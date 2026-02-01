package io.ktor.utils.io.core;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteBuffers.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0082\u0010\u001a\u0012\u0010\t\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007\u001a9\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a9\u0010\u000b\u001a\u00020\f*\u00020\u00102\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007\u001a9\u0010\u0012\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a9\u0010\u0014\u001a\u00020\f*\u00020\u00132\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"hasArray", "", "Lio/ktor/utils/io/core/Buffer;", "readAsMuchAsPossible", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "bb", "Ljava/nio/ByteBuffer;", "copied", "readAvailable", "dst", "readDirect", "", ContentDisposition.Parameters.Size, "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Input;", "readFully", "writeByteBufferDirect", "Lio/ktor/utils/io/core/BytePacketBuilder;", "writeDirect", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteBuffersKt {
    public static final int readAvailable(ByteReadPacket byteReadPacket, ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return readAsMuchAsPossible(byteReadPacket, dst, 0);
    }

    public static final int readFully(ByteReadPacket byteReadPacket, ByteBuffer dst) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int asMuchAsPossible = readAsMuchAsPossible(byteReadPacket, dst, 0);
        if (dst.hasRemaining()) {
            throw new EOFException("Not enough data in packet to fill buffer: " + dst.remaining() + " more bytes required");
        }
        return asMuchAsPossible;
    }

    private static final int readAsMuchAsPossible(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer, int i) throws EOFException {
        ChunkBuffer chunkBufferPrepareRead;
        while (byteBuffer.hasRemaining() && (chunkBufferPrepareRead = byteReadPacket.prepareRead(1)) != null) {
            int iRemaining = byteBuffer.remaining();
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
            if (iRemaining >= writePosition) {
                BufferUtilsJvmKt.readFully(chunkBuffer, byteBuffer, writePosition);
                byteReadPacket.releaseHead$ktor_io(chunkBufferPrepareRead);
                i += writePosition;
            } else {
                BufferUtilsJvmKt.readFully(chunkBuffer, byteBuffer, iRemaining);
                byteReadPacket.setHeadPosition(chunkBufferPrepareRead.getReadPosition());
                return i + iRemaining;
            }
        }
        return i;
    }

    public static final int writeByteBufferDirect(BytePacketBuilder bytePacketBuilder, int i, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = bytePacketBuilder2.prepareWriteHead(i);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            int limit = chunkBufferPrepareWriteHead.getLimit() - writePosition;
            ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, writePosition, limit);
            block.invoke(byteBufferM8822slice87lwejk);
            if (byteBufferM8822slice87lwejk.limit() != limit) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int iPosition = byteBufferM8822slice87lwejk.position();
            chunkBufferPrepareWriteHead.commitWritten(iPosition);
            if (iPosition >= 0) {
                return iPosition;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            InlineMarker.finallyStart(1);
            bytePacketBuilder2.afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void readDirect(ByteReadPacket byteReadPacket, int i, Function1<? super ByteBuffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteReadPacket byteReadPacket2 = byteReadPacket;
        ChunkBuffer chunkBufferPrepareRead = byteReadPacket2.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition2, writePosition);
            block.invoke(byteBufferM8822slice87lwejk);
            if (byteBufferM8822slice87lwejk.limit() != writePosition) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM8822slice87lwejk.position());
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                byteReadPacket2.ensureNext(chunkBufferPrepareRead);
            } else {
                byteReadPacket2.setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                byteReadPacket2.ensureNext(chunkBufferPrepareRead);
            } else {
                byteReadPacket2.setHeadPosition(readPosition4);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final boolean hasArray(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        return memory.hasArray() && !memory.isReadOnly();
    }

    public static final void writeDirect(BytePacketBuilder bytePacketBuilder, int i, Function1<? super ByteBuffer, Unit> block) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        BytePacketBuilder bytePacketBuilder2 = bytePacketBuilder;
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = bytePacketBuilder2.prepareWriteHead(i);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            int limit = chunkBufferPrepareWriteHead.getLimit() - writePosition;
            ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, writePosition, limit);
            block.invoke(byteBufferM8822slice87lwejk);
            if (byteBufferM8822slice87lwejk.limit() != limit) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            int iPosition = byteBufferM8822slice87lwejk.position();
            chunkBufferPrepareWriteHead.commitWritten(iPosition);
            if (iPosition < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
        } finally {
            InlineMarker.finallyStart(1);
            bytePacketBuilder2.afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(message = "Use read {} instead.")
    public static final void readDirect(Input input, int i, Function1<? super ByteBuffer, Unit> block) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareRead = input.prepareRead(i);
        if (chunkBufferPrepareRead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        int readPosition = chunkBufferPrepareRead.getReadPosition();
        try {
            ChunkBuffer chunkBuffer = chunkBufferPrepareRead;
            ByteBuffer memory = chunkBuffer.getMemory();
            int readPosition2 = chunkBuffer.getReadPosition();
            int writePosition = chunkBuffer.getWritePosition() - readPosition2;
            ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition2, writePosition);
            block.invoke(byteBufferM8822slice87lwejk);
            if (byteBufferM8822slice87lwejk.limit() != writePosition) {
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            }
            chunkBuffer.discardExact(byteBufferM8822slice87lwejk.position());
            InlineMarker.finallyStart(1);
            int readPosition3 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition3 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                input.ensureNext(chunkBufferPrepareRead);
            } else {
                input.setHeadPosition(readPosition3);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            int readPosition4 = chunkBufferPrepareRead.getReadPosition();
            if (readPosition4 < readPosition) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (readPosition4 == chunkBufferPrepareRead.getWritePosition()) {
                input.ensureNext(chunkBufferPrepareRead);
            } else {
                input.setHeadPosition(readPosition4);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
