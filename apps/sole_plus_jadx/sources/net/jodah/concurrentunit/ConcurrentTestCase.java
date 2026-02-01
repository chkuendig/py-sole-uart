package net.jodah.concurrentunit;

import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public abstract class ConcurrentTestCase {
    private final Waiter waiter = new Waiter();

    public void threadAssertEquals(Object obj, Object obj2) {
        this.waiter.assertEquals(obj, obj2);
    }

    public void threadAssertFalse(boolean z) {
        this.waiter.assertFalse(z);
    }

    public void threadAssertNotNull(Object obj) {
        this.waiter.assertNotNull(obj);
    }

    public void threadAssertNull(Object obj) {
        this.waiter.assertNull(obj);
    }

    public void threadAssertTrue(boolean z) {
        this.waiter.assertTrue(z);
    }

    public void threadFail() {
        threadFail(new AssertionError());
    }

    public void threadFail(String str) {
        threadFail(new AssertionError(str));
    }

    public void threadFail(Throwable th) {
        this.waiter.fail(th);
    }

    public void rethrow(Throwable th) throws Throwable {
        this.waiter.rethrow(th);
    }

    protected void await() throws Throwable {
        this.waiter.await();
    }

    protected void await(long j) throws Throwable {
        this.waiter.await(j);
    }

    protected void await(long j, int i) throws Throwable {
        this.waiter.await(j, i);
    }

    protected void await(long j, TimeUnit timeUnit) throws Throwable {
        this.waiter.await(j, timeUnit);
    }

    protected void await(long j, TimeUnit timeUnit, int i) throws Throwable {
        this.waiter.await(j, timeUnit, i);
    }

    protected void resume() {
        this.waiter.resume();
    }
}
