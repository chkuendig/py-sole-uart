package io.ktor.utils.io.core;

import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputPrimitives.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0002H\u0002\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\u0002H\u0002\u001aK\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u000e0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0014H\u0082\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a4\u0010\u0016\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002H\u000e0\u0018H\u0082\b¢\u0006\u0002\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u0002\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0002H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"readDouble", "", "Lio/ktor/utils/io/core/Input;", "readDoubleFallback", "readFloat", "", "readFloatFallback", "readInt", "", "readIntFallback", "readLong", "", "readLongFallback", "readPrimitive", "R", ContentDisposition.Parameters.Size, SdkConstants.FD_MAIN, "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "fallback", "Lkotlin/Function0;", "(Lio/ktor/utils/io/core/Input;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "readPrimitiveFallback", "read", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Buffer;", "(Lio/ktor/utils/io/core/Input;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "readShort", "", "readShortFallback", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputPrimitivesKt {
    private static final <R> R readPrimitiveFallback(Input input, int i, Function1<? super Buffer, ? extends R> function1) throws EOFException {
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, i);
        if (chunkBufferPrepareReadFirstHead == null) {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
        R rInvoke = function1.invoke(chunkBufferPrepareReadFirstHead);
        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
        return rInvoke;
    }

    public static final short readShort(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 2) {
            return readShortFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 2);
        return input.getHeadMemory().getShort(headPosition);
    }

    private static final short readShortFallback(Input input) throws EOFException {
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 2);
        if (chunkBufferPrepareReadFirstHead != null) {
            short s = BufferPrimitivesKt.readShort((Buffer) chunkBufferPrepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            return s;
        }
        StringsKt.prematureEndOfStream(2);
        throw new KotlinNothingValueException();
    }

    public static final int readInt(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 4) {
            return readIntFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 4);
        return input.getHeadMemory().getInt(headPosition);
    }

    private static final int readIntFallback(Input input) throws EOFException {
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 4);
        if (chunkBufferPrepareReadFirstHead != null) {
            int i = BufferPrimitivesKt.readInt((Buffer) chunkBufferPrepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            return i;
        }
        StringsKt.prematureEndOfStream(4);
        throw new KotlinNothingValueException();
    }

    public static final long readLong(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 8) {
            return readLongFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 8);
        return input.getHeadMemory().getLong(headPosition);
    }

    private static final long readLongFallback(Input input) throws EOFException {
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 8);
        if (chunkBufferPrepareReadFirstHead != null) {
            long j = BufferPrimitivesKt.readLong((Buffer) chunkBufferPrepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            return j;
        }
        StringsKt.prematureEndOfStream(8);
        throw new KotlinNothingValueException();
    }

    public static final float readFloat(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 4) {
            return readFloatFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 4);
        return input.getHeadMemory().getFloat(headPosition);
    }

    public static final float readFloatFallback(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 4);
        if (chunkBufferPrepareReadFirstHead != null) {
            float f = BufferPrimitivesKt.readFloat((Buffer) chunkBufferPrepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            return f;
        }
        StringsKt.prematureEndOfStream(4);
        throw new KotlinNothingValueException();
    }

    public static final double readDouble(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (input.getHeadEndExclusive() - input.getHeadPosition() <= 8) {
            return readDoubleFallback(input);
        }
        int headPosition = input.getHeadPosition();
        input.setHeadPosition(headPosition + 8);
        return input.getHeadMemory().getDouble(headPosition);
    }

    public static final double readDoubleFallback(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 8);
        if (chunkBufferPrepareReadFirstHead != null) {
            double d = BufferPrimitivesKt.readDouble((Buffer) chunkBufferPrepareReadFirstHead);
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            return d;
        }
        StringsKt.prematureEndOfStream(8);
        throw new KotlinNothingValueException();
    }

    private static final <R> R readPrimitive(Input input, int i, Function2<? super Memory, ? super Integer, ? extends R> function2, Function0<? extends R> function0) {
        if (input.getHeadEndExclusive() - input.getHeadPosition() > i) {
            int headPosition = input.getHeadPosition();
            input.setHeadPosition(i + headPosition);
            return function2.invoke(Memory.m8811boximpl(input.getHeadMemory()), Integer.valueOf(headPosition));
        }
        return function0.invoke();
    }
}
