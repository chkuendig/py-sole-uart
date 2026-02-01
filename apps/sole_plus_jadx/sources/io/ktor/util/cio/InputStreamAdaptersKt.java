package io.ktor.util.cio;

import com.android.SdkConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: InputStreamAdapters.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"toByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/InputStream;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", SdkConstants.ATTR_CONTEXT, "Lkotlin/coroutines/CoroutineContext;", SdkConstants.ATTR_PARENT, "Lkotlinx/coroutines/Job;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputStreamAdaptersKt {
    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(InputStream inputStream, ObjectPool objectPool, CoroutineContext coroutineContext, Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            objectPool = ByteBufferPoolKt.getKtorDefaultPool();
        }
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        if ((i & 4) != 0) {
            job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        }
        return toByteReadChannel(inputStream, objectPool, coroutineContext, job);
    }

    /* compiled from: InputStreamAdapters.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.InputStreamAdaptersKt$toByteReadChannel$1", f = "InputStreamAdapters.kt", i = {0, 0}, l = {34}, m = "invokeSuspend", n = {"$this$writer", "buffer"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.util.cio.InputStreamAdaptersKt$toByteReadChannel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        final /* synthetic */ InputStream $this_toByteReadChannel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ObjectPool<ByteBuffer> objectPool, InputStream inputStream, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$pool = objectPool;
            this.$this_toByteReadChannel = inputStream;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$pool, this.$this_toByteReadChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            ByteBuffer byteBufferBorrow;
            WriterScope writerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope2 = (WriterScope) this.L$0;
                byteBufferBorrow = this.$pool.borrow();
                writerScope = writerScope2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteBufferBorrow = (ByteBuffer) this.L$1;
                writerScope = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } finally {
                    try {
                        this.$pool.recycle(byteBufferBorrow);
                        this.$this_toByteReadChannel.close();
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                    }
                }
            }
            while (true) {
                byteBufferBorrow.clear();
                int i2 = this.$this_toByteReadChannel.read(byteBufferBorrow.array(), byteBufferBorrow.arrayOffset() + byteBufferBorrow.position(), byteBufferBorrow.remaining());
                if (i2 < 0) {
                    break;
                }
                if (i2 != 0) {
                    byteBufferBorrow.position(byteBufferBorrow.position() + i2);
                    byteBufferBorrow.flip();
                    this.L$0 = writerScope;
                    this.L$1 = byteBufferBorrow;
                    this.label = 1;
                    if (writerScope.getChannel().writeFully(byteBufferBorrow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.$pool.recycle(byteBufferBorrow);
            this.$this_toByteReadChannel.close();
            return Unit.INSTANCE;
        }
    }

    public static final ByteReadChannel toByteReadChannel(InputStream inputStream, ObjectPool<ByteBuffer> pool, CoroutineContext context, Job parent) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return CoroutinesKt.writer(CoroutineScopeKt.CoroutineScope(context), (CoroutineContext) parent, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(pool, inputStream, null)).getChannel();
    }
}
