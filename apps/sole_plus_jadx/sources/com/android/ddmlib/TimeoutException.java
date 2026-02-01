package com.android.ddmlib;

/* loaded from: classes3.dex */
public class TimeoutException extends Exception {
    private static final long serialVersionUID = 1;

    public TimeoutException() {
    }

    public TimeoutException(String s) {
        super(s);
    }

    public TimeoutException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TimeoutException(Throwable throwable) {
        super(throwable);
    }
}
