package com.ua.sdk.user;

import com.facebook.AccessToken;

/* loaded from: classes2.dex */
public enum UserSource {
    FACEBOOK(AccessToken.DEFAULT_GRAPH_DOMAIN),
    MMF("mmf");

    private final String name;

    UserSource(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
