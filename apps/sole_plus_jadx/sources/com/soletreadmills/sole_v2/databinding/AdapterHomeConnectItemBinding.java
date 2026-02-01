package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterHomeConnectItemBinding extends ViewDataBinding {
    public final CardView card;
    public final CardView cardImg;
    public final ImageView imageView11;
    public final ImageView imageView12;
    public final ImageView imageView15;
    public final ImageView img;
    public final ImageView imgCircle;
    public final LinearLayout layoutAdd;
    public final LinearLayout layoutConnect;
    public final LinearLayout llBrowsePrograms;
    public final LinearLayout llConnectingBoard;
    public final LinearLayout llDisconnect;
    public final LinearLayout llDisplayStats;
    public final LinearLayout llQuickStart;
    public final TextView tvName;
    public final TextView tvStatus;
    public final TextView tvTitle;

    protected AdapterHomeConnectItemBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView card, CardView cardImg, ImageView imageView11, ImageView imageView12, ImageView imageView15, ImageView img, ImageView imgCircle, LinearLayout layoutAdd, LinearLayout layoutConnect, LinearLayout llBrowsePrograms, LinearLayout llConnectingBoard, LinearLayout llDisconnect, LinearLayout llDisplayStats, LinearLayout llQuickStart, TextView tvName, TextView tvStatus, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card = card;
        this.cardImg = cardImg;
        this.imageView11 = imageView11;
        this.imageView12 = imageView12;
        this.imageView15 = imageView15;
        this.img = img;
        this.imgCircle = imgCircle;
        this.layoutAdd = layoutAdd;
        this.layoutConnect = layoutConnect;
        this.llBrowsePrograms = llBrowsePrograms;
        this.llConnectingBoard = llConnectingBoard;
        this.llDisconnect = llDisconnect;
        this.llDisplayStats = llDisplayStats;
        this.llQuickStart = llQuickStart;
        this.tvName = tvName;
        this.tvStatus = tvStatus;
        this.tvTitle = tvTitle;
    }

    public static AdapterHomeConnectItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHomeConnectItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterHomeConnectItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_home_connect_item, root, attachToRoot, component);
    }

    public static AdapterHomeConnectItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHomeConnectItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterHomeConnectItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_home_connect_item, null, false, component);
    }

    public static AdapterHomeConnectItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterHomeConnectItemBinding bind(View view, Object component) {
        return (AdapterHomeConnectItemBinding) bind(component, view, R.layout.adapter_home_connect_item);
    }
}
