package com.ua.sdk.role;

import com.ua.sdk.EntityList;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.role.Role;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class RoleManagerImpl extends AbstractManager<Role> implements RoleManager {
    public RoleManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Role> diskCache, EntityService<Role> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.role.RoleManager
    public Role fetchRole(Role.Type type) {
        return RoleHelper.getRole(type);
    }

    @Override // com.ua.sdk.role.RoleManager
    public EntityList<Role> fetchRoleList() throws UaException {
        return this.service.fetchPage(null);
    }

    @Override // com.ua.sdk.role.RoleManager
    public Request fetchRoleList(FetchCallback<EntityList<Role>> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.role.RoleManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fetchRequest.done(RoleManagerImpl.this.fetchRoleList(), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }
}
