package com.android.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class TraceUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ROOT);

    public static String getCurrentStack() {
        return getCurrentStack(1);
    }

    public static String getCurrentStack(int numberOfTopFramesToRemove) {
        int iIndexOf;
        String stackTrace = getStackTrace(new Throwable() { // from class: com.android.utils.TraceUtils.1
            @Override // java.lang.Throwable
            public String toString() {
                return "";
            }
        });
        if (numberOfTopFramesToRemove < 0) {
            numberOfTopFramesToRemove = 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < numberOfTopFramesToRemove + 2 && (iIndexOf = stackTrace.indexOf(10, i)) >= 0; i2++) {
            i = iIndexOf + 1;
        }
        return stackTrace.substring(i);
    }

    public static String getStackTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            t.printStackTrace(printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Throwable th) {
            try {
                printWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String getSimpleId(Object obj) {
        if (obj == null) {
            return AbstractJsonLexerKt.NULL;
        }
        return String.format("%s@%08X", obj.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(obj)));
    }

    public static String getSimpleIds(Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : iterable) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(getSimpleId(obj));
        }
        return sb.toString();
    }

    public static String currentTime() {
        return DATE_FORMAT.format(new Date());
    }

    private TraceUtils() {
    }
}
