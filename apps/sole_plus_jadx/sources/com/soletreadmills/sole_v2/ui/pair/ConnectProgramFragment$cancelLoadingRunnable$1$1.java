package com.soletreadmills.sole_v2.ui.pair;

import android.content.Context;
import android.widget.Toast;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ConnectProgramFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.ConnectProgramFragment$cancelLoadingRunnable$1$1", f = "ConnectProgramFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ConnectProgramFragment$cancelLoadingRunnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectProgramFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConnectProgramFragment$cancelLoadingRunnable$1$1(ConnectProgramFragment connectProgramFragment, Continuation<? super ConnectProgramFragment$cancelLoadingRunnable$1$1> continuation) {
        super(2, continuation);
        this.this$0 = connectProgramFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectProgramFragment$cancelLoadingRunnable$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConnectProgramFragment$cancelLoadingRunnable$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Context context = this.this$0.getContext();
        if (context != null) {
            Toast.makeText(context, R.string.failed, 0).show();
        }
        return Unit.INSTANCE;
    }
}
