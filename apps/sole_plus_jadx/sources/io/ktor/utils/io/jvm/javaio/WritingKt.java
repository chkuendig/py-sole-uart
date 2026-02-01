package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Writing.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/ByteReadChannel;", "out", "Ljava/io/OutputStream;", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/io/OutputStream;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WritingKt {

    /* compiled from: Writing.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.WritingKt", f = "Writing.kt", i = {0, 0, 0, 0, 0, 0}, l = {22}, m = "copyTo", n = {"$this$copyTo", "out", "buffer", "limit", "copied", "bufferSize"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2"})
    /* renamed from: io.ktor.utils.io.jvm.javaio.WritingKt$copyTo$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WritingKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0093 -> B:47:0x0097). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r18, java.io.OutputStream r19, long r20, kotlin.coroutines.Continuation<? super java.lang.Long> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.jvm.javaio.WritingKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.io.OutputStream, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, OutputStream outputStream, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, outputStream, j, continuation);
    }
}
