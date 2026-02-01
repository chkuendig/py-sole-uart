package org.scribe.builder.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class LinkedInApi extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://api.linkedin.com/uas/oauth/authenticate?oauth_token=%s";
    private static final String REQUEST_TOKEN_URL = "https://api.linkedin.com/uas/oauth/requestToken";
    private final Set<String> scopes;

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "https://api.linkedin.com/uas/oauth/accessToken";
    }

    public LinkedInApi() {
        this.scopes = Collections.emptySet();
    }

    public LinkedInApi(Set<String> set) {
        this.scopes = Collections.unmodifiableSet(set);
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        if (this.scopes.isEmpty()) {
            return REQUEST_TOKEN_URL;
        }
        return "https://api.linkedin.com/uas/oauth/requestToken?scope=" + scopesAsString();
    }

    private String scopesAsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.scopes.iterator();
        while (it.hasNext()) {
            sb.append("+" + it.next());
        }
        return sb.substring(1);
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return String.format(AUTHORIZE_URL, token.getToken());
    }

    public static LinkedInApi withScopes(String... strArr) {
        return new LinkedInApi(new HashSet(Arrays.asList(strArr)));
    }
}
