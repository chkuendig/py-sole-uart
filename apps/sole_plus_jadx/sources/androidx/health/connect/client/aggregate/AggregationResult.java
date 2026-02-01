package androidx.health.connect.client.aggregate;

import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.metadata.DataOrigin;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationResult.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\b\u0007\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0086\u0002J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0014H\u0086\u0002¢\u0006\u0002\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0018"}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResult;", "", "longValues", "", "", "", "doubleValues", "", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)V", "getDataOrigins", "()Ljava/util/Set;", "getDoubleValues", "()Ljava/util/Map;", "getLongValues", "contains", "", "metric", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/health/connect/client/aggregate/AggregateMetric;)Ljava/lang/Object;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AggregationResult {
    private final Set<DataOrigin> dataOrigins;
    private final Map<String, Double> doubleValues;
    private final Map<String, Long> longValues;

    public AggregationResult(Map<String, Long> longValues, Map<String, Double> doubleValues, Set<DataOrigin> dataOrigins) {
        Intrinsics.checkNotNullParameter(longValues, "longValues");
        Intrinsics.checkNotNullParameter(doubleValues, "doubleValues");
        Intrinsics.checkNotNullParameter(dataOrigins, "dataOrigins");
        this.longValues = longValues;
        this.doubleValues = doubleValues;
        this.dataOrigins = dataOrigins;
    }

    public final Map<String, Long> getLongValues() {
        return this.longValues;
    }

    public final Map<String, Double> getDoubleValues() {
        return this.doubleValues;
    }

    public final Set<DataOrigin> getDataOrigins() {
        return this.dataOrigins;
    }

    public final boolean contains(AggregateMetric<?> metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        AggregateMetric.Converter<?, ?> converter$connect_client_release = metric.getConverter$connect_client_release();
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromLong) {
            return this.longValues.containsKey(metric.getMetricKey());
        }
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromDouble) {
            return this.doubleValues.containsKey(metric.getMetricKey());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <T> T get(AggregateMetric<? extends T> metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        AggregateMetric.Converter<?, ? extends T> converter$connect_client_release = metric.getConverter$connect_client_release();
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromLong) {
            Long l = this.longValues.get(metric.getMetricKey());
            if (l != null) {
                return metric.getConverter$connect_client_release().invoke(l);
            }
            return null;
        }
        if (!(converter$connect_client_release instanceof AggregateMetric.Converter.FromDouble)) {
            throw new NoWhenBranchMatchedException();
        }
        Double d = this.doubleValues.get(metric.getMetricKey());
        if (d != null) {
            return metric.getConverter$connect_client_release().invoke(d);
        }
        return null;
    }
}
