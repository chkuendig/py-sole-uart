package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.util.BitmapUtils;
import com.mapbox.mapboxsdk.util.NetworkUtils;
import com.mapbox.mapboxsdk.util.constants.UtilConstants;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.cli.HelpFormatter;
import uk.co.senab.bitmapcache.BitmapLruCache;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class Icon implements MapboxConstants {
    private static final String DISK_CACHE_SUBDIR = "mapbox_icon_cache";
    private static final String TAG = "Icon";
    private static ConcurrentHashMap<String, ArrayList<Icon>> downloadQueue = new ConcurrentHashMap<>();
    protected static BitmapLruCache sIconCache;
    private Drawable drawable;
    private Marker marker;

    public enum Size {
        LARGE("l"),
        MEDIUM("m"),
        SMALL("s");

        private String apiString;

        Size(String str) {
            this.apiString = str;
        }

        public String getApiString() {
            return this.apiString;
        }
    }

    protected BitmapLruCache getCache() {
        return getCache(null);
    }

    protected BitmapLruCache getCache(Context context) {
        if (sIconCache == null && context != null) {
            File diskCacheDir = getDiskCacheDir(context, DISK_CACHE_SUBDIR);
            if (!diskCacheDir.exists()) {
                if (diskCacheDir.mkdirs()) {
                    if (UtilConstants.DEBUGMODE) {
                        Log.d(TAG, "creating cacheDir " + diskCacheDir);
                    }
                } else {
                    Log.e(TAG, "can't create cacheDir " + diskCacheDir);
                }
            }
            sIconCache = new BitmapLruCache.Builder(context).setMemoryCacheEnabled(true).setMemoryCacheMaxSize(BitmapUtils.calculateMemoryCacheSize(context)).setDiskCacheEnabled(true).setDiskCacheMaxSize(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED).build();
        }
        return sIconCache;
    }

    public static File getDiskCacheDir(Context context, String str) {
        return new File((("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) ? Environment.getExternalStorageDirectory() : context.getFilesDir()).getPath(), str);
    }

    public Icon(Context context, Size size, String str, String str2) {
        String str3;
        String str4 = "https://a.tiles.mapbox.com/v3/marker/pin-" + size.getApiString();
        if (!str.equals("")) {
            str3 = str4 + HelpFormatter.DEFAULT_OPT_PREFIX + str + "+" + str2.replace("#", "") + "@2x.png";
        } else {
            str3 = str4 + "+" + str2.replace("#", "") + "@2x.png";
        }
        downloadBitmap(context, str3);
    }

    public Icon(Drawable drawable) {
        this.drawable = drawable;
    }

    public Icon setMarker(Marker marker) {
        this.marker = marker;
        Drawable drawable = this.drawable;
        if (drawable != null) {
            marker.setMarker(drawable);
        }
        return this;
    }

    private void downloadBitmap(Context context, String str) {
        CacheableBitmapDrawable fromMemoryCache = getCache(context).getFromMemoryCache(str);
        if (fromMemoryCache != null) {
            this.drawable = fromMemoryCache;
            Marker marker = this.marker;
            if (marker != null) {
                marker.setMarker(fromMemoryCache);
                return;
            }
            return;
        }
        if (downloadQueue.putIfAbsent(str, new ArrayList<>()) == null) {
            ArrayList<Icon> arrayList = downloadQueue.get(str);
            synchronized (arrayList) {
                arrayList.add(this);
                new BitmapLoader().execute(str);
            }
            return;
        }
        ArrayList<Icon> arrayList2 = downloadQueue.get(str);
        if (arrayList2 == null) {
            CacheableBitmapDrawable cacheableBitmapDrawable = sIconCache.get(str);
            this.drawable = cacheableBitmapDrawable;
            Marker marker2 = this.marker;
            if (marker2 != null) {
                marker2.setMarker(cacheableBitmapDrawable);
                return;
            }
            return;
        }
        synchronized (arrayList2) {
            if (arrayList2.isEmpty()) {
                CacheableBitmapDrawable cacheableBitmapDrawable2 = sIconCache.get(str);
                this.drawable = cacheableBitmapDrawable2;
                Marker marker3 = this.marker;
                if (marker3 != null) {
                    marker3.setMarker(cacheableBitmapDrawable2);
                }
                return;
            }
            arrayList2.add(this);
        }
    }

    class BitmapLoader extends AsyncTask<String, Void, CacheableBitmapDrawable> {
        private String url;

        BitmapLoader() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public CacheableBitmapDrawable doInBackground(String... strArr) {
            this.url = strArr[0];
            CacheableBitmapDrawable fromDiskCache = Icon.this.getCache().getFromDiskCache(this.url, null);
            if (fromDiskCache != null) {
                return fromDiskCache;
            }
            try {
                if (UtilConstants.DEBUGMODE) {
                    Log.d(Icon.TAG, "Maki url to load = '" + this.url + "'");
                }
                return Icon.sIconCache.put(this.url, NetworkUtils.getHttpURLConnection(new URL(this.url)).getInputStream());
            } catch (IOException unused) {
                Log.e(Icon.TAG, "doInBackground: Unable to fetch icon from: " + this.url);
                return fromDiskCache;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(CacheableBitmapDrawable cacheableBitmapDrawable) {
            if (cacheableBitmapDrawable == null || Icon.this.marker == null) {
                return;
            }
            ArrayList arrayList = (ArrayList) Icon.downloadQueue.get(this.url);
            synchronized (arrayList) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Icon icon = (Icon) it.next();
                    if (icon.marker != null) {
                        icon.marker.setMarker(cacheableBitmapDrawable);
                    }
                }
                if (UtilConstants.DEBUGMODE) {
                    Log.d(Icon.TAG, "Loaded:" + this.url);
                }
                Icon.downloadQueue.remove(this.url);
            }
        }
    }
}
