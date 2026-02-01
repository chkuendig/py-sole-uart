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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubMemberScoreBinding extends ViewDataBinding {
    public final ImageView imgBtnGoPrev;
    public final RecyclerView rvMemberScore;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefresh;
    public final ConstraintLayout tobBar;
    public final LinearLayout tvMemberScoreWrap;
    public final TextView tvUsername;

    protected FragmentClubMemberScoreBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgBtnGoPrev, RecyclerView rvMemberScore, View statusBarHeight, SwipeRefreshLayout swipeRefresh, ConstraintLayout tobBar, LinearLayout tvMemberScoreWrap, TextView tvUsername) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgBtnGoPrev = imgBtnGoPrev;
        this.rvMemberScore = rvMemberScore;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefresh = swipeRefresh;
        this.tobBar = tobBar;
        this.tvMemberScoreWrap = tvMemberScoreWrap;
        this.tvUsername = tvUsername;
    }

    public static FragmentClubMemberScoreBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMemberScoreBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubMemberScoreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_member_score, root, attachToRoot, component);
    }

    public static FragmentClubMemberScoreBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMemberScoreBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubMemberScoreBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_member_score, null, false, component);
    }

    public static FragmentClubMemberScoreBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubMemberScoreBinding bind(View view, Object component) {
        return (FragmentClubMemberScoreBinding) bind(component, view, R.layout.fragment_club_member_score);
    }
}
