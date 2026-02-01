package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentEditProfileBinding extends ViewDataBinding {
    public final TextView birthday;
    public final TextView cancel;
    public final TextView female;
    public final EditText height;
    public final LinearLayout linearLayout7;
    public final TextView male;
    public final EditText name;
    public final TextView other;
    public final TextView save;
    public final View statusBarHeight;
    public final TextView title;
    public final TextView titleHeight;
    public final TextView titleWeight;
    public final EditText weight;

    protected FragmentEditProfileBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView birthday, TextView cancel, TextView female, EditText height, LinearLayout linearLayout7, TextView male, EditText name, TextView other, TextView save, View statusBarHeight, TextView title, TextView titleHeight, TextView titleWeight, EditText weight) {
        super(_bindingComponent, _root, _localFieldCount);
        this.birthday = birthday;
        this.cancel = cancel;
        this.female = female;
        this.height = height;
        this.linearLayout7 = linearLayout7;
        this.male = male;
        this.name = name;
        this.other = other;
        this.save = save;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
        this.titleHeight = titleHeight;
        this.titleWeight = titleWeight;
        this.weight = weight;
    }

    public static FragmentEditProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEditProfileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentEditProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_edit_profile, root, attachToRoot, component);
    }

    public static FragmentEditProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEditProfileBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentEditProfileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_edit_profile, null, false, component);
    }

    public static FragmentEditProfileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEditProfileBinding bind(View view, Object component) {
        return (FragmentEditProfileBinding) bind(component, view, R.layout.fragment_edit_profile);
    }
}
