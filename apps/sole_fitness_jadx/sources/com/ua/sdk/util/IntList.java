package com.ua.sdk.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class IntList implements Parcelable {
    static final int MIN_CAPACITY_INCREMENT = 12;
    int[] array;
    int size;
    static final int[] EMPTY = new int[0];
    public static final Parcelable.Creator<IntList> CREATOR = new Parcelable.Creator<IntList>() { // from class: com.ua.sdk.util.IntList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntList createFromParcel(Parcel parcel) {
            return new IntList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntList[] newArray(int i) {
            return new IntList[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IntList() {
        this.array = EMPTY;
        this.size = 0;
    }

    public IntList(int i) {
        this.array = new int[i];
        this.size = 0;
    }

    public IntList(int[] iArr) {
        if (iArr != null) {
            this.array = iArr;
            this.size = iArr.length;
        } else {
            this.array = EMPTY;
            this.size = 0;
        }
    }

    public int set(int i, int i2) {
        if (i < 0 || i > this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        int[] iArr = this.array;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    public int get(int i) {
        if (i < 0 || i > this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        return this.array[i];
    }

    public int getSize() {
        return this.size;
    }

    public void add(int i) {
        int i2 = this.size;
        int[] iArr = this.array;
        if (i2 == iArr.length) {
            int length = iArr.length;
            int[] iArr2 = new int[length < 12 ? length + 12 : length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public void clear() {
        this.size = 0;
    }

    public int[] toArray() {
        int i = this.size;
        int[] iArr = new int[i];
        System.arraycopy(this.array, 0, iArr, 0, i);
        return iArr;
    }

    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int i, int i2) {
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.array);
        parcel.writeInt(this.size);
    }

    private IntList(Parcel parcel) {
        this.array = parcel.createIntArray();
        this.size = parcel.readInt();
    }
}
