package com.soletreadmills.sole_v2._network;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import timber.log.Timber;

/* compiled from: TokenRefreshManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2._network.TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2", f = "TokenRefreshManager.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Continuation<? super Boolean>, Object> $refreshAction;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2(Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2> continuation) {
        super(2, continuation);
        this.$refreshAction = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2(this.$refreshAction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean zBooleanValue = false;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = TimeoutKt.withTimeout(15000L, new AnonymousClass1(this.$refreshAction, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            zBooleanValue = ((Boolean) obj).booleanValue();
        } catch (TimeoutCancellationException e) {
            Timber.INSTANCE.e(e, "⏱️ Refresh action timeout", new Object[0]);
        } catch (CancellationException e2) {
            throw e2;
        } catch (Exception e3) {
            Timber.INSTANCE.e(e3, "❌ Refresh action failed", new Object[0]);
        }
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* compiled from: TokenRefreshManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._network.TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2$1", f = "TokenRefreshManager.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._network.TokenRefreshManager$refreshTokenIfNeeded$jobToAwait$1$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<Continuation<? super Boolean>, Object> $refreshAction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$refreshAction = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$refreshAction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Boolean>, Object> function1 = this.$refreshAction;
                this.label = 1;
                obj = function1.invoke(this);
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
