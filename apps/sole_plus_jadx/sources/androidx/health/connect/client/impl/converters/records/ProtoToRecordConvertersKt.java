package androidx.health.connect.client.impl.converters.records;

import androidx.camera.video.AudioStats;
import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalBodyTemperatureRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodGlucoseRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.BodyFatRecord;
import androidx.health.connect.client.records.BodyTemperatureMeasurementLocation;
import androidx.health.connect.client.records.BodyTemperatureRecord;
import androidx.health.connect.client.records.BodyWaterMassRecord;
import androidx.health.connect.client.records.BoneMassRecord;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.LeanBodyMassRecord;
import androidx.health.connect.client.records.MealType;
import androidx.health.connect.client.records.MenstruationFlowRecord;
import androidx.health.connect.client.records.MenstruationPeriodRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.OvulationTestRecord;
import androidx.health.connect.client.records.OxygenSaturationRecord;
import androidx.health.connect.client.records.PowerRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.RespiratoryRateRecord;
import androidx.health.connect.client.records.RestingHeartRateRecord;
import androidx.health.connect.client.records.SexualActivityRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import androidx.health.connect.client.units.BloodGlucose;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.EnergyKt;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import androidx.health.connect.client.units.PercentageKt;
import androidx.health.connect.client.units.PowerKt;
import androidx.health.connect.client.units.PressureKt;
import androidx.health.connect.client.units.TemperatureKt;
import androidx.health.connect.client.units.VelocityKt;
import androidx.health.connect.client.units.VolumeKt;
import androidx.health.platform.client.proto.DataProto;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoToRecordConverters.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"toExerciseRouteData", "Landroidx/health/connect/client/records/ExerciseRoute;", "protoWrapper", "Landroidx/health/platform/client/exerciseroute/ExerciseRoute;", "toRecord", "Landroidx/health/connect/client/records/Record;", "proto", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProtoToRecordConvertersKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Record toRecord(DataProto.DataPoint proto) {
        List<ExerciseSegment> listEmptyList;
        List<ExerciseLap> listEmptyList2;
        ExerciseRouteResult.NoData noData;
        List<SleepSessionRecord.Stage> listEmptyList3;
        Intrinsics.checkNotNullParameter(proto, "proto");
        String name = proto.getDataType().getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2137162425:
                    if (name.equals("Height")) {
                        return new HeightRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), LengthKt.getMeters(ProtoToRecordUtilsKt.getDouble$default(proto, "height", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1931142571:
                    if (name.equals("BasalMetabolicRate")) {
                        return new BasalMetabolicRateRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), PowerKt.getKilocaloriesPerDay(ProtoToRecordUtilsKt.getDouble$default(proto, "bmr", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1878699588:
                    if (name.equals("MenstruationPeriod")) {
                        return new MenstruationPeriodRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1739492291:
                    if (name.equals("HeartRateSeries")) {
                        Instant startTime = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        List<DataProto.SeriesValue> seriesValuesList = proto.getSeriesValuesList();
                        Intrinsics.checkNotNullExpressionValue(seriesValuesList, "seriesValuesList");
                        List<DataProto.SeriesValue> list = seriesValuesList;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        for (DataProto.SeriesValue value : list) {
                            Instant instantOfEpochMilli = Instant.ofEpochMilli(value.getInstantTimeMillis());
                            Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli, "ofEpochMilli(value.instantTimeMillis)");
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            arrayList.add(new HeartRateRecord.Sample(instantOfEpochMilli, ProtoToRecordUtilsKt.getLong$default(value, "bpm", 0L, 2, (Object) null)));
                        }
                        return new HeartRateRecord(startTime, startZoneOffset, endTime, endZoneOffset, arrayList, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1728782805:
                    if (name.equals("Vo2Max")) {
                        DataProto.DataPoint dataPoint = proto;
                        return new Vo2MaxRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.getDouble$default(dataPoint, "vo2", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null), ProtoToRecordUtilsKt.mapEnum(dataPoint, "measurementMethod", Vo2MaxRecord.MEASUREMENT_METHOD_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1707725160:
                    if (name.equals("Weight")) {
                        return new WeightRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(proto, "weight", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1547814841:
                    if (name.equals("HeartRateVariabilityRmssd")) {
                        DataProto.DataPoint dataPoint2 = proto;
                        double double$default = 1.0d;
                        if (ProtoToRecordUtilsKt.getDouble$default(dataPoint2, "heartRateVariability", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null) >= 1.0d) {
                            double$default = 200.0d;
                            if (ProtoToRecordUtilsKt.getDouble$default(dataPoint2, "heartRateVariability", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null) <= 200.0d) {
                                double$default = ProtoToRecordUtilsKt.getDouble$default(dataPoint2, "heartRateVariability", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null);
                            }
                        }
                        return new HeartRateVariabilityRmssdRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), double$default, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1249467044:
                    if (name.equals("LeanBodyMass")) {
                        return new LeanBodyMassRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(proto, "mass", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1170329975:
                    if (name.equals("SexualActivity")) {
                        return new SexualActivityRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.mapEnum(proto, "protectionUsed", SexualActivityRecord.PROTECTION_USED_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -1089246824:
                    if (name.equals("TotalCaloriesBurned")) {
                        return new TotalCaloriesBurnedRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), EnergyKt.getKilocalories(ProtoToRecordUtilsKt.getDouble$default(proto, "energy", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -633416129:
                    if (name.equals("BloodPressure")) {
                        DataProto.DataPoint dataPoint3 = proto;
                        return new BloodPressureRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), PressureKt.getMillimetersOfMercury(ProtoToRecordUtilsKt.getDouble$default(dataPoint3, HealthConstants.BloodPressure.SYSTOLIC, AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), PressureKt.getMillimetersOfMercury(ProtoToRecordUtilsKt.getDouble$default(dataPoint3, HealthConstants.BloodPressure.DIASTOLIC, AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint3, "bodyPosition", BloodPressureRecord.BODY_POSITION_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint3, "measurementLocation", BloodPressureRecord.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -562822786:
                    if (name.equals("SpeedSeries")) {
                        Instant startTime2 = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset2 = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime2 = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset2 = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        List<DataProto.SeriesValue> seriesValuesList2 = proto.getSeriesValuesList();
                        Intrinsics.checkNotNullExpressionValue(seriesValuesList2, "seriesValuesList");
                        List<DataProto.SeriesValue> list2 = seriesValuesList2;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        for (DataProto.SeriesValue value2 : list2) {
                            Instant instantOfEpochMilli2 = Instant.ofEpochMilli(value2.getInstantTimeMillis());
                            Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli2, "ofEpochMilli(value.instantTimeMillis)");
                            Intrinsics.checkNotNullExpressionValue(value2, "value");
                            arrayList2.add(new SpeedRecord.Sample(instantOfEpochMilli2, VelocityKt.getMetersPerSecond(ProtoToRecordUtilsKt.getDouble$default(value2, "speed", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null))));
                        }
                        return new SpeedRecord(startTime2, startZoneOffset2, endTime2, endZoneOffset2, arrayList2, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -561665783:
                    if (name.equals("BodyWaterMass")) {
                        return new BodyWaterMassRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(proto, "mass", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -539421262:
                    if (name.equals("OxygenSaturation")) {
                        return new OxygenSaturationRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), PercentageKt.getPercent(ProtoToRecordUtilsKt.getDouble$default(proto, "percentage", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case -136898551:
                    if (name.equals("OvulationTest")) {
                        return new OvulationTestRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.mapEnum(proto, "result", OvulationTestRecord.RESULT_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 8847540:
                    if (name.equals("BloodGlucose")) {
                        DataProto.DataPoint dataPoint4 = proto;
                        return new BloodGlucoseRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), BloodGlucose.INSTANCE.millimolesPerLiter(ProtoToRecordUtilsKt.getDouble$default(dataPoint4, FirebaseAnalytics.Param.LEVEL, AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint4, "specimenSource", BloodGlucoseRecord.SPECIMEN_SOURCE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint4, "mealType", MealType.MEAL_TYPE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint4, "relationToMeal", BloodGlucoseRecord.RELATION_TO_MEAL_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 80208647:
                    if (name.equals("Steps")) {
                        return new StepsRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), ProtoToRecordUtilsKt.getLong$default(proto, "count", 0L, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 128630298:
                    if (name.equals("ActiveCaloriesBurned")) {
                        return new ActiveCaloriesBurnedRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), EnergyKt.getKilocalories(ProtoToRecordUtilsKt.getDouble$default(proto, "energy", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 187665747:
                    if (name.equals("BasalBodyTemperature")) {
                        DataProto.DataPoint dataPoint5 = proto;
                        return new BasalBodyTemperatureRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), TemperatureKt.getCelsius(ProtoToRecordUtilsKt.getDouble$default(dataPoint5, "temperature", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint5, "measurementLocation", BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 246984731:
                    if (name.equals("Menstruation")) {
                        return new MenstruationFlowRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.mapEnum(proto, "flow", MenstruationFlowRecord.FLOW_TYPE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 353103893:
                    if (name.equals("Distance")) {
                        return new DistanceRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), LengthKt.getMeters(ProtoToRecordUtilsKt.getDouble$default(proto, "distance", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 557067342:
                    if (name.equals("CervicalMucus")) {
                        DataProto.DataPoint dataPoint6 = proto;
                        return new CervicalMucusRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.mapEnum(dataPoint6, "texture", CervicalMucusRecord.APPEARANCE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.mapEnum(dataPoint6, "amount", CervicalMucusRecord.SENSATION_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 761063032:
                    if (name.equals("RestingHeartRate")) {
                        return new RestingHeartRateRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.getLong$default(proto, "bpm", 0L, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 955204109:
                    if (name.equals("FloorsClimbed")) {
                        return new FloorsClimbedRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), ProtoToRecordUtilsKt.getDouble$default(proto, "floors", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 989918314:
                    if (name.equals("RespiratoryRate")) {
                        return new RespiratoryRateRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.getDouble$default(proto, "rate", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1051870422:
                    if (name.equals("Hydration")) {
                        return new HydrationRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), VolumeKt.getLiters(ProtoToRecordUtilsKt.getDouble$default(proto, "volume", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1108584865:
                    if (name.equals("StepsCadenceSeries")) {
                        Instant startTime3 = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset3 = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime3 = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset3 = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        List<DataProto.SeriesValue> seriesValuesList3 = proto.getSeriesValuesList();
                        Intrinsics.checkNotNullExpressionValue(seriesValuesList3, "seriesValuesList");
                        List<DataProto.SeriesValue> list3 = seriesValuesList3;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (DataProto.SeriesValue value3 : list3) {
                            Instant instantOfEpochMilli3 = Instant.ofEpochMilli(value3.getInstantTimeMillis());
                            Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli3, "ofEpochMilli(value.instantTimeMillis)");
                            Intrinsics.checkNotNullExpressionValue(value3, "value");
                            arrayList3.add(new StepsCadenceRecord.Sample(instantOfEpochMilli3, ProtoToRecordUtilsKt.getDouble$default(value3, "rate", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)));
                        }
                        return new StepsCadenceRecord(startTime3, startZoneOffset3, endTime3, endZoneOffset3, arrayList3, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1193457969:
                    if (name.equals("IntermenstrualBleeding")) {
                        return new IntermenstrualBleedingRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1468615931:
                    if (name.equals("ElevationGained")) {
                        return new ElevationGainedRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), LengthKt.getMeters(ProtoToRecordUtilsKt.getDouble$default(proto, "elevation", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1478142546:
                    if (name.equals("WheelchairPushes")) {
                        return new WheelchairPushesRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), ProtoToRecordUtilsKt.getLong$default(proto, "count", 0L, 2, (Object) null), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1498531293:
                    if (name.equals("CyclingPedalingCadenceSeries")) {
                        Instant startTime4 = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset4 = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime4 = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset4 = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        List<DataProto.SeriesValue> seriesValuesList4 = proto.getSeriesValuesList();
                        Intrinsics.checkNotNullExpressionValue(seriesValuesList4, "seriesValuesList");
                        List<DataProto.SeriesValue> list4 = seriesValuesList4;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                        for (DataProto.SeriesValue value4 : list4) {
                            Instant instantOfEpochMilli4 = Instant.ofEpochMilli(value4.getInstantTimeMillis());
                            Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli4, "ofEpochMilli(value.instantTimeMillis)");
                            Intrinsics.checkNotNullExpressionValue(value4, "value");
                            arrayList4.add(new CyclingPedalingCadenceRecord.Sample(instantOfEpochMilli4, ProtoToRecordUtilsKt.getDouble$default(value4, "rpm", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)));
                        }
                        return new CyclingPedalingCadenceRecord(startTime4, startZoneOffset4, endTime4, endZoneOffset4, arrayList4, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1513758823:
                    if (name.equals("ActivitySession")) {
                        DataProto.DataPoint dataPoint7 = proto;
                        int iMapEnum = ProtoToRecordUtilsKt.mapEnum(dataPoint7, "activityType", ExerciseSessionRecord.EXERCISE_TYPE_STRING_TO_INT_MAP, 0);
                        String string = ProtoToRecordUtilsKt.getString(dataPoint7, "title");
                        String string2 = ProtoToRecordUtilsKt.getString(dataPoint7, "notes");
                        Instant startTime5 = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset5 = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime5 = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset5 = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        androidx.health.connect.client.records.metadata.Metadata metadata = ProtoToRecordUtilsKt.getMetadata(proto);
                        DataProto.DataPoint.SubTypeDataList subTypeDataList = proto.getSubTypeDataListsMap().get("segments");
                        if (subTypeDataList == null || (listEmptyList = ProtoToRecordUtilsKt.toSegmentList(subTypeDataList)) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List<ExerciseSegment> list5 = listEmptyList;
                        DataProto.DataPoint.SubTypeDataList subTypeDataList2 = proto.getSubTypeDataListsMap().get("laps");
                        if (subTypeDataList2 == null || (listEmptyList2 = ProtoToRecordUtilsKt.toLapList(subTypeDataList2)) == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        List<ExerciseLap> list6 = listEmptyList2;
                        DataProto.DataPoint.SubTypeDataList subTypeDataList3 = proto.getSubTypeDataListsMap().get("route");
                        if (subTypeDataList3 != null) {
                            noData = new ExerciseRouteResult.Data(new ExerciseRoute(ProtoToRecordUtilsKt.toLocationList(subTypeDataList3)));
                        } else {
                            DataProto.Value value5 = proto.getValuesMap().get("hasRoute");
                            noData = (value5 == null || !value5.getBooleanVal()) ? new ExerciseRouteResult.NoData() : new ExerciseRouteResult.ConsentRequired();
                        }
                        return new ExerciseSessionRecord(startTime5, startZoneOffset5, endTime5, endZoneOffset5, iMapEnum, string, string2, metadata, list5, list6, noData);
                    }
                    break;
                case 1584919122:
                    if (name.equals("BodyTemperature")) {
                        DataProto.DataPoint dataPoint8 = proto;
                        return new BodyTemperatureRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), TemperatureKt.getCelsius(ProtoToRecordUtilsKt.getDouble$default(dataPoint8, "temperature", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.mapEnum(dataPoint8, "measurementLocation", BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1719563767:
                    if (name.equals("BodyFat")) {
                        return new BodyFatRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), PercentageKt.getPercent(ProtoToRecordUtilsKt.getDouble$default(proto, "percentage", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 1738316664:
                    if (name.equals("Nutrition")) {
                        DataProto.Value value6 = proto.getValuesMap().get("biotin");
                        Mass grams = value6 != null ? MassKt.getGrams(value6.getDoubleVal()) : null;
                        DataProto.Value value7 = proto.getValuesMap().get("caffeine");
                        Mass grams2 = value7 != null ? MassKt.getGrams(value7.getDoubleVal()) : null;
                        DataProto.Value value8 = proto.getValuesMap().get("calcium");
                        Mass grams3 = value8 != null ? MassKt.getGrams(value8.getDoubleVal()) : null;
                        DataProto.Value value9 = proto.getValuesMap().get("calories");
                        Energy kilocalories = value9 != null ? EnergyKt.getKilocalories(value9.getDoubleVal()) : null;
                        DataProto.Value value10 = proto.getValuesMap().get("caloriesFromFat");
                        Energy kilocalories2 = value10 != null ? EnergyKt.getKilocalories(value10.getDoubleVal()) : null;
                        DataProto.Value value11 = proto.getValuesMap().get("chloride");
                        Mass grams4 = value11 != null ? MassKt.getGrams(value11.getDoubleVal()) : null;
                        DataProto.Value value12 = proto.getValuesMap().get("cholesterol");
                        Mass grams5 = value12 != null ? MassKt.getGrams(value12.getDoubleVal()) : null;
                        DataProto.Value value13 = proto.getValuesMap().get("chromium");
                        Mass grams6 = value13 != null ? MassKt.getGrams(value13.getDoubleVal()) : null;
                        DataProto.Value value14 = proto.getValuesMap().get("copper");
                        Mass grams7 = value14 != null ? MassKt.getGrams(value14.getDoubleVal()) : null;
                        DataProto.Value value15 = proto.getValuesMap().get("dietaryFiber");
                        Mass grams8 = value15 != null ? MassKt.getGrams(value15.getDoubleVal()) : null;
                        DataProto.Value value16 = proto.getValuesMap().get("folate");
                        Mass grams9 = value16 != null ? MassKt.getGrams(value16.getDoubleVal()) : null;
                        DataProto.Value value17 = proto.getValuesMap().get("folicAcid");
                        Mass grams10 = value17 != null ? MassKt.getGrams(value17.getDoubleVal()) : null;
                        DataProto.Value value18 = proto.getValuesMap().get("iodine");
                        Mass grams11 = value18 != null ? MassKt.getGrams(value18.getDoubleVal()) : null;
                        DataProto.Value value19 = proto.getValuesMap().get("iron");
                        Mass grams12 = value19 != null ? MassKt.getGrams(value19.getDoubleVal()) : null;
                        DataProto.Value value20 = proto.getValuesMap().get("magnesium");
                        Mass grams13 = value20 != null ? MassKt.getGrams(value20.getDoubleVal()) : null;
                        DataProto.Value value21 = proto.getValuesMap().get("manganese");
                        Mass grams14 = value21 != null ? MassKt.getGrams(value21.getDoubleVal()) : null;
                        DataProto.Value value22 = proto.getValuesMap().get("molybdenum");
                        Mass grams15 = value22 != null ? MassKt.getGrams(value22.getDoubleVal()) : null;
                        DataProto.Value value23 = proto.getValuesMap().get("monounsaturatedFat");
                        Mass grams16 = value23 != null ? MassKt.getGrams(value23.getDoubleVal()) : null;
                        DataProto.Value value24 = proto.getValuesMap().get("niacin");
                        Mass grams17 = value24 != null ? MassKt.getGrams(value24.getDoubleVal()) : null;
                        DataProto.Value value25 = proto.getValuesMap().get("pantothenicAcid");
                        Mass grams18 = value25 != null ? MassKt.getGrams(value25.getDoubleVal()) : null;
                        DataProto.Value value26 = proto.getValuesMap().get("phosphorus");
                        Mass grams19 = value26 != null ? MassKt.getGrams(value26.getDoubleVal()) : null;
                        DataProto.Value value27 = proto.getValuesMap().get("polyunsaturatedFat");
                        Mass grams20 = value27 != null ? MassKt.getGrams(value27.getDoubleVal()) : null;
                        DataProto.Value value28 = proto.getValuesMap().get("potassium");
                        Mass grams21 = value28 != null ? MassKt.getGrams(value28.getDoubleVal()) : null;
                        DataProto.Value value29 = proto.getValuesMap().get("protein");
                        Mass grams22 = value29 != null ? MassKt.getGrams(value29.getDoubleVal()) : null;
                        DataProto.Value value30 = proto.getValuesMap().get("riboflavin");
                        Mass grams23 = value30 != null ? MassKt.getGrams(value30.getDoubleVal()) : null;
                        DataProto.Value value31 = proto.getValuesMap().get("saturatedFat");
                        Mass grams24 = value31 != null ? MassKt.getGrams(value31.getDoubleVal()) : null;
                        DataProto.Value value32 = proto.getValuesMap().get("selenium");
                        Mass grams25 = value32 != null ? MassKt.getGrams(value32.getDoubleVal()) : null;
                        DataProto.Value value33 = proto.getValuesMap().get("sodium");
                        Mass grams26 = value33 != null ? MassKt.getGrams(value33.getDoubleVal()) : null;
                        DataProto.Value value34 = proto.getValuesMap().get("sugar");
                        Mass grams27 = value34 != null ? MassKt.getGrams(value34.getDoubleVal()) : null;
                        DataProto.Value value35 = proto.getValuesMap().get("thiamin");
                        Mass grams28 = value35 != null ? MassKt.getGrams(value35.getDoubleVal()) : null;
                        DataProto.Value value36 = proto.getValuesMap().get("totalCarbohydrate");
                        Mass grams29 = value36 != null ? MassKt.getGrams(value36.getDoubleVal()) : null;
                        DataProto.Value value37 = proto.getValuesMap().get("totalFat");
                        Mass grams30 = value37 != null ? MassKt.getGrams(value37.getDoubleVal()) : null;
                        DataProto.Value value38 = proto.getValuesMap().get("transFat");
                        Mass grams31 = value38 != null ? MassKt.getGrams(value38.getDoubleVal()) : null;
                        DataProto.Value value39 = proto.getValuesMap().get("unsaturatedFat");
                        Mass grams32 = value39 != null ? MassKt.getGrams(value39.getDoubleVal()) : null;
                        DataProto.Value value40 = proto.getValuesMap().get("vitaminA");
                        Mass grams33 = value40 != null ? MassKt.getGrams(value40.getDoubleVal()) : null;
                        DataProto.Value value41 = proto.getValuesMap().get("vitaminB12");
                        Mass grams34 = value41 != null ? MassKt.getGrams(value41.getDoubleVal()) : null;
                        DataProto.Value value42 = proto.getValuesMap().get("vitaminB6");
                        Mass grams35 = value42 != null ? MassKt.getGrams(value42.getDoubleVal()) : null;
                        DataProto.Value value43 = proto.getValuesMap().get("vitaminC");
                        Mass grams36 = value43 != null ? MassKt.getGrams(value43.getDoubleVal()) : null;
                        DataProto.Value value44 = proto.getValuesMap().get("vitaminD");
                        Mass grams37 = value44 != null ? MassKt.getGrams(value44.getDoubleVal()) : null;
                        DataProto.Value value45 = proto.getValuesMap().get("vitaminE");
                        Mass grams38 = value45 != null ? MassKt.getGrams(value45.getDoubleVal()) : null;
                        DataProto.Value value46 = proto.getValuesMap().get("vitaminK");
                        Mass grams39 = value46 != null ? MassKt.getGrams(value46.getDoubleVal()) : null;
                        DataProto.Value value47 = proto.getValuesMap().get("zinc");
                        Mass grams40 = value47 != null ? MassKt.getGrams(value47.getDoubleVal()) : null;
                        DataProto.DataPoint dataPoint9 = proto;
                        return new NutritionRecord(ProtoToRecordUtilsKt.getStartTime(proto), ProtoToRecordUtilsKt.getStartZoneOffset(proto), ProtoToRecordUtilsKt.getEndTime(proto), ProtoToRecordUtilsKt.getEndZoneOffset(proto), grams, grams2, grams3, kilocalories, kilocalories2, grams4, grams5, grams6, grams7, grams8, grams9, grams10, grams11, grams12, grams13, grams14, grams15, grams16, grams17, grams18, grams19, grams20, grams21, grams22, grams23, grams24, grams25, grams26, grams27, grams28, grams29, grams30, grams31, grams32, grams33, grams34, grams35, grams36, grams37, grams38, grams39, grams40, ProtoToRecordUtilsKt.getString(dataPoint9, "name"), ProtoToRecordUtilsKt.mapEnum(dataPoint9, "mealType", MealType.MEAL_TYPE_STRING_TO_INT_MAP, 0), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 2034898936:
                    if (name.equals("BoneMass")) {
                        return new BoneMassRecord(ProtoToRecordUtilsKt.getTime(proto), ProtoToRecordUtilsKt.getZoneOffset(proto), MassKt.getKilograms(ProtoToRecordUtilsKt.getDouble$default(proto, "mass", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null)), ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 2065313759:
                    if (name.equals("SleepSession")) {
                        DataProto.DataPoint dataPoint10 = proto;
                        String string3 = ProtoToRecordUtilsKt.getString(dataPoint10, "title");
                        String string4 = ProtoToRecordUtilsKt.getString(dataPoint10, "notes");
                        Instant startTime6 = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset6 = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime6 = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset6 = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        DataProto.DataPoint.SubTypeDataList subTypeDataList4 = proto.getSubTypeDataListsMap().get("stages");
                        if (subTypeDataList4 == null || (listEmptyList3 = ProtoToRecordUtilsKt.toStageList(subTypeDataList4)) == null) {
                            listEmptyList3 = CollectionsKt.emptyList();
                        }
                        return new SleepSessionRecord(startTime6, startZoneOffset6, endTime6, endZoneOffset6, string3, string4, listEmptyList3, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
                case 2095285180:
                    if (name.equals("PowerSeries")) {
                        Instant startTime7 = ProtoToRecordUtilsKt.getStartTime(proto);
                        ZoneOffset startZoneOffset7 = ProtoToRecordUtilsKt.getStartZoneOffset(proto);
                        Instant endTime7 = ProtoToRecordUtilsKt.getEndTime(proto);
                        ZoneOffset endZoneOffset7 = ProtoToRecordUtilsKt.getEndZoneOffset(proto);
                        List<DataProto.SeriesValue> seriesValuesList5 = proto.getSeriesValuesList();
                        Intrinsics.checkNotNullExpressionValue(seriesValuesList5, "seriesValuesList");
                        List<DataProto.SeriesValue> list7 = seriesValuesList5;
                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                        for (DataProto.SeriesValue value48 : list7) {
                            Instant instantOfEpochMilli5 = Instant.ofEpochMilli(value48.getInstantTimeMillis());
                            Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli5, "ofEpochMilli(value.instantTimeMillis)");
                            Intrinsics.checkNotNullExpressionValue(value48, "value");
                            arrayList5.add(new PowerRecord.Sample(instantOfEpochMilli5, PowerKt.getWatts(ProtoToRecordUtilsKt.getDouble$default(value48, "power", AudioStats.AUDIO_AMPLITUDE_NONE, 2, (Object) null))));
                        }
                        return new PowerRecord(startTime7, startZoneOffset7, endTime7, endZoneOffset7, arrayList5, ProtoToRecordUtilsKt.getMetadata(proto));
                    }
                    break;
            }
        }
        throw new RuntimeException("Unknown data type " + proto.getDataType().getName());
    }

    public static final ExerciseRoute toExerciseRouteData(androidx.health.platform.client.exerciseroute.ExerciseRoute protoWrapper) {
        Intrinsics.checkNotNullParameter(protoWrapper, "protoWrapper");
        List<DataProto.SubTypeDataValue> valuesList = protoWrapper.getProto().getValuesList();
        Intrinsics.checkNotNullExpressionValue(valuesList, "protoWrapper.proto.valuesList");
        List<DataProto.SubTypeDataValue> list = valuesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DataProto.SubTypeDataValue subTypeDataValue : list) {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(subTypeDataValue.getStartTimeMillis());
            DataProto.Value value = subTypeDataValue.getValuesMap().get("latitude");
            Intrinsics.checkNotNull(value);
            double doubleVal = value.getDoubleVal();
            DataProto.Value value2 = subTypeDataValue.getValuesMap().get("longitude");
            Intrinsics.checkNotNull(value2);
            double doubleVal2 = value2.getDoubleVal();
            DataProto.Value value3 = subTypeDataValue.getValuesMap().get("altitude");
            Length meters = value3 != null ? LengthKt.getMeters(value3.getDoubleVal()) : null;
            DataProto.Value value4 = subTypeDataValue.getValuesMap().get("horizontal_accuracy");
            Length meters2 = value4 != null ? LengthKt.getMeters(value4.getDoubleVal()) : null;
            DataProto.Value value5 = subTypeDataValue.getValuesMap().get("vertical_accuracy");
            Length meters3 = value5 != null ? LengthKt.getMeters(value5.getDoubleVal()) : null;
            Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli, "ofEpochMilli(value.startTimeMillis)");
            arrayList.add(new ExerciseRoute.Location(instantOfEpochMilli, doubleVal, doubleVal2, meters2, meters3, meters));
        }
        return new ExerciseRoute(arrayList);
    }
}
