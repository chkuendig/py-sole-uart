package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class VimeoApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "http://vimeo.com/oauth/authorize?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://vimeo.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://vimeo.com/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }
}
