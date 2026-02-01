package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterQuickPickItemBinding extends ViewDataBinding {
    public final ImageView imgIcon;
    public final TextView tvLabel;

    protected AdapterQuickPickItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgIcon, TextView tvLabel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgIcon = imgIcon;
        this.tvLabel = tvLabel;
    }

    public static AdapterQuickPickItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterQuickPickItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterQuickPickItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_quick_pick_item, root, attachToRoot, component);
    }

    public static AdapterQuickPickItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterQuickPickItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterQuickPickItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_quick_pick_item, null, false, component);
    }

    public static AdapterQuickPickItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterQuickPickItemBinding bind(View view, Object component) {
        return (AdapterQuickPickItemBinding) bind(component, view, R.layout.adapter_quick_pick_item);
    }
}
