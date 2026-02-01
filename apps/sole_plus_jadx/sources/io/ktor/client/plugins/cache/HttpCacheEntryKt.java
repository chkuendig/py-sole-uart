package io.ktor.client.plugins.cache;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HttpCacheEntry.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a$\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0000\u001a\u0018\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u0005H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"HttpCacheEntry", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "isShared", "", "response", "Lio/ktor/client/statement/HttpResponse;", "(ZLio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldValidate", "Lio/ktor/client/plugins/cache/ValidateStatus;", "cacheExpires", "Lio/ktor/util/date/GMTDate;", "responseHeaders", "Lio/ktor/http/Headers;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "fallback", "Lkotlin/Function0;", "varyKeys", "", "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpCacheEntryKt {

    /* compiled from: HttpCacheEntry.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", i = {0, 0}, l = {18}, m = "HttpCacheEntry", n = {"response", "isShared"}, s = {"L$0", "Z$0"})
    /* renamed from: io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheEntryKt.HttpCacheEntry(false, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object HttpCacheEntry(boolean r8, io.ktor.client.statement.HttpResponse r9, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.HttpCacheEntry> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.client.plugins.cache.HttpCacheEntryKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = (io.ktor.client.plugins.cache.HttpCacheEntryKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = new io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            r0.<init>(r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L39
            if (r1 != r7) goto L31
            boolean r8 = r4.Z$0
            java.lang.Object r9 = r4.L$0
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L51
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.utils.io.ByteReadChannel r1 = r9.getContent()
            r4.L$0 = r9
            r4.Z$0 = r8
            r4.label = r7
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r10 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)
            if (r10 != r0) goto L51
            return r0
        L51:
            io.ktor.utils.io.core.ByteReadPacket r10 = (io.ktor.utils.io.core.ByteReadPacket) r10
            r0 = 0
            r1 = 0
            byte[] r10 = io.ktor.utils.io.core.StringsKt.readBytes$default(r10, r0, r7, r1)
            io.ktor.client.statement.HttpResponseKt.complete(r9)
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = new io.ktor.client.plugins.cache.HttpCacheEntry
            r2 = 2
            io.ktor.util.date.GMTDate r8 = cacheExpires$default(r9, r8, r1, r2, r1)
            java.util.Map r1 = varyKeys(r9)
            r0.<init>(r8, r1, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.HttpCacheEntry(boolean, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Map<String, String> varyKeys(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        List<String> listVary = HttpMessagePropertiesKt.vary(httpResponse);
        if (listVary == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers headers = httpResponse.getCall().getRequest().getHeaders();
        for (String str : listVary) {
            String str2 = headers.get(str);
            if (str2 == null) {
                str2 = "";
            }
            linkedHashMap.put(str, str2);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ GMTDate cacheExpires$default(HttpResponse httpResponse, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<GMTDate>() { // from class: io.ktor.client.plugins.cache.HttpCacheEntryKt.cacheExpires.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GMTDate invoke() {
                    return DateJvmKt.GMTDate$default(null, 1, null);
                }
            };
        }
        return cacheExpires(httpResponse, z, function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.util.date.GMTDate cacheExpires(io.ktor.client.statement.HttpResponse r10, boolean r11, kotlin.jvm.functions.Function0<io.ktor.util.date.GMTDate> r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "fallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = r10
            io.ktor.http.HttpMessage r0 = (io.ktor.http.HttpMessage) r0
            java.util.List r0 = io.ktor.http.HttpMessagePropertiesKt.cacheControl(r0)
            r1 = 2
            r2 = 0
            r3 = 0
            if (r11 == 0) goto L44
            r11 = r0
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            boolean r4 = r11 instanceof java.util.Collection
            if (r4 == 0) goto L27
            r4 = r11
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L27
            goto L44
        L27:
            java.util.Iterator r11 = r11.iterator()
        L2b:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L44
            java.lang.Object r4 = r11.next()
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.getValue()
            java.lang.String r5 = "s-maxage"
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r4, r5, r2, r1, r3)
            if (r4 == 0) goto L2b
            goto L46
        L44:
            java.lang.String r5 = "max-age"
        L46:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r11 = r0.iterator()
        L4c:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L64
            java.lang.Object r0 = r11.next()
            r4 = r0
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r4, r5, r2, r1, r3)
            if (r4 == 0) goto L4c
            goto L65
        L64:
            r0 = r3
        L65:
            io.ktor.http.HeaderValue r0 = (io.ktor.http.HeaderValue) r0
            if (r0 == 0) goto L93
            java.lang.String r11 = r0.getValue()
            if (r11 == 0) goto L93
            r4 = r11
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11 = 1
            java.lang.String[] r5 = new java.lang.String[r11]
            java.lang.String r0 = "="
            r5[r2] = r0
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default(r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L93
            java.lang.Object r11 = r0.get(r11)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L93
            int r11 = java.lang.Integer.parseInt(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
        L93:
            if (r3 == 0) goto La6
            io.ktor.util.date.GMTDate r10 = r10.getRequestTime()
            int r11 = r3.intValue()
            long r11 = (long) r11
            r0 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r0
            io.ktor.util.date.GMTDate r10 = io.ktor.util.date.DateKt.plus(r10, r11)
            return r10
        La6:
            io.ktor.http.Headers r10 = r10.getHeaders()
            io.ktor.http.HttpHeaders r11 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r11 = r11.getExpires()
            java.lang.String r10 = r10.get(r11)
            if (r10 == 0) goto Ldb
            java.lang.String r11 = "0"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r11)
            if (r11 != 0) goto Ld4
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            if (r11 == 0) goto Lc8
            goto Ld4
        Lc8:
            io.ktor.util.date.GMTDate r10 = io.ktor.http.DateUtilsKt.fromHttpToGmtDate(r10)     // Catch: java.lang.Throwable -> Lcd
            goto Ld3
        Lcd:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
        Ld3:
            return r10
        Ld4:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        Ldb:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.cacheExpires(io.ktor.client.statement.HttpResponse, boolean, kotlin.jvm.functions.Function0):io.ktor.util.date.GMTDate");
    }

    public static final ValidateStatus shouldValidate(GMTDate cacheExpires, Headers responseHeaders, HttpRequestBuilder request) {
        int iIntValue;
        Object next;
        Integer numValueOf;
        String value;
        Integer intOrNull;
        String value2;
        List listSplit$default;
        String str;
        Intrinsics.checkNotNullParameter(cacheExpires, "cacheExpires");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(request, "request");
        HeadersBuilder headers = request.getHeaders();
        List<String> all = responseHeaders.getAll(HttpHeaders.INSTANCE.getCacheControl());
        Object obj = null;
        List<HeaderValue> headerValue = HttpHeaderValueParserKt.parseHeaderValue(all != null ? CollectionsKt.joinToString$default(all, ",", null, null, 0, null, null, 62, null) : null);
        List<String> all2 = headers.getAll(HttpHeaders.INSTANCE.getCacheControl());
        List<HeaderValue> headerValue2 = HttpHeaderValueParserKt.parseHeaderValue(all2 != null ? CollectionsKt.joinToString$default(all2, ",", null, null, 0, null, null, 62, null) : null);
        if (headerValue2.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        List<HeaderValue> list = headerValue2;
        Iterator<T> it = list.iterator();
        while (true) {
            iIntValue = 0;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (StringsKt.startsWith$default(((HeaderValue) next).getValue(), "max-age=", false, 2, (Object) null)) {
                break;
            }
        }
        HeaderValue headerValue3 = (HeaderValue) next;
        if (headerValue3 == null || (value2 = headerValue3.getValue()) == null || (listSplit$default = StringsKt.split$default((CharSequence) value2, new String[]{"="}, false, 0, 6, (Object) null)) == null || (str = (String) listSplit$default.get(1)) == null) {
            numValueOf = null;
        } else {
            Integer intOrNull2 = StringsKt.toIntOrNull(str);
            numValueOf = Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0);
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            HttpCacheKt.getLOGGER().trace("\"max-age\" is not set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        if (headerValue.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        long timestamp = cacheExpires.getTimestamp() - DateJvmKt.getTimeMillis();
        if (timestamp > 0) {
            HttpCacheKt.getLOGGER().trace("Cached response is valid for " + request.getUrl() + ", should not validate");
            return ValidateStatus.ShouldNotValidate;
        }
        if (headerValue.contains(CacheControl.INSTANCE.getMUST_REVALIDATE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"must-revalidate\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (StringsKt.startsWith$default(((HeaderValue) next2).getValue(), "max-stale=", false, 2, (Object) null)) {
                obj = next2;
                break;
            }
        }
        HeaderValue headerValue4 = (HeaderValue) obj;
        if (headerValue4 != null && (value = headerValue4.getValue()) != null) {
            String strSubstring = value.substring(10);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (strSubstring != null && (intOrNull = StringsKt.toIntOrNull(strSubstring)) != null) {
                iIntValue = intOrNull.intValue();
            }
        }
        if (timestamp + (iIntValue * 1000) > 0) {
            HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + " but less than max-stale, should warn");
            return ValidateStatus.ShouldWarn;
        }
        HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    }
}
