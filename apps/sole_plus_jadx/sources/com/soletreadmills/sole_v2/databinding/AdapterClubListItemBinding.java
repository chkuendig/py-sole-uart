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
public abstract class AdapterClubListItemBinding extends ViewDataBinding {
    public final LinearLayout flexboxLayout;
    public final ImageView imgMain;
    public final CardView imgMainWrap;
    public final ImageView imgRace;
    public final CardView imgRaceWrap;
    public final LinearLayout llMainWrap;
    public final TextView tvDays;
    public final View tvDaysBar;
    public final TextView tvDaysUnit;
    public final TextView tvEquipmentAndDate;
    public final TextView tvMemberCount;
    public final TextView tvRaceMemberCount;
    public final TextView tvTargetVal;
    public final TextView tvTitle;
    public final TextView tvUnit;

    protected AdapterClubListItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout flexboxLayout, ImageView imgMain, CardView imgMainWrap, ImageView imgRace, CardView imgRaceWrap, LinearLayout llMainWrap, TextView tvDays, View tvDaysBar, TextView tvDaysUnit, TextView tvEquipmentAndDate, TextView tvMemberCount, TextView tvRaceMemberCount, TextView tvTargetVal, TextView tvTitle, TextView tvUnit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flexboxLayout = flexboxLayout;
        this.imgMain = imgMain;
        this.imgMainWrap = imgMainWrap;
        this.imgRace = imgRace;
        this.imgRaceWrap = imgRaceWrap;
        this.llMainWrap = llMainWrap;
        this.tvDays = tvDays;
        this.tvDaysBar = tvDaysBar;
        this.tvDaysUnit = tvDaysUnit;
        this.tvEquipmentAndDate = tvEquipmentAndDate;
        this.tvMemberCount = tvMemberCount;
        this.tvRaceMemberCount = tvRaceMemberCount;
        this.tvTargetVal = tvTargetVal;
        this.tvTitle = tvTitle;
        this.tvUnit = tvUnit;
    }

    public static AdapterClubListItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubListItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubListItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_list_item, root, attachToRoot, component);
    }

    public static AdapterClubListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubListItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubListItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_list_item, null, false, component);
    }

    public static AdapterClubListItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubListItemBinding bind(View view, Object component) {
        return (AdapterClubListItemBinding) bind(component, view, R.layout.adapter_club_list_item);
    }
}
