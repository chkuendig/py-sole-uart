package com.ua.sdk.bodymass;

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
public class BodyMassManagerImpl extends AbstractManager<BodyMass> implements BodyMassManager {
    public BodyMassManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<BodyMass> diskCache, EntityService<BodyMass> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.bodymass.BodyMassManager
    public EntityList<BodyMass> fetchBodyMassList(EntityListRef<BodyMass> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.bodymass.BodyMassManager
    public Request fetchBodyMassList(EntityListRef<BodyMass> entityListRef, FetchCallback<EntityList<BodyMass>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }

    @Override // com.ua.sdk.bodymass.BodyMassManager
    public BodyMass fetchBodyMass(EntityRef<BodyMass> entityRef) throws UaException {
        return fetch(entityRef);
    }

    @Override // com.ua.sdk.bodymass.BodyMassManager
    public Request fetchBodyMass(EntityRef<BodyMass> entityRef, FetchCallback<BodyMass> fetchCallback) {
        return fetch(entityRef, fetchCallback);
    }

    @Override // com.ua.sdk.bodymass.BodyMassManager
    public BodyMass updateBodyMass(BodyMass bodyMass) throws UaException {
        return update(bodyMass);
    }

    @Override // com.ua.sdk.bodymass.BodyMassManager
    public Request updateBodyMass(BodyMass bodyMass, SaveCallback<BodyMass> saveCallback) {
        return update(bodyMass, saveCallback);
    }
}
