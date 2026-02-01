package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class ViadeoApi extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "https://secure.viadeo.com/oauth-provider/authorize2?client_id=%s&redirect_uri=%s&response_type=code";
    private static final String SCOPED_AUTHORIZE_URL = "https://secure.viadeo.com/oauth-provider/authorize2?client_id=%s&redirect_uri=%s&response_type=code&scope=%s";

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAccessTokenEndpoint() {
        return "https://secure.viadeo.com/oauth-provider/access_token2?grant_type=authorization_code";
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        Preconditions.checkValidUrl(oAuthConfig.getCallback(), "Must provide a valid url as callback. Viadeo does not support OOB");
        return oAuthConfig.hasScope() ? String.format(SCOPED_AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()), OAuthEncoder.encode(oAuthConfig.getScope())) : String.format(AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()));
    }
}
