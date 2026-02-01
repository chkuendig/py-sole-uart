package org.scribe.extractors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.Token;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class TokenExtractor20Impl implements AccessTokenExtractor {
    private static final String EMPTY_SECRET = "";
    private static final String TOKEN_REGEX = "access_token=([^&]+)";

    @Override // org.scribe.extractors.AccessTokenExtractor
    public Token extract(String str) {
        Preconditions.checkEmptyString(str, "Response body is incorrect. Can't extract a token from an empty string");
        Matcher matcher = Pattern.compile(TOKEN_REGEX).matcher(str);
        if (matcher.find()) {
            return new Token(OAuthEncoder.decode(matcher.group(1)), "", str);
        }
        throw new OAuthException("Response body is incorrect. Can't extract a token from this: '" + str + "'", null);
    }
}
