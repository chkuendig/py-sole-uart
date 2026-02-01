package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Temperature;
import androidx.health.connect.client.units.TemperatureDelta;
import androidx.health.connect.client.units.TemperatureKt;
import com.android.SdkConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkinTemperatureRecord.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002'(BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020&H\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006)"}, d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", SDKConstants.PARAM_END_TIME, "endZoneOffset", "deltas", "", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", SdkConstants.FlowAlignment.BASELINE, "Landroidx/health/connect/client/units/Temperature;", "measurementLocation", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/util/List;Landroidx/health/connect/client/units/Temperature;ILandroidx/health/connect/client/records/metadata/Metadata;)V", "getBaseline", "()Landroidx/health/connect/client/units/Temperature;", "getDeltas", "()Ljava/util/List;", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMeasurementLocation", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getStartTime", "getStartZoneOffset", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "Delta", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SkinTemperatureRecord implements IntervalRecord {
    public static final int MEASUREMENT_LOCATION_FINGER = 1;
    public static final Map<Integer, String> MEASUREMENT_LOCATION_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MEASUREMENT_LOCATION_STRING_TO_INT_MAP;
    public static final int MEASUREMENT_LOCATION_TOE = 2;
    public static final int MEASUREMENT_LOCATION_UNKNOWN = 0;
    public static final int MEASUREMENT_LOCATION_WRIST = 3;
    private final Temperature baseline;
    private final List<Delta> deltas;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private static final Temperature MIN_TEMPERATURE = TemperatureKt.getCelsius(0.0d);
    private static final Temperature MAX_TEMPERATURE = TemperatureKt.getCelsius(4.94E-322d);

    public SkinTemperatureRecord(Instant startTime, ZoneOffset zoneOffset, Instant endTime, ZoneOffset zoneOffset2, List<Delta> deltas, Temperature temperature, int i, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(deltas, "deltas");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = zoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = zoneOffset2;
        this.deltas = deltas;
        this.baseline = temperature;
        this.measurementLocation = i;
        this.metadata = metadata;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (temperature != null) {
            UtilsKt.requireNotLess(temperature, MIN_TEMPERATURE, "temperature");
            UtilsKt.requireNotMore(temperature, MAX_TEMPERATURE, "temperature");
        }
        if (deltas.isEmpty()) {
            return;
        }
        Iterator<T> it = deltas.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            Instant time = ((Delta) next).getTime();
            do {
                Object next2 = it.next();
                Instant time2 = ((Delta) next2).getTime();
                if (time.compareTo(time2) > 0) {
                    next = next2;
                    time = time2;
                }
            } while (it.hasNext());
        }
        if (((Delta) next).getTime().isBefore(getStartTime())) {
            throw new IllegalArgumentException("segments can not be out of parent time range.".toString());
        }
        Iterator<T> it2 = this.deltas.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next3 = it2.next();
        if (it2.hasNext()) {
            Instant time3 = ((Delta) next3).getTime();
            do {
                Object next4 = it2.next();
                Instant time4 = ((Delta) next4).getTime();
                if (time3.compareTo(time4) < 0) {
                    next3 = next4;
                    time3 = time4;
                }
            } while (it2.hasNext());
        }
        if (!((Delta) next3).getTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("segments can not be out of parent time range.".toString());
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

    public final List<Delta> getDeltas() {
        return this.deltas;
    }

    public final Temperature getBaseline() {
        return this.baseline;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    public /* synthetic */ SkinTemperatureRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, List list, Temperature temperature, int i, androidx.health.connect.client.records.metadata.Metadata metadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, list, (i2 & 32) != 0 ? null : temperature, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinTemperatureRecord)) {
            return false;
        }
        SkinTemperatureRecord skinTemperatureRecord = (SkinTemperatureRecord) other;
        return Intrinsics.areEqual(getStartTime(), skinTemperatureRecord.getStartTime()) && Intrinsics.areEqual(getEndTime(), skinTemperatureRecord.getEndTime()) && Intrinsics.areEqual(getStartZoneOffset(), skinTemperatureRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndZoneOffset(), skinTemperatureRecord.getEndZoneOffset()) && Intrinsics.areEqual(this.baseline, skinTemperatureRecord.baseline) && this.measurementLocation == skinTemperatureRecord.measurementLocation && Intrinsics.areEqual(this.deltas, skinTemperatureRecord.deltas) && Intrinsics.areEqual(getMetadata(), skinTemperatureRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((getStartTime().hashCode() * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int iHashCode3 = (iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31;
        Temperature temperature = this.baseline;
        return ((((((iHashCode3 + (temperature != null ? temperature.hashCode() : 0)) * 31) + Integer.hashCode(this.measurementLocation)) * 31) + this.deltas.hashCode()) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "SkinTemperatureRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", deltas=" + this.deltas + ", baseline=" + this.baseline + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to(BodyTemperatureMeasurementLocation.FINGER, 1), TuplesKt.to(BodyTemperatureMeasurementLocation.TOE, 2), TuplesKt.to(BodyTemperatureMeasurementLocation.WRIST, 3));
        MEASUREMENT_LOCATION_STRING_TO_INT_MAP = mapMapOf;
        MEASUREMENT_LOCATION_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }

    /* compiled from: SkinTemperatureRecord.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "", "time", "Ljava/time/Instant;", "delta", "Landroidx/health/connect/client/units/TemperatureDelta;", "(Ljava/time/Instant;Landroidx/health/connect/client/units/TemperatureDelta;)V", "getDelta", "()Landroidx/health/connect/client/units/TemperatureDelta;", "getTime", "()Ljava/time/Instant;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Delta {
        private final TemperatureDelta delta;
        private final Instant time;
        private static final Companion Companion = new Companion(null);
        private static final TemperatureDelta MIN_DELTA_TEMPERATURE = TemperatureDelta.INSTANCE.celsius(-30.0d);
        private static final TemperatureDelta MAX_DELTA_TEMPERATURE = TemperatureDelta.INSTANCE.celsius(30.0d);

        public Delta(Instant time, TemperatureDelta delta) {
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(delta, "delta");
            this.time = time;
            this.delta = delta;
            UtilsKt.requireNotLess(delta, MIN_DELTA_TEMPERATURE, "delta");
            UtilsKt.requireNotMore(delta, MAX_DELTA_TEMPERATURE, "delta");
        }

        public final TemperatureDelta getDelta() {
            return this.delta;
        }

        public final Instant getTime() {
            return this.time;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.records.SkinTemperatureRecord.Delta");
            Delta delta = (Delta) other;
            return Intrinsics.areEqual(this.time, delta.time) && Intrinsics.areEqual(this.delta, delta.delta);
        }

        public int hashCode() {
            return (this.time.hashCode() * 31) + this.delta.hashCode();
        }

        public String toString() {
            return "Delta(time=" + this.time + ", delta=" + this.delta + ')';
        }

        /* compiled from: SkinTemperatureRecord.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta$Companion;", "", "()V", "MAX_DELTA_TEMPERATURE", "Landroidx/health/connect/client/units/TemperatureDelta;", "MIN_DELTA_TEMPERATURE", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
