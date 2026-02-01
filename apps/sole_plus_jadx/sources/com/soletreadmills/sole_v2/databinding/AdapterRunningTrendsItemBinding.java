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
public abstract class AdapterRunningTrendsItemBinding extends ViewDataBinding {
    public final LinearLayout LL;
    public final TextView name;
    public final TextView unit;
    public final TextView unit2;
    public final TextView value;

    protected AdapterRunningTrendsItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LL, TextView name, TextView unit, TextView unit2, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LL = LL;
        this.name = name;
        this.unit = unit;
        this.unit2 = unit2;
        this.value = value;
    }

    public static AdapterRunningTrendsItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRunningTrendsItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterRunningTrendsItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_running_trends_item, root, attachToRoot, component);
    }

    public static AdapterRunningTrendsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRunningTrendsItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterRunningTrendsItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_running_trends_item, null, false, component);
    }

    public static AdapterRunningTrendsItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterRunningTrendsItemBinding bind(View view, Object component) {
        return (AdapterRunningTrendsItemBinding) bind(component, view, R.layout.adapter_running_trends_item);
    }
}
