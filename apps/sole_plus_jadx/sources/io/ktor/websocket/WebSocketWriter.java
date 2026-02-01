package io.ktor.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: WebSocketWriter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00010B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\"\u001a\u00020#H\u0007J\b\u0010$\u001a\u00020#H\u0002J!\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020#2\u0006\u0010'\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lio/ktor/websocket/WebSocketWriter;", "Lkotlinx/coroutines/CoroutineScope;", "writeChannel", "Lio/ktor/utils/io/ByteWriteChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "masking", "", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;ZLio/ktor/utils/io/pool/ObjectPool;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getMasking", "()Z", "setMasking", "(Z)V", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "queue", "Lkotlinx/coroutines/channels/Channel;", "", "serializer", "Lio/ktor/websocket/Serializer;", "writeLoopJob", "Lkotlinx/coroutines/Job;", "getWriteLoopJob$annotations", "()V", "close", "", "drainQueueAndDiscard", "drainQueueAndSerialize", "firstMsg", "buffer", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "send", TypedValues.AttributesType.S_FRAME, "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FlushRequest", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WebSocketWriter implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private boolean masking;
    private final ObjectPool<ByteBuffer> pool;
    private final Channel<Object> queue;
    private final Serializer serializer;
    private final ByteWriteChannel writeChannel;
    private final Job writeLoopJob;

    /* compiled from: WebSocketWriter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 0, 0}, l = {121}, m = "drainQueueAndSerialize", n = {"this", "buffer", "flush", "closeSent"}, s = {"L$0", "L$1", "L$2", "I$0"})
    /* renamed from: io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return WebSocketWriter.this.drainQueueAndSerialize(null, null, this);
        }
    }

    /* compiled from: WebSocketWriter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0}, l = {155, 158, 163}, m = "flush", n = {"this", "it"}, s = {"L$0", "L$2"})
    /* renamed from: io.ktor.websocket.WebSocketWriter$flush$1, reason: invalid class name and case insensitive filesystem */
    static final class C12841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12841(Continuation<? super C12841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketWriter.this.flush(this);
        }
    }

    /* compiled from: WebSocketWriter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", i = {0, 0, 1, 1}, l = {46, 48}, m = "writeLoop", n = {"this", "buffer", "this", "buffer"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: io.ktor.websocket.WebSocketWriter$writeLoop$1, reason: invalid class name and case insensitive filesystem */
    static final class C12851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12851(Continuation<? super C12851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketWriter.this.writeLoop(null, this);
        }
    }

    private static /* synthetic */ void getWriteLoopJob$annotations() {
    }

    public WebSocketWriter(ByteWriteChannel writeChannel, CoroutineContext coroutineContext, boolean z, ObjectPool<ByteBuffer> pool) {
        Intrinsics.checkNotNullParameter(writeChannel, "writeChannel");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.writeChannel = writeChannel;
        this.coroutineContext = coroutineContext;
        this.masking = z;
        this.pool = pool;
        this.queue = ChannelKt.Channel$default(8, null, null, 6, null);
        this.serializer = new Serializer();
        this.writeLoopJob = BuildersKt.launch(this, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new WebSocketWriter$writeLoopJob$1(this, null));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public /* synthetic */ WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteWriteChannel, coroutineContext, (i & 4) != 0 ? false : z, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }

    public final ObjectPool<ByteBuffer> getPool() {
        return this.pool;
    }

    public final SendChannel<Frame> getOutgoing() {
        return this.queue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b A[Catch: all -> 0x005d, ChannelWriteException -> 0x0060, TryCatch #4 {ChannelWriteException -> 0x0060, all -> 0x005d, blocks: (B:13:0x0038, B:39:0x00a4, B:28:0x0070, B:32:0x0083, B:34:0x008b, B:36:0x0093, B:43:0x00b0, B:45:0x00b4, B:46:0x00ba, B:47:0x00d2, B:18:0x0055), top: B:62:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:39:0x00a4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b4 -> B:42:0x00ad). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeLoop(java.nio.ByteBuffer r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.writeLoop(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
    
        throw new java.lang.IllegalArgumentException("unknown message " + r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drainQueueAndDiscard() {
        /*
            r4 = this;
            kotlinx.coroutines.channels.Channel<java.lang.Object> r0 = r4.queue
            kotlinx.coroutines.channels.SendChannel r0 = (kotlinx.coroutines.channels.SendChannel) r0
            r1 = 0
            r2 = 1
            kotlinx.coroutines.channels.SendChannel.DefaultImpls.close$default(r0, r1, r2, r1)
        L9:
            kotlinx.coroutines.channels.Channel<java.lang.Object> r0 = r4.queue     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.Object r0 = r0.mo10595tryReceivePtdJZtk()     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.Object r0 = kotlinx.coroutines.channels.ChannelResult.m10606getOrNullimpl(r0)     // Catch: java.util.concurrent.CancellationException -> L52
            if (r0 != 0) goto L16
            goto L52
        L16:
            boolean r1 = r0 instanceof io.ktor.websocket.Frame.Close     // Catch: java.util.concurrent.CancellationException -> L52
            if (r1 != 0) goto L9
            boolean r1 = r0 instanceof io.ktor.websocket.Frame.Ping     // Catch: java.util.concurrent.CancellationException -> L52
            if (r1 == 0) goto L20
            r1 = r2
            goto L22
        L20:
            boolean r1 = r0 instanceof io.ktor.websocket.Frame.Pong     // Catch: java.util.concurrent.CancellationException -> L52
        L22:
            if (r1 != 0) goto L9
            boolean r1 = r0 instanceof io.ktor.websocket.WebSocketWriter.FlushRequest     // Catch: java.util.concurrent.CancellationException -> L52
            if (r1 == 0) goto L2e
            io.ktor.websocket.WebSocketWriter$FlushRequest r0 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r0     // Catch: java.util.concurrent.CancellationException -> L52
            r0.complete()     // Catch: java.util.concurrent.CancellationException -> L52
            goto L9
        L2e:
            boolean r1 = r0 instanceof io.ktor.websocket.Frame.Text     // Catch: java.util.concurrent.CancellationException -> L52
            if (r1 == 0) goto L34
            r1 = r2
            goto L36
        L34:
            boolean r1 = r0 instanceof io.ktor.websocket.Frame.Binary     // Catch: java.util.concurrent.CancellationException -> L52
        L36:
            if (r1 == 0) goto L39
            goto L9
        L39:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.util.concurrent.CancellationException -> L52
            r2.<init>()     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.String r3 = "unknown message "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.util.concurrent.CancellationException -> L52
            java.lang.String r0 = r0.toString()     // Catch: java.util.concurrent.CancellationException -> L52
            r1.<init>(r0)     // Catch: java.util.concurrent.CancellationException -> L52
            throw r1     // Catch: java.util.concurrent.CancellationException -> L52
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.drainQueueAndDiscard():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:16:0x0056
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:62:0x011c, B:63:0x011e], limit reached: 77 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r5v14, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f7 -> B:53:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object drainQueueAndSerialize(io.ktor.websocket.Frame r8, java.nio.ByteBuffer r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.drainQueueAndSerialize(io.ktor.websocket.Frame, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object send(Frame frame, Continuation<? super Unit> continuation) {
        Object objSend = this.queue.send(frame, continuation);
        return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, io.ktor.websocket.WebSocketWriter$FlushRequest] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object flush(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.websocket.WebSocketWriter.C12841
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = (io.ktor.websocket.WebSocketWriter.C12841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.websocket.WebSocketWriter$flush$1 r0 = new io.ktor.websocket.WebSocketWriter$flush$1
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
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L95
        L42:
            java.lang.Object r2 = r0.L$2
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r2
            java.lang.Object r5 = r0.L$1
            io.ktor.websocket.WebSocketWriter$FlushRequest r5 = (io.ktor.websocket.WebSocketWriter.FlushRequest) r5
            java.lang.Object r7 = r0.L$0
            io.ktor.websocket.WebSocketWriter r7 = (io.ktor.websocket.WebSocketWriter) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L80
            goto L96
        L52:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.websocket.WebSocketWriter$FlushRequest r2 = new io.ktor.websocket.WebSocketWriter$FlushRequest
            kotlin.coroutines.CoroutineContext r9 = r8.getCoroutineContext()
            kotlinx.coroutines.Job$Key r7 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r7 = (kotlin.coroutines.CoroutineContext.Key) r7
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r7)
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            r2.<init>(r9)
            kotlinx.coroutines.channels.Channel<java.lang.Object> r9 = r8.queue     // Catch: java.lang.Throwable -> L79 kotlinx.coroutines.channels.ClosedSendChannelException -> L7e
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
            kotlinx.coroutines.Job r9 = r7.writeLoopJob
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.flush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed")
    public final void close() {
        SendChannel.DefaultImpls.close$default(this.queue, null, 1, null);
    }

    /* compiled from: WebSocketWriter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lio/ktor/websocket/WebSocketWriter$FlushRequest;", "", SdkConstants.ATTR_PARENT, "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "done", "Lkotlinx/coroutines/CompletableJob;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FlushRequest {
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
