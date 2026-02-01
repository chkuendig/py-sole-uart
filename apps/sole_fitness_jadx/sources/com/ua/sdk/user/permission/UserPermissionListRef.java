package com.ua.sdk.user.permission;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public class UserPermissionListRef implements EntityListRef<UserPermission> {
    public static Parcelable.Creator<UserPermissionListRef> CREATOR = new Parcelable.Creator<UserPermissionListRef>() { // from class: com.ua.sdk.user.permission.UserPermissionListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserPermissionListRef createFromParcel(Parcel parcel) {
            return new UserPermissionListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserPermissionListRef[] newArray(int i) {
            return new UserPermissionListRef[i];
        }
    };
    private final String href;
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private UserPermissionListRef(Builder builder) {
        this.id = builder.id;
        this.href = builder.href;
    }

    private UserPermissionListRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
    }

    public static class Builder {
        private String href;
        private final String id;

        public Builder(Resource resource) {
            this.id = resource.getRef().getId();
            this.href = resource.getRef().getHref();
        }

        public Builder(String str) {
            this.id = str;
        }

        public Builder href(String str) {
            this.href = str;
            return this;
        }

        public UserPermissionListRef build() {
            return new UserPermissionListRef(this);
        }
    }
}
