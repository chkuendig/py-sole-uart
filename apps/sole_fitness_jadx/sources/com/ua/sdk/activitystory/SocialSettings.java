package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class SocialSettings implements Parcelable {
    public static final Parcelable.Creator<SocialSettings> CREATOR = new Parcelable.Creator<SocialSettings>() { // from class: com.ua.sdk.activitystory.SocialSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SocialSettings createFromParcel(Parcel parcel) {
            return new SocialSettings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SocialSettings[] newArray(int i) {
            return new SocialSettings[i];
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

    public Boolean getFacebook() {
        return this.facebook;
    }

    public void setFacebook(Boolean bool) {
        this.facebook = bool;
    }

    public Boolean getTwitter() {
        return this.twitter;
    }

    public void setTwitter(Boolean bool) {
        this.twitter = bool;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.facebook);
        parcel.writeValue(this.twitter);
    }

    public SocialSettings() {
    }

    public SocialSettings(Builder builder) {
        this.facebook = builder.facebook;
        this.twitter = builder.twitter;
    }

    private SocialSettings(Parcel parcel) {
        this.facebook = (Boolean) parcel.readValue(null);
        this.twitter = (Boolean) parcel.readValue(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SocialSettings socialSettings = (SocialSettings) obj;
        Boolean bool = this.facebook;
        if (bool == null ? socialSettings.facebook != null : !bool.equals(socialSettings.facebook)) {
            return false;
        }
        Boolean bool2 = this.twitter;
        Boolean bool3 = socialSettings.twitter;
        return bool2 == null ? bool3 == null : bool2.equals(bool3);
    }

    public int hashCode() {
        Boolean bool = this.facebook;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.twitter;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public static class Builder {
        Boolean facebook;
        Boolean twitter;

        public Builder setFacebookShare(Boolean bool) {
            this.facebook = bool;
            return this;
        }

        public Builder setTwitterShare(Boolean bool) {
            this.twitter = bool;
            return this;
        }

        public SocialSettings build() {
            return new SocialSettings(this);
        }
    }
}
