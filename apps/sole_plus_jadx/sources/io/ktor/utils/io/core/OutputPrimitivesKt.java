package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutputPrimitives.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0002\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0002\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\f\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0002\u001a)\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012H\u0082\b\u001aA\u0010\u0014\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2'\u0010\u0015\u001a#\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u0016H\u0082\bø\u0001\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"writeDouble", "", "Lio/ktor/utils/io/core/Output;", "value", "", "writeFloat", "", "writeInt", "", "writeIntByteByByte", "writeIntFallback", "writeLong", "", "writeLongFallback", "writePrimitiveFallbackTemplate", "", "componentSize", "writeOperation", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "writePrimitiveTemplate", "block", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "index", "writeShort", "", "writeShortFallback", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OutputPrimitivesKt {
    private static final void writeIntByteByByte(Output output, int i) {
        short s = (short) (i >>> 16);
        output.writeByte((byte) (s >>> 8));
        output.writeByte((byte) (s & 255));
        short s2 = (short) (i & 65535);
        output.writeByte((byte) (s2 >>> 8));
        output.writeByte((byte) (s2 & 255));
    }

    private static final boolean writePrimitiveTemplate(Output output, int i, Function2<? super Memory, ? super Integer, Unit> function2) {
        int tailPosition = output.getTailPosition();
        if (output.getTailEndExclusive() - tailPosition <= i) {
            return false;
        }
        output.setTailPosition$ktor_io(i + tailPosition);
        function2.invoke(Memory.m8811boximpl(output.getTailMemory()), Integer.valueOf(tailPosition));
        return true;
    }

    private static final boolean writePrimitiveFallbackTemplate(Output output, int i, Function1<? super Buffer, Unit> function1) {
        function1.invoke(output.prepareWriteHead(i));
        output.afterHeadWrite();
        return true;
    }

    public static final void writeShort(Output output, short s) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int tailPosition = output.getTailPosition();
        if (output.getTailEndExclusive() - tailPosition <= 2) {
            writeShortFallback(output, s);
        } else {
            output.setTailPosition$ktor_io(tailPosition + 2);
            output.getTailMemory().putShort(tailPosition, s);
        }
    }

    private static final void writeShortFallback(Output output, short s) {
        BufferPrimitivesKt.writeShort((Buffer) output.prepareWriteHead(2), s);
        output.afterHeadWrite();
    }

    public static final void writeInt(Output output, int i) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int tailPosition = output.getTailPosition();
        if (output.getTailEndExclusive() - tailPosition <= 4) {
            writeIntFallback(output, i);
        } else {
            output.setTailPosition$ktor_io(tailPosition + 4);
            output.getTailMemory().putInt(tailPosition, i);
        }
    }

    private static final void writeIntFallback(Output output, int i) {
        BufferPrimitivesKt.writeInt((Buffer) output.prepareWriteHead(4), i);
        output.afterHeadWrite();
    }

    public static final void writeLong(Output output, long j) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int tailPosition = output.getTailPosition();
        if (output.getTailEndExclusive() - tailPosition <= 8) {
            writeLongFallback(output, j);
        } else {
            output.setTailPosition$ktor_io(tailPosition + 8);
            output.getTailMemory().putLong(tailPosition, j);
        }
    }

    private static final void writeLongFallback(Output output, long j) {
        BufferPrimitivesKt.writeLong((Buffer) output.prepareWriteHead(8), j);
        output.afterHeadWrite();
    }

    public static final void writeFloat(Output output, float f) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int tailPosition = output.getTailPosition();
        if (output.getTailEndExclusive() - tailPosition <= 4) {
            writeIntFallback(output, Float.floatToRawIntBits(f));
        } else {
            output.setTailPosition$ktor_io(tailPosition + 4);
            output.getTailMemory().putFloat(tailPosition, f);
        }
    }

    public static final void writeDouble(Output output, double d) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        int tailPosition = output.getTailPosition();
        if (output.getTailEndExclusive() - tailPosition <= 8) {
            writeLongFallback(output, Double.doubleToRawLongBits(d));
        } else {
            output.setTailPosition$ktor_io(tailPosition + 8);
            output.getTailMemory().putDouble(tailPosition, d);
        }
    }
}
