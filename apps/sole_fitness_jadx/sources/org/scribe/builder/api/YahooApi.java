package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class YahooApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://api.login.yahoo.com/oauth/v2/request_auth?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://api.login.yahoo.com/oauth/v2/get_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://api.login.yahoo.com/oauth/v2/get_request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }
}
