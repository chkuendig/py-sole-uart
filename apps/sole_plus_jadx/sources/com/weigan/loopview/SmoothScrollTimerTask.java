package com.weigan.loopview;

/* loaded from: classes4.dex */
final class SmoothScrollTimerTask implements Runnable {
    final LoopView loopView;
    int offset;
    int realTotalOffset = Integer.MAX_VALUE;
    int realOffset = 0;

    SmoothScrollTimerTask(LoopView loopview, int offset) {
        this.loopView = loopview;
        this.offset = offset;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i = this.realTotalOffset;
        int i2 = (int) (i * 0.1f);
        this.realOffset = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(i) <= 0) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(3000);
        } else {
            this.loopView.totalScrollY += this.realOffset;
            this.loopView.handler.sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }
}
