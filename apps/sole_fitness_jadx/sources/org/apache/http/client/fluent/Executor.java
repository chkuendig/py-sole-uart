package org.apache.http.client.fluent;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLInitializationException;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;

/* loaded from: classes2.dex */
public class Executor {
    static final HttpClient CLIENT;
    static final PoolingHttpClientConnectionManager CONNMGR;
    private volatile AuthCache authCache = new BasicAuthCache();
    private volatile CookieStore cookieStore;
    private volatile CredentialsProvider credentialsProvider;
    private final HttpClient httpclient;

    @Deprecated
    public static void registerScheme(Scheme scheme) {
    }

    @Deprecated
    public static void unregisterScheme(String str) {
    }

    static {
        SSLConnectionSocketFactory sSLConnectionSocketFactory = null;
        try {
            try {
                sSLConnectionSocketFactory = SSLConnectionSocketFactory.getSystemSocketFactory();
            } catch (SecurityException | KeyManagementException | NoSuchAlgorithmException unused) {
            }
        } catch (SSLInitializationException unused2) {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            sSLConnectionSocketFactory = new SSLConnectionSocketFactory(sSLContext);
        }
        RegistryBuilder registryBuilderRegister = RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory());
        if (sSLConnectionSocketFactory == null) {
            sSLConnectionSocketFactory = SSLConnectionSocketFactory.getSocketFactory();
        }
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager((Registry<ConnectionSocketFactory>) registryBuilderRegister.register("https", sSLConnectionSocketFactory).build());
        CONNMGR = poolingHttpClientConnectionManager;
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100);
        poolingHttpClientConnectionManager.setMaxTotal(200);
        poolingHttpClientConnectionManager.setValidateAfterInactivity(1000);
        CLIENT = HttpClientBuilder.create().setConnectionManager(poolingHttpClientConnectionManager).build();
    }

    public static Executor newInstance() {
        return new Executor(CLIENT);
    }

    public static Executor newInstance(HttpClient httpClient) {
        if (httpClient == null) {
            httpClient = CLIENT;
        }
        return new Executor(httpClient);
    }

    Executor(HttpClient httpClient) {
        this.httpclient = httpClient;
    }

    public Executor use(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        return this;
    }

    public Executor auth(AuthScope authScope, Credentials credentials) {
        if (this.credentialsProvider == null) {
            this.credentialsProvider = new BasicCredentialsProvider();
        }
        this.credentialsProvider.setCredentials(authScope, credentials);
        return this;
    }

    public Executor auth(HttpHost httpHost, Credentials credentials) {
        return auth(httpHost != null ? new AuthScope(httpHost.getHostName(), httpHost.getPort()) : AuthScope.ANY, credentials);
    }

    public Executor auth(String str, Credentials credentials) {
        return auth(HttpHost.create(str), credentials);
    }

    public Executor authPreemptive(HttpHost httpHost) {
        BasicScheme basicScheme = new BasicScheme();
        try {
            basicScheme.processChallenge(new BasicHeader("WWW-Authenticate", "BASIC "));
        } catch (MalformedChallengeException unused) {
        }
        this.authCache.put(httpHost, basicScheme);
        return this;
    }

    public Executor authPreemptive(String str) {
        return authPreemptive(HttpHost.create(str));
    }

    public Executor authPreemptiveProxy(HttpHost httpHost) {
        BasicScheme basicScheme = new BasicScheme();
        try {
            basicScheme.processChallenge(new BasicHeader("Proxy-Authenticate", "BASIC "));
        } catch (MalformedChallengeException unused) {
        }
        this.authCache.put(httpHost, basicScheme);
        return this;
    }

    public Executor authPreemptiveProxy(String str) {
        return authPreemptiveProxy(HttpHost.create(str));
    }

    public Executor auth(Credentials credentials) {
        return auth(AuthScope.ANY, credentials);
    }

    public Executor auth(String str, String str2) {
        return auth(new UsernamePasswordCredentials(str, str2));
    }

    public Executor auth(String str, String str2, String str3, String str4) {
        return auth(new NTCredentials(str, str2, str3, str4));
    }

    public Executor auth(HttpHost httpHost, String str, String str2) {
        return auth(httpHost, new UsernamePasswordCredentials(str, str2));
    }

    public Executor auth(HttpHost httpHost, String str, String str2, String str3, String str4) {
        return auth(httpHost, new NTCredentials(str, str2, str3, str4));
    }

    public Executor clearAuth() {
        if (this.credentialsProvider != null) {
            this.credentialsProvider.clear();
        }
        return this;
    }

    @Deprecated
    public Executor cookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    public Executor use(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    public Executor clearCookies() {
        if (this.cookieStore != null) {
            this.cookieStore.clear();
        }
        return this;
    }

    public Response execute(Request request) throws IOException {
        HttpClientContext httpClientContextCreate = HttpClientContext.create();
        if (this.credentialsProvider != null) {
            httpClientContextCreate.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
        }
        if (this.authCache != null) {
            httpClientContextCreate.setAttribute("http.auth.auth-cache", this.authCache);
        }
        if (this.cookieStore != null) {
            httpClientContextCreate.setAttribute("http.cookie-store", this.cookieStore);
        }
        return new Response(request.internalExecute(this.httpclient, httpClientContextCreate));
    }

    public static void closeIdleConnections() {
        CONNMGR.closeIdleConnections(0L, TimeUnit.MICROSECONDS);
    }
}
