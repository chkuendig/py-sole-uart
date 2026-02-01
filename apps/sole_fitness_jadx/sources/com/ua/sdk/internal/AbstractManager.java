package com.ua.sdk.internal;

import com.ua.sdk.CreateCallback;
import com.ua.sdk.DeleteCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Reference;
import com.ua.sdk.Request;
import com.ua.sdk.Resource;
import com.ua.sdk.SaveCallback;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.Cache;
import com.ua.sdk.cache.CachePolicy;
import com.ua.sdk.cache.CacheSettings;
import com.ua.sdk.cache.DiskCache;
import com.ua.sdk.cache.NullDiskCache;
import com.ua.sdk.cache.NullMemCache;
import com.ua.sdk.concurrent.CreateRequest;
import com.ua.sdk.concurrent.DeleteRequest;
import com.ua.sdk.concurrent.EntityEventHandler;
import com.ua.sdk.concurrent.FetchRequest;
import com.ua.sdk.concurrent.SaveRequest;
import com.ua.sdk.concurrent.SynchronousRequest;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public abstract class AbstractManager<T extends Resource> {
    protected final CacheSettings cacheSettings;
    protected final DiskCache<T> diskCache;
    protected final ExecutorService executor;
    protected final Cache memCache;
    protected final EntityService<T> service;

    protected T onPostServiceCreate(T t) throws UaException {
        return t;
    }

    protected T onPostServiceFetch(Reference reference, T t) throws UaException {
        return t;
    }

    protected EntityList<T> onPostServiceFetchPage(Reference reference, EntityList<T> entityList) throws UaException {
        return entityList;
    }

    protected T onPostServicePatch(T t) throws UaException {
        return t;
    }

    protected T onPostServiceSave(T t) throws UaException {
        return t;
    }

    protected AbstractManager(CacheSettings cacheSettings, Cache cache, DiskCache<T> diskCache, EntityService<T> entityService, ExecutorService executorService) {
        this.cacheSettings = (CacheSettings) Precondition.isNotNull(cacheSettings);
        if (diskCache == null) {
            this.diskCache = new NullDiskCache();
        } else {
            this.diskCache = diskCache;
        }
        if (cache == null) {
            this.memCache = new NullMemCache();
        } else {
            this.memCache = cache;
        }
        this.executor = executorService;
        this.service = entityService;
    }

    public T create(T t) throws UaException, NullPointerException {
        Precondition.isNotNull(t);
        long jPutForCreate = this.diskCache.putForCreate(t);
        T t2 = (T) onPostServiceCreate(this.service.create(t));
        this.diskCache.updateAfterCreate(jPutForCreate, t2);
        this.memCache.put(t2);
        return t2;
    }

    public Request create(final T t, CreateCallback<T> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.internal.AbstractManager.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() throws NullPointerException {
                try {
                    createRequest.done(AbstractManager.this.create(t), null);
                } catch (UaException e) {
                    createRequest.done(t, e);
                }
            }
        }));
        return createRequest;
    }

    public T fetch(Reference reference) throws UaException {
        return (T) fetch(reference, this.cacheSettings.getDefaultCachePolicy());
    }

    protected T fetch(Reference reference, CachePolicy cachePolicy) throws UaException {
        return (T) fetch(reference, cachePolicy, true);
    }

    protected T fetch(Reference reference, CachePolicy cachePolicy, boolean z) throws UaException {
        if (reference == null) {
            throw new UaException("ref can't be null");
        }
        if (cachePolicy == null) {
            cachePolicy = this.cacheSettings.getDefaultCachePolicy();
        }
        T t = null;
        if (cachePolicy.checkCacheFirst()) {
            if (z) {
                long cacheAge = this.memCache.getCacheAge(reference);
                if ((cachePolicy.ignoreAge() || (cacheAge >= 0 && cacheAge <= this.cacheSettings.getMaxCacheAge())) && (t = (T) this.memCache.get(reference)) != null) {
                    return t;
                }
            }
            long cacheAge2 = this.diskCache.getCacheAge(reference);
            if ((cachePolicy.ignoreAge() || (cacheAge2 >= 0 && cacheAge2 <= this.cacheSettings.getMaxCacheAge())) && (t = (T) this.diskCache.get(reference)) != null) {
                this.memCache.put(t);
                return t;
            }
        }
        if (cachePolicy.checkNetwork()) {
            try {
                t = (T) onPostServiceFetch(reference, this.service.fetch(reference));
                if (t != null) {
                    this.diskCache.updateAfterFetch(t);
                    this.memCache.put(t);
                }
            } catch (UaException e) {
                if (cachePolicy.checkNetworkFirst() && cachePolicy.checkCache()) {
                    return (T) fetch(reference, CachePolicy.CACHE_ONLY, z);
                }
                throw e;
            }
        }
        return t;
    }

    protected Request fetch(Reference reference, FetchCallback<T> fetchCallback) {
        return fetch(reference, this.cacheSettings.getDefaultCachePolicy(), fetchCallback);
    }

    protected Request fetch(final Reference reference, final CachePolicy cachePolicy, FetchCallback<T> fetchCallback) {
        Resource resource;
        if (cachePolicy == null) {
            cachePolicy = this.cacheSettings.getDefaultCachePolicy();
        }
        if (cachePolicy.checkCacheFirst()) {
            long cacheAge = this.memCache.getCacheAge(reference);
            if ((cachePolicy.ignoreAge() || (cacheAge >= 0 && cacheAge <= this.cacheSettings.getMaxCacheAge())) && (resource = this.memCache.get(reference)) != null) {
                EntityEventHandler.callOnFetched(resource, null, fetchCallback);
                return SynchronousRequest.INSTANCE;
            }
        }
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.internal.AbstractManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractManager abstractManager = AbstractManager.this;
                    Reference reference2 = reference;
                    CachePolicy cachePolicy2 = cachePolicy;
                    fetchRequest.done(abstractManager.fetch(reference2, cachePolicy2, !cachePolicy2.checkCacheFirst()), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }

    public T update(T t) throws UaException {
        Resource resource = this.diskCache.get(t.getRef());
        T t2 = null;
        try {
            this.memCache.put(t);
            this.diskCache.putForSave(t);
            t2 = (T) onPostServiceSave(this.service.save(t));
            this.diskCache.updateAfterSave(t2);
            this.memCache.remove(t);
            this.memCache.put(t2);
            return t2;
        } catch (UaException e) {
            if (AnonymousClass7.$SwitchMap$com$ua$sdk$UaException$Code[e.getCode().ordinal()] != 1 && t2 == null) {
                this.diskCache.updateAfterSave(resource);
                this.memCache.remove(t);
                this.memCache.put(resource);
            }
            throw e;
        }
    }

    /* renamed from: com.ua.sdk.internal.AbstractManager$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$UaException$Code;

        static {
            int[] iArr = new int[UaException.Code.values().length];
            $SwitchMap$com$ua$sdk$UaException$Code = iArr;
            try {
                iArr[UaException.Code.NOT_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public Request update(final T t, SaveCallback<T> saveCallback) {
        final SaveRequest saveRequest = new SaveRequest(saveCallback);
        saveRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.internal.AbstractManager.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    saveRequest.done(AbstractManager.this.update(t), null);
                } catch (UaException e) {
                    saveRequest.done(t, e);
                }
            }
        }));
        return saveRequest;
    }

    public <R extends Reference> R delete(R r) throws UaException {
        this.memCache.remove(r);
        this.diskCache.markForDelete(r);
        this.service.delete(r);
        this.diskCache.delete(r);
        return r;
    }

    public Request delete(final Reference reference, DeleteCallback deleteCallback) {
        final DeleteRequest deleteRequest = new DeleteRequest(deleteCallback);
        deleteRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.internal.AbstractManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractManager.this.delete(reference);
                    deleteRequest.done(reference, null);
                } catch (UaException e) {
                    deleteRequest.done(reference, e);
                }
            }
        }));
        return deleteRequest;
    }

    public EntityList<T> fetchPage(EntityListRef<T> entityListRef) throws UaException {
        return fetchPage(entityListRef, this.cacheSettings.getDefaultCachePolicy());
    }

    protected EntityList<T> fetchPage(EntityListRef<T> entityListRef, CachePolicy cachePolicy) throws UaException {
        return fetchPage((EntityListRef) entityListRef, cachePolicy, true);
    }

    protected EntityList<T> fetchPage(EntityListRef<T> entityListRef, CachePolicy cachePolicy, boolean z) throws UaException {
        if (cachePolicy == null) {
            cachePolicy = this.cacheSettings.getDefaultCachePolicy();
        }
        EntityList<T> entityListOnPostServiceFetchPage = null;
        try {
            try {
                if (cachePolicy.checkCacheFirst()) {
                    if (z) {
                        long cacheAge = this.memCache.getCacheAge(entityListRef);
                        if ((cachePolicy.ignoreAge() || (cacheAge >= 0 && cacheAge <= this.cacheSettings.getMaxCacheAge())) && (entityListOnPostServiceFetchPage = (EntityList) this.memCache.get(entityListRef)) != null) {
                            return entityListOnPostServiceFetchPage;
                        }
                    }
                    long cacheAge2 = this.diskCache.getCacheAge(entityListRef);
                    if ((cachePolicy.ignoreAge() || (cacheAge2 >= 0 && cacheAge2 <= this.cacheSettings.getMaxCacheAge())) && (entityListOnPostServiceFetchPage = this.diskCache.getList(entityListRef)) != null) {
                        this.memCache.put(entityListOnPostServiceFetchPage);
                        return entityListOnPostServiceFetchPage;
                    }
                }
                if (cachePolicy.checkNetwork()) {
                    try {
                        entityListOnPostServiceFetchPage = onPostServiceFetchPage(entityListRef, this.service.fetchPage(entityListRef));
                        if (entityListOnPostServiceFetchPage != null) {
                            if (entityListOnPostServiceFetchPage instanceof AbstractEntityList) {
                                this.diskCache.updateAfterFetch(entityListRef, entityListOnPostServiceFetchPage, ((AbstractEntityList) entityListOnPostServiceFetchPage).preparePartials(entityListRef));
                            } else {
                                this.diskCache.updateAfterFetch(entityListRef, entityListOnPostServiceFetchPage, false);
                            }
                            this.memCache.put(entityListOnPostServiceFetchPage);
                        }
                    } catch (UaException e) {
                        if (cachePolicy.checkNetworkFirst() && cachePolicy.checkCache()) {
                            return fetchPage(entityListRef, CachePolicy.CACHE_ONLY, z);
                        }
                        throw e;
                    }
                }
                return entityListOnPostServiceFetchPage;
            } catch (UaException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            throw new UaException(th);
        }
    }

    protected Request fetchPage(EntityListRef<T> entityListRef, FetchCallback<EntityList<T>> fetchCallback) {
        return fetchPage(entityListRef, this.cacheSettings.getDefaultCachePolicy(), fetchCallback);
    }

    protected Request fetchPage(final EntityListRef<T> entityListRef, final CachePolicy cachePolicy, FetchCallback<EntityList<T>> fetchCallback) {
        EntityList entityList;
        if (cachePolicy == null) {
            cachePolicy = this.cacheSettings.getDefaultCachePolicy();
        }
        if (cachePolicy.checkCacheFirst()) {
            long cacheAge = this.memCache.getCacheAge(entityListRef);
            if ((cachePolicy.ignoreAge() || (cacheAge >= 0 && cacheAge <= this.cacheSettings.getMaxCacheAge())) && (entityList = (EntityList) this.memCache.get(entityListRef)) != null) {
                EntityEventHandler.callOnFetched(entityList, null, fetchCallback);
                return SynchronousRequest.INSTANCE;
            }
        }
        final FetchRequest fetchRequest = new FetchRequest(fetchCallback);
        fetchRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.internal.AbstractManager.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractManager abstractManager = AbstractManager.this;
                    EntityListRef<T> entityListRef2 = entityListRef;
                    CachePolicy cachePolicy2 = cachePolicy;
                    fetchRequest.done(abstractManager.fetchPage(entityListRef2, cachePolicy2, !cachePolicy2.checkCacheFirst()), null);
                } catch (UaException e) {
                    fetchRequest.done(null, e);
                }
            }
        }));
        return fetchRequest;
    }

    public T patch(T t, Reference reference) throws UaException {
        this.memCache.put(t);
        this.diskCache.putForSave(t);
        T t2 = (T) onPostServicePatch(this.service.patch(t, reference));
        this.diskCache.updateAfterSave(t2);
        this.memCache.remove(t);
        this.memCache.put(t2);
        return t2;
    }

    public Request patch(final T t, final Reference reference, CreateCallback<T> createCallback) {
        final CreateRequest createRequest = new CreateRequest(createCallback);
        createRequest.setFuture(this.executor.submit(new Runnable() { // from class: com.ua.sdk.internal.AbstractManager.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    createRequest.done(AbstractManager.this.patch(t, reference), null);
                } catch (UaException e) {
                    createRequest.done(t, e);
                }
            }
        }));
        return createRequest;
    }
}
