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
public abstract class AdapterClubScoreboardItemBinding extends ViewDataBinding {
    public final ImageView imgArrow;
    public final ImageView imgAvatar;
    public final ImageView imgDelete;
    public final View imgIsSelf;
    public final LinearLayout llBg;
    public final LinearLayout llScoreboardWrap;
    public final TextView tvRank;
    public final TextView tvScoreValue;
    public final TextView tvUnit;
    public final TextView tvUsername;

    protected AdapterClubScoreboardItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imgArrow, ImageView imgAvatar, ImageView imgDelete, View imgIsSelf, LinearLayout llBg, LinearLayout llScoreboardWrap, TextView tvRank, TextView tvScoreValue, TextView tvUnit, TextView tvUsername) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imgArrow = imgArrow;
        this.imgAvatar = imgAvatar;
        this.imgDelete = imgDelete;
        this.imgIsSelf = imgIsSelf;
        this.llBg = llBg;
        this.llScoreboardWrap = llScoreboardWrap;
        this.tvRank = tvRank;
        this.tvScoreValue = tvScoreValue;
        this.tvUnit = tvUnit;
        this.tvUsername = tvUsername;
    }

    public static AdapterClubScoreboardItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubScoreboardItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubScoreboardItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_scoreboard_item, root, attachToRoot, component);
    }

    public static AdapterClubScoreboardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubScoreboardItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubScoreboardItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_scoreboard_item, null, false, component);
    }

    public static AdapterClubScoreboardItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubScoreboardItemBinding bind(View view, Object component) {
        return (AdapterClubScoreboardItemBinding) bind(component, view, R.layout.adapter_club_scoreboard_item);
    }
}
