package com.github.gzuliyujiang.wheelview.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NumberWheelView extends WheelView {
    public NumberWheelView(Context context) {
        super(context);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.github.gzuliyujiang.wheelview.widget.WheelView
    protected List<?> generatePreviewData() {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @Override // com.github.gzuliyujiang.wheelview.widget.WheelView
    @Deprecated
    public void setData(List<?> list) {
        if (isInEditMode()) {
            super.setData(generatePreviewData());
            return;
        }
        throw new UnsupportedOperationException("Use setRange instead");
    }

    public void setRange(int i, int i2, int i3) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        ArrayList arrayList = new ArrayList((iMax - iMin) / i3);
        while (iMin <= iMax) {
            arrayList.add(Integer.valueOf(iMin));
            iMin += i3;
        }
        super.setData(arrayList);
    }

    public void setRange(float f, float f2, float f3) {
        float fMin = Math.min(f, f2);
        float fMax = Math.max(f, f2);
        ArrayList arrayList = new ArrayList((int) ((fMax - fMin) / f3));
        while (fMin <= fMax) {
            arrayList.add(Float.valueOf(fMin));
            fMin += f3;
        }
        super.setData(arrayList);
    }
}
