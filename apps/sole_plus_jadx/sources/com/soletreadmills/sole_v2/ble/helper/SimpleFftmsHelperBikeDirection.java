package com.soletreadmills.sole_v2.ble.helper;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class SimpleFftmsHelperBikeDirection extends SimpleFftmsHelperBase {
    private double totalDistanceSimpleFtms;
    private final Object totalDistanceSimpleFtmsLock;
    private double totalEnergySimpleFtms;
    private final Object totalEnergySimpleFtmsLock;

    public SimpleFftmsHelperBikeDirection(double userWeightKg, boolean isFemale) {
        super(userWeightKg, isFemale);
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
        Timber.d("processDataBind", new Object[0]);
        if (ftmsBaseData instanceof IndoorBikeData) {
            IndoorBikeData indoorBikeData = (IndoorBikeData) ftmsBaseData;
            calculateSpeed(indoorBikeData);
            calculateTotalDistanceSimpleFtms(indoorBikeData);
            indoorBikeData.setTotalDistance(Integer.valueOf((int) getTotalDistanceSimpleFtms()));
            calculateTotalEnergySimpleFtms(indoorBikeData);
            indoorBikeData.setTotalEnergy(Integer.valueOf((int) getTotalEnergySimpleFtms()));
        }
        return ftmsBaseData;
    }

    private void calculateSpeed(IndoorBikeData indoorBikeData) {
        Double dValueOf;
        if (indoorBikeData.getInstantaneousCadence() != null) {
            try {
                dValueOf = Double.valueOf(((indoorBikeData.getInstantaneousCadence().doubleValue() * 6667.0d) * 60.0d) / 1000000.0d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            dValueOf = null;
        }
        if (dValueOf != null) {
            indoorBikeData.setInstantaneousSpeed(dValueOf);
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

    private void calculateTotalEnergySimpleFtms(IndoorBikeData indoorBikeData) {
        if (indoorBikeData.getElapsedTime() == null || this.elapsedTimeOld == null || indoorBikeData.getElapsedTime().intValue() == this.elapsedTimeOld.intValue() || indoorBikeData.getInstantaneousSpeed() == null || indoorBikeData.getInstantaneousSpeed().doubleValue() < AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        double d = this.userWeightKg > AudioStats.AUDIO_AMPLITUDE_NONE ? this.userWeightKg : 70.0d;
        double dIntValue = 1.0d;
        double d2 = (indoorBikeData.getInstantaneousSpeed().doubleValue() < 0.1d || indoorBikeData.getInstantaneousSpeed().doubleValue() >= 16.0d) ? (indoorBikeData.getInstantaneousSpeed().doubleValue() < 16.0d || indoorBikeData.getInstantaneousSpeed().doubleValue() >= 24.0d) ? (indoorBikeData.getInstantaneousSpeed().doubleValue() < 24.0d || indoorBikeData.getInstantaneousSpeed().doubleValue() >= 32.0d) ? (indoorBikeData.getInstantaneousSpeed().doubleValue() < 32.0d || indoorBikeData.getInstantaneousSpeed().doubleValue() >= 40.0d) ? (indoorBikeData.getInstantaneousSpeed().doubleValue() < 40.0d || indoorBikeData.getInstantaneousSpeed().doubleValue() >= 48.0d) ? indoorBikeData.getInstantaneousSpeed().doubleValue() >= 48.0d ? 6.0d : 0.0d : 5.0d : 4.0d : 3.0d : 2.0d : 1.0d;
        double d3 = this.isFemale ? 123.0d : 176.0d;
        if (indoorBikeData.getHeartRate() != null && indoorBikeData.getHeartRate().intValue() > 0) {
            dIntValue = indoorBikeData.getHeartRate().intValue() / 100.0d;
        }
        double d4 = (((d2 * d) * d3) * dIntValue) / 160000.0d;
        Timber.d("calculateTotalEnergySimpleFtms calories=%s", Double.valueOf(d4));
        if (d4 > AudioStats.AUDIO_AMPLITUDE_NONE) {
            setTotalEnergySimpleFtms(getTotalEnergySimpleFtms() + d4);
        }
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
