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
public abstract class AdapterHistoryItemBinding extends ViewDataBinding {
    public final LinearLayout LLHistory;
    public final LinearLayout LLImg;
    public final CardView cardImg;
    public final TextView date;
    public final ImageView img;
    public final ImageView imgArrow;
    public final ImageView imgPersonalBest;
    public final ImageView imgRemove;
    public final ImageView imgSpace;
    public final TextView name;
    public final TextView sportsParts;
    public final TextView value;

    protected AdapterHistoryItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLHistory, LinearLayout LLImg, CardView cardImg, TextView date, ImageView img, ImageView imgArrow, ImageView imgPersonalBest, ImageView imgRemove, ImageView imgSpace, TextView name, TextView sportsParts, TextView value) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLHistory = LLHistory;
        this.LLImg = LLImg;
        this.cardImg = cardImg;
        this.date = date;
        this.img = img;
        this.imgArrow = imgArrow;
        this.imgPersonalBest = imgPersonalBest;
        this.imgRemove = imgRemove;
        this.imgSpace = imgSpace;
        this.name = name;
        this.sportsParts = sportsParts;
        this.value = value;
    }

    public static AdapterHistoryItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterHistoryItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_item, root, attachToRoot, component);
    }

    public static AdapterHistoryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterHistoryItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_history_item, null, false, component);
    }

    public static AdapterHistoryItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHistoryItemBinding bind(View view, Object component) {
        return (AdapterHistoryItemBinding) bind(component, view, R.layout.adapter_history_item);
    }
}
