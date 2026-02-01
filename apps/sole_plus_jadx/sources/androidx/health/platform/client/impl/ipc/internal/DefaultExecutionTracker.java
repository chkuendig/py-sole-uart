package androidx.health.platform.client.impl.ipc.internal;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class DefaultExecutionTracker implements ExecutionTracker {
    private final Set<SettableFuture<?>> mFuturesInProgress = new HashSet();

    @Override // androidx.health.platform.client.impl.ipc.internal.ExecutionTracker
    public void track(final SettableFuture<?> settableFuture) {
        synchronized (this.mFuturesInProgress) {
            this.mFuturesInProgress.add(settableFuture);
            settableFuture.addListener(new Runnable() { // from class: androidx.health.platform.client.impl.ipc.internal.DefaultExecutionTracker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m7581x59c09430(settableFuture);
                }
            }, MoreExecutors.directExecutor());
        }
    }

    /* renamed from: lambda$track$0$androidx-health-platform-client-impl-ipc-internal-DefaultExecutionTracker, reason: not valid java name */
    /* synthetic */ void m7581x59c09430(SettableFuture settableFuture) {
        synchronized (this.mFuturesInProgress) {
            this.mFuturesInProgress.remove(settableFuture);
        }
    }

    @Override // androidx.health.platform.client.impl.ipc.internal.ExecutionTracker
    public void cancelPendingFutures(Throwable th) {
        HashSet hashSet;
        synchronized (this.mFuturesInProgress) {
            hashSet = new HashSet(this.mFuturesInProgress);
            this.mFuturesInProgress.clear();
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((SettableFuture) it.next()).setException(th);
        }
    }
}
