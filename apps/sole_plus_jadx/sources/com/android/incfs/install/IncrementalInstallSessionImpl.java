package com.android.incfs.install;

import com.android.incfs.install.PendingBlock;
import com.android.incfs.install.ReadRequest;
import com.google.common.base.Charsets;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* loaded from: classes3.dex */
class IncrementalInstallSessionImpl implements AutoCloseable {
    private static final int DONT_WAIT_TIME_MS = 0;
    private static final int FULL_REQUEST_SIZE = 12;
    private static final int REQUEST_SIZE = 8;
    private static final byte RESPONSE_CHUNK_HEADER_SIZE = 4;
    private static final int RESPONSE_HEADER_SIZE = 10;
    private static final int WAIT_TIME_MS = 10;
    private final List<StreamingApk> mApks;
    private volatile boolean mClosed;
    private final IDeviceConnection mConnection;
    private volatile boolean mInstallSucceeded;
    private final ILogger mLogger;
    private volatile Exception mPendingException;
    private final long mResponseTimeoutNs;
    private volatile boolean mStreamingCompleted;
    private final IBlockTransformer mTransformer;

    /* JADX INFO: Access modifiers changed from: private */
    enum ConditionResult {
        FULFILLED,
        UNFULFILLED,
        RESET_TIMEOUT
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface IOSupplier<T> {
        T get() throws InterruptedException, IOException;
    }

    IncrementalInstallSessionImpl(IDeviceConnection device, List<StreamingApk> apks, long responseTimeout, IBlockTransformer transformer, ILogger logger) {
        this.mConnection = device;
        this.mApks = apks;
        this.mResponseTimeoutNs = responseTimeout;
        this.mTransformer = transformer;
        this.mLogger = logger;
    }

    void waitForInstallCompleted(long timeout, TimeUnit timeOutUnits) throws InterruptedException, IOException {
        waitForCondition(timeOutUnits.toNanos(timeout), 10L, new IOSupplier() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda1
            @Override // com.android.incfs.install.IncrementalInstallSessionImpl.IOSupplier
            public final Object get() {
                return this.f$0.m7994x20e11386();
            }
        });
    }

    /* renamed from: lambda$waitForInstallCompleted$0$com-android-incfs-install-IncrementalInstallSessionImpl, reason: not valid java name */
    /* synthetic */ ConditionResult m7994x20e11386() throws InterruptedException, IOException {
        if (this.mPendingException != null) {
            throw new RuntimeException(this.mPendingException);
        }
        if (this.mInstallSucceeded || this.mClosed) {
            return ConditionResult.FULFILLED;
        }
        return ConditionResult.UNFULFILLED;
    }

