package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.services.PlaintextSignatureService;
import org.scribe.services.SignatureService;

/* loaded from: classes2.dex */
public class UbuntuOneApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://one.ubuntu.com/oauth/authorize/?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://one.ubuntu.com/oauth/access/";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://one.ubuntu.com/oauth/request/";
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
