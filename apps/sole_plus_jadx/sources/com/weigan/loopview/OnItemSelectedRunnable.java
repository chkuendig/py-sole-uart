package com.weigan.loopview;

/* loaded from: classes4.dex */
final class OnItemSelectedRunnable implements Runnable {
    final LoopView loopView;

    OnItemSelectedRunnable(LoopView loopview) {
        this.loopView = loopview;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.loopView.onItemSelectedListener.onItemSelected(this.loopView.getSelectedItem());
    }
}
