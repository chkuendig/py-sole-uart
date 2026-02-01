package io.ktor.utils.io.core.internal;

import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.PacketJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Unsafe.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u001e\u0010\u000b\u001a\u00020\u0006*\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyByteArray", "", "completeReadHead", "", "Lio/ktor/utils/io/core/Input;", IInstrumentationResultParser.StatusKeys.CURRENT, "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "prepareReadFirstHead", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "", "prepareReadNextHead", "prepareWriteHead", "Lio/ktor/utils/io/core/Output;", "capacity", "unsafeAppend", "Lio/ktor/utils/io/core/ByteReadPacket;", "builder", "Lio/ktor/utils/io/core/BytePacketBuilder;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UnsafeKt {
    public static final byte[] EmptyByteArray = new byte[0];

    public static final int unsafeAppend(ByteReadPacket byteReadPacket, BytePacketBuilder builder) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        int size = builder.getSize();
        ChunkBuffer chunkBufferStealAll$ktor_io = builder.stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            return 0;
        }
        if (size <= PacketJVMKt.getPACKET_MAX_COPY_SIZE() && chunkBufferStealAll$ktor_io.getNext() == null && byteReadPacket.tryWriteAppend$ktor_io(chunkBufferStealAll$ktor_io)) {
            builder.afterBytesStolen$ktor_io();
            return size;
        }
        byteReadPacket.append$ktor_io(chunkBufferStealAll$ktor_io);
        return size;
    }

    public static final ChunkBuffer prepareReadFirstHead(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.prepareReadHead$ktor_io(i);
    }

    public static final void completeReadHead(Input input, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current == input) {
            return;
        }
        ChunkBuffer chunkBuffer = current;
        if (chunkBuffer.getWritePosition() <= chunkBuffer.getReadPosition()) {
            input.ensureNext(current);
        } else if (chunkBuffer.getCapacity() - chunkBuffer.getLimit() < 8) {
            input.fixGapAfterRead$ktor_io(current);
        } else {
            input.setHeadPosition(current.getReadPosition());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ChunkBuffer prepareReadNextHead(Input input, ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(current, "current");
        if (current == input) {
            if (input.canRead()) {
                return (ChunkBuffer) input;
            }
            return null;
        }
        return input.ensureNextHead$ktor_io(current);
    }

    public static final ChunkBuffer prepareWriteHead(Output output, int i, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        if (chunkBuffer != null) {
            output.afterHeadWrite();
        }
        return output.prepareWriteHead(i);
    }
}
