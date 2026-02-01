package com.ua.sdk.authentication;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.Reference;

/* loaded from: classes2.dex */
public class OAuth2CredentialsImpl implements OAuth2Credentials, Parcelable {
    public static final Parcelable.Creator<OAuth2CredentialsImpl> CREATOR = new Parcelable.Creator<OAuth2CredentialsImpl>() { // from class: com.ua.sdk.authentication.OAuth2CredentialsImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OAuth2CredentialsImpl createFromParcel(Parcel parcel) {
            return new OAuth2CredentialsImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OAuth2CredentialsImpl[] newArray(int i) {
            return new OAuth2CredentialsImpl[i];
        }
    };
    private String accessToken;
    private Long expiresAt;
    private String refreshToken;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public Reference getRef() {
        return null;
    }

    public OAuth2CredentialsImpl() {
    }

    @Override // com.ua.sdk.authentication.OAuth2Credentials
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // com.ua.sdk.authentication.OAuth2Credentials
    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    @Override // com.ua.sdk.authentication.OAuth2Credentials
    public Long getExpiresAt() {
        return this.expiresAt;
    }

    @Override // com.ua.sdk.authentication.OAuth2Credentials
    public void setExpiresAt(Long l) {
        this.expiresAt = l;
    }

    @Override // com.ua.sdk.authentication.OAuth2Credentials
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.ua.sdk.authentication.OAuth2Credentials
    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.accessToken);
        parcel.writeValue(this.expiresAt);
        parcel.writeString(this.refreshToken);
    }

    private OAuth2CredentialsImpl(Parcel parcel) {
        this.accessToken = parcel.readString();
        this.expiresAt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.refreshToken = parcel.readString();
    }
}
