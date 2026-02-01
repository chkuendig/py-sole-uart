package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterMyDevicesItemBinding extends ViewDataBinding {
    public final CardView card;
    public final CardView cardImg;
    public final AppCompatImageView imgCheck;
    public final ImageView imgCircle;
    public final ImageView imgDevice;
    public final View line;
    public final TextView tvName;
    public final TextView tvStatus;
    public final TextView tvTitle;

    protected AdapterMyDevicesItemBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView card, CardView cardImg, AppCompatImageView imgCheck, ImageView imgCircle, ImageView imgDevice, View line, TextView tvName, TextView tvStatus, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card = card;
        this.cardImg = cardImg;
        this.imgCheck = imgCheck;
        this.imgCircle = imgCircle;
        this.imgDevice = imgDevice;
        this.line = line;
        this.tvName = tvName;
        this.tvStatus = tvStatus;
        this.tvTitle = tvTitle;
    }

    public static AdapterMyDevicesItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyDevicesItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterMyDevicesItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_my_devices_item, root, attachToRoot, component);
    }

    public static AdapterMyDevicesItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyDevicesItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterMyDevicesItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_my_devices_item, null, false, component);
    }

    public static AdapterMyDevicesItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyDevicesItemBinding bind(View view, Object component) {
        return (AdapterMyDevicesItemBinding) bind(component, view, R.layout.adapter_my_devices_item);
    }
}
