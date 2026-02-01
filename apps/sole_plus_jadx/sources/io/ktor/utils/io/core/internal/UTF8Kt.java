package io.ktor.utils.io.core.internal;

import androidx.health.connect.client.records.OvulationTestRecord;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.core.Buffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: UTF8.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0014\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0011\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0082\b\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a_\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u00012$\u0010\u0014\u001a \b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001b0\u001aH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a\u0010\u0010!\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0001\u001a\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0001H\u0001\u001a\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0001H\u0002\u001a$\u0010)\u001a\u00020\u000f*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001aH\u0080\bø\u0001\u0001\u001a$\u0010,\u001a\u00020\u0001*\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u001aH\u0080\bø\u0001\u0001\u001aA\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001H\u0000ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aQ\u00108\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001aQ\u0010?\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0001H\u0002ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>\u001a*\u0010A\u001a\u00020\u0001*\u00020/2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0080\bø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0002\b\u0019\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "byteCountUtf8", "firstByte", "charactersSize", "v", "codePoint", OvulationTestRecord.Result.HIGH, "", "low", "decodeUTF8LineLoopSuspend", "", "out", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "limit", "nextChunk", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/utils/io/core/Input;", "", "afterRead", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "highSurrogate", "cp", "isBmpCodePoint", "isValidCodePoint", "lowSurrogate", "malformedByteCount", "", "byteCount", "malformedCodePoint", "value", "prematureEndOfStreamUtf", ContentDisposition.Parameters.Size, "decodeASCII", "Lio/ktor/utils/io/core/Buffer;", "consumer", "decodeUTF8", "encodeUTF8", "Lio/ktor/utils/io/core/internal/EncodeResult;", "Lio/ktor/utils/io/bits/Memory;", "text", "", "from", "to", "dstOffset", "dstLimit", "encodeUTF8-lBXzO7A", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIII)I", "encodeUTF8Stage1", "index1", "lastCharIndex", "resultPosition1", "resultLimit", "encodeUTF8Stage1-Vm9B2pQ", "(Ljava/nio/ByteBuffer;Ljava/lang/CharSequence;IIIIII)I", "encodeUTF8Stage2", "encodeUTF8Stage2-Vm9B2pQ", "putUtf8Char", "offset", "putUtf8Char-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UTF8Kt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    /* compiled from: UTF8.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.core.internal.UTF8Kt", f = "UTF8.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {36}, m = "decodeUTF8LineLoopSuspend", n = {"out", "nextChunk", "afterRead", "decoded", ContentDisposition.Parameters.Size, "cr", "end", "limit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    /* renamed from: io.ktor.utils.io.core.internal.UTF8Kt$decodeUTF8LineLoopSuspend$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UTF8Kt.decodeUTF8LineLoopSuspend(null, 0, null, null, this);
        }
    }

    public static final int byteCountUtf8(int i) {
        int i2 = 0;
        int i3 = 128;
        for (int i4 = 1; i4 < 7 && (i & i3) != 0; i4++) {
            i &= ~i3;
            i3 >>= 1;
            i2++;
        }
        return i2;
    }

    public static final int codePoint(char c, char c2) {
        return ((c - 55232) << 10) | (c2 - CharCompanionObject.MIN_LOW_SURROGATE);
    }

    public static final int highSurrogate(int i) {
        return (i >>> 10) + 55232;
    }

    public static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    public static final int lowSurrogate(int i) {
        return (i & 1023) + 56320;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0261, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0262, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x026e, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0270, code lost:
    
        r5.element = r6 == true ? 1 : 0;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0277, code lost:
    
        r8.element = r6;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x029c, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02a4, code lost:
    
        r0.discardExact(((r15 - r18) - r7.element) + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013f, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0150, code lost:
    
        r8.element = true;
        r5.element = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0159, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01cf, code lost:
    
        r0.discardExact(r15 - r18);
        r2 = r7.element;
        r10 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01fd, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01fe, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020a, code lost:
    
        r8.element = true;
        r5.element = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0213, code lost:
    
        r8.element = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:177:0x038a, B:181:0x039d], limit reached: 248 */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0329 A[Catch: all -> 0x034e, TryCatch #5 {all -> 0x034e, blocks: (B:40:0x0133, B:47:0x013f, B:57:0x015b, B:152:0x0323, B:154:0x0329, B:155:0x032e, B:159:0x033b, B:158:0x0334, B:48:0x0142, B:148:0x0300, B:53:0x0150, B:54:0x0155, B:56:0x0159, B:60:0x0167, B:62:0x016b, B:63:0x0177, B:64:0x0191, B:65:0x0192, B:66:0x019c, B:67:0x019d, B:69:0x01a1, B:72:0x01a9, B:74:0x01ae, B:75:0x01bf, B:77:0x01cf, B:78:0x01d9, B:80:0x01ec, B:82:0x01f4, B:88:0x01fe, B:96:0x0215, B:89:0x0201, B:140:0x02bb, B:92:0x020a, B:93:0x020f, B:95:0x0213, B:97:0x0220, B:99:0x0224, B:100:0x022a, B:102:0x0231, B:103:0x024b, B:104:0x024c, B:106:0x0254, B:112:0x0262, B:136:0x02a4, B:113:0x0265, B:124:0x0287, B:132:0x029c, B:117:0x0270, B:133:0x029f, B:120:0x0277, B:137:0x02af, B:139:0x02b3, B:141:0x02be, B:142:0x02d8, B:116:0x026e, B:118:0x0273, B:121:0x027a, B:123:0x027e, B:143:0x02d9, B:144:0x02f3, B:145:0x02f4, B:146:0x02fe, B:151:0x0312), top: B:220:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0334 A[Catch: all -> 0x034e, TryCatch #5 {all -> 0x034e, blocks: (B:40:0x0133, B:47:0x013f, B:57:0x015b, B:152:0x0323, B:154:0x0329, B:155:0x032e, B:159:0x033b, B:158:0x0334, B:48:0x0142, B:148:0x0300, B:53:0x0150, B:54:0x0155, B:56:0x0159, B:60:0x0167, B:62:0x016b, B:63:0x0177, B:64:0x0191, B:65:0x0192, B:66:0x019c, B:67:0x019d, B:69:0x01a1, B:72:0x01a9, B:74:0x01ae, B:75:0x01bf, B:77:0x01cf, B:78:0x01d9, B:80:0x01ec, B:82:0x01f4, B:88:0x01fe, B:96:0x0215, B:89:0x0201, B:140:0x02bb, B:92:0x020a, B:93:0x020f, B:95:0x0213, B:97:0x0220, B:99:0x0224, B:100:0x022a, B:102:0x0231, B:103:0x024b, B:104:0x024c, B:106:0x0254, B:112:0x0262, B:136:0x02a4, B:113:0x0265, B:124:0x0287, B:132:0x029c, B:117:0x0270, B:133:0x029f, B:120:0x0277, B:137:0x02af, B:139:0x02b3, B:141:0x02be, B:142:0x02d8, B:116:0x026e, B:118:0x0273, B:121:0x027a, B:123:0x027e, B:143:0x02d9, B:144:0x02f3, B:145:0x02f4, B:146:0x02fe, B:151:0x0312), top: B:220:0x0133 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00ad -> B:23:0x00b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object decodeUTF8LineLoopSuspend(java.lang.Appendable r28, int r29, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.Input>, ? extends java.lang.Object> r30, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r31, kotlin.coroutines.Continuation<? super java.lang.Boolean> r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.decodeUTF8LineLoopSuspend(java.lang.Appendable, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Void prematureEndOfStreamUtf(int i) throws EOFException {
        throw new EOFException("Premature end of stream: expected " + i + " bytes to decode UTF-8 char");
    }

    /* renamed from: encodeUTF8-lBXzO7A, reason: not valid java name */
    public static final int m9074encodeUTF8lBXzO7A(ByteBuffer encodeUTF8, CharSequence text, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(encodeUTF8, "$this$encodeUTF8");
        Intrinsics.checkNotNullParameter(text, "text");
        int iMin = Math.min(i2, i + 65535);
        int iCoerceAtMost = RangesKt.coerceAtMost(i4, 65535);
        int i5 = i;
        int i6 = i3;
        while (i6 < iCoerceAtMost && i5 < iMin) {
            int i7 = i5 + 1;
            char cCharAt = text.charAt(i5);
            int i8 = cCharAt & CharCompanionObject.MAX_VALUE;
            if ((cCharAt & 65408) != 0) {
                return m9075encodeUTF8Stage1Vm9B2pQ(encodeUTF8, text, i5, iMin, i, i6, iCoerceAtMost, i3);
            }
            encodeUTF8.put(i6, (byte) i8);
            i5 = i7;
            i6++;
        }
        return EncodeResult.m9066constructorimpl(UShort.m9368constructorimpl((short) (i5 - i)), UShort.m9368constructorimpl((short) (i6 - i3)));
    }

    /* renamed from: encodeUTF8Stage1-Vm9B2pQ, reason: not valid java name */
    private static final int m9075encodeUTF8Stage1Vm9B2pQ(ByteBuffer byteBuffer, CharSequence charSequence, int i, int i2, int i3, int i4, int i5, int i6) {
        int iCodePoint;
        int i7;
        int i8 = i5 - 3;
        int i9 = i;
        int i10 = i4;
        while (i8 - i10 > 0 && i9 < i2) {
            int i11 = i9 + 1;
            char cCharAt = charSequence.charAt(i9);
            if (!Character.isHighSurrogate(cCharAt)) {
                i9 = i11;
                iCodePoint = cCharAt;
            } else if (i11 == i2 || !Character.isLowSurrogate(charSequence.charAt(i11))) {
                i9 = i11;
                iCodePoint = 63;
            } else {
                i9 += 2;
                iCodePoint = codePoint(cCharAt, charSequence.charAt(i11));
            }
            if (iCodePoint >= 0 && iCodePoint < 128) {
                byteBuffer.put(i10, (byte) iCodePoint);
                i7 = 1;
            } else if (128 <= iCodePoint && iCodePoint < 2048) {
                byteBuffer.put(i10, (byte) (((iCodePoint >> 6) & 31) | 192));
                byteBuffer.put(i10 + 1, (byte) (128 | (iCodePoint & 63)));
                i7 = 2;
            } else if (2048 <= iCodePoint && iCodePoint < 65536) {
                byteBuffer.put(i10, (byte) (((iCodePoint >> 12) & 15) | 224));
                byteBuffer.put(i10 + 1, (byte) ((63 & (iCodePoint >> 6)) | 128));
                byteBuffer.put(i10 + 2, (byte) (128 | (iCodePoint & 63)));
                i7 = 3;
            } else {
                if (65536 > iCodePoint || iCodePoint >= 1114112) {
                    malformedCodePoint(iCodePoint);
                    throw new KotlinNothingValueException();
                }
                byteBuffer.put(i10, (byte) (((iCodePoint >> 18) & 7) | 240));
                byteBuffer.put(i10 + 1, (byte) (((iCodePoint >> 12) & 63) | 128));
                byteBuffer.put(i10 + 2, (byte) ((63 & (iCodePoint >> 6)) | 128));
                byteBuffer.put(i10 + 3, (byte) (128 | (iCodePoint & 63)));
                i7 = 4;
            }
            i10 += i7;
        }
        if (i10 == i8) {
            return m9076encodeUTF8Stage2Vm9B2pQ(byteBuffer, charSequence, i9, i2, i3, i10, i5, i6);
        }
        return EncodeResult.m9066constructorimpl(UShort.m9368constructorimpl((short) (i9 - i3)), UShort.m9368constructorimpl((short) (i10 - i6)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e2, code lost:
    
        malformedCodePoint(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ea, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fd, code lost:
    
        return io.ktor.utils.io.core.internal.EncodeResult.m9066constructorimpl(kotlin.UShort.m9368constructorimpl((short) (r3 - r20)), kotlin.UShort.m9368constructorimpl((short) (r4 - r23)));
     */
    /* renamed from: encodeUTF8Stage2-Vm9B2pQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int m9076encodeUTF8Stage2Vm9B2pQ(java.nio.ByteBuffer r16, java.lang.CharSequence r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.internal.UTF8Kt.m9076encodeUTF8Stage2Vm9B2pQ(java.nio.ByteBuffer, java.lang.CharSequence, int, int, int, int, int, int):int");
    }

    private static final int charactersSize(int i) {
        if (1 <= i && i < 128) {
            return 1;
        }
        if (128 <= i && i < 2048) {
            return 2;
        }
        if (2048 <= i && i < 65536) {
            return 3;
        }
        if (65536 <= i && i < 1114112) {
            return 4;
        }
        malformedCodePoint(i);
        throw new KotlinNothingValueException();
    }

    public static final Void malformedByteCount(int i) throws MalformedUTF8InputException {
        throw new MalformedUTF8InputException("Expected " + i + " more character bytes");
    }

    public static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + i + " found");
    }

    public static final boolean decodeASCII(Buffer buffer, Function1<? super Character, Boolean> consumer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        for (int i = readPosition; i < writePosition; i++) {
            byte b = memory.get(i);
            int i2 = b & 255;
            if ((b & 128) == 128 || !consumer.invoke(Character.valueOf((char) i2)).booleanValue()) {
                buffer.discardExact(i - readPosition);
                return false;
            }
        }
        buffer.discardExact(writePosition - readPosition);
        return true;
    }

    public static final int decodeUTF8(Buffer buffer, Function1<? super Character, Boolean> consumer) throws MalformedUTF8InputException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = readPosition; i4 < writePosition; i4++) {
            byte b = memory.get(i4);
            int i5 = b & 255;
            if ((b & 128) != 0) {
                if (i == 0) {
                    int i6 = 128;
                    i2 = i5;
                    for (int i7 = 1; i7 < 7 && (i2 & i6) != 0; i7++) {
                        i2 &= ~i6;
                        i6 >>= 1;
                        i++;
                    }
                    int i8 = i - 1;
                    if (i > writePosition - i4) {
                        buffer.discardExact(i4 - readPosition);
                        return i;
                    }
                    i3 = i;
                    i = i8;
                } else {
                    i2 = (i2 << 6) | (b & 127);
                    i--;
                    if (i != 0) {
                        continue;
                    } else {
                        if (isBmpCodePoint(i2)) {
                            if (!consumer.invoke(Character.valueOf((char) i2)).booleanValue()) {
                                buffer.discardExact(((i4 - readPosition) - i3) + 1);
                                return -1;
                            }
                        } else {
                            if (!isValidCodePoint(i2)) {
                                malformedCodePoint(i2);
                                throw new KotlinNothingValueException();
                            }
                            if (!consumer.invoke(Character.valueOf((char) highSurrogate(i2))).booleanValue() || !consumer.invoke(Character.valueOf((char) lowSurrogate(i2))).booleanValue()) {
                                buffer.discardExact(((i4 - readPosition) - i3) + 1);
                                return -1;
                            }
                        }
                        i2 = 0;
                    }
                }
            } else {
                if (i != 0) {
                    malformedByteCount(i);
                    throw new KotlinNothingValueException();
                }
                if (!consumer.invoke(Character.valueOf((char) i5)).booleanValue()) {
                    buffer.discardExact(i4 - readPosition);
                    return -1;
                }
            }
        }
        buffer.discardExact(writePosition - readPosition);
        return 0;
    }

    /* renamed from: putUtf8Char-62zg_DM, reason: not valid java name */
    public static final int m9077putUtf8Char62zg_DM(ByteBuffer putUtf8Char, int i, int i2) {
        Intrinsics.checkNotNullParameter(putUtf8Char, "$this$putUtf8Char");
        if (i2 >= 0 && i2 < 128) {
            putUtf8Char.put(i, (byte) i2);
            return 1;
        }
        if (128 <= i2 && i2 < 2048) {
            putUtf8Char.put(i, (byte) (((i2 >> 6) & 31) | 192));
            putUtf8Char.put(i + 1, (byte) ((i2 & 63) | 128));
            return 2;
        }
        if (2048 <= i2 && i2 < 65536) {
            putUtf8Char.put(i, (byte) (((i2 >> 12) & 15) | 224));
            putUtf8Char.put(i + 1, (byte) (((i2 >> 6) & 63) | 128));
            putUtf8Char.put(i + 2, (byte) ((i2 & 63) | 128));
            return 3;
        }
        if (65536 > i2 || i2 >= 1114112) {
            malformedCodePoint(i2);
            throw new KotlinNothingValueException();
        }
        putUtf8Char.put(i, (byte) (((i2 >> 18) & 7) | 240));
        putUtf8Char.put(i + 1, (byte) (((i2 >> 12) & 63) | 128));
        putUtf8Char.put(i + 2, (byte) (((i2 >> 6) & 63) | 128));
        putUtf8Char.put(i + 3, (byte) ((i2 & 63) | 128));
        return 4;
    }
}
