package com.samsung.android.sdk.internal.healthdata;

/* loaded from: classes5.dex */
public final class ErrorUtil {
    public static String getNullArgumentMessage() {
        return "Argument is null";
    }

    public static String getRemoteExceptionMessage(Exception exc) {
        return "A remote-invocation error occurs on the connection: " + exc.toString();
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " is null");
    }
}
