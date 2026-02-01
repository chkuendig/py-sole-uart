package com.ua.sdk.authentication;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class InternalTokenCredentialTO {

    @SerializedName("secret")
    String secret;

    @SerializedName("token")
    String token;

    @SerializedName("token_type")
    String tokenType;

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public static InternalTokenCredentialTO toTransferObject(InternalTokenCredential internalTokenCredential) {
        InternalTokenCredentialTO internalTokenCredentialTO = new InternalTokenCredentialTO();
        internalTokenCredentialTO.setTokenType(internalTokenCredential.getTokenType());
        internalTokenCredentialTO.setToken(internalTokenCredential.getToken());
        internalTokenCredentialTO.setSecret(internalTokenCredential.getSecret());
        return internalTokenCredentialTO;
    }
}
