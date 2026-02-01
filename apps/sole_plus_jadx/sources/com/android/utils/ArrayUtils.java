package com.android.utils;

import java.lang.reflect.Array;

/* loaded from: classes3.dex */
class ArrayUtils {
    private static final int CACHE_SIZE = 73;
    private static final Object[] EMPTY = new Object[0];
    private static Object[] sCache = new Object[73];

    public static int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            int i2 = (1 << i) - 12;
            if (need <= i2) {
                return i2;
            }
        }
        return need;
    }

    private ArrayUtils() {
    }

    public static int idealBooleanArraySize(int need) {
        return idealByteArraySize(need);
    }

    public static int idealShortArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    public static int idealCharArraySize(int need) {
        return idealByteArraySize(need * 2) / 2;
    }

    public static int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public static int idealFloatArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public static int idealObjectArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    public static int idealLongArraySize(int need) {
        return idealByteArraySize(need * 8) / 8;
    }

    public static boolean equals(byte[] array1, byte[] array2, int length) {
        if (array1 == array2) {
            return true;
        }
        if (array1 == null || array2 == null || array1.length < length || array2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static <T> T[] emptyArray(Class<T> cls) throws NegativeArraySizeException {
        if (cls == Object.class) {
            return (T[]) EMPTY;
        }
        int iIdentityHashCode = ((System.identityHashCode(cls) / 8) & Integer.MAX_VALUE) % 73;
        Object objNewInstance = sCache[iIdentityHashCode];
        if (objNewInstance == null || objNewInstance.getClass().getComponentType() != cls) {
            objNewInstance = Array.newInstance((Class<?>) cls, 0);
            sCache[iIdentityHashCode] = objNewInstance;
        }
        return (T[]) ((Object[]) objNewInstance);
    }

    public static <T> boolean contains(T[] array, T value) {
        for (T t : array) {
            if (t == null) {
                if (value == null) {
                    return true;
                }
            } else if (value != null && t.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
