package com.mapbox.mapboxsdk.tileprovider.tilesource;

import android.graphics.drawable.Drawable;
import com.mapbox.mapboxsdk.geometry.BoundingBox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.constants.TileLayerConstants;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileDownloader;
import com.mapbox.mapboxsdk.views.util.constants.MapViewConstants;

/* loaded from: classes2.dex */
public class TileLayer implements ITileLayer, TileLayerConstants, MapViewConstants {
    protected String mAttribution;
    protected String mCacheKey;
    protected String mDescription;
    protected String mLegend;
    protected String mName;
    protected String mUrl;
    protected float mMinimumZoomLevel = 0.0f;
    protected float mMaximumZoomLevel = 22.0f;
    protected BoundingBox mBoundingBox = WORLD_BOUNDING_BOX;
    protected LatLng mCenter = new LatLng(0.0d, 0.0d);
    private final int mTileSizePixels = 256;

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public void detach() {
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public Drawable getDrawableFromTile(MapTileDownloader mapTileDownloader, MapTile mapTile, boolean z) {
        return null;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public int getTileSizePixels() {
        return 256;
    }

    public TileLayer(String str, String str2) {
        this.mUrl = str2;
        this.mCacheKey = str;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public TileLayer setURL(String str) {
        this.mUrl = str;
        return this;
    }

    public TileLayer setAttribution(String str) {
        this.mAttribution = str;
        return this;
    }

    public TileLayer setDescription(String str) {
        this.mDescription = str;
        return this;
    }

    public TileLayer setName(String str) {
        this.mName = str;
        return this;
    }

    public TileLayer setMinimumZoomLevel(float f) {
        this.mMinimumZoomLevel = f;
        return this;
    }

    public TileLayer setMaximumZoomLevel(float f) {
        this.mMaximumZoomLevel = f;
        return this;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public float getMinimumZoomLevel() {
        return this.mMinimumZoomLevel;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public float getMaximumZoomLevel() {
        return this.mMaximumZoomLevel;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public String getCacheKey() {
        return this.mCacheKey;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public BoundingBox getBoundingBox() {
        return this.mBoundingBox;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public LatLng getCenterCoordinate() {
        return this.mCenter;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public float getCenterZoom() {
        LatLng latLng = this.mCenter;
        if (latLng != null) {
            return (float) latLng.getAltitude();
        }
        return Math.round(this.mMaximumZoomLevel + this.mMinimumZoomLevel) / 2;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public String getName() {
        return this.mName;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public String getDescription() {
        return this.mDescription;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public String getAttribution() {
        return this.mAttribution;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public String getLegend() {
        return this.mLegend;
    }
}
