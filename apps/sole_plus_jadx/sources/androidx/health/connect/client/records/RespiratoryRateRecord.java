package androidx.health.connect.client.records;

import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RespiratoryRateRecord.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/health/connect/client/records/RespiratoryRateRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "rate", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;DLandroidx/health/connect/client/records/metadata/Metadata;)V", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getRate", "()D", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RespiratoryRateRecord implements InstantaneousRecord {
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final double rate;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public RespiratoryRateRecord(Instant time, ZoneOffset zoneOffset, double d, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.rate = d;
        this.metadata = metadata;
        UtilsKt.requireNonNegative(d, "rate");
        UtilsKt.requireNotMore(Double.valueOf(d), Double.valueOf(1000.0d), "rate");
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final double getRate() {
        return this.rate;
    }

    public /* synthetic */ RespiratoryRateRecord(Instant instant, ZoneOffset zoneOffset, double d, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, d, (i & 8) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RespiratoryRateRecord)) {
            return false;
        }
        RespiratoryRateRecord respiratoryRateRecord = (RespiratoryRateRecord) other;
        return this.rate == respiratoryRateRecord.rate && Intrinsics.areEqual(getTime(), respiratoryRateRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), respiratoryRateRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), respiratoryRateRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((Double.hashCode(this.rate) * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "RespiratoryRateRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", rate=" + this.rate + ", metadata=" + getMetadata() + ')';
    }
}
