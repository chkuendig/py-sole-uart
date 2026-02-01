package com.android.ddmlib;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TimeoutRemainder {
    private final SystemNanoTimeProvider nanoTimeProvider;
    private final long startNanos;
    private final long timeout;
    private final TimeUnit unit;

    public interface SystemNanoTimeProvider {
        long nanoTime();
    }

    public TimeoutRemainder(long timeout, TimeUnit unit) {
        this(DefaultSystemNanoTime.getInstance(), timeout, unit);
    }

    public TimeoutRemainder(SystemNanoTimeProvider nanoTimeProvider, long timeout, TimeUnit unit) {
        this.nanoTimeProvider = nanoTimeProvider;
        this.timeout = timeout;
        this.unit = unit;
        this.startNanos = elapsedNanos(0L);
    }

    public long getRemainingNanos() {
        return this.unit.toNanos(this.timeout) - elapsedNanos(this.startNanos);
    }

    public long getRemainingUnits(TimeUnit unit) {
        return unit.convert(getRemainingNanos(), TimeUnit.NANOSECONDS);
    }

    private long elapsedNanos(long startNanos) {
        return this.nanoTimeProvider.nanoTime() - startNanos;
    }

    public static class DefaultSystemNanoTime implements SystemNanoTimeProvider {
        public static DefaultSystemNanoTime sInstance = new DefaultSystemNanoTime();

        public static DefaultSystemNanoTime getInstance() {
            return sInstance;
        }

        @Override // com.android.ddmlib.TimeoutRemainder.SystemNanoTimeProvider
        public long nanoTime() {
            return System.nanoTime();
        }
    }
}
