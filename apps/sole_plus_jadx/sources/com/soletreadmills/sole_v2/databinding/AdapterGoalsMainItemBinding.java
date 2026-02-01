package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterGoalsMainItemBinding extends ViewDataBinding {
    public final ImageView imageView12;
    public final ImageView imgRemove;
    public final LinearLayout layoutAdd;
    public final PieChart pieChart;

    protected AdapterGoalsMainItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageView12, ImageView imgRemove, LinearLayout layoutAdd, PieChart pieChart) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageView12 = imageView12;
        this.imgRemove = imgRemove;
        this.layoutAdd = layoutAdd;
        this.pieChart = pieChart;
    }

    public static AdapterGoalsMainItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsMainItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterGoalsMainItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_goals_main_item, root, attachToRoot, component);
    }

    public static AdapterGoalsMainItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsMainItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterGoalsMainItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_goals_main_item, null, false, component);
    }

    public static AdapterGoalsMainItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsMainItemBinding bind(View view, Object component) {
        return (AdapterGoalsMainItemBinding) bind(component, view, R.layout.adapter_goals_main_item);
    }
}
