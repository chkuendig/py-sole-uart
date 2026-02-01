package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class DropBoxApi extends DefaultApi10a {
    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://api.dropbox.com/1/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://api.dropbox.com/1/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return "https://www.dropbox.com/1/oauth/authorize?oauth_token=" + token.getToken();
    }
}
