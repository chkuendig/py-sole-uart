package kotlinx.coroutines.guava;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: ListenableFuture.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0013\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\r\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096\u0002¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00028\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020'H\u0016R&\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \t*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/coroutines/guava/JobListenableFuture;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/common/util/concurrent/ListenableFuture;", "jobToCancel", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "auxFuture", "Lcom/google/common/util/concurrent/SettableFuture;", "", "kotlin.jvm.PlatformType", "auxFutureIsFailed", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "executor", "Ljava/util/concurrent/Executor;", "cancel", "mayInterruptIfRunning", "complete", "result", "(Ljava/lang/Object;)Z", "completeExceptionallyOrCancel", "t", "", "get", "()Ljava/lang/Object;", "timeout", "", HealthConstants.FoodIntake.UNIT, "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "getInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "isCancelled", "isDone", "toString", "", "kotlinx-coroutines-guava"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class JobListenableFuture<T> implements ListenableFuture<T> {
    private final SettableFuture<Object> auxFuture = SettableFuture.create();
    private boolean auxFutureIsFailed;
    private final Job jobToCancel;

    public JobListenableFuture(Job job) {
        this.jobToCancel = job;
    }

    public final boolean complete(T result) {
        return this.auxFuture.set(result);
    }

    public final boolean completeExceptionallyOrCancel(Throwable t) {
        if (t instanceof CancellationException) {
            return this.auxFuture.set(new Cancelled((CancellationException) t));
        }
        boolean exception = this.auxFuture.setException(t);
        if (!exception) {
            return exception;
        }
        this.auxFutureIsFailed = true;
        return exception;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        if (this.auxFuture.isCancelled()) {
            return true;
        }
        if (isDone() && !this.auxFutureIsFailed) {
            try {
                z = Uninterruptibles.getUninterruptibly(this.auxFuture) instanceof Cancelled;
            } catch (CancellationException unused) {
                z = true;
            } catch (ExecutionException unused2) {
                this.auxFutureIsFailed = true;
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        return getInternal(this.auxFuture.get());
    }

    @Override // java.util.concurrent.Future
    public T get(long timeout, TimeUnit unit) {
        return getInternal(this.auxFuture.get(timeout, unit));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final T getInternal(Object result) throws Throwable {
        if (result instanceof Cancelled) {
            throw new CancellationException().initCause(((Cancelled) result).exception);
        }
        return result;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor executor) {
        this.auxFuture.addListener(listener, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.auxFuture.isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!this.auxFuture.cancel(mayInterruptIfRunning)) {
            return false;
        }
        Job.DefaultImpls.cancel$default(this.jobToCancel, (CancellationException) null, 1, (Object) null);
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isDone()) {
            try {
                Object uninterruptibly = Uninterruptibles.getUninterruptibly(this.auxFuture);
                if (uninterruptibly instanceof Cancelled) {
                    sb.append("CANCELLED, cause=[" + ((Cancelled) uninterruptibly).exception + AbstractJsonLexerKt.END_LIST);
                } else {
                    sb.append("SUCCESS, result=[" + uninterruptibly + AbstractJsonLexerKt.END_LIST);
                }
            } catch (CancellationException unused) {
                sb.append("CANCELLED");
            } catch (ExecutionException e) {
                sb.append("FAILURE, cause=[" + e.getCause() + AbstractJsonLexerKt.END_LIST);
            } catch (Throwable th) {
                sb.append("UNKNOWN, cause=[" + th.getClass() + " thrown from get()]");
            }
        } else {
            sb.append("PENDING, delegate=[" + this.auxFuture + AbstractJsonLexerKt.END_LIST);
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
