package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomPairingDialogBinding extends ViewDataBinding {
    public final ConstraintLayout CLProgressbar;
    public final LinearLayout LLDisconnect;
    public final LinearLayout LLPairFailed;
    public final LinearLayout LLPairSuccess;
    public final LinearLayout LLPairingProgressbar;
    public final TextView textView4;
    public final TextView tvSuccess;

    protected CustomPairingDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLProgressbar, LinearLayout LLDisconnect, LinearLayout LLPairFailed, LinearLayout LLPairSuccess, LinearLayout LLPairingProgressbar, TextView textView4, TextView tvSuccess) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLProgressbar = CLProgressbar;
        this.LLDisconnect = LLDisconnect;
        this.LLPairFailed = LLPairFailed;
        this.LLPairSuccess = LLPairSuccess;
        this.LLPairingProgressbar = LLPairingProgressbar;
        this.textView4 = textView4;
        this.tvSuccess = tvSuccess;
    }

    public static CustomPairingDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomPairingDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomPairingDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_pairing_dialog, root, attachToRoot, component);
    }

    public static CustomPairingDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomPairingDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomPairingDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_pairing_dialog, null, false, component);
    }

    public static CustomPairingDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomPairingDialogBinding bind(View view, Object component) {
        return (CustomPairingDialogBinding) bind(component, view, R.layout.custom_pairing_dialog);
    }
}
