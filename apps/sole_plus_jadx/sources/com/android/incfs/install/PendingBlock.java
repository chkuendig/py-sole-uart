package com.android.incfs.install;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class PendingBlock {
    private final StreamingApk mApk;
    private final int mBlockCount;
    private final int mBlockIndex;
    private final int mBlockOffset;
    private final short mBlockSize;
    private final Path mFilePath;
    private final Type mType;

    public enum Compression {
        NONE,
        LZ4
    }

    public enum Type {
        APK_DATA,
        SIGNATURE_TREE
    }

    PendingBlock(Path filePath, Type type, int blockIndex, int blockCount, StreamingApk apk, int blockOffset, short blockSize) {
        this.mFilePath = filePath;
        this.mType = type;
        this.mBlockIndex = blockIndex;
        this.mBlockCount = blockCount;
        this.mApk = apk;
        this.mBlockOffset = blockOffset;
        this.mBlockSize = blockSize;
    }

    public PendingBlock(PendingBlock block) {
        this.mFilePath = block.mFilePath;
        this.mType = block.mType;
        this.mBlockIndex = block.mBlockIndex;
        this.mBlockCount = block.mBlockCount;
        this.mApk = block.mApk;
        this.mBlockOffset = block.mBlockOffset;
        this.mBlockSize = block.mBlockSize;
    }

    public Path getPath() {
        return this.mFilePath;
    }

    public Type getType() {
        return this.mType;
    }

    public Compression getCompression() {
        return Compression.NONE;
    }

    public int getBlockIndex() {
        return this.mBlockIndex;
    }

    public int getFileBlockCount() {
        return this.mBlockCount;
    }

    public short getBlockSize() {
        return this.mBlockSize;
    }

    public void readBlockData(ByteBuffer buffer) throws IOException {
        this.mApk.readBlockData(buffer, this.mType, this.mBlockOffset, this.mBlockSize);
    }

    public String toString() {
        return "PendingBlock{mFilePath=" + this.mFilePath + ", mType=" + this.mType + ", mBlockIndex=" + this.mBlockIndex + ", mBlockCount=" + this.mBlockCount + ", mBlockOffset=" + this.mBlockOffset + ", mBlockSize=" + ((int) this.mBlockSize) + AbstractJsonLexerKt.END_OBJ;
    }
}
