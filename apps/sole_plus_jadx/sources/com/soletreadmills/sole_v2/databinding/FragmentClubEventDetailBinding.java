package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubEventDetailBinding extends ViewDataBinding {
    public final LinearLayout LLProgress1;
    public final LinearLayout LLProgress2;
    public final LinearLayout LLProgress3;
    public final FlexboxLayout bodyParts;
    public final CardView cardProgress1;
    public final CardView cardProgress2;
    public final CardView cardProgress3;
    public final ImageView imgArea2Icon;
    public final ImageView imgBackBtn;
    public final ImageView imgBtnGoPrev;
    public final ImageView imgChallengeTopImg;
    public final ImageView imgDeleteButtonSmall;
    public final ImageView imgEditButtonSmall;
    public final ImageView imgRaceIcon;
    public final LinearLayout imgRank1Wrap;
    public final LinearLayout imgRank2Wrap;
    public final LinearLayout imgRank3Wrap;
    public final ImageView imgRankAvatar1;
    public final ImageView imgRankAvatar2;
    public final ImageView imgRankAvatar3;
    public final ImageView imgShareButtonSmall;
    public final ImageView imgVrRaceStatusIcon1;
    public final ImageView imgVrRaceStatusIcon2;
    public final TextView joinEventButton;
    public final ConstraintLayout linearLayout2Wrap;
    public final LinearLayout llBottomWrap;
    public final LinearLayout llClubCodeWrap;
    public final LinearLayout llGoalAreaWrap;
    public final LinearLayout llMemberOnlyWrap;
    public final LinearLayout llMembersWrap;
    public final LinearLayout llMenu1ForOwner;
    public final LinearLayout llMenu2ForMember;
    public final LinearLayout llRankAreaWrap;
    public final LinearLayout llVirtualRaceAreaWrap;
    public final LinearLayout llVirtualRaceNotComplete;
    public final LinearLayout llVirtualRaceNotStartYet;
    public final LinearLayout llVirtualRaceSelfDelete;
    public final LinearLayout llVirtualRaceSingleScore;
    public final NestedScrollView nestedScrollView2;
    public final ProgressBar pbProgressBar;
    public final TextView quitEventButton;
    public final RecyclerView rvUserList;
    public final LinearLayout shareButton;
    public final View statusBarHeight;
    public final SwipeRefreshLayout swipeRefresh;
    public final ConstraintLayout tobBar;
    public final TextView tvChallengeDescText;
    public final TextView tvChallengeName;
    public final TextView tvClubCode;
    public final TextView tvClubFormatType;
    public final TextView tvClubTitle;
    public final TextView tvCreateDate;
    public final TextView tvCreatedOwnerName;
    public final TextView tvDash;
    public final TextView tvDays;
    public final TextView tvDaysUnit;
    public final TextView tvEndDate;
    public final TextView tvEquipment;
    public final TextView tvGoalLine;
    public final TextView tvGoalNowVal;
    public final TextView tvGoalUnit;
    public final TextView tvGoalVal;
    public final TextView tvLeftTime;
    public final TextView tvMainValue;
    public final TextView tvMainValueUnit;
    public final TextView tvPrivacy;
    public final TextView tvRaceButton;
    public final TextView tvRaceInfoText;
    public final TextView tvRankVal1;
    public final TextView tvRankVal2;
    public final TextView tvRankVal3;
    public final TextView tvScore1;
    public final TextView tvScore2;
    public final TextView tvScore3;
    public final TextView tvScoreUnit1;
    public final TextView tvScoreUnit2;
    public final TextView tvScoreUnit3;
    public final TextView tvStartDate;
    public final TextView tvStatus;
    public final TextView tvUserCount;
    public final ImageView tvUsersMoreArrowBtn;
    public final TextView tvUsersMoreCount;
    public final LinearLayout tvUsersMoreCountWrap;
    public final TextView tvVrScore;
    public final View vGoalProgress;
    public final FrameLayout vGoalProgressWrap;
    public final View vRankProgress1;
    public final FrameLayout vRankProgress1Wrap;
    public final View vRankProgress2;
    public final FrameLayout vRankProgress2Wrap;
    public final View vRankProgress3;
    public final FrameLayout vRankProgress3Wrap;

    protected FragmentClubEventDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLProgress1, LinearLayout LLProgress2, LinearLayout LLProgress3, FlexboxLayout bodyParts, CardView cardProgress1, CardView cardProgress2, CardView cardProgress3, ImageView imgArea2Icon, ImageView imgBackBtn, ImageView imgBtnGoPrev, ImageView imgChallengeTopImg, ImageView imgDeleteButtonSmall, ImageView imgEditButtonSmall, ImageView imgRaceIcon, LinearLayout imgRank1Wrap, LinearLayout imgRank2Wrap, LinearLayout imgRank3Wrap, ImageView imgRankAvatar1, ImageView imgRankAvatar2, ImageView imgRankAvatar3, ImageView imgShareButtonSmall, ImageView imgVrRaceStatusIcon1, ImageView imgVrRaceStatusIcon2, TextView joinEventButton, ConstraintLayout linearLayout2Wrap, LinearLayout llBottomWrap, LinearLayout llClubCodeWrap, LinearLayout llGoalAreaWrap, LinearLayout llMemberOnlyWrap, LinearLayout llMembersWrap, LinearLayout llMenu1ForOwner, LinearLayout llMenu2ForMember, LinearLayout llRankAreaWrap, LinearLayout llVirtualRaceAreaWrap, LinearLayout llVirtualRaceNotComplete, LinearLayout llVirtualRaceNotStartYet, LinearLayout llVirtualRaceSelfDelete, LinearLayout llVirtualRaceSingleScore, NestedScrollView nestedScrollView2, ProgressBar pbProgressBar, TextView quitEventButton, RecyclerView rvUserList, LinearLayout shareButton, View statusBarHeight, SwipeRefreshLayout swipeRefresh, ConstraintLayout tobBar, TextView tvChallengeDescText, TextView tvChallengeName, TextView tvClubCode, TextView tvClubFormatType, TextView tvClubTitle, TextView tvCreateDate, TextView tvCreatedOwnerName, TextView tvDash, TextView tvDays, TextView tvDaysUnit, TextView tvEndDate, TextView tvEquipment, TextView tvGoalLine, TextView tvGoalNowVal, TextView tvGoalUnit, TextView tvGoalVal, TextView tvLeftTime, TextView tvMainValue, TextView tvMainValueUnit, TextView tvPrivacy, TextView tvRaceButton, TextView tvRaceInfoText, TextView tvRankVal1, TextView tvRankVal2, TextView tvRankVal3, TextView tvScore1, TextView tvScore2, TextView tvScore3, TextView tvScoreUnit1, TextView tvScoreUnit2, TextView tvScoreUnit3, TextView tvStartDate, TextView tvStatus, TextView tvUserCount, ImageView tvUsersMoreArrowBtn, TextView tvUsersMoreCount, LinearLayout tvUsersMoreCountWrap, TextView tvVrScore, View vGoalProgress, FrameLayout vGoalProgressWrap, View vRankProgress1, FrameLayout vRankProgress1Wrap, View vRankProgress2, FrameLayout vRankProgress2Wrap, View vRankProgress3, FrameLayout vRankProgress3Wrap) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLProgress1 = LLProgress1;
        this.LLProgress2 = LLProgress2;
        this.LLProgress3 = LLProgress3;
        this.bodyParts = bodyParts;
        this.cardProgress1 = cardProgress1;
        this.cardProgress2 = cardProgress2;
        this.cardProgress3 = cardProgress3;
        this.imgArea2Icon = imgArea2Icon;
        this.imgBackBtn = imgBackBtn;
        this.imgBtnGoPrev = imgBtnGoPrev;
        this.imgChallengeTopImg = imgChallengeTopImg;
        this.imgDeleteButtonSmall = imgDeleteButtonSmall;
        this.imgEditButtonSmall = imgEditButtonSmall;
        this.imgRaceIcon = imgRaceIcon;
        this.imgRank1Wrap = imgRank1Wrap;
        this.imgRank2Wrap = imgRank2Wrap;
        this.imgRank3Wrap = imgRank3Wrap;
        this.imgRankAvatar1 = imgRankAvatar1;
        this.imgRankAvatar2 = imgRankAvatar2;
        this.imgRankAvatar3 = imgRankAvatar3;
        this.imgShareButtonSmall = imgShareButtonSmall;
        this.imgVrRaceStatusIcon1 = imgVrRaceStatusIcon1;
        this.imgVrRaceStatusIcon2 = imgVrRaceStatusIcon2;
        this.joinEventButton = joinEventButton;
        this.linearLayout2Wrap = linearLayout2Wrap;
        this.llBottomWrap = llBottomWrap;
        this.llClubCodeWrap = llClubCodeWrap;
        this.llGoalAreaWrap = llGoalAreaWrap;
        this.llMemberOnlyWrap = llMemberOnlyWrap;
        this.llMembersWrap = llMembersWrap;
        this.llMenu1ForOwner = llMenu1ForOwner;
        this.llMenu2ForMember = llMenu2ForMember;
        this.llRankAreaWrap = llRankAreaWrap;
        this.llVirtualRaceAreaWrap = llVirtualRaceAreaWrap;
        this.llVirtualRaceNotComplete = llVirtualRaceNotComplete;
        this.llVirtualRaceNotStartYet = llVirtualRaceNotStartYet;
        this.llVirtualRaceSelfDelete = llVirtualRaceSelfDelete;
        this.llVirtualRaceSingleScore = llVirtualRaceSingleScore;
        this.nestedScrollView2 = nestedScrollView2;
        this.pbProgressBar = pbProgressBar;
        this.quitEventButton = quitEventButton;
        this.rvUserList = rvUserList;
        this.shareButton = shareButton;
        this.statusBarHeight = statusBarHeight;
        this.swipeRefresh = swipeRefresh;
        this.tobBar = tobBar;
        this.tvChallengeDescText = tvChallengeDescText;
        this.tvChallengeName = tvChallengeName;
        this.tvClubCode = tvClubCode;
        this.tvClubFormatType = tvClubFormatType;
        this.tvClubTitle = tvClubTitle;
        this.tvCreateDate = tvCreateDate;
        this.tvCreatedOwnerName = tvCreatedOwnerName;
        this.tvDash = tvDash;
        this.tvDays = tvDays;
        this.tvDaysUnit = tvDaysUnit;
        this.tvEndDate = tvEndDate;
        this.tvEquipment = tvEquipment;
        this.tvGoalLine = tvGoalLine;
        this.tvGoalNowVal = tvGoalNowVal;
        this.tvGoalUnit = tvGoalUnit;
        this.tvGoalVal = tvGoalVal;
        this.tvLeftTime = tvLeftTime;
        this.tvMainValue = tvMainValue;
        this.tvMainValueUnit = tvMainValueUnit;
        this.tvPrivacy = tvPrivacy;
        this.tvRaceButton = tvRaceButton;
        this.tvRaceInfoText = tvRaceInfoText;
        this.tvRankVal1 = tvRankVal1;
        this.tvRankVal2 = tvRankVal2;
        this.tvRankVal3 = tvRankVal3;
        this.tvScore1 = tvScore1;
        this.tvScore2 = tvScore2;
        this.tvScore3 = tvScore3;
        this.tvScoreUnit1 = tvScoreUnit1;
        this.tvScoreUnit2 = tvScoreUnit2;
        this.tvScoreUnit3 = tvScoreUnit3;
        this.tvStartDate = tvStartDate;
        this.tvStatus = tvStatus;
        this.tvUserCount = tvUserCount;
        this.tvUsersMoreArrowBtn = tvUsersMoreArrowBtn;
        this.tvUsersMoreCount = tvUsersMoreCount;
        this.tvUsersMoreCountWrap = tvUsersMoreCountWrap;
        this.tvVrScore = tvVrScore;
        this.vGoalProgress = vGoalProgress;
        this.vGoalProgressWrap = vGoalProgressWrap;
        this.vRankProgress1 = vRankProgress1;
        this.vRankProgress1Wrap = vRankProgress1Wrap;
        this.vRankProgress2 = vRankProgress2;
        this.vRankProgress2Wrap = vRankProgress2Wrap;
        this.vRankProgress3 = vRankProgress3;
        this.vRankProgress3Wrap = vRankProgress3Wrap;
    }

    public static FragmentClubEventDetailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubEventDetailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubEventDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_event_detail, root, attachToRoot, component);
    }

    public static FragmentClubEventDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubEventDetailBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubEventDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_event_detail, null, false, component);
    }

    public static FragmentClubEventDetailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubEventDetailBinding bind(View view, Object component) {
        return (FragmentClubEventDetailBinding) bind(component, view, R.layout.fragment_club_event_detail);
    }
}
