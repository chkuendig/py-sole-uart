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
public abstract class DialogClubFilterTargetBottomSheetBinding extends ViewDataBinding {
    public final ConstraintLayout CLTitle;
    public final AppCompatButton btnDone;
    public final ImageView imgBack;
    public final LinearLayout llActiveTime;
    public final LinearLayout llCalories;
    public final LinearLayout llDistance;
    public final LinearLayout llSessions;
    public final TextView title;

    protected DialogClubFilterTargetBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTitle, AppCompatButton btnDone, ImageView imgBack, LinearLayout llActiveTime, LinearLayout llCalories, LinearLayout llDistance, LinearLayout llSessions, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTitle = CLTitle;
        this.btnDone = btnDone;
        this.imgBack = imgBack;
        this.llActiveTime = llActiveTime;
        this.llCalories = llCalories;
        this.llDistance = llDistance;
        this.llSessions = llSessions;
        this.title = title;
    }

    public static DialogClubFilterTargetBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterTargetBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogClubFilterTargetBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_target_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogClubFilterTargetBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterTargetBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogClubFilterTargetBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_target_bottom_sheet, null, false, component);
    }

    public static DialogClubFilterTargetBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterTargetBottomSheetBinding bind(View view, Object component) {
        return (DialogClubFilterTargetBottomSheetBinding) bind(component, view, R.layout.dialog_club_filter_target_bottom_sheet);
    }
}
