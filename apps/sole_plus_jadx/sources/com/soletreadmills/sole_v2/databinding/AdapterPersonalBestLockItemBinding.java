package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public final class AdapterPersonalBestLockItemBinding implements ViewBinding {
    public final ImageView imgBg;
    public final ImageView imgIcon;
    private final ConstraintLayout rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private AdapterPersonalBestLockItemBinding(ConstraintLayout rootView, ImageView imgBg, ImageView imgIcon, TextView tvSubtitle, TextView tvTitle) {
        this.rootView = rootView;
        this.imgBg = imgBg;
        this.imgIcon = imgIcon;
        this.tvSubtitle = tvSubtitle;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterPersonalBestLockItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterPersonalBestLockItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_personal_best_lock_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterPersonalBestLockItemBinding bind(View rootView) {
        int i = R.id.img_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.img_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.tv_subtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new AdapterPersonalBestLockItemBinding((ConstraintLayout) rootView, imageView, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
