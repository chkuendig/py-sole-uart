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
import com.journeyapps.barcodescanner.BarcodeView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class FragmentQrcodeBinding extends ViewDataBinding {
    public final BarcodeView barcodeView;
    public final TextView cancel;
    public final ImageView imageView8;
    public final LinearLayout layoutHelp;
    public final LinearLayout linearLayout3;
    public final View maskBottom;
    public final View maskLeft;
    public final View maskRight;
    public final View maskTop;
    public final ConstraintLayout qrRoot;
    public final View scanFrame;
    public final View statusBarHeight;
    public final TextView textView3;
    public final ConstraintLayout topbar;
    public final TextView tvHelp;

    protected FragmentQrcodeBinding(Object _bindingComponent, View _root, int _localFieldCount, BarcodeView barcodeView, TextView cancel, ImageView imageView8, LinearLayout layoutHelp, LinearLayout linearLayout3, View maskBottom, View maskLeft, View maskRight, View maskTop, ConstraintLayout qrRoot, View scanFrame, View statusBarHeight, TextView textView3, ConstraintLayout topbar, TextView tvHelp) {
        super(_bindingComponent, _root, _localFieldCount);
        this.barcodeView = barcodeView;
        this.cancel = cancel;
        this.imageView8 = imageView8;
        this.layoutHelp = layoutHelp;
        this.linearLayout3 = linearLayout3;
        this.maskBottom = maskBottom;
        this.maskLeft = maskLeft;
        this.maskRight = maskRight;
        this.maskTop = maskTop;
        this.qrRoot = qrRoot;
        this.scanFrame = scanFrame;
        this.statusBarHeight = statusBarHeight;
        this.textView3 = textView3;
        this.topbar = topbar;
        this.tvHelp = tvHelp;
    }

    public static FragmentQrcodeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQrcodeBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentQrcodeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_qrcode, root, attachToRoot, component);
    }

    public static FragmentQrcodeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQrcodeBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentQrcodeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_qrcode, null, false, component);
    }

    public static FragmentQrcodeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentQrcodeBinding bind(View view, Object component) {
        return (FragmentQrcodeBinding) bind(component, view, R.layout.fragment_qrcode);
    }
}
