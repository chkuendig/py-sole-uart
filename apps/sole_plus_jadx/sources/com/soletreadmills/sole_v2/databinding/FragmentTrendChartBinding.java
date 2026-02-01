package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentTrendChartBinding extends ViewDataBinding {
    public final TextView avgUnit;
    public final TextView avgValue;
    public final ImageView back;
    public final BarChart barChart;
    public final TextView dateTitle;
    public final ImageView endImg;
    public final LinearLayout linearLayout10;
    public final TextView m3;
    public final TextView m6;
    public final TextView maxUnit;
    public final TextView maxValue;
    public final View statusBarHeight;
    public final TextView subTitle;
    public final ConstraintLayout topbar;
    public final TextView tvAvgTitle;
    public final TextView tvMaxTitle;
    public final TextView tvTitle;
    public final TextView year;

    protected FragmentTrendChartBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView avgUnit, TextView avgValue, ImageView back, BarChart barChart, TextView dateTitle, ImageView endImg, LinearLayout linearLayout10, TextView m3, TextView m6, TextView maxUnit, TextView maxValue, View statusBarHeight, TextView subTitle, ConstraintLayout topbar, TextView tvAvgTitle, TextView tvMaxTitle, TextView tvTitle, TextView year) {
        super(_bindingComponent, _root, _localFieldCount);
        this.avgUnit = avgUnit;
        this.avgValue = avgValue;
        this.back = back;
        this.barChart = barChart;
        this.dateTitle = dateTitle;
        this.endImg = endImg;
        this.linearLayout10 = linearLayout10;
        this.m3 = m3;
        this.m6 = m6;
        this.maxUnit = maxUnit;
        this.maxValue = maxValue;
        this.statusBarHeight = statusBarHeight;
        this.subTitle = subTitle;
        this.topbar = topbar;
        this.tvAvgTitle = tvAvgTitle;
        this.tvMaxTitle = tvMaxTitle;
        this.tvTitle = tvTitle;
        this.year = year;
    }

    public static FragmentTrendChartBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTrendChartBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentTrendChartBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_trend_chart, root, attachToRoot, component);
    }

    public static FragmentTrendChartBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTrendChartBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentTrendChartBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_trend_chart, null, false, component);
    }

    public static FragmentTrendChartBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTrendChartBinding bind(View view, Object component) {
        return (FragmentTrendChartBinding) bind(component, view, R.layout.fragment_trend_chart);
    }
}
