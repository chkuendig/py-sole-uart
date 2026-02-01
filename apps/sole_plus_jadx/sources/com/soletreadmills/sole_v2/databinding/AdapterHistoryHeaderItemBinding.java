package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterHistoryHeaderItemBinding extends ViewDataBinding {
    public final TextView title;
    public final TextView tvWorkoutsCount;

    protected AdapterHistoryHeaderItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView title, TextView tvWorkoutsCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.title = title;
        this.tvWorkoutsCount = tvWorkoutsCount;
    }

    public static AdapterHistoryHeaderItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryHeaderItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterHistoryHeaderItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_header_item, root, attachToRoot, component);
    }

    public static AdapterHistoryHeaderItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryHeaderItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterHistoryHeaderItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_header_item, null, false, component);
    }

    public static AdapterHistoryHeaderItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryHeaderItemBinding bind(View view, Object component) {
        return (AdapterHistoryHeaderItemBinding) bind(component, view, R.layout.adapter_history_header_item);
    }
}
