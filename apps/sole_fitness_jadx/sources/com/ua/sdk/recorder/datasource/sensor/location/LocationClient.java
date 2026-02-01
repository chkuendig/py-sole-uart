package com.ua.sdk.recorder.datasource.sensor.location;

import android.location.Location;

/* loaded from: classes2.dex */
public interface LocationClient {

    public interface LocationClientListener {
        void onLocation(Location location);

        void onStatus(boolean z, boolean z2, float f);
    }

    void connect(LocationClientListener locationClientListener);

    void disconnect();
}
