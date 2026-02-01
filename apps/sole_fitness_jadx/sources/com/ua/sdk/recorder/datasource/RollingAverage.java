package com.ua.sdk.recorder.datasource;

import java.lang.Number;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class RollingAverage<T extends Number> {
    private int maxSize;
    private LinkedList<T> values = new LinkedList<>();
    private double avg = 0.0d;

    public RollingAverage(int i) {
        this.maxSize = i;
    }

    public double getAverage() {
        return this.avg;
    }

    public void addValue(T t) {
        double dDoubleValue = t.doubleValue();
        if (this.maxSize <= 0 || Double.isInfinite(dDoubleValue) || Double.isNaN(dDoubleValue)) {
            return;
        }
        if (this.values.size() == this.maxSize) {
            this.values.removeFirst();
        }
        this.values.add(t);
        this.avg = calculateAvg();
    }

    public void reset() {
        this.values = new LinkedList<>();
        this.avg = 0.0d;
    }

    private double calculateAvg() {
        Iterator<T> it = this.values.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue / this.values.size();
    }
}
