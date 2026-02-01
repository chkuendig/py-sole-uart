package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class DiggApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "http://digg.com/oauth/authorize?oauth_token=%s";
    private static final String BASE_URL = "http://services.digg.com/oauth/";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://services.digg.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://services.digg.com/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }
}
