package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomTabBinding extends ViewDataBinding {
    public final ImageView tabIcon;

    protected CustomTabBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView tabIcon) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tabIcon = tabIcon;
    }

    public static CustomTabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomTabBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomTabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_tab, root, attachToRoot, component);
    }

    public static CustomTabBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomTabBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomTabBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_tab, null, false, component);
    }

    public static CustomTabBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomTabBinding bind(View view, Object component) {
        return (CustomTabBinding) bind(component, view, R.layout.custom_tab);
    }
}
