package org.scribe.services;

import kotlin.text.Typography;
import org.scribe.exceptions.OAuthSignatureException;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class PlaintextSignatureService implements SignatureService {
    private static final String METHOD = "PLAINTEXT";

    @Override // org.scribe.services.SignatureService
    public String getSignatureMethod() {
        return METHOD;
    }

    @Override // org.scribe.services.SignatureService
    public String getSignature(String str, String str2, String str3) {
        try {
            Preconditions.checkEmptyString(str2, "Api secret cant be null or empty string");
            return OAuthEncoder.encode(str2) + Typography.amp + OAuthEncoder.encode(str3);
        } catch (Exception e) {
            throw new OAuthSignatureException(str, e);
        }
    }
}
