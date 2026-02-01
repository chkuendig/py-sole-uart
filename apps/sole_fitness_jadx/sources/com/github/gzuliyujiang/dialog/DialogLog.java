package com.github.gzuliyujiang.dialog;

import android.util.Log;

/* loaded from: classes.dex */
public final class DialogLog {
    private static final String TAG = "AndroidPicker";
    private static boolean enable = false;

    private DialogLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            Log.d(TAG, obj.toString());
        }
    }
}
