package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentGoalsCreateBinding extends ViewDataBinding {
    public final AppCompatButton btnBottomSaveCreate;
    public final EditText etTargetScore;
    public final LinearLayout llRaceDistanceWrap;
    public final LinearLayout llTargetScoreWrap;
    public final LinearLayout llTargetWrap;
    public final RecyclerView rvEditMachineType;
    public final RecyclerView rvEditRaceDistance;
    public final RecyclerView rvEditScoreItem;
    public final View statusBarHeight;
    public final ConstraintLayout tobBar;
    public final TextView tvCancelBtn;
    public final TextView tvCreateBtn;
    public final TextView tvPageTitle;
    public final NestedScrollView tvScrollView;
    public final TextView tvTargetScoreError;

    protected FragmentGoalsCreateBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton btnBottomSaveCreate, EditText etTargetScore, LinearLayout llRaceDistanceWrap, LinearLayout llTargetScoreWrap, LinearLayout llTargetWrap, RecyclerView rvEditMachineType, RecyclerView rvEditRaceDistance, RecyclerView rvEditScoreItem, View statusBarHeight, ConstraintLayout tobBar, TextView tvCancelBtn, TextView tvCreateBtn, TextView tvPageTitle, NestedScrollView tvScrollView, TextView tvTargetScoreError) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btnBottomSaveCreate = btnBottomSaveCreate;
        this.etTargetScore = etTargetScore;
        this.llRaceDistanceWrap = llRaceDistanceWrap;
        this.llTargetScoreWrap = llTargetScoreWrap;
        this.llTargetWrap = llTargetWrap;
        this.rvEditMachineType = rvEditMachineType;
        this.rvEditRaceDistance = rvEditRaceDistance;
        this.rvEditScoreItem = rvEditScoreItem;
        this.statusBarHeight = statusBarHeight;
        this.tobBar = tobBar;
        this.tvCancelBtn = tvCancelBtn;
        this.tvCreateBtn = tvCreateBtn;
        this.tvPageTitle = tvPageTitle;
        this.tvScrollView = tvScrollView;
        this.tvTargetScoreError = tvTargetScoreError;
    }

    public static FragmentGoalsCreateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGoalsCreateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentGoalsCreateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_goals_create, root, attachToRoot, component);
    }

    public static FragmentGoalsCreateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGoalsCreateBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentGoalsCreateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_goals_create, null, false, component);
    }

    public static FragmentGoalsCreateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentGoalsCreateBinding bind(View view, Object component) {
        return (FragmentGoalsCreateBinding) bind(component, view, R.layout.fragment_goals_create);
    }
}
