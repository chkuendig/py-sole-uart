package com.mapbox.mapboxsdk.views.safecanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas;

/* loaded from: classes2.dex */
public class SafeTranslatedCanvas extends Canvas implements ISafeCanvas {
    private Canvas mCanvas;
    private final Matrix mMatrix = new Matrix();
    public int xOffset;
    public int yOffset;
    private static final Matrix sMatrix = new Matrix();
    private static final RectF sRectF = new RectF();
    private static float[] sFloatAry = new float[0];

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public Canvas getSafeCanvas() {
        return this;
    }

    public SafeTranslatedCanvas() {
    }

    public SafeTranslatedCanvas(Canvas canvas) {
        setCanvas(canvas);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int getXOffset() {
        return this.xOffset;
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int getYOffset() {
        return this.yOffset;
    }

    public void setCanvas(Canvas canvas) {
        this.mCanvas = canvas;
        canvas.getMatrix(this.mMatrix);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void getUnsafeCanvas(ISafeCanvas.UnsafeCanvasHandler unsafeCanvasHandler) {
        save();
        setMatrix(getOriginalMatrix());
        unsafeCanvasHandler.onUnsafeCanvas(this.mCanvas);
        restore();
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public Canvas getWrappedCanvas() {
        return this.mCanvas;
    }

    public Matrix getOriginalMatrix() {
        return this.mMatrix;
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipPath(SafeTranslatedPath safeTranslatedPath, Region.Op op) {
        return getWrappedCanvas().clipPath(safeTranslatedPath, op);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipPath(SafeTranslatedPath safeTranslatedPath) {
        return getWrappedCanvas().clipPath(safeTranslatedPath);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRect(double d, double d2, double d3, double d4, Region.Op op) {
        Canvas wrappedCanvas = getWrappedCanvas();
        int i = this.xOffset;
        float f = (float) (d + i);
        int i2 = this.yOffset;
        return wrappedCanvas.clipRect(f, (float) (d2 + i2), (float) (d3 + i), (float) (d4 + i2), op);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRect(double d, double d2, double d3, double d4) {
        Canvas wrappedCanvas = getWrappedCanvas();
        int i = this.xOffset;
        int i2 = this.yOffset;
        return wrappedCanvas.clipRect((float) (d + i), (float) (d2 + i2), (float) (d3 + i), (float) (d4 + i2));
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRect(int i, int i2, int i3, int i4) {
        Canvas wrappedCanvas = getWrappedCanvas();
        int i5 = this.xOffset;
        int i6 = this.yOffset;
        return wrappedCanvas.clipRect(i + i5, i2 + i6, i3 + i5, i4 + i6);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRect(Rect rect, Region.Op op) {
        rect.offset(this.xOffset, this.yOffset);
        return getWrappedCanvas().clipRect(rect, op);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRect(Rect rect) {
        rect.offset(this.xOffset, this.yOffset);
        return getWrappedCanvas().clipRect(rect);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRegion(Region region, Region.Op op) {
        region.translate(this.xOffset, this.yOffset);
        return getWrappedCanvas().clipRegion(region, op);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean clipRegion(Region region) {
        region.translate(this.xOffset, this.yOffset);
        return getWrappedCanvas().clipRegion(region);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void concat(Matrix matrix) {
        getWrappedCanvas().concat(matrix);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawARGB(int i, int i2, int i3, int i4) {
        getWrappedCanvas().drawARGB(i, i2, i3, i4);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawArc(Rect rect, float f, float f2, boolean z, SafePaint safePaint) {
        getWrappedCanvas().drawArc(toOffsetRectF(rect, sRectF), f, f2, z, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawBitmap(Bitmap bitmap, double d, double d2, SafePaint safePaint) {
        getWrappedCanvas().drawBitmap(bitmap, (float) (d + this.xOffset), (float) (d2 + this.yOffset), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, SafePaint safePaint) {
        Matrix matrix2 = sMatrix;
        matrix2.set(matrix);
        matrix2.postTranslate(this.xOffset, this.yOffset);
        getWrappedCanvas().drawBitmap(bitmap, matrix2, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, SafePaint safePaint) {
        rect2.offset(this.xOffset, this.yOffset);
        getWrappedCanvas().drawBitmap(bitmap, rect, rect2, safePaint);
        rect2.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        rect2.offset(this.xOffset, this.yOffset);
        getWrappedCanvas().drawBitmap(bitmap, rect, rect2, paint);
        rect2.offset(-this.xOffset, -this.yOffset);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawBitmap(int[] iArr, int i, int i2, double d, double d2, int i3, int i4, boolean z, SafePaint safePaint) {
        getWrappedCanvas().drawBitmap(iArr, i, i2, (float) (this.xOffset + d), (float) (d2 + this.yOffset), i3, i4, z, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, SafePaint safePaint) {
        getWrappedCanvas().drawBitmap(iArr, i, i2, i3 + i, i4 + i, i5, i6, z, (Paint) safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, double[] dArr, int i3, int[] iArr, int i4, SafePaint safePaint) {
        getWrappedCanvas().drawBitmapMesh(bitmap, i, i2, toOffsetFloatAry(dArr, sFloatAry), i3, iArr, i4, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawCircle(double d, double d2, float f, SafePaint safePaint) {
        getWrappedCanvas().drawCircle((float) (d + this.xOffset), (float) (d2 + this.yOffset), f, safePaint);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawColor(int i, PorterDuff.Mode mode) {
        getWrappedCanvas().drawColor(i, mode);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawColor(int i) {
        getWrappedCanvas().drawColor(i);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawLine(double d, double d2, double d3, double d4, SafePaint safePaint) {
        int i = this.xOffset;
        int i2 = this.yOffset;
        getWrappedCanvas().drawLine((float) (d + i), (float) (d2 + i2), (float) (d3 + i), (float) (d4 + i2), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawLines(double[] dArr, int i, int i2, SafePaint safePaint) {
        getWrappedCanvas().drawLines(toOffsetFloatAry(dArr, sFloatAry), i, i2, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawLines(double[] dArr, SafePaint safePaint) {
        getWrappedCanvas().drawLines(toOffsetFloatAry(dArr, sFloatAry), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawOval(Rect rect, SafePaint safePaint) {
        getWrappedCanvas().drawOval(toOffsetRectF(rect, sRectF), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPaint(SafePaint safePaint) {
        getWrappedCanvas().drawPaint(safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPath(SafeTranslatedPath safeTranslatedPath, SafePaint safePaint) {
        getWrappedCanvas().drawPath(safeTranslatedPath, safePaint);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPicture(Picture picture, Rect rect) {
        rect.offset(this.xOffset, this.yOffset);
        getWrappedCanvas().drawPicture(picture, rect);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPicture(Picture picture) {
        getWrappedCanvas().drawPicture(picture);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPoint(double d, double d2, SafePaint safePaint) {
        getWrappedCanvas().drawPoint((float) (d + this.xOffset), (float) (d2 + this.yOffset), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPoints(double[] dArr, int i, int i2, SafePaint safePaint) {
        getWrappedCanvas().drawPoints(toOffsetFloatAry(dArr, sFloatAry), i, i2, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPoints(double[] dArr, SafePaint safePaint) {
        getWrappedCanvas().drawPoints(toOffsetFloatAry(dArr, sFloatAry), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPosText(char[] cArr, int i, int i2, double[] dArr, SafePaint safePaint) {
        getWrappedCanvas().drawPosText(cArr, i, i2, toOffsetFloatAry(dArr, sFloatAry), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawPosText(String str, double[] dArr, SafePaint safePaint) {
        getWrappedCanvas().drawPosText(str, toOffsetFloatAry(dArr, sFloatAry), safePaint);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawRGB(int i, int i2, int i3) {
        getWrappedCanvas().drawRGB(i, i2, i3);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawRect(double d, double d2, double d3, double d4, SafePaint safePaint) {
        int i = this.xOffset;
        double d5 = d + i;
        double d6 = d3 + i;
        int i2 = this.yOffset;
        getWrappedCanvas().drawRect((float) d5, (float) (d2 + i2), (float) d6, (float) (d4 + i2), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawRect(Rect rect, SafePaint safePaint) {
        rect.offset(this.xOffset, this.yOffset);
        getWrappedCanvas().drawRect(rect, safePaint);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawRoundRect(Rect rect, float f, float f2, SafePaint safePaint) {
        getWrappedCanvas().drawRoundRect(toOffsetRectF(rect, sRectF), f, f2, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawText(String str, double d, double d2, SafePaint safePaint) {
        getWrappedCanvas().drawText(str, (float) (d + this.xOffset), (float) (d2 + this.yOffset), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawText(char[] cArr, int i, int i2, double d, double d2, SafePaint safePaint) {
        getWrappedCanvas().drawText(cArr, i, i2, (float) (d + this.xOffset), (float) (d2 + this.yOffset), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawText(CharSequence charSequence, int i, int i2, double d, double d2, SafePaint safePaint) {
        getWrappedCanvas().drawText(charSequence, i, i2, (float) (d + this.xOffset), (float) (d2 + this.yOffset), safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawText(String str, int i, int i2, double d, double d2, SafePaint safePaint) {
        getWrappedCanvas().drawText(str, i, i2, (float) (d + this.xOffset), (float) (d2 + this.yOffset), (Paint) safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawTextOnPath(char[] cArr, int i, int i2, SafeTranslatedPath safeTranslatedPath, float f, float f2, SafePaint safePaint) {
        getWrappedCanvas().drawTextOnPath(cArr, i, i2, safeTranslatedPath, f, f2, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawTextOnPath(String str, SafeTranslatedPath safeTranslatedPath, float f, float f2, SafePaint safePaint) {
        getWrappedCanvas().drawTextOnPath(str, safeTranslatedPath, f, f2, safePaint);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void drawVertices(Canvas.VertexMode vertexMode, int i, double[] dArr, int i2, float[] fArr, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, SafePaint safePaint) {
        getWrappedCanvas().drawVertices(vertexMode, i, toOffsetFloatAry(dArr, sFloatAry), i2, fArr, i3, iArr, i4, sArr, i5, i6, safePaint);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean getClipBounds(Rect rect) {
        boolean clipBounds = getWrappedCanvas().getClipBounds(rect);
        if (rect != null) {
            rect.offset(-this.xOffset, -this.yOffset);
        }
        return clipBounds;
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int getDensity() {
        return getWrappedCanvas().getDensity();
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public DrawFilter getDrawFilter() {
        return getWrappedCanvas().getDrawFilter();
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int getHeight() {
        return getWrappedCanvas().getHeight();
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void getMatrix(Matrix matrix) {
        getWrappedCanvas().getMatrix(matrix);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int getSaveCount() {
        return getWrappedCanvas().getSaveCount();
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int getWidth() {
        return getWrappedCanvas().getWidth();
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean isOpaque() {
        return getWrappedCanvas().isOpaque();
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean quickReject(double d, double d2, double d3, double d4, Canvas.EdgeType edgeType) {
        int i = this.xOffset;
        double d5 = d + i;
        double d6 = d3 + i;
        int i2 = this.yOffset;
        return getWrappedCanvas().quickReject((float) d5, (float) (d2 + i2), (float) d6, (float) (d4 + i2), edgeType);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean quickReject(SafeTranslatedPath safeTranslatedPath, Canvas.EdgeType edgeType) {
        return getWrappedCanvas().quickReject(safeTranslatedPath, edgeType);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public boolean quickReject(Rect rect, Canvas.EdgeType edgeType) {
        return getWrappedCanvas().quickReject(toOffsetRectF(rect, sRectF), edgeType);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void restore() {
        getWrappedCanvas().restore();
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void restoreToCount(int i) {
        getWrappedCanvas().restoreToCount(i);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void rotate(float f) {
        getWrappedCanvas().translate(this.xOffset, this.yOffset);
        getWrappedCanvas().rotate(f);
        getWrappedCanvas().translate(-this.xOffset, -this.yOffset);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void rotate(float f, double d, double d2) {
        getWrappedCanvas().rotate(f, (float) (d + this.xOffset), (float) (d2 + this.yOffset));
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int save() {
        return getWrappedCanvas().save();
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int save(int i) {
        return getWrappedCanvas().save(i);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int saveLayer(double d, double d2, double d3, double d4, SafePaint safePaint, int i) {
        Canvas wrappedCanvas = getWrappedCanvas();
        int i2 = this.xOffset;
        float f = (float) (d + i2);
        int i3 = this.yOffset;
        return wrappedCanvas.saveLayer(f, (float) (d2 + i3), (float) (d3 + i2), (float) (d4 + i3), safePaint, i);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int saveLayer(Rect rect, SafePaint safePaint, int i) {
        return getWrappedCanvas().saveLayer(toOffsetRectF(rect, sRectF), safePaint, i);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int saveLayerAlpha(double d, double d2, double d3, double d4, int i, int i2) {
        Canvas wrappedCanvas = getWrappedCanvas();
        int i3 = this.xOffset;
        float f = (float) (d + i3);
        int i4 = this.yOffset;
        return wrappedCanvas.saveLayerAlpha(f, (float) (d2 + i4), (float) (d3 + i3), (float) (d4 + i4), i, i2);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public int saveLayerAlpha(Rect rect, int i, int i2) {
        return getWrappedCanvas().saveLayerAlpha(toOffsetRectF(rect, sRectF), i, i2);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void scale(float f, float f2) {
        getWrappedCanvas().scale(f, f2);
    }

    @Override // com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void scale(float f, float f2, double d, double d2) {
        getWrappedCanvas().scale(f, f2, (float) (d + this.xOffset), (float) (d2 + this.yOffset));
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void setBitmap(Bitmap bitmap) {
        getWrappedCanvas().setBitmap(bitmap);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void setDensity(int i) {
        getWrappedCanvas().setDensity(i);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void setDrawFilter(DrawFilter drawFilter) {
        getWrappedCanvas().setDrawFilter(drawFilter);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void setMatrix(Matrix matrix) {
        getWrappedCanvas().setMatrix(matrix);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void skew(float f, float f2) {
        getWrappedCanvas().skew(f, f2);
    }

    @Override // android.graphics.Canvas, com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas
    public void translate(float f, float f2) {
        getWrappedCanvas().translate(f, f2);
    }

    public boolean equals(Object obj) {
        return getWrappedCanvas().equals(obj);
    }

    public int hashCode() {
        return getWrappedCanvas().hashCode();
    }

    public String toString() {
        return getWrappedCanvas().toString();
    }

    protected final RectF toOffsetRectF(Rect rect, RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect.left + this.xOffset, rect.top + this.yOffset, rect.right + this.xOffset, rect.bottom + this.yOffset);
        return rectF;
    }

    protected final float[] toOffsetFloatAry(double[] dArr, float[] fArr) {
        if (fArr == null || fArr.length < dArr.length) {
            fArr = new float[dArr.length];
        }
        for (int i = 0; i < dArr.length; i++) {
            fArr[i] = (float) (dArr[i] + (i % 2 == 0 ? this.xOffset : this.yOffset));
        }
        return fArr;
    }
}
