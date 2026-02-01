package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSignUpBinding extends ViewDataBinding {
    public final ConstraintLayout CLProgressbar;
    public final LinearLayout LLEmail;
    public final LinearLayout LLPassword;
    public final LinearLayout LLSignUpWithEmail;
    public final ImageView back;
    public final EditText edtEmail;
    public final EditText edtPassword;
    public final ImageView endImg;
    public final ImageView imgEmailClear;
    public final ImageView imgEye;
    public final ImageView imgPasswordClear;
    public final LinearLayout linearLayout;
    public final ProgressBar progressBar;
    public final View statusBarHeight;
    public final TextView textView2;
    public final TextView textView4;
    public final ConstraintLayout topbar;
    public final TextView tvEmailAlertText;
    public final TextView tvPasswordAlertText;
    public final TextView tvTerms;

    protected FragmentSignUpBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout CLProgressbar, LinearLayout LLEmail, LinearLayout LLPassword, LinearLayout LLSignUpWithEmail, ImageView back, EditText edtEmail, EditText edtPassword, ImageView endImg, ImageView imgEmailClear, ImageView imgEye, ImageView imgPasswordClear, LinearLayout linearLayout, ProgressBar progressBar, View statusBarHeight, TextView textView2, TextView textView4, ConstraintLayout topbar, TextView tvEmailAlertText, TextView tvPasswordAlertText, TextView tvTerms) {
        super(_bindingComponent, _root, _localFieldCount);
        this.CLProgressbar = CLProgressbar;
        this.LLEmail = LLEmail;
        this.LLPassword = LLPassword;
        this.LLSignUpWithEmail = LLSignUpWithEmail;
        this.back = back;
        this.edtEmail = edtEmail;
        this.edtPassword = edtPassword;
        this.endImg = endImg;
        this.imgEmailClear = imgEmailClear;
        this.imgEye = imgEye;
        this.imgPasswordClear = imgPasswordClear;
        this.linearLayout = linearLayout;
        this.progressBar = progressBar;
        this.statusBarHeight = statusBarHeight;
        this.textView2 = textView2;
        this.textView4 = textView4;
        this.topbar = topbar;
        this.tvEmailAlertText = tvEmailAlertText;
        this.tvPasswordAlertText = tvPasswordAlertText;
        this.tvTerms = tvTerms;
    }

    public static FragmentSignUpBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignUpBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSignUpBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sign_up, root, attachToRoot, component);
    }

    public static FragmentSignUpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignUpBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSignUpBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_sign_up, null, false, component);
    }

    public static FragmentSignUpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSignUpBinding bind(View view, Object component) {
        return (FragmentSignUpBinding) bind(component, view, R.layout.fragment_sign_up);
    }
}
