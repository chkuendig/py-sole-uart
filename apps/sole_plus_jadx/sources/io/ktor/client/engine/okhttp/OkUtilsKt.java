package io.ktor.client.engine.okhttp;

import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OkUtils.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a%\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0005H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"mapOkHttpException", "", "requestData", "Lio/ktor/client/request/HttpRequestData;", "origin", "Ljava/io/IOException;", "execute", "Lokhttp3/Response;", "Lokhttp3/OkHttpClient;", "request", "Lokhttp3/Request;", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fromOkHttp", "Lio/ktor/http/Headers;", "Lokhttp3/Headers;", "Lio/ktor/http/HttpProtocolVersion;", "Lokhttp3/Protocol;", "isConnectException", "", "ktor-client-okhttp"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OkUtilsKt {

    /* compiled from: OkUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Protocol.values().length];
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Protocol.SPDY_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Protocol.HTTP_2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Protocol.H2_PRIOR_KNOWLEDGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Protocol.QUIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Headers fromOkHttp(final okhttp3.Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return new Headers() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt.fromOkHttp.1
            private final boolean caseInsensitiveName = true;

            @Override // io.ktor.util.StringValues
            public boolean contains(String str) {
                return Headers.DefaultImpls.contains(this, str);
            }

            @Override // io.ktor.util.StringValues
            public boolean contains(String str, String str2) {
                return Headers.DefaultImpls.contains(this, str, str2);
            }

            @Override // io.ktor.util.StringValues
            public void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
                Headers.DefaultImpls.forEach(this, function2);
            }

            @Override // io.ktor.util.StringValues
            public String get(String str) {
                return Headers.DefaultImpls.get(this, str);
            }

            @Override // io.ktor.util.StringValues
            public boolean getCaseInsensitiveName() {
                return this.caseInsensitiveName;
            }

            @Override // io.ktor.util.StringValues
            public List<String> getAll(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                List<String> listValues = headers.values(name);
                if (listValues.isEmpty()) {
                    return null;
                }
                return listValues;
            }

            @Override // io.ktor.util.StringValues
            public Set<String> names() {
                return headers.names();
            }

            @Override // io.ktor.util.StringValues
            public Set<Map.Entry<String, List<String>>> entries() {
                return headers.toMultimap().entrySet();
            }

            @Override // io.ktor.util.StringValues
            public boolean isEmpty() {
                return headers.size() == 0;
            }
        };
    }

    public static final HttpProtocolVersion fromOkHttp(Protocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[protocol.ordinal()]) {
            case 1:
                return HttpProtocolVersion.INSTANCE.getHTTP_1_0();
            case 2:
                return HttpProtocolVersion.INSTANCE.getHTTP_1_1();
            case 3:
                return HttpProtocolVersion.INSTANCE.getSPDY_3();
            case 4:
                return HttpProtocolVersion.INSTANCE.getHTTP_2_0();
            case 5:
                return HttpProtocolVersion.INSTANCE.getHTTP_2_0();
            case 6:
                return HttpProtocolVersion.INSTANCE.getQUIC();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapOkHttpException(HttpRequestData httpRequestData, IOException iOException) {
        SocketTimeoutException SocketTimeoutException;
        if (iOException instanceof StreamAdapterIOException) {
            Throwable cause = iOException.getCause();
            return cause == null ? iOException : cause;
        }
        if (iOException instanceof java.net.SocketTimeoutException) {
            if (isConnectException(iOException)) {
                SocketTimeoutException = HttpTimeoutKt.ConnectTimeoutException(httpRequestData, iOException);
            } else {
                SocketTimeoutException = HttpTimeoutKt.SocketTimeoutException(httpRequestData, iOException);
            }
            return SocketTimeoutException;
        }
        return iOException;
    }

    private static final boolean isConnectException(IOException iOException) {
        String message = iOException.getMessage();
        return message != null && StringsKt.contains((CharSequence) message, (CharSequence) "connect", true);
    }

    public static final Object execute(OkHttpClient okHttpClient, Request request, HttpRequestData httpRequestData, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final Call callNewCall = okHttpClient.newCall(request);
        callNewCall.enqueue(new OkHttpCallback(httpRequestData, cancellableContinuationImpl2));
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.okhttp.OkUtilsKt$execute$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                callNewCall.cancel();
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
