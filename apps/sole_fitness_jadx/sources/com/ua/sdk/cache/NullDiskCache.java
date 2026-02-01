package com.ua.sdk.cache;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.Resource;
import com.ua.sdk.cache.DiskCache;

/* loaded from: classes2.dex */
public class NullDiskCache<T extends Resource> implements DiskCache<T> {
    @Override // com.ua.sdk.cache.DiskCache
    public void delete(Reference reference) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void deleteList(EntityListRef<T> entityListRef) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public T get(Reference reference) {
        return null;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public long getCacheAge(Reference reference) {
        return 0L;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public long getLastSynced(Reference reference) {
        return 0L;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public EntityList<T> getList(Reference reference) {
        return null;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public DiskCache.State getState(Reference reference) {
        return null;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void markForDelete(Reference reference) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public long putForCreate(T t) {
        return 0L;
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void putForSave(T t) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void updateAfterCreate(long j, T t) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void updateAfterFetch(EntityListRef<T> entityListRef, EntityList<T> entityList, boolean z) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void updateAfterFetch(T t) {
    }

    @Override // com.ua.sdk.cache.DiskCache
    public void updateAfterSave(T t) {
    }
}
