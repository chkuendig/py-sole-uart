package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public final class AdapterClassesCollectionBinding implements ViewBinding {
    public final ImageView backgroundImage;
    public final CardView cardBackgroundImage;
    public final ImageView ivArrow;
    public final LinearLayout leftContainer;
    public final LinearLayout rightContainer;
    private final ConstraintLayout rootView;
    public final TextView tvClassType;
    public final TextView tvClassesLabel;
    public final TextView tvCollectionDescription;
    public final TextView tvCollectionName;
    public final TextView tvWorkoutAmount;

    private AdapterClassesCollectionBinding(ConstraintLayout rootView, ImageView backgroundImage, CardView cardBackgroundImage, ImageView ivArrow, LinearLayout leftContainer, LinearLayout rightContainer, TextView tvClassType, TextView tvClassesLabel, TextView tvCollectionDescription, TextView tvCollectionName, TextView tvWorkoutAmount) {
        this.rootView = rootView;
        this.backgroundImage = backgroundImage;
        this.cardBackgroundImage = cardBackgroundImage;
        this.ivArrow = ivArrow;
        this.leftContainer = leftContainer;
        this.rightContainer = rightContainer;
        this.tvClassType = tvClassType;
        this.tvClassesLabel = tvClassesLabel;
        this.tvCollectionDescription = tvCollectionDescription;
        this.tvCollectionName = tvCollectionName;
        this.tvWorkoutAmount = tvWorkoutAmount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AdapterClassesCollectionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AdapterClassesCollectionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.adapter_classes_collection, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AdapterClassesCollectionBinding bind(View rootView) {
        int i = R.id.backgroundImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.cardBackgroundImage;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
            if (cardView != null) {
                i = R.id.ivArrow;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.leftContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.rightContainer;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.tvClassType;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvClassesLabel;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvCollectionDescription;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tvCollectionName;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.tvWorkoutAmount;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                return new AdapterClassesCollectionBinding((ConstraintLayout) rootView, imageView, cardView, imageView2, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5);
                                            }
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
