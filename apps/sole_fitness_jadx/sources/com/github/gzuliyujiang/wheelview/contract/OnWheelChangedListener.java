package com.github.gzuliyujiang.wheelview.contract;

import com.github.gzuliyujiang.wheelview.widget.WheelView;

/* loaded from: classes.dex */
public interface OnWheelChangedListener {
    void onWheelLoopFinished(WheelView wheelView);

    void onWheelScrollStateChanged(WheelView wheelView, int i);

    void onWheelScrolled(WheelView wheelView, int i);

    void onWheelSelected(WheelView wheelView, int i);
}
