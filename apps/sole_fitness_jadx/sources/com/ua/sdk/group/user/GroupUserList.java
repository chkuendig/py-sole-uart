package com.ua.sdk.group.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GroupUserList extends AbstractEntityList<GroupUser> {
    public static Parcelable.Creator<GroupUserList> CREATOR = new Parcelable.Creator<GroupUserList>() { // from class: com.ua.sdk.group.user.GroupUserList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupUserList createFromParcel(Parcel parcel) {
            return new GroupUserList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupUserList[] newArray(int i) {
            return new GroupUserList[i];
        }
    };
    private static final String LIST_KEY = "group_users";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public GroupUserList() {
    }

    private GroupUserList(Parcel parcel) {
        super(parcel);
    }
}
