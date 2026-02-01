package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class SimpleGeoApi extends DefaultApi10a {
    private static final String ENDPOINT = "these are not used since SimpleGeo uses 2 legged OAuth";

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return ENDPOINT;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return ENDPOINT;
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return ENDPOINT;
    }
}
