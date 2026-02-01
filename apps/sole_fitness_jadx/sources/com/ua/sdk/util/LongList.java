package com.ua.sdk.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class LongList implements Parcelable {
    static final int MIN_CAPACITY_INCREMENT = 12;
    long[] array;
    int size;
    static final long[] EMPTY = new long[0];
    public static final Parcelable.Creator<LongList> CREATOR = new Parcelable.Creator<LongList>() { // from class: com.ua.sdk.util.LongList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LongList createFromParcel(Parcel parcel) {
            return new LongList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LongList[] newArray(int i) {
            return new LongList[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LongList() {
        this.array = EMPTY;
        this.size = 0;
    }

    public LongList(int i) {
        this.array = new long[i];
        this.size = 0;
    }

    public LongList(long[] jArr) {
        if (jArr != null) {
            this.array = jArr;
            this.size = jArr.length;
        } else {
            this.array = EMPTY;
            this.size = 0;
        }
    }

    public long set(int i, long j) {
        if (i < 0 || i > this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        long[] jArr = this.array;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    public long get(int i) {
        if (i < 0 || i > this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        return this.array[i];
    }

    public int getSize() {
        return this.size;
    }

    public void add(long j) {
        int i = this.size;
        long[] jArr = this.array;
        if (i == jArr.length) {
            int length = jArr.length;
            long[] jArr2 = new long[length < 12 ? length + 12 : length * 2];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    public void clear() {
        this.size = 0;
    }

    public long[] toArray() {
        int i = this.size;
        long[] jArr = new long[i];
        System.arraycopy(this.array, 0, jArr, 0, i);
        return jArr;
    }

    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int i, int i2) {
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLongArray(this.array);
        parcel.writeInt(this.size);
    }

    private LongList(Parcel parcel) {
        this.array = parcel.createLongArray();
        this.size = parcel.readInt();
    }
}
