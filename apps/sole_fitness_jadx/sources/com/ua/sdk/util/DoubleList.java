package com.ua.sdk.util;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class DoubleList implements Parcelable {
    static final int MIN_CAPACITY_INCREMENT = 12;
    double[] array;
    int size;
    static final double[] EMPTY = new double[0];
    public static final Parcelable.Creator<DoubleList> CREATOR = new Parcelable.Creator<DoubleList>() { // from class: com.ua.sdk.util.DoubleList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DoubleList createFromParcel(Parcel parcel) {
            return new DoubleList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DoubleList[] newArray(int i) {
            return new DoubleList[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DoubleList() {
        this.array = EMPTY;
        this.size = 0;
    }

    public DoubleList(int i) {
        this.array = new double[i];
        this.size = 0;
    }

    public DoubleList(double[] dArr) {
        if (dArr != null) {
            this.array = dArr;
            this.size = dArr.length;
        } else {
            this.array = EMPTY;
            this.size = 0;
        }
    }

    public double set(int i, double d) {
        if (i < 0 || i > this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        double[] dArr = this.array;
        double d2 = dArr[i];
        dArr[i] = d;
        return d2;
    }

    public double get(int i) {
        if (i < 0 || i > this.size) {
            throwIndexOutOfBoundsException(i, this.size);
        }
        return this.array[i];
    }

    public int getSize() {
        return this.size;
    }

    public void add(double d) {
        int i = this.size;
        double[] dArr = this.array;
        if (i == dArr.length) {
            int length = dArr.length;
            double[] dArr2 = new double[length < 12 ? length + 12 : length * 2];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    public void clear() {
        this.size = 0;
    }

    public double[] toArray() {
        int i = this.size;
        double[] dArr = new double[i];
        System.arraycopy(this.array, 0, dArr, 0, i);
        return dArr;
    }

    static IndexOutOfBoundsException throwIndexOutOfBoundsException(int i, int i2) {
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDoubleArray(this.array);
        parcel.writeInt(this.size);
    }

    private DoubleList(Parcel parcel) {
        this.array = parcel.createDoubleArray();
        this.size = parcel.readInt();
    }
}
