package com.ua.sdk.recorder.datasource.derived;

/* loaded from: classes2.dex */
public class DistanceBearingCalculator {
    public static void calculateDistanceAndBearing(double d, double d2, double d3, double d4, float[] fArr) {
        double d5;
        double d6;
        double d7 = (0.017453292519943295d * d4) - (d2 * 0.017453292519943295d);
        double dAtan = Math.atan(Math.tan(d * 0.017453292519943295d) * 0.996647189328169d);
        double dAtan2 = Math.atan(0.996647189328169d * Math.tan(d3 * 0.017453292519943295d));
        double dCos = Math.cos(dAtan);
        double dCos2 = Math.cos(dAtan2);
        double dSin = Math.sin(dAtan);
        double dSin2 = Math.sin(dAtan2);
        double d8 = dCos * dCos2;
        double d9 = dSin * dSin2;
        double d10 = d7;
        double dCos3 = 0.0d;
        double d11 = 0.0d;
        double dSin3 = 0.0d;
        double dAtan22 = 0.0d;
        double d12 = 0.0d;
        int i = 0;
        while (true) {
            if (i >= 20) {
                d5 = dSin;
                d6 = dSin2;
                break;
            }
            dCos3 = Math.cos(d10);
            dSin3 = Math.sin(d10);
            double d13 = dCos2 * dSin3;
            double d14 = (dCos * dSin2) - ((dSin * dCos2) * dCos3);
            d5 = dSin;
            double dSqrt = Math.sqrt((d13 * d13) + (d14 * d14));
            d6 = dSin2;
            double d15 = d9 + (d8 * dCos3);
            dAtan22 = Math.atan2(dSqrt, d15);
            double d16 = dSqrt == 0.0d ? 0.0d : (d8 * dSin3) / dSqrt;
            double d17 = 1.0d - (d16 * d16);
            double d18 = d17 == 0.0d ? 0.0d : d15 - ((d9 * 2.0d) / d17);
            double d19 = 0.006739496756586903d * d17;
            double d20 = ((d19 / 16384.0d) * (((((320.0d - (175.0d * d19)) * d19) - 768.0d) * d19) + 4096.0d)) + 1.0d;
            double d21 = (d19 / 1024.0d) * ((d19 * (((74.0d - (47.0d * d19)) * d19) - 128.0d)) + 256.0d);
            double d22 = 2.0955066698943685E-4d * d17 * (((4.0d - (d17 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d23 = d18 * d18;
            d12 = d21 * dSqrt * (d18 + ((d21 / 4.0d) * ((((d23 * 2.0d) - 1.0d) * d15) - ((((d21 / 6.0d) * d18) * (((dSqrt * 4.0d) * dSqrt) - 3.0d)) * ((d23 * 4.0d) - 3.0d)))));
            double d24 = d7 + ((1.0d - d22) * 0.0033528106718309896d * d16 * (dAtan22 + (dSqrt * d22 * (d18 + (d22 * d15 * (((2.0d * d18) * d18) - 1.0d))))));
            if (Math.abs((d24 - d10) / d24) < 1.0E-12d) {
                d11 = d20;
                break;
            }
            i++;
            dSin = d5;
            dSin2 = d6;
            d10 = d24;
            d11 = d20;
        }
        fArr[0] = (float) (6356752.3142d * d11 * (dAtan22 - d12));
        if (fArr.length > 1) {
            double d25 = d6 * dCos;
            double d26 = d5;
            fArr[1] = (float) (((float) Math.atan2(dCos2 * dSin3, d25 - ((d26 * dCos2) * dCos3))) * 57.29577951308232d);
            if (fArr.length > 2) {
                fArr[2] = (float) (((float) Math.atan2(dCos * dSin3, ((-d26) * dCos2) + (d25 * dCos3))) * 57.29577951308232d);
            }
        }
    }
}
