package com.ua.sdk.actigraphy;

import com.ua.sdk.EntityList;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.Precondition;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ActigraphyManagerImpl extends AbstractManager<Actigraphy> implements ActigraphyManager {
    private ActigraphyService actigraphyService;

    public ActigraphyManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<Actigraphy> diskCache, ActigraphyService actigraphyService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, actigraphyService, executorService);
        this.actigraphyService = (ActigraphyService) Precondition.isNotNull(actigraphyService);
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyManager
    public EntityList<Actigraphy> fetchActigraphy(ActigraphyListRef actigraphyListRef) throws UaException {
        return this.actigraphyService.fetchPage(actigraphyListRef);
    }

    @Override // com.ua.sdk.actigraphy.ActigraphyManager
    public Request fetchActigraphy(final ActigraphyListRef actigraphyListRef, FetchCallback<EntityList<Actigraphy>> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.actigraphy.ActigraphyManagerImpl.1
            @Override // java.lang.Runnable
            public void run() throws UaException {
                UaException uaException;
                EntityList<Actigraphy> entityListFetchActigraphy = null;
                try {
                    entityListFetchActigraphy = ActigraphyManagerImpl.this.fetchActigraphy(actigraphyListRef);
                    uaException = null;
                } catch (UaException e) {
                    UaLog.error("Failed to fetch actigraphy");
                    uaException = e;
                } catch (Throwable th) {
                    UaLog.error("Failed to fetch actigraphy");
                    uaException = new UaException(th);
                }
                fetchRequest.done(entityListFetchActigraphy, uaException);
            }
        }));
        return fetchRequest;
    }
}
