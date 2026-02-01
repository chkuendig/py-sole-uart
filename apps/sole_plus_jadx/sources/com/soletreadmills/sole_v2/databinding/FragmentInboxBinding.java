package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentInboxBinding extends ViewDataBinding {
    public final LinearLayout LLHasData;
    public final LinearLayout LLInboxEmpty;
    public final LinearLayout LLMarkAllRead;
    public final LinearLayout LLUnread;
    public final ImageView back;
    public final ImageView imgEmpty;
    public final LinearLayout linearLayout9;
    public final RecyclerView rv;
    public final View statusBarHeight;
    public final TextView textView3;
    public final TextView textView8;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvEmpty;
    public final TextView tvResetFilters;
    public final TextView tvUnReadCount;

    protected FragmentInboxBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLHasData, LinearLayout LLInboxEmpty, LinearLayout LLMarkAllRead, LinearLayout LLUnread, ImageView back, ImageView imgEmpty, LinearLayout linearLayout9, RecyclerView rv, View statusBarHeight, TextView textView3, TextView textView8, TextView title, ConstraintLayout topbar, TextView tvEmpty, TextView tvResetFilters, TextView tvUnReadCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLHasData = LLHasData;
        this.LLInboxEmpty = LLInboxEmpty;
        this.LLMarkAllRead = LLMarkAllRead;
        this.LLUnread = LLUnread;
        this.back = back;
        this.imgEmpty = imgEmpty;
        this.linearLayout9 = linearLayout9;
        this.rv = rv;
        this.statusBarHeight = statusBarHeight;
        this.textView3 = textView3;
        this.textView8 = textView8;
        this.title = title;
        this.topbar = topbar;
        this.tvEmpty = tvEmpty;
        this.tvResetFilters = tvResetFilters;
        this.tvUnReadCount = tvUnReadCount;
    }

    public static FragmentInboxBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInboxBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentInboxBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_inbox, root, attachToRoot, component);
    }

    public static FragmentInboxBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInboxBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentInboxBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_inbox, null, false, component);
    }

    public static FragmentInboxBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInboxBinding bind(View view, Object component) {
        return (FragmentInboxBinding) bind(component, view, R.layout.fragment_inbox);
    }
}
