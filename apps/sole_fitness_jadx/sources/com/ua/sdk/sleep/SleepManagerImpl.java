package com.ua.sdk.sleep;

import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
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
public class SleepManagerImpl extends AbstractManager<SleepMetric> implements SleepManager {
    public SleepManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<SleepMetric> diskCache, EntityService<SleepMetric> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public SleepMetricBuilder getSleepMetricBuilder() {
        return new SleepMetricBuilderImpl();
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public SleepMetric fetchSleep(SleepRef sleepRef) throws UaException {
        return fetch(sleepRef);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public Request fetchSleep(SleepRef sleepRef, FetchCallback<SleepMetric> fetchCallback) {
        return fetch(sleepRef, fetchCallback);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public EntityList<SleepMetric> fetchSleepList(SleepListRef sleepListRef) throws UaException {
        return fetchPage(sleepListRef);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public Request fetchSleepList(SleepListRef sleepListRef, FetchCallback<EntityList<SleepMetric>> fetchCallback) {
        return fetchPage(sleepListRef, fetchCallback);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public SleepMetric updateSleep(SleepMetric sleepMetric) throws UaException {
        return update(sleepMetric);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public Request updateSleep(SleepMetric sleepMetric, SaveCallback<SleepMetric> saveCallback) {
        return update(sleepMetric, saveCallback);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public SleepRef deleteSleep(SleepRef sleepRef) throws UaException {
        return (SleepRef) delete(sleepRef);
    }

    @Override // com.ua.sdk.sleep.SleepManager
    public Request deleteSleep(SleepRef sleepRef, DeleteCallback<SleepRef> deleteCallback) {
        return delete(sleepRef, deleteCallback);
    }
}
