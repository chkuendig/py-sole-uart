package com.soletreadmills.sole_v2.ui.activity;

import com.soletreadmills.sole_v2._type.HistoryActivityType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ActivityMainFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$loadAllSections$1$1$1", f = "ActivityMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ActivityMainFragment$loadAllSections$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoryActivityType $historyActivityType;
    int label;
    final /* synthetic */ ActivityMainFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityMainFragment$loadAllSections$1$1$1(ActivityMainFragment activityMainFragment, HistoryActivityType historyActivityType, Continuation<? super ActivityMainFragment$loadAllSections$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = activityMainFragment;
        this.$historyActivityType = historyActivityType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityMainFragment$loadAllSections$1$1$1(this.this$0, this.$historyActivityType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ActivityMainFragment$loadAllSections$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.getMyLatest3MonthWorkoutStatsApiData(this.$historyActivityType);
        return Unit.INSTANCE;
    }
}
