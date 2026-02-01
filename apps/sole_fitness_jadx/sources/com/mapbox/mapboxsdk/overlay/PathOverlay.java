package com.mapbox.mapboxsdk.overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.util.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class PathOverlay extends Overlay {
    private static final String TAG = "PathOverlay";
    private ArrayList<PointF> mPoints;
    private int mPointsPrecomputed;
    private boolean mOptimizePath = true;
    protected Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private final PointF mTempPoint1 = new PointF();
    private final PointF mTempPoint2 = new PointF();
    private final Rect mLineBounds = new Rect();

    public PathOverlay() {
        this.mPaint.setColor(-16776961);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(10.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        clearPath();
    }

    public PathOverlay(int i, float f) {
        this.mPaint.setColor(i);
        this.mPaint.setStrokeWidth(f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        clearPath();
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public PathOverlay setPaint(Paint paint) {
        this.mPaint = paint;
        return this;
    }

    public void clearPath() {
        this.mPoints = new ArrayList<>();
        this.mPointsPrecomputed = 0;
    }

    public void addPoint(LatLng latLng) {
        addPoint(latLng.getLatitude(), latLng.getLongitude());
    }

    public void addPoint(double d, double d2) {
        this.mPoints.add(new PointF((float) d, (float) d2));
    }

    public void addPoints(LatLng... latLngArr) {
        for (LatLng latLng : latLngArr) {
            addPoint(latLng);
        }
    }

    public void addPoints(List<LatLng> list) {
        Iterator<LatLng> it = list.iterator();
        while (it.hasNext()) {
            addPoint(it.next());
        }
    }

    public void removeAllPoints() {
        this.mPoints.clear();
    }

    public int getNumberOfPoints() {
        return this.mPoints.size();
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    protected void draw(Canvas canvas, MapView mapView, boolean z) {
        int size = this.mPoints.size();
        if (z || size < 2) {
            return;
        }
        Projection projection = mapView.getProjection();
        while (true) {
            int i = this.mPointsPrecomputed;
            if (i >= size) {
                break;
            }
            Projection.toMapPixelsProjected(r2.x, r2.y, this.mPoints.get(i));
            this.mPointsPrecomputed++;
        }
        Rect rectFromPixelsToProjected = projection.fromPixelsToProjected(projection.getScreenRect());
        this.mPath.rewind();
        boolean zIntersects = !this.mOptimizePath;
        PointF pointF = this.mPoints.get(size - 1);
        this.mLineBounds.set((int) pointF.x, (int) pointF.y, (int) pointF.x, (int) pointF.y);
        PointF mapPixelsTranslated = null;
        for (int i2 = size - 2; i2 >= 0; i2--) {
            PointF pointF2 = this.mPoints.get(i2);
            this.mLineBounds.union((int) pointF2.x, (int) pointF2.y);
            if (this.mOptimizePath && !Rect.intersects(rectFromPixelsToProjected, this.mLineBounds)) {
                this.mLineBounds.set((int) pointF2.x, (int) pointF2.y, (int) pointF2.x, (int) pointF2.y);
                mapPixelsTranslated = null;
            } else {
                if (mapPixelsTranslated == null) {
                    mapPixelsTranslated = projection.toMapPixelsTranslated(pointF, this.mTempPoint1);
                    this.mPath.moveTo(mapPixelsTranslated.x, mapPixelsTranslated.y);
                }
                PointF mapPixelsTranslated2 = projection.toMapPixelsTranslated(pointF2, this.mTempPoint2);
                if (Math.abs(mapPixelsTranslated2.x - mapPixelsTranslated.x) + Math.abs(mapPixelsTranslated2.y - mapPixelsTranslated.y) > 1.0f) {
                    this.mPath.lineTo(mapPixelsTranslated2.x, mapPixelsTranslated2.y);
                    mapPixelsTranslated.x = mapPixelsTranslated2.x;
                    mapPixelsTranslated.y = mapPixelsTranslated2.y;
                    if (this.mOptimizePath) {
                        this.mLineBounds.set((int) pointF2.x, (int) pointF2.y, (int) pointF2.x, (int) pointF2.y);
                        zIntersects = true;
                    }
                }
            }
            pointF = pointF2;
        }
        if (!this.mOptimizePath) {
            zIntersects = Rect.intersects(rectFromPixelsToProjected, this.mLineBounds);
        }
        if (zIntersects) {
            float strokeWidth = this.mPaint.getStrokeWidth();
            this.mPaint.setStrokeWidth(strokeWidth / mapView.getScale());
            canvas.drawPath(this.mPath, this.mPaint);
            this.mPaint.setStrokeWidth(strokeWidth);
        }
    }

    public void setOptimizePath(boolean z) {
        this.mOptimizePath = z;
    }
}
