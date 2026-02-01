package com.mapbox.mapboxsdk.overlay;

import com.mapbox.mapboxsdk.api.ILatLng;

/* loaded from: classes2.dex */
public interface MapEventsReceiver {
    boolean longPressHelper(ILatLng iLatLng);

    boolean singleTapUpHelper(ILatLng iLatLng);
}
