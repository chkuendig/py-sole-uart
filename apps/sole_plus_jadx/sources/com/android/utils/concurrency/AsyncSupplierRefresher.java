package com.android.utils.concurrency;

import androidx.exifinterface.media.ExifInterface;
import com.android.utils.concurrency.AsyncSupplier;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncSupplier.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/utils/concurrency/AsyncSupplierRefresher;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/android/utils/concurrency/AsyncSupplier;", "", "asyncSupplier", "refreshDuration", "Ljava/time/Duration;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "(Lcom/android/utils/concurrency/AsyncSupplier;Ljava/time/Duration;Ljava/util/concurrent/ScheduledExecutorService;)V", "expensiveValueRef", "Ljava/lang/ref/WeakReference;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "scheduledFutureLock", "Ljava/util/concurrent/locks/ReentrantLock;", "cancel", "", "refresh", "reschedule", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncSupplierRefresher<V extends AsyncSupplier<?>> {
    private final ScheduledExecutorService executor;
    private final WeakReference<V> expensiveValueRef;
    private final Duration refreshDuration;
    private ScheduledFuture<?> scheduledFuture;
    private final ReentrantLock scheduledFutureLock;

    public AsyncSupplierRefresher(V asyncSupplier, Duration refreshDuration, ScheduledExecutorService executor) {
        Intrinsics.checkNotNullParameter(asyncSupplier, "asyncSupplier");
        Intrinsics.checkNotNullParameter(refreshDuration, "refreshDuration");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.refreshDuration = refreshDuration;
        this.executor = executor;
        this.expensiveValueRef = new WeakReference<>(asyncSupplier);
        this.scheduledFutureLock = new ReentrantLock();
        reschedule();
    }

    private final void reschedule() {
        ReentrantLock reentrantLock = this.scheduledFutureLock;
        reentrantLock.lock();
        try {
            ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null && scheduledFuture.isCancelled()) {
                return;
            }
            this.scheduledFuture = this.executor.schedule(new Runnable(this) { // from class: com.android.utils.concurrency.AsyncSupplierRefresher$reschedule$1$1
                final /* synthetic */ AsyncSupplierRefresher<V> $tmp0;

                {
                    this.$tmp0 = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.$tmp0.refresh();
                }
            }, this.refreshDuration.toMillis(), TimeUnit.MILLISECONDS);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        V v = this.expensiveValueRef.get();
        if (v != null) {
            v.get();
            reschedule();
        }
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.scheduledFutureLock;
        reentrantLock.lock();
        try {
            ScheduledFuture<?> scheduledFuture = this.scheduledFuture;
            if (scheduledFuture != null) {
                Boolean.valueOf(scheduledFuture.cancel(true));
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
