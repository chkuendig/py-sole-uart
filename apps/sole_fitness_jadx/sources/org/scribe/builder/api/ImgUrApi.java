package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class ImgUrApi extends DefaultApi10a {
    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://api.imgur.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://api.imgur.com/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format("https://api.imgur.com/oauth/authorize?oauth_token=%s", token.getToken());
    }
}
