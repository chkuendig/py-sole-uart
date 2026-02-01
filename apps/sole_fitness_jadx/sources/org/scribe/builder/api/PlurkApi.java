package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class PlurkApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_URL = "http://www.plurk.com/OAuth/access_token";
    private static final String AUTHORIZATION_URL = "http://www.plurk.com/OAuth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "http://www.plurk.com/OAuth/request_token";

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
        return String.format(AUTHORIZATION_URL, token.getToken());
    }

    public static class Mobile extends PlurkApi {
        private static final String AUTHORIZATION_URL = "http://www.plurk.com/m/authorize?oauth_token=%s";

        @Override // org.scribe.builder.api.PlurkApi, org.scribe.builder.api.DefaultApi10a
        public String getAuthorizationUrl(Token token) {
            return String.format(AUTHORIZATION_URL, token.getToken());
        }
    }
}
