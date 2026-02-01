package io.ktor.util.pipeline;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import io.ktor.util.debug.ContextUtilsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.objectweb.asm.Opcodes;

/* compiled from: Pipeline.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001az\u0010\u0007\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0003*\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\t\u001a\u00020\n2;\b\b\u0010\u000b\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0010*|\u0010\u0011\u001a\u0004\b\u0000\u0010\b\u001a\u0004\b\u0001\u0010\u0002\"5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f¢\u0006\u0002\b\u000f25\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f¢\u0006\u0002\b\u000f*p\b\u0000\u0010\u0012\u001a\u0004\b\u0000\u0010\b\u001a\u0004\b\u0001\u0010\u0002\".\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00020\r\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"execute", "", "TContext", "", "Lio/ktor/util/pipeline/Pipeline;", SdkConstants.ATTR_CONTEXT, "(Lio/ktor/util/pipeline/Pipeline;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "TSubject", TypedValues.CycleType.S_WAVE_PHASE, "Lio/ktor/util/pipeline/PipelinePhase;", "block", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/util/pipeline/Pipeline;Lio/ktor/util/pipeline/PipelinePhase;Lkotlin/jvm/functions/Function3;)V", "PipelineInterceptor", "PipelineInterceptorFunction", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PipelineKt {

    /* compiled from: Pipeline.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "TContext", ""}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$execute$2", f = "Pipeline.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.pipeline.PipelineKt$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ TContext $context;
        final /* synthetic */ Pipeline<Unit, TContext> $this_execute;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$this_execute = pipeline;
            this.$context = tcontext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_execute, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$this_execute.execute(this.$context, Unit.INSTANCE, this) == coroutine_suspended) {
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

    public static final <TContext> Object execute(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super Unit> continuation) {
        Object objInitContextInDebugMode = ContextUtilsKt.initContextInDebugMode(new AnonymousClass2(pipeline, tcontext, null), continuation);
        return objInitContextInDebugMode == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInitContextInDebugMode : Unit.INSTANCE;
    }

    private static final <TContext> Object execute$$forInline(Pipeline<Unit, TContext> pipeline, TContext tcontext, Continuation<? super Unit> continuation) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(pipeline, tcontext, null);
        InlineMarker.mark(0);
        ContextUtilsKt.initContextInDebugMode(anonymousClass2, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Add missing generic type declarations: [TContext] */
    /* compiled from: Pipeline.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u0010\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "TSubject", "", "TContext", "Lio/ktor/util/pipeline/PipelineContext;", "subject"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", i = {}, l = {494}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.util.pipeline.PipelineKt$intercept$1, reason: invalid class name */
    public static final class AnonymousClass1<TContext> extends SuspendLambda implements Function3<PipelineContext<? extends Object, TContext>, Object, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$block = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<? extends Object, TContext> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, continuation);
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
                Intrinsics.reifiedOperationMarker(3, "TSubject");
                if (!(obj2 instanceof Object)) {
                    return Unit.INSTANCE;
                }
                if (!(pipelineContext instanceof PipelineContext)) {
                    pipelineContext = null;
                }
                if (pipelineContext != null) {
                    Function3<PipelineContext<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object> function3 = this.$block;
                    this.L$0 = null;
                    this.label = 1;
                    if (function3.invoke(pipelineContext, obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public static final /* synthetic */ <TSubject, TContext> void intercept(Pipeline<?, TContext> pipeline, PipelinePhase phase, Function3<? super PipelineContext<TSubject, TContext>, ? super TSubject, ? super Continuation<? super Unit>, ? extends Object> block) throws InvalidPhaseException {
        Intrinsics.checkNotNullParameter(pipeline, "<this>");
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.needClassReification();
        pipeline.intercept(phase, new AnonymousClass1(block, null));
    }
}
