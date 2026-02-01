package com.android.ddmlib;

/* loaded from: classes3.dex */
public final class DdmConstants {
    public static final int CURRENT_PLATFORM;
    public static final String DOT_TRACE = ".trace";
    public static final String EXTENSION = "trace";
    public static final String FN_HPROF_CONVERTER;
    public static final String FN_TRACEVIEW;
    public static final int PLATFORM_DARWIN = 3;
    public static final int PLATFORM_LINUX = 1;
    public static final int PLATFORM_UNKNOWN = 0;
    public static final int PLATFORM_WINDOWS = 2;

    static {
        int iCurrentPlatform = currentPlatform();
        CURRENT_PLATFORM = iCurrentPlatform;
        FN_HPROF_CONVERTER = iCurrentPlatform == 2 ? "hprof-conv.exe" : "hprof-conv";
        FN_TRACEVIEW = iCurrentPlatform == 2 ? "traceview.bat" : "traceview";
    }

    public static int currentPlatform() {
        String property = System.getProperty("os.name");
        if (property.startsWith("Mac OS")) {
            return 3;
        }
        if (property.startsWith("Windows")) {
            return 2;
        }
        return property.startsWith("Linux") ? 1 : 0;
    }
}
