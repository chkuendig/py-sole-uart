package com.dyaco.sole.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

/* loaded from: classes.dex */
public class MyJPushReceiver extends BroadcastReceiver {
    private static final String TAG = "MyJPushReceiver";
    private static int id = 2;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PackageManager.NameNotFoundException {
        boolean zIsPackageInstalled = isPackageInstalled(context.getApplicationContext(), "com.android.vending");
        Log.d(TAG, "isGooglePlayInstalled=" + zIsPackageInstalled);
    }

    public boolean isPackageInstalled(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
