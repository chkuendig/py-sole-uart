package com.mapbox.mapboxsdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.cocoahero.android.geojson.FeatureCollection;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.api.ILatLng;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.events.MapListener;
import com.mapbox.mapboxsdk.events.ScrollEvent;
import com.mapbox.mapboxsdk.events.ZoomEvent;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.GeoJSONPainter;
import com.mapbox.mapboxsdk.overlay.GpsLocationProvider;
import com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay;
import com.mapbox.mapboxsdk.overlay.ItemizedOverlay;
import com.mapbox.mapboxsdk.overlay.MapEventsOverlay;
import com.mapbox.mapboxsdk.overlay.MapEventsReceiver;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.overlay.Overlay;
import com.mapbox.mapboxsdk.overlay.OverlayManager;
import com.mapbox.mapboxsdk.overlay.TilesOverlay;
import com.mapbox.mapboxsdk.overlay.UserLocationOverlay;
import com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase;
import com.mapbox.mapboxsdk.tileprovider.MapTileLayerBasic;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import com.mapbox.mapboxsdk.tileprovider.tilesource.MapboxTileLayer;
import com.mapbox.mapboxsdk.tileprovider.util.SimpleInvalidationHandler;
import com.mapbox.mapboxsdk.util.BitmapUtils;
import com.mapbox.mapboxsdk.util.DataLoadingUtils;
import com.mapbox.mapboxsdk.util.GeometryMath;
import com.mapbox.mapboxsdk.util.NetworkUtils;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import com.mapbox.mapboxsdk.views.util.Projection;
import com.mapbox.mapboxsdk.views.util.TileLoadedListener;
import com.mapbox.mapboxsdk.views.util.TilesLoadedListener;
import com.mapbox.mapboxsdk.views.util.constants.MapViewConstants;
import com.mapbox.mapboxsdk.views.util.constants.MapViewLayouts;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class MapView extends ViewGroup implements MapViewConstants, MapEventsReceiver, MapboxConstants {
    private static final String TAG = "MapBox MapView";
    private static Method sMotionEventTransformMethod;
    private boolean canTapTwoFingers;
    private Context context;
    private InfoWindow currentTooltip;
    private ArrayList<Marker> defaultMarkerList;
    private ItemizedIconOverlay defaultMarkerOverlay;
    private MapEventsOverlay eventsOverlay;
    private boolean firstMarker;
    private BoundingBox mBoundingBoxToZoomOn;
    private boolean mBoundingBoxToZoomOnRegionFit;
    private boolean mConstraintRegionFit;
    private final MapController mController;
    private PointF mDScroll;
    private PointF mDefaultPinAnchor;
    private Drawable mDefaultPinDrawable;
    private int mDefaultPinRes;
    private final GestureDetector mGestureDetector;
    private final Rect mInvalidateRect;
    protected final AtomicBoolean mIsAnimating;
    protected boolean mIsFlinging;
    private boolean mLayedOut;
    protected List<MapListener> mListeners;
    private UserLocationOverlay mLocationOverlay;
    private MapViewListener mMapViewListener;
    private float mMaximumZoomLevel;
    private float mMinimumZoomLevel;
    protected float mMultiTouchScale;
    protected PointF mMultiTouchScalePoint;
    private final OverlayManager mOverlayManager;
    private final PointF mPoint;
    private Projection mProjection;
    protected float mRequestedMinimumZoomLevel;
    private final float[] mRotatePoints;
    protected ScaleGestureDetector mScaleGestureDetector;
    protected BoundingBox mScrollableAreaBoundingBox;
    protected RectF mScrollableAreaLimit;
    protected final Scroller mScroller;
    protected final AtomicInteger mTargetZoomLevel;
    protected RectF mTempRect;
    protected final MapTileLayerBase mTileProvider;
    private final Handler mTileRequestCompleteHandler;
    private final TilesOverlay mTilesOverlay;
    private float mZoomLevel;
    private float mapOrientation;
    private int multiTouchDownCount;
    TileLoadedListener tileLoadedListener;
    private TilesLoadedListener tilesLoadedListener;

    public void updateScrollDuringAnimation() {
    }

    protected MapView(Context context, int i, MapTileLayerBase mapTileLayerBase, Handler handler, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.defaultMarkerList = new ArrayList<>();
        this.firstMarker = true;
        this.mZoomLevel = 11.0f;
        this.mRequestedMinimumZoomLevel = 0.0f;
        this.mMinimumZoomLevel = 0.0f;
        this.mMaximumZoomLevel = 22.0f;
        this.mTargetZoomLevel = new AtomicInteger();
        this.mIsAnimating = new AtomicBoolean(false);
        this.mMultiTouchScale = 1.0f;
        this.mMultiTouchScalePoint = new PointF();
        this.mListeners = new ArrayList();
        this.mapOrientation = 0.0f;
        this.mRotatePoints = new float[2];
        this.mInvalidateRect = new Rect();
        this.mScrollableAreaBoundingBox = null;
        this.mScrollableAreaLimit = null;
        this.mTempRect = new RectF();
        this.mBoundingBoxToZoomOn = null;
        this.mBoundingBoxToZoomOnRegionFit = false;
        this.mPoint = new PointF();
        this.mDefaultPinRes = R.drawable.defpin;
        this.mDefaultPinAnchor = DEFAULT_PIN_ANCHOR;
        this.canTapTwoFingers = false;
        this.multiTouchDownCount = 0;
        this.mDScroll = new PointF();
        setWillNotDraw(false);
        this.mLayedOut = false;
        this.mConstraintRegionFit = false;
        this.mController = new MapController(this);
        this.mScroller = new Scroller(context);
        Projection.setTileSize(i);
        mapTileLayerBase = mapTileLayerBase == null ? new MapTileLayerBasic(context, null, this) : mapTileLayerBase;
        handler = handler == null ? new SimpleInvalidationHandler(this) : handler;
        this.mTileRequestCompleteHandler = handler;
        this.mTileProvider = mapTileLayerBase;
        mapTileLayerBase.setTileRequestCompleteHandler(handler);
        TilesOverlay tilesOverlay = new TilesOverlay(mapTileLayerBase);
        this.mTilesOverlay = tilesOverlay;
        this.mOverlayManager = new OverlayManager(tilesOverlay);
        this.mGestureDetector = new GestureDetector(context, new MapViewGestureDetectorListener(this));
        this.mScaleGestureDetector = new ScaleGestureDetector(context, new MapViewScaleGestureDetectorListener(this));
        this.context = context;
        this.eventsOverlay = new MapEventsOverlay(context, this);
        getOverlays().add(this.eventsOverlay);
        TypedArray typedArrayObtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.MapView);
        String string = typedArrayObtainStyledAttributes.getString(0);
        if (!TextUtils.isEmpty(string)) {
            setTileSource(new MapboxTileLayer(string));
        } else {
            Log.w(TAG, "mapid not set.");
        }
        String string2 = typedArrayObtainStyledAttributes.getString(1);
        String string3 = typedArrayObtainStyledAttributes.getString(2);
        if (string2 != null && string3 != null) {
            setCenter(new LatLng(Double.parseDouble(string2), Double.parseDouble(string3)));
        } else {
            Log.d(TAG, "centerLatLng is not specified in XML.");
        }
        String string4 = typedArrayObtainStyledAttributes.getString(3);
        if (string4 != null) {
            setZoom(Float.parseFloat(string4));
        } else {
            Log.d(TAG, "zoomLevel is not specified in XML.");
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public MapView(Context context) {
        this(context, 256, null, null, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, 256, null, null, attributeSet);
    }

    protected MapView(Context context, int i, MapTileLayerBase mapTileLayerBase) {
        this(context, i, mapTileLayerBase, null, null);
    }

    public void addListener(MapListener mapListener) {
        if (this.mListeners.contains(mapListener)) {
            return;
        }
        this.mListeners.add(mapListener);
    }

    public void removeListener(MapListener mapListener) {
        if (this.mListeners.contains(mapListener)) {
            this.mListeners.remove(mapListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addOverlay(Overlay overlay) {
        if (!this.mOverlayManager.contains(overlay)) {
            this.mOverlayManager.add(overlay);
            if (overlay instanceof MapListener) {
                addListener((MapListener) overlay);
            }
        }
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeOverlay(Overlay overlay) {
        if (this.mOverlayManager.contains(overlay)) {
            this.mOverlayManager.remove(overlay);
            if (overlay instanceof MapListener) {
                removeListener((MapListener) overlay);
            }
        }
        invalidate();
    }

    private void updateAfterSourceChange() {
        Projection.setTileSize(this.mTileProvider.getTileSizePixels());
        setScrollableAreaLimit(this.mTileProvider.getBoundingBox());
        setMinZoomLevel(this.mTileProvider.getMinimumZoomLevel());
        setMaxZoomLevel(this.mTileProvider.getMaximumZoomLevel());
        setZoom(this.mZoomLevel);
        if (isLayedOut()) {
            scrollTo(this.mDScroll.x, this.mDScroll.y);
            postInvalidate();
        }
    }

    public void setTileSource(ITileLayer[] iTileLayerArr) {
        MapTileLayerBase mapTileLayerBase;
        if (iTileLayerArr == null || (mapTileLayerBase = this.mTileProvider) == null || !(mapTileLayerBase instanceof MapTileLayerBasic)) {
            return;
        }
        ((MapTileLayerBasic) mapTileLayerBase).setTileSources(iTileLayerArr);
        updateAfterSourceChange();
    }

    public void setTileSource(ITileLayer iTileLayer) {
        MapTileLayerBase mapTileLayerBase;
        if (iTileLayer == null || (mapTileLayerBase = this.mTileProvider) == null || !(mapTileLayerBase instanceof MapTileLayerBasic)) {
            return;
        }
        mapTileLayerBase.setTileSource(iTileLayer);
        updateAfterSourceChange();
    }

    public void addTileSource(ITileLayer iTileLayer) {
        MapTileLayerBase mapTileLayerBase;
        if (iTileLayer == null || (mapTileLayerBase = this.mTileProvider) == null || !(mapTileLayerBase instanceof MapTileLayerBasic)) {
            return;
        }
        ((MapTileLayerBasic) mapTileLayerBase).addTileSource(iTileLayer);
        updateAfterSourceChange();
    }

    public void addTileSource(ITileLayer iTileLayer, int i) {
        MapTileLayerBase mapTileLayerBase;
        if (iTileLayer == null || (mapTileLayerBase = this.mTileProvider) == null || !(mapTileLayerBase instanceof MapTileLayerBasic)) {
            return;
        }
        ((MapTileLayerBasic) mapTileLayerBase).addTileSource(iTileLayer, i);
        updateAfterSourceChange();
    }

    public void removeTileSource(ITileLayer iTileLayer) {
        MapTileLayerBase mapTileLayerBase;
        if (iTileLayer == null || (mapTileLayerBase = this.mTileProvider) == null || !(mapTileLayerBase instanceof MapTileLayerBasic)) {
            return;
        }
        ((MapTileLayerBasic) mapTileLayerBase).removeTileSource(iTileLayer);
        updateAfterSourceChange();
    }

    public void removeTileSource(int i) {
        MapTileLayerBase mapTileLayerBase = this.mTileProvider;
        if (mapTileLayerBase == null || !(mapTileLayerBase instanceof MapTileLayerBasic)) {
            return;
        }
        ((MapTileLayerBasic) mapTileLayerBase).removeTileSource(i);
        updateAfterSourceChange();
    }

    public Marker addMarker(Marker marker) {
        if (this.firstMarker) {
            this.defaultMarkerList.add(marker);
            setDefaultItemizedOverlay();
        } else {
            this.defaultMarkerOverlay.addItem(marker);
        }
        marker.addTo(this);
        this.firstMarker = false;
        return marker;
    }

    public void removeMarker(Marker marker) {
        this.defaultMarkerList.remove(marker);
        this.defaultMarkerOverlay.removeItem(marker);
        invalidate();
    }

    public void selectMarker(Marker marker) {
        InfoWindow toolTip = marker.getToolTip(this);
        MapViewListener mapViewListener = this.mMapViewListener;
        if (mapViewListener != null) {
            mapViewListener.onTapMarker(this, marker);
        }
        closeCurrentTooltip();
        if (toolTip == this.currentTooltip || !marker.hasContent()) {
            return;
        }
        MapViewListener mapViewListener2 = this.mMapViewListener;
        if (mapViewListener2 != null) {
            mapViewListener2.onShowMarker(this, marker);
        }
        this.currentTooltip = toolTip;
        marker.showBubble(toolTip, this, true);
    }

    public void addItemizedOverlay(ItemizedOverlay itemizedOverlay) {
        if (itemizedOverlay instanceof ItemizedIconOverlay) {
            ItemizedIconOverlay itemizedIconOverlay = (ItemizedIconOverlay) itemizedOverlay;
            for (int i = 0; i < itemizedIconOverlay.size(); i++) {
                itemizedIconOverlay.getItem(i).addTo(this);
            }
        }
        getOverlays().add(itemizedOverlay);
    }

    public ArrayList<ItemizedIconOverlay> getItemizedOverlays() {
        ArrayList<ItemizedIconOverlay> arrayList = new ArrayList<>();
        for (Overlay overlay : getOverlays()) {
            if (overlay instanceof ItemizedOverlay) {
                arrayList.add((ItemizedIconOverlay) overlay);
            }
        }
        return arrayList;
    }

    public void loadFromGeoJSONURL(String str) {
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            new GeoJSONPainter(this, null).loadFromURL(str);
        }
    }

    public FeatureCollection parseFromGeoJSONURL(String str) throws JSONException, IOException {
        return DataLoadingUtils.loadGeoJSONFromUrl(str);
    }

    public void closeCurrentTooltip() {
        InfoWindow infoWindow = this.currentTooltip;
        if (infoWindow != null) {
            MapViewListener mapViewListener = this.mMapViewListener;
            if (mapViewListener != null) {
                mapViewListener.onHidemarker(this, infoWindow.getBoundMarker());
            }
            this.currentTooltip.close();
            this.currentTooltip = null;
        }
    }

    public InfoWindow getCurrentTooltip() {
        return this.currentTooltip;
    }

    private void setDefaultItemizedOverlay() {
        ItemizedIconOverlay itemizedIconOverlay = new ItemizedIconOverlay(getContext(), this.defaultMarkerList, new ItemizedIconOverlay.OnItemGestureListener<Marker>() { // from class: com.mapbox.mapboxsdk.views.MapView.1
            @Override // com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.OnItemGestureListener
            public boolean onItemSingleTapUp(int i, Marker marker) {
                MapView.this.selectMarker(marker);
                return true;
            }

            @Override // com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.OnItemGestureListener
            public boolean onItemLongPress(int i, Marker marker) {
                if (MapView.this.mMapViewListener == null) {
                    return true;
                }
                MapView.this.mMapViewListener.onLongPressMarker(MapView.this, marker);
                return true;
            }
        });
        this.defaultMarkerOverlay = itemizedIconOverlay;
        addItemizedOverlay(itemizedIconOverlay);
    }

    @Override // com.mapbox.mapboxsdk.overlay.MapEventsReceiver
    public boolean singleTapUpHelper(ILatLng iLatLng) {
        closeCurrentTooltip();
        onTap(iLatLng);
        return true;
    }

    @Override // com.mapbox.mapboxsdk.overlay.MapEventsReceiver
    public boolean longPressHelper(ILatLng iLatLng) {
        onLongPress(iLatLng);
        return false;
    }

    public void onLongPress(ILatLng iLatLng) {
        MapViewListener mapViewListener = this.mMapViewListener;
        if (mapViewListener != null) {
            mapViewListener.onLongPressMap(this, iLatLng);
        }
    }

    public void onTap(ILatLng iLatLng) {
        MapViewListener mapViewListener = this.mMapViewListener;
        if (mapViewListener != null) {
            mapViewListener.onTapMap(this, iLatLng);
        }
    }

    public MapController getController() {
        return this.mController;
    }

    public TilesOverlay getMapOverlay() {
        return this.mTilesOverlay;
    }

    public List<Overlay> getOverlays() {
        return getOverlayManager();
    }

    public OverlayManager getOverlayManager() {
        return this.mOverlayManager;
    }

    public MapTileLayerBase getTileProvider() {
        return this.mTileProvider;
    }

    public Scroller getScroller() {
        return this.mScroller;
    }

    public Handler getTileRequestCompleteHandler() {
        return this.mTileRequestCompleteHandler;
    }

    public BoundingBox getBoundingBoxInternal() {
        if (getMeasuredWidth() == 0 || getMeasuredHeight() == 0) {
            return null;
        }
        Rect rectViewPortRect = GeometryMath.viewPortRect(getProjection(), null);
        LatLng latLngPixelXYToLatLong = Projection.pixelXYToLatLong(rectViewPortRect.right, rectViewPortRect.top, this.mZoomLevel);
        LatLng latLngPixelXYToLatLong2 = Projection.pixelXYToLatLong(rectViewPortRect.left, rectViewPortRect.bottom, this.mZoomLevel);
        return new BoundingBox(latLngPixelXYToLatLong.getLatitude(), latLngPixelXYToLatLong.getLongitude(), latLngPixelXYToLatLong2.getLatitude(), latLngPixelXYToLatLong2.getLongitude());
    }

    public BoundingBox getBoundingBox() {
        return getProjection().getBoundingBox();
    }

    public LatLng getCenter() {
        float fMapSize = Projection.mapSize(this.mZoomLevel) >> 1;
        return Projection.pixelXYToLatLong(this.mDScroll.x + fMapSize, this.mDScroll.y + fMapSize, this.mZoomLevel);
    }

    public Rect getScreenRect(Rect rect) {
        Rect intrinsicScreenRect = getIntrinsicScreenRect(rect);
        if (getMapOrientation() % 180.0f != 0.0f) {
            GeometryMath.getBoundingBoxForRotatedRectangle(intrinsicScreenRect, getScrollX(), getScrollY(), getMapOrientation(), intrinsicScreenRect);
        }
        return intrinsicScreenRect;
    }

    public Rect getIntrinsicScreenRect(Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        int measuredWidth = getMeasuredWidth() >> 1;
        int measuredHeight = getMeasuredHeight() >> 1;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        rect.set(scrollX - measuredWidth, scrollY - measuredHeight, scrollX + measuredWidth, scrollY + measuredHeight);
        return rect;
    }

    public Projection getProjection() {
        if (this.mProjection == null) {
            this.mProjection = new Projection(this);
        }
        return this.mProjection;
    }

    public MapView setCenter(ILatLng iLatLng) {
        return setCenter(iLatLng, false);
    }

    public MapView setCenter(ILatLng iLatLng, boolean z) {
        getController().setCurrentlyInUserAction(z);
        getController().setCenter(iLatLng);
        getController().setCurrentlyInUserAction(false);
        return this;
    }

    public MapView panBy(int i, int i2) {
        this.mController.panBy(i, i2);
        return this;
    }

    public MapView setScale(float f) {
        float fLog = this.mZoomLevel + ((float) (Math.log(f) / Math.log(2.0d)));
        if (fLog <= this.mMaximumZoomLevel && fLog >= this.mMinimumZoomLevel) {
            this.mMultiTouchScale = f;
            invalidate();
        }
        return this;
    }

    public float getScale() {
        return this.mMultiTouchScale;
    }

    private void snapItems() {
        Point point = new Point();
        if (getOverlayManager().onSnapToItem(getScrollX(), getScrollY(), point, this)) {
            scrollTo(point.x, point.y);
        }
    }

    public MapView setZoom(float f) {
        return this.mController.setZoom(f);
    }

    protected MapView setZoomInternal(float f) {
        return setZoomInternal(f, null, null);
    }

    protected MapView setZoomInternal(float f, ILatLng iLatLng, PointF pointF) {
        if (iLatLng == null) {
            iLatLng = getCenter();
        }
        float clampedZoomLevel = getClampedZoomLevel(f);
        float f2 = this.mZoomLevel;
        this.mMultiTouchScale = 1.0f;
        if (clampedZoomLevel != f2) {
            this.mZoomLevel = clampedZoomLevel;
            this.mTargetZoomLevel.set(Float.floatToIntBits(clampedZoomLevel));
            this.mScroller.forceFinished(true);
            this.mIsFlinging = false;
            updateScrollableAreaLimit();
        }
        if (iLatLng != null) {
            PointF mapPixels = Projection.toMapPixels(iLatLng.getLatitude(), iLatLng.getLongitude(), clampedZoomLevel, this.mDScroll.x, this.mDScroll.y, null);
            if (pointF != null) {
                mapPixels.offset(pointF.x, pointF.y);
            }
            scrollTo(mapPixels.x, mapPixels.y);
        } else if (clampedZoomLevel > f2) {
            int iMapSize = Projection.mapSize(clampedZoomLevel) >> 1;
            LatLng center = getCenter();
            PointF pointFLatLongToPixelXY = Projection.latLongToPixelXY(center.getLatitude(), center.getLongitude(), clampedZoomLevel, null);
            scrollTo(((int) pointFLatLongToPixelXY.x) - iMapSize, ((int) pointFLatLongToPixelXY.y) - iMapSize);
        } else if (clampedZoomLevel < f2) {
            float f3 = f2 - clampedZoomLevel;
            scrollTo((int) GeometryMath.rightShift(getScrollX(), f3), (int) GeometryMath.rightShift(getScrollY(), f3));
        }
        this.mProjection = new Projection(this);
        snapItems();
        if (isLayedOut()) {
            getMapOverlay().rescaleCache(clampedZoomLevel, f2, getProjection());
        }
        if (clampedZoomLevel != f2 && this.mListeners.size() > 0) {
            ZoomEvent zoomEvent = new ZoomEvent(this, clampedZoomLevel, this.mController.currentlyInUserAction());
            Iterator<MapListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onZoom(zoomEvent);
            }
        }
        requestLayout();
        return this;
    }

    private double minimumZoomForBoundingBox(BoundingBox boundingBox, boolean z, boolean z2) {
        RectF mapPixels = Projection.toMapPixels(boundingBox, 22.0f, this.mTempRect);
        float fLog = 22.0f - ((float) (Math.log(mapPixels.height() / getMeasuredHeight()) / Math.log(2.0d)));
        float fLog2 = 22.0f - ((float) (Math.log(mapPixels.width() / getMeasuredWidth()) / Math.log(2.0d)));
        double dMin = z ? Math.min(fLog, fLog2) : Math.max(fLog, fLog2);
        if (z2) {
            return z ? Math.floor(dMin) : Math.round(dMin);
        }
        return dMin;
    }

    public MapView zoomToBoundingBox(BoundingBox boundingBox, boolean z, boolean z2, boolean z3, boolean z4) {
        BoundingBox boundingBox2 = this.mScrollableAreaBoundingBox;
        if (boundingBox2 != null) {
            boundingBox = boundingBox2.intersect(boundingBox);
        }
        if (boundingBox != null && boundingBox.isValid()) {
            if (!this.mLayedOut) {
                this.mBoundingBoxToZoomOn = boundingBox;
                this.mBoundingBoxToZoomOnRegionFit = z;
                return this;
            }
            LatLng center = boundingBox.getCenter();
            float fMinimumZoomForBoundingBox = (float) minimumZoomForBoundingBox(boundingBox, z, z3);
            if (z2) {
                getController().setZoomAnimated(fMinimumZoomForBoundingBox, center, true, z4);
            } else {
                getController().setZoom(fMinimumZoomForBoundingBox, center, z4);
            }
        }
        return this;
    }

    public MapView zoomToBoundingBox(BoundingBox boundingBox, boolean z, boolean z2, boolean z3) {
        return zoomToBoundingBox(boundingBox, z, z2, z3, false);
    }

    public MapView zoomToBoundingBox(BoundingBox boundingBox, boolean z, boolean z2) {
        return zoomToBoundingBox(boundingBox, z, z2, false, false);
    }

    public MapView zoomToBoundingBox(BoundingBox boundingBox, boolean z) {
        return zoomToBoundingBox(boundingBox, z, false, false);
    }

    public MapView zoomToBoundingBox(BoundingBox boundingBox) {
        return zoomToBoundingBox(boundingBox, false);
    }

    public float getClampedZoomLevel(float f) {
        return Math.max(getMinZoomLevel(), Math.min(getMaxZoomLevel(), f));
    }

    public float getZoomLevel() {
        return getZoomLevel(true);
    }

    private float getAnimatedZoom() {
        return Float.intBitsToFloat(this.mTargetZoomLevel.get());
    }

    public float getZoomLevel(boolean z) {
        if (z && isAnimating()) {
            return getAnimatedZoom();
        }
        return this.mZoomLevel;
    }

    public float getMinZoomLevel() {
        return Math.max(this.mMinimumZoomLevel, 0.0f);
    }

    public float getMaxZoomLevel() {
        return this.mMaximumZoomLevel;
    }

    public void setMinZoomLevel(float f) {
        this.mMinimumZoomLevel = f;
        this.mRequestedMinimumZoomLevel = f;
        updateMinZoomLevel();
    }

    public void setMaxZoomLevel(float f) {
        this.mMaximumZoomLevel = f;
    }

    protected boolean canZoomIn() {
        return (isAnimating() ? getAnimatedZoom() : this.mZoomLevel) < getMaxZoomLevel();
    }

    protected boolean canZoomOut() {
        return (isAnimating() ? getAnimatedZoom() : this.mZoomLevel) > getMinZoomLevel();
    }

    public boolean zoomIn() {
        return getController().zoomIn();
    }

    public boolean zoomInFixing(ILatLng iLatLng, boolean z) {
        return getController().zoomInAbout(iLatLng, z);
    }

    public boolean zoomInFixing(ILatLng iLatLng) {
        return zoomInFixing(iLatLng, false);
    }

    public boolean zoomOut() {
        return getController().zoomOut();
    }

    public boolean zoomOutFixing(ILatLng iLatLng, boolean z) {
        return getController().zoomOutAbout(iLatLng, z);
    }

    public boolean zoomOutFixing(ILatLng iLatLng) {
        return zoomOutFixing(iLatLng, false);
    }

    public void setMapOrientation(float f) {
        this.mapOrientation = f % 360.0f;
        this.mProjection = null;
        invalidate();
    }

    public float getMapOrientation() {
        return this.mapOrientation;
    }

    public boolean useDataConnection() {
        return this.mTilesOverlay.useDataConnection();
    }

    public void setUseDataConnection(boolean z) {
        this.mTilesOverlay.setUseDataConnection(z);
    }

    private void updateMinZoomLevel() {
        BoundingBox boundingBox = this.mScrollableAreaBoundingBox;
        if (boundingBox == null || !this.mLayedOut) {
            return;
        }
        float fMax = (float) Math.max(this.mRequestedMinimumZoomLevel, minimumZoomForBoundingBox(boundingBox, this.mConstraintRegionFit, false));
        this.mMinimumZoomLevel = fMax;
        if (this.mZoomLevel < fMax) {
            setZoom(fMax);
        }
    }

    public void updateScrollableAreaLimit() {
        if (this.mScrollableAreaBoundingBox == null || !isLayedOut()) {
            return;
        }
        if (this.mScrollableAreaLimit == null) {
            this.mScrollableAreaLimit = new RectF();
        }
        Projection.toMapPixels(this.mScrollableAreaBoundingBox, getZoomLevel(false), this.mScrollableAreaLimit);
    }

    public void setScrollableAreaLimit(BoundingBox boundingBox) {
        this.mScrollableAreaBoundingBox = boundingBox;
        if (boundingBox == null) {
            this.mMinimumZoomLevel = this.mRequestedMinimumZoomLevel;
            this.mScrollableAreaLimit = null;
        } else {
            updateScrollableAreaLimit();
            updateMinZoomLevel();
        }
    }

    public boolean canGoTo(ILatLng iLatLng) {
        BoundingBox boundingBox = this.mScrollableAreaBoundingBox;
        return boundingBox == null || boundingBox.contains(iLatLng);
    }

    public boolean canGoTo(float f, float f2) {
        RectF rectF = this.mScrollableAreaLimit;
        return rectF == null || rectF.contains(f, f2);
    }

    public BoundingBox getScrollableAreaBoundingBox() {
        return this.mScrollableAreaBoundingBox;
    }

    public RectF getScrollableAreaLimit() {
        return this.mScrollableAreaLimit;
    }

    public boolean isLayedOut() {
        return this.mLayedOut;
    }

    public void invalidateMapCoordinates(Rect rect) {
        this.mInvalidateRect.set(rect);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (getMapOrientation() != 0.0f) {
            GeometryMath.getBoundingBoxForRotatedRectangle(this.mInvalidateRect, scrollX, scrollY, getMapOrientation() + 180.0f, this.mInvalidateRect);
        }
        this.mInvalidateRect.offset(width, height);
        super.invalidate(this.mInvalidateRect);
    }

    public void invalidateMapCoordinates(RectF rectF) {
        rectF.roundOut(this.mInvalidateRect);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (getMapOrientation() != 0.0f) {
            GeometryMath.getBoundingBoxForRotatedRectangle(this.mInvalidateRect, scrollX, scrollY, getMapOrientation() + 180.0f, this.mInvalidateRect);
        }
        this.mInvalidateRect.offset(width, height);
        super.invalidate(this.mInvalidateRect);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, null, 8, 0, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        measureChildren(i, i2);
        Projection projection = getProjection();
        int iMax = 0;
        int iMax2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredWidth = childAt.getMeasuredWidth();
                projection.toMapPixels(layoutParams.geoPoint, this.mPoint);
                int width = ((int) this.mPoint.x) + (getWidth() / 2);
                int height = ((int) this.mPoint.y) + (getHeight() / 2);
                switch (layoutParams.alignment) {
                    case 1:
                        width += measuredWidth;
                        break;
                    case 2:
                        measuredWidth /= 2;
                        width += measuredWidth;
                        break;
                    case 4:
                        width += measuredWidth;
                        measuredHeight /= 2;
                        height += measuredHeight;
                        break;
                    case 5:
                        width += measuredWidth / 2;
                        measuredHeight /= 2;
                        height += measuredHeight;
                        break;
                    case 6:
                        measuredHeight /= 2;
                        height += measuredHeight;
                        break;
                    case 7:
                        width += measuredWidth;
                        height += measuredHeight;
                        break;
                    case 8:
                        measuredWidth /= 2;
                        width += measuredWidth;
                        height += measuredHeight;
                        break;
                    case 9:
                        height += measuredHeight;
                        break;
                }
                int i4 = width + layoutParams.offsetX;
                int i5 = height + layoutParams.offsetY;
                iMax = Math.max(iMax, i4);
                iMax2 = Math.max(iMax2, i5);
            }
        }
        setMeasuredDimension(resolveSize(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i), resolveSize(Math.max(iMax2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == 0 || i2 == 0) {
            return;
        }
        this.mProjection = null;
        if (!this.mLayedOut) {
            this.mLayedOut = true;
            this.mController.mapViewLayedOut();
        }
        updateScrollableAreaLimit();
        updateMinZoomLevel();
        BoundingBox boundingBox = this.mBoundingBoxToZoomOn;
        if (boundingBox != null) {
            zoomToBoundingBox(boundingBox, this.mBoundingBoxToZoomOnRegionFit);
            this.mBoundingBoxToZoomOn = null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0046. Please report as an issue. */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int paddingTop2;
        int i5;
        int paddingTop3;
        int childCount = getChildCount();
        Projection projection = getProjection();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int measuredWidth = childAt.getMeasuredWidth();
                projection.toMapPixels(layoutParams.geoPoint, this.mPoint);
                int width = ((int) this.mPoint.x) + (getWidth() / 2);
                int height = ((int) this.mPoint.y) + (getHeight() / 2);
                switch (layoutParams.alignment) {
                    case 1:
                        width += getPaddingLeft();
                        paddingTop = getPaddingTop();
                        height += paddingTop;
                        break;
                    case 2:
                        width = (getPaddingLeft() + width) - (measuredWidth / 2);
                        paddingTop = getPaddingTop();
                        height += paddingTop;
                        break;
                    case 3:
                        width = (getPaddingLeft() + width) - measuredWidth;
                        paddingTop = getPaddingTop();
                        height += paddingTop;
                        break;
                    case 4:
                        width += getPaddingLeft();
                        paddingTop2 = getPaddingTop() + height;
                        i5 = measuredHeight / 2;
                        height = paddingTop2 - i5;
                        break;
                    case 5:
                        width = (getPaddingLeft() + width) - (measuredWidth / 2);
                        paddingTop2 = getPaddingTop() + height;
                        i5 = measuredHeight / 2;
                        height = paddingTop2 - i5;
                        break;
                    case 6:
                        width = (getPaddingLeft() + width) - measuredWidth;
                        paddingTop2 = getPaddingTop() + height;
                        i5 = measuredHeight / 2;
                        height = paddingTop2 - i5;
                        break;
                    case 7:
                        width += getPaddingLeft();
                        paddingTop3 = getPaddingTop();
                        height = (paddingTop3 + height) - measuredHeight;
                        break;
                    case 8:
                        width = (getPaddingLeft() + width) - (measuredWidth / 2);
                        paddingTop3 = getPaddingTop();
                        height = (paddingTop3 + height) - measuredHeight;
                        break;
                    case 9:
                        width = (getPaddingLeft() + width) - measuredWidth;
                        paddingTop3 = getPaddingTop();
                        height = (paddingTop3 + height) - measuredHeight;
                        break;
                }
                int i7 = width + layoutParams.offsetX;
                int i8 = height + layoutParams.offsetY;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    public void onDetach() {
        getOverlayManager().onDetach(this);
        this.mTileProvider.detach();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return getOverlayManager().onKeyDown(i, keyEvent, this) || super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return getOverlayManager().onKeyUp(i, keyEvent, this) || super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (getOverlayManager().onTrackballEvent(motionEvent, this)) {
            return true;
        }
        scrollBy((int) (motionEvent.getX() * 25.0f), (int) (motionEvent.getY() * 25.0f));
        return super.onTrackballEvent(motionEvent);
    }

    private boolean handleTwoFingersTap(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.multiTouchDownCount = 0;
            } else if (actionMasked == 1) {
                if (!isAnimating() && this.canTapTwoFingers) {
                    this.mController.zoomOutAbout(getProjection().fromPixels(motionEvent.getX(), motionEvent.getY()));
                    this.canTapTwoFingers = false;
                    this.multiTouchDownCount = 0;
                    return true;
                }
                this.canTapTwoFingers = false;
                this.multiTouchDownCount = 0;
            } else if (actionMasked == 5) {
                int i2 = this.multiTouchDownCount + 1;
                this.multiTouchDownCount = i2;
                this.canTapTwoFingers = i2 > 1;
            } else if (actionMasked == 6) {
                this.multiTouchDownCount--;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MotionEvent motionEventRotateTouchEvent = rotateTouchEvent(motionEvent);
        try {
            if (getOverlayManager().onTouchEvent(motionEventRotateTouchEvent, this)) {
                Log.d(TAG, "OverlayManager handled onTouchEvent");
                return true;
            }
            if (motionEventRotateTouchEvent.getPointerCount() != 1) {
                this.mScaleGestureDetector.onTouchEvent(motionEventRotateTouchEvent);
            }
            boolean zIsInProgress = this.mScaleGestureDetector.isInProgress();
            if (!zIsInProgress) {
                zIsInProgress = this.mGestureDetector.onTouchEvent(motionEventRotateTouchEvent);
            } else {
                this.canTapTwoFingers = false;
            }
            boolean zHandleTwoFingersTap = zIsInProgress | handleTwoFingersTap(motionEventRotateTouchEvent);
            if (motionEventRotateTouchEvent != motionEvent) {
                motionEventRotateTouchEvent.recycle();
            }
            return zHandleTwoFingersTap;
        } finally {
            if (motionEventRotateTouchEvent != motionEvent) {
                motionEventRotateTouchEvent.recycle();
            }
        }
    }

    private MotionEvent rotateTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (getMapOrientation() == 0.0f) {
            return motionEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (Build.VERSION.SDK_INT < 11) {
            this.mRotatePoints[0] = motionEvent.getX();
            this.mRotatePoints[1] = motionEvent.getY();
            getProjection().rotatePoints(this.mRotatePoints);
            float[] fArr = this.mRotatePoints;
            motionEventObtain.setLocation(fArr[0], fArr[1]);
        } else {
            try {
                if (sMotionEventTransformMethod == null) {
                    sMotionEventTransformMethod = MotionEvent.class.getDeclaredMethod("transform", Matrix.class);
                }
                sMotionEventTransformMethod.invoke(motionEventObtain, getProjection().getRotationMatrix());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return motionEventObtain;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScroller.isFinished()) {
                scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
                if (!isAnimating()) {
                    snapItems();
                }
                this.mIsFlinging = false;
            } else {
                scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            }
            postInvalidate();
        }
    }

    public final PointF getScrollPoint() {
        return this.mDScroll;
    }

    public final void setScrollPoint(PointF pointF) {
        scrollTo(pointF.x, pointF.y);
    }

    public final PointF getScalePoint() {
        return this.mMultiTouchScalePoint;
    }

    public final void setScalePoint(PointF pointF) {
        this.mMultiTouchScalePoint.set(pointF);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        scrollTo(i, i2);
    }

    public void scrollBy(double d, double d2) {
        scrollTo(this.mDScroll.x + d, this.mDScroll.y + d2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scrollTo(double d, double d2) {
        float fCenterX;
        float fCenterY;
        RectF rectF = this.mScrollableAreaLimit;
        if (rectF != null) {
            float measuredWidth = getMeasuredWidth() / 2;
            float measuredHeight = getMeasuredHeight() / 2;
            if (rectF.width() <= measuredWidth * 2.0f) {
                fCenterX = rectF.centerX();
            } else {
                double d3 = measuredWidth;
                if (d - d3 < rectF.left) {
                    fCenterX = rectF.left + measuredWidth;
                } else {
                    if (d3 + d > rectF.right) {
                        fCenterX = rectF.right - measuredWidth;
                    }
                    if (rectF.height() > 2.0f * measuredHeight) {
                        fCenterY = rectF.centerY();
                    } else {
                        double d4 = measuredHeight;
                        if (d2 - d4 < rectF.top) {
                            fCenterY = rectF.top + measuredHeight;
                        } else if (d4 + d2 > rectF.bottom) {
                            fCenterY = rectF.bottom - measuredHeight;
                        }
                    }
                    d2 = fCenterY;
                }
            }
            d = fCenterX;
            if (rectF.height() > 2.0f * measuredHeight) {
            }
            d2 = fCenterY;
        }
        if (!isAnimating()) {
            this.mController.offsetDeltaScroll((float) (d - this.mDScroll.x), (float) (d2 - this.mDScroll.y));
        }
        this.mDScroll.set((float) d, (float) d2);
        int iRound = (int) Math.round(d);
        int iRound2 = (int) Math.round(d2);
        this.mProjection = null;
        super.scrollTo(iRound, iRound2);
        if (this.mListeners.size() > 0) {
            ScrollEvent scrollEvent = new ScrollEvent(this, iRound, iRound2, this.mController.currentlyInUserAction());
            Iterator<MapListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onScroll(scrollEvent);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mTilesOverlay.setLoadingBackgroundColor(i);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mProjection = updateProjection();
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        float f = this.mMultiTouchScale;
        canvas.scale(f, f, this.mMultiTouchScalePoint.x, this.mMultiTouchScalePoint.y);
        canvas.rotate(this.mapOrientation, this.mProjection.getScreenRect().exactCenterX(), this.mProjection.getScreenRect().exactCenterY());
        getOverlayManager().draw(canvas, this);
        canvas.restore();
    }

    private Projection updateProjection() {
        return new Projection(this);
    }

    public boolean isUsingSafeCanvas() {
        return getOverlayManager().isUsingSafeCanvas();
    }

    public void setUseSafeCanvas(boolean z) {
        getOverlayManager().setUseSafeCanvas(z);
    }

    public MapView setConstraintRegionFit(boolean z) {
        this.mConstraintRegionFit = z;
        if (isLayedOut()) {
            updateScrollableAreaLimit();
            updateMinZoomLevel();
        }
        return this;
    }

    private UserLocationOverlay getOrCreateLocationOverlay() {
        if (this.mLocationOverlay == null) {
            UserLocationOverlay userLocationOverlay = new UserLocationOverlay(new GpsLocationProvider(getContext()), this);
            this.mLocationOverlay = userLocationOverlay;
            addOverlay(userLocationOverlay);
        }
        return this.mLocationOverlay;
    }

    public MapView setUserLocationEnabled(boolean z) {
        if (z) {
            getOrCreateLocationOverlay().enableMyLocation();
        } else {
            UserLocationOverlay userLocationOverlay = this.mLocationOverlay;
            if (userLocationOverlay != null) {
                userLocationOverlay.disableMyLocation();
                removeOverlay(this.mLocationOverlay);
                this.mLocationOverlay = null;
            }
        }
        return this;
    }

    public final boolean getUserLocationEnabled() {
        UserLocationOverlay userLocationOverlay = this.mLocationOverlay;
        if (userLocationOverlay != null) {
            return userLocationOverlay.isMyLocationEnabled();
        }
        return false;
    }

    public MapView setUserLocationTrackingMode(UserLocationOverlay.TrackingMode trackingMode) {
        getOrCreateLocationOverlay().setTrackingMode(trackingMode);
        return this;
    }

    public MapView setUserLocationRequiredZoom(float f) {
        getOrCreateLocationOverlay().setRequiredZoom(f);
        return this;
    }

    public UserLocationOverlay.TrackingMode getUserLocationTrackingMode() {
        UserLocationOverlay userLocationOverlay = this.mLocationOverlay;
        if (userLocationOverlay != null) {
            return userLocationOverlay.getTrackingMode();
        }
        return UserLocationOverlay.TrackingMode.NONE;
    }

    public void goToUserLocation(boolean z) {
        UserLocationOverlay userLocationOverlay = this.mLocationOverlay;
        if (userLocationOverlay != null) {
            userLocationOverlay.goToMyPosition(z);
        }
    }

    public UserLocationOverlay getUserLocationOverlay() {
        return this.mLocationOverlay;
    }

    public LatLng getUserLocation() {
        UserLocationOverlay userLocationOverlay = this.mLocationOverlay;
        if (userLocationOverlay != null) {
            return userLocationOverlay.getMyLocation();
        }
        return null;
    }

    public boolean isUserLocationVisible() {
        Location lastFix;
        UserLocationOverlay userLocationOverlay = this.mLocationOverlay;
        if (userLocationOverlay == null || (lastFix = userLocationOverlay.getLastFix()) == null || !isLayedOut()) {
            return false;
        }
        Projection projection = getProjection();
        float accuracy = lastFix.getAccuracy() / ((float) projection.groundResolution(lastFix.getLatitude()));
        PointF mapPixels = projection.toMapPixels(lastFix.getLatitude(), lastFix.getLongitude(), (PointF) null);
        return projection.getScreenRect().intersects((int) (mapPixels.x - accuracy), (int) (mapPixels.y - accuracy), (int) (mapPixels.x + accuracy), (int) (mapPixels.y + accuracy));
    }

    public void setDiskCacheEnabled(boolean z) {
        MapTileLayerBase mapTileLayerBase = this.mTileProvider;
        if (mapTileLayerBase != null) {
            mapTileLayerBase.setDiskCacheEnabled(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        onDetach();
        super.onDetachedFromWindow();
    }

    public boolean isAnimating() {
        return this.mIsAnimating.get();
    }

    public TileLoadedListener getTileLoadedListener() {
        return this.tileLoadedListener;
    }

    public static void setDebugMode(boolean z) {
        UtilConstants.setDebugMode(z);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams implements MapViewLayouts {
        public int alignment;
        public ILatLng geoPoint;
        public int offsetX;
        public int offsetY;

        public LayoutParams(int i, int i2, ILatLng iLatLng, int i3, int i4, int i5) {
            super(i, i2);
            if (iLatLng != null) {
                this.geoPoint = iLatLng;
            } else {
                this.geoPoint = new LatLng(0.0d, 0.0d);
            }
            this.alignment = i3;
            this.offsetX = i4;
            this.offsetY = i5;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.geoPoint = new LatLng(0.0d, 0.0d);
            this.alignment = 8;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public void setMapViewListener(MapViewListener mapViewListener) {
        this.mMapViewListener = mapViewListener;
    }

    public void setOnTileLoadedListener(TileLoadedListener tileLoadedListener) {
        this.tileLoadedListener = tileLoadedListener;
    }

    public void setOnTilesLoadedListener(TilesLoadedListener tilesLoadedListener) {
        this.tilesLoadedListener = tilesLoadedListener;
    }

    public TilesLoadedListener getTilesLoadedListener() {
        return this.tilesLoadedListener;
    }

    @Override // android.view.View
    public String toString() {
        return "MapView {" + getTileProvider() + "}";
    }

    public void setDefaultPinRes(int i) {
        this.mDefaultPinRes = i;
    }

    public void setDefaultPinDrawable(Drawable drawable) {
        this.mDefaultPinDrawable = drawable;
    }

    public Drawable getDefaultPinDrawable() {
        if (this.mDefaultPinDrawable == null && this.mDefaultPinRes != 0) {
            this.mDefaultPinDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(this.context.getResources(), this.mDefaultPinRes, BitmapUtils.getBitmapOptions(getResources().getDisplayMetrics())));
        }
        return this.mDefaultPinDrawable;
    }

    public void setDefaultPinAnchor(PointF pointF) {
        this.mDefaultPinAnchor = pointF;
    }

    public PointF getDefaultPinAnchor() {
        return this.mDefaultPinAnchor;
    }
}
