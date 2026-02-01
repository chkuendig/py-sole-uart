package com.android.utils;

/* loaded from: classes3.dex */
public class NullLogger implements ILogger {
    private static final ILogger sThis = new NullLogger();

    @Override // com.android.utils.ILogger
    public void error(Throwable t, String errorFormat, Object... args) {
    }

    @Override // com.android.utils.ILogger
    public void info(String msgFormat, Object... args) {
    }

    @Override // com.android.utils.ILogger
    public void verbose(String msgFormat, Object... args) {
    }

    @Override // com.android.utils.ILogger
    public void warning(String warningFormat, Object... args) {
    }

    public static ILogger getLogger() {
        return sThis;
    }
}
