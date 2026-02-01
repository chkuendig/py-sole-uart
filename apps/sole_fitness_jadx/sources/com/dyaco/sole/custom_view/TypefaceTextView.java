package com.dyaco.sole.custom_view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class TypefaceTextView extends TextView {
    public TypefaceTextView(Context context) {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTypeface(Context context, String str, int i) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), str), i);
    }

    public void setTypeface(Context context, String str) {
        setTypeface(context, str, 0);
    }
}
