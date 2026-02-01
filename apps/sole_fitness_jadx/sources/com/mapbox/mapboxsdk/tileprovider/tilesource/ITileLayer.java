package com.mapbox.mapboxsdk.tileprovider.tilesource;

import android.graphics.drawable.Drawable;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileDownloader;

/* loaded from: classes2.dex */
public interface ITileLayer {
    void detach();

    String getAttribution();

    BoundingBox getBoundingBox();

    String getCacheKey();

    LatLng getCenterCoordinate();

    float getCenterZoom();

    String getDescription();

    Drawable getDrawableFromTile(MapTileDownloader mapTileDownloader, MapTile mapTile, boolean z);

    String getLegend();

    float getMaximumZoomLevel();

    float getMinimumZoomLevel();

    String getName();

    int getTileSizePixels();

    TileLayer setURL(String str);
}
