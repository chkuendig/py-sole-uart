package org.scribe.builder;

import java.io.OutputStream;
import org.scribe.builder.api.Api;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.SignatureType;
import org.scribe.oauth.OAuthService;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class ServiceBuilder {
    private Api api;
    private String apiKey;
    private String apiSecret;
    private String scope;
    private String callback = OAuthConstants.OUT_OF_BAND;
    private SignatureType signatureType = SignatureType.Header;
    private OutputStream debugStream = null;

    public ServiceBuilder provider(Class<? extends Api> cls) {
        this.api = createApi(cls);
        return this;
    }

    private Api createApi(Class<? extends Api> cls) {
        Preconditions.checkNotNull(cls, "Api class cannot be null");
        try {
            return cls.newInstance();
        } catch (Exception e) {
            throw new OAuthException("Error while creating the Api object", e);
        }
    }

    public ServiceBuilder provider(Api api) {
        Preconditions.checkNotNull(api, "Api cannot be null");
        this.api = api;
        return this;
    }

    public ServiceBuilder callback(String str) {
        Preconditions.checkNotNull(str, "Callback can't be null");
        this.callback = str;
        return this;
    }

    public ServiceBuilder apiKey(String str) {
        Preconditions.checkEmptyString(str, "Invalid Api key");
        this.apiKey = str;
        return this;
    }

    public ServiceBuilder apiSecret(String str) {
        Preconditions.checkEmptyString(str, "Invalid Api secret");
        this.apiSecret = str;
        return this;
    }

    public ServiceBuilder scope(String str) {
        Preconditions.checkEmptyString(str, "Invalid OAuth scope");
        this.scope = str;
        return this;
    }

    public ServiceBuilder signatureType(SignatureType signatureType) {
        Preconditions.checkNotNull(signatureType, "Signature type can't be null");
        this.signatureType = signatureType;
        return this;
    }

    public ServiceBuilder debugStream(OutputStream outputStream) {
        Preconditions.checkNotNull(outputStream, "debug stream can't be null");
        this.debugStream = outputStream;
        return this;
    }

    public ServiceBuilder debug() {
        debugStream(System.out);
        return this;
    }

    public OAuthService build() {
        Preconditions.checkNotNull(this.api, "You must specify a valid api through the provider() method");
        Preconditions.checkEmptyString(this.apiKey, "You must provide an api key");
        Preconditions.checkEmptyString(this.apiSecret, "You must provide an api secret");
        return this.api.createService(new OAuthConfig(this.apiKey, this.apiSecret, this.callback, this.signatureType, this.scope, this.debugStream));
    }
}
