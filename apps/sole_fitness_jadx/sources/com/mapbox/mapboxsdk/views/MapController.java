package com.mapbox.mapboxsdk.views;

import android.graphics.PointF;
import android.view.animation.LinearInterpolator;
import com.mapbox.mapboxsdk.api.ILatLng;
import com.mapbox.mapboxsdk.views.util.Projection;
import com.mapbox.mapboxsdk.views.util.constants.MapViewConstants;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.TypeEvaluator;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MapController implements MapViewConstants {
    private static final String TAG = "Mapbox MapController";
    private ObjectAnimator mCurrentAnimation;
    protected final MapView mMapView;
    private ILatLng zoomOnLatLong = null;
    private PointF zoomDeltaScroll = new PointF();
    private ILatLng animateToTargetPoint = null;
    private boolean mCurrentlyUserAction = false;
    private ILatLng mPointToGoTo = null;
    private float mZoomToZoomTo = -1.0f;

    public class PointEvaluator implements TypeEvaluator<PointF> {
        public PointEvaluator() {
        }

        @Override // com.nineoldandroids.animation.TypeEvaluator
        public PointF evaluate(float f, PointF pointF, PointF pointF2) {
            return new PointF(((pointF2.x - pointF.x) * f) + pointF.x, (f * (pointF2.y - pointF.y)) + pointF.y);
        }
    }

    public MapController(MapView mapView) {
        this.mMapView = mapView;
    }

    public boolean currentlyInUserAction() {
        return this.mCurrentlyUserAction;
    }

    public void setCurrentlyInUserAction(boolean z) {
        this.mCurrentlyUserAction = z;
    }

    protected void aboutToStartAnimation(ILatLng iLatLng, PointF pointF) {
        this.zoomOnLatLong = iLatLng;
        Projection projection = this.mMapView.getProjection();
        this.mMapView.mMultiTouchScalePoint.set(pointF.x, pointF.y);
        projection.toPixels(pointF, pointF);
        this.zoomDeltaScroll.set((float) ((this.mMapView.getMeasuredWidth() / 2.0d) - pointF.x), (float) ((this.mMapView.getMeasuredHeight() / 2.0d) - pointF.y));
    }

    protected void aboutToStartAnimation(ILatLng iLatLng) {
        aboutToStartAnimation(iLatLng, this.mMapView.getProjection().toMapPixels(iLatLng, null));
    }

    protected void aboutToStartAnimation(PointF pointF) {
        float zoomLevel = this.mMapView.getZoomLevel(false);
        this.mMapView.getProjection();
        double dMapSize = Projection.mapSize(zoomLevel) >> 1;
        this.mMapView.getProjection();
        aboutToStartAnimation(Projection.pixelXYToLatLong(pointF.x + dMapSize, pointF.y + dMapSize, zoomLevel), pointF);
    }

    protected void aboutToStartAnimation(float f, float f2) {
        float measuredWidth = this.mMapView.getMeasuredWidth() / 2.0f;
        float measuredHeight = this.mMapView.getMeasuredHeight() / 2.0f;
        PointF scrollPoint = this.mMapView.getScrollPoint();
        double d = (scrollPoint.x + f) - measuredWidth;
        double d2 = (scrollPoint.y + f2) - measuredHeight;
        float zoomLevel = this.mMapView.getZoomLevel(false);
        this.mMapView.getProjection();
        double dMapSize = Projection.mapSize(zoomLevel) >> 1;
        this.mMapView.getProjection();
        this.zoomOnLatLong = Projection.pixelXYToLatLong(d + dMapSize, dMapSize + d2, zoomLevel);
        this.mMapView.mMultiTouchScalePoint.set((float) d, (float) d2);
        this.zoomDeltaScroll.set(measuredWidth - f, measuredHeight - f2);
    }

    public boolean animateTo(ILatLng iLatLng, boolean z) {
        return setZoomAnimated(this.mMapView.getZoomLevel(), iLatLng, true, z);
    }

    public boolean animateTo(ILatLng iLatLng) {
        return animateTo(iLatLng, false);
    }

    public boolean goTo(ILatLng iLatLng, PointF pointF) {
        PointF mapPixels = this.mMapView.getProjection().toMapPixels(iLatLng, null);
        mapPixels.offset(pointF.x, pointF.y);
        if (this.mMapView.getScrollPoint().equals(mapPixels)) {
            return false;
        }
        this.mMapView.scrollTo(mapPixels.x, mapPixels.y);
        return true;
    }

    public void panBy(float f, float f2, boolean z) {
        this.mCurrentlyUserAction = z;
        this.mMapView.scrollBy(f, f2);
        this.mCurrentlyUserAction = false;
    }

    public void offsetDeltaScroll(float f, float f2) {
        this.zoomDeltaScroll.offset(f, f2);
    }

    public void panBy(int i, int i2) {
        panBy(i, i2, false);
    }

    public void setCenter(ILatLng iLatLng) {
        setCenter(iLatLng, null);
    }

    public void setCenter(ILatLng iLatLng, PointF pointF) {
        if (iLatLng == null) {
            return;
        }
        if (!this.mMapView.isLayedOut()) {
            this.mPointToGoTo = iLatLng;
            return;
        }
        PointF mapPixels = this.mMapView.getProjection().toMapPixels(iLatLng, null);
        if (pointF != null) {
            mapPixels.offset(pointF.x, pointF.y);
        }
        this.mMapView.scrollTo(mapPixels.x, mapPixels.y);
    }

    public void stopPanning() {
        this.mMapView.mIsFlinging = false;
        this.mMapView.getScroller().forceFinished(true);
    }

    public void stopAnimation(boolean z) {
        ILatLng iLatLng;
        if (!this.mMapView.getScroller().isFinished()) {
            if (z) {
                this.mMapView.mIsFlinging = false;
                this.mMapView.getScroller().abortAnimation();
                setCenter(this.animateToTargetPoint);
            } else {
                stopPanning();
            }
        }
        if (this.mMapView.mIsAnimating.get()) {
            this.mCurrentAnimation.cancel();
            MapView mapView = this.mMapView;
            mapView.setZoomInternal(Float.intBitsToFloat(mapView.mTargetZoomLevel.get()));
            if (z && (iLatLng = this.zoomOnLatLong) != null) {
                goTo(iLatLng, this.zoomDeltaScroll);
            }
            this.mMapView.mIsAnimating.set(false);
        }
    }

    public boolean setZoomAnimated(float f, ILatLng iLatLng, boolean z, boolean z2) {
        int i;
        if (z2 && this.mMapView.isAnimating()) {
            return false;
        }
        if (!this.mMapView.isLayedOut()) {
            this.mPointToGoTo = iLatLng;
            this.mZoomToZoomTo = f;
            return false;
        }
        stopAnimation(true);
        this.mCurrentlyUserAction = z2;
        this.mMapView.mIsFlinging = false;
        float zoomLevel = this.mMapView.getZoomLevel(false);
        PointF scrollPoint = this.mMapView.getScrollPoint();
        PointF mapPixels = Projection.toMapPixels(iLatLng.getLatitude(), iLatLng.getLongitude(), zoomLevel, scrollPoint.x, scrollPoint.y, null);
        float clampedZoomLevel = this.mMapView.getClampedZoomLevel(f);
        boolean z3 = clampedZoomLevel != zoomLevel;
        boolean z4 = z && !mapPixels.equals(scrollPoint);
        if (!z3 && !z4) {
            this.mMapView.invalidate();
            return false;
        }
        this.mMapView.mMultiTouchScalePoint.set(mapPixels.x, mapPixels.y);
        ArrayList arrayList = new ArrayList();
        this.zoomDeltaScroll.set(0.0f, 0.0f);
        if (z3) {
            this.zoomOnLatLong = iLatLng;
            this.mMapView.mTargetZoomLevel.set(Float.floatToIntBits(clampedZoomLevel));
            float f2 = clampedZoomLevel - zoomLevel;
            float fPow = (float) Math.pow(2.0d, f2);
            if (f2 > 0.0f) {
                i = 1;
                arrayList.add(PropertyValuesHolder.ofFloat("scale", 1.0f, fPow));
            } else {
                i = 1;
                arrayList.add(PropertyValuesHolder.ofFloat("scale", 1.0f, fPow));
            }
        } else {
            i = 1;
        }
        if (z4) {
            PointEvaluator pointEvaluator = new PointEvaluator();
            Object[] objArr = new Object[i];
            objArr[0] = mapPixels;
            arrayList.add(PropertyValuesHolder.ofObject("scrollPoint", pointEvaluator, objArr));
        } else {
            this.mMapView.getProjection().toPixels(mapPixels, mapPixels);
            this.zoomDeltaScroll.set((float) ((this.mMapView.getMeasuredWidth() / 2.0d) - mapPixels.x), (float) ((this.mMapView.getMeasuredHeight() / 2.0d) - mapPixels.y));
        }
        if (arrayList.size() <= 0) {
            return false;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder.setDuration(z4 ? 500L : 250L);
        objectAnimatorOfPropertyValuesHolder.setTarget(this.mMapView);
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.mapbox.mapboxsdk.views.MapController.1
            @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MapController.this.onAnimationStart();
                super.onAnimationStart(animator);
            }

            @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MapController.this.onAnimationEnd();
                super.onAnimationEnd(animator);
            }
        });
        this.mCurrentAnimation = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.start();
        return true;
    }

    public MapView setZoom(float f) {
        return setZoom(f, false);
    }

    public MapView setZoom(float f, ILatLng iLatLng, boolean z) {
        this.mCurrentlyUserAction = z;
        stopAnimation(true);
        this.mMapView.setZoomInternal(f, iLatLng, null);
        this.mCurrentlyUserAction = false;
        return this.mMapView;
    }

    public MapView setZoom(float f, boolean z) {
        this.mCurrentlyUserAction = z;
        stopAnimation(true);
        this.mMapView.setZoomInternal(f);
        this.mCurrentlyUserAction = false;
        return this.mMapView;
    }

    public MapView setZoomAnimated(float f) {
        setZoomAnimated(f, this.mMapView.getCenter(), false);
        return this.mMapView;
    }

    public MapView setZoomAnimated(float f, ILatLng iLatLng, boolean z) {
        setZoomAnimated(f, iLatLng, false, z);
        return this.mMapView;
    }

    public boolean zoomIn(boolean z) {
        return zoomInAbout(this.mMapView.getCenter(), z);
    }

    public boolean zoomIn() {
        return zoomIn(false);
    }

    public boolean zoomInAbout(ILatLng iLatLng, boolean z) {
        double zoomLevel = this.mMapView.getZoomLevel(false);
        float fCeil = (float) (Math.ceil(zoomLevel) + 1.0d);
        if (((float) Math.pow(2.0d, fCeil - r0)) > 2.25d) {
            fCeil = (float) Math.ceil(zoomLevel);
        }
        return setZoomAnimated(fCeil, iLatLng, false, z);
    }

    public boolean zoomInAbout(ILatLng iLatLng) {
        return zoomInAbout(iLatLng, false);
    }

    public boolean zoomOut(boolean z) {
        return zoomOutAbout(this.mMapView.getCenter(), z);
    }

    public boolean zoomOut() {
        return zoomOut(false);
    }

    public boolean zoomOutAbout(ILatLng iLatLng, boolean z) {
        double zoomLevel = this.mMapView.getZoomLevel(false);
        float fFloor = (float) Math.floor(zoomLevel);
        if (((float) Math.pow(2.0d, fFloor - r0)) > 0.75d) {
            fFloor = (float) (Math.floor(zoomLevel) - 1.0d);
        }
        return setZoomAnimated(fFloor, iLatLng, false, z);
    }

    public boolean zoomOutAbout(ILatLng iLatLng) {
        return zoomOutAbout(iLatLng, false);
    }

    protected void onAnimationStart() {
        this.mMapView.mIsAnimating.set(true);
    }

    public void onAnimationEnd() {
        stopPanning();
        this.mMapView.mIsAnimating.set(false);
        MapView mapView = this.mMapView;
        mapView.setZoomInternal(Float.intBitsToFloat(mapView.mTargetZoomLevel.get()), this.zoomOnLatLong, this.zoomDeltaScroll);
        this.zoomOnLatLong = null;
        this.mCurrentlyUserAction = false;
    }

    public void mapViewLayedOut() {
        ILatLng iLatLng = this.mPointToGoTo;
        if (iLatLng != null) {
            setCenter(iLatLng);
            this.mPointToGoTo = null;
        }
        float f = this.mZoomToZoomTo;
        if (f != -1.0f) {
            setZoom(f);
            this.mZoomToZoomTo = -1.0f;
        }
    }
}
