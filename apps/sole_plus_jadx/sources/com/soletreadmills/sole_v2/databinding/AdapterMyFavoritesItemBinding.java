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
public abstract class AdapterMyFavoritesItemBinding extends ViewDataBinding {
    public final CardView cardView;
    public final ImageView img;
    public final ImageView imgRemove;
    public final LinearLayout linearLayout11;
    public final TextView parts;
    public final TextView title;

    protected AdapterMyFavoritesItemBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardView, ImageView img, ImageView imgRemove, LinearLayout linearLayout11, TextView parts, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardView = cardView;
        this.img = img;
        this.imgRemove = imgRemove;
        this.linearLayout11 = linearLayout11;
        this.parts = parts;
        this.title = title;
    }

    public static AdapterMyFavoritesItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyFavoritesItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterMyFavoritesItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_my_favorites_item, root, attachToRoot, component);
    }

    public static AdapterMyFavoritesItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyFavoritesItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterMyFavoritesItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_my_favorites_item, null, false, component);
    }

    public static AdapterMyFavoritesItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterMyFavoritesItemBinding bind(View view, Object component) {
        return (AdapterMyFavoritesItemBinding) bind(component, view, R.layout.adapter_my_favorites_item);
    }
}
