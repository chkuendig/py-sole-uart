package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentBannerBinding extends ViewDataBinding {
    public final ImageView bannerImg;
    public final Button btn;
    public final TextView countDownTime;
    public final CardView countDownTimeLayout;
    public final CardView dontShowAgain;
    public final TextView msg;
    public final View msgBackground;
    public final View statusBarHeight;
    public final LinearLayout topBar;

    protected FragmentBannerBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView bannerImg, Button btn, TextView countDownTime, CardView countDownTimeLayout, CardView dontShowAgain, TextView msg, View msgBackground, View statusBarHeight, LinearLayout topBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bannerImg = bannerImg;
        this.btn = btn;
        this.countDownTime = countDownTime;
        this.countDownTimeLayout = countDownTimeLayout;
        this.dontShowAgain = dontShowAgain;
        this.msg = msg;
        this.msgBackground = msgBackground;
        this.statusBarHeight = statusBarHeight;
        this.topBar = topBar;
    }

    public static FragmentBannerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBannerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentBannerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_banner, root, attachToRoot, component);
    }

    public static FragmentBannerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBannerBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentBannerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_banner, null, false, component);
    }

    public static FragmentBannerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBannerBinding bind(View view, Object component) {
        return (FragmentBannerBinding) bind(component, view, R.layout.fragment_banner);
    }
}
