package io.ktor.utils.io.charsets;

import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.jvm.ErrorsKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: CharsetJVM.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0015\u001a\u00020\u0001*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u0001\u001a6\u0010\u001c\u001a\u00020\u0001*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0000\u001a\u001e\u0010!\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001\u001a \u0010#\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a \u0010$\u001a\u00020\u0012*\u00060\nj\u0002`\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a\u0018\u0010%\u001a\u00020 *\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0018\u001a\u00020\u001dH\u0000\u001a0\u0010&\u001a\u00020\u0001*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001dH\u0000\u001a*\u0010*\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u0001\u001a(\u0010,\u001a\u00020+*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u0001H\u0002\u001a\u001e\u0010-\u001a\u00020.*\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0016\u001a\u00020/2\u0006\u0010\u0018\u001a\u000200\u001a\f\u00101\u001a\u00020.*\u000202H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00060\nj\u0002`\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001d\u0010\u0007\u001a\u00060\bj\u0002`\t*\u00060\u000ej\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010\"\u0019\u0010\u0011\u001a\u00020\u0012*\u00060\bj\u0002`\t8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014*\n\u00103\"\u00020\b2\u00020\b*\n\u00104\"\u00020\n2\u00020\n*\n\u00105\"\u00020\u000e2\u00020\u000e*\n\u00106\"\u0002072\u000207¨\u00068"}, d2 = {"DECODE_CHAR_BUFFER_SIZE", "", "EmptyByteBuffer", "Ljava/nio/ByteBuffer;", "EmptyCharBuffer", "Ljava/nio/CharBuffer;", "kotlin.jvm.PlatformType", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "getCharset", "(Ljava/nio/charset/CharsetDecoder;)Ljava/nio/charset/Charset;", "Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "(Ljava/nio/charset/CharsetEncoder;)Ljava/nio/charset/Charset;", "name", "", "getName", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "decode", "input", "Lio/ktor/utils/io/core/Input;", "dst", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "decodeBuffer", "Lio/ktor/utils/io/core/Buffer;", "out", "lastBuffer", "", "decodeExactBytes", "inputLength", "decodeImplByteBuffer", "decodeImplSlow", "encodeComplete", "encodeImpl", "", "fromIndex", "toIndex", "encodeToByteArray", "", "encodeToByteArraySlow", "encodeUTF8", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/Output;", "throwExceptionWrapped", "Ljava/nio/charset/CoderResult;", "Charset", "CharsetDecoder", "CharsetEncoder", "Charsets", "Lkotlin/text/Charsets;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CharsetJVMKt {
    private static final int DECODE_CHAR_BUFFER_SIZE = 8192;
    private static final ByteBuffer EmptyByteBuffer;
    private static final CharBuffer EmptyCharBuffer = CharBuffer.allocate(0);

    public static /* synthetic */ void Charset$annotations() {
    }

    public static final String getName(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String strName = charset.name();
        Intrinsics.checkNotNullExpressionValue(strName, "name()");
        return strName;
    }

    public static final Charset getCharset(CharsetEncoder charsetEncoder) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Charset charset = charsetEncoder.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset()");
        return charset;
    }

    public static final byte[] encodeToByteArray(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (input instanceof String) {
            if (i == 0 && i2 == input.length()) {
                byte[] bytes = ((String) input).getBytes(charsetEncoder.charset());
                Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
                return bytes;
            }
            String strSubstring = ((String) input).substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
            return bytes2;
        }
        return encodeToByteArraySlow(charsetEncoder, input, i, i2);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return encodeToByteArray(charsetEncoder, charSequence, i, i2);
    }

    private static final byte[] encodeToByteArraySlow(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) throws CharacterCodingException {
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            byte[] bArrArray = byteBufferEncode.array();
            if (bArrArray.length == byteBufferEncode.remaining()) {
                bArr = bArrArray;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    public static final int encodeImpl(CharsetEncoder charsetEncoder, CharSequence input, int i, int i2, Buffer dst) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer charBufferWrap = CharBuffer.wrap(input, i, i2);
        int iRemaining = charBufferWrap.remaining();
        ByteBuffer memory = dst.getMemory();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, writePosition, limit);
        CoderResult result = charsetEncoder.encode(charBufferWrap, byteBufferM8822slice87lwejk, false);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        if (byteBufferM8822slice87lwejk.limit() != limit) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(byteBufferM8822slice87lwejk.position());
        return iRemaining - charBufferWrap.remaining();
    }

    public static final void encodeUTF8(CharsetEncoder charsetEncoder, ByteReadPacket input, Output dst) throws Throwable {
        ChunkBuffer chunkBuffer;
        int i;
        int i2;
        int i3;
        char cLowSurrogate;
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (getCharset(charsetEncoder) == Charsets.UTF_8) {
            dst.writePacket(input);
            return;
        }
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        try {
            ChunkBuffer chunkBuffer2 = chunkBufferBorrow;
            int limit = chunkBuffer2.getLimit() - chunkBuffer2.getWritePosition();
            if (limit < 0) {
                throw new IllegalArgumentException(("size 0 is greater than buffer's remaining capacity " + limit).toString());
            }
            ByteBuffer byteBufferDuplicate = chunkBufferBorrow.getMemory().duplicate();
            Intrinsics.checkNotNull(byteBufferDuplicate);
            int writePosition = chunkBufferBorrow.getWritePosition();
            byteBufferDuplicate.limit(chunkBufferBorrow.getLimit());
            byteBufferDuplicate.position(writePosition);
            CharBuffer charBufferAsCharBuffer = byteBufferDuplicate.asCharBuffer();
            while (input.getRemaining() > 0) {
                try {
                    charBufferAsCharBuffer.clear();
                    ChunkBuffer chunkBufferPrepareReadHead$ktor_io = input.prepareReadHead$ktor_io(1);
                    if (chunkBufferPrepareReadHead$ktor_io == null) {
                        break;
                    }
                    ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadHead$ktor_io;
                    ByteBuffer memory = chunkBuffer3.getMemory();
                    int readPosition = chunkBuffer3.getReadPosition();
                    int writePosition2 = chunkBuffer3.getWritePosition();
                    int i4 = readPosition;
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        if (i4 >= writePosition2) {
                            chunkBuffer = chunkBufferBorrow;
                            i = writePosition;
                            i2 = limit;
                            chunkBuffer3.discardExact(writePosition2 - readPosition);
                            i3 = 0;
                            break;
                        }
                        byte b = memory.get(i4);
                        ByteBuffer byteBuffer = memory;
                        int i8 = b & 255;
                        chunkBuffer = chunkBufferBorrow;
                        i3 = -1;
                        if ((b & 128) == 0) {
                            if (i5 != 0) {
                                UTF8Kt.malformedByteCount(i5);
                                throw new KotlinNothingValueException();
                            }
                            char c = (char) i8;
                            try {
                                if (!charBufferAsCharBuffer.hasRemaining()) {
                                    chunkBuffer3.discardExact(i4 - readPosition);
                                    i = writePosition;
                                    i2 = limit;
                                    break;
                                }
                                charBufferAsCharBuffer.put(c);
                                i = writePosition;
                                i2 = limit;
                                i4++;
                                memory = byteBuffer;
                                chunkBufferBorrow = chunkBuffer;
                                limit = i2;
                                writePosition = i;
                            } catch (Throwable th) {
                                th = th;
                                chunkBufferBorrow = chunkBuffer;
                                chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
                                throw th;
                            }
                        } else if (i5 == 0) {
                            int i9 = 128;
                            i = writePosition;
                            i2 = limit;
                            int i10 = i5;
                            for (int i11 = 1; i11 < 7 && (i8 & i9) != 0; i11++) {
                                i8 &= ~i9;
                                i9 >>= 1;
                                i10++;
                            }
                            int i12 = i10 - 1;
                            if (i10 > writePosition2 - i4) {
                                chunkBuffer3.discardExact(i4 - readPosition);
                                i3 = i10;
                                break;
                            }
                            i5 = i12;
                            i7 = i10;
                            i6 = i8;
                            i4++;
                            memory = byteBuffer;
                            chunkBufferBorrow = chunkBuffer;
                            limit = i2;
                            writePosition = i;
                        } else {
                            i = writePosition;
                            i2 = limit;
                            int i13 = (i6 << 6) | (b & 127);
                            i5--;
                            if (i5 != 0) {
                                i6 = i13;
                            } else if (UTF8Kt.isBmpCodePoint(i13)) {
                                cLowSurrogate = (char) i13;
                                if (!charBufferAsCharBuffer.hasRemaining()) {
                                    chunkBuffer3.discardExact(((i4 - readPosition) - i7) + 1);
                                    break;
                                }
                                charBufferAsCharBuffer.put(cLowSurrogate);
                                i6 = 0;
                            } else {
                                if (!UTF8Kt.isValidCodePoint(i13)) {
                                    UTF8Kt.malformedCodePoint(i13);
                                    throw new KotlinNothingValueException();
                                }
                                char cHighSurrogate = (char) UTF8Kt.highSurrogate(i13);
                                if (!charBufferAsCharBuffer.hasRemaining()) {
                                    break;
                                }
                                charBufferAsCharBuffer.put(cHighSurrogate);
                                cLowSurrogate = (char) UTF8Kt.lowSurrogate(i13);
                                if (!charBufferAsCharBuffer.hasRemaining()) {
                                    break;
                                }
                                charBufferAsCharBuffer.put(cLowSurrogate);
                                i6 = 0;
                            }
                            i4++;
                            memory = byteBuffer;
                            chunkBufferBorrow = chunkBuffer;
                            limit = i2;
                            writePosition = i;
                        }
                    }
                    chunkBuffer3.discardExact(((i4 - readPosition) - i7) + 1);
                    input.setHeadPosition(chunkBufferPrepareReadHead$ktor_io.getReadPosition());
                    charBufferAsCharBuffer.flip();
                    if (charBufferAsCharBuffer.hasRemaining()) {
                        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, 1, null);
                        int i14 = 1;
                        while (true) {
                            try {
                                ChunkBuffer chunkBuffer4 = chunkBufferPrepareWriteHead;
                                ByteBuffer memory2 = chunkBuffer4.getMemory();
                                int writePosition3 = chunkBuffer4.getWritePosition();
                                int limit2 = chunkBuffer4.getLimit() - writePosition3;
                                ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory2, writePosition3, limit2);
                                CoderResult cr = charsetEncoder.encode(charBufferAsCharBuffer, byteBufferM8822slice87lwejk, false);
                                if (cr.isUnmappable() || cr.isMalformed()) {
                                    Intrinsics.checkNotNullExpressionValue(cr, "cr");
                                    throwExceptionWrapped(cr);
                                }
                                i14 = (cr.isOverflow() && byteBufferM8822slice87lwejk.hasRemaining()) ? i14 + 1 : 1;
                                if (byteBufferM8822slice87lwejk.limit() != limit2) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                                chunkBuffer4.commitWritten(byteBufferM8822slice87lwejk.position());
                                int i15 = charBufferAsCharBuffer.hasRemaining() ? i14 : 0;
                                if (i15 <= 0) {
                                    break;
                                } else {
                                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(dst, i15, chunkBufferPrepareWriteHead);
                                }
                            } finally {
                                dst.afterHeadWrite();
                            }
                        }
                    }
                    if (i3 > 0) {
                        break;
                    }
                    chunkBufferBorrow = chunkBuffer;
                    limit = i2;
                    writePosition = i;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            chunkBuffer = chunkBufferBorrow;
            i = writePosition;
            i2 = limit;
            charBufferAsCharBuffer.clear();
            charBufferAsCharBuffer.flip();
            ChunkBuffer chunkBufferPrepareWriteHead2 = UnsafeKt.prepareWriteHead(dst, 1, null);
            int i16 = 1;
            while (true) {
                try {
                    ChunkBuffer chunkBuffer5 = chunkBufferPrepareWriteHead2;
                    ByteBuffer memory3 = chunkBuffer5.getMemory();
                    int writePosition4 = chunkBuffer5.getWritePosition();
                    int limit3 = chunkBuffer5.getLimit() - writePosition4;
                    ByteBuffer byteBufferM8822slice87lwejk2 = Memory.m8822slice87lwejk(memory3, writePosition4, limit3);
                    CoderResult cr2 = charsetEncoder.encode(charBufferAsCharBuffer, byteBufferM8822slice87lwejk2, true);
                    if (cr2.isMalformed() || cr2.isUnmappable()) {
                        Intrinsics.checkNotNullExpressionValue(cr2, "cr");
                        throwExceptionWrapped(cr2);
                    }
                    i16 = cr2.isOverflow() ? i16 + 1 : 0;
                    if (byteBufferM8822slice87lwejk2.limit() != limit3) {
                        try {
                            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                    chunkBuffer5.commitWritten(byteBufferM8822slice87lwejk2.position());
                    if (i16 <= 0) {
                        dst.afterHeadWrite();
                        int iPosition = byteBufferDuplicate.position() - i;
                        if (iPosition < 0 || iPosition > i2) {
                            ErrorsKt.wrongBufferPositionChangeError(iPosition, 0);
                            throw new KotlinNothingValueException();
                        }
                        ChunkBuffer chunkBuffer6 = chunkBuffer;
                        chunkBuffer6.commitWritten(iPosition);
                        chunkBuffer6.release(ChunkBuffer.INSTANCE.getPool());
                        return;
                    }
                    chunkBufferPrepareWriteHead2 = UnsafeKt.prepareWriteHead(dst, i16, chunkBufferPrepareWriteHead2);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static /* synthetic */ int decodeBuffer$default(CharsetDecoder charsetDecoder, Buffer buffer, Appendable appendable, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        return decodeBuffer(charsetDecoder, buffer, appendable, z, i);
    }

    public static final Charset getCharset(CharsetDecoder charsetDecoder) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNull(charset);
        return charset;
    }

    public static final int decode(CharsetDecoder charsetDecoder, Input input, Appendable dst, int i) {
        CoderResult cr;
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(dst, "dst");
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        boolean z = true;
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        int iRemaining = 0;
        if (chunkBufferPrepareReadFirstHead != null) {
            int i2 = 1;
            int i3 = 1;
            int iRemaining2 = 0;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i2) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                            int i4 = i - iRemaining2;
                            if (i4 == 0) {
                                i2 = 0;
                            } else {
                                ByteBuffer memory = chunkBuffer2.getMemory();
                                int readPosition = chunkBuffer2.getReadPosition();
                                int writePosition2 = chunkBuffer2.getWritePosition() - readPosition;
                                ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition, writePosition2);
                                charBufferAllocate.clear();
                                if (i4 < 8192) {
                                    charBufferAllocate.limit(i4);
                                }
                                CoderResult rc = charsetDecoder.decode(byteBufferM8822slice87lwejk, charBufferAllocate, false);
                                charBufferAllocate.flip();
                                iRemaining2 += charBufferAllocate.remaining();
                                dst.append(charBufferAllocate);
                                if (rc.isMalformed() || rc.isUnmappable()) {
                                    Intrinsics.checkNotNullExpressionValue(rc, "rc");
                                    throwExceptionWrapped(rc);
                                }
                                i3 = (rc.isUnderflow() && byteBufferM8822slice87lwejk.hasRemaining()) ? i3 + 1 : 1;
                                if (byteBufferM8822slice87lwejk.limit() != writePosition2) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                                chunkBuffer2.discardExact(byteBufferM8822slice87lwejk.position());
                                i2 = i3;
                            }
                            writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                        } finally {
                            chunkBuffer = chunkBufferPrepareReadFirstHead;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i2) {
                        ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                        if (chunkBuffer3.getCapacity() - chunkBuffer3.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i2);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i2);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        break;
                    }
                    if (i2 <= 0) {
                        iRemaining = 1;
                        chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                        break;
                    }
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (iRemaining != 0) {
                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            }
            iRemaining = iRemaining2;
        }
        do {
            charBufferAllocate.clear();
            int i5 = i - iRemaining;
            if (i5 == 0) {
                break;
            }
            if (i5 < 8192) {
                charBufferAllocate.limit(i5);
            }
            cr = charsetDecoder.decode(EmptyByteBuffer, charBufferAllocate, true);
            charBufferAllocate.flip();
            iRemaining += charBufferAllocate.remaining();
            dst.append(charBufferAllocate);
            if (cr.isUnmappable() || cr.isMalformed()) {
                Intrinsics.checkNotNullExpressionValue(cr, "cr");
                throwExceptionWrapped(cr);
            }
        } while (cr.isOverflow());
        return iRemaining;
    }

    public static final String decodeExactBytes(CharsetDecoder charsetDecoder, Input input, int i) throws EOFException {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i == 0) {
            return "";
        }
        if (input.getHeadEndExclusive() - input.getHeadPosition() >= i) {
            if (input.getHeadMemory().hasArray()) {
                ByteBuffer headMemory = input.getHeadMemory();
                byte[] bArrArray = headMemory.array();
                Intrinsics.checkNotNullExpressionValue(bArrArray, "bb.array()");
                int iArrayOffset = headMemory.arrayOffset() + headMemory.position() + input.getHead().getReadPosition();
                Charset charset = charsetDecoder.charset();
                Intrinsics.checkNotNullExpressionValue(charset, "charset()");
                String str = new String(bArrArray, iArrayOffset, i, charset);
                input.discardExact(i);
                return str;
            }
            return decodeImplByteBuffer(charsetDecoder, input, i);
        }
        return decodeImplSlow(charsetDecoder, input, i);
    }

    private static final String decodeImplByteBuffer(CharsetDecoder charsetDecoder, Input input, int i) throws CharacterCodingException, EOFException {
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(input.getHeadMemory(), input.getHead().getReadPosition(), i);
        CoderResult rc = charsetDecoder.decode(byteBufferM8822slice87lwejk, charBufferAllocate, true);
        if (rc.isMalformed() || rc.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(rc, "rc");
            throwExceptionWrapped(rc);
        }
        charBufferAllocate.flip();
        input.discardExact(byteBufferM8822slice87lwejk.position());
        String string = charBufferAllocate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "cb.toString()");
        return string;
    }

    private static final String decodeImplSlow(CharsetDecoder charsetDecoder, Input input, int i) throws Throwable {
        int iPosition;
        ChunkBuffer chunkBuffer;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        boolean z;
        boolean z2;
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        boolean z3 = true;
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            iPosition = i;
            z2 = false;
        } else {
            iPosition = i;
            int i2 = 1;
            int i3 = 1;
            boolean z4 = false;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= i2) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                            if (!charBufferAllocate.hasRemaining() || iPosition == 0) {
                                i2 = 0;
                            } else {
                                ByteBuffer memory = chunkBuffer2.getMemory();
                                int readPosition = chunkBuffer2.getReadPosition();
                                int writePosition2 = chunkBuffer2.getWritePosition() - readPosition;
                                ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition, writePosition2);
                                int iLimit = byteBufferM8822slice87lwejk.limit();
                                int iPosition2 = byteBufferM8822slice87lwejk.position();
                                boolean z5 = iLimit - iPosition2 >= iPosition;
                                if (z5) {
                                    byteBufferM8822slice87lwejk.limit(iPosition2 + iPosition);
                                }
                                CoderResult rc = charsetDecoder.decode(byteBufferM8822slice87lwejk, charBufferAllocate, z5);
                                if (rc.isMalformed() || rc.isUnmappable()) {
                                    Intrinsics.checkNotNullExpressionValue(rc, "rc");
                                    throwExceptionWrapped(rc);
                                }
                                i3 = (rc.isUnderflow() && byteBufferM8822slice87lwejk.hasRemaining()) ? i3 + 1 : 1;
                                byteBufferM8822slice87lwejk.limit(iLimit);
                                iPosition -= byteBufferM8822slice87lwejk.position() - iPosition2;
                                if (byteBufferM8822slice87lwejk.limit() != writePosition2) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed".toString());
                                }
                                chunkBuffer2.discardExact(byteBufferM8822slice87lwejk.position());
                                i2 = i3;
                                z4 = z5;
                            }
                            ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                        } finally {
                            chunkBuffer = chunkBufferPrepareReadFirstHead;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z3 = false;
                            if (z3) {
                                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= i2) {
                        ChunkBuffer chunkBuffer4 = chunkBufferPrepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i2);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i2);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z = false;
                        break;
                    }
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (i2 <= 0) {
                        z = true;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z) {
                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            }
            z2 = z4;
        }
        if (charBufferAllocate.hasRemaining() && !z2) {
            CoderResult rc2 = charsetDecoder.decode(EmptyByteBuffer, charBufferAllocate, true);
            if (rc2.isMalformed() || rc2.isUnmappable()) {
                Intrinsics.checkNotNullExpressionValue(rc2, "rc");
                throwExceptionWrapped(rc2);
            }
        }
        if (iPosition > 0) {
            throw new EOFException("Not enough bytes available: had only " + (i - iPosition) + " instead of " + i);
        }
        if (iPosition < 0) {
            throw new AssertionError("remainingInputBytes < 0");
        }
        charBufferAllocate.flip();
        String string = charBufferAllocate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "cb.toString()");
        return string;
    }

    private static final void throwExceptionWrapped(CoderResult coderResult) throws CharacterCodingException {
        try {
            coderResult.throwException();
        } catch (java.nio.charset.MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(byteBufferAllocate);
        EmptyByteBuffer = byteBufferAllocate;
    }

    public static final boolean encodeComplete(CharsetEncoder charsetEncoder, Buffer dst) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer memory = dst.getMemory();
        int writePosition = dst.getWritePosition();
        int limit = dst.getLimit() - writePosition;
        ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, writePosition, limit);
        CoderResult result = charsetEncoder.encode(EmptyCharBuffer, byteBufferM8822slice87lwejk, true);
        if (result.isMalformed() || result.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            throwExceptionWrapped(result);
        }
        boolean zIsUnderflow = result.isUnderflow();
        if (byteBufferM8822slice87lwejk.limit() != limit) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        dst.commitWritten(byteBufferM8822slice87lwejk.position());
        return zIsUnderflow;
    }

    public static final int decodeBuffer(CharsetDecoder charsetDecoder, Buffer input, Appendable out, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(out, "out");
        ByteBuffer memory = input.getMemory();
        int readPosition = input.getReadPosition();
        int writePosition = input.getWritePosition() - readPosition;
        ByteBuffer byteBufferM8822slice87lwejk = Memory.m8822slice87lwejk(memory, readPosition, writePosition);
        ChunkBuffer chunkBufferBorrow = ChunkBuffer.INSTANCE.getPool().borrow();
        CharBuffer charBufferAsCharBuffer = chunkBufferBorrow.getMemory().asCharBuffer();
        int i2 = 0;
        while (byteBufferM8822slice87lwejk.hasRemaining() && i2 < i) {
            try {
                int iMin = Math.min(charBufferAsCharBuffer.capacity(), i - i2);
                charBufferAsCharBuffer.clear();
                charBufferAsCharBuffer.limit(iMin);
                CoderResult result = charsetDecoder.decode(byteBufferM8822slice87lwejk, charBufferAsCharBuffer, z);
                if (result.isMalformed() || result.isUnmappable()) {
                    Intrinsics.checkNotNullExpressionValue(result, "result");
                    throwExceptionWrapped(result);
                }
                i2 += iMin;
            } catch (Throwable th) {
                chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
                throw th;
            }
        }
        chunkBufferBorrow.release(ChunkBuffer.INSTANCE.getPool());
        if (byteBufferM8822slice87lwejk.limit() != writePosition) {
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        }
        input.discardExact(byteBufferM8822slice87lwejk.position());
        return i2;
    }
}
