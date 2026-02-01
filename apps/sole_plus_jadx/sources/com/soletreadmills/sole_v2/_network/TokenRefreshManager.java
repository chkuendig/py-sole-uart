package com.soletreadmills.sole_v2._network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import timber.log.Timber;

/* compiled from: TokenRefreshManager.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00132\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/_network/TokenRefreshManager;", "", "()V", "FAIL_COOLDOWN_MS", "", "REFRESH_ACTION_TIMEOUT_MS", "REFRESH_AWAIT_TIMEOUT_MS", "lastRefreshFailTime", "refreshJob", "Lkotlinx/coroutines/Deferred;", "", "refreshLock", "Lkotlinx/coroutines/sync/Mutex;", "refreshScope", "Lkotlinx/coroutines/CoroutineScope;", "refreshTokenIfNeeded", "oldToken", "", "getNowToken", "Lkotlin/Function0;", "refreshAction", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TokenRefreshManager {
    private static final long FAIL_COOLDOWN_MS = 5000;
    private static final long REFRESH_ACTION_TIMEOUT_MS = 15000;
    private static final long REFRESH_AWAIT_TIMEOUT_MS = 20000;
    private static long lastRefreshFailTime;
    private static Deferred<Boolean> refreshJob;
    public static final TokenRefreshManager INSTANCE = new TokenRefreshManager();
    private static final Mutex refreshLock = MutexKt.Mutex$default(false, 1, null);
    private static final CoroutineScope refreshScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    public static final int $stable = 8;

    /* compiled from: TokenRefreshManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._network.TokenRefreshManager", f = "TokenRefreshManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {203, 136, 213}, m = "refreshTokenIfNeeded", n = {"oldToken", "getNowToken", "refreshAction", "threadName", "$this$withLock_u24default$iv", "oldToken", "getNowToken", "threadName", "jobToAwait", "oldToken", "getNowToken", "threadName", "jobToAwait", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: com.soletreadmills.sole_v2._network.TokenRefreshManager$refreshTokenIfNeeded$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TokenRefreshManager.this.refreshTokenIfNeeded(null, null, null, this);
        }
    }

    /* compiled from: TokenRefreshManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._network.TokenRefreshManager", f = "TokenRefreshManager.kt", i = {0}, l = {203}, m = "reset", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2._network.TokenRefreshManager$reset$1, reason: invalid class name and case insensitive filesystem */
    static final class C08431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08431(Continuation<? super C08431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TokenRefreshManager.this.reset(this);
        }
    }

    private TokenRefreshManager() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(2:4|(1:6)(1:7))(0)|8|124|(1:(1:(1:(15:13|129|74|(1:76)(1:77)|78|(1:95)(3:82|(5:127|84|85|122|86)(1:93)|94)|96|97|98|(1:102)(1:101)|(1:106)|107|(1:109)(1:110)|111|112)(2:14|15))(14:16|131|17|18|126|59|60|98|(1:102)(0)|(2:104|106)|107|(0)(0)|111|112))(1:23))(2:24|(2:120|121)(2:29|(2:31|32)(2:33|(1:35)(1:36))))|133|37|(1:39)(2:42|(10:47|(1:49)(1:51)|50|41|53|134|54|136|55|(1:57)(11:58|126|59|60|98|(0)(0)|(0)|107|(0)(0)|111|112))(1:46))|40|41|53|134|54|136|55|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0209, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020a, code lost:
    
        r3 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x021a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x021b, code lost:
    
        r4 = 0;
        r3 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02af A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x029e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshTokenIfNeeded(java.lang.String r25, kotlin.jvm.functions.Function0<java.lang.String> r26, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r27, kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._network.TokenRefreshManager.refreshTokenIfNeeded(java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void shutdown() {
        CoroutineScopeKt.cancel$default(refreshScope, null, 1, null);
        Timber.INSTANCE.d("🛑 TokenRefreshManager shutdown", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reset(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.soletreadmills.sole_v2._network.TokenRefreshManager.C08431
            if (r0 == 0) goto L14
            r0 = r6
            com.soletreadmills.sole_v2._network.TokenRefreshManager$reset$1 r0 = (com.soletreadmills.sole_v2._network.TokenRefreshManager.C08431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.soletreadmills.sole_v2._network.TokenRefreshManager$reset$1 r0 = new com.soletreadmills.sole_v2._network.TokenRefreshManager$reset$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = com.soletreadmills.sole_v2._network.TokenRefreshManager.refreshLock
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L47
            return r1
        L47:
            r0 = r6
        L48:
            kotlinx.coroutines.Deferred<java.lang.Boolean> r6 = com.soletreadmills.sole_v2._network.TokenRefreshManager.refreshJob     // Catch: java.lang.Throwable -> L69
            if (r6 == 0) goto L51
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch: java.lang.Throwable -> L69
            kotlinx.coroutines.Job.DefaultImpls.cancel$default(r6, r4, r3, r4)     // Catch: java.lang.Throwable -> L69
        L51:
            com.soletreadmills.sole_v2._network.TokenRefreshManager.refreshJob = r4     // Catch: java.lang.Throwable -> L69
            r1 = 0
            com.soletreadmills.sole_v2._network.TokenRefreshManager.lastRefreshFailTime = r1     // Catch: java.lang.Throwable -> L69
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L69
            r0.unlock(r4)
            timber.log.Timber$Forest r6 = timber.log.Timber.INSTANCE
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "🔄 TokenRefreshManager reset"
            r6.d(r1, r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L69:
            r6 = move-exception
            r0.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._network.TokenRefreshManager.reset(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
