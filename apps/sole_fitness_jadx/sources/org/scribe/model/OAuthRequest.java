package org.scribe.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class OAuthRequest extends Request {
    private static final String OAUTH_PREFIX = "oauth_";
    private Map<String, String> oauthParameters;

    public OAuthRequest(Verb verb, String str) {
        super(verb, str);
        this.oauthParameters = new HashMap();
    }

    public void addOAuthParameter(String str, String str2) {
        this.oauthParameters.put(checkKey(str), str2);
    }

    private String checkKey(String str) {
        if (str.startsWith("oauth_") || str.equals("scope")) {
            return str;
        }
        throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", "scope", "oauth_"));
    }

    public Map<String, String> getOauthParameters() {
        return this.oauthParameters;
    }

    @Override // org.scribe.model.Request
    public String toString() {
        return String.format("@OAuthRequest(%s, %s)", getVerb(), getUrl());
    }
}
