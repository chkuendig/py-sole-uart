package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.internal.view.SupportMenu;
import com.mapbox.mapboxsdk.views.MapView;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class Overlay {
    private boolean mEnabled = true;
    protected float mScale;
    private static AtomicInteger sOrdinal = new AtomicInteger();
    private static final Rect mRect = new Rect();

    public interface Snappable {
        boolean onSnapToItem(int i, int i2, Point point, MapView mapView);
    }

    protected abstract void draw(Canvas canvas, MapView mapView, boolean z);

    public void onDetach(MapView mapView) {
    }

    public boolean onDoubleTap(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, MapView mapView) {
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent, MapView mapView) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent, MapView mapView) {
        return false;
    }

    public boolean onLongPress(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, MapView mapView) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent, MapView mapView) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public Overlay() {
    }

    public Overlay(Context context) {
        this.mScale = context.getResources().getDisplayMetrics().density;
    }

    public Overlay setContext(Context context) {
        this.mScale = context.getResources().getDisplayMetrics().density;
        return this;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    protected static final int getSafeMenuId() {
        return sOrdinal.getAndIncrement();
    }

    protected static synchronized void drawAt(Canvas canvas, Drawable drawable, Point point, Point point2, boolean z, float f) {
        canvas.save();
        canvas.rotate(-f, point.x, point.y);
        canvas.translate(point.x + point2.x, point.y + point2.y);
        drawable.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStrokeWidth(3.0f);
        canvas.drawLine(0.0f, -9.0f, 0.0f, 9.0f, paint);
        canvas.drawLine(-9.0f, 0.0f, 9.0f, 0.0f, paint);
        canvas.drawRect(drawable.getBounds(), paint);
        canvas.restore();
    }
}
