package io.ktor.client.plugins.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.utils.io.ByteChannelCtorKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J#\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ?\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J#\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache;", "", "publicStorage", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "privateStorage", "publicStorageNew", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "privateStorageNew", "useOldStorage", "", "isSharedClient", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;ZZ)V", "isSharedClient$ktor_client_core", "()Z", "getPrivateStorage$annotations", "()V", "getPrivateStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage$annotations", "getPublicStorage", "cacheResponse", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAndRefresh", "request", "Lio/ktor/client/request/HttpRequest;", "(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findResponse", "storage", "varyKeys", "", "", "url", "Lio/ktor/http/Url;", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Ljava/util/Map;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SdkConstants.ATTR_CONTEXT, "Lio/ktor/client/request/HttpRequestBuilder;", "content", "Lio/ktor/http/content/OutgoingContent;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpCache {
    private final boolean isSharedClient;
    private final HttpCacheStorage privateStorage;
    private final CacheStorage privateStorageNew;
    private final HttpCacheStorage publicStorage;
    private final CacheStorage publicStorageNew;
    private final boolean useOldStorage;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<HttpCache> key = new AttributeKey<>("HttpCache");
    private static final EventDefinition<HttpResponse> HttpResponseFromCache = new EventDefinition<>();

    /* compiled from: HttpCache.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {WinError.ERROR_TOO_MANY_POSTS, 300}, m = "findAndRefresh", n = {"this", "request", "response", "storage", "varyKeysFrom304", "request", "response", SdkConstants.FD_CACHE}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
    /* renamed from: io.ktor.client.plugins.cache.HttpCache$findAndRefresh$1, reason: invalid class name */
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
            return HttpCache.this.findAndRefresh(null, null, this);
        }
    }

    /* compiled from: HttpCache.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {1}, l = {311, TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "findResponse", n = {"requestHeaders"}, s = {"L$0"})
    /* renamed from: io.ktor.client.plugins.cache.HttpCache$findResponse$1, reason: invalid class name and case insensitive filesystem */
    static final class C10721 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10721(Continuation<? super C10721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCache.this.findResponse(null, null, null, null, this);
        }
    }

    /* compiled from: HttpCache.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", i = {0, 0, 0, 1}, l = {328, 328}, m = "findResponse", n = {"this", "url", "lookup", "lookup"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: io.ktor.client.plugins.cache.HttpCache$findResponse$4, reason: invalid class name */
    static final class AnonymousClass4 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCache.this.findResponse(null, null, this);
        }
    }

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2, cacheStorage, cacheStorage2, z, z2);
    }

    @Deprecated(message = "This will become internal")
    public static /* synthetic */ void getPrivateStorage$annotations() {
    }

    @Deprecated(message = "This will become internal")
    public static /* synthetic */ void getPublicStorage$annotations() {
    }

    private HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2) {
        this.publicStorage = httpCacheStorage;
        this.privateStorage = httpCacheStorage2;
        this.publicStorageNew = cacheStorage;
        this.privateStorageNew = cacheStorage2;
        this.useOldStorage = z;
        this.isSharedClient = z2;
    }

    public final HttpCacheStorage getPublicStorage() {
        return this.publicStorage;
    }

    public final HttpCacheStorage getPrivateStorage() {
        return this.privateStorage;
    }

    /* renamed from: isSharedClient$ktor_client_core, reason: from getter */
    public final boolean getIsSharedClient() {
        return this.isSharedClient;
    }

    /* compiled from: HttpCache.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R,\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Config;", "", "()V", "isShared", "", "()Z", "setShared", "(Z)V", "value", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "privateStorage", "getPrivateStorage$annotations", "getPrivateStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "setPrivateStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "privateStorageNew", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "getPrivateStorageNew$ktor_client_core", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "setPrivateStorageNew$ktor_client_core", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "publicStorage", "getPublicStorage$annotations", "getPublicStorage", "setPublicStorage", "publicStorageNew", "getPublicStorageNew$ktor_client_core", "setPublicStorageNew$ktor_client_core", "useOldStorage", "getUseOldStorage$ktor_client_core", "setUseOldStorage$ktor_client_core", "", "storage", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        private boolean isShared;
        private boolean useOldStorage;
        private CacheStorage publicStorageNew = CacheStorage.INSTANCE.getUnlimited().invoke();
        private CacheStorage privateStorageNew = CacheStorage.INSTANCE.getUnlimited().invoke();
        private HttpCacheStorage publicStorage = HttpCacheStorage.INSTANCE.getUnlimited().invoke();
        private HttpCacheStorage privateStorage = HttpCacheStorage.INSTANCE.getUnlimited().invoke();

        @Deprecated(message = "This will become internal. Use setter method instead with new storage interface")
        public static /* synthetic */ void getPrivateStorage$annotations() {
        }

        @Deprecated(message = "This will become internal. Use setter method instead with new storage interface")
        public static /* synthetic */ void getPublicStorage$annotations() {
        }

        /* renamed from: getPublicStorageNew$ktor_client_core, reason: from getter */
        public final CacheStorage getPublicStorageNew() {
            return this.publicStorageNew;
        }

        public final void setPublicStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            Intrinsics.checkNotNullParameter(cacheStorage, "<set-?>");
            this.publicStorageNew = cacheStorage;
        }

        /* renamed from: getPrivateStorageNew$ktor_client_core, reason: from getter */
        public final CacheStorage getPrivateStorageNew() {
            return this.privateStorageNew;
        }

        public final void setPrivateStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            Intrinsics.checkNotNullParameter(cacheStorage, "<set-?>");
            this.privateStorageNew = cacheStorage;
        }

        /* renamed from: getUseOldStorage$ktor_client_core, reason: from getter */
        public final boolean getUseOldStorage() {
            return this.useOldStorage;
        }

        public final void setUseOldStorage$ktor_client_core(boolean z) {
            this.useOldStorage = z;
        }

        /* renamed from: isShared, reason: from getter */
        public final boolean getIsShared() {
            return this.isShared;
        }

        public final void setShared(boolean z) {
            this.isShared = z;
        }

        public final HttpCacheStorage getPublicStorage() {
            return this.publicStorage;
        }

        public final void setPublicStorage(HttpCacheStorage value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.useOldStorage = true;
            this.publicStorage = value;
        }

        public final HttpCacheStorage getPrivateStorage() {
            return this.privateStorage;
        }

        public final void setPrivateStorage(HttpCacheStorage value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.useOldStorage = true;
            this.privateStorage = value;
        }

        public final void publicStorage(CacheStorage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.publicStorageNew = storage;
        }

        public final void privateStorage(CacheStorage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.privateStorageNew = storage;
        }
    }

    /* compiled from: HttpCache.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00032\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0016H\u0016J3\u0010\u0017\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\u001f\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0004\b \u0010!J9\u0010\"\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cache/HttpCache$Config;", "Lio/ktor/client/plugins/cache/HttpCache;", "()V", "HttpResponseFromCache", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "getHttpResponseFromCache", "()Lio/ktor/events/EventDefinition;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "proceedWithCache", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "cachedCall", "Lio/ktor/client/call/HttpClientCall;", "proceedWithCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithMissingCache", "proceedWithMissingCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithWarning", "cachedResponse", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCache> getKey() {
            return HttpCache.key;
        }

        public final EventDefinition<HttpResponse> getHttpResponseFromCache() {
            return HttpCache.HttpResponseFromCache;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCache prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCache(config.getPublicStorage(), config.getPrivateStorage(), config.getPublicStorageNew(), config.getPrivateStorageNew(), config.getUseOldStorage(), config.getIsShared(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCache plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            scope.getSendPipeline().insertPhaseAfter(HttpSendPipeline.INSTANCE.getState(), pipelinePhase);
            scope.getSendPipeline().intercept(pipelinePhase, new HttpCache$Companion$install$1(plugin, scope, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getState(), new HttpCache$Companion$install$2(plugin, scope, null));
        }

        public final Object proceedWithCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, HttpClientCall httpClientCall, Continuation<? super Unit> continuation) {
            pipelineContext.finish();
            httpClient.getMonitor().raise(getHttpResponseFromCache(), httpClientCall.getResponse());
            Object objProceedWith = pipelineContext.proceedWith(httpClientCall, continuation);
            return objProceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProceedWith : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, CachedResponseData cachedResponseData, HttpClient httpClient, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
            HttpRequestData httpRequestDataBuild = pipelineContext.getContext().build();
            HttpStatusCode statusCode = cachedResponseData.getStatusCode();
            GMTDate requestTime = cachedResponseData.getRequestTime();
            Headers.Companion companion = Headers.INSTANCE;
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            headersBuilder.appendAll(cachedResponseData.getHeaders());
            headersBuilder.append(HttpHeaders.INSTANCE.getWarning(), "110");
            Unit unit = Unit.INSTANCE;
            HttpClientCall httpClientCall = new HttpClientCall(httpClient, httpRequestDataBuild, new HttpResponseData(statusCode, requestTime, headersBuilder.build(), cachedResponseData.getVersion(), ByteChannelCtorKt.ByteReadChannel(cachedResponseData.getBody()), coroutineContext));
            pipelineContext.finish();
            httpClient.getMonitor().raise(getHttpResponseFromCache(), httpClientCall.getResponse());
            Object objProceedWith = pipelineContext.proceedWith(httpClientCall, continuation);
            return objProceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProceedWith : Unit.INSTANCE;
        }

        public final Object proceedWithMissingCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, Continuation<? super Unit> continuation) {
            pipelineContext.finish();
            HttpRequestData httpRequestDataBuild = pipelineContext.getContext().build();
            Object objProceedWith = pipelineContext.proceedWith(new HttpClientCall(httpClient, httpRequestDataBuild, new HttpResponseData(HttpStatusCode.INSTANCE.getGatewayTimeout(), DateJvmKt.GMTDate$default(null, 1, null), Headers.INSTANCE.getEmpty(), HttpProtocolVersion.INSTANCE.getHTTP_1_1(), ByteChannelCtorKt.ByteReadChannel(new byte[0]), httpRequestDataBuild.getExecutionContext())), continuation);
            return objProceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProceedWith : Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cacheResponse(HttpResponse httpResponse, Continuation<? super CachedResponseData> continuation) {
        CacheStorage cacheStorage;
        HttpRequest request = httpResponse.getCall().getRequest();
        List<HeaderValue> listCacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
        List<HeaderValue> listCacheControl2 = HttpMessagePropertiesKt.cacheControl(request);
        boolean zContains = listCacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core());
        if (zContains && this.isSharedClient) {
            return null;
        }
        if (zContains) {
            cacheStorage = this.privateStorageNew;
        } else {
            cacheStorage = this.publicStorageNew;
        }
        if (listCacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core()) || listCacheControl2.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core())) {
            return null;
        }
        return HttpCacheStorageKt.store(cacheStorage, httpResponse, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findAndRefresh(io.ktor.client.request.HttpRequest r13, io.ktor.client.statement.HttpResponse r14, kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r15) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.findAndRefresh(io.ktor.client.request.HttpRequest, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findResponse(io.ktor.client.plugins.cache.storage.CacheStorage r6, java.util.Map<java.lang.String, java.lang.String> r7, io.ktor.http.Url r8, io.ktor.client.request.HttpRequest r9, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCache.C10721
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.cache.HttpCache$findResponse$1 r0 = (io.ktor.client.plugins.cache.HttpCache.C10721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.cache.HttpCache$findResponse$1 r0 = new io.ktor.client.plugins.cache.HttpCache$findResponse$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7a
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L4f
        L3d:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r7.isEmpty()
            if (r10 != 0) goto L50
            r0.label = r4
            java.lang.Object r10 = r6.find(r8, r7, r0)
            if (r10 != r1) goto L4f
            return r1
        L4f:
            return r10
        L50:
            io.ktor.http.content.OutgoingContent r7 = r9.getContent()
            io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$1 r10 = new io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$1
            io.ktor.http.Headers r2 = r9.getHeaders()
            r10.<init>(r2)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$2 r2 = new io.ktor.client.plugins.cache.HttpCache$findResponse$requestHeaders$2
            io.ktor.http.Headers r9 = r9.getHeaders()
            r2.<init>(r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.jvm.functions.Function1 r7 = io.ktor.client.plugins.cache.HttpCacheKt.mergedHeadersLookup(r7, r10, r2)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r10 = r6.findAll(r8, r0)
            if (r10 != r1) goto L79
            return r1
        L79:
            r6 = r7
        L7a:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1 r7 = new io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
            r7.<init>()
            java.util.Comparator r7 = (java.util.Comparator) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.sortedWith(r10, r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L8d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Ld0
            java.lang.Object r8 = r7.next()
            r9 = r8
            io.ktor.client.plugins.cache.storage.CachedResponseData r9 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r9
            java.util.Map r9 = r9.getVaryKeys()
            boolean r10 = r9.isEmpty()
            if (r10 == 0) goto La5
            goto Ld1
        La5:
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        Lad:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Ld1
            java.lang.Object r10 = r9.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r0 = r10.getKey()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r0 = r6.invoke(r0)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r10)
            if (r10 != 0) goto Lad
            goto L8d
        Ld0:
            r8 = 0
        Ld1:
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.findResponse(io.ktor.client.plugins.cache.storage.CacheStorage, java.util.Map, io.ktor.http.Url, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findResponse(io.ktor.client.request.HttpRequestBuilder r9, io.ktor.http.content.OutgoingContent r10, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.storage.CachedResponseData> r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCache.findResponse(io.ktor.client.request.HttpRequestBuilder, io.ktor.http.content.OutgoingContent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
