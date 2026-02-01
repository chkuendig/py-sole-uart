package com.android.utils.concurrency;

import com.google.common.collect.EvictingQueue;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EvictingExecutorService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/utils/concurrency/EvictingExecutor;", "Ljava/util/concurrent/AbstractExecutorService;", "delegateExecutor", "Ljava/util/concurrent/ExecutorService;", "maxQueueingTasks", "", "(Ljava/util/concurrent/ExecutorService;I)V", "evictingQueue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "evictingQueueLock", "Ljava/util/concurrent/locks/ReentrantLock;", "awaitTermination", "", "timeout", "", HealthConstants.FoodIntake.UNIT, "Ljava/util/concurrent/TimeUnit;", "execute", "", "command", "isShutdown", "isTerminated", "queueProcessor", "shutdown", "shutdownNow", "", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class EvictingExecutor extends AbstractExecutorService {
    private final ExecutorService delegateExecutor;
    private final Queue<Runnable> evictingQueue;
    private final ReentrantLock evictingQueueLock;

    public /* synthetic */ EvictingExecutor(ExecutorService executorService, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(executorService, (i2 & 2) != 0 ? 1 : i);
    }

    public EvictingExecutor(ExecutorService delegateExecutor, int i) {
        Intrinsics.checkNotNullParameter(delegateExecutor, "delegateExecutor");
        this.delegateExecutor = delegateExecutor;
        this.evictingQueueLock = new ReentrantLock();
        EvictingQueue evictingQueueCreate = EvictingQueue.create(i);
        Intrinsics.checkNotNullExpressionValue(evictingQueueCreate, "create<Runnable>(maxQueueingTasks)");
        this.evictingQueue = evictingQueueCreate;
    }

    private final void queueProcessor() {
        this.delegateExecutor.execute(new Runnable() { // from class: com.android.utils.concurrency.EvictingExecutor.queueProcessor.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ReentrantLock reentrantLock = EvictingExecutor.this.evictingQueueLock;
                    EvictingExecutor evictingExecutor = EvictingExecutor.this;
                    reentrantLock.lock();
                    try {
                        ((Runnable) evictingExecutor.evictingQueue.remove()).run();
                    } finally {
                        reentrantLock.unlock();
                    }
                } catch (NoSuchElementException unused) {
                }
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegateExecutor.isTerminated();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (this.delegateExecutor.isTerminated()) {
            return;
        }
        ReentrantLock reentrantLock = this.evictingQueueLock;
        reentrantLock.lock();
        try {
            int size = this.evictingQueue.size();
            this.evictingQueue.offer(command);
            if (size != this.evictingQueue.size()) {
                queueProcessor();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        final ArrayList arrayList = new ArrayList();
        ReentrantLock reentrantLock = this.evictingQueueLock;
        reentrantLock.lock();
        try {
            CollectionsKt.removeAll(this.evictingQueue, new Function1<Runnable, Boolean>() { // from class: com.android.utils.concurrency.EvictingExecutor$shutdownNow$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Runnable it) {
                    List<Runnable> list = arrayList;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    return Boolean.valueOf(list.add(it));
                }
            });
            reentrantLock.unlock();
            List<Runnable> listShutdownNow = this.delegateExecutor.shutdownNow();
            Intrinsics.checkNotNullExpressionValue(listShutdownNow, "delegateExecutor.shutdownNow()");
            arrayList.addAll(listShutdownNow);
            return arrayList;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegateExecutor.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.delegateExecutor.awaitTermination(timeout, unit);
    }
}
