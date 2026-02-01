package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseWheelLayout extends LinearLayout implements OnWheelChangedListener {
    private AttributeSet attrs;
    private final List<WheelView> wheelViews;

    protected void onAttributeSet(Context context, TypedArray typedArray) {
    }

    protected void onInit(Context context) {
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelLoopFinished(WheelView wheelView) {
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrollStateChanged(WheelView wheelView, int i) {
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelScrolled(WheelView wheelView, int i) {
    }

    protected abstract int provideLayoutRes();

    protected abstract int[] provideStyleableRes();

    protected abstract List<WheelView> provideWheelViews();

    public BaseWheelLayout(Context context) {
        super(context);
        this.wheelViews = new ArrayList();
        init(context, null);
        onAttributeSet(context, context.obtainStyledAttributes(null, provideStyleableRes(), R.attr.WheelStyle, R.style.WheelDefault));
    }

    public BaseWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wheelViews = new ArrayList();
        init(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, provideStyleableRes(), R.attr.WheelStyle, R.style.WheelDefault);
        onAttributeSet(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public BaseWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wheelViews = new ArrayList();
        init(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, provideStyleableRes(), i, R.style.WheelDefault);
        onAttributeSet(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public BaseWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.wheelViews = new ArrayList();
        init(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, provideStyleableRes(), i, i2);
        onAttributeSet(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.attrs = attributeSet;
        setOrientation(1);
        inflate(context, provideLayoutRes(), this);
        onInit(context);
        this.wheelViews.addAll(provideWheelViews());
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setOnWheelChangedListener(this);
        }
    }

    public void setStyle(int i) {
        if (this.attrs == null) {
            throw new RuntimeException("Please use " + getClass().getSimpleName() + " in xml");
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(this.attrs, provideStyleableRes(), R.attr.WheelStyle, i);
        onAttributeSet(getContext(), typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
    }

    public void setCurtainEnabled(boolean z) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainEnabled(z);
        }
    }

    public void setCurtainColor(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainColor(i);
        }
    }

    public void setCurtainCorner(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainCorner(i);
        }
    }

    public void setCurtainRadius(float f) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurtainRadius(f);
        }
    }

    public void setAtmosphericEnabled(boolean z) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setAtmosphericEnabled(z);
        }
    }

    public void setCurvedEnabled(boolean z) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurvedEnabled(z);
        }
    }

    public void setCurvedMaxAngle(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurvedMaxAngle(i);
        }
    }

    public void setCurvedIndicatorSpace(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCurvedIndicatorSpace(i);
        }
    }

    public void setItemSpace(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setItemSpace(i);
        }
    }

    public void setCyclicEnabled(boolean z) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setCyclicEnabled(z);
        }
    }

    public void setIndicatorEnabled(boolean z) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setIndicatorEnabled(z);
        }
    }

    public void setIndicatorSize(float f) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setIndicatorSize(f);
        }
    }

    public void setIndicatorColor(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setIndicatorColor(i);
        }
    }

    public void setTextSize(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setTextSize(i);
        }
    }

    public void setSameWidthEnabled(boolean z) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setSameWidthEnabled(z);
        }
    }

    public void setDefaultItemPosition(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setDefaultPosition(i);
        }
    }

    public void setMaxWidthText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setMaxWidthText(str);
        }
    }

    public void setSelectedTextColor(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setSelectedTextColor(i);
        }
    }

    public void setTextColor(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setTextColor(i);
        }
    }

    public void setVisibleItemCount(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setVisibleItemCount(i);
        }
    }

    public void setTextAlign(int i) {
        Iterator<WheelView> it = this.wheelViews.iterator();
        while (it.hasNext()) {
            it.next().setTextAlign(i);
        }
    }
}
