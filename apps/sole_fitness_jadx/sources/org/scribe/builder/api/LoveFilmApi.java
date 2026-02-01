package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class LoveFilmApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://openapi.lovefilm.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://www.lovefilm.com/activate?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://openapi.lovefilm.com/oauth/request_token";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_URL;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_URL;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }
}
