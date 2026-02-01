package com.weigan.loopview;

/* loaded from: classes4.dex */
public interface OnItemScrollListener {
    void onItemScrollStateChanged(LoopView loopView, int currentPassItem, int oldScrollState, int scrollState, int totalScrollY);

    void onItemScrolling(LoopView loopView, int currentPassItem, int scrollState, int totalScrollY);
}
