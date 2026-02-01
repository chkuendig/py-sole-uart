package com.mapbox.mapboxsdk.views.safecanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;

/* loaded from: classes2.dex */
public interface ISafeCanvas {

    public interface UnsafeCanvasHandler {
        void onUnsafeCanvas(Canvas canvas);
    }

    boolean clipPath(SafeTranslatedPath safeTranslatedPath);

    boolean clipPath(SafeTranslatedPath safeTranslatedPath, Region.Op op);

    boolean clipRect(double d, double d2, double d3, double d4);

    boolean clipRect(double d, double d2, double d3, double d4, Region.Op op);

    boolean clipRect(int i, int i2, int i3, int i4);

    boolean clipRect(Rect rect);

    boolean clipRect(Rect rect, Region.Op op);

    boolean clipRegion(Region region);

    boolean clipRegion(Region region, Region.Op op);

    void concat(Matrix matrix);

    void drawARGB(int i, int i2, int i3, int i4);

    void drawArc(Rect rect, float f, float f2, boolean z, SafePaint safePaint);

    void drawBitmap(Bitmap bitmap, double d, double d2, SafePaint safePaint);

    void drawBitmap(Bitmap bitmap, Matrix matrix, SafePaint safePaint);

    void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, SafePaint safePaint);

    void drawBitmap(int[] iArr, int i, int i2, double d, double d2, int i3, int i4, boolean z, SafePaint safePaint);

    void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, SafePaint safePaint);

    void drawBitmapMesh(Bitmap bitmap, int i, int i2, double[] dArr, int i3, int[] iArr, int i4, SafePaint safePaint);

    void drawCircle(double d, double d2, float f, SafePaint safePaint);

    void drawColor(int i);

    void drawColor(int i, PorterDuff.Mode mode);

    void drawLine(double d, double d2, double d3, double d4, SafePaint safePaint);

    void drawLines(double[] dArr, int i, int i2, SafePaint safePaint);

    void drawLines(double[] dArr, SafePaint safePaint);

    void drawOval(Rect rect, SafePaint safePaint);

    void drawPaint(SafePaint safePaint);

    void drawPath(SafeTranslatedPath safeTranslatedPath, SafePaint safePaint);

    void drawPicture(Picture picture);

    void drawPicture(Picture picture, Rect rect);

    void drawPoint(double d, double d2, SafePaint safePaint);

    void drawPoints(double[] dArr, int i, int i2, SafePaint safePaint);

    void drawPoints(double[] dArr, SafePaint safePaint);

    void drawPosText(String str, double[] dArr, SafePaint safePaint);

    void drawPosText(char[] cArr, int i, int i2, double[] dArr, SafePaint safePaint);

    void drawRGB(int i, int i2, int i3);

    void drawRect(double d, double d2, double d3, double d4, SafePaint safePaint);

    void drawRect(Rect rect, SafePaint safePaint);

    void drawRoundRect(Rect rect, float f, float f2, SafePaint safePaint);

    void drawText(CharSequence charSequence, int i, int i2, double d, double d2, SafePaint safePaint);

    void drawText(String str, double d, double d2, SafePaint safePaint);

    void drawText(String str, int i, int i2, double d, double d2, SafePaint safePaint);

    void drawText(char[] cArr, int i, int i2, double d, double d2, SafePaint safePaint);

    void drawTextOnPath(String str, SafeTranslatedPath safeTranslatedPath, float f, float f2, SafePaint safePaint);

    void drawTextOnPath(char[] cArr, int i, int i2, SafeTranslatedPath safeTranslatedPath, float f, float f2, SafePaint safePaint);

    void drawVertices(Canvas.VertexMode vertexMode, int i, double[] dArr, int i2, float[] fArr, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, SafePaint safePaint);

    Rect getClipBounds();

    boolean getClipBounds(Rect rect);

    int getDensity();

    DrawFilter getDrawFilter();

    int getHeight();

    Matrix getMatrix();

    void getMatrix(Matrix matrix);

    Canvas getSafeCanvas();

    int getSaveCount();

    void getUnsafeCanvas(UnsafeCanvasHandler unsafeCanvasHandler);

    int getWidth();

    Canvas getWrappedCanvas();

    int getXOffset();

    int getYOffset();

    boolean isOpaque();

    boolean quickReject(double d, double d2, double d3, double d4, Canvas.EdgeType edgeType);

    boolean quickReject(Rect rect, Canvas.EdgeType edgeType);

    boolean quickReject(SafeTranslatedPath safeTranslatedPath, Canvas.EdgeType edgeType);

    void restore();

    void restoreToCount(int i);

    void rotate(float f);

    void rotate(float f, double d, double d2);

    int save();

    int save(int i);

    int saveLayer(double d, double d2, double d3, double d4, SafePaint safePaint, int i);

    int saveLayer(Rect rect, SafePaint safePaint, int i);

    int saveLayerAlpha(double d, double d2, double d3, double d4, int i, int i2);

    int saveLayerAlpha(Rect rect, int i, int i2);

    void scale(float f, float f2);

    void scale(float f, float f2, double d, double d2);

    void setBitmap(Bitmap bitmap);

    void setDensity(int i);

    void setDrawFilter(DrawFilter drawFilter);

    void setMatrix(Matrix matrix);

    void skew(float f, float f2);

    void translate(float f, float f2);
}
