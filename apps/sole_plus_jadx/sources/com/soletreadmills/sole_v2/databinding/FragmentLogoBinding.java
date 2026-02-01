package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentLogoBinding extends ViewDataBinding {
    public final ImageView imageView;

    protected FragmentLogoBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageView = imageView;
    }

    public static FragmentLogoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLogoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentLogoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_logo, root, attachToRoot, component);
    }

    public static FragmentLogoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLogoBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentLogoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_logo, null, false, component);
    }

    public static FragmentLogoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLogoBinding bind(View view, Object component) {
        return (FragmentLogoBinding) bind(component, view, R.layout.fragment_logo);
    }
}
