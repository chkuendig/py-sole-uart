package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Percentage;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OxygenSaturationRecord.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/health/connect/client/records/OxygenSaturationRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "percentage", "Landroidx/health/connect/client/units/Percentage;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Percentage;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getPercentage", "()Landroidx/health/connect/client/units/Percentage;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OxygenSaturationRecord implements InstantaneousRecord {
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Percentage percentage;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public OxygenSaturationRecord(Instant time, ZoneOffset zoneOffset, Percentage percentage, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.percentage = percentage;
        this.metadata = metadata;
        UtilsKt.requireNonNegative(percentage.getValue(), "percentage");
        UtilsKt.requireNotMore(Double.valueOf(percentage.getValue()), Double.valueOf(100.0d), "percentage");
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Percentage getPercentage() {
        return this.percentage;
    }

    public /* synthetic */ OxygenSaturationRecord(Instant instant, ZoneOffset zoneOffset, Percentage percentage, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, percentage, (i & 8) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OxygenSaturationRecord)) {
            return false;
        }
        OxygenSaturationRecord oxygenSaturationRecord = (OxygenSaturationRecord) other;
        return Intrinsics.areEqual(this.percentage, oxygenSaturationRecord.percentage) && Intrinsics.areEqual(getTime(), oxygenSaturationRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), oxygenSaturationRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), oxygenSaturationRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((this.percentage.hashCode() * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "OxygenSaturationRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", percentage=" + this.percentage + ", metadata=" + getMetadata() + ')';
    }
}
