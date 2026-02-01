package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterLanguageSettingsBinding extends ViewDataBinding {
    public final AppCompatImageView img;
    public final LinearLayoutCompat mainLayout;
    public final AppCompatTextView title;

    protected AdapterLanguageSettingsBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView img, LinearLayoutCompat mainLayout, AppCompatTextView title) {
        super(_bindingComponent, _root, _localFieldCount);
        this.img = img;
        this.mainLayout = mainLayout;
        this.title = title;
    }

    public static AdapterLanguageSettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLanguageSettingsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterLanguageSettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_language_settings, root, attachToRoot, component);
    }

    public static AdapterLanguageSettingsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLanguageSettingsBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterLanguageSettingsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_language_settings, null, false, component);
    }

    public static AdapterLanguageSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterLanguageSettingsBinding bind(View view, Object component) {
        return (AdapterLanguageSettingsBinding) bind(component, view, R.layout.adapter_language_settings);
    }
}
