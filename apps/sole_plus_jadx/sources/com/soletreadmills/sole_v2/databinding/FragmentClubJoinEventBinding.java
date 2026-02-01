package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentClubJoinEventBinding extends ViewDataBinding {
    public final Button btn0;
    public final Button btn1;
    public final Button btn2;
    public final Button btn3;
    public final Button btn4;
    public final Button btn5;
    public final Button btn6;
    public final Button btn7;
    public final Button btn8;
    public final Button btn9;
    public final LinearLayout btnDelete;
    public final Button btnDot;
    public final EditText etDigit1;
    public final EditText etDigit2;
    public final EditText etDigit3;
    public final EditText etDigit4;
    public final EditText etDigit5;
    public final EditText etDigit6;
    public final LinearLayout llOtpWrap;
    public final View statusBarHeight;
    public final ConstraintLayout tobBar;
    public final TextView tvCancel;

    protected FragmentClubJoinEventBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btn0, Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btn7, Button btn8, Button btn9, LinearLayout btnDelete, Button btnDot, EditText etDigit1, EditText etDigit2, EditText etDigit3, EditText etDigit4, EditText etDigit5, EditText etDigit6, LinearLayout llOtpWrap, View statusBarHeight, ConstraintLayout tobBar, TextView tvCancel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btn0 = btn0;
        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;
        this.btn4 = btn4;
        this.btn5 = btn5;
        this.btn6 = btn6;
        this.btn7 = btn7;
        this.btn8 = btn8;
        this.btn9 = btn9;
        this.btnDelete = btnDelete;
        this.btnDot = btnDot;
        this.etDigit1 = etDigit1;
        this.etDigit2 = etDigit2;
        this.etDigit3 = etDigit3;
        this.etDigit4 = etDigit4;
        this.etDigit5 = etDigit5;
        this.etDigit6 = etDigit6;
        this.llOtpWrap = llOtpWrap;
        this.statusBarHeight = statusBarHeight;
        this.tobBar = tobBar;
        this.tvCancel = tvCancel;
    }

    public static FragmentClubJoinEventBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubJoinEventBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubJoinEventBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_join_event, root, attachToRoot, component);
    }

    public static FragmentClubJoinEventBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubJoinEventBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubJoinEventBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_join_event, null, false, component);
    }

    public static FragmentClubJoinEventBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubJoinEventBinding bind(View view, Object component) {
        return (FragmentClubJoinEventBinding) bind(component, view, R.layout.fragment_club_join_event);
    }
}
