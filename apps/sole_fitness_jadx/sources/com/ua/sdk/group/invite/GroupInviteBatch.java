package com.ua.sdk.group.invite;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupInviteBatch extends GroupInviteImpl {

    @SerializedName("group_invites")
    List<GroupInvite> groupInvites;

    public void setGroupInvites(List<GroupInvite> list) {
        if (this.groupInvites == null) {
            this.groupInvites = new ArrayList();
        }
        this.groupInvites.clear();
        this.groupInvites.addAll(list);
    }
}
