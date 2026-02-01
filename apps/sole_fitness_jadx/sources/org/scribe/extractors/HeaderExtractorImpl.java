package org.scribe.extractors;

import java.util.Map;
import org.scribe.exceptions.OAuthParametersMissingException;
import org.scribe.model.OAuthRequest;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class HeaderExtractorImpl implements HeaderExtractor {
    public static final int ESTIMATED_PARAM_LENGTH = 20;
    private static final String PARAM_SEPARATOR = ", ";
    private static final String PREAMBLE = "OAuth ";

    @Override // org.scribe.extractors.HeaderExtractor
    public String extract(OAuthRequest oAuthRequest) {
        checkPreconditions(oAuthRequest);
        Map<String, String> oauthParameters = oAuthRequest.getOauthParameters();
        StringBuilder sb = new StringBuilder(oauthParameters.size() * 20);
        sb.append(PREAMBLE);
        for (Map.Entry<String, String> entry : oauthParameters.entrySet()) {
            if (sb.length() > 6) {
                sb.append(PARAM_SEPARATOR);
            }
            sb.append(String.format("%s=\"%s\"", entry.getKey(), OAuthEncoder.encode(entry.getValue())));
        }
        return sb.toString();
    }

    private void checkPreconditions(OAuthRequest oAuthRequest) {
        Preconditions.checkNotNull(oAuthRequest, "Cannot extract a header from a null object");
        if (oAuthRequest.getOauthParameters() == null || oAuthRequest.getOauthParameters().size() <= 0) {
            throw new OAuthParametersMissingException(oAuthRequest);
        }
    }
}
