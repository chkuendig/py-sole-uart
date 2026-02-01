package io.ktor.utils.io.core;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScannerJVM.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a0\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a)\u0010\u000e\u001a\u00020\u0001*\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u0012H\u0082\b\u001aA\u0010\u000e\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0082\b\u001a9\u0010\u0015\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0082\b\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a\u001c\u0010\u0018\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a,\u0010\u0019\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a$\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001a\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a$\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a$\u0010\u001c\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0012H\u0000\u001a4\u0010\u001c\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000¨\u0006\u001d"}, d2 = {"discardUntilDelimiterImplArrays", "", "buffer", "Lio/ktor/utils/io/core/Buffer;", "delimiter", "", "discardUntilDelimitersImplArrays", "delimiter1", "delimiter2", "readUntilDelimiterArrays", "dst", "", "offset", SessionDescription.ATTR_LENGTH, "copyUntilArrays", "predicate", "Lkotlin/Function1;", "", "Lio/ktor/utils/io/core/Output;", "Ljava/nio/ByteBuffer;", "bufferOffset", "copyUntilDirect", "discardUntilDelimiterImpl", "discardUntilDelimitersImpl", "readUntilDelimiterDirect", "readUntilDelimiterImpl", "readUntilDelimitersArrays", "readUntilDelimitersDirect", "readUntilDelimitersImpl", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ScannerJVMKt {
    public static final int discardUntilDelimiterImpl(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (ByteBuffersKt.hasArray(buffer)) {
            return discardUntilDelimiterImplArrays(buffer, b);
        }
        return ScannerKt.discardUntilDelimiterImplMemory(buffer, b);
    }

    private static final int discardUntilDelimiterImplArrays(Buffer buffer, byte b) {
        int i;
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        int iArrayOffset = memory.arrayOffset() + memory.position() + buffer.getReadPosition();
        int writePosition = (buffer.getWritePosition() - buffer.getReadPosition()) + iArrayOffset;
        if (writePosition <= bArrArray.length) {
            i = iArrayOffset;
            while (i < writePosition && bArrArray[i] != b) {
                i++;
            }
        } else {
            i = iArrayOffset;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - iArrayOffset;
    }

    public static final int discardUntilDelimitersImpl(Buffer buffer, byte b, byte b2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (ByteBuffersKt.hasArray(buffer)) {
            return discardUntilDelimitersImplArrays(buffer, b, b2);
        }
        return ScannerKt.discardUntilDelimitersImplMemory(buffer, b, b2);
    }

    private static final int discardUntilDelimitersImplArrays(Buffer buffer, byte b, byte b2) {
        int i;
        ByteBuffer memory = buffer.getMemory();
        byte[] bArrArray = memory.array();
        int iArrayOffset = memory.arrayOffset() + memory.position() + buffer.getReadPosition();
        int writePosition = (buffer.getWritePosition() - buffer.getReadPosition()) + iArrayOffset;
        if (writePosition <= bArrArray.length) {
            i = iArrayOffset;
            while (i < writePosition) {
                byte b3 = bArrArray[i];
                if (b3 == b || b3 == b2) {
                    break;
                }
                i++;
            }
        } else {
            i = iArrayOffset;
        }
        buffer.discardUntilIndex$ktor_io(i);
        return i - iArrayOffset;
    }

    public static final int readUntilDelimiterImpl(Buffer buffer, byte b, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int length = dst.length;
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimiterArrays(buffer, b, dst, i, i2);
        }
        return readUntilDelimiterDirect(buffer, b, dst, i, i2);
    }

    private static final int readUntilDelimiterArrays(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        int i3;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        byte[] bArrArray = memory.array();
        int iPosition = readPosition + memory.position() + memory.arrayOffset();
        int iMin2 = Math.min(iMin, memory.remaining()) + iPosition;
        if (iMin2 <= bArrArray.length) {
            i3 = iPosition;
            while (i3 < iMin2 && bArrArray[i3] != b) {
                i3++;
            }
        } else {
            i3 = iPosition;
        }
        int i4 = i3 - iPosition;
        System.arraycopy(bArrArray, iPosition, bArr, i, i4);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimitersImpl(Buffer buffer, byte b, byte b2, byte[] dst, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int length = dst.length;
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimitersArrays(buffer, b, b2, dst, i, i2);
        }
        return readUntilDelimitersDirect(buffer, b, b2, dst, i, i2);
    }

    private static final int readUntilDelimitersArrays(Buffer buffer, byte b, byte b2, byte[] bArr, int i, int i2) {
        int i3;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        byte[] bArrArray = memory.array();
        int iPosition = readPosition + memory.position() + memory.arrayOffset();
        int iMin2 = Math.min(iMin, memory.remaining()) + iPosition;
        if (iMin2 <= bArrArray.length) {
            i3 = iPosition;
            while (i3 < iMin2) {
                byte b3 = bArrArray[i3];
                if (b3 == b || b3 == b2) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = iPosition;
        }
        int i4 = i3 - iPosition;
        System.arraycopy(bArrArray, iPosition, bArr, i, i4);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimiterImpl(Buffer buffer, byte b, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimiterArrays(buffer, b, dst);
        }
        return readUntilDelimiterDirect(buffer, b, dst);
    }

    public static final int readUntilDelimitersImpl(Buffer buffer, byte b, byte b2, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (ByteBuffersKt.hasArray(buffer)) {
            return readUntilDelimitersArrays(buffer, b, b2, dst);
        }
        return readUntilDelimitersDirect(buffer, b, b2, dst);
    }

    private static final int copyUntilDirect(ByteBuffer byteBuffer, Function1<? super Byte, Boolean> function1, byte[] bArr, int i, int i2) {
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        int i4 = iPosition;
        while (i4 < byteBuffer.limit() && i4 < i3 && !function1.invoke(Byte.valueOf(byteBuffer.get(i4))).booleanValue()) {
            i4++;
        }
        int i5 = i4 - iPosition;
        byteBuffer.get(bArr, i, i5);
        return i5;
    }

    private static final int copyUntilArrays(ByteBuffer byteBuffer, Function1<? super Byte, Boolean> function1, int i, byte[] bArr, int i2, int i3) {
        int i4;
        byte[] bArrArray = byteBuffer.array();
        int iPosition = i + byteBuffer.position() + byteBuffer.arrayOffset();
        int iMin = Math.min(i3, byteBuffer.remaining()) + iPosition;
        if (iMin <= bArrArray.length) {
            i4 = iPosition;
            while (i4 < iMin && !function1.invoke(Byte.valueOf(bArrArray[i4])).booleanValue()) {
                i4++;
            }
        } else {
            i4 = iPosition;
        }
        int i5 = i4 - iPosition;
        System.arraycopy(bArrArray, iPosition, bArr, i2, i5);
        return i5;
    }

    private static final int copyUntilArrays(Buffer buffer, Function1<? super Byte, Boolean> function1, Output output) {
        int i;
        ByteBuffer memory = buffer.getMemory();
        byte[] array = memory.array();
        int iPosition = memory.position() + memory.arrayOffset() + buffer.getReadPosition();
        int iPosition2 = memory.position() + memory.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        int i2 = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + iPosition, iPosition2);
                if (iMin <= array.length) {
                    i = iPosition;
                    while (i < iMin && !function1.invoke(Byte.valueOf(array[i])).booleanValue()) {
                        i++;
                    }
                } else {
                    i = iPosition;
                }
                int i3 = i - iPosition;
                Intrinsics.checkNotNullExpressionValue(array, "array");
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, array, iPosition, i3);
                i2 += i3;
                if (chunkBuffer.getLimit() > chunkBuffer.getWritePosition() || i >= iPosition2) {
                    break;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                iPosition = i;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyStart(1);
        output.afterHeadWrite();
        InlineMarker.finallyEnd(1);
        buffer.discardUntilIndex$ktor_io(i);
        return i2;
    }

    private static final int readUntilDelimiterDirect(Buffer buffer, byte b, byte[] bArr, int i, int i2) {
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer memory = buffer.getMemory();
        int i3 = readPosition;
        while (true) {
            if (i3 >= iMin) {
                break;
            }
            if (memory.get(i3) == b) {
                iMin = i3;
                break;
            }
            i3++;
        }
        int i4 = iMin - readPosition;
        MemoryJvmKt.m8831copyTo9zorpBc(memory, bArr, readPosition, i4, i);
        buffer.discardExact(i4);
        return i4;
    }

    private static final int readUntilDelimitersDirect(Buffer buffer, byte b, byte b2, byte[] bArr, int i, int i2) {
        int readPosition = buffer.getReadPosition();
        int iMin = Math.min(buffer.getWritePosition(), i2 + readPosition);
        ByteBuffer memory = buffer.getMemory();
        for (int i3 = readPosition; i3 < iMin; i3++) {
            byte b3 = memory.get(i3);
            if (b3 == b || b3 == b2) {
                iMin = i3;
                break;
            }
        }
        int i4 = iMin - readPosition;
        MemoryJvmKt.m8831copyTo9zorpBc(memory, bArr, readPosition, i4, i);
        buffer.discardExact(i4);
        return i4;
    }

    public static final int readUntilDelimiterDirect(Buffer buffer, byte b, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        while (readPosition != writePosition && memory.get(readPosition) != b) {
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(dst, buffer, readPosition2);
        return readPosition2;
    }

    public static final int readUntilDelimiterArrays(Buffer buffer, byte b, Output dst) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = buffer.getMemory();
        byte[] array = memory.array();
        int iPosition = memory.position() + memory.arrayOffset() + buffer.getReadPosition();
        int iPosition2 = memory.position() + memory.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, null);
        int i2 = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + iPosition, iPosition2);
                if (iMin <= array.length) {
                    i = iPosition;
                    while (i < iMin && array[i] != b) {
                        i++;
                    }
                } else {
                    i = iPosition;
                }
                int i3 = i - iPosition;
                Intrinsics.checkNotNullExpressionValue(array, "array");
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, array, iPosition, i3);
                i2 += i3;
                if (chunkBuffer.getLimit() > chunkBuffer.getWritePosition() || i >= iPosition2) {
                    break;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, chunkBufferPrepareWriteHead);
                iPosition = i;
            } catch (Throwable th) {
                dst.afterHeadWrite();
                throw th;
            }
        }
        dst.afterHeadWrite();
        buffer.discardUntilIndex$ktor_io(i);
        return i2;
    }

    public static final int readUntilDelimitersDirect(Buffer buffer, byte b, byte b2, Output dst) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        ByteBuffer memory = buffer.getMemory();
        while (readPosition != writePosition) {
            byte b3 = memory.get(readPosition);
            if (b3 == b || b3 == b2) {
                break;
            }
            readPosition++;
        }
        int readPosition2 = readPosition - buffer.getReadPosition();
        OutputKt.writeFully(dst, buffer, readPosition2);
        return readPosition2;
    }

    public static final int readUntilDelimitersArrays(Buffer buffer, byte b, byte b2, Output dst) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = buffer.getMemory();
        byte[] array = memory.array();
        int iPosition = memory.position() + memory.arrayOffset() + buffer.getReadPosition();
        int iPosition2 = memory.position() + memory.arrayOffset() + buffer.getWritePosition();
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, null);
        int i2 = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min((chunkBuffer.getLimit() - chunkBuffer.getWritePosition()) + iPosition, iPosition2);
                if (iMin <= array.length) {
                    i = iPosition;
                    while (i < iMin) {
                        byte b3 = array[i];
                        if (b3 == b || b3 == b2) {
                            break;
                        }
                        i++;
                    }
                } else {
                    i = iPosition;
                }
                int i3 = i - iPosition;
                Intrinsics.checkNotNullExpressionValue(array, "array");
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, array, iPosition, i3);
                i2 += i3;
                if (chunkBuffer.getLimit() > chunkBuffer.getWritePosition() || i >= iPosition2) {
                    break;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, chunkBufferPrepareWriteHead);
                iPosition = i;
            } catch (Throwable th) {
                dst.afterHeadWrite();
                throw th;
            }
        }
        dst.afterHeadWrite();
        buffer.discardUntilIndex$ktor_io(i);
        return i2;
    }
}
