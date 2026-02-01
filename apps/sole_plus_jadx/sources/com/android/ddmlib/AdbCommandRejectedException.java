package com.android.ddmlib;

/* loaded from: classes3.dex */
public class AdbCommandRejectedException extends Exception {
    private static final long serialVersionUID = 1;
    private final boolean mErrorDuringDeviceSelection;
    private final boolean mIsDeviceOffline;

    AdbCommandRejectedException(String message) {
        super(message);
        this.mIsDeviceOffline = "device offline".equals(message);
        this.mErrorDuringDeviceSelection = false;
    }

    AdbCommandRejectedException(String message, boolean errorDuringDeviceSelection) {
        super(message);
        this.mErrorDuringDeviceSelection = errorDuringDeviceSelection;
        this.mIsDeviceOffline = "device offline".equals(message);
    }

    public boolean isDeviceOffline() {
        return this.mIsDeviceOffline;
    }

    public boolean wasErrorDuringDeviceSelection() {
        return this.mErrorDuringDeviceSelection;
    }

    @Deprecated
    public static AdbCommandRejectedException create(String message) {
        return new AdbCommandRejectedException(message);
    }
}
