package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubAllEventsBinding extends ViewDataBinding {
    public final LinearLayout LLDuration;
    public final LinearLayout LLEquipment;
    public final LinearLayout LLFormat;
    public final LinearLayout LLResults;
    public final LinearLayout LLTarget;
    public final ImageView imgBack;
    public final ImageView imgClear;
    public final ImageView imgDuration;
    public final ImageView imgEquipment;
    public final ImageView imgFormat;
    public final ImageView imgSearch;
    public final ImageView imgTarget;
    public final RecyclerView rv;
    public final View statusBarHeight;
    public final ConstraintLayout tobBar;
    public final TextView tvDurationCount;
    public final TextView tvDurationTitle;
    public final TextView tvEquipmentCount;
    public final TextView tvEquipmentTitle;
    public final TextView tvFormatCount;
    public final TextView tvFormatTitle;
    public final TextView tvTargetCount;
    public final TextView tvTargetTitle;
    public final TextView txtFilterCount;
    public final TextView txtResultsCount;

    protected FragmentClubAllEventsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLDuration, LinearLayout LLEquipment, LinearLayout LLFormat, LinearLayout LLResults, LinearLayout LLTarget, ImageView imgBack, ImageView imgClear, ImageView imgDuration, ImageView imgEquipment, ImageView imgFormat, ImageView imgSearch, ImageView imgTarget, RecyclerView rv, View statusBarHeight, ConstraintLayout tobBar, TextView tvDurationCount, TextView tvDurationTitle, TextView tvEquipmentCount, TextView tvEquipmentTitle, TextView tvFormatCount, TextView tvFormatTitle, TextView tvTargetCount, TextView tvTargetTitle, TextView txtFilterCount, TextView txtResultsCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLDuration = LLDuration;
        this.LLEquipment = LLEquipment;
        this.LLFormat = LLFormat;
        this.LLResults = LLResults;
        this.LLTarget = LLTarget;
        this.imgBack = imgBack;
        this.imgClear = imgClear;
        this.imgDuration = imgDuration;
        this.imgEquipment = imgEquipment;
        this.imgFormat = imgFormat;
        this.imgSearch = imgSearch;
        this.imgTarget = imgTarget;
        this.rv = rv;
        this.statusBarHeight = statusBarHeight;
        this.tobBar = tobBar;
        this.tvDurationCount = tvDurationCount;
        this.tvDurationTitle = tvDurationTitle;
        this.tvEquipmentCount = tvEquipmentCount;
        this.tvEquipmentTitle = tvEquipmentTitle;
        this.tvFormatCount = tvFormatCount;
        this.tvFormatTitle = tvFormatTitle;
        this.tvTargetCount = tvTargetCount;
        this.tvTargetTitle = tvTargetTitle;
        this.txtFilterCount = txtFilterCount;
        this.txtResultsCount = txtResultsCount;
    }

    public static FragmentClubAllEventsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubAllEventsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubAllEventsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_all_events, root, attachToRoot, component);
    }

    public static FragmentClubAllEventsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubAllEventsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubAllEventsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_all_events, null, false, component);
    }

    public static FragmentClubAllEventsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubAllEventsBinding bind(View view, Object component) {
        return (FragmentClubAllEventsBinding) bind(component, view, R.layout.fragment_club_all_events);
    }
}
