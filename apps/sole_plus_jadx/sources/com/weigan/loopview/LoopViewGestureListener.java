package com.weigan.loopview;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes4.dex */
final class LoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    final LoopView loopView;

    LoopViewGestureListener(LoopView loopview) {
        this.loopView = loopview;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.loopView.scrollBy(velocityY);
        return true;
    }
}
