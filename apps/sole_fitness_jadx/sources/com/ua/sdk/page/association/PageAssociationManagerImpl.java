package com.ua.sdk.page.association;

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
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.page.Page;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class PageAssociationManagerImpl extends AbstractManager<PageAssociation> implements PageAssociationManager {
    @Override // com.ua.sdk.page.association.PageAssociationManager
    public Request createPageAssociation(EntityRef<Page> entityRef, EntityRef<Page> entityRef2, CreateCallback<Page> createCallback) {
        return null;
    }

    public PageAssociationManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<PageAssociation> diskCache, EntityService<PageAssociation> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.page.association.PageAssociationManager
    public EntityList<PageAssociation> fetchPageAssociationList(EntityListRef<PageAssociation> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.page.association.PageAssociationManager
    public Request fetchPageAssociationList(EntityListRef<PageAssociation> entityListRef, FetchCallback<EntityList<PageAssociation>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.page.association.PageAssociationManager
    public PageAssociation fetchPageAssociation(EntityRef<PageAssociation> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.page.association.PageAssociationManager
    public Request fetchPageAssociation(EntityRef<PageAssociation> entityRef, FetchCallback<PageAssociation> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.page.association.PageAssociationManager
    public PageAssociation createPageAssociation(EntityRef<Page> entityRef, EntityRef<Page> entityRef2) throws UaException {
        return (PageAssociation) this.service.create(buildPageAssociation(entityRef, entityRef2));
    }

    private PageAssociation buildPageAssociation(EntityRef<Page> entityRef, EntityRef<Page> entityRef2) {
        PageAssociationImpl pageAssociationImpl = new PageAssociationImpl();
        pageAssociationImpl.setLink("from_page", new Link(((LinkEntityRef) entityRef).getHref(), entityRef.getId()));
        pageAssociationImpl.setLink("to_page", new Link(((LinkEntityRef) entityRef2).getHref(), entityRef2.getId()));
        return pageAssociationImpl;
    }
}
