package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* loaded from: classes.dex */
public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    protected final BackpressureQueueCallback actual;
    protected boolean emitting;
    protected Throwable exception;
    protected volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    public final boolean isTerminated() {
        return this.terminated;
    }

    public final void terminate() {
        this.terminated = true;
    }

    public final void terminate(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
    }

    public final void terminateAndDrain() throws Throwable {
        this.terminated = true;
        drain();
    }

    public final void terminateAndDrain(Throwable th) throws Throwable {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
        drain();
    }

    @Override // rx.Producer
    public final void request(long j) throws Throwable {
        boolean z;
        long j2;
        if (j == 0) {
            return;
        }
        while (true) {
            long j3 = get();
            boolean z2 = true;
            z = j3 == 0;
            if (j3 == Long.MAX_VALUE) {
                break;
            }
            if (j == Long.MAX_VALUE) {
                j2 = j;
            } else {
                j2 = j3 <= Long.MAX_VALUE - j ? j3 + j : Long.MAX_VALUE;
                z2 = z;
            }
            if (compareAndSet(j3, j2)) {
                z = z2;
                break;
            }
        }
        if (z) {
            drain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:
    
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        if (r5.peek() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0042, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        if (get() != Long.MAX_VALUE) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
    
        if (r2 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
    
        if (r1 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:
    
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0056, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0058, code lost:
    
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005c, code lost:
    
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0062, code lost:
    
        if (r9 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0064, code lost:
    
        if (r2 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0066, code lost:
    
        if (r1 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0068, code lost:
    
        if (r2 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006b, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006e, code lost:
    
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0070, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0071, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0072, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0074, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0075, code lost:
    
        throw r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0031 A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #2 {all -> 0x0085, blocks: (B:10:0x0012, B:26:0x0037, B:16:0x001f, B:24:0x0031, B:59:0x0078), top: B:80:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void drain() throws Throwable {
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z = true;
            this.emitting = true;
            boolean z2 = this.terminated;
            long j = get();
            try {
                BackpressureQueueCallback backpressureQueueCallback = this.actual;
                while (true) {
                    int i = 0;
                    while (true) {
                        try {
                            if (j > 0 || z2) {
                                if (z2) {
                                    if (backpressureQueueCallback.peek() == null) {
                                        backpressureQueueCallback.complete(this.exception);
                                        return;
                                    } else if (j != 0) {
                                    }
                                } else {
                                    Object objPoll = backpressureQueueCallback.poll();
                                    if (objPoll != null) {
                                        if (backpressureQueueCallback.accept(objPoll)) {
                                            return;
                                        }
                                        j--;
                                        i++;
                                    }
                                }
                            }
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
        }
    }
}
