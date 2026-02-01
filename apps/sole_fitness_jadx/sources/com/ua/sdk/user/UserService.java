package com.ua.sdk.user;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import com.ua.sdk.util.Streams;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class UserService extends AbstractResourceService<User> {
    public UserService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<User> jsonParser, JsonWriter<User> jsonWriter, JsonParser<EntityList<User>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreateUserUrl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public AuthenticationManager.AuthenticationType getCreateAuthenticationType() {
        return AuthenticationManager.AuthenticationType.CLIENT;
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        if (reference instanceof CurrentUserRef) {
            return this.urlBuilder.buildGetCurrentUserUrl();
        }
        return this.urlBuilder.buildGetUserUrl(reference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(User user) {
        return this.urlBuilder.buildSaveUserUrl(user.getRef());
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("User patch is not supported.");
    }

    public void resetPassword(String str) throws UaException, NullPointerException {
        Precondition.isNotNull(str);
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildResetPasswordUrl());
            try {
                this.authManager.signAsClient(sslConnection);
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                sslConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                sslConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
                Streams.writeFully("{\"email\":\"" + str + "\"}", sslConnection.getOutputStream());
                Precondition.isResponseSuccess(sslConnection);
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException unused) {
            throw new UaException(UaException.Code.CANCELED);
        } catch (IOException unused2) {
            throw new UaException(UaException.Code.UNKNOWN);
        }
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<User> entityListRef) {
        return this.urlBuilder.buildGetUserPageUrl(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("User delete is not supported.");
    }
}
