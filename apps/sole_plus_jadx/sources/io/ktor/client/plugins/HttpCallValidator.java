package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.pipeline.PipelinePhase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019BY\b\u0000\u00127\u0010\u0002\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0002\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidator;", "", "responseValidators", "", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "callExceptionHandlers", "Lio/ktor/client/plugins/HandlerWrapper;", "expectSuccess", "", "(Ljava/util/List;Ljava/util/List;Z)V", "processException", "cause", "", "request", "Lio/ktor/client/request/HttpRequest;", "(Ljava/lang/Throwable;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateResponse", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpCallValidator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<HttpCallValidator> key = new AttributeKey<>("HttpResponseValidator");
    private final List<HandlerWrapper> callExceptionHandlers;
    private final boolean expectSuccess;
    private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators;

    /* compiled from: HttpCallValidator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", i = {0, 0, 1, 1}, l = {58, 59}, m = "processException", n = {"cause", "request", "cause", "request"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.HttpCallValidator$processException$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCallValidator.this.processException(null, null, this);
        }
    }

    /* compiled from: HttpCallValidator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", i = {0}, l = {51}, m = "validateResponse", n = {"response"}, s = {"L$0"})
    /* renamed from: io.ktor.client.plugins.HttpCallValidator$validateResponse$1, reason: invalid class name and case insensitive filesystem */
    static final class C10701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10701(Continuation<? super C10701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCallValidator.this.validateResponse(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidator(List<? extends Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> responseValidators, List<? extends HandlerWrapper> callExceptionHandlers, boolean z) {
        Intrinsics.checkNotNullParameter(responseValidators, "responseValidators");
        Intrinsics.checkNotNullParameter(callExceptionHandlers, "callExceptionHandlers");
        this.responseValidators = responseValidators;
        this.callExceptionHandlers = callExceptionHandlers;
        this.expectSuccess = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object validateResponse(io.ktor.client.statement.HttpResponse r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.HttpCallValidator.C10701
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = (io.ktor.client.plugins.HttpCallValidator.C10701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.plugins.HttpCallValidator$validateResponse$1 r0 = new io.ktor.client.plugins.HttpCallValidator$validateResponse$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$1
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpResponse r2 = (io.ktor.client.statement.HttpResponse) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L6b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            org.slf4j.Logger r8 = io.ktor.client.plugins.HttpCallValidatorKt.access$getLOGGER$p()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Validating response for request "
            r2.<init>(r4)
            io.ktor.client.call.HttpClientCall r4 = r7.getCall()
            io.ktor.client.request.HttpRequest r4 = r4.getRequest()
            io.ktor.http.Url r4 = r4.getUrl()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r8.trace(r2)
            java.util.List<kotlin.jvm.functions.Function2<io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r8 = r6.responseValidators
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
            r5 = r8
            r8 = r7
            r7 = r5
        L6b:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r7.next()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r8
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r2 = r2.invoke(r8, r0)
            if (r2 != r1) goto L6b
            return r1
        L84:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.validateResponse(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009c, code lost:
    
        r2 = r9;
        r9 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processException(java.lang.Throwable r8, io.ktor.client.request.HttpRequest r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.HttpCallValidator.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = (io.ktor.client.plugins.HttpCallValidator.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.HttpCallValidator$processException$1 r0 = new io.ktor.client.plugins.HttpCallValidator$processException$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            java.lang.Object r8 = r0.L$2
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.client.request.HttpRequest r9 = (io.ktor.client.request.HttpRequest) r9
            java.lang.Object r2 = r0.L$0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9c
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            org.slf4j.Logger r10 = io.ktor.client.plugins.HttpCallValidatorKt.access$getLOGGER$p()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Processing exception "
            r2.<init>(r5)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r5 = " for request "
            java.lang.StringBuilder r2 = r2.append(r5)
            io.ktor.http.Url r5 = r9.getUrl()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r10.trace(r2)
            java.util.List<io.ktor.client.plugins.HandlerWrapper> r10 = r7.callExceptionHandlers
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L75:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lb8
            java.lang.Object r2 = r8.next()
            io.ktor.client.plugins.HandlerWrapper r2 = (io.ktor.client.plugins.HandlerWrapper) r2
            boolean r5 = r2 instanceof io.ktor.client.plugins.ExceptionHandlerWrapper
            if (r5 == 0) goto L9f
            io.ktor.client.plugins.ExceptionHandlerWrapper r2 = (io.ktor.client.plugins.ExceptionHandlerWrapper) r2
            kotlin.jvm.functions.Function2 r2 = r2.getHandler()
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r2 = r2.invoke(r9, r0)
            if (r2 != r1) goto L9a
            return r1
        L9a:
            r2 = r9
            r9 = r10
        L9c:
            r10 = r9
            r9 = r2
            goto L75
        L9f:
            boolean r5 = r2 instanceof io.ktor.client.plugins.RequestExceptionHandlerWrapper
            if (r5 == 0) goto L75
            io.ktor.client.plugins.RequestExceptionHandlerWrapper r2 = (io.ktor.client.plugins.RequestExceptionHandlerWrapper) r2
            kotlin.jvm.functions.Function3 r2 = r2.getHandler()
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r2 = r2.invoke(r9, r10, r0)
            if (r2 != r1) goto L9a
            return r1
        Lb8:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidator.processException(java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HttpCallValidator.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JC\u0010\u0018\u001a\u00020\u001621\u0010\u0019\u001a-\b\u0001\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001cJV\u0010\u001d\u001a\u00020\u00162F\u0010\u0019\u001aB\b\u0001\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b( \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eø\u0001\u0000¢\u0006\u0002\u0010!JA\u0010\"\u001a\u00020\u001621\u0010\u0019\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u001cR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eRH\u0010\u000f\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00100\u000bX\u0080\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidator$Config;", "", "()V", "expectSuccess", "", "getExpectSuccess$annotations", "getExpectSuccess", "()Z", "setExpectSuccess", "(Z)V", "responseExceptionHandlers", "", "Lio/ktor/client/plugins/HandlerWrapper;", "getResponseExceptionHandlers$ktor_client_core", "()Ljava/util/List;", "responseValidators", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "getResponseValidators$ktor_client_core", "handleResponseException", "block", "", "cause", "(Lkotlin/jvm/functions/Function2;)V", "handleResponseExceptionWithRequest", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequest;", "request", "(Lkotlin/jvm/functions/Function3;)V", "validateResponse", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators = new ArrayList();
        private final List<HandlerWrapper> responseExceptionHandlers = new ArrayList();
        private boolean expectSuccess = true;

        @Deprecated(message = "This property is ignored. Please use `expectSuccess` property in HttpClientConfig. This is going to become internal.")
        public static /* synthetic */ void getExpectSuccess$annotations() {
        }

        public final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> getResponseValidators$ktor_client_core() {
            return this.responseValidators;
        }

        public final List<HandlerWrapper> getResponseExceptionHandlers$ktor_client_core() {
            return this.responseExceptionHandlers;
        }

        public final boolean getExpectSuccess() {
            return this.expectSuccess;
        }

        public final void setExpectSuccess(boolean z) {
            this.expectSuccess = z;
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Consider using `handleResponseExceptionWithRequest` instead", replaceWith = @ReplaceWith(expression = "this.handleResponseExceptionWithRequest(block)", imports = {}))
        public final void handleResponseException(Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.responseExceptionHandlers.add(new ExceptionHandlerWrapper(block));
        }

        public final void handleResponseExceptionWithRequest(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(block));
        }

        public final void validateResponse(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.responseValidators.add(block);
        }
    }

    /* compiled from: HttpCallValidator.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidator$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpCallValidator$Config;", "Lio/ktor/client/plugins/HttpCallValidator;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCallValidator> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCallValidator> getKey() {
            return HttpCallValidator.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCallValidator prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCallValidator(CollectionsKt.reversed(config.getResponseValidators$ktor_client_core()), CollectionsKt.reversed(config.getResponseExceptionHandlers$ktor_client_core()), config.getExpectSuccess());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCallValidator plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getBefore(), new HttpCallValidator$Companion$install$1(plugin, null));
            PipelinePhase pipelinePhase = new PipelinePhase("BeforeReceive");
            scope.getResponsePipeline().insertPhaseBefore(HttpResponsePipeline.INSTANCE.getReceive(), pipelinePhase);
            scope.getResponsePipeline().intercept(pipelinePhase, new HttpCallValidator$Companion$install$2(plugin, null));
            ((HttpSend) HttpClientPluginKt.plugin(scope, HttpSend.INSTANCE)).intercept(new HttpCallValidator$Companion$install$3(plugin, null));
        }
    }
}
