package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSelectIconBinding extends ViewDataBinding {
    public final LinearLayout LLDone;
    public final TextView cancel;
    public final TextView done;
    public final LinearLayout linearLayout6;
    public final LinearLayout linearLayout7;
    public final RecyclerView recyclerview;
    public final TextView reset;
    public final View statusBarHeight;
    public final TextView title;

    protected FragmentSelectIconBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLDone, TextView cancel, TextView done, LinearLayout linearLayout6, LinearLayout linearLayout7, RecyclerView recyclerview, TextView reset, View statusBarHeight, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLDone = LLDone;
        this.cancel = cancel;
        this.done = done;
        this.linearLayout6 = linearLayout6;
        this.linearLayout7 = linearLayout7;
        this.recyclerview = recyclerview;
        this.reset = reset;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
    }

    public static FragmentSelectIconBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectIconBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSelectIconBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_select_icon, root, attachToRoot, component);
    }

    public static FragmentSelectIconBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectIconBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSelectIconBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_select_icon, null, false, component);
    }

    public static FragmentSelectIconBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectIconBinding bind(View view, Object component) {
        return (FragmentSelectIconBinding) bind(component, view, R.layout.fragment_select_icon);
    }
}
