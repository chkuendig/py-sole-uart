package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class EvernoteApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "https://www.evernote.com/OAuth.action?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://www.evernote.com/oauth";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "https://www.evernote.com/oauth";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }

    public static class Sandbox extends EvernoteApi {
        private static final String SANDBOX_URL = "https://sandbox.evernote.com";

        @Override // org.scribe.builder.api.EvernoteApi, org.scribe.builder.api.DefaultApi10a
        public String getAccessTokenEndpoint() {
            return "https://sandbox.evernote.com/oauth";
        }

        @Override // org.scribe.builder.api.EvernoteApi, org.scribe.builder.api.DefaultApi10a
        public String getRequestTokenEndpoint() {
            return "https://sandbox.evernote.com/oauth";
        }

        @Override // org.scribe.builder.api.EvernoteApi, org.scribe.builder.api.DefaultApi10a
        public String getAuthorizationUrl(Token token) {
            return String.format("https://sandbox.evernote.com/OAuth.action?oauth_token=%s", token.getToken());
        }
    }
}
