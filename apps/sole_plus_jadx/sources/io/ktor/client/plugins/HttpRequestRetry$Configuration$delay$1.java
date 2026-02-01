package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetry$Configuration$delay$1", f = "HttpRequestRetry.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HttpRequestRetry$Configuration$delay$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;

    HttpRequestRetry$Configuration$delay$1(Continuation<? super HttpRequestRetry$Configuration$delay$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HttpRequestRetry$Configuration$delay$1 httpRequestRetry$Configuration$delay$1 = new HttpRequestRetry$Configuration$delay$1(continuation);
        httpRequestRetry$Configuration$delay$1.J$0 = ((Number) obj).longValue();
        return httpRequestRetry$Configuration$delay$1;
    }

    public final Object invoke(long j, Continuation<? super Unit> continuation) {
        return ((HttpRequestRetry$Configuration$delay$1) create(Long.valueOf(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long l, Continuation<? super Unit> continuation) {
        return invoke(l.longValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.J$0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
