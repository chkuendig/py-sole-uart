package com.ua.sdk.page;

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
public class PageManagerImpl extends AbstractManager<Page> {
    public PageManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Page> diskCache, EntityService<Page> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    public Page fetchPage(EntityRef<Page> entityRef) throws UaException {
        return fetch(entityRef);
    }

    public Request fetchPage(EntityRef<Page> entityRef, FetchCallback<Page> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    public EntityList<Page> fetchPageList(EntityListRef<Page> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    public Request fetchPageList(EntityListRef<Page> entityListRef, FetchCallback<EntityList<Page>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }
}
