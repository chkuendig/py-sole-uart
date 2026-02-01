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
public abstract class FragmentPersonalBestBinding extends ViewDataBinding {
    public final LinearLayout LLGreatJob;
    public final LinearLayout LLLock;
    public final LinearLayout LLLockHeader;
    public final LinearLayout LLUnlock;
    public final LinearLayout LLUnlockHeader;
    public final LinearLayout LLYear;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final Toolbar collapsingToolbar;
    public final ImageView imageView30;
    public final ImageView imgSearch;
    public final View lockLine;
    public final RecyclerView rcvLock;
    public final RecyclerView rcvYear;
    public final RecyclerView recyclerview;
    public final View statusBarHeight;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvLockTitle;
    public final TextView tvUnlockTitle;
    public final View unlockLine;

    protected FragmentPersonalBestBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLGreatJob, LinearLayout LLLock, LinearLayout LLLockHeader, LinearLayout LLUnlock, LinearLayout LLUnlockHeader, LinearLayout LLYear, AppBarLayout appBarLayout, ImageView back, Toolbar collapsingToolbar, ImageView imageView30, ImageView imgSearch, View lockLine, RecyclerView rcvLock, RecyclerView rcvYear, RecyclerView recyclerview, View statusBarHeight, TextView textView3, TextView title, ConstraintLayout topbar, TextView tvLockTitle, TextView tvUnlockTitle, View unlockLine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLGreatJob = LLGreatJob;
        this.LLLock = LLLock;
        this.LLLockHeader = LLLockHeader;
        this.LLUnlock = LLUnlock;
        this.LLUnlockHeader = LLUnlockHeader;
        this.LLYear = LLYear;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.collapsingToolbar = collapsingToolbar;
        this.imageView30 = imageView30;
        this.imgSearch = imgSearch;
        this.lockLine = lockLine;
        this.rcvLock = rcvLock;
        this.rcvYear = rcvYear;
        this.recyclerview = recyclerview;
        this.statusBarHeight = statusBarHeight;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
        this.tvLockTitle = tvLockTitle;
        this.tvUnlockTitle = tvUnlockTitle;
        this.unlockLine = unlockLine;
    }

    public static FragmentPersonalBestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPersonalBestBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPersonalBestBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_personal_best, root, attachToRoot, component);
    }

    public static FragmentPersonalBestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPersonalBestBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPersonalBestBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_personal_best, null, false, component);
    }

    public static FragmentPersonalBestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPersonalBestBinding bind(View view, Object component) {
        return (FragmentPersonalBestBinding) bind(component, view, R.layout.fragment_personal_best);
    }
}
