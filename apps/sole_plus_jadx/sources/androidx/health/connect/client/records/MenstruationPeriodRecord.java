package androidx.health.connect.client.records;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MenstruationPeriodRecord.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/health/connect/client/records/MenstruationPeriodRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", SDKConstants.PARAM_END_TIME, "endZoneOffset", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getStartTime", "getStartZoneOffset", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MenstruationPeriodRecord implements IntervalRecord {
    private static final Companion Companion = new Companion(null);
    private static final Duration MAX_DURATION = Duration.ofDays(31);
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;

    public MenstruationPeriodRecord(Instant startTime, ZoneOffset zoneOffset, Instant endTime, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = zoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (Duration.between(getStartTime(), getEndTime()).compareTo(MAX_DURATION) > 0) {
            throw new IllegalArgumentException("Period must not exceed 31 days".toString());
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

    public /* synthetic */ MenstruationPeriodRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, (i & 16) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenstruationPeriodRecord)) {
            return false;
        }
        MenstruationPeriodRecord menstruationPeriodRecord = (MenstruationPeriodRecord) other;
        return Intrinsics.areEqual(getStartTime(), menstruationPeriodRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), menstruationPeriodRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), menstruationPeriodRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), menstruationPeriodRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), menstruationPeriodRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = getStartTime().hashCode() * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (((iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "MenstruationPeriodRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", metadata=" + getMetadata() + ')';
    }

    /* compiled from: MenstruationPeriodRecord.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/records/MenstruationPeriodRecord$Companion;", "", "()V", "MAX_DURATION", "Ljava/time/Duration;", "kotlin.jvm.PlatformType", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
