package com.mapbox.mapboxsdk.tileprovider;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes2.dex */
public interface IRegisterReceiver {
    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}
