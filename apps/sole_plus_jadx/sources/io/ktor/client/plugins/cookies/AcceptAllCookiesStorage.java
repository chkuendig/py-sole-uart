package io.ktor.client.plugins.cookies;

import com.android.SdkConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.http.Cookie;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: AcceptAllCookiesStorage.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0019B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0002J!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/cookies/AcceptAllCookiesStorage;", SdkConstants.CONSTRUCTOR_NAME, "()V", "Lio/ktor/http/Url;", "requestUrl", "Lio/ktor/http/Cookie;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", SDKConstants.PARAM_DEBUG_MESSAGE_TIMESTAMP, "cleanup", "(J)V", "close", "", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "container", "Ljava/util/List;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "ktor-client-core", "Lio/ktor/client/plugins/cookies/CookiesStorage;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AcceptAllCookiesStorage implements CookiesStorage {
    private final List<Cookie> container = new ArrayList();
    private volatile /* synthetic */ long oldestCookie = 0;
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0, 0}, l = {66}, m = "addCookie", n = {"this", "requestUrl", "cookie", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.addCookie(null, null, this);
        }
    }

    /* compiled from: AcceptAllCookiesStorage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0}, l = {66}, m = "get", n = {"this", "requestUrl", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1, reason: invalid class name and case insensitive filesystem */
    static final class C10821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10821(Continuation<? super C10821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AcceptAllCookiesStorage.this.get(null, this);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object get(io.ktor.http.Url r9, kotlin.coroutines.Continuation<? super java.util.List<io.ktor.http.Cookie>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.C10821
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.C10821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$get$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r1 = r0.L$1
            io.ktor.http.Url r1 = (io.ktor.http.Url) r1
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L56
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.sync.Mutex r10 = r8.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r0 = r10.lock(r3, r0)
            if (r0 != r1) goto L53
            return r1
        L53:
            r0 = r8
            r1 = r9
            r9 = r10
        L56:
            long r4 = io.ktor.util.date.DateJvmKt.getTimeMillis()     // Catch: java.lang.Throwable -> L8f
            long r6 = r0.oldestCookie     // Catch: java.lang.Throwable -> L8f
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 < 0) goto L63
            r0.cleanup(r4)     // Catch: java.lang.Throwable -> L8f
        L63:
            java.util.List<io.ktor.http.Cookie> r10 = r0.container     // Catch: java.lang.Throwable -> L8f
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch: java.lang.Throwable -> L8f
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L8f
            r0.<init>()     // Catch: java.lang.Throwable -> L8f
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L8f
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> L8f
        L72:
            boolean r2 = r10.hasNext()     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L89
            java.lang.Object r2 = r10.next()     // Catch: java.lang.Throwable -> L8f
            r4 = r2
            io.ktor.http.Cookie r4 = (io.ktor.http.Cookie) r4     // Catch: java.lang.Throwable -> L8f
            boolean r4 = io.ktor.client.plugins.cookies.CookiesStorageKt.matches(r4, r1)     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L72
            r0.add(r2)     // Catch: java.lang.Throwable -> L8f
            goto L72
        L89:
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L8f
            r9.unlock(r3)
            return r0
        L8f:
            r10 = move-exception
            r9.unlock(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.get(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object addCookie(final io.ktor.http.Url r6, final io.ktor.http.Cookie r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1 r0 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 != r4) goto L3d
            java.lang.Object r6 = r0.L$3
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.L$2
            io.ktor.http.Cookie r7 = (io.ktor.http.Cookie) r7
            java.lang.Object r1 = r0.L$1
            io.ktor.http.Url r1 = (io.ktor.http.Url) r1
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage r0 = (io.ktor.client.plugins.cookies.AcceptAllCookiesStorage) r0
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r6
            r6 = r1
            goto L5c
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r5.mutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r8
            r0.label = r4
            java.lang.Object r0 = r8.lock(r3, r0)
            if (r0 != r1) goto L5b
            return r1
        L5b:
            r0 = r5
        L5c:
            java.lang.String r1 = r7.getName()     // Catch: java.lang.Throwable -> L97
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Throwable -> L97
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto L8f
            java.util.List<io.ktor.http.Cookie> r1 = r0.container     // Catch: java.lang.Throwable -> L97
            io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2 r2 = new io.ktor.client.plugins.cookies.AcceptAllCookiesStorage$addCookie$2$2     // Catch: java.lang.Throwable -> L97
            r2.<init>()     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> L97
            kotlin.collections.CollectionsKt.removeAll(r1, r2)     // Catch: java.lang.Throwable -> L97
            java.util.List<io.ktor.http.Cookie> r1 = r0.container     // Catch: java.lang.Throwable -> L97
            io.ktor.http.Cookie r6 = io.ktor.client.plugins.cookies.CookiesStorageKt.fillDefaults(r7, r6)     // Catch: java.lang.Throwable -> L97
            r1.add(r6)     // Catch: java.lang.Throwable -> L97
            io.ktor.util.date.GMTDate r6 = r7.getExpires()     // Catch: java.lang.Throwable -> L97
            if (r6 == 0) goto L8f
            long r6 = r6.getTimestamp()     // Catch: java.lang.Throwable -> L97
            long r1 = r0.oldestCookie     // Catch: java.lang.Throwable -> L97
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L8f
            r0.oldestCookie = r6     // Catch: java.lang.Throwable -> L97
        L8f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L97
            r8.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L97:
            r6 = move-exception
            r8.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.addCookie(io.ktor.http.Url, io.ktor.http.Cookie, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void cleanup(final long timestamp) {
        CollectionsKt.removeAll((List) this.container, (Function1) new Function1<Cookie, Boolean>() { // from class: io.ktor.client.plugins.cookies.AcceptAllCookiesStorage.cleanup.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Cookie cookie) {
                Intrinsics.checkNotNullParameter(cookie, "cookie");
                GMTDate expires = cookie.getExpires();
                if (expires != null) {
                    return Boolean.valueOf(expires.getTimestamp() < timestamp);
                }
                return false;
            }
        });
        Iterator<T> it = this.container.iterator();
        long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            GMTDate expires = ((Cookie) it.next()).getExpires();
            if (expires != null) {
                jMin = Math.min(jMin, expires.getTimestamp());
            }
        }
        this.oldestCookie = jMin;
    }
}
