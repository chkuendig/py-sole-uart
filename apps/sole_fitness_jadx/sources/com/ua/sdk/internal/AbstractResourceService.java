package com.ua.sdk.internal;

import android.os.Build;
import android.os.NetworkOnMainThreadException;
import android.os.SystemClock;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.NetworkError;
import com.ua.sdk.Reference;
import com.ua.sdk.Resource;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URL;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

/* loaded from: classes2.dex */
public abstract class AbstractResourceService<T extends Resource> implements EntityService<T> {
    protected final AuthenticationManager authManager;
    protected final ConnectionFactory connFactory;
    protected final JsonParser<? extends EntityList<T>> jsonPageParser;
    protected final JsonParser<T> jsonParser;
    protected final JsonWriter<T> jsonWriter;
    protected final UrlBuilder urlBuilder;

    protected abstract URL getCreateUrl();

    protected abstract URL getDeleteUrl(Reference reference);

    protected abstract URL getFetchPageUrl(EntityListRef<T> entityListRef);

    protected abstract URL getFetchUrl(Reference reference);

    protected abstract URL getPatchUrl(Reference reference);

    protected abstract URL getSaveUrl(T t);

    public AbstractResourceService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<T> jsonParser, JsonWriter<T> jsonWriter, JsonParser<? extends EntityList<T>> jsonParser2) {
        this.connFactory = (ConnectionFactory) Precondition.isNotNull(connectionFactory);
        this.urlBuilder = (UrlBuilder) Precondition.isNotNull(urlBuilder);
        this.jsonParser = jsonParser;
        this.jsonWriter = jsonWriter;
        this.authManager = authenticationManager;
        this.jsonPageParser = jsonParser2;
    }

    protected final <R> R call(Callable<R> callable) throws UaException {
        return (R) call(callable, true);
    }

    private <R> R call(Callable<R> callable, boolean z) throws UaException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            return callable.call();
        } catch (NetworkError e) {
            if (e.getResponseCode() != 401) {
                throw e;
            }
            if (z) {
                this.authManager.refreshToken(jElapsedRealtime);
                return (R) call(callable, false);
            }
            throw new UaException(UaException.Code.NOT_AUTHENTICATED, e);
        } catch (UaException e2) {
            throw e2;
        } catch (InterruptedIOException e3) {
            throw new UaException(UaException.Code.CANCELED, e3);
        } catch (IOException e4) {
            throw new UaException(UaException.Code.UNKNOWN, e4);
        } catch (Exception e5) {
            if (Build.VERSION.SDK_INT >= 11 && (e5 instanceof NetworkOnMainThreadException)) {
                throw new UaException(UaException.Code.NETWORK_ON_MAIN_THREAD, e5);
            }
            throw new UaException(UaException.Code.UNKNOWN, e5);
        }
    }

    protected final void checkAuthentication(AuthenticationManager.AuthenticationType authenticationType) throws UaException {
        if (authenticationType == AuthenticationManager.AuthenticationType.USER) {
            Precondition.isAuthenticated(this.authManager);
        }
    }

    @Override // com.ua.sdk.internal.EntityService
    public T create(T t) throws UaException {
        try {
            checkAuthentication(getCreateAuthenticationType());
            return (T) call(getCreateCallable(t));
        } catch (UaException e) {
            throw e;
        } catch (Exception e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<T> getCreateCallable(final T t) throws UaException, NullPointerException {
        Precondition.isNotNull(this.jsonWriter, "jsonWriter");
        Precondition.isNotNull(this.jsonParser, "jsonParser");
        return (Callable<T>) new Callable<T>() { // from class: com.ua.sdk.internal.AbstractResourceService.1
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                Precondition.isNotNull(t, "resource");
                HttpsURLConnection sslConnection = AbstractResourceService.this.connFactory.getSslConnection(AbstractResourceService.this.getCreateUrl());
                AbstractResourceService.this.authManager.sign(sslConnection, AbstractResourceService.this.getCreateAuthenticationType());
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                AbstractResourceService.this.jsonWriter.write(t, sslConnection.getOutputStream());
                Precondition.isExpectedResponse(sslConnection, 201);
                return AbstractResourceService.this.jsonParser.parse(sslConnection.getInputStream());
            }
        };
    }

    protected AuthenticationManager.AuthenticationType getCreateAuthenticationType() {
        return AuthenticationManager.AuthenticationType.USER;
    }

    @Override // com.ua.sdk.internal.EntityService
    public T fetch(Reference reference) throws UaException {
        try {
            checkAuthentication(getFetchAuthenticationType());
            return (T) call(getFetchCallable(reference));
        } catch (UaException e) {
            throw e;
        } catch (Exception e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<T> getFetchCallable(final Reference reference) throws UaException, NullPointerException {
        Precondition.isNotNull(this.jsonParser, "jsonParser");
        return (Callable<T>) new Callable<T>() { // from class: com.ua.sdk.internal.AbstractResourceService.2
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                Precondition.isNotNull(reference, "ref");
                HttpsURLConnection sslConnection = AbstractResourceService.this.connFactory.getSslConnection(AbstractResourceService.this.getFetchUrl(reference));
                try {
                    AbstractResourceService.this.authManager.sign(sslConnection, AbstractResourceService.this.getFetchAuthenticationType());
                    sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                    sslConnection.setDoOutput(false);
                    sslConnection.setUseCaches(false);
                    Precondition.isExpectedResponse(sslConnection, 200);
                    return AbstractResourceService.this.jsonParser.parse(sslConnection.getInputStream());
                } finally {
                    sslConnection.disconnect();
                }
            }
        };
    }

    protected AuthenticationManager.AuthenticationType getFetchAuthenticationType() {
        return AuthenticationManager.AuthenticationType.USER;
    }

    @Override // com.ua.sdk.internal.EntityService
    public T save(T t) throws UaException {
        try {
            checkAuthentication(getSaveAuthenticationType());
            return (T) call(getSaveCallable(t));
        } catch (UaException e) {
            throw e;
        } catch (Exception e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<T> getSaveCallable(final T t) throws UaException, NullPointerException {
        Precondition.isNotNull(this.jsonWriter, "jsonWriter");
        Precondition.isNotNull(this.jsonParser, "jsonParser");
        return (Callable<T>) new Callable<T>() { // from class: com.ua.sdk.internal.AbstractResourceService.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                Precondition.isNotNull(t, "resource");
                HttpsURLConnection sslConnection = AbstractResourceService.this.connFactory.getSslConnection(AbstractResourceService.this.getSaveUrl(t));
                try {
                    AbstractResourceService.this.authManager.sign(sslConnection, AbstractResourceService.this.getSaveAuthenticationType());
                    sslConnection.setRequestMethod(HttpPut.METHOD_NAME);
                    sslConnection.setDoOutput(true);
                    sslConnection.setUseCaches(false);
                    AbstractResourceService.this.jsonWriter.write(t, sslConnection.getOutputStream());
                    Precondition.isExpectedResponse(sslConnection, 200);
                    return AbstractResourceService.this.jsonParser.parse(sslConnection.getInputStream());
                } finally {
                    sslConnection.disconnect();
                }
            }
        };
    }

    protected AuthenticationManager.AuthenticationType getSaveAuthenticationType() {
        return AuthenticationManager.AuthenticationType.USER;
    }

    @Override // com.ua.sdk.internal.EntityService
    public void delete(Reference reference) throws UaException {
        try {
            checkAuthentication(getDeleteAuthenticationType());
            call(getDeleteCallable(reference));
        } catch (UaException e) {
            throw e;
        } catch (Exception e2) {
            throw new UaException(e2);
        }
    }

    protected AuthenticationManager.AuthenticationType getDeleteAuthenticationType() {
        return AuthenticationManager.AuthenticationType.USER;
    }

    private Callable<Void> getDeleteCallable(final Reference reference) throws UaException, NullPointerException {
        Precondition.isNotNull(reference, "ref");
        return new Callable<Void>() { // from class: com.ua.sdk.internal.AbstractResourceService.4
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                HttpsURLConnection sslConnection = AbstractResourceService.this.connFactory.getSslConnection(AbstractResourceService.this.getDeleteUrl(reference));
                try {
                    AbstractResourceService.this.authManager.sign(sslConnection, AbstractResourceService.this.getDeleteAuthenticationType());
                    sslConnection.setRequestMethod(HttpDelete.METHOD_NAME);
                    sslConnection.setDoOutput(false);
                    sslConnection.setUseCaches(false);
                    Precondition.isExpectedResponse(sslConnection, 204);
                    sslConnection.disconnect();
                    return null;
                } catch (Throwable th) {
                    sslConnection.disconnect();
                    throw th;
                }
            }
        };
    }

    @Override // com.ua.sdk.internal.EntityService
    public T patch(T t, Reference reference) throws UaException {
        try {
            checkAuthentication(getPatchAuthenticationType());
            return (T) call(getPatchCallable(t, reference));
        } catch (UaException e) {
            throw e;
        } catch (Exception e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<T> getPatchCallable(final T t, final Reference reference) throws UaException, NullPointerException {
        Precondition.isNotNull(this.jsonWriter, "jsonWriter");
        Precondition.isNotNull(this.jsonParser, "jsonParser");
        Precondition.isNotNull(t, "resource");
        return (Callable<T>) new Callable<T>() { // from class: com.ua.sdk.internal.AbstractResourceService.5
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                HttpsURLConnection sslConnection = AbstractResourceService.this.connFactory.getSslConnection(AbstractResourceService.this.getPatchUrl(reference));
                try {
                    AbstractResourceService.this.authManager.sign(sslConnection, AbstractResourceService.this.getPatchAuthenticationType());
                    sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    sslConnection.setDoOutput(true);
                    sslConnection.setUseCaches(false);
                    sslConnection.addRequestProperty("X-HTTP-Method-Override", HttpPatch.METHOD_NAME);
                    AbstractResourceService.this.jsonWriter.write(t, sslConnection.getOutputStream());
                    Precondition.isResponseSuccess(sslConnection);
                    return AbstractResourceService.this.jsonParser.parse(sslConnection.getInputStream());
                } finally {
                    sslConnection.disconnect();
                }
            }
        };
    }

    protected AuthenticationManager.AuthenticationType getPatchAuthenticationType() {
        return AuthenticationManager.AuthenticationType.USER;
    }

    @Override // com.ua.sdk.internal.EntityService
    public EntityList<T> fetchPage(EntityListRef<T> entityListRef) throws UaException {
        try {
            checkAuthentication(getFetchPageAuthenticationType());
            return (EntityList) call(getFetchPageCallable(entityListRef));
        } catch (UaException e) {
            throw e;
        } catch (Exception e2) {
            throw new UaException(e2);
        }
    }

    protected Callable<EntityList<T>> getFetchPageCallable(final EntityListRef<T> entityListRef) throws UaException, NullPointerException {
        Precondition.isNotNull(this.jsonPageParser, "jsonPageParser");
        Precondition.isNotNull(entityListRef, "ref");
        return (Callable<EntityList<T>>) new Callable<EntityList<T>>() { // from class: com.ua.sdk.internal.AbstractResourceService.6
            @Override // java.util.concurrent.Callable
            public EntityList<T> call() throws Exception {
                HttpsURLConnection sslConnection = AbstractResourceService.this.connFactory.getSslConnection(AbstractResourceService.this.getFetchPageUrl(entityListRef));
                try {
                    AbstractResourceService.this.authManager.sign(sslConnection, AbstractResourceService.this.getFetchPageAuthenticationType());
                    sslConnection.setRequestMethod(HttpGet.METHOD_NAME);
                    sslConnection.setDoOutput(false);
                    sslConnection.setUseCaches(false);
                    Precondition.isExpectedResponse(sslConnection, 200);
                    return AbstractResourceService.this.jsonPageParser.parse(sslConnection.getInputStream());
                } finally {
                    sslConnection.disconnect();
                }
            }
        };
    }

    protected AuthenticationManager.AuthenticationType getFetchPageAuthenticationType() {
        return AuthenticationManager.AuthenticationType.USER;
    }
}
