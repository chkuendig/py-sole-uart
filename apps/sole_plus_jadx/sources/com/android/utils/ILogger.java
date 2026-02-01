package com.android.utils;

/* loaded from: classes3.dex */
public interface ILogger {
    void error(Throwable t, String msgFormat, Object... args);

    void info(String msgFormat, Object... args);

    void verbose(String msgFormat, Object... args);

    void warning(String msgFormat, Object... args);

    default void quiet(String msgFormat, Object... args) {
        info(msgFormat, args);
    }

    default void lifecycle(String msgFormat, Object... args) {
        info(msgFormat, args);
    }
}
