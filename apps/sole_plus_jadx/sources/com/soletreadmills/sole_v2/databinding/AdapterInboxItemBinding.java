package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterInboxItemBinding extends ViewDataBinding {
    public final LinearLayout LLFilterResultView;
    public final LinearLayout LLNew;
    public final CardView cardView;
    public final ImageView img;
    public final ImageView imgDeleteFilter;
    public final View line;
    public final TextView tvDate;
    public final TextView tvDec;
    public final TextView tvNew;
    public final TextView tvTitle;

    protected AdapterInboxItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLFilterResultView, LinearLayout LLNew, CardView cardView, ImageView img, ImageView imgDeleteFilter, View line, TextView tvDate, TextView tvDec, TextView tvNew, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLFilterResultView = LLFilterResultView;
        this.LLNew = LLNew;
        this.cardView = cardView;
        this.img = img;
        this.imgDeleteFilter = imgDeleteFilter;
        this.line = line;
        this.tvDate = tvDate;
        this.tvDec = tvDec;
        this.tvNew = tvNew;
        this.tvTitle = tvTitle;
    }

    public static AdapterInboxItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterInboxItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterInboxItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_inbox_item, root, attachToRoot, component);
    }

    public static AdapterInboxItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterInboxItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterInboxItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_inbox_item, null, false, component);
    }

    public static AdapterInboxItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterInboxItemBinding bind(View view, Object component) {
        return (AdapterInboxItemBinding) bind(component, view, R.layout.adapter_inbox_item);
    }
}
