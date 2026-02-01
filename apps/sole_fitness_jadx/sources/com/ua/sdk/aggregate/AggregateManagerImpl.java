package com.ua.sdk.aggregate;

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
public class AggregateManagerImpl extends AbstractManager<Aggregate> implements AggregateManager {
    public AggregateManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Aggregate> diskCache, EntityService<Aggregate> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.aggregate.AggregateManager
    public EntityList<Aggregate> fetchAggregateList(EntityListRef<Aggregate> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.aggregate.AggregateManager
    public Request fetchAggregateList(EntityListRef<Aggregate> entityListRef, FetchCallback<EntityList<Aggregate>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }
}
