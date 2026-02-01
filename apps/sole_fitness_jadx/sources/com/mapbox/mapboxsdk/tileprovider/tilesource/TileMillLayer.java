package com.mapbox.mapboxsdk.tileprovider.tilesource;

import com.mapbox.mapboxsdk.tileprovider.MapTile;

/* loaded from: classes2.dex */
public class TileMillLayer extends WebSourceTileLayer {
    private static final String BASE_URL = "http://%s:20008/tile/%s";

    public TileMillLayer(String str, String str2, float f, float f2) {
        super(str, String.format(BASE_URL, str, str2));
        this.mName = "TileMill";
        this.mMinimumZoomLevel = f;
        this.mMaximumZoomLevel = f2;
    }

    public TileMillLayer(String str, String str2) {
        this(str, str2, 0.0f, 22.0f);
    }

    public TileMillLayer(String str) {
        this("localhost", str);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.WebSourceTileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public TileLayer setURL(String str) {
        super.setURL(str + "/%d/%d/%d.png?updated=%d");
        return this;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.WebSourceTileLayer
    public String getTileURL(MapTile mapTile, boolean z) {
        return String.format(this.mUrl, Integer.valueOf(mapTile.getZ()), Integer.valueOf(mapTile.getX()), Integer.valueOf(mapTile.getY()), Long.valueOf(System.currentTimeMillis() / 1000));
    }
}
