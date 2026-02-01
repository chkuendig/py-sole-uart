package com.mapbox.mapboxsdk.events;

import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class ZoomEvent implements MapEvent {
    protected MapView source;
    protected boolean userAction;
    protected float zoomLevel;

    public ZoomEvent(MapView mapView, float f, boolean z) {
        this.source = mapView;
        this.zoomLevel = f;
        this.userAction = z;
    }

    public MapView getSource() {
        return this.source;
    }

    public float getZoomLevel() {
        return this.zoomLevel;
    }

    public boolean getUserAction() {
        return this.userAction;
    }

    public String toString() {
        return "ZoomEvent [source=" + this.source + ", zoomLevel=" + this.zoomLevel + ", userAction=" + this.userAction + "]";
    }
}
