package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentDisplaySettingsBinding extends ViewDataBinding {
    public final LinearLayout LLRotateAutomatically;
    public final LinearLayout LLRotateEvery;
    public final TextView done;
    public final LinearLayout linearLayout7;
    public final TextView reset;
    public final View statusBarHeight;
    public final Switch switchAutomatically;
    public final TextView title;
    public final TextView tvRotateEvery;

    protected FragmentDisplaySettingsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLRotateAutomatically, LinearLayout LLRotateEvery, TextView done, LinearLayout linearLayout7, TextView reset, View statusBarHeight, Switch switchAutomatically, TextView title, TextView tvRotateEvery) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLRotateAutomatically = LLRotateAutomatically;
        this.LLRotateEvery = LLRotateEvery;
        this.done = done;
        this.linearLayout7 = linearLayout7;
        this.reset = reset;
        this.statusBarHeight = statusBarHeight;
        this.switchAutomatically = switchAutomatically;
        this.title = title;
        this.tvRotateEvery = tvRotateEvery;
    }

    public static FragmentDisplaySettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplaySettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDisplaySettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_settings, root, attachToRoot, component);
    }

    public static FragmentDisplaySettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplaySettingsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDisplaySettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_settings, null, false, component);
    }

    public static FragmentDisplaySettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplaySettingsBinding bind(View view, Object component) {
        return (FragmentDisplaySettingsBinding) bind(component, view, R.layout.fragment_display_settings);
    }
}
