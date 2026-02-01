package com.soletreadmills.sole_v2.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TickDrawingView.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0014JN\u0010\u0018\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/widget/TickDrawingView;", "Landroid/view/View;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "gap", "", "longHeight", "longTickSpacing", "maxValue", "minValue", SdkConstants.ATTR_PADDING, "scaleWidth", "shortHeight", "step", "trailingSpace", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "setConfig", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TickDrawingView extends View {
    public static final int $stable = 8;
    private float gap;
    private float longHeight;
    private float longTickSpacing;
    private float maxValue;
    private float minValue;
    private float padding;
    private float scaleWidth;
    private float shortHeight;
    private float step;
    private float trailingSpace;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TickDrawingView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxValue = 10.0f;
        this.step = 0.1f;
        this.gap = 16.0f;
        this.scaleWidth = 2.0f;
        this.longHeight = 28.0f;
        this.shortHeight = 15.0f;
        this.padding = 32.0f;
        this.longTickSpacing = 0.5f;
    }

    public final void setConfig(float minValue, float maxValue, float step, float gap, float scaleWidth, float longHeight, float shortHeight, float padding, float longTickSpacing) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
        this.gap = gap;
        this.scaleWidth = scaleWidth;
        this.longHeight = longHeight;
        this.shortHeight = shortHeight;
        this.padding = padding;
        this.longTickSpacing = longTickSpacing;
        invalidate();
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f = ((int) ((this.maxValue - this.minValue) / this.step)) * this.gap;
        float size = View.MeasureSpec.getSize(widthMeasureSpec);
        float f2 = this.padding;
        float f3 = size - f2;
        this.trailingSpace = f3;
        setMeasuredDimension((int) (f + f2 + f3), View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorLabel_label1));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        float f = this.padding;
        int i = ((int) ((this.maxValue - this.minValue) / this.step)) + 1;
        int i2 = 0;
        float f2 = f;
        while (i2 < i) {
            float f3 = (i2 == 0 || (this.minValue + (((float) i2) * this.step)) % this.longTickSpacing == 0.0f) ? this.longHeight : this.shortHeight;
            float height = (getHeight() - f3) / 2.0f;
            canvas.drawRect(f2, height, f2 + this.scaleWidth, height + f3, paint);
            f2 += this.gap;
            i2++;
        }
    }
}
