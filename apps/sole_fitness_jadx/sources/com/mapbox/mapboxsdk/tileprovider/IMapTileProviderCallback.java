package com.mapbox.mapboxsdk.tileprovider;

import android.graphics.drawable.Drawable;
import uk.co.senab.bitmapcache.CacheableBitmapDrawable;

/* loaded from: classes2.dex */
public interface IMapTileProviderCallback {
    void mapTileRequestCompleted(MapTileRequestState mapTileRequestState, Drawable drawable);

    void mapTileRequestExpiredTile(MapTileRequestState mapTileRequestState, CacheableBitmapDrawable cacheableBitmapDrawable);

    void mapTileRequestFailed(MapTileRequestState mapTileRequestState);

    boolean useDataConnection();
}
