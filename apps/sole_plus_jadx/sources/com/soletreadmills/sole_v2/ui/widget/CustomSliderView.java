package com.soletreadmills.sole_v2.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

/* compiled from: CustomSliderView.kt */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\r*\u0001.\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\"H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u000e\u00106\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u00107\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u00108\u001a\u00020\"H\u0002J\f\u00109\u001a\u00020\u000b*\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R$\u00100\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019¨\u0006:"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/widget/CustomSliderView;", "Landroid/widget/FrameLayout;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "container", "drawingView", "Lcom/soletreadmills/sole_v2/ui/widget/TickDrawingView;", "gap", "", "handler", "Landroid/os/Handler;", "indicator", "Landroid/view/View;", "isTouching", "", "lastScrollX", "", "value", "longTickSpacing", "getLongTickSpacing", "()F", "setLongTickSpacing", "(F)V", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "onValueChanged", "Lkotlin/Function1;", "", "getOnValueChanged", "()Lkotlin/jvm/functions/Function1;", "setOnValueChanged", "(Lkotlin/jvm/functions/Function1;)V", SdkConstants.ATTR_PADDING, "scaleLongHeight", "scaleShortHeight", "scaleWidth", "scrollView", "Landroid/widget/HorizontalScrollView;", "snapRunnable", "com/soletreadmills/sole_v2/ui/widget/CustomSliderView$snapRunnable$1", "Lcom/soletreadmills/sole_v2/ui/widget/CustomSliderView$snapRunnable$1;", "step", "getStep", "setStep", "calculateValue", "performSnapToNearestValue", "roundToNearestStep", "setCurrentValue", "snapToValue", "updateConfig", SdkConstants.UNIT_DP, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CustomSliderView extends FrameLayout {
    public static final int $stable = 8;
    private final FrameLayout container;
    private final TickDrawingView drawingView;
    private final float gap;
    private final Handler handler;
    private final View indicator;
    private boolean isTouching;
    private int lastScrollX;
    private float longTickSpacing;
    private float maxValue;
    private float minValue;
    private Function1<? super Float, Unit> onValueChanged;
    private final float padding;
    private final float scaleLongHeight;
    private final float scaleShortHeight;
    private final float scaleWidth;
    private final HorizontalScrollView scrollView;
    private final CustomSliderView$snapRunnable$1 snapRunnable;
    private float step;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomSliderView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomSliderView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.soletreadmills.sole_v2.ui.widget.CustomSliderView$snapRunnable$1] */
    public CustomSliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.scrollView = horizontalScrollView;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.container = frameLayout;
        TickDrawingView tickDrawingView = new TickDrawingView(context);
        this.drawingView = tickDrawingView;
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
        view.setLayoutParams(new FrameLayout.LayoutParams((int) dp(2.0f), (int) dp(28.0f)));
        this.indicator = view;
        this.gap = dp(16.0f);
        this.padding = dp(32.0f);
        this.scaleWidth = dp(2.0f);
        this.scaleLongHeight = dp(28.0f);
        this.scaleShortHeight = dp(15.0f);
        this.maxValue = 10.0f;
        this.step = 0.1f;
        this.longTickSpacing = 0.5f;
        this.handler = new Handler(Looper.getMainLooper());
        this.snapRunnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.widget.CustomSliderView$snapRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                int scrollX = this.this$0.scrollView.getScrollX();
                if (scrollX != this.this$0.lastScrollX || this.this$0.isTouching) {
                    this.this$0.lastScrollX = scrollX;
                    this.this$0.handler.postDelayed(this, 50L);
                } else {
                    this.this$0.performSnapToNearestValue();
                }
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomSliderView, 0, 0);
        try {
            setMinValue(typedArrayObtainStyledAttributes.getFloat(R.styleable.CustomSliderView_minValue, 0.0f));
            setMaxValue(typedArrayObtainStyledAttributes.getFloat(R.styleable.CustomSliderView_maxValue, 10.0f));
            setStep(typedArrayObtainStyledAttributes.getFloat(R.styleable.CustomSliderView_step, 0.1f));
            setLongTickSpacing(typedArrayObtainStyledAttributes.getFloat(R.styleable.CustomSliderView_longTickSpacing, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
            updateConfig();
            frameLayout.addView(tickDrawingView, new FrameLayout.LayoutParams(-2, -1));
            horizontalScrollView.addView(frameLayout);
            addView(horizontalScrollView);
            addView(view);
            post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.widget.CustomSliderView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CustomSliderView._init_$lambda$4(this.f$0);
                }
            });
            horizontalScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.soletreadmills.sole_v2.ui.widget.CustomSliderView$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    CustomSliderView._init_$lambda$5(this.f$0);
                }
            });
            horizontalScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.soletreadmills.sole_v2.ui.widget.CustomSliderView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return CustomSliderView._init_$lambda$6(this.f$0, view2, motionEvent);
                }
            });
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final float getMinValue() {
        return this.minValue;
    }

    public final void setMinValue(float f) {
        this.minValue = f;
        updateConfig();
    }

    public final float getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(float f) {
        this.maxValue = f;
        updateConfig();
    }

    public final float getStep() {
        return this.step;
    }

    public final void setStep(float f) {
        this.step = RangesKt.coerceAtLeast(f, 1.0E-4f);
        updateConfig();
    }

    public final float getLongTickSpacing() {
        return this.longTickSpacing;
    }

    public final void setLongTickSpacing(float f) {
        this.longTickSpacing = f;
        updateConfig();
    }

    public final Function1<Float, Unit> getOnValueChanged() {
        return this.onValueChanged;
    }

    public final void setOnValueChanged(Function1<? super Float, Unit> function1) {
        this.onValueChanged = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(CustomSliderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int height = (int) ((this$0.getHeight() - this$0.scaleLongHeight) / 2.0f);
        ViewGroup.LayoutParams layoutParams = this$0.indicator.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = height;
        layoutParams2.leftMargin = (int) this$0.padding;
        this$0.indicator.setLayoutParams(layoutParams2);
        this$0.snapToValue(this$0.minValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(CustomSliderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.calculateValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$6(CustomSliderView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.isTouching = true;
            this$0.handler.removeCallbacks(this$0.snapRunnable);
        } else if (action == 1 || action == 3) {
            this$0.isTouching = false;
            this$0.handler.postDelayed(this$0.snapRunnable, 100L);
        }
        return false;
    }

    private final void calculateValue() {
        float scrollX = this.scrollView.getScrollX();
        float f = this.padding;
        float fRoundToNearestStep = roundToNearestStep(this.minValue + ((((scrollX + f) - f) / this.gap) * this.step));
        Function1<? super Float, Unit> function1 = this.onValueChanged;
        if (function1 != null) {
            function1.invoke(Float.valueOf(fRoundToNearestStep));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performSnapToNearestValue() {
        float scrollX = this.scrollView.getScrollX();
        float f = this.padding;
        float f2 = this.minValue + ((((scrollX + f) - f) / this.gap) * this.step);
        float fRoundToNearestStep = roundToNearestStep(f2);
        Timber.INSTANCE.d("rawValue: %s, rounded: %s, step: %s", Float.valueOf(f2), Float.valueOf(fRoundToNearestStep), Float.valueOf(this.step));
        snapToValue(fRoundToNearestStep);
    }

    private final float roundToNearestStep(float value) {
        if (this.step <= 0.0f) {
            return value;
        }
        float fRoundToInt = this.minValue + (MathKt.roundToInt((value - this.minValue) / r0) * this.step);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.6f", Arrays.copyOf(new Object[]{Float.valueOf(fRoundToInt)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return RangesKt.coerceIn(Float.parseFloat(str), this.minValue, this.maxValue);
    }

    public final void snapToValue(float value) {
        final float fCoerceIn = RangesKt.coerceIn(((RangesKt.coerceIn(value, this.minValue, this.maxValue) - this.minValue) / this.step) * this.gap, 0.0f, RangesKt.coerceAtLeast(this.container.getWidth() - this.scrollView.getWidth(), 0));
        this.scrollView.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.widget.CustomSliderView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CustomSliderView.snapToValue$lambda$7(this.f$0, fCoerceIn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void snapToValue$lambda$7(CustomSliderView this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scrollView.smoothScrollTo((int) f, 0);
    }

    public final void setCurrentValue(float value) {
        snapToValue(value);
    }

    private final void updateConfig() {
        this.drawingView.setConfig(this.minValue, this.maxValue, this.step, this.gap, this.scaleWidth, this.scaleLongHeight, this.scaleShortHeight, this.padding, this.longTickSpacing);
        invalidate();
    }

    private final float dp(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
