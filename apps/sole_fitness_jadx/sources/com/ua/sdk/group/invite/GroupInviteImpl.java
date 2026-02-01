package com.ua.sdk.group.invite;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.group.Group;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class GroupInviteImpl extends ApiTransferObject implements GroupInvite {
    public static Parcelable.Creator<GroupInviteImpl> CREATOR = new Parcelable.Creator<GroupInviteImpl>() { // from class: com.ua.sdk.group.invite.GroupInviteImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInviteImpl createFromParcel(Parcel parcel) {
            return new GroupInviteImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInviteImpl[] newArray(int i) {
            return new GroupInviteImpl[i];
        }
    };
    private static final String GROUP_KEY = "group";
    private static final String USER_KEY = "user";

    @SerializedName("email")
    String email;
    transient EntityRef<Group> groupRef;
    transient EntityRef<User> userRef;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GroupInviteImpl() {
    }

    private GroupInviteImpl(Parcel parcel) {
        super(parcel);
        this.email = parcel.readString();
    }

    @Override // com.ua.sdk.group.invite.GroupInvite
    public String getEmail() {
        return this.email;
    }

    @Override // com.ua.sdk.group.invite.GroupInvite
    public EntityRef<User> getUserRef() {
        Link link;
        if (this.userRef == null && (link = getLink("user")) != null) {
            this.userRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.userRef;
    }

    @Override // com.ua.sdk.group.invite.GroupInvite
    public EntityRef<Group> getGroupRef() {
        Link link;
        if (this.groupRef == null && (link = getLink(GROUP_KEY)) != null) {
            this.groupRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.groupRef;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setGroupRef(EntityRef<Group> entityRef) {
        if (entityRef == null || entityRef.getHref() == null) {
            return;
        }
        this.groupRef = entityRef;
        addLink(GROUP_KEY, new Link(entityRef.getHref()));
    }

    public void setUserRef(EntityRef<User> entityRef) {
        if (entityRef == null || entityRef.getHref() == null) {
            return;
        }
        this.userRef = entityRef;
        addLink("user", new Link(entityRef.getHref()));
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<GroupInvite> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.email);
    }
}
