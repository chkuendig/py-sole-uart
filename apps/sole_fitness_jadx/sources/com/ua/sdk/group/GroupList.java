package com.ua.sdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GroupList extends AbstractEntityList<Group> implements Parcelable {
    public static final Parcelable.Creator<GroupList> CREATOR = new Parcelable.Creator<GroupList>() { // from class: com.ua.sdk.group.GroupList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupList createFromParcel(Parcel parcel) {
            return new GroupList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupList[] newArray(int i) {
            return new GroupList[i];
        }
    };

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "groups";
    }

    public GroupList() {
    }

    @Override // com.ua.sdk.internal.AbstractEntityList, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private GroupList(Parcel parcel) {
        super(parcel);
    }
}
