package io.ktor.websocket;

import androidx.collection.SieveCacheKt;
import com.android.SdkConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.websocket.WebSocketSession;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: RawWebSocketCommon.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00014B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u00100\u001a\u000201H\u0096@ø\u0001\u0000¢\u0006\u0002\u00102J\b\u00103\u001a\u000201H\u0017R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "input", "Lio/ktor/utils/io/ByteReadChannel;", "output", "Lio/ktor/utils/io/ByteWriteChannel;", "maxFrameSize", "", "masking", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;)V", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_outgoing", "", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "extensions", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "incoming", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "lastOpcode", "", "getMasking", "()Z", "setMasking", "(Z)V", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "readerJob", "Lkotlinx/coroutines/Job;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "writerJob", "flush", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RawWebSocketCommon implements WebSocketSession {
    private final Channel<Frame> _incoming;
    private final Channel<Object> _outgoing;
    private final CoroutineContext coroutineContext;
    private final ByteReadChannel input;
    private int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    private final ByteWriteChannel output;
    private final Job readerJob;
    private final CompletableJob socketJob;
    private final Job writerJob;

    /* compiled from: RawWebSocketCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon", f = "RawWebSocketCommon.kt", i = {0, 0}, l = {123, 126, 131}, m = "flush", n = {"this", "it"}, s = {"L$0", "L$2"})
    /* renamed from: io.ktor.websocket.RawWebSocketCommon$flush$1, reason: invalid class name */
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
            return RawWebSocketCommon.this.flush(this);
        }
    }

    public RawWebSocketCommon(ByteReadChannel input, ByteWriteChannel output, long j, boolean z, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.input = input;
        this.output = output;
        this.maxFrameSize = j;
        this.masking = z;
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        this.socketJob = completableJobJob;
        this._incoming = ChannelKt.Channel$default(8, null, null, 6, null);
        this._outgoing = ChannelKt.Channel$default(8, null, null, 6, null);
        this.coroutineContext = coroutineContext.plus(completableJobJob).plus(new CoroutineName("raw-ws"));
        RawWebSocketCommon rawWebSocketCommon = this;
        this.writerJob = BuildersKt.launch(rawWebSocketCommon, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new RawWebSocketCommon$writerJob$1(this, null));
        this.readerJob = BuildersKt.launch(rawWebSocketCommon, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new RawWebSocketCommon$readerJob$1(this, null));
        completableJobJob.complete();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return WebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? SieveCacheKt.NodeLinkMask : j, (i & 8) != 0 ? false : z, coroutineContext);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.masking;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking = z;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, io.ktor.websocket.RawWebSocketCommon$FlushRequest] */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object flush(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.RawWebSocketCommon.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = (io.ktor.websocket.RawWebSocketCommon.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.websocket.RawWebSocketCommon$flush$1 r0 = new io.ktor.websocket.RawWebSocketCommon$flush$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L52
            if (r2 == r5) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.throwOnFailure(r9)
            goto La5
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            java.lang.Object r2 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L95
        L42:
            java.lang.Object r2 = r0.L$2
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r2
            java.lang.Object r5 = r0.L$1
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r5 = (io.ktor.websocket.RawWebSocketCommon.FlushRequest) r5
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.RawWebSocketCommon r7 = (io.ktor.websocket.RawWebSocketCommon) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L80
            goto L96
        L52:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.websocket.RawWebSocketCommon$FlushRequest r2 = new io.ktor.websocket.RawWebSocketCommon$FlushRequest
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r7 = (kotlin.coroutines.CoroutineContext.Key) r7
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r7)
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            r2.<init>(r9)
            kotlinx.coroutines.channels.Channel<java.lang.Object> r9 = r8._outgoing     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
            r0.label = r5     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
            java.lang.Object r9 = r9.send(r2, r0)     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
            if (r9 != r1) goto L95
            return r1
        L79:
            r9 = move-exception
            r2.complete()
            throw r9
        L7e:
            r7 = r8
            r5 = r2
        L80:
            r2.complete()
            kotlinx.coroutines.Job r9 = r7.writerJob
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r9 = r9.join(r0)
            if (r9 != r1) goto L94
            return r1
        L94:
            r2 = r5
        L95:
            r5 = r2
        L96:
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r9 = r5.await(r0)
            if (r9 != r1) goto La5
            return r1
        La5:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.flush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        SendChannel.DefaultImpls.close$default(getOutgoing(), null, 1, null);
        this.socketJob.complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RawWebSocketCommon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", SdkConstants.ATTR_PARENT, "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "done", "Lkotlinx/coroutines/CompletableJob;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job job) {
            this.done = JobKt.Job(job);
        }

        public final boolean complete() {
            return this.done.complete();
        }

        public final Object await(Continuation<? super Unit> continuation) {
            Object objJoin = this.done.join(continuation);
            return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
        }
    }
}
