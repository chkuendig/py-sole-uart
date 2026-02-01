package com.ua.sdk.group.invite;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class GroupInviteListRef implements EntityListRef<GroupInvite> {
    public static Parcelable.Creator<GroupInviteListRef> CREATOR = new Parcelable.Creator<GroupInviteListRef>() { // from class: com.ua.sdk.group.invite.GroupInviteListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInviteListRef createFromParcel(Parcel parcel) {
            return new GroupInviteListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupInviteListRef[] newArray(int i) {
            return new GroupInviteListRef[i];
        }
    };
    private final String href;

    public enum Type {
        GROUP,
        USER
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private GroupInviteListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private GroupInviteListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String GROUP_ID_KEY = "group_id";
        private static final String USER_ID_KEY = "user_id";
        private String id;
        private Type type;

        public Builder() {
            super("/v7.0/group_invite/");
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public GroupInviteListRef build() {
            Type type = this.type;
            if (type == null) {
                throw new IllegalArgumentException("Builder type must be initialized!");
            }
            if (this.id == null) {
                throw new IllegalArgumentException("ID must be initialized!");
            }
            if (type == Type.GROUP) {
                setParam("group_id", this.id);
            } else {
                setParam("user_id", this.id);
            }
            return new GroupInviteListRef(this);
        }
    }
}
