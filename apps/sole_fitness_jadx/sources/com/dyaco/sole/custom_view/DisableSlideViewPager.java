package com.dyaco.sole.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class DisableSlideViewPager extends ViewPager {
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public DisableSlideViewPager(Context context) {
        super(context);
    }

    public DisableSlideViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
