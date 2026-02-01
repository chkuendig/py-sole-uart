package io.ktor.utils.io.core;

import androidx.collection.SieveCacheKt;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffers.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\b\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0000\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0082\u0010\u001a\r\u0010\n\u001a\u00020\u0007*\u00020\u0007H\u0080\u0010\u001a1\u0010\u000b\u001a\u00020\f*\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000eH\u0080\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0080\u0010\u001a9\u0010\u0011\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0001\u001a\u001c\u0010\u001d\u001a\u00020\f*\u0004\u0018\u00010\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0000\u001a\f\u0010 \u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\u0015\u0010 \u001a\u00020\u0002*\u00020\u00072\u0006\u0010!\u001a\u00020\u0002H\u0082\u0010\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"coerceAtMostMaxInt", "", "", "coerceAtMostMaxIntOrFail", "message", "", "copyAll", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "head", "prev", "findTail", "forEachChunk", "", "block", "Lkotlin/Function1;", "isEmpty", "", "peekTo", "Lio/ktor/utils/io/core/Buffer;", "destination", "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "offset", "max", "peekTo-yRinSxo", "(Lio/ktor/utils/io/core/Buffer;Ljava/nio/ByteBuffer;JJJ)J", "readBytes", "", "count", "releaseAll", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "remainingAll", "n", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BuffersKt {
    public static final byte[] readBytes(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        byte[] bArr = new byte[i];
        BufferPrimitivesKt.readFully$default(buffer, bArr, 0, 0, 6, (Object) null);
        return bArr;
    }

    public static final void releaseAll(ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer chunkBufferCleanNext = chunkBuffer.cleanNext();
            chunkBuffer.release(pool);
            chunkBuffer = chunkBufferCleanNext;
        }
    }

    public static final void forEachChunk(ChunkBuffer chunkBuffer, Function1<? super ChunkBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        do {
            block.invoke(chunkBuffer);
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
    }

    public static final ChunkBuffer copyAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        ChunkBuffer chunkBufferDuplicate = chunkBuffer.duplicate();
        ChunkBuffer next = chunkBuffer.getNext();
        return next == null ? chunkBufferDuplicate : copyAll(next, chunkBufferDuplicate, chunkBufferDuplicate);
    }

    private static final ChunkBuffer copyAll(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ChunkBuffer chunkBuffer3) {
        while (true) {
            ChunkBuffer chunkBufferDuplicate = chunkBuffer.duplicate();
            chunkBuffer3.setNext(chunkBufferDuplicate);
            chunkBuffer = chunkBuffer.getNext();
            if (chunkBuffer == null) {
                return chunkBuffer2;
            }
            chunkBuffer3 = chunkBufferDuplicate;
        }
    }

    public static final ChunkBuffer findTail(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null) {
                return chunkBuffer;
            }
            chunkBuffer = next;
        }
    }

    public static final long remainingAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return remainingAll(chunkBuffer, 0L);
    }

    private static final long remainingAll(ChunkBuffer chunkBuffer, long j) {
        do {
            ChunkBuffer chunkBuffer2 = chunkBuffer;
            j += chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return j;
    }

    public static final boolean isEmpty(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        do {
            ChunkBuffer chunkBuffer2 = chunkBuffer;
            if (chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition() > 0) {
                return false;
            }
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return true;
    }

    public static final int coerceAtMostMaxInt(long j) {
        return (int) Math.min(j, SieveCacheKt.NodeLinkMask);
    }

    public static final int coerceAtMostMaxIntOrFail(long j, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (j <= SieveCacheKt.NodeLinkMask) {
            return (int) j;
        }
        throw new IllegalArgumentException(message);
    }

    public static /* synthetic */ byte[] readBytes$default(Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        return readBytes(buffer, i);
    }

    /* renamed from: peekTo-yRinSxo, reason: not valid java name */
    public static final long m8990peekToyRinSxo(Buffer peekTo, ByteBuffer destination, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(peekTo, "$this$peekTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        long jMin = Math.min(destination.limit() - j, Math.min(j3, peekTo.getWritePosition() - peekTo.getReadPosition()));
        Memory.m8814copyToJT6ljtQ(peekTo.getMemory(), destination, peekTo.getReadPosition() + j2, jMin, j);
        return jMin;
    }
}
