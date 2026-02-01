package com.ua.sdk.route.bookmark;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
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
import com.ua.sdk.route.RouteBookmark;
import com.ua.sdk.route.RouteBookmarkManager;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class RouteBookmarkManagerImpl extends AbstractManager<RouteBookmark> implements RouteBookmarkManager {
    public RouteBookmarkManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<RouteBookmark> diskCache, EntityService<RouteBookmark> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.route.RouteBookmarkManager
    public EntityList<RouteBookmark> fetchRouteBookmarkList(EntityListRef<RouteBookmark> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.route.RouteBookmarkManager
    public Request fetchRouteBookmarkList(EntityListRef<RouteBookmark> entityListRef, FetchCallback<EntityList<RouteBookmark>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.route.RouteBookmarkManager
    public RouteBookmark createRouteBookmark(RouteBookmark routeBookmark) throws UaException {
        return create(routeBookmark);
    }

    @Override // com.ua.sdk.route.RouteBookmarkManager
    public Request createRouteBookmark(RouteBookmark routeBookmark, CreateCallback<RouteBookmark> createCallback) {
        return create(routeBookmark, createCallback);
    }

    @Override // com.ua.sdk.route.RouteBookmarkManager
    public void deleteRouteBookmark(EntityRef<RouteBookmark> entityRef) throws UaException {
        delete(entityRef);
    }

    @Override // com.ua.sdk.route.RouteBookmarkManager
    public Request deleteRouteBookmark(EntityRef<RouteBookmark> entityRef, DeleteCallback<EntityRef<RouteBookmark>> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
