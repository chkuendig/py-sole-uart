package io.ktor.client.plugins.logging;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.objectweb.asm.Opcodes;

/* compiled from: LoggingUtils.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a2\u0010\n\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001a \u0010\u0012\u001a\u00020\u0001*\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\u001a>\u0010\u0018\u001a\u00020\u0001*\u00060\u0013j\u0002`\u00142\u001e\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00100\u001b0\u001a2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000\u001a#\u0010\u001c\u001a\u0004\u0018\u00010\u0016*\u00020\b2\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"logResponseBody", "", "log", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "contentType", "Lio/ktor/http/ContentType;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "(Ljava/lang/StringBuilder;Lio/ktor/http/ContentType;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logResponseHeader", "response", "Lio/ktor/client/statement/HttpResponse;", FirebaseAnalytics.Param.LEVEL, "Lio/ktor/client/plugins/logging/LogLevel;", "sanitizedHeaders", "", "Lio/ktor/client/plugins/logging/SanitizedHeader;", "logHeader", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "key", "", "value", "logHeaders", "headers", "", "", "tryReadText", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-logging"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LoggingUtilsKt {

    /* compiled from: LoggingUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", i = {0, 0}, l = {71}, m = "logResponseBody", n = {"$this$logResponseBody_u24lambda_u244", "charset$iv"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1, reason: invalid class name */
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
            return LoggingUtilsKt.logResponseBody(null, null, null, this);
        }
    }

    /* compiled from: LoggingUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.LoggingUtilsKt", f = "LoggingUtils.kt", i = {0}, l = {50}, m = "tryReadText", n = {HttpAuthHeader.Parameters.Charset}, s = {"L$0"})
    /* renamed from: io.ktor.client.plugins.logging.LoggingUtilsKt$tryReadText$1, reason: invalid class name and case insensitive filesystem */
    static final class C10881 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10881(Continuation<? super C10881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoggingUtilsKt.tryReadText(null, null, this);
        }
    }

    public static final void logHeaders(Appendable appendable, Set<? extends Map.Entry<String, ? extends List<String>>> headers, List<SanitizedHeader> sanitizedHeaders) throws IOException {
        Object next;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(sanitizedHeaders, "sanitizedHeaders");
        for (Map.Entry entry : CollectionsKt.sortedWith(CollectionsKt.toList(headers), new Comparator() { // from class: io.ktor.client.plugins.logging.LoggingUtilsKt$logHeaders$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) t).getKey(), (String) ((Map.Entry) t2).getKey());
            }
        })) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            Iterator<T> it = sanitizedHeaders.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((SanitizedHeader) next).getPredicate().invoke(str).booleanValue()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            SanitizedHeader sanitizedHeader = (SanitizedHeader) next;
            String placeholder = sanitizedHeader != null ? sanitizedHeader.getPlaceholder() : null;
            if (placeholder == null) {
                placeholder = CollectionsKt.joinToString$default(list, "; ", null, null, 0, null, null, 62, null);
            }
            logHeader(appendable, str, placeholder);
        }
    }

    public static final void logHeader(Appendable appendable, String key, String value) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Appendable appendableAppend = appendable.append("-> " + key + ": " + value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(value)");
        Intrinsics.checkNotNullExpressionValue(appendableAppend.append('\n'), "append('\\n')");
    }

    public static final void logResponseHeader(StringBuilder log, HttpResponse response, LogLevel level, List<SanitizedHeader> sanitizedHeaders) throws IOException {
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(sanitizedHeaders, "sanitizedHeaders");
        if (level.getInfo()) {
            StringBuilder sbAppend = log.append("RESPONSE: " + response.getStatus());
            Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
            Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append('\\n')");
            StringBuilder sbAppend2 = log.append("METHOD: " + response.getCall().getRequest().getMethod());
            Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(value)");
            Intrinsics.checkNotNullExpressionValue(sbAppend2.append('\n'), "append('\\n')");
            StringBuilder sbAppend3 = log.append("FROM: " + response.getCall().getRequest().getUrl());
            Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(value)");
            Intrinsics.checkNotNullExpressionValue(sbAppend3.append('\n'), "append('\\n')");
        }
        if (level.getHeaders()) {
            StringBuilder sbAppend4 = log.append("COMMON HEADERS");
            Intrinsics.checkNotNullExpressionValue(sbAppend4, "append(value)");
            Intrinsics.checkNotNullExpressionValue(sbAppend4.append('\n'), "append('\\n')");
            logHeaders(log, response.getHeaders().entries(), sanitizedHeaders);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object tryReadText(io.ktor.utils.io.ByteReadChannel r8, java.nio.charset.Charset r9, kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.client.plugins.logging.LoggingUtilsKt.C10881
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.logging.LoggingUtilsKt$tryReadText$1 r0 = (io.ktor.client.plugins.logging.LoggingUtilsKt.C10881) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.logging.LoggingUtilsKt$tryReadText$1 r0 = new io.ktor.client.plugins.logging.LoggingUtilsKt$tryReadText$1
            r0.<init>(r10)
        L19:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r4.L$0
            r9 = r8
            java.nio.charset.Charset r9 = (java.nio.charset.Charset) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L54
            goto L4c
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L54
            r4.label = r2     // Catch: java.lang.Throwable -> L54
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r8
            java.lang.Object r10 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L54
            if (r10 != r0) goto L4c
            return r0
        L4c:
            io.ktor.utils.io.core.Input r10 = (io.ktor.utils.io.core.Input) r10     // Catch: java.lang.Throwable -> L54
            r8 = 0
            r0 = 2
            java.lang.String r7 = io.ktor.utils.io.core.StringsKt.readText$default(r10, r9, r8, r0, r7)     // Catch: java.lang.Throwable -> L54
        L54:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingUtilsKt.tryReadText(io.ktor.utils.io.ByteReadChannel, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object tryReadText$$forInline(ByteReadChannel byteReadChannel, Charset charset, Continuation<? super String> continuation) {
        try {
            InlineMarker.mark(0);
            Object remaining$default = ByteReadChannel.DefaultImpls.readRemaining$default(byteReadChannel, 0L, continuation, 1, null);
            InlineMarker.mark(1);
            return StringsKt.readText$default((Input) remaining$default, charset, 0, 2, (Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object logResponseBody(java.lang.StringBuilder r12, io.ktor.http.ContentType r13, io.ktor.utils.io.ByteReadChannel r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof io.ktor.client.plugins.logging.LoggingUtilsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r15
            io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1 r0 = (io.ktor.client.plugins.logging.LoggingUtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1 r0 = new io.ktor.client.plugins.logging.LoggingUtilsKt$logResponseBody$1
            r0.<init>(r15)
        L19:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 0
            r2 = 1
            java.lang.String r8 = "append('\\n')"
            r9 = 10
            java.lang.String r10 = "append(value)"
            if (r1 == 0) goto L44
            if (r1 != r2) goto L3c
            java.lang.Object r12 = r4.L$1
            java.nio.charset.Charset r12 = (java.nio.charset.Charset) r12
            java.lang.Object r13 = r4.L$0
            java.lang.StringBuilder r13 = (java.lang.StringBuilder) r13
            kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Throwable -> L3a
            goto L95
        L3a:
            r12 = r13
            goto L9e
        L3c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L44:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "BODY Content-Type: "
            r15.<init>(r1)
            java.lang.StringBuilder r15 = r15.append(r13)
            java.lang.String r15 = r15.toString()
            java.lang.StringBuilder r15 = r12.append(r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r10)
            java.lang.StringBuilder r15 = r15.append(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r8)
            java.lang.String r15 = "BODY START"
            java.lang.StringBuilder r15 = r12.append(r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r10)
            java.lang.StringBuilder r15 = r15.append(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r8)
            if (r13 == 0) goto L7e
            io.ktor.http.HeaderValueWithParameters r13 = (io.ktor.http.HeaderValueWithParameters) r13
            java.nio.charset.Charset r13 = io.ktor.http.ContentTypesKt.charset(r13)
            if (r13 != 0) goto L80
        L7e:
            java.nio.charset.Charset r13 = kotlin.text.Charsets.UTF_8
        L80:
            r4.L$0 = r12     // Catch: java.lang.Throwable -> L9e
            r4.L$1 = r13     // Catch: java.lang.Throwable -> L9e
            r4.label = r2     // Catch: java.lang.Throwable -> L9e
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r14
            java.lang.Object r15 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L9e
            if (r15 != r0) goto L92
            return r0
        L92:
            r11 = r13
            r13 = r12
            r12 = r11
        L95:
            io.ktor.utils.io.core.Input r15 = (io.ktor.utils.io.core.Input) r15     // Catch: java.lang.Throwable -> L3a
            r14 = 0
            r0 = 2
            java.lang.String r7 = io.ktor.utils.io.core.StringsKt.readText$default(r15, r12, r14, r0, r7)     // Catch: java.lang.Throwable -> L3a
            goto L9f
        L9e:
            r13 = r12
        L9f:
            if (r7 != 0) goto La3
            java.lang.String r7 = "[response body omitted]"
        La3:
            java.lang.StringBuilder r12 = r13.append(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r10)
            java.lang.StringBuilder r12 = r12.append(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r8)
            java.lang.String r12 = "BODY END"
            r13.append(r12)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.LoggingUtilsKt.logResponseBody(java.lang.StringBuilder, io.ktor.http.ContentType, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
