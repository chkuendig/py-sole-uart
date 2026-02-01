package com.soletreadmills.sole_v2.ble.cmd;

import android.util.Log;
import com.soletreadmills.sole_v2._type.ConnectProgramNameType;
import com.soletreadmills.sole_v2.ble.BleTools;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import no.nordicsemi.android.ble.data.Data;

/* loaded from: classes5.dex */
public class FitnessMachineControlPointCmd {
    private static final String TAG = "FitnessMachineControlPointCmd";

    public static Data requestControl() {
        return new Data(new byte[]{0});
    }

    public static Data startOrResume() {
        return new Data(new byte[]{7});
    }

    public static Data pause() {
        return new Data(new byte[]{8, 2});
    }

    public static Data stop() {
        return new Data(new byte[]{8, 1});
    }

    public static Data getSupportProgram() {
        return new Data(new byte[]{FitnessMachineControlPointOpCode.SUPPORT_PROGRAM});
    }

    public static Data getCurrentProgram() {
        return new Data(new byte[]{FitnessMachineControlPointOpCode.CURRENT_PROGRAM});
    }

    public static Data setTargetSpeed(final float speedKm) {
        String str = TAG;
        Log.d(str, "setTargetSpeed -> speedKm=" + speedKm);
        if (speedKm < 0.0f) {
            return null;
        }
        int iIntValue = BigDecimal.valueOf(speedKm).multiply(BigDecimal.valueOf(100L)).setScale(0, RoundingMode.HALF_UP).intValue();
        Log.d(str, "setTargetSpeed -> conversionSpeed=" + iIntValue);
        byte[] bArrIntToByteArr = BleTools.intToByteArr(iIntValue, 18, 0);
        Log.d(str, "setTargetSpeed -> conversionSpeed=" + BleTools.bytesToHexUpper(bArrIntToByteArr, true));
        if (bArrIntToByteArr == null) {
            return null;
        }
        byte[] bArrMergeBytes = BleTools.mergeBytes(new byte[]{2}, bArrIntToByteArr);
        Log.d(str, "setTargetSpeed -> re=" + BleTools.bytesToHexUpper(bArrIntToByteArr, true));
        return new Data(bArrMergeBytes);
    }

    public static Data setTargetInclination(final float percent) {
        byte[] bArrIntToByteArr = BleTools.intToByteArr(BigDecimal.valueOf(percent).multiply(BigDecimal.valueOf(10L)).setScale(0, RoundingMode.HALF_UP).intValue(), 34, 0);
        if (bArrIntToByteArr != null) {
            return new Data(BleTools.mergeBytes(new byte[]{3}, bArrIntToByteArr));
        }
        return null;
    }

    public static Data setTargetResistanceLevel(final float level) {
        Log.d(TAG, "setTargetResistanceLevel level=" + level);
        if (level < 0.0f) {
            return null;
        }
        int iIntValue = BigDecimal.valueOf(level).multiply(BigDecimal.valueOf(10L)).setScale(0, RoundingMode.HALF_UP).intValue();
        if (iIntValue > 255) {
            iIntValue = 255;
        }
        if (iIntValue < 0) {
            iIntValue = 0;
        }
        byte[] bArrIntToByteArr = BleTools.intToByteArr(iIntValue, 17, 0);
        if (bArrIntToByteArr != null) {
            return new Data(BleTools.mergeBytes(new byte[]{4}, bArrIntToByteArr));
        }
        return null;
    }

