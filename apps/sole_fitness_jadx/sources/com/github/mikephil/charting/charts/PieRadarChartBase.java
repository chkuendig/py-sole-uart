package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes.dex */
public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    protected float mMinOffset;
    private float mRawRotationAngle;
    protected boolean mRotateEnabled;
    private float mRotationAngle;

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
    }

    public abstract int getIndexForAngle(float f);

    public abstract float getRadius();

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    public PieRadarChartBase(Context context) {
        super(context);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.mData.getEntryCount();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mTouchEnabled && this.mChartTouchListener != null) {
            return this.mChartTouchListener.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mChartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) this.mChartTouchListener).computeScroll();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        calcMinMax();
        if (this.mLegend != null) {
            this.mLegendRenderer.computeLegend(this.mData);
        }
        calculateOffsets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007d, code lost:
    
        if (r2 != 2) goto L19;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void calculateOffsets() {
        float requiredBaseOffset;
        float requiredBaseOffset2;
        float requiredBaseOffset3;
        float fConvertDpToPixel;
        float f;
        float f2;
        float fMin;
        float requiredBaseOffset4 = 0.0f;
        if (this.mLegend == null || !this.mLegend.isEnabled() || this.mLegend.isDrawInsideEnabled()) {
            requiredBaseOffset = 0.0f;
            requiredBaseOffset2 = 0.0f;
            requiredBaseOffset3 = 0.0f;
        } else {
            float fMin2 = Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent());
            int i = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mLegend.getOrientation().ordinal()];
            if (i == 1) {
                if (this.mLegend.getHorizontalAlignment() != Legend.LegendHorizontalAlignment.LEFT && this.mLegend.getHorizontalAlignment() != Legend.LegendHorizontalAlignment.RIGHT) {
                    fConvertDpToPixel = 0.0f;
                } else if (this.mLegend.getVerticalAlignment() == Legend.LegendVerticalAlignment.CENTER) {
                    fConvertDpToPixel = fMin2 + Utils.convertDpToPixel(13.0f);
                } else {
                    fConvertDpToPixel = fMin2 + Utils.convertDpToPixel(8.0f);
                    float f3 = this.mLegend.mNeededHeight + this.mLegend.mTextHeightMax;
                    MPPointF center = getCenter();
                    float width = this.mLegend.getHorizontalAlignment() == Legend.LegendHorizontalAlignment.RIGHT ? (getWidth() - fConvertDpToPixel) + 15.0f : fConvertDpToPixel - 15.0f;
                    float f4 = f3 + 15.0f;
                    float fDistanceToCenter = distanceToCenter(width, f4);
                    MPPointF position = getPosition(center, getRadius(), getAngleForPoint(width, f4));
                    float fDistanceToCenter2 = distanceToCenter(position.x, position.y);
                    float fConvertDpToPixel2 = Utils.convertDpToPixel(5.0f);
                    if (f4 < center.y || getHeight() - fConvertDpToPixel <= getWidth()) {
                        fConvertDpToPixel = fDistanceToCenter < fDistanceToCenter2 ? fConvertDpToPixel2 + (fDistanceToCenter2 - fDistanceToCenter) : 0.0f;
                    }
                    MPPointF.recycleInstance(center);
                    MPPointF.recycleInstance(position);
                }
                int i2 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.getHorizontalAlignment().ordinal()];
                if (i2 == 1) {
                    f = 0.0f;
                    f2 = 0.0f;
                    requiredBaseOffset4 = fConvertDpToPixel;
                    fConvertDpToPixel = 0.0f;
                    requiredBaseOffset4 += getRequiredBaseOffset();
                    requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                    requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                    requiredBaseOffset2 = f + getRequiredBaseOffset();
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        int i3 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
                        if (i3 == 1) {
                            fMin = Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                            f2 = fMin;
                            fConvertDpToPixel = 0.0f;
                            f = 0.0f;
                            requiredBaseOffset4 += getRequiredBaseOffset();
                            requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                            requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                            requiredBaseOffset2 = f + getRequiredBaseOffset();
                        } else if (i3 == 2) {
                            fMin = Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                            f = fMin;
                            fConvertDpToPixel = 0.0f;
                            f2 = 0.0f;
                            requiredBaseOffset4 += getRequiredBaseOffset();
                            requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                            requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                            requiredBaseOffset2 = f + getRequiredBaseOffset();
                        }
                    }
                    fConvertDpToPixel = 0.0f;
                    f = 0.0f;
                    f2 = f;
                    requiredBaseOffset4 += getRequiredBaseOffset();
                    requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                    requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                    requiredBaseOffset2 = f + getRequiredBaseOffset();
                } else {
                    f = 0.0f;
                    f2 = f;
                    requiredBaseOffset4 += getRequiredBaseOffset();
                    requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                    requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                    requiredBaseOffset2 = f + getRequiredBaseOffset();
                }
            } else {
                if (i == 2 && (this.mLegend.getVerticalAlignment() == Legend.LegendVerticalAlignment.TOP || this.mLegend.getVerticalAlignment() == Legend.LegendVerticalAlignment.BOTTOM)) {
                    fMin = Math.min(this.mLegend.mNeededHeight + getRequiredLegendOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
                    int i4 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
                    if (i4 != 1) {
                    }
                    f2 = fMin;
                    fConvertDpToPixel = 0.0f;
                    f = 0.0f;
                    requiredBaseOffset4 += getRequiredBaseOffset();
                    requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                    requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                    requiredBaseOffset2 = f + getRequiredBaseOffset();
                }
                fConvertDpToPixel = 0.0f;
                f = 0.0f;
                f2 = f;
                requiredBaseOffset4 += getRequiredBaseOffset();
                requiredBaseOffset = fConvertDpToPixel + getRequiredBaseOffset();
                requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                requiredBaseOffset2 = f + getRequiredBaseOffset();
            }
        }
        float fConvertDpToPixel3 = Utils.convertDpToPixel(this.mMinOffset);
        if (this instanceof RadarChart) {
            XAxis xAxis = getXAxis();
            if (xAxis.isEnabled() && xAxis.isDrawLabelsEnabled()) {
                fConvertDpToPixel3 = Math.max(fConvertDpToPixel3, xAxis.mLabelRotatedWidth);
            }
        }
        float extraTopOffset = requiredBaseOffset3 + getExtraTopOffset();
        float extraRightOffset = requiredBaseOffset + getExtraRightOffset();
        float extraBottomOffset = requiredBaseOffset2 + getExtraBottomOffset();
        float fMax = Math.max(fConvertDpToPixel3, requiredBaseOffset4 + getExtraLeftOffset());
        float fMax2 = Math.max(fConvertDpToPixel3, extraTopOffset);
        float fMax3 = Math.max(fConvertDpToPixel3, extraRightOffset);
        float fMax4 = Math.max(fConvertDpToPixel3, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.mViewPortHandler.restrainViewPort(fMax, fMax2, fMax3, fMax4);
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "offsetLeft: " + fMax + ", offsetTop: " + fMax2 + ", offsetRight: " + fMax3 + ", offsetBottom: " + fMax4);
        }
    }

    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public float getAngleForPoint(float f, float f2) {
        MPPointF centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.x;
        double d2 = f2 - centerOffsets.y;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.x) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        if (f3 > 360.0f) {
            f3 -= 360.0f;
        }
        MPPointF.recycleInstance(centerOffsets);
        return f3;
    }

    public MPPointF getPosition(MPPointF mPPointF, float f, float f2) {
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f, f2, mPPointF2);
        return mPPointF2;
    }

    public void getPosition(MPPointF mPPointF, float f, float f2, MPPointF mPPointF2) {
        double d = f;
        double d2 = f2;
        mPPointF2.x = (float) (mPPointF.x + (Math.cos(Math.toRadians(d2)) * d));
        mPPointF2.y = (float) (mPPointF.y + (d * Math.sin(Math.toRadians(d2))));
    }

    public float distanceToCenter(float f, float f2) {
        float f3;
        float f4;
        MPPointF centerOffsets = getCenterOffsets();
        if (f > centerOffsets.x) {
            f3 = f - centerOffsets.x;
        } else {
            f3 = centerOffsets.x - f;
        }
        if (f2 > centerOffsets.y) {
            f4 = f2 - centerOffsets.y;
        } else {
            f4 = centerOffsets.y - f2;
        }
        float fSqrt = (float) Math.sqrt(Math.pow(f3, 2.0d) + Math.pow(f4, 2.0d));
        MPPointF.recycleInstance(centerOffsets);
        return fSqrt;
    }

    public void setRotationAngle(float f) {
        this.mRawRotationAngle = f;
        this.mRotationAngle = Utils.getNormalizedAngle(f);
    }

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public void setRotationEnabled(boolean z) {
        this.mRotateEnabled = z;
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    public float getDiameter() {
        RectF contentRect = this.mViewPortHandler.getContentRect();
        contentRect.left += getExtraLeftOffset();
        contentRect.top += getExtraTopOffset();
        contentRect.right -= getExtraRightOffset();
        contentRect.bottom -= getExtraBottomOffset();
        return Math.min(contentRect.width(), contentRect.height());
    }

    public void spin(int i, float f, float f2, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        setRotationAngle(f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f, f2);
        objectAnimatorOfFloat.setDuration(i);
        objectAnimatorOfFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.PieRadarChartBase.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PieRadarChartBase.this.postInvalidate();
            }
        });
        objectAnimatorOfFloat.start();
    }
}
