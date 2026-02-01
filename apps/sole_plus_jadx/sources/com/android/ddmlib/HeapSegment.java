package com.android.ddmlib;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;

/* loaded from: classes3.dex */
public final class HeapSegment implements Comparable<HeapSegment> {
    private static final long INVALID_START_ADDRESS = -1;
    protected int mAllocationUnitCount;
    protected int mAllocationUnitSize;
    protected int mHeapId;
    protected int mOffset;
    protected long mStartAddress;
    protected ByteBuffer mUsageData;

    public static class HeapSegmentElement implements Comparable<HeapSegmentElement> {
        public static final int KIND_ARRAY_1 = 2;
        public static final int KIND_ARRAY_2 = 3;
        public static final int KIND_ARRAY_4 = 4;
        public static final int KIND_ARRAY_8 = 5;
        public static final int KIND_CLASS_OBJECT = 1;
        public static final int KIND_INVALID = -1;
        public static final int KIND_NATIVE = 7;
        public static final int KIND_OBJECT = 0;
        public static final int KIND_UNKNOWN = 6;
        private static final int PARTIAL_MASK = 128;
        public static final int SOLIDITY_FINALIZABLE = 5;
        public static final int SOLIDITY_FREE = 0;
        public static final int SOLIDITY_HARD = 1;
        public static final int SOLIDITY_INVALID = -1;
        public static final int SOLIDITY_PHANTOM = 4;
        public static final int SOLIDITY_SOFT = 2;
        public static final int SOLIDITY_SWEEP = 6;
        public static final int SOLIDITY_WEAK = 3;
        private int mKind;
        private int mLength;
        private int mSolidity;

        public HeapSegmentElement() {
            setSolidity(-1);
            setKind(-1);
            setLength(-1);
        }

        public HeapSegmentElement(HeapSegment hs) throws ParseException, BufferUnderflowException {
            set(hs);
        }

        public HeapSegmentElement set(HeapSegment hs) throws ParseException, BufferUnderflowException {
            ByteBuffer byteBuffer = hs.mUsageData;
            int i = byteBuffer.get() & 255;
            int i2 = (byteBuffer.get() & 255) + 1;
            while ((i & 128) != 0) {
                byte b = byteBuffer.get();
                int i3 = b & 255;
                if ((b & 127) != (i & (-129))) {
                    throw new ParseException("State mismatch", byteBuffer.position());
                }
                i2 += (byteBuffer.get() & 255) + 1;
                i = i3;
            }
            setSolidity(i & 7);
            setKind((i >> 3) & 7);
            setLength(i2 * hs.mAllocationUnitSize);
            return this;
        }

        public int getSolidity() {
            return this.mSolidity;
        }

        public void setSolidity(int solidity) {
            this.mSolidity = solidity;
        }

        public int getKind() {
            return this.mKind;
        }

        public void setKind(int kind) {
            this.mKind = kind;
        }

        public int getLength() {
            return this.mLength;
        }

        public void setLength(int length) {
            this.mLength = length;
        }

        @Override // java.lang.Comparable
        public int compareTo(HeapSegmentElement other) {
            int i = this.mLength;
            int i2 = other.mLength;
            if (i != i2) {
                return i < i2 ? -1 : 1;
            }
            return 0;
        }
    }

    public HeapSegment(ByteBuffer hpsgData) throws BufferUnderflowException {
        hpsgData.order(ByteOrder.BIG_ENDIAN);
        this.mHeapId = hpsgData.getInt();
        this.mAllocationUnitSize = hpsgData.get();
        this.mStartAddress = hpsgData.getInt() & 4294967295L;
        this.mOffset = hpsgData.getInt();
        this.mAllocationUnitCount = hpsgData.getInt();
        ByteBuffer byteBufferSlice = hpsgData.slice();
        this.mUsageData = byteBufferSlice;
        byteBufferSlice.order(ByteOrder.BIG_ENDIAN);
    }

    public boolean isValid() {
        return this.mStartAddress != -1;
    }

    public boolean canAppend(HeapSegment other) {
        return isValid() && other.isValid() && this.mHeapId == other.mHeapId && this.mAllocationUnitSize == other.mAllocationUnitSize && getEndAddress() == other.getStartAddress();
    }

    public boolean append(HeapSegment other) {
        if (!canAppend(other)) {
            return false;
        }
        int iPosition = this.mUsageData.position();
        if (this.mUsageData.capacity() - this.mUsageData.limit() < other.mUsageData.limit()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.mUsageData.limit() + other.mUsageData.limit()) * 2);
            this.mUsageData.rewind();
            byteBufferAllocate.put(this.mUsageData);
            this.mUsageData = byteBufferAllocate;
        }
        other.mUsageData.rewind();
        this.mUsageData.put(other.mUsageData);
        this.mUsageData.position(iPosition);
        this.mAllocationUnitCount += other.mAllocationUnitCount;
        other.mStartAddress = -1L;
        other.mUsageData = null;
        return true;
    }

    public long getStartAddress() {
        return this.mStartAddress + this.mOffset;
    }

    public int getLength() {
        return this.mAllocationUnitSize * this.mAllocationUnitCount;
    }

    public long getEndAddress() {
        return getStartAddress() + getLength();
    }

    public void rewindElements() {
        ByteBuffer byteBuffer = this.mUsageData;
        if (byteBuffer != null) {
            byteBuffer.rewind();
        }
    }

    public HeapSegmentElement getNextElement(HeapSegmentElement reuse) {
        try {
            if (reuse != null) {
                return reuse.set(this);
            }
            return new HeapSegmentElement(this);
        } catch (BufferUnderflowException | ParseException unused) {
            return null;
        }
    }

    public boolean equals(Object o) {
        return (o instanceof HeapSegment) && compareTo((HeapSegment) o) == 0;
    }

    public int hashCode() {
        return (this.mHeapId * 31) + (this.mAllocationUnitSize * 31) + (((int) this.mStartAddress) * 31) + (this.mOffset * 31) + (this.mAllocationUnitCount * 31) + this.mUsageData.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeapSegment { heap ");
        sb.append(this.mHeapId).append(", start 0x").append(Integer.toHexString((int) getStartAddress())).append(", length ").append(getLength()).append(" }");
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(HeapSegment other) {
        int i = this.mHeapId;
        int i2 = other.mHeapId;
        if (i != i2) {
            return i < i2 ? -1 : 1;
        }
        if (getStartAddress() != other.getStartAddress()) {
            return getStartAddress() < other.getStartAddress() ? -1 : 1;
        }
        int i3 = this.mAllocationUnitSize;
        int i4 = other.mAllocationUnitSize;
        if (i3 != i4) {
            return i3 < i4 ? -1 : 1;
        }
        long j = this.mStartAddress;
        long j2 = other.mStartAddress;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        int i5 = this.mOffset;
        int i6 = other.mOffset;
        if (i5 != i6) {
            return i5 < i6 ? -1 : 1;
        }
        int i7 = this.mAllocationUnitCount;
        int i8 = other.mAllocationUnitCount;
        if (i7 != i8) {
            return i7 < i8 ? -1 : 1;
        }
        ByteBuffer byteBuffer = this.mUsageData;
        ByteBuffer byteBuffer2 = other.mUsageData;
        if (byteBuffer != byteBuffer2) {
            return byteBuffer.compareTo(byteBuffer2);
        }
        return 0;
    }
}
