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
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSettingsAppsBinding extends ViewDataBinding {
    public final ImageView back;
    public final ImageView endImg;
    public final LinearLayout linearLayout4;
    public final LinearLayout llGarminConnect;
    public final LinearLayout llHealthConnect;
    public final LinearLayout llSamsungHealth;
    public final View statusBarHeight;
    public final TextView textView2;
    public final ConstraintLayout topbar;
    public final TextView tvGarminConnectLinked;
    public final TextView tvHealthConnectLinked;
    public final TextView tvSamsungHealthLinked;

    protected FragmentSettingsAppsBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView back, ImageView endImg, LinearLayout linearLayout4, LinearLayout llGarminConnect, LinearLayout llHealthConnect, LinearLayout llSamsungHealth, View statusBarHeight, TextView textView2, ConstraintLayout topbar, TextView tvGarminConnectLinked, TextView tvHealthConnectLinked, TextView tvSamsungHealthLinked) {
        super(_bindingComponent, _root, _localFieldCount);
        this.back = back;
        this.endImg = endImg;
        this.linearLayout4 = linearLayout4;
        this.llGarminConnect = llGarminConnect;
        this.llHealthConnect = llHealthConnect;
        this.llSamsungHealth = llSamsungHealth;
        this.statusBarHeight = statusBarHeight;
        this.textView2 = textView2;
        this.topbar = topbar;
        this.tvGarminConnectLinked = tvGarminConnectLinked;
        this.tvHealthConnectLinked = tvHealthConnectLinked;
        this.tvSamsungHealthLinked = tvSamsungHealthLinked;
    }

    public static FragmentSettingsAppsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsAppsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSettingsAppsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_settings_apps, root, attachToRoot, component);
    }

    public static FragmentSettingsAppsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsAppsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSettingsAppsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_settings_apps, null, false, component);
    }

    public static FragmentSettingsAppsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsAppsBinding bind(View view, Object component) {
        return (FragmentSettingsAppsBinding) bind(component, view, R.layout.fragment_settings_apps);
    }
}
