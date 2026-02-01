package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentDisplayDashboardP2Binding extends ViewDataBinding {
    public final LinearLayout chartContainer;

    protected FragmentDisplayDashboardP2Binding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout chartContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.chartContainer = chartContainer;
    }

    public static FragmentDisplayDashboardP2Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP2Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDisplayDashboardP2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard_p2, root, attachToRoot, component);
    }

    public static FragmentDisplayDashboardP2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP2Binding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDisplayDashboardP2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard_p2, null, false, component);
    }

    public static FragmentDisplayDashboardP2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP2Binding bind(View view, Object component) {
        return (FragmentDisplayDashboardP2Binding) bind(component, view, R.layout.fragment_display_dashboard_p2);
    }
}
