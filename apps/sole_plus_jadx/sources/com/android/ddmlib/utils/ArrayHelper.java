package com.android.ddmlib.utils;

/* loaded from: classes3.dex */
public final class ArrayHelper {
    public static void swap32bitsToArray(int value, byte[] dest, int offset) {
        dest[offset] = (byte) (value & 255);
        dest[offset + 1] = (byte) ((65280 & value) >> 8);
        dest[offset + 2] = (byte) ((16711680 & value) >> 16);
        dest[offset + 3] = (byte) ((value & (-16777216)) >> 24);
    }

    public static int swap32bitFromArray(byte[] value, int offset) {
        return ((value[offset + 3] & 255) << 24) | (value[offset] & 255) | ((value[offset + 1] & 255) << 8) | ((value[offset + 2] & 255) << 16);
    }

    public static int swapU16bitFromArray(byte[] value, int offset) {
        return ((value[offset + 1] & 255) << 8) | (value[offset] & 255);
    }

    public static long swap64bitFromArray(byte[] value, int offset) {
        return ((value[offset + 7] & 255) << 56) | (value[offset] & 255) | ((value[offset + 1] & 255) << 8) | ((value[offset + 2] & 255) << 16) | ((value[offset + 3] & 255) << 24) | ((value[offset + 4] & 255) << 32) | ((value[offset + 5] & 255) << 40) | ((value[offset + 6] & 255) << 48);
    }
}
