package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J/\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0004\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachingCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "delegate", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "store", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/http/Url;", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "find", "url", "varyKeys", "", "", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "data", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CachingCacheStorage implements CacheStorage {
    private final CacheStorage delegate;
    private final ConcurrentMap<Url, Set<CachedResponseData>> store;

    /* compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0, 0}, l = {43}, m = "find", n = {"this", "url", "varyKeys"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.find(null, null, this);
        }
    }

    /* compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {53}, m = "findAll", n = {"this", "url"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1, reason: invalid class name and case insensitive filesystem */
    static final class C10751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10751(Continuation<? super C10751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.findAll(null, this);
        }
    }

    /* compiled from: FileCacheStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", i = {0, 0}, l = {37, 38}, m = "store", n = {"this", "url"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1, reason: invalid class name and case insensitive filesystem */
    static final class C10761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10761(Continuation<? super C10761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.store(null, null, this);
        }
    }

    public CachingCacheStorage(CacheStorage delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.store = new ConcurrentMap<>(0, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object store(io.ktor.http.Url r7, io.ktor.client.plugins.cache.storage.CachedResponseData r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.client.plugins.cache.storage.CachingCacheStorage.C10761
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1 r0 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage.C10761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1 r0 = new io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            io.ktor.http.Url r7 = (io.ktor.http.Url) r7
            java.lang.Object r8 = r0.L$0
            java.util.Map r8 = (java.util.Map) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L72
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.L$1
            io.ktor.http.Url r7 = (io.ktor.http.Url) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.client.plugins.cache.storage.CachingCacheStorage r8 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5c
        L49:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.plugins.cache.storage.CacheStorage r9 = r6.delegate
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r9.store(r7, r8, r0)
            if (r8 != r1) goto L5b
            return r1
        L5b:
            r8 = r6
        L5c:
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r9 = r8.store
            java.util.Map r9 = (java.util.Map) r9
            io.ktor.client.plugins.cache.storage.CacheStorage r8 = r8.delegate
            r0.L$0 = r9
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.findAll(r7, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            r5 = r9
            r9 = r8
            r8 = r5
        L72:
            r8.put(r7, r9)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.CachingCacheStorage.store(io.ktor.http.Url, io.ktor.client.plugins.cache.storage.CachedResponseData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object find(io.ktor.http.Url r6, java.util.Map<java.lang.String, java.lang.String> r7, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cache.storage.CachingCacheStorage.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1 r0 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1 r0 = new io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r6 = r0.L$4
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r7 = r0.L$3
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r1 = r0.L$2
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r2 = r0.L$1
            io.ktor.http.Url r2 = (io.ktor.http.Url) r2
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.cache.storage.CachingCacheStorage r0 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r8 = r5.store
            boolean r8 = r8.containsKey(r6)
            if (r8 != 0) goto L75
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r8 = r5.store
            java.util.Map r8 = (java.util.Map) r8
            io.ktor.client.plugins.cache.storage.CacheStorage r2 = r5.delegate
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r8
            r0.L$4 = r6
            r0.label = r3
            java.lang.Object r0 = r2.findAll(r6, r0)
            if (r0 != r1) goto L6a
            return r1
        L6a:
            r2 = r6
            r1 = r7
            r7 = r8
            r8 = r0
            r0 = r5
        L6f:
            r7.put(r6, r8)
            r7 = r1
            r6 = r2
            goto L76
        L75:
            r0 = r5
        L76:
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r8 = r0.store
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r6 = kotlin.collections.MapsKt.getValue(r8, r6)
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L86:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto Lc9
            java.lang.Object r8 = r6.next()
            r0 = r8
            io.ktor.client.plugins.cache.storage.CachedResponseData r0 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r0
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L9a
            goto Lca
        L9a:
            java.util.Set r1 = r7.entrySet()
            java.util.Iterator r1 = r1.iterator()
        La2:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lca
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map r4 = r0.getVaryKeys()
            java.lang.Object r3 = r4.get(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r2 != 0) goto La2
            goto L86
        Lc9:
            r8 = 0
        Lca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.CachingCacheStorage.find(io.ktor.http.Url, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object findAll(io.ktor.http.Url r5, kotlin.coroutines.Continuation<? super java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cache.storage.CachingCacheStorage.C10751
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1 r0 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage.C10751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1 r0 = new io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r5 = r0.L$3
            io.ktor.http.Url r5 = (io.ktor.http.Url) r5
            java.lang.Object r1 = r0.L$2
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r2 = r0.L$1
            io.ktor.http.Url r2 = (io.ktor.http.Url) r2
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.cache.storage.CachingCacheStorage r0 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L68
        L3a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L42:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r6 = r4.store
            boolean r6 = r6.containsKey(r5)
            if (r6 != 0) goto L6d
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r6 = r4.store
            java.util.Map r6 = (java.util.Map) r6
            io.ktor.client.plugins.cache.storage.CacheStorage r2 = r4.delegate
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r5
            r0.label = r3
            java.lang.Object r0 = r2.findAll(r5, r0)
            if (r0 != r1) goto L64
            return r1
        L64:
            r2 = r5
            r1 = r6
            r6 = r0
            r0 = r4
        L68:
            r1.put(r5, r6)
            r5 = r2
            goto L6e
        L6d:
            r0 = r4
        L6e:
            io.ktor.util.collections.ConcurrentMap<io.ktor.http.Url, java.util.Set<io.ktor.client.plugins.cache.storage.CachedResponseData>> r6 = r0.store
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r5 = kotlin.collections.MapsKt.getValue(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.CachingCacheStorage.findAll(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
