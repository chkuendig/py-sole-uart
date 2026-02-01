package com.mapbox.mapboxsdk.tileprovider.tilesource;

import android.text.TextUtils;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.views.util.constants.MapViewConstants;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MapboxTileLayer extends TileJsonTileLayer implements MapViewConstants, MapboxConstants {
    private static final String TAG = "MapboxTileLayer";
    private String mId;

    public MapboxTileLayer(String str) {
        this(str, true);
    }

    public MapboxTileLayer(String str, boolean z) {
        super(str, str, z);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.WebSourceTileLayer
    protected void initialize(String str, String str2, boolean z) {
        this.mId = str;
        super.initialize(str, str2, z);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.WebSourceTileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public TileLayer setURL(String str) {
        if (!TextUtils.isEmpty(str) && !str.toLowerCase(Locale.US).contains("http://") && !str.toLowerCase(Locale.US).contains("https://")) {
            super.setURL(MapboxConstants.MAPBOX_BASE_URL + str + "/{z}/{x}/{y}{2x}.png");
        } else {
            super.setURL(str);
        }
        return this;
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.TileJsonTileLayer
    protected String getBrandedJSONURL() {
        Object[] objArr = new Object[3];
        objArr[0] = this.mEnableSSL ? "s" : "";
        objArr[1] = this.mId;
        objArr[2] = this.mEnableSSL ? "?secure" : "";
        return String.format("http%s://api.tiles.mapbox.com/v3/%s.json%s", objArr);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.tilesource.TileLayer, com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer
    public String getCacheKey() {
        return this.mId;
    }
}
