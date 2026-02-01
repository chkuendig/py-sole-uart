package com.soletreadmills.sole_v2._manager;

import android.content.Context;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.camera.video.AudioStats;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.PermissionController;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.response.InsertRecordsResponse;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Length;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.api.history.HistoryListData;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.CalendarTool;
import com.soletreadmills.sole_v2._type.CategoryType;
import com.sun.jna.platform.win32.WinError;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.future.FutureKt;
import timber.log.Timber;

/* compiled from: HealthDataManager.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0082@¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001e\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u000eJ\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J*\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0013¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/HealthDataManager;", "", "()V", "hasAllPermissions", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "permissions", "", "", "(Landroid/content/Context;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasAllPermissionsAsync", "Ljava/util/concurrent/CompletableFuture;", "requestPermissionsActivityContract", "Landroidx/activity/result/contract/ActivityResultContract;", "", "writeData", "", "historyData", "", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "writeHealthData", "records", "Landroidx/health/connect/client/records/Record;", "trainNoList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HealthDataManager {
    public static final int $stable = 0;

    /* compiled from: HealthDataManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CategoryType.values().length];
            try {
                iArr[CategoryType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CategoryType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CategoryType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CategoryType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CategoryType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: HealthDataManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.HealthDataManager", f = "HealthDataManager.kt", i = {0}, l = {246}, m = "hasAllPermissions", n = {"permissions"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2._manager.HealthDataManager$hasAllPermissions$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthDataManager.this.hasAllPermissions(null, null, this);
        }
    }

    public final void writeHealthData(Context context, List<Record> records, List<String> trainNoList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(records, "records");
        Intrinsics.checkNotNullParameter(trainNoList, "trainNoList");
        try {
            if (HealthConnectClient.Companion.getSdkStatus$default(HealthConnectClient.INSTANCE, context, null, 2, null) == 3) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C08381(trainNoList, HealthConnectClient.Companion.getOrCreate$default(HealthConnectClient.INSTANCE, context, null, 2, null), records, null), 3, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* compiled from: HealthDataManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.HealthDataManager$writeHealthData$1", f = "HealthDataManager.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.HealthDataManager$writeHealthData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HealthConnectClient $healthConnectClient;
        final /* synthetic */ List<Record> $records;
        final /* synthetic */ List<String> $trainNoList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08381(List<String> list, HealthConnectClient healthConnectClient, List<Record> list2, Continuation<? super C08381> continuation) {
            super(2, continuation);
            this.$trainNoList = list;
            this.$healthConnectClient = healthConnectClient;
            this.$records = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08381(this.$trainNoList, this.$healthConnectClient, this.$records, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getIO(), new C02061(this.$healthConnectClient, this.$records, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                System.out.println((Object) "健康數據寫入成功！");
                Iterator<String> it = this.$trainNoList.iterator();
                while (it.hasNext()) {
                    MySharedPreferences.INSTANCE.getInstance().saveHistoryUpdateToHealthConnect(it.next(), true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println((Object) ("健康數據寫入失敗：" + e.getMessage()));
            }
            return Unit.INSTANCE;
        }

        /* compiled from: HealthDataManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.HealthDataManager$writeHealthData$1$1", f = "HealthDataManager.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2._manager.HealthDataManager$writeHealthData$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InsertRecordsResponse>, Object> {
            final /* synthetic */ HealthConnectClient $healthConnectClient;
            final /* synthetic */ List<Record> $records;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02061(HealthConnectClient healthConnectClient, List<Record> list, Continuation<? super C02061> continuation) {
                super(2, continuation);
                this.$healthConnectClient = healthConnectClient;
                this.$records = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02061(this.$healthConnectClient, this.$records, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InsertRecordsResponse> continuation) {
                return ((C02061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = this.$healthConnectClient.insertRecords(this.$records, this);
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

    public final void writeData(Context context, List<HistoryListData> historyData) {
        WorkoutViewVo workoutData;
        Iterator<HistoryListData> it;
        String userWorkoutUuid;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(historyData, "historyData");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<HistoryListData> it2 = historyData.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            HistoryListData next = it2.next();
            if (!next.isHeader() && (workoutData = next.getWorkoutData()) != null) {
                try {
                    userWorkoutUuid = workoutData.getUserWorkoutUuid();
                } catch (Exception e) {
                    e = e;
                    it = it2;
                    e.printStackTrace();
                    it2 = it;
                }
                if (userWorkoutUuid != null && !MySharedPreferences.INSTANCE.getInstance().getHistoryUpdateToHealthConnect(userWorkoutUuid)) {
                    int iIntValue = -1;
                    try {
                        Integer totalTime = workoutData.getTotalTime();
                        if (totalTime != null) {
                            iIntValue = totalTime.intValue();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (iIntValue >= 0) {
                        Date dateTransformStrToDate = null;
                        try {
                            String startTime = workoutData.getStartTime();
                            if (startTime != null) {
                                dateTransformStrToDate = CalendarTool.transformStrToDate(startTime);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (dateTransformStrToDate != null) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(dateTransformStrToDate);
                            long timeInMillis = calendar.getTimeInMillis();
                            calendar.add(13, -iIntValue);
                            long timeInMillis2 = calendar.getTimeInMillis();
                            if (timeInMillis2 < timeInMillis) {
                                Instant instantOfEpochMilli = Instant.ofEpochMilli(timeInMillis2);
                                Instant instantOfEpochMilli2 = Instant.ofEpochMilli(timeInMillis);
                                ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 1000);
                                int i = WhenMappings.$EnumSwitchMapping$0[workoutData.getMachineCategoryType().ordinal()];
                                if (i == 1) {
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    arrayList.add(new ExerciseSessionRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, 57, (String) null, (String) null, (androidx.health.connect.client.records.metadata.Metadata) null, (List) null, (List) null, (ExerciseRoute) null, WinError.ERROR_PROFILE_NOT_FOUND, (DefaultConstructorMarker) null));
                                } else if (i == 2) {
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    arrayList.add(new ExerciseSessionRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, 9, (String) null, (String) null, (androidx.health.connect.client.records.metadata.Metadata) null, (List) null, (List) null, (ExerciseRoute) null, WinError.ERROR_PROFILE_NOT_FOUND, (DefaultConstructorMarker) null));
                                } else if (i == 3) {
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    arrayList.add(new ExerciseSessionRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, 25, (String) null, (String) null, (androidx.health.connect.client.records.metadata.Metadata) null, (List) null, (List) null, (ExerciseRoute) null, WinError.ERROR_PROFILE_NOT_FOUND, (DefaultConstructorMarker) null));
                                } else if (i == 4) {
                                    Integer totalSteps = workoutData.getTotalSteps();
                                    int iIntValue2 = totalSteps != null ? totalSteps.intValue() : 0;
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    arrayList.add(new StepsRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, iIntValue2, null, 32, null));
                                } else if (i == 5) {
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    arrayList.add(new ExerciseSessionRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, 54, (String) null, (String) null, (androidx.health.connect.client.records.metadata.Metadata) null, (List) null, (List) null, (ExerciseRoute) null, WinError.ERROR_PROFILE_NOT_FOUND, (DefaultConstructorMarker) null));
                                }
                                Integer totalCalories = workoutData.getTotalCalories();
                                int iIntValue3 = totalCalories != null ? totalCalories.intValue() : 0;
                                if (iIntValue3 > 0) {
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    it = it2;
                                    try {
                                        arrayList.add(new TotalCaloriesBurnedRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, Energy.INSTANCE.calories(iIntValue3 * 1000), null, 32, null));
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        it2 = it;
                                    }
                                } else {
                                    it = it2;
                                }
                                Double totalDistance = workoutData.getTotalDistance();
                                double dDoubleValue = totalDistance != null ? totalDistance.doubleValue() : 0.0d;
                                if (dDoubleValue > AudioStats.AUDIO_AMPLITUDE_NONE) {
                                    Intrinsics.checkNotNull(instantOfEpochMilli);
                                    Intrinsics.checkNotNull(instantOfEpochMilli2);
                                    arrayList.add(new DistanceRecord(instantOfEpochMilli, zoneOffsetOfTotalSeconds, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, Length.INSTANCE.kilometers(dDoubleValue), null, 32, null));
                                }
                                arrayList2.add(userWorkoutUuid);
                                it2 = it;
                            }
                        }
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            new HealthDataManager().writeHealthData(context, arrayList, arrayList2);
        } else {
            Timber.INSTANCE.d("沒有新的健康數據，跳過寫入", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object hasAllPermissions(android.content.Context r6, java.util.Set<java.lang.String> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.soletreadmills.sole_v2._manager.HealthDataManager.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.soletreadmills.sole_v2._manager.HealthDataManager$hasAllPermissions$1 r0 = (com.soletreadmills.sole_v2._manager.HealthDataManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.soletreadmills.sole_v2._manager.HealthDataManager$hasAllPermissions$1 r0 = new com.soletreadmills.sole_v2._manager.HealthDataManager$hasAllPermissions$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$0
            r7 = r6
            java.util.Set r7 = (java.util.Set) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L51
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.health.connect.client.HealthConnectClient$Companion r8 = androidx.health.connect.client.HealthConnectClient.INSTANCE
            r2 = 2
            r4 = 0
            androidx.health.connect.client.HealthConnectClient r6 = androidx.health.connect.client.HealthConnectClient.Companion.getOrCreate$default(r8, r6, r4, r2, r4)
            androidx.health.connect.client.PermissionController r6 = r6.getPermissionController()
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r6.getGrantedPermissions(r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            java.util.Set r8 = (java.util.Set) r8
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r6 = r8.containsAll(r7)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.HealthDataManager.hasAllPermissions(android.content.Context, java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: HealthDataManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.HealthDataManager$hasAllPermissionsAsync$1", f = "HealthDataManager.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.HealthDataManager$hasAllPermissionsAsync$1, reason: invalid class name and case insensitive filesystem */
    static final class C08371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Set<String> $permissions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08371(Context context, Set<String> set, Continuation<? super C08371> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$permissions = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthDataManager.this.new C08371(this.$context, this.$permissions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C08371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = HealthDataManager.this.hasAllPermissions(this.$context, this.$permissions, this);
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

    public final CompletableFuture<Boolean> hasAllPermissionsAsync(Context context, Set<String> permissions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return FutureKt.future$default(GlobalScope.INSTANCE, null, null, new C08371(context, permissions, null), 3, null);
    }

    public final ActivityResultContract<Set<String>, Set<String>> requestPermissionsActivityContract() {
        return PermissionController.Companion.createRequestPermissionResultContract$default(PermissionController.INSTANCE, null, 1, null);
    }
}
