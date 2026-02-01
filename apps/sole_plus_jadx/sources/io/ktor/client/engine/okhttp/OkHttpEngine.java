package io.ktor.client.engine.okhttp;

import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.utils.CoroutineDispatcherUtilsKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.CacheKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.date.GMTDate;
import java.io.Closeable;
import java.io.IOException;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* compiled from: OkHttpEngine.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0002J\u0019\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J1\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020\f2\u0006\u00100\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u00101J)\u00102\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00103R\u001c\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "config", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "(Lio/ktor/client/engine/okhttp/OkHttpConfig;)V", "clientCache", "", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "Lokhttp3/OkHttpClient;", "getConfig", "()Lio/ktor/client/engine/okhttp/OkHttpConfig;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "requestsJob", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "buildResponseData", "Lio/ktor/client/request/HttpResponseData;", "response", "Lokhttp3/Response;", "requestTime", "Lio/ktor/util/date/GMTDate;", "body", "", "callContext", "close", "", "createOkHttpClient", "timeoutExtension", "execute", "data", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeHttpRequest", "engine", "engineRequest", "Lokhttp3/Request;", "requestData", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWebSocketRequest", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ktor-client-okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OkHttpEngine extends HttpClientEngineBase {
    private static final Companion Companion = new Companion(null);
    private static final Lazy<OkHttpClient> okHttpClientPrototype$delegate = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$Companion$okHttpClientPrototype$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            return new OkHttpClient.Builder().build();
        }
    });
    private final Map<HttpTimeout.HttpTimeoutCapabilityConfiguration, OkHttpClient> clientCache;
    private final OkHttpConfig config;
    private final CoroutineContext coroutineContext;

    /* renamed from: dispatcher$delegate, reason: from kotlin metadata */
    private final Lazy dispatcher;
    private final CoroutineContext requestsJob;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* compiled from: OkHttpEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0}, l = {71, 78, 80}, m = "execute", n = {"this", "data"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$execute$1, reason: invalid class name and case insensitive filesystem */
    static final class C10661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10661(Continuation<? super C10661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.execute(null, this);
        }
    }

    /* compiled from: OkHttpEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0, 0, 0}, l = {113}, m = "executeHttpRequest", n = {"this", "callContext", "requestData", "requestTime"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1, reason: invalid class name and case insensitive filesystem */
    static final class C10671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10671(Continuation<? super C10671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeHttpRequest(null, null, null, null, this);
        }
    }

    /* compiled from: OkHttpEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", i = {0, 0, 0, 0}, l = {102}, m = "executeWebSocketRequest", n = {"this", "callContext", "requestTime", "session"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1, reason: invalid class name and case insensitive filesystem */
    static final class C10681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10681(Continuation<? super C10681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OkHttpEngine.this.executeWebSocketRequest(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpConfig config) {
        super("ktor-okhttp");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.dispatcher = LazyKt.lazy(new Function0<CoroutineDispatcher>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$dispatcher$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return CoroutineDispatcherUtilsKt.clientDispatcher(Dispatchers.INSTANCE, this.this$0.getConfig().getThreadsCount(), "ktor-okhttp-dispatcher");
            }
        });
        this.supportedCapabilities = SetsKt.setOf((Object[]) new HttpClientEngineCapability[]{HttpTimeout.INSTANCE, WebSocketCapability.INSTANCE});
        this.clientCache = CacheKt.createLRUCache(new OkHttpEngine$clientCache$1(this), new Function1<OkHttpClient, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$clientCache$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OkHttpClient it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OkHttpClient okHttpClient) {
                invoke2(okHttpClient);
                return Unit.INSTANCE;
            }
        }, getConfig().getClientCacheSize());
        CoroutineContext.Element element = super.getCoroutineContext().get(Job.INSTANCE);
        Intrinsics.checkNotNull(element);
        CoroutineContext coroutineContextSilentSupervisor = CoroutinesUtilsKt.SilentSupervisor((Job) element);
        this.requestsJob = coroutineContextSilentSupervisor;
        this.coroutineContext = super.getCoroutineContext().plus(coroutineContextSilentSupervisor);
        BuildersKt.launch(GlobalScope.INSTANCE, super.getCoroutineContext(), CoroutineStart.ATOMIC, new AnonymousClass1(null));
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public OkHttpConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public CoroutineDispatcher getDispatcher() {
        return (CoroutineDispatcher) this.dispatcher.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OkHttpEngine.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = OkHttpEngine.this.requestsJob.get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    this.label = 1;
                    if (((Job) element).join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    OkHttpClient okHttpClient = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient.connectionPool().evictAll();
                    okHttpClient.dispatcher().executorService().shutdown();
                }
                CoroutineContext.Element dispatcher = OkHttpEngine.this.getDispatcher();
                Intrinsics.checkNotNull(dispatcher, "null cannot be cast to non-null type java.io.Closeable");
                ((Closeable) dispatcher).close();
                return Unit.INSTANCE;
            } finally {
                it = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (it.hasNext()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient2.connectionPool().evictAll();
                    okHttpClient2.dispatcher().executorService().shutdown();
                }
                CoroutineContext.Element dispatcher2 = OkHttpEngine.this.getDispatcher();
                Intrinsics.checkNotNull(dispatcher2, "null cannot be cast to non-null type java.io.Closeable");
                ((Closeable) dispatcher2).close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object execute(io.ktor.client.request.HttpRequestData r10, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.engine.okhttp.OkHttpEngine.C10661
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.client.engine.okhttp.OkHttpEngine$execute$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine.C10661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.client.engine.okhttp.OkHttpEngine$execute$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$execute$1
            r0.<init>(r11)
        L19:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L49
            if (r1 == r4) goto L3d
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.throwOnFailure(r11)
            goto L98
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L88
        L3d:
            java.lang.Object r10 = r6.L$1
            io.ktor.client.request.HttpRequestData r10 = (io.ktor.client.request.HttpRequestData) r10
            java.lang.Object r1 = r6.L$0
            io.ktor.client.engine.okhttp.OkHttpEngine r1 = (io.ktor.client.engine.okhttp.OkHttpEngine) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5a
        L49:
            kotlin.ResultKt.throwOnFailure(r11)
            r6.L$0 = r9
            r6.L$1 = r10
            r6.label = r4
            java.lang.Object r11 = io.ktor.client.engine.UtilsKt.callContext(r6)
            if (r11 != r0) goto L59
            return r0
        L59:
            r1 = r9
        L5a:
            r5 = r10
            r4 = r11
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            okhttp3.Request r10 = io.ktor.client.engine.okhttp.OkHttpEngineKt.access$convertToOkHttpRequest(r5, r4)
            java.util.Map<io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration, okhttp3.OkHttpClient> r11 = r1.clientCache
            io.ktor.client.plugins.HttpTimeout$Plugin r7 = io.ktor.client.plugins.HttpTimeout.INSTANCE
            io.ktor.client.engine.HttpClientEngineCapability r7 = (io.ktor.client.engine.HttpClientEngineCapability) r7
            java.lang.Object r7 = r5.getCapabilityOrNull(r7)
            java.lang.Object r11 = r11.get(r7)
            okhttp3.OkHttpClient r11 = (okhttp3.OkHttpClient) r11
            if (r11 == 0) goto L99
            boolean r7 = io.ktor.client.request.HttpRequestKt.isUpgradeRequest(r5)
            r8 = 0
            if (r7 == 0) goto L89
            r6.L$0 = r8
            r6.L$1 = r8
            r6.label = r3
            java.lang.Object r11 = r1.executeWebSocketRequest(r11, r10, r4, r6)
            if (r11 != r0) goto L88
            return r0
        L88:
            return r11
        L89:
            r6.L$0 = r8
            r6.L$1 = r8
            r6.label = r2
            r2 = r11
            r3 = r10
            java.lang.Object r11 = r1.executeHttpRequest(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L98
            return r0
        L98:
            return r11
        L99:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "OkHttpClient can't be constructed because HttpTimeout plugin is not installed"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.execute(io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        CoroutineContext.Element element = this.requestsJob.get(Job.INSTANCE);
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((CompletableJob) element).complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeWebSocketRequest(okhttp3.OkHttpClient r6, okhttp3.Request r7, kotlin.coroutines.CoroutineContext r8, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.client.engine.okhttp.OkHttpEngine.C10681
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine.C10681) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeWebSocketRequest$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r6 = r0.L$3
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r6 = (io.ktor.client.engine.okhttp.OkHttpWebsocketSession) r6
            java.lang.Object r7 = r0.L$2
            io.ktor.util.date.GMTDate r7 = (io.ktor.util.date.GMTDate) r7
            java.lang.Object r8 = r0.L$1
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r0 = r0.L$0
            io.ktor.client.engine.okhttp.OkHttpEngine r0 = (io.ktor.client.engine.okhttp.OkHttpEngine) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L78
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 0
            io.ktor.util.date.GMTDate r9 = io.ktor.util.date.DateJvmKt.GMTDate$default(r9, r3, r9)
            io.ktor.client.engine.okhttp.OkHttpWebsocketSession r2 = new io.ktor.client.engine.okhttp.OkHttpWebsocketSession
            io.ktor.client.engine.okhttp.OkHttpConfig r4 = r5.getConfig()
            okhttp3.WebSocket$Factory r4 = r4.getWebSocketFactory()
            if (r4 != 0) goto L59
            r4 = r6
            okhttp3.WebSocket$Factory r4 = (okhttp3.WebSocket.Factory) r4
        L59:
            r2.<init>(r6, r4, r7, r8)
            r2.start()
            kotlinx.coroutines.CompletableDeferred r6 = r2.getOriginResponse$ktor_client_okhttp()
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r2
            r0.label = r3
            java.lang.Object r6 = r6.await(r0)
            if (r6 != r1) goto L74
            return r1
        L74:
            r0 = r5
            r7 = r9
            r9 = r6
            r6 = r2
        L78:
            okhttp3.Response r9 = (okhttp3.Response) r9
            io.ktor.client.request.HttpResponseData r6 = r0.buildResponseData(r9, r7, r6, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.executeWebSocketRequest(okhttp3.OkHttpClient, okhttp3.Request, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeHttpRequest(okhttp3.OkHttpClient r6, okhttp3.Request r7, kotlin.coroutines.CoroutineContext r8, io.ktor.client.request.HttpRequestData r9, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof io.ktor.client.engine.okhttp.OkHttpEngine.C10671
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1 r0 = (io.ktor.client.engine.okhttp.OkHttpEngine.C10671) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1 r0 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.L$3
            io.ktor.util.date.GMTDate r6 = (io.ktor.util.date.GMTDate) r6
            java.lang.Object r7 = r0.L$2
            r9 = r7
            io.ktor.client.request.HttpRequestData r9 = (io.ktor.client.request.HttpRequestData) r9
            java.lang.Object r7 = r0.L$1
            r8 = r7
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            java.lang.Object r7 = r0.L$0
            io.ktor.client.engine.okhttp.OkHttpEngine r7 = (io.ktor.client.engine.okhttp.OkHttpEngine) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L61
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 0
            io.ktor.util.date.GMTDate r10 = io.ktor.util.date.DateJvmKt.GMTDate$default(r10, r3, r10)
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.label = r3
            java.lang.Object r6 = io.ktor.client.engine.okhttp.OkUtilsKt.execute(r6, r7, r9, r0)
            if (r6 != r1) goto L5d
            return r1
        L5d:
            r7 = r5
            r4 = r10
            r10 = r6
            r6 = r4
        L61:
            okhttp3.Response r10 = (okhttp3.Response) r10
            okhttp3.ResponseBody r0 = r10.body()
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r1 = (kotlin.coroutines.CoroutineContext.Key) r1
            kotlin.coroutines.CoroutineContext$Element r1 = r8.get(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2 r2 = new io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r1.invokeOnCompletion(r2)
            if (r0 == 0) goto L8c
            okio.BufferedSource r0 = r0.getSource()
            if (r0 == 0) goto L8c
            io.ktor.utils.io.ByteReadChannel r9 = io.ktor.client.engine.okhttp.OkHttpEngineKt.access$toChannel(r0, r8, r9)
            if (r9 != 0) goto L92
        L8c:
            io.ktor.utils.io.ByteReadChannel$Companion r9 = io.ktor.utils.io.ByteReadChannel.INSTANCE
            io.ktor.utils.io.ByteReadChannel r9 = r9.getEmpty()
        L92:
            io.ktor.client.request.HttpResponseData r6 = r7.buildResponseData(r10, r6, r9, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpEngine.executeHttpRequest(okhttp3.OkHttpClient, okhttp3.Request, kotlin.coroutines.CoroutineContext, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final HttpResponseData buildResponseData(Response response, GMTDate requestTime, Object body, CoroutineContext callContext) {
        return new HttpResponseData(new HttpStatusCode(response.code(), response.message()), requestTime, OkUtilsKt.fromOkHttp(response.headers()), OkUtilsKt.fromOkHttp(response.protocol()), body, callContext);
    }

    /* compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine$Companion;", "", "()V", "okHttpClientPrototype", "Lokhttp3/OkHttpClient;", "getOkHttpClientPrototype", "()Lokhttp3/OkHttpClient;", "okHttpClientPrototype$delegate", "Lkotlin/Lazy;", "ktor-client-okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpClient getOkHttpClientPrototype() {
            return (OkHttpClient) OkHttpEngine.okHttpClientPrototype$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient createOkHttpClient(HttpTimeout.HttpTimeoutCapabilityConfiguration timeoutExtension) {
        OkHttpClient preconfigured = getConfig().getPreconfigured();
        if (preconfigured == null) {
            preconfigured = Companion.getOkHttpClientPrototype();
        }
        OkHttpClient.Builder builderNewBuilder = preconfigured.newBuilder();
        builderNewBuilder.dispatcher(new Dispatcher());
        getConfig().getConfig$ktor_client_okhttp().invoke(builderNewBuilder);
        Proxy proxy = getConfig().getProxy();
        if (proxy != null) {
            builderNewBuilder.proxy(proxy);
        }
        if (timeoutExtension != null) {
            OkHttpEngineKt.setupTimeoutAttributes(builderNewBuilder, timeoutExtension);
        }
        return builderNewBuilder.build();
    }
}
