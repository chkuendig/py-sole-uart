package com.ua.sdk.actigraphysettings;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import com.ua.sdk.remoteconnection.RemoteConnectionType;
import com.ua.sdk.remoteconnection.RemoteConnectionTypeManager;
import com.ua.sdk.remoteconnection.RemoteConnectionTypeRef;
import com.ua.sdk.user.UserManager;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ActigraphySettingsManagerImpl extends AbstractManager<ActigraphySettings> implements ActigraphySettingsManager {
    private RemoteConnectionTypeManager remoteConnectionTypeManager;
    private UserManager userManager;

    public ActigraphySettingsManagerImpl(UserManager userManager, CacheSettings cacheSettings, Cache cache, DiskCache<ActigraphySettings> diskCache, EntityService<ActigraphySettings> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
        this.userManager = userManager;
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public void setRemoteConnectionTypeManager(RemoteConnectionTypeManager remoteConnectionTypeManager) {
        this.remoteConnectionTypeManager = remoteConnectionTypeManager;
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public ActigraphySettings fetchActigraphySettings() throws UaException {
        return fetch(this.userManager.getCurrentUserRef());
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public Request fetchActigraphySettings(FetchCallback<ActigraphySettings> fetchCallback) {
        return fetch(this.userManager.getCurrentUserRef(), fetchCallback);
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public ActigraphySettings setSleepRecorderPriority(EntityRef<RemoteConnectionType> entityRef) throws UaException {
        if (entityRef instanceof RemoteConnectionTypeRef) {
            RemoteConnectionTypeRef remoteConnectionTypeRef = (RemoteConnectionTypeRef) entityRef;
            if (remoteConnectionTypeRef.getRecorderTypeKey() != null && !remoteConnectionTypeRef.getRecorderTypeKey().equals("")) {
                return create(buildPrioritySetting("sleep", remoteConnectionTypeRef));
            }
        }
        return create(buildPrioritySetting("sleep", this.remoteConnectionTypeManager.fetchRemoteConnectionType(entityRef)));
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public Request setSleepRecorderPriority(final EntityRef<RemoteConnectionType> entityRef, CreateCallback<ActigraphySettings> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.actigraphysettings.ActigraphySettingsManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActigraphySettingsManagerImpl.this.setSleepRecorderPriority(entityRef), null);
                } catch (UaException unused) {
                    UaLog.error("Failed to set sleep priority");
                }
            }
        }));
        return createRequest;
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public ActigraphySettings setActivityRecorderPriority(EntityRef<RemoteConnectionType> entityRef) throws UaException {
        if (entityRef instanceof RemoteConnectionTypeRef) {
            RemoteConnectionTypeRef remoteConnectionTypeRef = (RemoteConnectionTypeRef) entityRef;
            if (remoteConnectionTypeRef.getRecorderTypeKey() != null && !remoteConnectionTypeRef.getRecorderTypeKey().equals("")) {
                return create(buildPrioritySetting("activity", remoteConnectionTypeRef));
            }
        }
        return create(buildPrioritySetting("activity", this.remoteConnectionTypeManager.fetchRemoteConnectionType(entityRef)));
    }

    @Override // com.ua.sdk.actigraphysettings.ActigraphySettingsManager
    public Request setActivityRecorderPriority(final EntityRef<RemoteConnectionType> entityRef, CreateCallback<ActigraphySettings> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.actigraphysettings.ActigraphySettingsManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(ActigraphySettingsManagerImpl.this.setActivityRecorderPriority(entityRef), null);
                } catch (UaException unused) {
                    UaLog.error("Failed to set activity priority");
                }
            }
        }));
        return createRequest;
    }

    private ActigraphySettings buildPrioritySetting(String str, RemoteConnectionType remoteConnectionType) {
        ActigraphySettingsImpl actigraphySettingsImpl = new ActigraphySettingsImpl();
        ArrayList arrayList = new ArrayList();
        if (str.equals("sleep")) {
            arrayList.add(remoteConnectionType.getRecorderTypeKey());
            actigraphySettingsImpl.setSleepPriority(arrayList);
        } else {
            arrayList.add(remoteConnectionType.getRecorderTypeKey());
            actigraphySettingsImpl.setActivityPriority(arrayList);
        }
        return actigraphySettingsImpl;
    }

    private ActigraphySettings buildPrioritySetting(String str, RemoteConnectionTypeRef remoteConnectionTypeRef) {
        ActigraphySettingsImpl actigraphySettingsImpl = new ActigraphySettingsImpl();
        ArrayList arrayList = new ArrayList();
        if (str.equals("sleep")) {
            arrayList.add(remoteConnectionTypeRef.getRecorderTypeKey());
            actigraphySettingsImpl.setSleepPriority(arrayList);
        } else {
            arrayList.add(remoteConnectionTypeRef.getRecorderTypeKey());
            actigraphySettingsImpl.setActivityPriority(arrayList);
        }
        return actigraphySettingsImpl;
    }
}
