package com.ua.sdk.group.user;

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
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class GroupUserManagerImpl extends AbstractManager<GroupUser> implements GroupUserManager {
    public GroupUserManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<GroupUser> diskCache, EntityService<GroupUser> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.group.user.GroupUserManager
    public EntityList<GroupUser> fetchGroupUserList(EntityListRef<GroupUser> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.group.user.GroupUserManager
    public Request fetchGroupUserList(EntityListRef<GroupUser> entityListRef, FetchCallback<EntityList<GroupUser>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.group.user.GroupUserManager
    public GroupUser createGroupUser(GroupUser groupUser) throws UaException {
        return create(groupUser);
    }

    @Override // com.ua.sdk.group.user.GroupUserManager
    public Request createGroupUser(GroupUser groupUser, CreateCallback<GroupUser> createCallback) {
        return create(groupUser, createCallback);
    }

    @Override // com.ua.sdk.group.user.GroupUserManager
    public EntityRef<GroupUser> deleteGroupUser(EntityRef<GroupUser> entityRef) throws UaException {
        return (EntityRef) delete(entityRef);
    }

    @Override // com.ua.sdk.group.user.GroupUserManager
    public Request deleteGroupUser(EntityRef<GroupUser> entityRef, DeleteCallback<EntityRef<GroupUser>> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
