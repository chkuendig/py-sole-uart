package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentSettingProfileBinding extends ViewDataBinding {
    public final LinearLayout LLEdit;
    public final LinearLayout LLEditProfile;
    public final ImageView back;
    public final TextView birthday;
    public final ImageView endImg;
    public final TextView gender;
    public final TextView globalUserUuid;
    public final TextView height;
    public final ImageView imgHead;
    public final TextView name;
    public final View statusBarHeight;
    public final TextView title;
    public final ConstraintLayout topbar;
    public final TextView weight;
    public final TextView years;

    protected FragmentSettingProfileBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLEdit, LinearLayout LLEditProfile, ImageView back, TextView birthday, ImageView endImg, TextView gender, TextView globalUserUuid, TextView height, ImageView imgHead, TextView name, View statusBarHeight, TextView title, ConstraintLayout topbar, TextView weight, TextView years) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLEdit = LLEdit;
        this.LLEditProfile = LLEditProfile;
        this.back = back;
        this.birthday = birthday;
        this.endImg = endImg;
        this.gender = gender;
        this.globalUserUuid = globalUserUuid;
        this.height = height;
        this.imgHead = imgHead;
        this.name = name;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
        this.topbar = topbar;
        this.weight = weight;
        this.years = years;
    }

    public static FragmentSettingProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentSettingProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_setting_profile, root, attachToRoot, component);
    }

    public static FragmentSettingProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingProfileBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentSettingProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_setting_profile, null, false, component);
    }

    public static FragmentSettingProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSettingProfileBinding bind(View view, Object component) {
        return (FragmentSettingProfileBinding) bind(component, view, R.layout.fragment_setting_profile);
    }
}
