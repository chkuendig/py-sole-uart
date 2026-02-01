package org.scribe.builder.api;

import org.scribe.model.Token;

/* loaded from: classes2.dex */
public class FlickrApi extends DefaultApi10a {
    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAccessTokenEndpoint() {
        return "http://www.flickr.com/services/oauth/access_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getRequestTokenEndpoint() {
        return "http://www.flickr.com/services/oauth/request_token";
    }

    @Override // org.scribe.builder.api.DefaultApi10a
    public String getAuthorizationUrl(Token token) {
        return "http://www.flickr.com/services/oauth/authorize?oauth_token=" + token.getToken();
    }
}
