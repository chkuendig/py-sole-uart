package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class SkyrockApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_RESOURCE = "/oauth/token";
    private static final String API_ENDPOINT = "https://api.skyrock.com/v2";
    private static final String AUTHORIZE_URL = "/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "/oauth/initiate";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://api.skyrock.com/v2/oauth/token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://api.skyrock.com/v2/oauth/initiate";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format("https://api.skyrock.com/v2/oauth/authorize?oauth_token=%s", token.getToken());
    }
}
