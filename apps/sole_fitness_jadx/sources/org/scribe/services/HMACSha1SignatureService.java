package org.scribe.services;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.Typography;
import org.scribe.exceptions.OAuthSignatureException;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class HMACSha1SignatureService implements SignatureService {
    private static final String CARRIAGE_RETURN = "\r\n";
    private static final String EMPTY_STRING = "";
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static final String METHOD = "HMAC-SHA1";
    private static final String UTF8 = "UTF-8";

    @Override // org.scribe.services.SignatureService
    public String getSignatureMethod() {
        return METHOD;
    }

    @Override // org.scribe.services.SignatureService
    public String getSignature(String str, String str2, String str3) {
        try {
            Preconditions.checkEmptyString(str, "Base string cant be null or empty string");
            Preconditions.checkEmptyString(str2, "Api secret cant be null or empty string");
            return doSign(str, OAuthEncoder.encode(str2) + Typography.amp + OAuthEncoder.encode(str3));
        } catch (Exception e) {
            throw new OAuthSignatureException(str, e);
        }
    }

    private String doSign(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(secretKeySpec);
        return bytesToBase64String(mac.doFinal(str.getBytes("UTF-8"))).replace(CARRIAGE_RETURN, "");
    }

    private String bytesToBase64String(byte[] bArr) {
        return Base64Encoder.getInstance().encode(bArr);
    }
}
