package com.android.ddmlib.log;

/* loaded from: classes3.dex */
public final class InvalidTypeException extends Exception {
    private static final long serialVersionUID = 1;

    public InvalidTypeException() {
        super("Invalid Type");
    }

    public InvalidTypeException(String message) {
        super(message);
    }

    public InvalidTypeException(Throwable cause) {
        super(cause);
    }

    public InvalidTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
