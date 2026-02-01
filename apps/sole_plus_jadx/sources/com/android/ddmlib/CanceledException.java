package com.android.ddmlib;

/* loaded from: classes3.dex */
public abstract class CanceledException extends Exception {
    private static final long serialVersionUID = 1;

    public abstract boolean wasCanceled();

    CanceledException(String message) {
        super(message);
    }

    CanceledException(String message, Throwable cause) {
        super(message, cause);
    }
}
