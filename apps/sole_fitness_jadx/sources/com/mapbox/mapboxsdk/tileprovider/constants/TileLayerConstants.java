package com.mapbox.mapboxsdk.tileprovider.constants;

import com.mapbox.mapboxsdk.geometry.BoundingBox;

/* loaded from: classes2.dex */
public interface TileLayerConstants {
    public static final int CACHE_MAPTILECOUNT_DEFAULT = 9;
    public static final int CACHE_MAPTILEDISKSIZE_DEFAULT = 104857600;
    public static final boolean DEBUG_TILE_PROVIDERS = false;
    public static final int DEFAULT_TILE_SIZE = 256;
    public static final int MAXIMUM_ZOOMLEVEL = 22;
    public static final int MINIMUM_ZOOMLEVEL = 0;
    public static final int NUMBER_OF_TILE_DOWNLOAD_THREADS = 8;
    public static final int TILE_DOWNLOAD_MAXIMUM_QUEUE_SIZE = 40;
    public static final BoundingBox WORLD_BOUNDING_BOX = new BoundingBox(90.0d, 180.0d, -90.0d, -180.0d);
}
