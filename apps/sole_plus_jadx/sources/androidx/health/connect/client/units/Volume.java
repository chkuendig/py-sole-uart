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

/* compiled from: Volume.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001a\u001bB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\r\u0010\u0018\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0019R\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/health/connect/client/units/Volume;", "", "value", "", "type", "Landroidx/health/connect/client/units/Volume$Type;", "(DLandroidx/health/connect/client/units/Volume$Type;)V", "inFluidOuncesUs", "getFluidOuncesUs", "()D", "inLiters", "getLiters", "inMilliliters", "getMilliliters", "compareTo", "", "other", "equals", "", "", "get", "hashCode", "toString", "", "zero", "zero$connect_client_release", "Companion", "Type", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Volume implements Comparable<Volume> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Volume> ZEROS;
    private final Type type;
    private final double value;

    public /* synthetic */ Volume(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    @JvmStatic
    public static final Volume fluidOuncesUs(double d) {
        return INSTANCE.fluidOuncesUs(d);
    }

    @JvmStatic
    public static final Volume liters(double d) {
        return INSTANCE.liters(d);
    }

    @JvmStatic
    public static final Volume milliliters(double d) {
        return INSTANCE.milliliters(d);
    }

    private Volume(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    public final double getLiters() {
        return this.value * this.type.getLitersPerUnit();
    }

    public final double getMilliliters() {
        return get(Type.MILLILITERS);
    }

    public final double getFluidOuncesUs() {
        return get(Type.FLUID_OUNCES_US);
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getLiters() / type.getLitersPerUnit();
    }

    public final Volume zero$connect_client_release() {
        return (Volume) MapsKt.getValue(ZEROS, this.type);
    }

    @Override // java.lang.Comparable
    public int compareTo(Volume other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getLiters(), other.getLiters());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Volume)) {
            return false;
        }
        Volume volume = (Volume) other;
        return this.type == volume.type ? this.value == volume.value : getLiters() == volume.getLiters();
    }

    public int hashCode() {
        return Double.hashCode(getLiters());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    /* compiled from: Volume.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/health/connect/client/units/Volume$Companion;", "", "()V", "ZEROS", "", "Landroidx/health/connect/client/units/Volume$Type;", "Landroidx/health/connect/client/units/Volume;", "fluidOuncesUs", "value", "", "liters", "milliliters", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Volume liters(double value) {
            return new Volume(value, Type.LITERS, null);
        }

        @JvmStatic
        public final Volume milliliters(double value) {
            return new Volume(value, Type.MILLILITERS, null);
        }

        @JvmStatic
        public final Volume fluidOuncesUs(double value) {
            return new Volume(value, Type.FLUID_OUNCES_US, null);
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Volume(AudioStats.AUDIO_AMPLITUDE_NONE, type));
        }
        ZEROS = linkedHashMap;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Volume.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/Volume$Type;", "", "(Ljava/lang/String;I)V", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "LITERS", "MILLILITERS", "FLUID_OUNCES_US", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Type {
        public static final Type LITERS = new LITERS("LITERS", 0);
        public static final Type MILLILITERS = new MILLILITERS("MILLILITERS", 1);
        public static final Type FLUID_OUNCES_US = new FLUID_OUNCES_US("FLUID_OUNCES_US", 2);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{LITERS, MILLILITERS, FLUID_OUNCES_US};
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

        public abstract double getLitersPerUnit();

        public abstract String getTitle();

        /* compiled from: Volume.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Volume$Type$LITERS;", "Landroidx/health/connect/client/units/Volume$Type;", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class LITERS extends Type {
            private final double litersPerUnit;
            private final String title;

            LITERS(String str, int i) {
                super(str, i, null);
                this.litersPerUnit = 1.0d;
                this.title = "L";
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public double getLitersPerUnit() {
                return this.litersPerUnit;
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public String getTitle() {
                return this.title;
            }
        }

        private Type(String str, int i) {
        }

        /* compiled from: Volume.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Volume$Type$MILLILITERS;", "Landroidx/health/connect/client/units/Volume$Type;", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class MILLILITERS extends Type {
            private final double litersPerUnit;
            private final String title;

            MILLILITERS(String str, int i) {
                super(str, i, null);
                this.litersPerUnit = 0.001d;
                this.title = "mL";
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public double getLitersPerUnit() {
                return this.litersPerUnit;
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public String getTitle() {
                return this.title;
            }
        }

        /* compiled from: Volume.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Volume$Type$FLUID_OUNCES_US;", "Landroidx/health/connect/client/units/Volume$Type;", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class FLUID_OUNCES_US extends Type {
            private final double litersPerUnit;
            private final String title;

            FLUID_OUNCES_US(String str, int i) {
                super(str, i, null);
                this.litersPerUnit = 0.02957353d;
                this.title = "fl. oz (US)";
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public double getLitersPerUnit() {
                return this.litersPerUnit;
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public String getTitle() {
                return this.title;
            }
        }
    }
}
