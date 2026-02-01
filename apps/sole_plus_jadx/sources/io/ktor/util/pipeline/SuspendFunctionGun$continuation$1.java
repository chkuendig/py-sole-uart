package io.ktor.util.pipeline;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuspendFunctionGun.kt */
@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0010\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0002J\u001e\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u001c\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"io/ktor/util/pipeline/SuspendFunctionGun$continuation$1", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lio/ktor/util/CoroutineStackFrame;", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", SdkConstants.ATTR_CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentIndex", "", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lio/ktor/util/StackTraceElement;", "peekContinuation", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SuspendFunctionGun$continuation$1 implements Continuation<Unit>, CoroutineStackFrame {
    private int currentIndex = Integer.MIN_VALUE;
    final /* synthetic */ SuspendFunctionGun<TSubject, TContext> this$0;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    SuspendFunctionGun$continuation$1(SuspendFunctionGun<TSubject, TContext> suspendFunctionGun) {
        this.this$0 = suspendFunctionGun;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<?> continuationPeekContinuation = peekContinuation();
        if (continuationPeekContinuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuationPeekContinuation;
        }
        return null;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final void setCurrentIndex(int i) {
        this.currentIndex = i;
    }

    private final Continuation<?> peekContinuation() {
        if (this.currentIndex == Integer.MIN_VALUE) {
            this.currentIndex = ((SuspendFunctionGun) this.this$0).lastSuspensionIndex;
        }
        if (this.currentIndex >= 0) {
            try {
                Continuation<?>[] continuationArr = ((SuspendFunctionGun) this.this$0).suspensions;
                int i = this.currentIndex;
                Continuation<?> continuation = continuationArr[i];
                if (continuation == null) {
                    return StackWalkingFailedFrame.INSTANCE;
                }
                this.currentIndex = i - 1;
                return continuation;
            } catch (Throwable unused) {
                return StackWalkingFailedFrame.INSTANCE;
            }
        }
        this.currentIndex = Integer.MIN_VALUE;
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext get$context() {
        CoroutineContext coroutineContext;
        Continuation continuation = ((SuspendFunctionGun) this.this$0).suspensions[((SuspendFunctionGun) this.this$0).lastSuspensionIndex];
        if (continuation == null || (coroutineContext = continuation.get$context()) == null) {
            throw new IllegalStateException("Not started".toString());
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        if (!Result.m9093isFailureimpl(result)) {
            this.this$0.loop(false);
            return;
        }
        SuspendFunctionGun<TSubject, TContext> suspendFunctionGun = this.this$0;
        Result.Companion companion = Result.INSTANCE;
        Throwable thM9090exceptionOrNullimpl = Result.m9090exceptionOrNullimpl(result);
        Intrinsics.checkNotNull(thM9090exceptionOrNullimpl);
        suspendFunctionGun.resumeRootWith(Result.m9087constructorimpl(ResultKt.createFailure(thM9090exceptionOrNullimpl)));
    }
}
