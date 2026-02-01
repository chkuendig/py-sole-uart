package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class TrelloApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://trello.com/1/OAuthAuthorizeToken?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://trello.com/1/OAuthGetAccessToken";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://trello.com/1/OAuthGetRequestToken";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }
}
