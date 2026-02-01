package org.apache.http.client.fluent;

import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.util.Args;

/* loaded from: classes2.dex */
class InternalHttpRequest extends AbstractHttpMessage implements HttpUriRequest, HttpExecutionAware, Configurable {
    private final AtomicBoolean aborted;
    private final AtomicReference<Cancellable> cancellableRef;
    private RequestConfig config;
    private final String method;
    private URI uri;
    private ProtocolVersion version;

    InternalHttpRequest(String str, URI uri) {
        Args.notBlank(str, "Method");
        Args.notNull(uri, "Request URI");
        this.method = str;
        this.uri = uri;
        this.aborted = new AtomicBoolean(false);
        this.cancellableRef = new AtomicReference<>(null);
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : HttpVersion.HTTP_1_1;
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        return this.method;
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public void abort() throws UnsupportedOperationException {
        Cancellable andSet;
        if (!this.aborted.compareAndSet(false, true) || (andSet = this.cancellableRef.getAndSet(null)) == null) {
            return;
        }
        andSet.cancel();
    }

    @Override // org.apache.http.client.methods.HttpUriRequest, org.apache.http.client.methods.HttpExecutionAware
    public boolean isAborted() {
        return this.aborted.get();
    }

    @Override // org.apache.http.client.methods.HttpExecutionAware
    public void setCancellable(Cancellable cancellable) {
        if (this.aborted.get()) {
            return;
        }
        this.cancellableRef.set(cancellable);
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        ProtocolVersion protocolVersion = getProtocolVersion();
        URI uri = getURI();
        String aSCIIString = uri != null ? uri.toASCIIString() : null;
        if (aSCIIString == null || aSCIIString.isEmpty()) {
            aSCIIString = "/";
        }
        return new BasicRequestLine(getMethod(), aSCIIString, protocolVersion);
    }

    @Override // org.apache.http.client.methods.Configurable
    public RequestConfig getConfig() {
        return this.config;
    }

    public void setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
    }

    public void setURI(URI uri) {
        this.uri = uri;
    }

    public String toString() {
        return getMethod() + StringUtils.SPACE + getURI() + StringUtils.SPACE + getProtocolVersion();
    }
}
