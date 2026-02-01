package io.ktor.websocket;

import io.ktor.websocket.Frame;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: PingPong.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\\\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"PingerCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "PongerCoroutineName", "pinger", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Pong;", "Lkotlinx/coroutines/CoroutineScope;", "outgoing", "Lio/ktor/websocket/Frame;", "periodMillis", "", "timeoutMillis", "onTimeout", "Lkotlin/Function2;", "Lio/ktor/websocket/CloseReason;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;JJLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "ponger", "Lio/ktor/websocket/Frame$Ping;", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PingPongKt {
    private static final CoroutineName PongerCoroutineName = new CoroutineName("ws-ponger");
    private static final CoroutineName PingerCoroutineName = new CoroutineName("ws-pinger");

    public static final SendChannel<Frame.Ping> ponger(CoroutineScope coroutineScope, SendChannel<? super Frame.Pong> outgoing) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(outgoing, "outgoing");
        Channel channelChannel$default = ChannelKt.Channel$default(5, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, PongerCoroutineName, null, new C12801(channelChannel$default, outgoing, null), 2, null);
        return channelChannel$default;
    }

    /* compiled from: PingPong.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", i = {0, 1}, l = {119, 32}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$1", "L$1"})
    /* renamed from: io.ktor.websocket.PingPongKt$ponger$1, reason: invalid class name and case insensitive filesystem */
    static final class C12801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Frame.Ping> $channel;
        final /* synthetic */ SendChannel<Frame.Pong> $outgoing;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C12801(Channel<Frame.Ping> channel, SendChannel<? super Frame.Pong> sendChannel, Continuation<? super C12801> continuation) {
            super(2, continuation);
            this.$channel = channel;
            this.$outgoing = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C12801(this.$channel, this.$outgoing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0065 A[Catch: all -> 0x003a, TryCatch #2 {all -> 0x003a, blocks: (B:7:0x001b, B:20:0x004b, B:24:0x005d, B:26:0x0065, B:30:0x008e, B:12:0x0034, B:18:0x0046), top: B:42:0x0009, outer: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008e A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #2 {all -> 0x003a, blocks: (B:7:0x001b, B:20:0x004b, B:24:0x005d, B:26:0x0065, B:30:0x008e, B:12:0x0034, B:18:0x0046), top: B:42:0x0009, outer: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008c -> B:20:0x004b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 1
                r3 = 2
                r4 = 0
                if (r1 == 0) goto L3c
                if (r1 == r2) goto L28
                if (r1 != r3) goto L20
                java.lang.Object r1 = r11.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r11.L$1
                kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
                java.lang.Object r6 = r11.L$0
                kotlinx.coroutines.channels.SendChannel r6 = (kotlinx.coroutines.channels.SendChannel) r6
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L3a
                r12 = r6
                goto L4a
            L20:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L28:
                java.lang.Object r1 = r11.L$2
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r5 = r11.L$1
                kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
                java.lang.Object r6 = r11.L$0
                kotlinx.coroutines.channels.SendChannel r6 = (kotlinx.coroutines.channels.SendChannel) r6
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L3a
                r7 = r6
                r6 = r4
                goto L5d
            L3a:
                r12 = move-exception
                goto L94
            L3c:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Ping> r12 = r11.$channel     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L9a
                r5 = r12
                kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L9a
                kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame$Pong> r12 = r11.$outgoing     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L9a
                kotlinx.coroutines.channels.ChannelIterator r1 = r5.iterator()     // Catch: java.lang.Throwable -> L3a
            L4a:
                r6 = r4
            L4b:
                r11.L$0 = r12     // Catch: java.lang.Throwable -> L3a
                r11.L$1 = r5     // Catch: java.lang.Throwable -> L3a
                r11.L$2 = r1     // Catch: java.lang.Throwable -> L3a
                r11.label = r2     // Catch: java.lang.Throwable -> L3a
                java.lang.Object r7 = r1.hasNext(r11)     // Catch: java.lang.Throwable -> L3a
                if (r7 != r0) goto L5a
                return r0
            L5a:
                r10 = r7
                r7 = r12
                r12 = r10
            L5d:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L3a
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L3a
                if (r12 == 0) goto L8e
                java.lang.Object r12 = r1.next()     // Catch: java.lang.Throwable -> L3a
                io.ktor.websocket.Frame$Ping r12 = (io.ktor.websocket.Frame.Ping) r12     // Catch: java.lang.Throwable -> L3a
                org.slf4j.Logger r8 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()     // Catch: java.lang.Throwable -> L3a
                java.lang.String r9 = "Received ping message, sending pong message"
                r8.trace(r9)     // Catch: java.lang.Throwable -> L3a
                io.ktor.websocket.Frame$Pong r8 = new io.ktor.websocket.Frame$Pong     // Catch: java.lang.Throwable -> L3a
                byte[] r12 = r12.getData()     // Catch: java.lang.Throwable -> L3a
                r8.<init>(r12, r4, r3, r4)     // Catch: java.lang.Throwable -> L3a
                r11.L$0 = r7     // Catch: java.lang.Throwable -> L3a
                r11.L$1 = r5     // Catch: java.lang.Throwable -> L3a
                r11.L$2 = r1     // Catch: java.lang.Throwable -> L3a
                r11.label = r3     // Catch: java.lang.Throwable -> L3a
                java.lang.Object r12 = r7.send(r8, r11)     // Catch: java.lang.Throwable -> L3a
                if (r12 != r0) goto L8c
                return r0
            L8c:
                r12 = r7
                goto L4b
            L8e:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L3a
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r6)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L9a
                goto L9a
            L94:
                throw r12     // Catch: java.lang.Throwable -> L95
            L95:
                r0 = move-exception
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r12)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L9a
                throw r0     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L9a
            L9a:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt.C12801.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final SendChannel<Frame.Pong> pinger(CoroutineScope coroutineScope, SendChannel<? super Frame> outgoing, long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> onTimeout) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(outgoing, "outgoing");
        Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
        final CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        Channel channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, completableJobJob$default.plus(PingerCoroutineName), null, new AnonymousClass1(j, j2, onTimeout, channelChannel$default, outgoing, null), 2, null);
        CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.INSTANCE);
        Intrinsics.checkNotNull(element);
        ((Job) element).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.websocket.PingPongKt.pinger.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Job.DefaultImpls.cancel$default((Job) completableJobJob$default, (CancellationException) null, 1, (Object) null);
            }
        });
        return channelChannel$default;
    }

    /* compiled from: PingPong.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", i = {0, 0, 1, 1}, l = {64, 73, 95}, m = "invokeSuspend", n = {"random", "pingIdBytes", "random", "pingIdBytes"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: io.ktor.websocket.PingPongKt$pinger$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Frame.Pong> $channel;
        final /* synthetic */ Function2<CloseReason, Continuation<? super Unit>, Object> $onTimeout;
        final /* synthetic */ SendChannel<Frame> $outgoing;
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ long $timeoutMillis;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(long j, long j2, Function2<? super CloseReason, ? super Continuation<? super Unit>, ? extends Object> function2, Channel<Frame.Pong> channel, SendChannel<? super Frame> sendChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$periodMillis = j;
            this.$timeoutMillis = j2;
            this.$onTimeout = function2;
            this.$channel = channel;
            this.$outgoing = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x008b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00c9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ce A[Catch: CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, TRY_LEAVE, TryCatch #0 {CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00f1, blocks: (B:7:0x0012, B:12:0x0027, B:12:0x0027, B:12:0x0027, B:25:0x00ca, B:25:0x00ca, B:25:0x00ca, B:27:0x00ce, B:27:0x00ce, B:27:0x00ce, B:18:0x0071, B:18:0x0071, B:18:0x0071, B:22:0x008d, B:22:0x008d, B:22:0x008d, B:15:0x0034, B:15:0x0034, B:15:0x0034), top: B:34:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ef  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c7 -> B:25:0x00ca). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 244
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: PingPong.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$1", f = "PingPong.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: io.ktor.websocket.PingPongKt$pinger$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Channel<Frame.Pong> $channel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02701(Channel<Frame.Pong> channel, Continuation<? super C02701> continuation) {
                super(2, continuation);
                this.$channel = channel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02701(this.$channel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0 && i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                do {
                    this.label = 1;
                } while (this.$channel.receive(this) != coroutine_suspended);
                return coroutine_suspended;
            }
        }
    }
}
