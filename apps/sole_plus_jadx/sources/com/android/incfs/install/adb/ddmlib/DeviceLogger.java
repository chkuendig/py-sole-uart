package com.android.incfs.install.adb.ddmlib;

import com.android.incfs.install.ILogger;

/* loaded from: classes3.dex */
public class DeviceLogger implements ILogger {
    private com.android.utils.ILogger mLogger;

    public DeviceLogger(com.android.utils.ILogger logger) {
        this.mLogger = logger;
    }

    @Override // com.android.incfs.install.ILogger
    public void error(Throwable t, String msgFormat, Object... args) {
        this.mLogger.error(t, msgFormat, args);
    }

    @Override // com.android.incfs.install.ILogger
    public void warning(String msgFormat, Object... args) {
        this.mLogger.warning(msgFormat, args);
    }

    @Override // com.android.incfs.install.ILogger
    public void info(String msgFormat, Object... args) {
        this.mLogger.info(msgFormat, args);
    }

    @Override // com.android.incfs.install.ILogger
    public void verbose(String msgFormat, Object... args) {
        this.mLogger.verbose(msgFormat, args);
    }
}
