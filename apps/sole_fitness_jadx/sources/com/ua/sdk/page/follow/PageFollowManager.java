package com.ua.sdk.page.follow;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.page.Page;
import com.ua.sdk.user.User;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class PageFollowManager extends AbstractManager<PageFollow> {
    public PageFollowManager(CacheSettings cacheSettings, Cache cache, DiskCache<PageFollow> diskCache, EntityService<PageFollow> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    public EntityList<PageFollow> fetchPageFollowList(EntityListRef<PageFollow> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    public Request fetchPageFollowList(EntityListRef<PageFollow> entityListRef, FetchCallback<EntityList<PageFollow>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    public EntityList<PageFollow> fetchIsFollowingPage(EntityRef<User> entityRef, EntityRef<Page> entityRef2) throws UaException {
        return fetchPage(PageFollowRef.getBuilder().setUserId(entityRef.getId()).setPageId(entityRef2.getId()).build());
    }

    public Request fetchIsFollowingPage(EntityRef<User> entityRef, EntityRef<Page> entityRef2, FetchCallback<EntityList<PageFollow>> fetchCallback) {
        return fetchPage(PageFollowRef.getBuilder().setUserId(entityRef.getId()).setPageId(entityRef2.getId()).build(), fetchCallback);
    }

    public void deletePageFollow(EntityRef<PageFollow> entityRef) throws UaException {
        delete(entityRef);
    }

    public Request deletePageFollow(EntityRef<PageFollow> entityRef, DeleteCallback<Reference> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }

    public PageFollow createPageFollow(EntityRef<Page> entityRef, EntityRef<User> entityRef2) throws UaException {
        PageFollowImpl pageFollowImpl = new PageFollowImpl();
        pageFollowImpl.setPageRef(entityRef);
        pageFollowImpl.setUserRef(entityRef2);
        return create(pageFollowImpl);
    }

    public Request createPageFollow(EntityRef<Page> entityRef, EntityRef<User> entityRef2, CreateCallback<PageFollow> createCallback) {
        PageFollowImpl pageFollowImpl = new PageFollowImpl();
        pageFollowImpl.setPageRef(entityRef);
        pageFollowImpl.setUserRef(entityRef2);
        return create(pageFollowImpl, createCallback);
    }

    public EntityList<PageFollow> createPageFollows(List<EntityRef<Page>> list, EntityRef<User> entityRef) throws UaException, NullPointerException {
        Precondition.isNotNull(list);
        Precondition.isNotNull(entityRef);
        PageFollowImpl pageFollowImpl = new PageFollowImpl();
        for (EntityRef<Page> entityRef2 : list) {
            PageFollowImpl pageFollowImpl2 = new PageFollowImpl();
            pageFollowImpl2.setPageRef(entityRef2);
            pageFollowImpl2.setUserRef(entityRef);
            pageFollowImpl.addPageFollow(pageFollowImpl2);
        }
        return ((PageFollowService) this.service).patch(pageFollowImpl);
    }

    public Request createPageFollows(final List<EntityRef<Page>> list, final EntityRef<User> entityRef, CreateCallback<EntityList<PageFollow>> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.page.follow.PageFollowManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(PageFollowManager.this.createPageFollows(list, entityRef), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }
}
