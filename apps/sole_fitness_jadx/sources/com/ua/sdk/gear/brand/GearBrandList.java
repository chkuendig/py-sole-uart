package com.ua.sdk.gear.brand;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GearBrandList extends AbstractEntityList<GearBrand> {
    public static final Parcelable.Creator<GearBrandList> CREATOR = new Parcelable.Creator<GearBrandList>() { // from class: com.ua.sdk.gear.brand.GearBrandList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearBrandList createFromParcel(Parcel parcel) {
            return new GearBrandList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearBrandList[] newArray(int i) {
            return new GearBrandList[i];
        }
    };

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "gearbrand";
    }

    public GearBrandList() {
    }

    @Override // com.ua.sdk.internal.AbstractEntityList, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private GearBrandList(Parcel parcel) {
        super(parcel);
    }
}
