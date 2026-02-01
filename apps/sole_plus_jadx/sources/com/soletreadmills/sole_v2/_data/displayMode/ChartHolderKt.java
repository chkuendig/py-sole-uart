package com.soletreadmills.sole_v2._data.displayMode;

import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartHolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"getChartColors", "Lkotlin/Pair;", "", "statsType", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChartHolderKt {

    /* compiled from: ChartHolder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayStatsType.values().length];
            try {
                iArr[DisplayStatsType.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayStatsType.INCLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayStatsType.RESISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DisplayStatsType.OUTPUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DisplayStatsType.CADENCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Pair<Integer, Integer> getChartColors(DisplayStatsType statsType) {
        Intrinsics.checkNotNullParameter(statsType, "statsType");
        int i = WhenMappings.$EnumSwitchMapping$0[statsType.ordinal()];
        if (i == 1) {
            return TuplesKt.to(Integer.valueOf(R.color.colorStats_speed), Integer.valueOf(R.color.colorStats_speed30));
        }
        if (i == 2) {
            return TuplesKt.to(Integer.valueOf(R.color.colorStats_incline), Integer.valueOf(R.color.colorStats_incline30));
        }
        if (i == 3) {
            return TuplesKt.to(Integer.valueOf(R.color.colorStats_resistance), Integer.valueOf(R.color.colorStats_resistance30));
        }
        if (i == 4) {
            return TuplesKt.to(Integer.valueOf(R.color.colorStats_output), Integer.valueOf(R.color.colorStats_output30));
        }
        if (i == 5) {
            return TuplesKt.to(Integer.valueOf(R.color.colorStats_cadence), Integer.valueOf(R.color.colorStats_cadence30));
        }
        return TuplesKt.to(Integer.valueOf(R.color.colorStats_speed), Integer.valueOf(R.color.colorStats_speed30));
    }
}
