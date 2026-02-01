package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomSelectBleConnectBinding extends ViewDataBinding {
    public final LinearLayout LLBle;
    public final LinearLayout LLCloud;
    public final AppCompatImageView close;
    public final TextView title;

    protected CustomSelectBleConnectBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLBle, LinearLayout LLCloud, AppCompatImageView close, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLBle = LLBle;
        this.LLCloud = LLCloud;
        this.close = close;
        this.title = title;
    }

    public static CustomSelectBleConnectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectBleConnectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSelectBleConnectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_ble_connect, root, attachToRoot, component);
    }

    public static CustomSelectBleConnectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectBleConnectBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSelectBleConnectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_ble_connect, null, false, component);
    }

    public static CustomSelectBleConnectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectBleConnectBinding bind(View view, Object component) {
        return (CustomSelectBleConnectBinding) bind(component, view, R.layout.custom_select_ble_connect);
    }
}
