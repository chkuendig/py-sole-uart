package com.samsung.android.sdk.healthdata;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult;

/* loaded from: classes5.dex */
public interface HealthResultHolder<T extends BaseResult> {

    public interface ResultListener<T extends BaseResult> {
        void onResult(T t);
    }

    T await();

    void cancel();

    void setResultListener(ResultListener<T> resultListener);

    public static class BaseResult implements Parcelable {
        public static final Parcelable.Creator<BaseResult> CREATOR = new a();
        public static final int STATUS_CANCELED = 2;
        public static final int STATUS_FAILED = 4;
        public static final int STATUS_INVALID_INPUT_DATA = 8;
        public static final int STATUS_OUT_OF_SPACE = 16;
        public static final int STATUS_SUCCESSFUL = 1;
        public static final int STATUS_UNKNOWN = 0;
        final int a;
        final int b;
        final boolean c;

        static class a implements Parcelable.Creator<BaseResult> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public BaseResult createFromParcel(Parcel parcel) {
                return new BaseResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public BaseResult[] newArray(int i) {
                return new BaseResult[i];
            }
        }

        public BaseResult(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getCount() {
            return this.b;
        }

        public int getStatus() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        public BaseResult(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }

        protected BaseResult(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }
    }
}
