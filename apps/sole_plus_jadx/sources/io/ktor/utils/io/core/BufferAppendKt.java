package io.ktor.utils.io.core;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.utils.io.bits.Memory;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferAppend.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"writeBufferAppend", "", "Lio/ktor/utils/io/core/Buffer;", "other", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "writeBufferAppendUnreserve", "", "writeSize", "writeBufferPrepend", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BufferAppendKt {
    public static final int writeBufferAppend(Buffer buffer, Buffer other, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int iMin = Math.min(other.getWritePosition() - other.getReadPosition(), i);
        if (buffer.getLimit() - buffer.getWritePosition() <= iMin) {
            writeBufferAppendUnreserve(buffer, iMin);
        }
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        buffer.getLimit();
        ByteBuffer memory2 = other.getMemory();
        int readPosition = other.getReadPosition();
        other.getWritePosition();
        Memory.m8813copyToJT6ljtQ(memory2, memory, readPosition, iMin, writePosition);
        other.discardExact(iMin);
        buffer.commitWritten(iMin);
        return iMin;
    }

    public static final int writeBufferPrepend(Buffer buffer, Buffer other) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int writePosition = other.getWritePosition() - other.getReadPosition();
        int readPosition = buffer.getReadPosition();
        if (readPosition < writePosition) {
            throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
        }
        int i = readPosition - writePosition;
        Memory.m8813copyToJT6ljtQ(other.getMemory(), buffer.getMemory(), other.getReadPosition(), writePosition, i);
        other.discardExact(writePosition);
        buffer.releaseStartGap$ktor_io(i);
        return writePosition;
    }

    private static final void writeBufferAppendUnreserve(Buffer buffer, int i) {
        if ((buffer.getLimit() - buffer.getWritePosition()) + (buffer.getCapacity() - buffer.getLimit()) < i) {
            throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
        }
        if ((buffer.getWritePosition() + i) - buffer.getLimit() > 0) {
            buffer.releaseEndGap$ktor_io();
        }
    }
}
