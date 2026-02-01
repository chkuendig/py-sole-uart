package io.ktor.utils.io.streams;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.collection.SieveCacheKt;
import com.samsung.android.sdk.healthdata.HealthConstants;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.Output;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Streams.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\f\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0004\u001a#\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"SkipBuffer", "", "inputStream", "Ljava/io/InputStream;", "Lio/ktor/utils/io/core/ByteReadPacket;", "outputStream", "Ljava/io/OutputStream;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "readPacketAtLeast", "n", "", "readPacketAtMost", "readPacketExact", "readPacketImpl", HealthConstants.HeartRate.MIN, "max", "readerUTF8", "Ljava/io/Reader;", "writePacket", "", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "packet", "writerUTF8", "Ljava/io/Writer;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StreamsKt {
    private static final char[] SkipBuffer = new char[8192];

    public static final void writePacket(OutputStream outputStream, ByteReadPacket packet) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(packet, "packet");
        long remaining = packet.getRemaining();
        if (remaining == 0) {
            return;
        }
        byte[] bArr = new byte[(int) RangesKt.coerceAtMost(remaining, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)];
        while (!packet.getEndOfInput()) {
            try {
                outputStream.write(bArr, 0, InputArraysKt.readAvailable$default((Input) packet, bArr, 0, 0, 6, (Object) null));
            } finally {
                packet.release();
            }
        }
    }

    public static final ByteReadPacket readPacketExact(InputStream inputStream, long j) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readPacketImpl(inputStream, j, j);
    }

    public static final ByteReadPacket readPacketAtLeast(InputStream inputStream, long j) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readPacketImpl(inputStream, j, Long.MAX_VALUE);
    }

    public static final ByteReadPacket readPacketAtMost(InputStream inputStream, long j) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        return readPacketImpl(inputStream, 1L, j);
    }

    private static final ByteReadPacket readPacketImpl(InputStream inputStream, long j, long j2) {
        long j3 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("min shouldn't be negative".toString());
        }
        if (j > j2) {
            throw new IllegalArgumentException(("min shouldn't be greater than max: " + j + " > " + j2).toString());
        }
        int iCoerceAtMost = (int) RangesKt.coerceAtMost(j2, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        byte[] bArr = new byte[iCoerceAtMost];
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        while (true) {
            if (j3 >= j && (j3 != j || j != 0)) {
                break;
            }
            try {
                int i = inputStream.read(bArr, 0, Math.min((int) Math.min(j2 - j3, SieveCacheKt.NodeLinkMask), iCoerceAtMost));
                if (i == -1) {
                    throw new EOFException("Premature end of stream: was read " + j3 + " bytes of " + j);
                }
                j3 += i;
                io.ktor.utils.io.core.OutputKt.writeFully((Output) bytePacketBuilder, bArr, 0, i);
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        }
        return bytePacketBuilder.build();
    }

    public static final InputStream inputStream(final ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return new InputStream() { // from class: io.ktor.utils.io.streams.StreamsKt.inputStream.1
            @Override // java.io.InputStream
            public int read() {
                if (byteReadPacket.getEndOfInput()) {
                    return -1;
                }
                return byteReadPacket.readByte() & 255;
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(byteReadPacket.getRemaining(), SieveCacheKt.NodeLinkMask);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                byteReadPacket.release();
            }
        };
    }

    public static final Reader readerUTF8(final ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return new Reader() { // from class: io.ktor.utils.io.streams.StreamsKt.readerUTF8.1
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                byteReadPacket.release();
            }

            @Override // java.io.Reader
            public long skip(long n) {
                int i;
                char[] cArr = StreamsKt.SkipBuffer;
                int length = cArr.length;
                long j = 0;
                while (j < n && (i = read(cArr, 0, (int) Math.min(length, n - j))) != -1) {
                    j += i;
                }
                return j;
            }

            @Override // java.io.Reader
            public int read(char[] cbuf, int off, int len) {
                Intrinsics.checkNotNullParameter(cbuf, "cbuf");
                return byteReadPacket.readAvailableCharacters$ktor_io(cbuf, off, len);
            }
        };
    }

    public static final OutputStream outputStream(final BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        return new OutputStream() { // from class: io.ktor.utils.io.streams.StreamsKt.outputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream
            public void write(int b) {
                bytePacketBuilder.writeByte((byte) b);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b, int off, int len) {
                Intrinsics.checkNotNullParameter(b, "b");
                io.ktor.utils.io.core.OutputKt.writeFully((Output) bytePacketBuilder, b, off, len);
            }
        };
    }

    public static final Writer writerUTF8(final BytePacketBuilder bytePacketBuilder) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        return new Writer() { // from class: io.ktor.utils.io.streams.StreamsKt.writerUTF8.1
            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.Writer
            public void write(char[] cbuf, int off, int len) {
                Intrinsics.checkNotNullParameter(cbuf, "cbuf");
                bytePacketBuilder.append(cbuf, off, len + off);
            }
        };
    }

    public static final void writePacket(OutputStream outputStream, Function1<? super BytePacketBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(builder, "builder");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        try {
            builder.invoke(bytePacketBuilder);
            writePacket(outputStream, bytePacketBuilder.build());
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
