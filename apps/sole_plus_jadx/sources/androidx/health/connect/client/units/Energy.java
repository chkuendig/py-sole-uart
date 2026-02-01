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

/* compiled from: Energy.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001c\u001dB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\r\u0010\u001a\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001bR\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/health/connect/client/units/Energy;", "", "value", "", "type", "Landroidx/health/connect/client/units/Energy$Type;", "(DLandroidx/health/connect/client/units/Energy$Type;)V", "inCalories", "getCalories", "()D", "inJoules", "getJoules", "inKilocalories", "getKilocalories", "inKilojoules", "getKilojoules", "compareTo", "", "other", "equals", "", "", "get", "hashCode", "toString", "", "zero", "zero$connect_client_release", "Companion", "Type", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Energy implements Comparable<Energy> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Energy> ZEROS;
    private final Type type;
    private final double value;

    public /* synthetic */ Energy(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    @JvmStatic
    public static final Energy calories(double d) {
        return INSTANCE.calories(d);
    }

    @JvmStatic
    public static final Energy joules(double d) {
        return INSTANCE.joules(d);
    }

    @JvmStatic
    public static final Energy kilocalories(double d) {
        return INSTANCE.kilocalories(d);
    }

    @JvmStatic
    public static final Energy kilojoules(double d) {
        return INSTANCE.kilojoules(d);
    }

    private Energy(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    public final double getCalories() {
        return this.value * this.type.getCaloriesPerUnit();
    }

    public final double getKilocalories() {
        return get(Type.KILOCALORIES);
    }

    public final double getJoules() {
        return get(Type.JOULES);
    }

    public final double getKilojoules() {
        return get(Type.KILOJOULES);
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getCalories() / type.getCaloriesPerUnit();
    }

    public final Energy zero$connect_client_release() {
        return (Energy) MapsKt.getValue(ZEROS, this.type);
    }

    @Override // java.lang.Comparable
    public int compareTo(Energy other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getCalories(), other.getCalories());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Energy)) {
            return false;
        }
        Energy energy = (Energy) other;
        return this.type == energy.type ? this.value == energy.value : getCalories() == energy.getCalories();
    }

    public int hashCode() {
        return Double.hashCode(getCalories());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    /* compiled from: Energy.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/units/Energy$Companion;", "", "()V", "ZEROS", "", "Landroidx/health/connect/client/units/Energy$Type;", "Landroidx/health/connect/client/units/Energy;", "calories", "value", "", "joules", "kilocalories", "kilojoules", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Energy calories(double value) {
            return new Energy(value, Type.CALORIES, null);
        }

        @JvmStatic
        public final Energy kilocalories(double value) {
            return new Energy(value, Type.KILOCALORIES, null);
        }

        @JvmStatic
        public final Energy joules(double value) {
            return new Energy(value, Type.JOULES, null);
        }

        @JvmStatic
        public final Energy kilojoules(double value) {
            return new Energy(value, Type.KILOJOULES, null);
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Energy(AudioStats.AUDIO_AMPLITUDE_NONE, type));
        }
        ZEROS = linkedHashMap;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Energy.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/health/connect/client/units/Energy$Type;", "", "(Ljava/lang/String;I)V", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "CALORIES", "KILOCALORIES", "JOULES", "KILOJOULES", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Type {
        public static final Type CALORIES = new CALORIES("CALORIES", 0);
        public static final Type KILOCALORIES = new KILOCALORIES("KILOCALORIES", 1);
        public static final Type JOULES = new JOULES("JOULES", 2);
        public static final Type KILOJOULES = new KILOJOULES("KILOJOULES", 3);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CALORIES, KILOCALORIES, JOULES, KILOJOULES};
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

        public abstract double getCaloriesPerUnit();

        public abstract String getTitle();

        /* compiled from: Energy.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Energy$Type$CALORIES;", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class CALORIES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            CALORIES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 1.0d;
                this.title = "cal";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        private Type(String str, int i) {
        }

        /* compiled from: Energy.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Energy$Type$KILOCALORIES;", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class KILOCALORIES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            KILOCALORIES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 1000.0d;
                this.title = "kcal";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        /* compiled from: Energy.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Energy$Type$JOULES;", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class JOULES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            JOULES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 0.2390057361d;
                this.title = "J";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        /* compiled from: Energy.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/Energy$Type$KILOJOULES;", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class KILOJOULES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            KILOJOULES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 239.0057361d;
                this.title = "kJ";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }
    }
}
