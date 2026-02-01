package com.mapbox.mapboxsdk.views.safecanvas;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public class SafeTranslatedPath extends Path {
    private static final RectF sRectF = new RectF();
    public int xOffset = 0;
    public int yOffset = 0;

    public void onDrawCycleStart(ISafeCanvas iSafeCanvas) {
        super.offset(iSafeCanvas.getXOffset() - this.xOffset, iSafeCanvas.getYOffset() - this.yOffset);
        this.xOffset = iSafeCanvas.getXOffset();
        this.yOffset = iSafeCanvas.getYOffset();
    }

    @Override // android.graphics.Path
    public void reset() {
        super.reset();
    }

    @Override // android.graphics.Path
    public void rewind() {
        super.rewind();
    }

    @Override // android.graphics.Path
    public void set(Path path) {
        super.set(path);
    }

    @Override // android.graphics.Path
    public Path.FillType getFillType() {
        return super.getFillType();
    }

    @Override // android.graphics.Path
    public void setFillType(Path.FillType fillType) {
        super.setFillType(fillType);
    }

    @Override // android.graphics.Path
    public boolean isInverseFillType() {
        return super.isInverseFillType();
    }

    @Override // android.graphics.Path
    public void toggleInverseFillType() {
        super.toggleInverseFillType();
    }

    @Override // android.graphics.Path
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isRect(Rect rect) {
        rect.offset(this.xOffset, this.yOffset);
        boolean zIsRect = super.isRect(toOffsetRectF(rect, sRectF));
        rect.offset(-this.xOffset, -this.yOffset);
        return zIsRect;
    }

    public void computeBounds(Rect rect, boolean z) {
        RectF rectF = sRectF;
        super.computeBounds(rectF, z);
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Path
    public void incReserve(int i) {
        super.incReserve(i);
    }

    public void moveTo(double d, double d2) {
        super.moveTo((float) (d + this.xOffset), (float) (d2 + this.yOffset));
    }

    @Override // android.graphics.Path
    public void rMoveTo(float f, float f2) {
        super.rMoveTo(f, f2);
    }

    public void lineTo(double d, double d2) {
        super.lineTo((float) (d + this.xOffset), (float) (d2 + this.yOffset));
    }

    @Override // android.graphics.Path
    public void rLineTo(float f, float f2) {
        super.rLineTo(f, f2);
    }

    public void quadTo(double d, double d2, double d3, double d4) {
        int i = this.xOffset;
        int i2 = this.yOffset;
        super.quadTo((float) (d + i), (float) (d2 + i2), (float) (d3 + i), (float) (d4 + i2));
    }

    @Override // android.graphics.Path
    public void rQuadTo(float f, float f2, float f3, float f4) {
        super.rQuadTo(f, f2, f3, f4);
    }

    public void cubicTo(double d, double d2, double d3, double d4, double d5, double d6) {
        int i = this.xOffset;
        int i2 = this.yOffset;
        super.cubicTo((float) (d + i), (float) (d2 + i2), (float) (d3 + i), (float) (d4 + i2), (float) (d5 + i), (float) (d6 + i2));
    }

    @Override // android.graphics.Path
    public void rCubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        super.rCubicTo(f, f2, f3, f4, f5, f6);
    }

    public void arcTo(Rect rect, float f, float f2, boolean z) {
        rect.offset(this.xOffset, this.yOffset);
        super.arcTo(toOffsetRectF(rect, sRectF), f, f2, z);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    public void arcTo(Rect rect, float f, float f2) {
        rect.offset(this.xOffset, this.yOffset);
        super.arcTo(toOffsetRectF(rect, sRectF), f, f2);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Path
    public void close() {
        super.close();
    }

    public void addRect(Rect rect, Path.Direction direction) {
        rect.offset(this.xOffset, this.yOffset);
        super.addRect(toOffsetRectF(rect, sRectF), direction);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    public void addRect(double d, double d2, double d3, double d4, Path.Direction direction) {
        int i = this.xOffset;
        int i2 = this.yOffset;
        super.addRect((float) (d + i), (float) (d2 + i2), (float) (d3 + i), (float) (d4 + i2), direction);
    }

    public void addOval(Rect rect, Path.Direction direction) {
        rect.offset(this.xOffset, this.yOffset);
        super.addOval(toOffsetRectF(rect, sRectF), direction);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    public void addCircle(double d, double d2, float f, Path.Direction direction) {
        super.addCircle((float) (d + this.xOffset), (float) (d2 + this.yOffset), f, direction);
    }

    public void addArc(Rect rect, float f, float f2) {
        rect.offset(this.xOffset, this.yOffset);
        super.addArc(toOffsetRectF(rect, sRectF), f, f2);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    public void addRoundRect(Rect rect, float f, float f2, Path.Direction direction) {
        rect.offset(this.xOffset, this.yOffset);
        super.addRoundRect(toOffsetRectF(rect, sRectF), f, f2, direction);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    public void addRoundRect(Rect rect, float[] fArr, Path.Direction direction) {
        rect.offset(this.xOffset, this.yOffset);
        super.addRoundRect(toOffsetRectF(rect, sRectF), fArr, direction);
        rect.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Path
    public void addPath(Path path, float f, float f2) {
        boolean z = path instanceof SafeTranslatedPath;
        if (!z) {
            path.offset(this.xOffset, this.yOffset);
        }
        super.addPath(path, f, f2);
        if (z) {
            return;
        }
        path.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Path
    public void addPath(Path path) {
        boolean z = path instanceof SafeTranslatedPath;
        if (!z) {
            path.offset(this.xOffset, this.yOffset);
        }
        super.addPath(path);
        if (z) {
            return;
        }
        path.offset(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Path
    public void addPath(Path path, Matrix matrix) {
        boolean z = path instanceof SafeTranslatedPath;
        if (!z) {
            matrix.preTranslate(this.xOffset, this.yOffset);
        }
        super.addPath(path, matrix);
        if (z) {
            return;
        }
        matrix.preTranslate(-this.xOffset, -this.yOffset);
    }

    @Override // android.graphics.Path
    public void offset(float f, float f2, Path path) {
        super.offset(f, f2, path);
    }

    @Override // android.graphics.Path
    public void offset(float f, float f2) {
        super.offset(f, f2);
    }

    public void setLastPoint(double d, double d2) {
        super.setLastPoint((float) (d + this.xOffset), (float) (d2 + this.yOffset));
    }

    @Override // android.graphics.Path
    public void transform(Matrix matrix, Path path) {
        super.transform(matrix, path);
    }

    @Override // android.graphics.Path
    public void transform(Matrix matrix) {
        super.transform(matrix);
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    protected final RectF toOffsetRectF(Rect rect, RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect.left + this.xOffset, rect.top + this.yOffset, rect.right + this.xOffset, rect.bottom + this.yOffset);
        return rectF;
    }
}
