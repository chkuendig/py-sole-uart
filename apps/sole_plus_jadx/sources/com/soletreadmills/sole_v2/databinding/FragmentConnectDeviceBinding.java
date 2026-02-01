package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentConnectDeviceBinding extends ViewDataBinding {
    public final RecyclerView rvDevice;
    public final ConstraintLayout tobBar;
    public final TextView tvDone;
    public final TextView tvPageTitle;

    protected FragmentConnectDeviceBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvDevice, ConstraintLayout tobBar, TextView tvDone, TextView tvPageTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rvDevice = rvDevice;
        this.tobBar = tobBar;
        this.tvDone = tvDone;
        this.tvPageTitle = tvPageTitle;
    }

    public static FragmentConnectDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentConnectDeviceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connect_device, root, attachToRoot, component);
    }

    public static FragmentConnectDeviceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectDeviceBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentConnectDeviceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connect_device, null, false, component);
    }

    public static FragmentConnectDeviceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectDeviceBinding bind(View view, Object component) {
        return (FragmentConnectDeviceBinding) bind(component, view, R.layout.fragment_connect_device);
    }
}