    public static Data setTargetHeartRate(final Integer hr) {
        byte[] bArrIntToByteArr = BleTools.intToByteArr(hr.intValue(), 17, 0);
        if (bArrIntToByteArr != null) {
            return new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.SET_DISPLAY_HEART_RATE}, bArrIntToByteArr));
        }
        return null;
    }

    public static ArrayList<Data> setE1ProgramCmd(Integer age, Integer weight, ConnectProgramNameType ftmsProgramType, Integer timeMin, Float maxSpeed, Integer maxLevel, List<Integer> speedProfileArray, List<Integer> inclineProfileArray, List<Integer> levelProfileArray, Integer heightHR) {
        String strSwapHighLowBytes;
        String str;
        String str2;
        String str3;
        ArrayList<Data> arrayList = new ArrayList<>();
        String str4 = String.format(Locale.US, "%02X", age);
        String str5 = String.format(Locale.US, "%02X", weight);
        String strSwapHighLowBytes2 = BleTools.swapHighLowBytes(timeMin.intValue() * 60);
        if (maxSpeed == null) {
            strSwapHighLowBytes = "0000";
        } else {
            strSwapHighLowBytes = BleTools.swapHighLowBytes((int) (maxSpeed.floatValue() * 100.0f));
        }
        if (maxLevel == null) {
            str = "00";
        } else {
            str = String.format(Locale.US, "%02X", maxLevel);
        }
        switch (AnonymousClass1.$SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ftmsProgramType.ordinal()]) {
            case 1:
                str2 = "01";
                break;
            case 2:
                str2 = "02";
                break;
            case 3:
                str2 = "03";
                break;
            case 4:
                str2 = "04";
                break;
            case 5:
                str2 = "05";
                break;
            case 6:
                str2 = "06";
                break;
            case 7:
                str2 = "07";
                break;
            default:
                str2 = "00";
                break;
        }
        if (heightHR == null) {
            str3 = "00";
        } else {
            str3 = String.format(Locale.US, "%02X", heightHR);
        }
        arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E1}, BleTools.hexToBytes(str2 + str4 + str5 + strSwapHighLowBytes2 + strSwapHighLowBytes + "00" + str + "00" + str3 + "000000"))));
        String str6 = "";
        if (speedProfileArray != null) {
            String str7 = "";
            String str8 = str7;
            for (int i = 0; i < speedProfileArray.size(); i++) {
                if (i <= 18) {
                    str7 = str7 + String.format(Locale.US, "%02X", speedProfileArray.get(i));
                } else {
                    str8 = str8 + String.format(Locale.US, "%02X", speedProfileArray.get(i));
                }
            }
            arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E2}, BleTools.hexToBytes(str7))));
            for (int i2 = 0; i2 < 10; i2++) {
                str8 = str8 + "00";
            }
            arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E3}, BleTools.hexToBytes(str8))));
        }
        if (inclineProfileArray != null) {
            String str9 = "";
            String str10 = str9;
            for (int i3 = 0; i3 < inclineProfileArray.size(); i3++) {
                if (i3 <= 18) {
                    str9 = str9 + String.format(Locale.US, "%02X", Integer.valueOf(inclineProfileArray.get(i3).intValue() & 255));
                } else {
                    str10 = str10 + String.format(Locale.US, "%02X", Integer.valueOf(inclineProfileArray.get(i3).intValue() & 255));
                }
            }
            arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E4}, BleTools.hexToBytes(str9))));
            for (int i4 = 0; i4 < 10; i4++) {
                str10 = str10 + "00";
            }
            arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E5}, BleTools.hexToBytes(str10))));
        }
        if (levelProfileArray != null) {
            String str11 = "";
            for (int i5 = 0; i5 < levelProfileArray.size(); i5++) {
                if (i5 <= 18) {
                    str6 = str6 + String.format(Locale.US, "%02X", levelProfileArray.get(i5));
                } else {
                    str11 = str11 + String.format(Locale.US, "%02X", levelProfileArray.get(i5));
                }
            }
            arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E6}, BleTools.hexToBytes(str6))));
            for (int i6 = 0; i6 < 10; i6++) {
                str11 = str11 + "00";
            }
            arrayList.add(new Data(BleTools.mergeBytes(new byte[]{FitnessMachineControlPointOpCode.PROGRAM_E7}, BleTools.hexToBytes(str11))));
        }
        return arrayList;
    }

    /* renamed from: com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType;

        static {
            int[] iArr = new int[ConnectProgramNameType.values().length];
            $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType = iArr;
            try {
                iArr[ConnectProgramNameType.Manual.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ConnectProgramNameType.Hill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ConnectProgramNameType.Fatburn.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ConnectProgramNameType.Cardio.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ConnectProgramNameType.Strength.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ConnectProgramNameType.Interval.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$_type$ConnectProgramNameType[ConnectProgramNameType.Custom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
