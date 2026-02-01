package com.ua.sdk.authentication;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface InternalTokenCredential extends Parcelable {
    String getSecret();

    String getToken();

    String getTokenType();

    void setSecret(String str);

    void setToken(String str);

    void setTokenType(String str);
}
