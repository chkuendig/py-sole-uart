package io.ktor.utils.io.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

/* compiled from: CancellableReusableContinuation.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\f:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00062\u0010\u0010\u0011\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001a\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\bJ\u001f\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0015\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "", ExifInterface.GPS_DIRECTION_TRUE, SdkConstants.CONSTRUCTOR_NAME, "()V", "value", "", "close", "(Ljava/lang/Object;)V", "", "cause", "(Ljava/lang/Throwable;)V", "Lkotlin/coroutines/Continuation;", "actual", "completeSuspendBlock", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/internal/CancellableReusableContinuation$JobRelation;", "relation", "notParent", "(Lio/ktor/utils/io/internal/CancellableReusableContinuation$JobRelation;)V", "Lkotlin/coroutines/CoroutineContext;", SdkConstants.ATTR_CONTEXT, SdkConstants.ATTR_PARENT, "(Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/Job;", "job", "exception", "resumeWithExceptionContinuationOnly", "(Lkotlinx/coroutines/Job;Ljava/lang/Throwable;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "JobRelation", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CancellableReusableContinuation<T> implements Continuation<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, ServerProtocol.DIALOG_PARAM_STATE);
    private static final /* synthetic */ AtomicReferenceFieldUpdater jobCancellationHandler$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableReusableContinuation.class, Object.class, "jobCancellationHandler");
    private volatile /* synthetic */ Object state = null;
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    public final void close(T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Result.Companion companion = Result.INSTANCE;
        resumeWith(Result.m9087constructorimpl(value));
        JobRelation jobRelation = (JobRelation) jobCancellationHandler$FU.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.dispose();
        }
    }

    public final void close(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Result.Companion companion = Result.INSTANCE;
        resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(cause)));
        JobRelation jobRelation = (JobRelation) jobCancellationHandler$FU.getAndSet(this, null);
        if (jobRelation != null) {
            jobRelation.dispose();
        }
    }

    public final Object completeSuspendBlock(Continuation<? super T> actual) throws Throwable {
        Intrinsics.checkNotNullParameter(actual, "actual");
        while (true) {
            Object obj = this.state;
            if (obj == null) {
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, null, actual)) {
                    parent(actual.getContext());
                    return IntrinsicsKt.getCOROUTINE_SUSPENDED();
                }
            } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, obj, null)) {
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of io.ktor.utils.io.internal.CancellableReusableContinuation");
                return obj;
            }
        }
    }

    private final void parent(CoroutineContext context) {
        Object obj;
        JobRelation jobRelation;
        Job job = (Job) context.get(Job.INSTANCE);
        JobRelation jobRelation2 = (JobRelation) this.jobCancellationHandler;
        if ((jobRelation2 != null ? jobRelation2.getJob() : null) == job) {
            return;
        }
        if (job == null) {
            JobRelation jobRelation3 = (JobRelation) jobCancellationHandler$FU.getAndSet(this, null);
            if (jobRelation3 != null) {
                jobRelation3.dispose();
                return;
            }
            return;
        }
        JobRelation jobRelation4 = new JobRelation(this, job);
        do {
            obj = this.jobCancellationHandler;
            jobRelation = (JobRelation) obj;
            if (jobRelation != null && jobRelation.getJob() == job) {
                jobRelation4.dispose();
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(jobCancellationHandler$FU, this, obj, jobRelation4));
        if (jobRelation != null) {
            jobRelation.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notParent(CancellableReusableContinuation<T>.JobRelation relation) {
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(jobCancellationHandler$FU, this, relation, null);
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext context;
        Object obj = this.state;
        Continuation continuation = obj instanceof Continuation ? (Continuation) obj : null;
        return (continuation == null || (context = continuation.getContext()) == null) ? EmptyCoroutineContext.INSTANCE : context;
    }

    /* compiled from: CancellableReusableContinuation.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/internal/CancellableReusableContinuation$JobRelation;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "job", "Lkotlinx/coroutines/Job;", "(Lio/ktor/utils/io/internal/CancellableReusableContinuation;Lkotlinx/coroutines/Job;)V", "handler", "Lkotlinx/coroutines/DisposableHandle;", "getJob", "()Lkotlinx/coroutines/Job;", "dispose", "invoke", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class JobRelation implements Function1<Throwable, Unit> {
        private DisposableHandle handler;
        private final Job job;
        final /* synthetic */ CancellableReusableContinuation<T> this$0;

        public JobRelation(CancellableReusableContinuation cancellableReusableContinuation, Job job) {
            Intrinsics.checkNotNullParameter(job, "job");
            this.this$0 = cancellableReusableContinuation;
            this.job = job;
            DisposableHandle disposableHandleInvokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, this, 2, null);
            if (job.isActive()) {
                this.handler = disposableHandleInvokeOnCompletion$default;
            }
        }

        public final Job getJob() {
            return this.job;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable cause) {
            this.this$0.notParent(this);
            dispose();
            if (cause != null) {
                this.this$0.resumeWithExceptionContinuationOnly(this.job, cause);
            }
        }

        public final void dispose() {
            DisposableHandle disposableHandle = this.handler;
            if (disposableHandle != null) {
                this.handler = null;
                disposableHandle.dispose();
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        Object obj;
        Object objM9090exceptionOrNullimpl;
        do {
            obj = this.state;
            if (obj == null) {
                objM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(result);
                if (objM9090exceptionOrNullimpl == null) {
                    ResultKt.throwOnFailure(result);
                    objM9090exceptionOrNullimpl = result;
                }
            } else if (!(obj instanceof Continuation)) {
                return;
            } else {
                objM9090exceptionOrNullimpl = null;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, obj, objM9090exceptionOrNullimpl));
        if (obj instanceof Continuation) {
            ((Continuation) obj).resumeWith(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeWithExceptionContinuationOnly(Job job, Throwable exception) {
        Object obj;
        Continuation continuation;
        do {
            obj = this.state;
            if (!(obj instanceof Continuation)) {
                return;
            }
            continuation = (Continuation) obj;
            if (continuation.getContext().get(Job.INSTANCE) != job) {
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, obj, null));
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m9087constructorimpl(ResultKt.createFailure(exception)));
    }
}
