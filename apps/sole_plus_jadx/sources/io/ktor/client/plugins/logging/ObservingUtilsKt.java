package io.ktor.client.plugins.logging;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ObservingUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"observe", "Lio/ktor/http/content/OutgoingContent;", "log", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/http/content/OutgoingContent;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "ktor-client-logging"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObservingUtilsKt {

    /* compiled from: ObservingUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt", f = "ObservingUtils.kt", i = {0, 0}, l = {14}, m = "observe", n = {"$this$observe", "log"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return ObservingUtilsKt.observe(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object observe(io.ktor.http.content.OutgoingContent r4, io.ktor.utils.io.ByteWriteChannel r5, kotlin.coroutines.Continuation<? super io.ktor.http.content.OutgoingContent> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.client.plugins.logging.ObservingUtilsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1 r0 = (io.ktor.client.plugins.logging.ObservingUtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1 r0 = new io.ktor.client.plugins.logging.ObservingUtilsKt$observe$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.ByteWriteChannel r5 = (io.ktor.utils.io.ByteWriteChannel) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.http.content.OutgoingContent r4 = (io.ktor.http.content.OutgoingContent) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4 instanceof io.ktor.http.content.OutgoingContent.ByteArrayContent
            if (r6 == 0) goto L5a
            r6 = r4
            io.ktor.http.content.OutgoingContent$ByteArrayContent r6 = (io.ktor.http.content.OutgoingContent.ByteArrayContent) r6
            byte[] r6 = r6.getBytes()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r5, r6, r0)
            if (r6 != r1) goto L56
            return r1
        L56:
            io.ktor.utils.io.ByteWriteChannelKt.close(r5)
            goto L9f
        L5a:
            boolean r6 = r4 instanceof io.ktor.http.content.OutgoingContent.ReadChannelContent
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L7c
            io.ktor.utils.io.ByteChannel r6 = io.ktor.utils.io.ByteChannelKt.ByteChannel$default(r1, r3, r0)
            r0 = r4
            io.ktor.http.content.OutgoingContent$ReadChannelContent r0 = (io.ktor.http.content.OutgoingContent.ReadChannelContent) r0
            io.ktor.utils.io.ByteReadChannel r0 = r0.getChannel()
            r1 = r6
            io.ktor.utils.io.ByteWriteChannel r1 = (io.ktor.utils.io.ByteWriteChannel) r1
            io.ktor.util.ByteChannelsKt.copyToBoth(r0, r5, r1)
            io.ktor.client.plugins.logging.LoggedContent r5 = new io.ktor.client.plugins.logging.LoggedContent
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            r5.<init>(r4, r6)
            r4 = r5
            io.ktor.http.content.OutgoingContent r4 = (io.ktor.http.content.OutgoingContent) r4
            goto L9f
        L7c:
            boolean r6 = r4 instanceof io.ktor.http.content.OutgoingContent.WriteChannelContent
            if (r6 == 0) goto L9c
            io.ktor.utils.io.ByteChannel r6 = io.ktor.utils.io.ByteChannelKt.ByteChannel$default(r1, r3, r0)
            r0 = r4
            io.ktor.http.content.OutgoingContent$WriteChannelContent r0 = (io.ktor.http.content.OutgoingContent.WriteChannelContent) r0
            io.ktor.utils.io.ByteReadChannel r0 = toReadChannel(r0)
            r1 = r6
            io.ktor.utils.io.ByteWriteChannel r1 = (io.ktor.utils.io.ByteWriteChannel) r1
            io.ktor.util.ByteChannelsKt.copyToBoth(r0, r5, r1)
            io.ktor.client.plugins.logging.LoggedContent r5 = new io.ktor.client.plugins.logging.LoggedContent
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            r5.<init>(r4, r6)
            r4 = r5
            io.ktor.http.content.OutgoingContent r4 = (io.ktor.http.content.OutgoingContent) r4
            goto L9f
        L9c:
            io.ktor.utils.io.ByteWriteChannelKt.close(r5)
        L9f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.logging.ObservingUtilsKt.observe(io.ktor.http.content.OutgoingContent, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: ObservingUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1", f = "ObservingUtils.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1, reason: invalid class name and case insensitive filesystem */
    static final class C10891 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OutgoingContent.WriteChannelContent $this_toReadChannel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10891(OutgoingContent.WriteChannelContent writeChannelContent, Continuation<? super C10891> continuation) {
            super(2, continuation);
            this.$this_toReadChannel = writeChannelContent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10891 c10891 = new C10891(this.$this_toReadChannel, continuation);
            c10891.L$0 = obj;
            return c10891;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((C10891) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope = (WriterScope) this.L$0;
                this.label = 1;
                if (this.$this_toReadChannel.writeTo(writerScope.getChannel(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private static final ByteReadChannel toReadChannel(OutgoingContent.WriteChannelContent writeChannelContent) {
        return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, (CoroutineContext) Dispatchers.getDefault(), false, (Function2) new C10891(writeChannelContent, null), 2, (Object) null).getChannel();
    }
}
