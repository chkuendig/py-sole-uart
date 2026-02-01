package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.dyaco.sole.R2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, R2.attr.drawableLeftCompat, R2.attr.drawableBottomCompat), Color.rgb(148, R2.attr.controlBackground, R2.attr.controlBackground), Color.rgb(136, R2.attr.com_facebook_foreground_color, R2.attr.com_facebook_preset_size), Color.rgb(118, R2.attr.colorPrimary, R2.attr.colorPrimaryDark), Color.rgb(42, 109, 130)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(R2.attr.customBoolean, 80, 138), Color.rgb(R2.attr.drawableTopCompat, 149, 7), Color.rgb(R2.attr.drawableTopCompat, R2.attr.drawableEndCompat, 120), Color.rgb(106, 167, R2.attr.cardViewStyle), Color.rgb(53, R2.attr.constraintSetStart, R2.attr.contentPaddingRight)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(R2.attr.customBoolean, R2.attr.com_facebook_logout_text, 162), Color.rgb(R2.attr.constraintRotate, R2.attr.cardViewStyle, R2.attr.cardViewStyle), Color.rgb(R2.attr.com_facebook_confirm_logout, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(R2.attr.constraintSetEnd, 37, 82), Color.rgb(255, 102, 0), Color.rgb(R2.attr.drawPath, R2.attr.contentDescription, 0), Color.rgb(106, R2.attr.checkMarkTintMode, 31), Color.rgb(R2.attr.com_facebook_confirm_logout, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(R2.attr.constraintSet, 255, R2.attr.carousel_nextState), Color.rgb(255, R2.attr.drawableEndCompat, R2.attr.carousel_nextState), Color.rgb(255, R2.attr.contentPaddingLeft, R2.attr.carousel_nextState), Color.rgb(R2.attr.carousel_nextState, R2.attr.dialogCornerRadius, 255), Color.rgb(255, R2.attr.carousel_nextState, R2.attr.circularflow_defaultRadius)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((i2 & 255) << 24);
    }

    public static int rgb(String str) {
        int i = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((i >> 16) & 255, (i >> 8) & 255, (i >> 0) & 255);
    }

    public static int getHoloBlue() {
        return Color.rgb(51, R2.attr.com_facebook_horizontal_alignment, R2.attr.defaultQueryHint);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
        }
        return arrayList;
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}
