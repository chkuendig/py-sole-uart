package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.slider.Slider;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterConnectEditProgramItemBinding extends ViewDataBinding {
    public final TextView number;
    public final Slider seekBar;
    public final TextView value;

    protected AdapterConnectEditProgramItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView number, Slider seekBar, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.number = number;
        this.seekBar = seekBar;
        this.value = value;
    }

    public static AdapterConnectEditProgramItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectEditProgramItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterConnectEditProgramItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_edit_program_item, root, attachToRoot, component);
    }

    public static AdapterConnectEditProgramItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectEditProgramItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterConnectEditProgramItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_edit_program_item, null, false, component);
    }

    public static AdapterConnectEditProgramItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectEditProgramItemBinding bind(View view, Object component) {
        return (AdapterConnectEditProgramItemBinding) bind(component, view, R.layout.adapter_connect_edit_program_item);
    }
}
