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
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentHistoryWorkoutBinding extends ViewDataBinding {
    public final ConstraintLayout CLIsBest;
    public final LinearLayout LLBottom;
    public final LinearLayout LLChart;
    public final LinearLayout LLPace;
    public final LinearLayout LLRematch;
    public final LinearLayout LLShare;
    public final LinearLayout LLWorkoutInfo;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final Toolbar collapsingToolbar;
    public final ImageView endImg;
    public final ImageView imageView15;
    public final ImageView img;
    public final ImageView imgBack;
    public final ImageView imgBest;
    public final ImageView imgDelete;
    public final RecyclerView rvPace;
    public final View space1;
    public final View space2;
    public final View statusBarHeight;
    public final TextView time;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvHeader;
    public final TextView tvShare;
    public final TextView tvTitle;
    public final TextView tvTitleDate;
    public final TextView txtDate;
    public final View view2;
    public final View view4;
    public final TextView workoutName;

    protected FragmentHistoryWorkoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLIsBest, LinearLayout LLBottom, LinearLayout LLChart, LinearLayout LLPace, LinearLayout LLRematch, LinearLayout LLShare, LinearLayout LLWorkoutInfo, AppBarLayout appBarLayout, ImageView back, Toolbar collapsingToolbar, ImageView endImg, ImageView imageView15, ImageView img, ImageView imgBack, ImageView imgBest, ImageView imgDelete, RecyclerView rvPace, View space1, View space2, View statusBarHeight, TextView time, TextView title, ConstraintLayout topbar, TextView tvHeader, TextView tvShare, TextView tvTitle, TextView tvTitleDate, TextView txtDate, View view2, View view4, TextView workoutName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLIsBest = CLIsBest;
        this.LLBottom = LLBottom;
        this.LLChart = LLChart;
        this.LLPace = LLPace;
        this.LLRematch = LLRematch;
        this.LLShare = LLShare;
        this.LLWorkoutInfo = LLWorkoutInfo;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.collapsingToolbar = collapsingToolbar;
        this.endImg = endImg;
        this.imageView15 = imageView15;
        this.img = img;
        this.imgBack = imgBack;
        this.imgBest = imgBest;
        this.imgDelete = imgDelete;
        this.rvPace = rvPace;
        this.space1 = space1;
        this.space2 = space2;
        this.statusBarHeight = statusBarHeight;
        this.time = time;
        this.title = title;
        this.topbar = topbar;
        this.tvHeader = tvHeader;
        this.tvShare = tvShare;
        this.tvTitle = tvTitle;
        this.tvTitleDate = tvTitleDate;
        this.txtDate = txtDate;
        this.view2 = view2;
        this.view4 = view4;
        this.workoutName = workoutName;
    }

    public static FragmentHistoryWorkoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHistoryWorkoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHistoryWorkoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_history_workout, root, attachToRoot, component);
    }

    public static FragmentHistoryWorkoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHistoryWorkoutBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHistoryWorkoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_history_workout, null, false, component);
    }

    public static FragmentHistoryWorkoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHistoryWorkoutBinding bind(View view, Object component) {
        return (FragmentHistoryWorkoutBinding) bind(component, view, R.layout.fragment_history_workout);
    }
}
