package com.mapbox.mapboxsdk.tileprovider.modules;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes2.dex */
public class NetworkAvailabilityCheck {
    private final ConnectivityManager mConnectionManager;

    public NetworkAvailabilityCheck(Context context) {
        this.mConnectionManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public boolean getNetworkAvailable() {
        NetworkInfo activeNetworkInfo = this.mConnectionManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    public boolean getWiFiNetworkAvailable() {
        NetworkInfo networkInfo = this.mConnectionManager.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isAvailable();
    }

    public boolean getCellularDataNetworkAvailable() {
        NetworkInfo networkInfo = this.mConnectionManager.getNetworkInfo(0);
        return networkInfo != null && networkInfo.isAvailable();
    }

    public boolean getRouteToPathExists(int i) {
        return this.mConnectionManager.requestRouteToHost(1, i) || this.mConnectionManager.requestRouteToHost(0, i);
    }
}
