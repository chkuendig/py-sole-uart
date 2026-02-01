package androidx.health.connect.client.impl.platform.aggregate;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b¢\u0006\u0002\u0010\nJ\u0011\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\u000b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$¨\u0006,"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/SeriesAggregator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/health/connect/client/records/SeriesRecord;", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "Landroidx/health/connect/client/impl/platform/aggregate/RecordInfo;", "recordType", "Lkotlin/reflect/KClass;", "aggregateMetrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "(Lkotlin/reflect/KClass;Ljava/util/Set;)V", "aggregateInfo", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "getAggregateInfo", "()Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "getAggregateMetrics", "()Ljava/util/Set;", "avgData", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "getAvgData", "()Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDataOrigins", "doubleValues", "", "", "", "getDoubleValues", "()Ljava/util/Map;", "max", "getMax", "()Ljava/lang/Double;", "setMax", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", HealthConstants.HeartRate.MIN, "getMin", "setMin", "plusAssign", "", "value", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SeriesAggregator<T extends SeriesRecord<?>> implements Aggregator<RecordInfo> {
    private final AggregateMetricsInfo<? extends Comparable<?>> aggregateInfo;
    private final Set<AggregateMetric<?>> aggregateMetrics;
    private final AvgData avgData;
    private final Set<DataOrigin> dataOrigins;
    private Double max;
    private Double min;

    /* JADX WARN: Multi-variable type inference failed */
    public SeriesAggregator(KClass<T> recordType, Set<? extends AggregateMetric<?>> aggregateMetrics) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(aggregateMetrics, "aggregateMetrics");
        this.aggregateMetrics = aggregateMetrics;
        this.avgData = new AvgData(0, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
        this.dataOrigins = new LinkedHashSet();
        AggregateMetricsInfo<? extends Comparable<?>> aggregateMetricsInfo = (AggregateMetricsInfo) SeriesRecordAggregationExtensionsKt.RECORDS_TO_AGGREGATE_METRICS_INFO_MAP.get(recordType);
        if (aggregateMetricsInfo == null) {
            throw new IllegalArgumentException("Non supported fallback series record " + recordType);
        }
        this.aggregateInfo = aggregateMetricsInfo;
        if (SetsKt.setOf((Object[]) new AggregateMetric[]{aggregateMetricsInfo.getAverageMetric(), aggregateMetricsInfo.getMinMetric(), aggregateMetricsInfo.getMaxMetric()}).containsAll(aggregateMetrics)) {
            return;
        }
        StringBuilder sb = new StringBuilder("Invalid set of metrics ");
        Set<? extends AggregateMetric<?>> set = aggregateMetrics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((AggregateMetric) it.next()).getMetricKey());
        }
        throw new IllegalStateException(sb.append(arrayList).toString().toString());
    }

    public final Set<AggregateMetric<?>> getAggregateMetrics() {
        return this.aggregateMetrics;
    }

    public final AvgData getAvgData() {
        return this.avgData;
    }

    public final Double getMin() {
        return this.min;
    }

    public final void setMin(Double d) {
        this.min = d;
    }

    public final Double getMax() {
        return this.max;
    }

    public final void setMax(Double d) {
        this.max = d;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public Set<DataOrigin> getDataOrigins() {
        return this.dataOrigins;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public Map<String, Double> getDoubleValues() {
        double dDoubleValue;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (AggregateMetric<?> aggregateMetric : this.aggregateMetrics) {
            if (Intrinsics.areEqual(aggregateMetric, this.aggregateInfo.getAverageMetric())) {
                dDoubleValue = this.avgData.average();
            } else if (Intrinsics.areEqual(aggregateMetric, this.aggregateInfo.getMaxMetric())) {
                Double d = this.max;
                Intrinsics.checkNotNull(d);
                dDoubleValue = d.doubleValue();
            } else {
                if (!Intrinsics.areEqual(aggregateMetric, this.aggregateInfo.getMinMetric())) {
                    throw new IllegalStateException(("Invalid fallback aggregation metric " + aggregateMetric.getMetricKey()).toString());
                }
                Double d2 = this.min;
                Intrinsics.checkNotNull(d2);
                dDoubleValue = d2.doubleValue();
            }
            mapCreateMapBuilder.put(aggregateMetric.getMetricKey(), Double.valueOf(dDoubleValue));
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final AggregateMetricsInfo<? extends Comparable<?>> getAggregateInfo() {
        return this.aggregateInfo;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public void plusAssign(RecordInfo value) {
        Intrinsics.checkNotNullParameter(value, "value");
        for (SampleInfo sampleInfo : value.getSamples()) {
            this.avgData.plusAssign(sampleInfo.getValue());
            Double d = this.min;
            this.min = Double.valueOf(Math.min(d != null ? d.doubleValue() : sampleInfo.getValue(), sampleInfo.getValue()));
            Double d2 = this.max;
            this.max = Double.valueOf(Math.max(d2 != null ? d2.doubleValue() : sampleInfo.getValue(), sampleInfo.getValue()));
        }
        getDataOrigins().add(value.getDataOrigin());
    }
}
