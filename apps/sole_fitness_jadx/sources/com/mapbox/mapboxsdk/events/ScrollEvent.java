package com.mapbox.mapboxsdk.events;

import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class ScrollEvent implements MapEvent {
    protected MapView source;
    protected boolean userAction;
    protected int x;
    protected int y;

    public ScrollEvent(MapView mapView, int i, int i2, boolean z) {
        this.source = mapView;
        this.x = i;
        this.y = i2;
        this.userAction = z;
    }

    public MapView getSource() {
        return this.source;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getUserAction() {
        return this.userAction;
    }

    public String toString() {
        return "ScrollEvent [source=" + this.source + ", x=" + this.x + ", y=" + this.y + "]";
    }
}
