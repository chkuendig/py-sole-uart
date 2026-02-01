package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomHistoryWorkoutItemBinding extends ViewDataBinding {
    public final TextView title;
    public final TextView unit;
    public final TextView value;

    protected CustomHistoryWorkoutItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView title, TextView unit, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.title = title;
        this.unit = unit;
        this.value = value;
    }

    public static CustomHistoryWorkoutItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomHistoryWorkoutItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomHistoryWorkoutItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_history_workout_item, root, attachToRoot, component);
    }

    public static CustomHistoryWorkoutItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomHistoryWorkoutItemBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomHistoryWorkoutItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_history_workout_item, null, false, component);
    }

    public static CustomHistoryWorkoutItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomHistoryWorkoutItemBinding bind(View view, Object component) {
        return (CustomHistoryWorkoutItemBinding) bind(component, view, R.layout.custom_history_workout_item);
    }
}
