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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubScoreboardListBinding extends ViewDataBinding {
    public final LinearLayout clSearch;
    public final ConstraintLayout clSearchWrap;
    public final ImageView clearButton;
    public final AppCompatEditText editEventName;
    public final ImageView imgBtnCreatorCancelEdit;
    public final ImageView imgBtnGoPrev;
    public final RecyclerView rvAllList;
    public final RecyclerView rvTargetReached;
    public final RecyclerView rvWorkInProgress;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefresh;
    public final ConstraintLayout tobBar;
    public final LinearLayout tvAllWrap;
    public final TextView tvBtnCreatorDoneEdit;
    public final TextView tvBtnCreatorEdit;
    public final TextView tvRaceCountDownTimer;
    public final LinearLayout tvRaceCountDownTimerWrap;
    public final TextView tvTargetReachedTitle;
    public final LinearLayout tvTargetReachedWrap;
    public final LinearLayout tvWorkInProgressWrap;

    protected FragmentClubScoreboardListBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout clSearch, ConstraintLayout clSearchWrap, ImageView clearButton, AppCompatEditText editEventName, ImageView imgBtnCreatorCancelEdit, ImageView imgBtnGoPrev, RecyclerView rvAllList, RecyclerView rvTargetReached, RecyclerView rvWorkInProgress, View statusBarHeight, SwipeRefreshLayout swipeRefresh, ConstraintLayout tobBar, LinearLayout tvAllWrap, TextView tvBtnCreatorDoneEdit, TextView tvBtnCreatorEdit, TextView tvRaceCountDownTimer, LinearLayout tvRaceCountDownTimerWrap, TextView tvTargetReachedTitle, LinearLayout tvTargetReachedWrap, LinearLayout tvWorkInProgressWrap) {
        super(_bindingComponent, _root, _localFieldCount);
        this.clSearch = clSearch;
        this.clSearchWrap = clSearchWrap;
        this.clearButton = clearButton;
        this.editEventName = editEventName;
        this.imgBtnCreatorCancelEdit = imgBtnCreatorCancelEdit;
        this.imgBtnGoPrev = imgBtnGoPrev;
        this.rvAllList = rvAllList;
        this.rvTargetReached = rvTargetReached;
        this.rvWorkInProgress = rvWorkInProgress;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefresh = swipeRefresh;
        this.tobBar = tobBar;
        this.tvAllWrap = tvAllWrap;
        this.tvBtnCreatorDoneEdit = tvBtnCreatorDoneEdit;
        this.tvBtnCreatorEdit = tvBtnCreatorEdit;
        this.tvRaceCountDownTimer = tvRaceCountDownTimer;
        this.tvRaceCountDownTimerWrap = tvRaceCountDownTimerWrap;
        this.tvTargetReachedTitle = tvTargetReachedTitle;
        this.tvTargetReachedWrap = tvTargetReachedWrap;
        this.tvWorkInProgressWrap = tvWorkInProgressWrap;
    }

    public static FragmentClubScoreboardListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubScoreboardListBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubScoreboardListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_scoreboard_list, root, attachToRoot, component);
    }

    public static FragmentClubScoreboardListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubScoreboardListBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubScoreboardListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_scoreboard_list, null, false, component);
    }

    public static FragmentClubScoreboardListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubScoreboardListBinding bind(View view, Object component) {
        return (FragmentClubScoreboardListBinding) bind(component, view, R.layout.fragment_club_scoreboard_list);
    }
}
