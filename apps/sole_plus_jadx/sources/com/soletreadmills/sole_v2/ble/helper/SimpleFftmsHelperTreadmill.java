package com.soletreadmills.sole_v2.ble.helper;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class SimpleFftmsHelperTreadmill extends SimpleFftmsHelperBase {
    private Integer heartRateOld;
    private Double instantaneousSpeedOld;
    private double totalDistanceSimpleFtms;
    private final Object totalDistanceSimpleFtmsLock;
    private double totalEnergySimpleFtms;
    private final Object totalEnergySimpleFtmsLock;

    public SimpleFftmsHelperTreadmill(double userWeightKg, boolean isFemale) {
        super(userWeightKg, isFemale);
        this.totalDistanceSimpleFtms = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.totalDistanceSimpleFtmsLock = new Object();
        this.totalEnergySimpleFtms = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.totalEnergySimpleFtmsLock = new Object();
        this.instantaneousSpeedOld = null;
        this.heartRateOld = null;
    }

    @Override // com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase
    public void onTimerRunBind() {
        Timber.d("onTimerRunBind", new Object[0]);
    }

    @Override // com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperBase
    public FtmsBaseData processDataBind(FtmsBaseData ftmsBaseData) {
        Double d;
        Timber.d("processDataBind", new Object[0]);
        if (ftmsBaseData instanceof TreadmillData) {
            TreadmillData treadmillData = (TreadmillData) ftmsBaseData;
            if (treadmillData.getInstantaneousSpeed() == null && (d = this.instantaneousSpeedOld) != null) {
                treadmillData.setInstantaneousSpeed(d);
            }
            if (treadmillData.getHeartRate() != null) {
                treadmillData.setHeartRate(null);
            }
            calculateTotalDistanceSimpleFtms(treadmillData);
            treadmillData.setTotalDistance(Integer.valueOf((int) getTotalDistanceSimpleFtms()));
            calculatePaceSimpleFtms(treadmillData);
            calculateTotalEnergySimpleFtms(treadmillData);
            treadmillData.setTotalEnergy(Integer.valueOf((int) getTotalEnergySimpleFtms()));
            if (treadmillData.getInstantaneousSpeed() != null) {
                this.instantaneousSpeedOld = treadmillData.getInstantaneousSpeed();
            }
            if (treadmillData.getInstantaneousSpeed() == null && treadmillData.getHeartRate() == null) {
                this.instantaneousSpeedOld = null;
                this.heartRateOld = null;
            }
        }
        return ftmsBaseData;
    }

    private void calculateTotalDistanceSimpleFtms(TreadmillData treadmillData) {
        double dDoubleValue;
        if (treadmillData.getElapsedTime() == null || this.elapsedTimeOld == null || treadmillData.getElapsedTime().intValue() == this.elapsedTimeOld.intValue() || treadmillData.getInstantaneousSpeed() == null || treadmillData.getInstantaneousSpeed().doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        try {
            dDoubleValue = BigDecimal.valueOf(treadmillData.getInstantaneousSpeed().doubleValue() * 1000.0d).divide(BigDecimal.valueOf(3600L), 7, RoundingMode.HALF_UP).doubleValue();
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calculatePaceSimpleFtms(com.soletreadmills.sole_v2.ble.data.TreadmillData r8) {
        /*
            r7 = this;
            java.lang.Double r0 = r8.getInstantaneousSpeed()
            r1 = 0
            if (r0 == 0) goto L32
            java.lang.Double r0 = r8.getInstantaneousSpeed()
            double r3 = r0.doubleValue()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L32
            java.math.BigDecimal r0 = java.math.BigDecimal.ONE     // Catch: java.lang.Exception -> L2e
            java.lang.Double r3 = r8.getInstantaneousSpeed()     // Catch: java.lang.Exception -> L2e
            double r3 = r3.doubleValue()     // Catch: java.lang.Exception -> L2e
            java.math.BigDecimal r3 = java.math.BigDecimal.valueOf(r3)     // Catch: java.lang.Exception -> L2e
            java.math.RoundingMode r4 = java.math.RoundingMode.HALF_UP     // Catch: java.lang.Exception -> L2e
            r5 = 7
            java.math.BigDecimal r0 = r0.divide(r3, r5, r4)     // Catch: java.lang.Exception -> L2e
            double r3 = r0.doubleValue()     // Catch: java.lang.Exception -> L2e
            goto L33
        L2e:
            r0 = move-exception
            r0.printStackTrace()
        L32:
            r3 = r1
        L33:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4c
            r5 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            double r3 = r3 * r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4c
            r0 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            double r3 = r3 * r0
            java.lang.Double r0 = java.lang.Double.valueOf(r3)
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 == 0) goto L52
            r8.setInstantaneousPace(r0)
        L52:
            java.lang.String r8 = "calculatePaceSimpleFtms paceSec_100m=%s"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            timber.log.Timber.d(r8, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperTreadmill.calculatePaceSimpleFtms(com.soletreadmills.sole_v2.ble.data.TreadmillData):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calculateTotalEnergySimpleFtms(com.soletreadmills.sole_v2.ble.data.TreadmillData r14) {
        /*
            r13 = this;
            java.lang.Integer r0 = r14.getElapsedTime()
            if (r0 == 0) goto Ldc
            java.lang.Integer r0 = r13.elapsedTimeOld
            if (r0 == 0) goto Ldc
            java.lang.Integer r0 = r14.getElapsedTime()
            int r0 = r0.intValue()
            java.lang.Integer r1 = r13.elapsedTimeOld
            int r1 = r1.intValue()
            if (r0 == r1) goto Ldc
            java.lang.Double r0 = r14.getInstantaneousSpeed()
            if (r0 != 0) goto L21
            return
        L21:
            java.lang.Double r0 = r14.getInstantaneousSpeed()
            double r0 = r0.doubleValue()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L30
            return
        L30:
            double r0 = r13.userWeightKg
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L37
            return
        L37:
            java.lang.Double r0 = r14.getInstantaneousSpeed()
            double r0 = r0.doubleValue()
            r4 = 7
            double r0 = com.soletreadmills.sole_v2.ble.tool.UnitConversionTool.getMi(r0, r4)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L49
            return
        L49:
            java.lang.Double r4 = r14.getInclination()
            if (r4 == 0) goto L63
            java.lang.Double r14 = r14.getInclination()     // Catch: java.lang.Exception -> L5f
            double r4 = r14.doubleValue()     // Catch: java.lang.Exception -> L5f
            double r4 = java.lang.Math.abs(r4)     // Catch: java.lang.Exception -> L5f
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 / r6
            goto L64
        L5f:
            r14 = move-exception
            r14.printStackTrace()
        L63:
            r4 = r2
        L64:
            r6 = 4615514078110652826(0x400d99999999999a, double:3.7)
            int r14 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            r6 = 3
            r7 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r14 >= 0) goto L9c
            r11 = 4605092748572917498(0x3fe89374bc6a7efa, double:0.768)
            double r11 = r11 * r0
            double r11 = r11 + r9
            r9 = 4594103965482133488(0x3fc189374bc6a7f0, double:0.137)
            double r0 = r0 * r9
            double r0 = r0 * r4
            double r11 = r11 + r0
            double r0 = r13.userWeightKg     // Catch: java.lang.Exception -> L97
            double r11 = r11 * r0
            double r11 = r11 / r7
            java.math.BigDecimal r14 = java.math.BigDecimal.valueOf(r11)     // Catch: java.lang.Exception -> L97
            java.math.RoundingMode r0 = java.math.RoundingMode.DOWN     // Catch: java.lang.Exception -> L97
            java.math.BigDecimal r14 = r14.setScale(r6, r0)     // Catch: java.lang.Exception -> L97
            double r0 = r14.doubleValue()     // Catch: java.lang.Exception -> L97
            goto Lc3
        L97:
            r14 = move-exception
            r14.printStackTrace()
            goto Lc2
        L9c:
            r11 = 4609578333801778512(0x3ff883126e978d50, double:1.532)
            double r11 = r11 * r0
            double r11 = r11 + r9
            r9 = 4589600365854762992(0x3fb189374bc6a7f0, double:0.0685)
            double r0 = r0 * r9
            double r0 = r0 * r4
            double r11 = r11 + r0
            double r0 = r13.userWeightKg     // Catch: java.lang.Exception -> Lbe
            double r11 = r11 * r0
            double r11 = r11 / r7
            java.math.BigDecimal r14 = java.math.BigDecimal.valueOf(r11)     // Catch: java.lang.Exception -> Lbe
            java.math.RoundingMode r0 = java.math.RoundingMode.DOWN     // Catch: java.lang.Exception -> Lbe
            java.math.BigDecimal r14 = r14.setScale(r6, r0)     // Catch: java.lang.Exception -> Lbe
            double r0 = r14.doubleValue()     // Catch: java.lang.Exception -> Lbe
            goto Lc3
        Lbe:
            r14 = move-exception
            r14.printStackTrace()
        Lc2:
            r0 = r2
        Lc3:
            java.lang.Double r14 = java.lang.Double.valueOf(r0)
            java.lang.Object[] r14 = new java.lang.Object[]{r14}
            java.lang.String r4 = "calculateTotalEnergySimpleFtms calories=%s"
            timber.log.Timber.d(r4, r14)
            int r14 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r14 <= 0) goto Ldc
            double r2 = r13.getTotalEnergySimpleFtms()
            double r2 = r2 + r0
            r13.setTotalEnergySimpleFtms(r2)
        Ldc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ble.helper.SimpleFftmsHelperTreadmill.calculateTotalEnergySimpleFtms(com.soletreadmills.sole_v2.ble.data.TreadmillData):void");
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
