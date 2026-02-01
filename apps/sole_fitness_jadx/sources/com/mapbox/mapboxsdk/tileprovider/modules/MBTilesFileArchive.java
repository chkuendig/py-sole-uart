package com.mapbox.mapboxsdk.tileprovider.modules;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class MBTilesFileArchive implements IArchiveFile {
    public static final String COL_TILES_TILE_DATA = "tile_data";
    public static final String COL_VALUE = "value";
    public static final String TABLE_METADATA = "metadata";
    public static final String TABLE_TILES = "tiles";
    private static final String TAG = "MBTilesFileArchive";
    private final SQLiteDatabase mDatabase;

    public MBTilesFileArchive(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    public static MBTilesFileArchive getDatabaseFileArchive(File file) throws SQLiteException {
        return new MBTilesFileArchive(SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, 17));
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.modules.IArchiveFile
    public InputStream getInputStream(ITileLayer iTileLayer, MapTile mapTile) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            Cursor cursorQuery = this.mDatabase.query(TABLE_TILES, new String[]{COL_TILES_TILE_DATA}, "tile_column=? and tile_row=? and zoom_level=?", new String[]{Integer.toString(mapTile.getX()), Double.toString((Math.pow(2.0d, mapTile.getZ()) - mapTile.getY()) - 1.0d), Integer.toString(mapTile.getZ())}, null, null, null);
            if (cursorQuery.getCount() != 0) {
                cursorQuery.moveToFirst();
                byteArrayInputStream = new ByteArrayInputStream(cursorQuery.getBlob(0));
            } else {
                byteArrayInputStream = null;
            }
            cursorQuery.close();
        } catch (Throwable th) {
            Log.e(TAG, "Error getting db stream: " + mapTile, th);
        }
        if (byteArrayInputStream != null) {
            return byteArrayInputStream;
        }
        return null;
    }

    public String toString() {
        return "MBTiles [mDatabase=" + this.mDatabase.getPath() + "]";
    }

    private String getStringValue(String str) {
        Cursor cursorQuery = this.mDatabase.query(TABLE_METADATA, new String[]{"value"}, "name = ?", new String[]{str}, null, null, null);
        try {
            cursorQuery.moveToFirst();
            return cursorQuery.getString(0);
        } catch (Exception unused) {
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public float getMinZoomLevel() {
        String stringValue = getStringValue("minzoom");
        if (stringValue != null) {
            return Float.parseFloat(stringValue);
        }
        return 0.0f;
    }

    public float getMaxZoomLevel() {
        String stringValue = getStringValue("maxzoom");
        if (stringValue != null) {
            return Float.parseFloat(stringValue);
        }
        return 22.0f;
    }

    public String getName() {
        return getStringValue("name");
    }

    public String getType() {
        return getStringValue("template");
    }

    public String getVersion() {
        return getStringValue("version");
    }

    public String getDescription() {
        return getStringValue("description");
    }

    public String getAttribution() {
        return getStringValue("attribution");
    }

    public BoundingBox getBounds() {
        String stringValue = getStringValue("bounds");
        if (stringValue == null) {
            return null;
        }
        String[] strArrSplit = stringValue.split(",\\s*");
        return new BoundingBox(Double.parseDouble(strArrSplit[3]), Double.parseDouble(strArrSplit[2]), Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0]));
    }

    public LatLng getCenter() {
        String stringValue = getStringValue("center");
        if (stringValue == null) {
            return null;
        }
        String[] strArrSplit = stringValue.split(",\\s*");
        return new LatLng(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[2]));
    }

    public void close() {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
