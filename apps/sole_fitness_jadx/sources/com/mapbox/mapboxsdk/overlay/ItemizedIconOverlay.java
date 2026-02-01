package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.util.Projection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ItemizedIconOverlay extends ItemizedOverlay {
    private Context context;
    private int mDrawnItemsLimit;
    protected final List<Marker> mItemList;
    protected OnItemGestureListener<Marker> mOnItemGestureListener;
    private MapView view;

    public interface ActiveItem {
        boolean run(int i);
    }

    public interface OnItemGestureListener<T> {
        boolean onItemLongPress(int i, T t);

        boolean onItemSingleTapUp(int i, T t);
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay.Snappable
    public boolean onSnapToItem(int i, int i2, Point point, MapView mapView) {
        return false;
    }

    public ItemizedIconOverlay(Context context, List<Marker> list, OnItemGestureListener<Marker> onItemGestureListener) {
        this(context, list, onItemGestureListener, false);
    }

    public ItemizedIconOverlay(Context context, List<Marker> list, OnItemGestureListener<Marker> onItemGestureListener, boolean z) {
        this.mDrawnItemsLimit = Integer.MAX_VALUE;
        this.context = context;
        this.mItemList = list;
        this.mOnItemGestureListener = onItemGestureListener;
        if (z) {
            sortListByLatitude();
        }
        populate();
    }

    private void sortListByLatitude() {
        Collections.sort(this.mItemList, new Comparator<Marker>() { // from class: com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.1
            @Override // java.util.Comparator
            public int compare(Marker marker, Marker marker2) {
                return Double.valueOf(marker.getPoint().getLatitude()).compareTo(Double.valueOf(marker2.getPoint().getLatitude()));
            }
        });
    }

    @Override // com.mapbox.mapboxsdk.overlay.ItemizedOverlay
    protected Marker createItem(int i) {
        return this.mItemList.get(i);
    }

    @Override // com.mapbox.mapboxsdk.overlay.ItemizedOverlay
    public int size() {
        return Math.min(this.mItemList.size(), this.mDrawnItemsLimit);
    }

    public boolean addItem(Marker marker) {
        marker.setParentHolder(this);
        boolean zAdd = this.mItemList.add(marker);
        populate();
        return zAdd;
    }

    private boolean activateSelectedItems(MotionEvent motionEvent, MapView mapView, ActiveItem activeItem) {
        Projection projection = mapView.getProjection();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = 0; i < this.mItemList.size(); i++) {
            Marker item = getItem(i);
            if (markerHitTest(item, projection, x, y) && activeItem.run(i)) {
                setFocus(item);
                return true;
            }
        }
        return false;
    }

    public boolean addItems(List list) {
        for (Object obj : list) {
            if (obj instanceof Marker) {
                ((Marker) obj).setParentHolder(this);
            }
        }
        boolean zAddAll = this.mItemList.addAll(list);
        populate();
        return zAddAll;
    }

    public void removeAllItems() {
        removeAllItems(true);
    }

    public void removeAllItems(boolean z) {
        Iterator<Marker> it = this.mItemList.iterator();
        while (it.hasNext()) {
            it.next().setParentHolder(null);
        }
        this.mItemList.clear();
        if (z) {
            populate();
        }
    }

    public boolean removeItem(Marker marker) {
        boolean zRemove = this.mItemList.remove(marker);
        if (zRemove) {
            marker.setParentHolder(null);
        }
        populate();
        return zRemove;
    }

    public Marker removeItem(int i) {
        Marker markerRemove = this.mItemList.remove(i);
        if (markerRemove != null) {
            markerRemove.setParentHolder(null);
        }
        populate();
        return markerRemove;
    }

    public void removeItems(List list) {
        for (Object obj : list) {
            if ((obj instanceof Marker) && this.mItemList.remove(obj)) {
                ((Marker) obj).setParentHolder(null);
            }
        }
        populate();
    }

    @Override // com.mapbox.mapboxsdk.overlay.ItemizedOverlay, com.mapbox.mapboxsdk.overlay.Overlay
    public boolean onSingleTapConfirmed(MotionEvent motionEvent, final MapView mapView) {
        return activateSelectedItems(motionEvent, mapView, new ActiveItem() { // from class: com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.2
            @Override // com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.ActiveItem
            public boolean run(int i) {
                ItemizedIconOverlay itemizedIconOverlay = ItemizedIconOverlay.this;
                if (itemizedIconOverlay.mOnItemGestureListener == null) {
                    return false;
                }
                return ItemizedIconOverlay.this.onSingleTapUpHelper(i, itemizedIconOverlay.mItemList.get(i), mapView);
            }
        });
    }

    protected boolean onSingleTapUpHelper(int i, Marker marker, MapView mapView) {
        return this.mOnItemGestureListener.onItemSingleTapUp(i, marker);
    }

    @Override // com.mapbox.mapboxsdk.overlay.Overlay
    public boolean onLongPress(MotionEvent motionEvent, MapView mapView) {
        return activateSelectedItems(motionEvent, mapView, new ActiveItem() { // from class: com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.3
            @Override // com.mapbox.mapboxsdk.overlay.ItemizedIconOverlay.ActiveItem
            public boolean run(int i) {
                if (ItemizedIconOverlay.this.mOnItemGestureListener == null) {
                    return false;
                }
                ItemizedIconOverlay itemizedIconOverlay = ItemizedIconOverlay.this;
                return itemizedIconOverlay.onLongPressHelper(i, itemizedIconOverlay.getItem(i));
            }
        });
    }

    protected boolean onLongPressHelper(int i, Marker marker) {
        return this.mOnItemGestureListener.onItemLongPress(i, marker);
    }

    private double getThreshold() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
        return r1.widthPixels;
    }

    private ArrayList<LatLng> getCoordinateList(List<Marker> list) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        Iterator<Marker> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPoint());
        }
        return arrayList;
    }

    private float screenX(Marker marker) {
        return this.view.getProjection().toMapPixels(marker.getPoint(), null).x;
    }

    private float screenY(Marker marker) {
        return this.view.getProjection().toMapPixels(marker.getPoint(), null).y;
    }

    public int getDrawnItemsLimit() {
        return this.mDrawnItemsLimit;
    }

    public void setDrawnItemsLimit(int i) {
        this.mDrawnItemsLimit = i;
    }
}
