package io.ktor.client.plugins.cache.storage;

import io.ktor.utils.io.ByteChannel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$1$1$1", f = "FileCacheStorage.kt", i = {}, l = {96, 98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FileCacheStorage$writeCache$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CachedResponseData> $caches;
    final /* synthetic */ ByteChannel $channel;
    Object L$0;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileCacheStorage$writeCache$2$1$1$1(ByteChannel byteChannel, List<CachedResponseData> list, FileCacheStorage fileCacheStorage, Continuation<? super FileCacheStorage$writeCache$2$1$1$1> continuation) {
        super(2, continuation);
        this.$channel = byteChannel;
        this.$caches = list;
        this.this$0 = fileCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileCacheStorage$writeCache$2$1$1$1(this.$channel, this.$caches, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileCacheStorage$writeCache$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r6.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L39
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.utils.io.ByteChannel r7 = r6.$channel
            java.util.List<io.ktor.client.plugins.cache.storage.CachedResponseData> r1 = r6.$caches
            int r1 = r1.size()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r7 = r7.writeInt(r1, r4)
            if (r7 != r0) goto L39
            return r0
        L39:
            java.util.List<io.ktor.client.plugins.cache.storage.CachedResponseData> r7 = r6.$caches
            java.util.Iterator r7 = r7.iterator()
            r1 = r7
        L40:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L5e
            java.lang.Object r7 = r1.next()
            io.ktor.client.plugins.cache.storage.CachedResponseData r7 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r7
            io.ktor.client.plugins.cache.storage.FileCacheStorage r3 = r6.this$0
            io.ktor.utils.io.ByteChannel r4 = r6.$channel
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = io.ktor.client.plugins.cache.storage.FileCacheStorage.access$writeCache(r3, r4, r7, r5)
            if (r7 != r0) goto L40
            return r0
        L5e:
            io.ktor.utils.io.ByteChannel r7 = r6.$channel
            io.ktor.utils.io.ByteWriteChannel r7 = (io.ktor.utils.io.ByteWriteChannel) r7
            io.ktor.utils.io.ByteWriteChannelKt.close(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
