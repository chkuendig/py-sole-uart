package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.services.PlaintextSignatureService;
import org.scribe.services.SignatureService;

/* loaded from: classes2.dex */
public class YammerApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://www.yammer.com/oauth/authorize?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://www.yammer.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://www.yammer.com/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public SignatureService getSignatureService() {
        return new PlaintextSignatureService();
    }
}
