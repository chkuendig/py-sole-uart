package com.ua.sdk.authentication;

import com.facebook.AccessToken;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class OAuth2CredentialsTO {

    @SerializedName("access_token")
    String accessToken;

    @SerializedName(AccessToken.EXPIRES_IN_KEY)
    Long expiresIn;

    @SerializedName("refresh_token")
    String refreshToken;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public Long getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(Long l) {
        this.expiresIn = l;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public static OAuth2Credentials toImpl(OAuth2CredentialsTO oAuth2CredentialsTO) {
        OAuth2CredentialsImpl oAuth2CredentialsImpl = new OAuth2CredentialsImpl();
        oAuth2CredentialsImpl.setAccessToken(oAuth2CredentialsTO.getAccessToken());
        oAuth2CredentialsImpl.setRefreshToken(oAuth2CredentialsTO.getRefreshToken());
        oAuth2CredentialsImpl.setExpiresAt(Long.valueOf(System.currentTimeMillis() + (oAuth2CredentialsTO.getExpiresIn().longValue() * 1000)));
        return oAuth2CredentialsImpl;
    }
}
