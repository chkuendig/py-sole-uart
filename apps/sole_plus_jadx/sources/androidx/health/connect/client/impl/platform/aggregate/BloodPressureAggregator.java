package androidx.health.connect.client.impl.platform.aggregate;

import androidx.camera.video.AudioStats;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.units.Pressure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BloodPressureAggregationExtensions.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0096\u0002R#\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR%\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00160\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/BloodPressureAggregator;", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "bloodPressureMetrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "(Ljava/util/Set;)V", "avgDataMap", "", "Landroidx/health/connect/client/units/Pressure;", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "getAvgDataMap", "()Ljava/util/Map;", "getBloodPressureMetrics", "()Ljava/util/Set;", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDataOrigins", "doubleValues", "", "", "", "getDoubleValues", "minMaxMap", "getMinMaxMap", "plusAssign", "", "value", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class BloodPressureAggregator implements Aggregator<BloodPressureRecord> {
    private final Map<AggregateMetric<Pressure>, AvgData> avgDataMap;
    private final Set<AggregateMetric<?>> bloodPressureMetrics;
    private final Set<DataOrigin> dataOrigins;
    private final Map<AggregateMetric<Pressure>, Double> minMaxMap;

    /* JADX WARN: Multi-variable type inference failed */
    public BloodPressureAggregator(Set<? extends AggregateMetric<?>> bloodPressureMetrics) {
        Intrinsics.checkNotNullParameter(bloodPressureMetrics, "bloodPressureMetrics");
        this.bloodPressureMetrics = bloodPressureMetrics;
        this.avgDataMap = new LinkedHashMap();
        this.minMaxMap = new LinkedHashMap();
        this.dataOrigins = new LinkedHashSet();
        if (!BloodPressureAggregationExtensionsKt.BLOOD_PRESSURE_METRICS.containsAll(bloodPressureMetrics)) {
            StringBuilder sb = new StringBuilder("Invalid set of blood pressure fallback aggregation metrics ");
            Set<? extends AggregateMetric<?>> set = bloodPressureMetrics;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((AggregateMetric) it.next()).getMetricKey());
            }
            throw new IllegalStateException(sb.append(arrayList).toString().toString());
        }
        Iterator it2 = bloodPressureMetrics.iterator();
        while (it2.hasNext()) {
            AggregateMetric<Pressure> aggregateMetric = (AggregateMetric) it2.next();
            if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_AVG) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_AVG)) {
                this.avgDataMap.put(aggregateMetric, new AvgData(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null));
            } else {
                if (!(Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MAX) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MIN) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MAX) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MIN))) {
                    throw new IllegalStateException(("Invalid blood pressure fallback aggregation metric " + aggregateMetric.getMetricKey()).toString());
                }
                this.minMaxMap.put(aggregateMetric, null);
            }
        }
    }

    public final Set<AggregateMetric<?>> getBloodPressureMetrics() {
        return this.bloodPressureMetrics;
    }

    public final Map<AggregateMetric<Pressure>, AvgData> getAvgDataMap() {
        return this.avgDataMap;
    }

    public final Map<AggregateMetric<Pressure>, Double> getMinMaxMap() {
        return this.minMaxMap;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public Set<DataOrigin> getDataOrigins() {
        return this.dataOrigins;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public Map<String, Double> getDoubleValues() {
        double dDoubleValue;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (AggregateMetric<?> aggregateMetric : this.bloodPressureMetrics) {
            if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_AVG) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_AVG)) {
                AvgData avgData = this.avgDataMap.get(aggregateMetric);
                Intrinsics.checkNotNull(avgData);
                dDoubleValue = avgData.average();
            } else {
                if (!(Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MAX) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MIN) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MAX) ? true : Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MIN))) {
                    throw new IllegalStateException(("Invalid blood pressure fallback aggregation type " + aggregateMetric.getMetricKey()).toString());
                }
                Double d = this.minMaxMap.get(aggregateMetric);
                Intrinsics.checkNotNull(d);
                dDoubleValue = d.doubleValue();
            }
            mapCreateMapBuilder.put(aggregateMetric.getMetricKey(), Double.valueOf(dDoubleValue));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public void plusAssign(BloodPressureRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        double value2 = value.getDiastolic().getValue();
        double value3 = value.getSystolic().getValue();
        for (AggregateMetric<?> aggregateMetric : this.bloodPressureMetrics) {
            if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_AVG)) {
                AvgData avgData = this.avgDataMap.get(aggregateMetric);
                Intrinsics.checkNotNull(avgData);
                avgData.plusAssign(value2);
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MAX)) {
                Map<AggregateMetric<Pressure>, Double> map = this.minMaxMap;
                Double d = (Double) map.get(aggregateMetric);
                map.put(aggregateMetric, Double.valueOf(Math.max(d != null ? d.doubleValue() : value2, value2)));
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MIN)) {
                Map<AggregateMetric<Pressure>, Double> map2 = this.minMaxMap;
                Double d2 = (Double) map2.get(aggregateMetric);
                map2.put(aggregateMetric, Double.valueOf(Math.min(d2 != null ? d2.doubleValue() : value2, value2)));
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_AVG)) {
                AvgData avgData2 = this.avgDataMap.get(aggregateMetric);
                Intrinsics.checkNotNull(avgData2);
                avgData2.plusAssign(value3);
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MAX)) {
                Map<AggregateMetric<Pressure>, Double> map3 = this.minMaxMap;
                Double d3 = (Double) map3.get(aggregateMetric);
                map3.put(aggregateMetric, Double.valueOf(Math.max(d3 != null ? d3.doubleValue() : value3, value3)));
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MIN)) {
                Map<AggregateMetric<Pressure>, Double> map4 = this.minMaxMap;
                Double d4 = (Double) map4.get(aggregateMetric);
                map4.put(aggregateMetric, Double.valueOf(Math.min(d4 != null ? d4.doubleValue() : value3, value3)));
            }
            getDataOrigins().add(value.getMetadata().getDataOrigin());
        }
    }
}
