package com.ua.sdk.internal;

import com.ua.sdk.IntensityCalculator;
import com.ua.sdk.heartrate.HeartRateZones;

/* loaded from: classes2.dex */
public class IntensityCalculatorImpl implements IntensityCalculator {
    @Override // com.ua.sdk.IntensityCalculator
    public double calculateCurrentIntensity(HeartRateZones heartRateZones, double d) {
        if (heartRateZones == null) {
            return 0.0d;
        }
        double maxHr = getMaxHr(heartRateZones) - 10.0d;
        if (maxHr <= 0.0d) {
            return 0.0d;
        }
        return Math.max(0.0d, Math.min(100.0d, (((d * 2.22d) / maxHr) - 1.22d) * 100.0d));
    }

    private double getMaxHr(HeartRateZones heartRateZones) {
        return heartRateZones.getZone(heartRateZones.getZones().size() - 1).getEnd();
    }
}
