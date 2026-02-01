package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.CustomSliderView;

/* loaded from: classes5.dex */
public abstract class CustomProgramSliderviewBinding extends ViewDataBinding {
    public final CustomSliderView customSlider;
    public final TextView name;
    public final TextView unit;
    public final TextView value;

    protected CustomProgramSliderviewBinding(Object _bindingComponent, View _root, int _localFieldCount, CustomSliderView customSlider, TextView name, TextView unit, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.customSlider = customSlider;
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public static CustomProgramSliderviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomProgramSliderviewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomProgramSliderviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_program_sliderview, root, attachToRoot, component);
    }

    public static CustomProgramSliderviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomProgramSliderviewBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomProgramSliderviewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_program_sliderview, null, false, component);
    }

    public static CustomProgramSliderviewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomProgramSliderviewBinding bind(View view, Object component) {
        return (CustomProgramSliderviewBinding) bind(component, view, R.layout.custom_program_sliderview);
    }
}
