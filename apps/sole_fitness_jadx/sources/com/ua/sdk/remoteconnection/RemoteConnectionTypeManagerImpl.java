package com.ua.sdk.remoteconnection;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.actigraphysettings.ActigraphySettings;
import com.ua.sdk.actigraphysettings.ActigraphySettingsManager;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class RemoteConnectionTypeManagerImpl extends AbstractManager<RemoteConnectionType> implements RemoteConnectionTypeManager {
    private ActigraphySettingsManager actigraphySettingsManager;
    private RemoteConnectionTypePageImpl mRemoteConnectionTypePage;

    public RemoteConnectionTypeManagerImpl(ActigraphySettingsManager actigraphySettingsManager, CacheSettings cacheSettings, Cache cache, DiskCache<RemoteConnectionType> diskCache, EntityService<RemoteConnectionType> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.actigraphySettingsManager = actigraphySettingsManager;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public EntityList<RemoteConnectionType> fetchRemoteConnectionTypeList() throws UaException {
        return fetchPage(null);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request fetchRemoteConnectionTypeList(FetchCallback<EntityList<RemoteConnectionType>> fetchCallback) {
        return fetchPage((EntityListRef) null, fetchCallback);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public RemoteConnectionType fetchRemoteConnectionType(EntityRef<RemoteConnectionType> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request fetchRemoteConnectionType(EntityRef<RemoteConnectionType> entityRef, FetchCallback<RemoteConnectionType> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public ActigraphySettings fetchRemoteConnectionPriorities() throws UaException {
        return this.actigraphySettingsManager.fetchActigraphySettings();
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request fetchRemoteConnectionPriorities(FetchCallback<ActigraphySettings> fetchCallback) {
        return this.actigraphySettingsManager.fetchActigraphySettings(fetchCallback);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public void updateSleepConnectionPriorities(EntityRef<RemoteConnectionType> entityRef) throws UaException {
        this.actigraphySettingsManager.setSleepRecorderPriority(entityRef);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request updateSleepConnectionPriorities(EntityRef<RemoteConnectionType> entityRef, CreateCallback<ActigraphySettings> createCallback) {
        return this.actigraphySettingsManager.setSleepRecorderPriority(entityRef, createCallback);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public void updateActivityConnectionPriorities(EntityRef<RemoteConnectionType> entityRef) throws UaException {
        this.actigraphySettingsManager.setActivityRecorderPriority(entityRef);
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request updateActivityConnectionPriorities(EntityRef<RemoteConnectionType> entityRef, CreateCallback<ActigraphySettings> createCallback) {
        return this.actigraphySettingsManager.setActivityRecorderPriority(entityRef, createCallback);
    }
}
