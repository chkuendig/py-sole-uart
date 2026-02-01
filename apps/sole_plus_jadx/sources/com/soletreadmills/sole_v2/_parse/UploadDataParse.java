package com.soletreadmills.sole_v2._parse;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.TrainhProcessData;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: UploadDataParse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/soletreadmills/sole_v2/_parse/UploadDataParse;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadDataParse {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final String calculateAverageIncline(List<? extends FtmsBaseData> list, MachineType machineType) {
        return INSTANCE.calculateAverageIncline(list, machineType);
    }

    @JvmStatic
    public static final String calculateAverageWatt(List<? extends FtmsBaseData> list, MachineType machineType) {
        return INSTANCE.calculateAverageWatt(list, machineType);
    }

    @JvmStatic
    public static final String calculateAvgHeartRate(List<? extends FtmsBaseData> list) {
        return INSTANCE.calculateAvgHeartRate(list);
    }

    @JvmStatic
    public static final String calculateAvgRpm(List<? extends FtmsBaseData> list, MachineType machineType) {
        return INSTANCE.calculateAvgRpm(list, machineType);
    }

    @JvmStatic
    public static final String calculateAvgSpeed(List<? extends FtmsBaseData> list, MachineType machineType) {
        return INSTANCE.calculateAvgSpeed(list, machineType);
    }

    @JvmStatic
    public static final String calculatePeakHeartRate(List<? extends FtmsBaseData> list) {
        return INSTANCE.calculatePeakHeartRate(list);
    }

    @JvmStatic
    public static final String calculateTotalCalories(List<? extends FtmsBaseData> list) {
        return INSTANCE.calculateTotalCalories(list);
    }

    @JvmStatic
    public static final String calculateTotalDistance(List<? extends FtmsBaseData> list, MachineType machineType) {
        return INSTANCE.calculateTotalDistance(list, machineType);
    }

    @JvmStatic
    public static final String calculateVertical(List<? extends FtmsBaseData> list, MachineType machineType) {
        return INSTANCE.calculateVertical(list, machineType);
    }

    /* compiled from: UploadDataParse.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u000b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ4\u0010\f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J \u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J \u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0018\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J \u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u0017\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\u0018\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J \u0010\u001a\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_parse/UploadDataParse$Companion;", "", "()V", "calculateAverageCadence", "", "summaryDataList", "", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "categoryCode", "Lcom/soletreadmills/sole_v2/_type/MachineType;", "calculateAverageIncline", "calculateAverageLevel", "calculateAverageMET", "avgSpeed", "avgIncline", "avgWatt", "calculateAverageWatt", "calculateAvgHeartRate", "calculateAvgRpm", "calculateAvgSpeed", "calculatePeakHeartRate", "calculateTotalCalories", "calculateTotalDistance", "calculateTotalStep", "calculateTotalStroke", "calculateTotalTime", "calculateVertical", "processTrainData", "", "Lcom/soletreadmills/sole_v2/_data/TrainhProcessData$SysResponseDataBean;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: UploadDataParse.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MachineType.values().length];
                try {
                    iArr[MachineType.TREADMILL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MachineType.BIKE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MachineType.ELLIPTICAL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[MachineType.STEPPER.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[MachineType.ROWER.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String calculateTotalTime(List<? extends FtmsBaseData> summaryDataList) {
            FtmsBaseData ftmsBaseData;
            Integer elapsedTime;
            if (summaryDataList == null) {
                return "";
            }
            try {
                if (summaryDataList.isEmpty() || ((FtmsBaseData) CollectionsKt.first((List) summaryDataList)).getElapsedTime() == null) {
                    summaryDataList = null;
                }
                if (summaryDataList == null || (ftmsBaseData = (FtmsBaseData) CollectionsKt.lastOrNull((List) summaryDataList)) == null || (elapsedTime = ftmsBaseData.getElapsedTime()) == null) {
                    return "";
                }
                String strValueOf = String.valueOf(elapsedTime);
                return strValueOf != null ? strValueOf : "";
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculateTotalDistance(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            String strValueOf;
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list != null && !list.isEmpty()) {
                    int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                    Integer num = null;
                    if (i == 1) {
                        for (FtmsBaseData ftmsBaseData : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.TreadmillData");
                                Integer totalDistance = ((TreadmillData) ftmsBaseData).getTotalDistance();
                                if (totalDistance != null) {
                                    Intrinsics.checkNotNull(totalDistance);
                                    if (totalDistance.intValue() > 0 && (num == null || totalDistance.intValue() > num.intValue())) {
                                        num = totalDistance;
                                    }
                                }
                            } catch (Exception e) {
                                Timber.INSTANCE.e(e.fillInStackTrace());
                            }
                        }
                        if (num == null || (strValueOf = String.valueOf(BigDecimal.valueOf(num.intValue()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP).floatValue())) == null) {
                            return "0";
                        }
                    } else if (i == 2) {
                        for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData2, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.IndoorBikeData");
                                Integer totalDistance2 = ((IndoorBikeData) ftmsBaseData2).getTotalDistance();
                                if (totalDistance2 != null) {
                                    Intrinsics.checkNotNull(totalDistance2);
                                    if (totalDistance2.intValue() > 0 && (num == null || totalDistance2.intValue() > num.intValue())) {
                                        num = totalDistance2;
                                    }
                                }
                            } catch (Exception e2) {
                                Timber.INSTANCE.e(e2.fillInStackTrace());
                            }
                        }
                        if (num == null) {
                            return "0";
                        }
                        strValueOf = String.valueOf(BigDecimal.valueOf(num.intValue()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP).floatValue());
                        if (strValueOf == null) {
                            return "0";
                        }
                    } else if (i == 3) {
                        for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData3, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.CrossTrainerData");
                                Integer totalDistance3 = ((CrossTrainerData) ftmsBaseData3).getTotalDistance();
                                if (totalDistance3 != null) {
                                    Intrinsics.checkNotNull(totalDistance3);
                                    if (totalDistance3.intValue() > 0 && (num == null || totalDistance3.intValue() > num.intValue())) {
                                        num = totalDistance3;
                                    }
                                }
                            } catch (Exception e3) {
                                Timber.INSTANCE.e(e3.fillInStackTrace());
                            }
                        }
                        if (num == null) {
                            return "0";
                        }
                        strValueOf = String.valueOf(BigDecimal.valueOf(num.intValue()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP).floatValue());
                        if (strValueOf == null) {
                            return "0";
                        }
                    } else if (i == 4) {
                        for (FtmsBaseData ftmsBaseData4 : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData4, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.StepClimberData");
                                Integer positiveElevationGain = ((StepClimberData) ftmsBaseData4).getPositiveElevationGain();
                                if (positiveElevationGain != null) {
                                    Intrinsics.checkNotNull(positiveElevationGain);
                                    if (positiveElevationGain.intValue() > 0 && (num == null || positiveElevationGain.intValue() > num.intValue())) {
                                        num = positiveElevationGain;
                                    }
                                }
                            } catch (Exception e4) {
                                Timber.INSTANCE.e(e4.fillInStackTrace());
                            }
                        }
                        if (num == null) {
                            return "0";
                        }
                        strValueOf = num.toString();
                        if (strValueOf == null) {
                            return "0";
                        }
                    } else {
                        if (i != 5) {
                            return "0";
                        }
                        for (FtmsBaseData ftmsBaseData5 : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData5, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.RowerData");
                                Integer totalDistance4 = ((RowerData) ftmsBaseData5).getTotalDistance();
                                if (totalDistance4 != null) {
                                    Intrinsics.checkNotNull(totalDistance4);
                                    if (totalDistance4.intValue() > 0 && (num == null || totalDistance4.intValue() > num.intValue())) {
                                        num = totalDistance4;
                                    }
                                }
                            } catch (Exception e5) {
                                Timber.INSTANCE.e(e5.fillInStackTrace());
                            }
                        }
                        if (num == null) {
                            return "0";
                        }
                        strValueOf = num.toString();
                        if (strValueOf == null) {
                            return "0";
                        }
                    }
                    return strValueOf;
                }
                return "0";
            } catch (Exception e6) {
                Timber.INSTANCE.e(e6.fillInStackTrace());
                return "0";
            }
        }

        @JvmStatic
        public final String calculateVertical(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list == null || list.isEmpty() || WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()] != 1) {
                    return "";
                }
                Integer num = null;
                double dDoubleValue = 0.0d;
                for (FtmsBaseData ftmsBaseData : summaryDataList) {
                    try {
                        Intrinsics.checkNotNull(ftmsBaseData, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.TreadmillData");
                        TreadmillData treadmillData = (TreadmillData) ftmsBaseData;
                        Integer totalDistance = treadmillData.getTotalDistance();
                        if (totalDistance != null) {
                            Intrinsics.checkNotNull(totalDistance);
                            if (totalDistance.intValue() > 0 && (num == null || totalDistance.intValue() > num.intValue())) {
                                try {
                                    Double positiveElevationGain = treadmillData.getPositiveElevationGain();
                                    if (positiveElevationGain == null) {
                                        dDoubleValue = 0.0d;
                                    } else {
                                        Intrinsics.checkNotNull(positiveElevationGain);
                                        dDoubleValue = positiveElevationGain.doubleValue();
                                    }
                                    num = totalDistance;
                                } catch (Exception e) {
                                    e = e;
                                    num = totalDistance;
                                    Timber.INSTANCE.e(e.fillInStackTrace());
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                return (num == null || dDoubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE) ? "" : String.valueOf(dDoubleValue);
            } catch (Exception e3) {
                Timber.INSTANCE.e(e3.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculateTotalCalories(List<? extends FtmsBaseData> summaryDataList) {
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list != null && !list.isEmpty()) {
                    Iterator<T> it = summaryDataList.iterator();
                    Integer num = null;
                    while (it.hasNext()) {
                        try {
                            Integer totalEnergy = ((FtmsBaseData) it.next()).getTotalEnergy();
                            if (totalEnergy != null) {
                                Intrinsics.checkNotNull(totalEnergy);
                                if (totalEnergy.intValue() > 0 && (num == null || totalEnergy.intValue() > num.intValue())) {
                                    num = totalEnergy;
                                }
                            }
                        } catch (Exception e) {
                            Timber.INSTANCE.e(e.fillInStackTrace());
                        }
                    }
                    if (num == null) {
                        return "0";
                    }
                    String string = num.toString();
                    return string == null ? "0" : string;
                }
                return "";
            } catch (Exception e2) {
                Timber.INSTANCE.e(e2.fillInStackTrace());
                return "0";
            }
        }

        @JvmStatic
        public final String calculateAvgHeartRate(List<? extends FtmsBaseData> summaryDataList) {
            Integer heartRate;
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list != null && !list.isEmpty()) {
                    long jIntValue = 0;
                    long j = 0;
                    for (FtmsBaseData ftmsBaseData : summaryDataList) {
                        if (ftmsBaseData != null && (heartRate = ftmsBaseData.getHeartRate()) != null) {
                            Intrinsics.checkNotNull(heartRate);
                            if (heartRate.intValue() > 0) {
                                jIntValue += heartRate.intValue();
                                j++;
                            }
                        }
                    }
                    if (jIntValue <= 0 || j <= 0) {
                        return "";
                    }
                    return String.valueOf(jIntValue / j);
                }
                return "";
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculatePeakHeartRate(List<? extends FtmsBaseData> summaryDataList) {
            Integer heartRate;
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list != null && !list.isEmpty()) {
                    int iIntValue = 0;
                    for (FtmsBaseData ftmsBaseData : summaryDataList) {
                        if (ftmsBaseData != null && (heartRate = ftmsBaseData.getHeartRate()) != null) {
                            Intrinsics.checkNotNull(heartRate);
                            if (heartRate.intValue() > 0 && heartRate.intValue() > iIntValue) {
                                iIntValue = heartRate.intValue();
                            }
                        }
                    }
                    if (iIntValue <= 0) {
                        return "";
                    }
                    return String.valueOf(iIntValue);
                }
                return "";
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculateAvgRpm(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            int i;
            Double instantaneousCadence;
            String strValueOf;
            Double stepPerMinute;
            Double stepPerMinute2;
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list == null || list.isEmpty() || (i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()]) == 1) {
                    return "";
                }
                int i2 = 0;
                if (i == 2) {
                    Object objLastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) summaryDataList);
                    IndoorBikeData indoorBikeData = objLastOrNull instanceof IndoorBikeData ? (IndoorBikeData) objLastOrNull : null;
                    if (indoorBikeData != null) {
                        Double averageCadence = indoorBikeData.getAverageCadence();
                        if (averageCadence != null) {
                            strValueOf = String.valueOf((float) averageCadence.doubleValue());
                            if (strValueOf == null) {
                            }
                        }
                    }
                    Companion companion = this;
                    double dDoubleValue = 0.0d;
                    for (FtmsBaseData ftmsBaseData : summaryDataList) {
                        IndoorBikeData indoorBikeData2 = ftmsBaseData instanceof IndoorBikeData ? (IndoorBikeData) ftmsBaseData : null;
                        if (indoorBikeData2 != null && (instantaneousCadence = indoorBikeData2.getInstantaneousCadence()) != null) {
                            Intrinsics.checkNotNull(instantaneousCadence);
                            dDoubleValue += instantaneousCadence.doubleValue();
                            i2++;
                        }
                    }
                    return (dDoubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) ? "" : String.valueOf((float) (dDoubleValue / i2));
                }
                if (i != 3) {
                    return "";
                }
                Object objLastOrNull2 = CollectionsKt.lastOrNull((List<? extends Object>) summaryDataList);
                CrossTrainerData crossTrainerData = objLastOrNull2 instanceof CrossTrainerData ? (CrossTrainerData) objLastOrNull2 : null;
                if (crossTrainerData == null || (stepPerMinute2 = crossTrainerData.getStepPerMinute()) == null || (strValueOf = String.valueOf(((float) stepPerMinute2.doubleValue()) / 2.0f)) == null) {
                    Companion companion2 = this;
                    double dDoubleValue2 = 0.0d;
                    for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                        CrossTrainerData crossTrainerData2 = ftmsBaseData2 instanceof CrossTrainerData ? (CrossTrainerData) ftmsBaseData2 : null;
                        if (crossTrainerData2 != null && (stepPerMinute = crossTrainerData2.getStepPerMinute()) != null) {
                            dDoubleValue2 += stepPerMinute.doubleValue() / 2.0d;
                            i2++;
                        }
                    }
                    return (dDoubleValue2 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) ? "" : String.valueOf((float) (dDoubleValue2 / i2));
                }
                return strValueOf;
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculateAvgSpeed(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            Double instantaneousSpeed;
            String strValueOf;
            Double instantaneousSpeed2;
            Double averageSpeed;
            Double instantaneousSpeed3;
            Double averageSpeed2;
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list != null && !list.isEmpty()) {
                    int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                    int i2 = 0;
                    if (i == 1) {
                        Object objLastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) summaryDataList);
                        TreadmillData treadmillData = objLastOrNull instanceof TreadmillData ? (TreadmillData) objLastOrNull : null;
                        if (treadmillData != null) {
                            Double averageSpeed3 = treadmillData.getAverageSpeed();
                            if (averageSpeed3 != null) {
                                strValueOf = String.valueOf((float) averageSpeed3.doubleValue());
                                if (strValueOf == null) {
                                }
                            }
                        }
                        Companion companion = this;
                        double dDoubleValue = 0.0d;
                        for (FtmsBaseData ftmsBaseData : summaryDataList) {
                            TreadmillData treadmillData2 = ftmsBaseData instanceof TreadmillData ? (TreadmillData) ftmsBaseData : null;
                            if (treadmillData2 != null && (instantaneousSpeed = treadmillData2.getInstantaneousSpeed()) != null) {
                                Intrinsics.checkNotNull(instantaneousSpeed);
                                dDoubleValue += instantaneousSpeed.doubleValue();
                                i2++;
                            }
                        }
                        return (dDoubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) ? "" : String.valueOf((float) (dDoubleValue / i2));
                    }
                    if (i == 2) {
                        Object objLastOrNull2 = CollectionsKt.lastOrNull((List<? extends Object>) summaryDataList);
                        IndoorBikeData indoorBikeData = objLastOrNull2 instanceof IndoorBikeData ? (IndoorBikeData) objLastOrNull2 : null;
                        if (indoorBikeData == null || (averageSpeed = indoorBikeData.getAverageSpeed()) == null || (strValueOf = String.valueOf((float) averageSpeed.doubleValue())) == null) {
                            Companion companion2 = this;
                            double dDoubleValue2 = 0.0d;
                            for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                                IndoorBikeData indoorBikeData2 = ftmsBaseData2 instanceof IndoorBikeData ? (IndoorBikeData) ftmsBaseData2 : null;
                                if (indoorBikeData2 != null && (instantaneousSpeed2 = indoorBikeData2.getInstantaneousSpeed()) != null) {
                                    Intrinsics.checkNotNull(instantaneousSpeed2);
                                    dDoubleValue2 += instantaneousSpeed2.doubleValue();
                                    i2++;
                                }
                            }
                            return (dDoubleValue2 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) ? "" : String.valueOf((float) (dDoubleValue2 / i2));
                        }
                    } else {
                        if (i != 3) {
                            return "";
                        }
                        Object objLastOrNull3 = CollectionsKt.lastOrNull((List<? extends Object>) summaryDataList);
                        CrossTrainerData crossTrainerData = objLastOrNull3 instanceof CrossTrainerData ? (CrossTrainerData) objLastOrNull3 : null;
                        if (crossTrainerData == null || (averageSpeed2 = crossTrainerData.getAverageSpeed()) == null || (strValueOf = String.valueOf((float) averageSpeed2.doubleValue())) == null) {
                            Companion companion3 = this;
                            double dDoubleValue3 = 0.0d;
                            for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                                CrossTrainerData crossTrainerData2 = ftmsBaseData3 instanceof CrossTrainerData ? (CrossTrainerData) ftmsBaseData3 : null;
                                if (crossTrainerData2 != null && (instantaneousSpeed3 = crossTrainerData2.getInstantaneousSpeed()) != null) {
                                    Intrinsics.checkNotNull(instantaneousSpeed3);
                                    dDoubleValue3 += instantaneousSpeed3.doubleValue();
                                    i2++;
                                }
                            }
                            return (dDoubleValue3 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) ? "" : String.valueOf((float) (dDoubleValue3 / i2));
                        }
                    }
                    return strValueOf;
                }
                return "";
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculateAverageIncline(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            String strValueOf;
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                List<? extends FtmsBaseData> list = summaryDataList;
                if (list != null && !list.isEmpty()) {
                    int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                    double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                    int i2 = 0;
                    if (i == 1) {
                        for (FtmsBaseData ftmsBaseData : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.TreadmillData");
                                Double inclination = ((TreadmillData) ftmsBaseData).getInclination();
                                if (inclination != null) {
                                    Intrinsics.checkNotNull(inclination);
                                    dDoubleValue += inclination.doubleValue();
                                    i2++;
                                }
                            } catch (Exception e) {
                                Timber.INSTANCE.e(e.fillInStackTrace());
                            }
                        }
                        if (i2 <= 0) {
                            return "";
                        }
                        strValueOf = String.valueOf(dDoubleValue / i2);
                    } else if (i == 2) {
                        for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData2, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.IndoorBikeData");
                                Double inclination2 = ((IndoorBikeData) ftmsBaseData2).getInclination();
                                if (inclination2 != null) {
                                    Intrinsics.checkNotNull(inclination2);
                                    dDoubleValue += inclination2.doubleValue();
                                    i2++;
                                }
                            } catch (Exception e2) {
                                Timber.INSTANCE.e(e2.fillInStackTrace());
                            }
                        }
                        if (i2 <= 0) {
                            return "";
                        }
                        strValueOf = String.valueOf(dDoubleValue / i2);
                    } else {
                        if (i != 3) {
                            return "";
                        }
                        for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                            try {
                                Intrinsics.checkNotNull(ftmsBaseData3, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.CrossTrainerData");
                                Double inclination3 = ((CrossTrainerData) ftmsBaseData3).getInclination();
                                if (inclination3 != null) {
                                    Intrinsics.checkNotNull(inclination3);
                                    dDoubleValue += inclination3.doubleValue();
                                    i2++;
                                }
                            } catch (Exception e3) {
                                Timber.INSTANCE.e(e3.fillInStackTrace());
                            }
                        }
                        if (i2 <= 0) {
                            return "";
                        }
                        strValueOf = String.valueOf(dDoubleValue / i2);
                    }
                    return strValueOf;
                }
                return "";
            } catch (Exception e4) {
                Timber.INSTANCE.e(e4.fillInStackTrace());
                return "";
            }
        }

        @JvmStatic
        public final String calculateAverageWatt(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            List<? extends FtmsBaseData> list;
            int i;
            String strValueOf;
            Integer instantaneousPower;
            Integer instantaneousPower2;
            String weight;
            Integer instantaneousPower3;
            String strValueOf2 = "";
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                list = summaryDataList;
            } catch (Exception e) {
                Timber.INSTANCE.e(e.fillInStackTrace());
                return strValueOf2;
            }
            if (list == null || list.isEmpty() || (i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()]) == 1) {
                return "";
            }
            int i2 = 0;
            if (i == 2) {
                try {
                    FtmsBaseData ftmsBaseData = summaryDataList.get(summaryDataList.size() - 1);
                    Intrinsics.checkNotNull(ftmsBaseData, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.IndoorBikeData");
                    if (((IndoorBikeData) ftmsBaseData).getAveragePower() != null) {
                        strValueOf = String.valueOf(r10.intValue());
                    } else {
                        double dIntValue = 0.0d;
                        for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                            try {
                                if ((ftmsBaseData2 instanceof IndoorBikeData) && (instantaneousPower = ((IndoorBikeData) ftmsBaseData2).getInstantaneousPower()) != null) {
                                    Intrinsics.checkNotNull(instantaneousPower);
                                    dIntValue += instantaneousPower.intValue();
                                    i2++;
                                }
                            } catch (Exception e2) {
                                Timber.INSTANCE.e(e2.fillInStackTrace());
                            }
                        }
                        if (dIntValue <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) {
                            return "";
                        }
                        strValueOf = String.valueOf((float) (dIntValue / i2));
                    }
                } catch (Exception e3) {
                    Timber.INSTANCE.e(e3.fillInStackTrace());
                    return "";
                }
            } else if (i == 3) {
                try {
                    FtmsBaseData ftmsBaseData3 = summaryDataList.get(summaryDataList.size() - 1);
                    Intrinsics.checkNotNull(ftmsBaseData3, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.CrossTrainerData");
                    if (((CrossTrainerData) ftmsBaseData3).getAveragePower() != null) {
                        strValueOf = String.valueOf(r10.intValue());
                    } else {
                        double dIntValue2 = 0.0d;
                        for (FtmsBaseData ftmsBaseData4 : summaryDataList) {
                            try {
                                if ((ftmsBaseData4 instanceof CrossTrainerData) && (instantaneousPower2 = ((CrossTrainerData) ftmsBaseData4).getInstantaneousPower()) != null) {
                                    Intrinsics.checkNotNull(instantaneousPower2);
                                    dIntValue2 += instantaneousPower2.intValue();
                                    i2++;
                                }
                            } catch (Exception e4) {
                                Timber.INSTANCE.e(e4.fillInStackTrace());
                            }
                        }
                        if (dIntValue2 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) {
                            return "";
                        }
                        strValueOf = String.valueOf((float) (dIntValue2 / i2));
                    }
                } catch (Exception e5) {
                    Timber.INSTANCE.e(e5.fillInStackTrace());
                    return "";
                }
            } else {
                if (i == 4) {
                    try {
                        FtmsBaseData ftmsBaseData5 = summaryDataList.get(summaryDataList.size() - 1);
                        Intrinsics.checkNotNull(ftmsBaseData5, "null cannot be cast to non-null type com.soletreadmills.sole_v2.ble.data.StepClimberData");
                        Double averageStepRate = ((StepClimberData) ftmsBaseData5).getAverageStepRate();
                        LoginUserData loginUserData = Global.userData;
                        if (loginUserData == null || (weight = loginUserData.getWeight()) == null) {
                            weight = "0";
                        }
                        double d = Double.parseDouble(weight) * 9.81d * 0.19d;
                        Intrinsics.checkNotNull(averageStepRate);
                        strValueOf2 = String.valueOf(d / (60 / averageStepRate.doubleValue()));
                        return strValueOf2;
                    } catch (Exception e6) {
                        Timber.INSTANCE.e(e6.fillInStackTrace());
                        return "";
                    }
                }
                if (i != 5) {
                    return "";
                }
                double dIntValue3 = 0.0d;
                for (FtmsBaseData ftmsBaseData6 : summaryDataList) {
                    try {
                        if ((ftmsBaseData6 instanceof RowerData) && (instantaneousPower3 = ((RowerData) ftmsBaseData6).getInstantaneousPower()) != null) {
                            Intrinsics.checkNotNull(instantaneousPower3);
                            if (instantaneousPower3.intValue() > 0) {
                                dIntValue3 += instantaneousPower3.intValue();
                                i2++;
                            }
                        }
                    } catch (Exception e7) {
                        Timber.INSTANCE.e(e7.fillInStackTrace());
                    }
                }
                if (dIntValue3 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) {
                    return "";
                }
                strValueOf = String.valueOf((float) (dIntValue3 / i2));
                Timber.INSTANCE.e(e.fillInStackTrace());
                return strValueOf2;
            }
            return strValueOf;
        }

        public final String calculateAverageMET(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode, String avgSpeed, String avgIncline, String avgWatt) {
            double d;
            double d2;
            double d3;
            double d4;
            String weight;
            Intrinsics.checkNotNullParameter(summaryDataList, "summaryDataList");
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            Intrinsics.checkNotNullParameter(avgSpeed, "avgSpeed");
            Intrinsics.checkNotNullParameter(avgIncline, "avgIncline");
            Intrinsics.checkNotNullParameter(avgWatt, "avgWatt");
            String strValueOf = "0";
            try {
                try {
                    d = Double.parseDouble(UnitConversion.INSTANCE.getMi(avgSpeed));
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    d = 0.0d;
                }
                double d5 = 26.8d * d;
                try {
                    d2 = Double.parseDouble(avgIncline) / 100;
                } catch (Exception e2) {
                    Timber.INSTANCE.e(e2);
                    d2 = 0.0d;
                }
                int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                if (i == 1) {
                    double d6 = d >= 4.5d ? (0.2d * d5) + 3.5d + (d5 * 0.9d * d2) : (0.1d * d5) + 3.5d + (d5 * 1.8d * d2);
                    if (d6 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        try {
                            strValueOf = String.valueOf(d6 / 3.5d);
                        } catch (Exception e3) {
                            Timber.INSTANCE.e(e3);
                        }
                    }
                } else if (i == 2 || i == 3) {
                    try {
                        try {
                            d4 = Double.parseDouble(avgWatt) * 6;
                        } catch (Exception e4) {
                            Timber.INSTANCE.e(e4);
                            d4 = 0.0d;
                        }
                        Double dValueOf = null;
                        try {
                            LoginUserData loginUserData = Global.userData;
                            if (loginUserData != null && (weight = loginUserData.getWeight()) != null) {
                                dValueOf = Double.valueOf(Double.parseDouble(weight));
                            }
                        } catch (Exception e5) {
                            Timber.INSTANCE.e(e5);
                        }
                        double dDoubleValue = dValueOf != null ? dValueOf.doubleValue() : 0.0d;
                        double d7 = (d4 <= AudioStats.AUDIO_AMPLITUDE_NONE || dDoubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE) ? 0.0d : 7 + ((d4 * 1.8d) / dDoubleValue);
                        if (d7 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                            strValueOf = String.valueOf(d7 / 3.5d);
                        }
                    } catch (Exception e6) {
                        Timber.INSTANCE.e(e6);
                    }
                }
                try {
                    d3 = Double.parseDouble(strValueOf);
                } catch (Exception e7) {
                    Timber.INSTANCE.e(e7);
                    d3 = 0.0d;
                }
                if (d3 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    return strValueOf;
                }
                Iterator<? extends FtmsBaseData> it = summaryDataList.iterator();
                int i2 = 0;
                double dDoubleValue2 = 0.0d;
                while (it.hasNext()) {
                    Double metabolicEquivalent = it.next().getMetabolicEquivalent();
                    if (metabolicEquivalent != null) {
                        dDoubleValue2 += metabolicEquivalent.doubleValue();
                        i2++;
                    }
                }
                return (dDoubleValue2 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) ? strValueOf : String.valueOf(dDoubleValue2 / i2);
            } catch (Exception e8) {
                Timber.INSTANCE.e(e8);
                return strValueOf;
            }
        }

        public final String calculateAverageLevel(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            double dIntValue;
            Integer resistanceLevel;
            Integer resistanceLevel2;
            Integer resistanceLevel3;
            Integer resistanceLevel4;
            Intrinsics.checkNotNullParameter(summaryDataList, "summaryDataList");
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                int i2 = 0;
                if (i == 2) {
                    dIntValue = 0.0d;
                    for (FtmsBaseData ftmsBaseData : summaryDataList) {
                        if ((ftmsBaseData instanceof IndoorBikeData) && (resistanceLevel = ((IndoorBikeData) ftmsBaseData).getResistanceLevel()) != null) {
                            Intrinsics.checkNotNull(resistanceLevel);
                            dIntValue += resistanceLevel.intValue();
                            i2++;
                        }
                    }
                } else if (i == 3) {
                    dIntValue = 0.0d;
                    for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                        if ((ftmsBaseData2 instanceof CrossTrainerData) && (resistanceLevel2 = ((CrossTrainerData) ftmsBaseData2).getResistanceLevel()) != null) {
                            Intrinsics.checkNotNull(resistanceLevel2);
                            dIntValue += resistanceLevel2.intValue();
                            i2++;
                        }
                    }
                } else if (i == 4) {
                    dIntValue = 0.0d;
                    for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                        if ((ftmsBaseData3 instanceof StepClimberData) && (resistanceLevel3 = ((StepClimberData) ftmsBaseData3).getResistanceLevel()) != null) {
                            Intrinsics.checkNotNull(resistanceLevel3);
                            dIntValue += resistanceLevel3.intValue();
                            i2++;
                        }
                    }
                } else if (i != 5) {
                    dIntValue = 0.0d;
                } else {
                    dIntValue = 0.0d;
                    for (FtmsBaseData ftmsBaseData4 : summaryDataList) {
                        if ((ftmsBaseData4 instanceof RowerData) && (resistanceLevel4 = ((RowerData) ftmsBaseData4).getResistanceLevel()) != null) {
                            Intrinsics.checkNotNull(resistanceLevel4);
                            dIntValue += resistanceLevel4.intValue();
                            i2++;
                        }
                    }
                }
                if (dIntValue > AudioStats.AUDIO_AMPLITUDE_NONE && i2 > 0) {
                    return String.valueOf((float) (dIntValue / i2));
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
            return "0";
        }

        public final String calculateTotalStep(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            Integer stepCount;
            Intrinsics.checkNotNullParameter(summaryDataList, "summaryDataList");
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                if (i != 1 && i != 2 && i != 3 && i == 4) {
                    FtmsBaseData ftmsBaseData = (FtmsBaseData) CollectionsKt.lastOrNull((List) summaryDataList);
                    if ((ftmsBaseData instanceof StepClimberData) && (stepCount = ((StepClimberData) ftmsBaseData).getStepCount()) != null) {
                        return String.valueOf(stepCount.intValue());
                    }
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
            return "0";
        }

        public final String calculateAverageCadence(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            Double instantaneousCadence;
            String string;
            Double stepPerMinute;
            Double strokeRate;
            Intrinsics.checkNotNullParameter(summaryDataList, "summaryDataList");
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                if (i == 1) {
                    return "0";
                }
                int i2 = 0;
                if (i != 2) {
                    if (i == 3) {
                        return "0";
                    }
                    if (i != 4) {
                        if (i != 5) {
                            return "0";
                        }
                        double dDoubleValue = 0.0d;
                        for (FtmsBaseData ftmsBaseData : summaryDataList) {
                            if ((ftmsBaseData instanceof RowerData) && (strokeRate = ((RowerData) ftmsBaseData).getStrokeRate()) != null) {
                                Intrinsics.checkNotNull(strokeRate);
                                if (strokeRate.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                    strokeRate = null;
                                }
                                if (strokeRate != null) {
                                    Intrinsics.checkNotNull(strokeRate);
                                    dDoubleValue += strokeRate.doubleValue();
                                    i2++;
                                }
                            }
                        }
                        if (dDoubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) {
                            return "0";
                        }
                        return String.valueOf((float) (dDoubleValue / i2));
                    }
                    FtmsBaseData ftmsBaseData2 = (FtmsBaseData) CollectionsKt.lastOrNull((List) summaryDataList);
                    if (!(ftmsBaseData2 instanceof StepClimberData)) {
                        return "0";
                    }
                    Double averageStepRate = ((StepClimberData) ftmsBaseData2).getAverageStepRate();
                    if (averageStepRate != null) {
                        string = Float.valueOf((float) averageStepRate.doubleValue()).toString();
                        if (string == null) {
                        }
                    }
                    Companion companion = this;
                    double dDoubleValue2 = 0.0d;
                    for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                        if ((ftmsBaseData3 instanceof StepClimberData) && (stepPerMinute = ((StepClimberData) ftmsBaseData3).getStepPerMinute()) != null) {
                            Intrinsics.checkNotNull(stepPerMinute);
                            dDoubleValue2 += stepPerMinute.doubleValue();
                            i2++;
                        }
                    }
                    if (dDoubleValue2 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) {
                        return "0";
                    }
                    return String.valueOf((float) (dDoubleValue2 / i2));
                }
                FtmsBaseData ftmsBaseData4 = (FtmsBaseData) CollectionsKt.lastOrNull((List) summaryDataList);
                if (!(ftmsBaseData4 instanceof IndoorBikeData)) {
                    return "0";
                }
                Double averageCadence = ((IndoorBikeData) ftmsBaseData4).getAverageCadence();
                if (averageCadence == null || (string = Float.valueOf((float) averageCadence.doubleValue()).toString()) == null) {
                    Companion companion2 = this;
                    double dDoubleValue3 = 0.0d;
                    for (FtmsBaseData ftmsBaseData5 : summaryDataList) {
                        if ((ftmsBaseData5 instanceof IndoorBikeData) && (instantaneousCadence = ((IndoorBikeData) ftmsBaseData5).getInstantaneousCadence()) != null) {
                            Intrinsics.checkNotNull(instantaneousCadence);
                            dDoubleValue3 += instantaneousCadence.doubleValue();
                            i2++;
                        }
                    }
                    if (dDoubleValue3 <= AudioStats.AUDIO_AMPLITUDE_NONE || i2 <= 0) {
                        return "0";
                    }
                    return String.valueOf((float) (dDoubleValue3 / i2));
                }
                return string;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                return "0";
            }
        }

        public final String calculateTotalStroke(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            Integer strokeCount;
            Intrinsics.checkNotNullParameter(summaryDataList, "summaryDataList");
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                if (i != 1 && i != 2 && i != 3 && i != 4 && i == 5) {
                    FtmsBaseData ftmsBaseData = (FtmsBaseData) CollectionsKt.lastOrNull((List) summaryDataList);
                    if ((ftmsBaseData instanceof RowerData) && (strokeCount = ((RowerData) ftmsBaseData).getStrokeCount()) != null) {
                        return String.valueOf(strokeCount.intValue());
                    }
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
            return "0";
        }

        public final List<TrainhProcessData.SysResponseDataBean> processTrainData(List<? extends FtmsBaseData> summaryDataList, MachineType categoryCode) {
            Intrinsics.checkNotNullParameter(summaryDataList, "summaryDataList");
            Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
            ArrayList arrayList = new ArrayList();
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[categoryCode.ordinal()];
                if (i == 1) {
                    for (FtmsBaseData ftmsBaseData : summaryDataList) {
                        if (ftmsBaseData instanceof TreadmillData) {
                            TrainhProcessData.SysResponseDataBean sysResponseDataBean = new TrainhProcessData.SysResponseDataBean();
                            Integer elapsedTime = ((TreadmillData) ftmsBaseData).getElapsedTime();
                            if (elapsedTime != null) {
                                sysResponseDataBean.setTotal_workout_time(String.valueOf(elapsedTime.intValue()));
                            }
                            Integer remainingTime = ((TreadmillData) ftmsBaseData).getRemainingTime();
                            if (remainingTime != null) {
                                sysResponseDataBean.setTotal_timeleft(String.valueOf(remainingTime.intValue()));
                            }
                            if (((TreadmillData) ftmsBaseData).getHeartRate() != null) {
                                sysResponseDataBean.setNow_hr(Double.valueOf(r4.intValue()));
                            }
                            if (((TreadmillData) ftmsBaseData).getTotalDistance() != null) {
                                sysResponseDataBean.setTotal_distance(Double.valueOf(r4.intValue() / 1000.0d));
                            }
                            if (((TreadmillData) ftmsBaseData).getTotalEnergy() != null) {
                                sysResponseDataBean.setTotal_calorie(Double.valueOf(r4.intValue()));
                            }
                            Double instantaneousSpeed = ((TreadmillData) ftmsBaseData).getInstantaneousSpeed();
                            if (instantaneousSpeed != null) {
                                sysResponseDataBean.setNow_speed(instantaneousSpeed);
                            }
                            Double inclination = ((TreadmillData) ftmsBaseData).getInclination();
                            if (inclination != null) {
                                sysResponseDataBean.setNow_incline(inclination);
                            }
                            arrayList.add(sysResponseDataBean);
                        }
                    }
                } else if (i == 2) {
                    for (FtmsBaseData ftmsBaseData2 : summaryDataList) {
                        if (ftmsBaseData2 instanceof IndoorBikeData) {
                            TrainhProcessData.SysResponseDataBean sysResponseDataBean2 = new TrainhProcessData.SysResponseDataBean();
                            Integer elapsedTime2 = ((IndoorBikeData) ftmsBaseData2).getElapsedTime();
                            if (elapsedTime2 != null) {
                                sysResponseDataBean2.setTotal_workout_time(String.valueOf(elapsedTime2.intValue()));
                            }
                            Integer remainingTime2 = ((IndoorBikeData) ftmsBaseData2).getRemainingTime();
                            if (remainingTime2 != null) {
                                sysResponseDataBean2.setTotal_timeleft(String.valueOf(remainingTime2.intValue()));
                            }
                            if (((IndoorBikeData) ftmsBaseData2).getHeartRate() != null) {
                                sysResponseDataBean2.setNow_hr(Double.valueOf(r4.intValue()));
                            }
                            if (((IndoorBikeData) ftmsBaseData2).getTotalDistance() != null) {
                                sysResponseDataBean2.setTotal_distance(Double.valueOf(r4.intValue() / 1000.0d));
                            }
                            if (((IndoorBikeData) ftmsBaseData2).getTotalEnergy() != null) {
                                sysResponseDataBean2.setTotal_calorie(Double.valueOf(r4.intValue()));
                            }
                            Double instantaneousSpeed2 = ((IndoorBikeData) ftmsBaseData2).getInstantaneousSpeed();
                            if (instantaneousSpeed2 != null) {
                                sysResponseDataBean2.setNow_speed(instantaneousSpeed2);
                            }
                            Integer resistanceLevel = ((IndoorBikeData) ftmsBaseData2).getResistanceLevel();
                            if (resistanceLevel != null) {
                                sysResponseDataBean2.setNow_level(resistanceLevel);
                            }
                            Integer instantaneousPower = ((IndoorBikeData) ftmsBaseData2).getInstantaneousPower();
                            if (instantaneousPower != null) {
                                sysResponseDataBean2.setNow_watt(instantaneousPower);
                            }
                            Double averageCadence = ((IndoorBikeData) ftmsBaseData2).getAverageCadence();
                            if (averageCadence != null) {
                                sysResponseDataBean2.setAvg_rpm(averageCadence);
                            }
                            Double inclination2 = ((IndoorBikeData) ftmsBaseData2).getInclination();
                            if (inclination2 != null) {
                                sysResponseDataBean2.setNow_incline(inclination2);
                            }
                            arrayList.add(sysResponseDataBean2);
                        }
                    }
                } else if (i == 3) {
                    for (FtmsBaseData ftmsBaseData3 : summaryDataList) {
                        if (ftmsBaseData3 instanceof CrossTrainerData) {
                            TrainhProcessData.SysResponseDataBean sysResponseDataBean3 = new TrainhProcessData.SysResponseDataBean();
                            Integer elapsedTime3 = ((CrossTrainerData) ftmsBaseData3).getElapsedTime();
                            if (elapsedTime3 != null) {
                                sysResponseDataBean3.setTotal_workout_time(String.valueOf(elapsedTime3.intValue()));
                            }
                            Integer remainingTime3 = ((CrossTrainerData) ftmsBaseData3).getRemainingTime();
                            if (remainingTime3 != null) {
                                sysResponseDataBean3.setTotal_timeleft(String.valueOf(remainingTime3.intValue()));
                            }
                            if (((CrossTrainerData) ftmsBaseData3).getHeartRate() != null) {
                                sysResponseDataBean3.setNow_hr(Double.valueOf(r5.intValue()));
                            }
                            if (((CrossTrainerData) ftmsBaseData3).getTotalDistance() != null) {
                                sysResponseDataBean3.setTotal_distance(Double.valueOf(r5.intValue() / 1000.0d));
                            }
                            if (((CrossTrainerData) ftmsBaseData3).getTotalEnergy() != null) {
                                sysResponseDataBean3.setTotal_calorie(Double.valueOf(r5.intValue()));
                            }
                            Double instantaneousSpeed3 = ((CrossTrainerData) ftmsBaseData3).getInstantaneousSpeed();
                            if (instantaneousSpeed3 != null) {
                                sysResponseDataBean3.setNow_speed(instantaneousSpeed3);
                            }
                            Double inclination3 = ((CrossTrainerData) ftmsBaseData3).getInclination();
                            if (inclination3 != null) {
                                sysResponseDataBean3.setNow_incline(inclination3);
                            }
                            Integer resistanceLevel2 = ((CrossTrainerData) ftmsBaseData3).getResistanceLevel();
                            if (resistanceLevel2 != null) {
                                sysResponseDataBean3.setNow_level(resistanceLevel2);
                            }
                            Integer instantaneousPower2 = ((CrossTrainerData) ftmsBaseData3).getInstantaneousPower();
                            if (instantaneousPower2 != null) {
                                sysResponseDataBean3.setNow_watt(instantaneousPower2);
                            }
                            Double stepPerMinute = ((CrossTrainerData) ftmsBaseData3).getStepPerMinute();
                            if (stepPerMinute != null) {
                                sysResponseDataBean3.setAvg_rpm(Double.valueOf(stepPerMinute.doubleValue() / 2));
                            }
                            arrayList.add(sysResponseDataBean3);
                        }
                    }
                } else if (i == 4) {
                    for (FtmsBaseData ftmsBaseData4 : summaryDataList) {
                        if (ftmsBaseData4 instanceof StepClimberData) {
                            TrainhProcessData.SysResponseDataBean sysResponseDataBean4 = new TrainhProcessData.SysResponseDataBean();
                            Integer elapsedTime4 = ((StepClimberData) ftmsBaseData4).getElapsedTime();
                            if (elapsedTime4 != null) {
                                sysResponseDataBean4.setTotal_workout_time(String.valueOf(elapsedTime4.intValue()));
                            }
                            Integer remainingTime4 = ((StepClimberData) ftmsBaseData4).getRemainingTime();
                            if (remainingTime4 != null) {
                                sysResponseDataBean4.setTotal_timeleft(String.valueOf(remainingTime4.intValue()));
                            }
                            if (((StepClimberData) ftmsBaseData4).getHeartRate() != null) {
                                sysResponseDataBean4.setNow_hr(Double.valueOf(r2.intValue()));
                            }
                            if (((StepClimberData) ftmsBaseData4).getPositiveElevationGain() != null) {
                                sysResponseDataBean4.setTotal_distance(Double.valueOf(r2.intValue()));
                            }
                            if (((StepClimberData) ftmsBaseData4).getTotalEnergy() != null) {
                                sysResponseDataBean4.setTotal_calorie(Double.valueOf(r2.intValue()));
                            }
                            Integer resistanceLevel3 = ((StepClimberData) ftmsBaseData4).getResistanceLevel();
                            if (resistanceLevel3 != null) {
                                sysResponseDataBean4.setNow_level(resistanceLevel3);
                            }
                            if (((StepClimberData) ftmsBaseData4).getFloors() != null) {
                                sysResponseDataBean4.setTotal_floor(Double.valueOf(r2.intValue()));
                            }
                            if (((StepClimberData) ftmsBaseData4).getPositiveElevationGain() != null) {
                                sysResponseDataBean4.setTotal_elevation(Double.valueOf(r2.intValue()));
                            }
                            if (((StepClimberData) ftmsBaseData4).getStepCount() != null) {
                                sysResponseDataBean4.setTotal_steps(Double.valueOf(r2.intValue()));
                            }
                            Double stepPerMinute2 = ((StepClimberData) ftmsBaseData4).getStepPerMinute();
                            if (stepPerMinute2 != null) {
                                sysResponseDataBean4.setTotal_cur_spm(stepPerMinute2);
                            }
                            Double averageStepRate = ((StepClimberData) ftmsBaseData4).getAverageStepRate();
                            if (averageStepRate != null) {
                                sysResponseDataBean4.setTotal_avg_spm(averageStepRate);
                            }
                            arrayList.add(sysResponseDataBean4);
                        }
                    }
                } else if (i == 5) {
                    for (FtmsBaseData ftmsBaseData5 : summaryDataList) {
                        if (ftmsBaseData5 instanceof RowerData) {
                            TrainhProcessData.SysResponseDataBean sysResponseDataBean5 = new TrainhProcessData.SysResponseDataBean();
                            Integer elapsedTime5 = ((RowerData) ftmsBaseData5).getElapsedTime();
                            if (elapsedTime5 != null) {
                                sysResponseDataBean5.setTotal_workout_time(String.valueOf(elapsedTime5.intValue()));
                            }
                            Integer remainingTime5 = ((RowerData) ftmsBaseData5).getRemainingTime();
                            if (remainingTime5 != null) {
                                sysResponseDataBean5.setTotal_timeleft(String.valueOf(remainingTime5.intValue()));
                            }
                            if (((RowerData) ftmsBaseData5).getHeartRate() != null) {
                                sysResponseDataBean5.setNow_hr(Double.valueOf(r4.intValue()));
                            }
                            if (((RowerData) ftmsBaseData5).getTotalDistance() != null) {
                                sysResponseDataBean5.setTotal_distance(Double.valueOf(r4.intValue() / 1000.0d));
                            }
                            Double instantaneousPace = ((RowerData) ftmsBaseData5).getInstantaneousPace();
                            if (instantaneousPace != null) {
                                sysResponseDataBean5.setNow_pace(UnitConversion.INSTANCE.secToTime((int) instantaneousPace.doubleValue()));
                            }
                            if (((RowerData) ftmsBaseData5).getTotalEnergy() != null) {
                                sysResponseDataBean5.setTotal_calorie(Double.valueOf(r4.intValue()));
                            }
                            Integer resistanceLevel4 = ((RowerData) ftmsBaseData5).getResistanceLevel();
                            if (resistanceLevel4 != null) {
                                sysResponseDataBean5.setNow_level(resistanceLevel4);
                            }
                            Integer instantaneousPower3 = ((RowerData) ftmsBaseData5).getInstantaneousPower();
                            if (instantaneousPower3 != null) {
                                sysResponseDataBean5.setNow_watt(instantaneousPower3);
                            }
                            Double strokeRate = ((RowerData) ftmsBaseData5).getStrokeRate();
                            if (strokeRate != null) {
                                sysResponseDataBean5.setTotal_min_spm(strokeRate);
                            }
                            if (((RowerData) ftmsBaseData5).getStrokeCount() != null) {
                                sysResponseDataBean5.setTotal_spm(Double.valueOf(r11.intValue()));
                            }
                            arrayList.add(sysResponseDataBean5);
                        }
                    }
                }
                return arrayList;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                return new ArrayList();
            }
        }
    }
}
