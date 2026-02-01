package com.android.utils;

/* loaded from: classes3.dex */
public class SparseArray<E> {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArray() {
        this(10);
    }

    public SparseArray(int initialCapacity) {
        this.mGarbage = false;
        int iIdealIntArraySize = ArrayUtils.idealIntArraySize(initialCapacity);
        this.mKeys = new int[iIdealIntArraySize];
        this.mValues = new Object[iIdealIntArraySize];
        this.mSize = 0;
    }

    public E get(int key) {
        return get(key, null);
    }

    public E get(int i, E e) {
        E e2;
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        return (iBinarySearch < 0 || (e2 = (E) this.mValues[iBinarySearch]) == DELETED) ? e : e2;
    }

    public void delete(int key) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[iBinarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[iBinarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void remove(int key) {
        delete(key);
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void put(int key, E value) {
        int iBinarySearch = binarySearch(this.mKeys, 0, this.mSize, key);
        if (iBinarySearch >= 0) {
            this.mValues[iBinarySearch] = value;
            return;
        }
        int i = ~iBinarySearch;
        int i2 = this.mSize;
        if (i < i2) {
            Object[] objArr = this.mValues;
            if (objArr[i] == DELETED) {
                this.mKeys[i] = key;
                objArr[i] = value;
                return;
            }
        }
        if (this.mGarbage && i2 >= this.mKeys.length) {
            gc();
            i = ~binarySearch(this.mKeys, 0, this.mSize, key);
        }
        int i3 = this.mSize;
        if (i3 >= this.mKeys.length) {
            int iIdealIntArraySize = ArrayUtils.idealIntArraySize(i3 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr2 = new Object[iIdealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i4 = this.mSize;
        if (i4 - i != 0) {
            int[] iArr3 = this.mKeys;
            int i5 = i + 1;
            System.arraycopy(iArr3, i, iArr3, i5, i4 - i);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i, objArr4, i5, this.mSize - i);
        }
        this.mKeys[i] = key;
        this.mValues[i] = value;
        this.mSize++;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public int keyAt(int index) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[index];
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i];
    }

    public void setValueAt(int index, E value) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[index] = value;
    }

    public int indexOfKey(int key) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, key);
    }

    public int indexOfValue(E value) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(int key, E value) {
        int i = this.mSize;
        if (i != 0 && key <= this.mKeys[i - 1]) {
            put(key, value);
            return;
        }
        if (this.mGarbage && i >= this.mKeys.length) {
            gc();
        }
        int i2 = this.mSize;
        if (i2 >= this.mKeys.length) {
            int iIdealIntArraySize = ArrayUtils.idealIntArraySize(i2 + 1);
            int[] iArr = new int[iIdealIntArraySize];
            Object[] objArr = new Object[iIdealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
            this.mValues = objArr;
        }
        this.mKeys[i2] = key;
        this.mValues[i2] = value;
        this.mSize = i2 + 1;
    }

    public SparseArray<E> getUnmodifiable() {
        return new SparseArray<E>() { // from class: com.android.utils.SparseArray.1
            @Override // com.android.utils.SparseArray
            public E get(int i) {
                return (E) this.get(i);
            }

            @Override // com.android.utils.SparseArray
            public E get(int i, E e) {
                return (E) this.get(i, e);
            }

            @Override // com.android.utils.SparseArray
            public void delete(int key) {
                throw new UnsupportedOperationException();
            }

            @Override // com.android.utils.SparseArray
            public void remove(int key) {
                throw new UnsupportedOperationException();
            }

            @Override // com.android.utils.SparseArray
            public void put(int key, E value) {
                throw new UnsupportedOperationException();
            }

            @Override // com.android.utils.SparseArray
            public int size() {
                return this.size();
            }

            @Override // com.android.utils.SparseArray
            public int keyAt(int index) {
                return this.keyAt(index);
            }

            @Override // com.android.utils.SparseArray
            public E valueAt(int i) {
                return (E) this.valueAt(i);
            }

            @Override // com.android.utils.SparseArray
            public void setValueAt(int index, E value) {
                throw new UnsupportedOperationException();
            }

            @Override // com.android.utils.SparseArray
            public int indexOfKey(int key) {
                return this.indexOfKey(key);
            }

            @Override // com.android.utils.SparseArray
            public int indexOfValue(E value) {
                return this.indexOfValue(value);
            }

            @Override // com.android.utils.SparseArray
            public void clear() {
                throw new UnsupportedOperationException();
            }

            @Override // com.android.utils.SparseArray
            public void append(int key, E value) {
                throw new UnsupportedOperationException();
            }
        };
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
