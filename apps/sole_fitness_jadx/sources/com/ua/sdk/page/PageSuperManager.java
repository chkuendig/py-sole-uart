package com.ua.sdk.page;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.page.association.PageAssociation;
import com.ua.sdk.page.association.PageAssociationRef;
import com.ua.sdk.page.follow.PageFollow;
import com.ua.sdk.page.follow.PageFollowManager;
import com.ua.sdk.user.User;
import java.util.List;

/* loaded from: classes2.dex */
public class PageSuperManager implements PageManager {
    private final PageFollowManager pageFollowManager;
    private final PageManagerImpl pageManager;

    @Override // com.ua.sdk.page.PageManager
    public EntityList<PageAssociation> fetchPageAssociation(PageAssociationRef pageAssociationRef) throws UaException {
        return null;
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchPageAssociation(PageAssociationRef pageAssociationRef, FetchCallback<EntityList<PageAssociation>> fetchCallback) {
        return null;
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchPageType(EntityRef<PageType> entityRef, FetchCallback<PageType> fetchCallback) {
        return null;
    }

    @Override // com.ua.sdk.page.PageManager
    public PageType fetchPageType(EntityRef<PageType> entityRef) throws UaException {
        return null;
    }

    @Override // com.ua.sdk.page.PageManager
    public EntityList<PageType> fetchPageTypeList() throws UaException {
        return null;
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchPageTypeList(FetchCallback<EntityList<PageType>> fetchCallback) {
        return null;
    }

    public PageSuperManager(PageManagerImpl pageManagerImpl, PageFollowManager pageFollowManager) {
        this.pageManager = pageManagerImpl;
        this.pageFollowManager = pageFollowManager;
    }

    @Override // com.ua.sdk.page.PageManager
    public Page fetchPage(EntityRef<Page> entityRef) throws UaException {
        return this.pageManager.fetchPage(entityRef);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchPage(EntityRef<Page> entityRef, FetchCallback<Page> fetchCallback) {
        return this.pageManager.fetchPage(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.page.PageManager
    public EntityList<PageFollow> fetchPageFollowList(EntityListRef<PageFollow> entityListRef) throws UaException {
        return this.pageFollowManager.fetchPageFollowList(entityListRef);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchPageFollowList(EntityListRef<PageFollow> entityListRef, FetchCallback<EntityList<PageFollow>> fetchCallback) {
        return this.pageFollowManager.fetchPageFollowList(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.page.PageManager
    public EntityList<PageFollow> fetchIsFollowingPage(EntityRef<User> entityRef, EntityRef<Page> entityRef2) throws UaException {
        return this.pageFollowManager.fetchIsFollowingPage(entityRef, entityRef2);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchIsFollowingPage(EntityRef<User> entityRef, EntityRef<Page> entityRef2, FetchCallback<EntityList<PageFollow>> fetchCallback) {
        return this.pageFollowManager.fetchIsFollowingPage(entityRef, entityRef2, fetchCallback);
    }

    @Override // com.ua.sdk.page.PageManager
    public void deletePageFollow(EntityRef<PageFollow> entityRef) throws UaException {
        this.pageFollowManager.deletePageFollow(entityRef);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request deletePageFollow(EntityRef<PageFollow> entityRef, DeleteCallback<Reference> deleteCallback) {
        return this.pageFollowManager.deletePageFollow(entityRef, deleteCallback);
    }

    @Override // com.ua.sdk.page.PageManager
    public PageFollow createPageFollow(EntityRef<Page> entityRef, EntityRef<User> entityRef2) throws UaException {
        return this.pageFollowManager.createPageFollow(entityRef, entityRef2);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request createPageFollow(EntityRef<Page> entityRef, EntityRef<User> entityRef2, CreateCallback<PageFollow> createCallback) {
        return this.pageFollowManager.createPageFollow(entityRef, entityRef2, createCallback);
    }

    @Override // com.ua.sdk.page.PageManager
    public EntityList<PageFollow> createPageFollows(List<EntityRef<Page>> list, EntityRef<User> entityRef) throws UaException {
        return this.pageFollowManager.createPageFollows(list, entityRef);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request createPageFollows(List<EntityRef<Page>> list, EntityRef<User> entityRef, CreateCallback<EntityList<PageFollow>> createCallback) {
        return this.pageFollowManager.createPageFollows(list, entityRef, createCallback);
    }

    @Override // com.ua.sdk.page.PageManager
    public EntityList<Page> fetchPageList(EntityListRef<Page> entityListRef) throws UaException {
        return this.pageManager.fetchPageList(entityListRef);
    }

    @Override // com.ua.sdk.page.PageManager
    public Request fetchPageList(EntityListRef<Page> entityListRef, FetchCallback<EntityList<Page>> fetchCallback) {
        return this.pageManager.fetchPageList(entityListRef, fetchCallback);
    }
}
