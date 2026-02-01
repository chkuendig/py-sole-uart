package com.ua.sdk.heartrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class HeartRateZonesList extends AbstractEntityList<HeartRateZones> {
    public static Parcelable.Creator<HeartRateZonesList> CREATOR = new Parcelable.Creator<HeartRateZonesList>() { // from class: com.ua.sdk.heartrate.HeartRateZonesList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesList createFromParcel(Parcel parcel) {
            return new HeartRateZonesList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateZonesList[] newArray(int i) {
            return new HeartRateZonesList[i];
        }
    };
    private static final String LIST_KEY = "heart_rate_zones";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public HeartRateZonesList() {
    }

    private HeartRateZonesList(Parcel parcel) {
        super(parcel);
    }
}
