package com.soletreadmills.sole_v2._type;

import com.android.SdkConstants;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._tools.TimeTools;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ConnectProgramSettingsType.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/ConnectProgramSettingsType;", "", "displayName", "", "(Ljava/lang/String;II)V", SdkConstants.PreferenceAttributes.ATTR_DEFAULT_VALUE, "", "getDefaultValue", "()D", "getDisplayName", "()I", "maxValue", "getMaxValue", "minValue", "getMinValue", "step", "getStep", HealthConstants.FoodIntake.UNIT, "", "getUnit", "()Ljava/lang/String;", "displayValue", "currentValue", "MaxSpeed", "MaxResistance", "TargetTime", "TargetCalories", "TargetSpeed", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectProgramSettingsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ConnectProgramSettingsType[] $VALUES;
    private final int displayName;
    public static final ConnectProgramSettingsType MaxSpeed = new ConnectProgramSettingsType("MaxSpeed", 0, R.string.max_speed);
    public static final ConnectProgramSettingsType MaxResistance = new ConnectProgramSettingsType("MaxResistance", 1, R.string.max_resistance);
    public static final ConnectProgramSettingsType TargetTime = new ConnectProgramSettingsType("TargetTime", 2, R.string.target_time);
    public static final ConnectProgramSettingsType TargetCalories = new ConnectProgramSettingsType("TargetCalories", 3, R.string.calories);
    public static final ConnectProgramSettingsType TargetSpeed = new ConnectProgramSettingsType("TargetSpeed", 4, R.string.target_speed);

    /* compiled from: ConnectProgramSettingsType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConnectProgramSettingsType.values().length];
            try {
                iArr[ConnectProgramSettingsType.MaxSpeed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConnectProgramSettingsType.MaxResistance.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConnectProgramSettingsType.TargetSpeed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConnectProgramSettingsType.TargetCalories.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConnectProgramSettingsType.TargetTime.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ConnectProgramSettingsType[] $values() {
        return new ConnectProgramSettingsType[]{MaxSpeed, MaxResistance, TargetTime, TargetCalories, TargetSpeed};
    }

    public static EnumEntries<ConnectProgramSettingsType> getEntries() {
        return $ENTRIES;
    }

    public static ConnectProgramSettingsType valueOf(String str) {
        return (ConnectProgramSettingsType) Enum.valueOf(ConnectProgramSettingsType.class, str);
    }

    public static ConnectProgramSettingsType[] values() {
        return (ConnectProgramSettingsType[]) $VALUES.clone();
    }

    private ConnectProgramSettingsType(String str, int i, int i2) {
        this.displayName = i2;
    }

    public final int getDisplayName() {
        return this.displayName;
    }

    static {
        ConnectProgramSettingsType[] connectProgramSettingsTypeArr$values = $values();
        $VALUES = connectProgramSettingsTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(connectProgramSettingsTypeArr$values);
    }

    public final double getDefaultValue() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return getMinValue();
        }
        if (i == 5) {
            return 20.0d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final double getMinValue() {
        boolean unitType = Global.INSTANCE.getUnitType();
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return !unitType ? 5.0d : 3.0d;
        }
        if (i == 2) {
            return 1.0d;
        }
        if (i == 3) {
            return !unitType ? 1.0d : 0.5d;
        }
        if (i == 4) {
            return 1.0d;
        }
        if (i == 5) {
            return 10.0d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final double getMaxValue() {
        boolean unitType = Global.INSTANCE.getUnitType();
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 20.0d;
            }
            if (i != 3) {
                if (i == 4) {
                    return 9999.0d;
                }
                if (i == 5) {
                    return 99.0d;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (!unitType) {
                return 22.0d;
            }
        } else if (!unitType) {
            return 22.0d;
        }
        return 12.0d;
    }

    public final String displayValue(double currentValue) {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return String.valueOf((int) currentValue);
            }
            if (i != 3) {
                if (i == 4) {
                    return String.valueOf((int) currentValue);
                }
                if (i == 5) {
                    return TimeTools.secToTime02$default(TimeTools.INSTANCE, ((int) currentValue) * 60, false, 2, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(currentValue)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String getUnit() {
        boolean unitType = Global.INSTANCE.getUnitType();
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return "kcal";
                    }
                    if (i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return "";
        }
        return !unitType ? "km/h" : "mph";
    }

    public final double getStep() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1.0d;
            }
            if (i != 3) {
                if (i == 4 || i == 5) {
                    return 1.0d;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return 0.1d;
    }
}
