package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterDisplayDashboardItemBinding extends ViewDataBinding {
    public final View dashedLine;
    public final LinearLayout dragHandle;
    public final ImageView img;
    public final ConstraintLayout mainLayout;
    public final ImageView sortBtn;
    public final TextView unitText;
    public final TextView valueText;

    protected AdapterDisplayDashboardItemBinding(Object _bindingComponent, View _root, int _localFieldCount, View dashedLine, LinearLayout dragHandle, ImageView img, ConstraintLayout mainLayout, ImageView sortBtn, TextView unitText, TextView valueText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dashedLine = dashedLine;
        this.dragHandle = dragHandle;
        this.img = img;
        this.mainLayout = mainLayout;
        this.sortBtn = sortBtn;
        this.unitText = unitText;
        this.valueText = valueText;
    }

    public static AdapterDisplayDashboardItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDisplayDashboardItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterDisplayDashboardItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_display_dashboard_item, root, attachToRoot, component);
    }

    public static AdapterDisplayDashboardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDisplayDashboardItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterDisplayDashboardItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_display_dashboard_item, null, false, component);
    }

    public static AdapterDisplayDashboardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDisplayDashboardItemBinding bind(View view, Object component) {
        return (AdapterDisplayDashboardItemBinding) bind(component, view, R.layout.adapter_display_dashboard_item);
    }
}
