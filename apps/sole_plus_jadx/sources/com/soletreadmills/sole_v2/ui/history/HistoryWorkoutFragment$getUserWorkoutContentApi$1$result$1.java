package com.soletreadmills.sole_v2.ui.history;

import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.api.history.GetUserWorkoutContentApiData;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

/* compiled from: HistoryWorkoutFragment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1", f = "HistoryWorkoutFragment.kt", i = {}, l = {812}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends WorkoutViewVo, ? extends String>>, Object> {
    int label;
    final /* synthetic */ HistoryWorkoutFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1(HistoryWorkoutFragment historyWorkoutFragment, Continuation<? super HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = historyWorkoutFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends WorkoutViewVo, ? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<WorkoutViewVo, String>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<WorkoutViewVo, String>> continuation) {
        return ((HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetUserWorkoutContentApiData.DataMap dataMap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = DyacoApiKt.callGetUserWorkoutContentApiData(new GetUserWorkoutContentApiData.RequestBodyData(this.this$0.getWorkoutUuid(), Boxing.boxBoolean(true)), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GetUserWorkoutContentApiData.ResponseData responseData = (GetUserWorkoutContentApiData.ResponseData) ((Response) obj).body();
        return new Pair((responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData(), responseData != null ? responseData.getErrorCode() : null);
    }
}
