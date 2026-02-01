package com.mapbox.mapboxsdk.overlay;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas;
import com.mapbox.mapboxsdk.views.safecanvas.SafeTranslatedCanvas;
import com.nineoldandroids.view.ViewHelper;

/* loaded from: classes2.dex */
public abstract class SafeDrawOverlay extends Overlay {
    private boolean mUseSafeCanvas = true;
    private static final SafeTranslatedCanvas sSafeCanvas = new SafeTranslatedCanvas();
    private static final Matrix sMatrix = new Matrix();

    protected abstract void drawSafe(ISafeCanvas iSafeCanvas, MapView mapView, boolean z);

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    protected void draw(Canvas canvas, MapView mapView, boolean z) {
        SafeTranslatedCanvas safeTranslatedCanvas = sSafeCanvas;
        safeTranslatedCanvas.setCanvas(canvas);
        if (this.mUseSafeCanvas) {
            Rect screenRect = mapView.getProjection().getScreenRect();
            safeTranslatedCanvas.xOffset = -screenRect.left;
            safeTranslatedCanvas.yOffset = -screenRect.top;
            canvas.save();
            if (mapView.getMapOrientation() != 0.0f) {
                canvas.rotate(-mapView.getMapOrientation(), screenRect.exactCenterX(), screenRect.exactCenterY());
            }
            int i = screenRect.left - screenRect.left;
            int i2 = screenRect.top - screenRect.top;
            canvas.translate(screenRect.left * ViewHelper.getScaleX(mapView), screenRect.top * ViewHelper.getScaleY(mapView));
            canvas.translate(i, i2);
            if (mapView.getMapOrientation() != 0.0f) {
                safeTranslatedCanvas.rotate(mapView.getMapOrientation(), screenRect.exactCenterX(), screenRect.exactCenterY());
            }
        } else {
            safeTranslatedCanvas.xOffset = 0;
            safeTranslatedCanvas.yOffset = 0;
        }
        drawSafe(safeTranslatedCanvas, mapView, z);
        if (this.mUseSafeCanvas) {
            canvas.restore();
        }
    }

    public boolean isUsingSafeCanvas() {
        return this.mUseSafeCanvas;
    }

    public void setUseSafeCanvas(boolean z) {
        this.mUseSafeCanvas = z;
    }
}
