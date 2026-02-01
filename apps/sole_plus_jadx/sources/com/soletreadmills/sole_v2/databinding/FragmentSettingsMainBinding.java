package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSettingsMainBinding extends ViewDataBinding {
    public final ConstraintLayout CLProfile;
    public final LinearLayout LLAppTour;
    public final LinearLayout LLDeleteAccount;
    public final LinearLayout LLDevices;
    public final LinearLayout LLFaqSupport;
    public final LinearLayout LLGetPremium;
    public final LinearLayout LLHealthApps;
    public final LinearLayout LLHrm;
    public final LinearLayout LLLanguage;
    public final LinearLayout LLLogout;
    public final LinearLayout LLMyFavorites;
    public final LinearLayout LLNotify;
    public final LinearLayout LLPrivacyPolicy;
    public final LinearLayout LLResetPassword;
    public final View LLResetPasswordLine;
    public final LinearLayout LLSubscription;
    public final LinearLayout LLTermsOfUse;
    public final LinearLayout LLUnits;
    public final LinearLayout LLWorkoutSettings;
    public final AppBarLayout appBarLayout;
    public final ImageView back;
    public final CardView cardView3;
    public final Toolbar collapsingToolbar;
    public final TextView email;
    public final ImageView endImg;
    public final ImageView imageView14;
    public final ImageView img;
    public final ImageView imgRedCircle;
    public final TextView name;
    public final View statusBarHeight;
    public final Switch switchNotify;
    public final TextView textView3;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView txtLanguage;
    public final TextView txtUnits;
    public final TextView versionText;

    protected FragmentSettingsMainBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLProfile, LinearLayout LLAppTour, LinearLayout LLDeleteAccount, LinearLayout LLDevices, LinearLayout LLFaqSupport, LinearLayout LLGetPremium, LinearLayout LLHealthApps, LinearLayout LLHrm, LinearLayout LLLanguage, LinearLayout LLLogout, LinearLayout LLMyFavorites, LinearLayout LLNotify, LinearLayout LLPrivacyPolicy, LinearLayout LLResetPassword, View LLResetPasswordLine, LinearLayout LLSubscription, LinearLayout LLTermsOfUse, LinearLayout LLUnits, LinearLayout LLWorkoutSettings, AppBarLayout appBarLayout, ImageView back, CardView cardView3, Toolbar collapsingToolbar, TextView email, ImageView endImg, ImageView imageView14, ImageView img, ImageView imgRedCircle, TextView name, View statusBarHeight, Switch switchNotify, TextView textView3, TextView title, ConstraintLayout topbar, TextView txtLanguage, TextView txtUnits, TextView versionText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLProfile = CLProfile;
        this.LLAppTour = LLAppTour;
        this.LLDeleteAccount = LLDeleteAccount;
        this.LLDevices = LLDevices;
        this.LLFaqSupport = LLFaqSupport;
        this.LLGetPremium = LLGetPremium;
        this.LLHealthApps = LLHealthApps;
        this.LLHrm = LLHrm;
        this.LLLanguage = LLLanguage;
        this.LLLogout = LLLogout;
        this.LLMyFavorites = LLMyFavorites;
        this.LLNotify = LLNotify;
        this.LLPrivacyPolicy = LLPrivacyPolicy;
        this.LLResetPassword = LLResetPassword;
        this.LLResetPasswordLine = LLResetPasswordLine;
        this.LLSubscription = LLSubscription;
        this.LLTermsOfUse = LLTermsOfUse;
        this.LLUnits = LLUnits;
        this.LLWorkoutSettings = LLWorkoutSettings;
        this.appBarLayout = appBarLayout;
        this.back = back;
        this.cardView3 = cardView3;
        this.collapsingToolbar = collapsingToolbar;
        this.email = email;
        this.endImg = endImg;
        this.imageView14 = imageView14;
        this.img = img;
        this.imgRedCircle = imgRedCircle;
        this.name = name;
        this.statusBarHeight = statusBarHeight;
        this.switchNotify = switchNotify;
        this.textView3 = textView3;
        this.title = title;
        this.topbar = topbar;
        this.txtLanguage = txtLanguage;
        this.txtUnits = txtUnits;
        this.versionText = versionText;
    }

    public static FragmentSettingsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSettingsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_settings_main, root, attachToRoot, component);
    }

    public static FragmentSettingsMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsMainBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSettingsMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_settings_main, null, false, component);
    }

    public static FragmentSettingsMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingsMainBinding bind(View view, Object component) {
        return (FragmentSettingsMainBinding) bind(component, view, R.layout.fragment_settings_main);
    }
}
