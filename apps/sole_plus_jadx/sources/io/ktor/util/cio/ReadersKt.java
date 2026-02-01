package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Readers.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"toByteArray", "", "Lio/ktor/utils/io/ByteReadChannel;", "limit", "", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "use", "", "Lio/ktor/utils/io/ByteWriteChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ReadersKt {

    /* compiled from: Readers.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.ReadersKt", f = "Readers.kt", i = {}, l = {15}, m = "toByteArray", n = {}, s = {})
    /* renamed from: io.ktor.util.cio.ReadersKt$toByteArray$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReadersKt.toByteArray(null, 0, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object toByteArray(io.ktor.utils.io.ByteReadChannel r4, int r5, kotlin.coroutines.Continuation<? super byte[]> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.util.cio.ReadersKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.util.cio.ReadersKt$toByteArray$1 r0 = (io.ktor.util.cio.ReadersKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.util.cio.ReadersKt$toByteArray$1 r0 = new io.ktor.util.cio.ReadersKt$toByteArray$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3f
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            long r5 = (long) r5
            r0.label = r3
            java.lang.Object r6 = r4.readRemaining(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            io.ktor.utils.io.core.ByteReadPacket r6 = (io.ktor.utils.io.core.ByteReadPacket) r6
            r4 = 0
            r5 = 0
            byte[] r4 = io.ktor.utils.io.core.StringsKt.readBytes$default(r6, r4, r3, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.cio.ReadersKt.toByteArray(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object toByteArray$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return toByteArray(byteReadChannel, i, continuation);
    }

    public static final void use(ByteWriteChannel byteWriteChannel, Function1<? super ByteWriteChannel, Unit> block) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke(byteWriteChannel);
        } finally {
        }
    }
}
