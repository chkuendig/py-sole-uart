package io.ktor.client.plugins.websocket;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: WebSockets.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.WebSockets$Plugin$install$2", f = "WebSockets.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class WebSockets$Plugin$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $extensionsSupported;
    final /* synthetic */ WebSockets $plugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebSockets$Plugin$install$2(WebSockets webSockets, boolean z, Continuation<? super WebSockets$Plugin$install$2> continuation) {
        super(3, continuation);
        this.$plugin = webSockets;
        this.$extensionsSupported = z;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        WebSockets$Plugin$install$2 webSockets$Plugin$install$2 = new WebSockets$Plugin$install$2(this.$plugin, this.$extensionsSupported, continuation);
        webSockets$Plugin$install$2.L$0 = pipelineContext;
        webSockets$Plugin$install$2.L$1 = httpResponseContainer;
        return webSockets$Plugin$install$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DelegatingClientWebSocketSession delegatingClientWebSocketSession;
        List<? extends WebSocketExtension<?>> listEmptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) this.L$1;
            TypeInfo expectedType = httpResponseContainer.getExpectedType();
            Object response = httpResponseContainer.getResponse();
            if (!(response instanceof WebSocketSession)) {
                WebSocketsKt.getLOGGER().trace("Skipping non-websocket response from " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + ": " + response);
                return Unit.INSTANCE;
            }
            WebSocketsKt.getLOGGER().trace("Receive websocket session from " + ((HttpClientCall) pipelineContext.getContext()).getRequest().getUrl() + ": " + response);
            if (Intrinsics.areEqual(expectedType.getType(), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class))) {
                DefaultClientWebSocketSession defaultClientWebSocketSession = new DefaultClientWebSocketSession((HttpClientCall) pipelineContext.getContext(), this.$plugin.convertSessionToDefault$ktor_client_core((WebSocketSession) response));
                if (this.$extensionsSupported) {
                    listEmptyList = this.$plugin.completeNegotiation((HttpClientCall) pipelineContext.getContext());
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                defaultClientWebSocketSession.start(listEmptyList);
                delegatingClientWebSocketSession = defaultClientWebSocketSession;
            } else {
                delegatingClientWebSocketSession = new DelegatingClientWebSocketSession((HttpClientCall) pipelineContext.getContext(), (WebSocketSession) response);
            }
            this.L$0 = null;
            this.label = 1;
            if (pipelineContext.proceedWith(new HttpResponseContainer(expectedType, delegatingClientWebSocketSession), this) == coroutine_suspended) {
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
