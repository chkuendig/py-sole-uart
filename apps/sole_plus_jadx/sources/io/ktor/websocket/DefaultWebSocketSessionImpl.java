package io.ktor.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import io.ktor.http.ContentDisposition;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import org.objectweb.asm.Opcodes;

/* compiled from: DefaultWebSocketSession.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\b\u0000\u0018\u0000 e2\u00020g2\u00020\u0001:\u0001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J!\u0010,\u001a\u00020\f2\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\fH\u0017¢\u0006\u0004\b.\u0010 J\u000f\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101R\u001e\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020#0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001e\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\n0K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR$\u0010S\u001a\u00020/2\u0006\u0010O\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u00101\"\u0004\bQ\u0010RR$\u0010X\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010JR*\u0010^\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010U\"\u0004\ba\u0010WR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010bR*\u0010\u0005\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010_\u001a\u0004\bc\u0010U\"\u0004\bd\u0010W\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006f"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/WebSocketSession;", SdkConstants.FD_RES_RAW, "", "pingInterval", "timeoutMillis", SdkConstants.CONSTRUCTOR_NAME, "(Lio/ktor/websocket/WebSocketSession;JJ)V", "Lio/ktor/utils/io/core/BytePacketBuilder;", "packet", "Lio/ktor/websocket/Frame;", TypedValues.AttributesType.S_FRAME, "", "checkMaxFrameSize", "(Lio/ktor/utils/io/core/BytePacketBuilder;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "message", "goingAway", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outgoingProcessorLoop", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "runIncomingProcessor", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "runOrCancelPinger", "()V", "runOutgoingProcessor", "()Lkotlinx/coroutines/Job;", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "start", "(Ljava/util/List;)V", "terminate", "", "tryClose", "()Z", "", "_extensions", "Ljava/util/List;", "Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableJob;", SdkConstants.ATTR_CONTEXT, "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "value", "getMasking", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "outgoingToBeProcessed", "newValue", "pingIntervalMillis", "J", "getPingIntervalMillis", "setPingIntervalMillis", "Lio/ktor/websocket/WebSocketSession;", "getTimeoutMillis", "setTimeoutMillis", "Companion", "ktor-websockets", "Lio/ktor/websocket/DefaultWebSocketSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Deferred<CloseReason> closeReason;
    private final CompletableDeferred<CloseReason> closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Channel<Frame> filtered;
    private final Channel<Frame> outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "started");

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0}, l = {320}, m = "checkMaxFrameSize", n = {ContentDisposition.Parameters.Size}, s = {"I$0"})
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.checkMaxFrameSize(null, null, this);
        }
    }

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 2}, l = {245, 249, 259}, m = "outgoingProcessorLoop", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1, reason: invalid class name and case insensitive filesystem */
    static final class C12761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12761(Continuation<? super C12761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.outgoingProcessorLoop(this);
        }
    }

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", i = {0, 0, 0}, l = {274}, m = "sendCloseSequence", n = {"this", "exception", "reasonToSend"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1, reason: invalid class name and case insensitive filesystem */
    static final class C12791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12791(Continuation<? super C12791> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.sendCloseSequence(null, null, this);
        }
    }

    public DefaultWebSocketSessionImpl(WebSocketSession raw, long j, long j2) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.raw = raw;
        this.pinger = null;
        CompletableDeferred<CloseReason> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.closeReasonRef = completableDeferredCompletableDeferred$default;
        this.filtered = ChannelKt.Channel$default(8, null, null, 6, null);
        this.outgoingToBeProcessed = ChannelKt.Channel$default(UtilsKt.getOUTGOING_CHANNEL_CAPACITY(), null, null, 6, null);
        this.closed = 0;
        CompletableJob completableJobJob = JobKt.Job((Job) raw.getCoroutineContext().get(Job.INSTANCE));
        this.context = completableJobJob;
        this._extensions = new ArrayList();
        this.started = 0;
        this.coroutineContext = raw.getCoroutineContext().plus(completableJobJob).plus(new CoroutineName("ws-default"));
        this.pingIntervalMillis = j;
        this.timeoutMillis = j2;
        this.closeReason = completableDeferredCompletableDeferred$default;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.raw.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.raw.setMasking(z);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.raw.setMaxFrameSize(j);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j) {
        this.pingIntervalMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j) {
        this.timeoutMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred<CloseReason> getCloseReason() {
        return this.closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        Intrinsics.checkNotNullParameter(negotiatedExtensions, "negotiatedExtensions");
        if (!started$FU.compareAndSet(this, 0, 1)) {
            throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
        }
        DefaultWebSocketSessionKt.getLOGGER().trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(negotiatedExtensions, null, null, null, 0, null, null, 63, null));
        this._extensions.addAll(negotiatedExtensions);
        runOrCancelPinger();
        runIncomingProcessor(PingPongKt.ponger(this, getOutgoing()));
        runOutgoingProcessor();
    }

    public static /* synthetic */ Object goingAway$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Server is going down";
        }
        return defaultWebSocketSessionImpl.goingAway(str, continuation);
    }

    public final Object goingAway(String str, Continuation<? super Unit> continuation) {
        Object objSendCloseSequence$default = sendCloseSequence$default(this, new CloseReason(CloseReason.Codes.GOING_AWAY, str), null, continuation, 2, null);
        return objSendCloseSequence$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCloseSequence$default : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        Object objFlush = this.raw.flush(continuation);
        return objFlush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlush : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use cancel() instead.", replaceWith = @ReplaceWith(expression = "cancel()", imports = {"kotlinx.coroutines.cancel"}))
    public void terminate() {
        Job.DefaultImpls.cancel$default((Job) this.context, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(this.raw, null, 1, null);
    }

    private final Job runIncomingProcessor(SendChannel<? super Frame.Ping> ponger) {
        return BuildersKt__Builders_commonKt.launch$default(this, DefaultWebSocketSessionKt.IncomingProcessorCoroutineName.plus(Dispatchers.getUnconfined()), null, new C12771(ponger, null), 2, null);
    }

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", i = {0, 0, 0, 0, 1, 1, 1, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6}, l = {345, Opcodes.LOOKUPSWITCH, 219, Opcodes.RETURN, Opcodes.GETSTATIC, 180, 204, 219, 219, 219, 219}, m = "invokeSuspend", n = {"$this$launch", "last", "closeFramePresented", "$this$consume$iv$iv", "last", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "last", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "last", "closeFramePresented", "$this$consume$iv$iv", "$this$launch", "last", "closeFramePresented", "$this$consume$iv$iv", TypedValues.AttributesType.S_FRAME, "$this$launch", "last", "closeFramePresented", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$5", "L$0", "L$1", "L$2", "L$5", "L$0", "L$1", "L$2", "L$5", "L$7", "L$0", "L$1", "L$2", "L$5"})
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1, reason: invalid class name and case insensitive filesystem */
    static final class C12771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SendChannel<Frame.Ping> $ponger;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12771(SendChannel<? super Frame.Ping> sendChannel, Continuation<? super C12771> continuation) {
            super(2, continuation);
            this.$ponger = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12771 c12771 = DefaultWebSocketSessionImpl.this.new C12771(this.$ponger, continuation);
            c12771.L$0 = obj;
            return c12771;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:151:0x0316, code lost:
        
            r13 = r11.element;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
            io.ktor.utils.io.core.OutputKt.writeFully$default((io.ktor.utils.io.core.Output) r13, r0.getData(), 0, 0, 6, (java.lang.Object) null);
            r0 = r12;
            r12 = r4;
            r29 = r11;
            r11 = r6;
            r6 = r7;
            r7 = r9;
            r9 = r10;
            r10 = r29;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0139 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x014c A[Catch: all -> 0x00f9, TryCatch #2 {all -> 0x00f9, blocks: (B:9:0x0041, B:34:0x0121, B:38:0x0144, B:40:0x014c, B:42:0x017a, B:44:0x0184, B:46:0x0192, B:47:0x0196, B:50:0x01b1, B:61:0x01ff, B:63:0x0203, B:65:0x0209, B:68:0x0221, B:69:0x0224, B:71:0x0228, B:75:0x024c, B:97:0x0319, B:17:0x0090, B:20:0x00b2, B:24:0x00d0, B:27:0x00f2, B:33:0x011c), top: B:146:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0279 A[Catch: all -> 0x006d, TryCatch #4 {all -> 0x006d, blocks: (B:79:0x0273, B:81:0x0279, B:83:0x027d, B:84:0x0285, B:85:0x02a9, B:87:0x02af, B:91:0x02e8, B:12:0x0067), top: B:147:0x0067 }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x02a9 A[Catch: all -> 0x006d, TryCatch #4 {all -> 0x006d, blocks: (B:79:0x0273, B:81:0x0279, B:83:0x027d, B:84:0x0285, B:85:0x02a9, B:87:0x02af, B:91:0x02e8, B:12:0x0067), top: B:147:0x0067 }] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0319 A[Catch: all -> 0x00f9, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00f9, blocks: (B:9:0x0041, B:34:0x0121, B:38:0x0144, B:40:0x014c, B:42:0x017a, B:44:0x0184, B:46:0x0192, B:47:0x0196, B:50:0x01b1, B:61:0x01ff, B:63:0x0203, B:65:0x0209, B:68:0x0221, B:69:0x0224, B:71:0x0228, B:75:0x024c, B:97:0x0319, B:17:0x0090, B:20:0x00b2, B:24:0x00d0, B:27:0x00f2, B:33:0x011c), top: B:146:0x000c }] */
        /* JADX WARN: Type inference failed for: r13v9, types: [T, io.ktor.utils.io.core.BytePacketBuilder] */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object, kotlinx.coroutines.channels.SendChannel] */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v26 */
        /* JADX WARN: Type inference failed for: r7v28 */
        /* JADX WARN: Type inference failed for: r7v31 */
        /* JADX WARN: Type inference failed for: r7v32 */
        /* JADX WARN: Type inference failed for: r7v6, types: [kotlinx.coroutines.channels.SendChannel] */
        /* JADX WARN: Type inference failed for: r7v8, types: [kotlinx.coroutines.channels.SendChannel] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0207 -> B:74:0x0240). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x023d -> B:74:0x0240). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x030c -> B:95:0x0313). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1144
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.C12771.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Job runOutgoingProcessor() {
        return BuildersKt.launch(this, DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName.plus(Dispatchers.getUnconfined()), CoroutineStart.UNDISPATCHED, new C12781(null));
    }

    /* compiled from: DefaultWebSocketSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", i = {}, l = {WinError.ERROR_PIPE_LOCAL, 240, 240, 240, WinError.ERROR_PIPE_NOT_CONNECTED, 240, 240, 237, 240, 240}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, reason: invalid class name and case insensitive filesystem */
    static final class C12781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C12781(Continuation<? super C12781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultWebSocketSessionImpl.this.new C12781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0061 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 376
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.C12781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00da -> B:19:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object outgoingProcessorLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.outgoingProcessorLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendCloseSequence(io.ktor.websocket.CloseReason r6, java.lang.Throwable r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl.C12791
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl.C12791) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r6 = r0.L$2
            io.ktor.websocket.CloseReason r6 = (io.ktor.websocket.CloseReason) r6
            java.lang.Object r7 = r0.L$1
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Object r0 = r0.L$0
            io.ktor.websocket.DefaultWebSocketSessionImpl r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L37
            goto Lb2
        L37:
            r8 = move-exception
            goto Lc8
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r5.tryClose()
            if (r8 != 0) goto L4e
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L4e:
            org.slf4j.Logger r8 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Sending Close Sequence for session "
            r2.<init>(r4)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r4 = " with reason "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r4 = " and exception "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            r8.trace(r2)
            kotlinx.coroutines.CompletableJob r8 = r5.context
            r8.complete()
            if (r6 != 0) goto L88
            io.ktor.websocket.CloseReason r6 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r8 = io.ktor.websocket.CloseReason.Codes.NORMAL
            java.lang.String r2 = ""
            r6.<init>(r8, r2)
        L88:
            r5.runOrCancelPinger()     // Catch: java.lang.Throwable -> Lc6
            short r8 = r6.getCode()     // Catch: java.lang.Throwable -> Lc6
            io.ktor.websocket.CloseReason$Codes r2 = io.ktor.websocket.CloseReason.Codes.CLOSED_ABNORMALLY     // Catch: java.lang.Throwable -> Lc6
            short r2 = r2.getCode()     // Catch: java.lang.Throwable -> Lc6
            if (r8 == r2) goto Lb1
            io.ktor.websocket.WebSocketSession r8 = r5.raw     // Catch: java.lang.Throwable -> Lc6
            kotlinx.coroutines.channels.SendChannel r8 = r8.getOutgoing()     // Catch: java.lang.Throwable -> Lc6
            io.ktor.websocket.Frame$Close r2 = new io.ktor.websocket.Frame$Close     // Catch: java.lang.Throwable -> Lc6
            r2.<init>(r6)     // Catch: java.lang.Throwable -> Lc6
            r0.L$0 = r5     // Catch: java.lang.Throwable -> Lc6
            r0.L$1 = r7     // Catch: java.lang.Throwable -> Lc6
            r0.L$2 = r6     // Catch: java.lang.Throwable -> Lc6
            r0.label = r3     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r8 = r8.send(r2, r0)     // Catch: java.lang.Throwable -> Lc6
            if (r8 != r1) goto Lb1
            return r1
        Lb1:
            r0 = r5
        Lb2:
            kotlinx.coroutines.CompletableDeferred<io.ktor.websocket.CloseReason> r8 = r0.closeReasonRef
            r8.complete(r6)
            if (r7 == 0) goto Lc3
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame> r6 = r0.outgoingToBeProcessed
            r6.close(r7)
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame> r6 = r0.filtered
            r6.close(r7)
        Lc3:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        Lc6:
            r8 = move-exception
            r0 = r5
        Lc8:
            kotlinx.coroutines.CompletableDeferred<io.ktor.websocket.CloseReason> r1 = r0.closeReasonRef
            r1.complete(r6)
            if (r7 == 0) goto Ld9
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame> r6 = r0.outgoingToBeProcessed
            r6.close(r7)
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame> r6 = r0.filtered
            r6.close(r7)
        Ld9:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.sendCloseSequence(io.ktor.websocket.CloseReason, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, continuation);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    private final void runOrCancelPinger() {
        long pingIntervalMillis = getPingIntervalMillis();
        SendChannel<Frame.Pong> sendChannelPinger = (this.closed == 0 && pingIntervalMillis > 0) ? PingPongKt.pinger(this, this.raw.getOutgoing(), pingIntervalMillis, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null)) : null;
        SendChannel sendChannel = (SendChannel) pinger$FU.getAndSet(this, sendChannelPinger);
        if (sendChannel != null) {
            SendChannel.DefaultImpls.close$default(sendChannel, null, 1, null);
        }
        if (sendChannelPinger != null) {
            ChannelResult.m10611isSuccessimpl(sendChannelPinger.mo10590trySendJP2dKIU(EmptyPong));
        }
        if (this.closed == 0 || sendChannelPinger == null) {
            return;
        }
        runOrCancelPinger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkMaxFrameSize(io.ktor.utils.io.core.BytePacketBuilder r9, io.ktor.websocket.Frame r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws io.ktor.websocket.FrameTooBigException {
        /*
            r8 = this;
            boolean r0 = r11 instanceof io.ktor.websocket.DefaultWebSocketSessionImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = (io.ktor.websocket.DefaultWebSocketSessionImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r0 = new io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 == r3) goto L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2e:
            int r9 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L86
        L34:
            kotlin.ResultKt.throwOnFailure(r11)
            byte[] r10 = r10.getData()
            int r10 = r10.length
            if (r9 == 0) goto L43
            int r11 = r9.getSize()
            goto L44
        L43:
            r11 = 0
        L44:
            int r10 = r10 + r11
            long r4 = (long) r10
            long r6 = r8.getMaxFrameSize()
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 <= 0) goto L8d
            if (r9 == 0) goto L53
            r9.release()
        L53:
            r9 = r8
            io.ktor.websocket.WebSocketSession r9 = (io.ktor.websocket.WebSocketSession) r9
            io.ktor.websocket.CloseReason r11 = new io.ktor.websocket.CloseReason
            io.ktor.websocket.CloseReason$Codes r2 = io.ktor.websocket.CloseReason.Codes.TOO_BIG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Frame is too big: "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r5 = ". Max size is "
            java.lang.StringBuilder r4 = r4.append(r5)
            long r5 = r8.getMaxFrameSize()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r11.<init>(r2, r4)
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r9 = io.ktor.websocket.WebSocketSessionKt.close(r9, r11, r0)
            if (r9 != r1) goto L85
            return r1
        L85:
            r9 = r10
        L86:
            io.ktor.websocket.FrameTooBigException r10 = new io.ktor.websocket.FrameTooBigException
            long r0 = (long) r9
            r10.<init>(r0)
            throw r10
        L8d:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.checkMaxFrameSize(io.ktor.utils.io.core.BytePacketBuilder, io.ktor.websocket.Frame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processIncomingFrame(frame);
        }
        return frame;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processOutgoingFrame(frame);
        }
        return frame;
    }
}
