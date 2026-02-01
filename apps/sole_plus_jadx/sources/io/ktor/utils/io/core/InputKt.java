package io.ktor.utils.io.core;

import com.android.SdkConstants;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Input.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001\u001a$\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0080\bø\u0001\u0000\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0002\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001a$\u0010\u000f\u001a\u00020\u0004*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\tH\u0086\bø\u0001\u0000\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\tH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {SdkConstants.ATTR_DISCARD, "", "Lio/ktor/utils/io/core/Input;", "discardExact", "", "n", "", "forEach", "block", "Lkotlin/Function1;", "", "peekCharUtf8", "", "peekCharUtf8Impl", "first", "takeWhile", "Lio/ktor/utils/io/core/Buffer;", "", "takeWhileSize", "initialSize", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputKt {
    public static final long discard(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input.discard(Long.MAX_VALUE);
    }

    public static final void discardExact(Input input, long j) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        long jDiscard = input.discard(j);
        if (jDiscard != j) {
            throw new IllegalStateException("Only " + jDiscard + " bytes were discarded of " + j + " requested");
        }
    }

    public static final void discardExact(Input input, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        discardExact(input, i);
    }

    public static final void takeWhile(Input input, Function1<? super Buffer, Boolean> block) throws Throwable {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                if (!block.invoke(chunkBufferPrepareReadFirstHead).booleanValue()) {
                    z = true;
                    break;
                }
                z = false;
                try {
                    ChunkBuffer chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                    if (chunkBufferPrepareReadNextHead == null) {
                        break;
                    } else {
                        chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    }
                } catch (Throwable th) {
                    th = th;
                    InlineMarker.finallyStart(1);
                    if (z) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void takeWhileSize$default(io.ktor.utils.io.core.Input r3, int r4, kotlin.jvm.functions.Function1 r5, int r6, java.lang.Object r7) throws java.lang.Throwable {
        /*
            r7 = 1
            r6 = r6 & r7
            if (r6 == 0) goto L5
            r4 = r7
        L5:
            java.lang.String r6 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r3, r4)
            if (r6 != 0) goto L16
            return
        L16:
            r0 = r6
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.io.core.Buffer) r0     // Catch: java.lang.Throwable -> L8d
            int r1 = r0.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r0 = r0.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r1 = r1 - r0
            if (r1 < r4) goto L52
            java.lang.Object r4 = r5.invoke(r6)     // Catch: java.lang.Throwable -> L41
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Throwable -> L41
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L41
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)     // Catch: java.lang.Throwable -> L8d
            r0 = r6
            io.ktor.utils.io.core.Buffer r0 = (io.ktor.utils.io.core.Buffer) r0     // Catch: java.lang.Throwable -> L8d
            int r1 = r0.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            int r0 = r0.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            int r1 = r1 - r0
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)     // Catch: java.lang.Throwable -> L8d
            goto L52
        L41:
            r4 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)     // Catch: java.lang.Throwable -> L8d
            r5 = r6
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5     // Catch: java.lang.Throwable -> L8d
            r5.getWritePosition()     // Catch: java.lang.Throwable -> L8d
            r5.getReadPosition()     // Catch: java.lang.Throwable -> L8d
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)     // Catch: java.lang.Throwable -> L8d
            throw r4     // Catch: java.lang.Throwable -> L8d
        L52:
            r0 = 0
            if (r1 != 0) goto L5c
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadNextHead(r3, r6)     // Catch: java.lang.Throwable -> L5a
            goto L78
        L5a:
            r4 = move-exception
            goto L8f
        L5c:
            if (r1 < r4) goto L71
            r1 = r6
            io.ktor.utils.io.core.Buffer r1 = (io.ktor.utils.io.core.Buffer) r1     // Catch: java.lang.Throwable -> L5a
            int r2 = r1.getCapacity()     // Catch: java.lang.Throwable -> L5a
            int r1 = r1.getLimit()     // Catch: java.lang.Throwable -> L5a
            int r2 = r2 - r1
            r1 = 8
            if (r2 >= r1) goto L6f
            goto L71
        L6f:
            r1 = r6
            goto L78
        L71:
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r3, r6)     // Catch: java.lang.Throwable -> L5a
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.prepareReadFirstHead(r3, r4)     // Catch: java.lang.Throwable -> L5a
        L78:
            if (r1 != 0) goto L7b
            goto L7f
        L7b:
            if (r4 > 0) goto L8b
            r0 = r7
            r6 = r1
        L7f:
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)
            if (r0 == 0) goto L87
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r3, r6)
        L87:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)
            return
        L8b:
            r6 = r1
            goto L16
        L8d:
            r4 = move-exception
            r0 = r7
        L8f:
            kotlin.jvm.internal.InlineMarker.finallyStart(r7)
            if (r0 == 0) goto L97
            io.ktor.utils.io.core.internal.UnsafeKt.completeReadHead(r3, r6)
        L97:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r7)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.InputKt.takeWhileSize$default(io.ktor.utils.io.core.Input, int, kotlin.jvm.functions.Function1, int, java.lang.Object):void");
    }

    public static final void takeWhileSize(Input input, int i, Function1<? super Buffer, Integer> block) throws Throwable {
        boolean z;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, i);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                if (writePosition >= i) {
                    try {
                        i = block.invoke(chunkBufferPrepareReadFirstHead).intValue();
                        InlineMarker.finallyStart(1);
                        ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                        writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
                        InlineMarker.finallyEnd(1);
                    } finally {
                    }
                }
                z = false;
                if (writePosition == 0) {
                    try {
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                    } catch (Throwable th) {
                        th = th;
                        InlineMarker.finallyStart(1);
                        if (z) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        }
                        InlineMarker.finallyEnd(1);
                        throw th;
                    }
                } else if (writePosition >= i) {
                    ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                    if (chunkBuffer3.getCapacity() - chunkBuffer3.getLimit() < 8) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i);
                    } else {
                        chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                    }
                } else {
                    UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, i);
                }
                if (chunkBufferPrepareReadNextHead == null) {
                    break;
                }
                if (i <= 0) {
                    z = true;
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    break;
                }
                chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        }
        InlineMarker.finallyStart(1);
        if (z) {
            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
        }
        InlineMarker.finallyEnd(1);
    }

    public static final char peekCharUtf8(Input input) throws EOFException {
        Intrinsics.checkNotNullParameter(input, "<this>");
        int iTryPeek = input.tryPeek();
        if ((iTryPeek & 128) == 0) {
            return (char) iTryPeek;
        }
        if (iTryPeek == -1) {
            throw new EOFException("Failed to peek a char: end of input");
        }
        return peekCharUtf8Impl(input, iTryPeek);
    }

    private static final char peekCharUtf8Impl(Input input, int i) throws Throwable {
        boolean z;
        ChunkBuffer chunkBuffer;
        int i2;
        ChunkBuffer chunkBufferPrepareReadNextHead;
        boolean z2;
        boolean z3;
        int iByteCountUtf8 = UTF8Kt.byteCountUtf8(i);
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, iByteCountUtf8);
        char cHighSurrogate = '?';
        if (chunkBufferPrepareReadFirstHead == null) {
            z3 = false;
        } else {
            boolean z4 = false;
            while (true) {
                try {
                    int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
                    if (writePosition >= iByteCountUtf8) {
                        try {
                            ChunkBuffer chunkBuffer2 = chunkBufferPrepareReadFirstHead;
                            ByteBuffer memory = chunkBuffer2.getMemory();
                            int readPosition = chunkBuffer2.getReadPosition();
                            int writePosition2 = chunkBuffer2.getWritePosition();
                            int i3 = readPosition;
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            while (true) {
                                if (i3 < writePosition2) {
                                    byte b = memory.get(i3);
                                    int i7 = b & 255;
                                    i2 = -1;
                                    if ((b & 128) != 0) {
                                        if (i4 == 0) {
                                            int i8 = 128;
                                            for (int i9 = 1; i9 < 7 && (i7 & i8) != 0; i9++) {
                                                i7 &= ~i8;
                                                i8 >>= 1;
                                                i4++;
                                            }
                                            int i10 = i4 - 1;
                                            if (i4 > writePosition2 - i3) {
                                                chunkBuffer2.discardExact(i3 - readPosition);
                                                i2 = i4;
                                                break;
                                            }
                                            i6 = i4;
                                            i5 = i7;
                                            i4 = i10;
                                        } else {
                                            int i11 = (i5 << 6) | (b & 127);
                                            i4--;
                                            if (i4 != 0) {
                                                i5 = i11;
                                            } else if (UTF8Kt.isBmpCodePoint(i11)) {
                                                cHighSurrogate = (char) i11;
                                                chunkBuffer2.discardExact(((i3 - readPosition) - i6) + 1);
                                            } else {
                                                if (!UTF8Kt.isValidCodePoint(i11)) {
                                                    UTF8Kt.malformedCodePoint(i11);
                                                    throw new KotlinNothingValueException();
                                                }
                                                cHighSurrogate = (char) UTF8Kt.highSurrogate(i11);
                                                chunkBuffer2.discardExact(((i3 - readPosition) - i6) + 1);
                                            }
                                        }
                                        i3++;
                                    } else {
                                        if (i4 != 0) {
                                            UTF8Kt.malformedByteCount(i4);
                                            throw new KotlinNothingValueException();
                                        }
                                        cHighSurrogate = (char) i7;
                                        chunkBuffer2.discardExact(i3 - readPosition);
                                    }
                                } else {
                                    chunkBuffer2.discardExact(writePosition2 - readPosition);
                                    i2 = 0;
                                    break;
                                }
                            }
                            z4 = true;
                            ChunkBuffer chunkBuffer3 = chunkBufferPrepareReadFirstHead;
                            writePosition = chunkBuffer3.getWritePosition() - chunkBuffer3.getReadPosition();
                            iByteCountUtf8 = i2;
                        } finally {
                            chunkBuffer = chunkBufferPrepareReadFirstHead;
                            chunkBuffer.getWritePosition();
                            chunkBuffer.getReadPosition();
                        }
                    }
                    if (writePosition == 0) {
                        try {
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (z) {
                                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            }
                            throw th;
                        }
                    } else if (writePosition >= iByteCountUtf8) {
                        ChunkBuffer chunkBuffer4 = chunkBufferPrepareReadFirstHead;
                        if (chunkBuffer4.getCapacity() - chunkBuffer4.getLimit() < 8) {
                            UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                            chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, iByteCountUtf8);
                        } else {
                            chunkBufferPrepareReadNextHead = chunkBufferPrepareReadFirstHead;
                        }
                    } else {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                        chunkBufferPrepareReadNextHead = UnsafeKt.prepareReadFirstHead(input, iByteCountUtf8);
                    }
                    if (chunkBufferPrepareReadNextHead == null) {
                        z2 = false;
                        break;
                    }
                    chunkBufferPrepareReadFirstHead = chunkBufferPrepareReadNextHead;
                    if (iByteCountUtf8 <= 0) {
                        z2 = true;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
            if (z2) {
                UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
            }
            z3 = z4;
        }
        if (z3) {
            return cHighSurrogate;
        }
        throw new MalformedUTF8InputException("No UTF-8 character found");
    }

    public static final void forEach(Input input, Function1<? super Byte, Unit> block) throws Throwable {
        boolean z;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ChunkBuffer chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadFirstHead(input, 1);
        if (chunkBufferPrepareReadFirstHead == null) {
            return;
        }
        do {
            try {
                ChunkBuffer chunkBuffer = chunkBufferPrepareReadFirstHead;
                ByteBuffer memory = chunkBuffer.getMemory();
                int readPosition = chunkBuffer.getReadPosition();
                int writePosition = chunkBuffer.getWritePosition();
                for (int i = readPosition; i < writePosition; i++) {
                    block.invoke(Byte.valueOf(memory.get(i)));
                }
                chunkBuffer.discardExact(writePosition - readPosition);
                try {
                    chunkBufferPrepareReadFirstHead = UnsafeKt.prepareReadNextHead(input, chunkBufferPrepareReadFirstHead);
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    InlineMarker.finallyStart(1);
                    if (z) {
                        UnsafeKt.completeReadHead(input, chunkBufferPrepareReadFirstHead);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        } while (chunkBufferPrepareReadFirstHead != null);
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
    }
}
