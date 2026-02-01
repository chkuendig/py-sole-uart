package io.ktor.utils.io.nio;

import com.samsung.android.sdk.healthdata.HealthConstants;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Channels.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0010\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u0011\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002\u001a3\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0007\u001a%\u0010\u001a\u001a\u0004\u0018\u00010\f*\u00020\u00152\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\u0002\b\u001f\u001a\u0012\u0010\u001a\u001a\u00020 *\u00020\u00152\u0006\u0010!\u001a\u00020\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"read", "", "Ljava/nio/channels/ReadableByteChannel;", "destination", "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "maxLength", "read-UAd2zVI", "(Ljava/nio/channels/ReadableByteChannel;Ljava/nio/ByteBuffer;II)I", "buffer", "Lio/ktor/utils/io/core/Buffer;", "readPacketAtLeast", "Lio/ktor/utils/io/core/ByteReadPacket;", "n", "", "readPacketAtMost", "readPacketExact", "readPacketImpl", HealthConstants.HeartRate.MIN, "max", "write", "Ljava/nio/channels/WritableByteChannel;", "source", "sourceOffset", "write-UAd2zVI", "(Ljava/nio/channels/WritableByteChannel;Ljava/nio/ByteBuffer;II)I", "writePacket", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "", "Lkotlin/ExtensionFunctionType;", "", "p", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChannelsKt {
    public static final boolean writePacket(WritableByteChannel writableByteChannel, ByteReadPacket p) {
        int iWrite;
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        do {
            try {
                ByteReadPacket byteReadPacket = p;
                ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(1);
                if (chunkBufferPrepareRead == null) {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
                int readPosition = chunkBufferPrepareRead.getReadPosition();
                try {
                    ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
                    ByteBuffer memory = chunkBuffer.getMemory();
                    int readPosition2 = chunkBuffer.getReadPosition();
                    int writePosition = chunkBuffer.getWritePosition() - readPosition2;
                    ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition2, writePosition);
                    iWrite = writableByteChannel.write(byteBufferM8822slice87lwejk);
                    if (byteBufferM8822slice87lwejk.limit() != writePosition) {
                        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                    }
                    chunkBuffer.discardExact(byteBufferM8822slice87lwejk.position());
                    int readPosition3 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition3);
                    }
                    if (p.getEndOfInput()) {
                        return true;
                    }
                } catch (Throwable th) {
                    int readPosition4 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition4 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                p.release();
                throw th2;
            }
        } while (iWrite != 0);
        return false;
    }

    public static final ByteReadPacket readPacketExact(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, j, j);
    }

    public static final ByteReadPacket readPacketAtLeast(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, j, Long.MAX_VALUE);
    }

    public static final ByteReadPacket readPacketAtMost(ReadableByteChannel readableByteChannel, long j) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        return readPacketImpl(readableByteChannel, 1L, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        return new io.ktor.utils.io.core.ByteReadPacket(r9, r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final io.ktor.utils.io.core.ByteReadPacket readPacketImpl(java.nio.channels.ReadableByteChannel r18, long r19, long r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.nio.ChannelsKt.readPacketImpl(java.nio.channels.ReadableByteChannel, long, long):io.ktor.utils.io.core.ByteReadPacket");
    }

    /* renamed from: read-UAd2zVI, reason: not valid java name */
    public static final int m9079readUAd2zVI(ReadableByteChannel read, ByteBuffer destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(read, "$this$read");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return read.read(MemoryJvmKt.sliceSafe(destination, i, i2));
    }

    /* renamed from: write-UAd2zVI, reason: not valid java name */
    public static final int m9081writeUAd2zVI(WritableByteChannel write, ByteBuffer source, int i, int i2) {
        Intrinsics.checkNotNullParameter(write, "$this$write");
        Intrinsics.checkNotNullParameter(source, "source");
        return write.write(MemoryJvmKt.sliceSafe(source, i, i2));
    }

    public static final ByteReadPacket writePacket(WritableByteChannel writableByteChannel, Function1<? super BytePacketBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            builder.invoke(bytePacketBuilder);
            ByteReadPacket byteReadPacketBuild = bytePacketBuilder.build();
            try {
                if (writePacket(writableByteChannel, byteReadPacketBuild)) {
                    return null;
                }
                return byteReadPacketBuild;
            } catch (Throwable th) {
                byteReadPacketBuild.release();
                throw th;
            }
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    @Deprecated(message = "Use read(Memory) instead.")
    public static final int read(ReadableByteChannel readableByteChannel, Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.getLimit() - buffer.getWritePosition() == 0) {
            return 0;
        }
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int i = readableByteChannel.read(MemoryJvmKt.sliceSafe(memory, writePosition, buffer.getLimit() - writePosition));
        if (i == -1) {
            return -1;
        }
        buffer.commitWritten(i);
        return i;
    }

    /* renamed from: read-UAd2zVI$default, reason: not valid java name */
    public static /* synthetic */ int m9080readUAd2zVI$default(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteBuffer.limit() - i;
        }
        return m9079readUAd2zVI(readableByteChannel, byteBuffer, i, i2);
    }

    @Deprecated(message = "Use write(Memory) instead.")
    public static final int write(WritableByteChannel writableByteChannel, Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int iWrite = writableByteChannel.write(MemoryJvmKt.sliceSafe(memory, readPosition, buffer.getWritePosition() - readPosition));
        buffer.discardExact(iWrite);
        return iWrite;
    }

    /* renamed from: write-UAd2zVI$default, reason: not valid java name */
    public static /* synthetic */ int m9082writeUAd2zVI$default(WritableByteChannel writableByteChannel, ByteBuffer byteBuffer, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteBuffer.limit() - i;
        }
        return m9081writeUAd2zVI(writableByteChannel, byteBuffer, i, i2);
    }
}
