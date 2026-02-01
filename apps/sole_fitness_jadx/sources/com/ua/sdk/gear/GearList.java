package com.ua.sdk.gear;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GearList extends AbstractEntityList<Gear> {
    public static final Parcelable.Creator<GearList> CREATOR = new Parcelable.Creator<GearList>() { // from class: com.ua.sdk.gear.GearList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearList createFromParcel(Parcel parcel) {
            return new GearList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearList[] newArray(int i) {
            return new GearList[i];
        }
    };
    private static final String LIST_KEY = "gear";

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public GearList() {
    }

    @Override // com.ua.sdk.internal.AbstractEntityList, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private GearList(Parcel parcel) {
        super(parcel);
    }
}
