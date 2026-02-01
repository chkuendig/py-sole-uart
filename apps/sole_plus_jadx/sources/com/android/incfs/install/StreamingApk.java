package com.android.incfs.install;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.incfs.install.PendingBlock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
class StreamingApk implements AutoCloseable {
    static final short INCFS_BLOCK_SIZE = 4096;
    private static final int INCFS_DIGEST_SIZE = 32;
    private static final int INCFS_HASHES_PER_BLOCK = 128;
    private static final int INCFS_MAX_SIGNATURE_SIZE = 8096;
    private final Path mApk;
    private final FileChannel mApkChannel;
    private final long mApkSize;
    private final IBlockFilter mBlockFilter;
    private final int mDataBlockCount;
    private final ILogger mLogger;
    private final BitSet mSentDataBlocks;
    private final BitSet mSentTreeBlocks;
    private final Path mSignature;
    private final String mSignatureBase64;
    private final FileChannel mSignatureChannel;
    private final long mSignatureSize;
    private final int mTreeBlockCount;
    private final int mTreeOffset;

    private StreamingApk(Path apk, Path signature, FileChannel apkChannel, FileChannel signatureChannel, long apkSize, long sigSize, int treeOffset, String signatureBase64, IBlockFilter server, ILogger logger) {
        this.mApk = apk;
        this.mSignature = signature;
        this.mApkChannel = apkChannel;
        this.mSignatureChannel = signatureChannel;
        this.mApkSize = apkSize;
        this.mSignatureSize = sigSize;
        int iNumBytesToNumBlocks = numBytesToNumBlocks(apkSize);
        this.mDataBlockCount = iNumBytesToNumBlocks;
        int iVerityTreeBlocksForFile = verityTreeBlocksForFile(apkSize);
        this.mTreeBlockCount = iVerityTreeBlocksForFile;
        this.mSentDataBlocks = new BitSet(iNumBytesToNumBlocks);
        this.mSentTreeBlocks = new BitSet(iVerityTreeBlocksForFile);
        this.mTreeOffset = treeOffset;
        this.mSignatureBase64 = signatureBase64;
        this.mBlockFilter = server;
        this.mLogger = logger;
    }

    static StreamingApk generate(Path apk, Path sig, IBlockFilter server, ILogger logger) throws IOException {
        FileChannel fileChannelOpen;
        FileChannel fileChannelOpen2;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(sig, new OpenOption[0]));
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStreamWrap = Base64.getEncoder().wrap(byteArrayOutputStream);
            readInt32(bufferedInputStream, outputStreamWrap, "Failed to read version from " + sig);
            int bytesWithSize = readBytesWithSize(bufferedInputStream, outputStreamWrap, "Failed to read hashing info from " + sig) + 12 + readBytesWithSize(bufferedInputStream, outputStreamWrap, "Failed to read signing info from " + sig);
            if (bytesWithSize > INCFS_MAX_SIGNATURE_SIZE) {
                throw new IllegalArgumentException("Signature is too long. Max allowed is 8096");
            }
            FileChannel fileChannel = null;
            int int32 = readInt32(bufferedInputStream, null, "Failed to read tree size from " + sig);
            int iVerityTreeSizeForFile = verityTreeSizeForFile(Files.size(apk));
            if (int32 != iVerityTreeSizeForFile) {
                throw new IllegalArgumentException("Verity tree size mismatch in signature file: [was " + int32 + ", expected " + iVerityTreeSizeForFile + "]");
            }
            int i = bytesWithSize + 4;
            String str = new String(byteArrayOutputStream.toByteArray());
            bufferedInputStream.close();
            try {
                fileChannelOpen2 = FileChannel.open(apk, new OpenOption[0]);
                try {
                    fileChannelOpen = FileChannel.open(sig, new OpenOption[0]);
                } catch (IOException e) {
                    e = e;
                    fileChannelOpen = null;
                }
            } catch (IOException e2) {
                e = e2;
                fileChannelOpen = null;
            }
            try {
                return new StreamingApk(apk, sig, fileChannelOpen2, fileChannelOpen, fileChannelOpen2.size(), fileChannelOpen.size(), i, str, server, logger);
            } catch (IOException e3) {
                e = e3;
                fileChannel = fileChannelOpen2;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (fileChannelOpen != null) {
                    fileChannelOpen.close();
                }
                throw e;
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    String getSignatureBase64() {
        return this.mSignatureBase64;
    }

    List<PendingBlock> getBlockResponse(int blockIndex) {
        if (blockIndex < 0 || blockIndex >= this.mDataBlockCount) {
            throw new IllegalArgumentException("Requested block index is outside range");
        }
        final List<PendingBlock> treeBlocksResponsesForDataBlock = getTreeBlocksResponsesForDataBlock(blockIndex);
        if (!this.mSentDataBlocks.get(blockIndex)) {
            Optional<PendingBlock> dataPendingBlock = getDataPendingBlock(blockIndex);
            Objects.requireNonNull(treeBlocksResponsesForDataBlock);
            dataPendingBlock.ifPresent(new Consumer() { // from class: com.android.incfs.install.StreamingApk$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    treeBlocksResponsesForDataBlock.add((PendingBlock) obj);
                }
            });
        }
        return treeBlocksResponsesForDataBlock;
    }

