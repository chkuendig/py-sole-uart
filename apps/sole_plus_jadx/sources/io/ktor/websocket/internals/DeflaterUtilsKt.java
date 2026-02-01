package io.ktor.websocket.internals;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeflaterUtils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"EMPTY_CHUNK", "", "PADDED_EMPTY_CHUNK", "deflateFully", "Ljava/util/zip/Deflater;", "data", "deflateTo", "", "Lio/ktor/utils/io/core/BytePacketBuilder;", "deflater", "buffer", "Ljava/nio/ByteBuffer;", "flush", "", "inflateFully", "Ljava/util/zip/Inflater;", "ktor-websockets"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DeflaterUtilsKt {
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater deflater, byte[] data) {
        Intrinsics.checkNotNullParameter(deflater, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        deflater.setInput(data);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
            ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
            try {
                ByteBuffer byteBuffer = byteBufferBorrow;
                while (!deflater.needsInput()) {
                    deflateTo(bytePacketBuilder, deflater, byteBuffer, false);
                }
                while (deflateTo(bytePacketBuilder, deflater, byteBuffer, true) != 0) {
                }
                Unit unit = Unit.INSTANCE;
                ktorDefaultPool.recycle(byteBufferBorrow);
                ByteReadPacket byteReadPacketBuild = bytePacketBuilder.build();
                if (BytePacketUtilsKt.endsWith(byteReadPacketBuild, PADDED_EMPTY_CHUNK)) {
                    byte[] bytes = StringsKt.readBytes(byteReadPacketBuild, ((int) byteReadPacketBuild.getRemaining()) - EMPTY_CHUNK.length);
                    byteReadPacketBuild.release();
                    return bytes;
                }
                bytePacketBuilder = new BytePacketBuilder(null, 1, null);
                try {
                    bytePacketBuilder.writePacket(byteReadPacketBuild);
                    bytePacketBuilder.writeByte((byte) 0);
                    return StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null);
                } finally {
                }
            } catch (Throwable th) {
                ktorDefaultPool.recycle(byteBufferBorrow);
                throw th;
            }
        } finally {
        }
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] data) {
        Intrinsics.checkNotNullParameter(inflater, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        inflater.setInput(ArraysKt.plus(data, EMPTY_CHUNK));
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
            ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
            try {
                ByteBuffer byteBuffer = byteBufferBorrow;
                long length = r11.length + inflater.getBytesRead();
                while (inflater.getBytesRead() < length) {
                    byteBuffer.clear();
                    byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                    byteBuffer.flip();
                    OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
                }
                Unit unit = Unit.INSTANCE;
                ktorDefaultPool.recycle(byteBufferBorrow);
                return StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null);
            } catch (Throwable th) {
                ktorDefaultPool.recycle(byteBufferBorrow);
                throw th;
            }
        } catch (Throwable th2) {
            bytePacketBuilder.release();
            throw th2;
        }
    }

    private static final int deflateTo(BytePacketBuilder bytePacketBuilder, Deflater deflater, ByteBuffer byteBuffer, boolean z) {
        int iDeflate;
        byteBuffer.clear();
        if (z) {
            iDeflate = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2);
        } else {
            iDeflate = deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        }
        if (iDeflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + iDeflate);
        byteBuffer.flip();
        OutputArraysJVMKt.writeFully(bytePacketBuilder, byteBuffer);
        return iDeflate;
    }
}
