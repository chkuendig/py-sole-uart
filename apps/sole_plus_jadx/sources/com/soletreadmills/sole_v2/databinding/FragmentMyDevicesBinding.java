package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentMyDevicesBinding extends ViewDataBinding {
    public final ConstraintLayout CLNoSearch;
    public final LinearLayout LLAddDevice;
    public final LinearLayout LLUnpair;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final Toolbar collapsingToolbar;
    public final CoordinatorLayout coordinatorLayout;
    public final TextView edit;
    public final LinearLayout linearLayout5;
    public final RecyclerView recyclerview;
    public final View statusBarHeight;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvUnpair;
    public final View view2;

    protected FragmentMyDevicesBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLNoSearch, LinearLayout LLAddDevice, LinearLayout LLUnpair, AppBarLayout appBarLayout, ImageView back, Toolbar collapsingToolbar, CoordinatorLayout coordinatorLayout, TextView edit, LinearLayout linearLayout5, RecyclerView recyclerview, View statusBarHeight, TextView title, ConstraintLayout topbar, TextView tvUnpair, View view2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLNoSearch = CLNoSearch;
        this.LLAddDevice = LLAddDevice;
        this.LLUnpair = LLUnpair;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.collapsingToolbar = collapsingToolbar;
        this.coordinatorLayout = coordinatorLayout;
        this.edit = edit;
        this.linearLayout5 = linearLayout5;
        this.recyclerview = recyclerview;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
        this.topbar = topbar;
        this.tvUnpair = tvUnpair;
        this.view2 = view2;
    }

    public static FragmentMyDevicesBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyDevicesBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentMyDevicesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_my_devices, root, attachToRoot, component);
    }

    public static FragmentMyDevicesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyDevicesBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentMyDevicesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_my_devices, null, false, component);
    }

    public static FragmentMyDevicesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyDevicesBinding bind(View view, Object component) {
        return (FragmentMyDevicesBinding) bind(component, view, R.layout.fragment_my_devices);
    }
}
