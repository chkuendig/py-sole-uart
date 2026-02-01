package io.ktor.utils.io.charsets;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0080\bø\u0001\u0000\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0082\b\u001a$\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0082\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"decodeASCII", "", "Ljava/nio/ByteBuffer;", "out", "", "offset", SessionDescription.ATTR_LENGTH, "predicate", "Lkotlin/Function1;", "", "", "decodeASCII3_array", "decodeASCII3_buffer", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StringsKt {
    public static /* synthetic */ int decodeASCII$default(ByteBuffer byteBuffer, char[] out, int i, int i2, Function1 predicate, int i3, Object obj) {
        int i4;
        int i5;
        boolean z = false;
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = out.length;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (byteBuffer.hasArray()) {
            int i6 = i2 + i;
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int iRemaining = byteBuffer.remaining() + iArrayOffset;
            if (i6 > out.length || iRemaining > bArrArray.length) {
                i5 = i;
            } else {
                i5 = i;
                while (true) {
                    if (iArrayOffset < iRemaining && i5 < i6) {
                        byte b = bArrArray[iArrayOffset];
                        if (b < 0) {
                            break;
                        }
                        char c = (char) b;
                        if (!((Boolean) predicate.invoke(Character.valueOf(c))).booleanValue()) {
                            iArrayOffset--;
                            break;
                        }
                        out[i5] = c;
                        i5++;
                        iArrayOffset++;
                    } else {
                        break;
                    }
                }
                byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
            }
            return i5 - i;
        }
        int i7 = i2 + i;
        if (i7 <= out.length) {
            i4 = i;
            while (byteBuffer.hasRemaining()) {
                byte b2 = byteBuffer.get();
                if (b2 >= 0 && i4 < i7) {
                    char c2 = (char) b2;
                    if (((Boolean) predicate.invoke(Character.valueOf(c2))).booleanValue()) {
                        out[i4] = c2;
                        i4++;
                    }
                }
                z = true;
            }
        } else {
            i4 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i4 - i;
    }

    public static final int decodeASCII(ByteBuffer byteBuffer, char[] out, int i, int i2, Function1<? super Character, Boolean> predicate) {
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (byteBuffer.hasArray()) {
            int i5 = i2 + i;
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int iRemaining = byteBuffer.remaining() + iArrayOffset;
            if (i5 > out.length || iRemaining > bArrArray.length) {
                i4 = i;
            } else {
                i4 = i;
                while (true) {
                    if (iArrayOffset < iRemaining && i4 < i5) {
                        byte b = bArrArray[iArrayOffset];
                        if (b < 0) {
                            break;
                        }
                        char c = (char) b;
                        if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                            iArrayOffset--;
                            break;
                        }
                        out[i4] = c;
                        i4++;
                        iArrayOffset++;
                    } else {
                        break;
                    }
                }
                byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
            }
            return i4 - i;
        }
        int i6 = i2 + i;
        boolean z = false;
        if (i6 <= out.length) {
            i3 = i;
            while (byteBuffer.hasRemaining()) {
                byte b2 = byteBuffer.get();
                if (b2 >= 0 && i3 < i6) {
                    char c2 = (char) b2;
                    if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                        out[i3] = c2;
                        i3++;
                    }
                }
                z = true;
            }
        } else {
            i3 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i3 - i;
    }

    public static /* synthetic */ int decodeASCII$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeASCII(byteBuffer, cArr, i, i2);
    }

    public static final int decodeASCII(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        if (byteBuffer.hasArray()) {
            return decodeASCII3_array(byteBuffer, out, i, i2);
        }
        return decodeASCII3_buffer(byteBuffer, out, i, i2);
    }

    private static final int decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2 + i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (i4 > cArr.length || iRemaining > bArrArray.length) {
            i3 = i;
        } else {
            i3 = i;
            while (iArrayOffset < iRemaining && i3 < i4) {
                byte b = bArrArray[iArrayOffset];
                if (b < 0) {
                    break;
                }
                cArr[i3] = (char) b;
                i3++;
                iArrayOffset++;
            }
            byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
        }
        return i3 - i;
    }

    private static final int decodeASCII3_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2 + i;
        boolean z = false;
        if (i4 <= cArr.length) {
            i3 = i;
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                if (b < 0 || i3 >= i4) {
                    z = true;
                    break;
                }
                cArr[i3] = (char) b;
                i3++;
            }
        } else {
            i3 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i3 - i;
    }

    private static final int decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i2 + i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (i4 > cArr.length || iRemaining > bArrArray.length) {
            i3 = i;
        } else {
            i3 = i;
            while (true) {
                if (iArrayOffset < iRemaining && i3 < i4) {
                    byte b = bArrArray[iArrayOffset];
                    if (b < 0) {
                        break;
                    }
                    char c = (char) b;
                    if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                        iArrayOffset--;
                        break;
                    }
                    cArr[i3] = c;
                    i3++;
                    iArrayOffset++;
                } else {
                    break;
                }
            }
            byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
        }
        return i3 - i;
    }

    private static final int decodeASCII3_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i2 + i;
        boolean z = false;
        if (i4 <= cArr.length) {
            i3 = i;
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                if (b >= 0 && i3 < i4) {
                    char c = (char) b;
                    if (function1.invoke(Character.valueOf(c)).booleanValue()) {
                        cArr[i3] = c;
                        i3++;
                    }
                }
                z = true;
            }
        } else {
            i3 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i3 - i;
    }
}
