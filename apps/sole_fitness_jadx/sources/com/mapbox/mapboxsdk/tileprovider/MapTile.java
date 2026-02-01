package com.mapbox.mapboxsdk.tileprovider;

import android.graphics.Rect;

/* loaded from: classes2.dex */
public class MapTile {
    public static final int MAPTILE_FAIL_ID = 1;
    public static final int MAPTILE_SUCCESS_ID = 0;
    private final String cacheKey;
    private final int code;
    private Rect mTileRect;
    private final String path;
    private final int x;
    private final int y;
    private final int z;

    public MapTile(int i, int i2, int i3) {
        this("", i, i2, i3);
    }

    public MapTile(String str, int i, int i2, int i3) {
        this.z = i;
        this.x = i2;
        this.y = i3;
        String str2 = String.valueOf(i) + "/" + String.valueOf(i2) + "/" + String.valueOf(i3);
        this.path = str2;
        this.cacheKey = str + "/" + str2;
        this.code = (i + 37) * 17 * i2 * 37 * (i3 + 37);
    }

    public int getZ() {
        return this.z;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public String toString() {
        return this.path;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapTile)) {
            return false;
        }
        MapTile mapTile = (MapTile) obj;
        return this.z == mapTile.z && this.x == mapTile.x && this.y == mapTile.y;
    }

    public int hashCode() {
        return this.code;
    }

    public void setTileRect(Rect rect) {
        this.mTileRect = rect;
    }

    public final Rect getTileRect() {
        return this.mTileRect;
    }
}
