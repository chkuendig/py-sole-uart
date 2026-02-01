package com.ua.sdk.group.invite;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GroupInviteList extends AbstractEntityList<GroupInvite> {
    public static Parcelable.Creator<GroupInviteList> CREATOR = new Parcelable.Creator<GroupInviteList>() { // from class: com.ua.sdk.group.invite.GroupInviteList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInviteList createFromParcel(Parcel parcel) {
            return new GroupInviteList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInviteList[] newArray(int i) {
            return new GroupInviteList[i];
        }
    };
    private static final String LIST_KEY = "group_invites";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public GroupInviteList() {
    }

    private GroupInviteList(Parcel parcel) {
        super(parcel);
    }
}
