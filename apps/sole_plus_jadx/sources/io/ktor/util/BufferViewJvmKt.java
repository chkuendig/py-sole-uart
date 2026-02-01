package io.ktor.util;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.jvm.ErrorsKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferViewJvm.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"read", "", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "write", "Ljava/nio/channels/WritableByteChannel;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BufferViewJvmKt {
    public static final int read(ReadableByteChannel readableByteChannel, ChunkBuffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ChunkBuffer chunkBuffer = buffer;
        if (chunkBuffer.getLimit() - chunkBuffer.getWritePosition() == 0) {
            return 0;
        }
        int limit = chunkBuffer.getLimit() - chunkBuffer.getWritePosition();
        if (1 > limit) {
            throw new IllegalArgumentException(("size 1 is greater than buffer's remaining capacity " + limit).toString());
        }
        ByteBuffer byteBufferDuplicate = buffer.getMemory().duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        int writePosition = buffer.getWritePosition();
        byteBufferDuplicate.limit(buffer.getLimit());
        byteBufferDuplicate.position(writePosition);
        int i = readableByteChannel.read(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - writePosition;
        if (iPosition < 0 || iPosition > limit) {
            ErrorsKt.wrongBufferPositionChangeError(iPosition, 1);
            throw new KotlinNothingValueException();
        }
        buffer.commitWritten(iPosition);
        return i;
    }

    @InternalAPI
    public static final int write(WritableByteChannel writableByteChannel, ChunkBuffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer byteBufferDuplicate = buffer.getMemory().duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.limit(writePosition);
        byteBufferDuplicate.position(readPosition);
        int iWrite = writableByteChannel.write(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() - readPosition;
        if (iPosition < 0) {
            ErrorsKt.negativeShiftError(iPosition);
            throw new KotlinNothingValueException();
        }
        if (byteBufferDuplicate.limit() != writePosition) {
            ErrorsKt.limitChangeError();
            throw new KotlinNothingValueException();
        }
        buffer.discardExact(iPosition);
        return iWrite;
    }
}
