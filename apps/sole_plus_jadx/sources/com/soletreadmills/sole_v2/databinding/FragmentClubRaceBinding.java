package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.AnimatedPathImageView;

/* loaded from: classes5.dex */
public abstract class FragmentClubRaceBinding extends ViewDataBinding {
    public final LinearLayout LLLeave;
    public final AnimatedPathImageView animatedPathImageView;
    public final ImageView bleMachine;
    public final ImageView bleWatch;
    public final ImageView imgDisplay1;
    public final ImageView imgDisplay2;
    public final ImageView imgDisplay3;
    public final ImageView imgDisplay4;
    public final ImageView imgLeave;
    public final ImageView imgMachine;
    public final ImageView imgShadowBottom;
    public final ImageView imgShadowTop;
    public final ImageView imgWatch;
    public final LinearLayout layoutDisplay1;
    public final LinearLayout layoutDisplay1Click;
    public final LinearLayout layoutDisplay2;
    public final LinearLayout layoutDisplay2Click;
    public final LinearLayout layoutDisplay3Click;
    public final LinearLayout layoutDisplay4Click;
    public final LinearLayout layoutDistance;
    public final LinearLayout layoutStart;
    public final ConstraintLayout layoutTopView;
    public final LinearLayout linearLayout14;
    public final LinearLayout linearLayout15;
    public final LinearLayout linearLayout17;
    public final LinearLayout linearLayout18;
    public final ProgressBar progressBar;
    public final LinearLayout start;
    public final View statusBarHeight;
    public final TextView tvDisplay1;
    public final TextView tvDisplay1Title;
    public final TextView tvDisplay2;
    public final TextView tvDisplay2Title;
    public final TextView tvDisplay3;
    public final TextView tvDisplay3Title;
    public final TextView tvDisplay4;
    public final TextView tvDisplay4Title;
    public final TextView tvDistance;
    public final TextView tvLap;
    public final TextView tvStartOrFinish;

    protected FragmentClubRaceBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLLeave, AnimatedPathImageView animatedPathImageView, ImageView bleMachine, ImageView bleWatch, ImageView imgDisplay1, ImageView imgDisplay2, ImageView imgDisplay3, ImageView imgDisplay4, ImageView imgLeave, ImageView imgMachine, ImageView imgShadowBottom, ImageView imgShadowTop, ImageView imgWatch, LinearLayout layoutDisplay1, LinearLayout layoutDisplay1Click, LinearLayout layoutDisplay2, LinearLayout layoutDisplay2Click, LinearLayout layoutDisplay3Click, LinearLayout layoutDisplay4Click, LinearLayout layoutDistance, LinearLayout layoutStart, ConstraintLayout layoutTopView, LinearLayout linearLayout14, LinearLayout linearLayout15, LinearLayout linearLayout17, LinearLayout linearLayout18, ProgressBar progressBar, LinearLayout start, View statusBarHeight, TextView tvDisplay1, TextView tvDisplay1Title, TextView tvDisplay2, TextView tvDisplay2Title, TextView tvDisplay3, TextView tvDisplay3Title, TextView tvDisplay4, TextView tvDisplay4Title, TextView tvDistance, TextView tvLap, TextView tvStartOrFinish) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLLeave = LLLeave;
        this.animatedPathImageView = animatedPathImageView;
        this.bleMachine = bleMachine;
        this.bleWatch = bleWatch;
        this.imgDisplay1 = imgDisplay1;
        this.imgDisplay2 = imgDisplay2;
        this.imgDisplay3 = imgDisplay3;
        this.imgDisplay4 = imgDisplay4;
        this.imgLeave = imgLeave;
        this.imgMachine = imgMachine;
        this.imgShadowBottom = imgShadowBottom;
        this.imgShadowTop = imgShadowTop;
        this.imgWatch = imgWatch;
        this.layoutDisplay1 = layoutDisplay1;
        this.layoutDisplay1Click = layoutDisplay1Click;
        this.layoutDisplay2 = layoutDisplay2;
        this.layoutDisplay2Click = layoutDisplay2Click;
        this.layoutDisplay3Click = layoutDisplay3Click;
        this.layoutDisplay4Click = layoutDisplay4Click;
        this.layoutDistance = layoutDistance;
        this.layoutStart = layoutStart;
        this.layoutTopView = layoutTopView;
        this.linearLayout14 = linearLayout14;
        this.linearLayout15 = linearLayout15;
        this.linearLayout17 = linearLayout17;
        this.linearLayout18 = linearLayout18;
        this.progressBar = progressBar;
        this.start = start;
        this.statusBarHeight = statusBarHeight;
        this.tvDisplay1 = tvDisplay1;
        this.tvDisplay1Title = tvDisplay1Title;
        this.tvDisplay2 = tvDisplay2;
        this.tvDisplay2Title = tvDisplay2Title;
        this.tvDisplay3 = tvDisplay3;
        this.tvDisplay3Title = tvDisplay3Title;
        this.tvDisplay4 = tvDisplay4;
        this.tvDisplay4Title = tvDisplay4Title;
        this.tvDistance = tvDistance;
        this.tvLap = tvLap;
        this.tvStartOrFinish = tvStartOrFinish;
    }

    public static FragmentClubRaceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubRaceBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentClubRaceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_race, root, attachToRoot, component);
    }

    public static FragmentClubRaceBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubRaceBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentClubRaceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_club_race, null, false, component);
    }

    public static FragmentClubRaceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentClubRaceBinding bind(View view, Object component) {
        return (FragmentClubRaceBinding) bind(component, view, R.layout.fragment_club_race);
    }
}
