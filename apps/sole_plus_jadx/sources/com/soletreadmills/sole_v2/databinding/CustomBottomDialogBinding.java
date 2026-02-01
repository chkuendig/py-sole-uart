package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomBottomDialogBinding extends ViewDataBinding {
    public final LinearLayout LLDone;
    public final AppCompatImageView close;
    public final TextView done;
    public final TextView email;
    public final TextView msg;
    public final TextView reset;
    public final TextView title;

    protected CustomBottomDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLDone, AppCompatImageView close, TextView done, TextView email, TextView msg, TextView reset, TextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLDone = LLDone;
        this.close = close;
        this.done = done;
        this.email = email;
        this.msg = msg;
        this.reset = reset;
        this.title = title;
    }

    public static CustomBottomDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomBottomDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomBottomDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_bottom_dialog, root, attachToRoot, component);
    }

    public static CustomBottomDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomBottomDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomBottomDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_bottom_dialog, null, false, component);
    }

    public static CustomBottomDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomBottomDialogBinding bind(View view, Object component) {
        return (CustomBottomDialogBinding) bind(component, view, R.layout.custom_bottom_dialog);
    }
}
