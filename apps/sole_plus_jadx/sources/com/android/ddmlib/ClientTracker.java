package com.android.ddmlib;

import com.android.ddmlib.internal.ClientImpl;
import com.android.ddmlib.internal.DeviceImpl;

/* loaded from: classes3.dex */
public interface ClientTracker {
    void trackClientToDropAndReopen(ClientImpl client);

    void trackDeviceToDropAndReopen(DeviceImpl device);

    void trackDisconnectedClient(ClientImpl client);
}
