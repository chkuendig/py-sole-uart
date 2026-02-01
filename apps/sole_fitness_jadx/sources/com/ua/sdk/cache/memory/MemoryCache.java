package com.ua.sdk.cache.memory;

import com.ua.sdk.Reference;
import com.ua.sdk.Resource;
import com.ua.sdk.cache.Cache;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class MemoryCache implements Cache {
    WeakHashMap<Reference, Resource> map = new WeakHashMap<>();

    @Override // com.ua.sdk.cache.Cache
    public long getCacheAge(Reference reference) {
        return 0L;
    }

    @Override // com.ua.sdk.cache.Cache
    public <R extends Reference> Resource<R> get(R r) {
        return this.map.get(r);
    }

    @Override // com.ua.sdk.cache.Cache
    public void put(Resource resource) {
        if (resource != null) {
            this.map.put(resource.getRef(), resource);
        }
    }

    @Override // com.ua.sdk.cache.Cache
    public boolean remove(Resource resource) {
        return (resource == null || this.map.remove(resource.getRef()) == null) ? false : true;
    }

    @Override // com.ua.sdk.cache.Cache
    public boolean remove(Reference reference) {
        return this.map.remove(reference) != null;
    }
}
