package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentPairDevicePageItemBinding extends ViewDataBinding {
    public final ConstraintLayout CL;
    public final ImageView img;
    public final TextView name;

    protected FragmentPairDevicePageItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CL, ImageView img, TextView name) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CL = CL;
        this.img = img;
        this.name = name;
    }

    public static FragmentPairDevicePageItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPairDevicePageItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPairDevicePageItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pair_device_page_item, root, attachToRoot, component);
    }

    public static FragmentPairDevicePageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPairDevicePageItemBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPairDevicePageItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pair_device_page_item, null, false, component);
    }

    public static FragmentPairDevicePageItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPairDevicePageItemBinding bind(View view, Object component) {
        return (FragmentPairDevicePageItemBinding) bind(component, view, R.layout.fragment_pair_device_page_item);
    }
}
