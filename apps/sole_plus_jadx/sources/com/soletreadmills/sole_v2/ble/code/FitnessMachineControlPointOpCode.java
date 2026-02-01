package com.soletreadmills.sole_v2.ble.code;

import com.sun.jna.platform.win32.WinUser;

/* loaded from: classes5.dex */
public class FitnessMachineControlPointOpCode {
    public static final byte CURRENT_PROGRAM = -24;
    public static final byte PROGRAM_E1 = -31;
    public static final byte PROGRAM_E2 = -30;
    public static final byte PROGRAM_E3 = -29;
    public static final byte PROGRAM_E4 = -28;
    public static final byte PROGRAM_E5 = -27;
    public static final byte PROGRAM_E6 = -26;
    public static final byte PROGRAM_E7 = -25;
    public static final byte REQUEST_CONTROL = 0;
    public static final byte RESET = 1;
    public static final byte RESPONSE_CODE = -128;
    public static final byte SET_DISPLAY_HEART_RATE = -17;
    public static final byte SET_INDOOR_BIKE_SIMULATION_PARAMETERS = 17;
    public static final byte SET_TARGETED_CADENCE = 20;
    public static final byte SET_TARGETED_DISTANCE = 12;
    public static final byte SET_TARGETED_EXPENDED_ENERGY = 9;
    public static final byte SET_TARGETED_NUMBER_OF_STEPS = 10;
    public static final byte SET_TARGETED_NUMBER_OF_STRIDES = 11;
    public static final byte SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES = 16;
    public static final byte SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES = 15;
    public static final byte SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES = 14;
    public static final byte SET_TARGETED_TRAINING_TIME = 13;
    public static final byte SET_TARGET_HEART_RATE = 6;
    public static final byte SET_TARGET_INCLINATION = 3;
    public static final byte SET_TARGET_POWER = 5;
    public static final byte SET_TARGET_RESISTANCE_LEVEL = 4;
    public static final byte SET_TARGET_SPEED = 2;
    public static final byte SET_WHEEL_CIRCUMFERENCE = 18;
    public static final byte SPIN_DOWN_CONTROL = 19;
    public static final byte START_OR_RESUME = 7;
    public static final byte STOP_OR_PAUSE = 8;
    public static final byte SUPPORT_PROGRAM = -23;

    public enum Type {
        REQUEST_CONTROL,
        RESET,
        SET_TARGET_SPEED,
        SET_TARGET_INCLINATION,
        SET_TARGET_RESISTANCE_LEVEL,
        SET_TARGET_POWER,
        SET_TARGET_HEART_RATE,
        START_OR_RESUME,
        STOP_OR_PAUSE,
        SET_TARGETED_EXPENDED_ENERGY,
        SET_TARGETED_NUMBER_OF_STEPS,
        SET_TARGETED_NUMBER_OF_STRIDES,
        SET_TARGETED_DISTANCE,
        SET_TARGETED_TRAINING_TIME,
        SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES,
        SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES,
        SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES,
        SET_INDOOR_BIKE_SIMULATION_PARAMETERS,
        SET_WHEEL_CIRCUMFERENCE,
        SPIN_DOWN_CONTROL,
        SET_TARGETED_CADENCE,
        RESPONSE_CODE,
        CURRENT_PROGRAM,
        SUPPORT_PROGRAM,
        PROGRAM_E1,
        PROGRAM_E2,
        PROGRAM_E3,
        PROGRAM_E4,
        PROGRAM_E5,
        PROGRAM_E6,
        PROGRAM_E7
    }

