package org.scribe.services;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import org.scribe.exceptions.OAuthSignatureException;

/* loaded from: classes2.dex */
public class RSASha1SignatureService implements SignatureService {
    private static final String METHOD = "RSA-SHA1";
    private static final String RSA_SHA1 = "SHA1withRSA";
    private static final String UTF8 = "UTF-8";
    private PrivateKey privateKey;

    @Override // org.scribe.services.SignatureService
    public String getSignatureMethod() {
        return METHOD;
    }

    public RSASha1SignatureService(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    @Override // org.scribe.services.SignatureService
    public String getSignature(String str, String str2, String str3) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            Signature signature = Signature.getInstance(RSA_SHA1);
            signature.initSign(this.privateKey);
            signature.update(str.getBytes("UTF-8"));
            return bytesToBase64String(signature);
        } catch (Exception e) {
            throw new OAuthSignatureException(str, e);
        }
    }

    private String bytesToBase64String(Signature signature) throws SignatureException {
        return Base64Encoder.getInstance().encode(signature.sign());
    }
}
