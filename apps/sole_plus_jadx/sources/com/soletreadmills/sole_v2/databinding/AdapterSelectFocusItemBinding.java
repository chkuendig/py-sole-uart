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
public abstract class AdapterSelectFocusItemBinding extends ViewDataBinding {
    public final LinearLayout LL;
    public final TextView title;

    protected AdapterSelectFocusItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LL, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LL = LL;
        this.title = title;
    }

    public static AdapterSelectFocusItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectFocusItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterSelectFocusItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_select_focus_item, root, attachToRoot, component);
    }

    public static AdapterSelectFocusItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectFocusItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterSelectFocusItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_select_focus_item, null, false, component);
    }

    public static AdapterSelectFocusItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectFocusItemBinding bind(View view, Object component) {
        return (AdapterSelectFocusItemBinding) bind(component, view, R.layout.adapter_select_focus_item);
    }
}
