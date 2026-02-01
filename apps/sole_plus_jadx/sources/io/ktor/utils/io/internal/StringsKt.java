package io.ktor.utils.io.internal;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.charsets.UTFKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0082\b\u001a$\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\r\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0082\b\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a$\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a$\u0010\u0010\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¨\u0006\u0011"}, d2 = {"decodeASCII", "", "Ljava/nio/ByteBuffer;", "out", "", "offset", SessionDescription.ATTR_LENGTH, "decodeASCII3_array", "", "predicate", "Lkotlin/Function1;", "", "", "decodeASCII3_buffer", "decodeASCIILine", "decodeASCIILine_array", "decodeASCIILine_buffer", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StringsKt {
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

    public static /* synthetic */ long decodeASCIILine$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeASCIILine(byteBuffer, cArr, i, i2);
    }

    public static final long decodeASCIILine(ByteBuffer byteBuffer, char[] out, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        return byteBuffer.hasArray() ? decodeASCIILine_array(byteBuffer, out, i, i2) : decodeASCIILine_buffer(byteBuffer, out, i, i2);
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

    private static final long decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i2 + i;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int iRemaining = byteBuffer.remaining() + iArrayOffset;
        if (i4 > cArr.length || iRemaining > bArrArray.length) {
            i3 = i;
        } else {
            i3 = i;
            while (iArrayOffset < iRemaining) {
                byte b = bArrArray[iArrayOffset];
                if (b < 0) {
                    break;
                }
                char c = (char) b;
                if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                    byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
                    return UTFKt.decodeUtf8Result(i3 - i, -1);
                }
                if (i3 >= i4) {
                    break;
                }
                cArr[i3] = c;
                i3++;
                iArrayOffset++;
            }
            byteBuffer.position(iArrayOffset - byteBuffer.arrayOffset());
        }
        return UTFKt.decodeUtf8Result(i3 - i, 0);
    }

    private static final long decodeASCII3_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        boolean z;
        boolean z2;
        int i4 = i2 + i;
        if (i4 <= cArr.length) {
            i3 = i;
            while (byteBuffer.hasRemaining()) {
                byte b = byteBuffer.get();
                if (b >= 0) {
                    char c = (char) b;
                    if (!function1.invoke(Character.valueOf(c)).booleanValue()) {
                        z = true;
                        break;
                    }
                    if (i3 < i4) {
                        cArr[i3] = c;
                        i3++;
                    }
                }
                z = true;
                z2 = false;
            }
        } else {
            i3 = i;
        }
        z = false;
        z2 = z;
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return UTFKt.decodeUtf8Result(i3 - i, z2 ? -1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0039 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long decodeASCIILine_array(java.nio.ByteBuffer r11, char[] r12, int r13, int r14) {
        /*
            int r14 = r14 + r13
            byte[] r0 = r11.array()
            int r1 = r11.arrayOffset()
            int r2 = r11.position()
            int r1 = r1 + r2
            int r2 = r11.remaining()
            int r2 = r2 + r1
            int r3 = r12.length
            r4 = 13
            r5 = -1
            r6 = 1
            r7 = 0
            if (r14 > r3) goto L5a
            int r3 = r0.length
            if (r2 > r3) goto L5a
            r8 = r13
            r3 = r7
        L20:
            if (r1 >= r2) goto L51
            r9 = r0[r1]
            if (r9 < 0) goto L51
            char r9 = (char) r9
            if (r9 != r4) goto L2c
            r3 = r6
        L2a:
            r10 = r3
            goto L37
        L2c:
            r10 = 10
            if (r9 != r10) goto L32
            r3 = r7
            goto L2a
        L32:
            if (r3 == 0) goto L36
            r10 = r7
            goto L37
        L36:
            r10 = r6
        L37:
            if (r10 != 0) goto L47
            int r14 = r11.arrayOffset()
            int r1 = r1 - r14
            r11.position(r1)
            int r8 = r8 - r13
            long r13 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r8, r5)
            goto L61
        L47:
            if (r8 < r14) goto L4a
            goto L51
        L4a:
            r12[r8] = r9
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L20
        L51:
            int r14 = r11.arrayOffset()
            int r1 = r1 - r14
            r11.position(r1)
            goto L5c
        L5a:
            r8 = r13
            r3 = r7
        L5c:
            int r8 = r8 - r13
            long r13 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r8, r7)
        L61:
            r0 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r0 & r13
            int r0 = (int) r0
            r1 = 32
            if (r0 != r5) goto L8b
            long r0 = r13 >> r1
            int r0 = (int) r0
            if (r3 == 0) goto L77
            int r0 = r0 - r6
            long r11 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r0, r5)
            return r11
        L77:
            int r1 = r11.position()
            int r1 = r1 + r6
            r11.position(r1)
            if (r0 <= 0) goto L9f
            int r0 = r0 - r6
            char r11 = r12[r0]
            if (r11 != r4) goto L9f
            long r11 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r0, r5)
            return r11
        L8b:
            if (r3 == 0) goto L9f
            long r12 = r13 >> r1
            int r12 = (int) r12
            int r13 = r11.position()
            int r13 = r13 - r6
            r11.position(r13)
            int r12 = r12 - r6
            r11 = 2
            long r11 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r12, r11)
            return r11
        L9f:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.StringsKt.decodeASCIILine_array(java.nio.ByteBuffer, char[], int, int):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        r5 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long decodeASCIILine_buffer(java.nio.ByteBuffer r7, char[] r8, int r9, int r10) {
        /*
            int r10 = r10 + r9
            int r0 = r8.length
            r1 = 13
            r2 = 1
            r3 = 0
            r4 = r9
            if (r10 > r0) goto L39
            r0 = r3
        La:
            boolean r5 = r7.hasRemaining()
            if (r5 == 0) goto L36
            byte r5 = r7.get()
            if (r5 >= 0) goto L19
        L16:
            r10 = r2
            r5 = r3
            goto L3c
        L19:
            char r5 = (char) r5
            if (r5 != r1) goto L1f
            r0 = r2
        L1d:
            r6 = r0
            goto L2a
        L1f:
            r6 = 10
            if (r5 != r6) goto L25
            r0 = r3
            goto L1d
        L25:
            if (r0 == 0) goto L29
            r6 = r3
            goto L2a
        L29:
            r6 = r2
        L2a:
            if (r6 != 0) goto L2e
            r10 = r2
            goto L37
        L2e:
            if (r4 < r10) goto L31
            goto L16
        L31:
            r8[r4] = r5
            int r4 = r4 + 1
            goto La
        L36:
            r10 = r3
        L37:
            r5 = r10
            goto L3c
        L39:
            r10 = r3
            r0 = r10
            r5 = r0
        L3c:
            if (r10 == 0) goto L46
            int r10 = r7.position()
            int r10 = r10 - r2
            r7.position(r10)
        L46:
            int r4 = r4 - r9
            r9 = -1
            if (r5 == 0) goto L4b
            r3 = r9
        L4b:
            long r3 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r4, r3)
            r5 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r5 = r5 & r3
            int r10 = (int) r5
            r5 = 32
            if (r10 != r9) goto L79
            long r5 = r3 >> r5
            int r10 = (int) r5
            if (r0 == 0) goto L65
            int r10 = r10 - r2
            long r7 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r10, r9)
            return r7
        L65:
            int r0 = r7.position()
            int r0 = r0 + r2
            r7.position(r0)
            if (r10 <= 0) goto L8d
            int r10 = r10 - r2
            char r7 = r8[r10]
            if (r7 != r1) goto L8d
            long r7 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r10, r9)
            return r7
        L79:
            if (r0 == 0) goto L8d
            long r8 = r3 >> r5
            int r8 = (int) r8
            int r9 = r7.position()
            int r9 = r9 - r2
            r7.position(r9)
            int r8 = r8 - r2
            r7 = 2
            long r7 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r8, r7)
            return r7
        L8d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.StringsKt.decodeASCIILine_buffer(java.nio.ByteBuffer, char[], int, int):long");
    }
}
