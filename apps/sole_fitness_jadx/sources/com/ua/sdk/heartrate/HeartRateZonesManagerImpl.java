package com.ua.sdk.heartrate;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class HeartRateZonesManagerImpl extends AbstractManager<HeartRateZones> implements HeartRateZonesManager {
    private static final int NUM_HR_ZONES = 5;

    public HeartRateZonesManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<HeartRateZones> diskCache, EntityService<HeartRateZones> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public EntityList<HeartRateZones> fetchHeartRateZonesList(EntityListRef<HeartRateZones> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public Request fetchHeartRateZonesList(EntityListRef<HeartRateZones> entityListRef, FetchCallback<EntityList<HeartRateZones>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public HeartRateZones fetchHeartRateZones(EntityRef<HeartRateZones> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public Request fetchHeartRateZones(EntityRef<HeartRateZones> entityRef, FetchCallback<HeartRateZones> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public HeartRateZones createHeartRateZones(HeartRateZones heartRateZones) throws UaException {
        return create(heartRateZones);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public Request createHeartRateZones(HeartRateZones heartRateZones, CreateCallback<HeartRateZones> createCallback) {
        return create(heartRateZones, createCallback);
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public HeartRateZones calculateHeartRateZonesWithAge(int i) {
        return calculateHeartRateZonesWithMaxHeartRate((int) (208.0d - (i * 0.7d)));
    }

    @Override // com.ua.sdk.heartrate.HeartRateZonesManager
    public HeartRateZones calculateHeartRateZonesWithMaxHeartRate(int i) {
        HeartRateZone[] heartRateZoneArr = new HeartRateZone[5];
        double d = i;
        heartRateZoneArr[0] = new HeartRateZone("zone1", 0, (int) (0.6d * d));
        heartRateZoneArr[1] = new HeartRateZone("zone2", heartRateZoneArr[0].end + 1, (int) (0.7d * d));
        heartRateZoneArr[2] = new HeartRateZone("zone3", heartRateZoneArr[1].end + 1, (int) (0.8d * d));
        heartRateZoneArr[3] = new HeartRateZone("zone4", heartRateZoneArr[2].end + 1, (int) (d * 0.9d));
        heartRateZoneArr[4] = new HeartRateZone("zone5", heartRateZoneArr[3].end + 1, i);
        return new HeartRateZonesImpl(heartRateZoneArr);
    }
}
