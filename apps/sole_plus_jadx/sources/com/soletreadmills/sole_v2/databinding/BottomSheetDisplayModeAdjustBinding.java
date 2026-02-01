package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class BottomSheetDisplayModeAdjustBinding extends ViewDataBinding {
    public final LinearLayout llWrap;
    public final TextView number1;
    public final TextView number10;
    public final TextView number12;
    public final TextView number14;
    public final TextView number16;
    public final TextView number18;
    public final TextView number2;
    public final TextView number20;
    public final TextView number3;
    public final TextView number4;
    public final TextView number6;
    public final TextView number8;
    public final TextView tvDone;
    public final LinearLayout tvMinusBtn;
    public final LinearLayout tvPlusBtn;
    public final TextView tvTitle;
    public final TextView tvUnit;
    public final TextView tvValue;

    protected BottomSheetDisplayModeAdjustBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llWrap, TextView number1, TextView number10, TextView number12, TextView number14, TextView number16, TextView number18, TextView number2, TextView number20, TextView number3, TextView number4, TextView number6, TextView number8, TextView tvDone, LinearLayout tvMinusBtn, LinearLayout tvPlusBtn, TextView tvTitle, TextView tvUnit, TextView tvValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llWrap = llWrap;
        this.number1 = number1;
        this.number10 = number10;
        this.number12 = number12;
        this.number14 = number14;
        this.number16 = number16;
        this.number18 = number18;
        this.number2 = number2;
        this.number20 = number20;
        this.number3 = number3;
        this.number4 = number4;
        this.number6 = number6;
        this.number8 = number8;
        this.tvDone = tvDone;
        this.tvMinusBtn = tvMinusBtn;
        this.tvPlusBtn = tvPlusBtn;
        this.tvTitle = tvTitle;
        this.tvUnit = tvUnit;
        this.tvValue = tvValue;
    }

    public static BottomSheetDisplayModeAdjustBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetDisplayModeAdjustBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BottomSheetDisplayModeAdjustBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_display_mode_adjust, root, attachToRoot, component);
    }

    public static BottomSheetDisplayModeAdjustBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetDisplayModeAdjustBinding inflate(LayoutInflater inflater, Object component) {
        return (BottomSheetDisplayModeAdjustBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_display_mode_adjust, null, false, component);
    }

    public static BottomSheetDisplayModeAdjustBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetDisplayModeAdjustBinding bind(View view, Object component) {
        return (BottomSheetDisplayModeAdjustBinding) bind(component, view, R.layout.bottom_sheet_display_mode_adjust);
    }
}
