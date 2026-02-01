package com.soletreadmills.sole_v2._tools;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.blankj.utilcode.constant.CacheConstants;
import com.soletreadmills.sole_v2.AppConfig;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: UnitConversion.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0018\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001aJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0019\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001aJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001d\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0006¨\u0006*"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/UnitConversion;", "", "()V", "IntToRoman", "", "number", "", "convertFtInToCm", "heightStr", "scale", "examHeightCmRange", "", "cm", "examWeightKgLimit", "kg", "examWeightLbLimit", "lb", "getCm", SdkConstants.UNIT_IN, "ft", "getFt", "height", "getFtToM", "getHeightIn", "getIn", "getKg", "", "getKm", "mi", "getLb", "getLbCeiling", "getM_ToFt", "m", "getM_ToFtByDown", "getMi", "km", "isImperialUnitByCountryCode", "secToTime", "time", "secToTimeMinute", "unitFormat", "i", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnitConversion {
    public static final int $stable = 0;
    public static final UnitConversion INSTANCE = new UnitConversion();

    private UnitConversion() {
    }

    public final String getFt(String height) {
        return getFt(height, 7);
    }

    public final String getFt(String height, int scale) throws NumberFormatException {
        double d;
        if (height == null || height.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(height);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).divide(BigDecimal.valueOf(2.54d), scale, RoundingMode.HALF_UP).floatValue() / 12.0f);
    }

    public final String getHeightIn(String height) {
        return getHeightIn(height, 7);
    }

    public final String getHeightIn(String height, int scale) throws NumberFormatException {
        double d;
        if (height == null || height.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(height);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).divide(BigDecimal.valueOf(2.54d), scale, RoundingMode.HALF_UP).floatValue() % 12.0f);
    }

    public final String getIn(String cm) {
        return getIn(cm, 7);
    }

    public final String getIn(String cm, int scale) throws NumberFormatException {
        double d;
        if (cm == null || cm.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(cm);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).divide(BigDecimal.valueOf(2.54d), scale, RoundingMode.HALF_UP).floatValue());
    }

    public final String getCm(String in) {
        Intrinsics.checkNotNullParameter(in, "in");
        return getCm(in, 7);
    }

    public final String getCm(String in, int scale) throws NumberFormatException {
        double d;
        Intrinsics.checkNotNullParameter(in, "in");
        try {
            d = Double.parseDouble(in);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(2.54d)).setScale(scale, RoundingMode.HALF_UP).floatValue());
    }

    public final String getCm(String ft, String in) {
        Intrinsics.checkNotNullParameter(ft, "ft");
        Intrinsics.checkNotNullParameter(in, "in");
        return getCm(ft, in, 7);
    }

    public final String getCm(String ft, String in, int scale) throws NumberFormatException {
        double d;
        Intrinsics.checkNotNullParameter(ft, "ft");
        Intrinsics.checkNotNullParameter(in, "in");
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        try {
            d = Double.parseDouble(ft);
        } catch (Exception e) {
            e = e;
            d = 0.0d;
        }
        try {
            d2 = Double.parseDouble(in);
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            String plainString = BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(12L)).add(BigDecimal.valueOf(d2)).multiply(BigDecimal.valueOf(2.54d)).setScale(scale, RoundingMode.HALF_UP).toPlainString();
            Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
            return plainString;
        }
        String plainString2 = BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(12L)).add(BigDecimal.valueOf(d2)).multiply(BigDecimal.valueOf(2.54d)).setScale(scale, RoundingMode.HALF_UP).toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString2, "toPlainString(...)");
        return plainString2;
    }

    public final synchronized String getLb(String kg) {
        return getLb(kg, 7);
    }

    public static /* synthetic */ String convertFtInToCm$default(UnitConversion unitConversion, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return unitConversion.convertFtInToCm(str, i);
    }

    public final String convertFtInToCm(String heightStr, int scale) {
        Intrinsics.checkNotNullParameter(heightStr, "heightStr");
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d+)'[\\s]?(\\d+)\\\""), heightStr, 0, 2, null);
        if (matchResultFind$default != null) {
            MatchResult.Destructured destructured = matchResultFind$default.getDestructured();
            String str = destructured.getMatch().getGroupValues().get(1);
            String str2 = destructured.getMatch().getGroupValues().get(2);
            Double doubleOrNull = StringsKt.toDoubleOrNull(str);
            double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
            double dDoubleValue2 = doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d;
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(str2);
            if (doubleOrNull2 != null) {
                dDoubleValue = doubleOrNull2.doubleValue();
            }
            String string = new BigDecimal(((dDoubleValue2 * 12) + dDoubleValue) * 2.54d).setScale(scale, RoundingMode.HALF_UP).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        return "0";
    }

    public final String getLb(String kg, int scale) throws NumberFormatException {
        double d;
        if (kg == null || kg.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(kg);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(2.20462262d)).setScale(scale, RoundingMode.HALF_UP).floatValue());
    }

    public final synchronized double getLb(double kg) {
        if (kg == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return BigDecimal.valueOf(kg).multiply(BigDecimal.valueOf(2.20462262d)).doubleValue();
    }

    public final synchronized double getLb(double kg, int scale) {
        if (kg == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return BigDecimal.valueOf(kg).multiply(BigDecimal.valueOf(2.20462262d)).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public final synchronized double getLbCeiling(double kg, int scale) {
        if (kg == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return BigDecimal.valueOf(getLb(kg)).setScale(scale, RoundingMode.CEILING).doubleValue();
    }

    public final String getKg(String lb) {
        return getKg(lb, 7);
    }

    public final String getKg(String lb, int scale) throws NumberFormatException {
        double d;
        if (lb == null || lb.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(lb);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(0.45359237d)).setScale(scale, RoundingMode.HALF_UP).floatValue());
    }

    public final double getKg(double lb) {
        return lb == AudioStats.AUDIO_AMPLITUDE_NONE ? AudioStats.AUDIO_AMPLITUDE_NONE : BigDecimal.valueOf(lb).multiply(BigDecimal.valueOf(0.45359237d)).doubleValue();
    }

    public final double getKg(double lb, int scale) {
        return lb == AudioStats.AUDIO_AMPLITUDE_NONE ? AudioStats.AUDIO_AMPLITUDE_NONE : BigDecimal.valueOf(lb).multiply(BigDecimal.valueOf(0.45359237d)).setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    public final boolean examWeightKgLimit(String kg) {
        Double doubleOrNull;
        if (kg == null || (doubleOrNull = StringsKt.toDoubleOrNull(kg)) == null) {
            return true;
        }
        double dDoubleValue = doubleOrNull.doubleValue();
        return 30.0d <= dDoubleValue && dDoubleValue <= 180.0d;
    }

    public final boolean examWeightLbLimit(String lb) {
        Double doubleOrNull;
        if (lb == null || (doubleOrNull = StringsKt.toDoubleOrNull(lb)) == null) {
            return true;
        }
        double dDoubleValue = doubleOrNull.doubleValue();
        return 40.0d <= dDoubleValue && dDoubleValue <= 400.0d;
    }

    public final boolean examHeightCmRange(String cm) {
        Double doubleOrNull;
        if (cm == null || (doubleOrNull = StringsKt.toDoubleOrNull(cm)) == null) {
            return true;
        }
        double dDoubleValue = doubleOrNull.doubleValue();
        return 61.0d <= dDoubleValue && dDoubleValue <= 272.0d;
    }

    public final String getM_ToFt(String m) {
        return getM_ToFt(m, 7);
    }

    public final String getM_ToFt(String m, int scale) throws NumberFormatException {
        double d;
        if (m == null || m.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(m);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).divide(BigDecimal.valueOf(0.3048d), scale, RoundingMode.HALF_UP).floatValue());
    }

    public final String getM_ToFtByDown(String m, int scale) throws NumberFormatException {
        double d;
        if (m == null || m.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(m);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).divide(BigDecimal.valueOf(0.3048d), scale, RoundingMode.DOWN).floatValue());
    }

    public final String getFtToM(String ft) {
        return getFtToM(ft, 7);
    }

    public final String getFtToM(String ft, int scale) throws NumberFormatException {
        double d;
        if (ft == null || ft.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(ft);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(0.3048d)).setScale(scale, RoundingMode.HALF_UP).floatValue());
    }

    public final String getMi(String km) {
        return getMi(km, 7);
    }

    public final String getMi(String km, int scale) throws NumberFormatException {
        double d;
        if (km == null || km.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(km);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).divide(BigDecimal.valueOf(1.609d), scale, RoundingMode.HALF_UP).floatValue());
    }

    public final String getKm(String mi) {
        return getKm(mi, 7);
    }

    public final String getKm(String mi, int scale) throws NumberFormatException {
        double d;
        if (mi == null || mi.length() == 0) {
            return "";
        }
        try {
            d = Double.parseDouble(mi);
        } catch (Exception e) {
            e.printStackTrace();
            d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        return String.valueOf(BigDecimal.valueOf(d).multiply(BigDecimal.valueOf(1.609d)).setScale(scale, RoundingMode.HALF_UP).floatValue());
    }

    public final String secToTime(int time) {
        if (time <= 0) {
            return "00:00";
        }
        int i = time / 60;
        if (i < 60) {
            return unitFormat(i) + ':' + unitFormat(time % 60);
        }
        int i2 = i / 60;
        int i3 = i % 60;
        return unitFormat(i2) + ':' + unitFormat(i3) + ':' + unitFormat((time - (i2 * CacheConstants.HOUR)) - (i3 * 60));
    }

    public final String secToTimeMinute(int time) {
        if (time <= 0) {
            return "00:00";
        }
        return unitFormat(time / 60) + ':' + unitFormat(time % 60);
    }

    public final String unitFormat(int i) {
        if (i >= 0 && i < 10) {
            return "0" + i;
        }
        return "" + i;
    }

    public final String IntToRoman(int number) {
        return new String[]{"", "M", "MM", "MMM"}[number / 1000] + new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}[(number % 1000) / 100] + new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}[(number % 100) / 10] + new String[]{"", "I", "II", "III", "IV", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "VI", "VII", "VIII", "IX"}[number % 10];
    }

    public final boolean isImperialUnitByCountryCode() {
        return Intrinsics.areEqual(AppConfig.INSTANCE.getHEADER_COUNTRY_CODE(), "US");
    }
}
