package androidx.health.connect.client.impl.platform.aggregate;

import android.os.ext.SdkExtensions;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.request.AggregateRequest;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationExtensions.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0080\u0002\"\u001e\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10", "()Ljava/util/Set;", "fallbackMetrics", "Landroidx/health/connect/client/request/AggregateRequest;", "getFallbackMetrics", "(Landroidx/health/connect/client/request/AggregateRequest;)Ljava/util/Set;", "platformMetrics", "getPlatformMetrics", "plus", "Landroidx/health/connect/client/aggregate/AggregationResult;", "other", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AggregationExtensionsKt {
    private static final Set<AggregateMetric<?>> AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10 = SetsKt.setOf((Object[]) new AggregateMetric[]{BloodPressureRecord.DIASTOLIC_AVG, BloodPressureRecord.DIASTOLIC_MAX, BloodPressureRecord.DIASTOLIC_MIN, BloodPressureRecord.SYSTOLIC_AVG, BloodPressureRecord.SYSTOLIC_MAX, BloodPressureRecord.SYSTOLIC_MIN, CyclingPedalingCadenceRecord.RPM_AVG, CyclingPedalingCadenceRecord.RPM_MAX, CyclingPedalingCadenceRecord.RPM_MIN, NutritionRecord.TRANS_FAT_TOTAL, SpeedRecord.SPEED_AVG, SpeedRecord.SPEED_MAX, SpeedRecord.SPEED_MIN, StepsCadenceRecord.RATE_AVG, StepsCadenceRecord.RATE_MAX, StepsCadenceRecord.RATE_MIN});

    public static final Set<AggregateMetric<?>> getPlatformMetrics(AggregateRequest aggregateRequest) {
        Intrinsics.checkNotNullParameter(aggregateRequest, "<this>");
        if (SdkExtensions.getExtensionVersion(34) >= 10) {
            return aggregateRequest.getMetrics$connect_client_release();
        }
        Set<AggregateMetric<?>> metrics$connect_client_release = aggregateRequest.getMetrics$connect_client_release();
        ArrayList arrayList = new ArrayList();
        for (Object obj : metrics$connect_client_release) {
            if (!AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10.contains((AggregateMetric) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final Set<AggregateMetric<?>> getFallbackMetrics(AggregateRequest aggregateRequest) {
        Intrinsics.checkNotNullParameter(aggregateRequest, "<this>");
        if (SdkExtensions.getExtensionVersion(34) >= 10) {
            return SetsKt.emptySet();
        }
        Set<AggregateMetric<?>> metrics$connect_client_release = aggregateRequest.getMetrics$connect_client_release();
        ArrayList arrayList = new ArrayList();
        for (Object obj : metrics$connect_client_release) {
            if (AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10.contains((AggregateMetric) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final AggregationResult plus(AggregationResult aggregationResult, AggregationResult other) {
        Intrinsics.checkNotNullParameter(aggregationResult, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new AggregationResult(MapsKt.plus(aggregationResult.getLongValues(), other.getLongValues()), MapsKt.plus(aggregationResult.getDoubleValues(), other.getDoubleValues()), SetsKt.plus((Set) aggregationResult.getDataOrigins(), (Iterable) other.getDataOrigins()));
    }

    public static final Set<AggregateMetric<?>> getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10() {
        return AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10;
    }
}
