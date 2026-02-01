package io.ktor.util;

import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: Crypto.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b\u001a\u001d\u0010\u000b\u001a\u00020\u0005*\u00020\f2\u0006\u0010\t\u001a\u00020\u0005H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u000b\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\f\b\u0002\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"NONCE_SIZE_IN_BYTES", "", SdkConstants.ATTR_DIGITS, "", "generateNonce", "", ContentDisposition.Parameters.Size, "hex", "", "bytes", "s", "build", "Lio/ktor/util/Digest;", "(Lio/ktor/util/Digest;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "string", HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/util/Digest;Ljava/lang/String;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "io/ktor/util/CryptoKt")
/* loaded from: classes6.dex */
final /* synthetic */ class CryptoKt__CryptoKt {
    private static final char[] digits = CharsetKt.toCharArray("0123456789abcdef");

    public static final String hex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr = new char[bytes.length * 2];
        char[] cArr2 = digits;
        int i = 0;
        for (byte b : bytes) {
            int i2 = i + 1;
            cArr[i] = cArr2[(b & 255) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final byte[] hex(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        int length = s.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Integer.parseInt(String.valueOf(s.charAt(i2 + 1)), CharsKt.checkRadix(16)) | (Integer.parseInt(String.valueOf(s.charAt(i2)), CharsKt.checkRadix(16)) << 4));
        }
        return bArr;
    }

    @InternalAPI
    public static final Object build(Digest digest, byte[] bArr, Continuation<? super byte[]> continuation) {
        digest.plusAssign(bArr);
        return digest.build(continuation);
    }

    public static /* synthetic */ Object build$default(Digest digest, String str, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return CryptoKt.build(digest, str, charset, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final byte[] generateNonce(int i) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        while (bytePacketBuilder.getSize() < i) {
            try {
                io.ktor.utils.io.core.StringsKt.writeText$default(bytePacketBuilder, CryptoKt.generateNonce(), 0, 0, (Charset) null, 14, (Object) null);
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        }
        return io.ktor.utils.io.core.StringsKt.readBytes(bytePacketBuilder.build(), i);
    }

    @InternalAPI
    public static final Object build(Digest digest, String str, Charset charset, Continuation<? super byte[]> continuation) {
        byte[] bArrEncodeToByteArray;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArrEncodeToByteArray = StringsKt.encodeToByteArray(str);
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrEncodeToByteArray = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
        }
        digest.plusAssign(bArrEncodeToByteArray);
        return digest.build(continuation);
    }
}
