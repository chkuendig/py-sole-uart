package org.scribe.model;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class OAuthConfig {
    private final String apiKey;
    private final String apiSecret;
    private final String callback;
    private final OutputStream debugStream;
    private final String scope;
    private final SignatureType signatureType;

    public OAuthConfig(String str, String str2) {
        this(str, str2, null, null, null, null);
    }

    public OAuthConfig(String str, String str2, String str3, SignatureType signatureType, String str4, OutputStream outputStream) {
        this.apiKey = str;
        this.apiSecret = str2;
        this.callback = str3;
        this.signatureType = signatureType;
        this.scope = str4;
        this.debugStream = outputStream;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApiSecret() {
        return this.apiSecret;
    }

    public String getCallback() {
        return this.callback;
    }

    public SignatureType getSignatureType() {
        return this.signatureType;
    }

    public String getScope() {
        return this.scope;
    }

    public boolean hasScope() {
        return this.scope != null;
    }

    public void log(String str) throws IOException {
        if (this.debugStream != null) {
            try {
                this.debugStream.write((str + StringUtils.LF).getBytes("UTF8"));
            } catch (Exception e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
