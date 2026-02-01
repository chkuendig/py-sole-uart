package com.mapbox.mapboxsdk.tileprovider.modules;

import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import java.io.InputStream;

/* loaded from: classes2.dex */
public interface IArchiveFile {
    InputStream getInputStream(ITileLayer iTileLayer, MapTile mapTile);
}
