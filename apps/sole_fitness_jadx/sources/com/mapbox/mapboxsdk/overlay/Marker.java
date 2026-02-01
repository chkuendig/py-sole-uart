package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.mapbox.mapboxsdk.R;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.InfoWindow;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.util.Projection;

/* loaded from: classes2.dex */
public class Marker {
    public static final int ITEM_STATE_FOCUSED_MASK = 4;
    public static final int ITEM_STATE_PRESSED_MASK = 1;
    public static final int ITEM_STATE_SELECTED_MASK = 2;
    private boolean bubbleShowing;
    private Context context;
    private int group;
    private Icon icon;
    protected PointF mAnchor;
    private boolean mClustered;
    protected final PointF mCurMapCoords;
    private String mDescription;
    private Drawable mImage;
    protected LatLng mLatLng;
    protected Drawable mMarker;
    private final RectF mMyLocationPreviousRect;
    private final RectF mMyLocationRect;
    private ItemizedOverlay mParentHolder;
    private Object mRelatedObject;
    private String mSubDescription;
    private String mTitle;
    private InfoWindow mToolTip;
    protected String mUid;
    private MapView mapView;

    public enum HotspotPlace {
        NONE,
        CENTER,
        BOTTOM_CENTER,
        TOP_CENTER,
        RIGHT_CENTER,
        LEFT_CENTER,
        UPPER_RIGHT_CORNER,
        LOWER_RIGHT_CORNER,
        UPPER_LEFT_CORNER,
        LOWER_LEFT_CORNER
    }

    public Marker(String str, String str2, LatLng latLng) {
        this(null, str, str2, latLng);
    }

    public Marker(MapView mapView, String str, String str2, LatLng latLng) {
        this.group = 0;
        this.mMyLocationRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mMyLocationPreviousRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mCurMapCoords = new PointF();
        this.mAnchor = null;
        this.mTitle = "";
        this.mDescription = "";
        this.mSubDescription = "";
        this.mapView = mapView;
        setTitle(str);
        setDescription(str2);
        this.mLatLng = latLng;
        Log.d(getClass().getCanonicalName(), "markerconst" + mapView + str + str2 + latLng);
        if (mapView != null) {
            this.mAnchor = mapView.getDefaultPinAnchor();
        }
        this.mParentHolder = null;
    }

    public Marker addTo(MapView mapView) {
        if (this.mMarker == null) {
            setMarker(mapView.getDefaultPinDrawable());
        }
        this.mapView = mapView;
        this.context = mapView.getContext();
        if (this.mAnchor == null) {
            this.mAnchor = mapView.getDefaultPinAnchor();
        }
        return this;
    }

