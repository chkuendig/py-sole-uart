package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.displayDashboard.DisplayItemView;

/* loaded from: classes5.dex */
public abstract class CustomDashboardChartBinding extends ViewDataBinding {
    public final DisplayItemView displayItemView;
    public final LineChart lineChart;
    public final ConstraintLayout lineChartEmptyText;
    public final TextView maxLabel;
    public final TextView minLabel;

    protected CustomDashboardChartBinding(Object _bindingComponent, View _root, int _localFieldCount, DisplayItemView displayItemView, LineChart lineChart, ConstraintLayout lineChartEmptyText, TextView maxLabel, TextView minLabel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.displayItemView = displayItemView;
        this.lineChart = lineChart;
        this.lineChartEmptyText = lineChartEmptyText;
        this.maxLabel = maxLabel;
        this.minLabel = minLabel;
    }

    public static CustomDashboardChartBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDashboardChartBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomDashboardChartBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_dashboard_chart, root, attachToRoot, component);
    }

    public static CustomDashboardChartBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDashboardChartBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomDashboardChartBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_dashboard_chart, null, false, component);
    }

    public static CustomDashboardChartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDashboardChartBinding bind(View view, Object component) {
        return (CustomDashboardChartBinding) bind(component, view, R.layout.custom_dashboard_chart);
    }
}
