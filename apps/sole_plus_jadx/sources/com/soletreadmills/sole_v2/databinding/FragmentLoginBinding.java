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
public abstract class FragmentLoginBinding extends ViewDataBinding {
    public final LinearLayout LLLogin;
    public final LinearLayout LLPassword;
    public final ImageView back;
    public final EditText edtEmail;
    public final EditText edtPassword;
    public final ImageView endImg;
    public final ImageView imgEmailClear;
    public final ImageView imgEye;
    public final ImageView imgPasswordClear;
    public final LinearLayout llEmail;
    public final View statusBarHeight;
    public final TextView textView2;
    public final ConstraintLayout topbar;
    public final TextView tvEmailAlertText;
    public final TextView tvForgotPassword;
    public final TextView tvPasswordAlertText;

    protected FragmentLoginBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLLogin, LinearLayout LLPassword, ImageView back, EditText edtEmail, EditText edtPassword, ImageView endImg, ImageView imgEmailClear, ImageView imgEye, ImageView imgPasswordClear, LinearLayout llEmail, View statusBarHeight, TextView textView2, ConstraintLayout topbar, TextView tvEmailAlertText, TextView tvForgotPassword, TextView tvPasswordAlertText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLLogin = LLLogin;
        this.LLPassword = LLPassword;
        this.back = back;
        this.edtEmail = edtEmail;
        this.edtPassword = edtPassword;
        this.endImg = endImg;
        this.imgEmailClear = imgEmailClear;
        this.imgEye = imgEye;
        this.imgPasswordClear = imgPasswordClear;
        this.llEmail = llEmail;
        this.statusBarHeight = statusBarHeight;
        this.textView2 = textView2;
        this.topbar = topbar;
        this.tvEmailAlertText = tvEmailAlertText;
        this.tvForgotPassword = tvForgotPassword;
        this.tvPasswordAlertText = tvPasswordAlertText;
    }

    public static FragmentLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLoginBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentLoginBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_login, root, attachToRoot, component);
    }

    public static FragmentLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLoginBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentLoginBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_login, null, false, component);
    }

    public static FragmentLoginBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLoginBinding bind(View view, Object component) {
        return (FragmentLoginBinding) bind(component, view, R.layout.fragment_login);
    }
}
