package io.ktor.client.plugins.logging;

import com.android.SdkConstants;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: HttpClientCallLogger.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0012R\u0018\u0010\u0015\u001a\u00060\u0013j\u0002`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\u001b\u001a\u00060\u0013j\u0002`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lio/ktor/client/plugins/logging/HttpClientCallLogger;", "Lio/ktor/client/plugins/logging/Logger;", "logger", SdkConstants.CONSTRUCTOR_NAME, "(Lio/ktor/client/plugins/logging/Logger;)V", "", "closeRequestLog", "()V", "closeResponseLog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "message", "logRequest", "(Ljava/lang/String;)V", "logResponseBody", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logResponseException", "logResponseHeader", "Lio/ktor/client/plugins/logging/Logger;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "requestLog", "Ljava/lang/StringBuilder;", "Lkotlinx/coroutines/CompletableJob;", "requestLoggedMonitor", "Lkotlinx/coroutines/CompletableJob;", "responseHeaderMonitor", "responseLog", "ktor-client-logging", ""}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpClientCallLogger {
    private static final /* synthetic */ AtomicIntegerFieldUpdater requestLogged$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "requestLogged");
    private static final /* synthetic */ AtomicIntegerFieldUpdater responseLogged$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCallLogger.class, "responseLogged");
    private final Logger logger;
    private final StringBuilder requestLog;
    private volatile /* synthetic */ int requestLogged;
    private final CompletableJob requestLoggedMonitor;
    private final CompletableJob responseHeaderMonitor;
    private final StringBuilder responseLog;
    private volatile /* synthetic */ int responseLogged;

    /* compiled from: HttpClientCallLogger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", i = {0}, l = {52}, m = "closeResponseLog", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCallLogger.this.closeResponseLog(this);
        }
    }

    /* compiled from: HttpClientCallLogger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", i = {0, 0}, l = {34}, m = "logResponseBody", n = {"this", "message"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1, reason: invalid class name and case insensitive filesystem */
    static final class C10841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10841(Continuation<? super C10841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCallLogger.this.logResponseBody(null, this);
        }
    }

    /* compiled from: HttpClientCallLogger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.HttpClientCallLogger", f = "HttpClientCallLogger.kt", i = {0, 0}, l = {29}, m = "logResponseException", n = {"this", "message"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1, reason: invalid class name and case insensitive filesystem */
    static final class C10851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10851(Continuation<? super C10851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClientCallLogger.this.logResponseException(null, this);
        }
    }

    public HttpClientCallLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.requestLog = new StringBuilder();
        this.responseLog = new StringBuilder();
        this.requestLoggedMonitor = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.responseHeaderMonitor = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.requestLogged = 0;
        this.responseLogged = 0;
    }

    public final void logRequest(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        StringBuilder sbAppend = this.requestLog.append(StringsKt.trim((CharSequence) message).toString());
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append('\\n')");
    }

    public final void logResponseHeader(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        StringBuilder sbAppend = this.responseLog.append(StringsKt.trim((CharSequence) message).toString());
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append('\\n')");
        this.responseHeaderMonitor.complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object logResponseException(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger.C10851
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger.C10851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseException$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CompletableJob r6 = r4.requestLoggedMonitor
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.join(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r0 = r4
        L4d:
            io.ktor.client.plugins.logging.Logger r6 = r0.logger
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r5 = kotlin.text.StringsKt.trim(r5)
            java.lang.String r5 = r5.toString()
            r6.log(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.logResponseException(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object logResponseBody(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger.C10841
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger.C10841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$logResponseBody$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CompletableJob r6 = r4.responseHeaderMonitor
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.join(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r0 = r4
        L4d:
            java.lang.StringBuilder r6 = r0.responseLog
            r6.append(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.logResponseBody(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void closeRequestLog() {
        if (requestLogged$FU.compareAndSet(this, 0, 1)) {
            try {
                String string = StringsKt.trim(this.requestLog).toString();
                if (string.length() > 0) {
                    this.logger.log(string);
                }
            } finally {
                this.requestLoggedMonitor.complete();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object closeResponseLog(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.plugins.logging.HttpClientCallLogger.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1 r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1 r0 = new io.ktor.client.plugins.logging.HttpClientCallLogger$closeResponseLog$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            io.ktor.client.plugins.logging.HttpClientCallLogger r0 = (io.ktor.client.plugins.logging.HttpClientCallLogger) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L53
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = io.ktor.client.plugins.logging.HttpClientCallLogger.responseLogged$FU
            r2 = 0
            boolean r5 = r5.compareAndSet(r4, r2, r3)
            if (r5 != 0) goto L45
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L45:
            kotlinx.coroutines.CompletableJob r5 = r4.requestLoggedMonitor
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L52
            return r1
        L52:
            r0 = r4
        L53:
            java.lang.StringBuilder r5 = r0.responseLog
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r5 = kotlin.text.StringsKt.trim(r5)
            java.lang.String r5 = r5.toString()
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L6d
            io.ktor.client.plugins.logging.Logger r0 = r0.logger
            r0.log(r5)
        L6d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.HttpClientCallLogger.closeResponseLog(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
