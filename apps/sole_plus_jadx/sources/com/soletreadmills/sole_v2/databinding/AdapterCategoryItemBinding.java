package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterCategoryItemBinding extends ViewDataBinding {
    public final LinearLayout LL;
    public final ImageView imgArrow;
    public final ImageView imgFavorite;
    public final TextView selectCount;
    public final TextView title;

    protected AdapterCategoryItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LL, ImageView imgArrow, ImageView imgFavorite, TextView selectCount, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LL = LL;
        this.imgArrow = imgArrow;
        this.imgFavorite = imgFavorite;
        this.selectCount = selectCount;
        this.title = title;
    }

    public static AdapterCategoryItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterCategoryItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterCategoryItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_category_item, root, attachToRoot, component);
    }

    public static AdapterCategoryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterCategoryItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterCategoryItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_category_item, null, false, component);
    }

    public static AdapterCategoryItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterCategoryItemBinding bind(View view, Object component) {
        return (AdapterCategoryItemBinding) bind(component, view, R.layout.adapter_category_item);
    }
}
