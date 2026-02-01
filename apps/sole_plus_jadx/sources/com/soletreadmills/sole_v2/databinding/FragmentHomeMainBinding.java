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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentHomeMainBinding extends ViewDataBinding {
    public final LinearLayout LLConnect;
    public final LinearLayout LLGetPremium;
    public final LinearLayout LLGoals;
    public final AppBarLayout appBarLayout;
    public final Toolbar collapsingToolbar;
    public final ImageView imgCollectionsMoreBtn;
    public final ImageView imgConnect;
    public final ImageView imgConnectPlus;
    public final ImageView imgFavoritesMoreBtn;
    public final RecyclerView rvCollections;
    public final RecyclerView rvConnect;
    public final RecyclerView rvFavorites;
    public final RecyclerView rvGoals;
    public final RecyclerView rvPickedForYou;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvConnect;
    public final TextView tvFavoritesEmptyDesc;

    protected FragmentHomeMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLConnect, LinearLayout LLGetPremium, LinearLayout LLGoals, AppBarLayout appBarLayout, Toolbar collapsingToolbar, ImageView imgCollectionsMoreBtn, ImageView imgConnect, ImageView imgConnectPlus, ImageView imgFavoritesMoreBtn, RecyclerView rvCollections, RecyclerView rvConnect, RecyclerView rvFavorites, RecyclerView rvGoals, RecyclerView rvPickedForYou, View statusBarHeight, SwipeRefreshLayout swipeRefreshLayout, TextView textView3, TextView title, ConstraintLayout topbar, TextView tvConnect, TextView tvFavoritesEmptyDesc) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLConnect = LLConnect;
        this.LLGetPremium = LLGetPremium;
        this.LLGoals = LLGoals;
        this.appBarLayout = appBarLayout;
        this.collapsingToolbar = collapsingToolbar;
        this.imgCollectionsMoreBtn = imgCollectionsMoreBtn;
        this.imgConnect = imgConnect;
        this.imgConnectPlus = imgConnectPlus;
        this.imgFavoritesMoreBtn = imgFavoritesMoreBtn;
        this.rvCollections = rvCollections;
        this.rvConnect = rvConnect;
        this.rvFavorites = rvFavorites;
        this.rvGoals = rvGoals;
        this.rvPickedForYou = rvPickedForYou;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
        this.tvConnect = tvConnect;
        this.tvFavoritesEmptyDesc = tvFavoritesEmptyDesc;
    }

    public static FragmentHomeMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHomeMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_main, root, attachToRoot, component);
    }

    public static FragmentHomeMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHomeMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_home_main, null, false, component);
    }

    public static FragmentHomeMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHomeMainBinding bind(View view, Object component) {
        return (FragmentHomeMainBinding) bind(component, view, R.layout.fragment_home_main);
    }
}
