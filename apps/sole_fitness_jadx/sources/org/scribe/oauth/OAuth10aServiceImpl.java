package org.scribe.oauth;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Request;
import org.scribe.model.RequestTuner;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.services.Base64Encoder;
import org.scribe.utils.MapUtils;

/* loaded from: classes2.dex */
public class OAuth10aServiceImpl implements OAuthService {
    private static final String VERSION = "1.0";
    private DefaultApi10a api;
    private OAuthConfig config;

    @Override // org.scribe.oauth.OAuthService
    public String getVersion() {
        return "1.0";
    }

    public OAuth10aServiceImpl(DefaultApi10a defaultApi10a, OAuthConfig oAuthConfig) {
        this.api = defaultApi10a;
        this.config = oAuthConfig;
    }

    public Token getRequestToken(int i, TimeUnit timeUnit) {
        return getRequestToken(new TimeoutTuner(i, timeUnit));
    }

    @Override // org.scribe.oauth.OAuthService
    public Token getRequestToken() {
        return getRequestToken(2, TimeUnit.SECONDS);
    }

    public Token getRequestToken(RequestTuner requestTuner) throws IOException {
        this.config.log("obtaining request token from " + this.api.getRequestTokenEndpoint());
        OAuthRequest oAuthRequest = new OAuthRequest(this.api.getRequestTokenVerb(), this.api.getRequestTokenEndpoint());
        this.config.log("setting oauth_callback to " + this.config.getCallback());
        oAuthRequest.addOAuthParameter(OAuthConstants.CALLBACK, this.config.getCallback());
        addOAuthParams(oAuthRequest, OAuthConstants.EMPTY_TOKEN);
        appendSignature(oAuthRequest);
        this.config.log("sending request...");
        Response responseSend = oAuthRequest.send(requestTuner);
        String body = responseSend.getBody();
        this.config.log("response status code: " + responseSend.getCode());
        this.config.log("response body: " + body);
        return this.api.getRequestTokenExtractor().extract(body);
    }

    private void addOAuthParams(OAuthRequest oAuthRequest, Token token) throws IOException {
        oAuthRequest.addOAuthParameter(OAuthConstants.TIMESTAMP, this.api.getTimestampService().getTimestampInSeconds());
        oAuthRequest.addOAuthParameter(OAuthConstants.NONCE, this.api.getTimestampService().getNonce());
        oAuthRequest.addOAuthParameter(OAuthConstants.CONSUMER_KEY, this.config.getApiKey());
        oAuthRequest.addOAuthParameter(OAuthConstants.SIGN_METHOD, this.api.getSignatureService().getSignatureMethod());
        oAuthRequest.addOAuthParameter(OAuthConstants.VERSION, getVersion());
        if (this.config.hasScope()) {
            oAuthRequest.addOAuthParameter("scope", this.config.getScope());
        }
        oAuthRequest.addOAuthParameter(OAuthConstants.SIGNATURE, getSignature(oAuthRequest, token));
        this.config.log("appended additional OAuth parameters: " + MapUtils.toString(oAuthRequest.getOauthParameters()));
    }

    public Token getAccessToken(Token token, Verifier verifier, int i, TimeUnit timeUnit) {
        return getAccessToken(token, verifier, new TimeoutTuner(i, timeUnit));
    }

    @Override // org.scribe.oauth.OAuthService
    public Token getAccessToken(Token token, Verifier verifier) {
        return getAccessToken(token, verifier, 2, TimeUnit.SECONDS);
    }

    public Token getAccessToken(Token token, Verifier verifier, RequestTuner requestTuner) throws IOException {
        this.config.log("obtaining access token from " + this.api.getAccessTokenEndpoint());
        OAuthRequest oAuthRequest = new OAuthRequest(this.api.getAccessTokenVerb(), this.api.getAccessTokenEndpoint());
        oAuthRequest.addOAuthParameter(OAuthConstants.TOKEN, token.getToken());
        oAuthRequest.addOAuthParameter(OAuthConstants.VERIFIER, verifier.getValue());
        this.config.log("setting token to: " + token + " and verifier to: " + verifier);
        addOAuthParams(oAuthRequest, token);
        appendSignature(oAuthRequest);
        return this.api.getAccessTokenExtractor().extract(oAuthRequest.send(requestTuner).getBody());
    }

    @Override // org.scribe.oauth.OAuthService
    public void signRequest(Token token, OAuthRequest oAuthRequest) throws IOException {
        this.config.log("signing request: " + oAuthRequest.getCompleteUrl());
        if (!token.isEmpty()) {
            oAuthRequest.addOAuthParameter(OAuthConstants.TOKEN, token.getToken());
        }
        this.config.log("setting token to: " + token);
        addOAuthParams(oAuthRequest, token);
        appendSignature(oAuthRequest);
    }

    @Override // org.scribe.oauth.OAuthService
    public String getAuthorizationUrl(Token token) {
        return this.api.getAuthorizationUrl(token);
    }

    private String getSignature(OAuthRequest oAuthRequest, Token token) throws IOException {
        this.config.log("generating signature...");
        this.config.log("using base64 encoder: " + Base64Encoder.type());
        String strExtract = this.api.getBaseStringExtractor().extract(oAuthRequest);
        String signature = this.api.getSignatureService().getSignature(strExtract, this.config.getApiSecret(), token.getSecret());
        this.config.log("base string is: " + strExtract);
        this.config.log("signature is: " + signature);
        return signature;
    }

    /* renamed from: org.scribe.oauth.OAuth10aServiceImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$scribe$model$SignatureType;

        static {
            int[] iArr = new int[SignatureType.values().length];
            $SwitchMap$org$scribe$model$SignatureType = iArr;
            try {
                iArr[SignatureType.Header.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$scribe$model$SignatureType[SignatureType.QueryString.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void appendSignature(OAuthRequest oAuthRequest) throws IOException {
        int i = AnonymousClass1.$SwitchMap$org$scribe$model$SignatureType[this.config.getSignatureType().ordinal()];
        if (i == 1) {
            this.config.log("using Http Header signature");
            oAuthRequest.addHeader("Authorization", this.api.getHeaderExtractor().extract(oAuthRequest));
        } else {
            if (i != 2) {
                return;
            }
            this.config.log("using Querystring signature");
            for (Map.Entry<String, String> entry : oAuthRequest.getOauthParameters().entrySet()) {
                oAuthRequest.addQuerystringParameter(entry.getKey(), entry.getValue());
            }
        }
    }

    private static class TimeoutTuner extends RequestTuner {
        private final int duration;
        private final TimeUnit unit;

        public TimeoutTuner(int i, TimeUnit timeUnit) {
            this.duration = i;
            this.unit = timeUnit;
        }

        @Override // org.scribe.model.RequestTuner
        public void tune(Request request) {
            request.setReadTimeout(this.duration, this.unit);
        }
    }
}
