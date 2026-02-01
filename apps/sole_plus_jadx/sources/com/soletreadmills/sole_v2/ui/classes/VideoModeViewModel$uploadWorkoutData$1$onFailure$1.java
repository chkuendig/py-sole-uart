package com.soletreadmills.sole_v2.ui.classes;

import android.widget.Toast;
import com.digifly.ble.data.YogaWorkoutData;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoModeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onFailure$1", f = "VideoModeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class VideoModeViewModel$uploadWorkoutData$1$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $entityId;
    final /* synthetic */ boolean $isFromSqlite;
    final /* synthetic */ SummaryTempDataDatabase $summaryTempDataDatabase;
    final /* synthetic */ List<YogaWorkoutData> $yogaWorkoutDataList;
    int label;
    final /* synthetic */ VideoModeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoModeViewModel$uploadWorkoutData$1$onFailure$1(VideoModeViewModel videoModeViewModel, List<YogaWorkoutData> list, boolean z, Integer num, SummaryTempDataDatabase summaryTempDataDatabase, Continuation<? super VideoModeViewModel$uploadWorkoutData$1$onFailure$1> continuation) {
        super(2, continuation);
        this.this$0 = videoModeViewModel;
        this.$yogaWorkoutDataList = list;
        this.$isFromSqlite = z;
        this.$entityId = num;
        this.$summaryTempDataDatabase = summaryTempDataDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoModeViewModel$uploadWorkoutData$1$onFailure$1(this.this$0, this.$yogaWorkoutDataList, this.$isFromSqlite, this.$entityId, this.$summaryTempDataDatabase, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoModeViewModel$uploadWorkoutData$1$onFailure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Toast.makeText(this.this$0.context, R.string.uploading_workout_data_failed, 0).show();
        this.this$0.saveFailedWorkoutData(this.$yogaWorkoutDataList, this.$isFromSqlite, this.$entityId, this.$summaryTempDataDatabase);
        return Unit.INSTANCE;
    }
}
