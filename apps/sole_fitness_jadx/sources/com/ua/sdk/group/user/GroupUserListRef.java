package com.ua.sdk.group.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class GroupUserListRef implements EntityListRef<GroupUser> {
    public static Parcelable.Creator<GroupUserListRef> CREATOR = new Parcelable.Creator<GroupUserListRef>() { // from class: com.ua.sdk.group.user.GroupUserListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupUserListRef createFromParcel(Parcel parcel) {
            return new GroupUserListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupUserListRef[] newArray(int i) {
            return new GroupUserListRef[i];
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

    private GroupUserListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private GroupUserListRef(Builder builder) {
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
            super("/v7.0/group_user/");
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public GroupUserListRef build() {
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
            return new GroupUserListRef(this);
        }
    }
}
