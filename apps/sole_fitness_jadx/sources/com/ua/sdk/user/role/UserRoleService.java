package com.ua.sdk.user.role;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.NetworkError;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class UserRoleService implements EntityService<UserRole> {
    private final AuthenticationManager authManager;
    private final ConnectionFactory connFactory;
    private final JsonParser<UserRole> jsonParser;
    private final JsonWriter<UserRole> jsonWriter;
    private final UrlBuilder urlBuilder;

    public UserRoleService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<UserRole> jsonParser, JsonWriter<UserRole> jsonWriter) {
        this.connFactory = connectionFactory;
        this.authManager = authenticationManager;
        this.urlBuilder = urlBuilder;
        this.jsonParser = jsonParser;
        this.jsonWriter = jsonWriter;
    }

    @Override // com.ua.sdk.internal.EntityService
    public UserRole create(UserRole userRole) throws UaException, NullPointerException {
        Precondition.isNotNull(userRole);
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildCreateUserRoleUrl());
            try {
                this.authManager.sign(sslConnection, AuthenticationManager.AuthenticationType.USER);
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(false);
                sslConnection.setUseCaches(false);
                this.jsonWriter.write(userRole, sslConnection.getOutputStream());
                Precondition.isExpectedResponse(sslConnection, 200);
                return this.jsonParser.parse(sslConnection.getInputStream());
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

    @Override // com.ua.sdk.internal.EntityService
    public UserRole fetch(Reference reference) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetUserRoleUrl(reference));
            try {
                this.authManager.sign(sslConnection, AuthenticationManager.AuthenticationType.USER);
                sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                sslConnection.setDoOutput(false);
                sslConnection.setUseCaches(false);
                Precondition.isExpectedResponse(sslConnection, 200);
                return this.jsonParser.parse(sslConnection.getInputStream());
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

    @Override // com.ua.sdk.internal.EntityService
    public UserRole save(UserRole userRole) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public void delete(Reference reference) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public UserRole patch(UserRole userRole, Reference reference) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public EntityList<UserRole> fetchPage(EntityListRef<UserRole> entityListRef) throws UaException {
        throw new UnsupportedOperationException();
    }
}
