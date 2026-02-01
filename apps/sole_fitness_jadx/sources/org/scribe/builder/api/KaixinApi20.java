package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;

/* loaded from: classes2.dex */
public class KaixinApi20 extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "http://api.kaixin001.com/oauth2/authorize?client_id=%s&redirect_uri=%s&response_type=code";
    private static final String SCOPED_AUTHORIZE_URL = "http://api.kaixin001.com/oauth2/authorize?client_id=%s&redirect_uri=%s&response_type=code&scope=%s";

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAccessTokenEndpoint() {
        return "https://api.kaixin001.com/oauth2/access_token?grant_type=authorization_code";
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        return oAuthConfig.hasScope() ? String.format(SCOPED_AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()), OAuthEncoder.encode(oAuthConfig.getScope())) : String.format(AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()));
    }
}
