package androidx.health.connect.client.units;

import androidx.camera.video.AudioStats;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Length.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001e\u001fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\r\u0010\u001c\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001dR\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/health/connect/client/units/Length;", "", "value", "", "type", "Landroidx/health/connect/client/units/Length$Type;", "(DLandroidx/health/connect/client/units/Length$Type;)V", "inFeet", "getFeet", "()D", "inInches", "getInches", "inKilometers", "getKilometers", "inMeters", "getMeters", "inMiles", "getMiles", "compareTo", "", "other", "equals", "", "", "get", "hashCode", "toString", "", "zero", "zero$connect_client_release", "Companion", "Type", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Length implements Comparable<Length> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Length> ZEROS;
    private final Type type;
    private final double value;

    public /* synthetic */ Length(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    @JvmStatic
    public static final Length feet(double d) {
        return INSTANCE.feet(d);
    }

    @JvmStatic
    public static final Length inches(double d) {
        return INSTANCE.inches(d);
    }

    @JvmStatic
    public static final Length kilometers(double d) {
        return INSTANCE.kilometers(d);
    }

    @JvmStatic
    public static final Length meters(double d) {
        return INSTANCE.meters(d);
    }

    @JvmStatic
    public static final Length miles(double d) {
        return INSTANCE.miles(d);
    }

    private Length(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    public final double getMeters() {
        return this.value * this.type.getMetersPerUnit();
    }

    public final double getKilometers() {
        return get(Type.KILOMETERS);
    }

    public final double getMiles() {
        return get(Type.MILES);
    }

    public final double getInches() {
        return get(Type.INCHES);
    }

    public final double getFeet() {
        return get(Type.FEET);
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getMeters() / type.getMetersPerUnit();
    }

    public final Length zero$connect_client_release() {
        return (Length) MapsKt.getValue(ZEROS, this.type);
    }

    @Override // java.lang.Comparable
    public int compareTo(Length other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getMeters(), other.getMeters());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Length)) {
            return false;
        }
        Length length = (Length) other;
        return this.type == length.type ? this.value == length.value : getMeters() == length.getMeters();
    }

    public int hashCode() {
        return Double.hashCode(getMeters());
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append(this.value).append(' ');
        String lowerCase = this.type.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return sbAppend.append(lowerCase).toString();
    }

    /* compiled from: Length.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/Length$Companion;", "", "()V", "ZEROS", "", "Landroidx/health/connect/client/units/Length$Type;", "Landroidx/health/connect/client/units/Length;", "feet", "value", "", "inches", "kilometers", "meters", "miles", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Length meters(double value) {
            return new Length(value, Type.METERS, null);
        }

        @JvmStatic
        public final Length kilometers(double value) {
            return new Length(value, Type.KILOMETERS, null);
        }

        @JvmStatic
        public final Length miles(double value) {
            return new Length(value, Type.MILES, null);
        }

        @JvmStatic
        public final Length inches(double value) {
            return new Length(value, Type.INCHES, null);
        }

        @JvmStatic
        public final Length feet(double value) {
            return new Length(value, Type.FEET, null);
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Length(AudioStats.AUDIO_AMPLITUDE_NONE, type));
        }
        ZEROS = linkedHashMap;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Length.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/health/connect/client/units/Length$Type;", "", "(Ljava/lang/String;I)V", "metersPerUnit", "", "getMetersPerUnit", "()D", "METERS", "KILOMETERS", "MILES", "INCHES", "FEET", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Type {
        public static final Type METERS = new METERS("METERS", 0);
        public static final Type KILOMETERS = new KILOMETERS("KILOMETERS", 1);
        public static final Type MILES = new MILES("MILES", 2);
        public static final Type INCHES = new INCHES("INCHES", 3);
        public static final Type FEET = new FEET("FEET", 4);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{METERS, KILOMETERS, MILES, INCHES, FEET};
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

        public abstract double getMetersPerUnit();

        /* compiled from: Length.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Length$Type$METERS;", "Landroidx/health/connect/client/units/Length$Type;", "metersPerUnit", "", "getMetersPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class METERS extends Type {
            private final double metersPerUnit;

            METERS(String str, int i) {
                super(str, i, null);
                this.metersPerUnit = 1.0d;
            }

            @Override // androidx.health.connect.client.units.Length.Type
            public double getMetersPerUnit() {
                return this.metersPerUnit;
            }
        }

        private Type(String str, int i) {
        }

        /* compiled from: Length.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Length$Type$KILOMETERS;", "Landroidx/health/connect/client/units/Length$Type;", "metersPerUnit", "", "getMetersPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class KILOMETERS extends Type {
            private final double metersPerUnit;

            KILOMETERS(String str, int i) {
                super(str, i, null);
                this.metersPerUnit = 1000.0d;
            }

            @Override // androidx.health.connect.client.units.Length.Type
            public double getMetersPerUnit() {
                return this.metersPerUnit;
            }
        }

        /* compiled from: Length.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Length$Type$MILES;", "Landroidx/health/connect/client/units/Length$Type;", "metersPerUnit", "", "getMetersPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class MILES extends Type {
            private final double metersPerUnit;

            MILES(String str, int i) {
                super(str, i, null);
                this.metersPerUnit = 1609.34d;
            }

            @Override // androidx.health.connect.client.units.Length.Type
            public double getMetersPerUnit() {
                return this.metersPerUnit;
            }
        }

        /* compiled from: Length.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Length$Type$INCHES;", "Landroidx/health/connect/client/units/Length$Type;", "metersPerUnit", "", "getMetersPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class INCHES extends Type {
            private final double metersPerUnit;

            INCHES(String str, int i) {
                super(str, i, null);
                this.metersPerUnit = 0.0254d;
            }

            @Override // androidx.health.connect.client.units.Length.Type
            public double getMetersPerUnit() {
                return this.metersPerUnit;
            }
        }

        /* compiled from: Length.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Length$Type$FEET;", "Landroidx/health/connect/client/units/Length$Type;", "metersPerUnit", "", "getMetersPerUnit", "()D", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class FEET extends Type {
            private final double metersPerUnit;

            FEET(String str, int i) {
                super(str, i, null);
                this.metersPerUnit = 0.3048d;
            }

            @Override // androidx.health.connect.client.units.Length.Type
            public double getMetersPerUnit() {
                return this.metersPerUnit;
            }
        }
    }
}
