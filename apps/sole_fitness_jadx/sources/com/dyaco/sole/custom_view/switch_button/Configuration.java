package com.dyaco.sole.custom_view.switch_button;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.dyaco.sole.R2;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class Configuration implements Cloneable {
    private float density;
    private Rect mInsetBounds;
    private Drawable mOnDrawable = null;
    private Drawable mOffDrawable = null;
    private Drawable mThumbDrawable = null;
    private int mOnColor = Default.DEFAULT_ON_COLOR;
    private int mOffColor = Default.DEFAULT_OFF_COLOR;
    private int mThumbColor = Default.DEFAULT_THUMB_COLOR;
    private int mThumbPressedColor = Default.DEFAULT_THUMB_PRESSED_COLOR;
    private int mThumbMarginTop = 0;
    private int mThumbMarginBottom = 0;
    private int mThumbMarginLeft = 0;
    private int mThumbMarginRight = 0;
    private int mThumbWidth = -1;
    private int mThumbHeight = -1;
    private int mVelocity = -1;
    private float mRadius = -1.0f;
    private float mMeasureFactor = 0.0f;

    static class Default {
        static int DEFAULT_OFF_COLOR = Color.parseColor("#E3E3E3");
        static int DEFAULT_ON_COLOR = Color.parseColor("#02BFE7");
        static int DEFAULT_THUMB_COLOR = Color.parseColor("#FFFFFF");
        static int DEFAULT_THUMB_PRESSED_COLOR = Color.parseColor("#fafafa");
        static int DEFAULT_THUMB_MARGIN = 2;
        static int DEFAULT_RADIUS = R2.color.olive;
        static float DEFAULT_MEASURE_FACTOR = 2.0f;
        static int DEFAULT_INNER_BOUNDS = 0;

        Default() {
        }
    }

    static class Limit {
        static int MIN_THUMB_SIZE = 24;

        Limit() {
        }
    }

    private Configuration() {
    }

    public static Configuration getDefault(float f) {
        Configuration configuration = new Configuration();
        configuration.density = f;
        configuration.setThumbMarginInPixel(configuration.getDefaultThumbMarginInPixel());
        configuration.mInsetBounds = new Rect(Default.DEFAULT_INNER_BOUNDS, Default.DEFAULT_INNER_BOUNDS, Default.DEFAULT_INNER_BOUNDS, Default.DEFAULT_INNER_BOUNDS);
        return configuration;
    }

    public void setBackDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable2 == null && drawable == null) {
            throw new IllegalArgumentException("back drawable can not be null");
        }
        if (drawable != null) {
            this.mOffDrawable = drawable;
            if (drawable2 != null) {
                this.mOnDrawable = drawable2;
            } else {
                this.mOnDrawable = drawable;
            }
        }
    }

    void setOffDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("off drawable can not be null");
        }
        this.mOffDrawable = drawable;
    }

    void setOnDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("on drawable can not be null");
        }
        this.mOnDrawable = drawable;
    }

    public Drawable getOnDrawable() {
        return this.mOnDrawable;
    }

    public Drawable getOffDrawable() {
        return this.mOffDrawable;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("thumb drawable can not be null");
        }
        this.mThumbDrawable = drawable;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public void setThumbMargin(int i, int i2, int i3, int i4) {
        float f = this.density;
        this.mThumbMarginTop = (int) (i * f);
        this.mThumbMarginBottom = (int) (i2 * f);
        this.mThumbMarginLeft = (int) (i3 * f);
        this.mThumbMarginRight = (int) (i4 * f);
    }

    public void setThumbMarginInPixel(int i, int i2, int i3, int i4) {
        this.mThumbMarginTop = i;
        this.mThumbMarginBottom = i2;
        this.mThumbMarginLeft = i3;
        this.mThumbMarginRight = i4;
    }

    public void setThumbMargin(int i, int i2, int i3) {
        setThumbMargin(i, i2, i3, i3);
    }

    public void setThumbMargin(int i, int i2) {
        setThumbMargin(i, i, i2, i2);
    }

    public void setThumbMargin(int i) {
        setThumbMargin(i, i, i, i);
    }

    public void setThumbMarginInPixel(int i) {
        setThumbMarginInPixel(i, i, i, i);
    }

    public int getDefaultThumbMarginInPixel() {
        return (int) (Default.DEFAULT_THUMB_MARGIN * this.density);
    }

    public int getThumbMarginTop() {
        return this.mThumbMarginTop;
    }

    public int getThumbMarginBottom() {
        return this.mThumbMarginBottom;
    }

    public int getThumbMarginLeft() {
        return this.mThumbMarginLeft;
    }

    public int getThumbMarginRight() {
        return this.mThumbMarginRight;
    }

    public float getDensity() {
        return this.density;
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public float getRadius() {
        float f = this.mRadius;
        return f < 0.0f ? Default.DEFAULT_RADIUS : f;
    }

    public void setVelocity(int i) {
        this.mVelocity = i;
    }

    public int getVelocity() {
        return this.mVelocity;
    }

    public void setOnColor(int i) {
        this.mOnColor = i;
    }

    public int getOnColor(int i) {
        return this.mOnColor;
    }

    public void setOffColor(int i) {
        this.mOffColor = i;
    }

    public int getOffColor() {
        return this.mOffColor;
    }

    public void setThumbColor(int i) {
        this.mThumbColor = i;
    }

    public int getThumbColor() {
        return this.mThumbColor;
    }

    public void setThumbWidthAndHeightInPixel(int i, int i2) {
        if (i > 0) {
            this.mThumbWidth = i;
        }
        if (i2 > 0) {
            this.mThumbHeight = i2;
        }
    }

    public void setThumbWidthAndHeight(int i, int i2) {
        float f = this.density;
        setThumbWidthAndHeightInPixel((int) (i * f), (int) (i2 * f));
    }

    public Drawable getOffDrawableWithFix() {
        Drawable drawable = this.mOffDrawable;
        return drawable != null ? drawable : getDrawableFromColor(this.mOffColor);
    }

    public Drawable getOnDrawableWithFix() {
        Drawable drawable = this.mOnDrawable;
        return drawable != null ? drawable : getDrawableFromColor(this.mOnColor);
    }

    public Drawable getThumbDrawableWithFix() throws NoSuchFieldException {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            return drawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawableFromColor = getDrawableFromColor(this.mThumbColor);
        Drawable drawableFromColor2 = getDrawableFromColor(this.mThumbPressedColor);
        int[] iArr = null;
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, drawableFromColor2);
        }
        stateListDrawable.addState(new int[0], drawableFromColor);
        return stateListDrawable;
    }

    public float getMeasureFactor() {
        if (this.mMeasureFactor <= 0.0f) {
            this.mMeasureFactor = Default.DEFAULT_MEASURE_FACTOR;
        }
        return this.mMeasureFactor;
    }

    public void setMeasureFactor(float f) {
        if (f <= 0.0f) {
            this.mMeasureFactor = Default.DEFAULT_MEASURE_FACTOR;
        }
        this.mMeasureFactor = f;
    }

    public Rect getInsetBounds() {
        return this.mInsetBounds;
    }

    public void setInsetBounds(int i, int i2, int i3, int i4) {
        setInsetLeft(i);
        setInsetTop(i2);
        setInsetRight(i3);
        setInsetBottom(i4);
    }

    public void setInsetLeft(int i) {
        if (i > 0) {
            i = -i;
        }
        this.mInsetBounds.left = i;
    }

    public void setInsetTop(int i) {
        if (i > 0) {
            i = -i;
        }
        this.mInsetBounds.top = i;
    }

    public void setInsetRight(int i) {
        if (i > 0) {
            i = -i;
        }
        this.mInsetBounds.right = i;
    }

    public void setInsetBottom(int i) {
        if (i > 0) {
            i = -i;
        }
        this.mInsetBounds.bottom = i;
    }

    public int getInsetX() {
        return getShrinkX() / 2;
    }

    public int getInsetY() {
        return getShrinkY() / 2;
    }

    public int getShrinkX() {
        return this.mInsetBounds.left + this.mInsetBounds.right;
    }

    public int getShrinkY() {
        return this.mInsetBounds.top + this.mInsetBounds.bottom;
    }

    public boolean needShrink() {
        return ((this.mInsetBounds.left + this.mInsetBounds.right) + this.mInsetBounds.top) + this.mInsetBounds.bottom != 0;
    }

    private Drawable getDrawableFromColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getRadius());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    int getThumbWidth() {
        int intrinsicWidth;
        int i = this.mThumbWidth;
        if (i >= 0) {
            return i;
        }
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null && (intrinsicWidth = drawable.getIntrinsicWidth()) > 0) {
            return intrinsicWidth;
        }
        if (this.density <= 0.0f) {
            throw new IllegalArgumentException("density must be a positive number");
        }
        return (int) (Limit.MIN_THUMB_SIZE * this.density);
    }

    int getThumbHeight() {
        int intrinsicHeight;
        int i = this.mThumbHeight;
        if (i >= 0) {
            return i;
        }
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null && (intrinsicHeight = drawable.getIntrinsicHeight()) > 0) {
            return intrinsicHeight;
        }
        if (this.density <= 0.0f) {
            throw new IllegalArgumentException("density must be a positive number");
        }
        return (int) (Limit.MIN_THUMB_SIZE * this.density);
    }
}
