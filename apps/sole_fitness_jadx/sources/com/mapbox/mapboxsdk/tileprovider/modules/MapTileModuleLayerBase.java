package com.mapbox.mapboxsdk.tileprovider.modules;

import android.graphics.drawable.Drawable;
import android.os.Process;
import android.util.Log;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.MapTileRequestState;
import com.mapbox.mapboxsdk.tileprovider.constants.TileLayerConstants;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import com.mapbox.mapboxsdk.util.BitmapUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public abstract class MapTileModuleLayerBase implements TileLayerConstants {
    private static final String TAG = "MapTileModuleLayerBase";
    private final ExecutorService mExecutor;
    protected final LinkedHashMap<MapTile, MapTileRequestState> mPending;
    protected final Object mQueueLockObject = new Object();
    protected final HashMap<MapTile, MapTileRequestState> mWorking;

    public abstract BoundingBox getBoundingBox();

    public abstract String getCacheKey();

    public abstract LatLng getCenterCoordinate();

    public abstract float getCenterZoom();

    public abstract float getMaximumZoomLevel();

    public abstract float getMinimumZoomLevel();

    protected abstract String getName();

    protected abstract String getThreadGroupName();

    protected abstract Runnable getTileLoader();

    public abstract int getTileSizePixels();

    public abstract ITileLayer getTileSource();

    public abstract boolean getUsesDataConnection();

    public abstract void setTileSource(ITileLayer iTileLayer);

    public MapTileRequestState popFirstPending() {
        Iterator<MapTile> it = this.mPending.keySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        return this.mPending.remove(it.next());
    }

    public MapTileModuleLayerBase(int i, final int i2) {
        if (i2 < i) {
            Log.w(TAG, "The pending queue size is smaller than the thread pool size. Automatically reducing the thread pool size.");
            i = i2;
        }
        this.mExecutor = Executors.newFixedThreadPool(i, new ConfigurablePriorityThreadFactory(5, getThreadGroupName()));
        this.mWorking = new HashMap<>();
        this.mPending = new LinkedHashMap<MapTile, MapTileRequestState>(i2 + 2, 0.1f, true) { // from class: com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase.1
            private static final long serialVersionUID = 6455337315681858866L;

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<MapTile, MapTileRequestState> entry) {
                while (size() > i2) {
                    MapTileRequestState mapTileRequestStatePopFirstPending = MapTileModuleLayerBase.this.popFirstPending();
                    mapTileRequestStatePopFirstPending.getCallback().mapTileRequestFailed(mapTileRequestStatePopFirstPending);
                }
                return false;
            }
        };
    }

    public void loadMapTileAsync(MapTileRequestState mapTileRequestState) {
        synchronized (this.mQueueLockObject) {
            Log.d(TAG, "MapTileModuleLayerBase.loadMaptileAsync() on provider: " + getName() + " for tile: " + mapTileRequestState.getMapTile());
            if (this.mPending.containsKey(mapTileRequestState.getMapTile())) {
                Log.d(TAG, "MapTileModuleLayerBase.loadMaptileAsync() tile already exists in request queue for modular provider. Moving to front of queue.");
            } else {
                Log.d(TAG, "MapTileModuleLayerBase.loadMaptileAsync() adding tile to request queue for modular provider.");
            }
            this.mPending.put(mapTileRequestState.getMapTile(), mapTileRequestState);
        }
        try {
            this.mExecutor.execute(getTileLoader());
        } catch (RejectedExecutionException e) {
            Log.w(TAG, "RejectedExecutionException", e);
        }
    }

    protected void clearQueue() {
        synchronized (this.mQueueLockObject) {
            this.mPending.clear();
            this.mWorking.clear();
        }
    }

    public void detach() {
        clearQueue();
        this.mExecutor.shutdown();
    }

    void removeTileFromQueues(MapTile mapTile) {
        synchronized (this.mQueueLockObject) {
            this.mPending.remove(mapTile);
            this.mWorking.remove(mapTile);
        }
    }

    protected abstract class TileLoader implements Runnable {
        protected abstract Drawable loadTile(MapTileRequestState mapTileRequestState) throws CantContinueException;

        protected void onTileLoaderInit() {
        }

        protected void onTileLoaderShutdown() {
        }

        protected TileLoader() {
        }

        protected MapTileRequestState nextTile() {
            MapTileRequestState mapTileRequestStatePopFirstPending;
            synchronized (MapTileModuleLayerBase.this.mQueueLockObject) {
                mapTileRequestStatePopFirstPending = MapTileModuleLayerBase.this.popFirstPending();
                if (mapTileRequestStatePopFirstPending != null) {
                    MapTileModuleLayerBase.this.mWorking.put(mapTileRequestStatePopFirstPending.getMapTile(), mapTileRequestStatePopFirstPending);
                }
            }
            return mapTileRequestStatePopFirstPending;
        }

        protected void tileLoaded(MapTileRequestState mapTileRequestState, Drawable drawable) {
            MapTileModuleLayerBase.this.removeTileFromQueues(mapTileRequestState.getMapTile());
            mapTileRequestState.getCallback().mapTileRequestCompleted(mapTileRequestState, drawable);
        }

        protected void tileLoadedExpired(MapTileRequestState mapTileRequestState, CacheableBitmapDrawable cacheableBitmapDrawable) {
            MapTileModuleLayerBase.this.removeTileFromQueues(mapTileRequestState.getMapTile());
            mapTileRequestState.getCallback().mapTileRequestExpiredTile(mapTileRequestState, cacheableBitmapDrawable);
        }

        protected void tileLoadedFailed(MapTileRequestState mapTileRequestState) {
            MapTileModuleLayerBase.this.removeTileFromQueues(mapTileRequestState.getMapTile());
            mapTileRequestState.getCallback().mapTileRequestFailed(mapTileRequestState);
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            onTileLoaderInit();
            while (true) {
                MapTileRequestState mapTileRequestStateNextTile = nextTile();
                if (mapTileRequestStateNextTile != null) {
                    Drawable drawableLoadTile = null;
                    try {
                        drawableLoadTile = loadTile(mapTileRequestStateNextTile);
                    } catch (CantContinueException e) {
                        Log.e(MapTileModuleLayerBase.TAG, "Tile loader can't continue: " + mapTileRequestStateNextTile.getMapTile(), e);
                        MapTileModuleLayerBase.this.clearQueue();
                    } catch (Throwable th) {
                        Log.e(MapTileModuleLayerBase.TAG, "Error downloading tile: " + mapTileRequestStateNextTile.getMapTile(), th);
                    }
                    if (drawableLoadTile == null) {
                        tileLoadedFailed(mapTileRequestStateNextTile);
                    } else if (BitmapUtils.isCacheDrawableExpired(drawableLoadTile)) {
                        tileLoadedExpired(mapTileRequestStateNextTile, (CacheableBitmapDrawable) drawableLoadTile);
                    } else {
                        tileLoaded(mapTileRequestStateNextTile, drawableLoadTile);
                    }
                } else {
                    onTileLoaderShutdown();
                    return;
                }
            }
        }
    }

    public class CantContinueException extends Exception {
        private static final long serialVersionUID = 146526524087765133L;

        public CantContinueException(String str) {
            super(str);
        }

        public CantContinueException(Throwable th) {
            super(th);
        }
    }
}
