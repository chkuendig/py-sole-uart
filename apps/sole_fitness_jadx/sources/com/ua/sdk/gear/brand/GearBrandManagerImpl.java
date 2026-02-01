package com.ua.sdk.gear.brand;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
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
public class GearBrandManagerImpl extends AbstractManager<GearBrand> implements GearBrandManager {
    public GearBrandManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<GearBrand> diskCache, EntityService<GearBrand> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.gear.brand.GearBrandManager
    public EntityList<GearBrand> fetchGearBrandList(EntityListRef<GearBrand> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.gear.brand.GearBrandManager
    public Request fetchGearBrand(EntityListRef<GearBrand> entityListRef, FetchCallback<EntityList<GearBrand>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }
}
