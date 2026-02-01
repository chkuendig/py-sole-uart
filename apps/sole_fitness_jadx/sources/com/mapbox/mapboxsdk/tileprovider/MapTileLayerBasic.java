package com.mapbox.mapboxsdk.tileprovider;

import android.content.Context;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileDownloader;
import com.mapbox.mapboxsdk.tileprovider.modules.MapTileModuleLayerBase;
import com.mapbox.mapboxsdk.tileprovider.tilesource.ITileLayer;
import com.mapbox.mapboxsdk.tileprovider.util.SimpleRegisterReceiver;
import com.mapbox.mapboxsdk.views.MapView;

/* loaded from: classes2.dex */
public class MapTileLayerBasic extends MapTileLayerArray implements IMapTileProviderCallback {
    Context mContext;
    MapView mMapView;

    public MapTileLayerBasic(Context context, ITileLayer iTileLayer, MapView mapView) {
        super(context, iTileLayer, new SimpleRegisterReceiver(context));
        this.mContext = context;
        this.mMapView = mapView;
        new MapTileDownloader(iTileLayer, this.mTileCache, this.mNetworkAvailabilityCheck, this.mMapView);
        for (MapTileModuleLayerBase mapTileModuleLayerBase : this.mTileProviderList) {
            if (mapTileModuleLayerBase.getClass().isInstance(MapTileDownloader.class)) {
                this.mTileProviderList.remove(mapTileModuleLayerBase);
            }
        }
        addTileSource(iTileLayer);
    }

    @Override // com.mapbox.mapboxsdk.tileprovider.MapTileLayerArray, com.mapbox.mapboxsdk.tileprovider.MapTileLayerBase
    public void setTileSource(ITileLayer iTileLayer) {
        super.setTileSource(iTileLayer);
        addTileSource(iTileLayer);
    }

    public void setTileSources(ITileLayer[] iTileLayerArr) {
        super.setTileSource(null);
        synchronized (this.mTileProviderList) {
            this.mTileProviderList.clear();
        }
        for (ITileLayer iTileLayer : iTileLayerArr) {
            addTileSource(iTileLayer);
        }
    }

    public void addTileSource(ITileLayer iTileLayer) {
        addTileSource(iTileLayer, this.mTileProviderList.size());
    }

    public void addTileSource(ITileLayer iTileLayer, int i) {
        if (iTileLayer == null) {
            return;
        }
        MapTileDownloader mapTileDownloader = new MapTileDownloader(iTileLayer, this.mTileCache, this.mNetworkAvailabilityCheck, this.mMapView);
        if (hasNoSource()) {
            this.mCacheKey = iTileLayer.getCacheKey();
        }
        synchronized (this.mTileProviderList) {
            if (i >= 0) {
                if (i <= this.mTileProviderList.size()) {
                    this.mTileProviderList.add(i, mapTileDownloader);
                }
            }
        }
    }

    public void removeTileSource(int i) {
        synchronized (this.mTileProviderList) {
            boolean z = true;
            boolean z2 = i >= 0;
            if (i >= this.mTileProviderList.size()) {
                z = false;
            }
            if (z & z2) {
                this.mTileProviderList.remove(i);
            }
        }
    }

    public void removeTileSource(ITileLayer iTileLayer) {
        synchronized (this.mTileProviderList) {
            for (MapTileModuleLayerBase mapTileModuleLayerBase : this.mTileProviderList) {
                if (mapTileModuleLayerBase.getTileSource() == iTileLayer) {
                    this.mTileProviderList.remove(mapTileModuleLayerBase);
                    return;
                }
            }
        }
    }
}
