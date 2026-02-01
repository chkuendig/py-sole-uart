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
public abstract class AdapterConnectPageCategoryItemBinding extends ViewDataBinding {
    public final LinearLayout LL;
    public final ImageView imgFavorite;
    public final TextView title;

    protected AdapterConnectPageCategoryItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LL, ImageView imgFavorite, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LL = LL;
        this.imgFavorite = imgFavorite;
        this.title = title;
    }

    public static AdapterConnectPageCategoryItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectPageCategoryItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterConnectPageCategoryItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_page_category_item, root, attachToRoot, component);
    }

    public static AdapterConnectPageCategoryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectPageCategoryItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterConnectPageCategoryItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_connect_page_category_item, null, false, component);
    }

    public static AdapterConnectPageCategoryItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterConnectPageCategoryItemBinding bind(View view, Object component) {
        return (AdapterConnectPageCategoryItemBinding) bind(component, view, R.layout.adapter_connect_page_category_item);
    }
}
