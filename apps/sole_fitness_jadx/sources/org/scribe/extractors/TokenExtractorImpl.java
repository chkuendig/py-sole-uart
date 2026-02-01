package org.scribe.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class TokenExtractorImpl implements RequestTokenExtractor, AccessTokenExtractor {
    private static final Pattern TOKEN_REGEX = Pattern.compile("oauth_token=([^&]+)");
    private static final Pattern SECRET_REGEX = Pattern.compile("oauth_token_secret=([^&]*)");

    @Override // org.scribe.extractors.RequestTokenExtractor, org.scribe.extractors.AccessTokenExtractor
    public Token extract(String str) {
        Preconditions.checkEmptyString(str, "Response body is incorrect. Can't extract a token from an empty string");
        return new Token(extract(str, TOKEN_REGEX), extract(str, SECRET_REGEX), str);
    }

    private String extract(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() >= 1) {
            return OAuthEncoder.decode(matcher.group(1));
        }
        throw new OAuthException("Response body is incorrect. Can't extract token and secret from this: '" + str + "'", null);
    }
}
