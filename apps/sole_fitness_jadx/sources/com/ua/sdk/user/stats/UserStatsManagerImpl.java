package com.ua.sdk.user.stats;

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
public class UserStatsManagerImpl extends AbstractManager<UserStats> implements UserStatsManager {
    public UserStatsManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<UserStats> diskCache, EntityService<UserStats> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.user.stats.UserStatsManager
    public UserStats fetchUserStats(UserStatsRef userStatsRef) throws UaException {
        return fetch(userStatsRef);
    }

    @Override // com.ua.sdk.user.stats.UserStatsManager
    public Request fetchUserStats(UserStatsRef userStatsRef, FetchCallback<UserStats> fetchCallback) {
        return fetch(userStatsRef, fetchCallback);
    }
}
