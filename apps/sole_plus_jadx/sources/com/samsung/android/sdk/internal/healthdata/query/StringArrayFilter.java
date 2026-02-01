package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* loaded from: classes5.dex */
public class StringArrayFilter extends HealthDataResolver.Filter {
    private String a;
    private String[] b;

    public StringArrayFilter(String str, String[] strArr) {
        this.mType = HealthDataResolver.Filter.ParcelType.STRING_ARRAY;
        this.a = str;
        this.b = strArr;
    }

    public String getField() {
        return this.a;
    }

    public String[] getList() {
        return this.b;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.a = parcel.readString();
        this.b = parcel.createStringArray();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeStringArray(this.b);
    }

    public StringArrayFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
