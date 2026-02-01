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
public abstract class CustomSelectLanguageBinding extends ViewDataBinding {
    public final LinearLayout LLDone;
    public final AppCompatImageView close;
    public final TextView done;
    public final RecyclerView recyclerview;
    public final TextView reset;
    public final TextView title;

    protected CustomSelectLanguageBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLDone, AppCompatImageView close, TextView done, RecyclerView recyclerview, TextView reset, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLDone = LLDone;
        this.close = close;
        this.done = done;
        this.recyclerview = recyclerview;
        this.reset = reset;
        this.title = title;
    }

    public static CustomSelectLanguageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectLanguageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSelectLanguageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_language, root, attachToRoot, component);
    }

    public static CustomSelectLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectLanguageBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSelectLanguageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_language, null, false, component);
    }

    public static CustomSelectLanguageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectLanguageBinding bind(View view, Object component) {
        return (CustomSelectLanguageBinding) bind(component, view, R.layout.custom_select_language);
    }
}
