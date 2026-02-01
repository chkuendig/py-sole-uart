package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterSelectDurationItemBinding extends ViewDataBinding {
    public final LinearLayout LL;
    public final TextView time;
    public final TextView unit;

    protected AdapterSelectDurationItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LL, TextView time, TextView unit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LL = LL;
        this.time = time;
        this.unit = unit;
    }

    public static AdapterSelectDurationItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectDurationItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterSelectDurationItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_select_duration_item, root, attachToRoot, component);
    }

    public static AdapterSelectDurationItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectDurationItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterSelectDurationItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_select_duration_item, null, false, component);
    }

    public static AdapterSelectDurationItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectDurationItemBinding bind(View view, Object component) {
        return (AdapterSelectDurationItemBinding) bind(component, view, R.layout.adapter_select_duration_item);
    }
}
