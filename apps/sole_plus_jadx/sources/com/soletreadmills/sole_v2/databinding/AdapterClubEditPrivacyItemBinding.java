package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterClubEditPrivacyItemBinding extends ViewDataBinding {
    public final LinearLayout llBtnWrap;
    public final TextView tvBtn;
    public final ImageView tvIcon;

    protected AdapterClubEditPrivacyItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llBtnWrap, TextView tvBtn, ImageView tvIcon) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llBtnWrap = llBtnWrap;
        this.tvBtn = tvBtn;
        this.tvIcon = tvIcon;
    }

    public static AdapterClubEditPrivacyItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubEditPrivacyItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubEditPrivacyItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_edit_privacy_item, root, attachToRoot, component);
    }

    public static AdapterClubEditPrivacyItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubEditPrivacyItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubEditPrivacyItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_edit_privacy_item, null, false, component);
    }

    public static AdapterClubEditPrivacyItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubEditPrivacyItemBinding bind(View view, Object component) {
        return (AdapterClubEditPrivacyItemBinding) bind(component, view, R.layout.adapter_club_edit_privacy_item);
    }
}
