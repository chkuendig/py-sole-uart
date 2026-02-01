package com.ua.sdk.authentication;

import com.facebook.AccessToken;
import com.ua.sdk.UaException;

/* loaded from: classes2.dex */
public interface InternalTokenCredentialManager {
    OAuth2Credentials createForLogin(TokenType tokenType, String str, String str2) throws UaException;

    OAuth2Credentials updateForSync(TokenType tokenType, String str, String str2) throws UaException;

    public enum TokenType {
        FACEBOOK(AccessToken.DEFAULT_GRAPH_DOMAIN),
        TWITTER("twitter");

        private String name;

        TokenType(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }
}
