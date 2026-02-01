package io.ktor.client.plugins;

import com.sun.jna.platform.win32.WinError;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$intercept$1", f = "HttpRequestRetry.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {WinError.ERROR_TOO_MANY_POSTS, 314}, m = "invokeSuspend", n = {"$this$intercept", "request", "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "subRequest", "retryCount", "maxRetries", "$this$intercept", "request", "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "lastRetryData", "retryCount", "maxRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
/* loaded from: classes6.dex */
final class HttpRequestRetry$intercept$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ HttpClient $client;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ HttpRequestRetry this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpRequestRetry$intercept$1(HttpRequestRetry httpRequestRetry, HttpClient httpClient, Continuation<? super HttpRequestRetry$intercept$1> continuation) {
        super(3, continuation);
        this.this$0 = httpRequestRetry;
        this.$client = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRequestRetry$intercept$1 httpRequestRetry$intercept$1 = new HttpRequestRetry$intercept$1(this.this$0, this.$client, continuation);
        httpRequestRetry$intercept$1.L$0 = sender;
        httpRequestRetry$intercept$1.L$1 = httpRequestBuilder;
        return httpRequestRetry$intercept$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x010d A[Catch: all -> 0x0078, TRY_ENTER, TryCatch #0 {all -> 0x0078, blocks: (B:34:0x010d, B:35:0x0121, B:38:0x013f, B:41:0x014a, B:11:0x0071), top: B:51:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0149 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014a A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #0 {all -> 0x0078, blocks: (B:34:0x010d, B:35:0x0121, B:38:0x013f, B:41:0x014a, B:11:0x0071), top: B:51:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ce A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01cc -> B:7:0x0034). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestRetry$intercept$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
