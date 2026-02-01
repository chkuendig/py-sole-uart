package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class XingApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://api.xing.com/v1/authorize?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://api.xing.com/v1/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://api.xing.com/v1/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }
}
