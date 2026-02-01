package io.ktor.utils.io.core;

import androidx.collection.SieveCacheKt;
import com.samsung.android.sdk.healthdata.HealthConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\n*\u00020\u000bH\u0082\b\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0010\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0003\u001a\u001e\u0010\u0011\u001a\u00020\r*\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010\u0014\u001a\u00020\u0015*\u00020\u00102\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0007\u001a.\u0010\u0014\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u001a\"\u0010 \u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\"\u0010!\u001a\u00020\u0015*\u00020\u00102\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\"\u001a\u00020\u0003H\u0007\u001a \u0010!\u001a\u00020\u0015*\u00020\u00102\u0006\u0010#\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010$\u001a\u00020\u0015*\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a \u0010%\u001a\u0004\u0018\u00010\u0015*\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u001e\u0010'\u001a\u00020\n*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010(\u001a\u00020\u0015*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a$\u0010*\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010*\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a,\u0010,\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u001d\u001a\u00020+2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a0\u0010,\u001a\u00020\u0003*\u00020\u00102\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a$\u0010.\u001a\u00020\u0003*\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020+H\u0002\u001a\u001b\u0010/\u001a\u00020\r*\u00020\u00152\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0086\b\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a4\u00100\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\f\b\u0002\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019\u001a$\u00107\u001a\u000201*\u00020+2\u0006\u00102\u001a\u0002062\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002¨\u00068"}, d2 = {"bufferLimitExceeded", "", "limit", "", "prematureEndOfStream", ContentDisposition.Parameters.Size, "", "prematureEndOfStreamToReadChars", "charactersCount", "isAsciiChar", "", "", "readBytes", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "n", "Lio/ktor/utils/io/core/Input;", "readBytesOf", HealthConstants.HeartRate.MIN, "max", "readText", "", "Lio/ktor/utils/io/core/Buffer;", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "decoder", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "readTextExact", "readTextExactBytes", "bytes", "bytesCount", "readTextExactCharacters", "readUTF8Line", "estimate", "readUTF8LineTo", "readUTF8UntilDelimiter", "delimiters", "readUTF8UntilDelimiterTo", "Lio/ktor/utils/io/core/Output;", "readUTF8UntilDelimiterToSlowUtf8", "decoded0", "readUTFUntilDelimiterToSlowAscii", "toByteArray", "writeText", "", "text", "", "fromIndex", "toIndex", "", "writeTextUtf8", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StringsKt {
    private static final boolean isAsciiChar(char c) {
        return c <= 127;
    }

    public static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return kotlin.text.StringsKt.encodeToByteArray(str);
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        return CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static /* synthetic */ String readUTF8Line$default(ByteReadPacket byteReadPacket, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadPacket, i, i2);
    }

    public static /* synthetic */ String readUTF8Line$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 16;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readUTF8Line(input, i, i2);
    }

    public static final String readUTF8Line(Input input, int i, int i2) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(input, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    public static /* synthetic */ String readUTF8UntilDelimiter$default(Input input, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiter(input, str, i);
    }

    public static final String readUTF8UntilDelimiter(Input input, String delimiters, int i) throws Throwable {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        StringBuilder sb = new StringBuilder();
        readUTF8UntilDelimiterTo(input, sb, delimiters, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Appendable appendable, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, appendable, str, i);
    }

    public static /* synthetic */ int readUTF8UntilDelimiterTo$default(Input input, Output output, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8UntilDelimiterTo(input, output, str, i);
    }

    public static final int readUTF8UntilDelimiterTo(Input input, Output out, String delimiters, int i) {
        long untilDelimiters;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        int length = delimiters.length();
        if (length == 1 && delimiters.charAt(0) <= 127) {
            untilDelimiters = ScannerKt.readUntilDelimiter(input, (byte) delimiters.charAt(0), out);
        } else if (length == 2 && delimiters.charAt(0) <= 127 && delimiters.charAt(1) <= 127) {
            untilDelimiters = ScannerKt.readUntilDelimiters(input, (byte) delimiters.charAt(0), (byte) delimiters.charAt(1), out);
        } else {
            return readUTFUntilDelimiterToSlowAscii(input, delimiters, i, out);
        }
        return (int) untilDelimiters;
    }

    public static /* synthetic */ byte[] readBytes$default(ByteReadPacket byteReadPacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long remaining = byteReadPacket.getRemaining();
            if (remaining > SieveCacheKt.NodeLinkMask) {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
            i = (int) remaining;
        }
        return readBytes(byteReadPacket, i);
    }

    public static final byte[] readBytes(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i != 0) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully((Input) byteReadPacket, bArr, 0, i);
            return bArr;
        }
        return UnsafeKt.EmptyByteArray;
    }

    public static final byte[] readBytes(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf(input, i, i);
    }

    public static final byte[] readBytes(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return readBytesOf$default(input, 0, 0, 3, null);
    }

    public static /* synthetic */ byte[] readBytesOf$default(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return readBytesOf(input, i, i2);
    }

    public static final byte[] readBytesOf(Input input, int i, int i2) throws EOFException {
        int available;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (i == i2 && i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        int i3 = 0;
        if (i == i2) {
            byte[] bArr = new byte[i];
            InputArraysKt.readFully(input, bArr, 0, i);
            return bArr;
        }
        byte[] bArrCopyOf = new byte[(int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i2, EncodingKt.sizeEstimate(input)), i)];
        while (i3 < i2 && (available = InputArraysKt.readAvailable(input, bArrCopyOf, i3, Math.min(i2, bArrCopyOf.length) - i3)) > 0) {
            i3 += available;
            if (bArrCopyOf.length == i3) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3 * 2);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
            }
        }
        if (i3 < i) {
            throw new EOFException("Not enough bytes available to read " + i + " bytes: " + (i - i3) + " more required");
        }
        if (i3 == bArrCopyOf.length) {
            return bArrCopyOf;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i3);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    public static /* synthetic */ int readText$default(Input input, Appendable appendable, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 4) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, appendable, charset, i);
    }

    public static final int readText(Input input, Appendable out, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decode(charsetDecoderNewDecoder, input, out, i);
    }

    public static /* synthetic */ String readText$default(Input input, CharsetDecoder charsetDecoder, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charsetDecoder, i);
    }

    @Deprecated(message = "Use CharsetDecoder.decode instead", replaceWith = @ReplaceWith(expression = "decoder.decode(this, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final String readText(Input input, CharsetDecoder decoder, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return EncodingKt.decode(decoder, input, i);
    }

    public static /* synthetic */ String readText$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(input, charset, i);
    }

    public static final String readText(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return EncodingKt.decode(charsetDecoderNewDecoder, input, i);
    }

    public static final String readText(Buffer buffer, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        CharsetJVMKt.decodeBuffer(charsetDecoderNewDecoder, buffer, sb, true, i);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String readText$default(Buffer buffer, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readText(buffer, charset, i);
    }

    public static /* synthetic */ String readTextExact$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExact(input, charset, i);
    }

    @Deprecated(message = "Use readTextExactCharacters instead.", replaceWith = @ReplaceWith(expression = "readTextExactCharacters(n, charset)", imports = {}))
    public static final String readTextExact(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactCharacters(input, i, charset);
    }

    public static /* synthetic */ String readTextExactCharacters$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactCharacters(input, i, charset);
    }

    public static final String readTextExactCharacters(Input input, int i, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String text = readText(input, charset, i);
        if (text.length() >= i) {
            return text;
        }
        prematureEndOfStreamToReadChars(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, charset, i);
    }

    @Deprecated(message = "Parameters order is changed.", replaceWith = @ReplaceWith(expression = "readTextExactBytes(bytes, charset)", imports = {}))
    public static final String readTextExactBytes(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readTextExactBytes(input, i, charset);
    }

    public static /* synthetic */ String readTextExactBytes$default(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return readTextExactBytes(input, i, charset);
    }

    public static final String readTextExactBytes(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        return CharsetJVMKt.decodeExactBytes(charsetDecoderNewDecoder, input, i);
    }

    public static /* synthetic */ void writeText$default(Output output, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, charSequence, i, i2, charset);
    }

    public static final void writeText(Output output, CharSequence text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, text, i, i2);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        EncodingKt.encodeToImpl(charsetEncoderNewEncoder, output, text, i, i2);
    }

    public static /* synthetic */ void writeText$default(Output output, char[] cArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(output, cArr, i, i2, charset);
    }

    public static final void writeText(Output output, char[] text, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            writeTextUtf8(output, new CharArraySequence(text, 0, text.length), i, i2);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
        EncodingKt.encode(charsetEncoderNewEncoder, text, i, i2, output);
    }

    private static final Void bufferLimitExceeded(int i) throws BufferLimitExceededException {
        throw new BufferLimitExceededException("Too many characters before delimiter: limit " + i + " exceeded");
    }

    public static final Void prematureEndOfStream(int i) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + i + " bytes");
    }

    public static final Void prematureEndOfStream(long j) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + j + " bytes");
    }

    private static final Void prematureEndOfStreamToReadChars(int i) throws EOFException {
        throw new EOFException("Not enough input bytes to read " + i + " characters.");
    }

    public static final String readUTF8Line(ByteReadPacket byteReadPacket, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (byteReadPacket.getEndOfInput()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        if (readUTF8LineTo(byteReadPacket, sb, i2)) {
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
    
        r3 = r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x016f A[EDGE_INSN: B:171:0x016f->B:100:0x016f BREAK  A[LOOP:1: B:10:0x0044->B:106:0x0191], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013c A[Catch: all -> 0x01c0, TryCatch #0 {all -> 0x01c0, blocks: (B:9:0x002e, B:11:0x0046, B:14:0x005a, B:27:0x007f, B:109:0x01a5, B:112:0x01ac, B:106:0x0191, B:25:0x0075, B:30:0x0089, B:31:0x0091, B:32:0x0092, B:33:0x009a, B:38:0x00a4, B:40:0x00a8, B:41:0x00b1, B:43:0x00b7, B:45:0x00c9, B:47:0x00d3, B:49:0x00d9, B:62:0x00fe, B:60:0x00f4, B:63:0x0108, B:64:0x0110, B:65:0x0111, B:67:0x0117, B:81:0x013c, B:93:0x0159, B:98:0x0166, B:99:0x016e, B:100:0x016f, B:79:0x0134, B:101:0x017d, B:102:0x0185, B:103:0x0186, B:104:0x018e, B:107:0x0198), top: B:152:0x002e, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean readUTF8LineTo(io.ktor.utils.io.core.Input r21, java.lang.Appendable r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8LineTo(io.ktor.utils.io.core.Input, java.lang.Appendable, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
    
        bufferLimitExceeded(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int readUTF8UntilDelimiterTo(io.ktor.utils.io.core.Input r17, java.lang.Appendable r18, java.lang.String r19, int r20) throws java.lang.Throwable {
        /*
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "out"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "delimiters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r4)
            r6 = 0
            if (r5 != 0) goto L22
            r7 = r6
            goto L8a
        L22:
            r7 = r6
            r8 = r7
        L24:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch: java.lang.Throwable -> L96
            java.nio.ByteBuffer r10 = r9.getMemory()     // Catch: java.lang.Throwable -> L96
            int r11 = r9.getReadPosition()     // Catch: java.lang.Throwable -> L96
            int r12 = r9.getWritePosition()     // Catch: java.lang.Throwable -> L96
            r13 = r11
        L34:
            if (r13 >= r12) goto L74
            byte r14 = r10.get(r13)     // Catch: java.lang.Throwable -> L96
            r15 = r14 & 255(0xff, float:3.57E-43)
            r4 = 128(0x80, float:1.8E-43)
            r14 = r14 & r4
            if (r14 == r4) goto L6c
            char r4 = (char) r15     // Catch: java.lang.Throwable -> L96
            r14 = r2
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch: java.lang.Throwable -> L96
            r15 = 2
            r16 = r8
            r8 = 0
            boolean r8 = kotlin.text.StringsKt.contains$default(r14, r4, r6, r15, r8)     // Catch: java.lang.Throwable -> L96
            if (r8 == 0) goto L52
            r4 = r6
            r8 = 1
            goto L5c
        L52:
            if (r7 == r3) goto L63
            int r7 = r7 + 1
            r0.append(r4)     // Catch: java.lang.Throwable -> L96
            r8 = r16
            r4 = 1
        L5c:
            if (r4 != 0) goto L5f
            goto L6e
        L5f:
            int r13 = r13 + 1
            r4 = 1
            goto L34
        L63:
            bufferLimitExceeded(r20)     // Catch: java.lang.Throwable -> L96
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L96
            r0.<init>()     // Catch: java.lang.Throwable -> L96
            throw r0     // Catch: java.lang.Throwable -> L96
        L6c:
            r16 = r8
        L6e:
            int r13 = r13 - r11
            r9.discardExact(r13)     // Catch: java.lang.Throwable -> L96
            r4 = r6
            goto L7d
        L74:
            r16 = r8
            int r12 = r12 - r11
            r9.discardExact(r12)     // Catch: java.lang.Throwable -> L96
            r8 = r16
            r4 = 1
        L7d:
            if (r4 != 0) goto L83
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
            goto L89
        L83:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch: java.lang.Throwable -> L93
            if (r5 != 0) goto L91
        L89:
            r6 = r8
        L8a:
            if (r6 != 0) goto L90
            int r7 = readUTF8UntilDelimiterToSlowUtf8(r1, r0, r2, r3, r7)
        L90:
            return r7
        L91:
            r4 = 1
            goto L24
        L93:
            r0 = move-exception
            r4 = r6
            goto L98
        L96:
            r0 = move-exception
            r4 = 1
        L98:
            if (r4 == 0) goto L9d
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        L9d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8UntilDelimiterTo(io.ktor.utils.io.core.Input, java.lang.Appendable, java.lang.String, int):int");
    }

    private static final void writeTextUtf8(Output output, CharSequence charSequence, int i, int i2) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iM9074encodeUTF8lBXzO7A = UTF8Kt.m9074encodeUTF8lBXzO7A(chunkBuffer.getMemory(), charSequence, i, i2, chunkBuffer.getWritePosition(), chunkBuffer.getLimit());
                short sM9063component1Mh2AYeg = EncodeResult.m9063component1Mh2AYeg(iM9074encodeUTF8lBXzO7A);
                short sM9064component2Mh2AYeg = EncodeResult.m9064component2Mh2AYeg(iM9074encodeUTF8lBXzO7A);
                int i3 = sM9063component1Mh2AYeg & UShort.MAX_VALUE;
                i += i3;
                chunkBuffer.commitWritten(sM9064component2Mh2AYeg & UShort.MAX_VALUE);
                int i4 = (i3 != 0 || i >= i2) ? i < i2 ? 1 : 0 : 8;
                if (i4 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i4, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        bufferLimitExceeded(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUTFUntilDelimiterToSlowAscii(io.ktor.utils.io.core.Input r18, java.lang.String r19, int r20, io.ktor.utils.io.core.Output r21) throws java.lang.Throwable {
        /*
            r1 = r18
            r0 = r19
            r2 = r20
            r3 = r21
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r1, r4)
            if (r5 != 0) goto L13
            r6 = 0
            r7 = 0
            goto L9a
        L13:
            r7 = 0
            r8 = 0
        L15:
            r9 = r5
            io.ktor.utils.io.core.Buffer r9 = (io.ktor.utils.io.core.Buffer) r9     // Catch: java.lang.Throwable -> Lad
            int r10 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lad
            int r11 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lad
            int r10 = r10 - r11
            java.nio.ByteBuffer r11 = r9.getMemory()     // Catch: java.lang.Throwable -> Lad
            int r12 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lad
            int r13 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lad
            r14 = r12
        L2e:
            if (r14 >= r13) goto L71
            byte r15 = r11.get(r14)     // Catch: java.lang.Throwable -> Lad
            r4 = r15 & 255(0xff, float:3.57E-43)
            r6 = 128(0x80, float:1.8E-43)
            r15 = r15 & r6
            if (r15 == r6) goto L68
            char r4 = (char) r4     // Catch: java.lang.Throwable -> Lad
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Throwable -> Lad
            r15 = 2
            r16 = r8
            r8 = 0
            r17 = r11
            r11 = 0
            boolean r4 = kotlin.text.StringsKt.contains$default(r6, r4, r11, r15, r8)     // Catch: java.lang.Throwable -> Lad
            if (r4 == 0) goto L4f
            r4 = r11
            r8 = 1
            goto L56
        L4f:
            if (r7 == r2) goto L5f
            int r7 = r7 + 1
            r8 = r16
            r4 = 1
        L56:
            if (r4 != 0) goto L59
            goto L6b
        L59:
            int r14 = r14 + 1
            r11 = r17
            r4 = 1
            goto L2e
        L5f:
            bufferLimitExceeded(r20)     // Catch: java.lang.Throwable -> Lad
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> Lad
            r0.<init>()     // Catch: java.lang.Throwable -> Lad
            throw r0     // Catch: java.lang.Throwable -> Lad
        L68:
            r16 = r8
            r11 = 0
        L6b:
            int r14 = r14 - r12
            r9.discardExact(r14)     // Catch: java.lang.Throwable -> Lad
            r4 = r11
            goto L7b
        L71:
            r16 = r8
            r11 = 0
            int r13 = r13 - r12
            r9.discardExact(r13)     // Catch: java.lang.Throwable -> Lad
            r8 = r16
            r4 = 1
        L7b:
            int r6 = r9.getWritePosition()     // Catch: java.lang.Throwable -> Lad
            int r12 = r9.getReadPosition()     // Catch: java.lang.Throwable -> Lad
            int r6 = r6 - r12
            int r10 = r10 - r6
            if (r10 <= 0) goto L8d
            r9.rewind(r10)     // Catch: java.lang.Throwable -> Lad
            io.ktor.utils.io.core.OutputKt.writeFully(r3, r9, r10)     // Catch: java.lang.Throwable -> Lad
        L8d:
            if (r4 != 0) goto L93
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
            goto L99
        L93:
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r1, r5)     // Catch: java.lang.Throwable -> Laa
            if (r5 != 0) goto La7
        L99:
            r6 = r8
        L9a:
            if (r6 != 0) goto La6
            boolean r4 = r18.getEndOfInput()
            if (r4 != 0) goto La6
            int r7 = readUTF8UntilDelimiterToSlowUtf8(r1, r3, r0, r2, r7)
        La6:
            return r7
        La7:
            r4 = 1
            goto L15
        Laa:
            r0 = move-exception
            r4 = r11
            goto Laf
        Lad:
            r0 = move-exception
            r4 = 1
        Laf:
            if (r4 == 0) goto Lb4
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r1, r5)
        Lb4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTFUntilDelimiterToSlowAscii(io.ktor.utils.io.core.Input, java.lang.String, int, io.ktor.utils.io.core.Output):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input r17, io.ktor.utils.io.core.Output r18, java.lang.String r19, int r20, int r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input, io.ktor.utils.io.core.Output, java.lang.String, int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input r17, java.lang.Appendable r18, java.lang.String r19, int r20, int r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.StringsKt.readUTF8UntilDelimiterToSlowUtf8(io.ktor.utils.io.core.Input, java.lang.Appendable, java.lang.String, int, int):int");
    }
}
