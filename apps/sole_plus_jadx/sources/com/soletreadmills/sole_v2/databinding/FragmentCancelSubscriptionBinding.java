package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentCancelSubscriptionBinding extends ViewDataBinding {
    public final LinearLayout LLCancelSubscription;
    public final EditText etOtherReason;
    public final ImageView imgBack;
    public final ImageView imgSearch;
    public final RadioGroup radioGroupReasons;
    public final AppCompatRadioButton rbCostHigh;
    public final AppCompatRadioButton rbNoLongerUse;
    public final AppCompatRadioButton rbNoNeedPremium;
    public final AppCompatRadioButton rbOther;
    public final AppCompatRadioButton rbRoutineChanged;
    public final AppCompatRadioButton rbUnhappyApp;
    public final TextView textView6;
    public final TextView textView7;
    public final ConstraintLayout tobBar;
    public final TextView tvCancelBtn;

    protected FragmentCancelSubscriptionBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLCancelSubscription, EditText etOtherReason, ImageView imgBack, ImageView imgSearch, RadioGroup radioGroupReasons, AppCompatRadioButton rbCostHigh, AppCompatRadioButton rbNoLongerUse, AppCompatRadioButton rbNoNeedPremium, AppCompatRadioButton rbOther, AppCompatRadioButton rbRoutineChanged, AppCompatRadioButton rbUnhappyApp, TextView textView6, TextView textView7, ConstraintLayout tobBar, TextView tvCancelBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLCancelSubscription = LLCancelSubscription;
        this.etOtherReason = etOtherReason;
        this.imgBack = imgBack;
        this.imgSearch = imgSearch;
        this.radioGroupReasons = radioGroupReasons;
        this.rbCostHigh = rbCostHigh;
        this.rbNoLongerUse = rbNoLongerUse;
        this.rbNoNeedPremium = rbNoNeedPremium;
        this.rbOther = rbOther;
        this.rbRoutineChanged = rbRoutineChanged;
        this.rbUnhappyApp = rbUnhappyApp;
        this.textView6 = textView6;
        this.textView7 = textView7;
        this.tobBar = tobBar;
        this.tvCancelBtn = tvCancelBtn;
    }

    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentCancelSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_cancel_subscription, root, attachToRoot, component);
    }

    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCancelSubscriptionBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentCancelSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_cancel_subscription, null, false, component);
    }

    public static FragmentCancelSubscriptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCancelSubscriptionBinding bind(View view, Object component) {
        return (FragmentCancelSubscriptionBinding) bind(component, view, R.layout.fragment_cancel_subscription);
    }
}
