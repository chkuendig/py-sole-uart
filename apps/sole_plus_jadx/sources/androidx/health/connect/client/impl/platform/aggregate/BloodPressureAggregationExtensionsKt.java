package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.connect.client.units.Pressure;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BloodPressureAggregationExtensions.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0082@¢\u0006\u0002\u0010\u000e\u001a:\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001H\u0080@¢\u0006\u0002\u0010\u0010\"\u001a\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"BLOOD_PRESSURE_METRICS", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "Landroidx/health/connect/client/units/Pressure;", "aggregateBloodPressure", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/connect/client/HealthConnectClient;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "aggregator", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bloodPressureMetrics", "(Landroidx/health/connect/client/HealthConnectClient;Ljava/util/Set;Landroidx/health/connect/client/time/TimeRangeFilter;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BloodPressureAggregationExtensionsKt {
    private static final Set<AggregateMetric<Pressure>> BLOOD_PRESSURE_METRICS = SetsKt.setOf((Object[]) new AggregateMetric[]{BloodPressureRecord.DIASTOLIC_AVG, BloodPressureRecord.DIASTOLIC_MAX, BloodPressureRecord.DIASTOLIC_MIN, BloodPressureRecord.SYSTOLIC_AVG, BloodPressureRecord.SYSTOLIC_MAX, BloodPressureRecord.SYSTOLIC_MIN});

    /* compiled from: BloodPressureAggregationExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt", f = "BloodPressureAggregationExtensions.kt", i = {0, 1}, l = {58, 58}, m = "aggregateBloodPressure", n = {"aggregator", "aggregator"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$2, reason: invalid class name */
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BloodPressureAggregationExtensionsKt.aggregateBloodPressure((HealthConnectClient) null, (TimeRangeFilter) null, (Set<DataOrigin>) null, (Aggregator<BloodPressureRecord>) null, this);
        }
    }

    public static final Object aggregateBloodPressure(HealthConnectClient healthConnectClient, Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Set<DataOrigin> set2, Continuation<? super AggregationResult> continuation) {
        return aggregateBloodPressure(healthConnectClient, timeRangeFilter, set2, new BloodPressureAggregator(set), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object aggregateBloodPressure(androidx.health.connect.client.HealthConnectClient r5, androidx.health.connect.client.time.TimeRangeFilter r6, java.util.Set<androidx.health.connect.client.records.metadata.DataOrigin> r7, final androidx.health.connect.client.impl.platform.aggregate.Aggregator<androidx.health.connect.client.records.BloodPressureRecord> r8, kotlin.coroutines.Continuation<? super androidx.health.connect.client.aggregate.AggregationResult> r9) {
        /*
            boolean r0 = r9 instanceof androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r9
            androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$2 r0 = (androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$2 r0 = new androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.L$0
            androidx.health.connect.client.impl.platform.aggregate.Aggregator r5 = (androidx.health.connect.client.impl.platform.aggregate.Aggregator) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6b
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            java.lang.Object r5 = r0.L$0
            r8 = r5
            androidx.health.connect.client.impl.platform.aggregate.Aggregator r8 = (androidx.health.connect.client.impl.platform.aggregate.Aggregator) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L56
        L42:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Class<androidx.health.connect.client.records.BloodPressureRecord> r9 = androidx.health.connect.client.records.BloodPressureRecord.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = androidx.health.connect.client.impl.platform.aggregate.HealthConnectClientAggregationExtensionsKt.readRecordsFlow(r5, r9, r6, r7, r0)
            if (r9 != r1) goto L56
            return r1
        L56:
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$3 r5 = new androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt$aggregateBloodPressure$3
            r5.<init>()
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r5 = r9.collect(r5, r0)
            if (r5 != r1) goto L6a
            return r1
        L6a:
            r5 = r8
        L6b:
            androidx.health.connect.client.aggregate.AggregationResult r5 = r5.getResult()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt.aggregateBloodPressure(androidx.health.connect.client.HealthConnectClient, androidx.health.connect.client.time.TimeRangeFilter, java.util.Set, androidx.health.connect.client.impl.platform.aggregate.Aggregator, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
