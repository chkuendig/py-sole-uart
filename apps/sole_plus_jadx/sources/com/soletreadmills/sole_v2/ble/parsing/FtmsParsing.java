package com.soletreadmills.sole_v2.ble.parsing;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import com.soletreadmills.sole_v2.ble.BleTools;
import com.soletreadmills.sole_v2.ble.BleUuid;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineFeatureType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes5.dex */
public class FtmsParsing {
    private static final String TAG = "FtmsParsing";

    public static ArrayList<FitnessMachineFeatureType> parsingFitnessMachineFeature(final Data data) {
        ArrayList<FitnessMachineFeatureType> arrayList = null;
        if (data.getValue() != null && data.getValue().length > 0) {
            Integer intValue = data.getIntValue(20, 0);
            if (intValue == null) {
                return null;
            }
            arrayList = new ArrayList<>();
            if ((intValue.intValue() & 1) == 1) {
                arrayList.add(FitnessMachineFeatureType.AVERAGE_SPEED_SUPPORTED);
            }
            if ((intValue.intValue() & 2) == 2) {
                arrayList.add(FitnessMachineFeatureType.CADENCE_SUPPORTED);
            }
            if ((intValue.intValue() & 4) == 4) {
                arrayList.add(FitnessMachineFeatureType.TOTAL_DISTANCE_SUPPORTED);
            }
            if ((intValue.intValue() & 8) == 8) {
                arrayList.add(FitnessMachineFeatureType.INCLINATION_SUPPORTED);
            }
            if ((intValue.intValue() & 16) == 16) {
                arrayList.add(FitnessMachineFeatureType.ELEVATION_GAIN_SUPPORTED);
            }
            if ((intValue.intValue() & 32) == 32) {
                arrayList.add(FitnessMachineFeatureType.PACE_SUPPORTED);
            }
            if ((intValue.intValue() & 64) == 64) {
                arrayList.add(FitnessMachineFeatureType.STEP_COUNT_SUPPORTED);
            }
            if ((intValue.intValue() & 128) == 128) {
                arrayList.add(FitnessMachineFeatureType.RESISTANCE_LEVEL_SUPPORTED);
            }
            if ((intValue.intValue() & 256) == 256) {
                arrayList.add(FitnessMachineFeatureType.STRIDE_COUNT_SUPPORTED);
            }
            if ((intValue.intValue() & 512) == 512) {
                arrayList.add(FitnessMachineFeatureType.EXPENDED_ENERGY_SUPPORTED);
            }
            if ((intValue.intValue() & 1024) == 1024) {
                arrayList.add(FitnessMachineFeatureType.HEART_RATE_MEASUREMENT_SUPPORTED);
            }
            if ((intValue.intValue() & 2048) == 2048) {
                arrayList.add(FitnessMachineFeatureType.METABOLIC_EQUIVALENT_SUPPORTED);
            }
            if ((intValue.intValue() & 4096) == 4096) {
                arrayList.add(FitnessMachineFeatureType.ELAPSED_TIME_SUPPORTED);
            }
            if ((intValue.intValue() & 8192) == 8192) {
                arrayList.add(FitnessMachineFeatureType.REMAINING_TIME_SUPPORTED);
            }
            if ((intValue.intValue() & 16384) == 16384) {
                arrayList.add(FitnessMachineFeatureType.POWER_MEASUREMENT_SUPPORTED);
            }
            if ((intValue.intValue() & 32768) == 32768) {
                arrayList.add(FitnessMachineFeatureType.FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED);
            }
            if ((intValue.intValue() & 65536) == 65536) {
                arrayList.add(FitnessMachineFeatureType.FORCE_ON_BELT_AND_POWER_OUTPUT_SUPPORTED);
            }
            Integer intValue2 = data.getIntValue(20, 4);
            if (intValue2 == null) {
                return arrayList;
            }
            if ((intValue2.intValue() & 1) == 1) {
                arrayList.add(FitnessMachineFeatureType.SPEED_TARGET_SETTING_SUPPORTED);
            }
            if ((intValue2.intValue() & 2) == 2) {
                arrayList.add(FitnessMachineFeatureType.INCLINATION_TARGET_SETTING_SUPPORTED);
            }
            if ((intValue2.intValue() & 4) == 4) {
                arrayList.add(FitnessMachineFeatureType.RESISTANCE_TARGET_SETTING_SUPPORTED);
            }
            if ((intValue2.intValue() & 8) == 8) {
                arrayList.add(FitnessMachineFeatureType.POWER_TARGET_SETTING_SUPPORTED);
            }
            if ((intValue2.intValue() & 16) == 16) {
                arrayList.add(FitnessMachineFeatureType.HEART_RATE_TARGET_SETTING_SUPPORTED);
            }
            if ((intValue2.intValue() & 32) == 32) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_EXPENDED_ENERGY_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 64) == 64) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_STEP_NUMBER_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 128) == 128) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_STRIDE_NUMBER_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 256) == 256) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_DISTANCE_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 512) == 512) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_TRAINING_TIME_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 1024) == 1024) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 2048) == 2048) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 4096) == 4096) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 8192) == 8192) {
                arrayList.add(FitnessMachineFeatureType.INDOOR_BIKE_SIMULATION_PARAMETERS_SUPPORTED);
            }
            if ((intValue2.intValue() & 16384) == 16384) {
                arrayList.add(FitnessMachineFeatureType.WHEEL_CIRCUMFERENCE_CONFIGURATION_SUPPORTED);
            }
            if ((intValue2.intValue() & 32768) == 32768) {
                arrayList.add(FitnessMachineFeatureType.SPIN_DOWN_CONTROL_SUPPORTED);
            }
            if ((intValue2.intValue() & 65536) == 65536) {
                arrayList.add(FitnessMachineFeatureType.TARGETED_CADENCE_CONFIGURATION_SUPPORTED);
            }
        }
        return arrayList;
    }

    public static TrainingStatusType parsingTrainingStatus(final Data data) {
        Integer intValue;
        TrainingStatusType trainingStatusType = null;
        try {
            intValue = data.getIntValue(17, 1);
        } catch (Exception e) {
            e.printStackTrace();
            intValue = null;
        }
        if (intValue != null) {
            switch (intValue.intValue()) {
                case 0:
                    trainingStatusType = TrainingStatusType.OTHER;
                    break;
                case 1:
                    trainingStatusType = TrainingStatusType.IDLE;
                    break;
                case 2:
                    trainingStatusType = TrainingStatusType.WARMING_UP;
                    break;
                case 3:
                    trainingStatusType = TrainingStatusType.LOW_INTENSITY_INTERVAL;
                    break;
                case 4:
                    trainingStatusType = TrainingStatusType.HIGH_INTENSITY_INTERVAL;
                    break;
                case 5:
                    trainingStatusType = TrainingStatusType.RECOVERY_INTERVAL;
                    break;
                case 6:
                    trainingStatusType = TrainingStatusType.ISOMETRIC;
                    break;
                case 7:
                    trainingStatusType = TrainingStatusType.HEART_RATE_CONTROL;
                    break;
                case 8:
                    trainingStatusType = TrainingStatusType.FITNESS_TEST;
                    break;
                case 9:
                    trainingStatusType = TrainingStatusType.SPEED_OUTSIDE_OF_CONTROL_REGION_LOW;
                    break;
                case 10:
                    trainingStatusType = TrainingStatusType.SPEED_OUTSIDE_OF_CONTROL_REGION_HIGH;
                    break;
                case 11:
                    trainingStatusType = TrainingStatusType.COOL_DOWN;
                    break;
                case 12:
                    trainingStatusType = TrainingStatusType.WATT_CONTROL;
                    break;
                case 13:
                    trainingStatusType = TrainingStatusType.MANUAL_MODE_QUICK_START;
                    break;
                case 14:
                    trainingStatusType = TrainingStatusType.PRE_WORKOUT;
                    break;
                case 15:
                    trainingStatusType = TrainingStatusType.POST_WORKOUT;
                    break;
            }
        }
        Log.d(TAG, "parsingTrainingStatus trainingStatusType=" + trainingStatusType);
        return trainingStatusType;
    }

    public static FitnessMachineStatusType parsingFitnessMachineStatus(final Data data) {
        Integer intValue;
        FitnessMachineStatusType fitnessMachineStatusType;
        Log.d(TAG, "parsingFitnessMachineStatus fitnessMachineStatusType data=" + data);
        FitnessMachineStatusType fitnessMachineStatusType2 = null;
        try {
            intValue = data.getIntValue(17, 0);
        } catch (Exception e) {
            e.printStackTrace();
            intValue = null;
        }
        if (intValue != null) {
            int iIntValue = intValue.intValue();
            if (iIntValue != 255) {
                switch (iIntValue) {
                    case 1:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.RESET;
                        break;
                    case 2:
                        Integer intValue2 = data.getIntValue(17, 1);
                        if (intValue2 != null) {
                            int iIntValue2 = intValue2.intValue();
                            if (iIntValue2 == 1) {
                                fitnessMachineStatusType = FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER;
                            } else if (iIntValue2 == 2) {
                                fitnessMachineStatusType = FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER;
                            }
                            fitnessMachineStatusType2 = fitnessMachineStatusType;
                            break;
                        }
                        break;
                    case 3:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY;
                        break;
                    case 4:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER;
                        break;
                    case 5:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGET_SPEED_CHANGED;
                        break;
                    case 6:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGET_INCLINE_CHANGED;
                        break;
                    case 7:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGET_RESISTANCE_LEVEL_CHANGED;
                        break;
                    case 8:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGET_POWER_CHANGED;
                        break;
                    case 9:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGET_HEART_RATE_CHANGED;
                        break;
                    case 10:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_EXPENDED_ENERGY_CHANGED;
                        break;
                    case 11:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_NUMBER_OF_STEPS_CHANGED;
                        break;
                    case 12:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_NUMBER_OF_STRIDES_CHANGED;
                        break;
                    case 13:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_DISTANCE_CHANGED;
                        break;
                    case 14:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_TRAINING_TIME_CHANGED;
                        break;
                    case 15:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED;
                        break;
                    case 16:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED;
                        break;
                    case 17:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED;
                        break;
                    case 18:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED;
                        break;
                    case 19:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.WHEEL_CIRCUMFERENCE_CHANGED;
                        break;
                    case 20:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.SPIN_DOWN_STATUS;
                        break;
                    case 21:
                        fitnessMachineStatusType2 = FitnessMachineStatusType.TARGETED_CADENCE_CHANGED;
                        break;
                }
            } else {
                fitnessMachineStatusType2 = FitnessMachineStatusType.CONTROL_PERMISSION_LOST;
            }
        }
        Log.d(TAG, "parsingFitnessMachineStatus fitnessMachineStatusType=" + fitnessMachineStatusType2);
        return fitnessMachineStatusType2;
    }

    public static FitnessMachineStatusType parsingFitnessMachineStatusType(byte value) {
        if (value == 9) {
            return FitnessMachineStatusType.Program_E1_hr1;
        }
        if (value != 16) {
            switch (value) {
                case 0:
                    return FitnessMachineStatusType.Program_E1_quickStart;
                case 1:
                    return FitnessMachineStatusType.Program_E1_manual;
                case 2:
                    return FitnessMachineStatusType.Program_E1_hill;
                case 3:
                    return FitnessMachineStatusType.Program_E1_fatburn;
                case 4:
                    return FitnessMachineStatusType.Program_E1_cardio;
                case 5:
                    return FitnessMachineStatusType.Program_E1_strength;
                case 6:
                    return FitnessMachineStatusType.Program_E1_interval;
                case 7:
                    return FitnessMachineStatusType.Program_E1_custom;
                default:
                    return null;
            }
        }
        return FitnessMachineStatusType.Program_E1_hr2;
    }

    public static FitnessMachineControlPointResponseData parsingFitnessMachineControlPointResponse(final Data data) {
        FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData = new FitnessMachineControlPointResponseData();
        if (data.getValue() == null) {
            return fitnessMachineControlPointResponseData;
        }
        fitnessMachineControlPointResponseData.setValue(data.getValue());
        if (data.getValue().length >= 1) {
            if (FitnessMachineControlPointOpCode.codeToType(data.getValue()[0]) == FitnessMachineControlPointOpCode.Type.RESPONSE_CODE) {
                if (data.getValue().length >= 2) {
                    fitnessMachineControlPointResponseData.setOpCodeType(FitnessMachineControlPointOpCode.codeToType(data.getValue()[1]));
                    if (data.getValue().length >= 3) {
                        fitnessMachineControlPointResponseData.setResultCodeType(FitnessMachineControlPointResultCode.codeToType(data.getValue()[2]));
                        if (data.getValue().length >= 4 && fitnessMachineControlPointResponseData.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS && fitnessMachineControlPointResponseData.getOpCodeType() == FitnessMachineControlPointOpCode.Type.CURRENT_PROGRAM) {
                            fitnessMachineControlPointResponseData.setFitnessMachineStatusType(parsingFitnessMachineStatusType(data.getValue()[3]));
                        }
                    }
                }
            } else {
                fitnessMachineControlPointResponseData.setOpCodeType(FitnessMachineControlPointOpCode.codeToType(data.getValue()[0]));
            }
        }
        return fitnessMachineControlPointResponseData;
    }

    public static FtmsBaseData parsingFtmsData(final BluetoothDevice bluetoothDevice, final FtmsDeviceManager ftmsDeviceManager, final BluetoothGattCharacteristic characteristic, final Data data) {
        String str = TAG;
        Log.d(str, "parsingFtmsData characteristic=" + characteristic);
        FtmsBaseData ftmsBaseDataParsingRowerData = null;
        if (characteristic != null && characteristic.getUuid() != null) {
            byte[] value = characteristic.getValue();
            if (value != null) {
                Log.d(str, "parsingFtmsData originalData =" + BleTools.bytesToHexUpper(value, true) + " | size=" + value.length);
            }
            if (characteristic.getUuid().equals(BleUuid.UUID_TREADMILL_DATA)) {
                Log.d(str, "parsingFtmsData -> characteristic=Treadmill Data");
                ftmsBaseDataParsingRowerData = parsingTreadmillData(data);
            } else if (characteristic.getUuid().equals(BleUuid.UUID_INDOOR_BIKE_DATA)) {
                Log.d(str, "parsingFtmsData -> characteristic=BIKE Data");
                ftmsBaseDataParsingRowerData = parsingIndoorBikeData(data);
            } else if (characteristic.getUuid().equals(BleUuid.UUID_CROSS_TRAINER_DATA)) {
                Log.d(str, "parsingFtmsData -> characteristic=Elliptical Data");
                ftmsBaseDataParsingRowerData = parsingCrossTrainerData(data);
            } else if (characteristic.getUuid().equals(BleUuid.UUID_STEP_CLIMBER_DATA)) {
                Log.d(str, "parsingFtmsData -> characteristic=Stepper Data");
                ftmsBaseDataParsingRowerData = parsingStepClimberData(data);
            } else if (characteristic.getUuid().equals(BleUuid.UUID_ROWER_DATA)) {
                Log.d(str, "parsingFtmsData -> characteristic=Rower Data");
                ftmsBaseDataParsingRowerData = parsingRowerData(data);
            }
            if (ftmsBaseDataParsingRowerData != null) {
                ftmsBaseDataParsingRowerData.setMacAddress(bluetoothDevice.getAddress());
                String bluetoothDeviceName = ftmsDeviceManager.getBluetoothDeviceName();
                if (bluetoothDeviceName != null) {
                    ftmsBaseDataParsingRowerData.setBleName(bluetoothDeviceName);
                }
            }
            boolean z = ftmsBaseDataParsingRowerData instanceof TreadmillData;
            boolean z2 = ftmsBaseDataParsingRowerData instanceof IndoorBikeData;
            boolean z3 = ftmsBaseDataParsingRowerData instanceof CrossTrainerData;
            boolean z4 = ftmsBaseDataParsingRowerData instanceof StepClimberData;
            boolean z5 = ftmsBaseDataParsingRowerData instanceof RowerData;
        }
        return ftmsBaseDataParsingRowerData;
    }

    public static TreadmillData parsingTreadmillData(final Data data) {
        Integer intValue;
        int i;
        TreadmillData treadmillData = new TreadmillData();
        if (data.getValue() == null || data.getValue().length <= 0 || (intValue = data.getIntValue(18, 0)) == null) {
            return treadmillData;
        }
        Log.d(TAG, "parsingTreadmillData flagsInt=" + Integer.toBinaryString(intValue.intValue()));
        if ((intValue.intValue() & 1) != 1) {
            if (data.getIntValue(18, 2) != null) {
                treadmillData.setInstantaneousSpeed(Double.valueOf(BigDecimal.valueOf(r3.intValue()).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP).doubleValue()));
            }
            i = 4;
        } else {
            i = 2;
        }
        if ((intValue.intValue() & 2) == 2) {
            Integer intValue2 = data.getIntValue(18, i);
            i += 2;
            if (intValue2 != null) {
                treadmillData.setAverageSpeed(Double.valueOf(BigDecimal.valueOf(intValue2.intValue()).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 4) == 4) {
            Integer intValue3 = data.getIntValue(18, i);
            Integer intValue4 = data.getIntValue(17, i + 2);
            i += 3;
            Integer numValueOf = (intValue4 == null || intValue3 == null) ? null : Integer.valueOf(intValue3.intValue() + (intValue4.intValue() << 16));
            if (numValueOf != null) {
                treadmillData.setTotalDistance(numValueOf);
            }
        }
        if ((intValue.intValue() & 8) == 8) {
            int i2 = i + 2;
            if (data.getIntValue(34, i) != null) {
                treadmillData.setInclination(Double.valueOf(BigDecimal.valueOf(r5.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
            i += 4;
            if (data.getIntValue(34, i2) != null) {
                treadmillData.setRampAngleSetting(Double.valueOf(BigDecimal.valueOf(r5.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 16) == 16) {
            int i3 = i + 2;
            if (data.getIntValue(18, i) != null) {
                treadmillData.setPositiveElevationGain(Double.valueOf(BigDecimal.valueOf(r5.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
            i += 4;
            if (data.getIntValue(18, i3) != null) {
                treadmillData.setNegativeElevationGain(Double.valueOf(BigDecimal.valueOf(r5.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 32) == 32) {
            Integer intValue5 = data.getIntValue(17, i);
            i++;
            if (intValue5 != null) {
                treadmillData.setInstantaneousPace(Double.valueOf(intValue5.doubleValue()));
            }
        }
        if ((intValue.intValue() & 64) == 64) {
            Integer intValue6 = data.getIntValue(17, i);
            i++;
            if (intValue6 != null) {
                treadmillData.setAveragePace(Double.valueOf(intValue6.doubleValue()));
            }
        }
        if ((intValue.intValue() & 128) == 128) {
            Integer intValue7 = data.getIntValue(18, i);
            int i4 = i + 2;
            if (intValue7 != null) {
                treadmillData.setTotalEnergy(intValue7);
            }
            Integer intValue8 = data.getIntValue(18, i4);
            int i5 = i + 4;
            if (intValue8 != null) {
                treadmillData.setEnergyPerHour(intValue8);
            }
            Integer intValue9 = data.getIntValue(17, i5);
            i += 5;
            if (intValue9 != null) {
                treadmillData.setEnergyPerMinute(intValue9);
            }
        }
        if ((intValue.intValue() & 256) == 256) {
            Integer intValue10 = data.getIntValue(17, i);
            i++;
            if (intValue10 != null && intValue10.intValue() > 0 && intValue10.intValue() <= 300) {
                treadmillData.setHeartRate(intValue10);
            }
        }
        if ((intValue.intValue() & 512) == 512) {
            Integer intValue11 = data.getIntValue(17, i);
            i++;
            if (intValue11 != null) {
                treadmillData.setMetabolicEquivalent(Double.valueOf(BigDecimal.valueOf(intValue11.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 1024) == 1024) {
            Integer intValue12 = data.getIntValue(18, i);
            i += 2;
            if (intValue12 != null) {
                treadmillData.setElapsedTime(intValue12);
            }
        }
        if ((intValue.intValue() & 2048) == 2048) {
            Integer intValue13 = data.getIntValue(18, i);
            i += 2;
            if (intValue13 != null) {
                treadmillData.setRemainingTime(intValue13);
            }
        }
        if ((intValue.intValue() & 4096) == 4096) {
            Integer intValue14 = data.getIntValue(34, i);
            int i6 = i + 2;
            if (intValue14 != null) {
                treadmillData.setForceOnBelt(intValue14);
            }
            Integer intValue15 = data.getIntValue(34, i6);
            if (intValue15 != null) {
                treadmillData.setPowerOutput(intValue15);
            }
        }
        return treadmillData;
    }

    public static IndoorBikeData parsingIndoorBikeData(final Data data) {
        Integer intValue;
        int i;
        Integer intValue2;
        IndoorBikeData indoorBikeData = new IndoorBikeData();
        if (data.getValue() == null || data.getValue().length <= 0 || (intValue = data.getIntValue(18, 0)) == null) {
            return indoorBikeData;
        }
        Log.d(TAG, "parsingIndoorBikeData flagsInt=" + Integer.toBinaryString(intValue.intValue()));
        if ((intValue.intValue() & 1) != 1) {
            if (data.getIntValue(18, 2) != null) {
                indoorBikeData.setInstantaneousSpeed(Double.valueOf(BigDecimal.valueOf(r3.intValue()).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP).doubleValue()));
            }
            i = 4;
        } else {
            i = 2;
        }
        if ((intValue.intValue() & 2) == 2) {
            Integer intValue3 = data.getIntValue(18, i);
            i += 2;
            if (intValue3 != null) {
                indoorBikeData.setAverageSpeed(Double.valueOf(BigDecimal.valueOf(intValue3.intValue()).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 4) == 4) {
            Integer intValue4 = data.getIntValue(18, i);
            i += 2;
            if (intValue4 != null) {
                indoorBikeData.setInstantaneousCadence(Double.valueOf(BigDecimal.valueOf(intValue4.intValue()).divide(BigDecimal.valueOf(2L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 8) == 8) {
            Integer intValue5 = data.getIntValue(18, i);
            i += 2;
            if (intValue5 != null) {
                indoorBikeData.setAverageCadence(Double.valueOf(BigDecimal.valueOf(intValue5.intValue()).divide(BigDecimal.valueOf(2L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 16) == 16) {
            Integer intValue6 = data.getIntValue(18, i);
            Integer intValue7 = data.getIntValue(17, i + 2);
            i += 3;
            Integer numValueOf = (intValue7 == null || intValue6 == null) ? null : Integer.valueOf(intValue6.intValue() + (intValue7.intValue() << 16));
            if (numValueOf != null) {
                indoorBikeData.setTotalDistance(numValueOf);
            }
        }
        if ((intValue.intValue() & 32) == 32) {
            Integer intValue8 = data.getIntValue(34, i);
            i += 2;
            if (intValue8 != null) {
                indoorBikeData.setResistanceLevel(intValue8);
            }
        }
        if ((intValue.intValue() & 64) == 64) {
            Integer intValue9 = data.getIntValue(34, i);
            i += 2;
            if (intValue9 != null) {
                indoorBikeData.setInstantaneousPower(intValue9);
            }
        }
        if ((intValue.intValue() & 128) == 128) {
            Integer intValue10 = data.getIntValue(34, i);
            i += 2;
            if (intValue10 != null) {
                indoorBikeData.setAveragePower(intValue10);
            }
        }
        if ((intValue.intValue() & 256) == 256) {
            Integer intValue11 = data.getIntValue(18, i);
            int i2 = i + 2;
            if (intValue11 != null) {
                indoorBikeData.setTotalEnergy(intValue11);
            }
            Integer intValue12 = data.getIntValue(18, i2);
            int i3 = i + 4;
            if (intValue12 != null) {
                indoorBikeData.setEnergyPerHour(intValue12);
            }
            Integer intValue13 = data.getIntValue(17, i3);
            i += 5;
            if (intValue13 != null) {
                indoorBikeData.setEnergyPerMinute(intValue13);
            }
        }
        if ((intValue.intValue() & 512) == 512) {
            Integer intValue14 = data.getIntValue(17, i);
            i++;
            if (intValue14 != null && intValue14.intValue() > 0 && intValue14.intValue() <= 300) {
                indoorBikeData.setHeartRate(intValue14);
            }
        }
        if ((intValue.intValue() & 1024) == 1024) {
            Integer intValue15 = data.getIntValue(17, i);
            i++;
            if (intValue15 != null) {
                indoorBikeData.setMetabolicEquivalent(Double.valueOf(BigDecimal.valueOf(intValue15.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 2048) == 2048) {
            Integer intValue16 = data.getIntValue(18, i);
            i += 2;
            if (intValue16 != null) {
                indoorBikeData.setElapsedTime(intValue16);
            }
        }
        if ((intValue.intValue() & 4096) == 4096 && (intValue2 = data.getIntValue(18, i)) != null) {
            indoorBikeData.setRemainingTime(intValue2);
        }
        return indoorBikeData;
    }

    public static int parsingCrossTrainerDataSize(final Data data) {
        if (data.getValue() == null || data.getValue().length <= 0) {
            return 0;
        }
        Integer intValue = data.getIntValue(18, 0);
        Integer intValue2 = data.getIntValue(17, 2);
        Integer numValueOf = (intValue2 == null || intValue == null) ? null : Integer.valueOf(intValue.intValue() + (intValue2.intValue() << 16));
        if (numValueOf == null) {
            return 0;
        }
        Log.d(TAG, "parsingCrossTrainerData flagsInt=" + Integer.toBinaryString(numValueOf.intValue()));
        int i = (numValueOf.intValue() & 1) != 1 ? 5 : 3;
        if ((numValueOf.intValue() & 2) == 2) {
            i += 2;
        }
        if ((numValueOf.intValue() & 4) == 4) {
            i += 3;
        }
        if ((numValueOf.intValue() & 8) == 8) {
            i += 4;
        }
        if ((numValueOf.intValue() & 16) == 16) {
            i += 2;
        }
        if ((numValueOf.intValue() & 32) == 32) {
            i += 4;
        }
        if ((numValueOf.intValue() & 64) == 64) {
            i += 4;
        }
        if ((numValueOf.intValue() & 128) == 128) {
            i += 2;
        }
        if ((numValueOf.intValue() & 256) == 256) {
            i += 2;
        }
        if ((numValueOf.intValue() & 512) == 512) {
            i += 2;
        }
        if ((numValueOf.intValue() & 1024) == 1024) {
            i += 5;
        }
        if ((numValueOf.intValue() & 2048) == 2048) {
            i++;
        }
        if ((numValueOf.intValue() & 4096) == 4096) {
            i++;
        }
        if ((numValueOf.intValue() & 8192) == 8192) {
            i += 2;
        }
        return (numValueOf.intValue() & 16384) == 16384 ? i + 2 : i;
    }

    public static CrossTrainerData parsingCrossTrainerData(final Data data) {
        Integer intValue;
        CrossTrainerData crossTrainerData = new CrossTrainerData();
        if (data.getValue() != null && data.getValue().length > 0) {
            Integer intValue2 = data.getIntValue(18, 0);
            Integer intValue3 = data.getIntValue(17, 2);
            Integer numValueOf = null;
            Integer numValueOf2 = (intValue3 == null || intValue2 == null) ? null : Integer.valueOf(intValue2.intValue() + (intValue3.intValue() << 16));
            if (numValueOf2 == null) {
                return crossTrainerData;
            }
            Log.d(TAG, "parsingCrossTrainerData flagsInt=" + Integer.toBinaryString(numValueOf2.intValue()));
            int i = 3;
            if ((numValueOf2.intValue() & 1) != 1) {
                if (data.getIntValue(18, 3) != null) {
                    crossTrainerData.setInstantaneousSpeed(Double.valueOf(BigDecimal.valueOf(r5.intValue()).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP).doubleValue()));
                }
                i = 5;
            }
            if ((numValueOf2.intValue() & 2) == 2) {
                Integer intValue4 = data.getIntValue(18, i);
                i += 2;
                if (intValue4 != null) {
                    crossTrainerData.setAverageSpeed(Double.valueOf(BigDecimal.valueOf(intValue4.intValue()).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP).doubleValue()));
                }
            }
            if ((numValueOf2.intValue() & 4) == 4) {
                Integer intValue5 = data.getIntValue(18, i);
                Integer intValue6 = data.getIntValue(17, i + 2);
                i += 3;
                if (intValue6 != null && intValue5 != null) {
                    numValueOf = Integer.valueOf(intValue5.intValue() + (intValue6.intValue() << 16));
                }
                if (numValueOf != null) {
                    crossTrainerData.setTotalDistance(numValueOf);
                }
            }
            if ((numValueOf2.intValue() & 8) == 8) {
                Integer intValue7 = data.getIntValue(18, i);
                int i2 = i + 2;
                if (intValue7 != null) {
                    crossTrainerData.setStepPerMinute(Double.valueOf(intValue7.doubleValue()));
                }
                Integer intValue8 = data.getIntValue(18, i2);
                i += 4;
                if (intValue8 != null) {
                    crossTrainerData.setAverageStepRate(Double.valueOf(intValue8.doubleValue()));
                }
            }
            if ((numValueOf2.intValue() & 16) == 16) {
                Integer intValue9 = data.getIntValue(18, i);
                i += 2;
                if (intValue9 != null) {
                    crossTrainerData.setStrideCount(intValue9);
                }
            }
            if ((numValueOf2.intValue() & 32) == 32) {
                Integer intValue10 = data.getIntValue(18, i);
                int i3 = i + 2;
                if (intValue10 != null) {
                    crossTrainerData.setPositiveElevationGain(Double.valueOf(intValue10.doubleValue()));
                }
                Integer intValue11 = data.getIntValue(18, i3);
                i += 4;
                if (intValue11 != null) {
                    crossTrainerData.setNegativeElevationGain(Double.valueOf(intValue11.doubleValue()));
                }
            }
            if ((numValueOf2.intValue() & 64) == 64) {
                int i4 = i + 2;
                if (data.getIntValue(34, i) != null) {
                    crossTrainerData.setInclination(Double.valueOf(BigDecimal.valueOf(r4.intValue()).multiply(BigDecimal.valueOf(0.1d)).setScale(1, RoundingMode.HALF_UP).doubleValue()));
                }
                i += 4;
                if (data.getIntValue(34, i4) != null) {
                    crossTrainerData.setRampAngleSetting(Double.valueOf(BigDecimal.valueOf(r4.intValue()).multiply(BigDecimal.valueOf(0.1d)).setScale(1, RoundingMode.HALF_UP).doubleValue()));
                }
            }
            if ((numValueOf2.intValue() & 128) == 128) {
                Integer intValue12 = data.getIntValue(34, i);
                i += 2;
                if (intValue12 != null) {
                    crossTrainerData.setResistanceLevel(intValue12);
                }
            }
            if ((numValueOf2.intValue() & 256) == 256) {
                Integer intValue13 = data.getIntValue(34, i);
                i += 2;
                if (intValue13 != null) {
                    crossTrainerData.setInstantaneousPower(intValue13);
                }
            }
            if ((numValueOf2.intValue() & 512) == 512) {
                Integer intValue14 = data.getIntValue(34, i);
                i += 2;
                if (intValue14 != null) {
                    crossTrainerData.setAveragePower(intValue14);
                }
            }
            if ((numValueOf2.intValue() & 1024) == 1024) {
                Integer intValue15 = data.getIntValue(18, i);
                int i5 = i + 2;
                if (intValue15 != null) {
                    crossTrainerData.setTotalEnergy(intValue15);
                }
                Integer intValue16 = data.getIntValue(18, i5);
                int i6 = i + 4;
                if (intValue16 != null) {
                    crossTrainerData.setEnergyPerHour(intValue16);
                }
                Integer intValue17 = data.getIntValue(17, i6);
                i += 5;
                if (intValue17 != null) {
                    crossTrainerData.setEnergyPerMinute(intValue17);
                }
            }
            if ((numValueOf2.intValue() & 2048) == 2048) {
                Integer intValue18 = data.getIntValue(17, i);
                i++;
                if (intValue18 != null && intValue18.intValue() > 0 && intValue18.intValue() <= 300) {
                    crossTrainerData.setHeartRate(intValue18);
                }
            }
            if ((numValueOf2.intValue() & 4096) == 4096) {
                Integer intValue19 = data.getIntValue(17, i);
                i++;
                if (intValue19 != null) {
                    crossTrainerData.setMetabolicEquivalent(Double.valueOf(BigDecimal.valueOf(intValue19.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
                }
            }
            if ((numValueOf2.intValue() & 8192) == 8192) {
                Integer intValue20 = data.getIntValue(18, i);
                i += 2;
                if (intValue20 != null) {
                    crossTrainerData.setElapsedTime(intValue20);
                }
            }
            if ((numValueOf2.intValue() & 16384) == 16384 && (intValue = data.getIntValue(18, i)) != null) {
                crossTrainerData.setRemainingTime(intValue);
            }
            if ((numValueOf2.intValue() & 32768) == 32768) {
                crossTrainerData.setMovementDirection(CrossTrainerData.MovementDirectionType.BACKWARD);
            } else {
                crossTrainerData.setMovementDirection(CrossTrainerData.MovementDirectionType.FORWARD);
            }
        }
        return crossTrainerData;
    }

    public static StepClimberData parsingStepClimberData(final Data data) {
        Integer intValue;
        int i;
        Integer intValue2;
        StepClimberData stepClimberData = new StepClimberData();
        if (data.getValue() == null || data.getValue().length <= 0 || (intValue = data.getIntValue(18, 0)) == null) {
            return stepClimberData;
        }
        Log.d(TAG, "parsingStepClimberData flagsInt=" + Integer.toBinaryString(intValue.intValue()));
        if ((intValue.intValue() & 1) != 1) {
            Integer intValue3 = data.getIntValue(18, 2);
            if (intValue3 != null) {
                stepClimberData.setFloors(intValue3);
            }
            Integer intValue4 = data.getIntValue(18, 4);
            if (intValue4 != null) {
                stepClimberData.setStepCount(intValue4);
            }
            i = 6;
        } else {
            i = 2;
        }
        if ((intValue.intValue() & 2) == 2) {
            Integer intValue5 = data.getIntValue(18, i);
            i += 2;
            if (intValue5 != null) {
                stepClimberData.setStepPerMinute(Double.valueOf(intValue5.doubleValue()));
            }
        }
        if ((intValue.intValue() & 4) == 4) {
            Integer intValue6 = data.getIntValue(18, i);
            i += 2;
            if (intValue6 != null) {
                stepClimberData.setAverageStepRate(Double.valueOf(intValue6.doubleValue()));
            }
        }
        if ((intValue.intValue() & 8) == 8) {
            Integer intValue7 = data.getIntValue(18, i);
            i += 2;
            if (intValue7 != null) {
                stepClimberData.setPositiveElevationGain(intValue7);
            }
        }
        if ((intValue.intValue() & 16) == 16) {
            Integer intValue8 = data.getIntValue(18, i);
            int i2 = i + 2;
            if (intValue8 != null) {
                stepClimberData.setTotalEnergy(intValue8);
            }
            Integer intValue9 = data.getIntValue(18, i2);
            int i3 = i + 4;
            if (intValue9 != null) {
                stepClimberData.setEnergyPerHour(intValue9);
            }
            Integer intValue10 = data.getIntValue(17, i3);
            i += 5;
            if (intValue10 != null) {
                stepClimberData.setEnergyPerMinute(intValue10);
            }
        }
        if ((intValue.intValue() & 32) == 32) {
            Integer intValue11 = data.getIntValue(17, i);
            i++;
            if (intValue11 != null && intValue11.intValue() > 0 && intValue11.intValue() <= 300) {
                stepClimberData.setHeartRate(intValue11);
            }
        }
        if ((intValue.intValue() & 64) == 64) {
            Integer intValue12 = data.getIntValue(17, i);
            i++;
            if (intValue12 != null) {
                stepClimberData.setMetabolicEquivalent(Double.valueOf(BigDecimal.valueOf(intValue12.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 128) == 128) {
            Integer intValue13 = data.getIntValue(18, i);
            i += 2;
            if (intValue13 != null) {
                stepClimberData.setElapsedTime(intValue13);
            }
        }
        if ((intValue.intValue() & 256) == 256) {
            Integer intValue14 = data.getIntValue(18, i);
            i += 2;
            if (intValue14 != null) {
                stepClimberData.setRemainingTime(intValue14);
            }
        }
        if ((intValue.intValue() & 512) == 512 && (intValue2 = data.getIntValue(34, i)) != null) {
            stepClimberData.setResistanceLevel(intValue2);
        }
        return stepClimberData;
    }

    public static RowerData parsingRowerData(Data data) {
        Integer intValue;
        int i;
        Integer intValue2;
        RowerData rowerData = new RowerData();
        if (data.getValue() == null || data.getValue().length <= 0 || (intValue = data.getIntValue(18, 0)) == null) {
            return rowerData;
        }
        Log.d(TAG, "parsingRowerData flagsInt=" + Integer.toBinaryString(intValue.intValue()));
        if ((intValue.intValue() & 1) != 1) {
            Integer intValue3 = data.getIntValue(17, 2);
            if (intValue3 != null) {
                rowerData.setStrokeRate(Double.valueOf(intValue3.doubleValue() / 2.0d));
            }
            Integer intValue4 = data.getIntValue(18, 3);
            if (intValue4 != null) {
                rowerData.setStrokeCount(intValue4);
            }
            i = 5;
        } else {
            i = 2;
        }
        if ((intValue.intValue() & 2) == 2) {
            Integer intValue5 = data.getIntValue(17, i);
            i++;
            if (intValue5 != null) {
                rowerData.setAverageStrokeRate(Double.valueOf(intValue5.doubleValue() / 2.0d));
            }
        }
        if ((intValue.intValue() & 4) == 4) {
            Integer intValue6 = data.getIntValue(18, i);
            Integer intValue7 = data.getIntValue(17, i + 2);
            i += 3;
            Integer numValueOf = (intValue7 == null || intValue6 == null) ? null : Integer.valueOf(intValue6.intValue() + (intValue7.intValue() << 16));
            if (numValueOf != null) {
                rowerData.setTotalDistance(numValueOf);
            }
        }
        if ((intValue.intValue() & 8) == 8) {
            Integer intValue8 = data.getIntValue(18, i);
            i += 2;
            if (intValue8 != null) {
                rowerData.setInstantaneousPace(Double.valueOf(intValue8.doubleValue()));
            }
        }
        if ((intValue.intValue() & 16) == 16) {
            Integer intValue9 = data.getIntValue(18, i);
            i += 2;
            if (intValue9 != null) {
                rowerData.setAveragePace(Double.valueOf(intValue9.doubleValue()));
            }
        }
        if ((intValue.intValue() & 32) == 32) {
            Integer intValue10 = data.getIntValue(34, i);
            i += 2;
            if (intValue10 != null) {
                rowerData.setInstantaneousPower(intValue10);
            }
        }
        if ((intValue.intValue() & 64) == 64) {
            Integer intValue11 = data.getIntValue(34, i);
            i += 2;
            if (intValue11 != null) {
                rowerData.setAveragePower(intValue11);
            }
        }
        if ((intValue.intValue() & 128) == 128) {
            Integer intValue12 = data.getIntValue(34, i);
            i += 2;
            if (intValue12 != null) {
                rowerData.setResistanceLevel(intValue12);
            }
        }
        if ((intValue.intValue() & 256) == 256) {
            Integer intValue13 = data.getIntValue(18, i);
            int i2 = i + 2;
            if (intValue13 != null) {
                rowerData.setTotalEnergy(intValue13);
            }
            Integer intValue14 = data.getIntValue(18, i2);
            int i3 = i + 4;
            if (intValue14 != null) {
                rowerData.setEnergyPerHour(intValue14);
            }
            Integer intValue15 = data.getIntValue(17, i3);
            i += 5;
            if (intValue15 != null) {
                rowerData.setEnergyPerMinute(intValue15);
            }
        }
        if ((intValue.intValue() & 512) == 512) {
            Integer intValue16 = data.getIntValue(17, i);
            i++;
            if (intValue16 != null && intValue16.intValue() > 0 && intValue16.intValue() <= 300) {
                rowerData.setHeartRate(intValue16);
            }
        }
        if ((intValue.intValue() & 1024) == 1024) {
            Integer intValue17 = data.getIntValue(17, i);
            i++;
            if (intValue17 != null) {
                rowerData.setMetabolicEquivalent(Double.valueOf(BigDecimal.valueOf(intValue17.intValue()).divide(BigDecimal.valueOf(10L), 1, RoundingMode.HALF_UP).doubleValue()));
            }
        }
        if ((intValue.intValue() & 2048) == 2048) {
            Integer intValue18 = data.getIntValue(18, i);
            i += 2;
            if (intValue18 != null) {
                rowerData.setElapsedTime(intValue18);
            }
        }
        if ((intValue.intValue() & 4096) == 4096 && (intValue2 = data.getIntValue(18, i)) != null) {
            rowerData.setRemainingTime(intValue2);
        }
        return rowerData;
    }
}
