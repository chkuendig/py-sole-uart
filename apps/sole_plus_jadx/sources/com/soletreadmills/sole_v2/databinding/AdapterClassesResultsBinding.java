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
public abstract class AdapterClassesResultsBinding extends ViewDataBinding {
    public final LinearLayout LLFilterResultView;
    public final ImageView imgDeleteFilter;
    public final TextView txtFilterCount;
    public final TextView txtResultsCount;

    protected AdapterClassesResultsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLFilterResultView, ImageView imgDeleteFilter, TextView txtFilterCount, TextView txtResultsCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLFilterResultView = LLFilterResultView;
        this.imgDeleteFilter = imgDeleteFilter;
        this.txtFilterCount = txtFilterCount;
        this.txtResultsCount = txtResultsCount;
    }

    public static AdapterClassesResultsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesResultsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClassesResultsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_classes_results, root, attachToRoot, component);
    }

    public static AdapterClassesResultsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesResultsBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClassesResultsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_classes_results, null, false, component);
    }

    public static AdapterClassesResultsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesResultsBinding bind(View view, Object component) {
        return (AdapterClassesResultsBinding) bind(component, view, R.layout.adapter_classes_results);
    }
}
