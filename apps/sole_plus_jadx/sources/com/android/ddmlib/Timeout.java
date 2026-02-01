package com.android.ddmlib;

/* loaded from: classes3.dex */
public class Timeout {
    private long deadline;

    public Timeout(long delayMs) {
        this.deadline = System.currentTimeMillis() + delayMs;
    }

    public long remaining() {
        return Math.max(this.deadline - System.currentTimeMillis(), 0L);
    }
}
