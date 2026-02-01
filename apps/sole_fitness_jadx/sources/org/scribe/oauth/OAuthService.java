package org.scribe.oauth;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

/* loaded from: classes2.dex */
public interface OAuthService {
    Token getAccessToken(Token token, Verifier verifier);

    String getAuthorizationUrl(Token token);

    Token getRequestToken();

    String getVersion();

    void signRequest(Token token, OAuthRequest oAuthRequest);
}