    /* renamed from: com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type = iArr;
            try {
                iArr[Type.REQUEST_CONTROL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.RESET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGET_SPEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGET_INCLINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGET_RESISTANCE_LEVEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGET_POWER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGET_HEART_RATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.START_OR_RESUME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.STOP_OR_PAUSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_EXPENDED_ENERGY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_NUMBER_OF_STEPS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_NUMBER_OF_STRIDES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_DISTANCE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_TRAINING_TIME.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_INDOOR_BIKE_SIMULATION_PARAMETERS.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_WHEEL_CIRCUMFERENCE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SPIN_DOWN_CONTROL.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SET_TARGETED_CADENCE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.CURRENT_PROGRAM.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.SUPPORT_PROGRAM.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E1.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E2.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E3.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E4.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E5.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E6.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.PROGRAM_E7.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[Type.RESPONSE_CODE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
        }
    }

    public static byte typeToCode(Type type) {
        switch (AnonymousClass1.$SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointOpCode$Type[type.ordinal()]) {
            case 1:
                return (byte) 0;
            case 2:
                return (byte) 1;
            case 3:
                return (byte) 2;
            case 4:
                return (byte) 3;
            case 5:
                return (byte) 4;
            case 6:
                return (byte) 5;
            case 7:
                return (byte) 6;
            case 8:
                return (byte) 7;
            case 9:
                return (byte) 8;
            case 10:
                return (byte) 9;
            case 11:
                return (byte) 10;
            case 12:
                return (byte) 11;
            case 13:
                return (byte) 12;
            case 14:
                return (byte) 13;
            case 15:
                return (byte) 14;
            case 16:
                return (byte) 15;
            case 17:
                return (byte) 16;
            case 18:
                return (byte) 17;
            case 19:
                return (byte) 18;
            case 20:
                return (byte) 19;
            case 21:
                return (byte) 20;
            case 22:
                return CURRENT_PROGRAM;
            case 23:
                return SUPPORT_PROGRAM;
            case 24:
                return PROGRAM_E1;
            case 25:
                return PROGRAM_E2;
            case 26:
                return PROGRAM_E3;
            case 27:
                return PROGRAM_E4;
            case 28:
                return PROGRAM_E5;
            case 29:
                return PROGRAM_E6;
            case 30:
                return PROGRAM_E7;
            default:
                return (byte) -128;
        }
    }

    public static Type codeToType(byte code) {
        switch (code) {
            case -31:
                return Type.PROGRAM_E1;
            case -30:
                return Type.PROGRAM_E2;
            case -29:
                return Type.PROGRAM_E3;
            case -28:
                return Type.PROGRAM_E4;
            case -27:
                return Type.PROGRAM_E5;
            case WinUser.GCL_STYLE /* -26 */:
                return Type.PROGRAM_E6;
            case -25:
                return Type.PROGRAM_E7;
            case WinUser.GCLP_WNDPROC /* -24 */:
                return Type.CURRENT_PROGRAM;
            case -23:
                return Type.SUPPORT_PROGRAM;
            default:
                switch (code) {
                    case 0:
                        return Type.REQUEST_CONTROL;
                    case 1:
                        return Type.RESET;
                    case 2:
                        return Type.SET_TARGET_SPEED;
                    case 3:
                        return Type.SET_TARGET_INCLINATION;
                    case 4:
                        return Type.SET_TARGET_RESISTANCE_LEVEL;
                    case 5:
                        return Type.SET_TARGET_POWER;
                    case 6:
                        return Type.SET_TARGET_HEART_RATE;
                    case 7:
                        return Type.START_OR_RESUME;
                    case 8:
                        return Type.STOP_OR_PAUSE;
                    case 9:
                        return Type.SET_TARGETED_EXPENDED_ENERGY;
                    case 10:
                        return Type.SET_TARGETED_NUMBER_OF_STEPS;
                    case 11:
                        return Type.SET_TARGETED_NUMBER_OF_STRIDES;
                    case 12:
                        return Type.SET_TARGETED_DISTANCE;
                    case 13:
                        return Type.SET_TARGETED_TRAINING_TIME;
                    case 14:
                        return Type.SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES;
                    case 15:
                        return Type.SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES;
                    case 16:
                        return Type.SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES;
                    case 17:
                        return Type.SET_INDOOR_BIKE_SIMULATION_PARAMETERS;
                    case 18:
                        return Type.SET_WHEEL_CIRCUMFERENCE;
                    case 19:
                        return Type.SPIN_DOWN_CONTROL;
                    case 20:
                        return Type.SET_TARGETED_CADENCE;
                    default:
                        return Type.RESPONSE_CODE;
                }
        }
    }
}
