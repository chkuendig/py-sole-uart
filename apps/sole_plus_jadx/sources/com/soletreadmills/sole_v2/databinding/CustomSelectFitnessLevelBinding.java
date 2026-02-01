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
public abstract class CustomSelectFitnessLevelBinding extends ViewDataBinding {
    public final LinearLayout LLAnyLevel;
    public final LinearLayout LLDone;
    public final LinearLayout LLExpert;
    public final LinearLayout LLNovice;
    public final LinearLayout LLSkilled;
    public final AppCompatImageView close;
    public final TextView done;
    public final ImageView imgAnyLevel;
    public final ImageView imgExpert;
    public final ImageView imgNovice;
    public final ImageView imgSkilled;
    public final TextView reset;
    public final TextView title;
    public final TextView txtAnyLevel;
    public final TextView txtExpert;
    public final TextView txtNovice;
    public final TextView txtSkilled;

    protected CustomSelectFitnessLevelBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLAnyLevel, LinearLayout LLDone, LinearLayout LLExpert, LinearLayout LLNovice, LinearLayout LLSkilled, AppCompatImageView close, TextView done, ImageView imgAnyLevel, ImageView imgExpert, ImageView imgNovice, ImageView imgSkilled, TextView reset, TextView title, TextView txtAnyLevel, TextView txtExpert, TextView txtNovice, TextView txtSkilled) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLAnyLevel = LLAnyLevel;
        this.LLDone = LLDone;
        this.LLExpert = LLExpert;
        this.LLNovice = LLNovice;
        this.LLSkilled = LLSkilled;
        this.close = close;
        this.done = done;
        this.imgAnyLevel = imgAnyLevel;
        this.imgExpert = imgExpert;
        this.imgNovice = imgNovice;
        this.imgSkilled = imgSkilled;
        this.reset = reset;
        this.title = title;
        this.txtAnyLevel = txtAnyLevel;
        this.txtExpert = txtExpert;
        this.txtNovice = txtNovice;
        this.txtSkilled = txtSkilled;
    }

    public static CustomSelectFitnessLevelBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectFitnessLevelBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CustomSelectFitnessLevelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_fitness_level, root, attachToRoot, component);
    }

    public static CustomSelectFitnessLevelBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectFitnessLevelBinding inflate(LayoutInflater inflater, Object component) {
        return (CustomSelectFitnessLevelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.custom_select_fitness_level, null, false, component);
    }

    public static CustomSelectFitnessLevelBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CustomSelectFitnessLevelBinding bind(View view, Object component) {
        return (CustomSelectFitnessLevelBinding) bind(component, view, R.layout.custom_select_fitness_level);
    }
}
