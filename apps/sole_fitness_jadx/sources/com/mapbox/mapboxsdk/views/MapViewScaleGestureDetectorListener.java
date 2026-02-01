package com.mapbox.mapboxsdk.views;

import android.view.ScaleGestureDetector;

/* loaded from: classes2.dex */
public class MapViewScaleGestureDetectorListener implements ScaleGestureDetector.OnScaleGestureListener {
    private static String TAG = "Mapbox scaleDetector";
    private float currentScale;
    private float firstSpan;
    private float lastFocusX;
    private float lastFocusY;
    private final MapView mapView;
    private boolean scaling;

    public MapViewScaleGestureDetectorListener(MapView mapView) {
        this.mapView = mapView;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.lastFocusX = scaleGestureDetector.getFocusX();
        this.lastFocusY = scaleGestureDetector.getFocusY();
        this.firstSpan = scaleGestureDetector.getCurrentSpan();
        this.currentScale = 1.0f;
        if (!this.mapView.isAnimating()) {
            this.mapView.mIsAnimating.set(true);
            this.mapView.getController().aboutToStartAnimation(this.lastFocusX, this.lastFocusY);
            this.scaling = true;
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (!this.scaling) {
            return true;
        }
        this.currentScale = scaleGestureDetector.getCurrentSpan() / this.firstSpan;
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        this.mapView.setScale(this.currentScale);
        this.mapView.getController().offsetDeltaScroll(this.lastFocusX - focusX, this.lastFocusY - focusY);
        this.mapView.getController().panBy(this.lastFocusX - focusX, this.lastFocusY - focusY, true);
        this.lastFocusX = focusX;
        this.lastFocusY = focusY;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        if (this.scaling) {
            this.mapView.mTargetZoomLevel.set(Float.floatToIntBits((float) ((Math.log(this.currentScale) / Math.log(2.0d)) + this.mapView.getZoomLevel(false))));
            this.mapView.getController().onAnimationEnd();
            this.scaling = false;
        }
    }
}
