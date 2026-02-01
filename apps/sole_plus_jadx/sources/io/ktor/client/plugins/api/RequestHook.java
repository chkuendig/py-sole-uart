package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KtorCallContexts.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002S\u0012O\u0012M\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002¢\u0006\u0002\b\f0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\rJk\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102Q\u0010\u0011\u001aM\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002¢\u0006\u0002\b\fH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/api/RequestHook;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function4;", "Lio/ktor/client/plugins/api/OnRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/ParameterName;", "name", "request", "", "content", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "()V", "install", "client", "Lio/ktor/client/HttpClient;", "handler", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function4;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RequestHook implements ClientHook<Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object>> {
    public static final RequestHook INSTANCE = new RequestHook();

    private RequestHook() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public /* bridge */ /* synthetic */ void install(HttpClient httpClient, Function4<? super OnRequestContext, ? super HttpRequestBuilder, ? super Object, ? super Continuation<? super Unit>, ? extends Object> function4) {
        install2(httpClient, (Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object>) function4);
    }

    /* compiled from: KtorCallContexts.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.api.RequestHook$install$1", f = "KtorCallContexts.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.api.RequestHook$install$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<OnRequestContext, HttpRequestBuilder, Object, Continuation<? super Unit>, Object> $handler;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$handler = function4;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, continuation);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                Function4<OnRequestContext, HttpRequestBuilder, Object, Continuation<? super Unit>, Object> function4 = this.$handler;
                OnRequestContext onRequestContext = new OnRequestContext();
                Object context = pipelineContext.getContext();
                Object subject = pipelineContext.getSubject();
                this.label = 1;
                if (function4.invoke(onRequestContext, context, subject, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: install, reason: avoid collision after fix types in other method */
    public void install2(HttpClient client, Function4<? super OnRequestContext, ? super HttpRequestBuilder, Object, ? super Continuation<? super Unit>, ? extends Object> handler) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(handler, "handler");
        client.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getState(), new AnonymousClass1(handler, null));
    }
}
