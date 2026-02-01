package com.mapbox.mapboxsdk.tileprovider.tilesource;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.MapTileCache;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileDownloader;
import com.mapbox.mapboxsdk.util.NetworkUtils;
import com.mapbox.mapboxsdk.views.util.TileLoadedListener;
import com.mapbox.mapboxsdk.views.util.TilesLoadedListener;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class WebSourceTileLayer extends TileLayer {
    private static final String TAG = "WebSourceTileLayer";
    private static final Paint compositePaint = new Paint(2);
    private AtomicInteger activeThreads;
    protected boolean mEnableSSL;

    public WebSourceTileLayer(String str, String str2) {
        this(str, str2, false);
    }

    public WebSourceTileLayer(String str, String str2, boolean z) {
        super(str, str2);
        this.activeThreads = new AtomicInteger(0);
        this.mEnableSSL = false;
        initialize(str, str2, z);
    }

    private boolean checkThreadControl() {
        return this.activeThreads.get() == 0;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public TileLayer setURL(String str) {
        Object[] objArr = new Object[1];
        objArr[0] = this.mEnableSSL ? "" : "s";
        if (str.contains(String.format("http%s://", objArr))) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = this.mEnableSSL ? "" : "s";
            String str2 = String.format("http%s://", objArr2);
            Object[] objArr3 = new Object[1];
            objArr3[0] = this.mEnableSSL ? "s" : "";
            super.setURL(str.replace(str2, String.format("http%s://", objArr3)));
        } else {
            super.setURL(str);
        }
        return this;
    }

    protected void initialize(String str, String str2, boolean z) {
        this.mEnableSSL = z;
        setURL(str2);
    }

    public String[] getTileURLs(MapTile mapTile, boolean z) {
        String tileURL = getTileURL(mapTile, z);
        if (TextUtils.isEmpty(tileURL)) {
            return null;
        }
        return new String[]{tileURL};
    }

    public String getTileURL(MapTile mapTile, boolean z) {
        return parseUrlForTile(this.mUrl, mapTile, z);
    }

    protected String parseUrlForTile(String str, MapTile mapTile, boolean z) {
        return str.replace("{z}", String.valueOf(mapTile.getZ())).replace("{x}", String.valueOf(mapTile.getX())).replace("{y}", String.valueOf(mapTile.getY())).replace("{2x}", z ? "@2x" : "");
    }

    private Bitmap compositeBitmaps(Bitmap bitmap, Bitmap bitmap2) {
        new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, compositePaint);
        return bitmap2;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public CacheableBitmapDrawable getDrawableFromTile(MapTileDownloader mapTileDownloader, MapTile mapTile, boolean z) {
        TileLoadedListener tileLoadedListener;
        if (mapTileDownloader.isNetworkAvailable()) {
            TilesLoadedListener tilesLoadedListener = mapTileDownloader.getTilesLoadedListener();
            String[] tileURLs = getTileURLs(mapTile, z);
            if (tileURLs != null) {
                MapTileCache cache = mapTileDownloader.getCache();
                if (tilesLoadedListener != null) {
                    tilesLoadedListener.onTilesLoadStarted();
                }
                Bitmap bitmapCompositeBitmaps = null;
                for (String str : tileURLs) {
                    Bitmap bitmapFromURL = getBitmapFromURL(mapTile, str, cache);
                    if (bitmapFromURL != null) {
                        bitmapCompositeBitmaps = bitmapCompositeBitmaps == null ? bitmapFromURL : compositeBitmaps(bitmapFromURL, bitmapCompositeBitmaps);
                    }
                }
                cacheableBitmapDrawablePutTileBitmap = bitmapCompositeBitmaps != null ? cache.putTileBitmap(mapTile, bitmapCompositeBitmaps) : null;
                if (checkThreadControl() && tilesLoadedListener != null) {
                    tilesLoadedListener.onTilesLoaded();
                }
            }
            return (cacheableBitmapDrawablePutTileBitmap == null || (tileLoadedListener = mapTileDownloader.getTileLoadedListener()) == null) ? cacheableBitmapDrawablePutTileBitmap : tileLoadedListener.onTileLoaded(cacheableBitmapDrawablePutTileBitmap);
        }
        Log.d(TAG, "Skipping tile " + mapTile.toString() + " due to NetworkAvailabilityCheck.");
        return null;
    }

    public Bitmap getBitmapFromURL(MapTile mapTile, String str, MapTileCache mapTileCache) {
        Log.d(getClass().getCanonicalName(), "getBitmapFormURL() called with url = '" + str + "'");
        this.activeThreads.incrementAndGet();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(NetworkUtils.getHttpURLConnection(new URL(str)).getInputStream());
            if (bitmapDecodeStream != null) {
                mapTileCache.putTileInMemoryCache(mapTile, bitmapDecodeStream);
            }
            return bitmapDecodeStream;
        } catch (Throwable th) {
            try {
                Log.e(TAG, "Error downloading MapTile: " + str + CertificateUtil.DELIMITER + th);
                return null;
            } finally {
                this.activeThreads.decrementAndGet();
            }
        }
    }
}
