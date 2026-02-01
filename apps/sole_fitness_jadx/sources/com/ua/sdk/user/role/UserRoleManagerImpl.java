package com.ua.sdk.user.role;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class UserRoleManagerImpl extends AbstractManager<UserRole> implements UserRoleManager {
    public UserRoleManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<UserRole> diskCache, EntityService<UserRole> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public UserRole fetchUserRole(EntityRef entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public Request fetchUserRole(final EntityRef entityRef, FetchCallback<UserRole> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.user.role.UserRoleManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fetchRequest.done(UserRoleManagerImpl.this.fetchUserRole(entityRef), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public UserRole createUserRole(UserRole userRole) throws UaException {
        return create(userRole);
    }

    @Override // com.ua.sdk.user.role.UserRoleManager
    public Request createUserRole(final UserRole userRole, CreateCallback<UserRole> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.user.role.UserRoleManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(UserRoleManagerImpl.this.createUserRole(userRole), null);
                } catch (UaException e) {
                    createRequest.done(null, e);
                }
            }
        }));
        return createRequest;
    }
}
