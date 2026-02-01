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
public abstract class DialogClubFilterDurationBottomSheetBinding extends ViewDataBinding {
    public final ConstraintLayout CLTitle;
    public final LinearLayout LLDay1;
    public final LinearLayout LLDay2;
    public final LinearLayout LLDay3;
    public final LinearLayout LLMonths1;
    public final LinearLayout LLMonths2;
    public final LinearLayout LLMonths3;
    public final AppCompatButton btnDone;
    public final ImageView imgBack;
    public final TextView title;

    protected DialogClubFilterDurationBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTitle, LinearLayout LLDay1, LinearLayout LLDay2, LinearLayout LLDay3, LinearLayout LLMonths1, LinearLayout LLMonths2, LinearLayout LLMonths3, AppCompatButton btnDone, ImageView imgBack, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTitle = CLTitle;
        this.LLDay1 = LLDay1;
        this.LLDay2 = LLDay2;
        this.LLDay3 = LLDay3;
        this.LLMonths1 = LLMonths1;
        this.LLMonths2 = LLMonths2;
        this.LLMonths3 = LLMonths3;
        this.btnDone = btnDone;
        this.imgBack = imgBack;
        this.title = title;
    }

    public static DialogClubFilterDurationBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterDurationBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogClubFilterDurationBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_duration_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogClubFilterDurationBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterDurationBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogClubFilterDurationBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_duration_bottom_sheet, null, false, component);
    }

    public static DialogClubFilterDurationBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterDurationBottomSheetBinding bind(View view, Object component) {
        return (DialogClubFilterDurationBottomSheetBinding) bind(component, view, R.layout.dialog_club_filter_duration_bottom_sheet);
    }
}
