package com.ua.sdk.util;

import android.os.Looper;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

/* loaded from: classes2.dex */
public final class Utility {
    private Utility() {
    }

    public static <T> boolean containsNull(Collection<T> collection) {
        Objects.requireNonNull(collection);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return true;
            }
        }
        return false;
    }

    public static long generateId() {
        long jAbs;
        Random random = new Random();
        do {
            jAbs = Math.abs(random.nextLong());
        } while (jAbs == 0);
        return jAbs;
    }

    public static String randomString(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (str.length() > 0) {
            Random random = new Random();
            int length = str.length();
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(str.charAt(Math.abs(random.nextInt()) % length));
            }
        }
        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isUiThread() {
        return Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isEqual(String str, String str2) {
        return isEqual(str, str2, false);
    }

    public static boolean isEqual(String str, String str2, boolean z) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return z ? str.equalsIgnoreCase(str2) : str.equals(str2);
    }

    public static Double strToDouble(String str) {
        try {
            if (isEmpty(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            Log.debug("Potential Error, could not perform strToDouble convertion.", e);
            return null;
        }
    }

    public static Float strToFloat(String str) {
        try {
            if (isEmpty(str)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException e) {
            Log.debug("Potential Error, could not perform strToDouble convertion.", e);
            return null;
        }
    }

    public static Integer strToInteger(String str) {
        try {
            if (isEmpty(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            Log.debug("Potential Error, could not perform strToLong convertion.", e);
            return null;
        }
    }

    public static Long strToLong(String str) {
        try {
            if (isEmpty(str)) {
                return null;
            }
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            Log.debug("Potential Error, could not perform strToLong convertion.", e);
            return null;
        }
    }
}
