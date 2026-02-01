package com.mapbox.mapboxsdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class TipView extends View {
    private Paint mPaint;
    private Path mPath;

    public TipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.mPath.rewind();
        int i = measuredWidth / 2;
        float f = i - measuredHeight;
        this.mPath.moveTo(f, 0.0f);
        this.mPath.lineTo(i + measuredHeight, 0.0f);
        this.mPath.lineTo(i, measuredHeight);
        this.mPath.lineTo(f, 0.0f);
        canvas.drawPath(this.mPath, this.mPaint);
    }
}
