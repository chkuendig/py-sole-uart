package io.ktor.http.websocket;

import io.ktor.util.Base64Kt;
import io.ktor.util.CryptoKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"WEBSOCKET_SERVER_ACCEPT_TAIL", "", "websocketServerAccept", "nonce", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    private static final String WEBSOCKET_SERVER_ACCEPT_TAIL = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    public static final String websocketServerAccept(String nonce) {
        byte[] bArrEncodeToByteArray;
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        String str = StringsKt.trim((CharSequence) nonce).toString() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        Charset charset = Charsets.ISO_8859_1;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArrEncodeToByteArray = StringsKt.encodeToByteArray(str);
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrEncodeToByteArray = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, str, 0, str.length());
        }
        return Base64Kt.encodeBase64(CryptoKt.sha1(bArrEncodeToByteArray));
    }
}
