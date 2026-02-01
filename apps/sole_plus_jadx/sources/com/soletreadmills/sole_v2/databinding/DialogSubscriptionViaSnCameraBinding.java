package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.view.PreviewView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class DialogSubscriptionViaSnCameraBinding extends ViewDataBinding {
    public final AppCompatImageView close;
    public final PreviewView previewView;
    public final View redLineBox;
    public final AppCompatImageView scanning;

    protected DialogSubscriptionViaSnCameraBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView close, PreviewView previewView, View redLineBox, AppCompatImageView scanning) {
        super(_bindingComponent, _root, _localFieldCount);
        this.close = close;
        this.previewView = previewView;
        this.redLineBox = redLineBox;
        this.scanning = scanning;
    }

    public static DialogSubscriptionViaSnCameraBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubscriptionViaSnCameraBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogSubscriptionViaSnCameraBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_subscription_via_sn_camera, root, attachToRoot, component);
    }

    public static DialogSubscriptionViaSnCameraBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubscriptionViaSnCameraBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogSubscriptionViaSnCameraBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_subscription_via_sn_camera, null, false, component);
    }

    public static DialogSubscriptionViaSnCameraBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSubscriptionViaSnCameraBinding bind(View view, Object component) {
        return (DialogSubscriptionViaSnCameraBinding) bind(component, view, R.layout.dialog_subscription_via_sn_camera);
    }
}
