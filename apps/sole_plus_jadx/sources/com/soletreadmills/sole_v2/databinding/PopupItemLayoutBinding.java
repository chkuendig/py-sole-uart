package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class PopupItemLayoutBinding extends ViewDataBinding {
    public final ImageView imgIcon;
    public final TextView tvText;

    protected PopupItemLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgIcon, TextView tvText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgIcon = imgIcon;
        this.tvText = tvText;
    }

    public static PopupItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PopupItemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.popup_item_layout, root, attachToRoot, component);
    }

    public static PopupItemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupItemLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (PopupItemLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.popup_item_layout, null, false, component);
    }

    public static PopupItemLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupItemLayoutBinding bind(View view, Object component) {
        return (PopupItemLayoutBinding) bind(component, view, R.layout.popup_item_layout);
    }
}
