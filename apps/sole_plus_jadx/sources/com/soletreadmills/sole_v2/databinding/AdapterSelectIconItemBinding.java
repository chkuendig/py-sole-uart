package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterSelectIconItemBinding extends ViewDataBinding {
    public final LinearLayout LLHead;
    public final ImageView headImg;
    public final ImageView iconSelect;
    public final ConstraintLayout mainLayout;
    public final View outLine;

    protected AdapterSelectIconItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLHead, ImageView headImg, ImageView iconSelect, ConstraintLayout mainLayout, View outLine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLHead = LLHead;
        this.headImg = headImg;
        this.iconSelect = iconSelect;
        this.mainLayout = mainLayout;
        this.outLine = outLine;
    }

    public static AdapterSelectIconItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectIconItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterSelectIconItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_select_icon_item, root, attachToRoot, component);
    }

    public static AdapterSelectIconItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectIconItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterSelectIconItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_select_icon_item, null, false, component);
    }

    public static AdapterSelectIconItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterSelectIconItemBinding bind(View view, Object component) {
        return (AdapterSelectIconItemBinding) bind(component, view, R.layout.adapter_select_icon_item);
    }
}
