package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSubscriptionBluetoothBinding extends ViewDataBinding {
    public final ConstraintLayout CLAdd;
    public final ImageView back;
    public final ConstraintLayout bleDevice;
    public final TextView classTypeName;
    public final AppCompatTextView iLostMyNumber;
    public final ImageView imageView12;
    public final ImageView imgCamera;
    public final EditText serialNumber;
    public final View statusBarHeight;
    public final Button submit;
    public final LinearLayout tobBar;
    public final TextView useSerialNumber;
    public final LinearLayout viaBleLayout;
    public final LinearLayout viaSnLayout;

    protected FragmentSubscriptionBluetoothBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLAdd, ImageView back, ConstraintLayout bleDevice, TextView classTypeName, AppCompatTextView iLostMyNumber, ImageView imageView12, ImageView imgCamera, EditText serialNumber, View statusBarHeight, Button submit, LinearLayout tobBar, TextView useSerialNumber, LinearLayout viaBleLayout, LinearLayout viaSnLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLAdd = CLAdd;
        this.back = back;
        this.bleDevice = bleDevice;
        this.classTypeName = classTypeName;
        this.iLostMyNumber = iLostMyNumber;
        this.imageView12 = imageView12;
        this.imgCamera = imgCamera;
        this.serialNumber = serialNumber;
        this.statusBarHeight = statusBarHeight;
        this.submit = submit;
        this.tobBar = tobBar;
        this.useSerialNumber = useSerialNumber;
        this.viaBleLayout = viaBleLayout;
        this.viaSnLayout = viaSnLayout;
    }

    public static FragmentSubscriptionBluetoothBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionBluetoothBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSubscriptionBluetoothBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_subscription_bluetooth, root, attachToRoot, component);
    }

    public static FragmentSubscriptionBluetoothBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionBluetoothBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSubscriptionBluetoothBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_subscription_bluetooth, null, false, component);
    }

    public static FragmentSubscriptionBluetoothBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSubscriptionBluetoothBinding bind(View view, Object component) {
        return (FragmentSubscriptionBluetoothBinding) bind(component, view, R.layout.fragment_subscription_bluetooth);
    }
}
