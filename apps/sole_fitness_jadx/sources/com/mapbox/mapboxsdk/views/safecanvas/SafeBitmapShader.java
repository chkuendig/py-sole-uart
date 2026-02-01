package com.mapbox.mapboxsdk.views.safecanvas;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Shader;

/* loaded from: classes2.dex */
public class SafeBitmapShader extends BitmapShader {
    private final int mBitmapHeight;
    private final int mBitmapWidth;
    private final Matrix mMatrix;

    public SafeBitmapShader(Bitmap bitmap, Shader.TileMode tileMode, Shader.TileMode tileMode2) {
        super(bitmap, tileMode, tileMode2);
        this.mMatrix = new Matrix();
        this.mBitmapWidth = bitmap.getWidth();
        this.mBitmapHeight = bitmap.getHeight();
    }

    public void onDrawCycleStart(ISafeCanvas iSafeCanvas) {
        this.mMatrix.setTranslate(iSafeCanvas.getXOffset() % this.mBitmapWidth, iSafeCanvas.getYOffset() % this.mBitmapHeight);
        setLocalMatrix(this.mMatrix);
    }
}
