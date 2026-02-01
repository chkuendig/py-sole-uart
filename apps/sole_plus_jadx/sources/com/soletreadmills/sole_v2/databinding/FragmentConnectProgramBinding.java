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
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;

/* loaded from: classes5.dex */
public abstract class FragmentConnectProgramBinding extends ViewDataBinding {
    public final ConstraintLayout CLTargetHeartRate;
    public final LinearLayout LLBarchat;
    public final LinearLayout LLSave;
    public final LinearLayout LLTargetImg;
    public final LinearLayout LLTargetView;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final MultiLayerBarChartView barChart;
    public final ImageView bleWatch;
    public final Toolbar collapsingToolbar;
    public final TextView edit;
    public final ImageView imageView11;
    public final ImageView img;
    public final ImageView imgWatch;
    public final LinearLayout linearLayout8;
    public final TextView name;
    public final LinearLayout start;
    public final View statusBarHeight;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvMachineName;
    public final TextView tvMax60;
    public final TextView tvMax80;
    public final TextView tvProgramName;
    public final TextView unit;
    public final TextView value;

    protected FragmentConnectProgramBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTargetHeartRate, LinearLayout LLBarchat, LinearLayout LLSave, LinearLayout LLTargetImg, LinearLayout LLTargetView, AppBarLayout appBarLayout, ImageView back, MultiLayerBarChartView barChart, ImageView bleWatch, Toolbar collapsingToolbar, TextView edit, ImageView imageView11, ImageView img, ImageView imgWatch, LinearLayout linearLayout8, TextView name, LinearLayout start, View statusBarHeight, TextView textView12, TextView textView13, TextView title, ConstraintLayout topbar, TextView tvMachineName, TextView tvMax60, TextView tvMax80, TextView tvProgramName, TextView unit, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTargetHeartRate = CLTargetHeartRate;
        this.LLBarchat = LLBarchat;
        this.LLSave = LLSave;
        this.LLTargetImg = LLTargetImg;
        this.LLTargetView = LLTargetView;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.barChart = barChart;
        this.bleWatch = bleWatch;
        this.collapsingToolbar = collapsingToolbar;
        this.edit = edit;
        this.imageView11 = imageView11;
        this.img = img;
        this.imgWatch = imgWatch;
        this.linearLayout8 = linearLayout8;
        this.name = name;
        this.start = start;
        this.statusBarHeight = statusBarHeight;
        this.textView12 = textView12;
        this.textView13 = textView13;
        this.title = title;
        this.topbar = topbar;
        this.tvMachineName = tvMachineName;
        this.tvMax60 = tvMax60;
        this.tvMax80 = tvMax80;
        this.tvProgramName = tvProgramName;
        this.unit = unit;
        this.value = value;
    }

    public static FragmentConnectProgramBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectProgramBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentConnectProgramBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connect_program, root, attachToRoot, component);
    }

    public static FragmentConnectProgramBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectProgramBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentConnectProgramBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connect_program, null, false, component);
    }

    public static FragmentConnectProgramBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectProgramBinding bind(View view, Object component) {
        return (FragmentConnectProgramBinding) bind(component, view, R.layout.fragment_connect_program);
    }
}
