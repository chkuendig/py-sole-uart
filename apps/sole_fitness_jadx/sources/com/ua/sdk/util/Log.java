package com.ua.sdk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class Log {
    private static final String LOG_TAG = "sdk";
    private static boolean debugEnabled = true;

    private Log() {
    }

    public static void setDebugEnabled(boolean z) {
        debugEnabled = z;
    }

    public static boolean isDebugEnabled() {
        return debugEnabled;
    }

    public static void exception(String str, String[] strArr) {
        android.util.Log.e("sdk", str, null);
        if (strArr != null) {
            for (String str2 : strArr) {
                android.util.Log.e("sdk", str2, null);
            }
        }
    }

    public static void exception(String str, List<String> list) {
        android.util.Log.e("sdk", str, null);
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                android.util.Log.e("sdk", it.next(), null);
            }
        }
    }

    public static void exception(String str, Throwable th) {
        android.util.Log.e("sdk", str, th);
    }

    public static void exception(Throwable th) {
        android.util.Log.e("sdk", "", th);
    }

    public static void exception(String str) {
        android.util.Log.e("sdk", str);
    }

    public static void debug(String str) {
        debug(str, (Throwable) null);
    }

    public static void debug(Throwable th) {
        debug((String) null, th);
    }

    public static void debug(String str, Throwable th) {
        if (debugEnabled) {
            if (str != null && str.length() > 0) {
                android.util.Log.d("sdk", str + StringUtils.LF);
            }
            if (th != null) {
                android.util.Log.d("sdk", th.getMessage());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    android.util.Log.d("sdk", "\t" + stackTraceElement.toString());
                }
            }
        }
    }

    public static InputStream debug(InputStream inputStream) {
        return debug((String) null, inputStream);
    }

    public static InputStream debug(String str, InputStream inputStream) throws IOException {
        if (!debugEnabled || inputStream == null) {
            return inputStream;
        }
        byte[] bArr = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (IOException e) {
                exception(e);
            }
        }
        inputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        StringBuffer stringBuffer = new StringBuffer();
        if (str == null) {
            str = "";
        }
        stringBuffer.append(str);
        while (true) {
            try {
                int i2 = byteArrayInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, i2));
            } catch (IOException e2) {
                exception(e2);
            }
        }
        byteArrayInputStream.close();
        debug(stringBuffer.toString());
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }
}
