package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubSearchEventBinding extends ViewDataBinding {
    public final LinearLayout LLEventsEmpty;
    public final ConstraintLayout clSearchWrap;
    public final ImageView clearButton;
    public final AppCompatEditText editEventName;
    public final ImageView imageView30;
    public final ImageView imgCancel;
    public final LinearLayout llTotalCountWrap;
    public final RecyclerView rvSearchList;
    public final View statusBarHeight;
    public final ConstraintLayout tobBar;
    public final TextView tvTotalCount;

    protected FragmentClubSearchEventBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLEventsEmpty, ConstraintLayout clSearchWrap, ImageView clearButton, AppCompatEditText editEventName, ImageView imageView30, ImageView imgCancel, LinearLayout llTotalCountWrap, RecyclerView rvSearchList, View statusBarHeight, ConstraintLayout tobBar, TextView tvTotalCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLEventsEmpty = LLEventsEmpty;
        this.clSearchWrap = clSearchWrap;
        this.clearButton = clearButton;
        this.editEventName = editEventName;
        this.imageView30 = imageView30;
        this.imgCancel = imgCancel;
        this.llTotalCountWrap = llTotalCountWrap;
        this.rvSearchList = rvSearchList;
        this.statusBarHeight = statusBarHeight;
        this.tobBar = tobBar;
        this.tvTotalCount = tvTotalCount;
    }

    public static FragmentClubSearchEventBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubSearchEventBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubSearchEventBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_search_event, root, attachToRoot, component);
    }

    public static FragmentClubSearchEventBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubSearchEventBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubSearchEventBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_search_event, null, false, component);
    }

    public static FragmentClubSearchEventBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubSearchEventBinding bind(View view, Object component) {
        return (FragmentClubSearchEventBinding) bind(component, view, R.layout.fragment_club_search_event);
    }
}
