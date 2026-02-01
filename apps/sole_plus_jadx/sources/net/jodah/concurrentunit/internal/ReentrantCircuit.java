package net.jodah.concurrentunit.internal;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* loaded from: classes6.dex */
public class ReentrantCircuit {
    private final Sync sync = new Sync();

    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 992522674231731445L;

        private Sync() {
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryReleaseShared(int i) {
            setState(0);
            return true;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int i) {
            Thread firstQueuedThread = getFirstQueuedThread();
            if (firstQueuedThread != null && firstQueuedThread != Thread.currentThread()) {
                return -1;
            }
            if (i == 0) {
                return isClosed() ? 1 : -1;
            }
            setState(1);
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isClosed() {
            return getState() == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void open() {
            setState(1);
        }
    }

    public void await() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(0);
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.sync.tryAcquireSharedNanos(0, timeUnit.toNanos(j));
    }

    public void close() {
        this.sync.releaseShared(1);
    }

    public void interruptWaiters() {
        Iterator<Thread> it = this.sync.getSharedQueuedThreads().iterator();
        while (it.hasNext()) {
            it.next().interrupt();
        }
    }

    public boolean isClosed() {
        return this.sync.isClosed();
    }

    public void open() {
        this.sync.open();
    }

    public String toString() {
        return isClosed() ? "closed" : "open";
    }
}
