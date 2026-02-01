package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentHowToLinkProfileBinding extends ViewDataBinding {
    public final ImageView back;
    public final ImageView endImg;
    public final View statusBarHeight;
    public final TextView textView2;
    public final ConstraintLayout topbar;

    protected FragmentHowToLinkProfileBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView back, ImageView endImg, View statusBarHeight, TextView textView2, ConstraintLayout topbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.back = back;
        this.endImg = endImg;
        this.statusBarHeight = statusBarHeight;
        this.textView2 = textView2;
        this.topbar = topbar;
    }

    public static FragmentHowToLinkProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHowToLinkProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentHowToLinkProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_how_to_link_profile, root, attachToRoot, component);
    }

    public static FragmentHowToLinkProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHowToLinkProfileBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentHowToLinkProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_how_to_link_profile, null, false, component);
    }

    public static FragmentHowToLinkProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHowToLinkProfileBinding bind(View view, Object component) {
        return (FragmentHowToLinkProfileBinding) bind(component, view, R.layout.fragment_how_to_link_profile);
    }
}
