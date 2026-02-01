package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionOperator;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* loaded from: classes2.dex */
public class DefaultHttpClientConnectionOperator implements HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final DnsResolver dnsResolver;
    private final Log log = LogFactory.getLog(getClass());
    private final SchemePortResolver schemePortResolver;
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;

    public DefaultHttpClientConnectionOperator(Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        Args.notNull(lookup, "Socket factory registry");
        this.socketFactoryRegistry = lookup;
        this.schemePortResolver = schemePortResolver == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver;
        this.dnsResolver = dnsResolver == null ? SystemDefaultDnsResolver.INSTANCE : dnsResolver;
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext httpContext) {
        Lookup<ConnectionSocketFactory> lookup = (Lookup) httpContext.getAttribute("http.socket-factory-registry");
        return lookup == null ? this.socketFactoryRegistry : lookup;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011b A[SYNTHETIC] */
    @Override // org.apache.http.conn.HttpClientConnectionOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, InetSocketAddress inetSocketAddress, int i, SocketConfig socketConfig, HttpContext httpContext) throws IOException {
        ConnectionSocketFactory connectionSocketFactoryLookup = getSocketFactoryRegistry(httpContext).lookup(httpHost.getSchemeName());
        if (connectionSocketFactoryLookup == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        }
        InetAddress[] inetAddressArrResolve = httpHost.getAddress() != null ? new InetAddress[]{httpHost.getAddress()} : this.dnsResolver.resolve(httpHost.getHostName());
        int iResolve = this.schemePortResolver.resolve(httpHost);
        int i2 = 0;
        while (i2 < inetAddressArrResolve.length) {
            InetAddress inetAddress = inetAddressArrResolve[i2];
            boolean z = i2 == inetAddressArrResolve.length - 1;
            Socket socketCreateSocket = connectionSocketFactoryLookup.createSocket(httpContext);
            socketCreateSocket.setSoTimeout(socketConfig.getSoTimeout());
            socketCreateSocket.setReuseAddress(socketConfig.isSoReuseAddress());
            socketCreateSocket.setTcpNoDelay(socketConfig.isTcpNoDelay());
            socketCreateSocket.setKeepAlive(socketConfig.isSoKeepAlive());
            int soLinger = socketConfig.getSoLinger();
            if (soLinger >= 0) {
                socketCreateSocket.setSoLinger(true, soLinger);
            }
            managedHttpClientConnection.bind(socketCreateSocket);
            InetSocketAddress inetSocketAddress2 = new InetSocketAddress(inetAddress, iResolve);
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connecting to " + inetSocketAddress2);
            }
            int i3 = i2;
            int i4 = iResolve;
            try {
                managedHttpClientConnection.bind(connectionSocketFactoryLookup.connectSocket(i, socketCreateSocket, httpHost, inetSocketAddress2, inetSocketAddress, httpContext));
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Connection established " + managedHttpClientConnection);
                    return;
                }
                return;
            } catch (ConnectException e) {
                if (z) {
                    if ("Connection timed out".equals(e.getMessage())) {
                        throw new ConnectTimeoutException(e, httpHost, inetAddressArrResolve);
                    }
                    throw new HttpHostConnectException(e, httpHost, inetAddressArrResolve);
                }
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Connect to " + inetSocketAddress2 + " timed out. Connection will be retried using another IP address");
                }
                i2 = i3 + 1;
                iResolve = i4;
            } catch (NoRouteToHostException e2) {
                if (z) {
                    throw e2;
                }
                if (this.log.isDebugEnabled()) {
                }
                i2 = i3 + 1;
                iResolve = i4;
            } catch (SocketTimeoutException e3) {
                if (z) {
                    throw new ConnectTimeoutException(e3, httpHost, inetAddressArrResolve);
                }
                if (this.log.isDebugEnabled()) {
                }
                i2 = i3 + 1;
                iResolve = i4;
            }
        }
    }

    @Override // org.apache.http.conn.HttpClientConnectionOperator
    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, HttpContext httpContext) throws IOException {
        ConnectionSocketFactory connectionSocketFactoryLookup = getSocketFactoryRegistry(HttpClientContext.adapt(httpContext)).lookup(httpHost.getSchemeName());
        if (connectionSocketFactoryLookup == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        }
        if (!(connectionSocketFactoryLookup instanceof LayeredConnectionSocketFactory)) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol does not support connection upgrade");
        }
        managedHttpClientConnection.bind(((LayeredConnectionSocketFactory) connectionSocketFactoryLookup).createLayeredSocket(managedHttpClientConnection.getSocket(), httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpContext));
    }
}
