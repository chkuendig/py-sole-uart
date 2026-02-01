package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* loaded from: classes5.dex */
public class StringFilter extends HealthDataResolver.Filter {
    private String a;
    private String b;

    public StringFilter(String str, String str2) {
        this.mType = HealthDataResolver.Filter.ParcelType.STRING;
        this.a = str;
        this.b = str2;
    }

    public String getField() {
        return this.a;
    }

    public String getValue() {
        return this.b;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public StringFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
