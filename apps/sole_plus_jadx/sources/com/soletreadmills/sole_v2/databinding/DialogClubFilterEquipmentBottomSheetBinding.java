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
public abstract class DialogClubFilterEquipmentBottomSheetBinding extends ViewDataBinding {
    public final ConstraintLayout CLTitle;
    public final AppCompatButton btnDone;
    public final ImageView imgBack;
    public final LinearLayout llEquipmentBike;
    public final LinearLayout llEquipmentElliptical;
    public final LinearLayout llEquipmentRower;
    public final LinearLayout llEquipmentTreadmill;
    public final TextView title;

    protected DialogClubFilterEquipmentBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLTitle, AppCompatButton btnDone, ImageView imgBack, LinearLayout llEquipmentBike, LinearLayout llEquipmentElliptical, LinearLayout llEquipmentRower, LinearLayout llEquipmentTreadmill, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLTitle = CLTitle;
        this.btnDone = btnDone;
        this.imgBack = imgBack;
        this.llEquipmentBike = llEquipmentBike;
        this.llEquipmentElliptical = llEquipmentElliptical;
        this.llEquipmentRower = llEquipmentRower;
        this.llEquipmentTreadmill = llEquipmentTreadmill;
        this.title = title;
    }

    public static DialogClubFilterEquipmentBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterEquipmentBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogClubFilterEquipmentBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_equipment_bottom_sheet, root, attachToRoot, component);
    }

    public static DialogClubFilterEquipmentBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterEquipmentBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogClubFilterEquipmentBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_club_filter_equipment_bottom_sheet, null, false, component);
    }

    public static DialogClubFilterEquipmentBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogClubFilterEquipmentBottomSheetBinding bind(View view, Object component) {
        return (DialogClubFilterEquipmentBottomSheetBinding) bind(component, view, R.layout.dialog_club_filter_equipment_bottom_sheet);
    }
}
