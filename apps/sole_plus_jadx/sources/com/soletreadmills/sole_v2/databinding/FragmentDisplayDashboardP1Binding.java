package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentDisplayDashboardP1Binding extends ViewDataBinding {
    public final RecyclerView rvDisplayModeItem;

    protected FragmentDisplayDashboardP1Binding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvDisplayModeItem) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvDisplayModeItem = rvDisplayModeItem;
    }

    public static FragmentDisplayDashboardP1Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP1Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDisplayDashboardP1Binding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard_p1, root, attachToRoot, component);
    }

    public static FragmentDisplayDashboardP1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP1Binding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDisplayDashboardP1Binding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard_p1, null, false, component);
    }

    public static FragmentDisplayDashboardP1Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP1Binding bind(View view, Object component) {
        return (FragmentDisplayDashboardP1Binding) bind(component, view, R.layout.fragment_display_dashboard_p1);
    }
}
