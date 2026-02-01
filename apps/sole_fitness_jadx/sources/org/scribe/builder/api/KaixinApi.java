package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

/* loaded from: classes2.dex */
public class KaixinApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://api.kaixin001.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "http://api.kaixin001.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://api.kaixin001.com/oauth/request_token";

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

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }
}
