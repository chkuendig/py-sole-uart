package com.ua.sdk.user.permission;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityRef;
import com.ua.sdk.NetworkError;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;

/* loaded from: classes2.dex */
public class UserPermissionService {
    private final AuthenticationManager authManager;
    private final ConnectionFactory connFactory;
    private final JsonParser<? extends EntityList<UserPermission>> jsonPageParser;
    private final UrlBuilder urlBuilder;

    public UserPermissionService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<? extends EntityList<UserPermission>> jsonParser) {
        this.connFactory = connectionFactory;
        this.authManager = authenticationManager;
        this.urlBuilder = urlBuilder;
        this.jsonPageParser = jsonParser;
    }

    public EntityList<UserPermission> fetchUserPermission(EntityRef entityRef) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetUserPermissionUrl(entityRef));
            try {
                this.authManager.sign(sslConnection, AuthenticationManager.AuthenticationType.USER);
                sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                sslConnection.setDoOutput(false);
                sslConnection.setUseCaches(false);
                Precondition.isExpectedResponse(sslConnection, 200);
                return this.jsonPageParser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (NetworkError e) {
            if (e.getResponseCode() == 401) {
                throw new UaException(UaException.Code.NOT_AUTHENTICATED, e);
            }
            throw e;
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException unused2) {
            throw new UaException(UaException.Code.UNKNOWN);
        }
    }

    public EntityList<UserPermission> fetchUserPermissions() throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetUserPermissionsUrl(null));
            try {
                this.authManager.sign(sslConnection, AuthenticationManager.AuthenticationType.USER);
                sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                sslConnection.setDoOutput(false);
                sslConnection.setUseCaches(false);
                Precondition.isExpectedResponse(sslConnection, 200);
                return this.jsonPageParser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (NetworkError e) {
            if (e.getResponseCode() == 401) {
                throw new UaException(UaException.Code.NOT_AUTHENTICATED, e);
            }
            throw e;
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException unused2) {
            throw new UaException(UaException.Code.UNKNOWN);
        }
    }
}
