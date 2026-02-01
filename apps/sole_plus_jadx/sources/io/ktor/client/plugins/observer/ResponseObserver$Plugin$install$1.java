package io.ktor.client.plugins.observer;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.ByteChannelsKt;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1", f = "ResponseObserver.kt", i = {0, 0, 0}, l = {68, 80}, m = "invokeSuspend", n = {"$this$intercept", "newResponse", "sideResponse"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
final class ResponseObserver$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseObserver $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ResponseObserver$Plugin$install$1(ResponseObserver responseObserver, HttpClient httpClient, Continuation<? super ResponseObserver$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = responseObserver;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseObserver$Plugin$install$1 responseObserver$Plugin$install$1 = new ResponseObserver$Plugin$install$1(this.$plugin, this.$scope, continuation);
        responseObserver$Plugin$install$1.L$0 = pipelineContext;
        responseObserver$Plugin$install$1.L$1 = httpResponse;
        return responseObserver$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlinx.coroutines.CoroutineScope] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpResponse httpResponse;
        PipelineContext pipelineContext;
        HttpResponse httpResponse2;
        HttpClient httpClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
            HttpResponse httpResponse3 = (HttpResponse) this.L$1;
            Function1 function1 = this.$plugin.filter;
            if (function1 != null && !((Boolean) function1.invoke(httpResponse3.getCall())).booleanValue()) {
                return Unit.INSTANCE;
            }
            Pair<ByteReadChannel, ByteReadChannel> pairSplit = ByteChannelsKt.split(httpResponse3.getContent(), httpResponse3);
            ByteReadChannel byteReadChannelComponent1 = pairSplit.component1();
            HttpResponse response = DelegatedCallKt.wrapWithContent(httpResponse3.getCall(), pairSplit.component2()).getResponse();
            HttpResponse response2 = DelegatedCallKt.wrapWithContent(httpResponse3.getCall(), byteReadChannelComponent1).getResponse();
            HttpClient httpClient2 = this.$scope;
            this.L$0 = pipelineContext2;
            this.L$1 = response;
            this.L$2 = response2;
            this.L$3 = httpClient2;
            this.label = 1;
            Object responseObserverContext = ResponseObserverContextJvmKt.getResponseObserverContext(this);
            if (responseObserverContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpResponse = response;
            pipelineContext = pipelineContext2;
            httpResponse2 = response2;
            obj = responseObserverContext;
            httpClient = httpClient2;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ?? r1 = (CoroutineScope) this.L$3;
            HttpResponse httpResponse4 = (HttpResponse) this.L$2;
            HttpResponse httpResponse5 = (HttpResponse) this.L$1;
            PipelineContext pipelineContext3 = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
            httpResponse = httpResponse5;
            pipelineContext = pipelineContext3;
            httpClient = r1;
            httpResponse2 = httpResponse4;
        }
        BuildersKt__Builders_commonKt.launch$default(httpClient, (CoroutineContext) obj, null, new AnonymousClass1(this.$plugin, httpResponse2, null), 2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(httpResponse, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: ResponseObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1", f = "ResponseObserver.kt", i = {}, l = {70, 76}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserver$Plugin$install$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResponseObserver $plugin;
        final /* synthetic */ HttpResponse $sideResponse;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ResponseObserver responseObserver, HttpResponse httpResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$plugin = responseObserver;
            this.$sideResponse = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$plugin, this.$sideResponse, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = this.$plugin.responseHandler;
                HttpResponse httpResponse = this.$sideResponse;
                this.label = 1;
                if (function2.invoke(httpResponse, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ByteReadChannel content = this.$sideResponse.getContent();
            if (!content.isClosedForRead()) {
                this.label = 2;
                if (ByteReadChannelKt.discard(content, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
