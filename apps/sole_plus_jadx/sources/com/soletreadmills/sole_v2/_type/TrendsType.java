package com.soletreadmills.sole_v2._type;

import android.content.Context;
import androidx.camera.video.AudioStats;
import com.android.SdkConstants;
import com.blankj.utilcode.constant.CacheConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.TrendItemWithDWM;
import com.soletreadmills.sole_v2._data.UserWorkout12WeeklyStatsVoData;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TrendsType.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006/"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/TrendsType;", "", "titleResId", "", "captionResId", "colorResId", "(Ljava/lang/String;IIII)V", "getCaptionResId", "()I", "getColorResId", "getTitleResId", "formatValue", "", "value", "", "(Ljava/lang/Double;)Ljava/lang/String;", "getThreeMonthsDetailData", "Lcom/soletreadmills/sole_v2/_data/TrendItemWithDWM;", "threeMonthsData", "Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "getUnit", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "convertedPace", "unitType", "", "TIME", "DISTANCE", "DISTANCE_M", "CALORIES", "HR", "RUNNING_PACE", "INCLINE", "CADENCE_RPM", "OUTPUT", "SPEED", "CADENCE_SPM", "ROWING_PACE", "ASCENT", "FLOORS", "STEPS", "RESISTANCE", "STRIDE", "STROKE", "WEIGHT", "REPS", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrendsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TrendsType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int captionResId;
    private final int colorResId;
    private final int titleResId;
    public static final TrendsType TIME = new TrendsType("TIME", 0, R.string.trends_time, R.string.trends_avg_per_week, R.color.colorStats_time);
    public static final TrendsType DISTANCE = new TrendsType("DISTANCE", 1, R.string.trends_distance, R.string.trends_avg_per_week, R.color.colorStats_distance);
    public static final TrendsType DISTANCE_M = new TrendsType("DISTANCE_M", 2, R.string.trends_distance, R.string.trends_avg_per_week, R.color.colorStats_distance);
    public static final TrendsType CALORIES = new TrendsType("CALORIES", 3, R.string.trends_calories, R.string.trends_avg_per_week, R.color.colorStats_calories);
    public static final TrendsType HR = new TrendsType("HR", 4, R.string.trends_heart_rate, R.string.trends_avg, R.color.colorStats_hr);
    public static final TrendsType RUNNING_PACE = new TrendsType("RUNNING_PACE", 5, R.string.trends_pace, R.string.trends_avg, R.color.colorStats_pace);
    public static final TrendsType INCLINE = new TrendsType("INCLINE", 6, R.string.trends_incline, R.string.trends_avg, R.color.colorStats_incline);
    public static final TrendsType CADENCE_RPM = new TrendsType("CADENCE_RPM", 7, R.string.trends_cadence, R.string.trends_avg, R.color.colorStats_cadence);
    public static final TrendsType OUTPUT = new TrendsType("OUTPUT", 8, R.string.trends_output, R.string.trends_avg, R.color.colorStats_output);
    public static final TrendsType SPEED = new TrendsType("SPEED", 9, R.string.trends_speed, R.string.trends_avg, R.color.colorStats_speed);
    public static final TrendsType CADENCE_SPM = new TrendsType("CADENCE_SPM", 10, R.string.trends_cadence, R.string.trends_avg, R.color.colorStats_cadence);
    public static final TrendsType ROWING_PACE = new TrendsType("ROWING_PACE", 11, R.string.trends_pace, R.string.trends_avg, R.color.colorStats_pace);
    public static final TrendsType ASCENT = new TrendsType("ASCENT", 12, R.string.trends_ascent, R.string.trends_avg_per_week, R.color.colorStats_ascent);
    public static final TrendsType FLOORS = new TrendsType("FLOORS", 13, R.string.trends_floors, R.string.trends_avg_per_week, R.color.colorStats_floors);
    public static final TrendsType STEPS = new TrendsType("STEPS", 14, R.string.trends_steps, R.string.trends_avg_per_week, R.color.colorGlobal_black);
    public static final TrendsType RESISTANCE = new TrendsType("RESISTANCE", 15, R.string.resistance, R.string.trends_avg, R.color.colorStats_resistance);
    public static final TrendsType STRIDE = new TrendsType("STRIDE", 16, R.string.stride, R.string.trends_avg_per_week, R.color.colorStats_count);
    public static final TrendsType STROKE = new TrendsType("STROKE", 17, R.string.stroke, R.string.trends_avg_per_week, R.color.colorStats_count);
    public static final TrendsType WEIGHT = new TrendsType("WEIGHT", 18, R.string.weight, R.string.trends_avg_per_week, R.color.colorStats_resistance);
    public static final TrendsType REPS = new TrendsType("REPS", 19, R.string.reps, R.string.trends_avg_per_week, R.color.colorStats_count);

    /* compiled from: TrendsType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TrendsType.values().length];
            try {
                iArr[TrendsType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrendsType.DISTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TrendsType.DISTANCE_M.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TrendsType.CALORIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TrendsType.HR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TrendsType.RUNNING_PACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TrendsType.INCLINE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TrendsType.CADENCE_RPM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TrendsType.CADENCE_SPM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TrendsType.OUTPUT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TrendsType.SPEED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[TrendsType.ASCENT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[TrendsType.STEPS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[TrendsType.FLOORS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[TrendsType.ROWING_PACE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[TrendsType.RESISTANCE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[TrendsType.STRIDE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[TrendsType.STROKE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[TrendsType.WEIGHT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[TrendsType.REPS.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ TrendsType[] $values() {
        return new TrendsType[]{TIME, DISTANCE, DISTANCE_M, CALORIES, HR, RUNNING_PACE, INCLINE, CADENCE_RPM, OUTPUT, SPEED, CADENCE_SPM, ROWING_PACE, ASCENT, FLOORS, STEPS, RESISTANCE, STRIDE, STROKE, WEIGHT, REPS};
    }

    private final double convertedPace(double d, boolean z) {
        return z ? d * 1.609344d : d;
    }

    public static EnumEntries<TrendsType> getEntries() {
        return $ENTRIES;
    }

    public static TrendsType valueOf(String str) {
        return (TrendsType) Enum.valueOf(TrendsType.class, str);
    }

    public static TrendsType[] values() {
        return (TrendsType[]) $VALUES.clone();
    }

    private TrendsType(String str, int i, int i2, int i3, int i4) {
        this.titleResId = i2;
        this.captionResId = i3;
        this.colorResId = i4;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getCaptionResId() {
        return this.captionResId;
    }

    public final int getColorResId() {
        return this.colorResId;
    }

    static {
        TrendsType[] trendsTypeArr$values = $values();
        $VALUES = trendsTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(trendsTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: TrendsType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/TrendsType$Companion;", "", "()V", "getTrends", "", "Lcom/soletreadmills/sole_v2/_type/TrendsType;", "activityType", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: TrendsType.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HistoryActivityType.values().length];
                try {
                    iArr[HistoryActivityType.RUNNING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[HistoryActivityType.CYCLING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[HistoryActivityType.ELLIPTICAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[HistoryActivityType.STAIR_CLIMBING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[HistoryActivityType.ROWING.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[HistoryActivityType.WALKING_AND_HIKING.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[HistoryActivityType.STRENGTH_AND_FUNCTION.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<TrendsType> getTrends(HistoryActivityType activityType) {
            Intrinsics.checkNotNullParameter(activityType, "activityType");
            switch (WhenMappings.$EnumSwitchMapping$0[activityType.ordinal()]) {
                case 1:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.DISTANCE, TrendsType.CALORIES, TrendsType.HR, TrendsType.RUNNING_PACE, TrendsType.INCLINE});
                case 2:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.DISTANCE, TrendsType.CALORIES, TrendsType.HR, TrendsType.SPEED, TrendsType.CADENCE_RPM, TrendsType.OUTPUT, TrendsType.RESISTANCE});
                case 3:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.DISTANCE, TrendsType.CALORIES, TrendsType.HR, TrendsType.STRIDE, TrendsType.CADENCE_RPM, TrendsType.OUTPUT, TrendsType.INCLINE, TrendsType.RESISTANCE});
                case 4:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.ASCENT, TrendsType.CALORIES, TrendsType.HR, TrendsType.STRIDE, TrendsType.CADENCE_SPM, TrendsType.OUTPUT, TrendsType.RESISTANCE});
                case 5:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.DISTANCE_M, TrendsType.CALORIES, TrendsType.HR, TrendsType.STROKE, TrendsType.ROWING_PACE, TrendsType.CADENCE_SPM, TrendsType.OUTPUT, TrendsType.RESISTANCE});
                case 6:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.DISTANCE, TrendsType.CALORIES, TrendsType.HR, TrendsType.STRIDE, TrendsType.CADENCE_SPM});
                case 7:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.CALORIES, TrendsType.HR, TrendsType.WEIGHT, TrendsType.REPS});
                default:
                    return CollectionsKt.listOf((Object[]) new TrendsType[]{TrendsType.TIME, TrendsType.CALORIES, TrendsType.HR});
            }
        }
    }

    public final TrendItemWithDWM<Double> getThreeMonthsDetailData(UserWorkout12WeeklyStatsVoData threeMonthsData) {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgTimePerWeek();
                }
                return null;
            case 2:
            case 3:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgDistancePerWeek();
                }
                return null;
            case 4:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgCaloriesPerWeek();
                }
                return null;
            case 5:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgHeartRate();
                }
                return null;
            case 6:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgPace();
                }
                return null;
            case 7:
            case 12:
            case 14:
                return null;
            case 8:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgCadence();
                }
                return null;
            case 9:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgCadence();
                }
                return null;
            case 10:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgWatt();
                }
                return null;
            case 11:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgSpeed();
                }
                return null;
            case 13:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgStepsPerWeek();
                }
                return null;
            case 15:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgPace();
                }
                return null;
            case 16:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgLevel();
                }
                return null;
            case 17:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgStepsPerWeek();
                }
                return null;
            case 18:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgStrokePerWeek();
                }
                return null;
            case 19:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgWeightsPerWeek();
                }
                return null;
            case 20:
                if (threeMonthsData != null) {
                    return threeMonthsData.getAvgRepsPerWeek();
                }
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String formatValue(Double value) {
        boolean unitType = Global.INSTANCE.getUnitType();
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? String.valueOf(value.doubleValue() / CacheConstants.HOUR) : null, "--");
            case 2:
                if (unitType) {
                    return ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getMi(value != null ? value.toString() : null), "--");
                }
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 3:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf((value != null ? value.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 1000), "--");
            case 4:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 5:
                return ConvertUtils.INSTANCE.formatToIntegerRounded(value != null ? value.toString() : null, "--");
            case 6:
                long jConvertedPace = value != null ? (long) convertedPace(value.doubleValue(), unitType) : 0L;
                return jConvertedPace <= 0 ? "--" : TimeTools.INSTANCE.secToTime03(jConvertedPace);
            case 7:
            case 12:
            case 14:
                return "--";
            case 8:
                return ConvertUtils.INSTANCE.formatToIntegerRounded(value != null ? value.toString() : null, "--");
            case 9:
                return ConvertUtils.INSTANCE.formatToIntegerRounded(value != null ? value.toString() : null, "--");
            case 10:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 11:
                if (unitType) {
                    return ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getMi(value != null ? value.toString() : null), "--");
                }
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 13:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 15:
                long jDoubleValue = value != null ? (long) value.doubleValue() : 0L;
                return jDoubleValue <= 0 ? "--" : TimeTools.INSTANCE.secToTime03(jDoubleValue);
            case 16:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 17:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 18:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 19:
                if (unitType) {
                    return ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getLb(value != null ? value.toString() : null), "--");
                }
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            case 20:
                return ConvertUtils.INSTANCE.formatToOneDecimal02(value != null ? value.toString() : null, "--");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getUnit(Context context) {
        String string;
        String string2;
        String string3;
        String string4;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean unitType = Global.INSTANCE.getUnitType();
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                String string5 = context.getString(R.string.h);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            case 2:
                if (unitType) {
                    string = context.getString(R.string.mi);
                } else {
                    string = context.getString(R.string.km);
                }
                String str = string;
                Intrinsics.checkNotNull(str);
                return str;
            case 3:
                String string6 = context.getString(R.string.m);
                Intrinsics.checkNotNull(string6);
                return string6;
            case 4:
                String string7 = context.getString(R.string.kcal);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            case 5:
                String string8 = context.getString(R.string.bpm);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                return string8;
            case 6:
                String string9 = context.getString(R.string.min02);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                return string9;
            case 7:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 20:
                return "";
            case 8:
                String string10 = context.getString(R.string.rpm);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                return string10;
            case 9:
                String string11 = context.getString(R.string.spm);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            case 10:
                String string12 = context.getString(R.string.watts);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                return string12;
            case 11:
                if (unitType) {
                    string2 = context.getString(R.string.mph);
                } else {
                    string2 = context.getString(R.string.km_h);
                }
                String str2 = string2;
                Intrinsics.checkNotNull(str2);
                return str2;
            case 12:
                if (unitType) {
                    string3 = context.getString(R.string.ft);
                } else {
                    string3 = context.getString(R.string.m);
                }
                String str3 = string3;
                Intrinsics.checkNotNull(str3);
                return str3;
            case 15:
                String string13 = context.getString(R.string.m_500);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                return string13;
            case 19:
                if (unitType) {
                    string4 = context.getString(R.string.lb);
                } else {
                    string4 = context.getString(R.string.kg);
                }
                String str4 = string4;
                Intrinsics.checkNotNull(str4);
                return str4;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
