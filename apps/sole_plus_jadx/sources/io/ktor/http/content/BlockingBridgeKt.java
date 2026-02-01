package io.ktor.http.content;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BlockingBridge.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0002\u001a/\u0010\u0007\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u00020\b2\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\r\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"isParkingAllowedFunction", "Ljava/lang/reflect/Method;", "()Ljava/lang/reflect/Method;", "isParkingAllowedFunction$delegate", "Lkotlin/Lazy;", "safeToRunInPlace", "", "withBlocking", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withBlockingAndRedispatch", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BlockingBridgeKt {
    private static final Lazy isParkingAllowedFunction$delegate = LazyKt.lazy(new Function0<Method>() { // from class: io.ktor.http.content.BlockingBridgeKt.isParkingAllowedFunction.2
        @Override // kotlin.jvm.functions.Function0
        public final Method invoke() {
            try {
                return Class.forName("io.ktor.utils.io.jvm.javaio.PollersKt").getMethod("isParkingAllowed", new Class[0]);
            } catch (Throwable unused) {
                return null;
            }
        }
    });

    private static final Method isParkingAllowedFunction() {
        return (Method) isParkingAllowedFunction$delegate.getValue();
    }

    public static final Object withBlocking(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) throws Throwable {
        if (safeToRunInPlace()) {
            Object objInvoke = function1.invoke(continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        Object objWithBlockingAndRedispatch = withBlockingAndRedispatch(function1, continuation);
        return objWithBlockingAndRedispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithBlockingAndRedispatch : Unit.INSTANCE;
    }

    private static final boolean safeToRunInPlace() {
        boolean zAreEqual;
        Method methodIsParkingAllowedFunction = isParkingAllowedFunction();
        if (methodIsParkingAllowedFunction == null) {
            return false;
        }
        try {
            zAreEqual = Intrinsics.areEqual(methodIsParkingAllowedFunction.invoke(null, new Object[0]), (Object) true);
        } catch (Throwable unused) {
            zAreEqual = false;
        }
        return zAreEqual;
    }

    /* compiled from: BlockingBridge.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.content.BlockingBridgeKt$withBlockingAndRedispatch$2", f = "BlockingBridge.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.http.content.BlockingBridgeKt$withBlockingAndRedispatch$2, reason: invalid class name and case insensitive filesystem */
    static final class C11582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C11582(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super C11582> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C11582(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object withBlockingAndRedispatch(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) throws Throwable {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C11582(function1, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
