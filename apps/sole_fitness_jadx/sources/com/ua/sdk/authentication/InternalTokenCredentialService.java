package com.ua.sdk.authentication;

import com.ua.sdk.UaException;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class InternalTokenCredentialService {
    private AuthenticationManager authManager;
    private ConnectionFactory connFactory;
    private JsonWriter<InternalTokenCredential> internalTokenCredentialWriter;
    private JsonParser<OAuth2Credentials> oauth2Parser;
    private UrlBuilder urlBuilder;

    public void init(ConnectionFactory connectionFactory, UrlBuilder urlBuilder, AuthenticationManager authenticationManager, JsonParser<OAuth2Credentials> jsonParser, JsonWriter<InternalTokenCredential> jsonWriter) {
        this.connFactory = connectionFactory;
        this.urlBuilder = urlBuilder;
        this.authManager = authenticationManager;
        this.oauth2Parser = jsonParser;
        this.internalTokenCredentialWriter = jsonWriter;
    }

    public OAuth2Credentials save(InternalTokenCredential internalTokenCredential, boolean z) throws UaException, NullPointerException {
        Precondition.isNotNull(internalTokenCredential, "internalTokenCredential");
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildCreateInternalTokenCredentialUrl());
            try {
                if (z) {
                    this.authManager.signAsUser(sslConnection);
                } else {
                    this.authManager.signAsClient(sslConnection);
                }
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                this.internalTokenCredentialWriter.write(internalTokenCredential, sslConnection.getOutputStream());
                Precondition.isResponseSuccess(sslConnection);
                return this.oauth2Parser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (IOException e2) {
            throw new UaException(UaException.Code.UNKNOWN, e2);
        }
    }
}
