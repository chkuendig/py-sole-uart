package com.soletreadmills.sole_v2.ui.classes;

import com.digifly.ble.data.YogaWorkoutData;
import com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase;
import com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataEntity;
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
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: VideoModeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onResponse$1", f = "VideoModeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class VideoModeViewModel$uploadWorkoutData$1$onResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $entityId;
    final /* synthetic */ boolean $isFromSqlite;
    final /* synthetic */ Response<UploadWorkoutApiData.ResponseData> $response;
    final /* synthetic */ SummaryTempDataDatabase $summaryTempDataDatabase;
    final /* synthetic */ List<YogaWorkoutData> $yogaWorkoutDataList;
    int label;
    final /* synthetic */ VideoModeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoModeViewModel$uploadWorkoutData$1$onResponse$1(Response<UploadWorkoutApiData.ResponseData> response, VideoModeViewModel videoModeViewModel, boolean z, Integer num, List<YogaWorkoutData> list, SummaryTempDataDatabase summaryTempDataDatabase, Continuation<? super VideoModeViewModel$uploadWorkoutData$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$response = response;
        this.this$0 = videoModeViewModel;
        this.$isFromSqlite = z;
        this.$entityId = num;
        this.$yogaWorkoutDataList = list;
        this.$summaryTempDataDatabase = summaryTempDataDatabase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoModeViewModel$uploadWorkoutData$1$onResponse$1(this.$response, this.this$0, this.$isFromSqlite, this.$entityId, this.$yogaWorkoutDataList, this.$summaryTempDataDatabase, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoModeViewModel$uploadWorkoutData$1$onResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            if (r0 != 0) goto L90
            kotlin.ResultKt.throwOnFailure(r7)
            retrofit2.Response<com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData$ResponseData> r7 = r6.$response
            java.lang.Object r7 = r7.body()
            if (r7 == 0) goto L80
            retrofit2.Response<com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData$ResponseData> r7 = r6.$response
            java.lang.Object r7 = r7.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData$ResponseData r7 = (com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData.ResponseData) r7
            boolean r7 = r7.getSuccess()
            if (r7 == 0) goto L80
            retrofit2.Response<com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData$ResponseData> r7 = r6.$response
            java.lang.Object r7 = r7.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData$ResponseData r7 = (com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData.ResponseData) r7
            com.soletreadmills.sole_v2._data.api.club.UploadWorkoutApiData$DataMap r7 = r7.getDataMap()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.String r7 = r7.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L45
            goto L80
        L45:
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r7 = r6.this$0
            android.content.Context r7 = com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.access$getContext$p(r7)
            int r0 = com.soletreadmills.sole_v2.R.string.saved_one_workout_record
            r1 = 0
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r0, r1)
            r7.show()
            boolean r7 = r6.$isFromSqlite
            if (r7 == 0) goto L8d
            java.lang.Integer r7 = r6.$entityId
            if (r7 == 0) goto L8d
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r7 = r6.this$0
            androidx.lifecycle.ViewModel r7 = (androidx.lifecycle.ViewModel) r7
            kotlinx.coroutines.CoroutineScope r0 = androidx.lifecycle.ViewModelKt.getViewModelScope(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            r1 = r7
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onResponse$1$1 r7 = new com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onResponse$1$1
            com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase r2 = r6.$summaryTempDataDatabase
            java.lang.Integer r3 = r6.$entityId
            r4 = 0
            r7.<init>(r2, r3, r4)
            r3 = r7
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            r2 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
            goto L8d
        L80:
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r7 = r6.this$0
            java.util.List<com.digifly.ble.data.YogaWorkoutData> r0 = r6.$yogaWorkoutDataList
            boolean r1 = r6.$isFromSqlite
            java.lang.Integer r2 = r6.$entityId
            com.soletreadmills.sole_v2._roomDataBase.summaryTempData.SummaryTempDataDatabase r3 = r6.$summaryTempDataDatabase
            com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel.access$saveFailedWorkoutData(r7, r0, r1, r2, r3)
        L8d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L90:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: VideoModeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onResponse$1$1", f = "VideoModeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel$uploadWorkoutData$1$onResponse$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $entityId;
        final /* synthetic */ SummaryTempDataDatabase $summaryTempDataDatabase;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SummaryTempDataDatabase summaryTempDataDatabase, Integer num, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$summaryTempDataDatabase = summaryTempDataDatabase;
            this.$entityId = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$summaryTempDataDatabase, this.$entityId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SummaryTempDataEntity summaryTempDataEntityFindById;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                summaryTempDataEntityFindById = this.$summaryTempDataDatabase.summaryTempDataDao().findById(this.$entityId.intValue());
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                summaryTempDataEntityFindById = null;
            }
            if (summaryTempDataEntityFindById != null) {
                try {
                    this.$summaryTempDataDatabase.summaryTempDataDao().delete(summaryTempDataEntityFindById);
                } catch (Exception e2) {
                    Timber.INSTANCE.e(e2);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
