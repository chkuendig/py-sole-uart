package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;

/* loaded from: classes5.dex */
public abstract class AdapterConnectPageItemBinding extends ViewDataBinding {
    public final MultiLayerBarChartView barChart;
    public final CardView cardView;
    public final ImageView img;
    public final TextView name;
    public final TextView parts;

    protected AdapterConnectPageItemBinding(Object _bindingComponent, View _root, int _localFieldCount, MultiLayerBarChartView barChart, CardView cardView, ImageView img, TextView name, TextView parts) {
        super(_bindingComponent, _root, _localFieldCount);
        this.barChart = barChart;
        this.cardView = cardView;
        this.img = img;
        this.name = name;
        this.parts = parts;
    }

    public static AdapterConnectPageItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectPageItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterConnectPageItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_page_item, root, attachToRoot, component);
    }

    public static AdapterConnectPageItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectPageItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterConnectPageItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_page_item, null, false, component);
    }

    public static AdapterConnectPageItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectPageItemBinding bind(View view, Object component) {
        return (AdapterConnectPageItemBinding) bind(component, view, R.layout.adapter_connect_page_item);
    }
}
