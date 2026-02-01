package io.ktor.client.plugins.websocket;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.android.SdkConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: builders.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006\u001aW\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a.\u0010\u001b\u001a\u00020\r*\u00020\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a^\u0010\u001b\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a8\u0010\u001b\u001a\u00020\r*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aW\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010\u001f\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aW\u0010 \u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010 \u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010 \u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"WebSockets", "", "Lio/ktor/client/HttpClientConfig;", "config", "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lkotlin/ExtensionFunctionType;", "webSocket", "Lio/ktor/client/HttpClient;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lkotlin/Function2;", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FirebaseAnalytics.Param.METHOD, "Lio/ktor/http/HttpMethod;", SdkConstants.ATTR_HOST, "", "port", "", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BuildersKt {

    /* compiled from: builders.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt", f = "builders.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4}, l = {241, 244, 101, 103, 103, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, m = "webSocket", n = {"block", "this_$iv", "block", "this_$iv", "response$iv", "this_$iv", "response$iv", "it", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocket$1, reason: invalid class name and case insensitive filesystem */
    static final class C10901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10901(Continuation<? super C10901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BuildersKt.webSocket(null, null, null, this);
        }
    }

    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, final Function1<? super WebSockets.Config, Unit> config) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        httpClientConfig.install(WebSockets.INSTANCE, new Function1<WebSockets.Config, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.WebSockets.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSockets.Config config2) {
                invoke2(config2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSockets.Config install) {
                Intrinsics.checkNotNullParameter(install, "$this$install");
                config.invoke(install);
            }
        });
    }

    public static final Object webSocketSession(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$statement$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                invoke2(uRLBuilder, uRLBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(URLBuilder url, URLBuilder it) {
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                url.setProtocol(URLProtocol.INSTANCE.getWS());
                url.setPort(url.getProtocol().getDefaultPort());
            }
        });
        function1.invoke(httpRequestBuilder);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new AnonymousClass2(new HttpStatement(httpRequestBuilder, httpClient), completableDeferredCompletableDeferred$default, null), 3, null);
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* compiled from: builders.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", i = {0, 1, 1, 2, 2}, l = {239, 242, 49, 248, 248}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2", "L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<DefaultClientWebSocketSession> $sessionDeferred;
        final /* synthetic */ HttpStatement $statement;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HttpStatement httpStatement, CompletableDeferred<DefaultClientWebSocketSession> completableDeferred, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$statement = httpStatement;
            this.$sessionDeferred = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$statement, this.$sessionDeferred, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00ab A[Catch: all -> 0x0052, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:23:0x004e, B:44:0x00ab, B:52:0x00e4, B:53:0x00eb), top: B:67:0x004e }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e4 A[Catch: all -> 0x0052, TRY_ENTER, TryCatch #0 {all -> 0x0052, blocks: (B:23:0x004e, B:44:0x00ab, B:52:0x00e4, B:53:0x00eb), top: B:67:0x004e }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00ff A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0100  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 274
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        HttpMethod httpMethod2 = httpMethod;
        String str3 = (i & 2) != 0 ? null : str;
        Integer num2 = (i & 4) != 0 ? null : num;
        String str4 = (i & 8) != 0 ? null : str2;
        if ((i & 16) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocketSession(httpClient, httpMethod2, str3, num2, str4, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocketSession) {
                Intrinsics.checkNotNullParameter(webSocketSession, "$this$webSocketSession");
                webSocketSession.setMethod(httpMethod);
                HttpRequestKt.url$default(webSocketSession, "ws", str, num, str2, null, 16, null);
                function1.invoke(webSocketSession);
            }
        }, continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocketSession(httpClient, str, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocketSession.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocketSession) {
                Intrinsics.checkNotNullParameter(webSocketSession, "$this$webSocketSession");
                URLParserKt.takeFrom(webSocketSession.getUrl(), str);
                function1.invoke(webSocketSession);
            }
        }, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f5 A[Catch: all -> 0x0089, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0089, blocks: (B:19:0x004c, B:66:0x0143, B:22:0x005b, B:56:0x011d, B:53:0x010b, B:63:0x0131, B:30:0x0085, B:48:0x00f5, B:67:0x0144, B:68:0x014b), top: B:82:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0144 A[Catch: all -> 0x0089, TryCatch #3 {all -> 0x0089, blocks: (B:19:0x004c, B:66:0x0143, B:22:0x005b, B:56:0x011d, B:53:0x010b, B:63:0x0131, B:30:0x0085, B:48:0x00f5, B:67:0x0144, B:68:0x014b), top: B:82:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r10v1, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1<? super io.ktor.client.request.HttpRequestBuilder, kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r9v1, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r9v5, types: [io.ktor.client.statement.HttpResponse, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object webSocket(io.ktor.client.HttpClient r8, kotlin.jvm.functions.Function1<? super io.ktor.client.request.HttpRequestBuilder, kotlin.Unit> r9, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt.webSocket(io.ktor.client.HttpClient, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object webSocket(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocket.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.setMethod(httpMethod);
                HttpRequestKt.url$default(webSocket, "ws", str, num, str2, null, 16, null);
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocket.7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocket(httpClient, str, function1, function2, continuation);
    }

    public static final Object webSocket(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, HttpMethod.INSTANCE.getGet(), null, null, null, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.webSocket.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWS());
                webSocket.getUrl().setPort(UtilsKt.getPort(webSocket));
                URLParserKt.takeFrom(webSocket.getUrl(), str);
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, function1, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, function1, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.ws.5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return ws(httpClient, str, function1, function2, continuation);
    }

    public static final Object ws(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, str, function1, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
                webSocket.getUrl().setPort(webSocket.getUrl().getProtocol().getDefaultPort());
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return wss(httpClient, str, function1, function2, continuation);
    }

    public static final Object wss(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWss = wss(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder wss) {
                Intrinsics.checkNotNullParameter(wss, "$this$wss");
                URLParserKt.takeFrom(wss.getUrl(), str);
                function1.invoke(wss);
            }
        }, function2, continuation);
        return objWss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWss : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, HttpMethod httpMethod, String str, final Integer num, String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        Object objWebSocket = webSocket(httpClient, httpMethod, str, num, str2, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt.wss.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket) {
                Intrinsics.checkNotNullParameter(webSocket, "$this$webSocket");
                webSocket.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
                if (num != null) {
                    webSocket.getUrl().setPort(num.intValue());
                }
                function1.invoke(webSocket);
            }
        }, function2, continuation);
        return objWebSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWebSocket : Unit.INSTANCE;
    }
}
