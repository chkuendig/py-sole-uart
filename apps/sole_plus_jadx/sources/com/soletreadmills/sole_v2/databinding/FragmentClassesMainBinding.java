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
public abstract class FragmentClassesMainBinding extends ViewDataBinding {
    public final LinearLayout LLAll;
    public final LinearLayout LLCategory;
    public final LinearLayout LLCollections;
    public final LinearLayout LLCollectionsView;
    public final LinearLayout LLSessionsView;
    public final LinearLayout LLWorkoutsEmpty;
    public final ImageView add;
    public final AppBarLayout appBarLayout;
    public final Toolbar collapsingToolbar;
    public final TextView collections;
    public final View collectionsLine;
    public final ImageView imageView30;
    public final ImageView imgSearch;
    public final RecyclerView recyclerview;
    public final RecyclerView recyclerviewCategory;
    public final RecyclerView recyclerviewCollections;
    public final TextView sessions;
    public final View sessionsLine;
    public final View statusBarHeight;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView txtResetFilters;

    protected FragmentClassesMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLAll, LinearLayout LLCategory, LinearLayout LLCollections, LinearLayout LLCollectionsView, LinearLayout LLSessionsView, LinearLayout LLWorkoutsEmpty, ImageView add, AppBarLayout appBarLayout, Toolbar collapsingToolbar, TextView collections, View collectionsLine, ImageView imageView30, ImageView imgSearch, RecyclerView recyclerview, RecyclerView recyclerviewCategory, RecyclerView recyclerviewCollections, TextView sessions, View sessionsLine, View statusBarHeight, TextView textView3, TextView title, ConstraintLayout topbar, TextView txtResetFilters) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLAll = LLAll;
        this.LLCategory = LLCategory;
        this.LLCollections = LLCollections;
        this.LLCollectionsView = LLCollectionsView;
        this.LLSessionsView = LLSessionsView;
        this.LLWorkoutsEmpty = LLWorkoutsEmpty;
        this.add = add;
        this.appBarLayout = appBarLayout;
        this.collapsingToolbar = collapsingToolbar;
        this.collections = collections;
        this.collectionsLine = collectionsLine;
        this.imageView30 = imageView30;
        this.imgSearch = imgSearch;
        this.recyclerview = recyclerview;
        this.recyclerviewCategory = recyclerviewCategory;
        this.recyclerviewCollections = recyclerviewCollections;
        this.sessions = sessions;
        this.sessionsLine = sessionsLine;
        this.statusBarHeight = statusBarHeight;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
        this.txtResetFilters = txtResetFilters;
    }

    public static FragmentClassesMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClassesMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClassesMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_classes_main, root, attachToRoot, component);
    }

    public static FragmentClassesMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClassesMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClassesMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_classes_main, null, false, component);
    }

    public static FragmentClassesMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClassesMainBinding bind(View view, Object component) {
        return (FragmentClassesMainBinding) bind(component, view, R.layout.fragment_classes_main);
    }
}
