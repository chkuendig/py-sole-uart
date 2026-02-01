package com.ua.sdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitystory.ActivityStory;
import com.ua.sdk.group.invite.GroupInvite;
import com.ua.sdk.group.objective.GroupObjective;
import com.ua.sdk.group.purpose.GroupPurpose;
import com.ua.sdk.group.user.GroupUser;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GroupImpl extends ApiTransferObject implements Group, Parcelable {
    public static final Parcelable.Creator<GroupImpl> CREATOR = new Parcelable.Creator<GroupImpl>() { // from class: com.ua.sdk.group.GroupImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupImpl createFromParcel(Parcel parcel) {
            return new GroupImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupImpl[] newArray(int i) {
            return new GroupImpl[i];
        }
    };
    private static final String REF_SELF = "self";
    private transient EntityRef<ActivityStory> activityFeedRef;

    @SerializedName("description")
    private String description;
    private transient EntityRef<GroupInvite> groupInviteRef;

    @SerializedName("group_objective")
    private GroupObjective groupObjective;
    private transient EntityRef<User> groupOwnerRef;
    private transient EntityRef<GroupPurpose> groupPurposeRef;
    private transient EntityRef<GroupUser> groupUserRef;

    @SerializedName("invitation_code")
    private String invitationCode;

    @SerializedName("invitation_required")
    private Boolean invitationRequired;

    @SerializedName("max_users")
    private Integer maxUsers;
    private transient int memberCount;

    @SerializedName("name")
    private String name;

    @SerializedName("is_public")
    private Boolean publicGroup;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GroupImpl() {
    }

    @Override // com.ua.sdk.group.Group
    public Boolean getPublicGroup() {
        return this.publicGroup;
    }

    public void setPublicGroup(Boolean bool) {
        this.publicGroup = bool;
    }

    @Override // com.ua.sdk.group.Group
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Override // com.ua.sdk.group.Group
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    @Override // com.ua.sdk.group.Group
    public Boolean getInvitationRequired() {
        return this.invitationRequired;
    }

    public void setInvitationRequired(Boolean bool) {
        this.invitationRequired = bool;
    }

    @Override // com.ua.sdk.group.Group
    public String getInvitationCode() {
        return this.invitationCode;
    }

    public void setInvitationCode(String str) {
        this.invitationCode = str;
    }

    @Override // com.ua.sdk.group.Group
    public int getMemberCount() {
        Link link;
        if (this.memberCount == 0 && (link = getLink("users")) != null) {
            this.memberCount = link.getCount().intValue();
        }
        return this.memberCount;
    }

    @Override // com.ua.sdk.group.Group
    public int getMaxUsers() {
        Integer num = this.maxUsers;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setMaxUsers(int i) {
        this.maxUsers = Integer.valueOf(i);
    }

    @Override // com.ua.sdk.group.Group
    public GroupObjective getGroupObjective() {
        return this.groupObjective;
    }

    public void setGroupObjective(GroupObjective groupObjective) {
        this.groupObjective = groupObjective;
    }

    @Override // com.ua.sdk.group.Group
    public EntityRef<GroupUser> getGroupUserRef() {
        ArrayList<Link> links;
        if (this.groupUserRef == null && (links = getLinks("group_user")) != null) {
            this.groupUserRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.groupUserRef;
    }

    @Override // com.ua.sdk.group.Group
    public EntityRef<ActivityStory> getActivityFeedRef() {
        ArrayList<Link> links;
        if (this.activityFeedRef == null && (links = getLinks("activity_feed")) != null) {
            this.activityFeedRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.activityFeedRef;
    }

    @Override // com.ua.sdk.group.Group
    public EntityRef<GroupPurpose> getGroupPurposeRef() {
        ArrayList<Link> links;
        if (this.groupPurposeRef == null && (links = getLinks("group_purpose")) != null) {
            this.groupPurposeRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.groupPurposeRef;
    }

    public void setGroupPurposeRef(EntityRef<GroupPurpose> entityRef) {
        this.groupPurposeRef = entityRef;
        addLink("group_purpose", new Link(entityRef.getHref(), entityRef.getId()));
    }

    @Override // com.ua.sdk.group.Group
    public EntityRef<GroupInvite> getGroupInviteRef() {
        ArrayList<Link> links;
        if (this.groupInviteRef == null && (links = getLinks("group_invite")) != null) {
            this.groupInviteRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.groupInviteRef;
    }

    @Override // com.ua.sdk.group.Group
    public EntityRef<User> getGroupOwnerRef() {
        Link link;
        if (this.groupOwnerRef == null && (link = getLink("group_owner")) != null) {
            this.groupOwnerRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.groupOwnerRef;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<GroupImpl> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.publicGroup);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeValue(this.invitationRequired);
        parcel.writeString(this.invitationCode);
        parcel.writeValue(this.groupObjective);
        parcel.writeValue(this.maxUsers);
    }

    private GroupImpl(Parcel parcel) {
        super(parcel);
        this.publicGroup = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.invitationRequired = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.invitationCode = parcel.readString();
        this.groupObjective = (GroupObjective) parcel.readValue(GroupObjective.class.getClassLoader());
        this.maxUsers = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
