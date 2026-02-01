package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class BottomSheetGoalsDetailBinding extends ViewDataBinding {
    public final LinearLayout bottomSheetLayout;
    public final AppCompatImageView close;
    public final AppCompatImageView deleteButton;
    public final AppCompatImageView editButton;
    public final PieChart pieChart;
    public final TextView tvCurrentUnit;
    public final TextView tvCurrentValue;
    public final TextView tvGoalUnit;
    public final TextView tvGoalValue;
    public final TextView tvLeftUnit;
    public final TextView tvLeftValue;
    public final TextView tvStatusPercentUnit;
    public final TextView tvStatusRateValue;
    public final TextView tvStreakUnit;
    public final TextView tvStreakValue;
    public final TextView tvSubTitle;
    public final TextView tvTitle;
    public final TextView tvToGainUnit;
    public final TextView tvToGainValue;

    protected BottomSheetGoalsDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout bottomSheetLayout, AppCompatImageView close, AppCompatImageView deleteButton, AppCompatImageView editButton, PieChart pieChart, TextView tvCurrentUnit, TextView tvCurrentValue, TextView tvGoalUnit, TextView tvGoalValue, TextView tvLeftUnit, TextView tvLeftValue, TextView tvStatusPercentUnit, TextView tvStatusRateValue, TextView tvStreakUnit, TextView tvStreakValue, TextView tvSubTitle, TextView tvTitle, TextView tvToGainUnit, TextView tvToGainValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bottomSheetLayout = bottomSheetLayout;
        this.close = close;
        this.deleteButton = deleteButton;
        this.editButton = editButton;
        this.pieChart = pieChart;
        this.tvCurrentUnit = tvCurrentUnit;
        this.tvCurrentValue = tvCurrentValue;
        this.tvGoalUnit = tvGoalUnit;
        this.tvGoalValue = tvGoalValue;
        this.tvLeftUnit = tvLeftUnit;
        this.tvLeftValue = tvLeftValue;
        this.tvStatusPercentUnit = tvStatusPercentUnit;
        this.tvStatusRateValue = tvStatusRateValue;
        this.tvStreakUnit = tvStreakUnit;
        this.tvStreakValue = tvStreakValue;
        this.tvSubTitle = tvSubTitle;
        this.tvTitle = tvTitle;
        this.tvToGainUnit = tvToGainUnit;
        this.tvToGainValue = tvToGainValue;
    }

    public static BottomSheetGoalsDetailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetGoalsDetailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BottomSheetGoalsDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_goals_detail, root, attachToRoot, component);
    }

    public static BottomSheetGoalsDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetGoalsDetailBinding inflate(LayoutInflater inflater, Object component) {
        return (BottomSheetGoalsDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_goals_detail, null, false, component);
    }

    public static BottomSheetGoalsDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetGoalsDetailBinding bind(View view, Object component) {
        return (BottomSheetGoalsDetailBinding) bind(component, view, R.layout.bottom_sheet_goals_detail);
    }
}
