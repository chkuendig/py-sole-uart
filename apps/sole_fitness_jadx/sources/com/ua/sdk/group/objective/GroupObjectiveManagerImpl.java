package com.ua.sdk.group.objective;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class GroupObjectiveManagerImpl extends AbstractManager<GroupObjective> implements GroupObjectiveManager {
    public GroupObjectiveManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<GroupObjective> diskCache, EntityService<GroupObjective> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public EntityList<GroupObjective> fetchGroupObjectiveList(EntityListRef<GroupObjective> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public Request fetchGroupObjectiveList(EntityListRef<GroupObjective> entityListRef, FetchCallback<EntityList<GroupObjective>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public GroupObjective fetchGroupObjective(EntityRef<GroupObjective> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public Request fetchGroupObjective(EntityRef<GroupObjective> entityRef, FetchCallback<GroupObjective> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public GroupObjective createGroupObjective(GroupObjective groupObjective) throws UaException {
        return create(groupObjective);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public Request createGroupObjective(GroupObjective groupObjective, CreateCallback<GroupObjective> createCallback) {
        return create(groupObjective, createCallback);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public GroupObjective updateGroupObjective(GroupObjective groupObjective) throws UaException {
        return update(groupObjective);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public Request updateGroupObjective(GroupObjective groupObjective, SaveCallback<GroupObjective> saveCallback) {
        return update(groupObjective, saveCallback);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public EntityRef<GroupObjective> deleteGroupObjective(EntityRef<GroupObjective> entityRef) throws UaException {
        return (EntityRef) delete(entityRef);
    }

    @Override // com.ua.sdk.group.objective.GroupObjectiveManager
    public Request deleteGroupObjective(EntityRef<GroupObjective> entityRef, DeleteCallback<EntityRef<GroupObjective>> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
