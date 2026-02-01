package org.scribe.services;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;
import org.scribe.exceptions.OAuthSignatureException;

/* loaded from: classes2.dex */
public class CommonsEncoder extends Base64Encoder {
    @Override // org.scribe.services.Base64Encoder
    public String getType() {
        return "CommonsCodec";
    }

    @Override // org.scribe.services.Base64Encoder
    public String encode(byte[] bArr) {
        try {
            return new String(Base64.encodeBase64(bArr), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new OAuthSignatureException("Can't perform base64 encoding", e);
        }
    }

    public static boolean isPresent() throws ClassNotFoundException {
        try {
            Class.forName("org.apache.commons.codec.binary.Base64");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
