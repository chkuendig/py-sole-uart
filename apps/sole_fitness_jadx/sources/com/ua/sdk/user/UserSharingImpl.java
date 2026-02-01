package com.ua.sdk.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UserSharingImpl implements UserSharing, Parcelable {
    public static Parcelable.Creator<UserSharingImpl> CREATOR = new Parcelable.Creator<UserSharingImpl>() { // from class: com.ua.sdk.user.UserSharingImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSharingImpl createFromParcel(Parcel parcel) {
            return new UserSharingImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserSharingImpl[] newArray(int i) {
            return new UserSharingImpl[i];
        }
    };

    @SerializedName(AccessToken.DEFAULT_GRAPH_DOMAIN)
    Boolean facebook;

    @SerializedName("twitter")
    Boolean twitter;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserSharingImpl() {
    }

    @Override // com.ua.sdk.user.UserSharing
    public Boolean getTwitter() {
        return this.twitter;
    }

    @Override // com.ua.sdk.user.UserSharing
    public boolean isTwitter() {
        Boolean bool = this.twitter;
        return bool != null && bool.booleanValue();
    }

    @Override // com.ua.sdk.user.UserSharing
    public void setTwitter(Boolean bool) {
        this.twitter = bool;
    }

    @Override // com.ua.sdk.user.UserSharing
    public Boolean getFacebook() {
        return this.facebook;
    }

    @Override // com.ua.sdk.user.UserSharing
    public boolean isFacebook() {
        Boolean bool = this.facebook;
        return bool != null && bool.booleanValue();
    }

    @Override // com.ua.sdk.user.UserSharing
    public void setFacebook(Boolean bool) {
        this.facebook = bool;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Boolean facebook;
        private Boolean twitter;

        public Builder setTwitter(Boolean bool) {
            this.twitter = bool;
            return this;
        }

        public Builder setFacebook(Boolean bool) {
            this.facebook = bool;
            return this;
        }

        public UserSharingImpl build() {
            UserSharingImpl userSharingImpl = new UserSharingImpl();
            userSharingImpl.setTwitter(this.twitter);
            userSharingImpl.setFacebook(this.facebook);
            return userSharingImpl;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.twitter);
        parcel.writeValue(this.facebook);
    }

    private UserSharingImpl(Parcel parcel) {
        this.twitter = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.facebook = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
