package com.mapbox.mapboxsdk.tileprovider.tilesource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.modules.MBTilesFileArchive;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileDownloader;
import com.mapbox.mapboxsdk.views.util.constants.MapViewConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public class MBTilesLayer extends TileLayer implements MapViewConstants, MapboxConstants {
    private static final String TAG = "MBTilesLayer";
    MBTilesFileArchive mbTilesFileArchive;

    public MBTilesLayer(Context context, String str) {
        super(str.substring(str.lastIndexOf(47) + 1, str.lastIndexOf(46)), str);
        initialize(str, context);
    }

    public MBTilesLayer(String str) {
        this(null, str);
    }

    public MBTilesLayer(File file) {
        super(file.getName(), file.getAbsolutePath());
        initialize(file);
    }

    public MBTilesLayer(SQLiteDatabase sQLiteDatabase) {
        super(getFileName(sQLiteDatabase.getPath()), sQLiteDatabase.getPath());
        initialize(sQLiteDatabase);
    }

    private static final String getFileName(String str) {
        return str.substring(str.lastIndexOf(47) + 1, str.lastIndexOf(46));
    }

    private static File createFileFromInputStream(InputStream inputStream, String str) throws IOException {
        try {
            File file = new File(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Failed to create file from input stream.", e);
            return null;
        }
    }

    private void initialize(File file) {
        if (file != null) {
            this.mbTilesFileArchive = MBTilesFileArchive.getDatabaseFileArchive(file);
        }
        MBTilesFileArchive mBTilesFileArchive = this.mbTilesFileArchive;
        if (mBTilesFileArchive != null) {
            this.mMaximumZoomLevel = mBTilesFileArchive.getMaxZoomLevel();
            this.mMinimumZoomLevel = this.mbTilesFileArchive.getMinZoomLevel();
            this.mName = this.mbTilesFileArchive.getName();
            this.mDescription = this.mbTilesFileArchive.getDescription();
            this.mAttribution = this.mbTilesFileArchive.getAttribution();
            this.mBoundingBox = this.mbTilesFileArchive.getBounds();
            this.mCenter = this.mbTilesFileArchive.getCenter();
        }
    }

    private void initialize(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            this.mbTilesFileArchive = new MBTilesFileArchive(sQLiteDatabase);
        }
        MBTilesFileArchive mBTilesFileArchive = this.mbTilesFileArchive;
        if (mBTilesFileArchive != null) {
            this.mMaximumZoomLevel = mBTilesFileArchive.getMaxZoomLevel();
            this.mMinimumZoomLevel = this.mbTilesFileArchive.getMinZoomLevel();
            this.mName = this.mbTilesFileArchive.getName();
            this.mDescription = this.mbTilesFileArchive.getDescription();
            this.mAttribution = this.mbTilesFileArchive.getAttribution();
            this.mBoundingBox = this.mbTilesFileArchive.getBounds();
            this.mCenter = this.mbTilesFileArchive.getCenter();
        }
    }

    private void initialize(String str, Context context) {
        initialize(getFile(str, context));
    }

    private File getFile(String str, Context context) throws IOException {
        if (context != null) {
            try {
                return createFileFromInputStream(context.getAssets().open(str), Environment.getExternalStorageDirectory() + File.separator + str);
            } catch (IOException e) {
                Log.e(TAG, "MBTiles file not found in assets: " + e.toString());
                return null;
            }
        }
        try {
            return new File(str);
        } catch (Exception e2) {
            Log.e(TAG, "can't load MBTiles: " + e2.toString());
            return null;
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public void detach() {
        MBTilesFileArchive mBTilesFileArchive = this.mbTilesFileArchive;
        if (mBTilesFileArchive != null) {
            mBTilesFileArchive.close();
            this.mbTilesFileArchive = null;
        }
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public CacheableBitmapDrawable getDrawableFromTile(MapTileDownloader mapTileDownloader, MapTile mapTile, boolean z) {
        InputStream inputStream;
        MBTilesFileArchive mBTilesFileArchive = this.mbTilesFileArchive;
        if (mBTilesFileArchive == null || (inputStream = mBTilesFileArchive.getInputStream(this, mapTile)) == null) {
            return null;
        }
        CacheableBitmapDrawable cacheableBitmapDrawablePutTileStream = mapTileDownloader.getCache().putTileStream(mapTile, inputStream, null);
        if (cacheableBitmapDrawablePutTileStream == null) {
            Log.d(TAG, "error reading stream from mbtiles");
        }
        return cacheableBitmapDrawablePutTileStream;
    }
}
