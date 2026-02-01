package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class MeetupApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "http://www.meetup.com/authenticate?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://api.meetup.com/oauth/access/";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://api.meetup.com/oauth/request/";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }
}
