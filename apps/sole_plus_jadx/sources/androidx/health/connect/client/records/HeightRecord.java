package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeightRecord.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Landroidx/health/connect/client/records/HeightRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "height", "Landroidx/health/connect/client/units/Length;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getHeight", "()Landroidx/health/connect/client/units/Length;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HeightRecord implements InstantaneousRecord {
    private static final String HEIGHT_FIELD_NAME = "height";
    private final Length height;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    private static final Length MAX_HEIGHT = LengthKt.getMeters(1.5E-323d);
    private static final String HEIGHT_NAME = "Height";
    public static final AggregateMetric<Length> HEIGHT_AVG = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(HEIGHT_NAME, AggregateMetric.AggregationType.AVERAGE, "height", new HeightRecord$Companion$HEIGHT_AVG$1(Length.INSTANCE));
    public static final AggregateMetric<Length> HEIGHT_MIN = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(HEIGHT_NAME, AggregateMetric.AggregationType.MINIMUM, "height", new HeightRecord$Companion$HEIGHT_MIN$1(Length.INSTANCE));
    public static final AggregateMetric<Length> HEIGHT_MAX = AggregateMetric.INSTANCE.doubleMetric$connect_client_release(HEIGHT_NAME, AggregateMetric.AggregationType.MAXIMUM, "height", new HeightRecord$Companion$HEIGHT_MAX$1(Length.INSTANCE));

    public HeightRecord(Instant time, ZoneOffset zoneOffset, Length height, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.height = height;
        this.metadata = metadata;
        UtilsKt.requireNotLess(height, height.zero$connect_client_release(), "height");
        UtilsKt.requireNotMore(height, MAX_HEIGHT, "height");
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final Length getHeight() {
        return this.height;
    }

    public /* synthetic */ HeightRecord(Instant instant, ZoneOffset zoneOffset, Length length, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, length, (i & 8) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeightRecord)) {
            return false;
        }
        HeightRecord heightRecord = (HeightRecord) other;
        return Intrinsics.areEqual(this.height, heightRecord.height) && Intrinsics.areEqual(getTime(), heightRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), heightRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), heightRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((this.height.hashCode() * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "HeightRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", height=" + this.height + ", metadata=" + getMetadata() + ')';
    }
}
