package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* loaded from: classes5.dex */
public class NumberArrayFilter extends HealthDataResolver.Filter {
    private String a;
    private Number[] b;

    public NumberArrayFilter(String str, Number[] numberArr) {
        this.mType = HealthDataResolver.Filter.ParcelType.NUMBER_ARRAY;
        this.a = str;
        this.b = numberArr;
    }

    public String getField() {
        return this.a;
    }

    public Number[] getList() {
        return this.b;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.a = parcel.readString();
        this.b = (Number[]) parcel.readSerializable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.Number[]] */
    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeSerializable(this.b);
    }

    public NumberArrayFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
