package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/SampleInfo;", "", "time", "Ljava/time/Instant;", "value", "", "(Ljava/time/Instant;D)V", "getTime", "()Ljava/time/Instant;", "getValue", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isWithin", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "zoneOffset", "Ljava/time/ZoneOffset;", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SampleInfo {
    private final Instant time;
    private final double value;

    public static /* synthetic */ SampleInfo copy$default(SampleInfo sampleInfo, Instant instant, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            instant = sampleInfo.time;
        }
        if ((i & 2) != 0) {
            d = sampleInfo.value;
        }
        return sampleInfo.copy(instant, d);
    }

    /* renamed from: component1, reason: from getter */
    public final Instant getTime() {
        return this.time;
    }

    /* renamed from: component2, reason: from getter */
    public final double getValue() {
        return this.value;
    }

    public final SampleInfo copy(Instant time, double value) {
        Intrinsics.checkNotNullParameter(time, "time");
        return new SampleInfo(time, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SampleInfo)) {
            return false;
        }
        SampleInfo sampleInfo = (SampleInfo) other;
        return Intrinsics.areEqual(this.time, sampleInfo.time) && Double.compare(this.value, sampleInfo.value) == 0;
    }

    public int hashCode() {
        return (this.time.hashCode() * 31) + Double.hashCode(this.value);
    }

    public String toString() {
        return "SampleInfo(time=" + this.time + ", value=" + this.value + ')';
    }

    public SampleInfo(Instant time, double d) {
        Intrinsics.checkNotNullParameter(time, "time");
        this.time = time;
        this.value = d;
    }

    public final Instant getTime() {
        return this.time;
    }

    public final double getValue() {
        return this.value;
    }

    public final boolean isWithin(TimeRangeFilter timeRangeFilter, ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        if (TimeExtensionsKt.useLocalTime(timeRangeFilter)) {
            if (timeRangeFilter.getLocalStartTime() == null || !this.time.isBefore(TimeExtensionsKt.toInstantWithDefaultZoneFallback(timeRangeFilter.getLocalStartTime(), zoneOffset))) {
                return timeRangeFilter.getLocalEndTime() == null || this.time.isBefore(TimeExtensionsKt.toInstantWithDefaultZoneFallback(timeRangeFilter.getLocalEndTime(), zoneOffset));
            }
            return false;
        }
        if (timeRangeFilter.getStartTime() == null || !this.time.isBefore(timeRangeFilter.getStartTime())) {
            return timeRangeFilter.getEndTime() == null || this.time.isBefore(timeRangeFilter.getEndTime());
        }
        return false;
    }
}
