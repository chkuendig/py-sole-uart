package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class VkontakteApi extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "https://oauth.vk.com/authorize?client_id=%s&redirect_uri=%s&response_type=code";
    private static final String SCOPED_AUTHORIZE_URL = String.format("%s&scope=%%s", AUTHORIZE_URL);

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAccessTokenEndpoint() {
        return "https://api.vkontakte.ru/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        Preconditions.checkValidUrl(oAuthConfig.getCallback(), "Valid url is required for a callback. Vkontakte does not support OOB");
        return oAuthConfig.hasScope() ? String.format(SCOPED_AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()), OAuthEncoder.encode(oAuthConfig.getScope())) : String.format(AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()));
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }
}
