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
public abstract class AdapterPayWallItemBinding extends ViewDataBinding {
    public final LinearLayout LL;
    public final AppCompatImageView imgCheck;
    public final TextView tvDes;
    public final TextView tvFee;
    public final TextView tvTitle;

    protected AdapterPayWallItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LL, AppCompatImageView imgCheck, TextView tvDes, TextView tvFee, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LL = LL;
        this.imgCheck = imgCheck;
        this.tvDes = tvDes;
        this.tvFee = tvFee;
        this.tvTitle = tvTitle;
    }

    public static AdapterPayWallItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPayWallItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterPayWallItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_pay_wall_item, root, attachToRoot, component);
    }

    public static AdapterPayWallItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPayWallItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterPayWallItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_pay_wall_item, null, false, component);
    }

    public static AdapterPayWallItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPayWallItemBinding bind(View view, Object component) {
        return (AdapterPayWallItemBinding) bind(component, view, R.layout.adapter_pay_wall_item);
    }
}
