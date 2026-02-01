package com.sun.jna.platform.mac;

import com.sun.jna.platform.win32.Advapi32;

/* loaded from: classes4.dex */
public class IOReturnException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private int ioReturn;

    public static int getCode(int i) {
        return i & Advapi32.MAX_VALUE_NAME;
    }

    public static int getSubSystem(int i) {
        return (i >> 14) & 4095;
    }

    public static int getSystem(int i) {
        return (i >> 26) & 63;
    }

    public IOReturnException(int i) {
        this(i, formatMessage(i));
    }

    protected IOReturnException(int i, String str) {
        super(str);
        this.ioReturn = i;
    }

    public int getIOReturnCode() {
        return this.ioReturn;
    }

    private static String formatMessage(int i) {
        return "IOReturn error code: " + i + " (system=" + getSystem(i) + ", subSystem=" + getSubSystem(i) + ", code=" + getCode(i) + ")";
    }
}
