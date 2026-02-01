package com.ua.sdk.group.purpose;

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
public class GroupPurposeManagerImpl extends AbstractManager<GroupPurpose> implements GroupPurposeManager {
    public GroupPurposeManagerImpl(CacheSettings cacheSettings, Cache cache, DiskCache<GroupPurpose> diskCache, EntityService<GroupPurpose> entityService, ExecutorService executorService) {
        super(cacheSettings, cache, diskCache, entityService, executorService);
    }

    @Override // com.ua.sdk.group.purpose.GroupPurposeManager
    public EntityList<GroupPurpose> fetchGroupPurposeList() throws UaException {
        return fetchPage(null);
    }

    @Override // com.ua.sdk.group.purpose.GroupPurposeManager
    public Request fetchGroupPurposeList(FetchCallback<EntityList<GroupPurpose>> fetchCallback) {
        return fetchPage((EntityListRef) null, fetchCallback);
    }
}
