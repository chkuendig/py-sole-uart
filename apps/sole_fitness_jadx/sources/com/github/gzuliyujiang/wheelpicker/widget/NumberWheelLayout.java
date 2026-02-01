package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.OnNumberSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NumberWheelLayout extends OptionWheelLayout {
    private OnNumberSelectedListener onNumberSelectedListener;

    public NumberWheelLayout(Context context) {
        super(context);
    }

    public NumberWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NumberWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int[] provideStyleableRes() {
        return R.styleable.NumberWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.NumberWheelLayout_wheel_itemTextSize, (int) (context.getResources().getDisplayMetrics().scaledDensity * 15.0f)));
        setVisibleItemCount(typedArray.getInt(R.styleable.NumberWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArray.getString(R.styleable.NumberWheelLayout_wheel_maxWidthText));
        setSelectedTextColor(typedArray.getColor(R.styleable.NumberWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        setTextColor(typedArray.getColor(R.styleable.NumberWheelLayout_wheel_itemTextColor, -7829368));
        setItemSpace(typedArray.getDimensionPixelSize(R.styleable.NumberWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArray.getColor(R.styleable.NumberWheelLayout_wheel_indicatorColor, -3552823));
        setIndicatorSize(typedArray.getDimensionPixelSize(R.styleable.NumberWheelLayout_wheel_indicatorSize, r0));
        setCurvedIndicatorSpace(typedArray.getDimensionPixelSize(R.styleable.NumberWheelLayout_wheel_curvedIndicatorSpace, (int) (f * 1.0f)));
        setCurtainEnabled(typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArray.getColor(R.styleable.NumberWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainRadius(typedArray.getDimension(R.styleable.NumberWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArray.getInteger(R.styleable.NumberWheelLayout_wheel_curvedMaxAngle, 90));
        setTextAlign(typedArray.getInt(R.styleable.NumberWheelLayout_wheel_itemTextAlign, 0));
        getLabelView().setText(typedArray.getString(R.styleable.NumberWheelLayout_wheel_label));
        float f2 = typedArray.getFloat(R.styleable.NumberWheelLayout_wheel_minNumber, 0.0f);
        float f3 = typedArray.getFloat(R.styleable.NumberWheelLayout_wheel_maxNumber, 10.0f);
        float f4 = typedArray.getFloat(R.styleable.NumberWheelLayout_wheel_stepNumber, 1.0f);
        if (typedArray.getBoolean(R.styleable.NumberWheelLayout_wheel_isDecimal, false)) {
            setRange(f2, f3, f4);
        } else {
            setRange((int) f2, (int) f3, (int) f4);
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, com.github.gzuliyujiang.wheelview.contract.OnWheelChangedListener
    public void onWheelSelected(WheelView wheelView, int i) {
        if (this.onNumberSelectedListener != null) {
            this.onNumberSelectedListener.onNumberSelected(i, (Number) getWheelView().getItem(i));
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout
    @Deprecated
    public void setData(List<?> list) {
        throw new UnsupportedOperationException("Use setRange instead");
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout
    @Deprecated
    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        throw new UnsupportedOperationException("Use setOnNumberSelectedListener instead");
    }

    public void setOnNumberSelectedListener(OnNumberSelectedListener onNumberSelectedListener) {
        this.onNumberSelectedListener = onNumberSelectedListener;
    }

    public void setRange(int i, int i2, int i3) {
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        ArrayList arrayList = new ArrayList((iMax - iMin) / i3);
        while (iMin <= iMax) {
            arrayList.add(Integer.valueOf(iMin));
            iMin += i3;
        }
        super.setData(arrayList);
    }

    public void setRange(float f, float f2, float f3) {
        float fMin = Math.min(f, f2);
        float fMax = Math.max(f, f2);
        ArrayList arrayList = new ArrayList((int) ((fMax - fMin) / f3));
        while (fMin <= fMax) {
            arrayList.add(Float.valueOf(fMin));
            fMin += f3;
        }
        super.setData(arrayList);
    }
}
