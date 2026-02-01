package io.ktor.websocket;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WebSocketWriter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.WebSocketWriter$writeLoopJob$1", f = "WebSocketWriter.kt", i = {0, 0}, l = {40}, m = "invokeSuspend", n = {"$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
final class WebSocketWriter$writeLoopJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WebSocketWriter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebSocketWriter$writeLoopJob$1(WebSocketWriter webSocketWriter, Continuation<? super WebSocketWriter$writeLoopJob$1> continuation) {
        super(2, continuation);
        this.this$0 = webSocketWriter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketWriter$writeLoopJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebSocketWriter$writeLoopJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ObjectPool pool;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pool = this.this$0.getPool();
            WebSocketWriter webSocketWriter = this.this$0;
            Object objBorrow = pool.borrow();
            try {
                this.L$0 = pool;
                this.L$1 = objBorrow;
                this.label = 1;
                if (webSocketWriter.writeLoop((ByteBuffer) objBorrow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objBorrow;
            } catch (Throwable th) {
                th = th;
                obj2 = objBorrow;
                pool.recycle(obj2);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = this.L$1;
            pool = (ObjectPool) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                pool.recycle(obj2);
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        pool.recycle(obj2);
        return Unit.INSTANCE;
    }
}
