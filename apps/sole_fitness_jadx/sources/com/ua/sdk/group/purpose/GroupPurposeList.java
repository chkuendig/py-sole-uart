package com.ua.sdk.group.purpose;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GroupPurposeList extends AbstractEntityList<GroupPurpose> {
    public static Parcelable.Creator<GroupPurposeList> CREATOR = new Parcelable.Creator<GroupPurposeList>() { // from class: com.ua.sdk.group.purpose.GroupPurposeList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupPurposeList createFromParcel(Parcel parcel) {
            return new GroupPurposeList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupPurposeList[] newArray(int i) {
            return new GroupPurposeList[i];
        }
    };
    private static final String LIST_KEY = "group_purposes";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public GroupPurposeList() {
    }

    private GroupPurposeList(Parcel parcel) {
        super(parcel);
    }
}
