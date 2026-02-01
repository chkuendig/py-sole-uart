package com.android.utils;

import com.google.common.collect.ImmutableList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public class FlightRecorder {
    private static final FlightRecorder INSTANCE = new FlightRecorder();
    private Deque<Object> records;
    private int sizeLimit;

    public static void initialize(int sizeLimit) {
        INSTANCE.setSizeLimit(sizeLimit);
    }

    public static void log(Object record) {
        INSTANCE.doLog(record);
    }

    public static void log(Supplier<?> lazyRecord) {
        INSTANCE.doLog(lazyRecord);
    }

    public static List<Object> getAndClear() {
        return INSTANCE.doGetAndClear();
    }

    public static void print() {
        Iterator<Object> it = getAndClear().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private FlightRecorder() {
    }

    private synchronized void setSizeLimit(int sizeLimit) {
        if (sizeLimit > 0) {
            if (this.records == null) {
                this.records = new ArrayDeque(sizeLimit);
            } else {
                while (this.records.size() > sizeLimit) {
                    this.records.removeFirst();
                }
                ArrayDeque arrayDeque = new ArrayDeque(sizeLimit);
                arrayDeque.addAll(this.records);
                this.records = arrayDeque;
            }
        } else {
            this.records = null;
        }
        this.sizeLimit = sizeLimit;
    }

    private synchronized void doLog(Object record) {
        Deque<Object> deque = this.records;
        if (deque != null) {
            if (deque.size() >= this.sizeLimit) {
                this.records.removeFirst();
            }
            this.records.add(record);
        }
    }

    private synchronized void doLog(Supplier<?> lazyRecord) {
        Deque<Object> deque = this.records;
        if (deque != null) {
            if (deque.size() >= this.sizeLimit) {
                this.records.removeFirst();
            }
            this.records.add(lazyRecord.get());
        }
    }

    private synchronized List<Object> doGetAndClear() {
        Deque<Object> deque = this.records;
        if (deque == null) {
            return ImmutableList.of();
        }
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) deque);
        this.records.clear();
        return immutableListCopyOf;
    }
}
