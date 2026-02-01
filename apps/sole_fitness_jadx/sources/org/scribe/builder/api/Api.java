package org.scribe.builder.api;

import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuthService;

/* loaded from: classes2.dex */
public interface Api {
    OAuthService createService(OAuthConfig oAuthConfig);
}
