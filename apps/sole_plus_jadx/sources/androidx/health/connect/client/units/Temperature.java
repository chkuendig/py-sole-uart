package androidx.health.connect.client.units;

import androidx.core.text.util.LocalePreferences;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Temperature.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0015\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/health/connect/client/units/Temperature;", "", "value", "", "type", "Landroidx/health/connect/client/units/Temperature$Type;", "(DLandroidx/health/connect/client/units/Temperature$Type;)V", "inCelsius", "getCelsius", "()D", "inFahrenheit", "getFahrenheit", "compareTo", "", "other", "equals", "", "", "hashCode", "toString", "", "Companion", "Type", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Temperature implements Comparable<Temperature> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Type type;
    private final double value;

    /* compiled from: Temperature.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.CELSIUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.FAHRENHEIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ Temperature(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }

    @JvmStatic
    public static final Temperature celsius(double d) {
        return INSTANCE.celsius(d);
    }

    @JvmStatic
    public static final Temperature fahrenheit(double d) {
        return INSTANCE.fahrenheit(d);
    }

    private Temperature(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    public final double getCelsius() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i == 1) {
            return this.value;
        }
        if (i == 2) {
            return (this.value - 32.0d) / 1.8d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final double getFahrenheit() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i == 1) {
            return (this.value * 1.8d) + 32.0d;
        }
        if (i == 2) {
            return this.value;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // java.lang.Comparable
    public int compareTo(Temperature other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.type == other.type) {
            return Double.compare(this.value, other.value);
        }
        return Double.compare(getCelsius(), other.getCelsius());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Temperature)) {
            return false;
        }
        Temperature temperature = (Temperature) other;
        return this.type == temperature.type ? this.value == temperature.value : getCelsius() == temperature.getCelsius();
    }

    public int hashCode() {
        return Double.hashCode(getCelsius());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    /* compiled from: Temperature.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/health/connect/client/units/Temperature$Companion;", "", "()V", LocalePreferences.TemperatureUnit.CELSIUS, "Landroidx/health/connect/client/units/Temperature;", "value", "", "fahrenheit", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Temperature celsius(double value) {
            return new Temperature(value, Type.CELSIUS, null);
        }

        @JvmStatic
        public final Temperature fahrenheit(double value) {
            return new Temperature(value, Type.FAHRENHEIT, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Temperature.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/units/Temperature$Type;", "", "(Ljava/lang/String;I)V", "title", "", "getTitle", "()Ljava/lang/String;", "CELSIUS", "FAHRENHEIT", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Type {
        public static final Type CELSIUS = new CELSIUS("CELSIUS", 0);
        public static final Type FAHRENHEIT = new FAHRENHEIT("FAHRENHEIT", 1);
        private static final /* synthetic */ Type[] $VALUES = $values();

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CELSIUS, FAHRENHEIT};
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

        public abstract String getTitle();

        /* compiled from: Temperature.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Temperature$Type$CELSIUS;", "Landroidx/health/connect/client/units/Temperature$Type;", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class CELSIUS extends Type {
            private final String title;

            CELSIUS(String str, int i) {
                super(str, i, null);
                this.title = "Celsius";
            }

            @Override // androidx.health.connect.client.units.Temperature.Type
            public String getTitle() {
                return this.title;
            }
        }

        private Type(String str, int i) {
        }

        /* compiled from: Temperature.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/units/Temperature$Type$FAHRENHEIT;", "Landroidx/health/connect/client/units/Temperature$Type;", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class FAHRENHEIT extends Type {
            private final String title;

            FAHRENHEIT(String str, int i) {
                super(str, i, null);
                this.title = "Fahrenheit";
            }

            @Override // androidx.health.connect.client.units.Temperature.Type
            public String getTitle() {
                return this.title;
            }
        }
    }
}
