package org.scribe.builder.api;

import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class FacebookApi extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s";
    private static final String SCOPED_AUTHORIZE_URL = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s&scope=%s";

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAccessTokenEndpoint() {
        return "https://graph.facebook.com/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        Preconditions.checkValidUrl(oAuthConfig.getCallback(), "Must provide a valid url as callback. Facebook does not support OOB");
        return oAuthConfig.hasScope() ? String.format(SCOPED_AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()), OAuthEncoder.encode(oAuthConfig.getScope())) : String.format(AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()));
    }
}
