package com.ua.sdk.activitytype;

import android.database.SQLException;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.internal.AbstractManager;
import com.ua.sdk.internal.EntityService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class ActivityTypeManagerImpl extends AbstractManager<ActivityType> implements ActivityTypeManager {
    private final ActivityTypeDatabase activityTypeCache;

    public ActivityTypeManagerImpl(CacheSettings cacheSettings, Cache cache, ActivityTypeDatabase activityTypeDatabase, EntityService<ActivityType> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, activityTypeDatabase, entityService, executorService);
        this.activityTypeCache = activityTypeDatabase;
    }

    @Override // com.ua.sdk.activitytype.ActivityTypeManager
    public EntityList<ActivityType> fetchActivityTypeList() throws SQLException, UaException {
        ArrayList arrayList = new ArrayList();
        if (this.activityTypeCache.isAllActivityTypeCacheSet() && this.activityTypeCache.getCacheAge() < this.cacheSettings.getMaxCacheAge()) {
            return new AllActivityTypesList(this.activityTypeCache.getAllActivityTypes());
        }
        ActivityTypeListRef ref = getRef();
        EntityList<ActivityType> entityListFetchPage = fetchPage(ref);
        Iterator<ActivityType> it = entityListFetchPage.getAll().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.diskCache.updateAfterFetch(ref, entityListFetchPage, false);
        while (entityListFetchPage.hasNext()) {
            EntityListRef<ActivityType> nextPage = entityListFetchPage.getNextPage();
            entityListFetchPage = fetchPage(nextPage);
            Iterator<ActivityType> it2 = entityListFetchPage.getAll().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
            this.diskCache.updateAfterFetch(nextPage, entityListFetchPage, false);
        }
        this.activityTypeCache.setAllActivityTypesCached(true);
        return new AllActivityTypesList(arrayList);
    }

    @Override // com.ua.sdk.activitytype.ActivityTypeManager
    public Request fetchActivityTypeList(FetchCallback<EntityList<ActivityType>> fetchCallback) {
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.activitytype.ActivityTypeManagerImpl.1
            @Override // java.lang.Runnable
            public void run() throws SQLException {
                try {
                    fetchRequest.done(ActivityTypeManagerImpl.this.fetchActivityTypeList(), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }

    private ActivityTypeListRef getRef() {
        return ActivityTypeListRef.getBuilder().build();
    }

    @Override // com.ua.sdk.activitytype.ActivityTypeManager
    public ActivityType fetchActivityType(ActivityTypeRef activityTypeRef) throws UaException {
        return fetch(activityTypeRef);
    }

    @Override // com.ua.sdk.activitytype.ActivityTypeManager
    public Request fetchActivityType(ActivityTypeRef activityTypeRef, FetchCallback<ActivityType> fetchCallback) {
        return fetch(activityTypeRef, fetchCallback);
    }
}
