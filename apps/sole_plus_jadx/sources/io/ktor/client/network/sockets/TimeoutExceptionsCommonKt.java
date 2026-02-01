package io.ktor.client.network.sockets;

import io.ktor.client.request.HttpRequestData;
import io.ktor.util.InternalAPI;
import io.ktor.util.PlatformUtils;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TimeoutExceptionsCommon.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\b"}, d2 = {"mapEngineExceptions", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "input", "request", "Lio/ktor/client/request/HttpRequestData;", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TimeoutExceptionsCommonKt {
    @InternalAPI
    public static final ByteReadChannel mapEngineExceptions(CoroutineScope coroutineScope, ByteReadChannel input, HttpRequestData request) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(request, "request");
        if (PlatformUtils.INSTANCE.getIS_NATIVE()) {
            return input;
        }
        ByteChannel byteChannelByteChannelWithMappedExceptions = TimeoutExceptionsKt.ByteChannelWithMappedExceptions(request);
        CoroutinesKt.writer$default(coroutineScope, (CoroutineContext) null, byteChannelByteChannelWithMappedExceptions, new AnonymousClass1(input, byteChannelByteChannelWithMappedExceptions, null), 1, (Object) null);
        return byteChannelByteChannelWithMappedExceptions;
    }

    /* compiled from: TimeoutExceptionsCommon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1", f = "TimeoutExceptionsCommon.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ ByteChannel $replacementChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
            this.$replacementChannel = byteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$input, this.$replacementChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (ByteReadChannelKt.copyAndClose$default(this.$input, this.$replacementChannel, 0L, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                this.$input.cancel(th);
            }
            return Unit.INSTANCE;
        }
    }

    @InternalAPI
    public static final ByteWriteChannel mapEngineExceptions(CoroutineScope coroutineScope, ByteWriteChannel output, HttpRequestData request) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(request, "request");
        if (PlatformUtils.INSTANCE.getIS_NATIVE()) {
            return output;
        }
        ByteChannel byteChannelByteChannelWithMappedExceptions = TimeoutExceptionsKt.ByteChannelWithMappedExceptions(request);
        CoroutinesKt.writer$default(coroutineScope, (CoroutineContext) null, byteChannelByteChannelWithMappedExceptions, new AnonymousClass2(byteChannelByteChannelWithMappedExceptions, output, null), 1, (Object) null);
        return byteChannelByteChannelWithMappedExceptions;
    }

    /* compiled from: TimeoutExceptionsCommon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$2", f = "TimeoutExceptionsCommon.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteWriteChannel $output;
        final /* synthetic */ ByteChannel $replacementChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ByteChannel byteChannel, ByteWriteChannel byteWriteChannel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$replacementChannel = byteChannel;
            this.$output = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$replacementChannel, this.$output, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (ByteReadChannelKt.copyAndClose$default(this.$replacementChannel, this.$output, 0L, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                this.$replacementChannel.close(th);
            }
            return Unit.INSTANCE;
        }
    }
}