    private List<PendingBlock> getTreeBlocksResponsesForDataBlock(int blockIndex) {
        int i = this.mTreeBlockCount - ((this.mDataBlockCount + 127) / 128);
        int i2 = (blockIndex / 128) + i;
        final ArrayList arrayList = new ArrayList();
        if (!this.mSentTreeBlocks.get(i2)) {
            Optional<PendingBlock> treePendingBlock = getTreePendingBlock(i2);
            Objects.requireNonNull(arrayList);
            treePendingBlock.ifPresent(new Consumer() { // from class: com.android.incfs.install.StreamingApk$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    arrayList.add((PendingBlock) obj);
                }
            });
        }
        if (i != 0) {
            for (int i3 = 0; i3 < i; i3++) {
                if (!this.mSentTreeBlocks.get(i3)) {
                    Optional<PendingBlock> treePendingBlock2 = getTreePendingBlock(i3);
                    Objects.requireNonNull(arrayList);
                    treePendingBlock2.ifPresent(new Consumer() { // from class: com.android.incfs.install.StreamingApk$$ExternalSyntheticLambda1
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            arrayList.add((PendingBlock) obj);
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    private Optional<PendingBlock> getTreePendingBlock(int treeBlockIndex) {
        PendingBlock pendingBlock = new PendingBlock(this.mSignature, PendingBlock.Type.SIGNATURE_TREE, treeBlockIndex, this.mTreeBlockCount, this, this.mTreeOffset + (treeBlockIndex * 4096), (short) Math.min(this.mSignatureSize - r8, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        if (this.mBlockFilter.shouldServeBlock(pendingBlock)) {
            this.mLogger.verbose("Sending %s", pendingBlock);
            this.mSentTreeBlocks.set(treeBlockIndex, true);
            return Optional.of(pendingBlock);
        }
        this.mLogger.verbose("Denied sending %s", pendingBlock);
        return Optional.empty();
    }

    private Optional<PendingBlock> getDataPendingBlock(int index) {
        PendingBlock pendingBlock = new PendingBlock(this.mApk, PendingBlock.Type.APK_DATA, index, this.mDataBlockCount, this, index * 4096, (short) Math.min(this.mApkSize - r6, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        if (this.mBlockFilter.shouldServeBlock(pendingBlock)) {
            this.mLogger.verbose("Sending %s", pendingBlock);
            this.mSentDataBlocks.set(index, true);
            return Optional.of(pendingBlock);
        }
        this.mLogger.verbose("Denied sending %s", pendingBlock);
        return Optional.empty();
    }

    void readBlockData(ByteBuffer buffer, PendingBlock.Type type, int blockOffset, short blockSize) throws IOException {
        FileChannel fileChannel = type == PendingBlock.Type.APK_DATA ? this.mApkChannel : this.mSignatureChannel;
        int iLimit = buffer.limit();
        buffer.limit(buffer.position() + blockSize);
        try {
            if (((short) fileChannel.read(buffer, blockOffset)) != blockSize) {
                throw new IOException("Failed to read " + ((int) blockSize) + " bytes from " + (type == PendingBlock.Type.APK_DATA ? this.mApk : this.mSignature));
            }
        } finally {
            buffer.limit(iLimit);
        }
    }

    private static int numBytesToNumBlocks(long fileSize) {
        return ((int) (fileSize / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) + (fileSize % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM == 0 ? 0 : 1);
    }

    private static int verityTreeSizeForFile(long fileSize) {
        return verityTreeBlocksForFile(fileSize) * 4096;
    }

    private static int verityTreeBlocksForFile(long fileSize) {
        int i = 0;
        if (fileSize == 0) {
            return 0;
        }
        long j = ((fileSize - 1) / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) + 1;
        while (j > 1) {
            j = (j + 127) / 128;
            i = (int) (i + j);
        }
        return i;
    }

    private static int readInt32(InputStream is, OutputStream accumulator, String errorMessage) throws IOException {
        byte[] bArr = new byte[4];
        if (is.read(bArr) != 4) {
            throw new IOException(errorMessage);
        }
        if (accumulator != null) {
            accumulator.write(bArr);
        }
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    private static int readBytesWithSize(InputStream is, OutputStream accumulator, String errorMessage) throws IOException {
        int int32 = readInt32(is, accumulator, errorMessage);
        byte[] bArr = new byte[4096];
        int i = 0;
        while (i < int32) {
            int i2 = is.read(bArr, 0, int32 - i);
            if (i2 <= 0) {
                break;
            }
            accumulator.write(bArr, 0, i2);
            i += i2;
        }
        if (i == int32) {
            return int32;
        }
        throw new IOException(errorMessage);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            this.mApkChannel.close();
        } catch (IOException unused) {
        }
        try {
            this.mSignatureChannel.close();
        } catch (IOException unused2) {
        }
    }
}
