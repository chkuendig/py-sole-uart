package com.soletreadmills.sole_v2._network.Interceptor;

import com.soletreadmills.sole_v2._network.TokenRefreshManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TokenAutoRefreshInterceptor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptor$intercept$refreshSuccess$1", f = "TokenAutoRefreshInterceptor.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class TokenAutoRefreshInterceptor$intercept$refreshSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $oldToken;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TokenAutoRefreshInterceptor$intercept$refreshSuccess$1(String str, Continuation<? super TokenAutoRefreshInterceptor$intercept$refreshSuccess$1> continuation) {
        super(2, continuation);
        this.$oldToken = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TokenAutoRefreshInterceptor$intercept$refreshSuccess$1(this.$oldToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((TokenAutoRefreshInterceptor$intercept$refreshSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = TokenRefreshManager.INSTANCE.refreshTokenIfNeeded(this.$oldToken, new Function0<String>() { // from class: com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptor$intercept$refreshSuccess$1.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return MySharedPreferences.INSTANCE.getInstance().getSharedLoginToken();
                }
            }, new AnonymousClass2(null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    /* compiled from: TokenAutoRefreshInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptor$intercept$refreshSuccess$1$2", f = "TokenAutoRefreshInterceptor.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptor$intercept$refreshSuccess$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TokenAutoRefreshInterceptorKt.loginByTokenAgain(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }
}
