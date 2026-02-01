package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomDisplayStatsSelectBinding extends ViewDataBinding {
    public final AppCompatImageView close;
    public final RecyclerView recyclerview;
    public final TextView reset;
    public final TextView title;

    protected CustomDisplayStatsSelectBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView close, RecyclerView recyclerview, TextView reset, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.close = close;
        this.recyclerview = recyclerview;
        this.reset = reset;
        this.title = title;
    }

    public static CustomDisplayStatsSelectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDisplayStatsSelectBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomDisplayStatsSelectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_display_stats_select, root, attachToRoot, component);
    }

    public static CustomDisplayStatsSelectBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDisplayStatsSelectBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomDisplayStatsSelectBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_display_stats_select, null, false, component);
    }

    public static CustomDisplayStatsSelectBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomDisplayStatsSelectBinding bind(View view, Object component) {
        return (CustomDisplayStatsSelectBinding) bind(component, view, R.layout.custom_display_stats_select);
    }
}
