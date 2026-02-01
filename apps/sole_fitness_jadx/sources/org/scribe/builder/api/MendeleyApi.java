package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

/* loaded from: classes2.dex */
public class MendeleyApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "http://api.mendeley.com/oauth/authorize?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://api.mendeley.com/oauth/access_token/";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://api.mendeley.com/oauth/request_token/";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }
}
