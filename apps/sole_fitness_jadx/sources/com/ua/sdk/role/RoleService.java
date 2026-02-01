package com.ua.sdk.role;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.NetworkError;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpGet;

/* loaded from: classes2.dex */
public class RoleService implements EntityService<Role> {
    private final AuthenticationManager authManager;
    private final ConnectionFactory connFactory;
    private final JsonParser<? extends EntityList<Role>> jsonPageParser;
    private final JsonParser<Role> jsonParser;
    private final UrlBuilder urlBuilder;

    public RoleService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<Role> jsonParser, JsonParser<? extends EntityList<Role>> jsonParser2) {
        this.connFactory = connectionFactory;
        this.authManager = authenticationManager;
        this.urlBuilder = urlBuilder;
        this.jsonParser = jsonParser;
        this.jsonPageParser = jsonParser2;
    }

    @Override // com.ua.sdk.internal.EntityService
    public Role create(Role role) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public Role fetch(Reference reference) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetRoleUrl(reference));
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
    public Role save(Role role) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public void delete(Reference reference) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public Role patch(Role role, Reference reference) throws UaException {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.EntityService
    public EntityList<Role> fetchPage(EntityListRef<Role> entityListRef) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetRolesUrl(null));
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
