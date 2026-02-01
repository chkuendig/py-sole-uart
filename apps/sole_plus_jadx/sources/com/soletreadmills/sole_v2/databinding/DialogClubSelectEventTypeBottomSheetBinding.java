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
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class DialogClubSelectEventTypeBottomSheetBinding extends ViewDataBinding {
    public final ConstraintLayout CLTitle;
    public final ImageView imgBack;
    public final LinearLayout llRanking;
    public final LinearLayout llShareGoal;
    public final LinearLayout llVirtualRace;
    public final TextView title;

    protected DialogClubSelectEventTypeBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTitle, ImageView imgBack, LinearLayout llRanking, LinearLayout llShareGoal, LinearLayout llVirtualRace, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTitle = CLTitle;
        this.imgBack = imgBack;
        this.llRanking = llRanking;
        this.llShareGoal = llShareGoal;
        this.llVirtualRace = llVirtualRace;
        this.title = title;
    }

    public static DialogClubSelectEventTypeBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubSelectEventTypeBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogClubSelectEventTypeBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_select_event_type_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogClubSelectEventTypeBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubSelectEventTypeBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogClubSelectEventTypeBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_select_event_type_bottom_sheet, null, false, component);
    }

    public static DialogClubSelectEventTypeBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubSelectEventTypeBottomSheetBinding bind(View view, Object component) {
        return (DialogClubSelectEventTypeBottomSheetBinding) bind(component, view, R.layout.dialog_club_select_event_type_bottom_sheet);
    }
}
