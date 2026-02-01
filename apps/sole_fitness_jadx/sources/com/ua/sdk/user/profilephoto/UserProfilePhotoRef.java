package com.ua.sdk.user.profilephoto;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class UserProfilePhotoRef implements EntityRef<UserProfilePhoto>, Parcelable {
    public static final Parcelable.Creator<UserProfilePhotoRef> CREATOR = new Parcelable.Creator<UserProfilePhotoRef>() { // from class: com.ua.sdk.user.profilephoto.UserProfilePhotoRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfilePhotoRef createFromParcel(Parcel parcel) {
            return new UserProfilePhotoRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfilePhotoRef[] newArray(int i) {
            return new UserProfilePhotoRef[i];
        }
    };
    private final String href;
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private UserProfilePhotoRef(Builder builder) {
        this.id = builder.id;
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private String id;

        private Builder() {
            super("/v7.0/user_profile_photo/{id}/");
        }

        public Builder setId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public UserProfilePhotoRef build() {
            return new UserProfilePhotoRef(this);
        }
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

    private UserProfilePhotoRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
    }
}
