package com.soletreadmills.sole_v2.ble.helper;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.soletreadmills.sole_v2._type.DyacoWorkoutDataSource;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.tool.UnitConversionTool;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinUser;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import no.nordicsemi.android.ble.data.Data;
import org.objectweb.asm.Opcodes;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class SimpleFftmsHelperBikeEjek extends SimpleFftmsHelperBase {
    private Integer heartRateOld;
    private Integer instantaneousPowerOld;
    private double totalDistanceSimpleFtms;
    private final Object totalDistanceSimpleFtmsLock;
    private double totalEnergySimpleFtms;
    private final Object totalEnergySimpleFtmsLock;
    private final int[][] wattTableArr;

    public SimpleFftmsHelperBikeEjek(double userWeightKg, boolean isFemale) {
        super(userWeightKg, isFemale);
        int[] iArr = new int[22];
        // fill-array-data instruction
        iArr[0] = 16;
        iArr[1] = 22;
        iArr[2] = 31;
        iArr[3] = 40;
        iArr[4] = 49;
        iArr[5] = 58;
        iArr[6] = 69;
        iArr[7] = 81;
        iArr[8] = 92;
        iArr[9] = 103;
        iArr[10] = 111;
        iArr[11] = 118;
        iArr[12] = 126;
        iArr[13] = 133;
        iArr[14] = 141;
        iArr[15] = 148;
        iArr[16] = 156;
        iArr[17] = 163;
        iArr[18] = 171;
        iArr[19] = 178;
        iArr[20] = 186;
        iArr[21] = 193;
        this.wattTableArr = new int[][]{new int[]{2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36}, new int[]{3, 4, 6, 7, 9, 10, 12, 15, 17, 19, 21, 23, 25, 26, 28, 29, 31, 32, 34, 35, 37, 38}, new int[]{4, 5, 7, 9, 11, 12, 16, 19, 23, 26, 27, 28, 29, 30, 32, 34, 36, 38, 40, 42, 44, 46}, new int[]{5, 6, 9, 11, 14, 16, 20, 25, 29, 33, 34, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46}, new int[]{6, 8, 11, 14, 17, 20, 25, 30, 35, 40, 42, 45, 47, 49, 51, 53, 55, 57, 59, 61, 63, 65}, new int[]{8, 10, 14, 18, 22, 25, 31, 37, 42, 47, 51, 54, 58, 61, 65, 68, 72, 75, 79, 82, 86, 89}, new int[]{9, 11, 16, 20, 25, 29, 35, 42, 48, 54, 57, 61, 64, 67, 70, 73, 75, 79, 82, 85, 88, 91}, new int[]{10, 13, 19, 25, 31, 36, 42, 50, 56, 61, 66, 71, 76, 81, 86, 91, 96, 101, 106, 111, 116, 121}, new int[]{11, 14, 20, 27, 33, 39, 46, 54, 61, 68, 73, 79, 84, 89, 94, 99, 104, 109, 114, 119, 124, 129}, new int[]{12, 16, 23, 30, 36, 43, 51, 59, 67, 75, 80, 86, 91, 96, 101, 106, 111, 116, 121, 126, 131, 136}, new int[]{13, 17, 24, 32, 39, 46, 55, 64, 73, 82, 88, 93, 99, 104, 110, 115, 121, 126, 132, 137, 143, 148}, new int[]{14, 18, 26, 34, 42, 50, 60, 70, 80, 89, 95, 102, 108, 114, 120, 126, 132, 138, 144, 150, 156, 162}, new int[]{15, 20, 29, 37, 46, 54, 65, 75, 86, 96, 103, 109, 116, 122, 129, 135, 142, 148, 155, 161, Opcodes.JSR, 174}, iArr, new int[]{17, 23, 33, 43, 53, 62, 74, 86, 93, 110, 118, 126, 134, 141, 149, 156, 164, Opcodes.LOOKUPSWITCH, Opcodes.PUTSTATIC, 186, 194, 201}, new int[]{19, 25, 36, 46, 57, 67, 80, 92, 105, 117, 125, 134, 142, 150, 158, Opcodes.IF_ACMPNE, 174, 182, 190, 198, 206, WinError.ERROR_TOO_MANY_MODULES}, new int[]{20, 26, 38, 49, 60, 71, 84, 100, 112, 124, 133, 142, 151, 159, Opcodes.JSR, Opcodes.ARETURN, Opcodes.INVOKEINTERFACE, 193, 202, WinError.ERROR_THREAD_1_INACTIVE, 219, 227}, new int[]{21, 28, 40, 52, 64, 75, 90, 105, 118, 131, 141, 150, 160, Opcodes.RET, Opcodes.PUTSTATIC, 188, 198, 207, WinError.ERROR_EXE_CANNOT_MODIFY_SIGNED_BINARY, WinError.ERROR_VIRUS_DELETED, 236, 245}, new int[]{22, 29, 42, 54, 67, 79, 94, 109, 124, 138, 148, 158, Opcodes.JSR, Opcodes.GETSTATIC, 188, 198, WinError.ERROR_META_EXPANSION_TOO_LONG, WinError.ERROR_EXE_CANNOT_MODIFY_STRONG_SIGNED_BINARY, 228, 238, 248, 258}, new int[]{23, 31, 44, 58, 71, 84, 99, 115, 130, 145, 156, 167, Opcodes.GETSTATIC, 188, 199, WinError.ERROR_INVALID_SIGNAL_NUMBER, WinError.ERROR_CHECKOUT_REQUIRED, WinError.ERROR_BAD_PIPE, 241, 251, 262, 272}, new int[]{25, 33, 47, 61, 75, 88, 104, 120, 136, 152, 164, Opcodes.DRETURN, 187, 198, WinError.ERROR_THREAD_1_INACTIVE, WinError.ERROR_CHECKOUT_REQUIRED, WinError.ERROR_PIPE_NOT_CONNECTED, 244, 256, WinError.ERROR_DIRECTORY, 279, Data.FORMAT_SINT16_BE}, new int[]{26, 34, 49, 63, 78, 92, 109, 125, 145, 159, Opcodes.LOOKUPSWITCH, 183, 195, 207, 219, WinError.ERROR_PIPE_BUSY, 243, 255, WinError.ERROR_DIRECTORY, 279, Data.FORMAT_SINT24_BE, 303}, new int[]{27, 36, 51, 66, 81, 96, 114, 131, 149, 26, Opcodes.PUTSTATIC, 192, 205, WinError.ERROR_EXE_CANNOT_MODIFY_SIGNED_BINARY, WinError.ERROR_BAD_PIPE, 242, 255, WinError.ERROR_DIRECTORY, 280, Data.FORMAT_SINT32_BE, 305, 317}, new int[]{28, 37, 53, 69, 85, 101, 119, 137, 155, 173, 186, 200, 213, WinError.ERROR_VIRUS_DELETED, 239, 252, 265, WinError.ERROR_INVALID_EA_HANDLE, Data.FORMAT_SINT24_BE, 304, 317, 330}, new int[]{29, 39, 56, 72, 89, 105, 124, 143, 162, 180, 194, WinError.ERROR_META_EXPANSION_TOO_LONG, WinError.ERROR_BAD_FILE_TYPE, 236, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 264, WinError.ERROR_INVALID_EA_HANDLE, Data.FORMAT_SINT32_BE, 306, 320, 334, 348}, new int[]{31, 41, 58, 75, 92, 109, 129, 130, Opcodes.JSR, 187, 202, WinError.ERROR_EXE_MACHINE_TYPE_MISMATCH, WinError.ERROR_PIPE_BUSY, 245, 260, 274, 289, 303, 318, 332, 347, WinError.ERROR_INVALID_LDT_SIZE}, new int[]{32, 42, 60, 78, 96, 113, 133, 154, 174, 194, WinError.ERROR_INVALID_SIGNAL_NUMBER, WinError.ERROR_VIRUS_INFECTED, 240, 255, 270, 285, 300, 315, 330, 345, 360, 375}, new int[]{33, 44, 62, 81, 99, 117, 138, 159, 180, 201, WinError.ERROR_EXE_CANNOT_MODIFY_SIGNED_BINARY, WinError.ERROR_PIPE_NOT_CONNECTED, 249, 264, 280, 295, 311, 326, 342, 357, 373, 388}, new int[]{34, 45, 64, 83, 102, 121, 143, 165, 187, WinError.ERROR_META_EXPANSION_TOO_LONG, 224, 241, 257, 273, 289, 305, 321, 337, WinError.ERROR_MAX_SESSIONS_REACHED, 369, 385, 401}, new int[]{35, 46, 66, 86, 106, 125, 148, 170, 193, WinError.ERROR_NESTING_NOT_ALLOWED, WinError.ERROR_NO_DATA, 249, WinError.ERROR_CANNOT_COPY, WinError.ERROR_EAS_NOT_SUPPORTED, WinError.ERROR_PARTIAL_COPY, 315, 332, 348, 365, 381, 398, 414}, new int[]{37, 49, 70, 91, 112, 133, 155, Opcodes.DRETURN, 199, WinError.ERROR_BAD_FILE_TYPE, 241, WinUser.WM_SYSKEYUP, 280, WinError.ERROR_PARTIAL_COPY, 318, 337, 356, 375, 394, 413, 432, 451}, new int[]{38, 51, 73, 94, 116, 137, 159, 180, 205, WinError.ERROR_PIPE_LOCAL, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 270, Data.FORMAT_SINT16_BE, 311, 332, WinError.ERROR_FAIL_RESTART, 373, 393, 414, 434, 455, 475}, new int[]{39, 52, 74, 96, 118, 140, 163, Opcodes.INVOKEINTERFACE, 211, 236, 257, WinError.ERROR_INVALID_EA_HANDLE, WinError.ERROR_PARTIAL_COPY, WinNT.SERVICE_TYPE_ALL, 340, 360, 381, 401, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 442, 463, 483}, new int[]{41, 54, 77, 99, 122, 144, Opcodes.RET, 190, 219, 243, 265, 286, 308, 329, WinError.ERROR_FAIL_SHUTDOWN, 372, 394, DyacoWorkoutDataSource.SPIRIT_CLUB_MACHINE_CONSOLE, 437, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 480, TypedValues.PositionType.TYPE_TRANSITION_EASING}, new int[]{42, 56, 80, 104, 128, 151, Opcodes.ARETURN, 200, WinError.ERROR_VIRUS_DELETED, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 274, WinError.ERROR_TOO_MANY_POSTS, 322, 345, 369, 392, TypedValues.CycleType.TYPE_PATH_ROTATE, 439, 463, 486, TypedValues.PositionType.TYPE_POSITION_TYPE, 533}, new int[]{43, 57, 82, 106, 131, 155, Opcodes.PUTFIELD, 205, WinError.ERROR_NO_DATA, 257, 281, 306, 330, 354, 378, 402, 426, 450, 474, 498, 522, WinError.ERROR_PORT_MESSAGE_TOO_LONG}, new int[]{44, 59, 84, 109, 134, 158, Opcodes.INVOKESTATIC, WinError.ERROR_THREAD_1_INACTIVE, 238, 264, 289, 314, 339, 363, 388, FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 437, 461, 486, TypedValues.PositionType.TYPE_POSITION_TYPE, WinError.ERROR_ARITHMETIC_OVERFLOW, WinError.ERROR_BAD_FUNCTION_TABLE}, new int[]{46, 61, 87, 113, 139, 164, 191, WinError.ERROR_NESTING_NOT_ALLOWED, 245, 271, WinError.ERROR_TOO_MANY_POSTS, 325, WinError.ERROR_FAIL_RESTART, 378, 405, 431, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 484, 511, 537, WinError.ERROR_INVALID_LDT_DESCRIPTOR, WinError.ERROR_DEBUG_ATTACH_FAILED}, new int[]{47, 62, 89, 115, 142, Opcodes.JSR, 196, WinError.ERROR_VIRUS_INFECTED, 251, WinError.ERROR_INVALID_EA_HANDLE, 305, 332, 359, 386, 413, 440, 467, 494, 521, WinError.ERROR_DEVICE_ALREADY_ATTACHED, WinError.ERROR_APP_INIT_FAILURE, 602}, new int[]{48, 64, 92, 119, 147, 174, 202, WinError.ERROR_BAD_PIPE, 258, 285, 314, 343, 372, 401, 430, 459, 488, 517, WinError.ERROR_PORT_MESSAGE_TOO_LONG, WinError.ERROR_APP_INIT_FAILURE, 604, WinError.ERROR_DRIVER_FAILED_SLEEP}};
        this.instantaneousPowerOld = null;
        this.heartRateOld = null;
        this.totalDistanceSimpleFtms = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.totalDistanceSimpleFtmsLock = new Object();
        this.totalEnergySimpleFtms = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.totalEnergySimpleFtmsLock = new Object();
    }

    @Override // com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase
    public void onTimerRunBind() {
        Timber.d("onTimerRunBind", new Object[0]);
    }

    @Override // com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase
    public FtmsBaseData processDataBind(FtmsBaseData ftmsBaseData) {
        Integer num;
        Timber.d("processDataBind", new Object[0]);
        if (ftmsBaseData instanceof IndoorBikeData) {
            IndoorBikeData indoorBikeData = (IndoorBikeData) ftmsBaseData;
            if (indoorBikeData.getInstantaneousPower() == null && (num = this.instantaneousPowerOld) != null) {
                indoorBikeData.setInstantaneousPower(num);
            }
            if (indoorBikeData.getHeartRate() != null) {
                indoorBikeData.setHeartRate(null);
            }
            WattTableTableData wattTableTableDataFindWattTableTableData = indoorBikeData.getInstantaneousPower() != null ? findWattTableTableData(indoorBikeData.getInstantaneousPower().intValue()) : null;
            calculateSpeed(indoorBikeData, wattTableTableDataFindWattTableTableData);
            calculateTotalDistanceSimpleFtms(indoorBikeData);
            indoorBikeData.setTotalDistance(Integer.valueOf((int) getTotalDistanceSimpleFtms()));
            calculateTotalEnergySimpleFtms(indoorBikeData, wattTableTableDataFindWattTableTableData);
            indoorBikeData.setTotalEnergy(Integer.valueOf((int) getTotalEnergySimpleFtms()));
            if (indoorBikeData.getInstantaneousPower() != null) {
                this.instantaneousPowerOld = indoorBikeData.getInstantaneousPower();
            }
            if (indoorBikeData.getInstantaneousPower() == null && indoorBikeData.getHeartRate() == null) {
                this.instantaneousPowerOld = null;
                this.heartRateOld = null;
            }
        }
        return ftmsBaseData;
    }

    private void calculateRpmAndLevel(IndoorBikeData indoorBikeData) {
        WattTableTableData wattTableTableDataFindWattTableTableData = indoorBikeData.getInstantaneousPower() != null ? findWattTableTableData(indoorBikeData.getInstantaneousPower().intValue()) : null;
        if (wattTableTableDataFindWattTableTableData != null) {
            int i = wattTableTableDataFindWattTableTableData.rpm;
            int i2 = wattTableTableDataFindWattTableTableData.level;
            if (indoorBikeData.getInstantaneousCadence() == null) {
                indoorBikeData.setInstantaneousCadence(Double.valueOf(i));
            }
            if (indoorBikeData.getResistanceLevel() == null) {
                indoorBikeData.setResistanceLevel(Integer.valueOf(i2));
            }
        }
    }

    private static class WattTableTableData {
        int level;
        int rpm;

        private WattTableTableData() {
            this.rpm = 0;
            this.level = 0;
        }
    }

    private WattTableTableData findWattTableTableData(final int power) {
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int iAbs = 100;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 22; i5++) {
                int i6 = 0;
                while (true) {
                    if (i6 >= 40) {
                        break;
                    }
                    int i7 = this.wattTableArr[i6][i5];
                    if (i7 == power) {
                        i2 = (i5 * 5) + 15;
                        int i8 = i6 + 1;
                        WattTableTableData wattTableTableData = new WattTableTableData();
                        wattTableTableData.rpm = i2;
                        wattTableTableData.level = i8;
                        arrayList.add(wattTableTableData);
                        i3 = i8;
                        break;
                    }
                    if (i7 <= power || Math.abs(i7 - power) <= 50) {
                        if (Math.abs(this.wattTableArr[i6][i5] - power) < iAbs) {
                            iAbs = Math.abs(this.wattTableArr[i6][i5] - power);
                            i4 = this.wattTableArr[i6][i5];
                            i2 = (i5 * 5) + 15;
                            i3 = i6 + 1;
                        } else if (Math.abs(this.wattTableArr[i6][i5] - power) == iAbs) {
                            int i9 = this.wattTableArr[i6][i5];
                            if (i4 == i9) {
                                int i10 = (i5 * 5) + 15;
                                if (i2 >= i10) {
                                    i3 = i6 + 1;
                                    i2 = i10;
                                }
                            } else if (i4 > i9) {
                                i2 = (i5 * 5) + 15;
                                i3 = i6 + 1;
                                i4 = i9;
                            }
                        }
                        i6++;
                    }
                }
            }
            if (arrayList.size() > 0) {
                int size = arrayList.size() / 2;
                int i11 = size - 1;
                if (arrayList.size() % 2 == 0) {
                    size = i11;
                }
                if (size >= arrayList.size()) {
                    size = arrayList.size() - 1;
                }
                if (size >= 0) {
                    i = size;
                }
                return (WattTableTableData) arrayList.get(i);
            }
            WattTableTableData wattTableTableData2 = new WattTableTableData();
            if (power != 0 && i2 == 0 && i3 == 0) {
                wattTableTableData2.rpm = 120;
                wattTableTableData2.level = 40;
            } else {
                wattTableTableData2.rpm = i2;
                wattTableTableData2.level = i3;
            }
            return wattTableTableData2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void calculateSpeed(IndoorBikeData indoorBikeData, WattTableTableData wattTableTableData) {
        Double dValueOf;
        Double dValueOf2 = null;
        if (indoorBikeData.getInstantaneousCadence() != null) {
            dValueOf = indoorBikeData.getInstantaneousCadence();
        } else {
            dValueOf = wattTableTableData != null ? Double.valueOf(wattTableTableData.rpm) : null;
        }
        if (dValueOf != null) {
            try {
                dValueOf2 = Double.valueOf(UnitConversionTool.getKm(dValueOf.doubleValue() * 0.00387d * 60.0d, 7));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dValueOf2 != null) {
            indoorBikeData.setInstantaneousSpeed(dValueOf2);
        }
    }

    private void calculateTotalDistanceSimpleFtms(IndoorBikeData indoorBikeData) {
        double dDoubleValue;
        if (indoorBikeData.getElapsedTime() == null || this.elapsedTimeOld == null || indoorBikeData.getElapsedTime().intValue() == this.elapsedTimeOld.intValue() || indoorBikeData.getInstantaneousSpeed() == null || indoorBikeData.getInstantaneousSpeed().doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        try {
            dDoubleValue = BigDecimal.valueOf(indoorBikeData.getInstantaneousSpeed().doubleValue() * 1000.0d).divide(BigDecimal.valueOf(3600L), 7, RoundingMode.HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            dDoubleValue = 0.0d;
        }
        Timber.d("calculateTotalDistanceSimpleFtms speedM_sec=%s", Double.valueOf(dDoubleValue));
        if (dDoubleValue > AudioStats.AUDIO_AMPLITUDE_NONE) {
            setTotalDistanceSimpleFtms(getTotalDistanceSimpleFtms() + dDoubleValue);
        }
    }

    private double getTotalDistanceSimpleFtms() {
        double d;
        synchronized (this.totalDistanceSimpleFtmsLock) {
            d = this.totalDistanceSimpleFtms;
        }
        return d;
    }

    private void setTotalDistanceSimpleFtms(double totalDistanceSimpleFtms) {
        synchronized (this.totalDistanceSimpleFtmsLock) {
            this.totalDistanceSimpleFtms = totalDistanceSimpleFtms;
            Timber.d("setTotalDistanceSimpleFtms totalDistanceSimpleFtms=%s", Double.valueOf(totalDistanceSimpleFtms));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:17|(1:19)(1:(1:22)(7:23|24|33|25|26|29|(2:31|32)(1:38)))|20|24|33|25|26|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        r9.printStackTrace();
        r4 = 0.0d;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calculateTotalEnergySimpleFtms(com.soletreadmills.sole_v2.ble.data.IndoorBikeData r9, com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBikeEjek.WattTableTableData r10) {
        /*
            r8 = this;
            java.lang.Integer r0 = r9.getElapsedTime()
            if (r0 == 0) goto L91
            java.lang.Integer r0 = r8.elapsedTimeOld
            if (r0 == 0) goto L91
            java.lang.Integer r0 = r9.getElapsedTime()
            int r0 = r0.intValue()
            java.lang.Integer r1 = r8.elapsedTimeOld
            int r1 = r1.intValue()
            if (r0 == r1) goto L91
            java.lang.Double r0 = r9.getInstantaneousSpeed()
            if (r0 != 0) goto L21
            return
        L21:
            java.lang.Double r0 = r9.getInstantaneousSpeed()
            double r0 = r0.doubleValue()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L30
            return
        L30:
            java.lang.Double r0 = r9.getInstantaneousSpeed()
            double r0 = r0.doubleValue()
            r4 = 7
            double r0 = com.soletreadmills.sole_v2.ble.tool.UnitConversionTool.getMi(r0, r4)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L42
            return
        L42:
            java.lang.Integer r4 = r9.getResistanceLevel()
            if (r4 == 0) goto L52
            java.lang.Integer r9 = r9.getResistanceLevel()
            int r9 = r9.intValue()
        L50:
            double r9 = (double) r9
            goto L58
        L52:
            if (r10 == 0) goto L57
            int r9 = r10.level
            goto L50
        L57:
            r9 = r2
        L58:
            r4 = 4623089132683890000(0x402883126e978d50, double:12.256)
            double r4 = r4 * r0
            r6 = 4608848750662144492(0x3ff5eb851eb851ec, double:1.37)
            double r0 = r0 * r6
            double r0 = r0 * r9
            double r4 = r4 + r0
            double r9 = r8.userWeightKg     // Catch: java.lang.Exception -> L73
            double r4 = r4 + r9
            r9 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r4 = r4 * r9
            r9 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            double r4 = r4 / r9
            goto L78
        L73:
            r9 = move-exception
            r9.printStackTrace()
            r4 = r2
        L78:
            java.lang.Double r9 = java.lang.Double.valueOf(r4)
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.String r10 = "calculateTotalEnergySimpleFtms calories=%s"
            timber.log.Timber.d(r10, r9)
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L91
            double r9 = r8.getTotalEnergySimpleFtms()
            double r9 = r9 + r4
            r8.setTotalEnergySimpleFtms(r9)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBikeEjek.calculateTotalEnergySimpleFtms(com.soletreadmills.sole_v2.ble.data.IndoorBikeData, com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBikeEjek$WattTableTableData):void");
    }

    private double getTotalEnergySimpleFtms() {
        double d;
        synchronized (this.totalEnergySimpleFtmsLock) {
            d = this.totalEnergySimpleFtms;
        }
        return d;
    }

    private void setTotalEnergySimpleFtms(double totalEnergySimpleFtms) {
        synchronized (this.totalEnergySimpleFtmsLock) {
            this.totalEnergySimpleFtms = totalEnergySimpleFtms;
            Timber.d("setTotalEnergySimpleFtms totalEnergySimpleFtms=%s", Double.valueOf(totalEnergySimpleFtms));
        }
    }
}
