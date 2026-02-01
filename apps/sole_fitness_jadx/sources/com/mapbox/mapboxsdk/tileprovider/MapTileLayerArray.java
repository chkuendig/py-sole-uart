package com.mapbox.mapboxsdk.tileprovider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase;
import com.mapbox.mapboxsdk.tileprovider.modules.NetworkAvailabilityCheck;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import com.mapbox.mapboxsdk.util.BitmapUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class MapTileLayerArray extends MapTileLayerBase {
    private static final String TAG = "MapTileLayerArray";
    protected final NetworkAvailabilityCheck mNetworkAvailabilityCheck;
    protected final List<MapTileModuleLayerBase> mTileProviderList;
    protected final List<MapTile> mUnaccessibleTiles;
    protected final HashMap<MapTile, MapTileRequestState> mWorking;

    protected MapTileLayerArray(Context context, ITileLayer iTileLayer, IRegisterReceiver iRegisterReceiver) {
        this(context, iTileLayer, iRegisterReceiver, null);
    }

    public MapTileLayerArray(Context context, ITileLayer iTileLayer, IRegisterReceiver iRegisterReceiver, MapTileModuleLayerBase[] mapTileModuleLayerBaseArr) {
        super(context, iTileLayer);
        this.mWorking = new HashMap<>();
        this.mUnaccessibleTiles = new ArrayList();
        this.mNetworkAvailabilityCheck = new NetworkAvailabilityCheck(context);
        ArrayList arrayList = new ArrayList();
        this.mTileProviderList = arrayList;
        if (mapTileModuleLayerBaseArr != null) {
            this.mCacheKey = mapTileModuleLayerBaseArr[0].getCacheKey();
            Collections.addAll(arrayList, mapTileModuleLayerBaseArr);
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public void detach() {
        if (getTileSource() != null) {
            getTileSource().detach();
        }
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            while (it.hasNext()) {
                it.next().detach();
            }
        }
        synchronized (this.mWorking) {
            this.mWorking.clear();
        }
    }

    private boolean networkAvailable() {
        NetworkAvailabilityCheck networkAvailabilityCheck = this.mNetworkAvailabilityCheck;
        return networkAvailabilityCheck == null || networkAvailabilityCheck.getNetworkAvailable();
    }

    private boolean tileUnavailable(MapTile mapTile) {
        if (this.mUnaccessibleTiles.size() <= 0) {
            return false;
        }
        if (!networkAvailable()) {
            return this.mUnaccessibleTiles.contains(mapTile);
        }
        this.mUnaccessibleTiles.clear();
        return false;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public Drawable getMapTile(MapTile mapTile, boolean z) {
        boolean zContainsKey;
        MapTileRequestState mapTileRequestState;
        Log.d(TAG, "getMapTile() with pTile (CacheKey) = '" + mapTile.getCacheKey() + "'; allowRemote = '" + z + "'");
        if (tileUnavailable(mapTile)) {
            Log.d(TAG, "MapTileLayerArray.getMapTile() tileUnavailable: " + mapTile);
            return null;
        }
        CacheableBitmapDrawable mapTileFromMemory = this.mTileCache.getMapTileFromMemory(mapTile);
        if (mapTileFromMemory != null && mapTileFromMemory.isBitmapValid() && !BitmapUtils.isCacheDrawableExpired(mapTileFromMemory)) {
            mapTileFromMemory.setBeingUsed(true);
            Log.d(TAG, "Found tile(" + mapTile.getCacheKey() + ") in memory, so returning for drawing.");
            return mapTileFromMemory;
        }
        if (z) {
            Log.d(TAG, "Tile not found in memory so will load from remote.");
            synchronized (this.mWorking) {
                zContainsKey = this.mWorking.containsKey(mapTile);
            }
            if (!zContainsKey) {
                Log.d(TAG, "MapTileLayerArray.getMapTile() requested but not in cache, trying from async providers: " + mapTile);
                synchronized (this.mTileProviderList) {
                    mapTileRequestState = new MapTileRequestState(mapTile, (MapTileModuleLayerBase[]) this.mTileProviderList.toArray(new MapTileModuleLayerBase[this.mTileProviderList.size()]), this);
                }
                synchronized (this.mWorking) {
                    if (this.mWorking.containsKey(mapTile)) {
                        return null;
                    }
                    this.mWorking.put(mapTile, mapTileRequestState);
                    MapTileModuleLayerBase mapTileModuleLayerBaseFindNextAppropriateProvider = findNextAppropriateProvider(mapTileRequestState);
                    if (mapTileModuleLayerBaseFindNextAppropriateProvider != null) {
                        mapTileModuleLayerBaseFindNextAppropriateProvider.loadMapTileAsync(mapTileRequestState);
                    } else {
                        mapTileRequestFailed(mapTileRequestState);
                    }
                }
            }
            return mapTileFromMemory;
        }
        Log.w(TAG, "Tile not found in memory, and not allowed to load from remote source.");
        return null;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase, com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public void mapTileRequestCompleted(MapTileRequestState mapTileRequestState, Drawable drawable) {
        synchronized (this.mWorking) {
            this.mWorking.remove(mapTileRequestState.getMapTile());
        }
        super.mapTileRequestCompleted(mapTileRequestState, drawable);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase, com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public void mapTileRequestFailed(MapTileRequestState mapTileRequestState) {
        MapTileModuleLayerBase mapTileModuleLayerBaseFindNextAppropriateProvider = findNextAppropriateProvider(mapTileRequestState);
        if (mapTileModuleLayerBaseFindNextAppropriateProvider != null) {
            mapTileModuleLayerBaseFindNextAppropriateProvider.loadMapTileAsync(mapTileRequestState);
            return;
        }
        synchronized (this.mWorking) {
            this.mWorking.remove(mapTileRequestState.getMapTile());
        }
        if (!networkAvailable()) {
            this.mUnaccessibleTiles.add(mapTileRequestState.getMapTile());
        }
        super.mapTileRequestFailed(mapTileRequestState);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase, com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public void mapTileRequestExpiredTile(MapTileRequestState mapTileRequestState, CacheableBitmapDrawable cacheableBitmapDrawable) {
        super.mapTileRequestExpiredTile(mapTileRequestState, cacheableBitmapDrawable);
        MapTileModuleLayerBase mapTileModuleLayerBaseFindNextAppropriateProvider = findNextAppropriateProvider(mapTileRequestState);
        if (mapTileModuleLayerBaseFindNextAppropriateProvider != null) {
            mapTileModuleLayerBaseFindNextAppropriateProvider.loadMapTileAsync(mapTileRequestState);
            return;
        }
        synchronized (this.mWorking) {
            this.mWorking.remove(mapTileRequestState.getMapTile());
        }
    }

    protected MapTileModuleLayerBase findNextAppropriateProvider(MapTileRequestState mapTileRequestState) {
        MapTileModuleLayerBase nextProvider;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            nextProvider = mapTileRequestState.getNextProvider();
            if (nextProvider != null) {
                boolean z4 = true;
                z = !getProviderExists(nextProvider);
                boolean z5 = !useDataConnection() && nextProvider.getUsesDataConnection();
                float z6 = mapTileRequestState.getMapTile().getZ();
                if (z6 <= nextProvider.getMaximumZoomLevel() && z6 >= nextProvider.getMinimumZoomLevel()) {
                    z4 = false;
                }
                boolean z7 = z5;
                z3 = z4;
                z2 = z7;
            }
            if (nextProvider == null || (!z && !z2 && !z3)) {
                break;
            }
        }
        return nextProvider;
    }

    public boolean getProviderExists(MapTileModuleLayerBase mapTileModuleLayerBase) {
        boolean zContains;
        synchronized (this.mTileProviderList) {
            zContains = this.mTileProviderList.contains(mapTileModuleLayerBase);
        }
        return zContains;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public float getMinimumZoomLevel() {
        float fMax;
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            fMax = 0.0f;
            while (it.hasNext()) {
                fMax = Math.max(fMax, it.next().getMinimumZoomLevel());
            }
        }
        return fMax;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public float getMaximumZoomLevel() {
        float fMin;
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            fMin = 22.0f;
            while (it.hasNext()) {
                fMin = Math.min(fMin, it.next().getMaximumZoomLevel());
            }
        }
        return fMin;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public void setTileSource(ITileLayer iTileLayer) {
        super.setTileSource(iTileLayer);
        this.mUnaccessibleTiles.clear();
        synchronized (this.mTileProviderList) {
            this.mTileProviderList.clear();
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public boolean hasNoSource() {
        boolean z;
        synchronized (this.mTileProviderList) {
            z = this.mTileProviderList.size() == 0;
        }
        return z;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public BoundingBox getBoundingBox() {
        BoundingBox boundingBoxUnion;
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            boundingBoxUnion = null;
            while (it.hasNext()) {
                BoundingBox boundingBox = it.next().getBoundingBox();
                boundingBoxUnion = boundingBoxUnion == null ? boundingBox : boundingBoxUnion.union(boundingBox);
            }
        }
        return boundingBoxUnion;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public LatLng getCenterCoordinate() {
        float latitude;
        int i;
        float longitude;
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            latitude = 0.0f;
            i = 0;
            longitude = 0.0f;
            while (it.hasNext()) {
                LatLng centerCoordinate = it.next().getCenterCoordinate();
                if (centerCoordinate != null) {
                    latitude = (float) (latitude + centerCoordinate.getLatitude());
                    longitude = (float) (longitude + centerCoordinate.getLongitude());
                    i++;
                }
            }
        }
        if (i <= 0) {
            return null;
        }
        float f = i;
        return new LatLng(latitude / f, longitude / f);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public float getCenterZoom() {
        int i;
        float centerZoom;
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            i = 0;
            centerZoom = 0.0f;
            while (it.hasNext()) {
                centerZoom += it.next().getCenterZoom();
                i++;
            }
        }
        return centerZoom > 0.0f ? centerZoom / i : (getMaximumZoomLevel() + getMinimumZoomLevel()) / 2.0f;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public int getTileSizePixels() {
        int tileSizePixels;
        synchronized (this.mTileProviderList) {
            Iterator<MapTileModuleLayerBase> it = this.mTileProviderList.iterator();
            tileSizePixels = it.hasNext() ? 0 + it.next().getTileSizePixels() : 0;
        }
        return tileSizePixels;
    }
}
