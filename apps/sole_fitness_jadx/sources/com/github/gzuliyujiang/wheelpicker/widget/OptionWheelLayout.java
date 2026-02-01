package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class OptionWheelLayout extends BaseWheelLayout {
    private TextView labelView;
    private OnOptionSelectedListener onOptionSelectedListener;
    private WheelView wheelView;

    public OptionWheelLayout(Context context) {
        super(context);
    }

    public OptionWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OptionWheelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public OptionWheelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int provideLayoutRes() {
        return R.layout.wheel_picker_option;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int[] provideStyleableRes() {
        return R.styleable.OptionWheelLayout;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List<WheelView> provideWheelViews() {
        return Collections.singletonList(this.wheelView);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onInit(Context context) {
        this.wheelView = (WheelView) findViewById(R.id.wheel_picker_option_wheel);
        this.labelView = (TextView) findViewById(R.id.wheel_picker_option_label);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void onAttributeSet(Context context, TypedArray typedArray) {
        float f = context.getResources().getDisplayMetrics().density;
        setTextSize(typedArray.getDimensionPixelSize(R.styleable.OptionWheelLayout_wheel_itemTextSize, (int) (context.getResources().getDisplayMetrics().scaledDensity * 15.0f)));
        setVisibleItemCount(typedArray.getInt(R.styleable.OptionWheelLayout_wheel_visibleItemCount, 5));
        setSameWidthEnabled(typedArray.getBoolean(R.styleable.OptionWheelLayout_wheel_sameWidthEnabled, false));
        setMaxWidthText(typedArray.getString(R.styleable.OptionWheelLayout_wheel_maxWidthText));
        setSelectedTextColor(typedArray.getColor(R.styleable.OptionWheelLayout_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK));
        setTextColor(typedArray.getColor(R.styleable.OptionWheelLayout_wheel_itemTextColor, -7829368));
        setItemSpace(typedArray.getDimensionPixelSize(R.styleable.OptionWheelLayout_wheel_itemSpace, (int) (20.0f * f)));
        setCyclicEnabled(typedArray.getBoolean(R.styleable.OptionWheelLayout_wheel_cyclicEnabled, false));
        setIndicatorEnabled(typedArray.getBoolean(R.styleable.OptionWheelLayout_wheel_indicatorEnabled, false));
        setIndicatorColor(typedArray.getColor(R.styleable.OptionWheelLayout_wheel_indicatorColor, -3552823));
        float f2 = f * 1.0f;
        setIndicatorSize(typedArray.getDimension(R.styleable.OptionWheelLayout_wheel_indicatorSize, f2));
        setCurvedIndicatorSpace(typedArray.getDimensionPixelSize(R.styleable.OptionWheelLayout_wheel_curvedIndicatorSpace, (int) f2));
        setCurtainEnabled(typedArray.getBoolean(R.styleable.OptionWheelLayout_wheel_curtainEnabled, false));
        setCurtainColor(typedArray.getColor(R.styleable.OptionWheelLayout_wheel_curtainColor, -1996488705));
        setCurtainRadius(typedArray.getDimension(R.styleable.OptionWheelLayout_wheel_curtainRadius, 0.0f));
        setAtmosphericEnabled(typedArray.getBoolean(R.styleable.OptionWheelLayout_wheel_atmosphericEnabled, false));
        setCurvedEnabled(typedArray.getBoolean(R.styleable.OptionWheelLayout_wheel_curvedEnabled, false));
        setCurvedMaxAngle(typedArray.getInteger(R.styleable.OptionWheelLayout_wheel_curvedMaxAngle, 90));
        setTextAlign(typedArray.getInt(R.styleable.OptionWheelLayout_wheel_itemTextAlign, 0));
        this.labelView.setText(typedArray.getString(R.styleable.OptionWheelLayout_wheel_label));
    }

    public void onWheelSelected(WheelView wheelView, int i) {
        OnOptionSelectedListener onOptionSelectedListener = this.onOptionSelectedListener;
        if (onOptionSelectedListener != null) {
            onOptionSelectedListener.onOptionSelected(i, this.wheelView.getItem(i));
        }
    }

    public void setData(List<?> list) {
        this.wheelView.setData(list);
    }

    public void setDefaultValue(Object obj) {
        this.wheelView.setDefaultValue(obj);
    }

    public void setDefaultPosition(int i) {
        this.wheelView.setDefaultPosition(i);
    }

    public void setOnOptionSelectedListener(OnOptionSelectedListener onOptionSelectedListener) {
        this.onOptionSelectedListener = onOptionSelectedListener;
    }

    public final WheelView getWheelView() {
        return this.wheelView;
    }

    public final TextView getLabelView() {
        return this.labelView;
    }
}
