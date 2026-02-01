package io.ktor.utils.io.jvm.nio;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Reading.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"copyTo", "", "Ljava/nio/channels/Pipe;", "ch", "Lio/ktor/utils/io/ByteWriteChannel;", "limit", "(Ljava/nio/channels/Pipe;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/ReadableByteChannel;", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReadingKt {

    /* compiled from: Reading.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.nio.ReadingKt", f = "Reading.kt", i = {0, 0, 0, 0, 0, 0}, l = {42}, m = "copyTo", n = {"ch", "copied", "eof", "copy", "limit", "needFlush"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
    /* renamed from: io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadingKt.copyTo((ReadableByteChannel) null, (ByteWriteChannel) null, 0L, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a0 -> B:31:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(final java.nio.channels.ReadableByteChannel r11, io.ktor.utils.io.ByteWriteChannel r12, final long r13, kotlin.coroutines.Continuation<? super java.lang.Long> r15) {
        /*
            boolean r0 = r15 instanceof io.ktor.utils.io.jvm.nio.ReadingKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r15
            io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1 r0 = (io.ktor.utils.io.jvm.nio.ReadingKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1 r0 = new io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$1
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            int r11 = r0.I$0
            long r12 = r0.J$0
            java.lang.Object r14 = r0.L$3
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r4 = (kotlin.jvm.internal.Ref.LongRef) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r14
            r13 = r12
            r12 = r5
            goto La3
        L41:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L49:
            kotlin.ResultKt.throwOnFailure(r15)
            r4 = 0
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 < 0) goto Lb0
            boolean r15 = r11 instanceof java.nio.channels.SelectableChannel
            if (r15 == 0) goto L68
            r15 = r11
            java.nio.channels.SelectableChannel r15 = (java.nio.channels.SelectableChannel) r15
            boolean r15 = r15.isBlocking()
            if (r15 == 0) goto L60
            goto L68
        L60:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Non-blocking channels are not supported"
            r11.<init>(r12)
            throw r11
        L68:
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$copy$1 r10 = new io.ktor.utils.io.jvm.nio.ReadingKt$copyTo$copy$1
            r4 = r10
            r5 = r13
            r7 = r15
            r8 = r11
            r9 = r2
            r4.<init>()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            boolean r11 = r12.getAutoFlush()
            r11 = r11 ^ r3
            r4 = r15
        L84:
            long r5 = r4.element
            int r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r15 >= 0) goto La9
            boolean r15 = r2.element
            if (r15 != 0) goto La9
            r0.L$0 = r12
            r0.L$1 = r4
            r0.L$2 = r2
            r0.L$3 = r10
            r0.J$0 = r13
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r15 = r12.write(r3, r10, r0)
            if (r15 != r1) goto La3
            return r1
        La3:
            if (r11 == 0) goto L84
            r12.flush()
            goto L84
        La9:
            long r11 = r4.element
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r11
        Lb0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Limit shouldn't be negative: "
            r11.<init>(r12)
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r11 = r11.toString()
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.nio.ReadingKt.copyTo(java.nio.channels.ReadableByteChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ReadableByteChannel readableByteChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(readableByteChannel, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }

    public static final Object copyTo(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        Pipe.SourceChannel sourceChannelSource = pipe.source();
        Intrinsics.checkNotNullExpressionValue(sourceChannelSource, "source()");
        return copyTo(sourceChannelSource, byteWriteChannel, j, continuation);
    }

    public static /* synthetic */ Object copyTo$default(Pipe pipe, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(pipe, byteWriteChannel, j, (Continuation<? super Long>) continuation);
    }
}
