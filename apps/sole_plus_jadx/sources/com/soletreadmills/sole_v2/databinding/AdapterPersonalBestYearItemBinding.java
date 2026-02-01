package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterPersonalBestYearItemBinding extends ViewDataBinding {
    public final ConstraintLayout CL;
    public final TextView tvValue;

    protected AdapterPersonalBestYearItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CL, TextView tvValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CL = CL;
        this.tvValue = tvValue;
    }

    public static AdapterPersonalBestYearItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPersonalBestYearItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterPersonalBestYearItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_personal_best_year_item, root, attachToRoot, component);
    }

    public static AdapterPersonalBestYearItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPersonalBestYearItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterPersonalBestYearItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_personal_best_year_item, null, false, component);
    }

    public static AdapterPersonalBestYearItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPersonalBestYearItemBinding bind(View view, Object component) {
        return (AdapterPersonalBestYearItemBinding) bind(component, view, R.layout.adapter_personal_best_year_item);
    }
}
