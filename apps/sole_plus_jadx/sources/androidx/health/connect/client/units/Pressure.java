package androidx.health.connect.client.units;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pressure.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\r\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0012R\u0011\u0010\u0005\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/health/connect/client/units/Pressure;", "", "value", "", "(D)V", "inMillimetersOfMercury", "getMillimetersOfMercury", "()D", "compareTo", "", "other", "equals", "", "", "hashCode", "toString", "", "zero", "zero$connect_client_release", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Pressure implements Comparable<Pressure> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pressure ZERO = new Pressure(AudioStats.AUDIO_AMPLITUDE_NONE);
    private final double value;

    public /* synthetic */ Pressure(double d, DefaultConstructorMarker defaultConstructorMarker) {
        this(d);
    }

    @JvmStatic
    public static final Pressure millimetersOfMercury(double d) {
        return INSTANCE.millimetersOfMercury(d);
    }

    private Pressure(double d) {
        this.value = d;
    }

    /* renamed from: getMillimetersOfMercury, reason: from getter */
    public final double getValue() {
        return this.value;
    }

    public final Pressure zero$connect_client_release() {
        return ZERO;
    }

    @Override // java.lang.Comparable
    public int compareTo(Pressure other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Double.compare(this.value, other.value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Pressure) && this.value == ((Pressure) other).value;
    }

    public int hashCode() {
        return Double.hashCode(this.value);
    }

    public String toString() {
        return this.value + " mmHg";
    }

    /* compiled from: Pressure.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/health/connect/client/units/Pressure$Companion;", "", "()V", "ZERO", "Landroidx/health/connect/client/units/Pressure;", "millimetersOfMercury", "value", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Pressure millimetersOfMercury(double value) {
            return new Pressure(value, null);
        }
    }
}
