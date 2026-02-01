package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
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
public abstract class FragmentMyFavoritesBinding extends ViewDataBinding {
    public final LinearLayout LLCategory;
    public final LinearLayout LLRemoveAll;
    public final LinearLayout LLWorkoutsEmpty;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final Toolbar collapsingToolbar;
    public final ImageView imgEmpty;
    public final RecyclerView recyclerViewFavorites;
    public final HorizontalScrollView scrollFilter;
    public final TextView setFree;
    public final View statusBarHeight;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvEmpty;
    public final TextView tvResetFilters;
    public final TextView txtClasses;
    public final TextView txtCollections;
    public final TextView txtEditOrDone;
    public final TextView txtPrograms;

    protected FragmentMyFavoritesBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLCategory, LinearLayout LLRemoveAll, LinearLayout LLWorkoutsEmpty, AppBarLayout appBarLayout, ImageView back, Toolbar collapsingToolbar, ImageView imgEmpty, RecyclerView recyclerViewFavorites, HorizontalScrollView scrollFilter, TextView setFree, View statusBarHeight, TextView title, ConstraintLayout topbar, TextView tvEmpty, TextView tvResetFilters, TextView txtClasses, TextView txtCollections, TextView txtEditOrDone, TextView txtPrograms) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLCategory = LLCategory;
        this.LLRemoveAll = LLRemoveAll;
        this.LLWorkoutsEmpty = LLWorkoutsEmpty;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.collapsingToolbar = collapsingToolbar;
        this.imgEmpty = imgEmpty;
        this.recyclerViewFavorites = recyclerViewFavorites;
        this.scrollFilter = scrollFilter;
        this.setFree = setFree;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
        this.topbar = topbar;
        this.tvEmpty = tvEmpty;
        this.tvResetFilters = tvResetFilters;
        this.txtClasses = txtClasses;
        this.txtCollections = txtCollections;
        this.txtEditOrDone = txtEditOrDone;
        this.txtPrograms = txtPrograms;
    }

    public static FragmentMyFavoritesBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyFavoritesBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentMyFavoritesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_my_favorites, root, attachToRoot, component);
    }

    public static FragmentMyFavoritesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyFavoritesBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentMyFavoritesBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_my_favorites, null, false, component);
    }

    public static FragmentMyFavoritesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentMyFavoritesBinding bind(View view, Object component) {
        return (FragmentMyFavoritesBinding) bind(component, view, R.layout.fragment_my_favorites);
    }
}
