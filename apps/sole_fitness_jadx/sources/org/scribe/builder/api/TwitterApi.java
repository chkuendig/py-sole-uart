package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class TwitterApi extends DefaultApi10a {
    private static final String ACCESS_TOKEN_RESOURCE = "api.twitter.com/oauth/access_token";
    private static final String AUTHORIZE_URL = "https://api.twitter.com/oauth/authorize?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "api.twitter.com/oauth/request_token";

    public static class Authorize extends SSL {
    }

    public static class SSL extends TwitterApi {
        @Override // org.scribe.builder.api.TwitterApi, org.scribe.builder.api.DefaultApi10a
        public String getAccessTokenEndpoint() {
            return "https://api.twitter.com/oauth/access_token";
        }

        @Override // org.scribe.builder.api.TwitterApi, org.scribe.builder.api.DefaultApi10a
        public String getRequestTokenEndpoint() {
            return "https://api.twitter.com/oauth/request_token";
        }
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://api.twitter.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://api.twitter.com/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }

    public static class Authenticate extends SSL {
        private static final String AUTHENTICATE_URL = "https://api.twitter.com/oauth/authenticate?oauth_token=%s";

        @Override // org.scribe.builder.api.TwitterApi, org.scribe.builder.api.DefaultApi10a
        public String getAuthorizationUrl(Token token) {
            return String.format(AUTHENTICATE_URL, token.getToken());
        }
    }
}
