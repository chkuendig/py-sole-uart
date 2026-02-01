package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentHistoryBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final Toolbar collapsingToolbar;
    public final CoordinatorLayout coordinatorLayout;
    public final TextView edit;
    public final RecyclerView recyclerview;
    public final RecyclerView rvActivityType;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;

    protected FragmentHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, ImageView back, Toolbar collapsingToolbar, CoordinatorLayout coordinatorLayout, TextView edit, RecyclerView recyclerview, RecyclerView rvActivityType, View statusBarHeight, SwipeRefreshLayout swipeRefreshLayout, TextView textView3, TextView title, ConstraintLayout topbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.collapsingToolbar = collapsingToolbar;
        this.coordinatorLayout = coordinatorLayout;
        this.edit = edit;
        this.recyclerview = recyclerview;
        this.rvActivityType = rvActivityType;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
    }

    public static FragmentHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHistoryBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_history, root, attachToRoot, component);
    }

    public static FragmentHistoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHistoryBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHistoryBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_history, null, false, component);
    }

    public static FragmentHistoryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHistoryBinding bind(View view, Object component) {
        return (FragmentHistoryBinding) bind(component, view, R.layout.fragment_history);
    }
}
