package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterClubEditScoreItemBinding extends ViewDataBinding {
    public final LinearLayout llBtnWrap;
    public final TextView tvBtn;

    protected AdapterClubEditScoreItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llBtnWrap, TextView tvBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llBtnWrap = llBtnWrap;
        this.tvBtn = tvBtn;
    }

    public static AdapterClubEditScoreItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubEditScoreItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubEditScoreItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_edit_score_item, root, attachToRoot, component);
    }

    public static AdapterClubEditScoreItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubEditScoreItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubEditScoreItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_edit_score_item, null, false, component);
    }

    public static AdapterClubEditScoreItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubEditScoreItemBinding bind(View view, Object component) {
        return (AdapterClubEditScoreItemBinding) bind(component, view, R.layout.adapter_club_edit_score_item);
    }
}
