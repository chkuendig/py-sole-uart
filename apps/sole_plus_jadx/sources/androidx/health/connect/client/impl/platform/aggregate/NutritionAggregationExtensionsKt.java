package androidx.health.connect.client.impl.platform.aggregate;

import androidx.camera.video.AudioStats;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NutritionAggregationExtensions.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082@¢\u0006\u0002\u0010\u000b\u001a(\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0080@¢\u0006\u0002\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0011"}, d2 = {"aggregateNutrition", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/HealthConnectClient;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "aggregator", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "Landroidx/health/connect/client/records/NutritionRecord;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aggregateNutritionTransFatTotal", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sliceFactor", "", "Landroidx/health/connect/client/records/IntervalRecord;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NutritionAggregationExtensionsKt {

    /* compiled from: NutritionAggregationExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt", f = "NutritionAggregationExtensions.kt", i = {0, 0, 1}, l = {46, 47}, m = "aggregateNutrition", n = {"timeRangeFilter", "aggregator", "aggregator"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutrition$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NutritionAggregationExtensionsKt.aggregateNutrition(null, null, null, null, this);
        }
    }

    public static final Object aggregateNutritionTransFatTotal(HealthConnectClient healthConnectClient, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set, Continuation<? super AggregationResult> continuation) {
        return aggregateNutrition(healthConnectClient, timeRangeFilter, set, new TransFatTotalAggregator(timeRangeFilter), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object aggregateNutrition(androidx.health.connect.client.HealthConnectClient r5, final androidx.health.connect.client.time.TimeRangeFilter r6, java.util.Set<androidx.health.connect.client.records.metadata.DataOrigin> r7, final androidx.health.connect.client.impl.platform.aggregate.Aggregator<androidx.health.connect.client.records.NutritionRecord> r8, kotlin.coroutines.Continuation<? super androidx.health.connect.client.aggregate.AggregationResult> r9) {
        /*
            boolean r0 = r9 instanceof androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutrition$1 r0 = (androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutrition$1 r0 = new androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutrition$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            androidx.health.connect.client.impl.platform.aggregate.Aggregator r5 = (androidx.health.connect.client.impl.platform.aggregate.Aggregator) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L79
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r5 = r0.L$1
            r8 = r5
            androidx.health.connect.client.impl.platform.aggregate.Aggregator r8 = (androidx.health.connect.client.impl.platform.aggregate.Aggregator) r8
            java.lang.Object r5 = r0.L$0
            r6 = r5
            androidx.health.connect.client.time.TimeRangeFilter r6 = (androidx.health.connect.client.time.TimeRangeFilter) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L61
        L47:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Class<androidx.health.connect.client.records.NutritionRecord> r9 = androidx.health.connect.client.records.NutritionRecord.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            androidx.health.connect.client.time.TimeRangeFilter r2 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.withBufferedStart(r6)
            r0.L$0 = r6
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.readRecordsFlow(r5, r9, r2, r7, r0)
            if (r9 != r1) goto L61
            return r1
        L61:
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutrition$2 r5 = new androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt$aggregateNutrition$2
            r5.<init>()
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r0.L$0 = r8
            r6 = 0
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r9.collect(r5, r0)
            if (r5 != r1) goto L78
            return r1
        L78:
            r5 = r8
        L79:
            androidx.health.connect.client.aggregate.AggregationResult r5 = r5.getResult()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt.aggregateNutrition(androidx.health.connect.client.HealthConnectClient, androidx.health.connect.client.time.TimeRangeFilter, java.util.Set, androidx.health.connect.client.impl.platform.aggregate.Aggregator, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final double sliceFactor(IntervalRecord intervalRecord, TimeRangeFilter timeRangeFilter) {
        Instant instant;
        Instant instant2;
        Intrinsics.checkNotNullParameter(intervalRecord, "<this>");
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        if (TimeExtensionsKt.useLocalTime(timeRangeFilter)) {
            LocalDateTime localStartTime = timeRangeFilter.getLocalStartTime();
            Instant instantWithDefaultZoneFallback = localStartTime != null ? TimeExtensionsKt.toInstantWithDefaultZoneFallback(localStartTime, intervalRecord.getStartZoneOffset()) : null;
            LocalDateTime localEndTime = timeRangeFilter.getLocalEndTime();
            Instant instantWithDefaultZoneFallback2 = localEndTime != null ? TimeExtensionsKt.toInstantWithDefaultZoneFallback(localEndTime, intervalRecord.getEndZoneOffset()) : null;
            Instant startTime = intervalRecord.getStartTime();
            if (instantWithDefaultZoneFallback == null) {
                instantWithDefaultZoneFallback = intervalRecord.getStartTime();
            }
            instant2 = (Instant) ComparisonsKt.maxOf(startTime, instantWithDefaultZoneFallback);
            Instant endTime = intervalRecord.getEndTime();
            if (instantWithDefaultZoneFallback2 == null) {
                instantWithDefaultZoneFallback2 = intervalRecord.getEndTime();
            }
            instant = (Instant) ComparisonsKt.minOf(endTime, instantWithDefaultZoneFallback2);
        } else {
            Instant startTime2 = intervalRecord.getStartTime();
            Instant startTime3 = timeRangeFilter.getStartTime();
            if (startTime3 == null) {
                startTime3 = intervalRecord.getStartTime();
            }
            Instant instant3 = (Instant) ComparisonsKt.maxOf(startTime2, startTime3);
            Instant endTime2 = intervalRecord.getEndTime();
            Instant endTime3 = timeRangeFilter.getEndTime();
            if (endTime3 == null) {
                endTime3 = intervalRecord.getEndTime();
            }
            instant = (Instant) ComparisonsKt.minOf(endTime2, endTime3);
            instant2 = instant3;
        }
        return Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, TimeExtensionsKt.div(TimeExtensionsKt.minus(instant, instant2), TimeExtensionsKt.getDuration(intervalRecord)));
    }
}
