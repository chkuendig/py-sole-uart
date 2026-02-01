package com.mapbox.mapboxsdk.tileprovider.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.mapbox.mapboxsdk.tileprovider.IRegisterReceiver;

/* loaded from: classes2.dex */
public class SimpleRegisterReceiver implements IRegisterReceiver {
    private final Context mContext;

    public SimpleRegisterReceiver(Context context) {
        this.mContext = context;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.IRegisterReceiver
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mContext.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.IRegisterReceiver
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mContext.unregisterReceiver(broadcastReceiver);
    }
}
