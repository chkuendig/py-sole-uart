package androidx.health.connect.client.impl.platform.aggregate;

import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\u0007\u001a\u00020\b*\u00020\t2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0080@¢\u0006\u0002\u0010\u0011\u001aq\u0010\u0012\u001a\u00020\b\"\f\b\u0000\u0010\u0013*\u0006\u0012\u0002\b\u00030\u0003*\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00022\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\u0002\b\u001cH\u0082@¢\u0006\u0002\u0010\u001d\u001au\u0010\u0012\u001a\u00020\b\"\f\b\u0000\u0010\u0013*\u0006\u0012\u0002\b\u00030\u0003*\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00022\u0010\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u001d\u0010\u0018\u001a\u0019\u0012\u0004\u0012\u0002H\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\u0002\b\u001cH\u0081@¢\u0006\u0002\u0010\u001f\u001a:\u0010 \u001a\u00020\b*\u00020\t2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0080@¢\u0006\u0002\u0010\u0011\u001a:\u0010!\u001a\u00020\b*\u00020\t2\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0080@¢\u0006\u0002\u0010\u0011\"4\u0010\u0000\u001a(\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"RECORDS_TO_AGGREGATE_METRICS_INFO_MAP", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/SeriesRecord;", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "aggregateCyclingPedalingCadence", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/HealthConnectClient;", "metrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "(Landroidx/health/connect/client/HealthConnectClient;Ljava/util/Set;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateSeriesRecord", ExifInterface.GPS_DIRECTION_TRUE, "recordType", "aggregator", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "Landroidx/health/connect/client/impl/platform/aggregate/RecordInfo;", "getSampleInfo", "Lkotlin/Function1;", "", "Landroidx/health/connect/client/impl/platform/aggregate/SampleInfo;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/health/connect/client/HealthConnectClient;Lkotlin/reflect/KClass;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateMetrics", "(Landroidx/health/connect/client/HealthConnectClient;Lkotlin/reflect/KClass;Ljava/util/Set;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateSpeed", "aggregateStepsCadence", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SeriesRecordAggregationExtensionsKt {
    private static final Map<KClass<? extends SeriesRecord<Object>>, AggregateMetricsInfo<? extends Comparable<?>>> RECORDS_TO_AGGREGATE_METRICS_INFO_MAP = MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), new AggregateMetricsInfo(CyclingPedalingCadenceRecord.RPM_AVG, CyclingPedalingCadenceRecord.RPM_MIN, CyclingPedalingCadenceRecord.RPM_MAX)), TuplesKt.to(Reflection.getOrCreateKotlinClass(SpeedRecord.class), new AggregateMetricsInfo(SpeedRecord.SPEED_AVG, SpeedRecord.SPEED_MIN, SpeedRecord.SPEED_MAX)), TuplesKt.to(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), new AggregateMetricsInfo(StepsCadenceRecord.RATE_AVG, StepsCadenceRecord.RATE_MIN, StepsCadenceRecord.RATE_MAX)));

    /* compiled from: SeriesRecordAggregationExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt", f = "SeriesRecordAggregationExtensions.kt", i = {0, 0, 0, 1}, l = {128, 130}, m = "aggregateSeriesRecord", n = {"timeRangeFilter", "aggregator", "getSampleInfo", "aggregator"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeriesRecord$2, reason: invalid class name and case insensitive filesystem */
    static final class C07962<T extends SeriesRecord<?>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C07962(Continuation<? super C07962> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SeriesRecordAggregationExtensionsKt.aggregateSeriesRecord((HealthConnectClient) null, (KClass) null, (TimeRangeFilter) null, (Set<DataOrigin>) null, (Aggregator<RecordInfo>) null, (Function1) null, this);
        }
    }

    public static final Object aggregateCyclingPedalingCadence(HealthConnectClient healthConnectClient, Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set2, Continuation<? super AggregationResult> continuation) {
        return aggregateSeriesRecord(healthConnectClient, Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), set, timeRangeFilter, set2, new Function1<CyclingPedalingCadenceRecord, List<? extends SampleInfo>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt.aggregateCyclingPedalingCadence.2
            @Override // kotlin.jvm.functions.Function1
            public final List<SampleInfo> invoke(CyclingPedalingCadenceRecord aggregateSeriesRecord) {
                Intrinsics.checkNotNullParameter(aggregateSeriesRecord, "$this$aggregateSeriesRecord");
                List<CyclingPedalingCadenceRecord.Sample> samples = aggregateSeriesRecord.getSamples();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
                for (CyclingPedalingCadenceRecord.Sample sample : samples) {
                    arrayList.add(new SampleInfo(sample.getTime(), sample.getRevolutionsPerMinute()));
                }
                return arrayList;
            }
        }, continuation);
    }

    public static final Object aggregateSpeed(HealthConnectClient healthConnectClient, Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set2, Continuation<? super AggregationResult> continuation) {
        return aggregateSeriesRecord(healthConnectClient, Reflection.getOrCreateKotlinClass(SpeedRecord.class), set, timeRangeFilter, set2, new Function1<SpeedRecord, List<? extends SampleInfo>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt.aggregateSpeed.2
            @Override // kotlin.jvm.functions.Function1
            public final List<SampleInfo> invoke(SpeedRecord aggregateSeriesRecord) {
                Intrinsics.checkNotNullParameter(aggregateSeriesRecord, "$this$aggregateSeriesRecord");
                List<SpeedRecord.Sample> samples = aggregateSeriesRecord.getSamples();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
                for (SpeedRecord.Sample sample : samples) {
                    arrayList.add(new SampleInfo(sample.getTime(), sample.getSpeed().getMetersPerSecond()));
                }
                return arrayList;
            }
        }, continuation);
    }

    public static final Object aggregateStepsCadence(HealthConnectClient healthConnectClient, Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set2, Continuation<? super AggregationResult> continuation) {
        return aggregateSeriesRecord(healthConnectClient, Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), set, timeRangeFilter, set2, new Function1<StepsCadenceRecord, List<? extends SampleInfo>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt.aggregateStepsCadence.2
            @Override // kotlin.jvm.functions.Function1
            public final List<SampleInfo> invoke(StepsCadenceRecord aggregateSeriesRecord) {
                Intrinsics.checkNotNullParameter(aggregateSeriesRecord, "$this$aggregateSeriesRecord");
                List<StepsCadenceRecord.Sample> samples = aggregateSeriesRecord.getSamples();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
                for (StepsCadenceRecord.Sample sample : samples) {
                    arrayList.add(new SampleInfo(sample.getTime(), sample.getRate()));
                }
                return arrayList;
            }
        }, continuation);
    }

    public static final <T extends SeriesRecord<?>> Object aggregateSeriesRecord(HealthConnectClient healthConnectClient, KClass<T> kClass, Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set2, Function1<? super T, ? extends List<SampleInfo>> function1, Continuation<? super AggregationResult> continuation) {
        return aggregateSeriesRecord(healthConnectClient, kClass, timeRangeFilter, set2, new SeriesAggregator(kClass, set), function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends androidx.health.connect.client.records.SeriesRecord<?>> java.lang.Object aggregateSeriesRecord(androidx.health.connect.client.HealthConnectClient r5, kotlin.reflect.KClass<T> r6, final androidx.health.connect.client.time.TimeRangeFilter r7, java.util.Set<androidx.health.connect.client.records.metadata.DataOrigin> r8, final androidx.health.connect.client.impl.platform.aggregate.Aggregator<androidx.health.connect.client.impl.platform.aggregate.RecordInfo> r9, final kotlin.jvm.functions.Function1<? super T, ? extends java.util.List<androidx.health.connect.client.impl.platform.aggregate.SampleInfo>> r10, kotlin.coroutines.Continuation<? super androidx.health.connect.client.aggregate.AggregationResult> r11) {
        /*
            boolean r0 = r11 instanceof androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt.C07962
            if (r0 == 0) goto L14
            r0 = r11
            androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeriesRecord$2 r0 = (androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt.C07962) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeriesRecord$2 r0 = new androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeriesRecord$2
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            androidx.health.connect.client.impl.platform.aggregate.Aggregator r5 = (androidx.health.connect.client.impl.platform.aggregate.Aggregator) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7c
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r5 = r0.L$2
            r10 = r5
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r5 = r0.L$1
            r9 = r5
            androidx.health.connect.client.impl.platform.aggregate.Aggregator r9 = (androidx.health.connect.client.impl.platform.aggregate.Aggregator) r9
            java.lang.Object r5 = r0.L$0
            r7 = r5
            androidx.health.connect.client.time.TimeRangeFilter r7 = (androidx.health.connect.client.time.TimeRangeFilter) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L62
        L4c:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.health.connect.client.time.TimeRangeFilter r11 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.withBufferedStart(r7)
            r0.L$0 = r7
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.readRecordsFlow(r5, r6, r11, r8, r0)
            if (r11 != r1) goto L62
            return r1
        L62:
            kotlinx.coroutines.flow.Flow r11 = (kotlinx.coroutines.flow.Flow) r11
            androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeriesRecord$3 r5 = new androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt$aggregateSeriesRecord$3
            r5.<init>()
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r0.L$0 = r9
            r6 = 0
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r5 = r11.collect(r5, r0)
            if (r5 != r1) goto L7b
            return r1
        L7b:
            r5 = r9
        L7c:
            androidx.health.connect.client.aggregate.AggregationResult r5 = r5.getResult()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.platform.aggregate.SeriesRecordAggregationExtensionsKt.aggregateSeriesRecord(androidx.health.connect.client.HealthConnectClient, kotlin.reflect.KClass, androidx.health.connect.client.time.TimeRangeFilter, java.util.Set, androidx.health.connect.client.impl.platform.aggregate.Aggregator, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
