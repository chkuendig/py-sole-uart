package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"CHUNK_BUFFER_SIZE", "", "copyToBoth", "", "Lio/ktor/utils/io/ByteReadChannel;", "first", "Lio/ktor/utils/io/ByteWriteChannel;", "second", "split", "Lkotlin/Pair;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "toByteArray", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    /* compiled from: ByteChannels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", i = {}, l = {88}, m = "toByteArray", n = {}, s = {})
    /* renamed from: io.ktor.util.ByteChannelsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    static final class C11631 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11631(Continuation<? super C11631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelsKt.toByteArray(null, this);
        }
    }

    public static final Pair<ByteReadChannel, ByteReadChannel> split(ByteReadChannel byteReadChannel, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        final ByteChannel ByteChannel = ByteChannelKt.ByteChannel(true);
        final ByteChannel ByteChannel2 = ByteChannelKt.ByteChannel(true);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C11611(byteReadChannel, ByteChannel, ByteChannel2, null), 3, null).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt.split.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    return;
                }
                ByteChannel.cancel(th);
                ByteChannel2.cancel(th);
            }
        });
        return TuplesKt.to(ByteChannel, ByteChannel2);
    }

    /* compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1", f = "ByteChannels.kt", i = {0, 1, 1, 1}, l = {24, 28}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.util.ByteChannelsKt$split$1, reason: invalid class name and case insensitive filesystem */
    static final class C11611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteChannel $first;
        final /* synthetic */ ByteChannel $second;
        final /* synthetic */ ByteReadChannel $this_split;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11611(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ByteChannel byteChannel2, Continuation<? super C11611> continuation) {
            super(2, continuation);
            this.$this_split = byteReadChannel;
            this.$first = byteChannel;
            this.$second = byteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11611 c11611 = new C11611(this.$this_split, this.$first, this.$second, continuation);
            c11611.L$0 = obj;
            return c11611;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0036, TryCatch #2 {all -> 0x0036, blocks: (B:30:0x00ac, B:19:0x0040, B:21:0x0048, B:24:0x005c, B:41:0x00bf, B:42:0x00c0, B:45:0x00d7, B:14:0x0030, B:34:0x00b4, B:39:0x00bd, B:38:0x00ba), top: B:57:0x0030, inners: #3, #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a4 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00c0 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #2 {all -> 0x0036, blocks: (B:30:0x00ac, B:19:0x0040, B:21:0x0048, B:24:0x005c, B:41:0x00bf, B:42:0x00c0, B:45:0x00d7, B:14:0x0030, B:34:0x00b4, B:39:0x00bd, B:38:0x00ba), top: B:57:0x0030, inners: #3, #5 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a5 -> B:29:0x00aa). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 251
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.C11611.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ByteChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.ByteChannelsKt$copyToBoth$1", f = "ByteChannels.kt", i = {1, 1, 1, 2, 2}, l = {58, 60, 61}, m = "invokeSuspend", n = {"$this$use$iv", "it", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$4", "I$0", "L$0", "I$0"})
    /* renamed from: io.ktor.util.ByteChannelsKt$copyToBoth$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteWriteChannel $first;
        final /* synthetic */ ByteWriteChannel $second;
        final /* synthetic */ ByteReadChannel $this_copyToBoth;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_copyToBoth = byteReadChannel;
            this.$first = byteWriteChannel;
            this.$second = byteWriteChannel2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_copyToBoth, this.$first, this.$second, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x006b A[Catch: all -> 0x005d, TryCatch #5 {all -> 0x005d, blocks: (B:44:0x00e4, B:24:0x0063, B:26:0x006b, B:28:0x0073, B:30:0x007b, B:33:0x0095, B:53:0x00f4, B:54:0x00f5, B:57:0x00fe, B:19:0x0059, B:51:0x00f2, B:50:0x00ef, B:47:0x00ea, B:34:0x009e, B:43:0x00d7), top: B:74:0x0059, inners: #1, #4 }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ba A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00d3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00fe A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #5 {all -> 0x005d, blocks: (B:44:0x00e4, B:24:0x0063, B:26:0x006b, B:28:0x0073, B:30:0x007b, B:33:0x0095, B:53:0x00f4, B:54:0x00f5, B:57:0x00fe, B:19:0x0059, B:51:0x00f2, B:50:0x00ef, B:47:0x00ea, B:34:0x009e, B:43:0x00d7), top: B:74:0x0059, inners: #1, #4 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d1 -> B:41:0x00d4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void copyToBoth(ByteReadChannel byteReadChannel, final ByteWriteChannel first, final ByteWriteChannel second) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), null, new AnonymousClass1(byteReadChannel, first, second, null), 2, null).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt.copyToBoth.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    return;
                }
                first.close(th);
                second.close(th);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object toByteArray(io.ktor.utils.io.ByteReadChannel r8, kotlin.coroutines.Continuation<? super byte[]> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.util.ByteChannelsKt.C11631
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = (io.ktor.util.ByteChannelsKt.C11631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = new io.ktor.util.ByteChannelsKt$toByteArray$1
            r0.<init>(r9)
        L19:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L33
            if (r1 != r7) goto L2b
            kotlin.ResultKt.throwOnFailure(r9)
            goto L44
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r9)
            r4.label = r7
            r2 = 0
            r5 = 1
            r6 = 0
            r1 = r8
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L44
            return r0
        L44:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r8 = 0
            r0 = 0
            byte[] r8 = io.ktor.utils.io.core.StringsKt.readBytes$default(r9, r8, r7, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.toByteArray(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
