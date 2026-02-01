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
public abstract class FragmentResetPasswordBinding extends ViewDataBinding {
    public final LinearLayout LLResetLink;
    public final LinearLayout LLSend;
    public final ImageView back;
    public final EditText edtEmail;
    public final ImageView endImg;
    public final ImageView imageView6;
    public final ImageView imgClear;
    public final LinearLayout linearLayout4;
    public final LinearLayout llEmail;
    public final View statusBarHeight;
    public final TextView textView2;
    public final TextView textView5;
    public final ConstraintLayout topbar;
    public final TextView tvEmailAlertText;

    protected FragmentResetPasswordBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLResetLink, LinearLayout LLSend, ImageView back, EditText edtEmail, ImageView endImg, ImageView imageView6, ImageView imgClear, LinearLayout linearLayout4, LinearLayout llEmail, View statusBarHeight, TextView textView2, TextView textView5, ConstraintLayout topbar, TextView tvEmailAlertText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLResetLink = LLResetLink;
        this.LLSend = LLSend;
        this.back = back;
        this.edtEmail = edtEmail;
        this.endImg = endImg;
        this.imageView6 = imageView6;
        this.imgClear = imgClear;
        this.linearLayout4 = linearLayout4;
        this.llEmail = llEmail;
        this.statusBarHeight = statusBarHeight;
        this.textView2 = textView2;
        this.textView5 = textView5;
        this.topbar = topbar;
        this.tvEmailAlertText = tvEmailAlertText;
    }

    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentResetPasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_reset_password, root, attachToRoot, component);
    }

    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResetPasswordBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentResetPasswordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_reset_password, null, false, component);
    }

    public static FragmentResetPasswordBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentResetPasswordBinding bind(View view, Object component) {
        return (FragmentResetPasswordBinding) bind(component, view, R.layout.fragment_reset_password);
    }
}
