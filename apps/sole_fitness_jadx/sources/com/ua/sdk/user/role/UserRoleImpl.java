package com.ua.sdk.user.role;

import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.role.Role;

/* loaded from: classes2.dex */
public class UserRoleImpl extends ApiTransferObject implements UserRole {
    private transient Link resource;
    private transient Link role;
    private transient Link user;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserRoleImpl() {
    }

    private UserRoleImpl(Builder builder) {
        this.role = builder.role;
        this.user = builder.user;
        this.resource = builder.resource;
    }

    @Override // com.ua.sdk.user.role.UserRole
    public Link getRole() {
        Link link = this.role;
        return link != null ? link : getLink("role");
    }

    @Override // com.ua.sdk.user.role.UserRole
    public Link getUser() {
        Link link = this.user;
        return link != null ? link : getLink("user");
    }

    @Override // com.ua.sdk.user.role.UserRole
    public Link getResource() {
        Link link = this.resource;
        return link != null ? link : getLink("resource");
    }

    @Override // com.ua.sdk.user.role.UserRole
    public void setRole(Link link) {
        this.role = link;
    }

    @Override // com.ua.sdk.user.role.UserRole
    public void setUser(Link link) {
        this.user = link;
    }

    @Override // com.ua.sdk.user.role.UserRole
    public void setResource(Link link) {
        this.resource = link;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<UserRole> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    public static class Builder {
        Link resource;
        Link role;
        Link user;

        public Builder setRole(Role.Type type) {
            this.role = new Link((String) null, type.getValue());
            return this;
        }

        public Builder setUser(String str) {
            this.user = new Link((String) null, str);
            return this;
        }

        public Builder setResource(String str) {
            this.resource = new Link(str);
            return this;
        }

        public UserRoleImpl build() {
            return new UserRoleImpl(this);
        }
    }
}
