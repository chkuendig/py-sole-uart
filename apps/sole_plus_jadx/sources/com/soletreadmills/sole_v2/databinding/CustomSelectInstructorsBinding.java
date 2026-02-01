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
public abstract class CustomSelectInstructorsBinding extends ViewDataBinding {
    public final LinearLayout LLDone;
    public final AppCompatImageView close;
    public final TextView done;
    public final LinearLayout linearLayout6;
    public final LinearLayout linearLayout7;
    public final RecyclerView recyclerview;
    public final TextView reset;
    public final View statusBarHeight;
    public final TextView title;

    protected CustomSelectInstructorsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLDone, AppCompatImageView close, TextView done, LinearLayout linearLayout6, LinearLayout linearLayout7, RecyclerView recyclerview, TextView reset, View statusBarHeight, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLDone = LLDone;
        this.close = close;
        this.done = done;
        this.linearLayout6 = linearLayout6;
        this.linearLayout7 = linearLayout7;
        this.recyclerview = recyclerview;
        this.reset = reset;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
    }

    public static CustomSelectInstructorsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectInstructorsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSelectInstructorsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_instructors, root, attachToRoot, component);
    }

    public static CustomSelectInstructorsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectInstructorsBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSelectInstructorsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_instructors, null, false, component);
    }

    public static CustomSelectInstructorsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectInstructorsBinding bind(View view, Object component) {
        return (CustomSelectInstructorsBinding) bind(component, view, R.layout.custom_select_instructors);
    }
}
