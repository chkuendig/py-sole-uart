package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.http.Cookie;
import io.ktor.http.CookieKt;
import io.ktor.http.Url;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpCookies.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\u0002\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "renderClientCookies", "", "cookies", "", "Lio/ktor/http/Cookie;", "Lio/ktor/client/HttpClient;", "url", "Lio/ktor/http/Url;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "name", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpCookiesKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCookies");

    /* compiled from: HttpCookies.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", i = {}, l = {136}, m = "cookies", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookiesKt.cookies((HttpClient) null, (Url) null, this);
        }
    }

    /* compiled from: HttpCookies.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", i = {}, l = {142}, m = "cookies", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$2, reason: invalid class name */
    static final class AnonymousClass2 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookiesKt.cookies((HttpClient) null, (String) null, this);
        }
    }

    /* compiled from: HttpCookies.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cookies.HttpCookiesKt$renderClientCookies$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C10831 extends FunctionReferenceImpl implements Function1<Cookie, String> {
        public static final C10831 INSTANCE = new C10831();

        C10831() {
            super(1, CookieKt.class, "renderCookieHeader", "renderCookieHeader(Lio/ktor/http/Cookie;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Cookie p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return CookieKt.renderCookieHeader(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderClientCookies(List<Cookie> list) {
        return CollectionsKt.joinToString$default(list, "; ", null, null, 0, null, C10831.INSTANCE, 30, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object cookies(io.ktor.client.HttpClient r4, io.ktor.http.Url r5, kotlin.coroutines.Continuation<? super java.util.List<io.ktor.http.Cookie>> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.client.plugins.cookies.HttpCookiesKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$1 r0 = (io.ktor.client.plugins.cookies.HttpCookiesKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$1 r0 = new io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.client.plugins.cookies.HttpCookies$Companion r6 = io.ktor.client.plugins.cookies.HttpCookies.INSTANCE
            io.ktor.client.plugins.HttpClientPlugin r6 = (io.ktor.client.plugins.HttpClientPlugin) r6
            java.lang.Object r4 = io.ktor.client.plugins.HttpClientPluginKt.pluginOrNull(r4, r6)
            io.ktor.client.plugins.cookies.HttpCookies r4 = (io.ktor.client.plugins.cookies.HttpCookies) r4
            if (r4 == 0) goto L4e
            r0.label = r3
            java.lang.Object r6 = r4.get(r5, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L52
        L4e:
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L52:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookiesKt.cookies(io.ktor.client.HttpClient, io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object cookies(io.ktor.client.HttpClient r4, java.lang.String r5, kotlin.coroutines.Continuation<? super java.util.List<io.ktor.http.Cookie>> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.client.plugins.cookies.HttpCookiesKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$2 r0 = (io.ktor.client.plugins.cookies.HttpCookiesKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$2 r0 = new io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$2
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.client.plugins.cookies.HttpCookies$Companion r6 = io.ktor.client.plugins.cookies.HttpCookies.INSTANCE
            io.ktor.client.plugins.HttpClientPlugin r6 = (io.ktor.client.plugins.HttpClientPlugin) r6
            java.lang.Object r4 = io.ktor.client.plugins.HttpClientPluginKt.pluginOrNull(r4, r6)
            io.ktor.client.plugins.cookies.HttpCookies r4 = (io.ktor.client.plugins.cookies.HttpCookies) r4
            if (r4 == 0) goto L52
            io.ktor.http.Url r5 = io.ktor.http.URLUtilsKt.Url(r5)
            r0.label = r3
            java.lang.Object r6 = r4.get(r5, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L56
        L52:
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L56:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookiesKt.cookies(io.ktor.client.HttpClient, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Cookie get(List<Cookie> list, String name) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Cookie) next).getName(), name)) {
                break;
            }
        }
        return (Cookie) next;
    }
}
