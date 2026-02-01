package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentActivityMainBinding extends ViewDataBinding {
    public final LinearLayout LLHistory;
    public final LinearLayout LLHistoryEmpty;
    public final LinearLayout LLPersonalBest;
    public final LinearLayout LLPersonalBestEmpty;
    public final LinearLayout LLTrainingVolume;
    public final ImageView add;
    public final AppBarLayout appBarLayout;
    public final TextView chartTitle;
    public final Toolbar collapsingToolbar;
    public final ImageView endImg;
    public final ImageView imgHistoryArrow;
    public final ImageView imgPersonalBestArrow;
    public final LineChart lineChart;
    public final RecyclerView rvHistory;
    public final RecyclerView rvPersonalBest;
    public final LinearLayout sectionsContainer;
    public final View statusBarHeight;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvActiveHours;
    public final TextView tvTotalCalories;
    public final TextView tvTotalDistance;
    public final TextView tvTotalDistanceTitle;
    public final TextView tvWorkoutsCount;

    protected FragmentActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLHistory, LinearLayout LLHistoryEmpty, LinearLayout LLPersonalBest, LinearLayout LLPersonalBestEmpty, LinearLayout LLTrainingVolume, ImageView add, AppBarLayout appBarLayout, TextView chartTitle, Toolbar collapsingToolbar, ImageView endImg, ImageView imgHistoryArrow, ImageView imgPersonalBestArrow, LineChart lineChart, RecyclerView rvHistory, RecyclerView rvPersonalBest, LinearLayout sectionsContainer, View statusBarHeight, TextView textView3, TextView title, ConstraintLayout topbar, TextView tvActiveHours, TextView tvTotalCalories, TextView tvTotalDistance, TextView tvTotalDistanceTitle, TextView tvWorkoutsCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLHistory = LLHistory;
        this.LLHistoryEmpty = LLHistoryEmpty;
        this.LLPersonalBest = LLPersonalBest;
        this.LLPersonalBestEmpty = LLPersonalBestEmpty;
        this.LLTrainingVolume = LLTrainingVolume;
        this.add = add;
        this.appBarLayout = appBarLayout;
        this.chartTitle = chartTitle;
        this.collapsingToolbar = collapsingToolbar;
        this.endImg = endImg;
        this.imgHistoryArrow = imgHistoryArrow;
        this.imgPersonalBestArrow = imgPersonalBestArrow;
        this.lineChart = lineChart;
        this.rvHistory = rvHistory;
        this.rvPersonalBest = rvPersonalBest;
        this.sectionsContainer = sectionsContainer;
        this.statusBarHeight = statusBarHeight;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
        this.tvActiveHours = tvActiveHours;
        this.tvTotalCalories = tvTotalCalories;
        this.tvTotalDistance = tvTotalDistance;
        this.tvTotalDistanceTitle = tvTotalDistanceTitle;
        this.tvWorkoutsCount = tvWorkoutsCount;
    }

    public static FragmentActivityMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentActivityMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentActivityMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_activity_main, root, attachToRoot, component);
    }

    public static FragmentActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentActivityMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentActivityMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_activity_main, null, false, component);
    }

    public static FragmentActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentActivityMainBinding bind(View view, Object component) {
        return (FragmentActivityMainBinding) bind(component, view, R.layout.fragment_activity_main);
    }
}
