package io.ktor.client.plugins;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.InternalAPI;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpTimeout.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\r\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a%\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a#\u0010\u000b\u001a\u00020\u0018*\u00020\u00192\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\u0002\b\u001c\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "ConnectTimeoutException", "Lio/ktor/client/network/sockets/ConnectTimeoutException;", "request", "Lio/ktor/client/request/HttpRequestData;", "cause", "", "url", "", "timeout", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Throwable;)Lio/ktor/client/network/sockets/ConnectTimeoutException;", "SocketTimeoutException", "Lio/ktor/client/network/sockets/SocketTimeoutException;", "convertLongTimeoutToIntWithInfiniteAsZero", "", "convertLongTimeoutToLongWithInfiniteAsZero", "unwrapRequestTimeoutException", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpTimeoutKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpTimeout");

    @InternalAPI
    public static final int convertLongTimeoutToIntWithInfiniteAsZero(long j) {
        if (j == Long.MAX_VALUE) {
            return 0;
        }
        if (j < SieveCacheKt.NodeMetaAndPreviousMask) {
            return Integer.MIN_VALUE;
        }
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    @InternalAPI
    public static final long convertLongTimeoutToLongWithInfiniteAsZero(long j) {
        if (j == Long.MAX_VALUE) {
            return 0L;
        }
        return j;
    }

    public static final void timeout(HttpRequestBuilder httpRequestBuilder, Function1<? super HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit> block) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        HttpTimeout.Companion companion = HttpTimeout.INSTANCE;
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = new HttpTimeout.HttpTimeoutCapabilityConfiguration(null, null, null, 7, null);
        block.invoke(httpTimeoutCapabilityConfiguration);
        httpRequestBuilder.setCapability(companion, httpTimeoutCapabilityConfiguration);
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return ConnectTimeoutException(httpRequestData, th);
    }

    public static final ConnectTimeoutException ConnectTimeoutException(HttpRequestData request, Throwable th) {
        Object obj;
        Intrinsics.checkNotNullParameter(request, "request");
        StringBuilder sbAppend = new StringBuilder("Connect timeout has expired [url=").append(request.getUrl()).append(", connect_timeout=");
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.getCapabilityOrNull(HttpTimeout.INSTANCE);
        if (httpTimeoutCapabilityConfiguration == null || (obj = httpTimeoutCapabilityConfiguration.get_connectTimeoutMillis()) == null) {
            obj = "unknown";
        }
        return new ConnectTimeoutException(sbAppend.append(obj).append(" ms]").toString(), th);
    }

    public static /* synthetic */ ConnectTimeoutException ConnectTimeoutException$default(String str, Long l, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        return ConnectTimeoutException(str, l, th);
    }

    public static final ConnectTimeoutException ConnectTimeoutException(String url, Long l, Throwable th) {
        Intrinsics.checkNotNullParameter(url, "url");
        StringBuilder sbAppend = new StringBuilder("Connect timeout has expired [url=").append(url).append(", connect_timeout=");
        Object obj = l;
        if (l == null) {
            obj = "unknown";
        }
        return new ConnectTimeoutException(sbAppend.append(obj).append(" ms]").toString(), th);
    }

    public static /* synthetic */ SocketTimeoutException SocketTimeoutException$default(HttpRequestData httpRequestData, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return SocketTimeoutException(httpRequestData, th);
    }

    public static final SocketTimeoutException SocketTimeoutException(HttpRequestData request, Throwable th) {
        Object obj;
        Intrinsics.checkNotNullParameter(request, "request");
        StringBuilder sbAppend = new StringBuilder("Socket timeout has expired [url=").append(request.getUrl()).append(", socket_timeout=");
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.getCapabilityOrNull(HttpTimeout.INSTANCE);
        if (httpTimeoutCapabilityConfiguration == null || (obj = httpTimeoutCapabilityConfiguration.get_socketTimeoutMillis()) == null) {
            obj = "unknown";
        }
        return new SocketTimeoutException(sbAppend.append(obj).append("] ms").toString(), th);
    }

    public static final <T> T unwrapRequestTimeoutException(Function0<? extends T> block) throws Throwable {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }
}
