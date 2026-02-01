package com.ua.sdk.group.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.group.Group;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class GroupUserImpl extends ApiTransferObject implements GroupUser {
    public static Parcelable.Creator<GroupUserImpl> CREATOR = new Parcelable.Creator<GroupUserImpl>() { // from class: com.ua.sdk.group.user.GroupUserImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupUserImpl createFromParcel(Parcel parcel) {
            return new GroupUserImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupUserImpl[] newArray(int i) {
            return new GroupUserImpl[i];
        }
    };
    private static final String GROUP_KEY = "group";
    private static final String USER_KEY = "user";
    transient EntityRef<Group> groupRef;
    transient EntityRef<User> userRef;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private GroupUserImpl(Builder builder) {
        this.userRef = new LinkEntityRef(builder.userHref);
        this.groupRef = new LinkEntityRef(builder.groupHref);
        addLink("user", new Link(builder.userHref));
        addLink(GROUP_KEY, new Link(builder.groupHref));
    }

    public GroupUserImpl() {
    }

    private GroupUserImpl(Parcel parcel) {
        super(parcel);
    }

    @Override // com.ua.sdk.group.user.GroupUser
    public EntityRef<User> getUserRef() {
        Link link;
        if (this.userRef == null && (link = getLink("user")) != null) {
            this.userRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.userRef;
    }

    @Override // com.ua.sdk.group.user.GroupUser
    public EntityRef<Group> getGroupRef() {
        Link link;
        if (this.groupRef == null && (link = getLink(GROUP_KEY)) != null) {
            this.groupRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.groupRef;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<GroupUser> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    public static class Builder {
        String groupHref;
        String userHref;

        public Builder setGroupRef(EntityRef<Group> entityRef) {
            this.groupHref = entityRef.getHref();
            return this;
        }

        public Builder setUserRef(EntityRef<User> entityRef) {
            this.userHref = entityRef.getHref();
            return this;
        }

        public GroupUserImpl build() {
            return new GroupUserImpl(this);
        }
    }
}
