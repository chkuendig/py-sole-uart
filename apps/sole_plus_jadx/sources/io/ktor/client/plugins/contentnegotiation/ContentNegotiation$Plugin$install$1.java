package io.ktor.client.plugins.contentnegotiation;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: ContentNegotiation.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.contentnegotiation.ContentNegotiation$Plugin$install$1", f = "ContentNegotiation.kt", i = {0}, l = {251, 252}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class ContentNegotiation$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContentNegotiation $plugin;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentNegotiation$Plugin$install$1(ContentNegotiation contentNegotiation, Continuation<? super ContentNegotiation$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = contentNegotiation;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        ContentNegotiation$Plugin$install$1 contentNegotiation$Plugin$install$1 = new ContentNegotiation$Plugin$install$1(this.$plugin, continuation);
        contentNegotiation$Plugin$install$1.L$0 = pipelineContext;
        return contentNegotiation$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pipelineContext = (PipelineContext) this.L$0;
            this.L$0 = pipelineContext;
            this.label = 1;
            obj = this.$plugin.convertRequest$ktor_client_content_negotiation((HttpRequestBuilder) pipelineContext.getContext(), pipelineContext.getSubject(), this);
            if (obj == coroutine_suspended) {
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
            pipelineContext = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (obj == null) {
            return Unit.INSTANCE;
        }
        this.L$0 = null;
        this.label = 2;
        if (pipelineContext.proceedWith(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
