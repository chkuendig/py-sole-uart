package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferPrimitivesKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Encoding.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a.\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010\u001a*\u0010\b\u001a\u00020\u0011*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u001a0\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a0\u0010\u0013\u001a\u00020\u0007*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0014H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u0007*\u00060\nj\u0002`\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a,\u0010\u0016\u001a\u00020\u0017*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0007\u001a,\u0010\u0018\u001a\u00020\u0017*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u0000\u001a0\u0010\u0019\u001a\u00020\u0007*\u00060\nj\u0002`\u000b2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\u001b\u001a\u00020\u0011*\u00060\nj\u0002`\u000b2\u0006\u0010\u0004\u001a\u00020\u0011\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0000¨\u0006\u001e"}, d2 = {"decode", "", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "input", "Lio/ktor/utils/io/core/Input;", "max", "", "encode", "", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "fromIndex", "toIndex", "dst", "Lio/ktor/utils/io/core/Output;", "Lio/ktor/utils/io/core/ByteReadPacket;", "", "encodeArrayImpl", "Lio/ktor/utils/io/core/Buffer;", "encodeCompleteImpl", "encodeToByteArrayImpl", "", "encodeToByteArrayImpl1", "encodeToImpl", "destination", "encodeUTF8", "sizeEstimate", "", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EncodingKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use writeText on Output instead.", replaceWith = @ReplaceWith(expression = "dst.writeText(input, fromIndex, toIndex, charset)", imports = {"io.ktor.utils.io.core.writeText"}))
    public static final void encode(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2, Output dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        encodeToImpl(charsetEncoder, dst, input, i, i2);
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArrayImpl(charsetEncoder, charSequence, i, i2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Internal API. Will be hidden in future releases. Use encodeToByteArray instead.", replaceWith = @ReplaceWith(expression = "encodeToByteArray(input, fromIndex, toIndex)", imports = {}))
    public static final byte[] encodeToByteArrayImpl(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        return CharsetJVMKt.encodeToByteArray(charsetEncoder, input, i, i2);
    }

    public static /* synthetic */ ByteReadPacket encode$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encode(charsetEncoder, charSequence, i, i2);
    }

    public static /* synthetic */ String decode$default(CharsetDecoder charsetDecoder, Input input, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decode(charsetDecoder, input, i);
    }

    public static final String decode(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min(i, sizeEstimate(input)));
        CharsetJVMKt.decode(charsetDecoder, input, sb, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final int encodeArrayImpl(CharsetEncoder charsetEncoder, char[] input, int i, int i2, Buffer dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        int i3 = i2 - i;
        return CharsetJVMKt.encodeImpl(charsetEncoder, new CharArraySequence(input, i, i3), 0, i3, dst);
    }

    public static /* synthetic */ byte[] encodeToByteArrayImpl1$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArrayImpl1(charsetEncoder, charSequence, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final byte[] encodeToByteArrayImpl1(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        byte[] bytes$default;
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i >= i2) {
            return UnsafeKt.EmptyByteArray;
        }
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        try {
            int iEncodeImpl = i + CharsetJVMKt.encodeImpl(charsetEncoder, input, i, i2, chunkBufferBorrow);
            if (iEncodeImpl == i2) {
                ChunkBuffer chunkBuffer = chunkBufferBorrow;
                int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                bytes$default = new byte[writePosition];
                Intrinsics.checkNotNull(chunkBufferBorrow, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
                BufferPrimitivesKt.readFully((Buffer) chunkBufferBorrow, bytes$default, 0, writePosition);
            } else {
                BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
                try {
                    bytePacketBuilder.appendSingleChunk$ktor_io(chunkBufferBorrow.duplicate());
                    encodeToImpl(charsetEncoder, bytePacketBuilder, input, iEncodeImpl, i2);
                    bytes$default = io.ktor.utils.io.core.StringsKt.readBytes$default(bytePacketBuilder.build(), 0, 1, null);
                } catch (Throwable th) {
                    bytePacketBuilder.release();
                    throw th;
                }
            }
            return bytes$default;
        } finally {
            chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
        }
    }

    public static final long sizeEstimate(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input instanceof ByteReadPacket ? input.getRemaining() : Math.max(input.getRemaining(), 16L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ByteReadPacket encode(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            encodeToImpl(charsetEncoder, bytePacketBuilder, input, i, i2);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ByteReadPacket encodeUTF8(CharsetEncoder charsetEncoder, ByteReadPacket input) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            CharsetJVMKt.encodeUTF8(charsetEncoder, input, bytePacketBuilder);
            return bytePacketBuilder.build();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final void encode(CharsetEncoder charsetEncoder, char[] input, int i, int i2, Output dst) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (i >= i2) {
            return;
        }
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, null);
        while (true) {
            try {
                int iEncodeArrayImpl = encodeArrayImpl(charsetEncoder, input, i, i2, chunkBufferPrepareWriteHead);
                if (iEncodeArrayImpl < 0) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                i += iEncodeArrayImpl;
                int i3 = i >= i2 ? 0 : iEncodeArrayImpl == 0 ? 8 : 1;
                if (i3 > 0) {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, i3, chunkBufferPrepareWriteHead);
                } else {
                    dst.afterHeadWrite();
                    encodeCompleteImpl(charsetEncoder, dst);
                    return;
                }
            } catch (Throwable th) {
                dst.afterHeadWrite();
                throw th;
            }
        }
    }

    private static final int encodeCompleteImpl(CharsetEncoder charsetEncoder, Output output) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        int i = 1;
        int limit = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int limit2 = chunkBuffer.getLimit() - chunkBuffer.getWritePosition();
                i = CharsetJVMKt.encodeComplete(charsetEncoder, chunkBuffer) ? 0 : i + 1;
                limit += limit2 - (chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                if (i <= 0) {
                    return limit;
                }
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final int encodeToImpl(CharsetEncoder charsetEncoder, Output destination, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i >= i2) {
            return 0;
        }
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(destination, 1, null);
        int limit = 0;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int limit2 = chunkBuffer.getLimit() - chunkBuffer.getWritePosition();
                int iEncodeImpl = CharsetJVMKt.encodeImpl(charsetEncoder, input, i, i2, chunkBuffer);
                if (iEncodeImpl < 0) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                i += iEncodeImpl;
                limit += limit2 - (chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                int i3 = i >= i2 ? 0 : iEncodeImpl == 0 ? 8 : 1;
                if (i3 > 0) {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(destination, i3, chunkBufferPrepareWriteHead);
                } else {
                    destination.afterHeadWrite();
                    return limit + encodeCompleteImpl(charsetEncoder, destination);
                }
            } catch (Throwable th) {
                destination.afterHeadWrite();
                throw th;
            }
        }
    }
}
