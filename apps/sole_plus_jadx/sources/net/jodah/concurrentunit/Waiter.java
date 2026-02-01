package net.jodah.concurrentunit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.jodah.concurrentunit.internal.ReentrantCircuit;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

/* loaded from: classes6.dex */
public class Waiter {
    private static final String TIMEOUT_MESSAGE = "Test timed out while waiting for an expected result, expectedResumes: %d, actualResumes: %d";
    private final ReentrantCircuit circuit;
    private volatile Throwable failure;
    private AtomicInteger remainingResumes = new AtomicInteger(0);

    public Waiter() {
        ReentrantCircuit reentrantCircuit = new ReentrantCircuit();
        this.circuit = reentrantCircuit;
        reentrantCircuit.open();
    }

    public void assertEquals(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            fail(format(obj, obj2));
        }
    }

    public void assertFalse(boolean z) {
        if (z) {
            fail("expected false");
        }
    }

    public void assertNotNull(Object obj) {
        if (obj == null) {
            fail("expected not null");
        }
    }

    public void assertNull(Object obj) {
        if (obj != null) {
            fail(format(AbstractJsonLexerKt.NULL, obj));
        }
    }

    public void assertTrue(boolean z) {
        if (z) {
            return;
        }
        fail("expected true");
    }

    public <T> void assertThat(T t, Matcher<? super T> matcher) {
        try {
            MatcherAssert.assertThat(t, matcher);
        } catch (AssertionError e) {
            fail(e);
        }
    }

    public void await() throws Throwable {
        await(0L, TimeUnit.MILLISECONDS, 1);
    }

    public void await(long j) throws Throwable {
        await(j, TimeUnit.MILLISECONDS, 1);
    }

    public void await(long j, TimeUnit timeUnit) throws Throwable {
        await(j, timeUnit, 1);
    }

    public void await(long j, int i) throws Throwable {
        await(j, TimeUnit.MILLISECONDS, i);
    }

    public void await(long j, TimeUnit timeUnit, int i) throws Throwable {
        try {
            if (this.failure == null) {
                synchronized (this) {
                    if (this.remainingResumes.addAndGet(i) > 0) {
                        this.circuit.open();
                    }
                }
                if (j == 0) {
                    this.circuit.await();
                } else if (!this.circuit.await(j, timeUnit)) {
                    throw new TimeoutException(String.format(TIMEOUT_MESSAGE, Integer.valueOf(i), Integer.valueOf(i - this.remainingResumes.get())));
                }
            }
        } finally {
            this.remainingResumes.set(0);
            this.circuit.open();
            if (this.failure != null) {
                Throwable th = this.failure;
                this.failure = null;
                sneakyThrow(th);
            }
        }
    }

    public synchronized void resume() {
        if (this.remainingResumes.decrementAndGet() <= 0) {
            this.circuit.close();
        }
    }

    public void fail() {
        fail(new AssertionError());
    }

    public void fail(String str) {
        fail(new AssertionError(str));
    }

    public void fail(Throwable th) {
        AssertionError assertionError;
        if (th instanceof AssertionError) {
            assertionError = (AssertionError) th;
        } else {
            AssertionError assertionError2 = new AssertionError();
            assertionError2.initCause(th);
            assertionError = assertionError2;
        }
        this.failure = assertionError;
        this.circuit.close();
        throw assertionError;
    }

    public void rethrow(Throwable th) throws Throwable {
        this.failure = th;
        this.circuit.close();
        sneakyThrow(th);
    }

    private static void sneakyThrow(Throwable th) throws Throwable {
        sneakyThrow2(th);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        throw th;
    }

    private String format(Object obj, Object obj2) {
        return "expected:<" + obj + "> but was:<" + obj2 + ">";
    }
}
