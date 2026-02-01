package org.scribe.extractors;

import org.scribe.exceptions.OAuthParametersMissingException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.ParameterList;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class BaseStringExtractorImpl implements BaseStringExtractor {
    private static final String AMPERSAND_SEPARATED_STRING = "%s&%s&%s";

    @Override // org.scribe.extractors.BaseStringExtractor
    public String extract(OAuthRequest oAuthRequest) {
        checkPreconditions(oAuthRequest);
        return String.format(AMPERSAND_SEPARATED_STRING, OAuthEncoder.encode(oAuthRequest.getVerb().name()), OAuthEncoder.encode(oAuthRequest.getSanitizedUrl()), getSortedAndEncodedParams(oAuthRequest));
    }

    private String getSortedAndEncodedParams(OAuthRequest oAuthRequest) {
        ParameterList parameterList = new ParameterList();
        parameterList.addAll(oAuthRequest.getQueryStringParams());
        parameterList.addAll(oAuthRequest.getBodyParams());
        parameterList.addAll(new ParameterList(oAuthRequest.getOauthParameters()));
        return parameterList.sort().asOauthBaseString();
    }

    private void checkPreconditions(OAuthRequest oAuthRequest) {
        Preconditions.checkNotNull(oAuthRequest, "Cannot extract base string from null object");
        if (oAuthRequest.getOauthParameters() == null || oAuthRequest.getOauthParameters().size() <= 0) {
            throw new OAuthParametersMissingException(oAuthRequest);
        }
    }
}
