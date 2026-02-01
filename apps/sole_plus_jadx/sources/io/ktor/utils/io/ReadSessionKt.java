package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.ranges.RangesKt;
import org.objectweb.asm.Opcodes;

/* compiled from: ReadSession.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001ao\u0010\b\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00062K\u0010\n\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000bH\u0086Hø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0002H\u0082\b\u001a\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u00020\u0019*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001f\u0010\u001a\u001a\u0004\u0018\u00010\u0004*\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"completeReadingFromBuffer", "", "Lio/ktor/utils/io/ByteReadChannel;", "buffer", "Lio/ktor/utils/io/core/Buffer;", "bytesRead", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", "desiredSize", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "source", "", "start", "endExclusive", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readSessionFor", "Lio/ktor/utils/io/SuspendableReadSession;", "requestBuffer", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBufferFallback", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestBufferSuspend", "(Lio/ktor/utils/io/SuspendableReadSession;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReadSessionKt {

    /* compiled from: ReadSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    @DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0, 0, 1, 1, 1, 2}, l = {23, 27, 30}, m = "read", n = {"$this$read", "block", "$this$read", "buffer", "bytesRead", "cause"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0"})
    /* renamed from: io.ktor.utils.io.ReadSessionKt$read$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadSessionKt.read(null, 0, null, this);
        }
    }

    /* compiled from: ReadSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {130}, m = "requestBufferFallback", n = {"chunk"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1, reason: invalid class name and case insensitive filesystem */
    static final class C12651 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12651(Continuation<? super C12651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadSessionKt.requestBufferFallback(null, 0, this);
        }
    }

    /* compiled from: ReadSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {123}, m = "requestBufferSuspend", n = {"$this$requestBufferSuspend"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12661(Continuation<? super C12661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadSessionKt.requestBufferSuspend(null, 0, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r8, int r9, kotlin.jvm.functions.Function3<? super io.ktor.utils.io.bits.Memory, ? super java.lang.Long, ? super java.lang.Long, java.lang.Integer> r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ReadSessionKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ReadSessionKt$read$1 r0 = (io.ktor.utils.io.ReadSessionKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ReadSessionKt$read$1 r0 = new io.ktor.utils.io.ReadSessionKt$read$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L4e
            if (r2 == r4) goto L3d
            if (r2 == r3) goto L34
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc5
        L3d:
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L4b
            goto Lad
        L4b:
            r8 = move-exception
            goto Lb6
        L4e:
            java.lang.Object r8 = r0.L$1
            r10 = r8
            kotlin.jvm.functions.Function3 r10 = (kotlin.jvm.functions.Function3) r10
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6b
        L5b:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r11 = requestBuffer(r8, r9, r0)
            if (r11 != r1) goto L6b
            return r1
        L6b:
            io.ktor.utils.io.core.Buffer r11 = (io.ktor.utils.io.core.Buffer) r11
            if (r11 != 0) goto L76
            io.ktor.utils.io.core.Buffer$Companion r9 = io.ktor.utils.io.core.Buffer.INSTANCE
            io.ktor.utils.io.core.Buffer r9 = r9.getEmpty()
            goto L77
        L76:
            r9 = r11
        L77:
            java.nio.ByteBuffer r11 = r9.getMemory()     // Catch: java.lang.Throwable -> Lb2
            io.ktor.utils.io.bits.Memory r11 = io.ktor.utils.io.bits.Memory.m8811boximpl(r11)     // Catch: java.lang.Throwable -> Lb2
            int r2 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lb2
            long r5 = (long) r2     // Catch: java.lang.Throwable -> Lb2
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)     // Catch: java.lang.Throwable -> Lb2
            int r5 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lb2
            long r5 = (long) r5     // Catch: java.lang.Throwable -> Lb2
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Object r10 = r10.invoke(r11, r2, r5)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Number r10 = (java.lang.Number) r10     // Catch: java.lang.Throwable -> Lb2
            int r10 = r10.intValue()     // Catch: java.lang.Throwable -> Lb2
            r0.L$0 = r8     // Catch: java.lang.Throwable -> Lb2
            r0.L$1 = r9     // Catch: java.lang.Throwable -> Lb2
            r0.I$0 = r10     // Catch: java.lang.Throwable -> Lb2
            r0.label = r4     // Catch: java.lang.Throwable -> Lb2
            java.lang.Object r11 = completeReadingFromBuffer(r8, r9, r10, r0)     // Catch: java.lang.Throwable -> Lb2
            if (r11 != r1) goto Laa
            return r1
        Laa:
            r7 = r10
            r10 = r8
            r8 = r7
        Lad:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)     // Catch: java.lang.Throwable -> L4b
            return r8
        Lb2:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r7
        Lb6:
            r0.L$0 = r8
            r11 = 0
            r0.L$1 = r11
            r0.label = r3
            r11 = 0
            java.lang.Object r9 = completeReadingFromBuffer(r10, r9, r11, r0)
            if (r9 != r1) goto Lc5
            return r1
        Lc5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.read(io.ktor.utils.io.ByteReadChannel, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i, Function3<? super Memory, ? super Long, ? super Long, Integer> function3, Continuation<? super Integer> continuation) {
        InlineMarker.mark(0);
        Object objRequestBuffer = requestBuffer(byteReadChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer empty = (Buffer) objRequestBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        try {
            int iIntValue = function3.invoke(Memory.m8811boximpl(empty.getMemory()), Long.valueOf(empty.getReadPosition()), Long.valueOf(empty.getWritePosition())).intValue();
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, iIntValue, continuation);
            InlineMarker.mark(1);
            return Integer.valueOf(iIntValue);
        } catch (Throwable th) {
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, 0, continuation);
            InlineMarker.mark(1);
            throw th;
        }
    }

    public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        InlineMarker.mark(0);
        Object objRequestBuffer = requestBuffer(byteReadChannel, i, continuation);
        InlineMarker.mark(1);
        Buffer empty = (Buffer) objRequestBuffer;
        if (empty == null) {
            empty = Buffer.INSTANCE.getEmpty();
        }
        try {
            int iIntValue = ((Number) function3.invoke(Memory.m8811boximpl(empty.getMemory()), Long.valueOf(empty.getReadPosition()), Long.valueOf(empty.getWritePosition()))).intValue();
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, iIntValue, continuation);
            InlineMarker.mark(1);
            return Integer.valueOf(iIntValue);
        } catch (Throwable th) {
            InlineMarker.mark(0);
            completeReadingFromBuffer(byteReadChannel, empty, 0, continuation);
            InlineMarker.mark(1);
            throw th;
        }
    }

    public static final Object requestBuffer(ByteReadChannel byteReadChannel, int i, Continuation<? super Buffer> continuation) {
        SuspendableReadSession suspendableReadSessionStartReadSession;
        if (byteReadChannel instanceof SuspendableReadSession) {
            suspendableReadSessionStartReadSession = (SuspendableReadSession) byteReadChannel;
        } else {
            suspendableReadSessionStartReadSession = byteReadChannel instanceof HasReadSession ? ((HasReadSession) byteReadChannel).startReadSession() : null;
        }
        if (suspendableReadSessionStartReadSession != null) {
            ChunkBuffer chunkBufferRequest = suspendableReadSessionStartReadSession.request(RangesKt.coerceAtMost(i, 8));
            return chunkBufferRequest != null ? chunkBufferRequest : requestBufferSuspend(suspendableReadSessionStartReadSession, i, continuation);
        }
        return requestBufferFallback(byteReadChannel, i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestBufferSuspend(io.ktor.utils.io.SuspendableReadSession r4, int r5, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.Buffer> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ReadSessionKt.C12661
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = (io.ktor.utils.io.ReadSessionKt.C12661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1 r0 = new io.ktor.utils.io.ReadSessionKt$requestBufferSuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.SuspendableReadSession r4 = (io.ktor.utils.io.SuspendableReadSession) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.await(r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            io.ktor.utils.io.core.internal.ChunkBuffer r4 = r4.request(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.requestBufferSuspend(io.ktor.utils.io.SuspendableReadSession, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object requestBufferFallback(io.ktor.utils.io.ByteReadChannel r15, int r16, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.internal.ChunkBuffer> r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof io.ktor.utils.io.ReadSessionKt.C12651
            if (r1 == 0) goto L16
            r1 = r0
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r1 = (io.ktor.utils.io.ReadSessionKt.C12651) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1 r1 = new io.ktor.utils.io.ReadSessionKt$requestBufferFallback$1
            r1.<init>(r0)
        L1b:
            r12 = r1
            java.lang.Object r0 = r12.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r12.L$0
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = (io.ktor.utils.io.core.internal.ChunkBuffer) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L74
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r0 = io.ktor.utils.io.core.internal.ChunkBuffer.INSTANCE
            io.ktor.utils.io.pool.ObjectPool r0 = r0.getPool()
            java.lang.Object r0 = r0.borrow()
            io.ktor.utils.io.core.internal.ChunkBuffer r0 = (io.ktor.utils.io.core.internal.ChunkBuffer) r0
            java.nio.ByteBuffer r4 = r0.getMemory()
            int r2 = r0.getWritePosition()
            long r5 = (long) r2
            r2 = r16
            long r8 = (long) r2
            r2 = r0
            io.ktor.utils.io.core.Buffer r2 = (io.ktor.utils.io.core.Buffer) r2
            int r7 = r2.getLimit()
            int r2 = r2.getWritePosition()
            int r7 = r7 - r2
            long r10 = (long) r7
            r12.L$0 = r0
            r12.label = r3
            r13 = 0
            r2 = r15
            r3 = r4
            r4 = r5
            r6 = r13
            java.lang.Object r2 = r2.mo8801peekTolBXzO7A(r3, r4, r6, r8, r10, r12)
            if (r2 != r1) goto L72
            return r1
        L72:
            r1 = r0
            r0 = r2
        L74:
            java.lang.Number r0 = (java.lang.Number) r0
            long r2 = r0.longValue()
            int r0 = (int) r2
            r1.commitWritten(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ReadSessionKt.requestBufferFallback(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final SuspendableReadSession readSessionFor(ByteReadChannel byteReadChannel) {
        if (byteReadChannel instanceof HasReadSession) {
            return ((HasReadSession) byteReadChannel).startReadSession();
        }
        return null;
    }

    public static final Object completeReadingFromBuffer(ByteReadChannel byteReadChannel, Buffer buffer, int i, Continuation<? super Unit> continuation) {
        if (i < 0) {
            throw new IllegalStateException(("bytesRead shouldn't be negative: " + i).toString());
        }
        boolean z = byteReadChannel instanceof HasReadSession;
        SuspendableReadSession suspendableReadSessionStartReadSession = z ? ((HasReadSession) byteReadChannel).startReadSession() : null;
        if (suspendableReadSessionStartReadSession != null) {
            suspendableReadSessionStartReadSession.discard(i);
            if (z) {
                ((HasReadSession) byteReadChannel).endReadSession();
            }
            return Unit.INSTANCE;
        }
        if ((buffer instanceof ChunkBuffer) && buffer != ChunkBuffer.INSTANCE.getEmpty()) {
            ((ChunkBuffer) buffer).release(ChunkBuffer.INSTANCE.getPool());
            Object objDiscard = byteReadChannel.discard(i, continuation);
            return objDiscard == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDiscard : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
