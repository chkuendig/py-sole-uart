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
public abstract class FragmentClubMainBinding extends ViewDataBinding {
    public final LinearLayout LLVirtualRaces;
    public final ImageView imgRankingsMoreBtn;
    public final ImageView imgSearch;
    public final ImageView imgShareGoalsMoreBtn;
    public final ImageView imgVirtuslRacesMoreBtn;
    public final LinearLayout llCreateEvent;
    public final LinearLayout llJoinById;
    public final LinearLayout llMyEvents;
    public final LinearLayout llOngoingWrap;
    public final LinearLayout llRankingsWrap;
    public final LinearLayout llSharedGoalsWrap;
    public final LinearLayout llUpcomingWrap;
    public final LinearLayout llVirtualRaceWrap;
    public final RecyclerView recyclerViewOngoingItems;
    public final RecyclerView recyclerViewRankingItems;
    public final RecyclerView recyclerViewUpcomingItems;
    public final RecyclerView recyclerViewVirtualRaceItems;
    public final RecyclerView recyclerViewsharedGoalItems;
    public final NestedScrollView scrollView;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefresh;
    public final TextView title;
    public final ConstraintLayout tobBar;
    public final TextView tvAllEvent;

    protected FragmentClubMainBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLVirtualRaces, ImageView imgRankingsMoreBtn, ImageView imgSearch, ImageView imgShareGoalsMoreBtn, ImageView imgVirtuslRacesMoreBtn, LinearLayout llCreateEvent, LinearLayout llJoinById, LinearLayout llMyEvents, LinearLayout llOngoingWrap, LinearLayout llRankingsWrap, LinearLayout llSharedGoalsWrap, LinearLayout llUpcomingWrap, LinearLayout llVirtualRaceWrap, RecyclerView recyclerViewOngoingItems, RecyclerView recyclerViewRankingItems, RecyclerView recyclerViewUpcomingItems, RecyclerView recyclerViewVirtualRaceItems, RecyclerView recyclerViewsharedGoalItems, NestedScrollView scrollView, View statusBarHeight, SwipeRefreshLayout swipeRefresh, TextView title, ConstraintLayout tobBar, TextView tvAllEvent) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLVirtualRaces = LLVirtualRaces;
        this.imgRankingsMoreBtn = imgRankingsMoreBtn;
        this.imgSearch = imgSearch;
        this.imgShareGoalsMoreBtn = imgShareGoalsMoreBtn;
        this.imgVirtuslRacesMoreBtn = imgVirtuslRacesMoreBtn;
        this.llCreateEvent = llCreateEvent;
        this.llJoinById = llJoinById;
        this.llMyEvents = llMyEvents;
        this.llOngoingWrap = llOngoingWrap;
        this.llRankingsWrap = llRankingsWrap;
        this.llSharedGoalsWrap = llSharedGoalsWrap;
        this.llUpcomingWrap = llUpcomingWrap;
        this.llVirtualRaceWrap = llVirtualRaceWrap;
        this.recyclerViewOngoingItems = recyclerViewOngoingItems;
        this.recyclerViewRankingItems = recyclerViewRankingItems;
        this.recyclerViewUpcomingItems = recyclerViewUpcomingItems;
        this.recyclerViewVirtualRaceItems = recyclerViewVirtualRaceItems;
        this.recyclerViewsharedGoalItems = recyclerViewsharedGoalItems;
        this.scrollView = scrollView;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefresh = swipeRefresh;
        this.title = title;
        this.tobBar = tobBar;
        this.tvAllEvent = tvAllEvent;
    }

    public static FragmentClubMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_main, root, attachToRoot, component);
    }

    public static FragmentClubMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_main, null, false, component);
    }

    public static FragmentClubMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMainBinding bind(View view, Object component) {
        return (FragmentClubMainBinding) bind(component, view, R.layout.fragment_club_main);
    }
}
