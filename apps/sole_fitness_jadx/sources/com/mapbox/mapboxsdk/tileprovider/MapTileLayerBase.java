package com.mapbox.mapboxsdk.tileprovider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.constants.TileLayerConstants;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import com.mapbox.mapboxsdk.util.BitmapUtils;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public abstract class MapTileLayerBase implements IMapTileProviderCallback, TileLayerConstants {
    private static final String TAG = "MapTileLayerBase";
    protected Context context;
    protected String mCacheKey;
    protected final MapTileCache mTileCache;
    private Handler mTileRequestCompleteHandler;
    private ITileLayer mTileSource;
    private boolean mUseDataConnection;

    public abstract void detach();

    public abstract Drawable getMapTile(MapTile mapTile, boolean z);

    public float getMinimumZoomLevel() {
        return this.mTileSource.getMinimumZoomLevel();
    }

    public float getMaximumZoomLevel() {
        return this.mTileSource.getMaximumZoomLevel();
    }

    public int getTileSizePixels() {
        return this.mTileSource.getTileSizePixels();
    }

    public BoundingBox getBoundingBox() {
        return this.mTileSource.getBoundingBox();
    }

    public LatLng getCenterCoordinate() {
        return this.mTileSource.getCenterCoordinate();
    }

    public float getCenterZoom() {
        return this.mTileSource.getCenterZoom();
    }

    public void setTileSource(ITileLayer iTileLayer) {
        ITileLayer iTileLayer2 = this.mTileSource;
        if (iTileLayer2 != null) {
            iTileLayer2.detach();
        }
        this.mTileSource = iTileLayer;
        if (iTileLayer != null) {
            this.mCacheKey = iTileLayer.getCacheKey();
        }
    }

    public ITileLayer getTileSource() {
        return this.mTileSource;
    }

    public String getCacheKey() {
        return this.mCacheKey;
    }

    public MapTileCache createTileCache(Context context) {
        return new MapTileCache(context);
    }

    public MapTileLayerBase(Context context, ITileLayer iTileLayer) {
        this(context, iTileLayer, null);
    }

    public MapTileLayerBase(Context context, ITileLayer iTileLayer, Handler handler) {
        this.mUseDataConnection = true;
        this.mCacheKey = "";
        this.context = context;
        this.mTileRequestCompleteHandler = handler;
        this.mTileSource = iTileLayer;
        this.mTileCache = createTileCache(context);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public void mapTileRequestCompleted(MapTileRequestState mapTileRequestState, Drawable drawable) {
        if (this.mTileRequestCompleteHandler != null) {
            Message message = new Message();
            message.obj = mapTileRequestState.getMapTile().getTileRect();
            message.what = 0;
            this.mTileRequestCompleteHandler.sendMessage(message);
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public void mapTileRequestFailed(MapTileRequestState mapTileRequestState) {
        Handler handler = this.mTileRequestCompleteHandler;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public void mapTileRequestExpiredTile(MapTileRequestState mapTileRequestState, CacheableBitmapDrawable cacheableBitmapDrawable) {
        putExpiredTileIntoCache(mapTileRequestState.getMapTile(), cacheableBitmapDrawable.getBitmap());
        Handler handler = this.mTileRequestCompleteHandler;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putTileIntoCacheInternal(MapTile mapTile, Drawable drawable) {
        this.mTileCache.putTile(mapTile, drawable);
    }

    private class CacheTask extends AsyncTask<Object, Void, Void> {
        private CacheTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            MapTileLayerBase.this.putTileIntoCacheInternal((MapTile) objArr[0], (Drawable) objArr[1]);
            return null;
        }
    }

    private void putTileIntoCache(MapTile mapTile, Drawable drawable) {
        if (drawable != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new CacheTask().execute(mapTile, drawable);
            } else {
                putTileIntoCacheInternal(mapTile, drawable);
            }
        }
    }

    protected void putTileIntoCache(MapTileRequestState mapTileRequestState, Drawable drawable) {
        putTileIntoCache(mapTileRequestState.getMapTile(), drawable);
    }

    protected void removeTileFromCache(MapTileRequestState mapTileRequestState) {
        this.mTileCache.removeTileFromMemory(mapTileRequestState.getMapTile());
    }

    public void putExpiredTileIntoCache(MapTile mapTile, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        BitmapUtils.setCacheDrawableExpired(this.mTileCache.putTileInMemoryCache(mapTile, bitmap));
    }

    public void setTileRequestCompleteHandler(Handler handler) {
        this.mTileRequestCompleteHandler = handler;
    }

    public void clearTileMemoryCache() {
        this.mTileCache.purgeMemoryCache();
    }

    public void clearTileDiskCache() {
        this.mTileCache.purgeDiskCache();
    }

    public void setDiskCacheEnabled(boolean z) {
        this.mTileCache.setDiskCacheEnabled(z);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.IMapTileProviderCallback
    public boolean useDataConnection() {
        return this.mUseDataConnection;
    }

    public void setUseDataConnection(boolean z) {
        this.mUseDataConnection = z;
    }

    public boolean hasNoSource() {
        return this.mTileSource == null;
    }

    public CacheableBitmapDrawable getMapTileFromMemory(MapTile mapTile) {
        MapTileCache mapTileCache = this.mTileCache;
        if (mapTileCache != null) {
            return mapTileCache.getMapTileFromMemory(mapTile);
        }
        return null;
    }

    public CacheableBitmapDrawable createCacheableBitmapDrawable(Bitmap bitmap, MapTile mapTile) {
        MapTileCache mapTileCache = this.mTileCache;
        if (mapTileCache != null) {
            return mapTileCache.createCacheableBitmapDrawable(bitmap, mapTile);
        }
        return null;
    }

    public Bitmap getBitmapFromRemoved(int i, int i2) {
        MapTileCache mapTileCache = this.mTileCache;
        if (mapTileCache != null) {
            return mapTileCache.getBitmapFromRemoved(i, i2);
        }
        return null;
    }

    public void removeTileFromMemory(MapTile mapTile) {
        MapTileCache mapTileCache = this.mTileCache;
        if (mapTileCache != null) {
            mapTileCache.removeTileFromMemory(mapTile);
        }
    }
}
