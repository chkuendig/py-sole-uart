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
public abstract class FragmentUserSubscriptionBinding extends ViewDataBinding {
    public final LinearLayout LLALL;
    public final LinearLayout LLCancelStatus;
    public final LinearLayout LLCancelSubscription;
    public final LinearLayout LLCard;
    public final LinearLayout LLChangePlans;
    public final LinearLayout LLChangeToOtherPlan;
    public final LinearLayout LLGetPremium;
    public final LinearLayout LLManageBilling;
    public final LinearLayout LLRemoveCard;
    public final LinearLayout LLRenewSubscription;
    public final LinearLayout LLSeePlans;
    public final ImageView back;
    public final ImageView endImg;
    public final ImageView imageView9;
    public final ImageView imgCard;
    public final ImageView imgFailed;
    public final View lineRe;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView tvCard;
    public final TextView tvChangeDesc;
    public final TextView tvChangeFee;
    public final TextView tvChangeTitle;
    public final TextView tvDesc;
    public final TextView tvFailed;
    public final TextView tvFee;
    public final TextView tvSubscriptionMethod;
    public final View viewManageBilling;

    protected FragmentUserSubscriptionBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLALL, LinearLayout LLCancelStatus, LinearLayout LLCancelSubscription, LinearLayout LLCard, LinearLayout LLChangePlans, LinearLayout LLChangeToOtherPlan, LinearLayout LLGetPremium, LinearLayout LLManageBilling, LinearLayout LLRemoveCard, LinearLayout LLRenewSubscription, LinearLayout LLSeePlans, ImageView back, ImageView endImg, ImageView imageView9, ImageView imgCard, ImageView imgFailed, View lineRe, TextView title, ConstraintLayout topbar, TextView tvCard, TextView tvChangeDesc, TextView tvChangeFee, TextView tvChangeTitle, TextView tvDesc, TextView tvFailed, TextView tvFee, TextView tvSubscriptionMethod, View viewManageBilling) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLALL = LLALL;
        this.LLCancelStatus = LLCancelStatus;
        this.LLCancelSubscription = LLCancelSubscription;
        this.LLCard = LLCard;
        this.LLChangePlans = LLChangePlans;
        this.LLChangeToOtherPlan = LLChangeToOtherPlan;
        this.LLGetPremium = LLGetPremium;
        this.LLManageBilling = LLManageBilling;
        this.LLRemoveCard = LLRemoveCard;
        this.LLRenewSubscription = LLRenewSubscription;
        this.LLSeePlans = LLSeePlans;
        this.back = back;
        this.endImg = endImg;
        this.imageView9 = imageView9;
        this.imgCard = imgCard;
        this.imgFailed = imgFailed;
        this.lineRe = lineRe;
        this.title = title;
        this.topbar = topbar;
        this.tvCard = tvCard;
        this.tvChangeDesc = tvChangeDesc;
        this.tvChangeFee = tvChangeFee;
        this.tvChangeTitle = tvChangeTitle;
        this.tvDesc = tvDesc;
        this.tvFailed = tvFailed;
        this.tvFee = tvFee;
        this.tvSubscriptionMethod = tvSubscriptionMethod;
        this.viewManageBilling = viewManageBilling;
    }

    public static FragmentUserSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUserSubscriptionBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentUserSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_user_subscription, root, attachToRoot, component);
    }

    public static FragmentUserSubscriptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUserSubscriptionBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentUserSubscriptionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_user_subscription, null, false, component);
    }

    public static FragmentUserSubscriptionBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentUserSubscriptionBinding bind(View view, Object component) {
        return (FragmentUserSubscriptionBinding) bind(component, view, R.layout.fragment_user_subscription);
    }
}
