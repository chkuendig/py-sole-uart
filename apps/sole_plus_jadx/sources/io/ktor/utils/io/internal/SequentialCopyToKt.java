package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SequentialCopyTo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"copyToSequentialImpl", "", "Lio/ktor/utils/io/ByteChannelSequentialBase;", "dst", "limit", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToTail", "joinToImpl", "", "closeOnEnd", "", "(Lio/ktor/utils/io/ByteChannelSequentialBase;Lio/ktor/utils/io/ByteChannelSequentialBase;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SequentialCopyToKt {

    /* compiled from: SequentialCopyTo.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {27, 32, 40}, m = "copyToSequentialImpl", n = {"$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "$this$copyToSequentialImpl", "dst", "limit", "remainingLimit", "transferred"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2"})
    /* renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$copyToSequentialImpl$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.copyToSequentialImpl(null, null, 0L, this);
        }
    }

    /* compiled from: SequentialCopyTo.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 1, 1}, l = {60, 66}, m = "copyToTail", n = {"dst", "lastPiece", "lastPiece", "rc"}, s = {"L$0", "L$1", "L$0", "I$0"})
    /* renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1, reason: invalid class name and case insensitive filesystem */
    static final class C12701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12701(Continuation<? super C12701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.copyToTail(null, null, 0L, this);
        }
    }

    /* compiled from: SequentialCopyTo.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0}, l = {8}, m = "joinToImpl", n = {"dst", "closeOnEnd"}, s = {"L$0", "Z$0"})
    /* renamed from: io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1, reason: invalid class name and case insensitive filesystem */
    static final class C12711 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C12711(Continuation<? super C12711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SequentialCopyToKt.joinToImpl(null, null, false, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object joinToImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.ByteChannelSequentialBase r5, boolean r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.internal.SequentialCopyToKt.C12711
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 r0 = (io.ktor.utils.io.internal.SequentialCopyToKt.C12711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$joinToImpl$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            boolean r6 = r0.Z$0
            java.lang.Object r4 = r0.L$0
            r5 = r4
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.Z$0 = r6
            r0.label = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r4 = copyToSequentialImpl(r4, r5, r2, r0)
            if (r4 != r1) goto L4e
            return r1
        L4e:
            if (r6 == 0) goto L55
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            io.ktor.utils.io.ByteWriteChannelKt.close(r5)
        L55:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.joinToImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d9 -> B:50:0x00fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00df -> B:49:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00f1 -> B:49:0x00f4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyToSequentialImpl(io.ktor.utils.io.ByteChannelSequentialBase r18, io.ktor.utils.io.ByteChannelSequentialBase r19, long r20, kotlin.coroutines.Continuation<? super java.lang.Long> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.copyToSequentialImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v9, types: [io.ktor.utils.io.core.internal.ChunkBuffer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyToTail(io.ktor.utils.io.ByteChannelSequentialBase r8, io.ktor.utils.io.ByteChannelSequentialBase r9, long r10, kotlin.coroutines.Continuation<? super java.lang.Long> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.io.internal.SequentialCopyToKt.C12701
            if (r0 == 0) goto L14
            r0 = r12
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 r0 = (io.ktor.utils.io.internal.SequentialCopyToKt.C12701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1 r0 = new io.ktor.utils.io.internal.SequentialCopyToKt$copyToTail$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = (io.ktor.utils.io.core.internal.ChunkBuffer) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L4d
            goto Lae
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            io.ktor.utils.io.core.internal.ChunkBuffer r9 = (io.ktor.utils.io.core.internal.ChunkBuffer) r9
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> L4d
            r7 = r9
            r9 = r8
            r8 = r12
            r12 = r7
            goto L78
        L4d:
            r8 = move-exception
            goto Lbf
        L4f:
            kotlin.ResultKt.throwOnFailure(r12)
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r12 = io.ktor.utils.io.core.internal.ChunkBuffer.INSTANCE
            io.ktor.utils.io.pool.ObjectPool r12 = r12.getPool()
            java.lang.Object r12 = r12.borrow()
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = (io.ktor.utils.io.core.internal.ChunkBuffer) r12
            int r2 = r12.getCapacity()     // Catch: java.lang.Throwable -> Lbd
            long r5 = (long) r2     // Catch: java.lang.Throwable -> Lbd
            long r10 = kotlin.ranges.RangesKt.coerceAtMost(r10, r5)     // Catch: java.lang.Throwable -> Lbd
            int r10 = (int) r10     // Catch: java.lang.Throwable -> Lbd
            r12.resetForWrite(r10)     // Catch: java.lang.Throwable -> Lbd
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Lbd
            r0.L$1 = r12     // Catch: java.lang.Throwable -> Lbd
            r0.label = r4     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r8 = r8.readAvailable(r12, r0)     // Catch: java.lang.Throwable -> Lbd
            if (r8 != r1) goto L78
            return r1
        L78:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> Lbd
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> Lbd
            r10 = -1
            if (r8 != r10) goto L9a
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r8 = io.ktor.utils.io.core.internal.ChunkBuffer.INSTANCE     // Catch: java.lang.Throwable -> Lbd
            io.ktor.utils.io.pool.ObjectPool r8 = r8.getPool()     // Catch: java.lang.Throwable -> Lbd
            r12.release(r8)     // Catch: java.lang.Throwable -> Lbd
            r8 = 0
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch: java.lang.Throwable -> Lbd
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r9 = io.ktor.utils.io.core.internal.ChunkBuffer.INSTANCE
            io.ktor.utils.io.pool.ObjectPool r9 = r9.getPool()
            r12.release(r9)
            return r8
        L9a:
            r10 = r12
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.io.core.Buffer) r10     // Catch: java.lang.Throwable -> Lbd
            r0.L$0 = r12     // Catch: java.lang.Throwable -> Lbd
            r11 = 0
            r0.L$1 = r11     // Catch: java.lang.Throwable -> Lbd
            r0.I$0 = r8     // Catch: java.lang.Throwable -> Lbd
            r0.label = r3     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r9 = r9.writeFully(r10, r0)     // Catch: java.lang.Throwable -> Lbd
            if (r9 != r1) goto Lad
            return r1
        Lad:
            r9 = r12
        Lae:
            long r10 = (long) r8
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)     // Catch: java.lang.Throwable -> L4d
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.INSTANCE
            io.ktor.utils.io.pool.ObjectPool r10 = r10.getPool()
            r9.release(r10)
            return r8
        Lbd:
            r8 = move-exception
            r9 = r12
        Lbf:
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r10 = io.ktor.utils.io.core.internal.ChunkBuffer.INSTANCE
            io.ktor.utils.io.pool.ObjectPool r10 = r10.getPool()
            r9.release(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.SequentialCopyToKt.copyToTail(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
