package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubMyEventsBinding extends ViewDataBinding {
    public final TextView archiveTotalCount;
    public final ImageView imgBack;
    public final LinearLayout llArchiveWrap;
    public final LinearLayout llOngoingWrap;
    public final LinearLayout llTopbarTextContent;
    public final LinearLayout llUpcomingWrap;
    public final TextView ongoingTotalCount;
    public final RecyclerView recyclerViewArchiveItems;
    public final RecyclerView recyclerViewOngoingItems;
    public final RecyclerView recyclerViewUpcomingItems;
    public final NestedScrollView scrollView;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefresh;
    public final ConstraintLayout tobBar2;
    public final LinearLayout tvAllBtn;
    public final TextView tvAllBtnText;
    public final LinearLayout tvCreatedByMeBtn;
    public final TextView tvCreatedByMeBtnText;
    public final TextView tvEditBtn;
    public final TextView tvEditDoneBtn;
    public final TextView tvStickyCount;
    public final TextView tvStyckyTitle;
    public final TextView tvTopBarTitle;
    public final View underlineAll;
    public final View underlineCreatedByMe;
    public final TextView upcomingTotalCount;

    protected FragmentClubMyEventsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView archiveTotalCount, ImageView imgBack, LinearLayout llArchiveWrap, LinearLayout llOngoingWrap, LinearLayout llTopbarTextContent, LinearLayout llUpcomingWrap, TextView ongoingTotalCount, RecyclerView recyclerViewArchiveItems, RecyclerView recyclerViewOngoingItems, RecyclerView recyclerViewUpcomingItems, NestedScrollView scrollView, View statusBarHeight, SwipeRefreshLayout swipeRefresh, ConstraintLayout tobBar2, LinearLayout tvAllBtn, TextView tvAllBtnText, LinearLayout tvCreatedByMeBtn, TextView tvCreatedByMeBtnText, TextView tvEditBtn, TextView tvEditDoneBtn, TextView tvStickyCount, TextView tvStyckyTitle, TextView tvTopBarTitle, View underlineAll, View underlineCreatedByMe, TextView upcomingTotalCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.archiveTotalCount = archiveTotalCount;
        this.imgBack = imgBack;
        this.llArchiveWrap = llArchiveWrap;
        this.llOngoingWrap = llOngoingWrap;
        this.llTopbarTextContent = llTopbarTextContent;
        this.llUpcomingWrap = llUpcomingWrap;
        this.ongoingTotalCount = ongoingTotalCount;
        this.recyclerViewArchiveItems = recyclerViewArchiveItems;
        this.recyclerViewOngoingItems = recyclerViewOngoingItems;
        this.recyclerViewUpcomingItems = recyclerViewUpcomingItems;
        this.scrollView = scrollView;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefresh = swipeRefresh;
        this.tobBar2 = tobBar2;
        this.tvAllBtn = tvAllBtn;
        this.tvAllBtnText = tvAllBtnText;
        this.tvCreatedByMeBtn = tvCreatedByMeBtn;
        this.tvCreatedByMeBtnText = tvCreatedByMeBtnText;
        this.tvEditBtn = tvEditBtn;
        this.tvEditDoneBtn = tvEditDoneBtn;
        this.tvStickyCount = tvStickyCount;
        this.tvStyckyTitle = tvStyckyTitle;
        this.tvTopBarTitle = tvTopBarTitle;
        this.underlineAll = underlineAll;
        this.underlineCreatedByMe = underlineCreatedByMe;
        this.upcomingTotalCount = upcomingTotalCount;
    }

    public static FragmentClubMyEventsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMyEventsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubMyEventsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_my_events, root, attachToRoot, component);
    }

    public static FragmentClubMyEventsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMyEventsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubMyEventsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_my_events, null, false, component);
    }

    public static FragmentClubMyEventsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMyEventsBinding bind(View view, Object component) {
        return (FragmentClubMyEventsBinding) bind(component, view, R.layout.fragment_club_my_events);
    }
}
