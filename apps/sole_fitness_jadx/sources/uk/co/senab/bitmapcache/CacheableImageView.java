package uk.co.senab.bitmapcache;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class CacheableImageView extends ImageView {
    private static void onDrawableSet(Drawable drawable) {
        if (drawable instanceof CacheableBitmapDrawable) {
            ((CacheableBitmapDrawable) drawable).setBeingUsed(true);
        }
    }

    private static void onDrawableUnset(Drawable drawable) {
        if (drawable instanceof CacheableBitmapDrawable) {
            ((CacheableBitmapDrawable) drawable).setBeingUsed(false);
        }
    }

    public CacheableImageView(Context context) {
        super(context);
    }

    public CacheableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CacheableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        super.setImageDrawable(drawable);
        if (drawable != drawable2) {
            onDrawableSet(drawable);
            onDrawableUnset(drawable2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable = getDrawable();
        super.setImageResource(i);
        onDrawableUnset(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        Drawable drawable = getDrawable();
        super.setImageURI(uri);
        onDrawableUnset(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setImageDrawable(null);
    }
}
