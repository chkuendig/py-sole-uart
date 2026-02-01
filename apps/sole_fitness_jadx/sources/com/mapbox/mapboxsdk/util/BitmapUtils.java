package com.mapbox.mapboxsdk.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class BitmapUtils {
    public static final int[] EXPIRED = {-1};
    private static final String TAG = "BitmapUtils";

    public static BitmapFactory.Options getBitmapOptions(DisplayMetrics displayMetrics) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 160;
        options.inTargetDensity = displayMetrics.densityDpi;
        return options;
    }

    public static boolean isCacheDrawableExpired(Drawable drawable) {
        return drawable != null && drawable.getState() == EXPIRED;
    }

    public static void setCacheDrawableExpired(CacheableBitmapDrawable cacheableBitmapDrawable) {
        if (cacheableBitmapDrawable != null) {
            cacheableBitmapDrawable.setState(EXPIRED);
        }
    }

    private static class ActivityManagerHoneycomb {
        private ActivityManagerHoneycomb() {
        }

        static int getLargeMemoryClass(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    public static int calculateMemoryCacheSize(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z && Build.VERSION.SDK_INT >= 11) {
            memoryClass = ActivityManagerHoneycomb.getLargeMemoryClass(activityManager);
        }
        Log.d(TAG, "LargeHeap enabled? = '" + z + "'");
        int i = (memoryClass * 1048576) / 7;
        Log.d(TAG, "Heap Reserve Request For Cache Size = '" + i + "'");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Log.d(TAG, "Available Memory = '" + memoryInfo.availMem + "'");
        return i;
    }
}
