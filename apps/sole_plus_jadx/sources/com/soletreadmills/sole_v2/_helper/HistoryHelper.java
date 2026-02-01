package com.soletreadmills.sole_v2._helper;

import android.content.Context;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.SrvoRefDataVo;
import com.soletreadmills.sole_v2._data.VideoRefDataVo;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.ClassesType;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2._type.WorkoutDataSourceType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HistoryHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/_helper/HistoryHelper;", "", "()V", "getCategoryType", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "data", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "getDisplayName", "getIcon", "", "getIconBackgroundColor", "getIconColor", "getRecordValue", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryHelper {
    public static final int $stable = 0;
    public static final HistoryHelper INSTANCE = new HistoryHelper();

    /* compiled from: HistoryHelper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[WorkoutDataSourceType.values().length];
            try {
                iArr[WorkoutDataSourceType.GARMIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkoutDataSourceType.SRVO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkoutDataSourceType.HOME_APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkoutDataSourceType.MACHINE_CONSOLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HistoryActivityType.values().length];
            try {
                iArr2[HistoryActivityType.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[HistoryActivityType.CYCLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[HistoryActivityType.STAIR_CLIMBING.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[HistoryActivityType.ROWING.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[HistoryActivityType.STRENGTH_AND_FUNCTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private HistoryHelper() {
    }

    public final String getDisplayName(Context context, WorkoutViewVo data) {
        String srvoName;
        Intrinsics.checkNotNullParameter(context, "context");
        if (data == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        if (Intrinsics.areEqual((Object) data.isPrimaryInDuplicateGroup(), (Object) false)) {
            String string = context.getString(R.string.overlapping_record);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[data.getDataSource().ordinal()];
        if (i == 1) {
            String string2 = context.getString(R.string.garmin_workout);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i == 2) {
            SrvoRefDataVo srvoRefData = data.getSrvoRefData();
            return (srvoRefData == null || (srvoName = srvoRefData.getSrvoName()) == null) ? SdkConstants.RES_QUALIFIER_SEP : srvoName;
        }
        VideoRefDataVo videoRefData = data.getVideoRefData();
        if (videoRefData != null) {
            String className = videoRefData.getClassName();
            return className == null ? SdkConstants.RES_QUALIFIER_SEP : className;
        }
        String programName = data.getProgramName();
        if (programName != null) {
            if (StringsKt.isBlank(programName)) {
                programName = null;
            }
            if (programName != null) {
                return programName;
            }
        }
        String string3 = context.getString(R.string.free_workout);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    public final int getIconColor(Context context, WorkoutViewVo data) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (data == null) {
            return ContextCompat.getColor(context, R.color.colorClass_classCardio);
        }
        if (WhenMappings.$EnumSwitchMapping$0[data.getDataSource().ordinal()] == 1) {
            return ContextCompat.getColor(context, R.color.color_garmin);
        }
        VideoRefDataVo videoRefData = data.getVideoRefData();
        if (videoRefData != null) {
            ClassesType.Companion companion = ClassesType.INSTANCE;
            String classType = videoRefData.getClassType();
            if (classType != null) {
                upperCase = classType.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            }
            ClassesType classesTypeFromApiValue = companion.fromApiValue(upperCase);
            return ContextCompat.getColor(context, classesTypeFromApiValue != null ? classesTypeFromApiValue.getColor() : R.color.colorClass_classRecovery);
        }
        String programName = data.getProgramName();
        if (programName != null) {
            if ((StringsKt.isBlank(programName) ? null : programName) != null) {
                return ContextCompat.getColor(context, R.color.colorClass_presentWorkout);
            }
        }
        return ContextCompat.getColor(context, R.color.colorClass_freeWorkout);
    }

    public final int getIconBackgroundColor(Context context, WorkoutViewVo data) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (data == null) {
            return ContextCompat.getColor(context, R.color.colorClass_classCardio_overly25);
        }
        if (WhenMappings.$EnumSwitchMapping$0[data.getDataSource().ordinal()] == 1) {
            return ContextCompat.getColor(context, R.color.color_garmin_overly25);
        }
        VideoRefDataVo videoRefData = data.getVideoRefData();
        if (videoRefData != null) {
            ClassesType.Companion companion = ClassesType.INSTANCE;
            String classType = videoRefData.getClassType();
            if (classType != null) {
                upperCase = classType.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            }
            ClassesType classesTypeFromApiValue = companion.fromApiValue(upperCase);
            return ContextCompat.getColor(context, classesTypeFromApiValue != null ? classesTypeFromApiValue.getColorBackground() : R.color.colorClass_classRecovery_overly25);
        }
        String programName = data.getProgramName();
        if (programName != null) {
            if ((StringsKt.isBlank(programName) ? null : programName) != null) {
                return ContextCompat.getColor(context, R.color.colorClass_presentWorkout_overly25);
            }
        }
        return ContextCompat.getColor(context, R.color.colorClass_freeWorkout_overly25);
    }

    public final int getIcon(Context context, WorkoutViewVo data) {
        String upperCase;
        String classType;
        Intrinsics.checkNotNullParameter(context, "context");
        if (data == null) {
            return R.drawable.sole;
        }
        if (data.getVideoRefData() != null) {
            ClassesType.Companion companion = ClassesType.INSTANCE;
            VideoRefDataVo videoRefData = data.getVideoRefData();
            if (videoRefData == null || (classType = videoRefData.getClassType()) == null) {
                upperCase = null;
            } else {
                upperCase = classType.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            }
            ClassesType classesTypeFromApiValue = companion.fromApiValue(upperCase);
            if (classesTypeFromApiValue == null) {
                return R.drawable.sole;
            }
            return classesTypeFromApiValue.getIcon();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[data.getDataSource().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return R.drawable.ic_activity_srvo_activity;
            }
            return data.getMachineCategoryType().getIcon();
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.TREADMILL_RUNNING)) {
            return R.drawable.ic_machine_treadmill;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.INDOOR_CYCLING)) {
            return R.drawable.ic_machine_bike;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.ELLIPTICAL)) {
            return R.drawable.ic_machine_elliptical;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.STAIR_CLIMBING)) {
            return R.drawable.ic_machine_stepper;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.INDOOR_ROWING)) {
            return R.drawable.ic_machine_rower;
        }
        return R.drawable.icon_shape;
    }

    public final String getCategoryType(Context context, WorkoutViewVo data) {
        String upperCase;
        String classType;
        Intrinsics.checkNotNullParameter(context, "context");
        if (data == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        if (Intrinsics.areEqual((Object) data.isPrimaryInDuplicateGroup(), (Object) false)) {
            int i = WhenMappings.$EnumSwitchMapping$0[data.getDataSource().ordinal()];
            if (i == 1) {
                String string = context.getString(R.string.garmin);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (i == 3) {
                String string2 = context.getString(R.string.bluetooth);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            if (i == 4) {
                String string3 = context.getString(R.string.sole_cloud);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            }
        }
        if (data.getVideoRefData() != null) {
            ClassesType.Companion companion = ClassesType.INSTANCE;
            VideoRefDataVo videoRefData = data.getVideoRefData();
            if (videoRefData == null || (classType = videoRefData.getClassType()) == null) {
                upperCase = null;
            } else {
                upperCase = classType.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            }
            ClassesType classesTypeFromApiValue = companion.fromApiValue(upperCase);
            if (classesTypeFromApiValue == null) {
                return SdkConstants.RES_QUALIFIER_SEP;
            }
            String string4 = context.getString(classesTypeFromApiValue.getStringKey());
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[data.getDataSource().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                String string5 = context.getString(R.string.srvo);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            }
            String string6 = context.getString(data.getMachineCategoryType().getTitle());
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.TREADMILL_RUNNING)) {
            String string7 = context.getString(R.string.treadmill);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.INDOOR_CYCLING)) {
            String string8 = context.getString(R.string.cycling);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            return string8;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.ELLIPTICAL)) {
            String string9 = context.getString(R.string.elliptical);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.STAIR_CLIMBING)) {
            String string10 = context.getString(R.string.stepper);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        }
        if (data.getHistoryActivityType().isInActivityType(HistoryActivityType.INDOOR_ROWING)) {
            String string11 = context.getString(R.string.rowing);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            return string11;
        }
        return data.getRootHistoryActivityType().getTitle(context);
    }

    public final String getRecordValue(Context context, WorkoutViewVo data) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        if (data == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        boolean unitType = Global.INSTANCE.getUnitType();
        int i = WhenMappings.$EnumSwitchMapping$1[data.getRootHistoryActivityType().ordinal()];
        if (i == 1) {
            if (unitType) {
                StringBuilder sb = new StringBuilder();
                ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                UnitConversion unitConversion = UnitConversion.INSTANCE;
                Number totalDistance = data.getTotalDistance();
                if (totalDistance == null) {
                    totalDistance = 0;
                }
                return sb.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils, unitConversion.getMi(totalDistance.toString(), 2), null, 2, null)).append(' ').append(context.getString(R.string.mi)).toString();
            }
            StringBuilder sb2 = new StringBuilder("");
            ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
            Number totalDistance2 = data.getTotalDistance();
            if (totalDistance2 == null) {
                totalDistance2 = 0;
            }
            return sb2.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils2, totalDistance2.toString(), null, 2, null)).append(' ').append(context.getString(R.string.km)).toString();
        }
        if (i == 2) {
            if (unitType) {
                StringBuilder sb3 = new StringBuilder();
                ConvertUtils convertUtils3 = ConvertUtils.INSTANCE;
                UnitConversion unitConversion2 = UnitConversion.INSTANCE;
                Number totalDistance3 = data.getTotalDistance();
                if (totalDistance3 == null) {
                    totalDistance3 = 0;
                }
                return sb3.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils3, unitConversion2.getMi(totalDistance3.toString(), 2), null, 2, null)).append(' ').append(context.getString(R.string.mi)).toString();
            }
            StringBuilder sb4 = new StringBuilder("");
            ConvertUtils convertUtils4 = ConvertUtils.INSTANCE;
            Number totalDistance4 = data.getTotalDistance();
            if (totalDistance4 == null) {
                totalDistance4 = 0;
            }
            return sb4.append(ConvertUtils.formatToTwoDecimalSmart$default(convertUtils4, totalDistance4.toString(), null, 2, null)).append(' ').append(context.getString(R.string.km)).toString();
        }
        if (i == 3) {
            if (unitType) {
                StringBuilder sb5 = new StringBuilder();
                ConvertUtils convertUtils5 = ConvertUtils.INSTANCE;
                UnitConversion unitConversion3 = UnitConversion.INSTANCE;
                Number totalDistance5 = data.getTotalDistance();
                if (totalDistance5 == null) {
                    totalDistance5 = 0;
                }
                return sb5.append(ConvertUtils.formatToOneDecimal02$default(convertUtils5, unitConversion3.getMi(totalDistance5.toString(), 1), null, 2, null)).append(' ').append(context.getString(R.string.ft)).toString();
            }
            StringBuilder sb6 = new StringBuilder("");
            ConvertUtils convertUtils6 = ConvertUtils.INSTANCE;
            Number totalDistance6 = data.getTotalDistance();
            if (totalDistance6 == null) {
                totalDistance6 = 0;
            }
            return sb6.append(ConvertUtils.formatToOneDecimal02$default(convertUtils6, totalDistance6.toString(), null, 2, null)).append(' ').append(context.getString(R.string.m)).toString();
        }
        if (i == 4) {
            StringBuilder sb7 = new StringBuilder("");
            ConvertUtils convertUtils7 = ConvertUtils.INSTANCE;
            Double totalDistance7 = data.getTotalDistance();
            return sb7.append(ConvertUtils.formatToOneDecimal02$default(convertUtils7, String.valueOf((totalDistance7 != null ? totalDistance7.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 1000), null, 2, null)).append(' ').append(context.getString(R.string.m)).toString();
        }
        if (i == 5) {
            if (data.getSrvoRefData() == null) {
                StringBuilder sb8 = new StringBuilder();
                ConvertUtils convertUtils8 = ConvertUtils.INSTANCE;
                Integer totalCalories = data.getTotalCalories();
                return sb8.append(ConvertUtils.formatToOneDecimal02$default(convertUtils8, String.valueOf(totalCalories != null ? totalCalories.intValue() : 0), null, 2, null)).append(' ').append(context.getString(R.string.kcal)).toString();
            }
            SrvoRefDataVo srvoRefData = data.getSrvoRefData();
            if (srvoRefData == null) {
                return SdkConstants.RES_QUALIFIER_SEP;
            }
            if (unitType) {
                StringBuilder sb9 = new StringBuilder();
                ConvertUtils convertUtils9 = ConvertUtils.INSTANCE;
                UnitConversion unitConversion4 = UnitConversion.INSTANCE;
                Number srvoTotalWeight = srvoRefData.getSrvoTotalWeight();
                if (srvoTotalWeight == null) {
                    srvoTotalWeight = 0;
                }
                string = sb9.append(ConvertUtils.formatToOneDecimal02$default(convertUtils9, unitConversion4.getLb(srvoTotalWeight.toString(), 1), null, 2, null)).append(' ').append(context.getString(R.string.lb)).toString();
            } else {
                StringBuilder sb10 = new StringBuilder("");
                ConvertUtils convertUtils10 = ConvertUtils.INSTANCE;
                Number srvoTotalWeight2 = srvoRefData.getSrvoTotalWeight();
                if (srvoTotalWeight2 == null) {
                    srvoTotalWeight2 = 0;
                }
                string = sb10.append(ConvertUtils.formatToOneDecimal02$default(convertUtils10, srvoTotalWeight2.toString(), null, 2, null)).append(' ').append(context.getString(R.string.kg)).toString();
            }
            return string == null ? SdkConstants.RES_QUALIFIER_SEP : string;
        }
        if (data.getVideoRefData() != null) {
            return TimeTools.secToTime02$default(TimeTools.INSTANCE, data.getTotalTime() != null ? r0.intValue() : 0L, false, 2, null);
        }
        StringBuilder sb11 = new StringBuilder();
        ConvertUtils convertUtils11 = ConvertUtils.INSTANCE;
        Integer totalCalories2 = data.getTotalCalories();
        return sb11.append(ConvertUtils.formatToOneDecimal02$default(convertUtils11, String.valueOf(totalCalories2 != null ? totalCalories2.intValue() : 0), null, 2, null)).append(' ').append(context.getString(R.string.kcal)).toString();
    }
}
