package io.ktor.client;

import androidx.core.app.NotificationCompat;
import com.android.SdkConstants;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.BodyProgress;
import io.ktor.client.plugins.DefaultResponseValidationKt;
import io.ktor.client.plugins.DefaultTransformKt;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpPlainText;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.plugins.HttpRequestLifecycle;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.client.utils.HttpResponseReceiveFail;
import io.ktor.events.Events;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.objectweb.asm.Opcodes;

/* compiled from: HttpClient.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0018\u00002\u00020R2\u00060Sj\u0002`TB)\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0011\u001a\u00020\u00002\u001b\u0010\u0010\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u00062\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u00100\u001a\u0004\b1\u00102R\u0017\u00103\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00107R\u0017\u00109\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010C\u001a\u00020B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010H\u001a\u00020G8\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010M\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngine;", "engine", "Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "userConfig", "", "manageEngine", SdkConstants.CONSTRUCTOR_NAME, "(Lio/ktor/client/engine/HttpClientEngine;Lio/ktor/client/HttpClientConfig;Z)V", "(Lio/ktor/client/engine/HttpClientEngine;Lio/ktor/client/HttpClientConfig;)V", "", "close", "()V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "config", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/call/HttpClientCall;", "execute$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lio/ktor/client/engine/HttpClientEngineCapability;", "capability", "isSupported", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Z", "", "toString", "()Ljava/lang/String;", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "Lkotlinx/coroutines/CompletableJob;", "clientJob", "Lkotlinx/coroutines/CompletableJob;", "Lio/ktor/client/HttpClientConfig;", "getConfig$ktor_client_core", "()Lio/ktor/client/HttpClientConfig;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/client/engine/HttpClientEngine;", "getEngine", "()Lio/ktor/client/engine/HttpClientEngine;", "engineConfig", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getEngineConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "Z", "Lio/ktor/events/Events;", "monitor", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "Lio/ktor/client/statement/HttpReceivePipeline;", "receivePipeline", "Lio/ktor/client/statement/HttpReceivePipeline;", "getReceivePipeline", "()Lio/ktor/client/statement/HttpReceivePipeline;", "Lio/ktor/client/request/HttpRequestPipeline;", "requestPipeline", "Lio/ktor/client/request/HttpRequestPipeline;", "getRequestPipeline", "()Lio/ktor/client/request/HttpRequestPipeline;", "Lio/ktor/client/statement/HttpResponsePipeline;", "responsePipeline", "Lio/ktor/client/statement/HttpResponsePipeline;", "getResponsePipeline", "()Lio/ktor/client/statement/HttpResponsePipeline;", "Lio/ktor/client/request/HttpSendPipeline;", "sendPipeline", "Lio/ktor/client/request/HttpSendPipeline;", "getSendPipeline", "()Lio/ktor/client/request/HttpSendPipeline;", "ktor-client-core", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpClient implements CoroutineScope, Closeable {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");
    private final Attributes attributes;
    private final CompletableJob clientJob;
    private volatile /* synthetic */ int closed;
    private final HttpClientConfig<HttpClientEngineConfig> config;
    private final CoroutineContext coroutineContext;
    private final HttpClientEngine engine;
    private final HttpClientEngineConfig engineConfig;
    private boolean manageEngine;
    private final Events monitor;
    private final HttpReceivePipeline receivePipeline;
    private final HttpRequestPipeline requestPipeline;
    private final HttpResponsePipeline responsePipeline;
    private final HttpSendPipeline sendPipeline;
    private final HttpClientConfig<? extends HttpClientEngineConfig> userConfig;

    public HttpClient(HttpClientEngine engine, HttpClientConfig<? extends HttpClientEngineConfig> userConfig) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        this.engine = engine;
        this.userConfig = userConfig;
        this.closed = 0;
        CompletableJob completableJobJob = JobKt.Job((Job) engine.getCoroutineContext().get(Job.INSTANCE));
        this.clientJob = completableJobJob;
        this.coroutineContext = engine.getCoroutineContext().plus(completableJobJob);
        this.requestPipeline = new HttpRequestPipeline(userConfig.getDevelopmentMode());
        HttpResponsePipeline httpResponsePipeline = new HttpResponsePipeline(userConfig.getDevelopmentMode());
        this.responsePipeline = httpResponsePipeline;
        HttpSendPipeline httpSendPipeline = new HttpSendPipeline(userConfig.getDevelopmentMode());
        this.sendPipeline = httpSendPipeline;
        this.receivePipeline = new HttpReceivePipeline(userConfig.getDevelopmentMode());
        this.attributes = AttributesJvmKt.Attributes(true);
        this.engineConfig = engine.getConfig();
        this.monitor = new Events();
        HttpClientConfig<HttpClientEngineConfig> httpClientConfig = new HttpClientConfig<>();
        this.config = httpClientConfig;
        if (this.manageEngine) {
            completableJobJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClient.1
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
                    if (th != null) {
                        CoroutineScopeKt.cancel$default(HttpClient.this.getEngine(), null, 1, null);
                    }
                }
            });
        }
        engine.install(this);
        httpSendPipeline.intercept(HttpSendPipeline.INSTANCE.getReceive(), new AnonymousClass2(null));
        HttpClientConfig.install$default(httpClientConfig, HttpRequestLifecycle.INSTANCE, null, 2, null);
        HttpClientConfig.install$default(httpClientConfig, BodyProgress.INSTANCE, null, 2, null);
        if (userConfig.getUseDefaultTransformers()) {
            httpClientConfig.install("DefaultTransformers", new Function1<HttpClient, Unit>() { // from class: io.ktor.client.HttpClient$3$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpClient httpClient) {
                    invoke2(httpClient);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpClient install) {
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    DefaultTransformKt.defaultTransformers(install);
                }
            });
        }
        HttpClientConfig.install$default(httpClientConfig, HttpSend.INSTANCE, null, 2, null);
        HttpClientConfig.install$default(httpClientConfig, HttpCallValidator.INSTANCE, null, 2, null);
        if (userConfig.getFollowRedirects()) {
            HttpClientConfig.install$default(httpClientConfig, HttpRedirect.INSTANCE, null, 2, null);
        }
        httpClientConfig.plusAssign(userConfig);
        if (userConfig.getUseDefaultTransformers()) {
            HttpClientConfig.install$default(httpClientConfig, HttpPlainText.INSTANCE, null, 2, null);
        }
        DefaultResponseValidationKt.addDefaultResponseValidation(httpClientConfig);
        httpClientConfig.install(this);
        httpResponsePipeline.intercept(HttpResponsePipeline.INSTANCE.getReceive(), new AnonymousClass4(null));
    }

    public final HttpClientEngine getEngine() {
        return this.engine;
    }

    public /* synthetic */ HttpClient(HttpClientEngine httpClientEngine, HttpClientConfig httpClientConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClientEngine, (i & 2) != 0 ? new HttpClientConfig() : httpClientConfig);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClient(HttpClientEngine engine, HttpClientConfig<? extends HttpClientEngineConfig> userConfig, boolean z) {
        this(engine, userConfig);
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        this.manageEngine = z;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final HttpRequestPipeline getRequestPipeline() {
        return this.requestPipeline;
    }

    public final HttpResponsePipeline getResponsePipeline() {
        return this.responsePipeline;
    }

    public final HttpSendPipeline getSendPipeline() {
        return this.sendPipeline;
    }

    public final HttpReceivePipeline getReceivePipeline() {
        return this.receivePipeline;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final HttpClientEngineConfig getEngineConfig() {
        return this.engineConfig;
    }

    public final Events getMonitor() {
        return this.monitor;
    }

    public final HttpClientConfig<HttpClientEngineConfig> getConfig$ktor_client_core() {
        return this.config;
    }

    /* compiled from: HttpClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", i = {0, 0}, l = {144, 146}, m = "invokeSuspend", n = {"$this$intercept", NotificationCompat.CATEGORY_CALL}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.HttpClient$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = HttpClient.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = obj;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            PipelineContext pipelineContext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                obj2 = this.L$1;
                if (!(obj2 instanceof HttpClientCall)) {
                    throw new IllegalStateException(("Error: HttpClientCall expected, but found " + obj2 + '(' + Reflection.getOrCreateKotlinClass(obj2.getClass()) + ").").toString());
                }
                this.L$0 = pipelineContext2;
                this.L$1 = obj2;
                this.label = 1;
                Object objExecute = HttpClient.this.getReceivePipeline().execute(Unit.INSTANCE, ((HttpClientCall) obj2).getResponse(), this);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext = pipelineContext2;
                obj = objExecute;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                obj2 = this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ((HttpClientCall) obj2).setResponse$ktor_client_core((HttpResponse) obj);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (pipelineContext.proceedWith(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HttpClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", i = {0}, l = {Opcodes.RETURN}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
    /* renamed from: io.ktor.client.HttpClient$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = HttpClient.this.new AnonymousClass4(continuation);
            anonymousClass4.L$0 = pipelineContext;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PipelineContext pipelineContext;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pipelineContext = (PipelineContext) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    HttpClient.this.getMonitor().raise(ClientEventsKt.getHttpResponseReceiveFailed(), new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.getContext()).getResponse(), th));
                    throw th;
                }
            }
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
            try {
                this.L$0 = pipelineContext2;
                this.label = 1;
                if (pipelineContext2.proceed(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                pipelineContext = pipelineContext2;
                th = th3;
                HttpClient.this.getMonitor().raise(ClientEventsKt.getHttpResponseReceiveFailed(), new HttpResponseReceiveFail(((HttpClientCall) pipelineContext.getContext()).getResponse(), th));
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute$ktor_client_core(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.HttpClient$execute$1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.HttpClient$execute$1 r0 = (io.ktor.client.HttpClient$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.HttpClient$execute$1 r0 = new io.ktor.client.HttpClient$execute$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.events.Events r6 = r4.monitor
            io.ktor.events.EventDefinition r2 = io.ktor.client.utils.ClientEventsKt.getHttpRequestCreated()
            r6.raise(r2, r5)
            io.ktor.client.request.HttpRequestPipeline r6 = r4.requestPipeline
            java.lang.Object r2 = r5.getBody()
            r0.label = r3
            java.lang.Object r6 = r6.execute(r5, r2, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            java.lang.String r5 = "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r5)
            io.ktor.client.call.HttpClientCall r6 = (io.ktor.client.call.HttpClientCall) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.HttpClient.execute$ktor_client_core(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isSupported(HttpClientEngineCapability<?> capability) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        return this.engine.getSupportedCapabilities().contains(capability);
    }

    public final HttpClient config(Function1<? super HttpClientConfig<?>, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        HttpClientEngine httpClientEngine = this.engine;
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.plusAssign(this.userConfig);
        block.invoke(httpClientConfig);
        return new HttpClient(httpClientEngine, httpClientConfig, this.manageEngine);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            Attributes attributes = (Attributes) this.attributes.get(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST());
            Iterator<T> it = attributes.getAllKeys().iterator();
            while (it.hasNext()) {
                AttributeKey attributeKey = (AttributeKey) it.next();
                Intrinsics.checkNotNull(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object obj = attributes.get(attributeKey);
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                }
            }
            this.clientJob.complete();
            if (this.manageEngine) {
                this.engine.close();
            }
        }
    }

    public String toString() {
        return "HttpClient[" + this.engine + AbstractJsonLexerKt.END_LIST;
    }
}
