package org.apache.http.impl.execchain;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthState;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

/* loaded from: classes2.dex */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpProcessor httpProcessor, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(httpProcessor, "Proxy HTTP processor");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.proxyHttpProcessor = httpProcessor;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
    }

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler) {
        this(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, new ImmutableHttpProcessor(new RequestTargetHost()), authenticationStrategy, authenticationStrategy2, userTokenHandler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.http.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws HttpException, IOException {
        HttpException httpException;
        ConnectionHolder connectionHolder;
        RuntimeException runtimeException;
        IOException iOException;
        int i;
        int i2;
        ConnectionHolder connectionHolder2;
        HttpClientConnection httpClientConnection;
        Object obj;
        AuthState authState;
        String str;
        HttpResponse response;
        Object userToken;
        AuthState authState2;
        HttpResponse httpResponse;
        String str2;
        HttpRoute httpRoute2 = httpRoute;
        HttpExecutionAware httpExecutionAware2 = httpExecutionAware;
        Args.notNull(httpRoute2, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        AuthState targetAuthState = httpClientContext.getTargetAuthState();
        if (targetAuthState == null) {
            targetAuthState = new AuthState();
            httpClientContext.setAttribute("http.auth.target-scope", targetAuthState);
        }
        AuthState authState3 = targetAuthState;
        AuthState proxyAuthState = httpClientContext.getProxyAuthState();
        if (proxyAuthState == null) {
            proxyAuthState = new AuthState();
            httpClientContext.setAttribute("http.auth.proxy-scope", proxyAuthState);
        }
        AuthState authState4 = proxyAuthState;
        if (httpRequestWrapper instanceof HttpEntityEnclosingRequest) {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpRequestWrapper);
        }
        Object userToken2 = httpClientContext.getUserToken();
        ConnectionRequest connectionRequestRequestConnection = this.connManager.requestConnection(httpRoute2, userToken2);
        String str3 = "Request aborted";
        if (httpExecutionAware2 != null) {
            if (httpExecutionAware.isAborted()) {
                connectionRequestRequestConnection.cancel();
                throw new RequestAbortedException("Request aborted");
            }
            httpExecutionAware2.setCancellable(connectionRequestRequestConnection);
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        try {
            int connectionRequestTimeout = requestConfig.getConnectionRequestTimeout();
            HttpClientConnection httpClientConnection2 = connectionRequestRequestConnection.get(connectionRequestTimeout > 0 ? connectionRequestTimeout : 0L, TimeUnit.MILLISECONDS);
            httpClientContext.setAttribute("http.connection", httpClientConnection2);
            if (requestConfig.isStaleConnectionCheckEnabled() && httpClientConnection2.isOpen()) {
                this.log.debug("Stale connection check");
                if (httpClientConnection2.isStale()) {
                    this.log.debug("Stale connection detected");
                    httpClientConnection2.close();
                }
            }
            ConnectionHolder connectionHolder3 = new ConnectionHolder(this.log, this.connManager, httpClientConnection2);
            if (httpExecutionAware2 != null) {
                try {
                    try {
                        httpExecutionAware2.setCancellable(connectionHolder3);
                    } catch (ConnectionShutdownException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                        interruptedIOException.initCause(e);
                        throw interruptedIOException;
                    }
                } catch (IOException e2) {
                    iOException = e2;
                    connectionHolder = connectionHolder3;
                    connectionHolder.abortConnection();
                    throw iOException;
                } catch (RuntimeException e3) {
                    runtimeException = e3;
                    connectionHolder = connectionHolder3;
                    connectionHolder.abortConnection();
                    throw runtimeException;
                } catch (HttpException e4) {
                    httpException = e4;
                    connectionHolder = connectionHolder3;
                    connectionHolder.abortConnection();
                    throw httpException;
                }
            }
            int i3 = 1;
            int i4 = 1;
            while (true) {
                if (i4 > i3 && !RequestEntityProxy.isRepeatable(httpRequestWrapper)) {
                    throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
                }
                if (httpExecutionAware2 != null && httpExecutionAware.isAborted()) {
                    throw new RequestAbortedException(str3);
                }
                try {
                    if (httpClientConnection2.isOpen()) {
                        i = i4;
                        i2 = i3;
                        connectionHolder2 = connectionHolder3;
                        httpClientConnection = httpClientConnection2;
                        obj = userToken2;
                        authState = authState4;
                        str = str3;
                    } else {
                        Log log = this.log;
                        i = i4;
                        StringBuilder sb = new StringBuilder();
                        connectionHolder2 = connectionHolder3;
                        try {
                            sb.append("Opening connection ");
                            sb.append(httpRoute2);
                            log.debug(sb.toString());
                            i2 = 1;
                            AuthState authState5 = authState4;
                            httpClientConnection = httpClientConnection2;
                            authState = authState4;
                            str = str3;
                            obj = userToken2;
                            try {
                                establishRoute(authState5, httpClientConnection2, httpRoute, httpRequestWrapper, httpClientContext);
                            } catch (TunnelRefusedException e5) {
                                if (this.log.isDebugEnabled()) {
                                    this.log.debug(e5.getMessage());
                                }
                                response = e5.getResponse();
                                connectionHolder = connectionHolder2;
                            }
                        } catch (IOException e6) {
                            iOException = e6;
                            connectionHolder = connectionHolder2;
                            connectionHolder.abortConnection();
                            throw iOException;
                        } catch (RuntimeException e7) {
                            runtimeException = e7;
                            connectionHolder = connectionHolder2;
                            connectionHolder.abortConnection();
                            throw runtimeException;
                        } catch (HttpException e8) {
                            httpException = e8;
                            connectionHolder = connectionHolder2;
                            connectionHolder.abortConnection();
                            throw httpException;
                        }
                    }
                    try {
                        int socketTimeout = requestConfig.getSocketTimeout();
                        if (socketTimeout >= 0) {
                            httpClientConnection.setSocketTimeout(socketTimeout);
                        }
                        if (httpExecutionAware2 != null && httpExecutionAware.isAborted()) {
                            throw new RequestAbortedException(str);
                        }
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Executing request " + httpRequestWrapper.getRequestLine());
                        }
                        if (!httpRequestWrapper.containsHeader("Authorization")) {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug("Target auth state: " + authState3.getState());
                            }
                            this.authenticator.generateAuthResponse(httpRequestWrapper, authState3, httpClientContext);
                        }
                        if (httpRequestWrapper.containsHeader("Proxy-Authorization") || httpRoute.isTunnelled()) {
                            authState2 = authState;
                        } else {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug("Proxy auth state: " + authState.getState());
                            }
                            authState2 = authState;
                            this.authenticator.generateAuthResponse(httpRequestWrapper, authState2, httpClientContext);
                        }
                        HttpResponse httpResponseExecute = this.requestExecutor.execute(httpRequestWrapper, httpClientConnection, httpClientContext);
                        if (this.reuseStrategy.keepAlive(httpResponseExecute, httpClientContext)) {
                            long keepAliveDuration = this.keepAliveStrategy.getKeepAliveDuration(httpResponseExecute, httpClientContext);
                            if (this.log.isDebugEnabled()) {
                                if (keepAliveDuration > 0) {
                                    str2 = "for " + keepAliveDuration + StringUtils.SPACE + TimeUnit.MILLISECONDS;
                                } else {
                                    str2 = "indefinitely";
                                }
                                httpResponse = httpResponseExecute;
                                this.log.debug("Connection can be kept alive " + str2);
                            } else {
                                httpResponse = httpResponseExecute;
                            }
                            connectionHolder = connectionHolder2;
                            try {
                                connectionHolder.setValidFor(keepAliveDuration, TimeUnit.MILLISECONDS);
                                connectionHolder.markReusable();
                            } catch (IOException e9) {
                                e = e9;
                                iOException = e;
                                connectionHolder.abortConnection();
                                throw iOException;
                            } catch (RuntimeException e10) {
                                e = e10;
                                runtimeException = e;
                                connectionHolder.abortConnection();
                                throw runtimeException;
                            } catch (HttpException e11) {
                                e = e11;
                                httpException = e;
                                connectionHolder.abortConnection();
                                throw httpException;
                            }
                        } else {
                            httpResponse = httpResponseExecute;
                            connectionHolder = connectionHolder2;
                            connectionHolder.markNonReusable();
                        }
                        HttpResponse httpResponse2 = httpResponse;
                        AuthState authState6 = authState2;
                        if (!needAuthentication(authState3, authState2, httpRoute, httpResponse2, httpClientContext)) {
                            response = httpResponse2;
                            break;
                        }
                        HttpEntity entity = httpResponse2.getEntity();
                        if (connectionHolder.isReusable()) {
                            EntityUtils.consume(entity);
                        } else {
                            httpClientConnection.close();
                            if (authState6.getState() == AuthProtocolState.SUCCESS && authState6.getAuthScheme() != null && authState6.getAuthScheme().isConnectionBased()) {
                                this.log.debug("Resetting proxy auth state");
                                authState6.reset();
                            }
                            if (authState3.getState() == AuthProtocolState.SUCCESS && authState3.getAuthScheme() != null && authState3.getAuthScheme().isConnectionBased()) {
                                this.log.debug("Resetting target auth state");
                                authState3.reset();
                            }
                        }
                        HttpRequest original = httpRequestWrapper.getOriginal();
                        if (!original.containsHeader("Authorization")) {
                            httpRequestWrapper.removeHeaders("Authorization");
                        }
                        if (!original.containsHeader("Proxy-Authorization")) {
                            httpRequestWrapper.removeHeaders("Proxy-Authorization");
                        }
                        i4 = i + 1;
                        httpClientConnection2 = httpClientConnection;
                        connectionHolder3 = connectionHolder;
                        str3 = str;
                        i3 = i2;
                        authState4 = authState6;
                        userToken2 = obj;
                        httpRoute2 = httpRoute;
                        httpExecutionAware2 = httpExecutionAware;
                    } catch (IOException e12) {
                        e = e12;
                        connectionHolder = connectionHolder2;
                    } catch (RuntimeException e13) {
                        e = e13;
                        connectionHolder = connectionHolder2;
                    } catch (HttpException e14) {
                        e = e14;
                        connectionHolder = connectionHolder2;
                    }
                } catch (IOException e15) {
                    e = e15;
                    connectionHolder = connectionHolder3;
                } catch (RuntimeException e16) {
                    e = e16;
                    connectionHolder = connectionHolder3;
                } catch (HttpException e17) {
                    e = e17;
                    connectionHolder = connectionHolder3;
                }
            }
            if (obj == null) {
                userToken = this.userTokenHandler.getUserToken(httpClientContext);
                httpClientContext.setAttribute("http.user-token", userToken);
            } else {
                userToken = obj;
            }
            if (userToken != null) {
                connectionHolder.setState(userToken);
            }
            HttpEntity entity2 = response.getEntity();
            if (entity2 != null && entity2.isStreaming()) {
                return new HttpResponseProxy(response, connectionHolder);
            }
            connectionHolder.releaseConnection();
            return new HttpResponseProxy(response, null);
        } catch (InterruptedException e18) {
            Thread.currentThread().interrupt();
            throw new RequestAbortedException("Request aborted", e18);
        } catch (ExecutionException e19) {
            ExecutionException executionException = e19;
            Throwable cause = executionException.getCause();
            if (cause != null) {
                executionException = cause;
            }
            throw new RequestAbortedException("Request execution failed", executionException);
        }
    }

    void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        int iNextStep;
        int connectTimeout = httpClientContext.getRequestConfig().getConnectTimeout();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        do {
            HttpRoute route = routeTracker.toRoute();
            iNextStep = this.routeDirector.nextStep(httpRoute, route);
            switch (iNextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    this.connManager.routeComplete(httpClientConnection, httpRoute, httpClientContext);
                    break;
                case 1:
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                    routeTracker.connectTarget(httpRoute.isSecure());
                    break;
                case 2:
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                    routeTracker.connectProxy(httpRoute.getProxyHost(), false);
                    break;
                case 3:
                    boolean zCreateTunnelToTarget = createTunnelToTarget(authState, httpClientConnection, httpRoute, httpRequest, httpClientContext);
                    this.log.debug("Tunnel to target created.");
                    routeTracker.tunnelTarget(zCreateTunnelToTarget);
                    break;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean zCreateTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpClientContext);
                    this.log.debug("Tunnel to proxy created.");
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), zCreateTunnelToProxy);
                    break;
                case 5:
                    this.connManager.upgrade(httpClientConnection, httpRoute, httpClientContext);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    break;
                default:
                    throw new IllegalStateException("Unknown step indicator " + iNextStep + " from RouteDirector.");
            }
        } while (iNextStep > 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0093, code lost:
    
        if (r16.reuseStrategy.keepAlive(r7, r21) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0095, code lost:
    
        r16.log.debug("Connection kept alive");
        org.apache.http.util.EntityUtils.consume(r7.getEntity());
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a4, code lost:
    
        r18.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean createTunnelToTarget(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        HttpResponse httpResponse;
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int connectTimeout = requestConfig.getConnectTimeout();
        HttpHost targetHost = httpRoute.getTargetHost();
        HttpHost proxyHost = httpRoute.getProxyHost();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", targetHost.toHostString(), httpRequest.getProtocolVersion());
        this.requestExecutor.preProcess(basicHttpRequest, this.proxyHttpProcessor, httpClientContext);
        while (true) {
            HttpResponse httpResponse2 = null;
            while (true) {
                if (httpResponse2 == null) {
                    if (!httpClientConnection.isOpen()) {
                        this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                    }
                    basicHttpRequest.removeHeaders("Proxy-Authorization");
                    this.authenticator.generateAuthResponse(basicHttpRequest, authState, httpClientContext);
                    HttpResponse httpResponseExecute = this.requestExecutor.execute(basicHttpRequest, httpClientConnection, httpClientContext);
                    if (httpResponseExecute.getStatusLine().getStatusCode() < 200) {
                        throw new HttpException("Unexpected response to CONNECT request: " + httpResponseExecute.getStatusLine());
                    }
                    if (!requestConfig.isAuthenticationEnabled()) {
                        httpResponse = httpResponseExecute;
                    } else {
                        if (this.authenticator.isAuthenticationRequested(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState, httpClientContext) && this.authenticator.handleAuthChallenge(proxyHost, httpResponseExecute, this.proxyAuthStrategy, authState, httpClientContext)) {
                            break;
                        }
                        httpResponse = httpResponseExecute;
                    }
                    httpResponse2 = httpResponse;
                } else {
                    if (httpResponse2.getStatusLine().getStatusCode() <= 299) {
                        return false;
                    }
                    HttpEntity entity = httpResponse2.getEntity();
                    if (entity != null) {
                        httpResponse2.setEntity(new BufferedHttpEntity(entity));
                    }
                    httpClientConnection.close();
                    throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse2.getStatusLine(), httpResponse2);
                }
            }
        }
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        if (targetHost.getPort() < 0) {
            targetHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
        }
        boolean zIsAuthenticationRequested = this.authenticator.isAuthenticationRequested(targetHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        boolean zIsAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(proxyHost, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        if (zIsAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(targetHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        }
        if (!zIsAuthenticationRequested2) {
            return false;
        }
        return this.authenticator.handleAuthChallenge(proxyHost, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
    }
}
