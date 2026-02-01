package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Temperature;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyTemperatureRecord.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0017\u0010\b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/health/connect/client/records/BodyTemperatureRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "temperature", "Landroidx/health/connect/client/units/Temperature;", "measurementLocation", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Temperature;ILandroidx/health/connect/client/records/metadata/Metadata;)V", "getMeasurementLocation$annotations", "()V", "getMeasurementLocation", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTemperature", "()Landroidx/health/connect/client/units/Temperature;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BodyTemperatureRecord implements InstantaneousRecord {
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Temperature temperature;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    public static /* synthetic */ void getMeasurementLocation$annotations() {
    }

    public BodyTemperatureRecord(Instant time, ZoneOffset zoneOffset, Temperature temperature, int i, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.temperature = temperature;
        this.measurementLocation = i;
        this.metadata = metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Temperature getTemperature() {
        return this.temperature;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    public /* synthetic */ BodyTemperatureRecord(Instant instant, ZoneOffset zoneOffset, Temperature temperature, int i, androidx.health.connect.client.records.metadata.Metadata metadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, temperature, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BodyTemperatureRecord)) {
            return false;
        }
        BodyTemperatureRecord bodyTemperatureRecord = (BodyTemperatureRecord) other;
        return Intrinsics.areEqual(this.temperature, bodyTemperatureRecord.temperature) && this.measurementLocation == bodyTemperatureRecord.measurementLocation && Intrinsics.areEqual(getTime(), bodyTemperatureRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), bodyTemperatureRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), bodyTemperatureRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((((this.temperature.hashCode() * 31) + this.measurementLocation) * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BodyTemperatureRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", temperature=" + this.temperature + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }
}
