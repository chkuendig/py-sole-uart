package com.soletreadmills.sole_v2.ble.helper;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.soletreadmills.sole_v2._type.DyacoWorkoutDataSource;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.tool.UnitConversionTool;
import com.sun.jna.platform.linux.Fcntl;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.platform.win32.WinNT;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import no.nordicsemi.android.ble.data.Data;
import org.objectweb.asm.Opcodes;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class SimpleFftmsHelperEllipticalEjek extends SimpleFftmsHelperBase {
    private Integer heartRateOld;
    private Integer instantaneousPowerOld;
    private double totalDistanceSimpleFtms;
    private final Object totalDistanceSimpleFtmsLock;
    private double totalEnergySimpleFtms;
    private final Object totalEnergySimpleFtmsLock;
    private final int[][] wattTableArr;

    @Override // com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase
    public void onTimerRunBind() {
    }

    public SimpleFftmsHelperEllipticalEjek(double userWeightKg, boolean isFemale) {
        super(userWeightKg, isFemale);
        int[] iArr = new int[23];
        // fill-array-data instruction
        iArr[0] = 11;
        iArr[1] = 28;
        iArr[2] = 44;
        iArr[3] = 69;
        iArr[4] = 94;
        iArr[5] = 125;
        iArr[6] = 155;
        iArr[7] = 189;
        iArr[8] = 223;
        iArr[9] = 261;
        iArr[10] = 298;
        iArr[11] = 336;
        iArr[12] = 374;
        iArr[13] = 414;
        iArr[14] = 453;
        iArr[15] = 494;
        iArr[16] = 535;
        iArr[17] = 578;
        iArr[18] = 621;
        iArr[19] = 665;
        iArr[20] = 708;
        iArr[21] = 751;
        iArr[22] = 793;
        this.wattTableArr = new int[][]{new int[]{3, 7, 10, 15, 20, 26, 31, 38, 45, 54, 62, 70, 77, 85, 93, 101, 109, 131, 152, 163, 173, Opcodes.INVOKESTATIC, 194}, new int[]{3, 8, 12, 18, 24, 31, 37, 46, 54, 64, 74, 83, 92, 102, 112, 123, 134, 156, Opcodes.RETURN, 190, 202, WinError.ERROR_TOO_MANY_MODULES, WinError.ERROR_VIRUS_DELETED}, new int[]{4, 9, 13, 20, 26, 34, DyacoWorkoutDataSource.SPIRIT_CLUB_MOBILE_APP, 50, 59, 71, 82, 92, 102, 114, 125, 137, 149, 174, 199, 213, 227, 241, 254}, new int[]{4, 9, 14, 22, 29, 38, 47, 57, 67, 80, 92, 104, 116, 129, 141, 155, Opcodes.JSR, 193, WinError.ERROR_EXE_CANNOT_MODIFY_STRONG_SIGNED_BINARY, WinError.ERROR_PIPE_NOT_CONNECTED, 248, 263, WinError.ERROR_INVALID_EA_HANDLE}, new int[]{4, 10, 16, 24, 32, 42, 52, 64, 76, 90, 104, 118, 131, 145, 158, 173, 187, WinError.ERROR_TOO_MANY_MODULES, 241, 258, 275, Data.FORMAT_SINT32_BE, 308}, new int[]{5, 11, 17, 27, 36, 47, 57, 71, 85, 100, 114, 128, 142, 158, 174, 191, WinError.ERROR_META_EXPANSION_TOO_LONG, 236, 263, WinError.ERROR_EAS_NOT_SUPPORTED, 300, 318, 336}, new int[]{5, 13, 20, 30, 40, 53, 66, 81, 95, 113, 130, 146, 162, 180, 198, WinError.ERROR_EXE_CANNOT_MODIFY_STRONG_SIGNED_BINARY, 238, 268, WinError.ERROR_TOO_MANY_POSTS, WinNT.SERVICE_TYPE_ALL, 340, 361, 381}, new int[]{6, 14, 22, 34, 46, 61, 75, 92, 109, 128, 146, 165, Opcodes.INVOKESTATIC, 204, WinError.ERROR_FILE_TOO_LARGE, 244, 265, WinError.ERROR_PARTIAL_COPY, 333, 357, 380, 403, 426}, new int[]{6, 16, 25, 39, 52, 69, 86, 105, 124, 146, Opcodes.JSR, 190, WinError.ERROR_LOCKED, WinError.ERROR_MORE_DATA, 256, 281, 305, 344, 382, 409, 435, 461, WinError.ERROR_INVALID_ADDRESS}, new int[]{7, 18, 28, 43, 58, 77, 96, 118, 140, Opcodes.IF_ACMPNE, 192, WinError.ERROR_EXE_CANNOT_MODIFY_SIGNED_BINARY, 241, WinError.ERROR_CANNOT_COPY, Data.FORMAT_SINT16_BE, 318, 346, 385, TypedValues.CycleType.TYPE_WAVE_OFFSET, 454, 483, 512, WinError.ERROR_TIMER_NOT_CANCELED}, new int[]{8, 20, 31, 49, 66, 88, 110, 135, 159, 188, WinError.ERROR_EXE_MACHINE_TYPE_MISMATCH, 243, 270, WinError.ERROR_TOO_MANY_POSTS, 326, 358, 390, 421, 452, 484, 515, WinError.ERROR_PORT_MESSAGE_TOO_LONG, WinError.ERROR_INVALID_IMAGE_HASH}, new int[]{9, 22, 35, 55, 75, 100, 125, 152, Opcodes.GETSTATIC, WinError.ERROR_THREAD_1_INACTIVE, 242, 273, 303, 335, 366, 400, 434, 469, TypedValues.PositionType.TYPE_PERCENT_WIDTH, WinError.ERROR_ABIOS_ERROR, WinError.ERROR_MISSING_SYSTEMFILE, 608, WinError.ERROR_PORT_NOT_SET}, new int[]{10, 25, 40, 62, 83, 111, 139, 170, 200, 235, 269, 304, 338, 375, DyacoWorkoutDataSource.SPIRIT_CLUB_MOBILE_APP, Fcntl.S_IRWXU, 485, 524, WinError.ERROR_INVALID_LDT_OFFSET, 603, WinError.ERROR_PORT_NOT_SET, WinError.ERROR_STOPPED_ON_SYMLINK, 719}, iArr, new int[]{13, 31, 49, 77, 105, 140, 174, 211, 248, 289, 330, 372, 413, 457, 500, WinError.ERROR_INVALID_PORT_ATTRIBUTES, WinError.ERROR_DEBUG_ATTACH_FAILED, WinError.ERROR_SYSTEM_IMAGE_BAD_SIGNATURE, WinError.ERROR_UNWIND_CONSOLIDATE, WinError.ERROR_WAIT_2, WinError.ERROR_DISK_REPAIR_DISABLED, 827, 873}, new int[]{14, 35, 56, 87, 118, 156, 193, WinError.ERROR_MORE_DATA, 275, 321, 366, FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 457, TypedValues.PositionType.TYPE_SIZE_PERCENT, WinError.ERROR_PROFILING_AT_LIMIT, 603, WinError.ERROR_DRIVER_DATABASE_ERROR, 704, WinError.ERROR_RESOURCE_REQUIREMENTS_CHANGED, 809, 862, 914, 965}, new int[]{16, 41, 66, 102, 138, 180, WinError.ERROR_BAD_FILE_TYPE, 271, 320, 366, FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 464, 515, WinError.ERROR_SYNCHRONIZATION_REQUIRED, 623, WinError.ERROR_MEDIA_CHECK, WinError.ERROR_ABANDONED_WAIT_0, 794, 852, 912, 971, 1029, 1087}, new int[]{18, 46, 73, 112, 150, 197, 244, Data.FORMAT_SINT24_BE, 337, 398, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 515, WinError.ERROR_CONTROL_C_EXIT, WinError.ERROR_NOINTERFACE, WinError.ERROR_DBG_TERMINATE_PROCESS, WinError.ERROR_BUFFER_ALL_ZEROS, 816, 882, 947, 1014, WinError.ERROR_CANNOT_DETECT_DRIVER_FAILURE, 1145, WinError.ERROR_INVALID_COMPUTERNAME}, new int[]{20, 49, 78, 120, 162, 211, 260, 307, WinError.ERROR_MAX_SESSIONS_REACHED, 417, 480, WinError.ERROR_WX86_ERROR, 600, 663, WinError.ERROR_HIBERNATED, 792, 857, 926, WinError.ERROR_EA_ACCESS_DENIED, WinError.ERROR_EXCEPTION_IN_SERVICE, 1133, WinError.ERROR_CONNECTION_UNAVAIL, 1269}, new int[]{22, 53, 84, 129, 174, WinError.ERROR_BAD_FILE_TYPE, 270, 320, 370, 437, TypedValues.PositionType.TYPE_PERCENT_WIDTH, WinError.ERROR_THREAD_NOT_IN_PROCESS, WinError.ERROR_CANT_ENABLE_DENY_ONLY, WinError.ERROR_DBG_RIPEXCEPTION, WinError.ERROR_VOLSNAP_HIBERNATE_READY, 830, 898, 970, 1042, WinError.ERROR_SHUTDOWN_IN_PROGRESS, 1188, WinError.ERROR_APPHELP_BLOCK, WinError.ERROR_PASSWORD_EXPIRED}};
        this.instantaneousPowerOld = null;
        this.heartRateOld = null;
        this.totalDistanceSimpleFtms = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.totalDistanceSimpleFtmsLock = new Object();
        this.totalEnergySimpleFtms = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.totalEnergySimpleFtmsLock = new Object();
    }

    @Override // com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase
    public FtmsBaseData processDataBind(FtmsBaseData ftmsBaseData) {
        Integer num;
        CrossTrainerData crossTrainerData = new CrossTrainerData();
        if (ftmsBaseData != null) {
            crossTrainerData.setBleName(ftmsBaseData.getBleName());
            crossTrainerData.setMacAddress(ftmsBaseData.getMacAddress());
            crossTrainerData.setElapsedTime(ftmsBaseData.getElapsedTime());
            if (ftmsBaseData.getHeartRate() != null) {
                crossTrainerData.setHeartRate(ftmsBaseData.getHeartRate());
            }
        }
        if (ftmsBaseData instanceof IndoorBikeData) {
            IndoorBikeData indoorBikeData = (IndoorBikeData) ftmsBaseData;
            if (indoorBikeData.getInstantaneousPower() != null) {
                crossTrainerData.setInstantaneousPower(indoorBikeData.getInstantaneousPower());
            }
            if (indoorBikeData.getInstantaneousCadence() != null) {
                crossTrainerData.setStepPerMinute(Double.valueOf(indoorBikeData.getInstantaneousCadence().doubleValue() * 2.0d));
            }
        }
        if (crossTrainerData.getInstantaneousPower() == null && (num = this.instantaneousPowerOld) != null) {
            crossTrainerData.setInstantaneousPower(num);
        }
        if (crossTrainerData.getHeartRate() != null) {
            crossTrainerData.setHeartRate(null);
        }
        WattTableTableData wattTableTableDataFindWattTableTableData = crossTrainerData.getInstantaneousPower() != null ? findWattTableTableData(crossTrainerData.getInstantaneousPower().intValue()) : null;
        calculateSpeed(crossTrainerData, wattTableTableDataFindWattTableTableData);
        calculateTotalDistanceSimpleFtms(crossTrainerData);
        crossTrainerData.setTotalDistance(Integer.valueOf((int) getTotalDistanceSimpleFtms()));
        calculateTotalEnergySimpleFtms(crossTrainerData, wattTableTableDataFindWattTableTableData);
        crossTrainerData.setTotalEnergy(Integer.valueOf((int) getTotalEnergySimpleFtms()));
        if (crossTrainerData.getInstantaneousPower() != null) {
            this.instantaneousPowerOld = crossTrainerData.getInstantaneousPower();
        }
        if (crossTrainerData.getInstantaneousPower() == null && crossTrainerData.getHeartRate() == null) {
            this.instantaneousPowerOld = null;
            this.heartRateOld = null;
        }
        return crossTrainerData;
    }

    private void calculateRpmAndLevel(CrossTrainerData crossTrainerData) {
        WattTableTableData wattTableTableDataFindWattTableTableData = crossTrainerData.getInstantaneousPower() != null ? findWattTableTableData(crossTrainerData.getInstantaneousPower().intValue()) : null;
        if (wattTableTableDataFindWattTableTableData != null) {
            int i = wattTableTableDataFindWattTableTableData.rpm;
            int i2 = wattTableTableDataFindWattTableTableData.level;
            if (crossTrainerData.getStepPerMinute() == null) {
                crossTrainerData.setStepPerMinute(Double.valueOf(i * 2.0d));
            }
            if (crossTrainerData.getResistanceLevel() == null) {
                crossTrainerData.setResistanceLevel(Integer.valueOf(i2));
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
            for (int i5 = 0; i5 < 23; i5++) {
                int i6 = 0;
                while (true) {
                    if (i6 >= 20) {
                        break;
                    }
                    int i7 = this.wattTableArr[i6][i5];
                    if (i7 == power) {
                        i2 = (i5 * 5) + 10;
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
                            i2 = (i5 * 5) + 10;
                            i3 = i6 + 1;
                        } else if (Math.abs(this.wattTableArr[i6][i5] - power) == iAbs) {
                            int i9 = this.wattTableArr[i6][i5];
                            if (i4 == i9) {
                                int i10 = (i5 * 5) + 10;
                                if (i2 >= i10) {
                                    i3 = i6 + 1;
                                    i2 = i10;
                                }
                            } else if (i4 > i9) {
                                i2 = (i5 * 5) + 10;
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
                wattTableTableData2.level = 20;
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

    private void calculateSpeed(CrossTrainerData crossTrainerData, WattTableTableData wattTableTableData) {
        Double dValueOf;
        Double dValueOf2 = null;
        if (crossTrainerData.getStepPerMinute() != null) {
            dValueOf = Double.valueOf(crossTrainerData.getStepPerMinute().doubleValue() / 2.0d);
        } else {
            dValueOf = wattTableTableData != null ? Double.valueOf(wattTableTableData.rpm) : null;
        }
        if (dValueOf != null) {
            try {
                dValueOf2 = Double.valueOf(UnitConversionTool.getKm(dValueOf.doubleValue() * 0.00114d * 60.0d, 7));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dValueOf2 != null) {
            crossTrainerData.setInstantaneousSpeed(dValueOf2);
        }
    }

    private void calculateTotalDistanceSimpleFtms(CrossTrainerData crossTrainerData) {
        double dDoubleValue;
        if (crossTrainerData.getElapsedTime() == null || this.elapsedTimeOld == null || crossTrainerData.getElapsedTime().intValue() == this.elapsedTimeOld.intValue() || crossTrainerData.getInstantaneousSpeed() == null || crossTrainerData.getInstantaneousSpeed().doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        try {
            dDoubleValue = BigDecimal.valueOf(crossTrainerData.getInstantaneousSpeed().doubleValue() * 1000.0d).divide(BigDecimal.valueOf(3600L), 7, RoundingMode.HALF_UP).doubleValue();
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
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        r9.printStackTrace();
        r4 = 0.0d;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calculateTotalEnergySimpleFtms(com.soletreadmills.sole_v2.ble.data.CrossTrainerData r9, com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperEllipticalEjek.WattTableTableData r10) {
        /*
            r8 = this;
            java.lang.Integer r0 = r9.getElapsedTime()
            if (r0 == 0) goto L8e
            java.lang.Integer r0 = r8.elapsedTimeOld
            if (r0 == 0) goto L8e
            java.lang.Integer r0 = r9.getElapsedTime()
            int r0 = r0.intValue()
            java.lang.Integer r1 = r8.elapsedTimeOld
            int r1 = r1.intValue()
            if (r0 == r1) goto L8e
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
            r6 = 4615063718147915776(0x400c000000000000, double:3.5)
            double r0 = r0 * r6
            double r0 = r0 * r9
            double r4 = r4 + r0
            double r9 = r8.userWeightKg     // Catch: java.lang.Exception -> L70
            double r4 = r4 + r9
            r9 = 4612811918334230528(0x4004000000000000, double:2.5)
            double r4 = r4 * r9
            r9 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            double r4 = r4 / r9
            goto L75
        L70:
            r9 = move-exception
            r9.printStackTrace()
            r4 = r2
        L75:
            java.lang.Double r9 = java.lang.Double.valueOf(r4)
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            java.lang.String r10 = "calculateTotalEnergySimpleFtms calories=%s"
            timber.log.Timber.d(r10, r9)
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L8e
            double r9 = r8.getTotalEnergySimpleFtms()
            double r9 = r9 + r4
            r8.setTotalEnergySimpleFtms(r9)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperEllipticalEjek.calculateTotalEnergySimpleFtms(com.soletreadmills.sole_v2.ble.data.CrossTrainerData, com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperEllipticalEjek$WattTableTableData):void");
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
