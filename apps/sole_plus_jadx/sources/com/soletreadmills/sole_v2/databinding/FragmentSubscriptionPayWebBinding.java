package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSubscriptionPayWebBinding extends ViewDataBinding {
    public final ImageView back;
    public final View statusBarHeight;
    public final ConstraintLayout topBar;
    public final TextView topBarTitle;
    public final WebView webView;

    protected FragmentSubscriptionPayWebBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView back, View statusBarHeight, ConstraintLayout topBar, TextView topBarTitle, WebView webView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.back = back;
        this.statusBarHeight = statusBarHeight;
        this.topBar = topBar;
        this.topBarTitle = topBarTitle;
        this.webView = webView;
    }

    public static FragmentSubscriptionPayWebBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionPayWebBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSubscriptionPayWebBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_subscription_pay_web, root, attachToRoot, component);
    }

    public static FragmentSubscriptionPayWebBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionPayWebBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSubscriptionPayWebBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_subscription_pay_web, null, false, component);
    }

    public static FragmentSubscriptionPayWebBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionPayWebBinding bind(View view, Object component) {
        return (FragmentSubscriptionPayWebBinding) bind(component, view, R.layout.fragment_subscription_pay_web);
    }
}
