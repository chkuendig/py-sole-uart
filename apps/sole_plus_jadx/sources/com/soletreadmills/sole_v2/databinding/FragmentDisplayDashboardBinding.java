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
import androidx.viewpager2.widget.ViewPager2;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentDisplayDashboardBinding extends ViewDataBinding {
    public final LinearLayout backBtn;
    public final ImageView bleWatch;
    public final LinearLayout controlBoard;
    public final LinearLayout finishBtn;
    public final ImageView imgWatch;
    public final LinearLayout line;
    public final LinearLayout llControlPanel;
    public final LinearLayout llLeftBottomSheet;
    public final LinearLayout llLeftLine;
    public final LinearLayout llPauseBtn;
    public final LinearLayout llPausePanel;
    public final LinearLayout llRightBottomSheet;
    public final LinearLayout llRightLine;
    public final LinearLayout llStartBtn;
    public final LinearLayout llStartPanel;
    public final LinearLayout pagerIndicator;
    public final ImageView rotateSetting;
    public final View statusBarHeight;
    public final ImageView tabIndicator1;
    public final ImageView tabIndicator2;
    public final ImageView tabIndicator3;
    public final ConstraintLayout tobBar;
    public final TextView tvLeftUnit;
    public final TextView tvLeftValue;
    public final TextView tvRightUnit;
    public final TextView tvRightValue;
    public final ViewPager2 viewPager;

    protected FragmentDisplayDashboardBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout backBtn, ImageView bleWatch, LinearLayout controlBoard, LinearLayout finishBtn, ImageView imgWatch, LinearLayout line, LinearLayout llControlPanel, LinearLayout llLeftBottomSheet, LinearLayout llLeftLine, LinearLayout llPauseBtn, LinearLayout llPausePanel, LinearLayout llRightBottomSheet, LinearLayout llRightLine, LinearLayout llStartBtn, LinearLayout llStartPanel, LinearLayout pagerIndicator, ImageView rotateSetting, View statusBarHeight, ImageView tabIndicator1, ImageView tabIndicator2, ImageView tabIndicator3, ConstraintLayout tobBar, TextView tvLeftUnit, TextView tvLeftValue, TextView tvRightUnit, TextView tvRightValue, ViewPager2 viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.backBtn = backBtn;
        this.bleWatch = bleWatch;
        this.controlBoard = controlBoard;
        this.finishBtn = finishBtn;
        this.imgWatch = imgWatch;
        this.line = line;
        this.llControlPanel = llControlPanel;
        this.llLeftBottomSheet = llLeftBottomSheet;
        this.llLeftLine = llLeftLine;
        this.llPauseBtn = llPauseBtn;
        this.llPausePanel = llPausePanel;
        this.llRightBottomSheet = llRightBottomSheet;
        this.llRightLine = llRightLine;
        this.llStartBtn = llStartBtn;
        this.llStartPanel = llStartPanel;
        this.pagerIndicator = pagerIndicator;
        this.rotateSetting = rotateSetting;
        this.statusBarHeight = statusBarHeight;
        this.tabIndicator1 = tabIndicator1;
        this.tabIndicator2 = tabIndicator2;
        this.tabIndicator3 = tabIndicator3;
        this.tobBar = tobBar;
        this.tvLeftUnit = tvLeftUnit;
        this.tvLeftValue = tvLeftValue;
        this.tvRightUnit = tvRightUnit;
        this.tvRightValue = tvRightValue;
        this.viewPager = viewPager;
    }

    public static FragmentDisplayDashboardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDisplayDashboardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard, root, attachToRoot, component);
    }

    public static FragmentDisplayDashboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDisplayDashboardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard, null, false, component);
    }

    public static FragmentDisplayDashboardBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardBinding bind(View view, Object component) {
        return (FragmentDisplayDashboardBinding) bind(component, view, R.layout.fragment_display_dashboard);
    }
}
