package com.android.utils.concurrency;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncSupplier.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BB\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\b\u0002\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00018\u00008V@RX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/utils/concurrency/CachedAsyncSupplier;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/android/utils/concurrency/AsyncSupplier;", "compute", "Lkotlin/Function0;", "isUpToDate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/util/concurrent/ExecutorService;)V", "Lcom/google/common/util/concurrent/ListeningExecutorService;", "kotlin.jvm.PlatformType", "newValue", "lastComputedValue", "getLastComputedValue", "()Ljava/lang/Object;", "setLastComputedValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "lastComputedValueLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "now", "getNow", "setNow", "runningComputation", "Lcom/google/common/util/concurrent/ListenableFuture;", "runningComputationLock", "Ljava/util/concurrent/locks/ReentrantLock;", "get", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CachedAsyncSupplier<V> implements AsyncSupplier<V> {
    private final Function0<V> compute;
    private final ListeningExecutorService executor;
    private final Function1<V, Boolean> isUpToDate;
    private V lastComputedValue;
    private final ReentrantReadWriteLock lastComputedValueLock;
    private ListenableFuture<V> runningComputation;
    private final ReentrantLock runningComputationLock;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedAsyncSupplier(Function0<? extends V> compute, ExecutorService executor) {
        this(compute, null, executor, 2, null);
        Intrinsics.checkNotNullParameter(compute, "compute");
        Intrinsics.checkNotNullParameter(executor, "executor");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CachedAsyncSupplier(Function0<? extends V> compute, Function1<? super V, Boolean> isUpToDate, ExecutorService executor) {
        Intrinsics.checkNotNullParameter(compute, "compute");
        Intrinsics.checkNotNullParameter(isUpToDate, "isUpToDate");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.compute = compute;
        this.isUpToDate = isUpToDate;
        this.executor = MoreExecutors.listeningDecorator(executor);
        this.runningComputationLock = new ReentrantLock();
        ListenableFuture<V> listenableFutureImmediateFuture = Futures.immediateFuture(null);
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture(null)");
        this.runningComputation = listenableFutureImmediateFuture;
        this.lastComputedValueLock = new ReentrantReadWriteLock();
    }

    public /* synthetic */ CachedAsyncSupplier(Function0 function0, AnonymousClass1 anonymousClass1, ExecutorService executorService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new Function1<V, Boolean>() { // from class: com.android.utils.concurrency.CachedAsyncSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(V v) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((AnonymousClass1) obj);
            }
        } : anonymousClass1, executorService);
    }

    private final V getLastComputedValue() {
        ReentrantReadWriteLock.ReadLock lock = this.lastComputedValueLock.readLock();
        lock.lock();
        try {
            return this.lastComputedValue;
        } finally {
            lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastComputedValue(V v) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.lastComputedValueLock;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            this.lastComputedValue = v;
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.android.utils.concurrency.AsyncSupplier
    public V getNow() {
        ListenableFuture<V> listenableFuture = get();
        if (listenableFuture.isDone()) {
            return (V) Futures.getDone(listenableFuture);
        }
        return getLastComputedValue();
    }

    private void setNow(V v) {
        setLastComputedValue(v);
    }

    @Override // java.util.function.Supplier
    public ListenableFuture<V> get() {
        V lastComputedValue = getLastComputedValue();
        if (lastComputedValue != null && this.isUpToDate.invoke(lastComputedValue).booleanValue()) {
            ListenableFuture<V> listenableFutureImmediateFuture = Futures.immediateFuture(lastComputedValue);
            Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture(cachedValue)");
            return listenableFutureImmediateFuture;
        }
        ReentrantLock reentrantLock = this.runningComputationLock;
        reentrantLock.lock();
        try {
            if (this.runningComputation.isDone()) {
                ListenableFuture<V> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(this.executor.submit(new Callable(this) { // from class: com.android.utils.concurrency.CachedAsyncSupplier$get$1$1
                    final /* synthetic */ CachedAsyncSupplier<V> this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.util.concurrent.Callable
                    public final V call() {
                        V v = (V) ((CachedAsyncSupplier) this.this$0).compute.invoke();
                        this.this$0.setLastComputedValue(v);
                        return v;
                    }
                }));
                Intrinsics.checkNotNullExpressionValue(listenableFutureNonCancellationPropagating, "override fun get(): List…ningComputation\n    }\n  }");
                this.runningComputation = listenableFutureNonCancellationPropagating;
            }
            return this.runningComputation;
        } finally {
            reentrantLock.unlock();
        }
    }
}
