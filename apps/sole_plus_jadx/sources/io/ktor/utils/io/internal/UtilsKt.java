package io.ktor.utils.io.internal;

import com.android.SdkConstants;
import com.facebook.AuthenticationTokenClaims;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0006H\u0000\u001a\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u000f\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0001H\u0000¨\u0006\u0012"}, d2 = {"getIOIntProperty", "", "name", "", SdkConstants.SKIN_DEFAULT, "indexOfPartial", "Ljava/nio/ByteBuffer;", AuthenticationTokenClaims.JSON_KEY_SUB, "isEmpty", "", "putAtMost", "src", "n", "putLimited", "limit", "startsWith", "prefix", "prefixSkip", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilsKt {
    public static final boolean isEmpty(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        return !byteBuffer.hasRemaining();
    }

    public static final int getIOIntProperty(String name, int i) {
        String property;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            property = System.getProperty("io.ktor.utils.io." + name);
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (intOrNull = kotlin.text.StringsKt.toIntOrNull(property)) == null) ? i : intOrNull.intValue();
    }

    public static final int indexOfPartial(ByteBuffer byteBuffer, ByteBuffer sub) {
        int i;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(sub, "sub");
        int iPosition = sub.position();
        int iRemaining = sub.remaining();
        byte b = sub.get(iPosition);
        int iLimit = byteBuffer.limit();
        loop0: for (int iPosition2 = byteBuffer.position(); iPosition2 < iLimit; iPosition2++) {
            if (byteBuffer.get(iPosition2) == b) {
                while (i < iRemaining) {
                    int i2 = iPosition2 + i;
                    if (i2 == iLimit) {
                        break loop0;
                    }
                    i = byteBuffer.get(i2) == sub.get(iPosition + i) ? i + 1 : 1;
                }
                return iPosition2 - byteBuffer.position();
            }
        }
        return -1;
    }

    public static /* synthetic */ boolean startsWith$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return startsWith(byteBuffer, byteBuffer2, i);
    }

    public static final boolean startsWith(ByteBuffer byteBuffer, ByteBuffer prefix, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        int iMin = Math.min(byteBuffer.remaining(), prefix.remaining() - i);
        if (iMin <= 0) {
            return false;
        }
        int iPosition = byteBuffer.position();
        int iPosition2 = prefix.position() + i;
        for (int i2 = 0; i2 < iMin; i2++) {
            if (byteBuffer.get(iPosition + i2) != prefix.get(iPosition2 + i2)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ int putAtMost$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer2.remaining();
        }
        return putAtMost(byteBuffer, byteBuffer2, i);
    }

    public static final int putAtMost(ByteBuffer byteBuffer, ByteBuffer src, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        int iRemaining = byteBuffer.remaining();
        int iRemaining2 = src.remaining();
        if (iRemaining2 <= iRemaining && iRemaining2 <= i) {
            byteBuffer.put(src);
        } else {
            iRemaining2 = Math.min(iRemaining, Math.min(iRemaining2, i));
            int i2 = 1;
            if (1 <= iRemaining2) {
                while (true) {
                    byteBuffer.put(src.get());
                    if (i2 == iRemaining2) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return iRemaining2;
    }

    public static /* synthetic */ int putLimited$default(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.limit();
        }
        return putLimited(byteBuffer, byteBuffer2, i);
    }

    public static final int putLimited(ByteBuffer byteBuffer, ByteBuffer src, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        return putAtMost(byteBuffer, src, i - src.position());
    }
}
