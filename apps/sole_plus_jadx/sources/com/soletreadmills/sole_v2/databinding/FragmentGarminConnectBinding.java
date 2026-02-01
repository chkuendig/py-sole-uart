package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentGarminConnectBinding extends ViewDataBinding {
    public final View navigationBarHeight;
    public final View statusBarHeight;
    public final WebView webView;

    protected FragmentGarminConnectBinding(Object _bindingComponent, View _root, int _localFieldCount, View navigationBarHeight, View statusBarHeight, WebView webView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.navigationBarHeight = navigationBarHeight;
        this.statusBarHeight = statusBarHeight;
        this.webView = webView;
    }

    public static FragmentGarminConnectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGarminConnectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentGarminConnectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_garmin_connect, root, attachToRoot, component);
    }

    public static FragmentGarminConnectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGarminConnectBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentGarminConnectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_garmin_connect, null, false, component);
    }

    public static FragmentGarminConnectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGarminConnectBinding bind(View view, Object component) {
        return (FragmentGarminConnectBinding) bind(component, view, R.layout.fragment_garmin_connect);
    }
}
