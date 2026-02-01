package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* loaded from: classes5.dex */
public class NotFilter extends HealthDataResolver.Filter {
    public NotFilter(HealthDataResolver.Filter filter) {
        HealthDataResolver.Filter.checkFilter(filter);
        this.mType = HealthDataResolver.Filter.ParcelType.NOT;
        this.mFilters.add(filter);
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mFilters = parcel.createTypedArrayList(HealthDataResolver.Filter.CREATOR);
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.mFilters);
    }

    public NotFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
