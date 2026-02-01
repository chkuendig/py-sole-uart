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
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentPaywallBinding extends ViewDataBinding {
    public final LinearLayout LLActivate;
    public final LinearLayout LLBottom;
    public final ImageView back;
    public final ImageView imageView13;
    public final ImageView imgGradient;
    public final RecyclerView rvPlans;
    public final ConstraintLayout topbar;
    public final TextView tvActivate;
    public final TextView tvHint;

    protected FragmentPaywallBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLActivate, LinearLayout LLBottom, ImageView back, ImageView imageView13, ImageView imgGradient, RecyclerView rvPlans, ConstraintLayout topbar, TextView tvActivate, TextView tvHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLActivate = LLActivate;
        this.LLBottom = LLBottom;
        this.back = back;
        this.imageView13 = imageView13;
        this.imgGradient = imgGradient;
        this.rvPlans = rvPlans;
        this.topbar = topbar;
        this.tvActivate = tvActivate;
        this.tvHint = tvHint;
    }

    public static FragmentPaywallBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaywallBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPaywallBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_paywall, root, attachToRoot, component);
    }

    public static FragmentPaywallBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaywallBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPaywallBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_paywall, null, false, component);
    }

    public static FragmentPaywallBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaywallBinding bind(View view, Object component) {
        return (FragmentPaywallBinding) bind(component, view, R.layout.fragment_paywall);
    }
}
