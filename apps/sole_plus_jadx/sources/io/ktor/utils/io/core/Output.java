package io.ktor.utils.io.core;

import androidx.collection.SieveCacheKt;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.ChunkBufferKt;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Output.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00060\u0001j\u0002`\u00022\u00060\u0003j\u0002`\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020(H\u0001J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-H\u0016J\"\u0010+\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fJ\u0012\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u000102H\u0016J\"\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J\u0015\u00105\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\bH\u0000¢\u0006\u0002\b6J \u00107\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020\bH\u0002J\u0015\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020\bH\u0000¢\u0006\u0002\b?J\u0006\u0010@\u001a\u00020(J\b\u0010A\u001a\u00020(H$J\u0006\u0010B\u001a\u00020(J-\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH$ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020(H\u0002J\u0015\u0010I\u001a\u00020(2\u0006\u0010>\u001a\u00020\bH\u0010¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\fH\u0001J\u0006\u0010M\u001a\u00020(J\u000f\u0010N\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bOJ(\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\f0SH\u0081\bø\u0001\u0003J\u000e\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020WJ\u0010\u0010X\u001a\u00020(2\u0006\u0010V\u001a\u00020WH\u0002J\u0015\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020\bH\u0000¢\u0006\u0002\b[J\u000e\u0010\\\u001a\u00020(2\u0006\u0010]\u001a\u00020^J\u0016\u0010\\\u001a\u00020(2\u0006\u0010_\u001a\u00020^2\u0006\u0010L\u001a\u00020\fJ\u0016\u0010\\\u001a\u00020(2\u0006\u0010_\u001a\u00020^2\u0006\u0010L\u001a\u00020`J&\u0010a\u001a\u00020(2\u0006\u0010b\u001a\u00020\b2\u0006\u0010c\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0018\u0010d\u001a\u00020(2\u0006\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u001b\u001a\u00020\u001cX\u0080\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0019R\u0015\u0010%\u001a\u00020\f8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000e\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006e"}, d2 = {"Lio/ktor/utils/io/core/Output;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "()V", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "_head", "_size", "", "get_size", "()I", "_tail", "chainedSize", "head", "getHead$ktor_io", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "tailEndExclusive", "getTailEndExclusive$ktor_io", "setTailEndExclusive$ktor_io", "(I)V", "tailInitialPosition", "tailMemory", "Lio/ktor/utils/io/bits/Memory;", "getTailMemory-SK3TCg8$ktor_io", "()Ljava/nio/ByteBuffer;", "setTailMemory-3GNKZMM$ktor_io", "(Ljava/nio/ByteBuffer;)V", "Ljava/nio/ByteBuffer;", "tailPosition", "getTailPosition$ktor_io", "setTailPosition$ktor_io", "tailRemaining", "getTailRemaining$ktor_io", "afterBytesStolen", "", "afterBytesStolen$ktor_io", "afterHeadWrite", "append", "value", "", "csq", "", "start", "end", "", "startIndex", "endIndex", "appendChain", "appendChain$ktor_io", "appendChainImpl", "newTail", "chainedSizeDelta", "appendCharFallback", "c", "appendNewChunk", "appendSingleChunk", "buffer", "appendSingleChunk$ktor_io", "close", "closeDestination", "flush", "source", "offset", SessionDescription.ATTR_LENGTH, "flush-62zg_DM", "(Ljava/nio/ByteBuffer;II)V", "flushChain", "last", "last$ktor_io", "prepareWriteHead", "n", "release", "stealAll", "stealAll$ktor_io", "write", ContentDisposition.Parameters.Size, "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "writeByte", "v", "", "writeByteFallback", "writeChunkBuffer", "chunkBuffer", "writeChunkBuffer$ktor_io", "writePacket", "packet", "Lio/ktor/utils/io/core/ByteReadPacket;", "p", "", "writePacketMerging", "tail", "foreignStolen", "writePacketSlowPrepend", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class Output implements Appendable, Closeable {
    private ChunkBuffer _head;
    private ChunkBuffer _tail;
    private int chainedSize;
    private final ObjectPool<ChunkBuffer> pool;
    private int tailEndExclusive;
    private int tailInitialPosition;
    private ByteBuffer tailMemory;
    private int tailPosition;

    protected abstract void closeDestination();

    /* renamed from: flush-62zg_DM */
    protected abstract void mo8991flush62zg_DM(ByteBuffer source, int offset, int length);

    public Output(ObjectPool<ChunkBuffer> pool) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.pool = pool;
        this.tailMemory = Memory.INSTANCE.m8828getEmptySK3TCg8();
    }

    protected final ObjectPool<ChunkBuffer> getPool() {
        return this.pool;
    }

    public Output() {
        this(ChunkBuffer.INSTANCE.getPool());
    }

    protected final int get_size() {
        return this.chainedSize + (this.tailPosition - this.tailInitialPosition);
    }

    public final ChunkBuffer getHead$ktor_io() {
        ChunkBuffer chunkBuffer = this._head;
        return chunkBuffer == null ? ChunkBuffer.INSTANCE.getEmpty() : chunkBuffer;
    }

    /* renamed from: getTailMemory-SK3TCg8$ktor_io, reason: not valid java name and from getter */
    public final ByteBuffer getTailMemory() {
        return this.tailMemory;
    }

    /* renamed from: setTailMemory-3GNKZMM$ktor_io, reason: not valid java name */
    public final void m9027setTailMemory3GNKZMM$ktor_io(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<set-?>");
        this.tailMemory = byteBuffer;
    }

    /* renamed from: getTailPosition$ktor_io, reason: from getter */
    public final int getTailPosition() {
        return this.tailPosition;
    }

    public final void setTailPosition$ktor_io(int i) {
        this.tailPosition = i;
    }

    /* renamed from: getTailEndExclusive$ktor_io, reason: from getter */
    public final int getTailEndExclusive() {
        return this.tailEndExclusive;
    }

    public final void setTailEndExclusive$ktor_io(int i) {
        this.tailEndExclusive = i;
    }

    public final int getTailRemaining$ktor_io() {
        return getTailEndExclusive() - getTailPosition();
    }

    public final void flush() {
        flushChain();
    }

    private final void flushChain() {
        ChunkBuffer chunkBufferStealAll$ktor_io = stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            return;
        }
        ChunkBuffer next = chunkBufferStealAll$ktor_io;
        do {
            try {
                ChunkBuffer chunkBuffer = next;
                mo8991flush62zg_DM(next.getMemory(), next.getReadPosition(), chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
                next = next.getNext();
            } finally {
                BuffersKt.releaseAll(chunkBufferStealAll$ktor_io, this.pool);
            }
        } while (next != null);
    }

    public final ChunkBuffer stealAll$ktor_io() {
        ChunkBuffer chunkBuffer = this._head;
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = this._tail;
        if (chunkBuffer2 != null) {
            chunkBuffer2.commitWrittenUntilIndex(this.tailPosition);
        }
        this._head = null;
        this._tail = null;
        this.tailPosition = 0;
        this.tailEndExclusive = 0;
        this.tailInitialPosition = 0;
        this.chainedSize = 0;
        this.tailMemory = Memory.INSTANCE.m8828getEmptySK3TCg8();
        return chunkBuffer;
    }

    public final void appendSingleChunk$ktor_io(ChunkBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (buffer.getNext() != null) {
            throw new IllegalStateException("It should be a single buffer chunk.".toString());
        }
        appendChainImpl(buffer, buffer, 0);
    }

    public final void appendChain$ktor_io(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer chunkBufferFindTail = BuffersKt.findTail(head);
        ChunkBuffer chunkBuffer = chunkBufferFindTail;
        long jRemainingAll = BuffersKt.remainingAll(head) - (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
        if (jRemainingAll < SieveCacheKt.NodeLinkMask) {
            appendChainImpl(head, chunkBufferFindTail, (int) jRemainingAll);
        } else {
            NumbersKt.failLongToIntConversion(jRemainingAll, "total size increase");
            throw new KotlinNothingValueException();
        }
    }

    private final ChunkBuffer appendNewChunk() {
        ChunkBuffer chunkBufferBorrow = this.pool.borrow();
        chunkBufferBorrow.reserveEndGap(8);
        appendSingleChunk$ktor_io(chunkBufferBorrow);
        return chunkBufferBorrow;
    }

    private final void appendChainImpl(ChunkBuffer head, ChunkBuffer newTail, int chainedSizeDelta) {
        ChunkBuffer chunkBuffer = this._tail;
        if (chunkBuffer == null) {
            this._head = head;
            this.chainedSize = 0;
        } else {
            chunkBuffer.setNext(head);
            int i = this.tailPosition;
            chunkBuffer.commitWrittenUntilIndex(i);
            this.chainedSize += i - this.tailInitialPosition;
        }
        this._tail = newTail;
        this.chainedSize += chainedSizeDelta;
        this.tailMemory = newTail.getMemory();
        this.tailPosition = newTail.getWritePosition();
        this.tailInitialPosition = newTail.getReadPosition();
        this.tailEndExclusive = newTail.getLimit();
    }

    public final void writeByte(byte v) {
        int i = this.tailPosition;
        if (i < this.tailEndExclusive) {
            this.tailPosition = i + 1;
            this.tailMemory.put(i, v);
        } else {
            writeByteFallback(v);
        }
    }

    private final void writeByteFallback(byte v) {
        appendNewChunk().writeByte(v);
        this.tailPosition++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
        } finally {
            closeDestination();
        }
    }

    @Override // java.lang.Appendable
    public Output append(char value) {
        int i = this.tailPosition;
        int i2 = 3;
        if (this.tailEndExclusive - i >= 3) {
            ByteBuffer byteBuffer = this.tailMemory;
            if (value >= 0 && value < 128) {
                byteBuffer.put(i, (byte) value);
                i2 = 1;
            } else if (128 <= value && value < 2048) {
                byteBuffer.put(i, (byte) (((value >> 6) & 31) | 192));
                byteBuffer.put(i + 1, (byte) ((value & '?') | 128));
                i2 = 2;
            } else if (2048 <= value && value < 0) {
                byteBuffer.put(i, (byte) (((value >> '\f') & 15) | 224));
                byteBuffer.put(i + 1, (byte) (((value >> 6) & 63) | 128));
                byteBuffer.put(i + 2, (byte) ((value & '?') | 128));
            } else {
                if (0 > value || value >= 0) {
                    UTF8Kt.malformedCodePoint(value);
                    throw new KotlinNothingValueException();
                }
                byteBuffer.put(i, (byte) (((value >> 18) & 7) | 240));
                byteBuffer.put(i + 1, (byte) (((value >> '\f') & 63) | 128));
                byteBuffer.put(i + 2, (byte) (((value >> 6) & 63) | 128));
                byteBuffer.put(i + 3, (byte) ((value & '?') | 128));
                i2 = 4;
            }
            this.tailPosition = i + i2;
            return this;
        }
        appendCharFallback(value);
        return this;
    }

    @Override // java.lang.Appendable
    public Output append(CharSequence value) {
        if (value == null) {
            append(AbstractJsonLexerKt.NULL, 0, 4);
        } else {
            append(value, 0, value.length());
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Output append(CharSequence value, int startIndex, int endIndex) {
        if (value == null) {
            return append(AbstractJsonLexerKt.NULL, startIndex, endIndex);
        }
        StringsKt.writeText(this, value, startIndex, endIndex, Charsets.UTF_8);
        return this;
    }

    public final void writePacket(ByteReadPacket packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        ChunkBuffer chunkBufferStealAll$ktor_io = packet.stealAll$ktor_io();
        if (chunkBufferStealAll$ktor_io == null) {
            packet.release();
            return;
        }
        ChunkBuffer chunkBuffer = this._tail;
        if (chunkBuffer == null) {
            appendChain$ktor_io(chunkBufferStealAll$ktor_io);
        } else {
            writePacketMerging(chunkBuffer, chunkBufferStealAll$ktor_io, packet.getPool());
        }
    }

    public final void writeChunkBuffer$ktor_io(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chunkBuffer");
        ChunkBuffer chunkBuffer2 = this._tail;
        if (chunkBuffer2 == null) {
            appendChain$ktor_io(chunkBuffer);
        } else {
            writePacketMerging(chunkBuffer2, chunkBuffer, this.pool);
        }
    }

    private final void writePacketMerging(ChunkBuffer tail, ChunkBuffer foreignStolen, ObjectPool<ChunkBuffer> pool) {
        tail.commitWrittenUntilIndex(this.tailPosition);
        ChunkBuffer chunkBuffer = tail;
        int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
        ChunkBuffer chunkBuffer2 = foreignStolen;
        int writePosition2 = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
        int packet_max_copy_size = PacketJVMKt.getPACKET_MAX_COPY_SIZE();
        if (writePosition2 >= packet_max_copy_size || writePosition2 > (chunkBuffer.getCapacity() - chunkBuffer.getLimit()) + (chunkBuffer.getLimit() - chunkBuffer.getWritePosition())) {
            writePosition2 = -1;
        }
        if (writePosition >= packet_max_copy_size || writePosition > foreignStolen.getStartGap() || !ChunkBufferKt.isExclusivelyOwned(foreignStolen)) {
            writePosition = -1;
        }
        if (writePosition2 == -1 && writePosition == -1) {
            appendChain$ktor_io(foreignStolen);
            return;
        }
        if (writePosition != -1 && writePosition2 > writePosition) {
            if (writePosition2 == -1 || writePosition < writePosition2) {
                writePacketSlowPrepend(foreignStolen, tail);
                return;
            }
            throw new IllegalStateException("prep = " + writePosition + ", app = " + writePosition2);
        }
        BufferAppendKt.writeBufferAppend(chunkBuffer, chunkBuffer2, (chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
        afterHeadWrite();
        ChunkBuffer chunkBufferCleanNext = foreignStolen.cleanNext();
        if (chunkBufferCleanNext != null) {
            appendChain$ktor_io(chunkBufferCleanNext);
        }
        foreignStolen.release(pool);
    }

    private final void writePacketSlowPrepend(ChunkBuffer foreignStolen, ChunkBuffer tail) {
        BufferAppendKt.writeBufferPrepend(foreignStolen, tail);
        ChunkBuffer chunkBuffer = this._head;
        if (chunkBuffer == null) {
            throw new IllegalStateException("head should't be null since it is already handled in the fast-path".toString());
        }
        if (chunkBuffer == tail) {
            this._head = foreignStolen;
        } else {
            while (true) {
                ChunkBuffer next = chunkBuffer.getNext();
                Intrinsics.checkNotNull(next);
                if (next == tail) {
                    break;
                } else {
                    chunkBuffer = next;
                }
            }
            chunkBuffer.setNext(foreignStolen);
        }
        tail.release(this.pool);
        this._tail = BuffersKt.findTail(foreignStolen);
    }

    public final void writePacket(ByteReadPacket p, int n) throws EOFException {
        Intrinsics.checkNotNullParameter(p, "p");
        while (n > 0) {
            ByteReadPacket byteReadPacket = p;
            int headEndExclusive = byteReadPacket.getHeadEndExclusive() - byteReadPacket.getHeadPosition();
            if (headEndExclusive <= n) {
                n -= headEndExclusive;
                ChunkBuffer chunkBufferSteal$ktor_io = p.steal$ktor_io();
                if (chunkBufferSteal$ktor_io == null) {
                    throw new EOFException("Unexpected end of packet");
                }
                appendSingleChunk$ktor_io(chunkBufferSteal$ktor_io);
            } else {
                ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(1);
                if (chunkBufferPrepareRead == null) {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
                int readPosition = chunkBufferPrepareRead.getReadPosition();
                try {
                    OutputKt.writeFully(this, chunkBufferPrepareRead, n);
                    int readPosition2 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition2 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition2 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                        return;
                    } else {
                        byteReadPacket.setHeadPosition(readPosition2);
                        return;
                    }
                } catch (Throwable th) {
                    int readPosition3 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition3);
                    }
                    throw th;
                }
            }
        }
    }

    public final void writePacket(ByteReadPacket p, long n) throws EOFException {
        Intrinsics.checkNotNullParameter(p, "p");
        while (n > 0) {
            ByteReadPacket byteReadPacket = p;
            long headEndExclusive = byteReadPacket.getHeadEndExclusive() - byteReadPacket.getHeadPosition();
            if (headEndExclusive <= n) {
                n -= headEndExclusive;
                ChunkBuffer chunkBufferSteal$ktor_io = p.steal$ktor_io();
                if (chunkBufferSteal$ktor_io == null) {
                    throw new EOFException("Unexpected end of packet");
                }
                appendSingleChunk$ktor_io(chunkBufferSteal$ktor_io);
            } else {
                ChunkBuffer chunkBufferPrepareRead = byteReadPacket.prepareRead(1);
                if (chunkBufferPrepareRead == null) {
                    StringsKt.prematureEndOfStream(1);
                    throw new KotlinNothingValueException();
                }
                int readPosition = chunkBufferPrepareRead.getReadPosition();
                try {
                    OutputKt.writeFully(this, chunkBufferPrepareRead, (int) n);
                    int readPosition2 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition2 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition2 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                        return;
                    } else {
                        byteReadPacket.setHeadPosition(readPosition2);
                        return;
                    }
                } catch (Throwable th) {
                    int readPosition3 = chunkBufferPrepareRead.getReadPosition();
                    if (readPosition3 < readPosition) {
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                    if (readPosition3 == chunkBufferPrepareRead.getWritePosition()) {
                        byteReadPacket.ensureNext(chunkBufferPrepareRead);
                    } else {
                        byteReadPacket.setHeadPosition(readPosition3);
                    }
                    throw th;
                }
            }
        }
    }

    public final Appendable append(char[] csq, int start, int end) {
        Intrinsics.checkNotNullParameter(csq, "csq");
        StringsKt.writeText(this, csq, start, end, Charsets.UTF_8);
        return this;
    }

    public final void release() {
        close();
    }

    public final void afterHeadWrite() {
        ChunkBuffer chunkBuffer = this._tail;
        if (chunkBuffer != null) {
            this.tailPosition = chunkBuffer.getWritePosition();
        }
    }

    public final int write(int size, Function1<? super Buffer, Integer> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            int iIntValue = block.invoke(prepareWriteHead(size)).intValue();
            if (iIntValue >= 0) {
                return iIntValue;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            InlineMarker.finallyStart(1);
            afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    public void last$ktor_io(ChunkBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        appendSingleChunk$ktor_io(buffer);
    }

    public final void afterBytesStolen$ktor_io() {
        ChunkBuffer head$ktor_io = getHead$ktor_io();
        if (head$ktor_io != ChunkBuffer.INSTANCE.getEmpty()) {
            if (head$ktor_io.getNext() != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
            head$ktor_io.resetForWrite();
            head$ktor_io.reserveEndGap(8);
            int writePosition = head$ktor_io.getWritePosition();
            this.tailPosition = writePosition;
            this.tailInitialPosition = writePosition;
            this.tailEndExclusive = head$ktor_io.getLimit();
        }
    }

    private final void appendCharFallback(char c) {
        int i = 3;
        try {
            ChunkBuffer chunkBufferPrepareWriteHead = prepareWriteHead(3);
            ByteBuffer memory = chunkBufferPrepareWriteHead.getMemory();
            int writePosition = chunkBufferPrepareWriteHead.getWritePosition();
            if (c >= 0 && c < 128) {
                memory.put(writePosition, (byte) c);
                i = 1;
            } else if (128 <= c && c < 2048) {
                memory.put(writePosition, (byte) (((c >> 6) & 31) | 192));
                memory.put(writePosition + 1, (byte) ((c & '?') | 128));
                i = 2;
            } else if (2048 <= c && c < 0) {
                memory.put(writePosition, (byte) (((c >> '\f') & 15) | 224));
                memory.put(writePosition + 1, (byte) (((c >> 6) & 63) | 128));
                memory.put(writePosition + 2, (byte) ((c & '?') | 128));
            } else {
                if (0 > c || c >= 0) {
                    UTF8Kt.malformedCodePoint(c);
                    throw new KotlinNothingValueException();
                }
                memory.put(writePosition, (byte) (((c >> 18) & 7) | 240));
                memory.put(writePosition + 1, (byte) (((c >> '\f') & 63) | 128));
                memory.put(writePosition + 2, (byte) (((c >> 6) & 63) | 128));
                memory.put(writePosition + 3, (byte) ((c & '?') | 128));
                i = 4;
            }
            chunkBufferPrepareWriteHead.commitWritten(i);
            if (i < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
        } finally {
            afterHeadWrite();
        }
    }

    public final ChunkBuffer prepareWriteHead(int n) {
        ChunkBuffer chunkBuffer;
        if (getTailEndExclusive() - getTailPosition() >= n && (chunkBuffer = this._tail) != null) {
            chunkBuffer.commitWrittenUntilIndex(this.tailPosition);
            return chunkBuffer;
        }
        return appendNewChunk();
    }
}
