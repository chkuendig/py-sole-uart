package com.mapbox.mapboxsdk.tileprovider;

import com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes2.dex */
public class MapTileRequestState {
    private final IMapTileProviderCallback mCallback;
    private MapTileModuleLayerBase mCurrentProvider;
    private final MapTile mMapTile;
    private final Queue<MapTileModuleLayerBase> mProviderQueue;

    public MapTileRequestState(MapTile mapTile, MapTileModuleLayerBase[] mapTileModuleLayerBaseArr, IMapTileProviderCallback iMapTileProviderCallback) {
        LinkedList linkedList = new LinkedList();
        this.mProviderQueue = linkedList;
        if (mapTileModuleLayerBaseArr != null) {
            Collections.addAll(linkedList, mapTileModuleLayerBaseArr);
        }
        this.mMapTile = mapTile;
        this.mCallback = iMapTileProviderCallback;
    }

    public MapTile getMapTile() {
        return this.mMapTile;
    }

    public IMapTileProviderCallback getCallback() {
        return this.mCallback;
    }

    public MapTileModuleLayerBase getNextProvider() {
        MapTileModuleLayerBase mapTileModuleLayerBasePoll = this.mProviderQueue.poll();
        this.mCurrentProvider = mapTileModuleLayerBasePoll;
        return mapTileModuleLayerBasePoll;
    }
}
