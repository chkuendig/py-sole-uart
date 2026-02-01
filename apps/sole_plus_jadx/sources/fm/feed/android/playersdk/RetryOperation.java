package fm.feed.android.playersdk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryOperation.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BO\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u0015\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\fX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lfm/feed/android/playersdk/RetryOperation;", "", "retries", "", "initialIntervalMilli", "", "retryStrategy", "Lfm/feed/android/playersdk/RetryStrategy;", "retry", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(IJLfm/feed/android/playersdk/RetryStrategy;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "<set-?>", "tryNumber", "getTryNumber", "()I", "setTryNumber$PlayerSdk_exoDefaultRelease", "(I)V", "operationFailed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class RetryOperation {
    private final long initialIntervalMilli;
    private final int retries;
    private final Function2<RetryOperation, Continuation<? super Unit>, Object> retry;
    private final RetryStrategy retryStrategy;
    private int tryNumber;

    /* compiled from: RetryOperation.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.RetryOperation", f = "RetryOperation.kt", i = {0}, l = {20, 21}, m = "operationFailed", n = {"this"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.RetryOperation$operationFailed$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetryOperation.this.operationFailed(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RetryOperation(int i, long j, RetryStrategy retryStrategy, Function2<? super RetryOperation, ? super Continuation<? super Unit>, ? extends Object> retry) {
        Intrinsics.checkNotNullParameter(retryStrategy, "retryStrategy");
        Intrinsics.checkNotNullParameter(retry, "retry");
        this.retries = i;
        this.initialIntervalMilli = j;
        this.retryStrategy = retryStrategy;
        this.retry = retry;
    }

    public /* synthetic */ RetryOperation(int i, long j, RetryStrategy retryStrategy, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 1000L : j, (i2 & 4) != 0 ? RetryStrategy.LINEAR : retryStrategy, function2);
    }

    public final int getTryNumber() {
        return this.tryNumber;
    }

    public final void setTryNumber$PlayerSdk_exoDefaultRelease(int i) {
        this.tryNumber = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object operationFailed(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof fm.feed.android.playersdk.RetryOperation.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            fm.feed.android.playersdk.RetryOperation$operationFailed$1 r0 = (fm.feed.android.playersdk.RetryOperation.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            fm.feed.android.playersdk.RetryOperation$operationFailed$1 r0 = new fm.feed.android.playersdk.RetryOperation$operationFailed$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L89
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            java.lang.Object r2 = r0.L$0
            fm.feed.android.playersdk.RetryOperation r2 = (fm.feed.android.playersdk.RetryOperation) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7b
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            int r8 = r7.getTryNumber()
            int r8 = r8 + r4
            r7.setTryNumber$PlayerSdk_exoDefaultRelease(r8)
            int r8 = r7.getTryNumber()
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            java.lang.String r2 = "Session call to server failed, retry no  "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r8)
            java.lang.String r2 = "FeedMediaSDK"
            android.util.Log.e(r2, r8)
            int r8 = r7.getTryNumber()
            int r2 = r7.retries
            if (r8 >= r2) goto L8c
            int r8 = r7.getTryNumber()
            long r5 = r7.initialIntervalMilli
            fm.feed.android.playersdk.RetryStrategy r2 = r7.retryStrategy
            long r5 = fm.feed.android.playersdk.RetryOperationKt.calculateDelay(r8, r5, r2)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r8 != r1) goto L7a
            return r1
        L7a:
            r2 = r7
        L7b:
            kotlin.jvm.functions.Function2<fm.feed.android.playersdk.RetryOperation, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r8 = r2.retry
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r8 = r8.invoke(r2, r0)
            if (r8 != r1) goto L89
            return r1
        L89:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L8c:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.RetryOperation.operationFailed(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
