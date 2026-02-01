package com.ua.sdk.group.leaderboard;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
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
public class GroupLeaderboardManagerImpl extends AbstractManager<GroupLeaderboard> implements GroupLeaderboardManager {
    public GroupLeaderboardManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<GroupLeaderboard> diskCache, EntityService<GroupLeaderboard> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.group.leaderboard.GroupLeaderboardManager
    public EntityList<GroupLeaderboard> fetchGroupLeaderboardList(EntityListRef<GroupLeaderboard> entityListRef) throws UaException {
        return fetchPage(entityListRef);
    }

    @Override // com.ua.sdk.group.leaderboard.GroupLeaderboardManager
    public Request fetchGroupLeaderboardList(EntityListRef<GroupLeaderboard> entityListRef, FetchCallback<EntityList<GroupLeaderboard>> fetchCallback) {
        return fetchPage(entityListRef, fetchCallback);
    }
}
