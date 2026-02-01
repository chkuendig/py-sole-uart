package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpTimeout.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/HttpRequestTimeoutException;", "Ljava/io/IOException;", "Lio/ktor/utils/io/errors/IOException;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;)V", "url", "", "timeoutMillis", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpRequestTimeoutException extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestTimeoutException(String url, Long l) {
        super("Request timeout has expired [url=" + url + ", request_timeout=" + (l == null ? "unknown" : l) + " ms]");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HttpRequestTimeoutException(HttpRequestBuilder request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String strBuildString = request.getUrl().buildString();
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.getCapabilityOrNull(HttpTimeout.INSTANCE);
        this(strBuildString, httpTimeoutCapabilityConfiguration != null ? httpTimeoutCapabilityConfiguration.get_requestTimeoutMillis() : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HttpRequestTimeoutException(HttpRequestData request) {
        Intrinsics.checkNotNullParameter(request, "request");
        String urlString = request.getUrl().getUrlString();
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.getCapabilityOrNull(HttpTimeout.INSTANCE);
        this(urlString, httpTimeoutCapabilityConfiguration != null ? httpTimeoutCapabilityConfiguration.get_requestTimeoutMillis() : null);
    }
}
