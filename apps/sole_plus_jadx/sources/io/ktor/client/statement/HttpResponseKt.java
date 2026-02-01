package io.ktor.client.statement;

import io.ktor.client.request.HttpRequest;
import io.ktor.util.InternalAPI;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: HttpResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a#\u0010\b\u001a\u00020\t*\u00020\u00022\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"request", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "getRequest", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/request/HttpRequest;", "bodyAsChannel", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bodyAsText", "", "fallbackCharset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpResponseKt {

    /* compiled from: HttpResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {}, l = {97}, m = "bodyAsChannel", n = {}, s = {})
    /* renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1, reason: invalid class name */
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
            return HttpResponseKt.bodyAsChannel(null, this);
        }
    }

    /* compiled from: HttpResponse.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {0}, l = {97}, m = "bodyAsText", n = {"decoder"}, s = {"L$0"})
    /* renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsText$1, reason: invalid class name and case insensitive filesystem */
    static final class C11521 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11521(Continuation<? super C11521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsText(null, null, this);
        }
    }

    public static final HttpRequest getRequest(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        return httpResponse.getCall().getRequest();
    }

    @InternalAPI
    public static final void complete(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        CoroutineContext.Element element = httpResponse.getCoroutineContext().get(Job.INSTANCE);
        Intrinsics.checkNotNull(element);
        ((CompletableJob) element).complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object bodyAsText(io.ktor.client.statement.HttpResponse r5, java.nio.charset.Charset r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.client.statement.HttpResponseKt.C11521
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = (io.ktor.client.statement.HttpResponseKt.C11521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.nio.charset.CharsetDecoder r5 = (java.nio.charset.CharsetDecoder) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6c
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r5
            io.ktor.http.HttpMessage r7 = (io.ktor.http.HttpMessage) r7
            java.nio.charset.Charset r7 = io.ktor.http.HttpMessagePropertiesKt.charset(r7)
            if (r7 != 0) goto L43
            goto L44
        L43:
            r6 = r7
        L44:
            java.nio.charset.CharsetDecoder r6 = r6.newDecoder()
            io.ktor.client.call.HttpClientCall r5 = r5.getCall()
            java.lang.Class<io.ktor.utils.io.core.Input> r7 = io.ktor.utils.io.core.Input.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<io.ktor.utils.io.core.Input> r4 = io.ktor.utils.io.core.Input.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.bodyNullable(r7, r0)
            if (r7 != r1) goto L6b
            return r1
        L6b:
            r5 = r6
        L6c:
            if (r7 == 0) goto L7d
            io.ktor.utils.io.core.Input r7 = (io.ktor.utils.io.core.Input) r7
            java.lang.String r6 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = 2
            r0 = 0
            r1 = 0
            java.lang.String r5 = io.ktor.utils.io.charsets.EncodingKt.decode$default(r5, r7, r1, r6, r0)
            return r5
        L7d:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.core.Input"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsText(io.ktor.client.statement.HttpResponse, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object bodyAsText$default(HttpResponse httpResponse, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return bodyAsText(httpResponse, charset, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object bodyAsChannel(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super io.ktor.utils.io.ByteReadChannel> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpResponseKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1 r0 = (io.ktor.client.statement.HttpResponseKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.client.call.HttpClientCall r5 = r5.getCall()
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r6 = io.ktor.utils.io.ByteReadChannel.class
            kotlin.reflect.KType r6 = kotlin.jvm.internal.Reflection.typeOf(r6)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r6)
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r4 = io.ktor.utils.io.ByteReadChannel.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r6 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r6)
            r0.label = r3
            java.lang.Object r6 = r5.bodyNullable(r6, r0)
            if (r6 != r1) goto L56
            return r1
        L56:
            if (r6 == 0) goto L5b
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            return r6
        L5b:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsChannel(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
