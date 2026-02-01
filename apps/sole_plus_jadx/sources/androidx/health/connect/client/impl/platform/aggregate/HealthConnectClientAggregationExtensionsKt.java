package androidx.health.connect.client.impl.platform.aggregate;

import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.impl.converters.datatype.RecordsTypeNameMapKt;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: HealthConnectClientAggregationExtensions.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\b\u0010\b\u001a\u00020\tH\u0000\u001aR\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u000b*\u00020\u0003*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00022\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00012\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u00020\t*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0080@¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001aL\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u001e0\u001d\"\b\b\u0000\u0010\u000b*\u00020\u0003*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00022\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001H\u0086@¢\u0006\u0002\u0010\u001f\u001a\f\u0010 \u001a\u00020\u0011*\u00020\u0011H\u0000\"\u001c\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"AGGREGATION_FALLBACK_RECORD_TYPES", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "RECORD_START_TIME_BUFFER", "Ljava/time/Duration;", "getRECORD_START_TIME_BUFFER", "()Ljava/time/Duration;", "emptyAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "aggregate", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/health/connect/client/HealthConnectClient;", "recordType", "metrics", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "(Landroidx/health/connect/client/HealthConnectClient;Lkotlin/reflect/KClass;Ljava/util/Set;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateFallback", "request", "Landroidx/health/connect/client/request/AggregateRequest;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "overlaps", "", "Landroidx/health/connect/client/records/IntervalRecord;", "readRecordsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "(Landroidx/health/connect/client/HealthConnectClient;Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withBufferedStart", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthConnectClientAggregationExtensionsKt {
    private static final Set<KClass<? extends Record>> AGGREGATION_FALLBACK_RECORD_TYPES;
    private static final Duration RECORD_START_TIME_BUFFER;

    /* compiled from: HealthConnectClientAggregationExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt", f = "HealthConnectClientAggregationExtensions.kt", i = {0, 0}, l = {63}, m = "aggregateFallback", n = {"$this$aggregateFallback", "request"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HealthConnectClientAggregationExtensionsKt.aggregateFallback(null, null, this);
        }
    }

    static {
        Duration durationOfDays = Duration.ofDays(1L);
        Intrinsics.checkNotNullExpressionValue(durationOfDays, "ofDays(1)");
        RECORD_START_TIME_BUFFER = durationOfDays;
        AGGREGATION_FALLBACK_RECORD_TYPES = SetsKt.setOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), Reflection.getOrCreateKotlinClass(NutritionRecord.class), Reflection.getOrCreateKotlinClass(SpeedRecord.class), Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class)});
    }

    public static final Duration getRECORD_START_TIME_BUFFER() {
        return RECORD_START_TIME_BUFFER;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0082 -> B:21:0x0086). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object aggregateFallback(androidx.health.connect.client.HealthConnectClient r11, androidx.health.connect.client.request.AggregateRequest r12, kotlin.coroutines.Continuation<? super androidx.health.connect.client.aggregate.AggregationResult> r13) {
        /*
            boolean r0 = r13 instanceof androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$1 r0 = (androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$1 r0 = new androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$aggregateFallback$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r11 = r0.L$3
            androidx.health.connect.client.aggregate.AggregationResult r11 = (androidx.health.connect.client.aggregate.AggregationResult) r11
            java.lang.Object r12 = r0.L$2
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.L$1
            androidx.health.connect.client.request.AggregateRequest r2 = (androidx.health.connect.client.request.AggregateRequest) r2
            java.lang.Object r4 = r0.L$0
            androidx.health.connect.client.HealthConnectClient r4 = (androidx.health.connect.client.HealthConnectClient) r4
            kotlin.ResultKt.throwOnFailure(r13)
            r10 = r4
            r4 = r12
            r12 = r10
            goto L86
        L3d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L45:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.health.connect.client.aggregate.AggregationResult r13 = emptyAggregationResult()
            java.util.Set<kotlin.reflect.KClass<? extends androidx.health.connect.client.records.Record>> r2 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.AGGREGATION_FALLBACK_RECORD_TYPES
            java.util.Iterator r2 = r2.iterator()
            r10 = r12
            r12 = r11
            r11 = r13
            r13 = r10
        L56:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L8f
            java.lang.Object r4 = r2.next()
            r5 = r4
            kotlin.reflect.KClass r5 = (kotlin.reflect.KClass) r5
            java.util.Set r6 = androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt.getFallbackMetrics(r13)
            androidx.health.connect.client.time.TimeRangeFilter r7 = r13.getTimeRangeFilter()
            java.util.Set r8 = r13.getDataOriginFilter$connect_client_release()
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r2
            r0.L$3 = r11
            r0.label = r3
            r4 = r12
            r9 = r0
            java.lang.Object r4 = aggregate(r4, r5, r6, r7, r8, r9)
            if (r4 != r1) goto L82
            return r1
        L82:
            r10 = r2
            r2 = r13
            r13 = r4
            r4 = r10
        L86:
            androidx.health.connect.client.aggregate.AggregationResult r13 = (androidx.health.connect.client.aggregate.AggregationResult) r13
            androidx.health.connect.client.aggregate.AggregationResult r11 = androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt.plus(r11, r13)
            r13 = r2
            r2 = r4
            goto L56
        L8f:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.aggregateFallback(androidx.health.connect.client.HealthConnectClient, androidx.health.connect.client.request.AggregateRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Record> Object aggregate(HealthConnectClient healthConnectClient, KClass<T> kClass, Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set2, Continuation<? super AggregationResult> continuation) {
        String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(kClass);
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (Intrinsics.areEqual(((AggregateMetric) obj).getDataTypeName(), str)) {
                arrayList.add(obj);
            }
        }
        Set set3 = CollectionsKt.toSet(arrayList);
        if (set3.isEmpty()) {
            return emptyAggregationResult();
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BloodPressureRecord.class))) {
            return BloodPressureAggregationExtensionsKt.aggregateBloodPressure(healthConnectClient, (Set<? extends AggregateMetric<?>>) set3, timeRangeFilter, set2, continuation);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class))) {
            return SeriesRecordAggregationExtensionsKt.aggregateCyclingPedalingCadence(healthConnectClient, set3, timeRangeFilter, set2, continuation);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(NutritionRecord.class))) {
            return NutritionAggregationExtensionsKt.aggregateNutritionTransFatTotal(healthConnectClient, timeRangeFilter, set2, continuation);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(SpeedRecord.class))) {
            return SeriesRecordAggregationExtensionsKt.aggregateSpeed(healthConnectClient, set3, timeRangeFilter, set2, continuation);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class))) {
            return SeriesRecordAggregationExtensionsKt.aggregateStepsCadence(healthConnectClient, set3, timeRangeFilter, set2, continuation);
        }
        throw new IllegalStateException(("Invalid record type for aggregation fallback: " + kClass).toString());
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: HealthConnectClientAggregationExtensions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/health/connect/client/records/Record;", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$readRecordsFlow$2", f = "HealthConnectClientAggregationExtensions.kt", i = {0, 1, 1}, l = {110, 118}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "response"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt$readRecordsFlow$2, reason: invalid class name */
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<FlowCollector<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<DataOrigin> $dataOriginFilter;
        final /* synthetic */ KClass<T> $recordType;
        final /* synthetic */ HealthConnectClient $this_readRecordsFlow;
        final /* synthetic */ TimeRangeFilter $timeRangeFilter;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HealthConnectClient healthConnectClient, KClass<T> kClass, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_readRecordsFlow = healthConnectClient;
            this.$recordType = kClass;
            this.$timeRangeFilter = timeRangeFilter;
            this.$dataOriginFilter = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_readRecordsFlow, this.$recordType, this.$timeRangeFilter, this.$dataOriginFilter, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super List<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0075 -> B:18:0x0078). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L31
                if (r2 == r5) goto L26
                if (r2 != r4) goto L1e
                java.lang.Object r2 = r0.L$1
                androidx.health.connect.client.response.ReadRecordsResponse r2 = (androidx.health.connect.client.response.ReadRecordsResponse) r2
                java.lang.Object r6 = r0.L$0
                kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                kotlin.ResultKt.throwOnFailure(r18)
                r8 = r4
                goto L78
            L1e:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L26:
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.throwOnFailure(r18)
                r4 = r18
            L2f:
                r6 = r2
                goto L60
            L31:
                kotlin.ResultKt.throwOnFailure(r18)
                java.lang.Object r2 = r0.L$0
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                r12 = r3
            L39:
                androidx.health.connect.client.HealthConnectClient r15 = r0.$this_readRecordsFlow
                androidx.health.connect.client.request.ReadRecordsRequest r14 = new androidx.health.connect.client.request.ReadRecordsRequest
                kotlin.reflect.KClass<T> r7 = r0.$recordType
                androidx.health.connect.client.time.TimeRangeFilter r8 = r0.$timeRangeFilter
                java.util.Set<androidx.health.connect.client.records.metadata.DataOrigin> r9 = r0.$dataOriginFilter
                r13 = 24
                r16 = 0
                r10 = 0
                r11 = 0
                r6 = r14
                r4 = r14
                r14 = r16
                r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r0.L$0 = r2
                r0.L$1 = r3
                r0.label = r5
                java.lang.Object r4 = r15.readRecords(r4, r6)
                if (r4 != r1) goto L2f
                return r1
            L60:
                r2 = r4
                androidx.health.connect.client.response.ReadRecordsResponse r2 = (androidx.health.connect.client.response.ReadRecordsResponse) r2
                java.util.List r4 = r2.getRecords()
                r7 = r0
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r0.L$0 = r6
                r0.L$1 = r2
                r8 = 2
                r0.label = r8
                java.lang.Object r4 = r6.emit(r4, r7)
                if (r4 != r1) goto L78
                return r1
            L78:
                java.lang.String r12 = r2.getPageToken()
                if (r12 != 0) goto L81
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L81:
                r2 = r6
                r4 = r8
                goto L39
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T extends Record> Object readRecordsFlow(HealthConnectClient healthConnectClient, KClass<T> kClass, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set, Continuation<? super Flow<? extends List<? extends T>>> continuation) {
        return FlowKt.flow(new AnonymousClass2(healthConnectClient, kClass, timeRangeFilter, set, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[PHI: r0
      0x004f: PHI (r0v11 boolean) = (r0v5 boolean), (r0v14 boolean) binds: [B:28:0x007d, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[PHI: r0
      0x0051: PHI (r0v9 boolean) = (r0v5 boolean), (r0v5 boolean), (r0v14 boolean), (r0v14 boolean) binds: [B:26:0x006f, B:28:0x007d, B:12:0x0036, B:14:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean overlaps(androidx.health.connect.client.records.IntervalRecord r5, androidx.health.connect.client.time.TimeRangeFilter r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "timeRangeFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = androidx.health.connect.client.impl.platform.TimeExtensionsKt.useLocalTime(r6)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L53
            java.time.LocalDateTime r0 = r6.getLocalEndTime()
            if (r0 == 0) goto L31
            java.time.Instant r0 = r5.getStartTime()
            java.time.LocalDateTime r3 = r6.getLocalEndTime()
            java.time.ZoneOffset r4 = r5.getStartZoneOffset()
            java.time.Instant r3 = androidx.health.connect.client.impl.platform.TimeExtensionsKt.toInstantWithDefaultZoneFallback(r3, r4)
            boolean r0 = r0.isBefore(r3)
            if (r0 == 0) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L32
        L31:
            r0 = r2
        L32:
            java.time.LocalDateTime r3 = r6.getLocalStartTime()
            if (r3 == 0) goto L51
            java.time.Instant r3 = r5.getEndTime()
            java.time.LocalDateTime r6 = r6.getLocalStartTime()
            java.time.ZoneOffset r5 = r5.getEndZoneOffset()
            java.time.Instant r5 = androidx.health.connect.client.impl.platform.TimeExtensionsKt.toInstantWithDefaultZoneFallback(r6, r5)
            boolean r5 = r3.isAfter(r5)
            if (r5 == 0) goto L4f
            goto L51
        L4f:
            r5 = r1
            goto L80
        L51:
            r5 = r2
            goto L80
        L53:
            java.time.Instant r0 = r6.getEndTime()
            if (r0 == 0) goto L6a
            java.time.Instant r0 = r5.getStartTime()
            java.time.Instant r3 = r6.getEndTime()
            boolean r0 = r0.isBefore(r3)
            if (r0 == 0) goto L68
            goto L6a
        L68:
            r0 = r1
            goto L6b
        L6a:
            r0 = r2
        L6b:
            java.time.Instant r3 = r6.getStartTime()
            if (r3 == 0) goto L51
            java.time.Instant r5 = r5.getEndTime()
            java.time.Instant r6 = r6.getStartTime()
            boolean r5 = r5.isAfter(r6)
            if (r5 == 0) goto L4f
            goto L51
        L80:
            if (r0 == 0) goto L85
            if (r5 == 0) goto L85
            r1 = r2
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.overlaps(androidx.health.connect.client.records.IntervalRecord, androidx.health.connect.client.time.TimeRangeFilter):boolean");
    }

    public static final TimeRangeFilter withBufferedStart(TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "<this>");
        Instant startTime = timeRangeFilter.getStartTime();
        Instant instantMinus = startTime != null ? startTime.minus((TemporalAmount) RECORD_START_TIME_BUFFER) : null;
        Instant endTime = timeRangeFilter.getEndTime();
        LocalDateTime localStartTime = timeRangeFilter.getLocalStartTime();
        return new TimeRangeFilter(instantMinus, endTime, localStartTime != null ? localStartTime.minus((TemporalAmount) RECORD_START_TIME_BUFFER) : null, timeRangeFilter.getLocalEndTime());
    }

    public static final AggregationResult emptyAggregationResult() {
        return new AggregationResult(MapsKt.emptyMap(), MapsKt.emptyMap(), SetsKt.emptySet());
    }
}
