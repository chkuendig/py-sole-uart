package com.ua.sdk.gear.user;

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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class UserGearService implements EntityService<UserGear> {
    AuthenticationManager authenticationManager;
    ConnectionFactory connectionFactory;
    JsonParser<UserGear> jsonParser;
    JsonWriter<UserGear> jsonWriter;
    JsonParser<EntityList<UserGear>> listJsonParser;
    UrlBuilder urlBuilder;

    @Override // com.ua.sdk.internal.EntityService
    public UserGear fetch(Reference reference) throws UaException {
        return null;
    }

    @Override // com.ua.sdk.internal.EntityService
    public UserGear save(UserGear userGear) throws UaException {
        return null;
    }

    public UserGearService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<EntityList<UserGear>> jsonParser, JsonParser<UserGear> jsonParser2, JsonWriter<UserGear> jsonWriter) {
        this.connectionFactory = connectionFactory;
        this.authenticationManager = authenticationManager;
        this.urlBuilder = urlBuilder;
        this.listJsonParser = jsonParser;
        this.jsonParser = jsonParser2;
        this.jsonWriter = jsonWriter;
    }

    @Override // com.ua.sdk.internal.EntityService
    public UserGear create(UserGear userGear) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connectionFactory.getSslConnection(this.urlBuilder.buildCreateUserGearUrl());
            Precondition.isAuthenticated(this.authenticationManager);
            try {
                this.authenticationManager.signAsUser(sslConnection);
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                this.jsonWriter.write(userGear, sslConnection.getOutputStream());
                int responseCode = sslConnection.getResponseCode();
                if (responseCode == 201) {
                    return this.jsonParser.parse(sslConnection.getInputStream());
                }
                throw new NetworkError(responseCode, sslConnection);
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (IOException e2) {
            throw new UaException(UaException.Code.UNKNOWN, e2);
        }
    }

    @Override // com.ua.sdk.internal.EntityService
    public void delete(Reference reference) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connectionFactory.getSslConnection(this.urlBuilder.buildDeleteUserGearUrl(reference));
            Precondition.isAuthenticated(this.authenticationManager);
            try {
                this.authenticationManager.signAsUser(sslConnection);
                sslConnection.setRequestMethod(HttpDelete.METHOD_NAME);
                sslConnection.setDoOutput(false);
                sslConnection.setUseCaches(false);
                int responseCode = sslConnection.getResponseCode();
                if (responseCode == 204) {
                } else {
                    throw new NetworkError(responseCode, sslConnection);
                }
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (IOException e2) {
            throw new UaException(UaException.Code.UNKNOWN, e2);
        }
    }

    @Override // com.ua.sdk.internal.EntityService
    public UserGear patch(UserGear userGear, Reference reference) throws UaException {
        try {
            HttpsURLConnection sslConnection = this.connectionFactory.getSslConnection(this.urlBuilder.buildPatchUserGearUrl(reference));
            Precondition.isAuthenticated(this.authenticationManager);
            try {
                this.authenticationManager.signAsUser(sslConnection);
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                sslConnection.addRequestProperty("X-HTTP-Method-Override", HttpPatch.METHOD_NAME);
                this.jsonWriter.write(userGear, sslConnection.getOutputStream());
                int responseCode = sslConnection.getResponseCode();
                if (responseCode == 200) {
                    return this.jsonParser.parse(sslConnection.getInputStream());
                }
                throw new NetworkError(responseCode, sslConnection);
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (IOException e2) {
            throw new UaException(UaException.Code.UNKNOWN, e2);
        }
    }

    @Override // com.ua.sdk.internal.EntityService
    public EntityList<UserGear> fetchPage(EntityListRef<UserGear> entityListRef) throws UaException {
        try {
            if (entityListRef != null) {
                Precondition.isAuthenticated(this.authenticationManager);
                HttpsURLConnection sslConnection = this.connectionFactory.getSslConnection(this.urlBuilder.buildGetUserGearUrl(entityListRef));
                Precondition.isAuthenticated(this.authenticationManager);
                try {
                    this.authenticationManager.signAsUser(sslConnection);
                    sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                    sslConnection.setDoOutput(false);
                    sslConnection.setUseCaches(false);
                    int responseCode = sslConnection.getResponseCode();
                    if (responseCode == 200) {
                        return this.listJsonParser.parse(sslConnection.getInputStream());
                    }
                    throw new NetworkError(responseCode, sslConnection);
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
