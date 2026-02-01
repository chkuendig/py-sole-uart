package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import com.android.SdkConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeartRateRecord.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006\""}, d2 = {"Landroidx/health/connect/client/records/HeartRateRecord;", "Landroidx/health/connect/client/records/SeriesRecord;", "Landroidx/health/connect/client/records/HeartRateRecord$Sample;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", SDKConstants.PARAM_END_TIME, "endZoneOffset", SdkConstants.FD_SAMPLES, "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/util/List;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getSamples", "()Ljava/util/List;", "getStartTime", "getStartZoneOffset", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "Sample", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HeartRateRecord implements SeriesRecord<Sample> {
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final List<Sample> samples;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private static final String HEART_RATE_TYPE_NAME = "HeartRateSeries";
    private static final String BPM_FIELD_NAME = "bpm";
    public static final AggregateMetric<Long> BPM_AVG = AggregateMetric.INSTANCE.longMetric$connect_client_release(HEART_RATE_TYPE_NAME, AggregateMetric.AggregationType.AVERAGE, BPM_FIELD_NAME);
    public static final AggregateMetric<Long> BPM_MIN = AggregateMetric.INSTANCE.longMetric$connect_client_release(HEART_RATE_TYPE_NAME, AggregateMetric.AggregationType.MINIMUM, BPM_FIELD_NAME);
    public static final AggregateMetric<Long> BPM_MAX = AggregateMetric.INSTANCE.longMetric$connect_client_release(HEART_RATE_TYPE_NAME, AggregateMetric.AggregationType.MAXIMUM, BPM_FIELD_NAME);
    public static final AggregateMetric<Long> MEASUREMENTS_COUNT = AggregateMetric.INSTANCE.countMetric$connect_client_release(HEART_RATE_TYPE_NAME);

    public HeartRateRecord(Instant startTime, ZoneOffset zoneOffset, Instant endTime, ZoneOffset zoneOffset2, List<Sample> samples, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(samples, "samples");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = zoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = zoneOffset2;
        this.samples = samples;
        this.metadata = metadata;
        if (getStartTime().isAfter(getEndTime())) {
            throw new IllegalArgumentException("startTime must not be after endTime.".toString());
        }
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    @Override // androidx.health.connect.client.records.SeriesRecord
    public List<Sample> getSamples() {
        return this.samples;
    }

    public /* synthetic */ HeartRateRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, List list, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, list, (i & 32) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeartRateRecord)) {
            return false;
        }
        HeartRateRecord heartRateRecord = (HeartRateRecord) other;
        return Intrinsics.areEqual(getStartTime(), heartRateRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), heartRateRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), heartRateRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), heartRateRecord.getEndZoneOffset()) && Intrinsics.areEqual(getSamples(), heartRateRecord.getSamples()) && Intrinsics.areEqual(getMetadata(), heartRateRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = getStartTime().hashCode() * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (((iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((((iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getSamples().hashCode()) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "HeartRateRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", samples=" + getSamples() + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: HeartRateRecord.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/health/connect/client/records/HeartRateRecord$Sample;", "", "time", "Ljava/time/Instant;", "beatsPerMinute", "", "(Ljava/time/Instant;J)V", "getBeatsPerMinute", "()J", "getTime", "()Ljava/time/Instant;", "equals", "", "other", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Sample {
        private final long beatsPerMinute;
        private final Instant time;

        public Sample(Instant time, long j) {
            Intrinsics.checkNotNullParameter(time, "time");
            this.time = time;
            this.beatsPerMinute = j;
            UtilsKt.requireNotLess(Long.valueOf(j), (Comparable) 1L, "beatsPerMinute");
            UtilsKt.requireNotMore(Long.valueOf(j), (Comparable) 300L, "beatsPerMinute");
        }

        public final Instant getTime() {
            return this.time;
        }

        public final long getBeatsPerMinute() {
            return this.beatsPerMinute;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sample)) {
                return false;
            }
            Sample sample = (Sample) other;
            return Intrinsics.areEqual(this.time, sample.time) && this.beatsPerMinute == sample.beatsPerMinute;
        }

        public int hashCode() {
            return (this.time.hashCode() * 31) + Long.hashCode(this.beatsPerMinute);
        }

        public String toString() {
            return "Sample(time=" + this.time + ", beatsPerMinute=" + this.beatsPerMinute + ')';
        }
    }
}
