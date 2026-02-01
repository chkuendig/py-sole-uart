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
public final class AdapterPersonalBestItemBinding implements ViewBinding {
    public final ImageView imgBg;
    public final ImageView imgIcon;
    public final ImageView imgInfo;
    private final ConstraintLayout rootView;
    public final TextView tvDate;
    public final TextView tvSubtitle1;
    public final TextView tvSubtitle1Unit;
    public final TextView tvSubtitle2;
    public final TextView tvSubtitle2Unit;
    public final TextView tvTitle;

    private AdapterPersonalBestItemBinding(ConstraintLayout rootView, ImageView imgBg, ImageView imgIcon, ImageView imgInfo, TextView tvDate, TextView tvSubtitle1, TextView tvSubtitle1Unit, TextView tvSubtitle2, TextView tvSubtitle2Unit, TextView tvTitle) {
        this.rootView = rootView;
        this.imgBg = imgBg;
        this.imgIcon = imgIcon;
        this.imgInfo = imgInfo;
        this.tvDate = tvDate;
        this.tvSubtitle1 = tvSubtitle1;
        this.tvSubtitle1Unit = tvSubtitle1Unit;
        this.tvSubtitle2 = tvSubtitle2;
        this.tvSubtitle2Unit = tvSubtitle2Unit;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterPersonalBestItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterPersonalBestItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_personal_best_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterPersonalBestItemBinding bind(View rootView) {
        int i = R.id.img_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.img_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.img_info;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.tv_date;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tv_subtitle1;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tv_subtitle1_unit;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tv_subtitle2;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.tv_subtitle2_unit;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.tv_title;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            return new AdapterPersonalBestItemBinding((ConstraintLayout) rootView, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, textView5, textView6);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
