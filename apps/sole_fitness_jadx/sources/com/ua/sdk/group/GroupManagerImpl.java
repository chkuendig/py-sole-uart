package com.ua.sdk.group;

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
import com.ua.sdk.concurrent.SaveRequest;
import com.ua.sdk.group.objective.GroupObjectiveImpl;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.internal.Precondition;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class GroupManagerImpl extends AbstractManager<Group> implements GroupManager {
    public GroupManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Group> diskCache, EntityService<Group> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.group.GroupManager
    public EntityList<Group> fetchGroupList(EntityListRef<Group> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request fetchGroupList(EntityListRef<Group> entityListRef, FetchCallback<EntityList<Group>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Group fetchGroup(EntityRef<Group> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request fetchGroup(EntityRef<Group> entityRef, FetchCallback<Group> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Group createGroup(Group group) throws UaException {
        return create(group);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request createGroup(Group group, CreateCallback<Group> createCallback) {
        return create(group, createCallback);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Group updateGroup(Group group, EntityRef<Group> entityRef) throws UaException {
        return patch(group, entityRef);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request updateGroup(Group group, EntityRef<Group> entityRef, CreateCallback<Group> createCallback) {
        return patch(group, entityRef, createCallback);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Group endGroupChallenge(Group group) throws UaException, NullPointerException {
        Precondition.isNotNull(group);
        Precondition.isNotNull((GroupObjectiveImpl) group.getGroupObjective());
        ((GroupObjectiveImpl) group.getGroupObjective()).setEndDate(new Date());
        return update(group);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request endGroupChallenge(final Group group, SaveCallback<Group> saveCallback) {
        final SaveRequest saveRequest = new SaveRequest(saveCallback);
        saveRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.group.GroupManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    saveRequest.done(GroupManagerImpl.this.endGroupChallenge(group), null);
                } catch (UaException e) {
                    saveRequest.done(null, e);
                }
            }
        }));
        return saveRequest;
    }

    @Override // com.ua.sdk.group.GroupManager
    public Group endGroupChallenge(EntityRef<Group> entityRef) throws UaException, NullPointerException {
        Precondition.isNotNull(entityRef);
        return endGroupChallenge(fetchGroup(entityRef));
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request endGroupChallenge(final EntityRef<Group> entityRef, SaveCallback<Group> saveCallback) {
        final SaveRequest saveRequest = new SaveRequest(saveCallback);
        saveRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.group.GroupManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    saveRequest.done(GroupManagerImpl.this.endGroupChallenge(entityRef), null);
                } catch (UaException e) {
                    saveRequest.done(null, e);
                }
            }
        }));
        return saveRequest;
    }

    @Override // com.ua.sdk.group.GroupManager
    public void deleteGroup(EntityRef<Group> entityRef) throws UaException {
        delete(entityRef);
    }

    @Override // com.ua.sdk.group.GroupManager
    public Request deleteGroup(EntityRef<Group> entityRef, DeleteCallback<EntityRef<Group>> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
