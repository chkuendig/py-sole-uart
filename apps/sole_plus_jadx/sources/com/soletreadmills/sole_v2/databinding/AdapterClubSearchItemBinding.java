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
public abstract class AdapterClubSearchItemBinding extends ViewDataBinding {
    public final ImageView imgDeleteBtn;
    public final ImageView imgMainImg;
    public final ImageView imgQuitBtn;
    public final LinearLayout llCardWrap;
    public final LinearLayout llMainWrap;
    public final TextView tvDayUnit;
    public final TextView tvDays;
    public final TextView tvStartDate;
    public final TextView tvTargetVal;
    public final TextView tvTitle;
    public final TextView tvUnit;

    protected AdapterClubSearchItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgDeleteBtn, ImageView imgMainImg, ImageView imgQuitBtn, LinearLayout llCardWrap, LinearLayout llMainWrap, TextView tvDayUnit, TextView tvDays, TextView tvStartDate, TextView tvTargetVal, TextView tvTitle, TextView tvUnit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgDeleteBtn = imgDeleteBtn;
        this.imgMainImg = imgMainImg;
        this.imgQuitBtn = imgQuitBtn;
        this.llCardWrap = llCardWrap;
        this.llMainWrap = llMainWrap;
        this.tvDayUnit = tvDayUnit;
        this.tvDays = tvDays;
        this.tvStartDate = tvStartDate;
        this.tvTargetVal = tvTargetVal;
        this.tvTitle = tvTitle;
        this.tvUnit = tvUnit;
    }

    public static AdapterClubSearchItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubSearchItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubSearchItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_search_item, root, attachToRoot, component);
    }

    public static AdapterClubSearchItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubSearchItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubSearchItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_search_item, null, false, component);
    }

    public static AdapterClubSearchItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubSearchItemBinding bind(View view, Object component) {
        return (AdapterClubSearchItemBinding) bind(component, view, R.layout.adapter_club_search_item);
    }
}
