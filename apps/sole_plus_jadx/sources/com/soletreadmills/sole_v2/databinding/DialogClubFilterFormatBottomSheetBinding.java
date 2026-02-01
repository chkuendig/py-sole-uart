package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class DialogClubFilterFormatBottomSheetBinding extends ViewDataBinding {
    public final ConstraintLayout CLTitle;
    public final AppCompatButton btnDone;
    public final ImageView imgBack;
    public final ImageView imgFormatRankingCheck;
    public final ImageView imgFormatSharedGoalCheck;
    public final ImageView imgFormatVirtualRaceCheck;
    public final LinearLayout llFormatRanking;
    public final LinearLayout llFormatSharedGoal;
    public final LinearLayout llFormatVirtualRace;
    public final TextView title;
    public final TextView tvFormatRankingTitle;
    public final TextView tvFormatSharedGoalTitle;
    public final TextView tvFormatVirtualRaceTitle;

    protected DialogClubFilterFormatBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTitle, AppCompatButton btnDone, ImageView imgBack, ImageView imgFormatRankingCheck, ImageView imgFormatSharedGoalCheck, ImageView imgFormatVirtualRaceCheck, LinearLayout llFormatRanking, LinearLayout llFormatSharedGoal, LinearLayout llFormatVirtualRace, TextView title, TextView tvFormatRankingTitle, TextView tvFormatSharedGoalTitle, TextView tvFormatVirtualRaceTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTitle = CLTitle;
        this.btnDone = btnDone;
        this.imgBack = imgBack;
        this.imgFormatRankingCheck = imgFormatRankingCheck;
        this.imgFormatSharedGoalCheck = imgFormatSharedGoalCheck;
        this.imgFormatVirtualRaceCheck = imgFormatVirtualRaceCheck;
        this.llFormatRanking = llFormatRanking;
        this.llFormatSharedGoal = llFormatSharedGoal;
        this.llFormatVirtualRace = llFormatVirtualRace;
        this.title = title;
        this.tvFormatRankingTitle = tvFormatRankingTitle;
        this.tvFormatSharedGoalTitle = tvFormatSharedGoalTitle;
        this.tvFormatVirtualRaceTitle = tvFormatVirtualRaceTitle;
    }

    public static DialogClubFilterFormatBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterFormatBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogClubFilterFormatBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_format_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogClubFilterFormatBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterFormatBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogClubFilterFormatBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_format_bottom_sheet, null, false, component);
    }

    public static DialogClubFilterFormatBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterFormatBottomSheetBinding bind(View view, Object component) {
        return (DialogClubFilterFormatBottomSheetBinding) bind(component, view, R.layout.dialog_club_filter_format_bottom_sheet);
    }
}
