package com.ua.sdk.group;

import com.ua.sdk.EntityRef;
import com.ua.sdk.group.objective.GroupObjective;
import com.ua.sdk.group.purpose.GroupPurpose;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class GroupBuilder {
    String description;
    GroupObjective groupObjective;
    EntityRef<GroupPurpose> groupPurposeRef;
    String invitationCode;
    Boolean invitationRequired;
    Boolean isPublic;
    String name;

    public GroupBuilder setIsPublic(Boolean bool) {
        this.isPublic = bool;
        return this;
    }

    public GroupBuilder setInvitationRequired(Boolean bool) {
        this.invitationRequired = bool;
        return this;
    }

    public GroupBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public GroupBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    public GroupBuilder setInvitationCode(String str) {
        this.invitationCode = str;
        return this;
    }

    public GroupBuilder setGroupObjective(GroupObjective groupObjective) {
        this.groupObjective = groupObjective;
        return this;
    }

    public GroupBuilder setGroupPurpose(GroupPurpose groupPurpose) throws NullPointerException {
        Precondition.isNotNull(groupPurpose);
        this.groupPurposeRef = groupPurpose.getRef();
        return this;
    }

    public Group build() throws NullPointerException {
        Precondition.isNotNull(this.name, "name");
        Precondition.isNotNull(this.groupObjective, "groupObjective");
        if (this.groupPurposeRef == null) {
            this.groupPurposeRef = new LinkEntityRef(UrlBuilderImpl.GET_GROUP_PURPOSE_CHALLENGE_URL);
        }
        GroupImpl groupImpl = new GroupImpl();
        groupImpl.setPublicGroup(this.isPublic);
        groupImpl.setInvitationRequired(this.invitationRequired);
        groupImpl.setName(this.name);
        groupImpl.setDescription(this.description);
        groupImpl.setInvitationCode(this.invitationCode);
        groupImpl.setGroupObjective(this.groupObjective);
        groupImpl.setGroupPurposeRef(this.groupPurposeRef);
        return groupImpl;
    }
}
