package com.ua.sdk.gear.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class UserGearList extends AbstractEntityList<UserGear> implements Parcelable {
    public static final Parcelable.Creator<UserGearList> CREATOR = new Parcelable.Creator<UserGearList>() { // from class: com.ua.sdk.gear.user.UserGearList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearList createFromParcel(Parcel parcel) {
            return new UserGearList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserGearList[] newArray(int i) {
            return new UserGearList[i];
        }
    };

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "usergear";
    }

    public UserGearList() {
    }

    @Override // com.ua.sdk.internal.AbstractEntityList, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private UserGearList(Parcel parcel) {
        super(parcel);
    }
}
