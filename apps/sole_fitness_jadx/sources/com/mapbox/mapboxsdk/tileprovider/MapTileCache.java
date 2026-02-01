package com.mapbox.mapboxsdk.tileprovider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import com.mapbox.mapboxsdk.tileprovider.constants.TileLayerConstants;
import com.mapbox.mapboxsdk.util.BitmapUtils;
import java.io.File;
import java.io.InputStream;
import uk.co.senab.bitmapcache.BitmapLruCache;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class MapTileCache implements TileLayerConstants {
    private static final String DISK_CACHE_SUBDIR = "mapbox_tiles_cache";
    static final String TAG = "MapTileCache";
    protected static BitmapLruCache sCachedTiles;
    private Context context;
    private boolean mDiskCacheEnabled;
    private int mMaximumCacheSize;

    public MapTileCache(Context context) {
        this(context, TileLayerConstants.CACHE_MAPTILEDISKSIZE_DEFAULT);
    }

    public MapTileCache(Context context, int i) {
        this.mDiskCacheEnabled = false;
        this.context = context;
        this.mMaximumCacheSize = i;
    }

    protected BitmapLruCache getCache() {
        if (sCachedTiles == null) {
            File diskCacheDir = getDiskCacheDir(this.context, DISK_CACHE_SUBDIR);
            if (!diskCacheDir.exists()) {
                if (diskCacheDir.mkdirs()) {
                    Log.i(TAG, "created cacheDir " + diskCacheDir.getAbsolutePath());
                } else {
                    Log.e(TAG, "can't create cacheDir " + diskCacheDir);
                }
            } else {
                Log.i(TAG, "cacheDir previously created '" + diskCacheDir.getAbsolutePath() + "'");
            }
            sCachedTiles = new BitmapLruCache.Builder(this.context).setMemoryCacheEnabled(true).setMemoryCacheMaxSize(BitmapUtils.calculateMemoryCacheSize(this.context)).setDiskCacheEnabled(this.mDiskCacheEnabled).setDiskCacheMaxSize(this.mMaximumCacheSize).setDiskCacheLocation(diskCacheDir).build();
            Log.i(TAG, "Disk Cache Enabled: '" + sCachedTiles.isDiskCacheEnabled() + "'; Memory Cache Enabled: '" + sCachedTiles.isMemoryCacheEnabled() + "'");
        }
        return sCachedTiles;
    }

    public String getCacheKey(MapTile mapTile) {
        return mapTile.getCacheKey();
    }

    public CacheableBitmapDrawable getMapTile(MapTile mapTile) {
        String cacheKey = getCacheKey(mapTile);
        CacheableBitmapDrawable fromMemoryCache = getCache().getFromMemoryCache(cacheKey);
        return fromMemoryCache == null ? getCache().getFromDiskCache(cacheKey, null) : fromMemoryCache;
    }

    public CacheableBitmapDrawable getMapTileFromMemory(MapTile mapTile) {
        return getCache().getFromMemoryCache(getCacheKey(mapTile));
    }

    public CacheableBitmapDrawable getMapTileFromDisk(MapTile mapTile) {
        return getCache().getFromDiskCache(getCacheKey(mapTile), null);
    }

    public CacheableBitmapDrawable putTileStream(MapTile mapTile, InputStream inputStream, BitmapFactory.Options options) {
        return getCache().put(getCacheKey(mapTile), inputStream, options);
    }

    public CacheableBitmapDrawable putTileBitmap(MapTile mapTile, Bitmap bitmap) {
        return getCache().put(getCacheKey(mapTile), bitmap);
    }

    public CacheableBitmapDrawable putTile(MapTile mapTile, Drawable drawable) {
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            String cacheKey = getCacheKey(mapTile);
            cacheableBitmapDrawablePutInMemoryCache = getCache().containsInMemoryCache(cacheKey) ? null : getCache().putInMemoryCache(getCacheKey(mapTile), ((BitmapDrawable) drawable).getBitmap());
            if (getCache().isDiskCacheEnabled() && !getCache().containsInDiskCache(cacheKey)) {
                if (cacheableBitmapDrawablePutInMemoryCache != null) {
                    getCache().putInDiskCache(getCacheKey(mapTile), cacheableBitmapDrawablePutInMemoryCache);
                } else {
                    getCache().putInDiskCache(getCacheKey(mapTile), ((BitmapDrawable) drawable).getBitmap());
                }
            }
        }
        return cacheableBitmapDrawablePutInMemoryCache;
    }

    public CacheableBitmapDrawable putTileInMemoryCache(MapTile mapTile, Bitmap bitmap) {
        if (bitmap != null) {
            return getCache().putInMemoryCache(getCacheKey(mapTile), bitmap);
        }
        return null;
    }

    public CacheableBitmapDrawable putTileInMemoryCache(MapTile mapTile, Drawable drawable) {
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        String cacheKey = getCacheKey(mapTile);
        if (drawable instanceof CacheableBitmapDrawable) {
            return getCache().putInMemoryCache(cacheKey, (CacheableBitmapDrawable) drawable);
        }
        return getCache().putInMemoryCache(cacheKey, ((BitmapDrawable) drawable).getBitmap());
    }

    public CacheableBitmapDrawable putTileInDiskCache(MapTile mapTile, Drawable drawable) {
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        String cacheKey = getCacheKey(mapTile);
        if (!getCache().isDiskCacheEnabled() || getCache().containsInDiskCache(cacheKey)) {
            return null;
        }
        return getCache().putInDiskCache(getCacheKey(mapTile), ((BitmapDrawable) drawable).getBitmap());
    }

    public boolean containsTile(MapTile mapTile) {
        return getCache().contains(getCacheKey(mapTile));
    }

    public boolean containsTileInDiskCache(MapTile mapTile) {
        return getCache().isDiskCacheEnabled() && getCache().containsInDiskCache(getCacheKey(mapTile));
    }

    public void removeTile(MapTile mapTile) {
        getCache().remove(getCacheKey(mapTile));
    }

    public void removeTileFromMemory(MapTile mapTile) {
        getCache().removeFromMemoryCache(getCacheKey(mapTile));
    }

    public void purgeMemoryCache() {
        getCache().purgeMemoryCache();
    }

    public void purgeDiskCache() {
        getCache().purgeDiskCache();
    }

    public CacheableBitmapDrawable createCacheableBitmapDrawable(Bitmap bitmap, MapTile mapTile) {
        return getCache().createCacheableBitmapDrawable(bitmap, getCacheKey(mapTile), -1);
    }

    public Bitmap getBitmapFromRemoved(int i, int i2) {
        return getCache().getBitmapFromRemoved(i, i2);
    }

    public Bitmap decodeBitmap(byte[] bArr, BitmapFactory.Options options) {
        return getCache().decodeBitmap(new BitmapLruCache.ByteArrayInputStreamProvider(bArr), options);
    }

    public Bitmap decodeBitmap(BitmapLruCache.InputStreamProvider inputStreamProvider, BitmapFactory.Options options) {
        return getCache().decodeBitmap(inputStreamProvider, options);
    }

    public static File getDiskCacheDir(Context context, String str) {
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? Environment.getExternalStorageDirectory() : context.getFilesDir()).getPath();
        Log.i(TAG, "cachePath: '" + path + "'");
        return new File(path, str);
    }

    public void setDiskCacheEnabled(boolean z) {
        if (this.mDiskCacheEnabled != z) {
            this.mDiskCacheEnabled = z;
            sCachedTiles = null;
        }
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled;
    }
}
