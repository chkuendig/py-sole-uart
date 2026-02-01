package io.ktor.websocket;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: Serializer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0004J \u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\f\u0010#\u001a\u00020\u0004*\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lio/ktor/websocket/Serializer;", "", "()V", "frameBody", "Ljava/nio/ByteBuffer;", "hasOutstandingBytes", "", "getHasOutstandingBytes", "()Z", "lastDataFrameType", "Lio/ktor/websocket/FrameType;", "maskBuffer", "masking", "getMasking", "setMasking", "(Z)V", "messages", "Ljava/util/concurrent/ArrayBlockingQueue;", "Lio/ktor/websocket/Frame;", "remainingCapacity", "", "getRemainingCapacity", "()I", "enqueue", "", "f", "estimateFrameHeaderSize", "mask", "maskSize", "serialize", "buffer", "serializeHeader", TypedValues.AttributesType.S_FRAME, "setMaskBuffer", "writeCurrentPayload", "maskedIfNeeded", "ktor-websockets"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Serializer {
    private ByteBuffer frameBody;
    private FrameType lastDataFrameType;
    private ByteBuffer maskBuffer;
    private boolean masking;
    private final ArrayBlockingQueue<Frame> messages = new ArrayBlockingQueue<>(1024);

    private final int maskSize(boolean mask) {
        return mask ? 4 : 0;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public final boolean getHasOutstandingBytes() {
        return (this.messages.isEmpty() && this.frameBody == null) ? false : true;
    }

    public final int getRemainingCapacity() {
        return this.messages.remainingCapacity();
    }

    public final void enqueue(Frame f) throws InterruptedException {
        Intrinsics.checkNotNullParameter(f, "f");
        this.messages.put(f);
    }

    public final void serialize(ByteBuffer buffer) {
        Frame framePeek;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        while (writeCurrentPayload(buffer) && (framePeek = this.messages.peek()) != null) {
            boolean z = this.masking;
            setMaskBuffer(z);
            if (buffer.remaining() < estimateFrameHeaderSize(framePeek, z)) {
                return;
            }
            serializeHeader(framePeek, buffer, z);
            this.messages.remove();
            this.frameBody = maskedIfNeeded(framePeek.getBuffer());
        }
    }

    private final void serializeHeader(Frame frame, ByteBuffer buffer, boolean mask) {
        int opcode;
        ByteBuffer byteBufferDuplicate;
        int iRemaining = frame.getBuffer().remaining();
        if (iRemaining >= 126) {
            iRemaining = iRemaining <= 65535 ? 126 : 127;
        }
        FrameType frameType = this.lastDataFrameType;
        if (frameType == null) {
            if (!frame.getFin()) {
                this.lastDataFrameType = frame.getFrameType();
            }
            opcode = frame.getFrameType().getOpcode();
        } else if (frameType == frame.getFrameType()) {
            if (frame.getFin()) {
                this.lastDataFrameType = null;
            }
            opcode = 0;
        } else {
            if (!frame.getFrameType().getControlFrame()) {
                throw new IllegalStateException("Can't continue with different data frame opcode");
            }
            opcode = frame.getFrameType().getOpcode();
        }
        buffer.put((byte) (opcode | (frame.getFin() ? 128 : 0) | (frame.getRsv1() ? 64 : 0) | (frame.getRsv2() ? 32 : 0) | (frame.getRsv3() ? 16 : 0)));
        buffer.put((byte) ((mask ? 128 : 0) | iRemaining));
        if (iRemaining == 126) {
            buffer.putShort((short) frame.getBuffer().remaining());
        } else if (iRemaining == 127) {
            buffer.putLong(frame.getBuffer().remaining());
        }
        ByteBuffer byteBuffer = this.maskBuffer;
        if (byteBuffer == null || (byteBufferDuplicate = byteBuffer.duplicate()) == null) {
            return;
        }
        NIOKt.moveTo$default(byteBufferDuplicate, buffer, 0, 2, null);
    }

    private final int estimateFrameHeaderSize(Frame f, boolean mask) {
        int iRemaining = f.getBuffer().remaining();
        return (iRemaining < 126 ? 2 : iRemaining <= 32767 ? 4 : 10) + maskSize(mask);
    }

    private final boolean writeCurrentPayload(ByteBuffer buffer) {
        ByteBuffer byteBuffer = this.frameBody;
        if (byteBuffer == null) {
            return true;
        }
        NIOKt.moveTo$default(byteBuffer, buffer, 0, 2, null);
        if (byteBuffer.hasRemaining()) {
            return false;
        }
        this.frameBody = null;
        return true;
    }

    private final ByteBuffer maskedIfNeeded(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.maskBuffer;
        if (byteBuffer2 == null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferCopy$default = NIOKt.copy$default(byteBuffer, 0, 1, null);
        UtilsKt.xor(byteBufferCopy$default, byteBuffer2);
        return byteBufferCopy$default == null ? byteBuffer : byteBufferCopy$default;
    }

    private final void setMaskBuffer(boolean mask) {
        if (mask) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.putInt(Random.INSTANCE.nextInt());
            byteBufferAllocate.clear();
            this.maskBuffer = byteBufferAllocate;
            return;
        }
        this.maskBuffer = null;
    }
}
