package com.ua.sdk.authentication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import com.ua.sdk.util.Streams;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class AuthenticationServiceImpl implements AuthenticationService {
    private final String clientId;
    private final String clientSecret;
    private final ConnectionFactory connFactory;
    private final Context context;
    private final JsonParser<OAuth2Credentials> oauth2Parser;
    private final UrlBuilder urlBuilder;

    public AuthenticationServiceImpl(String str, String str2, ConnectionFactory connectionFactory, UrlBuilder urlBuilder, JsonParser<OAuth2Credentials> jsonParser, Context context) {
        this.connFactory = (ConnectionFactory) Precondition.isNotNull(connectionFactory);
        this.urlBuilder = (UrlBuilder) Precondition.isNotNull(urlBuilder);
        this.oauth2Parser = (JsonParser) Precondition.isNotNull(jsonParser);
        this.clientId = (String) Precondition.isNotNull(str);
        this.clientSecret = (String) Precondition.isNotNull(str2);
        this.context = (Context) Precondition.isNotNull(context);
    }

    @Override // com.ua.sdk.authentication.AuthenticationService
    public void requestUserAuthorization(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.urlBuilder.buildOAuth2AuthorizationUrl(this.clientId, str).toString()));
        intent.setFlags(268435456);
        this.context.startActivity(intent);
    }

    @Override // com.ua.sdk.authentication.AuthenticationService
    public String getUserAuthorizationUrl(String str) {
        return this.urlBuilder.buildOAuth2AuthorizationUrl(this.clientId, str).toString();
    }

    @Override // com.ua.sdk.authentication.AuthenticationService
    public OAuth2Credentials authenticateUser(CharSequence charSequence, CharSequence charSequence2) throws UaException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=password");
            sb.append("&client_id=");
            sb.append(this.clientId);
            sb.append("&client_secret=");
            sb.append(this.clientSecret);
            sb.append("&username=");
            sb.append(URLEncoder.encode(charSequence.toString(), "UTF-8"));
            sb.append("&password=");
            sb.append(URLEncoder.encode(charSequence2.toString(), "UTF-8"));
            return requestToken(sb);
        } catch (UnsupportedEncodingException unused) {
            throw new UaException();
        }
    }

    @Override // com.ua.sdk.authentication.AuthenticationService
    public OAuth2Credentials authenticateUser(String str) throws UaException {
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=authorization_code");
        sb.append("&client_id=");
        sb.append(this.clientId);
        sb.append("&client_secret=");
        sb.append(this.clientSecret);
        sb.append("&code=");
        sb.append(str);
        return requestToken(sb);
    }

    @Override // com.ua.sdk.authentication.AuthenticationService
    public OAuth2Credentials authenticateClient() throws UaException {
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=client_credentials");
        sb.append("&client_id=");
        sb.append(this.clientId);
        sb.append("&client_secret=");
        sb.append(this.clientSecret);
        return requestToken(sb);
    }

    @Override // com.ua.sdk.authentication.AuthenticationService
    public OAuth2Credentials refreshAuthentication(OAuth2Credentials oAuth2Credentials) throws UaException {
        StringBuilder sb = new StringBuilder();
        sb.append("grant_type=refresh_token");
        sb.append("&client_id=");
        sb.append(this.clientId);
        sb.append("&client_secret=");
        sb.append(this.clientSecret);
        sb.append("&refresh_token=");
        sb.append(oAuth2Credentials.getRefreshToken());
        return requestToken(sb);
    }

    private OAuth2Credentials requestToken(CharSequence charSequence) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetAuthenticationToken());
            try {
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                sslConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                Streams.writeFully(charSequence, sslConnection.getOutputStream());
                Precondition.isResponseHttpOk(sslConnection);
                return this.oauth2Parser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (UaException e) {
            throw e;
        } catch (InterruptedIOException e2) {
            throw new UaException(UaException.Code.CANCELED, e2);
        } catch (Throwable th) {
            throw new UaException(th);
        }
    }
}
