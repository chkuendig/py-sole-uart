package com.ua.sdk;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes2.dex */
public class UaLog {
    public static final AndroidLogger DEFAULT_LOGGER;
    private static Logger sLogger;

    public interface Logger {
        public static final int DEBUG = 3;
        public static final int ERROR = 6;
        public static final int INFO = 4;
        public static final int REPORT = 8;
        public static final int WARN = 5;

        void log(int i, String str);

        void log(int i, String str, Object obj);

        void log(int i, String str, Object obj, Object obj2);

        void log(int i, String str, Throwable th);

        void log(int i, String str, Object... objArr);
    }

    static {
        AndroidLogger androidLogger = new AndroidLogger();
        DEFAULT_LOGGER = androidLogger;
        sLogger = androidLogger;
    }

    public static void report(String str) {
        sLogger.log(8, str);
    }

    public static void report(String str, Object obj) {
        sLogger.log(8, str, obj);
    }

    public static void report(String str, Object obj, Object obj2) {
        sLogger.log(8, str, obj, obj2);
    }

    public static void report(String str, Object... objArr) {
        sLogger.log(8, str, objArr);
    }

    public static void report(String str, Throwable th) {
        sLogger.log(8, str, th);
    }

    public static void error(String str) {
        sLogger.log(6, str);
    }

    public static void error(String str, Object obj) {
        sLogger.log(6, str, obj);
    }

    public static void error(String str, Object obj, Object obj2) {
        sLogger.log(6, str, obj, obj2);
    }

    public static void error(String str, Object... objArr) {
        sLogger.log(6, str, objArr);
    }

    public static void error(String str, Throwable th) {
        sLogger.log(6, str, th);
    }

    public static void warn(String str) {
        sLogger.log(5, str);
    }

    public static void warn(String str, Object obj) {
        sLogger.log(5, str, obj);
    }

    public static void warn(String str, Object obj, Object obj2) {
        sLogger.log(5, str, obj, obj2);
    }

    public static void warn(String str, Object... objArr) {
        sLogger.log(5, str, objArr);
    }

    public static void warn(String str, Throwable th) {
        sLogger.log(5, str, th);
    }

    public static void info(String str) {
        sLogger.log(4, str);
    }

    public static void info(String str, Object obj) {
        sLogger.log(4, str, obj);
    }

    public static void info(String str, Object obj, Object obj2) {
        sLogger.log(4, str, obj, obj2);
    }

    public static void info(String str, Object... objArr) {
        sLogger.log(4, str, objArr);
    }

    public static void info(String str, Throwable th) {
        sLogger.log(4, str, th);
    }

    public static void debug(String str) {
        sLogger.log(3, str);
    }

    public static void debug(String str, Object obj) {
        sLogger.log(3, str, obj);
    }

    public static void debug(String str, Object obj, Object obj2) {
        sLogger.log(3, str, obj, obj2);
    }

    public static void debug(String str, Object... objArr) {
        sLogger.log(3, str, objArr);
    }

    public static void debug(String str, Throwable th) {
        sLogger.log(3, str, th);
    }

    public static String buildMessage(String str, Object obj) {
        return obj == null ? str : String.format(Locale.US, str, obj);
    }

    public static String buildMessage(String str, Object obj, Object obj2) {
        return obj2 == null ? buildMessage(str, obj) : String.format(Locale.US, str, obj, obj2);
    }

    public static String buildMessage(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static void setLogger(Logger logger) {
        if (logger == null) {
            sLogger = DEFAULT_LOGGER;
        } else {
            sLogger = logger;
        }
    }

    public static Logger getLogger() {
        return sLogger;
    }

    public static class AndroidLogger implements Logger {
        private static final String TAG = "sdk";
        private int mLogLevel = 4;

        @Override // com.ua.sdk.UaLog.Logger
        public void log(int i, String str) {
            if (i >= this.mLogLevel) {
                if (i == 3) {
                    Log.d("sdk", str);
                    return;
                }
                if (i == 4) {
                    Log.i("sdk", str);
                    return;
                }
                if (i == 5) {
                    Log.w("sdk", str);
                } else if (i == 6) {
                    Log.e("sdk", str);
                } else {
                    if (i != 8) {
                        return;
                    }
                    Log.e("sdk", str);
                }
            }
        }

        @Override // com.ua.sdk.UaLog.Logger
        public void log(int i, String str, Object obj) {
            if (i >= this.mLogLevel) {
                log(i, UaLog.buildMessage(str, obj));
            }
        }

        @Override // com.ua.sdk.UaLog.Logger
        public void log(int i, String str, Object obj, Object obj2) {
            if (i >= this.mLogLevel) {
                log(i, UaLog.buildMessage(str, obj, obj2));
            }
        }

        @Override // com.ua.sdk.UaLog.Logger
        public void log(int i, String str, Object... objArr) {
            if (i >= this.mLogLevel) {
                log(i, UaLog.buildMessage(str, objArr));
            }
        }

        @Override // com.ua.sdk.UaLog.Logger
        public void log(int i, String str, Throwable th) {
            if (i >= this.mLogLevel) {
                if (i == 3) {
                    Log.d("sdk", str, th);
                    return;
                }
                if (i == 4) {
                    Log.i("sdk", str, th);
                    return;
                }
                if (i == 5) {
                    Log.w("sdk", str, th);
                } else if (i == 6) {
                    Log.e("sdk", str, th);
                } else {
                    if (i != 8) {
                        return;
                    }
                    Log.e("sdk", str, th);
                }
            }
        }

        public void setLogLevel(int i) {
            this.mLogLevel = i;
        }
    }
}
