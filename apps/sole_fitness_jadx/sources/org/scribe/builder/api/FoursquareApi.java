package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class FoursquareApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "http://foursquare.com/oauth/authorize?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://foursquare.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://foursquare.com/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }
}
