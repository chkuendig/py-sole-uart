package io.ktor.utils.io.core;

import com.android.SdkConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Output.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a*\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a/\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a/\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0017\u001a\u001c\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00182\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001a2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001c2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001d2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a&\u0010\u0010\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u001e2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u001a[\u0010\u001f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072<\u0010 \u001a8\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0!H\u0082\b\u001a\u0082\u0001\u0010\u001f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2`\u0010 \u001a\\\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0'H\u0082\bø\u0001\u0001\u001ac\u0010*\u001a\u00020\u000b*\u00020\u00032\u0006\u0010+\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072<\u0010 \u001a8\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0!H\u0082\b\u001a$\u0010,\u001a\u00020\u000b*\u00020\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.0-H\u0080\bø\u0001\u0002\u001a.\u0010/\u001a\u00020\u000b*\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00072\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070-H\u0080\bø\u0001\u0002\u0082\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00061"}, d2 = {"append", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Lio/ktor/utils/io/core/Output;", "csq", "", "start", "", "end", "", SdkConstants.GRAVITY_VALUE_FILL, "", "times", "", "value", "", "writeFully", "src", "Lio/ktor/utils/io/bits/Memory;", "offset", SessionDescription.ATTR_LENGTH, "writeFully-UAd2zVI", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;II)V", "(Lio/ktor/utils/io/core/Output;Ljava/nio/ByteBuffer;JJ)V", "Lio/ktor/utils/io/core/Buffer;", "", "", "", "", "", "", "writeFullyBytesTemplate", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "currentOffset", "count", "initialOffset", "Lkotlin/Function4;", "destination", "destinationOffset", "writeFullyTemplate", "componentSize", "writeWhile", "Lkotlin/Function1;", "", "writeWhileSize", "initialSize", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OutputKt {
    public static /* synthetic */ Appendable append$default(Output output, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return append(output, charSequence, i, i2);
    }

    public static final Appendable append(Output output, CharSequence csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        return output.append(csq, i, i2);
    }

    public static /* synthetic */ Appendable append$default(Output output, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return append(output, cArr, i, i2);
    }

    public static final Appendable append(Output output, char[] csq, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(csq, "csq");
        return output.append(csq, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(output, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFully(output, sArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFully(output, iArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFully(output, jArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFully(output, fArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Output output, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFully(output, dArr, i, i2);
    }

    /* renamed from: writeFully-UAd2zVI, reason: not valid java name */
    public static final void m9028writeFullyUAd2zVI(Output writeFully, ByteBuffer src, int i, int i2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(src, "src");
        m9029writeFullyUAd2zVI(writeFully, src, i, i2);
    }

    public static /* synthetic */ void fill$default(Output output, long j, byte b, int i, Object obj) {
        if ((i & 2) != 0) {
            b = 0;
        }
        fill(output, j, b);
    }

    public static final void writeWhile(Output output, Function1<? super Buffer, Boolean> block) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (block.invoke(chunkBufferPrepareWriteHead).booleanValue()) {
            try {
                chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static /* synthetic */ void writeWhileSize$default(Output output, int i, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i, null);
        while (true) {
            try {
                int iIntValue = ((Number) block.invoke(chunkBufferPrepareWriteHead)).intValue();
                if (iIntValue <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, iIntValue, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static final void writeWhileSize(Output output, int i, Function1<? super Buffer, Integer> block) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i, null);
        while (true) {
            try {
                int iIntValue = block.invoke(chunkBufferPrepareWriteHead).intValue();
                if (iIntValue <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, iIntValue, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    public static final void writeFully(Output output, byte[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                if (i2 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, short[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 2, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 2;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, int[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 4;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, long[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 8;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, float[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 4, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully((Buffer) chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 4;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, double[] src, int i, int i2) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 8, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully(chunkBuffer, src, i, iMin);
                i += iMin;
                i2 -= iMin;
                int i3 = i2 * 8;
                if (i3 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i3, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static final void writeFully(Output output, Buffer src, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                BufferPrimitivesKt.writeFully(chunkBuffer, src, iMin);
                i -= iMin;
                if (i <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    public static /* synthetic */ void writeFully$default(Output output, Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        writeFully(output, buffer, i);
    }

    /* renamed from: writeFully-UAd2zVI, reason: not valid java name */
    public static final void m9029writeFullyUAd2zVI(Output writeFully, ByteBuffer src, long j, long j2) {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(src, "src");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(writeFully, 1, null);
        long j3 = j;
        long j4 = j2;
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                long jMin = Math.min(j4, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                Memory.m8814copyToJT6ljtQ(src, chunkBuffer.getMemory(), j3, jMin, chunkBuffer.getWritePosition());
                chunkBuffer.commitWritten((int) jMin);
                j3 += jMin;
                j4 -= jMin;
                if (j4 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(writeFully, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                writeFully.afterHeadWrite();
            }
        }
    }

    public static final void fill(Output output, long j, byte b) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        long j2 = 0;
        while (true) {
            try {
                int iMin = (int) Math.min(r4.getLimit() - r4.getWritePosition(), j - j2);
                BufferCompatibilityKt.fill((Buffer) chunkBufferPrepareWriteHead, iMin, b);
                j2 += iMin;
                if (j2 >= j) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                output.afterHeadWrite();
            }
        }
    }

    private static final void writeFullyBytesTemplate(Output output, int i, int i2, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                function3.invoke(chunkBuffer, Integer.valueOf(i), Integer.valueOf(iMin));
                i += iMin;
                i2 -= iMin;
                if (i2 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeFullyBytesTemplate(Output output, long j, long j2, Function4<? super Memory, ? super Long, ? super Long, ? super Long, Unit> function4) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                long jMin = Math.min(j2, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                function4.invoke(Memory.m8811boximpl(chunkBuffer.getMemory()), Long.valueOf(chunkBuffer.getWritePosition()), Long.valueOf(j), Long.valueOf(jMin));
                chunkBuffer.commitWritten((int) jMin);
                j += jMin;
                j2 -= jMin;
                if (j2 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private static final void writeFullyTemplate(Output output, int i, int i2, int i3, Function3<? super Buffer, ? super Integer, ? super Integer, Unit> function3) {
        ChunkBuffer chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i, null);
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareWriteHead;
                int iMin = Math.min(i3, chunkBuffer.getLimit() - chunkBuffer.getWritePosition());
                function3.invoke(chunkBuffer, Integer.valueOf(i2), Integer.valueOf(iMin));
                i2 += iMin;
                i3 -= iMin;
                int i4 = i3 * i;
                if (i4 <= 0) {
                    return;
                } else {
                    chunkBufferPrepareWriteHead = UnsafeKt.prepareWriteHead(output, i4, chunkBufferPrepareWriteHead);
                }
            } finally {
                InlineMarker.finallyStart(1);
                output.afterHeadWrite();
                InlineMarker.finallyEnd(1);
            }
        }
    }
}
