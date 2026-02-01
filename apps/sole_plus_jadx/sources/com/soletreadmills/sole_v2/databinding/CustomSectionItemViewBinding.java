package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomSectionItemViewBinding extends ViewDataBinding {
    public final ImageView ivArrow;
    public final RecyclerView rvSectionContent;
    public final TextView tvSectionSubtitle;
    public final TextView tvSectionTitle;

    protected CustomSectionItemViewBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivArrow, RecyclerView rvSectionContent, TextView tvSectionSubtitle, TextView tvSectionTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivArrow = ivArrow;
        this.rvSectionContent = rvSectionContent;
        this.tvSectionSubtitle = tvSectionSubtitle;
        this.tvSectionTitle = tvSectionTitle;
    }

    public static CustomSectionItemViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSectionItemViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSectionItemViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_section_item_view, root, attachToRoot, component);
    }

    public static CustomSectionItemViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSectionItemViewBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSectionItemViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_section_item_view, null, false, component);
    }

    public static CustomSectionItemViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSectionItemViewBinding bind(View view, Object component) {
        return (CustomSectionItemViewBinding) bind(component, view, R.layout.custom_section_item_view);
    }
}
