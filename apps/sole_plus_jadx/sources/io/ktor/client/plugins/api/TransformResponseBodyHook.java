package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.content.NullBody;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KtorCallContexts.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002j\u0012f\u0012d\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0002¢\u0006\u0002\b\u000e0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u000fJ\u0082\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132h\u0010\u0014\u001ad\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0002¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/api/TransformResponseBodyHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function5;", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lio/ktor/utils/io/ByteReadChannel;", "content", "Lio/ktor/util/reflect/TypeInfo;", "requestedType", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "()V", "install", "", "client", "Lio/ktor/client/HttpClient;", "handler", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function5;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TransformResponseBodyHook implements ClientHook<Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<? super Object>, ? extends Object>> {
    public static final TransformResponseBodyHook INSTANCE = new TransformResponseBodyHook();

    private TransformResponseBodyHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient httpClient, Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<? super Object>, ? extends Object> function5) {
        install2(httpClient, (Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<Object>, ? extends Object>) function5);
    }

    /* compiled from: KtorCallContexts.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.api.TransformResponseBodyHook$install$1", f = "KtorCallContexts.kt", i = {0, 0}, l = {108, 115}, m = "invokeSuspend", n = {"$this$intercept", "typeInfo"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.api.TransformResponseBodyHook$install$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<Object>, Object> $handler;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<Object>, ? extends Object> function5, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$handler = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, continuation);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PipelineContext pipelineContext;
            TypeInfo typeInfo;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                HttpResponseContainer httpResponseContainer = (HttpResponseContainer) pipelineContext2.getSubject();
                TypeInfo expectedType = httpResponseContainer.getExpectedType();
                Object response = httpResponseContainer.getResponse();
                if (!(response instanceof ByteReadChannel)) {
                    return Unit.INSTANCE;
                }
                Function5<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, Continuation<Object>, Object> function5 = this.$handler;
                TransformResponseBodyContext transformResponseBodyContext = new TransformResponseBodyContext();
                HttpResponse response2 = ((HttpClientCall) pipelineContext2.getContext()).getResponse();
                this.L$0 = pipelineContext2;
                this.L$1 = expectedType;
                this.label = 1;
                Object objInvoke = function5.invoke(transformResponseBodyContext, response2, response, expectedType, this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext = pipelineContext2;
                obj = objInvoke;
                typeInfo = expectedType;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                typeInfo = (TypeInfo) this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (obj == null) {
                return Unit.INSTANCE;
            }
            if (!(obj instanceof NullBody) && !typeInfo.getType().isInstance(obj)) {
                throw new IllegalStateException("transformResponseBody returned " + obj + " but expected value of type " + typeInfo);
            }
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (pipelineContext.proceedWith(new HttpResponseContainer(typeInfo, obj), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: install, reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<Object>, ? extends Object> handler) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(handler, "handler");
        client.getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new AnonymousClass1(handler, null));
    }
}
