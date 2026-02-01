package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentVerifyEmailBinding extends ViewDataBinding {
    public final ImageView back;
    public final LinearLayout clear;
    public final LinearLayout delete;
    public final EditText edt1;
    public final EditText edt2;
    public final EditText edt3;
    public final EditText edt4;
    public final EditText edt5;
    public final EditText edt6;
    public final TextView email;
    public final ImageView endImg;
    public final ImageView imageView18;
    public final ImageView imageView19;
    public final TextView number0;
    public final TextView number1;
    public final TextView number2;
    public final TextView number3;
    public final TextView number4;
    public final TextView number5;
    public final TextView number6;
    public final TextView number7;
    public final TextView number8;
    public final TextView number9;
    public final TextView resendCode;
    public final TextView resendCodeDelayCount;
    public final View statusBarHeight;
    public final TextView title;
    public final ConstraintLayout topbar;

    protected FragmentVerifyEmailBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView back, LinearLayout clear, LinearLayout delete, EditText edt1, EditText edt2, EditText edt3, EditText edt4, EditText edt5, EditText edt6, TextView email, ImageView endImg, ImageView imageView18, ImageView imageView19, TextView number0, TextView number1, TextView number2, TextView number3, TextView number4, TextView number5, TextView number6, TextView number7, TextView number8, TextView number9, TextView resendCode, TextView resendCodeDelayCount, View statusBarHeight, TextView title, ConstraintLayout topbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.back = back;
        this.clear = clear;
        this.delete = delete;
        this.edt1 = edt1;
        this.edt2 = edt2;
        this.edt3 = edt3;
        this.edt4 = edt4;
        this.edt5 = edt5;
        this.edt6 = edt6;
        this.email = email;
        this.endImg = endImg;
        this.imageView18 = imageView18;
        this.imageView19 = imageView19;
        this.number0 = number0;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
        this.number7 = number7;
        this.number8 = number8;
        this.number9 = number9;
        this.resendCode = resendCode;
        this.resendCodeDelayCount = resendCodeDelayCount;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
        this.topbar = topbar;
    }

    public static FragmentVerifyEmailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentVerifyEmailBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentVerifyEmailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_verify_email, root, attachToRoot, component);
    }

    public static FragmentVerifyEmailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentVerifyEmailBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentVerifyEmailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_verify_email, null, false, component);
    }

    public static FragmentVerifyEmailBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentVerifyEmailBinding bind(View view, Object component) {
        return (FragmentVerifyEmailBinding) bind(component, view, R.layout.fragment_verify_email);
    }
}
