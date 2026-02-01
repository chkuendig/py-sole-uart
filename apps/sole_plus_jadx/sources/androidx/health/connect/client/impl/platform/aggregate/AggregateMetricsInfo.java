package androidx.health.connect.client.impl.platform.aggregate;

import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.aggregate.AggregateMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J?\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", ExifInterface.GPS_DIRECTION_TRUE, "", "averageMetric", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "minMetric", "maxMetric", "(Landroidx/health/connect/client/aggregate/AggregateMetric;Landroidx/health/connect/client/aggregate/AggregateMetric;Landroidx/health/connect/client/aggregate/AggregateMetric;)V", "getAverageMetric", "()Landroidx/health/connect/client/aggregate/AggregateMetric;", "getMaxMetric", "getMinMetric", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AggregateMetricsInfo<T> {
    private final AggregateMetric<T> averageMetric;
    private final AggregateMetric<T> maxMetric;
    private final AggregateMetric<T> minMetric;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AggregateMetricsInfo copy$default(AggregateMetricsInfo aggregateMetricsInfo, AggregateMetric aggregateMetric, AggregateMetric aggregateMetric2, AggregateMetric aggregateMetric3, int i, Object obj) {
        if ((i & 1) != 0) {
            aggregateMetric = aggregateMetricsInfo.averageMetric;
        }
        if ((i & 2) != 0) {
            aggregateMetric2 = aggregateMetricsInfo.minMetric;
        }
        if ((i & 4) != 0) {
            aggregateMetric3 = aggregateMetricsInfo.maxMetric;
        }
        return aggregateMetricsInfo.copy(aggregateMetric, aggregateMetric2, aggregateMetric3);
    }

    public final AggregateMetric<T> component1() {
        return this.averageMetric;
    }

    public final AggregateMetric<T> component2() {
        return this.minMetric;
    }

    public final AggregateMetric<T> component3() {
        return this.maxMetric;
    }

    public final AggregateMetricsInfo<T> copy(AggregateMetric<? extends T> averageMetric, AggregateMetric<? extends T> minMetric, AggregateMetric<? extends T> maxMetric) {
        Intrinsics.checkNotNullParameter(averageMetric, "averageMetric");
        Intrinsics.checkNotNullParameter(minMetric, "minMetric");
        Intrinsics.checkNotNullParameter(maxMetric, "maxMetric");
        return new AggregateMetricsInfo<>(averageMetric, minMetric, maxMetric);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AggregateMetricsInfo)) {
            return false;
        }
        AggregateMetricsInfo aggregateMetricsInfo = (AggregateMetricsInfo) other;
        return Intrinsics.areEqual(this.averageMetric, aggregateMetricsInfo.averageMetric) && Intrinsics.areEqual(this.minMetric, aggregateMetricsInfo.minMetric) && Intrinsics.areEqual(this.maxMetric, aggregateMetricsInfo.maxMetric);
    }

    public int hashCode() {
        return (((this.averageMetric.hashCode() * 31) + this.minMetric.hashCode()) * 31) + this.maxMetric.hashCode();
    }

    public String toString() {
        return "AggregateMetricsInfo(averageMetric=" + this.averageMetric + ", minMetric=" + this.minMetric + ", maxMetric=" + this.maxMetric + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AggregateMetricsInfo(AggregateMetric<? extends T> averageMetric, AggregateMetric<? extends T> minMetric, AggregateMetric<? extends T> maxMetric) {
        Intrinsics.checkNotNullParameter(averageMetric, "averageMetric");
        Intrinsics.checkNotNullParameter(minMetric, "minMetric");
        Intrinsics.checkNotNullParameter(maxMetric, "maxMetric");
        this.averageMetric = averageMetric;
        this.minMetric = minMetric;
        this.maxMetric = maxMetric;
    }

    public final AggregateMetric<T> getAverageMetric() {
        return this.averageMetric;
    }

    public final AggregateMetric<T> getMinMetric() {
        return this.minMetric;
    }

    public final AggregateMetric<T> getMaxMetric() {
        return this.maxMetric;
    }
}
