package com.ua.sdk.authentication;

import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.InterruptedIOException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class FilemobileCredentialService {
    private AuthenticationManager authManager;
    private ConnectionFactory connFactory;
    private JsonParser<FilemobileCredential> jsonParser;
    private UrlBuilder urlBuilder;

    public void init(ConnectionFactory connectionFactory, UrlBuilder urlBuilder, JsonParser<FilemobileCredential> jsonParser, AuthenticationManager authenticationManager) {
        this.connFactory = connectionFactory;
        this.urlBuilder = urlBuilder;
        this.jsonParser = jsonParser;
        this.authManager = authenticationManager;
    }

    public FilemobileCredential fetchCredentials() throws UaException {
        return fetchCredentials(0);
    }

    public FilemobileCredential fetchCredentials(int i) throws UaException {
        if (i > 2) {
            UaLog.debug("Tried fetching Filemobile credentials three(3) times.  Was not able to get a token.");
            throw new UaException("Unable to fetch Filemobile credentials.");
        }
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildCreateFilemobileTokenCredentialUrl());
            try {
                this.authManager.signAsUser(sslConnection);
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                Precondition.isResponseSuccess(sslConnection);
                if (sslConnection.getResponseCode() == 202) {
                    return retryFetchCredentials(i);
                }
                return this.jsonParser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            UaLog.debug("Filemobile fetch credentials cancelled.");
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (Throwable th) {
            UaLog.error("Unable to fetch Filemobile credentials.", th);
            throw new UaException("Unable to fetch Filemobile credentials.", th);
        }
    }

    private FilemobileCredential retryFetchCredentials(int i) throws InterruptedException, UaException {
        UaLog.debug("Retrying in three(3) seconds.");
        Thread.sleep(3000L);
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching Filemobile credentials attempt: ");
        int i2 = i + 1;
        sb.append(i2);
        UaLog.debug(sb.toString());
        return fetchCredentials(i2);
    }
}
