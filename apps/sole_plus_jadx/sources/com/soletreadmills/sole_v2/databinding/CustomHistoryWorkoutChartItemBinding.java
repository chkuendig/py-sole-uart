package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomHistoryWorkoutChartItemBinding extends ViewDataBinding {
    public final LinearLayout LLNotEnoughData;
    public final LinearLayout LLTop;
    public final LineChart lineChart;
    public final TextView maxLabel;
    public final TextView minLabel;
    public final TextView title;
    public final TextView tvDistance;
    public final TextView tvNotEnoughData;
    public final TextView tvTime;
    public final TextView unit;
    public final TextView value;

    protected CustomHistoryWorkoutChartItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLNotEnoughData, LinearLayout LLTop, LineChart lineChart, TextView maxLabel, TextView minLabel, TextView title, TextView tvDistance, TextView tvNotEnoughData, TextView tvTime, TextView unit, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLNotEnoughData = LLNotEnoughData;
        this.LLTop = LLTop;
        this.lineChart = lineChart;
        this.maxLabel = maxLabel;
        this.minLabel = minLabel;
        this.title = title;
        this.tvDistance = tvDistance;
        this.tvNotEnoughData = tvNotEnoughData;
        this.tvTime = tvTime;
        this.unit = unit;
        this.value = value;
    }

    public static CustomHistoryWorkoutChartItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomHistoryWorkoutChartItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomHistoryWorkoutChartItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_history_workout_chart_item, root, attachToRoot, component);
    }

    public static CustomHistoryWorkoutChartItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomHistoryWorkoutChartItemBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomHistoryWorkoutChartItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_history_workout_chart_item, null, false, component);
    }

    public static CustomHistoryWorkoutChartItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomHistoryWorkoutChartItemBinding bind(View view, Object component) {
        return (CustomHistoryWorkoutChartItemBinding) bind(component, view, R.layout.custom_history_workout_chart_item);
    }
}
