package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterGoalsTopItemBinding extends ViewDataBinding {
    public final LinearLayout LLSetRestTime;
    public final ImageView imageView28;

    protected AdapterGoalsTopItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLSetRestTime, ImageView imageView28) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLSetRestTime = LLSetRestTime;
        this.imageView28 = imageView28;
    }

    public static AdapterGoalsTopItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsTopItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterGoalsTopItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_goals_top_item, root, attachToRoot, component);
    }

    public static AdapterGoalsTopItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsTopItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterGoalsTopItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_goals_top_item, null, false, component);
    }

    public static AdapterGoalsTopItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsTopItemBinding bind(View view, Object component) {
        return (AdapterGoalsTopItemBinding) bind(component, view, R.layout.adapter_goals_top_item);
    }
}
