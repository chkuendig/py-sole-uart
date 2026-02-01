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
public abstract class AdapterClubMemberScoreItemBinding extends ViewDataBinding {
    public final LinearLayout llBg;
    public final LinearLayout llScoreboardWrap;
    public final TextView tvDate;
    public final TextView tvOrderNum;
    public final TextView tvScoreValue;
    public final TextView tvUnit;

    protected AdapterClubMemberScoreItemBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout llBg, LinearLayout llScoreboardWrap, TextView tvDate, TextView tvOrderNum, TextView tvScoreValue, TextView tvUnit) {
        super(_bindingComponent, _root, _localFieldCount);
        this.llBg = llBg;
        this.llScoreboardWrap = llScoreboardWrap;
        this.tvDate = tvDate;
        this.tvOrderNum = tvOrderNum;
        this.tvScoreValue = tvScoreValue;
        this.tvUnit = tvUnit;
    }

    public static AdapterClubMemberScoreItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubMemberScoreItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubMemberScoreItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_member_score_item, root, attachToRoot, component);
    }

    public static AdapterClubMemberScoreItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubMemberScoreItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubMemberScoreItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_member_score_item, null, false, component);
    }

    public static AdapterClubMemberScoreItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubMemberScoreItemBinding bind(View view, Object component) {
        return (AdapterClubMemberScoreItemBinding) bind(component, view, R.layout.adapter_club_member_score_item);
    }
}
