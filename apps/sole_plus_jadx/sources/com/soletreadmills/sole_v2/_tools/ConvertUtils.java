package com.soletreadmills.sole_v2._tools;

import androidx.camera.video.AudioStats;
import com.android.SdkConstants;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ConvertUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u001a\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u001a\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0019J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001b\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/ConvertUtils;", "", "()V", "diffDouble", "", IInstrumentationResultParser.StatusKeys.CURRENT, "first", "(Ljava/lang/Double;Ljava/lang/Double;)D", "diffFloat", "", "(Ljava/lang/Float;Ljava/lang/Float;)F", "diffInt", "", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "displayDiffInt", "", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "formatToIntegerRounded", "input", SdkConstants.SKIN_DEFAULT, "formatToOneDecimal", "formatToOneDecimal02", "formatToTwoDecimalSmart", "toDouble", "value", "(Ljava/lang/Integer;)Ljava/lang/Double;", "(Ljava/lang/String;)Ljava/lang/Double;", "toInt", "(Ljava/lang/Double;)Ljava/lang/Integer;", "(Ljava/lang/String;)Ljava/lang/Integer;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConvertUtils {
    public static final int $stable = 0;
    public static final ConvertUtils INSTANCE = new ConvertUtils();

    private ConvertUtils() {
    }

    public final Integer toInt(String value) {
        if (value == null) {
            return null;
        }
        try {
            String string = StringsKt.trim((CharSequence) value).toString();
            if (string != null) {
                return Integer.valueOf(Integer.parseInt(string));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final Double toDouble(String value) {
        if (value == null) {
            return null;
        }
        try {
            String string = StringsKt.trim((CharSequence) value).toString();
            if (string != null) {
                return Double.valueOf(Double.parseDouble(string));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final Integer toInt(Double value) {
        if (value != null) {
            return Integer.valueOf((int) value.doubleValue());
        }
        return null;
    }

    public final Double toDouble(Integer value) {
        if (value != null) {
            return Double.valueOf(value.intValue());
        }
        return null;
    }

    public static /* synthetic */ String formatToOneDecimal$default(ConvertUtils convertUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = SdkConstants.RES_QUALIFIER_SEP;
        }
        return convertUtils.formatToOneDecimal(str, str2);
    }

    public final String formatToOneDecimal(String input, String str) {
        Double doubleOrNull;
        Intrinsics.checkNotNullParameter(str, "default");
        if (input != null) {
            try {
                doubleOrNull = StringsKt.toDoubleOrNull(input);
            } catch (Exception unused) {
                return str;
            }
        } else {
            doubleOrNull = null;
        }
        if (doubleOrNull == null) {
            return str;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{doubleOrNull}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static /* synthetic */ String formatToIntegerRounded$default(ConvertUtils convertUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = SdkConstants.RES_QUALIFIER_SEP;
        }
        return convertUtils.formatToIntegerRounded(str, str2);
    }

    public final String formatToIntegerRounded(String input, String str) {
        Intrinsics.checkNotNullParameter(str, "default");
        if (input == null) {
            return str;
        }
        try {
            Double doubleOrNull = StringsKt.toDoubleOrNull(input);
            return doubleOrNull != null ? String.valueOf((int) Math.rint(doubleOrNull.doubleValue())) : str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ String formatToOneDecimal02$default(ConvertUtils convertUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = SdkConstants.RES_QUALIFIER_SEP;
        }
        return convertUtils.formatToOneDecimal02(str, str2);
    }

    public final String formatToOneDecimal02(String input, String str) {
        Intrinsics.checkNotNullParameter(str, "default");
        if (input == null) {
            return str;
        }
        try {
            Double doubleOrNull = StringsKt.toDoubleOrNull(input);
            if (doubleOrNull == null) {
                return str;
            }
            double dDoubleValue = doubleOrNull.doubleValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return StringsKt.removeSuffix(str2, (CharSequence) ".0");
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ String formatToTwoDecimalSmart$default(ConvertUtils convertUtils, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = SdkConstants.RES_QUALIFIER_SEP;
        }
        return convertUtils.formatToTwoDecimalSmart(str, str2);
    }

    public final String formatToTwoDecimalSmart(String input, String str) {
        Intrinsics.checkNotNullParameter(str, "default");
        if (input == null) {
            return str;
        }
        try {
            Double doubleOrNull = StringsKt.toDoubleOrNull(input);
            if (doubleOrNull == null) {
                return str;
            }
            String str2 = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.US)).format(doubleOrNull.doubleValue());
            Intrinsics.checkNotNull(str2);
            return str2;
        } catch (Exception unused) {
            return str;
        }
    }

    public final int diffInt(Integer current, Integer first) {
        return (current != null ? current.intValue() : 0) - (first != null ? first.intValue() : 0);
    }

    public final float diffFloat(Float current, Float first) {
        return (current != null ? current.floatValue() : 0.0f) - (first != null ? first.floatValue() : 0.0f);
    }

    public final double diffDouble(Double current, Double first) {
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        double dDoubleValue2 = current != null ? current.doubleValue() : 0.0d;
        if (first != null) {
            dDoubleValue = first.doubleValue();
        }
        return dDoubleValue2 - dDoubleValue;
    }

    public final String displayDiffInt(Integer current, Integer first) {
        return String.valueOf(RangesKt.coerceAtLeast(diffInt(current, first), 0));
    }
}
