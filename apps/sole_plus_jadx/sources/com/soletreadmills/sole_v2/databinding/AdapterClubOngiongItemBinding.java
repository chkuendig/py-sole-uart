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
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterClubOngiongItemBinding extends ViewDataBinding {
    public final LinearLayout LLProgress1;
    public final LinearLayout LLProgress2;
    public final LinearLayout LLProgress3;
    public final ImageView avatarIcon;
    public final CardView cardProgress1;
    public final CardView cardProgress2;
    public final CardView cardProgress3;
    public final CardView cvOngoingCard;
    public final ImageView imgArea2Icon;
    public final TextView imgOngoingLeftTimeVal;
    public final TextView imgOngoingProcessVal;
    public final ImageView imgOngoingThumb;
    public final TextView imgOngoingTitle;
    public final ImageView imgRaceIcon;
    public final LinearLayout imgRank1Wrap;
    public final LinearLayout imgRank2Wrap;
    public final LinearLayout imgRank3Wrap;
    public final ImageView imgRankAvatar1;
    public final ImageView imgRankAvatar2;
    public final ImageView imgRankAvatar3;
    public final ImageView imgVrRaceStatusIcon1;
    public final ImageView imgVrRaceStatusIcon2;
    public final LinearLayout llGoalAreaWrap;
    public final LinearLayout llRankAreaWrap;
    public final LinearLayout llVirtualRaceAreaWrap;
    public final LinearLayout llVirtualRaceNotComplete;
    public final LinearLayout llVirtualRaceNotStartYet;
    public final TextView llVirtualRaceNotStartYetTime;
    public final LinearLayout llVirtualRaceSelfDelete;
    public final LinearLayout llVirtualRaceSingleScore;
    public final TextView participantCount;
    public final ProgressBar progressBar;
    public final TextView tvGoalLine;
    public final TextView tvGoalNowVal;
    public final TextView tvGoalUnit;
    public final TextView tvGoalVal;
    public final TextView tvRaceButton;
    public final TextView tvRankVal1;
    public final TextView tvRankVal2;
    public final TextView tvRankVal3;
    public final TextView tvScore1;
    public final TextView tvScore2;
    public final TextView tvScore3;
    public final TextView tvScoreUnit1;
    public final TextView tvScoreUnit2;
    public final TextView tvScoreUnit3;
    public final TextView tvVrScore;
    public final View vGoalProgress;
    public final FrameLayout vGoalProgressWrap;
    public final View vRankProgress1;
    public final FrameLayout vRankProgress1Wrap;
    public final View vRankProgress2;
    public final FrameLayout vRankProgress2Wrap;
    public final View vRankProgress3;
    public final FrameLayout vRankProgress3Wrap;

    protected AdapterClubOngiongItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLProgress1, LinearLayout LLProgress2, LinearLayout LLProgress3, ImageView avatarIcon, CardView cardProgress1, CardView cardProgress2, CardView cardProgress3, CardView cvOngoingCard, ImageView imgArea2Icon, TextView imgOngoingLeftTimeVal, TextView imgOngoingProcessVal, ImageView imgOngoingThumb, TextView imgOngoingTitle, ImageView imgRaceIcon, LinearLayout imgRank1Wrap, LinearLayout imgRank2Wrap, LinearLayout imgRank3Wrap, ImageView imgRankAvatar1, ImageView imgRankAvatar2, ImageView imgRankAvatar3, ImageView imgVrRaceStatusIcon1, ImageView imgVrRaceStatusIcon2, LinearLayout llGoalAreaWrap, LinearLayout llRankAreaWrap, LinearLayout llVirtualRaceAreaWrap, LinearLayout llVirtualRaceNotComplete, LinearLayout llVirtualRaceNotStartYet, TextView llVirtualRaceNotStartYetTime, LinearLayout llVirtualRaceSelfDelete, LinearLayout llVirtualRaceSingleScore, TextView participantCount, ProgressBar progressBar, TextView tvGoalLine, TextView tvGoalNowVal, TextView tvGoalUnit, TextView tvGoalVal, TextView tvRaceButton, TextView tvRankVal1, TextView tvRankVal2, TextView tvRankVal3, TextView tvScore1, TextView tvScore2, TextView tvScore3, TextView tvScoreUnit1, TextView tvScoreUnit2, TextView tvScoreUnit3, TextView tvVrScore, View vGoalProgress, FrameLayout vGoalProgressWrap, View vRankProgress1, FrameLayout vRankProgress1Wrap, View vRankProgress2, FrameLayout vRankProgress2Wrap, View vRankProgress3, FrameLayout vRankProgress3Wrap) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLProgress1 = LLProgress1;
        this.LLProgress2 = LLProgress2;
        this.LLProgress3 = LLProgress3;
        this.avatarIcon = avatarIcon;
        this.cardProgress1 = cardProgress1;
        this.cardProgress2 = cardProgress2;
        this.cardProgress3 = cardProgress3;
        this.cvOngoingCard = cvOngoingCard;
        this.imgArea2Icon = imgArea2Icon;
        this.imgOngoingLeftTimeVal = imgOngoingLeftTimeVal;
        this.imgOngoingProcessVal = imgOngoingProcessVal;
        this.imgOngoingThumb = imgOngoingThumb;
        this.imgOngoingTitle = imgOngoingTitle;
        this.imgRaceIcon = imgRaceIcon;
        this.imgRank1Wrap = imgRank1Wrap;
        this.imgRank2Wrap = imgRank2Wrap;
        this.imgRank3Wrap = imgRank3Wrap;
        this.imgRankAvatar1 = imgRankAvatar1;
        this.imgRankAvatar2 = imgRankAvatar2;
        this.imgRankAvatar3 = imgRankAvatar3;
        this.imgVrRaceStatusIcon1 = imgVrRaceStatusIcon1;
        this.imgVrRaceStatusIcon2 = imgVrRaceStatusIcon2;
        this.llGoalAreaWrap = llGoalAreaWrap;
        this.llRankAreaWrap = llRankAreaWrap;
        this.llVirtualRaceAreaWrap = llVirtualRaceAreaWrap;
        this.llVirtualRaceNotComplete = llVirtualRaceNotComplete;
        this.llVirtualRaceNotStartYet = llVirtualRaceNotStartYet;
        this.llVirtualRaceNotStartYetTime = llVirtualRaceNotStartYetTime;
        this.llVirtualRaceSelfDelete = llVirtualRaceSelfDelete;
        this.llVirtualRaceSingleScore = llVirtualRaceSingleScore;
        this.participantCount = participantCount;
        this.progressBar = progressBar;
        this.tvGoalLine = tvGoalLine;
        this.tvGoalNowVal = tvGoalNowVal;
        this.tvGoalUnit = tvGoalUnit;
        this.tvGoalVal = tvGoalVal;
        this.tvRaceButton = tvRaceButton;
        this.tvRankVal1 = tvRankVal1;
        this.tvRankVal2 = tvRankVal2;
        this.tvRankVal3 = tvRankVal3;
        this.tvScore1 = tvScore1;
        this.tvScore2 = tvScore2;
        this.tvScore3 = tvScore3;
        this.tvScoreUnit1 = tvScoreUnit1;
        this.tvScoreUnit2 = tvScoreUnit2;
        this.tvScoreUnit3 = tvScoreUnit3;
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

    public static AdapterClubOngiongItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubOngiongItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubOngiongItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_ongiong_item, root, attachToRoot, component);
    }

    public static AdapterClubOngiongItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubOngiongItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubOngiongItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_ongiong_item, null, false, component);
    }

    public static AdapterClubOngiongItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubOngiongItemBinding bind(View view, Object component) {
        return (AdapterClubOngiongItemBinding) bind(component, view, R.layout.adapter_club_ongiong_item);
    }
}
