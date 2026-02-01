package io.ktor.client.utils;

import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannelUtils.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001an\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"observable", "Lio/ktor/utils/io/ByteReadChannel;", SdkConstants.ATTR_CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "contentLength", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "bytesSentTotal", "Lkotlin/coroutines/Continuation;", "", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Long;Lkotlin/jvm/functions/Function3;)Lio/ktor/utils/io/ByteReadChannel;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteChannelUtilsKt {

    /* compiled from: ByteChannelUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.utils.ByteChannelUtilsKt$observable$1", f = "ByteChannelUtils.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3}, l = {23, 24, 26, 31}, m = "invokeSuspend", n = {"$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "read", "$this$writer", "$this$useInstance$iv", "instance$iv", "byteArray", "total", "bytesSend", "$this$useInstance$iv", "instance$iv"}, s = {"L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "I$0", "L$0", "L$1", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1"})
    /* renamed from: io.ktor.client.utils.ByteChannelUtilsKt$observable$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Long $contentLength;
        final /* synthetic */ Function3<Long, Long, Continuation<? super Unit>, Object> $listener;
        final /* synthetic */ ByteReadChannel $this_observable;
        int I$0;
        long J$0;
        long J$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Long l, ByteReadChannel byteReadChannel, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$contentLength = l;
            this.$this_observable = byteReadChannel;
            this.$listener = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$contentLength, this.$this_observable, this.$listener, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00e7 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:9:0x001d, B:61:0x01a0, B:37:0x00e1, B:39:0x00e7, B:42:0x0100, B:54:0x016e, B:58:0x0181), top: B:68:0x000c }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0126 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0159 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x016e A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #0 {all -> 0x0022, blocks: (B:9:0x001d, B:61:0x01a0, B:37:0x00e1, B:39:0x00e7, B:42:0x0100, B:54:0x016e, B:58:0x0181), top: B:68:0x000c }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x015a -> B:51:0x0167). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 430
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.utils.ByteChannelUtilsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final ByteReadChannel observable(ByteReadChannel byteReadChannel, CoroutineContext context, Long l, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> listener) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, context, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(l, byteReadChannel, listener, null)).getChannel();
    }
}
