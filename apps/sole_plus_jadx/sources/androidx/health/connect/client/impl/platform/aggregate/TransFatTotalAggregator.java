package androidx.health.connect.client.impl.platform.aggregate;

import androidx.camera.video.AudioStats;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NutritionAggregationExtensions.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/TransFatTotalAggregator;", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "Landroidx/health/connect/client/records/NutritionRecord;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Landroidx/health/connect/client/time/TimeRangeFilter;)V", "dataOrigins", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDataOrigins", "()Ljava/util/Set;", "doubleValues", "", "", "", "getDoubleValues", "()Ljava/util/Map;", "getTimeRangeFilter", "()Landroidx/health/connect/client/time/TimeRangeFilter;", "total", "getTotal", "()D", "setTotal", "(D)V", "plusAssign", "", "value", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class TransFatTotalAggregator implements Aggregator<NutritionRecord> {
    private final Set<DataOrigin> dataOrigins;
    private final TimeRangeFilter timeRangeFilter;
    private double total;

    public TransFatTotalAggregator(TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        this.timeRangeFilter = timeRangeFilter;
        this.dataOrigins = new LinkedHashSet();
    }

    public final TimeRangeFilter getTimeRangeFilter() {
        return this.timeRangeFilter;
    }

    public final double getTotal() {
        return this.total;
    }

    public final void setTotal(double d) {
        this.total = d;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public Set<DataOrigin> getDataOrigins() {
        return this.dataOrigins;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public Map<String, Double> getDoubleValues() {
        return MapsKt.mapOf(TuplesKt.to(NutritionRecord.TRANS_FAT_TOTAL.getMetricKey(), Double.valueOf(this.total)));
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public void plusAssign(NutritionRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.getTransFat() != null) {
            NutritionRecord nutritionRecord = value;
            if (NutritionAggregationExtensionsKt.sliceFactor(nutritionRecord, this.timeRangeFilter) > AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.total += value.getTransFat().getGrams() * NutritionAggregationExtensionsKt.sliceFactor(nutritionRecord, this.timeRangeFilter);
                getDataOrigins().add(value.getMetadata().getDataOrigin());
            }
        }
    }
}
