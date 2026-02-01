package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterHistoryWorkoutItemBinding extends ViewDataBinding {
    public final TextView txtPace;
    public final TextView txtTitle;
    public final View view5;

    protected AdapterHistoryWorkoutItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView txtPace, TextView txtTitle, View view5) {
        super(_bindingComponent, _root, _localFieldCount);
        this.txtPace = txtPace;
        this.txtTitle = txtTitle;
        this.view5 = view5;
    }

    public static AdapterHistoryWorkoutItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryWorkoutItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterHistoryWorkoutItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_workout_item, root, attachToRoot, component);
    }

    public static AdapterHistoryWorkoutItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryWorkoutItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterHistoryWorkoutItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_workout_item, null, false, component);
    }

    public static AdapterHistoryWorkoutItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryWorkoutItemBinding bind(View view, Object component) {
        return (AdapterHistoryWorkoutItemBinding) bind(component, view, R.layout.adapter_history_workout_item);
    }
}
