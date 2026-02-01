package com.mapbox.mapboxsdk.views;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import com.mapbox.mapboxsdk.views.util.Projection;

/* loaded from: classes2.dex */
public class MapViewGestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
    private final MapView mapView;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public MapViewGestureDetectorListener(MapView mapView) {
        this.mapView = mapView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.mapView.mIsFlinging) {
            this.mapView.mScroller.abortAnimation();
            this.mapView.mIsFlinging = false;
        }
        this.mapView.getOverlayManager().onDown(motionEvent, this.mapView);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.mapView.isAnimating() && !this.mapView.getOverlayManager().onFling(motionEvent, motionEvent2, f, f2, this.mapView)) {
            this.mapView.getProjection();
            int iMapSize = Projection.mapSize(this.mapView.getZoomLevel(false));
            this.mapView.mIsFlinging = true;
            int i = -iMapSize;
            this.mapView.mScroller.fling(this.mapView.getScrollX(), this.mapView.getScrollY(), (int) (-f), (int) (-f2), i, iMapSize, i, iMapSize);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (!this.mapView.getOverlayManager().onLongPress(motionEvent, this.mapView) && UtilConstants.DEBUGMODE) {
            this.mapView.zoomOutFixing(this.mapView.getProjection().fromPixels(motionEvent.getX(), motionEvent.getY()), false);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!this.mapView.isAnimating() && !this.mapView.getOverlayManager().onScroll(motionEvent, motionEvent2, f, f2, this.mapView)) {
            this.mapView.getController().panBy((int) f, (int) f2, true);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        this.mapView.getOverlayManager().onShowPress(motionEvent, this.mapView);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.mapView.getOverlayManager().onSingleTapConfirmed(motionEvent, this.mapView);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.mapView.getOverlayManager().onDoubleTap(motionEvent, this.mapView)) {
            return true;
        }
        return this.mapView.zoomInFixing(this.mapView.getProjection().fromPixels(motionEvent.getX(), motionEvent.getY()), false);
    }
}
