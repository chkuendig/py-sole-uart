package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: Delimited.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/LookAheadSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1", f = "Delimited.kt", i = {0, 0, 1, 1}, l = {85, 95}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "copied", "$this$lookAheadSuspend", "copied"}, s = {"L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes6.dex */
final class DelimitedKt$readUntilDelimiterSuspend$copied$1 extends SuspendLambda implements Function2<LookAheadSuspendSession, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $copied0;
    final /* synthetic */ ByteBuffer $delimiter;
    final /* synthetic */ ByteBuffer $dst;
    final /* synthetic */ Ref.BooleanRef $endFound;
    final /* synthetic */ ByteReadChannel $this_readUntilDelimiterSuspend;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DelimitedKt$readUntilDelimiterSuspend$copied$1(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, Ref.BooleanRef booleanRef, ByteReadChannel byteReadChannel, Continuation<? super DelimitedKt$readUntilDelimiterSuspend$copied$1> continuation) {
        super(2, continuation);
        this.$copied0 = i;
        this.$delimiter = byteBuffer;
        this.$dst = byteBuffer2;
        this.$endFound = booleanRef;
        this.$this_readUntilDelimiterSuspend = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DelimitedKt$readUntilDelimiterSuspend$copied$1 delimitedKt$readUntilDelimiterSuspend$copied$1 = new DelimitedKt$readUntilDelimiterSuspend$copied$1(this.$copied0, this.$delimiter, this.$dst, this.$endFound, this.$this_readUntilDelimiterSuspend, continuation);
        delimitedKt$readUntilDelimiterSuspend$copied$1.L$0 = obj;
        return delimitedKt$readUntilDelimiterSuspend$copied$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LookAheadSuspendSession lookAheadSuspendSession, Continuation<? super Integer> continuation) {
        return ((DelimitedKt$readUntilDelimiterSuspend$copied$1) create(lookAheadSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
    
        if (r7.$endFound.element == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0083, code lost:
    
        r1 = r1 + r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0080 -> B:26:0x0083). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            int r1 = r7.I$0
            java.lang.Object r4 = r7.L$0
            io.ktor.utils.io.LookAheadSuspendSession r4 = (io.ktor.utils.io.LookAheadSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L83
        L18:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L20:
            int r1 = r7.I$0
            java.lang.Object r4 = r7.L$0
            io.ktor.utils.io.LookAheadSuspendSession r4 = (io.ktor.utils.io.LookAheadSuspendSession) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L44
        L2a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            io.ktor.utils.io.LookAheadSuspendSession r8 = (io.ktor.utils.io.LookAheadSuspendSession) r8
            int r1 = r7.$copied0
        L33:
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.L$0 = r8
            r7.I$0 = r1
            r7.label = r3
            java.lang.Object r4 = r8.awaitAtLeast(r3, r4)
            if (r4 != r0) goto L43
            return r0
        L43:
            r4 = r8
        L44:
            r8 = r4
            io.ktor.utils.io.LookAheadSession r8 = (io.ktor.utils.io.LookAheadSession) r8
            java.nio.ByteBuffer r5 = r7.$delimiter
            java.nio.ByteBuffer r6 = r7.$dst
            int r5 = io.ktor.utils.io.DelimitedKt.access$tryCopyUntilDelimiter(r8, r5, r6)
            if (r5 != 0) goto L85
            java.nio.ByteBuffer r5 = r7.$delimiter
            int r8 = io.ktor.utils.io.DelimitedKt.access$startsWithDelimiter(r8, r5)
            java.nio.ByteBuffer r5 = r7.$delimiter
            int r5 = r5.remaining()
            if (r8 != r5) goto L64
            kotlin.jvm.internal.Ref$BooleanRef r8 = r7.$endFound
            r8.element = r3
            goto L9c
        L64:
            io.ktor.utils.io.ByteReadChannel r8 = r7.$this_readUntilDelimiterSuspend
            boolean r8 = r8.isClosedForWrite()
            if (r8 == 0) goto L6d
            goto L9c
        L6d:
            java.nio.ByteBuffer r8 = r7.$delimiter
            int r8 = r8.remaining()
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r4
            r7.I$0 = r1
            r7.label = r2
            java.lang.Object r8 = r4.awaitAtLeast(r8, r5)
            if (r8 != r0) goto L83
            return r0
        L83:
            r8 = r4
            goto L8e
        L85:
            if (r5 > 0) goto L8c
            kotlin.jvm.internal.Ref$BooleanRef r8 = r7.$endFound
            r8.element = r3
            int r5 = -r5
        L8c:
            int r1 = r1 + r5
            goto L83
        L8e:
            java.nio.ByteBuffer r4 = r7.$dst
            boolean r4 = r4.hasRemaining()
            if (r4 == 0) goto L9c
            kotlin.jvm.internal.Ref$BooleanRef r4 = r7.$endFound
            boolean r4 = r4.element
            if (r4 == 0) goto L33
        L9c:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
