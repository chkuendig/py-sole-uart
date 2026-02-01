package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentChooseBinding extends ViewDataBinding {
    public final LinearLayout LLFB;
    public final LinearLayout LLGoogle;
    public final LinearLayout LLLogin;
    public final LinearLayout LLSignup;
    public final ImageView imageView2;
    public final ImageView imageView3;
    public final ImageView imageView4;
    public final View statusBarHeight;
    public final TextView textView;
    public final TextView tvTerms;
    public final VideoView videoView;
    public final View view;

    protected FragmentChooseBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLFB, LinearLayout LLGoogle, LinearLayout LLLogin, LinearLayout LLSignup, ImageView imageView2, ImageView imageView3, ImageView imageView4, View statusBarHeight, TextView textView, TextView tvTerms, VideoView videoView, View view) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLFB = LLFB;
        this.LLGoogle = LLGoogle;
        this.LLLogin = LLLogin;
        this.LLSignup = LLSignup;
        this.imageView2 = imageView2;
        this.imageView3 = imageView3;
        this.imageView4 = imageView4;
        this.statusBarHeight = statusBarHeight;
        this.textView = textView;
        this.tvTerms = tvTerms;
        this.videoView = videoView;
        this.view = view;
    }

    public static FragmentChooseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChooseBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentChooseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_choose, root, attachToRoot, component);
    }

    public static FragmentChooseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChooseBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentChooseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_choose, null, false, component);
    }

    public static FragmentChooseBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChooseBinding bind(View view, Object component) {
        return (FragmentChooseBinding) bind(component, view, R.layout.fragment_choose);
    }
}
