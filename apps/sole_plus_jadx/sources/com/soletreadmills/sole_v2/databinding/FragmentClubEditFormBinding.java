package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubEditFormBinding extends ViewDataBinding {
    public final AppCompatButton btnBottomSaveCreate;
    public final AppCompatButton btnBottomSaveEdit;
    public final ImageView challengeFormClearPhotoBtn;
    public final TextView challengeFormEndDateTimeFormat;
    public final LinearLayout challengeFormMakePhotoBtn;
    public final ImageView challengeFormPreviewPhoto;
    public final LinearLayout challengeFormPreviewPhotoWrap;
    public final LinearLayout challengeFormSelectPhotoBtn;
    public final TextView challengeFormStartDateTimeFormat;
    public final TextView challengeFormTakePhotoError;
    public final LinearLayout challengeFormTakePhotoWrap;
    public final EditText etDateCount;
    public final EditText etDateEnd;
    public final EditText etDateStart;
    public final EditText etEventDescription;
    public final EditText etEventName;
    public final EditText etTargetScore;
    public final EditText etVirtualRaceDateStart;
    public final ImageView imgMinusDay;
    public final ImageView imgPlusDay;
    public final ImageView imgRaceDistance;
    public final LinearLayout llDatesWrap;
    public final LinearLayout llPhotoWrap;
    public final LinearLayout llPrivacyWrap;
    public final LinearLayout llRaceDateWrap;
    public final LinearLayout llRaceDistanceWrap;
    public final LinearLayout llTargetScoreWrap;
    public final LinearLayout llTargetWrap;
    public final RecyclerView rvEditMachineType;
    public final RecyclerView rvEditPravicy;
    public final RecyclerView rvEditRaceDistance;
    public final RecyclerView rvEditScoreItem;
    public final View statusBarHeight;
    public final ConstraintLayout tobBar;
    public final TextView tvCancelBtn;
    public final TextView tvCreateBtn;
    public final TextView tvEventDescriptionError;
    public final TextView tvEventNameError;
    public final TextView tvPageTitle;
    public final TextView tvSaveEditBtn;
    public final TextView tvTargetScoreError;

    protected FragmentClubEditFormBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton btnBottomSaveCreate, AppCompatButton btnBottomSaveEdit, ImageView challengeFormClearPhotoBtn, TextView challengeFormEndDateTimeFormat, LinearLayout challengeFormMakePhotoBtn, ImageView challengeFormPreviewPhoto, LinearLayout challengeFormPreviewPhotoWrap, LinearLayout challengeFormSelectPhotoBtn, TextView challengeFormStartDateTimeFormat, TextView challengeFormTakePhotoError, LinearLayout challengeFormTakePhotoWrap, EditText etDateCount, EditText etDateEnd, EditText etDateStart, EditText etEventDescription, EditText etEventName, EditText etTargetScore, EditText etVirtualRaceDateStart, ImageView imgMinusDay, ImageView imgPlusDay, ImageView imgRaceDistance, LinearLayout llDatesWrap, LinearLayout llPhotoWrap, LinearLayout llPrivacyWrap, LinearLayout llRaceDateWrap, LinearLayout llRaceDistanceWrap, LinearLayout llTargetScoreWrap, LinearLayout llTargetWrap, RecyclerView rvEditMachineType, RecyclerView rvEditPravicy, RecyclerView rvEditRaceDistance, RecyclerView rvEditScoreItem, View statusBarHeight, ConstraintLayout tobBar, TextView tvCancelBtn, TextView tvCreateBtn, TextView tvEventDescriptionError, TextView tvEventNameError, TextView tvPageTitle, TextView tvSaveEditBtn, TextView tvTargetScoreError) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnBottomSaveCreate = btnBottomSaveCreate;
        this.btnBottomSaveEdit = btnBottomSaveEdit;
        this.challengeFormClearPhotoBtn = challengeFormClearPhotoBtn;
        this.challengeFormEndDateTimeFormat = challengeFormEndDateTimeFormat;
        this.challengeFormMakePhotoBtn = challengeFormMakePhotoBtn;
        this.challengeFormPreviewPhoto = challengeFormPreviewPhoto;
        this.challengeFormPreviewPhotoWrap = challengeFormPreviewPhotoWrap;
        this.challengeFormSelectPhotoBtn = challengeFormSelectPhotoBtn;
        this.challengeFormStartDateTimeFormat = challengeFormStartDateTimeFormat;
        this.challengeFormTakePhotoError = challengeFormTakePhotoError;
        this.challengeFormTakePhotoWrap = challengeFormTakePhotoWrap;
        this.etDateCount = etDateCount;
        this.etDateEnd = etDateEnd;
        this.etDateStart = etDateStart;
        this.etEventDescription = etEventDescription;
        this.etEventName = etEventName;
        this.etTargetScore = etTargetScore;
        this.etVirtualRaceDateStart = etVirtualRaceDateStart;
        this.imgMinusDay = imgMinusDay;
        this.imgPlusDay = imgPlusDay;
        this.imgRaceDistance = imgRaceDistance;
        this.llDatesWrap = llDatesWrap;
        this.llPhotoWrap = llPhotoWrap;
        this.llPrivacyWrap = llPrivacyWrap;
        this.llRaceDateWrap = llRaceDateWrap;
        this.llRaceDistanceWrap = llRaceDistanceWrap;
        this.llTargetScoreWrap = llTargetScoreWrap;
        this.llTargetWrap = llTargetWrap;
        this.rvEditMachineType = rvEditMachineType;
        this.rvEditPravicy = rvEditPravicy;
        this.rvEditRaceDistance = rvEditRaceDistance;
        this.rvEditScoreItem = rvEditScoreItem;
        this.statusBarHeight = statusBarHeight;
        this.tobBar = tobBar;
        this.tvCancelBtn = tvCancelBtn;
        this.tvCreateBtn = tvCreateBtn;
        this.tvEventDescriptionError = tvEventDescriptionError;
        this.tvEventNameError = tvEventNameError;
        this.tvPageTitle = tvPageTitle;
        this.tvSaveEditBtn = tvSaveEditBtn;
        this.tvTargetScoreError = tvTargetScoreError;
    }

    public static FragmentClubEditFormBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubEditFormBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubEditFormBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_edit_form, root, attachToRoot, component);
    }

    public static FragmentClubEditFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubEditFormBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubEditFormBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_edit_form, null, false, component);
    }

    public static FragmentClubEditFormBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubEditFormBinding bind(View view, Object component) {
        return (FragmentClubEditFormBinding) bind(component, view, R.layout.fragment_club_edit_form);
    }
}
