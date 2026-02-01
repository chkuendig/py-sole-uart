package io.ktor.utils.io.internal;

import com.android.SdkConstants;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.samsung.android.sdk.healthdata.HealthConstants;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WriteSessionImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0001\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0019\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/utils/io/internal/WriteSessionImpl;", "Lio/ktor/utils/io/WriterSuspendSession;", "channel", "Lio/ktor/utils/io/ByteBufferChannel;", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "byteBuffer", "Ljava/nio/ByteBuffer;", IInstrumentationResultParser.StatusKeys.CURRENT, SdkConstants.ATTR_LOCKED, "", "ringBufferCapacity", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "view", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "begin", "", "complete", "flush", "request", HealthConstants.HeartRate.MIN, "tryAwait", "n", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitJoinSwitch", "written", "writtenFailed", "", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WriteSessionImpl implements WriterSuspendSession {
    private ByteBuffer byteBuffer;
    private ByteBufferChannel current;
    private int locked;
    private RingBufferCapacity ringBufferCapacity;
    private ChunkBuffer view;

    /* compiled from: WriteSessionImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.WriteSessionImpl", f = "WriteSessionImpl.kt", i = {0}, l = {86}, m = "tryAwaitJoinSwitch", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WriteSessionImpl.this.tryAwaitJoinSwitch(0, this);
        }
    }

    public WriteSessionImpl(ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.current = channel.resolveChannelInstance$ktor_io();
        this.byteBuffer = ChunkBuffer.INSTANCE.getEmpty().getMemory();
        this.view = ChunkBuffer.INSTANCE.getEmpty();
        this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    }

    public final void begin() {
        ByteBufferChannel byteBufferChannelResolveChannelInstance$ktor_io = this.current.resolveChannelInstance$ktor_io();
        this.current = byteBufferChannelResolveChannelInstance$ktor_io;
        ByteBuffer byteBuffer = byteBufferChannelResolveChannelInstance$ktor_io.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return;
        }
        this.byteBuffer = byteBuffer;
        ChunkBuffer chunkBufferChunkBuffer$default = BufferUtilsJvmKt.ChunkBuffer$default(this.current.currentState$ktor_io().backingBuffer, null, 2, null);
        this.view = chunkBufferChunkBuffer$default;
        BufferUtilsJvmKt.resetFromContentToWrite(chunkBufferChunkBuffer$default, this.byteBuffer);
        this.ringBufferCapacity = this.current.currentState$ktor_io().capacity;
    }

    public final void complete() {
        int i = this.locked;
        if (i > 0) {
            this.ringBufferCapacity.completeRead(i);
            this.locked = 0;
        }
        this.current.restoreStateAfterWrite$ktor_io();
        this.current.tryTerminate$ktor_io();
    }

    @Override // io.ktor.utils.io.WriterSession
    public ChunkBuffer request(int min) {
        int iTryWriteAtLeast = this.locked + this.ringBufferCapacity.tryWriteAtLeast(0);
        this.locked = iTryWriteAtLeast;
        if (iTryWriteAtLeast < min) {
            return null;
        }
        this.current.prepareWriteBuffer$ktor_io(this.byteBuffer, iTryWriteAtLeast);
        if (this.byteBuffer.remaining() < min) {
            return null;
        }
        BufferUtilsJvmKt.resetFromContentToWrite(this.view, this.byteBuffer);
        return this.view;
    }

    @Override // io.ktor.utils.io.WriterSession
    public void written(int n) {
        int i;
        if (n < 0 || n > (i = this.locked)) {
            writtenFailed(n);
            throw new KotlinNothingValueException();
        }
        this.locked = i - n;
        this.current.bytesWrittenFromSession$ktor_io(this.byteBuffer, this.ringBufferCapacity, n);
    }

    private final Void writtenFailed(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Written bytes count shouldn't be negative: " + n);
        }
        throw new IllegalStateException("Unable to mark " + n + " bytes as written: only " + this.locked + " were pre-locked.");
    }

    @Override // io.ktor.utils.io.WriterSuspendSession
    public Object tryAwait(int i, Continuation<? super Unit> continuation) throws Throwable {
        if (this.current.getJoining() != null) {
            Object objTryAwaitJoinSwitch = tryAwaitJoinSwitch(i, continuation);
            return objTryAwaitJoinSwitch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTryAwaitJoinSwitch : Unit.INSTANCE;
        }
        int i2 = this.locked;
        if (i2 >= i) {
            return Unit.INSTANCE;
        }
        if (i2 > 0) {
            this.ringBufferCapacity.completeRead(i2);
            this.locked = 0;
        }
        Object objTryWriteSuspend$ktor_io = this.current.tryWriteSuspend$ktor_io(i, continuation);
        return objTryWriteSuspend$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTryWriteSuspend$ktor_io : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryAwaitJoinSwitch(int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.internal.WriteSessionImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = (io.ktor.utils.io.internal.WriteSessionImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = new io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r5 = (io.ktor.utils.io.internal.WriteSessionImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L60
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r4.locked
            if (r6 <= 0) goto L45
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r4.ringBufferCapacity
            r2.completeRead(r6)
            r6 = 0
            r4.locked = r6
        L45:
            r4.flush()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r6.tryTerminate$ktor_io()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.current
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.tryWriteSuspend$ktor_io(r5, r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            r5 = r4
        L60:
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.ByteBufferChannel r6 = r6.resolveChannelInstance$ktor_io()
            r5.current = r6
            java.nio.ByteBuffer r6 = r6.setupStateForWrite$ktor_io()
            if (r6 != 0) goto L6f
            goto L90
        L6f:
            r5.byteBuffer = r6
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            java.nio.ByteBuffer r6 = r6.backingBuffer
            r0 = 2
            r1 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.BufferUtilsJvmKt.ChunkBuffer$default(r6, r1, r0, r1)
            r5.view = r6
            java.nio.ByteBuffer r0 = r5.byteBuffer
            io.ktor.utils.io.core.BufferUtilsJvmKt.resetFromContentToWrite(r6, r0)
            io.ktor.utils.io.ByteBufferChannel r6 = r5.current
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r6.currentState$ktor_io()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.capacity
            r5.ringBufferCapacity = r6
        L90:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.WriteSessionImpl.tryAwaitJoinSwitch(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.WriterSession
    public void flush() {
        this.current.flush();
    }
}
