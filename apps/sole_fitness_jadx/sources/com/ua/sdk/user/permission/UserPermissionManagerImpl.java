package com.ua.sdk.user.permission;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.internal.AbstractManager;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UserPermissionManagerImpl extends AbstractManager<UserPermission> implements UserPermissionManager {
    private final UserPermissionService service;

    public UserPermissionManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<UserPermission> diskCache, UserPermissionService userPermissionService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, null, executorService);
        this.service = userPermissionService;
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public EntityList<UserPermission> fetchUserPermission(EntityRef entityRef) throws UaException {
        return this.service.fetchUserPermission(entityRef);
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public Request fetchUserPermission(final EntityRef entityRef, FetchCallback<EntityList<UserPermission>> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.user.permission.UserPermissionManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fetchRequest.done(UserPermissionManagerImpl.this.fetchUserPermission(entityRef), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public EntityList<UserPermission> fetchUserPermissionList() throws UaException {
        return this.service.fetchUserPermissions();
    }

    @Override // com.ua.sdk.user.permission.UserPermissionManager
    public Request fetchUserPermissionList(FetchCallback<EntityList<UserPermission>> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.user.permission.UserPermissionManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fetchRequest.done(UserPermissionManagerImpl.this.fetchUserPermissionList(), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }
}
