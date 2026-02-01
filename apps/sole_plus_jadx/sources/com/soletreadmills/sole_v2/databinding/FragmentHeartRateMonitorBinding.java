package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentHeartRateMonitorBinding extends ViewDataBinding {
    public final RecyclerView rvHrm;
    public final SwipeRefreshLayout swipeRefreshLayout;
    public final ConstraintLayout tobBar;
    public final TextView tvCancelBtn;
    public final TextView tvPageTitle;

    protected FragmentHeartRateMonitorBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvHrm, SwipeRefreshLayout swipeRefreshLayout, ConstraintLayout tobBar, TextView tvCancelBtn, TextView tvPageTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvHrm = rvHrm;
        this.swipeRefreshLayout = swipeRefreshLayout;
        this.tobBar = tobBar;
        this.tvCancelBtn = tvCancelBtn;
        this.tvPageTitle = tvPageTitle;
    }

    public static FragmentHeartRateMonitorBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHeartRateMonitorBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHeartRateMonitorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_heart_rate_monitor, root, attachToRoot, component);
    }

    public static FragmentHeartRateMonitorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHeartRateMonitorBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHeartRateMonitorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_heart_rate_monitor, null, false, component);
    }

    public static FragmentHeartRateMonitorBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHeartRateMonitorBinding bind(View view, Object component) {
        return (FragmentHeartRateMonitorBinding) bind(component, view, R.layout.fragment_heart_rate_monitor);
    }
}
