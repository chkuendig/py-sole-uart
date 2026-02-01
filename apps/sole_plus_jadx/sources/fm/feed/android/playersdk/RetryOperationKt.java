package fm.feed.android.playersdk;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryOperation.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001ab\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"calculateDelay", "", "tryNumber", "", "initialIntervalMilli", "retryStrategy", "Lfm/feed/android/playersdk/RetryStrategy;", "retryOperation", "", "retries", "initialDelay", "operation", "Lkotlin/Function2;", "Lfm/feed/android/playersdk/RetryOperation;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(IJJLfm/feed/android/playersdk/RetryStrategy;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlayerSdk_exoDefaultRelease"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class RetryOperationKt {

    /* compiled from: RetryOperation.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RetryStrategy.values().length];
            iArr[RetryStrategy.CONSTANT.ordinal()] = 1;
            iArr[RetryStrategy.LINEAR.ordinal()] = 2;
            iArr[RetryStrategy.EXPONENTIAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: RetryOperation.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.RetryOperationKt", f = "RetryOperation.kt", i = {0, 0}, l = {44, 46}, m = "retryOperation", n = {"operation", "retryOperation"}, s = {"L$0", "L$1"})
    /* renamed from: fm.feed.android.playersdk.RetryOperationKt$retryOperation$1, reason: invalid class name */
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
            return RetryOperationKt.retryOperation(0, 0L, 0L, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object retryOperation(int r12, long r13, long r15, fm.feed.android.playersdk.RetryStrategy r17, kotlin.jvm.functions.Function2<? super fm.feed.android.playersdk.RetryOperation, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r0 = r19
            boolean r1 = r0 instanceof fm.feed.android.playersdk.RetryOperationKt.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            fm.feed.android.playersdk.RetryOperationKt$retryOperation$1 r1 = (fm.feed.android.playersdk.RetryOperationKt.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            fm.feed.android.playersdk.RetryOperationKt$retryOperation$1 r1 = new fm.feed.android.playersdk.RetryOperationKt$retryOperation$1
            r1.<init>(r0)
        L1b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L44
            if (r3 == r5) goto L37
            if (r3 != r4) goto L2f
            kotlin.ResultKt.throwOnFailure(r0)
            goto L71
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            java.lang.Object r3 = r1.L$1
            fm.feed.android.playersdk.RetryOperation r3 = (fm.feed.android.playersdk.RetryOperation) r3
            java.lang.Object r5 = r1.L$0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r5
            goto L63
        L44:
            kotlin.ResultKt.throwOnFailure(r0)
            fm.feed.android.playersdk.RetryOperation r3 = new fm.feed.android.playersdk.RetryOperation
            r6 = r3
            r7 = r12
            r8 = r15
            r10 = r17
            r11 = r18
            r6.<init>(r7, r8, r10, r11)
            r0 = r18
            r1.L$0 = r0
            r1.L$1 = r3
            r1.label = r5
            r5 = r13
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r13, r1)
            if (r5 != r2) goto L63
            return r2
        L63:
            r5 = 0
            r1.L$0 = r5
            r1.L$1 = r5
            r1.label = r4
            java.lang.Object r0 = r0.invoke(r3, r1)
            if (r0 != r2) goto L71
            return r2
        L71:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.RetryOperationKt.retryOperation(int, long, long, fm.feed.android.playersdk.RetryStrategy, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final long calculateDelay(int i, long j, RetryStrategy retryStrategy) {
        Intrinsics.checkNotNullParameter(retryStrategy, "retryStrategy");
        int i2 = WhenMappings.$EnumSwitchMapping$0[retryStrategy.ordinal()];
        if (i2 == 1) {
            return j;
        }
        if (i2 == 2) {
            return j * i;
        }
        if (i2 == 3) {
            return (long) Math.pow(2.0d, i);
        }
        throw new NoWhenBranchMatchedException();
    }
}
