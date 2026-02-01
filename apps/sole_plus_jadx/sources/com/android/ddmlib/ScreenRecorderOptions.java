package com.android.ddmlib;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ScreenRecorderOptions {
    public final int bitrateMbps;
    public final int height;
    public final boolean showTouches;
    public final long timeLimit;
    public final TimeUnit timeLimitUnits;
    public final int width;

    private ScreenRecorderOptions(Builder builder) {
        this.width = builder.mWidth;
        this.height = builder.mHeight;
        this.bitrateMbps = builder.mBitRate;
        this.timeLimit = builder.mTime;
        this.timeLimitUnits = builder.mTimeUnits;
        this.showTouches = builder.mShowTouches;
    }

    public static class Builder {
        private int mBitRate;
        private int mHeight;
        private boolean mShowTouches;
        private long mTime;
        private TimeUnit mTimeUnits;
        private int mWidth;

        public Builder setSize(int w, int h) {
            this.mWidth = w;
            this.mHeight = h;
            return this;
        }

        public Builder setBitRate(int bitRateMbps) {
            this.mBitRate = bitRateMbps;
            return this;
        }

        public Builder setTimeLimit(long time, TimeUnit units) {
            this.mTime = time;
            this.mTimeUnits = units;
            return this;
        }

        public Builder setShowTouches(boolean showTouches) {
            this.mShowTouches = showTouches;
            return this;
        }

        public ScreenRecorderOptions build() {
            return new ScreenRecorderOptions(this);
        }
    }
}
