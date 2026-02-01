package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentPairDeviceBinding extends ViewDataBinding {
    public final ConstraintLayout CLDeviceList;
    public final ConstraintLayout CLNoSearch;
    public final ConstraintLayout CLProgressbar;
    public final ConstraintLayout CLSearchProgressbar;
    public final LinearLayout LLPair;
    public final LinearLayout LLPairFailed;
    public final LinearLayout LLPairSuccess;
    public final LinearLayout LLPairingProgressbar;
    public final TextView cancel;
    public final TabLayout dotsIndicator;
    public final LinearLayout linearLayout3;
    public final LinearLayout pair;
    public final View statusBarHeight;
    public final TextView textView4;
    public final ConstraintLayout topbar;
    public final LinearLayout tryAgain;
    public final TextView tvDevicePaired;
    public final TextView tvSearch;
    public final ViewPager2 viewPager;

    protected FragmentPairDeviceBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLDeviceList, ConstraintLayout CLNoSearch, ConstraintLayout CLProgressbar, ConstraintLayout CLSearchProgressbar, LinearLayout LLPair, LinearLayout LLPairFailed, LinearLayout LLPairSuccess, LinearLayout LLPairingProgressbar, TextView cancel, TabLayout dotsIndicator, LinearLayout linearLayout3, LinearLayout pair, View statusBarHeight, TextView textView4, ConstraintLayout topbar, LinearLayout tryAgain, TextView tvDevicePaired, TextView tvSearch, ViewPager2 viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLDeviceList = CLDeviceList;
        this.CLNoSearch = CLNoSearch;
        this.CLProgressbar = CLProgressbar;
        this.CLSearchProgressbar = CLSearchProgressbar;
        this.LLPair = LLPair;
        this.LLPairFailed = LLPairFailed;
        this.LLPairSuccess = LLPairSuccess;
        this.LLPairingProgressbar = LLPairingProgressbar;
        this.cancel = cancel;
        this.dotsIndicator = dotsIndicator;
        this.linearLayout3 = linearLayout3;
        this.pair = pair;
        this.statusBarHeight = statusBarHeight;
        this.textView4 = textView4;
        this.topbar = topbar;
        this.tryAgain = tryAgain;
        this.tvDevicePaired = tvDevicePaired;
        this.tvSearch = tvSearch;
        this.viewPager = viewPager;
    }

    public static FragmentPairDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPairDeviceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentPairDeviceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pair_device, root, attachToRoot, component);
    }

    public static FragmentPairDeviceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPairDeviceBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentPairDeviceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_pair_device, null, false, component);
    }

    public static FragmentPairDeviceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPairDeviceBinding bind(View view, Object component) {
        return (FragmentPairDeviceBinding) bind(component, view, R.layout.fragment_pair_device);
    }
}
