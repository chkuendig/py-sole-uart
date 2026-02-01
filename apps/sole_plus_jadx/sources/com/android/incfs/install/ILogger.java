package com.android.incfs.install;

/* loaded from: classes3.dex */
public interface ILogger {
    void error(Throwable t, String msgFormat, Object... args);

    void info(String msgFormat, Object... args);

    void verbose(String msgFormat, Object... args);

    void warning(String msgFormat, Object... args);
}
