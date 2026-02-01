package io.ktor.client.plugins;

import com.android.SdkConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.content.ObservableContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyProgress.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lio/ktor/client/plugins/BodyProgress;", "", "()V", SdkConstants.ATTR_HANDLE, "", "scope", "Lio/ktor/client/HttpClient;", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BodyProgress {

    /* renamed from: Plugin, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<BodyProgress> key = new AttributeKey<>("BodyProgress");

    /* JADX INFO: Access modifiers changed from: private */
    public final void handle(HttpClient scope) {
        PipelinePhase pipelinePhase = new PipelinePhase("ObservableContent");
        scope.getRequestPipeline().insertPhaseAfter(HttpRequestPipeline.INSTANCE.getRender(), pipelinePhase);
        scope.getRequestPipeline().intercept(pipelinePhase, new AnonymousClass1(null));
        scope.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getAfter(), new AnonymousClass2(null));
    }

    /* compiled from: BodyProgress.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$1", f = "BodyProgress.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.BodyProgress$handle$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                Object obj2 = this.L$1;
                Function3 function3 = (Function3) ((HttpRequestBuilder) pipelineContext.getContext()).getAttributes().getOrNull(BodyProgressKt.UploadProgressListenerAttributeKey);
                if (function3 == null) {
                    return Unit.INSTANCE;
                }
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(new ObservableContent((OutgoingContent) obj2, ((HttpRequestBuilder) pipelineContext.getContext()).getExecutionContext(), function3), this) == coroutine_suspended) {
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

    /* compiled from: BodyProgress.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.BodyProgress$handle$2", f = "BodyProgress.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.BodyProgress$handle$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = httpResponse;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                HttpResponse httpResponse = (HttpResponse) this.L$1;
                Function3 function3 = (Function3) httpResponse.getCall().getRequest().getAttributes().getOrNull(BodyProgressKt.DownloadProgressListenerAttributeKey);
                if (function3 == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(BodyProgressKt.withObservableDownload(httpResponse, function3), this) == coroutine_suspended) {
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

    /* compiled from: BodyProgress.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u00032\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0002\b\u0010H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/BodyProgress$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "", "Lio/ktor/client/plugins/BodyProgress;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.BodyProgress$Plugin, reason: from kotlin metadata */
    public static final class Companion implements HttpClientPlugin<Unit, BodyProgress> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<BodyProgress> getKey() {
            return BodyProgress.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public BodyProgress prepare(Function1<? super Unit, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new BodyProgress();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(BodyProgress plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            plugin.handle(scope);
        }
    }
}
