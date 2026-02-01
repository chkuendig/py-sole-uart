package io.ktor.utils.io.core;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: StringsJVM.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\f\b\u0002\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0086\b\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¨\u0006\u000f"}, d2 = {"String", "", "bytes", "", "offset", "", SessionDescription.ATTR_LENGTH, HttpAuthHeader.Parameters.Charset, "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "getCharsInternal", "", "dst", "", "dstOffset", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StringsJVMKt {
    public static final String String(byte[] bytes, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, i, i2, charset);
    }

    public static /* synthetic */ String String$default(byte[] bytes, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bytes.length;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(bytes, i, i2, charset);
    }

    public static final void getCharsInternal(String str, char[] dst, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        str.getChars(0, str.length(), dst, i);
    }
}
