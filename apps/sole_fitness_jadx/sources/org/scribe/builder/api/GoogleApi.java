package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

/* loaded from: classes2.dex */
public class GoogleApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://www.google.com/accounts/OAuthAuthorizeToken?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://www.google.com/accounts/OAuthGetAccessToken";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://www.google.com/accounts/OAuthGetRequestToken";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }
}
