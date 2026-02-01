package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterDisplayStatsSelectItemBinding extends ViewDataBinding {
    public final ImageView img;
    public final ImageView imgSelect;
    public final LinearLayout layout;
    public final TextView title;

    protected AdapterDisplayStatsSelectItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView img, ImageView imgSelect, LinearLayout layout, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.img = img;
        this.imgSelect = imgSelect;
        this.layout = layout;
        this.title = title;
    }

    public static AdapterDisplayStatsSelectItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDisplayStatsSelectItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterDisplayStatsSelectItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_display_stats_select_item, root, attachToRoot, component);
    }

    public static AdapterDisplayStatsSelectItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDisplayStatsSelectItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterDisplayStatsSelectItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_display_stats_select_item, null, false, component);
    }

    public static AdapterDisplayStatsSelectItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterDisplayStatsSelectItemBinding bind(View view, Object component) {
        return (AdapterDisplayStatsSelectItemBinding) bind(component, view, R.layout.adapter_display_stats_select_item);
    }
}
