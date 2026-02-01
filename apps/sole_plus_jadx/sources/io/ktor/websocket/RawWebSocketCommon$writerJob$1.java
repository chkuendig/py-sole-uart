package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1}, l = {58, 60}, m = "invokeSuspend", n = {"message"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, TryCatch #1 {ChannelWriteException -> 0x0026, blocks: (B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, TryCatch #1 {ChannelWriteException -> 0x0026, blocks: (B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b A[Catch: all -> 0x0023, ChannelWriteException -> 0x0026, TryCatch #1 {ChannelWriteException -> 0x0026, blocks: (B:7:0x0013, B:27:0x0062, B:18:0x002c, B:21:0x0040, B:23:0x0044, B:30:0x007b, B:32:0x007f, B:33:0x0085, B:34:0x009d, B:29:0x006f, B:11:0x001f), top: B:49:0x000b, outer: #0 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0061 -> B:27:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x007f -> B:18:0x002c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
