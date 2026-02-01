package com.ua.sdk.group.invite;

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
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class GroupInviteManagerImpl extends AbstractManager<GroupInvite> implements GroupInviteManager {
    public GroupInviteManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<GroupInvite> diskCache, EntityService<GroupInvite> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public EntityList<GroupInvite> fetchGroupInviteList(EntityListRef<GroupInvite> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public Request fetchGroupInviteList(EntityListRef<GroupInvite> entityListRef, FetchCallback<EntityList<GroupInvite>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public GroupInvite createGroupInvite(GroupInvite groupInvite) throws UaException {
        return create(groupInvite);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public Request createGroupInvite(GroupInvite groupInvite, CreateCallback<GroupInvite> createCallback) {
        return create(groupInvite, createCallback);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public EntityList<GroupInvite> patchGroupInvite(GroupInvite groupInvite) throws UaException {
        return ((GroupInviteService) this.service).patch(groupInvite);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public Request patchGroupInvite(final GroupInvite groupInvite, CreateCallback<EntityList<GroupInvite>> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.group.invite.GroupInviteManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(GroupInviteManagerImpl.this.patchGroupInvite(groupInvite), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public EntityRef<GroupInvite> deleteGroupInvite(EntityRef<GroupInvite> entityRef) throws UaException {
        return (EntityRef) delete(entityRef);
    }

    @Override // com.ua.sdk.group.invite.GroupInviteManager
    public Request deleteGroupInvite(EntityRef<GroupInvite> entityRef, DeleteCallback<EntityRef<GroupInvite>> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
