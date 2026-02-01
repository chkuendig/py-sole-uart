package io.ktor.client.statement;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: HttpStatement.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u0002H\f\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\rJT\u0010\u000b\u001a\u0002H\u000e\"\u0006\b\u0000\u0010\f\u0018\u0001\"\u0004\b\u0001\u0010\u000e23\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0011\u0010\u0018\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJJ\u0010\u0018\u001a\u0002H\f\"\u0004\b\u0000\u0010\f21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001a\u001a\u00020\u0019H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0015\u0010\u001d\u001a\u00020\u0017*\u00020\u0019H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "builder", "Lio/ktor/client/request/HttpRequestBuilder;", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "getClient$annotations", "()V", "getClient", "()Lio/ktor/client/HttpClient;", "body", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCapabilities", "", "execute", "Lio/ktor/client/statement/HttpResponse;", "executeUnsafe", "toString", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    /* compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {126}, m = "cleanup", n = {}, s = {})
    /* renamed from: io.ktor.client.statement.HttpStatement$cleanup$1, reason: invalid class name */
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
            return HttpStatement.this.cleanup(null, this);
        }
    }

    /* compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 1, 1}, l = {47, 50, 52, 52}, m = "execute", n = {"this", "block", "this", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name and case insensitive filesystem */
    static final class C11531<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11531(Continuation<? super C11531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    /* compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {108}, m = "executeUnsafe", n = {}, s = {})
    /* renamed from: io.ktor.client.statement.HttpStatement$executeUnsafe$1, reason: invalid class name and case insensitive filesystem */
    static final class C11541 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11541(Continuation<? super C11541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.executeUnsafe(this);
        }
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = builder;
        this.client = client;
        checkCapabilities();
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:57|(1:(1:(1:(1:(2:14|15)(3:16|17|49))(3:19|20|58))(5:22|53|23|40|(1:42)(2:43|44)))(2:27|28))(3:30|31|(1:33)(1:34))|35|55|36|(1:38)(3:39|40|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0096, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object execute(kotlin.jvm.functions.Function2<? super io.ktor.client.statement.HttpResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.statement.HttpStatement.C11531
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement.C11531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L64
            if (r2 == r7) goto L58
            if (r2 == r6) goto L47
            if (r2 == r5) goto L41
            if (r2 == r4) goto L38
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L38:
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> La5
            goto La4
        L41:
            java.lang.Object r10 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> La5
            goto L95
        L47:
            java.lang.Object r10 = r0.L$1
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L53
            goto L87
        L53:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L97
        L58:
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.util.concurrent.CancellationException -> La5
            goto L75
        L64:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> La5
            r0.L$1 = r10     // Catch: java.util.concurrent.CancellationException -> La5
            r0.label = r7     // Catch: java.util.concurrent.CancellationException -> La5
            java.lang.Object r11 = r9.executeUnsafe(r0)     // Catch: java.util.concurrent.CancellationException -> La5
            if (r11 != r1) goto L74
            return r1
        L74:
            r2 = r9
        L75:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11     // Catch: java.util.concurrent.CancellationException -> La5
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L96
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L96
            r0.label = r6     // Catch: java.lang.Throwable -> L96
            java.lang.Object r10 = r10.invoke(r11, r0)     // Catch: java.lang.Throwable -> L96
            if (r10 != r1) goto L84
            return r1
        L84:
            r8 = r11
            r11 = r10
            r10 = r8
        L87:
            r0.L$0 = r11     // Catch: java.util.concurrent.CancellationException -> La5
            r0.L$1 = r3     // Catch: java.util.concurrent.CancellationException -> La5
            r0.label = r5     // Catch: java.util.concurrent.CancellationException -> La5
            java.lang.Object r10 = r2.cleanup(r10, r0)     // Catch: java.util.concurrent.CancellationException -> La5
            if (r10 != r1) goto L94
            return r1
        L94:
            r10 = r11
        L95:
            return r10
        L96:
            r10 = move-exception
        L97:
            r0.L$0 = r10     // Catch: java.util.concurrent.CancellationException -> La5
            r0.L$1 = r3     // Catch: java.util.concurrent.CancellationException -> La5
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> La5
            java.lang.Object r11 = r2.cleanup(r11, r0)     // Catch: java.util.concurrent.CancellationException -> La5
            if (r11 != r1) goto La4
            return r1
        La4:
            throw r10     // Catch: java.util.concurrent.CancellationException -> La5
        La5:
            r10 = move-exception
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Throwable r10 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.execute(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HttpStatement.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.statement.HttpStatement$execute$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super HttpResponse>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
            return ((AnonymousClass4) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SavedCallKt.save(((HttpResponse) this.L$0).getCall(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((HttpClientCall) obj).getResponse();
        }
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return execute(new AnonymousClass4(null), continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) throws Throwable {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objExecuteUnsafe = executeUnsafe(null);
            InlineMarker.mark(1);
            HttpResponse httpResponse = (HttpResponse) objExecuteUnsafe;
            try {
                InlineMarker.mark(3);
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
                InlineMarker.mark(0);
                Object objBodyNullable = call.bodyNullable(typeInfoTypeInfoImpl, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                Object obj = objBodyNullable;
                return objBodyNullable;
            } finally {
                InlineMarker.finallyStart(1);
                HttpResponseKt.complete(httpResponse);
                InlineMarker.finallyEnd(1);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objExecuteUnsafe = executeUnsafe(null);
            InlineMarker.mark(1);
            HttpResponse httpResponse = (HttpResponse) objExecuteUnsafe;
            try {
                InlineMarker.mark(3);
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                Type javaType = TypesJVMKt.getJavaType((KType) null);
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                TypeInfo typeInfoTypeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null);
                InlineMarker.mark(0);
                Object objBodyNullable = call.bodyNullable(typeInfoTypeInfoImpl, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                Object obj = objBodyNullable;
                InlineMarker.mark(3);
                return function2.invoke(objBodyNullable, null);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                cleanup(httpResponse, null);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeUnsafe(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement.C11541
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = (io.ktor.client.statement.HttpStatement.C11541) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = new io.ktor.client.statement.HttpStatement$executeUnsafe$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.util.concurrent.CancellationException -> L52
            goto L4b
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L52
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L52
            io.ktor.client.request.HttpRequestBuilder r2 = r4.builder     // Catch: java.util.concurrent.CancellationException -> L52
            io.ktor.client.request.HttpRequestBuilder r5 = r5.takeFromWithExecutionContext(r2)     // Catch: java.util.concurrent.CancellationException -> L52
            io.ktor.client.HttpClient r2 = r4.client     // Catch: java.util.concurrent.CancellationException -> L52
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.Object r5 = r2.execute$ktor_client_core(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L52
            if (r5 != r1) goto L4b
            return r1
        L4b:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch: java.util.concurrent.CancellationException -> L52
            io.ktor.client.statement.HttpResponse r5 = r5.getResponse()     // Catch: java.util.concurrent.CancellationException -> L52
            return r5
        L52:
            r5 = move-exception
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Throwable r5 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.executeUnsafe(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cleanup(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CompletableJob r5 = (kotlinx.coroutines.CompletableJob) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5f
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.getContent()     // Catch: java.lang.Throwable -> L54
            io.ktor.utils.io.ByteReadChannelKt.cancel(r5)     // Catch: java.lang.Throwable -> L54
        L54:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r6.join(r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.cleanup(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkCapabilities() {
        Set setKeySet;
        Map map = (Map) this.builder.getAttributes().getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map == null || (setKeySet = map.keySet()) == null) {
            return;
        }
        ArrayList<HttpClientPlugin> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (obj instanceof HttpClientPlugin) {
                arrayList.add(obj);
            }
        }
        for (HttpClientPlugin httpClientPlugin : arrayList) {
            if (HttpClientPluginKt.pluginOrNull(this.client, httpClientPlugin) == null) {
                throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
            }
        }
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + AbstractJsonLexerKt.END_LIST;
    }
}
