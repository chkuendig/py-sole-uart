package com.android.utils;

/* loaded from: classes3.dex */
public class SparseIntArray {
    private int[] mKeys;
    private int mSize;
    private int[] mValues;

    public SparseIntArray() {
        this(10);
    }

    public SparseIntArray(int initialCapacity) {
        int iIdealIntArraySize = ArrayUtils.idealIntArraySize(initialCapacity);
        this.mKeys = new int[iIdealIntArraySize];
        this.mValues = new int[iIdealIntArraySize];
        this.mSize = 0;
    }

    public int get(int key) {
        return get(key, 0);
    }

    public int get(int key, int valueIfKeyNotFound) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        return iBinarySearch < 0 ? valueIfKeyNotFound : this.mValues[iBinarySearch];
    }

    public void delete(int key) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            removeAt(iBinarySearch);
        }
    }

    public void removeAt(int index) {
        int[] iArr = this.mKeys;
        int i = index + 1;
        System.arraycopy(iArr, i, iArr, index, this.mSize - i);
        int[] iArr2 = this.mValues;
        System.arraycopy(iArr2, i, iArr2, index, this.mSize - i);
        this.mSize--;
    }

    public void put(int key, int value) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = value;
            return;
        }
        int i = ~iBinarySearch;
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int iIdealIntArraySize = ArrayUtils.idealIntArraySize(i2 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            int[] iArr2 = new int[iIdealIntArraySize];
            int[] iArr3 = this.mKeys;
            System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
            int[] iArr4 = this.mValues;
            System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
            this.mKeys = iArr;
            this.mValues = iArr2;
        }
        int i3 = this.mSize;
        if (i3 - i != 0) {
            int[] iArr5 = this.mKeys;
            int i4 = i + 1;
            System.arraycopy(iArr5, i, iArr5, i4, i3 - i);
            int[] iArr6 = this.mValues;
            System.arraycopy(iArr6, i, iArr6, i4, this.mSize - i);
        }
        this.mKeys[i] = key;
        this.mValues[i] = value;
        this.mSize++;
    }

    public int size() {
        return this.mSize;
    }

    public int keyAt(int index) {
        return this.mKeys[index];
    }

    public int valueAt(int index) {
        return this.mValues[index];
    }

    public int indexOfKey(int key) {
        return binarySearch(this.mKeys, 0, this.mSize, key);
    }

    public int indexOfValue(int value) {
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        this.mSize = 0;
    }

    public void append(int key, int value) {
        int i = this.mSize;
        if (i != 0 && key <= this.mKeys[i - 1]) {
            put(key, value);
            return;
        }
        if (i >= this.mKeys.length) {
            int iIdealIntArraySize = ArrayUtils.idealIntArraySize(i + 1);
            int[] iArr = new int[iIdealIntArraySize];
            int[] iArr2 = new int[iIdealIntArraySize];
            int[] iArr3 = this.mKeys;
            System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
            int[] iArr4 = this.mValues;
            System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
            this.mKeys = iArr;
            this.mValues = iArr2;
        }
        this.mKeys[i] = key;
        this.mValues[i] = value;
        this.mSize = i + 1;
    }

    private static int binarySearch(int[] a, int start, int len, int key) {
        int i = len + start;
        int i2 = start - 1;
        int i3 = i;
        while (i3 - i2 > 1) {
            int i4 = (i3 + i2) / 2;
            if (a[i4] < key) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        return i3 == i ? ~i : a[i3] == key ? i3 : ~i3;
    }
}
