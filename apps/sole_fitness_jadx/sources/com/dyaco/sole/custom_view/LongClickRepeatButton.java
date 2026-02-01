package com.dyaco.sole.custom_view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class LongClickRepeatButton extends ImageButton {
    private MyHandler handler;
    private long intervalTime;

    public LongClickRepeatButton(Context context) {
        super(context);
        this.intervalTime = 200L;
        init();
    }

    public LongClickRepeatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.intervalTime = 200L;
        init();
    }

    public LongClickRepeatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.intervalTime = 200L;
        init();
    }

    private void init() {
        this.handler = new MyHandler(this);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dyaco.sole.custom_view.LongClickRepeatButton.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                new Thread(new LongClickThread()).start();
                return true;
            }
        });
    }

    private class LongClickThread implements Runnable {
        private int num;

        private LongClickThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (LongClickRepeatButton.this.isPressed()) {
                int i = this.num + 1;
                this.num = i;
                if (i % 5 == 0) {
                    LongClickRepeatButton.this.handler.sendEmptyMessage(1);
                }
                SystemClock.sleep(LongClickRepeatButton.this.intervalTime / 5);
            }
        }
    }

    private static class MyHandler extends Handler {
        private WeakReference<LongClickRepeatButton> ref;

        MyHandler(LongClickRepeatButton longClickRepeatButton) {
            this.ref = new WeakReference<>(longClickRepeatButton);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            LongClickRepeatButton longClickRepeatButton = this.ref.get();
            if (longClickRepeatButton != null) {
                longClickRepeatButton.performClick();
            }
        }
    }

    public void setIntervalTime(long j) {
        this.intervalTime = j;
    }
}
