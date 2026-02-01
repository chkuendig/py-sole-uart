package androidx.health.platform.client.impl.ipc.internal;

import com.google.common.util.concurrent.SettableFuture;

/* loaded from: classes2.dex */
public interface ExecutionTracker {
    void cancelPendingFutures(Throwable th);

    void track(SettableFuture<?> settableFuture);
}
