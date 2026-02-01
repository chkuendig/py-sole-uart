package com.soletreadmills.sole_v2.ble.tool;

import androidx.camera.video.AudioStats;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes5.dex */
public class UnitConversionTool {
    public static double getMi(double km, int scale) {
        try {
            return BigDecimal.valueOf(km).divide(BigDecimal.valueOf(1.609d), scale, RoundingMode.HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public static double getKm(double mi, int scale) {
        try {
            return BigDecimal.valueOf(mi).multiply(BigDecimal.valueOf(1.609d)).setScale(scale, RoundingMode.HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }
}
