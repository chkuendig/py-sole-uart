package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class BottomSheetGoalsEditTargetBinding extends ViewDataBinding {
    public final LinearLayout clear;
    public final LinearLayout delete;
    public final ImageView imageView19;
    public final LinearLayout llWrap;
    public final TextView number0;
    public final TextView number1;
    public final TextView number2;
    public final TextView number3;
    public final TextView number4;
    public final TextView number5;
    public final TextView number6;
    public final TextView number7;
    public final TextView number8;
    public final TextView number9;
    public final TextView tvCancel;
    public final TextView tvDone;
    public final LinearLayout tvMinusBtn;
    public final ImageView tvMinusBtnImg;
    public final TextView tvPeriodAndUnit;
    public final LinearLayout tvPlusBtn;
    public final ImageView tvPlusBtnImg;
    public final TextView tvTitle;
    public final TextView tvValue;

    protected BottomSheetGoalsEditTargetBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout clear, LinearLayout delete, ImageView imageView19, LinearLayout llWrap, TextView number0, TextView number1, TextView number2, TextView number3, TextView number4, TextView number5, TextView number6, TextView number7, TextView number8, TextView number9, TextView tvCancel, TextView tvDone, LinearLayout tvMinusBtn, ImageView tvMinusBtnImg, TextView tvPeriodAndUnit, LinearLayout tvPlusBtn, ImageView tvPlusBtnImg, TextView tvTitle, TextView tvValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.clear = clear;
        this.delete = delete;
        this.imageView19 = imageView19;
        this.llWrap = llWrap;
        this.number0 = number0;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
        this.number7 = number7;
        this.number8 = number8;
        this.number9 = number9;
        this.tvCancel = tvCancel;
        this.tvDone = tvDone;
        this.tvMinusBtn = tvMinusBtn;
        this.tvMinusBtnImg = tvMinusBtnImg;
        this.tvPeriodAndUnit = tvPeriodAndUnit;
        this.tvPlusBtn = tvPlusBtn;
        this.tvPlusBtnImg = tvPlusBtnImg;
        this.tvTitle = tvTitle;
        this.tvValue = tvValue;
    }

    public static BottomSheetGoalsEditTargetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetGoalsEditTargetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BottomSheetGoalsEditTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_goals_edit_target, root, attachToRoot, component);
    }

    public static BottomSheetGoalsEditTargetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetGoalsEditTargetBinding inflate(LayoutInflater inflater, Object component) {
        return (BottomSheetGoalsEditTargetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_goals_edit_target, null, false, component);
    }

    public static BottomSheetGoalsEditTargetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetGoalsEditTargetBinding bind(View view, Object component) {
        return (BottomSheetGoalsEditTargetBinding) bind(component, view, R.layout.bottom_sheet_goals_edit_target);
    }
}
