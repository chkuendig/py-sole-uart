package com.soletreadmills.sole_v2.ui.customview;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.goal.GoalTimeFrame;
import com.soletreadmills.sole_v2._data.goal.GoalsStatsType;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoalsDetailView.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\t\u001a\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"getFormattedGoalsValue", "", "currentValue", "", "statsType", "", "unitType", "", "timeFrame", "(Ljava/lang/Double;IZI)Ljava/lang/String;", "getGoalsTimeLeftUnit", "isPlural", "app_release", "intFormat", "Ljava/text/DecimalFormat;"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsDetailViewKt {
    public static final String getFormattedGoalsValue(Double d, int i, boolean z, int i2) {
        String str;
        String str2;
        double dDoubleValue = d != null ? d.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        Lazy lazy = LazyKt.lazy(new Function0<DecimalFormat>() { // from class: com.soletreadmills.sole_v2.ui.customview.GoalsDetailViewKt$getFormattedGoalsValue$intFormat$2
            @Override // kotlin.jvm.functions.Function0
            public final DecimalFormat invoke() {
                DecimalFormat decimalFormat = new DecimalFormat("#0", DecimalFormatSymbols.getInstance(Locale.US));
                decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
                return decimalFormat;
            }
        });
        if (i == GoalsStatsType.TotalDistance.getId()) {
            if (z) {
                str2 = getFormattedGoalsValue$lambda$0(lazy).format(Double.parseDouble(UnitConversion.INSTANCE.getMi(String.valueOf(dDoubleValue), 0)));
            } else {
                str2 = getFormattedGoalsValue$lambda$0(lazy).format(Double.parseDouble(ConvertUtils.formatToOneDecimal$default(ConvertUtils.INSTANCE, String.valueOf(dDoubleValue), null, 2, null)));
            }
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        if (i == GoalsStatsType.ActiveMinutes.getId()) {
            if (i2 == GoalTimeFrame.Daily.getId()) {
                str = getFormattedGoalsValue$lambda$0(lazy).format(dDoubleValue);
            } else {
                str = getFormattedGoalsValue$lambda$0(lazy).format(dDoubleValue / 60);
            }
            Intrinsics.checkNotNull(str);
            return str;
        }
        if (i == GoalsStatsType.WorkoutCounts.getId()) {
            String str3 = getFormattedGoalsValue$lambda$0(lazy).format(dDoubleValue);
            Intrinsics.checkNotNull(str3);
            return str3;
        }
        if (i == GoalsStatsType.TotalCalories.getId()) {
            String str4 = getFormattedGoalsValue$lambda$0(lazy).format(dDoubleValue);
            Intrinsics.checkNotNull(str4);
            return str4;
        }
        if (i == GoalsStatsType.TotalStrokes.getId()) {
            String str5 = getFormattedGoalsValue$lambda$0(lazy).format(dDoubleValue);
            Intrinsics.checkNotNull(str5);
            return str5;
        }
        if (i == GoalsStatsType.TotalSteps.getId()) {
            String str6 = getFormattedGoalsValue$lambda$0(lazy).format(dDoubleValue);
            Intrinsics.checkNotNull(str6);
            return str6;
        }
        return String.valueOf(dDoubleValue);
    }

    private static final DecimalFormat getFormattedGoalsValue$lambda$0(Lazy<? extends DecimalFormat> lazy) {
        return lazy.getValue();
    }

    public static final int getGoalsTimeLeftUnit(int i, boolean z) {
        if (i == GoalTimeFrame.Daily.getId()) {
            if (!z) {
                return R.string.hour;
            }
            return R.string.hours;
        }
        if (i == GoalTimeFrame.Weekly.getId()) {
            if (!z) {
                return R.string.day;
            }
            return R.string.days;
        }
        if (i != GoalTimeFrame.Monthly.getId()) {
            return R.string.empty_text;
        }
        if (!z) {
            return R.string.day;
        }
        return R.string.days;
    }
}
