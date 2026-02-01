package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.InternalAPI;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@ø\u0001\u0000J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0017R\u000b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "closed", "", "config", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "checkExtensions", "", "requestData", "Lio/ktor/client/request/HttpRequestData;", "execute", "Lio/ktor/client/request/HttpResponseData;", "data", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWithinCallContext", "install", "client", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface HttpClientEngine extends CoroutineScope, Closeable {
    @InternalAPI
    Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    HttpClientEngineConfig getConfig();

    CoroutineDispatcher getDispatcher();

    Set<HttpClientEngineCapability<?>> getSupportedCapabilities();

    @InternalAPI
    void install(HttpClient client);

    /* compiled from: HttpClientEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            return SetsKt.emptySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean getClosed(HttpClientEngine httpClientEngine) {
            return !(((Job) httpClientEngine.getCoroutineContext().get(Job.INSTANCE)) != null ? r1.isActive() : false);
        }

        @InternalAPI
        public static void install(HttpClientEngine httpClientEngine, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            client.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getEngine(), new AnonymousClass1(client, httpClientEngine, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object executeWithinCallContext(io.ktor.client.engine.HttpClientEngine r10, io.ktor.client.request.HttpRequestData r11, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r12) {
            /*
                boolean r0 = r12 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L14
                r0 = r12
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r12 = r0.label
                int r12 = r12 - r2
                r0.label = r12
                goto L19
            L14:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r12)
            L19:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L42
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r12)
                goto L83
            L2d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L35:
                java.lang.Object r10 = r0.L$1
                r11 = r10
                io.ktor.client.request.HttpRequestData r11 = (io.ktor.client.request.HttpRequestData) r11
                java.lang.Object r10 = r0.L$0
                io.ktor.client.engine.HttpClientEngine r10 = (io.ktor.client.engine.HttpClientEngine) r10
                kotlin.ResultKt.throwOnFailure(r12)
                goto L56
            L42:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.Job r12 = r11.getExecutionContext()
                r0.L$0 = r10
                r0.L$1 = r11
                r0.label = r4
                java.lang.Object r12 = io.ktor.client.engine.HttpClientEngineKt.createCallContext(r10, r12, r0)
                if (r12 != r1) goto L56
                return r1
            L56:
                kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
                io.ktor.client.engine.KtorCallContextElement r2 = new io.ktor.client.engine.KtorCallContextElement
                r2.<init>(r12)
                kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
                kotlin.coroutines.CoroutineContext r5 = r12.plus(r2)
                r4 = r10
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r12 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r2 = 0
                r12.<init>(r10, r11, r2)
                r7 = r12
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 2
                r9 = 0
                r6 = 0
                kotlinx.coroutines.Deferred r10 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r12 = r10.await(r0)
                if (r12 != r1) goto L83
                return r1
            L83:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.executeWithinCallContext(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void checkExtensions(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData) {
            for (HttpClientEngineCapability<?> httpClientEngineCapability : httpRequestData.getRequiredCapabilities$ktor_client_core()) {
                if (!httpClientEngine.getSupportedCapabilities().contains(httpClientEngineCapability)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
                }
            }
        }
    }

    /* compiled from: HttpClientEngine.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", i = {0, 0}, l = {70, 82}, m = "invokeSuspend", n = {"$this$intercept", "requestData"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.engine.HttpClientEngine$install$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpClient $client;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ HttpClientEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$client = httpClient;
            this.this$0 = httpClientEngine;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$client, this.this$0, continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            HttpRequestData httpRequestDataBuild;
            PipelineContext pipelineContext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                Object obj2 = this.L$1;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.takeFromWithExecutionContext((HttpRequestBuilder) pipelineContext2.getContext());
                if (obj2 == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KType kTypeTypeOf = Reflection.typeOf(Object.class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf), Reflection.getOrCreateKotlinClass(Object.class), kTypeTypeOf));
                } else if (obj2 instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(obj2);
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.setBody(obj2);
                    KType kTypeTypeOf2 = Reflection.typeOf(Object.class);
                    httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(kTypeTypeOf2), Reflection.getOrCreateKotlinClass(Object.class), kTypeTypeOf2));
                }
                this.$client.getMonitor().raise(ClientEventsKt.getHttpRequestIsReadyForSending(), httpRequestBuilder);
                httpRequestDataBuild = httpRequestBuilder.build();
                httpRequestDataBuild.getAttributes().put(HttpClientEngineKt.getCLIENT_CONFIG(), this.$client.getConfig$ktor_client_core());
                HttpClientEngineKt.validateHeaders(httpRequestDataBuild);
                DefaultImpls.checkExtensions(this.this$0, httpRequestDataBuild);
                this.L$0 = pipelineContext2;
                this.L$1 = httpRequestDataBuild;
                this.label = 1;
                Object objExecuteWithinCallContext = DefaultImpls.executeWithinCallContext(this.this$0, httpRequestDataBuild, this);
                if (objExecuteWithinCallContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext = pipelineContext2;
                obj = objExecuteWithinCallContext;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                httpRequestDataBuild = (HttpRequestData) this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            HttpClientCall httpClientCall = new HttpClientCall(this.$client, httpRequestDataBuild, (HttpResponseData) obj);
            final HttpResponse response = httpClientCall.getResponse();
            this.$client.getMonitor().raise(ClientEventsKt.getHttpResponseReceived(), response);
            Job job = JobKt.getJob(response.getCoroutineContext());
            final HttpClient httpClient = this.$client;
            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.HttpClientEngine.install.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        httpClient.getMonitor().raise(ClientEventsKt.getHttpResponseCancelled(), response);
                    }
                }
            });
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (pipelineContext.proceedWith(httpClientCall, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }
}
