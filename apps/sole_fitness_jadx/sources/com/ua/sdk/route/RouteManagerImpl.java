package com.ua.sdk.route;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Link;
import com.ua.sdk.route.bookmark.RouteBookmarkImpl;
import com.ua.sdk.user.User;
import com.ua.sdk.user.UserManager;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class RouteManagerImpl extends AbstractManager<Route> implements RouteManager {
    private final RouteBookmarkManager routeBookmarkManager;
    private final UserManager userManager;

    public RouteManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Route> diskCache, EntityService<Route> entityService, ExecutorService executorService, RouteBookmarkManager routeBookmarkManager, UserManager userManager) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.routeBookmarkManager = routeBookmarkManager;
        this.userManager = userManager;
    }

    @Override // com.ua.sdk.route.RouteManager
    public RouteBuilder getRouteBuilder() {
        return new RouteBuilderImpl();
    }

    @Override // com.ua.sdk.route.RouteManager
    public Route fetchRoute(RouteRef routeRef) throws UaException {
        return fetch(routeRef);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request fetchRoute(RouteRef routeRef, FetchCallback<Route> fetchCallback) {
        return fetch(routeRef, fetchCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public void createRoute(Route route) throws UaException {
        create(route);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request createRoute(Route route, CreateCallback<Route> createCallback) {
        return create(route, createCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public EntityList<Route> fetchRouteList(EntityListRef<Route> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request fetchRouteList(EntityListRef<Route> entityListRef, FetchCallback<EntityList<Route>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public void updateRoute(Route route) throws UaException {
        update(route);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request updateRoute(Route route, SaveCallback<Route> saveCallback) {
        return update(route, saveCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public void deleteRoute(RouteRef routeRef) throws UaException {
        delete(routeRef);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request deleteRoute(RouteRef routeRef, DeleteCallback<RouteRef> deleteCallback) {
        return delete(routeRef, deleteCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public EntityList<RouteBookmark> fetchRouteBookmarkList(EntityListRef<RouteBookmark> entityListRef) throws UaException {
        return this.routeBookmarkManager.fetchRouteBookmarkList(entityListRef);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request fetchRouteBookmarkList(EntityListRef<RouteBookmark> entityListRef, FetchCallback<EntityList<RouteBookmark>> fetchCallback) {
        return this.routeBookmarkManager.fetchRouteBookmarkList(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public EntityList<Route> fetchBookmarkedRoutes(EntityListRef<RouteBookmark> entityListRef) throws UaException {
        EntityList<RouteBookmark> entityListFetchRouteBookmarkList = this.routeBookmarkManager.fetchRouteBookmarkList(entityListRef);
        RouteList routeList = new RouteList();
        Iterator<RouteBookmark> it = entityListFetchRouteBookmarkList.getAll().iterator();
        while (it.hasNext()) {
            routeList.add(fetchRoute(RouteRef.getBuilder().setId(it.next().getRoute().getId()).build()));
        }
        return routeList;
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request fetchBookmarkedRoutes(final EntityListRef<RouteBookmark> entityListRef, FetchCallback<EntityList<Route>> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.route.RouteManagerImpl.1
            @Override // java.lang.Runnable
            public void run() throws UaException {
                UaException uaException;
                EntityList<Route> entityListFetchBookmarkedRoutes = null;
                try {
                    entityListFetchBookmarkedRoutes = RouteManagerImpl.this.fetchBookmarkedRoutes(entityListRef);
                    uaException = null;
                } catch (UaException e) {
                    UaLog.error("Failed to fetch routes");
                    uaException = e;
                } catch (Throwable th) {
                    UaLog.error("Failed to fetch routes");
                    uaException = new UaException(th);
                }
                fetchRequest.done(entityListFetchBookmarkedRoutes, uaException);
            }
        }));
        return fetchRequest;
    }

    @Override // com.ua.sdk.route.RouteManager
    public RouteBookmark createRouteBookmark(Route route) throws UaException {
        return this.routeBookmarkManager.createRouteBookmark(buildRouteBookmark(route));
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request createRouteBookmark(Route route, CreateCallback<RouteBookmark> createCallback) {
        return this.routeBookmarkManager.createRouteBookmark(buildRouteBookmark(route), createCallback);
    }

    @Override // com.ua.sdk.route.RouteManager
    public void deleteRouteBookmark(EntityRef<RouteBookmark> entityRef) throws UaException {
        this.routeBookmarkManager.deleteRouteBookmark(entityRef);
    }

    @Override // com.ua.sdk.route.RouteManager
    public Request deleteRouteBookmark(EntityRef<RouteBookmark> entityRef, DeleteCallback<EntityRef<RouteBookmark>> deleteCallback) {
        return this.routeBookmarkManager.deleteRouteBookmark(entityRef, deleteCallback);
    }

    private RouteBookmark buildRouteBookmark(Route route) {
        RouteBookmarkImpl routeBookmarkImpl = new RouteBookmarkImpl();
        EntityRef<User> currentUserRef = this.userManager.getCurrentUserRef();
        RouteRef routeRefBuild = RouteRef.getBuilder().setId(route.getRef().getId()).build();
        routeBookmarkImpl.setRoute(new Link(routeRefBuild.getHref(), routeRefBuild.getId()));
        routeBookmarkImpl.setUser(new Link(currentUserRef.getHref(), currentUserRef.getId()));
        return routeBookmarkImpl;
    }
}
