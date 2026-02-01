package com.android.utils;

/* loaded from: classes3.dex */
public class HashCodes {
    public static int mix(int hashCode1, int hashCode2) {
        return (hashCode1 * 31) + hashCode2;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3) {
        return (((hashCode1 * 31) + hashCode2) * 31) + hashCode3;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4) {
        return (((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4, int hashCode5) {
        return (((((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4, int hashCode5, int hashCode6) {
        return (((((((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4, int hashCode5, int hashCode6, int hashCode7) {
        return (((((((((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4, int hashCode5, int hashCode6, int hashCode7, int hashCode8) {
        return (((((((((((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4, int hashCode5, int hashCode6, int hashCode7, int hashCode8, int hashCode9) {
        return (((((((((((((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9;
    }

    public static int mix(int hashCode1, int hashCode2, int hashCode3, int hashCode4, int hashCode5, int hashCode6, int hashCode7, int hashCode8, int hashCode9, int hashCode10) {
        return (((((((((((((((((hashCode1 * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10;
    }

    private HashCodes() {
    }
}
