package com.ua.sdk.remoteconnection;

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
public class RemoteConnectionManagerImpl extends AbstractManager<RemoteConnection> implements RemoteConnectionManager {
    public RemoteConnectionManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<RemoteConnection> diskCache, EntityService<RemoteConnection> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public EntityList<RemoteConnection> fetchRemoteConnectionList() throws UaException {
        return fetchPage(null);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public Request fetchRemoteConnectionList(FetchCallback<EntityList<RemoteConnection>> fetchCallback) {
        return fetchPage((EntityListRef) null, fetchCallback);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public RemoteConnection fetchRemoteConnection(EntityRef<RemoteConnection> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public Request fetchRemoteConnection(EntityRef<RemoteConnection> entityRef, FetchCallback<RemoteConnection> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public void deleteRemoteConnection(EntityRef<RemoteConnection> entityRef) throws UaException {
        delete(entityRef);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionManager
    public Request deleteRemoteConnection(EntityRef<RemoteConnection> entityRef, DeleteCallback<RemoteConnectionRef> deleteCallback) {
        return delete(entityRef, deleteCallback);
    }
}
