package com.ua.sdk.recorder.datasource;

import java.lang.Number;

/* loaded from: classes2.dex */
public class Average<T extends Number> {
    private double avg = 0.0d;
    private long size = 0;

    public void addValue(T t) {
        double dDoubleValue = (this.avg * this.size) + t.doubleValue();
        long j = this.size;
        this.avg = dDoubleValue / (j + 1);
        this.size = j + 1;
    }

    public double getAverage() {
        return this.avg;
    }

    public long getSize() {
        return this.size;
    }

    public void reset() {
        this.avg = 0.0d;
        this.size = 0L;
    }
}
