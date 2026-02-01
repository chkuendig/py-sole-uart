package com.mapbox.mapboxsdk.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.mapbox.mapboxsdk.views.util.Projection;

/* loaded from: classes2.dex */
public class GeometryMath {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final double RAD2DEG = 57.29577951308232d;

    public static int getNextSquareNumberAbove(float f) {
        int i = 1;
        int i2 = 0;
        int i3 = 1;
        while (i <= f) {
            i *= 2;
            i2 = i3;
            i3++;
        }
        return i2;
    }

    public static final Rect getBoundingBoxForRotatedRectangle(Rect rect, int i, int i2, float f, Rect rect2) {
        Rect rectReusable = reusable(rect2);
        if (f % 360.0f == 0.0f) {
            rectReusable.set(rect);
            return rectReusable;
        }
        double d = f * 0.017453292519943295d;
        double dSin = Math.sin(d);
        double dCos = Math.cos(d);
        double d2 = rect.left - i;
        double d3 = rect.top - i2;
        double d4 = i;
        double d5 = (d4 - (d2 * dCos)) + (d3 * dSin);
        double d6 = i2;
        double d7 = (d6 - (d2 * dSin)) - (d3 * dCos);
        double d8 = rect.right - i;
        double d9 = rect.top - i2;
        double d10 = (d4 - (d8 * dCos)) + (d9 * dSin);
        double d11 = (d6 - (d8 * dSin)) - (d9 * dCos);
        double d12 = rect.left - i;
        double d13 = rect.bottom - i2;
        double d14 = (d4 - (d12 * dCos)) + (d13 * dSin);
        double d15 = (d6 - (d12 * dSin)) - (d13 * dCos);
        double d16 = rect.right - i;
        double d17 = rect.bottom - i2;
        double d18 = (d4 - (d16 * dCos)) + (d17 * dSin);
        double d19 = (d6 - (d16 * dSin)) - (d17 * dCos);
        rectReusable.set((int) Min4(d5, d10, d14, d18), (int) Min4(d7, d11, d15, d19), (int) Max4(d5, d10, d14, d18), (int) Max4(d7, d11, d15, d19));
        return rectReusable;
    }

    public static final PointF reusable(PointF pointF) {
        return pointF != null ? pointF : new PointF();
    }

    public static final Point reusable(Point point) {
        return point != null ? point : new Point();
    }

    public static final RectF reusable(RectF rectF) {
        return rectF != null ? rectF : new RectF();
    }

    public static final Rect reusable(Rect rect) {
        return rect != null ? rect : new Rect();
    }

    public static PointF rotatePoint(float f, float f2, PointF pointF, float f3, PointF pointF2) {
        PointF pointFReusable = reusable(pointF2);
        double d = f3 * 0.017453292519943295d;
        double dSin = Math.sin(d);
        double dCos = Math.cos(d);
        double d2 = pointF.x - f;
        double d3 = pointF.y - f2;
        double d4 = f;
        double d5 = f2;
        pointFReusable.set((float) (((d2 * dCos) - (d3 * dSin)) + d4 + d4), (float) ((d2 * dSin) + (d3 * dCos) + d5 + d5));
        return pointFReusable;
    }

    private static double Min4(double d, double d2, double d3, double d4) {
        return Math.floor(Math.min(Math.min(d, d2), Math.min(d3, d4)));
    }

    private static double Max4(double d, double d2, double d3, double d4) {
        return Math.ceil(Math.max(Math.max(d, d2), Math.max(d3, d4)));
    }

    public static int mod(int i, int i2) {
        if (i > 0) {
            return i % i2;
        }
        while (i < 0) {
            i += i2;
        }
        return i;
    }

    public static float leftShift(float f, float f2) {
        return (float) (f * Math.pow(2.0d, f2));
    }

    public static float rightShift(float f, float f2) {
        return (float) (f / Math.pow(2.0d, f2));
    }

    public static Rect viewPortRect(float f, Projection projection, Rect rect) {
        Rect rectReusable = reusable(rect);
        Rect screenRect = projection.getScreenRect();
        int iMapSize = Projection.mapSize(f) >> 1;
        rectReusable.set(screenRect);
        rectReusable.offset(iMapSize, iMapSize);
        return rectReusable;
    }

    public static Rect viewPortRectForTileDrawing(float f, Projection projection, Rect rect) {
        Rect rectReusable = reusable(rect);
        Rect screenRect = projection.getScreenRect();
        int iMapSize = Projection.mapSize(f) >> 1;
        int iMapSize2 = Projection.mapSize((float) Math.floor(f)) >> 1;
        float f2 = iMapSize2 / iMapSize;
        rectReusable.set((int) (screenRect.left * f2), (int) (screenRect.top * f2), (int) (screenRect.right * f2), (int) (f2 * screenRect.bottom));
        rectReusable.offset(iMapSize2, iMapSize2);
        return rectReusable;
    }

    public static Rect viewPortRect(Projection projection, Rect rect) {
        return viewPortRect(projection.getZoomLevel(), projection, rect);
    }

    public static Rect viewPortRectForTileDrawing(Projection projection, Rect rect) {
        return viewPortRectForTileDrawing(projection.getZoomLevel(), projection, rect);
    }
}