    void waitForServingCompleted(long timeout, TimeUnit timeOutUnits) throws InterruptedException, IOException {
        waitForCondition(timeOutUnits.toNanos(timeout), 10L, new IOSupplier() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda0
            @Override // com.android.incfs.install.IncrementalInstallSessionImpl.IOSupplier
            public final Object get() {
                return this.f$0.m7995x2f00a076();
            }
        });
    }

    /* renamed from: lambda$waitForServingCompleted$1$com-android-incfs-install-IncrementalInstallSessionImpl, reason: not valid java name */
    /* synthetic */ ConditionResult m7995x2f00a076() throws InterruptedException, IOException {
        if (this.mPendingException != null) {
            throw new RuntimeException(this.mPendingException);
        }
        if (this.mStreamingCompleted || this.mClosed) {
            return ConditionResult.FULFILLED;
        }
        return ConditionResult.UNFULFILLED;
    }

    void waitForAnyCompletion(long timeout, TimeUnit timeOutUnits) throws InterruptedException, IOException {
        waitForCondition(timeOutUnits.toNanos(timeout), 10L, new IOSupplier() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda2
            @Override // com.android.incfs.install.IncrementalInstallSessionImpl.IOSupplier
            public final Object get() {
                return this.f$0.m7993x1d8ebdb2();
            }
        });
    }

    /* renamed from: lambda$waitForAnyCompletion$2$com-android-incfs-install-IncrementalInstallSessionImpl, reason: not valid java name */
    /* synthetic */ ConditionResult m7993x1d8ebdb2() throws InterruptedException, IOException {
        if (this.mPendingException != null) {
            throw new RuntimeException(this.mPendingException);
        }
        if (this.mInstallSucceeded || this.mStreamingCompleted || this.mClosed) {
            return ConditionResult.FULFILLED;
        }
        return ConditionResult.UNFULFILLED;
    }

    private void waitForCondition(long timeoutNs, long waitMs, IOSupplier<ConditionResult> condition) throws InterruptedException, IOException {
        long jNanoTime = System.nanoTime();
        while (true) {
            if (timeoutNs == 0 || jNanoTime + timeoutNs >= System.nanoTime()) {
                ConditionResult conditionResult = condition.get();
                if (conditionResult == ConditionResult.FULFILLED) {
                    return;
                }
                if (waitMs > 0) {
                    Thread.sleep(waitMs);
                }
                if (conditionResult == ConditionResult.RESET_TIMEOUT) {
                    jNanoTime = System.nanoTime();
                }
            } else {
                throw new IOException("timeout while waiting for condition");
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.mClosed) {
            return;
        }
        if (!this.mStreamingCompleted) {
            try {
                writeToDevice(buildCloseResponseChunk());
            } catch (Exception unused) {
            }
        }
        try {
            this.mConnection.close();
        } catch (Exception unused2) {
        }
        this.mApks.forEach(new Consumer() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((StreamingApk) obj).close();
            }
        });
        this.mClosed = true;
    }

    void execute(Executor executor) {
        executor.execute(new Runnable() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m7991xbd33169a();
            }
        });
    }

    /* renamed from: lambda$execute$3$com-android-incfs-install-IncrementalInstallSessionImpl, reason: not valid java name */
    /* synthetic */ void m7991xbd33169a() {
        try {
            writeToDevice(ByteBuffer.wrap("OKAY".getBytes(Charsets.UTF_8)));
            processDeviceData();
        } catch (Exception e) {
            this.mPendingException = e;
        }
    }

    private void processDeviceData() throws InterruptedException, IOException {
        final ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16384);
        byteBufferAllocate.flip();
        final MagicMatcher magicMatcher = new MagicMatcher(null);
        final StringBuilder sb = new StringBuilder();
        waitForCondition(this.mResponseTimeoutNs, 0L, new IOSupplier() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda5
            @Override // com.android.incfs.install.IncrementalInstallSessionImpl.IOSupplier
            public final Object get() {
                return this.f$0.m7992x3a3dfed5(byteBufferAllocate, magicMatcher, sb);
            }
        });
    }

    /* renamed from: lambda$processDeviceData$4$com-android-incfs-install-IncrementalInstallSessionImpl, reason: not valid java name */
    /* synthetic */ ConditionResult m7992x3a3dfed5(ByteBuffer byteBuffer, MagicMatcher magicMatcher, StringBuilder sb) throws InterruptedException, IOException {
        if (this.mClosed) {
            return ConditionResult.FULFILLED;
        }
        if (byteBuffer.remaining() < 12) {
            byteBuffer.compact();
            int i = this.mConnection.read(byteBuffer, 10L);
            byteBuffer.flip();
            if (i < 0) {
                throw new EOFException("EOF");
            }
        }
        MagicMatcher.MagicType magicTypeFindMagic = magicMatcher.findMagic(byteBuffer);
        if (magicTypeFindMagic == null) {
            return ConditionResult.UNFULFILLED;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$android$incfs$install$IncrementalInstallSessionImpl$MagicMatcher$MagicType[magicTypeFindMagic.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                while (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    if (b == 93) {
                        throw new IOException("Installation failure: " + sb.toString());
                    }
                    sb.append((char) b);
                }
            } else if (i2 == 3) {
                this.mInstallSucceeded = true;
                magicMatcher.advance();
            }
        } else if (byteBuffer.remaining() >= 8) {
            if (processReadData(nextRequest(byteBuffer))) {
                this.mStreamingCompleted = true;
            }
            magicMatcher.advance();
        }
        if (this.mStreamingCompleted && this.mInstallSucceeded) {
            return ConditionResult.FULFILLED;
        }
        return ConditionResult.RESET_TIMEOUT;
    }

    /* renamed from: com.android.incfs.install.IncrementalInstallSessionImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$incfs$install$IncrementalInstallSessionImpl$MagicMatcher$MagicType;
        static final /* synthetic */ int[] $SwitchMap$com$android$incfs$install$ReadRequest$RequestType;

        static {
            int[] iArr = new int[MagicMatcher.MagicType.values().length];
            $SwitchMap$com$android$incfs$install$IncrementalInstallSessionImpl$MagicMatcher$MagicType = iArr;
            try {
                iArr[MagicMatcher.MagicType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$incfs$install$IncrementalInstallSessionImpl$MagicMatcher$MagicType[MagicMatcher.MagicType.INSTALLATION_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$android$incfs$install$IncrementalInstallSessionImpl$MagicMatcher$MagicType[MagicMatcher.MagicType.INSTALLATION_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ReadRequest.RequestType.values().length];
            $SwitchMap$com$android$incfs$install$ReadRequest$RequestType = iArr2;
            try {
                iArr2[ReadRequest.RequestType.SERVING_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$android$incfs$install$ReadRequest$RequestType[ReadRequest.RequestType.BLOCK_MISSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$android$incfs$install$ReadRequest$RequestType[ReadRequest.RequestType.PREFETCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$android$incfs$install$ReadRequest$RequestType[ReadRequest.RequestType.DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static ReadRequest nextRequest(ByteBuffer data) {
        ReadRequest.RequestType requestType;
        short s = data.getShort();
        if (s == 0) {
            requestType = ReadRequest.RequestType.SERVING_COMPLETE;
        } else if (s == 1) {
            requestType = ReadRequest.RequestType.BLOCK_MISSING;
        } else if (s == 2) {
            requestType = ReadRequest.RequestType.PREFETCH;
        } else if (s == 3) {
            requestType = ReadRequest.RequestType.DESTROY;
        } else {
            throw new IllegalStateException("Unknown request type " + ((int) s));
        }
        return new ReadRequest(requestType, data.getShort(), data.getInt());
    }

    private boolean processReadData(ReadRequest request) throws InterruptedException, IOException {
        this.mLogger.verbose("Received %s", request.toString());
        int i = AnonymousClass1.$SwitchMap$com$android$incfs$install$ReadRequest$RequestType[request.requestType.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2 || i == 3) {
            writeToDevice(buildResponseChunk(request.apkId, this.mApks.get(request.apkId).getBlockResponse(request.blockIndex)));
            return false;
        }
        if (i != 4) {
            return false;
        }
        throw new IOException("Destroy request received");
    }

    private static ByteBuffer buildCloseResponseChunk() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(14);
        byteBufferAllocate.putInt(10);
        byteBufferAllocate.putShort((short) -1);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private ByteBuffer buildResponseChunk(short apkId, List<PendingBlock> blocks) throws IOException {
        if (blocks.isEmpty()) {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((blocks.size() * 4106) + 4);
        byteBufferAllocate.position(4);
        Iterator<PendingBlock> it = blocks.iterator();
        int blockSize = 0;
        while (it.hasNext()) {
            PendingBlock pendingBlockTransform = this.mTransformer.transform(it.next());
            byteBufferAllocate.putShort(apkId);
            byte b = 1;
            byteBufferAllocate.put(pendingBlockTransform.getType() == PendingBlock.Type.APK_DATA ? (byte) 0 : (byte) 1);
            if (pendingBlockTransform.getCompression() == PendingBlock.Compression.NONE) {
                b = 0;
            }
            byteBufferAllocate.put(b);
            byteBufferAllocate.putInt(pendingBlockTransform.getBlockIndex());
            byteBufferAllocate.putShort(pendingBlockTransform.getBlockSize());
            pendingBlockTransform.readBlockData(byteBufferAllocate);
            blockSize += pendingBlockTransform.getBlockSize() + 10;
        }
        byteBufferAllocate.putInt(0, blockSize);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private void writeToDevice(final ByteBuffer data) throws InterruptedException, IOException {
        waitForCondition(this.mResponseTimeoutNs, 0L, new IOSupplier() { // from class: com.android.incfs.install.IncrementalInstallSessionImpl$$ExternalSyntheticLambda6
            @Override // com.android.incfs.install.IncrementalInstallSessionImpl.IOSupplier
            public final Object get() {
                return this.f$0.m7996x7f24c8d7(data);
            }
        });
    }

    /* renamed from: lambda$writeToDevice$5$com-android-incfs-install-IncrementalInstallSessionImpl, reason: not valid java name */
    /* synthetic */ ConditionResult m7996x7f24c8d7(ByteBuffer byteBuffer) throws InterruptedException, IOException {
        if (!byteBuffer.hasRemaining()) {
            return ConditionResult.FULFILLED;
        }
        if (this.mConnection.write(byteBuffer, 10L) < 0) {
            throw new IOException("channel EOF");
        }
        return ConditionResult.UNFULFILLED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class MagicMatcher {
        private static final ArrayList<Magic> MAGICS;
        private MagicType mFoundMatch;
        private final int[] mPositions;

        private enum MagicType {
            INCREMENTAL,
            INSTALLATION_FAILURE,
            INSTALLATION_SUCCESS
        }

        private MagicMatcher() {
            this.mPositions = new int[MAGICS.size()];
            this.mFoundMatch = null;
        }

        /* synthetic */ MagicMatcher(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static class Magic {
            final MagicType type;
            final byte[] value;

            Magic(MagicType type, byte[] value) {
                this.type = type;
                this.value = value;
            }
        }

        static {
            ArrayList<Magic> arrayList = new ArrayList<>();
            MAGICS = arrayList;
            arrayList.add(new Magic(MagicType.INCREMENTAL, "INCR".getBytes(Charsets.UTF_8)));
            arrayList.add(new Magic(MagicType.INSTALLATION_FAILURE, "Failure [".getBytes(Charsets.UTF_8)));
            arrayList.add(new Magic(MagicType.INSTALLATION_SUCCESS, "Success".getBytes(Charsets.UTF_8)));
        }

        MagicType findMagic(ByteBuffer buffer) {
            MagicType magicType = this.mFoundMatch;
            if (magicType != null) {
                return magicType;
            }
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                for (int i = 0; i < this.mPositions.length; i++) {
                    ArrayList<Magic> arrayList = MAGICS;
                    byte[] bArr = arrayList.get(i).value;
                    int[] iArr = this.mPositions;
                    int i2 = iArr[i];
                    if (b == bArr[i2]) {
                        int i3 = i2 + 1;
                        iArr[i] = i3;
                        if (i3 == bArr.length) {
                            MagicType magicType2 = arrayList.get(i).type;
                            this.mFoundMatch = magicType2;
                            this.mPositions[i] = 0;
                            return magicType2;
                        }
                    } else if (b == bArr[0]) {
                        iArr[i] = 1;
                    } else {
                        iArr[i] = 0;
                    }
                }
            }
            return null;
        }

        void advance() {
            this.mFoundMatch = null;
        }
    }
}
