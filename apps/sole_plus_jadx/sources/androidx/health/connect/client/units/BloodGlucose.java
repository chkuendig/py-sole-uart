package androidx.health.connect.client.units;

import androidx.camera.video.AudioStats;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: BloodGlucose.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0018\u0019B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\r\u0010\u0016\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0017R\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose;", "", "value", "", "type", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "(DLandroidx/health/connect/client/units/BloodGlucose$Type;)V", "inMilligramsPerDeciliter", "getMilligramsPerDeciliter", "()D", "inMillimolesPerLiter", "getMillimolesPerLiter", "compareTo", "", "other", "equals", "", "", "get", "hashCode", "toString", "", "zero", "zero$connect_client_release", "Companion", "Type", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BloodGlucose implements Comparable<BloodGlucose> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, BloodGlucose> ZEROS;
    private final Type type;
    private final double value;

    public /* synthetic */ BloodGlucose(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    @JvmStatic
    public static final BloodGlucose milligramsPerDeciliter(double d) {
        return INSTANCE.milligramsPerDeciliter(d);
    }

    @JvmStatic
    public static final BloodGlucose millimolesPerLiter(double d) {
        return INSTANCE.millimolesPerLiter(d);
    }

    private BloodGlucose(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    public final double getMillimolesPerLiter() {
        return this.value * this.type.getMillimolesPerLiterPerUnit();
    }

    public final double getMilligramsPerDeciliter() {
        return get(Type.MILLIGRAMS_PER_DECILITER);
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getMillimolesPerLiter() / type.getMillimolesPerLiterPerUnit();
    }

    public final BloodGlucose zero$connect_client_release() {
        return (BloodGlucose) MapsKt.getValue(ZEROS, this.type);
    }

    @Override // java.lang.Comparable
    public int compareTo(BloodGlucose other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getMillimolesPerLiter(), other.getMillimolesPerLiter());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BloodGlucose)) {
            return false;
        }
        BloodGlucose bloodGlucose = (BloodGlucose) other;
        return this.type == bloodGlucose.type ? this.value == bloodGlucose.value : getMillimolesPerLiter() == bloodGlucose.getMillimolesPerLiter();
    }

    public int hashCode() {
        return Double.hashCode(getMillimolesPerLiter());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    /* compiled from: BloodGlucose.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose$Companion;", "", "()V", "ZEROS", "", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "Landroidx/health/connect/client/units/BloodGlucose;", "milligramsPerDeciliter", "value", "", "millimolesPerLiter", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BloodGlucose millimolesPerLiter(double value) {
            return new BloodGlucose(value, Type.MILLIMOLES_PER_LITER, null);
        }

        @JvmStatic
        public final BloodGlucose milligramsPerDeciliter(double value) {
            return new BloodGlucose(value, Type.MILLIGRAMS_PER_DECILITER, null);
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new BloodGlucose(AudioStats.AUDIO_AMPLITUDE_NONE, type));
        }
        ZEROS = linkedHashMap;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BloodGlucose.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose$Type;", "", "(Ljava/lang/String;I)V", "millimolesPerLiterPerUnit", "", "getMillimolesPerLiterPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "MILLIMOLES_PER_LITER", "MILLIGRAMS_PER_DECILITER", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Type {
        public static final Type MILLIMOLES_PER_LITER = new MILLIMOLES_PER_LITER("MILLIMOLES_PER_LITER", 0);
        public static final Type MILLIGRAMS_PER_DECILITER = new MILLIGRAMS_PER_DECILITER("MILLIGRAMS_PER_DECILITER", 1);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{MILLIMOLES_PER_LITER, MILLIGRAMS_PER_DECILITER};
        }

        public /* synthetic */ Type(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public abstract double getMillimolesPerLiterPerUnit();

        public abstract String getTitle();

        /* compiled from: BloodGlucose.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose$Type$MILLIMOLES_PER_LITER;", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "millimolesPerLiterPerUnit", "", "getMillimolesPerLiterPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class MILLIMOLES_PER_LITER extends Type {
            private final double millimolesPerLiterPerUnit;

            MILLIMOLES_PER_LITER(String str, int i) {
                super(str, i, null);
                this.millimolesPerLiterPerUnit = 1.0d;
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public double getMillimolesPerLiterPerUnit() {
                return this.millimolesPerLiterPerUnit;
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public String getTitle() {
                return "mmol/L";
            }
        }

        private Type(String str, int i) {
        }

        /* compiled from: BloodGlucose.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose$Type$MILLIGRAMS_PER_DECILITER;", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "millimolesPerLiterPerUnit", "", "getMillimolesPerLiterPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class MILLIGRAMS_PER_DECILITER extends Type {
            private final double millimolesPerLiterPerUnit;
            private final String title;

            MILLIGRAMS_PER_DECILITER(String str, int i) {
                super(str, i, null);
                this.millimolesPerLiterPerUnit = 0.05555555555555555d;
                this.title = "mg/dL";
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public double getMillimolesPerLiterPerUnit() {
                return this.millimolesPerLiterPerUnit;
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public String getTitle() {
                return this.title;
            }
        }
    }
}
