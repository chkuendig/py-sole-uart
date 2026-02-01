package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterClassesEndBinding extends ViewDataBinding {
    protected AdapterClassesEndBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static AdapterClassesEndBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesEndBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClassesEndBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_classes_end, root, attachToRoot, component);
    }

    public static AdapterClassesEndBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesEndBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClassesEndBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_classes_end, null, false, component);
    }

    public static AdapterClassesEndBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesEndBinding bind(View view, Object component) {
        return (AdapterClassesEndBinding) bind(component, view, R.layout.adapter_classes_end);
    }
}
