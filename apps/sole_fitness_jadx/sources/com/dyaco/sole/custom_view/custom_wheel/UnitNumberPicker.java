package com.dyaco.sole.custom_view.custom_wheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.dyaco.sole.R;

/* loaded from: classes.dex */
public class UnitNumberPicker extends NumberPicker {
    private Paint paint;
    private int textX;
    private int textY;
    private String unitText;

    public UnitNumberPicker(Context context) {
        super(context);
    }

    public UnitNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            throw new RuntimeException("DateNumberPicker只能从xml布局文件调用");
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.UnitNumberPicker);
        this.unitText = typedArrayObtainStyledAttributes.getString(0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(2, 14.0f);
        int color = typedArrayObtainStyledAttributes.getColor(1, -7829368);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(color);
        this.paint.setTextSize(dimension);
        this.paint.setAntiAlias(true);
        post(new Runnable() { // from class: com.dyaco.sole.custom_view.custom_wheel.UnitNumberPicker.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(UnitNumberPicker.this.unitText)) {
                    return;
                }
                Rect rect = new Rect();
                UnitNumberPicker.this.paint.getTextBounds(UnitNumberPicker.this.unitText, 0, UnitNumberPicker.this.unitText.length(), rect);
                UnitNumberPicker.this.textX = (r1.getWidth() - rect.width()) - 20;
                UnitNumberPicker unitNumberPicker = UnitNumberPicker.this;
                unitNumberPicker.textY = (unitNumberPicker.getHeight() / 3) + rect.height() + 20;
            }
        });
    }

    public void setUnitText(int i) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-7829368);
        this.paint.setTextSize(i);
        this.paint.setAntiAlias(true);
        post(new Runnable() { // from class: com.dyaco.sole.custom_view.custom_wheel.UnitNumberPicker.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(UnitNumberPicker.this.unitText)) {
                    return;
                }
                Rect rect = new Rect();
                UnitNumberPicker.this.paint.getTextBounds(UnitNumberPicker.this.unitText, 0, UnitNumberPicker.this.unitText.length(), rect);
                UnitNumberPicker.this.textX = (r1.getWidth() - rect.width()) - 20;
                UnitNumberPicker unitNumberPicker = UnitNumberPicker.this;
                unitNumberPicker.textY = (unitNumberPicker.getHeight() / 3) + rect.height() + 20;
            }
        });
    }

    @Override // com.dyaco.sole.custom_view.custom_wheel.NumberPicker, android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.unitText)) {
            return;
        }
        canvas.drawText(this.unitText, this.textX, this.textY, this.paint);
    }
}
