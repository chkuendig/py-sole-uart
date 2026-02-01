package com.dyaco.sole.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.dyaco.sole.custom.Global;
import com.soletreadmills.sole.R;

/* loaded from: classes.dex */
public class LinesGridView extends GridView {
    public LinesGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public LinesGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinesGridView(Context context) {
        super(context);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int width = getWidth() / childAt.getWidth();
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStrokeWidth(Global.dpToPixel(0.5f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getContext().getResources().getColor(R.color.light_gray));
        int i = 0;
        while (i < childCount) {
            View childAt2 = getChildAt(i);
            if (i < width) {
                canvas.drawLine(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getTop(), paint);
            }
            i++;
            if (i % width == 0) {
                canvas.drawLine(childAt2.getLeft(), childAt2.getBottom(), childAt2.getRight(), childAt2.getBottom(), paint);
            } else if (i <= childCount - (childCount % width)) {
                canvas.drawLine(childAt2.getLeft(), childAt2.getBottom(), childAt2.getRight(), childAt2.getBottom(), paint);
            }
        }
        int i2 = childCount % width;
        if (i2 != 0) {
            for (int i3 = 0; i3 < width - i2; i3++) {
                View childAt3 = getChildAt(childCount - 1);
                canvas.drawLine(childAt3.getRight() + (childAt3.getWidth() * i3), childAt3.getTop(), childAt3.getRight() + (childAt3.getWidth() * i3), childAt3.getBottom(), paint);
            }
        }
    }
}
