package io.ktor.client.engine.okhttp;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ActorScope;
import okhttp3.Request;

/* compiled from: OkHttpWebsocketSession.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lio/ktor/websocket/Frame;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1", f = "OkHttpWebsocketSession.kt", i = {0, 1, 1}, l = {62, 66}, m = "invokeSuspend", n = {"$this$actor", "websocket", "closeReason"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes6.dex */
final class OkHttpWebsocketSession$outgoing$1 extends SuspendLambda implements Function2<ActorScope<Frame>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $engineRequest;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OkHttpWebsocketSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OkHttpWebsocketSession$outgoing$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation<? super OkHttpWebsocketSession$outgoing$1> continuation) {
        super(2, continuation);
        this.this$0 = okHttpWebsocketSession;
        this.$engineRequest = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpWebsocketSession$outgoing$1 okHttpWebsocketSession$outgoing$1 = new OkHttpWebsocketSession$outgoing$1(this.this$0, this.$engineRequest, continuation);
        okHttpWebsocketSession$outgoing$1.L$0 = obj;
        return okHttpWebsocketSession$outgoing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ActorScope<Frame> actorScope, Continuation<? super Unit> continuation) {
        return ((OkHttpWebsocketSession$outgoing$1) create(actorScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091 A[Catch: all -> 0x001e, TryCatch #4 {all -> 0x001e, blocks: (B:7:0x001a, B:24:0x0089, B:26:0x0091, B:28:0x009b, B:21:0x0077, B:29:0x00af, B:31:0x00b3, B:32:0x00c2, B:34:0x00c6, B:37:0x00d6, B:43:0x00e9, B:44:0x00ee), top: B:66:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0086 -> B:24:0x0089). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
