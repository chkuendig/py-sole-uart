package com.ua.sdk.gear;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
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
public class GearService implements EntityService<Gear> {
    private final AuthenticationManager authenticationManager;
    private final ConnectionFactory connectionFactory;
    private final JsonParser<EntityList<Gear>> listJsonParser;
    private final UrlBuilder urlBuilder;

    @Override // com.ua.sdk.internal.EntityService
    public Gear create(Gear gear) throws UaException {
        return null;
    }

    @Override // com.ua.sdk.internal.EntityService
    public void delete(Reference reference) throws UaException {
    }

    @Override // com.ua.sdk.internal.EntityService
    public Gear fetch(Reference reference) throws UaException {
        return null;
    }

    @Override // com.ua.sdk.internal.EntityService
    public Gear patch(Gear gear, Reference reference) throws UaException {
        return null;
    }

    @Override // com.ua.sdk.internal.EntityService
    public Gear save(Gear gear) throws UaException {
        return null;
    }

    public GearService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<EntityList<Gear>> jsonParser) {
        this.connectionFactory = connectionFactory;
        this.authenticationManager = authenticationManager;
        this.urlBuilder = urlBuilder;
        this.listJsonParser = jsonParser;
    }

    @Override // com.ua.sdk.internal.EntityService
    public EntityList<Gear> fetchPage(EntityListRef<Gear> entityListRef) throws UaException {
        try {
            if (entityListRef != null) {
                Precondition.isAuthenticated(this.authenticationManager);
                HttpsURLConnection sslConnection = this.connectionFactory.getSslConnection(this.urlBuilder.buildGetGearUrl(entityListRef));
                try {
                    this.authenticationManager.signAsUser(sslConnection);
                    sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                    sslConnection.setDoOutput(false);
                    sslConnection.setUseCaches(false);
                    Precondition.isResponseHttpOk(sslConnection);
                    return this.listJsonParser.parse(sslConnection.getInputStream());
                } finally {
                    sslConnection.disconnect();
                }
            }
            throw new UaException("The ref must not be null!");
        } catch (InterruptedIOException e) {
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (IOException e2) {
            throw new UaException(UaException.Code.UNKNOWN, e2);
        }
    }
}
