package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpInetSocketAddress;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SchemeSocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
/* loaded from: classes2.dex */
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected final DnsResolver dnsResolver;
    private final Log log = LogFactory.getLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = new SystemDefaultDnsResolver();
    }

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
    }

    @Override // org.apache.http.conn.ClientConnectionOperator
    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    private SchemeRegistry getSchemeRegistry(HttpContext httpContext) {
        SchemeRegistry schemeRegistry = (SchemeRegistry) httpContext.getAttribute(ClientContext.SCHEME_REGISTRY);
        return schemeRegistry == null ? this.schemeRegistry : schemeRegistry;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb A[SYNTHETIC] */
    @Override // org.apache.http.conn.ClientConnectionOperator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, InetAddress inetAddress, HttpContext httpContext, HttpParams httpParams) throws IOException {
        InetAddress inetAddress2 = inetAddress;
        Args.notNull(operatedClientConnection, "Connection");
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "HTTP parameters");
        int i = 1;
        Asserts.check(!operatedClientConnection.isOpen(), "Connection must not be open");
        Scheme scheme = getSchemeRegistry(httpContext).getScheme(httpHost.getSchemeName());
        SchemeSocketFactory schemeSocketFactory = scheme.getSchemeSocketFactory();
        InetAddress[] inetAddressArrResolveHostname = resolveHostname(httpHost.getHostName());
        int iResolvePort = scheme.resolvePort(httpHost.getPort());
        int i2 = 0;
        int i3 = 0;
        while (i3 < inetAddressArrResolveHostname.length) {
            InetAddress inetAddress3 = inetAddressArrResolveHostname[i3];
            int i4 = i3 == inetAddressArrResolveHostname.length - i ? i : i2;
            Socket socketCreateSocket = schemeSocketFactory.createSocket(httpParams);
            operatedClientConnection.opening(socketCreateSocket, httpHost);
            HttpInetSocketAddress httpInetSocketAddress = new HttpInetSocketAddress(httpHost, inetAddress3, iResolvePort);
            InetSocketAddress inetSocketAddress = inetAddress2 != null ? new InetSocketAddress(inetAddress2, i2) : null;
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connecting to " + httpInetSocketAddress);
            }
            try {
                Socket socketConnectSocket = schemeSocketFactory.connectSocket(socketCreateSocket, httpInetSocketAddress, inetSocketAddress, httpParams);
                if (socketCreateSocket != socketConnectSocket) {
                    operatedClientConnection.opening(socketConnectSocket, httpHost);
                    socketCreateSocket = socketConnectSocket;
                }
                prepareSocket(socketCreateSocket, httpContext, httpParams);
                operatedClientConnection.openCompleted(schemeSocketFactory.isSecure(socketCreateSocket), httpParams);
                return;
            } catch (ConnectException e) {
                if (i4 != 0) {
                    throw e;
                }
                if (!this.log.isDebugEnabled()) {
                    this.log.debug("Connect to " + httpInetSocketAddress + " timed out. Connection will be retried using another IP address");
                }
                i3++;
                inetAddress2 = inetAddress;
                i = 1;
                i2 = 0;
            } catch (ConnectTimeoutException e2) {
                if (i4 != 0) {
                    throw e2;
                }
                if (!this.log.isDebugEnabled()) {
                }
                i3++;
                inetAddress2 = inetAddress;
                i = 1;
                i2 = 0;
            }
        }
    }

    @Override // org.apache.http.conn.ClientConnectionOperator
    public void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws IOException {
        Args.notNull(operatedClientConnection, "Connection");
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "Parameters");
        Asserts.check(operatedClientConnection.isOpen(), "Connection must be open");
        Scheme scheme = getSchemeRegistry(httpContext).getScheme(httpHost.getSchemeName());
        Asserts.check(scheme.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
        SchemeLayeredSocketFactory schemeLayeredSocketFactory = (SchemeLayeredSocketFactory) scheme.getSchemeSocketFactory();
        Socket socketCreateLayeredSocket = schemeLayeredSocketFactory.createLayeredSocket(operatedClientConnection.getSocket(), httpHost.getHostName(), scheme.resolvePort(httpHost.getPort()), httpParams);
        prepareSocket(socketCreateLayeredSocket, httpContext, httpParams);
        operatedClientConnection.update(socketCreateLayeredSocket, httpHost, schemeLayeredSocketFactory.isSecure(socketCreateLayeredSocket), httpParams);
    }

    protected void prepareSocket(Socket socket, HttpContext httpContext, HttpParams httpParams) throws IOException {
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpParams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        int linger = HttpConnectionParams.getLinger(httpParams);
        if (linger >= 0) {
            socket.setSoLinger(linger > 0, linger);
        }
    }

    protected InetAddress[] resolveHostname(String str) throws UnknownHostException {
        return this.dnsResolver.resolve(str);
    }
}
