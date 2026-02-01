package com.mapbox.mapboxsdk.overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.mapbox.mapboxsdk.overlay.Overlay;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas;
import com.mapbox.mapboxsdk.views.safecanvas.SafePaint;
import com.mapbox.mapboxsdk.views.util.Projection;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class ItemizedOverlay extends SafeDrawOverlay implements Overlay.Snappable {
    private static SafePaint mClusterTextPaint;
    private Marker mFocusedItem;
    private final ArrayList<Marker> mInternalItemList;
    private OnFocusChangeListener mOnFocusChangeListener;
    protected boolean mDrawFocusedItem = true;
    private boolean mPendingFocusChangedEvent = false;

    public interface OnFocusChangeListener {
        void onFocusChanged(ItemizedOverlay itemizedOverlay, Marker marker);
    }

    protected abstract Marker createItem(int i);

    protected boolean onTap(int i) {
        return false;
    }

    public abstract int size();

    public ItemizedOverlay() {
        if (mClusterTextPaint == null) {
            SafePaint safePaint = new SafePaint();
            mClusterTextPaint = safePaint;
            safePaint.setTextAlign(Paint.Align.CENTER);
            mClusterTextPaint.setTextSize(30.0f);
            mClusterTextPaint.setFakeBoldText(true);
        }
        this.mInternalItemList = new ArrayList<>();
    }

    @Override // com.mapbox.mapboxsdk.overlay.SafeDrawOverlay
    protected void drawSafe(ISafeCanvas iSafeCanvas, MapView mapView, boolean z) {
        OnFocusChangeListener onFocusChangeListener;
        if (z) {
            return;
        }
        if (this.mPendingFocusChangedEvent && (onFocusChangeListener = this.mOnFocusChangeListener) != null) {
            onFocusChangeListener.onFocusChanged(this, this.mFocusedItem);
        }
        this.mPendingFocusChangedEvent = false;
        Projection projection = mapView.getProjection();
        int size = this.mInternalItemList.size() - 1;
        RectF rectF = new RectF(0.0f, 0.0f, mapView.getMeasuredWidth(), mapView.getMeasuredHeight());
        projection.rotateRect(rectF);
        float scale = 1.0f / mapView.getScale();
        for (int i = size; i >= 0; i--) {
            Marker item = getItem(i);
            if (item != this.mFocusedItem) {
                onDrawItem(iSafeCanvas, item, projection, mapView.getMapOrientation(), rectF, scale);
            }
        }
        Marker marker = this.mFocusedItem;
        if (marker != null) {
            onDrawItem(iSafeCanvas, marker, projection, mapView.getMapOrientation(), rectF, scale);
        }
    }

    protected void populate() {
        int size = size();
        this.mInternalItemList.clear();
        this.mInternalItemList.ensureCapacity(size);
        for (int i = 0; i < size; i++) {
            this.mInternalItemList.add(createItem(i));
        }
    }

    public final Marker getItem(int i) {
        return this.mInternalItemList.get(i);
    }

    protected void onDrawItem(ISafeCanvas iSafeCanvas, Marker marker, Projection projection, final float f, RectF rectF, float f2) {
        marker.updateDrawingPosition();
        PointF positionOnMap = marker.getPositionOnMap();
        final Point point = new Point((int) positionOnMap.x, (int) positionOnMap.y);
        if (RectF.intersects(rectF, marker.getDrawingBounds(projection, null))) {
            iSafeCanvas.save();
            iSafeCanvas.scale(f2, f2, positionOnMap.x, positionOnMap.y);
            final Drawable marker2 = marker.getMarker((this.mDrawFocusedItem && this.mFocusedItem == marker) ? 4 : 0);
            if (marker2 == null) {
                return;
            }
            final Point anchor = marker.getAnchor();
            if (isUsingSafeCanvas()) {
                Overlay.drawAt(iSafeCanvas.getSafeCanvas(), marker2, point, anchor, false, f);
            } else {
                iSafeCanvas.getUnsafeCanvas(new ISafeCanvas.UnsafeCanvasHandler() { // from class: com.mapbox.mapboxsdk.overlay.ItemizedOverlay.1
                    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas.UnsafeCanvasHandler
                    public void onUnsafeCanvas(Canvas canvas) {
                        Overlay.drawAt(canvas, marker2, point, anchor, false, f);
                    }
                });
            }
            iSafeCanvas.restore();
        }
    }

    protected boolean markerHitTest(Marker marker, Projection projection, float f, float f2) {
        RectF drawingBounds = marker.getDrawingBounds(projection, null);
        drawingBounds.bottom -= drawingBounds.height() / 2.0f;
        return drawingBounds.contains(f, f2);
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public boolean onSingleTapConfirmed(MotionEvent motionEvent, MapView mapView) {
        int size = size();
        Projection projection = mapView.getProjection();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = 0; i < size; i++) {
            if (markerHitTest(getItem(i), projection, x, y) && onTap(i)) {
                return true;
            }
        }
        return super.onSingleTapConfirmed(motionEvent, mapView);
    }

    public void setDrawFocusedItem(boolean z) {
        this.mDrawFocusedItem = z;
    }

    public void setFocus(Marker marker) {
        this.mPendingFocusChangedEvent = marker != this.mFocusedItem;
        this.mFocusedItem = marker;
    }

    public Marker getFocus() {
        return this.mFocusedItem;
    }

    public void blurItem(Marker marker) {
        if (this.mFocusedItem == marker) {
            setFocus(null);
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mOnFocusChangeListener = onFocusChangeListener;
    }
}
