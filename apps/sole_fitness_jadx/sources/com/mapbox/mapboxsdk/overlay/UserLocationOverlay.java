package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.util.Log;
import android.view.MotionEvent;
import com.dyaco.sole.R2;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.events.MapListener;
import com.mapbox.mapboxsdk.events.ScrollEvent;
import com.mapbox.mapboxsdk.events.ZoomEvent;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Overlay;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import com.mapbox.mapboxsdk.views.MapController;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.safecanvas.ISafeCanvas;
import com.mapbox.mapboxsdk.views.safecanvas.SafePaint;
import com.mapbox.mapboxsdk.views.util.Projection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class UserLocationOverlay extends SafeDrawOverlay implements Overlay.Snappable, MapListener {
    private static final String TAG = "UserLocationOverlay";
    private final SafePaint mCirclePaint;
    protected final Context mContext;
    private Bitmap mDirectionArrowBitmap;
    private PointF mDirectionHotspot;
    private boolean mDrawAccuracyEnabled;
    private boolean mIsLocationEnabled;
    private LatLng mLatLng;
    private Location mLocation;
    private final MapController mMapController;
    private final PointF mMapCoords;
    protected final MapView mMapView;
    private final RectF mMyLocationPreviousRect;
    public GpsLocationProvider mMyLocationProvider;
    private final RectF mMyLocationRect;
    private final SafePaint mPaint;
    private Bitmap mPersonBitmap;
    private PointF mPersonHotspot;
    private float mRequiredZoomLevel;
    private final LinkedList<Runnable> mRunOnFirstFix;
    private TrackingMode mTrackingMode;
    private boolean mZoomBasedOnAccuracy;

    public enum TrackingMode {
        NONE,
        FOLLOW,
        FOLLOW_BEARING
    }

    public void setDirectionArrowBitmap(Bitmap bitmap) {
        this.mDirectionArrowBitmap = bitmap;
    }

    public void setPersonBitmap(Bitmap bitmap) {
        this.mPersonBitmap = bitmap;
    }

    public void setDirectionArrowHotspot(PointF pointF) {
        this.mDirectionHotspot = pointF;
    }

    public void setPersonHotspot(PointF pointF) {
        this.mPersonHotspot = pointF;
    }

    public UserLocationOverlay(GpsLocationProvider gpsLocationProvider, MapView mapView, int i, int i2) {
        SafePaint safePaint = new SafePaint();
        this.mPaint = safePaint;
        SafePaint safePaint2 = new SafePaint();
        this.mCirclePaint = safePaint2;
        this.mRunOnFirstFix = new LinkedList<>();
        this.mMapCoords = new PointF();
        this.mIsLocationEnabled = false;
        this.mDrawAccuracyEnabled = true;
        this.mTrackingMode = TrackingMode.NONE;
        this.mZoomBasedOnAccuracy = true;
        this.mRequiredZoomLevel = 10.0f;
        this.mMyLocationRect = new RectF();
        this.mMyLocationPreviousRect = new RectF();
        this.mMapView = mapView;
        this.mMapController = mapView.getController();
        Context context = mapView.getContext();
        this.mContext = context;
        safePaint2.setARGB(0, 100, 100, 255);
        safePaint2.setAntiAlias(true);
        safePaint.setAntiAlias(true);
        safePaint.setFilterBitmap(true);
        this.mPersonHotspot = new PointF(0.5f, 0.5f);
        this.mDirectionHotspot = new PointF(0.5f, 0.5f);
        if (i2 != 0) {
            this.mPersonBitmap = BitmapFactory.decodeResource(context.getResources(), i2);
        }
        if (i != 0) {
            this.mDirectionArrowBitmap = BitmapFactory.decodeResource(context.getResources(), i);
        }
        setMyLocationProvider(gpsLocationProvider);
    }

    public UserLocationOverlay(GpsLocationProvider gpsLocationProvider, MapView mapView) {
        this(gpsLocationProvider, mapView, R.drawable.direction_arrow, R.drawable.location_marker);
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public void onDetach(MapView mapView) {
        disableMyLocation();
        super.onDetach(mapView);
    }

    public void setDrawAccuracyEnabled(boolean z) {
        this.mDrawAccuracyEnabled = z;
    }

    public boolean isDrawAccuracyEnabled() {
        return this.mDrawAccuracyEnabled;
    }

    public GpsLocationProvider getMyLocationProvider() {
        return this.mMyLocationProvider;
    }

    protected void setMyLocationProvider(GpsLocationProvider gpsLocationProvider) {
        GpsLocationProvider gpsLocationProvider2 = this.mMyLocationProvider;
        if (gpsLocationProvider2 != null) {
            gpsLocationProvider2.stopLocationProvider();
        }
        this.mMyLocationProvider = gpsLocationProvider;
    }

    protected void drawMyLocation(ISafeCanvas iSafeCanvas, MapView mapView, Location location) {
        Rect rect = new Rect(0, 0, mapView.getMeasuredWidth(), mapView.getMeasuredHeight());
        Projection projection = mapView.getProjection();
        Rect rect2 = new Rect();
        getDrawingBounds(projection, location, (RectF) null).round(rect2);
        if (Rect.intersects(rect, rect2)) {
            projection.toMapPixels(this.mLatLng, this.mMapCoords);
            float scale = 1.0f / mapView.getScale();
            iSafeCanvas.save();
            iSafeCanvas.scale(scale, scale, this.mMapCoords.x, this.mMapCoords.y);
            if (this.mDrawAccuracyEnabled) {
                float accuracy = (location.getAccuracy() / ((float) Projection.groundResolution(location.getLatitude(), mapView.getZoomLevel()))) * mapView.getScale();
                iSafeCanvas.save();
                iSafeCanvas.rotate(location.getBearing(), this.mMapCoords.x, this.mMapCoords.y);
                this.mCirclePaint.setAlpha(50);
                this.mCirclePaint.setStyle(Paint.Style.FILL);
                iSafeCanvas.drawCircle(this.mMapCoords.x, this.mMapCoords.y, accuracy, this.mCirclePaint);
                this.mCirclePaint.setAlpha(R2.attr.checkMarkTintMode);
                this.mCirclePaint.setStyle(Paint.Style.STROKE);
                iSafeCanvas.drawCircle(this.mMapCoords.x, this.mMapCoords.y, accuracy, this.mCirclePaint);
                iSafeCanvas.restore();
            }
            if (UtilConstants.DEBUGMODE) {
                float f = this.mMapCoords.x + 50.0f;
                float f2 = this.mMapCoords.y - 20.0f;
                double d = f;
                iSafeCanvas.drawText("Lat: " + location.getLatitude(), d, 5.0f + f2, this.mPaint);
                iSafeCanvas.drawText("Lon: " + location.getLongitude(), d, 20.0f + f2, this.mPaint);
                iSafeCanvas.drawText("Alt: " + location.getAltitude(), d, 35.0f + f2, this.mPaint);
                iSafeCanvas.drawText("Acc: " + location.getAccuracy(), d, f2 + 50.0f, this.mPaint);
            }
            if (location.hasBearing()) {
                iSafeCanvas.save();
                iSafeCanvas.rotate(location.getBearing(), this.mMapCoords.x, this.mMapCoords.y);
                iSafeCanvas.translate((-this.mDirectionArrowBitmap.getWidth()) * this.mDirectionHotspot.x, (-this.mDirectionArrowBitmap.getHeight()) * this.mDirectionHotspot.y);
                iSafeCanvas.drawBitmap(this.mDirectionArrowBitmap, this.mMapCoords.x, this.mMapCoords.y, this.mPaint);
                iSafeCanvas.restore();
            } else {
                iSafeCanvas.save();
                iSafeCanvas.rotate(-this.mMapView.getMapOrientation(), this.mMapCoords.x, this.mMapCoords.y);
                iSafeCanvas.translate((-this.mPersonBitmap.getWidth()) * this.mPersonHotspot.x, (-this.mPersonBitmap.getHeight()) * this.mPersonHotspot.y);
                iSafeCanvas.drawBitmap(this.mPersonBitmap, this.mMapCoords.x, this.mMapCoords.y, this.mPaint);
                iSafeCanvas.restore();
            }
            iSafeCanvas.restore();
        }
    }

    public PointF getPositionOnScreen(Projection projection, PointF pointF) {
        if (pointF == null) {
            pointF = new PointF();
        }
        projection.toPixels(this.mLatLng, pointF);
        return pointF;
    }

    public PointF getDrawingPositionOnScreen(Projection projection, Location location, PointF pointF) {
        PointF positionOnScreen = getPositionOnScreen(projection, pointF);
        if (location.hasBearing()) {
            positionOnScreen.offset(this.mPersonHotspot.x * this.mPersonBitmap.getWidth(), this.mPersonHotspot.y * this.mPersonBitmap.getWidth());
        } else {
            positionOnScreen.offset(this.mDirectionHotspot.x * this.mDirectionArrowBitmap.getWidth(), this.mDirectionHotspot.y * this.mDirectionArrowBitmap.getWidth());
        }
        return positionOnScreen;
    }

    protected RectF getDrawingBounds(Projection projection, Location location, RectF rectF) {
        return getDrawingBounds(getPositionOnScreen(projection, null), location, rectF);
    }

    protected RectF getDrawingBounds(PointF pointF, Location location, RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        Bitmap bitmap = location.hasBearing() ? this.mDirectionArrowBitmap : this.mPersonBitmap;
        PointF pointF2 = location.hasBearing() ? this.mDirectionHotspot : this.mPersonHotspot;
        float fSqrt = (int) (Math.sqrt(2.0d) * Math.max(bitmap.getWidth(), bitmap.getHeight()));
        float f = pointF.x - (pointF2.x * fSqrt);
        float f2 = pointF.y - (pointF2.y * fSqrt);
        rectF.set(f, f2, f + fSqrt, fSqrt + f2);
        return rectF;
    }

    protected RectF getMyLocationMapDrawingBounds(MapView mapView, Location location, RectF rectF) {
        mapView.getProjection().toMapPixels(this.mLatLng, this.mMapCoords);
        RectF drawingBounds = getDrawingBounds(this.mMapCoords, location, rectF);
        if (this.mDrawAccuracyEnabled) {
            float fCeil = (float) Math.ceil(location.getAccuracy() / ((float) Projection.groundResolution(location.getLatitude(), this.mMapView.getZoomLevel())));
            RectF rectF2 = new RectF(this.mMapCoords.x - fCeil, this.mMapCoords.y - fCeil, this.mMapCoords.x + fCeil, this.mMapCoords.y + fCeil);
            float f = -((float) Math.ceil(this.mCirclePaint.getStrokeWidth() == 0.0f ? 1.0d : this.mCirclePaint.getStrokeWidth()));
            rectF2.inset(f, f);
            drawingBounds.union(rectF2);
        }
        return drawingBounds;
    }

    @Override // com.mapbox.mapboxsdk.overlay.SafeDrawOverlay
    protected void drawSafe(ISafeCanvas iSafeCanvas, MapView mapView, boolean z) {
        if (z || this.mLocation == null || !isMyLocationEnabled()) {
            return;
        }
        drawMyLocation(iSafeCanvas, mapView, this.mLocation);
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay.Snappable
    public boolean onSnapToItem(int i, int i2, Point point, MapView mapView) {
        if (!isFollowLocationEnabled() && this.mLocation != null) {
            point.x = (int) this.mMapCoords.x;
            point.y = (int) this.mMapCoords.y;
            double d = i - this.mMapCoords.x;
            double d2 = i2 - this.mMapCoords.y;
            z = (d * d) + (d2 * d2) < 64.0d;
            if (UtilConstants.DEBUGMODE) {
                Log.d(TAG, "snap=" + z);
            }
        }
        return z;
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        if (motionEvent.getAction() == 2) {
            disableFollowLocation();
        }
        return super.onTouchEvent(motionEvent, mapView);
    }

    public LatLng getMyLocation() {
        return this.mLatLng;
    }

    public Location getLastFix() {
        return this.mLocation;
    }

    public void enableFollowLocation() {
        if (this.mTrackingMode == TrackingMode.NONE) {
            this.mTrackingMode = TrackingMode.FOLLOW;
        }
        if (isMyLocationEnabled()) {
            updateMyLocation(this.mMyLocationProvider.getLastKnownLocation());
        }
    }

    public void disableFollowLocation() {
        this.mTrackingMode = TrackingMode.NONE;
    }

    public void setTrackingMode(TrackingMode trackingMode) {
        this.mTrackingMode = trackingMode;
        if (trackingMode == TrackingMode.NONE || !isMyLocationEnabled()) {
            return;
        }
        updateMyLocation(this.mMyLocationProvider.getLastKnownLocation());
    }

    public void setRequiredZoom(float f) {
        this.mRequiredZoomLevel = f;
        this.mZoomBasedOnAccuracy = false;
    }

    public TrackingMode getTrackingMode() {
        return this.mTrackingMode;
    }

    public boolean isFollowLocationEnabled() {
        return this.mTrackingMode != TrackingMode.NONE;
    }

    private void updateDrawingPositionRect() {
        getMyLocationMapDrawingBounds(this.mMapView, this.mLocation, this.mMyLocationRect);
    }

    private void invalidate() {
        if (this.mMapView == null) {
            return;
        }
        this.mMyLocationPreviousRect.set(this.mMyLocationRect);
        updateDrawingPositionRect();
        final RectF rectF = new RectF(this.mMyLocationRect);
        rectF.union(this.mMyLocationPreviousRect);
        this.mMapView.post(new Runnable() { // from class: com.mapbox.mapboxsdk.overlay.UserLocationOverlay.1
            @Override // java.lang.Runnable
            public void run() {
                UserLocationOverlay.this.mMapView.invalidateMapCoordinates(rectF);
            }
        });
    }

    public void onLocationChanged(Location location, GpsLocationProvider gpsLocationProvider) {
        Location location2 = this.mLocation;
        if (location2 != null && location2.getBearing() == location.getBearing() && this.mLocation.distanceTo(location) == 0.0f) {
            return;
        }
        updateMyLocation(location);
        synchronized (this.mRunOnFirstFix) {
            Iterator<Runnable> it = this.mRunOnFirstFix.iterator();
            while (it.hasNext()) {
                new Thread(it.next()).start();
            }
            this.mRunOnFirstFix.clear();
        }
    }

    public boolean enableMyLocation(GpsLocationProvider gpsLocationProvider) {
        setMyLocationProvider(gpsLocationProvider);
        this.mIsLocationEnabled = false;
        return enableMyLocation();
    }

    public boolean goToMyPosition(boolean z) {
        if (this.mLocation == null) {
            return false;
        }
        float zoomLevel = this.mMapView.getZoomLevel(false);
        float f = this.mRequiredZoomLevel;
        if (zoomLevel > f) {
            if (z) {
                return this.mMapController.animateTo(this.mLatLng);
            }
            return this.mMapController.goTo(this.mLatLng, null);
        }
        double d = f;
        if (this.mZoomBasedOnAccuracy && this.mMapView.isLayedOut()) {
            double accuracy = (this.mLocation.getAccuracy() / 110000.0f) * 1.2d;
            Projection projection = this.mMapView.getProjection();
            LatLng latLng = new LatLng(this.mLocation.getLatitude() - accuracy, this.mLocation.getLongitude() - accuracy);
            LatLng latLng2 = new LatLng(this.mLocation.getLatitude() + accuracy, this.mLocation.getLongitude() + accuracy);
            int iMin = Math.min(this.mMapView.getMeasuredWidth(), this.mMapView.getMeasuredHeight()) / 2;
            BoundingBox boundingBox = projection.getBoundingBox();
            if (latLng2.getLatitude() != boundingBox.getLatNorth() || latLng2.getLongitude() != boundingBox.getLonEast() || latLng.getLatitude() != boundingBox.getLatSouth() || latLng.getLongitude() != boundingBox.getLonWest()) {
                this.mMapView.zoomToBoundingBox(new BoundingBox(latLng2, latLng), true, z, true);
            }
        } else {
            if (z) {
                return this.mMapController.setZoomAnimated((float) d, this.mLatLng, true, false);
            }
            this.mMapController.setZoom((float) d, this.mLatLng, false);
        }
        return true;
    }

    private void updateMyLocation(Location location) {
        this.mLocation = location;
        if (location == null) {
            this.mLatLng = null;
            return;
        }
        this.mLatLng = new LatLng(this.mLocation);
        if (isFollowLocationEnabled() && goToMyPosition(true)) {
            return;
        }
        invalidate();
    }

    public boolean enableMyLocation() {
        if (this.mIsLocationEnabled) {
            this.mMyLocationProvider.stopLocationProvider();
        }
        boolean zStartLocationProvider = this.mMyLocationProvider.startLocationProvider(this);
        this.mIsLocationEnabled = zStartLocationProvider;
        if (zStartLocationProvider) {
            updateMyLocation(this.mMyLocationProvider.getLastKnownLocation());
        }
        return zStartLocationProvider;
    }

    public void disableMyLocation() {
        this.mIsLocationEnabled = false;
        GpsLocationProvider gpsLocationProvider = this.mMyLocationProvider;
        if (gpsLocationProvider != null) {
            gpsLocationProvider.stopLocationProvider();
        }
        MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.postInvalidate();
        }
    }

    public boolean isMyLocationEnabled() {
        return this.mIsLocationEnabled;
    }

    public boolean runOnFirstFix(Runnable runnable) {
        if (this.mMyLocationProvider != null && this.mLocation != null) {
            new Thread(runnable).start();
            return true;
        }
        synchronized (this.mRunOnFirstFix) {
            this.mRunOnFirstFix.addLast(runnable);
        }
        return false;
    }

    @Override // com.mapbox.mapboxsdk.events.MapListener
    public void onScroll(ScrollEvent scrollEvent) {
        if (scrollEvent.getUserAction()) {
            disableFollowLocation();
        }
    }

    @Override // com.mapbox.mapboxsdk.events.MapListener
    public void onZoom(ZoomEvent zoomEvent) {
        if (zoomEvent.getUserAction()) {
            disableFollowLocation();
        }
    }
}
