package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class CustomSelectActivityBinding extends ViewDataBinding {
    public final LinearLayout LLBoxing;
    public final LinearLayout LLCycling;
    public final LinearLayout LLDone;
    public final LinearLayout LLElliptical;
    public final LinearLayout LLFullSweat;
    public final LinearLayout LLMeditation;
    public final LinearLayout LLRowing;
    public final LinearLayout LLSculpt;
    public final LinearLayout LLStretching;
    public final LinearLayout LLTreadmill;
    public final LinearLayout LLYoga;
    public final AppCompatImageView close;
    public final TextView done;
    public final ImageView imgBoxing;
    public final ImageView imgCycling;
    public final ImageView imgElliptical;
    public final ImageView imgFullSweat;
    public final ImageView imgMeditation;
    public final ImageView imgRowing;
    public final ImageView imgSculpt;
    public final ImageView imgStretching;
    public final ImageView imgTreadmill;
    public final ImageView imgYoga;
    public final TextView reset;
    public final TextView title;
    public final TextView tvBoxing;
    public final TextView tvCycling;
    public final TextView tvElliptical;
    public final TextView tvFullSweat;
    public final TextView tvMeditation;
    public final TextView tvRowing;
    public final TextView tvSculpt;
    public final TextView tvStretching;
    public final TextView tvTreadmill;
    public final TextView tvYoga;

    protected CustomSelectActivityBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLBoxing, LinearLayout LLCycling, LinearLayout LLDone, LinearLayout LLElliptical, LinearLayout LLFullSweat, LinearLayout LLMeditation, LinearLayout LLRowing, LinearLayout LLSculpt, LinearLayout LLStretching, LinearLayout LLTreadmill, LinearLayout LLYoga, AppCompatImageView close, TextView done, ImageView imgBoxing, ImageView imgCycling, ImageView imgElliptical, ImageView imgFullSweat, ImageView imgMeditation, ImageView imgRowing, ImageView imgSculpt, ImageView imgStretching, ImageView imgTreadmill, ImageView imgYoga, TextView reset, TextView title, TextView tvBoxing, TextView tvCycling, TextView tvElliptical, TextView tvFullSweat, TextView tvMeditation, TextView tvRowing, TextView tvSculpt, TextView tvStretching, TextView tvTreadmill, TextView tvYoga) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLBoxing = LLBoxing;
        this.LLCycling = LLCycling;
        this.LLDone = LLDone;
        this.LLElliptical = LLElliptical;
        this.LLFullSweat = LLFullSweat;
        this.LLMeditation = LLMeditation;
        this.LLRowing = LLRowing;
        this.LLSculpt = LLSculpt;
        this.LLStretching = LLStretching;
        this.LLTreadmill = LLTreadmill;
        this.LLYoga = LLYoga;
        this.close = close;
        this.done = done;
        this.imgBoxing = imgBoxing;
        this.imgCycling = imgCycling;
        this.imgElliptical = imgElliptical;
        this.imgFullSweat = imgFullSweat;
        this.imgMeditation = imgMeditation;
        this.imgRowing = imgRowing;
        this.imgSculpt = imgSculpt;
        this.imgStretching = imgStretching;
        this.imgTreadmill = imgTreadmill;
        this.imgYoga = imgYoga;
        this.reset = reset;
        this.title = title;
        this.tvBoxing = tvBoxing;
        this.tvCycling = tvCycling;
        this.tvElliptical = tvElliptical;
        this.tvFullSweat = tvFullSweat;
        this.tvMeditation = tvMeditation;
        this.tvRowing = tvRowing;
        this.tvSculpt = tvSculpt;
        this.tvStretching = tvStretching;
        this.tvTreadmill = tvTreadmill;
        this.tvYoga = tvYoga;
    }

    public static CustomSelectActivityBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectActivityBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSelectActivityBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_activity, root, attachToRoot, component);
    }

    public static CustomSelectActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectActivityBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSelectActivityBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_activity, null, false, component);
    }

    public static CustomSelectActivityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectActivityBinding bind(View view, Object component) {
        return (CustomSelectActivityBinding) bind(component, view, R.layout.custom_select_activity);
    }
}
