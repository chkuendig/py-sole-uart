package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomSelectFocusBinding extends ViewDataBinding {
    public final LinearLayout LLDone;
    public final AppCompatImageView close;
    public final TextView done;
    public final TextView reset;
    public final RecyclerView rv;
    public final TextView title;

    protected CustomSelectFocusBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLDone, AppCompatImageView close, TextView done, TextView reset, RecyclerView rv, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLDone = LLDone;
        this.close = close;
        this.done = done;
        this.reset = reset;
        this.rv = rv;
        this.title = title;
    }

    public static CustomSelectFocusBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectFocusBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSelectFocusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_focus, root, attachToRoot, component);
    }

    public static CustomSelectFocusBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectFocusBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSelectFocusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_focus, null, false, component);
    }

    public static CustomSelectFocusBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectFocusBinding bind(View view, Object component) {
        return (CustomSelectFocusBinding) bind(component, view, R.layout.custom_select_focus);
    }
}
