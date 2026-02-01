package com.android.ddmlib;

import com.android.ddmlib.Log;
import com.sun.jna.platform.win32.WinError;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final class DdmPreferences {
    public static final String DEFAULT_ADBHOST_VALUE = "127.0.0.1";
    public static final boolean DEFAULT_INITIAL_HEAP_UPDATE = false;
    public static final boolean DEFAULT_INITIAL_THREAD_UPDATE = false;
    public static final Log.LogLevel DEFAULT_LOG_LEVEL;
    public static final int DEFAULT_PROFILER_BUFFER_SIZE_MB = 8;
    public static final int DEFAULT_TIMEOUT = 5000;
    public static final boolean DEFAULT_USE_ADBHOST = false;
    private static String sAdbHostValue;
    private static int sDdmCommandPort;
    private static boolean sDdmlibCommandServiceEnabled;
    private static boolean sInitialHeapUpdate;
    private static int sJdwpMaxPacketSize;
    private static boolean sJdwpProxyEnabled;
    private static int sJdwpProxyPort;
    private static Log.LogLevel sLogLevel;
    private static int sProfilerBufferSizeMb;
    private static boolean sThreadUpdate;
    private static int sTimeOut;
    private static boolean sUseAdbHost;

    static {
        Log.LogLevel logLevel = Log.LogLevel.ERROR;
        DEFAULT_LOG_LEVEL = logLevel;
        sThreadUpdate = false;
        sInitialHeapUpdate = false;
        sLogLevel = logLevel;
        sTimeOut = 5000;
        sProfilerBufferSizeMb = 8;
        sUseAdbHost = false;
        sAdbHostValue = DEFAULT_ADBHOST_VALUE;
        sJdwpMaxPacketSize = ((Integer) getPropertyOrDefault("DDMLIB_JDWP_MAX_PACKET_SIZE", 838860800, new Function() { // from class: com.android.ddmlib.DdmPreferences$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.parseInt((String) obj));
            }
        })).intValue();
        sJdwpProxyEnabled = ((Boolean) getPropertyOrDefault("DDMLIB_JDWP_PROXY_ENABLED", true, new Function() { // from class: com.android.ddmlib.DdmPreferences$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
        })).booleanValue();
        sJdwpProxyPort = ((Integer) getPropertyOrDefault("DDMLIB_JDWP_PROXY_PORT", Integer.valueOf(WinError.ERROR_DS_AUTHORIZATION_FAILED), new Function() { // from class: com.android.ddmlib.DdmPreferences$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.parseInt((String) obj));
            }
        })).intValue();
        sDdmlibCommandServiceEnabled = ((Boolean) getPropertyOrDefault("DDMLIB_COMMAND_SERVICE_ENABLED", false, new Function() { // from class: com.android.ddmlib.DdmPreferences$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
        })).booleanValue();
        sDdmCommandPort = ((Integer) getPropertyOrDefault("DDMLIB_COMMAND_PORT", Integer.valueOf(WinError.ERROR_DS_EXISTS_IN_RDNATTID), new Function() { // from class: com.android.ddmlib.DdmPreferences$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(Integer.parseInt((String) obj));
            }
        })).intValue();
    }

    public static boolean getInitialThreadUpdate() {
        return sThreadUpdate;
    }

    public static void setInitialThreadUpdate(boolean state) {
        sThreadUpdate = state;
    }

    public static boolean getInitialHeapUpdate() {
        return sInitialHeapUpdate;
    }

    public static void setInitialHeapUpdate(boolean state) {
        sInitialHeapUpdate = state;
    }

    public static Log.LogLevel getLogLevel() {
        return sLogLevel;
    }

    public static void setLogLevel(String value) {
        Log.LogLevel byString = Log.LogLevel.getByString(value);
        sLogLevel = byString;
        Log.setLevel(byString);
    }

    public static int getTimeOut() {
        return sTimeOut;
    }

    public static void setTimeOut(int timeOut) {
        sTimeOut = timeOut;
    }

    public static int getProfilerBufferSizeMb() {
        return sProfilerBufferSizeMb;
    }

    public static void setProfilerBufferSizeMb(int bufferSizeMb) {
        sProfilerBufferSizeMb = bufferSizeMb;
    }

    public static boolean getUseAdbHost() {
        return sUseAdbHost;
    }

    public static void setUseAdbHost(boolean useAdbHost) {
        sUseAdbHost = useAdbHost;
    }

    public static String getAdbHostValue() {
        return sAdbHostValue;
    }

    public static void setAdbHostValue(String adbHostValue) {
        sAdbHostValue = adbHostValue;
    }

    public static void enableJdwpProxyService(boolean enabled) {
        sJdwpProxyEnabled = enabled;
    }

    public static boolean isJdwpProxyEnabled() {
        return sJdwpProxyEnabled;
    }

    public static void setJdwpProxyPort(int port) {
        sJdwpProxyPort = port;
    }

    public static int getJdwpProxyPort() {
        return sJdwpProxyPort;
    }

    public static void setDdmCommandPort(int port) {
        sDdmCommandPort = port;
    }

    public static int getDdmCommandPort() {
        return sDdmCommandPort;
    }

    public static void enableDdmlibCommandService(boolean enabled) {
        sDdmlibCommandServiceEnabled = enabled;
    }

    public static boolean isDdmlibCommandServiceEnabled() {
        return sDdmlibCommandServiceEnabled;
    }

    private static <T> T getPropertyOrDefault(String property, T def, Function<String, T> parser) {
        try {
            return parser.apply(System.getProperty(property, def + ""));
        } catch (Exception unused) {
            return def;
        }
    }

    public static int getJdwpMaxPacketSize() {
        return sJdwpMaxPacketSize;
    }

    public static void setsJdwpMaxPacketSize(int size) {
        sJdwpMaxPacketSize = size;
    }

    private DdmPreferences() {
    }
}
