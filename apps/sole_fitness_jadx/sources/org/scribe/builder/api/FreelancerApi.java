package org.scribe.builder.api;

import org.scribe.model.Token;
import org.scribe.model.Verb;

/* loaded from: classes2.dex */
public class FreelancerApi extends DefaultApi10a {
    private static final String AUTHORIZATION_URL = "http://www.freelancer.com/users/api-token/auth.php?oauth_token=%s";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://api.freelancer.com/RequestAccessToken/requestAccessToken.xml?";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://api.freelancer.com/RequestRequestToken/requestRequestToken.xml";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZATION_URL, token.getToken());
    }

    public static class Sandbox extends FreelancerApi {
        private static final String SANDBOX_AUTHORIZATION_URL = "http://www.sandbox.freelancer.com/users/api-token/auth.php";

        @Override // org.scribe.builder.api.FreelancerApi, org.scribe.builder.api.DefaultApi10a
        public String getAccessTokenEndpoint() {
            return "http://api.sandbox.freelancer.com/RequestAccessToken/requestAccessToken.xml?";
        }

        @Override // org.scribe.builder.api.FreelancerApi, org.scribe.builder.api.DefaultApi10a
        public String getRequestTokenEndpoint() {
            return "http://api.sandbox.freelancer.com/RequestRequestToken/requestRequestToken.xml";
        }

        @Override // org.scribe.builder.api.FreelancerApi, org.scribe.builder.api.DefaultApi10a
        public String getAuthorizationUrl(Token token) {
            return String.format("http://www.sandbox.freelancer.com/users/api-token/auth.php?oauth_token=%s", token.getToken());
        }
    }
}
