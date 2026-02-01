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
public abstract class FragmentConnectedPageBinding extends ViewDataBinding {
    public final LinearLayout LLBottom;
    public final LinearLayout LLCategory;
    public final LinearLayout LLDisconnect;
    public final LinearLayout LLFinish;
    public final LinearLayout LLNoProgram;
    public final LinearLayout LLSimpleBottom;
    public final LinearLayout LLStart;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final ImageView bleWatch;
    public final Toolbar collapsingToolbar;
    public final ImageView imageView11;
    public final ImageView imageView15;
    public final ImageView imageView22;
    public final ImageView imgWatch;
    public final LinearLayout linearLayout5;
    public final TextView llCountdownNum;
    public final LinearLayout llCountdownWrap;
    public final RecyclerView recyclerViewProgram;
    public final RecyclerView recyclerviewCategory;
    public final TextView textView11;
    public final TextView textView9;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvDeviceName;
    public final TextView tvDisplay;
    public final TextView tvMachineType;
    public final TextView tvUnpair;

    protected FragmentConnectedPageBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLBottom, LinearLayout LLCategory, LinearLayout LLDisconnect, LinearLayout LLFinish, LinearLayout LLNoProgram, LinearLayout LLSimpleBottom, LinearLayout LLStart, AppBarLayout appBarLayout, ImageView back, ImageView bleWatch, Toolbar collapsingToolbar, ImageView imageView11, ImageView imageView15, ImageView imageView22, ImageView imgWatch, LinearLayout linearLayout5, TextView llCountdownNum, LinearLayout llCountdownWrap, RecyclerView recyclerViewProgram, RecyclerView recyclerviewCategory, TextView textView11, TextView textView9, TextView title, ConstraintLayout topbar, TextView tvDeviceName, TextView tvDisplay, TextView tvMachineType, TextView tvUnpair) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLBottom = LLBottom;
        this.LLCategory = LLCategory;
        this.LLDisconnect = LLDisconnect;
        this.LLFinish = LLFinish;
        this.LLNoProgram = LLNoProgram;
        this.LLSimpleBottom = LLSimpleBottom;
        this.LLStart = LLStart;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.bleWatch = bleWatch;
        this.collapsingToolbar = collapsingToolbar;
        this.imageView11 = imageView11;
        this.imageView15 = imageView15;
        this.imageView22 = imageView22;
        this.imgWatch = imgWatch;
        this.linearLayout5 = linearLayout5;
        this.llCountdownNum = llCountdownNum;
        this.llCountdownWrap = llCountdownWrap;
        this.recyclerViewProgram = recyclerViewProgram;
        this.recyclerviewCategory = recyclerviewCategory;
        this.textView11 = textView11;
        this.textView9 = textView9;
        this.title = title;
        this.topbar = topbar;
        this.tvDeviceName = tvDeviceName;
        this.tvDisplay = tvDisplay;
        this.tvMachineType = tvMachineType;
        this.tvUnpair = tvUnpair;
    }

    public static FragmentConnectedPageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectedPageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentConnectedPageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connected_page, root, attachToRoot, component);
    }

    public static FragmentConnectedPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectedPageBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentConnectedPageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connected_page, null, false, component);
    }

    public static FragmentConnectedPageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectedPageBinding bind(View view, Object component) {
        return (FragmentConnectedPageBinding) bind(component, view, R.layout.fragment_connected_page);
    }
}
