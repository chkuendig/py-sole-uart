package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterHistoryActivitytypeItemBinding extends ViewDataBinding {
    public final View line;
    public final TextView tvTitle;

    protected AdapterHistoryActivitytypeItemBinding(Object _bindingComponent, View _root, int _localFieldCount, View line, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.line = line;
        this.tvTitle = tvTitle;
    }

    public static AdapterHistoryActivitytypeItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryActivitytypeItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterHistoryActivitytypeItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_activitytype_item, root, attachToRoot, component);
    }

    public static AdapterHistoryActivitytypeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryActivitytypeItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterHistoryActivitytypeItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_activitytype_item, null, false, component);
    }

    public static AdapterHistoryActivitytypeItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryActivitytypeItemBinding bind(View view, Object component) {
        return (AdapterHistoryActivitytypeItemBinding) bind(component, view, R.layout.adapter_history_activitytype_item);
    }
}
