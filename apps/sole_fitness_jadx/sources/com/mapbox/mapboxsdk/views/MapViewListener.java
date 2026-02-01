package com.mapbox.mapboxsdk.views;

import com.mapbox.mapboxsdk.api.ILatLng;
import com.mapbox.mapboxsdk.overlay.Marker;

/* loaded from: classes2.dex */
public interface MapViewListener {
    void onHidemarker(MapView mapView, Marker marker);

    void onLongPressMap(MapView mapView, ILatLng iLatLng);

    void onLongPressMarker(MapView mapView, Marker marker);

    void onShowMarker(MapView mapView, Marker marker);

    void onTapMap(MapView mapView, ILatLng iLatLng);

    void onTapMarker(MapView mapView, Marker marker);
}
