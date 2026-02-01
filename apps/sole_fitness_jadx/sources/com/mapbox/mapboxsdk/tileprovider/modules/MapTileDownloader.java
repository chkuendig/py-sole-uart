package com.mapbox.mapboxsdk.tileprovider.modules;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.MapTileCache;
import com.mapbox.mapboxsdk.tileprovider.MapTileRequestState;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer;
import com.mapbox.mapboxsdk.views.MapView;
import com.mapbox.mapboxsdk.views.util.TileLoadedListener;
import com.mapbox.mapboxsdk.views.util.TilesLoadedListener;
import java.util.concurrent.atomic.AtomicReference;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class MapTileDownloader extends MapTileModuleLayerBase {
    private static final String TAG = "MapTileDownloader";
    boolean hdpi;
    private final NetworkAvailabilityCheck mNetworkAvailabilityCheck;
    private final AtomicReference<MapTileCache> mTileCache;
    private final AtomicReference<TileLayer> mTileSource;
    private MapView mapView;

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    protected String getName() {
        return "Online Tile Download Provider";
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    protected String getThreadGroupName() {
        return "downloader";
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public boolean getUsesDataConnection() {
        return true;
    }

    public MapTileDownloader(ITileLayer iTileLayer, MapTileCache mapTileCache, NetworkAvailabilityCheck networkAvailabilityCheck, MapView mapView) {
        super(8, 40);
        this.mTileSource = new AtomicReference<>();
        AtomicReference<MapTileCache> atomicReference = new AtomicReference<>();
        this.mTileCache = atomicReference;
        this.mapView = mapView;
        atomicReference.set(mapTileCache);
        this.hdpi = mapView.getContext().getResources().getDisplayMetrics().densityDpi > 240;
        this.mNetworkAvailabilityCheck = networkAvailabilityCheck;
        setTileSource(iTileLayer);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public ITileLayer getTileSource() {
        return this.mTileSource.get();
    }

    public MapTileCache getCache() {
        return this.mTileCache.get();
    }

    public boolean isNetworkAvailable() {
        NetworkAvailabilityCheck networkAvailabilityCheck = this.mNetworkAvailabilityCheck;
        return networkAvailabilityCheck == null || networkAvailabilityCheck.getNetworkAvailable();
    }

    public TilesLoadedListener getTilesLoadedListener() {
        return this.mapView.getTilesLoadedListener();
    }

    public TileLoadedListener getTileLoadedListener() {
        return this.mapView.getTileLoadedListener();
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    protected Runnable getTileLoader() {
        return new TileLoader();
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public float getMinimumZoomLevel() {
        TileLayer tileLayer = this.mTileSource.get();
        if (tileLayer != null) {
            return tileLayer.getMinimumZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public float getMaximumZoomLevel() {
        TileLayer tileLayer = this.mTileSource.get();
        if (tileLayer != null) {
            return tileLayer.getMaximumZoomLevel();
        }
        return 22.0f;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public BoundingBox getBoundingBox() {
        TileLayer tileLayer = this.mTileSource.get();
        if (tileLayer != null) {
            return tileLayer.getBoundingBox();
        }
        return null;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public LatLng getCenterCoordinate() {
        TileLayer tileLayer = this.mTileSource.get();
        if (tileLayer != null) {
            return tileLayer.getCenterCoordinate();
        }
        return null;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public float getCenterZoom() {
        TileLayer tileLayer = this.mTileSource.get();
        return tileLayer != null ? tileLayer.getCenterZoom() : (getMaximumZoomLevel() + getMinimumZoomLevel()) / 2.0f;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public int getTileSizePixels() {
        TileLayer tileLayer = this.mTileSource.get();
        if (tileLayer != null) {
            return tileLayer.getTileSizePixels();
        }
        return 0;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public void setTileSource(ITileLayer iTileLayer) {
        if (this.mTileSource.get() != null) {
            this.mTileSource.get().detach();
        }
        if (iTileLayer instanceof TileLayer) {
            this.mTileSource.set((TileLayer) iTileLayer);
        } else {
            this.mTileSource.set(null);
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase
    public String getCacheKey() {
        TileLayer tileLayer = this.mTileSource.get();
        return tileLayer != null ? tileLayer.getCacheKey() : "";
    }

    protected class TileLoader extends MapTileModuleLayerBase.TileLoader {
        protected TileLoader() {
            super();
        }

        @Override // com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase.TileLoader
        public Drawable loadTile(MapTileRequestState mapTileRequestState) throws MapTileModuleLayerBase.CantContinueException {
            Drawable drawableFromTile;
            MapTile mapTile = mapTileRequestState.getMapTile();
            Log.d(MapTileDownloader.TAG, "loadTile() with tile = '" + mapTile + "'");
            if (MapTileDownloader.this.mTileCache == null || !((MapTileCache) MapTileDownloader.this.mTileCache.get()).containsTileInDiskCache(mapTile)) {
                TileLayer tileLayer = (TileLayer) MapTileDownloader.this.mTileSource.get();
                if (tileLayer != null) {
                    MapTileDownloader mapTileDownloader = MapTileDownloader.this;
                    drawableFromTile = tileLayer.getDrawableFromTile(mapTileDownloader, mapTile, mapTileDownloader.hdpi);
                } else {
                    drawableFromTile = null;
                }
                Log.d(MapTileDownloader.TAG, "tileLayer.getDrawable() returning result = '" + drawableFromTile + "'");
                return drawableFromTile;
            }
            Log.d(MapTileDownloader.TAG, "tile found in Disk Cache, so returning it. tile = '" + mapTile + "'");
            return ((MapTileCache) MapTileDownloader.this.mTileCache.get()).getMapTileFromDisk(mapTile);
        }
    }

    private CacheableBitmapDrawable onTileLoaded(CacheableBitmapDrawable cacheableBitmapDrawable) {
        return this.mapView.getTileLoadedListener().onTileLoaded(cacheableBitmapDrawable);
    }
}
