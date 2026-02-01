package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class ViewDisplayDashboardItemBinding extends ViewDataBinding {
    public final ImageView img;
    public final ConstraintLayout mainLayout;
    public final ImageView sortBtn;
    public final TextView unitText;
    public final TextView valueText;

    protected ViewDisplayDashboardItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView img, ConstraintLayout mainLayout, ImageView sortBtn, TextView unitText, TextView valueText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.img = img;
        this.mainLayout = mainLayout;
        this.sortBtn = sortBtn;
        this.unitText = unitText;
        this.valueText = valueText;
    }

    public static ViewDisplayDashboardItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDisplayDashboardItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ViewDisplayDashboardItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_display_dashboard_item, root, attachToRoot, component);
    }

    public static ViewDisplayDashboardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDisplayDashboardItemBinding inflate(LayoutInflater inflater, Object component) {
        return (ViewDisplayDashboardItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.view_display_dashboard_item, null, false, component);
    }

    public static ViewDisplayDashboardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDisplayDashboardItemBinding bind(View view, Object component) {
        return (ViewDisplayDashboardItemBinding) bind(component, view, R.layout.view_display_dashboard_item);
    }
}
