package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterConnectDeviceItemBinding extends ViewDataBinding {
    public final LinearLayout LLStatus;
    public final CardView card;
    public final CardView cardImg;
    public final ImageView imgCircle;
    public final ImageView imgDevice;
    public final TextView tvStatus;
    public final TextView tvTitle;

    protected AdapterConnectDeviceItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLStatus, CardView card, CardView cardImg, ImageView imgCircle, ImageView imgDevice, TextView tvStatus, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLStatus = LLStatus;
        this.card = card;
        this.cardImg = cardImg;
        this.imgCircle = imgCircle;
        this.imgDevice = imgDevice;
        this.tvStatus = tvStatus;
        this.tvTitle = tvTitle;
    }

    public static AdapterConnectDeviceItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectDeviceItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterConnectDeviceItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_device_item, root, attachToRoot, component);
    }

    public static AdapterConnectDeviceItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectDeviceItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterConnectDeviceItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_device_item, null, false, component);
    }

    public static AdapterConnectDeviceItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectDeviceItemBinding bind(View view, Object component) {
        return (AdapterConnectDeviceItemBinding) bind(component, view, R.layout.adapter_connect_device_item);
    }
}
