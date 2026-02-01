package com.mapbox.mapboxsdk.views.util;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mapbox.mapboxsdk.api.ILatLng;
import com.mapbox.mapboxsdk.constants.GeoConstants;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.util.GeometryMath;
import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class Projection implements GeoConstants {
    private static final String TAG = "Projection";
    protected static int mTileSize = 256;
    private final int centerX;
    private final int centerY;
    private BoundingBox mBoundingBoxProjection;
    private final Rect mIntrinsicScreenRectProjection;
    private final float mMapOrientation;
    private final Matrix mRotateMatrix;
    private final Rect mScreenRectProjection;
    private final float mZoomLevelProjection;
    private MapView mapView;
    private final int offsetX;
    private final int offsetY;
    private int viewHeight2;
    private int viewWidth2;
    private int worldSize2;

    public Projection(MapView mapView) {
        this.mapView = null;
        Matrix matrix = new Matrix();
        this.mRotateMatrix = matrix;
        this.mapView = mapView;
        this.viewWidth2 = mapView.getMeasuredWidth() >> 1;
        this.viewHeight2 = this.mapView.getMeasuredHeight() >> 1;
        float zoomLevel = this.mapView.getZoomLevel(false);
        this.mZoomLevelProjection = zoomLevel;
        int iMapSize = mapSize(zoomLevel) >> 1;
        this.worldSize2 = iMapSize;
        this.offsetX = -iMapSize;
        this.offsetY = -iMapSize;
        this.centerX = mapView.getScrollX();
        this.centerY = mapView.getScrollY();
        this.mIntrinsicScreenRectProjection = this.mapView.getIntrinsicScreenRect(null);
        this.mScreenRectProjection = this.mapView.getScreenRect(null);
        float mapOrientation = this.mapView.getMapOrientation();
        this.mMapOrientation = mapOrientation;
        matrix.setRotate(-mapOrientation, this.viewWidth2, this.viewHeight2);
    }

    public float getZoomLevel() {
        return this.mZoomLevelProjection;
    }

    public int getHalfWorldSize() {
        return this.worldSize2;
    }

    public BoundingBox getBoundingBox() {
        if (this.mBoundingBoxProjection == null) {
            this.mBoundingBoxProjection = this.mapView.getBoundingBoxInternal();
        }
        return this.mBoundingBoxProjection;
    }

    public Rect getScreenRect() {
        return this.mScreenRectProjection;
    }

    public Rect getIntrinsicScreenRect() {
        return this.mIntrinsicScreenRectProjection;
    }

    public float getMapOrientation() {
        return this.mMapOrientation;
    }

    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    public ILatLng fromPixels(float f, float f2) {
        Rect intrinsicScreenRect = getIntrinsicScreenRect();
        return pixelXYToLatLong(intrinsicScreenRect.left + ((int) f) + this.worldSize2, intrinsicScreenRect.top + ((int) f2) + this.worldSize2, this.mZoomLevelProjection);
    }

    public ILatLng fromPixels(int i, int i2) {
        return fromPixels(i, i2);
    }

    public Point fromMapPixels(int i, int i2, Point point) {
        Point pointReusable = GeometryMath.reusable(point);
        pointReusable.set(i - this.viewWidth2, i2 - this.viewHeight2);
        pointReusable.offset(this.centerX, this.centerY);
        return pointReusable;
    }

    public PointF toPixels(ILatLng iLatLng, PointF pointF) {
        PointF mapPixels = toMapPixels(iLatLng, pointF);
        mapPixels.offset(-this.mIntrinsicScreenRectProjection.exactCenterX(), -this.mIntrinsicScreenRectProjection.exactCenterY());
        float f = this.mMapOrientation;
        if (f % 360.0f != 0.0f) {
            GeometryMath.rotatePoint(0.0f, 0.0f, mapPixels, f, mapPixels);
        }
        mapPixels.offset(this.viewWidth2, this.viewHeight2);
        return mapPixels;
    }

    public PointF toPixels(PointF pointF, PointF pointF2) {
        PointF pointFReusable = GeometryMath.reusable(pointF2);
        pointFReusable.set(pointF);
        pointFReusable.offset(this.viewWidth2 - this.mIntrinsicScreenRectProjection.exactCenterX(), this.viewHeight2 - this.mIntrinsicScreenRectProjection.exactCenterY());
        return pointFReusable;
    }

    public PointF toMapPixels(ILatLng iLatLng, PointF pointF) {
        return toMapPixels(iLatLng.getLatitude(), iLatLng.getLongitude(), pointF);
    }

    public static PointF toMapPixels(double d, double d2, float f, double d3, double d4, PointF pointF) {
        PointF pointFReusable = GeometryMath.reusable(pointF);
        int iMapSize = mapSize(f);
        latLongToPixelXY(d, d2, f, pointFReusable);
        float f2 = -(iMapSize >> 1);
        pointFReusable.offset(f2, f2);
        return pointFReusable;
    }

    public PointF toMapPixels(double d, double d2, PointF pointF) {
        return toMapPixels(d, d2, getZoomLevel(), this.centerX, this.centerY, pointF);
    }

    public static RectF toMapPixels(BoundingBox boundingBox, float f, RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        int iMapSize = mapSize(f) >> 1;
        PointF pointFLatLongToPixelXY = latLongToPixelXY(boundingBox.getLatNorth(), boundingBox.getLonWest(), f, null);
        PointF pointFLatLongToPixelXY2 = latLongToPixelXY(boundingBox.getLatSouth(), boundingBox.getLonEast(), f, null);
        rectF.set(pointFLatLongToPixelXY.x, pointFLatLongToPixelXY.y, pointFLatLongToPixelXY2.x, pointFLatLongToPixelXY2.y);
        float f2 = -iMapSize;
        rectF.offset(f2, f2);
        return rectF;
    }

    public static PointF toMapPixelsProjected(double d, double d2, PointF pointF) {
        if (pointF == null) {
            pointF = new PointF();
        }
        latLongToPixelXY(d, d2, 22.0f, pointF);
        return pointF;
    }

    public PointF toMapPixelsTranslated(PointF pointF, PointF pointF2) {
        if (pointF2 == null) {
            pointF2 = new PointF();
        }
        float zoomLevel = 22.0f - getZoomLevel();
        pointF2.set((int) (GeometryMath.rightShift(pointF.x, zoomLevel) + this.offsetX), (int) (GeometryMath.rightShift(pointF.y, zoomLevel) + this.offsetY));
        return pointF2;
    }

    public Rect fromPixelsToProjected(Rect rect) {
        Rect rect2 = new Rect();
        float zoomLevel = 22.0f - getZoomLevel();
        int iLeftShift = (int) GeometryMath.leftShift(rect.left - this.offsetX, zoomLevel);
        int iLeftShift2 = (int) GeometryMath.leftShift(rect.right - this.offsetX, zoomLevel);
        int iLeftShift3 = (int) GeometryMath.leftShift(rect.bottom - this.offsetY, zoomLevel);
        int iLeftShift4 = (int) GeometryMath.leftShift(rect.top - this.offsetY, zoomLevel);
        rect2.set(Math.min(iLeftShift, iLeftShift2), Math.min(iLeftShift3, iLeftShift4), Math.max(iLeftShift, iLeftShift2), Math.max(iLeftShift3, iLeftShift4));
        return rect2;
    }

    public static void setTileSize(int i) {
        mTileSize = i;
    }

    public static int getTileSize() {
        return mTileSize;
    }

    private static double clip(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    public static int mapSize(float f) {
        return (int) GeometryMath.leftShift(mTileSize, f);
    }

    public static double groundResolution(double d, float f) {
        return (((Math.cos((clip(wrap(d, -90.0d, 90.0d, 180.0d), -85.05112878d, 85.05112878d) * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / mapSize(f);
    }

    public double groundResolution(double d) {
        return groundResolution(d, this.mZoomLevelProjection);
    }

    public static double mapScale(double d, int i, int i2) {
        return (groundResolution(d, i) * i2) / 0.0254d;
    }

    public static PointF latLongToPixelXY(double d, double d2, float f, PointF pointF) {
        double dWrap = wrap(d, -90.0d, 90.0d, 180.0d);
        double dWrap2 = wrap(d2, -180.0d, 180.0d, 360.0d);
        PointF pointF2 = pointF == null ? new PointF() : pointF;
        double dClip = clip(dWrap, -85.05112878d, 85.05112878d);
        double dClip2 = (clip(dWrap2, -180.0d, 180.0d) + 180.0d) / 360.0d;
        double dSin = Math.sin((dClip * 3.141592653589793d) / 180.0d);
        double dLog = 0.5d - (Math.log((dSin + 1.0d) / (1.0d - dSin)) / 12.566370614359172d);
        float fMapSize = mapSize(f);
        double d3 = fMapSize;
        double d4 = fMapSize - 1.0f;
        pointF2.x = (float) clip(dClip2 * d3, 0.0d, d4);
        pointF2.y = (float) clip(dLog * d3, 0.0d, d4);
        return pointF2;
    }

    public static LatLng pixelXYToLatLong(double d, double d2, float f) {
        double dMapSize = mapSize(f);
        double d3 = dMapSize - 1.0d;
        return new LatLng(90.0d - ((Math.atan(Math.exp(((-(0.5d - (clip(wrap(d2, 0.0d, d3, dMapSize), 0.0d, d3) / dMapSize))) * 2.0d) * 3.141592653589793d)) * 360.0d) / 3.141592653589793d), ((clip(wrap(d, 0.0d, d3, dMapSize), 0.0d, d3) / dMapSize) - 0.5d) * 360.0d);
    }

    public LatLng pixelXYToLatLong(double d, double d2) {
        return pixelXYToLatLong(d, d2, this.mZoomLevelProjection);
    }

    public static Point pixelXYToTileXY(int i, int i2, Point point) {
        if (point == null) {
            point = new Point();
        }
        point.x = i / mTileSize;
        point.y = i2 / mTileSize;
        return point;
    }

    public static Point tileXYToPixelXY(int i, int i2, Point point) {
        if (point == null) {
            point = new Point();
        }
        point.x = i * mTileSize;
        point.y = i2 * mTileSize;
        return point;
    }

    private static double wrap(double d, double d2, double d3, double d4) {
        if (d2 > d3) {
            throw new IllegalArgumentException("minValue must be smaller than maxValue: " + d2 + ">" + d3);
        }
        if (d4 <= (d3 - d2) + 1.0d) {
            while (d < d2) {
                d += d4;
            }
            while (d > d3) {
                d -= d4;
            }
            return d;
        }
        throw new IllegalArgumentException("interval must be equal or smaller than maxValue-minValue: min: " + d2 + " max:" + d3 + " int:" + d4);
    }

    public void rotatePoints(float[] fArr) {
        this.mRotateMatrix.mapPoints(fArr);
    }

    public void rotateRect(RectF rectF) {
        this.mRotateMatrix.mapRect(rectF);
    }

    public final Matrix getRotationMatrix() {
        return this.mRotateMatrix;
    }
}
