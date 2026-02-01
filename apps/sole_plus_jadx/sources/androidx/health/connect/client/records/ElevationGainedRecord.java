package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ElevationGainedRecord.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/health/connect/client/records/ElevationGainedRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", SDKConstants.PARAM_END_TIME, "endZoneOffset", "elevation", "Landroidx/health/connect/client/units/Length;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getElevation", "()Landroidx/health/connect/client/units/Length;", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getStartTime", "getStartZoneOffset", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ElevationGainedRecord implements IntervalRecord {
    private final Length elevation;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private static final Length MAX_ELEVATION_GAIN = LengthKt.getMeters(4.940656E-318d);
    private static final Length MIN_ELEVATION_GAIN = LengthKt.getMeters(Double.NaN);
    public static final AggregateMetric<Length> ELEVATION_GAINED_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release("ElevationGained", AggregateMetric.AggregationType.TOTAL, "elevation", new ElevationGainedRecord$Companion$ELEVATION_GAINED_TOTAL$1(Length.INSTANCE));

    public ElevationGainedRecord(Instant startTime, ZoneOffset zoneOffset, Instant endTime, ZoneOffset zoneOffset2, Length elevation, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(elevation, "elevation");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = zoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = zoneOffset2;
        this.elevation = elevation;
        this.metadata = metadata;
        UtilsKt.requireNotLess(elevation, MIN_ELEVATION_GAIN, "elevation");
        UtilsKt.requireNotMore(elevation, MAX_ELEVATION_GAIN, "elevation");
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
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

    public final Length getElevation() {
        return this.elevation;
    }

    public /* synthetic */ ElevationGainedRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, Length length, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, length, (i & 32) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ElevationGainedRecord)) {
            return false;
        }
        ElevationGainedRecord elevationGainedRecord = (ElevationGainedRecord) other;
        return Intrinsics.areEqual(this.elevation, elevationGainedRecord.elevation) && Intrinsics.areEqual(getStartTime(), elevationGainedRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), elevationGainedRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), elevationGainedRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), elevationGainedRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), elevationGainedRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((this.elevation.hashCode() * 31) + getStartTime().hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (((iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "ElevationGainedRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", elevation=" + this.elevation + ", metadata=" + getMetadata() + ')';
    }
}
