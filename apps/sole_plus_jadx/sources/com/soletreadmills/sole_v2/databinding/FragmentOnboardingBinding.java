package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentOnboardingBinding extends ViewDataBinding {
    public final TextView birthday;
    public final TextView female;
    public final EditText height;
    public final ImageView imageView5;
    public final ImageView imageView7;
    public final LinearLayout layoutPage1;
    public final LinearLayout layoutPage2;
    public final LinearLayout layoutPage3;
    public final LinearLayout linearLayout2;
    public final LinearLayout linearLayout7;
    public final LinearLayout llPairViaBluetooth;
    public final LinearLayout llPairViaCloud;
    public final TextView male;
    public final View statusBarHeight;
    public final TextView titleHeight;
    public final TextView titleWeight;
    public final TextView tvNext;
    public final TextView tvPairLater;
    public final TextView tvSkip;
    public final View view1;
    public final View view2;
    public final View view3;
    public final EditText weight;

    protected FragmentOnboardingBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView birthday, TextView female, EditText height, ImageView imageView5, ImageView imageView7, LinearLayout layoutPage1, LinearLayout layoutPage2, LinearLayout layoutPage3, LinearLayout linearLayout2, LinearLayout linearLayout7, LinearLayout llPairViaBluetooth, LinearLayout llPairViaCloud, TextView male, View statusBarHeight, TextView titleHeight, TextView titleWeight, TextView tvNext, TextView tvPairLater, TextView tvSkip, View view1, View view2, View view3, EditText weight) {
        super(_bindingComponent, _root, _localFieldCount);
        this.birthday = birthday;
        this.female = female;
        this.height = height;
        this.imageView5 = imageView5;
        this.imageView7 = imageView7;
        this.layoutPage1 = layoutPage1;
        this.layoutPage2 = layoutPage2;
        this.layoutPage3 = layoutPage3;
        this.linearLayout2 = linearLayout2;
        this.linearLayout7 = linearLayout7;
        this.llPairViaBluetooth = llPairViaBluetooth;
        this.llPairViaCloud = llPairViaCloud;
        this.male = male;
        this.statusBarHeight = statusBarHeight;
        this.titleHeight = titleHeight;
        this.titleWeight = titleWeight;
        this.tvNext = tvNext;
        this.tvPairLater = tvPairLater;
        this.tvSkip = tvSkip;
        this.view1 = view1;
        this.view2 = view2;
        this.view3 = view3;
        this.weight = weight;
    }

    public static FragmentOnboardingBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentOnboardingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_onboarding, root, attachToRoot, component);
    }

    public static FragmentOnboardingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentOnboardingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_onboarding, null, false, component);
    }

    public static FragmentOnboardingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentOnboardingBinding bind(View view, Object component) {
        return (FragmentOnboardingBinding) bind(component, view, R.layout.fragment_onboarding);
    }
}
