package io.ktor.utils.io;

import androidx.exifinterface.media.ExifInterface;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: Coroutines.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.CoroutinesKt$launchChannel$job$1", f = "Coroutines.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CoroutinesKt$launchChannel$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $attachJob;
    final /* synthetic */ Function2<S, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ ByteChannel $channel;
    final /* synthetic */ CoroutineDispatcher $dispatcher;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoroutinesKt$launchChannel$job$1(boolean z, ByteChannel byteChannel, Function2<? super S, ? super Continuation<? super Unit>, ? extends Object> function2, CoroutineDispatcher coroutineDispatcher, Continuation<? super CoroutinesKt$launchChannel$job$1> continuation) {
        super(2, continuation);
        this.$attachJob = z;
        this.$channel = byteChannel;
        this.$block = function2;
        this.$dispatcher = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutinesKt$launchChannel$job$1 coroutinesKt$launchChannel$job$1 = new CoroutinesKt$launchChannel$job$1(this.$attachJob, this.$channel, this.$block, this.$dispatcher, continuation);
        coroutinesKt$launchChannel$job$1.L$0 = obj;
        return coroutinesKt$launchChannel$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutinesKt$launchChannel$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (this.$attachJob) {
                    ByteChannel byteChannel = this.$channel;
                    CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    byteChannel.attachJob((Job) element);
                }
                ChannelScope channelScope = new ChannelScope(coroutineScope, this.$channel);
                Function2<S, Continuation<? super Unit>, Object> function2 = this.$block;
                this.label = 1;
                if (function2.invoke(channelScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th) {
            if (!Intrinsics.areEqual(this.$dispatcher, Dispatchers.getUnconfined()) && this.$dispatcher != null) {
                throw th;
            }
            this.$channel.cancel(th);
        }
        return Unit.INSTANCE;
    }
}
