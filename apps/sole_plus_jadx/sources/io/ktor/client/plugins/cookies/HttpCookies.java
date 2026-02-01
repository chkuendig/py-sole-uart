package io.ktor.client.plugins.cookies;

import com.android.SdkConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: HttpCookies.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002#$BA\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012-\u0010\u0005\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000b0\u0006ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\tH\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0015R8\u0010\u0005\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000b0\u0006X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "storage", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "defaults", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/util/List;)V", "initializer", "Lkotlinx/coroutines/Job;", "getInitializer$annotations", "()V", "captureHeaderCookies", "builder", "Lio/ktor/client/request/HttpRequestBuilder;", "captureHeaderCookies$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "get", "Lio/ktor/http/Cookie;", "requestUrl", "Lio/ktor/http/Url;", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCookiesFrom", "response", "Lio/ktor/client/statement/HttpResponse;", "saveCookiesFrom$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCookiesWith", "sendCookiesWith$ktor_client_core", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpCookies implements Closeable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<HttpCookies> key = new AttributeKey<>("HttpCookies");
    private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults;
    private final Job initializer;
    private final CookiesStorage storage;

    /* compiled from: HttpCookies.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", i = {0, 0}, l = {39, 40}, m = "get", n = {"this", "requestUrl"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.cookies.HttpCookies$get$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookies.this.get(null, this);
        }
    }

    private static /* synthetic */ void getInitializer$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpCookies(CookiesStorage storage, List<? extends Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object>> defaults) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(defaults, "defaults");
        this.storage = storage;
        this.defaults = defaults;
        this.initializer = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), null, new HttpCookies$initializer$1(this, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(io.ktor.http.Url r6, kotlin.coroutines.Continuation<? super java.util.List<io.ktor.http.Cookie>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cookies.HttpCookies.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$get$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L64
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.client.plugins.cookies.HttpCookies r2 = (io.ktor.client.plugins.cookies.HttpCookies) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L54
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.Job r7 = r5.initializer
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.join(r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            r2 = r5
        L54:
            io.ktor.client.plugins.cookies.CookiesStorage r7 = r2.storage
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.get(r6, r0)
            if (r7 != r1) goto L64
            return r1
        L64:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.get(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object captureHeaderCookies$ktor_client_core(io.ktor.client.request.HttpRequestBuilder r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.captureHeaderCookies$ktor_client_core(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendCookiesWith$ktor_client_core(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L50
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.http.URLBuilder r6 = r5.getUrl()
            io.ktor.http.URLBuilder r6 = io.ktor.http.URLBuilderKt.clone(r6)
            io.ktor.http.Url r6 = r6.build()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.get(r6, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            java.util.List r6 = (java.util.List) r6
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L91
            java.lang.String r6 = io.ktor.client.plugins.cookies.HttpCookiesKt.access$renderClientCookies(r6)
            io.ktor.http.HeadersBuilder r0 = r5.getHeaders()
            io.ktor.http.HttpHeaders r1 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r1 = r1.getCookie()
            r0.set(r1, r6)
            org.slf4j.Logger r0 = io.ktor.client.plugins.cookies.HttpCookiesKt.access$getLOGGER$p()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Sending cookie "
            r1.<init>(r2)
            java.lang.StringBuilder r6 = r1.append(r6)
            java.lang.String r1 = " for "
            java.lang.StringBuilder r6 = r6.append(r1)
            io.ktor.http.URLBuilder r5 = r5.getUrl()
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            r0.trace(r5)
            goto L9e
        L91:
            io.ktor.http.HeadersBuilder r5 = r5.getHeaders()
            io.ktor.http.HttpHeaders r6 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r6 = r6.getCookie()
            r5.remove(r6)
        L9e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.sendCookiesWith$ktor_client_core(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveCookiesFrom$ktor_client_core(io.ktor.client.statement.HttpResponse r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$1
            io.ktor.http.Url r2 = (io.ktor.http.Url) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.plugins.cookies.HttpCookies r4 = (io.ktor.client.plugins.cookies.HttpCookies) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto La6
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.request.HttpRequest r10 = io.ktor.client.statement.HttpResponseKt.getRequest(r9)
            io.ktor.http.Url r10 = r10.getUrl()
            io.ktor.http.Headers r2 = r9.getHeaders()
            io.ktor.http.HttpHeaders r4 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r4 = r4.getSetCookie()
            java.util.List r2 = r2.getAll(r4)
            if (r2 == 0) goto L98
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L5f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L98
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            org.slf4j.Logger r5 = io.ktor.client.plugins.cookies.HttpCookiesKt.access$getLOGGER$p()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Received cookie "
            r6.<init>(r7)
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.String r6 = " in response for "
            java.lang.StringBuilder r4 = r4.append(r6)
            io.ktor.client.call.HttpClientCall r6 = r9.getCall()
            io.ktor.client.request.HttpRequest r6 = r6.getRequest()
            io.ktor.http.Url r6 = r6.getUrl()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            r5.trace(r4)
            goto L5f
        L98:
            io.ktor.http.HttpMessage r9 = (io.ktor.http.HttpMessage) r9
            java.util.List r9 = io.ktor.http.HttpMessagePropertiesKt.setCookie(r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r4 = r8
            r2 = r10
        La6:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lc3
            java.lang.Object r10 = r9.next()
            io.ktor.http.Cookie r10 = (io.ktor.http.Cookie) r10
            io.ktor.client.plugins.cookies.CookiesStorage r5 = r4.storage
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r10 = r5.addCookie(r2, r10, r0)
            if (r10 != r1) goto La6
            return r1
        Lc3:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.saveCookiesFrom$ktor_client_core(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.storage.close();
    }

    /* compiled from: HttpCookies.kt */
    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J7\u0010\u0012\u001a\u00020\b2'\u0010\u0013\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\u0014R8\u0010\u0003\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\t0\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "", "()V", "defaults", "", "Lkotlin/Function2;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "storage", "getStorage", "()Lio/ktor/client/plugins/cookies/CookiesStorage;", "setStorage", "(Lio/ktor/client/plugins/cookies/CookiesStorage;)V", "build", "Lio/ktor/client/plugins/cookies/HttpCookies;", "build$ktor_client_core", SdkConstants.SKIN_DEFAULT, "block", "(Lkotlin/jvm/functions/Function2;)V", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults = new ArrayList();
        private CookiesStorage storage = new AcceptAllCookiesStorage();

        public final CookiesStorage getStorage() {
            return this.storage;
        }

        public final void setStorage(CookiesStorage cookiesStorage) {
            Intrinsics.checkNotNullParameter(cookiesStorage, "<set-?>");
            this.storage = cookiesStorage;
        }

        /* renamed from: default, reason: not valid java name */
        public final void m8784default(Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.defaults.add(block);
        }

        public final HttpCookies build$ktor_client_core() {
            return new HttpCookies(this.storage, this.defaults);
        }
    }

    /* compiled from: HttpCookies.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "Lio/ktor/client/plugins/cookies/HttpCookies;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCookies prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return config.build$ktor_client_core();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCookies> getKey() {
            return HttpCookies.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCookies plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getState(), new HttpCookies$Companion$install$1(plugin, null));
            scope.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getState(), new HttpCookies$Companion$install$2(plugin, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getState(), new HttpCookies$Companion$install$3(plugin, null));
        }
    }
}
