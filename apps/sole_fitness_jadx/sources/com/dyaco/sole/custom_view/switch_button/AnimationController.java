package com.dyaco.sole.custom_view.switch_button;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
class AnimationController {
    private static int ANI_WHAT = 256;
    private static int DEFAULT_FRAME_DURATION = 16;
    private static int DEFAULT_VELOCITY = 7;
    private int mFrame;
    private int mFrom;
    private OnAnimateListener mOnAnimateListener;
    private int mTo;
    private boolean isAnimating = false;
    private int mVelocity = DEFAULT_VELOCITY;
    private AnimationHandler mHandler = new AnimationHandler();

    interface OnAnimateListener {
        boolean continueAnimating();

        void onAnimateComplete();

        void onAnimationStart();

        void onFrameUpdate(int i);
    }

    private AnimationController() {
    }

    static AnimationController getDefault() {
        return new AnimationController();
    }

    AnimationController init(OnAnimateListener onAnimateListener) {
        if (onAnimateListener == null) {
            throw new IllegalArgumentException("onAnimateListener can not be null");
        }
        this.mOnAnimateListener = onAnimateListener;
        return this;
    }

    private static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != AnimationController.ANI_WHAT || message.obj == null) {
                return;
            }
            ((Runnable) message.obj).run();
        }
    }

    void startAnimation(int i, int i2) {
        this.isAnimating = true;
        this.mFrom = i;
        this.mTo = i2;
        int i3 = this.mVelocity;
        this.mFrame = i3;
        if (i2 > i) {
            this.mFrame = Math.abs(i3);
        } else if (i2 < i) {
            this.mFrame = -Math.abs(i3);
        } else {
            this.isAnimating = false;
            this.mOnAnimateListener.onAnimateComplete();
            return;
        }
        this.mOnAnimateListener.onAnimationStart();
        new RequireNextFrame().run();
    }

    void stopAnimation() {
        this.isAnimating = false;
    }

    public void setVelocity(int i) {
        if (i <= 0) {
            this.mVelocity = DEFAULT_VELOCITY;
        } else {
            this.mVelocity = i;
        }
    }

    class RequireNextFrame implements Runnable {
        private void calcNextFrame() {
        }

        RequireNextFrame() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AnimationController.this.isAnimating) {
                calcNextFrame();
                AnimationController.this.mOnAnimateListener.onFrameUpdate(AnimationController.this.mFrame);
                if (AnimationController.this.mOnAnimateListener.continueAnimating()) {
                    requireNextFrame();
                } else {
                    AnimationController.this.stopAnimation();
                    AnimationController.this.mOnAnimateListener.onAnimateComplete();
                }
            }
        }

        private void requireNextFrame() {
            Message messageObtainMessage = AnimationController.this.mHandler.obtainMessage();
            messageObtainMessage.what = AnimationController.ANI_WHAT;
            messageObtainMessage.obj = this;
            AnimationController.this.mHandler.sendMessageDelayed(messageObtainMessage, AnimationController.DEFAULT_FRAME_DURATION);
        }
    }
}
