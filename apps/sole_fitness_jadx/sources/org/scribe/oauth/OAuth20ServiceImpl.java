package org.scribe.oauth;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

/* loaded from: classes2.dex */
public class OAuth20ServiceImpl implements OAuthService {
    private static final String VERSION = "2.0";
    private final DefaultApi20 api;
    private final OAuthConfig config;

    @Override // org.scribe.oauth.OAuthService
    public String getVersion() {
        return VERSION;
    }

    public OAuth20ServiceImpl(DefaultApi20 defaultApi20, OAuthConfig oAuthConfig) {
        this.api = defaultApi20;
        this.config = oAuthConfig;
    }

    @Override // org.scribe.oauth.OAuthService
    public Token getAccessToken(Token token, Verifier verifier) {
        OAuthRequest oAuthRequest = new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint());
        oAuthRequest.addQuerystringParameter("client_id", this.config.getApiKey());
        oAuthRequest.addQuerystringParameter(OAuthConstants.CLIENT_SECRET, this.config.getApiSecret());
        oAuthRequest.addQuerystringParameter(OAuthConstants.CODE, verifier.getValue());
        oAuthRequest.addQuerystringParameter("redirect_uri", this.config.getCallback());
        if (this.config.hasScope()) {
            oAuthRequest.addQuerystringParameter("scope", this.config.getScope());
        }
        return this.api.getAccessTokenExtractor().extract(oAuthRequest.send().getBody());
    }

    @Override // org.scribe.oauth.OAuthService
    public Token getRequestToken() {
        throw new UnsupportedOperationException("Unsupported operation, please use 'getAuthorizationUrl' and redirect your users there");
    }

    @Override // org.scribe.oauth.OAuthService
    public void signRequest(Token token, OAuthRequest oAuthRequest) {
        oAuthRequest.addQuerystringParameter("access_token", token.getToken());
    }

    @Override // org.scribe.oauth.OAuthService
    public String getAuthorizationUrl(Token token) {
        return this.api.getAuthorizationUrl(this.config);
    }
}
