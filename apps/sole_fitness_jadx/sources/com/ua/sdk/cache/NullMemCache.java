package com.ua.sdk.cache;

import com.ua.sdk.Reference;
import com.ua.sdk.Resource;

/* loaded from: classes2.dex */
public class NullMemCache implements Cache {
    @Override // com.ua.sdk.cache.Cache
    public <R extends Reference> Resource<R> get(R r) {
        return null;
    }

    @Override // com.ua.sdk.cache.Cache
    public long getCacheAge(Reference reference) {
        return 0L;
    }

    @Override // com.ua.sdk.cache.Cache
    public void put(Resource resource) {
    }

    @Override // com.ua.sdk.cache.Cache
    public boolean remove(Reference reference) {
        return false;
    }

    @Override // com.ua.sdk.cache.Cache
    public boolean remove(Resource resource) {
        return false;
    }
}
