package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentWorkoutSettingsBinding extends ViewDataBinding {
    public final LinearLayout LLLanguage;
    public final LinearLayout LLMaxResistance;
    public final LinearLayout LLMaxSpeed;
    public final LinearLayout LLRotateAutomatically;
    public final LinearLayout LLRotateEvery;
    public final LinearLayout LLTargetTime;
    public final TextView done;
    public final ImageView imageView20;
    public final ImageView imageView21;
    public final TextView language;
    public final LinearLayout linearLayout7;
    public final TextView reset;
    public final SeekBar seekBar;
    public final View statusBarHeight;
    public final Switch switchAutomatically;
    public final Switch switchShowSubtitles;
    public final TextView title;
    public final TextView tvMaxResistance;
    public final TextView tvMaxSpeed;
    public final TextView tvRotateEvery;
    public final TextView tvTargetTime;
    public final TextView volumeValue;

    protected FragmentWorkoutSettingsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLLanguage, LinearLayout LLMaxResistance, LinearLayout LLMaxSpeed, LinearLayout LLRotateAutomatically, LinearLayout LLRotateEvery, LinearLayout LLTargetTime, TextView done, ImageView imageView20, ImageView imageView21, TextView language, LinearLayout linearLayout7, TextView reset, SeekBar seekBar, View statusBarHeight, Switch switchAutomatically, Switch switchShowSubtitles, TextView title, TextView tvMaxResistance, TextView tvMaxSpeed, TextView tvRotateEvery, TextView tvTargetTime, TextView volumeValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLLanguage = LLLanguage;
        this.LLMaxResistance = LLMaxResistance;
        this.LLMaxSpeed = LLMaxSpeed;
        this.LLRotateAutomatically = LLRotateAutomatically;
        this.LLRotateEvery = LLRotateEvery;
        this.LLTargetTime = LLTargetTime;
        this.done = done;
        this.imageView20 = imageView20;
        this.imageView21 = imageView21;
        this.language = language;
        this.linearLayout7 = linearLayout7;
        this.reset = reset;
        this.seekBar = seekBar;
        this.statusBarHeight = statusBarHeight;
        this.switchAutomatically = switchAutomatically;
        this.switchShowSubtitles = switchShowSubtitles;
        this.title = title;
        this.tvMaxResistance = tvMaxResistance;
        this.tvMaxSpeed = tvMaxSpeed;
        this.tvRotateEvery = tvRotateEvery;
        this.tvTargetTime = tvTargetTime;
        this.volumeValue = volumeValue;
    }

    public static FragmentWorkoutSettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWorkoutSettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentWorkoutSettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_workout_settings, root, attachToRoot, component);
    }

    public static FragmentWorkoutSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWorkoutSettingsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentWorkoutSettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_workout_settings, null, false, component);
    }

    public static FragmentWorkoutSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWorkoutSettingsBinding bind(View view, Object component) {
        return (FragmentWorkoutSettingsBinding) bind(component, view, R.layout.fragment_workout_settings);
    }
}
