package com.soletreadmills.sole_v2.ble.type;

import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessMachineStatusType.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b(\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006,"}, d2 = {"Lcom/soletreadmills/sole_v2/ble/type/FitnessMachineStatusType;", "", "(Ljava/lang/String;I)V", "getProgramName", "", "RESET", "FITNESS_MACHINE_STOPPED_BY_THE_USER", "FITNESS_MACHINE_PAUSED_BY_THE_USER", "FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY", "FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER", "TARGET_SPEED_CHANGED", "TARGET_INCLINE_CHANGED", "TARGET_RESISTANCE_LEVEL_CHANGED", "TARGET_POWER_CHANGED", "TARGET_HEART_RATE_CHANGED", "TARGETED_EXPENDED_ENERGY_CHANGED", "TARGETED_NUMBER_OF_STEPS_CHANGED", "TARGETED_NUMBER_OF_STRIDES_CHANGED", "TARGETED_DISTANCE_CHANGED", "TARGETED_TRAINING_TIME_CHANGED", "TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED", "TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED", "TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED", "INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED", "WHEEL_CIRCUMFERENCE_CHANGED", "SPIN_DOWN_STATUS", "TARGETED_CADENCE_CHANGED", "CONTROL_PERMISSION_LOST", "Program_E1_quickStart", "Program_E1_manual", "Program_E1_hill", "Program_E1_fatburn", "Program_E1_cardio", "Program_E1_strength", "Program_E1_interval", "Program_E1_custom", "Program_E1_hr1", "Program_E1_hr2", "Program_E2", "Program_E3", "Program_E4", "Program_E5", "Program_E6", "Program_E7", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FitnessMachineStatusType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FitnessMachineStatusType[] $VALUES;
    public static final FitnessMachineStatusType RESET = new FitnessMachineStatusType("RESET", 0);
    public static final FitnessMachineStatusType FITNESS_MACHINE_STOPPED_BY_THE_USER = new FitnessMachineStatusType("FITNESS_MACHINE_STOPPED_BY_THE_USER", 1);
    public static final FitnessMachineStatusType FITNESS_MACHINE_PAUSED_BY_THE_USER = new FitnessMachineStatusType("FITNESS_MACHINE_PAUSED_BY_THE_USER", 2);
    public static final FitnessMachineStatusType FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY = new FitnessMachineStatusType("FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY", 3);
    public static final FitnessMachineStatusType FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER = new FitnessMachineStatusType("FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER", 4);
    public static final FitnessMachineStatusType TARGET_SPEED_CHANGED = new FitnessMachineStatusType("TARGET_SPEED_CHANGED", 5);
    public static final FitnessMachineStatusType TARGET_INCLINE_CHANGED = new FitnessMachineStatusType("TARGET_INCLINE_CHANGED", 6);
    public static final FitnessMachineStatusType TARGET_RESISTANCE_LEVEL_CHANGED = new FitnessMachineStatusType("TARGET_RESISTANCE_LEVEL_CHANGED", 7);
    public static final FitnessMachineStatusType TARGET_POWER_CHANGED = new FitnessMachineStatusType("TARGET_POWER_CHANGED", 8);
    public static final FitnessMachineStatusType TARGET_HEART_RATE_CHANGED = new FitnessMachineStatusType("TARGET_HEART_RATE_CHANGED", 9);
    public static final FitnessMachineStatusType TARGETED_EXPENDED_ENERGY_CHANGED = new FitnessMachineStatusType("TARGETED_EXPENDED_ENERGY_CHANGED", 10);
    public static final FitnessMachineStatusType TARGETED_NUMBER_OF_STEPS_CHANGED = new FitnessMachineStatusType("TARGETED_NUMBER_OF_STEPS_CHANGED", 11);
    public static final FitnessMachineStatusType TARGETED_NUMBER_OF_STRIDES_CHANGED = new FitnessMachineStatusType("TARGETED_NUMBER_OF_STRIDES_CHANGED", 12);
    public static final FitnessMachineStatusType TARGETED_DISTANCE_CHANGED = new FitnessMachineStatusType("TARGETED_DISTANCE_CHANGED", 13);
    public static final FitnessMachineStatusType TARGETED_TRAINING_TIME_CHANGED = new FitnessMachineStatusType("TARGETED_TRAINING_TIME_CHANGED", 14);
    public static final FitnessMachineStatusType TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED = new FitnessMachineStatusType("TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED", 15);
    public static final FitnessMachineStatusType TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED = new FitnessMachineStatusType("TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED", 16);
    public static final FitnessMachineStatusType TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED = new FitnessMachineStatusType("TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED", 17);
    public static final FitnessMachineStatusType INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED = new FitnessMachineStatusType("INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED", 18);
    public static final FitnessMachineStatusType WHEEL_CIRCUMFERENCE_CHANGED = new FitnessMachineStatusType("WHEEL_CIRCUMFERENCE_CHANGED", 19);
    public static final FitnessMachineStatusType SPIN_DOWN_STATUS = new FitnessMachineStatusType("SPIN_DOWN_STATUS", 20);
    public static final FitnessMachineStatusType TARGETED_CADENCE_CHANGED = new FitnessMachineStatusType("TARGETED_CADENCE_CHANGED", 21);
    public static final FitnessMachineStatusType CONTROL_PERMISSION_LOST = new FitnessMachineStatusType("CONTROL_PERMISSION_LOST", 22);
    public static final FitnessMachineStatusType Program_E1_quickStart = new FitnessMachineStatusType("Program_E1_quickStart", 23);
    public static final FitnessMachineStatusType Program_E1_manual = new FitnessMachineStatusType("Program_E1_manual", 24);
    public static final FitnessMachineStatusType Program_E1_hill = new FitnessMachineStatusType("Program_E1_hill", 25);
    public static final FitnessMachineStatusType Program_E1_fatburn = new FitnessMachineStatusType("Program_E1_fatburn", 26);
    public static final FitnessMachineStatusType Program_E1_cardio = new FitnessMachineStatusType("Program_E1_cardio", 27);
    public static final FitnessMachineStatusType Program_E1_strength = new FitnessMachineStatusType("Program_E1_strength", 28);
    public static final FitnessMachineStatusType Program_E1_interval = new FitnessMachineStatusType("Program_E1_interval", 29);
    public static final FitnessMachineStatusType Program_E1_custom = new FitnessMachineStatusType("Program_E1_custom", 30);
    public static final FitnessMachineStatusType Program_E1_hr1 = new FitnessMachineStatusType("Program_E1_hr1", 31);
    public static final FitnessMachineStatusType Program_E1_hr2 = new FitnessMachineStatusType("Program_E1_hr2", 32);
    public static final FitnessMachineStatusType Program_E2 = new FitnessMachineStatusType("Program_E2", 33);
    public static final FitnessMachineStatusType Program_E3 = new FitnessMachineStatusType("Program_E3", 34);
    public static final FitnessMachineStatusType Program_E4 = new FitnessMachineStatusType("Program_E4", 35);
    public static final FitnessMachineStatusType Program_E5 = new FitnessMachineStatusType("Program_E5", 36);
    public static final FitnessMachineStatusType Program_E6 = new FitnessMachineStatusType("Program_E6", 37);
    public static final FitnessMachineStatusType Program_E7 = new FitnessMachineStatusType("Program_E7", 38);

    /* compiled from: FitnessMachineStatusType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FitnessMachineStatusType.values().length];
            try {
                iArr[FitnessMachineStatusType.Program_E1_quickStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_manual.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_hill.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_fatburn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_cardio.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_strength.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_interval.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_custom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_hr1.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FitnessMachineStatusType.Program_E1_hr2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ FitnessMachineStatusType[] $values() {
        return new FitnessMachineStatusType[]{RESET, FITNESS_MACHINE_STOPPED_BY_THE_USER, FITNESS_MACHINE_PAUSED_BY_THE_USER, FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY, FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER, TARGET_SPEED_CHANGED, TARGET_INCLINE_CHANGED, TARGET_RESISTANCE_LEVEL_CHANGED, TARGET_POWER_CHANGED, TARGET_HEART_RATE_CHANGED, TARGETED_EXPENDED_ENERGY_CHANGED, TARGETED_NUMBER_OF_STEPS_CHANGED, TARGETED_NUMBER_OF_STRIDES_CHANGED, TARGETED_DISTANCE_CHANGED, TARGETED_TRAINING_TIME_CHANGED, TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED, TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED, TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED, INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED, WHEEL_CIRCUMFERENCE_CHANGED, SPIN_DOWN_STATUS, TARGETED_CADENCE_CHANGED, CONTROL_PERMISSION_LOST, Program_E1_quickStart, Program_E1_manual, Program_E1_hill, Program_E1_fatburn, Program_E1_cardio, Program_E1_strength, Program_E1_interval, Program_E1_custom, Program_E1_hr1, Program_E1_hr2, Program_E2, Program_E3, Program_E4, Program_E5, Program_E6, Program_E7};
    }

    public static EnumEntries<FitnessMachineStatusType> getEntries() {
        return $ENTRIES;
    }

    public static FitnessMachineStatusType valueOf(String str) {
        return (FitnessMachineStatusType) Enum.valueOf(FitnessMachineStatusType.class, str);
    }

    public static FitnessMachineStatusType[] values() {
        return (FitnessMachineStatusType[]) $VALUES.clone();
    }

    private FitnessMachineStatusType(String str, int i) {
    }

    static {
        FitnessMachineStatusType[] fitnessMachineStatusTypeArr$values = $values();
        $VALUES = fitnessMachineStatusTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(fitnessMachineStatusTypeArr$values);
    }

    public final int getProgramName() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
        }
        return R.string.empty_text;
    }
}
