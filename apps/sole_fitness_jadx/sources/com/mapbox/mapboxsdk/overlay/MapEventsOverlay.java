package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class MapEventsOverlay extends Overlay {
    private MapEventsReceiver mReceiver;

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    protected void draw(Canvas canvas, MapView mapView, boolean z) {
    }

    public MapEventsOverlay(Context context, MapEventsReceiver mapEventsReceiver) {
        super(context);
        this.mReceiver = mapEventsReceiver;
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public boolean onSingleTapConfirmed(MotionEvent motionEvent, MapView mapView) {
        return this.mReceiver.singleTapUpHelper(mapView.getProjection().fromPixels(motionEvent.getX(), motionEvent.getY()));
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public boolean onLongPress(MotionEvent motionEvent, MapView mapView) {
        return this.mReceiver.longPressHelper(mapView.getProjection().fromPixels(motionEvent.getX(), motionEvent.getY()));
    }
}
