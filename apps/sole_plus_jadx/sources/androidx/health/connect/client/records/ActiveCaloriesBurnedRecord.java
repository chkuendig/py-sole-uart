package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.EnergyKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveCaloriesBurnedRecord.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006 "}, d2 = {"Landroidx/health/connect/client/records/ActiveCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", SDKConstants.PARAM_END_TIME, "endZoneOffset", ActiveCaloriesBurnedRecord.ENERGY_FIELD_NAME, "Landroidx/health/connect/client/units/Energy;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Energy;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getEnergy", "()Landroidx/health/connect/client/units/Energy;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getStartTime", "getStartZoneOffset", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ActiveCaloriesBurnedRecord implements IntervalRecord {
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final Energy energy;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private static final Energy MAX_ENERGY = EnergyKt.getKilocalories(4.940656E-318d);
    private static final String TYPE_NAME = "ActiveCaloriesBurned";
    private static final String ENERGY_FIELD_NAME = "energy";
    public static final AggregateMetric<Energy> ACTIVE_CALORIES_TOTAL = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(TYPE_NAME, AggregateMetric.AggregationType.TOTAL, ENERGY_FIELD_NAME, new ActiveCaloriesBurnedRecord$Companion$ACTIVE_CALORIES_TOTAL$1(Energy.INSTANCE));

    public ActiveCaloriesBurnedRecord(Instant startTime, ZoneOffset zoneOffset, Instant endTime, ZoneOffset zoneOffset2, Energy energy, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(energy, "energy");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = zoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = zoneOffset2;
        this.energy = energy;
        this.metadata = metadata;
        UtilsKt.requireNotLess(energy, energy.zero$connect_client_release(), ENERGY_FIELD_NAME);
        UtilsKt.requireNotMore(energy, MAX_ENERGY, ENERGY_FIELD_NAME);
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

    public final Energy getEnergy() {
        return this.energy;
    }

    public /* synthetic */ ActiveCaloriesBurnedRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, Energy energy, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, energy, (i & 32) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveCaloriesBurnedRecord)) {
            return false;
        }
        ActiveCaloriesBurnedRecord activeCaloriesBurnedRecord = (ActiveCaloriesBurnedRecord) other;
        return Intrinsics.areEqual(this.energy, activeCaloriesBurnedRecord.energy) && Intrinsics.areEqual(getStartTime(), activeCaloriesBurnedRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), activeCaloriesBurnedRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), activeCaloriesBurnedRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), activeCaloriesBurnedRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), activeCaloriesBurnedRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((this.energy.hashCode() * 31) + getStartTime().hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (((iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "ActiveCaloriesBurnedRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", energy=" + this.energy + ", metadata=" + getMetadata() + ')';
    }
}
