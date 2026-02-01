package org.scribe.builder.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class ConstantContactApi2 extends DefaultApi20 {
    private static final String AUTHORIZE_URL = "https://oauth2.constantcontact.com/oauth2/oauth/siteowner/authorize?client_id=%s&response_type=code&redirect_uri=%s";

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAccessTokenEndpoint() {
        return "https://oauth2.constantcontact.com/oauth2/oauth/token?grant_type=authorization_code";
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public String getAuthorizationUrl(OAuthConfig oAuthConfig) {
        return String.format(AUTHORIZE_URL, oAuthConfig.getApiKey(), OAuthEncoder.encode(oAuthConfig.getCallback()));
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

    @Override // org.scribe.builder.api.DefaultApi20
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new AccessTokenExtractor() { // from class: org.scribe.builder.api.ConstantContactApi2.1
            @Override // org.scribe.extractors.AccessTokenExtractor
            public Token extract(String str) {
                Preconditions.checkEmptyString(str, "Response body is incorrect. Can't extract a token from an empty string");
                Matcher matcher = Pattern.compile("\"access_token\"\\s*:\\s*\"([^&\"]+)\"").matcher(str);
                if (matcher.find()) {
                    return new Token(OAuthEncoder.decode(matcher.group(1)), "", str);
                }
                throw new OAuthException("Response body is incorrect. Can't extract a token from this: '" + str + "'", null);
            }
        };
    }
}
