package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterPickForYouItemBinding extends ViewDataBinding {
    public final CardView cardView;
    public final ImageView img;
    public final ImageView imgFavorite;
    public final TextView min;
    public final TextView parts;
    public final TextView title;

    protected AdapterPickForYouItemBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardView, ImageView img, ImageView imgFavorite, TextView min, TextView parts, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardView = cardView;
        this.img = img;
        this.imgFavorite = imgFavorite;
        this.min = min;
        this.parts = parts;
        this.title = title;
    }

    public static AdapterPickForYouItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPickForYouItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterPickForYouItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_pick_for_you_item, root, attachToRoot, component);
    }

    public static AdapterPickForYouItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPickForYouItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterPickForYouItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_pick_for_you_item, null, false, component);
    }

    public static AdapterPickForYouItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterPickForYouItemBinding bind(View view, Object component) {
        return (AdapterPickForYouItemBinding) bind(component, view, R.layout.adapter_pick_for_you_item);
    }
}
