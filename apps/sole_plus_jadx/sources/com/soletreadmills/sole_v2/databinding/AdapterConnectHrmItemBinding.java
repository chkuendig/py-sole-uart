package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterConnectHrmItemBinding extends ViewDataBinding {
    public final CardView card;
    public final CardView cardImg;
    public final ImageView imgCircle;
    public final ImageView imgDevice;
    public final TextView tvStatus;
    public final TextView tvTitle;

    protected AdapterConnectHrmItemBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView card, CardView cardImg, ImageView imgCircle, ImageView imgDevice, TextView tvStatus, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card = card;
        this.cardImg = cardImg;
        this.imgCircle = imgCircle;
        this.imgDevice = imgDevice;
        this.tvStatus = tvStatus;
        this.tvTitle = tvTitle;
    }

    public static AdapterConnectHrmItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectHrmItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterConnectHrmItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_hrm_item, root, attachToRoot, component);
    }

    public static AdapterConnectHrmItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectHrmItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterConnectHrmItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_hrm_item, null, false, component);
    }

    public static AdapterConnectHrmItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectHrmItemBinding bind(View view, Object component) {
        return (AdapterConnectHrmItemBinding) bind(component, view, R.layout.adapter_connect_hrm_item);
    }
}