    public boolean hasContent() {
        return (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mDescription) && TextUtils.isEmpty(this.mSubDescription) && this.mImage == null) ? false : true;
    }

    protected InfoWindow createTooltip(MapView mapView) {
        return new InfoWindow(R.layout.tooltip, mapView);
    }

    public InfoWindow getToolTip(MapView mapView) {
        InfoWindow infoWindow = this.mToolTip;
        if (infoWindow == null || infoWindow.getMapView() != mapView) {
            this.mToolTip = createTooltip(mapView);
        }
        return this.mToolTip;
    }

    public void closeToolTip() {
        InfoWindow infoWindow = this.mToolTip;
        if (infoWindow == null || !infoWindow.equals(infoWindow.getMapView().getCurrentTooltip())) {
            return;
        }
        this.mToolTip.getMapView().closeCurrentTooltip();
    }

    public void blur() {
        ItemizedOverlay itemizedOverlay = this.mParentHolder;
        if (itemizedOverlay != null) {
            itemizedOverlay.blurItem(this);
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public LatLng getPoint() {
        return this.mLatLng;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setSubDescription(String str) {
        this.mSubDescription = str;
    }

    public void setImage(Drawable drawable) {
        this.mImage = drawable;
    }

    public void setRelatedObject(Object obj) {
        this.mRelatedObject = obj;
    }

    public void setPoint(LatLng latLng) {
        this.mLatLng = latLng;
        invalidate();
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getSubDescription() {
        return this.mSubDescription;
    }

    public Drawable getImage() {
        return this.mImage;
    }

    public Object getRelatedObject() {
        return this.mRelatedObject;
    }

    public ItemizedOverlay getParentHolder() {
        return this.mParentHolder;
    }

    public void setParentHolder(ItemizedOverlay itemizedOverlay) {
        this.mParentHolder = itemizedOverlay;
    }

    public Drawable getMarker(int i) {
        Drawable drawable = this.mMarker;
        if (drawable == null) {
            return null;
        }
        setState(drawable, i);
        return this.mMarker;
    }

    public void setMarker(Drawable drawable) {
        this.mMarker = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        invalidate();
    }

    public void setHotspot(HotspotPlace hotspotPlace) {
        if (hotspotPlace == null) {
            hotspotPlace = HotspotPlace.BOTTOM_CENTER;
        }
        switch (AnonymousClass2.$SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[hotspotPlace.ordinal()]) {
            case 1:
            case 2:
                this.mAnchor.set(0.0f, 0.0f);
                break;
            case 3:
                this.mAnchor.set(0.5f, 1.0f);
                break;
            case 4:
                this.mAnchor.set(0.0f, 1.0f);
                break;
            case 5:
                this.mAnchor.set(1.0f, 1.0f);
                break;
            case 6:
                this.mAnchor.set(0.5f, 0.5f);
                break;
            case 7:
                this.mAnchor.set(0.0f, 0.5f);
                break;
            case 8:
                this.mAnchor.set(1.0f, 0.5f);
                break;
            case 9:
                this.mAnchor.set(0.5f, 0.0f);
                break;
            case 10:
                this.mAnchor.set(1.0f, 0.0f);
                break;
        }
        invalidate();
    }

    /* renamed from: com.mapbox.mapboxsdk.overlay.Marker$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace;

        static {
            int[] iArr = new int[HotspotPlace.values().length];
            $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace = iArr;
            try {
                iArr[HotspotPlace.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.UPPER_LEFT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.BOTTOM_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.LOWER_LEFT_CORNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.LOWER_RIGHT_CORNER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.TOP_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[HotspotPlace.UPPER_RIGHT_CORNER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public Point getAnchor() {
        if (this.mAnchor != null) {
            return new Point((int) ((-this.mAnchor.x) * getWidth()), (int) ((-this.mAnchor.y) * getHeight()));
        }
        return new Point(0, 0);
    }

    public Point getAnchor(HotspotPlace hotspotPlace) {
        return getHotspot(hotspotPlace, getWidth(), getHeight());
    }

    public void setAnchor(PointF pointF) {
        this.mAnchor = pointF;
        invalidate();
    }

    public static void setState(Drawable drawable, int i) {
        int[] iArr = new int[3];
        int i2 = 0;
        if ((i & 1) > 0) {
            iArr[0] = 16842919;
            i2 = 1;
        }
        if ((i & 2) > 0) {
            iArr[i2] = 16842913;
            i2++;
        }
        if ((i & 4) > 0) {
            iArr[i2] = 16842908;
        }
        drawable.setState(iArr);
    }

    public Drawable getDrawable() {
        return this.mMarker;
    }

    public int getWidth() {
        return this.mMarker.getIntrinsicWidth();
    }

    public int getHeight() {
        return this.mMarker.getIntrinsicHeight() / 2;
    }

    public PointF getPositionOnScreen(Projection projection, PointF pointF) {
        return projection.toPixels(this.mCurMapCoords, pointF);
    }

    public PointF getDrawingPositionOnScreen(Projection projection, PointF pointF) {
        PointF positionOnScreen = getPositionOnScreen(projection, pointF);
        Point anchor = getAnchor();
        positionOnScreen.offset(anchor.x, anchor.y);
        return positionOnScreen;
    }

    protected RectF getDrawingBounds(Projection projection, RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        PointF positionOnScreen = getPositionOnScreen(projection, null);
        int width = getWidth();
        int height = getHeight();
        float f = width;
        float f2 = positionOnScreen.x - (this.mAnchor.x * f);
        float f3 = positionOnScreen.y - (this.mAnchor.y * height);
        rectF.set(f2, f3, f + f2, (height * 2) + f3);
        return rectF;
    }

    protected RectF getMapDrawingBounds(Projection projection, RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        }
        projection.toMapPixels(this.mLatLng, this.mCurMapCoords);
        int width = getWidth();
        int height = getHeight();
        float f = width;
        float f2 = this.mCurMapCoords.x - (this.mAnchor.x * f);
        float f3 = this.mCurMapCoords.y - (this.mAnchor.y * height);
        rectF.set(f2, f3, f + f2, (height * 2) + f3);
        return rectF;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public PointF getHotspotScale(HotspotPlace hotspotPlace, PointF pointF) {
        if (pointF == null) {
            pointF = new PointF();
        }
        if (hotspotPlace == null) {
            hotspotPlace = HotspotPlace.BOTTOM_CENTER;
        }
        switch (AnonymousClass2.$SwitchMap$com$mapbox$mapboxsdk$overlay$Marker$HotspotPlace[hotspotPlace.ordinal()]) {
            case 1:
            case 2:
                pointF.set(0.0f, 0.0f);
                return pointF;
            case 3:
                pointF.set(0.5f, 1.0f);
                return pointF;
            case 4:
                pointF.set(0.0f, 1.0f);
                return pointF;
            case 5:
                pointF.set(1.0f, 1.0f);
                return pointF;
            case 6:
                pointF.set(0.5f, 0.5f);
                return pointF;
            case 7:
                pointF.set(0.0f, 0.5f);
                return pointF;
            case 8:
                pointF.set(1.0f, 0.5f);
                return pointF;
            case 9:
                pointF.set(0.5f, 0.0f);
                return pointF;
            case 10:
                pointF.set(1.0f, 0.0f);
                return pointF;
            default:
                return pointF;
        }
    }

    public Point getHotspot(HotspotPlace hotspotPlace, int i, int i2) {
        PointF hotspotScale = getHotspotScale(hotspotPlace, null);
        return new Point((int) ((-i) * hotspotScale.x), (int) ((-i2) * hotspotScale.y));
    }

    public void showBubble(InfoWindow infoWindow, MapView mapView, boolean z) {
        Point anchor = getAnchor();
        Point anchor2 = getAnchor(HotspotPlace.TOP_CENTER);
        anchor.offset(-anchor2.x, anchor2.y);
        infoWindow.open(this, getPoint(), anchor.x, anchor.y);
        if (z) {
            mapView.getController().animateTo(getPoint());
        }
        this.bubbleShowing = true;
        infoWindow.setBoundMarker(this);
    }

    public Marker setIcon(Icon icon) {
        this.icon = icon;
        icon.setMarker(this);
        return this;
    }

    public PointF getPositionOnMap() {
        return this.mCurMapCoords;
    }

    public void updateDrawingPosition() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            return;
        }
        getMapDrawingBounds(mapView.getProjection(), this.mMyLocationRect);
    }

    public void invalidate() {
        if (this.mapView == null) {
            return;
        }
        this.mMyLocationPreviousRect.set(this.mMyLocationRect);
        updateDrawingPosition();
        final RectF rectF = new RectF(this.mMyLocationRect);
        rectF.union(this.mMyLocationPreviousRect);
        this.mapView.post(new Runnable() { // from class: com.mapbox.mapboxsdk.overlay.Marker.1
            @Override // java.lang.Runnable
            public void run() {
                Marker.this.mapView.invalidateMapCoordinates(rectF);
            }
        });
    }
}
