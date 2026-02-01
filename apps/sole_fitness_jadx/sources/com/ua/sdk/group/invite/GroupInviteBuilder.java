package com.ua.sdk.group.invite;

import com.ua.sdk.EntityRef;
import com.ua.sdk.group.Group;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupInviteBuilder {
    String email;
    List<GroupInvite> groupInvites;
    EntityRef<Group> groupRef;
    EntityRef<User> userRef;

    public GroupInviteBuilder setGroup(EntityRef<Group> entityRef) {
        this.groupRef = entityRef;
        return this;
    }

    public GroupInviteBuilder setUser(EntityRef<User> entityRef) {
        this.userRef = entityRef;
        return this;
    }

    public GroupInviteBuilder setEmail(String str) {
        this.email = str;
        return this;
    }

    public GroupInviteBuilder addGroupInvite(EntityRef<User> entityRef, EntityRef<Group> entityRef2) {
        return addGroupInvite(new GroupInviteBuilder().setUser(entityRef).setGroup(entityRef2).build());
    }

    public GroupInviteBuilder addGroupInvite(String str, EntityRef<Group> entityRef) {
        return addGroupInvite(new GroupInviteBuilder().setEmail(str).setGroup(entityRef).build());
    }

    public GroupInvite build() throws NullPointerException {
        List<GroupInvite> list = this.groupInvites;
        if (list != null && !list.isEmpty()) {
            GroupInviteBatch groupInviteBatch = new GroupInviteBatch();
            groupInviteBatch.setGroupInvites(this.groupInvites);
            return groupInviteBatch;
        }
        Precondition.isNotNull(this.groupRef);
        if (this.email == null) {
            Precondition.isNotNull(this.userRef);
        }
        if (this.userRef == null) {
            Precondition.isNotNull(this.email);
        }
        GroupInviteImpl groupInviteImpl = new GroupInviteImpl();
        groupInviteImpl.setUserRef(this.userRef);
        groupInviteImpl.setGroupRef(this.groupRef);
        groupInviteImpl.setEmail(this.email);
        return groupInviteImpl;
    }

    private GroupInviteBuilder addGroupInvite(GroupInvite groupInvite) {
        if (this.groupInvites == null) {
            this.groupInvites = new ArrayList();
        }
        this.groupInvites.add(groupInvite);
        return this;
    }
}
