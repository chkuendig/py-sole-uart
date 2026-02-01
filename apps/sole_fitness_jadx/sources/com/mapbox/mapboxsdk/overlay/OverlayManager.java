package com.mapbox.mapboxsdk.overlay;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import com.mapbox.mapboxsdk.overlay.Overlay;
import com.mapbox.mapboxsdk.views.MapView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class OverlayManager extends AbstractList<Overlay> {
    private final CopyOnWriteArrayList<Overlay> mOverlayList;
    private TilesOverlay mTilesOverlay;
    private boolean mUseSafeCanvas = true;

    public OverlayManager(TilesOverlay tilesOverlay) {
        setTilesOverlay(tilesOverlay);
        this.mOverlayList = new CopyOnWriteArrayList<>();
    }

    @Override // java.util.AbstractList, java.util.List
    public Overlay get(int i) {
        return this.mOverlayList.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mOverlayList.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Overlay overlay) {
        try {
            this.mOverlayList.add(i, overlay);
            if (overlay instanceof SafeDrawOverlay) {
                ((SafeDrawOverlay) overlay).setUseSafeCanvas(isUsingSafeCanvas());
            }
        } finally {
            sortOverlays();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Overlay remove(int i) {
        try {
            return this.mOverlayList.remove(i);
        } finally {
            sortOverlays();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Overlay set(int i, Overlay overlay) {
        try {
            Overlay overlay2 = this.mOverlayList.set(i, overlay);
            if (overlay instanceof SafeDrawOverlay) {
                ((SafeDrawOverlay) overlay).setUseSafeCanvas(isUsingSafeCanvas());
            }
            return overlay2;
        } finally {
            sortOverlays();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer getOverlayClassSortIndex(Overlay overlay) {
        int i;
        if (overlay instanceof MapEventsOverlay) {
            i = 0;
        } else if (overlay instanceof UserLocationOverlay) {
            i = 2;
        } else {
            i = overlay instanceof PathOverlay ? 1 : 3;
        }
        return Integer.valueOf(i);
    }

    private void sortOverlays() {
        CopyOnWriteArrayList<Overlay> copyOnWriteArrayList = this.mOverlayList;
        Overlay[] overlayArr = (Overlay[]) copyOnWriteArrayList.toArray(new Overlay[copyOnWriteArrayList.size()]);
        Arrays.sort(overlayArr, new Comparator<Overlay>() { // from class: com.mapbox.mapboxsdk.overlay.OverlayManager.1
            @Override // java.util.Comparator
            public int compare(Overlay overlay, Overlay overlay2) {
                return OverlayManager.this.getOverlayClassSortIndex(overlay).compareTo(OverlayManager.this.getOverlayClassSortIndex(overlay2));
            }
        });
        this.mOverlayList.clear();
        this.mOverlayList.addAll(Arrays.asList(overlayArr));
    }

    public boolean isUsingSafeCanvas() {
        return this.mUseSafeCanvas;
    }

    public void setUseSafeCanvas(boolean z) {
        this.mUseSafeCanvas = z;
        Iterator<Overlay> it = this.mOverlayList.iterator();
        while (it.hasNext()) {
            Overlay next = it.next();
            if (next instanceof SafeDrawOverlay) {
                ((SafeDrawOverlay) next).setUseSafeCanvas(isUsingSafeCanvas());
            }
        }
        TilesOverlay tilesOverlay = this.mTilesOverlay;
        if (tilesOverlay != null) {
            tilesOverlay.setUseSafeCanvas(isUsingSafeCanvas());
        }
    }

    public TilesOverlay getTilesOverlay() {
        return this.mTilesOverlay;
    }

    public void setTilesOverlay(TilesOverlay tilesOverlay) {
        this.mTilesOverlay = tilesOverlay;
        if (tilesOverlay != null) {
            tilesOverlay.setUseSafeCanvas(isUsingSafeCanvas());
        }
    }

    public Iterable<Overlay> overlaysReversed() {
        return new Iterable<Overlay>() { // from class: com.mapbox.mapboxsdk.overlay.OverlayManager.2
            @Override // java.lang.Iterable
            public Iterator<Overlay> iterator() {
                final ListIterator listIterator = OverlayManager.this.mOverlayList.listIterator(OverlayManager.this.mOverlayList.size());
                return new Iterator<Overlay>() { // from class: com.mapbox.mapboxsdk.overlay.OverlayManager.2.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return listIterator.hasPrevious();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public Overlay next() {
                        return (Overlay) listIterator.previous();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        listIterator.remove();
                    }
                };
            }
        };
    }

    public void draw(Canvas canvas, MapView mapView) {
        TilesOverlay tilesOverlay = this.mTilesOverlay;
        if (tilesOverlay != null && tilesOverlay.isEnabled()) {
            this.mTilesOverlay.draw(canvas, mapView, true);
        }
        TilesOverlay tilesOverlay2 = this.mTilesOverlay;
        if (tilesOverlay2 != null && tilesOverlay2.isEnabled()) {
            this.mTilesOverlay.draw(canvas, mapView, false);
        }
        Iterator<Overlay> it = this.mOverlayList.iterator();
        while (it.hasNext()) {
            Overlay next = it.next();
            if (next.isEnabled()) {
                next.draw(canvas, mapView, true);
            }
        }
        Iterator<Overlay> it2 = this.mOverlayList.iterator();
        while (it2.hasNext()) {
            Overlay next2 = it2.next();
            if (next2.isEnabled()) {
                next2.draw(canvas, mapView, false);
            }
        }
    }

    public void onDetach(MapView mapView) {
        TilesOverlay tilesOverlay = this.mTilesOverlay;
        if (tilesOverlay != null) {
            tilesOverlay.onDetach(mapView);
        }
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            it.next().onDetach(mapView);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onKeyDown(i, keyEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onKeyUp(i, keyEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onTouchEvent(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onTrackballEvent(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onSnapToItem(int i, int i2, Point point, MapView mapView) {
        for (Object obj : overlaysReversed()) {
            if ((obj instanceof Overlay.Snappable) && ((Overlay.Snappable) obj).onSnapToItem(i, i2, point, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onDoubleTap(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onDoubleTapEvent(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onSingleTapConfirmed(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onDown(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onDown(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onFling(motionEvent, motionEvent2, f, f2, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onLongPress(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onLongPress(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onScroll(motionEvent, motionEvent2, f, f2, mapView)) {
                return true;
            }
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            it.next().onShowPress(motionEvent, mapView);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent, MapView mapView) {
        Iterator<Overlay> it = overlaysReversed().iterator();
        while (it.hasNext()) {
            if (it.next().onSingleTapUp(motionEvent, mapView)) {
                return true;
            }
        }
        return false;
    }

    public void setOptionsMenusEnabled(boolean z) {
        Iterator<Overlay> it = this.mOverlayList.iterator();
        while (it.hasNext()) {
            Object obj = (Overlay) it.next();
            if (obj instanceof IOverlayMenuProvider) {
                IOverlayMenuProvider iOverlayMenuProvider = (IOverlayMenuProvider) obj;
                if (iOverlayMenuProvider.isOptionsMenuEnabled()) {
                    iOverlayMenuProvider.setOptionsMenuEnabled(z);
                }
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu, int i, MapView mapView) {
        boolean zOnCreateOptionsMenu = true;
        for (Object obj : overlaysReversed()) {
            if (obj instanceof IOverlayMenuProvider) {
                IOverlayMenuProvider iOverlayMenuProvider = (IOverlayMenuProvider) obj;
                if (iOverlayMenuProvider.isOptionsMenuEnabled()) {
                    zOnCreateOptionsMenu &= iOverlayMenuProvider.onCreateOptionsMenu(menu, i, mapView);
                }
            }
        }
        return zOnCreateOptionsMenu;
    }

    public boolean onPrepareOptionsMenu(Menu menu, int i, MapView mapView) {
        for (Object obj : overlaysReversed()) {
            if (obj instanceof IOverlayMenuProvider) {
                IOverlayMenuProvider iOverlayMenuProvider = (IOverlayMenuProvider) obj;
                if (iOverlayMenuProvider.isOptionsMenuEnabled()) {
                    iOverlayMenuProvider.onPrepareOptionsMenu(menu, i, mapView);
                }
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem, int i, MapView mapView) {
        for (Object obj : overlaysReversed()) {
            if (obj instanceof IOverlayMenuProvider) {
                IOverlayMenuProvider iOverlayMenuProvider = (IOverlayMenuProvider) obj;
                if (iOverlayMenuProvider.isOptionsMenuEnabled() && iOverlayMenuProvider.onOptionsItemSelected(menuItem, i, mapView)) {
                    return true;
                }
            }
        }
        return false;
    }
}
