package com.mapbox.mapboxsdk.tileprovider.util;

import android.os.Handler;
import android.os.Message;
import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class SimpleInvalidationHandler extends Handler {
    private final MapView mView;

    public SimpleInvalidationHandler(MapView mapView) {
        this.mView = mapView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 0) {
            return;
        }
        this.mView.invalidate();
    }
}
