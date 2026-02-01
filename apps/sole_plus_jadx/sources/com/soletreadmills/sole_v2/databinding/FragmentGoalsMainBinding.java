package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentGoalsMainBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final Toolbar collapsingToolbar;
    public final RecyclerView rv;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvDone;
    public final TextView tvEdit;

    protected FragmentGoalsMainBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBarLayout, ImageView back, Toolbar collapsingToolbar, RecyclerView rv, View statusBarHeight, SwipeRefreshLayout swipeRefreshLayout, TextView textView3, TextView title, ConstraintLayout topbar, TextView tvDone, TextView tvEdit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.collapsingToolbar = collapsingToolbar;
        this.rv = rv;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
        this.tvDone = tvDone;
        this.tvEdit = tvEdit;
    }

    public static FragmentGoalsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGoalsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentGoalsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_goals_main, root, attachToRoot, component);
    }

    public static FragmentGoalsMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGoalsMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentGoalsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_goals_main, null, false, component);
    }

    public static FragmentGoalsMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGoalsMainBinding bind(View view, Object component) {
        return (FragmentGoalsMainBinding) bind(component, view, R.layout.fragment_goals_main);
    }
}
