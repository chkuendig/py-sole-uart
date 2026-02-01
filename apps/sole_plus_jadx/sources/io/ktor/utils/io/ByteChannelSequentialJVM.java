package io.ktor.utils.io;

import com.android.SdkConstants;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.sun.jna.platform.win32.WinError;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* compiled from: ByteChannelSequentialJVM.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0011\u0010\f\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002H\u000f0\u0011¢\u0006\u0002\b\u0013H\u0017¢\u0006\u0002\u0010\u0014J@\u0010\u0015\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0016¢\u0006\u0002\b\u0013H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J$\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010&\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J!\u0010'\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0002J-\u0010-\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010.\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J$\u0010.\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0\u0011H\u0016J\u0019\u0010/\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u00101\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u00102\u001a\u00020\n2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0011H\u0096@ø\u0001\u0000¢\u0006\u0002\u00103R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM;", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "initial", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "autoFlush", "", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Z)V", "attachedJob", "Lkotlinx/coroutines/Job;", "attachJob", "", "job", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lookAhead", "R", "visitor", "Lkotlin/Function1;", "Lio/ktor/utils/io/LookAheadSession;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lookAheadSuspend", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "read", HealthConstants.HeartRate.MIN, "", "consumer", "Ljava/nio/ByteBuffer;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "dst", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "readAvailableSuspend", "readFully", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReadAvailable", "tryWriteAvailable", "src", "write", "writeAvailable", "writeAvailableSuspend", "writeFully", "writeFullySuspend", "writeWhile", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", RtspHeaders.SESSION, "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteChannelSequentialJVM extends ByteChannelSequentialBase {
    private volatile Job attachedJob;

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {195}, m = "read", n = {"this", "consumer", HealthConstants.HeartRate.MIN}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$read$1, reason: invalid class name and case insensitive filesystem */
    static final class C12451 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12451(Continuation<? super C12451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.read(0, null, this);
        }
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {111, 112}, m = "readAvailableSuspend", n = {"this", "dst"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12461(Continuation<? super C12461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.readAvailableSuspend(null, this);
        }
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {127}, m = "readFullySuspend", n = {"this", "dst", "count"}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12471 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12471(Continuation<? super C12471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.readFullySuspend((ByteBuffer) null, 0, this);
        }
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {WinError.ERROR_PIPE_NOT_CONNECTED}, m = "write", n = {"this", "block", HealthConstants.HeartRate.MIN}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$write$1, reason: invalid class name and case insensitive filesystem */
    static final class C12481 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12481(Continuation<? super C12481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.write(0, null, this);
        }
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {40, 41}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12491(Continuation<? super C12491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.writeAvailableSuspend((ByteBuffer) null, this);
        }
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {53}, m = "writeFullySuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12501(Continuation<? super C12501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.writeFullySuspend(null, this);
        }
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {245}, m = "writeWhile", n = {"this", "block", "shouldContinue"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1, reason: invalid class name and case insensitive filesystem */
    static final class C12511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12511(Continuation<? super C12511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialJVM.this.writeWhile(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM(ChunkBuffer initial, boolean z) {
        super(initial, z, null, 4, null);
        Intrinsics.checkNotNullParameter(initial, "initial");
    }

    @Override // io.ktor.utils.io.ByteChannel
    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.ByteChannelSequentialJVM.attachJob.1
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
                ByteChannelSequentialJVM.this.attachedJob = null;
                if (th != null) {
                    ByteChannelSequentialJVM.this.cancel(ExceptionUtilsKt.unwrapCancellationException(th));
                }
            }
        }, 2, null);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int iTryWriteAvailable = tryWriteAvailable(byteBuffer);
        if (iTryWriteAvailable <= 0) {
            if (byteBuffer.hasRemaining()) {
                return writeAvailableSuspend(byteBuffer, continuation);
            }
            iTryWriteAvailable = 0;
        }
        return Boxing.boxInt(iTryWriteAvailable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM.C12491
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM.C12491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeAvailableSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.writeAvailable(r6, r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.writeAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) throws Throwable {
        Object objWriteFullySuspend;
        tryWriteAvailable(byteBuffer);
        return (byteBuffer.hasRemaining() && (objWriteFullySuspend = writeFullySuspend(byteBuffer, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWriteFullySuspend : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004e -> B:20:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFullySuspend(java.nio.ByteBuffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialJVM.C12501
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM.C12501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeFullySuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L51
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r4
        L3e:
            boolean r6 = r5.hasRemaining()
            if (r6 == 0) goto L59
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r2.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            int r6 = r2.tryWriteAvailable(r5)
            r2.afterWrite(r6)
            goto L3e
        L59:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.writeFullySuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int tryWriteAvailable(java.nio.ByteBuffer r4) throws java.lang.Throwable {
        /*
            r3 = this;
            int r0 = r4.remaining()
            int r1 = r3.getAvailableForWrite()
            boolean r2 = r3.getClosed()
            if (r2 == 0) goto L1e
            java.lang.Throwable r4 = r3.getClosedCause()
            if (r4 != 0) goto L1d
            kotlinx.coroutines.channels.ClosedSendChannelException r4 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r0 = "Channel closed for write"
            r4.<init>(r0)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L1d:
            throw r4
        L1e:
            r2 = 0
            if (r0 != 0) goto L23
        L21:
            r0 = r2
            goto L4b
        L23:
            if (r0 > r1) goto L2f
            io.ktor.utils.io.core.BytePacketBuilder r1 = r3.getWritable()
            io.ktor.utils.io.core.Output r1 = (io.ktor.utils.io.core.Output) r1
            io.ktor.utils.io.core.OutputArraysJVMKt.writeFully(r1, r4)
            goto L4b
        L2f:
            if (r1 != 0) goto L32
            goto L21
        L32:
            int r0 = r4.limit()
            int r2 = r4.position()
            int r2 = r2 + r1
            r4.limit(r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r3.getWritable()
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputArraysJVMKt.writeFully(r2, r4)
            r4.limit(r0)
            r0 = r1
        L4b:
            r3.afterWrite(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.tryWriteAvailable(java.nio.ByteBuffer):int");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int iTryReadAvailable = tryReadAvailable(byteBuffer);
        if (iTryReadAvailable != 0) {
            return Boxing.boxInt(iTryReadAvailable);
        }
        return !byteBuffer.hasRemaining() ? Boxing.boxInt(0) : readAvailableSuspend(byteBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public int readAvailable(int min, Function1<? super ByteBuffer, Unit> block) throws Throwable {
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (get_availableForRead() < min) {
            return -1;
        }
        prepareFlushedBytes();
        ByteReadPacket readable = getReadable();
        ChunkBuffer chunkBufferPrepareRead = readable.prepareRead(min);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(min);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition2, writePosition);
            int iPosition = byteBufferM8822slice87lwejk.position();
            block.invoke(byteBufferM8822slice87lwejk);
            int iPosition2 = byteBufferM8822slice87lwejk.position() - iPosition;
            if (byteBufferM8822slice87lwejk.limit() != writePosition) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM8822slice87lwejk.position());
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                readable.ensureNext(chunkBufferPrepareRead);
            } else {
                readable.setHeadPosition(readPosition3);
            }
            return iPosition2;
        } catch (Throwable th) {
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                readable.ensureNext(chunkBufferPrepareRead);
            } else {
                readable.setHeadPosition(readPosition4);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM.C12461
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM.C12461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readAvailableSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.await(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L60
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L60:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable(r6, r0)
            if (r7 != r1) goto L6e
            return r1
        L6e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.readAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) throws Throwable {
        int iTryReadAvailable = tryReadAvailable(byteBuffer);
        if (iTryReadAvailable != -1) {
            return !byteBuffer.hasRemaining() ? Boxing.boxInt(iTryReadAvailable) : readFullySuspend(byteBuffer, iTryReadAvailable, continuation);
        }
        throw new EOFException("Channel closed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0055 -> B:20:0x0058). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(java.nio.ByteBuffer r8, int r9, kotlin.coroutines.Continuation<? super java.lang.Integer> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteChannelSequentialJVM.C12471
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM.C12471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$readFullySuspend$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r2 = (io.ktor.utils.io.ByteChannelSequentialJVM) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r9
            r9 = r8
            r8 = r6
            goto L58
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r7
        L43:
            boolean r10 = r8.hasRemaining()
            if (r10 == 0) goto L77
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r9
            r0.label = r3
            java.lang.Object r10 = r2.await(r3, r0)
            if (r10 != r1) goto L58
            return r1
        L58:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            java.lang.String r4 = "Channel closed"
            if (r10 == 0) goto L71
            int r10 = r2.tryReadAvailable(r8)
            r5 = -1
            if (r10 == r5) goto L6b
            int r9 = r9 + r10
            goto L43
        L6b:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r4)
            throw r8
        L71:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r4)
            throw r8
        L77:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.readFullySuspend(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int tryReadAvailable(ByteBuffer dst) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (getClosed() && get_availableForRead() == 0) {
            return -1;
        }
        if (!getReadable().canRead()) {
            prepareFlushedBytes();
        }
        int available = ByteBuffersKt.readAvailable(getReadable(), dst);
        afterRead(available);
        return available;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read { } instead.")
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> visitor) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.invoke(new Session(this));
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read { } instead.")
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return function2.invoke(new Session(this), continuation);
    }

    /* compiled from: ByteChannelSequentialJVM.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialJVM$Session;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "channel", "Lio/ktor/utils/io/ByteChannelSequentialJVM;", "(Lio/ktor/utils/io/ByteChannelSequentialJVM;)V", "awaitAtLeast", "", "n", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "", "request", "Ljava/nio/ByteBuffer;", SdkConstants.TAG_SKIP, "atLeast", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Session implements LookAheadSuspendSession {
        private final ByteChannelSequentialJVM channel;

        public Session(ByteChannelSequentialJVM channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        @Override // io.ktor.utils.io.LookAheadSuspendSession
        public Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) throws Throwable {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return this.channel.await(i, continuation);
        }

        @Override // io.ktor.utils.io.LookAheadSession
        /* renamed from: consumed */
        public void mo9078consumed(int n) throws Throwable {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            this.channel.discard(n);
        }

        @Override // io.ktor.utils.io.LookAheadSession
        public ByteBuffer request(int skip, int atLeast) throws Throwable {
            Throwable closedCause = this.channel.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            if (this.channel.isClosedForRead()) {
                return null;
            }
            if (this.channel.getReadable().getEndOfInput()) {
                this.channel.prepareFlushedBytes();
            }
            ChunkBuffer head = this.channel.getReadable().getHead();
            ChunkBuffer chunkBuffer = head;
            if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() < atLeast + skip) {
                return null;
            }
            ByteBuffer byteBufferSlice = head.getMemory().slice();
            byteBufferSlice.position(head.getReadPosition() + skip);
            byteBufferSlice.limit(head.getWritePosition());
            return byteBufferSlice;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object read(int r7, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.read(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        Object objAwait = await(1, continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public int writeAvailable(int min, Function1<? super ByteBuffer, Unit> block) throws Throwable {
        Intrinsics.checkNotNullParameter(block, "block");
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                throw new ClosedSendChannelException("Channel closed for write");
            }
            throw closedCause;
        }
        if (getAvailableForWrite() < min) {
            return 0;
        }
        BytePacketBuilder writable = getWritable();
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = writable.prepareWriteHead(min);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            int limit = chunkBufferPrepareWriteHead.getLimit() - writePosition;
            ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, writePosition, limit);
            int iPosition = byteBufferM8822slice87lwejk.position();
            block.invoke(byteBufferM8822slice87lwejk);
            int iPosition2 = byteBufferM8822slice87lwejk.position() - iPosition;
            if (byteBufferM8822slice87lwejk.limit() != limit) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int iPosition3 = byteBufferM8822slice87lwejk.position();
            chunkBufferPrepareWriteHead.commitWritten(iPosition3);
            if (iPosition3 >= 0) {
                return iPosition2;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            writable.afterHeadWrite();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object write(int r5, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialJVM.C12481
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM.C12481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$write$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$write$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r0 = (io.ktor.utils.io.ByteChannelSequentialJVM) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L65
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r4.getClosed()
            if (r7 == 0) goto L55
            java.lang.Throwable r5 = r4.getClosedCause()
            if (r5 != 0) goto L54
            kotlinx.coroutines.channels.ClosedSendChannelException r5 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r6 = "Channel closed for write"
            r5.<init>(r6)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
        L54:
            throw r5
        L55:
            r0.L$0 = r4
            r0.L$1 = r6
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r7 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r5, r0)
            if (r7 != r1) goto L64
            return r1
        L64:
            r0 = r4
        L65:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r0.getWritable()
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r7.prepareWriteHead(r5)
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch: java.lang.Throwable -> Lb5
            java.nio.ByteBuffer r1 = r5.getMemory()     // Catch: java.lang.Throwable -> Lb5
            int r2 = r5.getWritePosition()     // Catch: java.lang.Throwable -> Lb5
            int r3 = r5.getLimit()     // Catch: java.lang.Throwable -> Lb5
            int r3 = r3 - r2
            java.nio.ByteBuffer r1 = io.ktor.utils.io.bits.Memory.m8822slice87lwejk(r1, r2, r3)     // Catch: java.lang.Throwable -> Lb5
            r6.invoke(r1)     // Catch: java.lang.Throwable -> Lb5
            int r6 = r1.limit()     // Catch: java.lang.Throwable -> Lb5
            if (r6 != r3) goto La9
            int r6 = r1.position()     // Catch: java.lang.Throwable -> Lb5
            r5.commitWritten(r6)     // Catch: java.lang.Throwable -> Lb5
            if (r6 < 0) goto L9d
            r7.afterHeadWrite()
            r0.afterWrite(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L9d:
            java.lang.String r5 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb5
            r6.<init>(r5)     // Catch: java.lang.Throwable -> Lb5
            throw r6     // Catch: java.lang.Throwable -> Lb5
        La9:
            java.lang.String r5 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb5
            r6.<init>(r5)     // Catch: java.lang.Throwable -> Lb5
            throw r6     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r5 = move-exception
            r7.afterHeadWrite()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.write(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #0 {all -> 0x00cd, blocks: (B:26:0x0078, B:28:0x009d, B:35:0x00b5, B:36:0x00c0, B:37:0x00c1, B:38:0x00cc), top: B:42:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1 A[Catch: all -> 0x00cd, TryCatch #0 {all -> 0x00cd, blocks: (B:26:0x0078, B:28:0x009d, B:35:0x00b5, B:36:0x00c0, B:37:0x00c1, B:38:0x00cc), top: B:42:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006c -> B:25:0x006e). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.ByteWriteChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeWhile(kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialJVM.C12511
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = (io.ktor.utils.io.ByteChannelSequentialJVM.C12511) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1 r0 = new io.ktor.utils.io.ByteChannelSequentialJVM$writeWhile$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialJVM r4 = (io.ktor.utils.io.ByteChannelSequentialJVM) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6e
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r9
        L42:
            boolean r11 = r4.getClosed()
            if (r11 == 0) goto L58
            java.lang.Throwable r10 = r4.getClosedCause()
            if (r10 != 0) goto L57
            kotlinx.coroutines.channels.ClosedSendChannelException r10 = new kotlinx.coroutines.channels.ClosedSendChannelException
            java.lang.String r11 = "Channel closed for write"
            r10.<init>(r11)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
        L57:
            throw r10
        L58:
            kotlin.jvm.internal.Ref$BooleanRef r11 = new kotlin.jvm.internal.Ref$BooleanRef
            r11.<init>()
            r0.L$0 = r4
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r2 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r2 != r1) goto L6c
            return r1
        L6c:
            r2 = r10
            r10 = r11
        L6e:
            io.ktor.utils.io.core.BytePacketBuilder r11 = r4.getWritable()
            io.ktor.utils.io.core.Output r11 = (io.ktor.utils.io.core.Output) r11
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = r11.prepareWriteHead(r3)
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch: java.lang.Throwable -> Lcd
            java.nio.ByteBuffer r6 = r5.getMemory()     // Catch: java.lang.Throwable -> Lcd
            int r7 = r5.getWritePosition()     // Catch: java.lang.Throwable -> Lcd
            int r8 = r5.getLimit()     // Catch: java.lang.Throwable -> Lcd
            int r8 = r8 - r7
            java.nio.ByteBuffer r6 = io.ktor.utils.io.bits.Memory.m8822slice87lwejk(r6, r7, r8)     // Catch: java.lang.Throwable -> Lcd
            java.lang.Object r7 = r2.invoke(r6)     // Catch: java.lang.Throwable -> Lcd
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> Lcd
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> Lcd
            r10.element = r7     // Catch: java.lang.Throwable -> Lcd
            int r7 = r6.limit()     // Catch: java.lang.Throwable -> Lcd
            if (r7 != r8) goto Lc1
            int r6 = r6.position()     // Catch: java.lang.Throwable -> Lcd
            r5.commitWritten(r6)     // Catch: java.lang.Throwable -> Lcd
            if (r6 < 0) goto Lb5
            r11.afterHeadWrite()
            r4.afterWrite(r6)
            boolean r10 = r10.element
            if (r10 != 0) goto Lb3
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        Lb3:
            r10 = r2
            goto L42
        Lb5:
            java.lang.String r10 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lcd
            r0.<init>(r10)     // Catch: java.lang.Throwable -> Lcd
            throw r0     // Catch: java.lang.Throwable -> Lcd
        Lc1:
            java.lang.String r10 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lcd
            r0.<init>(r10)     // Catch: java.lang.Throwable -> Lcd
            throw r0     // Catch: java.lang.Throwable -> Lcd
        Lcd:
            r10 = move-exception
            r11.afterHeadWrite()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialJVM.writeWhile(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
