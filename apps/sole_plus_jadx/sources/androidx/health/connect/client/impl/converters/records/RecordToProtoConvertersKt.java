package androidx.health.connect.client.impl.converters.records;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
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
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.IntervalRecord;
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
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.SexualActivityRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import androidx.health.platform.client.proto.DataProto;
import com.android.SdkConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordToProtoConverters.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001aG\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0002¨\u0006\u000e"}, d2 = {"toProto", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "Landroidx/health/connect/client/records/Record;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/health/connect/client/records/SeriesRecord;", "dataTypeName", "", "getSeriesValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", SdkConstants.FD_SAMPLE, "Landroidx/health/platform/client/proto/DataProto$SeriesValue;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecordToProtoConvertersKt {
    public static final DataProto.DataPoint toProto(Record record) {
        Intrinsics.checkNotNullParameter(record, "<this>");
        if (record instanceof BasalBodyTemperatureRecord) {
            DataProto.DataPoint.Builder dataType = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BasalBodyTemperature"));
            BasalBodyTemperatureRecord basalBodyTemperatureRecord = (BasalBodyTemperatureRecord) record;
            dataType.putValues("temperature", ValueExtKt.doubleVal(basalBodyTemperatureRecord.getTemperature().getCelsius()));
            DataProto.Value valueEnumValFromInt = ValueExtKt.enumValFromInt(basalBodyTemperatureRecord.getMeasurementLocation(), BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
            if (valueEnumValFromInt != null) {
                dataType.putValues("measurementLocation", valueEnumValFromInt);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild = dataType.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild;
        }
        if (record instanceof BasalMetabolicRateRecord) {
            DataProto.DataPoint.Builder dataType2 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BasalMetabolicRate"));
            dataType2.putValues("bmr", ValueExtKt.doubleVal(((BasalMetabolicRateRecord) record).getBasalMetabolicRate().getKilocaloriesPerDay()));
            DataProto.DataPoint dataPointBuild2 = dataType2.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild2, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild2;
        }
        if (record instanceof BloodGlucoseRecord) {
            DataProto.DataPoint.Builder dataType3 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BloodGlucose"));
            BloodGlucoseRecord bloodGlucoseRecord = (BloodGlucoseRecord) record;
            dataType3.putValues(FirebaseAnalytics.Param.LEVEL, ValueExtKt.doubleVal(bloodGlucoseRecord.getLevel().getMillimolesPerLiter()));
            DataProto.Value valueEnumValFromInt2 = ValueExtKt.enumValFromInt(bloodGlucoseRecord.getSpecimenSource(), BloodGlucoseRecord.SPECIMEN_SOURCE_INT_TO_STRING_MAP);
            if (valueEnumValFromInt2 != null) {
                dataType3.putValues("specimenSource", valueEnumValFromInt2);
            }
            DataProto.Value valueEnumValFromInt3 = ValueExtKt.enumValFromInt(bloodGlucoseRecord.getMealType(), MealType.MEAL_TYPE_INT_TO_STRING_MAP);
            if (valueEnumValFromInt3 != null) {
                dataType3.putValues("mealType", valueEnumValFromInt3);
            }
            DataProto.Value valueEnumValFromInt4 = ValueExtKt.enumValFromInt(bloodGlucoseRecord.getRelationToMeal(), BloodGlucoseRecord.RELATION_TO_MEAL_INT_TO_STRING_MAP);
            if (valueEnumValFromInt4 != null) {
                dataType3.putValues("relationToMeal", valueEnumValFromInt4);
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild3 = dataType3.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild3, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild3;
        }
        if (record instanceof BloodPressureRecord) {
            DataProto.DataPoint.Builder dataType4 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BloodPressure"));
            BloodPressureRecord bloodPressureRecord = (BloodPressureRecord) record;
            dataType4.putValues(HealthConstants.BloodPressure.SYSTOLIC, ValueExtKt.doubleVal(bloodPressureRecord.getSystolic().getValue()));
            dataType4.putValues(HealthConstants.BloodPressure.DIASTOLIC, ValueExtKt.doubleVal(bloodPressureRecord.getDiastolic().getValue()));
            DataProto.Value valueEnumValFromInt5 = ValueExtKt.enumValFromInt(bloodPressureRecord.getBodyPosition(), BloodPressureRecord.BODY_POSITION_INT_TO_STRING_MAP);
            if (valueEnumValFromInt5 != null) {
                dataType4.putValues("bodyPosition", valueEnumValFromInt5);
            }
            DataProto.Value valueEnumValFromInt6 = ValueExtKt.enumValFromInt(bloodPressureRecord.getMeasurementLocation(), BloodPressureRecord.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
            if (valueEnumValFromInt6 != null) {
                dataType4.putValues("measurementLocation", valueEnumValFromInt6);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild4 = dataType4.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild4, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild4;
        }
        if (record instanceof BodyFatRecord) {
            DataProto.DataPoint.Builder dataType5 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BodyFat"));
            dataType5.putValues("percentage", ValueExtKt.doubleVal(((BodyFatRecord) record).getPercentage().getValue()));
            DataProto.DataPoint dataPointBuild5 = dataType5.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild5, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild5;
        }
        if (record instanceof BodyTemperatureRecord) {
            DataProto.DataPoint.Builder dataType6 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BodyTemperature"));
            BodyTemperatureRecord bodyTemperatureRecord = (BodyTemperatureRecord) record;
            dataType6.putValues("temperature", ValueExtKt.doubleVal(bodyTemperatureRecord.getTemperature().getCelsius()));
            DataProto.Value valueEnumValFromInt7 = ValueExtKt.enumValFromInt(bodyTemperatureRecord.getMeasurementLocation(), BodyTemperatureMeasurementLocation.MEASUREMENT_LOCATION_INT_TO_STRING_MAP);
            if (valueEnumValFromInt7 != null) {
                dataType6.putValues("measurementLocation", valueEnumValFromInt7);
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild6 = dataType6.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild6, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild6;
        }
        if (record instanceof BodyWaterMassRecord) {
            DataProto.DataPoint.Builder dataType7 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BodyWaterMass"));
            dataType7.putValues("mass", ValueExtKt.doubleVal(((BodyWaterMassRecord) record).getMass().getKilograms()));
            DataProto.DataPoint dataPointBuild7 = dataType7.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild7, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild7;
        }
        if (record instanceof BoneMassRecord) {
            DataProto.DataPoint.Builder dataType8 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("BoneMass"));
            dataType8.putValues("mass", ValueExtKt.doubleVal(((BoneMassRecord) record).getMass().getKilograms()));
            DataProto.DataPoint dataPointBuild8 = dataType8.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild8, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild8;
        }
        if (record instanceof CervicalMucusRecord) {
            DataProto.DataPoint.Builder dataType9 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("CervicalMucus"));
            CervicalMucusRecord cervicalMucusRecord = (CervicalMucusRecord) record;
            DataProto.Value valueEnumValFromInt8 = ValueExtKt.enumValFromInt(cervicalMucusRecord.getAppearance(), CervicalMucusRecord.APPEARANCE_INT_TO_STRING_MAP);
            if (valueEnumValFromInt8 != null) {
                dataType9.putValues("texture", valueEnumValFromInt8);
            }
            DataProto.Value valueEnumValFromInt9 = ValueExtKt.enumValFromInt(cervicalMucusRecord.getSensation(), CervicalMucusRecord.SENSATION_INT_TO_STRING_MAP);
            if (valueEnumValFromInt9 != null) {
                dataType9.putValues("amount", valueEnumValFromInt9);
                Unit unit9 = Unit.INSTANCE;
                Unit unit10 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild9 = dataType9.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild9, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild9;
        }
        if (record instanceof CyclingPedalingCadenceRecord) {
            return toProto((SeriesRecord) record, "CyclingPedalingCadenceSeries", new Function1<CyclingPedalingCadenceRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto.10
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(CyclingPedalingCadenceRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue seriesValueBuild = DataProto.SeriesValue.newBuilder().putValues("rpm", ValueExtKt.doubleVal(sample.getRevolutionsPerMinute())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(seriesValueBuild, "newBuilder()\n           …                 .build()");
                    return seriesValueBuild;
                }
            });
        }
        if (record instanceof HeartRateRecord) {
            return toProto((SeriesRecord) record, "HeartRateSeries", new Function1<HeartRateRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto.11
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(HeartRateRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue seriesValueBuild = DataProto.SeriesValue.newBuilder().putValues("bpm", ValueExtKt.longVal(sample.getBeatsPerMinute())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(seriesValueBuild, "newBuilder()\n           …                 .build()");
                    return seriesValueBuild;
                }
            });
        }
        if (record instanceof HeightRecord) {
            DataProto.DataPoint.Builder dataType10 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Height"));
            dataType10.putValues("height", ValueExtKt.doubleVal(((HeightRecord) record).getHeight().getMeters()));
            DataProto.DataPoint dataPointBuild10 = dataType10.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild10, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild10;
        }
        if (record instanceof HeartRateVariabilityRmssdRecord) {
            DataProto.DataPoint.Builder dataType11 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("HeartRateVariabilityRmssd"));
            dataType11.putValues("heartRateVariability", ValueExtKt.doubleVal(((HeartRateVariabilityRmssdRecord) record).getHeartRateVariabilityMillis()));
            DataProto.DataPoint dataPointBuild11 = dataType11.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild11, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild11;
        }
        if (record instanceof IntermenstrualBleedingRecord) {
            DataProto.DataPoint dataPointBuild12 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("IntermenstrualBleeding")).build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild12, "instantaneousProto().set…strualBleeding\")).build()");
            return dataPointBuild12;
        }
        if (record instanceof LeanBodyMassRecord) {
            DataProto.DataPoint.Builder dataType12 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("LeanBodyMass"));
            dataType12.putValues("mass", ValueExtKt.doubleVal(((LeanBodyMassRecord) record).getMass().getKilograms()));
            DataProto.DataPoint dataPointBuild13 = dataType12.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild13, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild13;
        }
        if (record instanceof MenstruationFlowRecord) {
            DataProto.DataPoint.Builder dataType13 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Menstruation"));
            DataProto.Value valueEnumValFromInt10 = ValueExtKt.enumValFromInt(((MenstruationFlowRecord) record).getFlow(), MenstruationFlowRecord.FLOW_TYPE_INT_TO_STRING_MAP);
            if (valueEnumValFromInt10 != null) {
                dataType13.putValues("flow", valueEnumValFromInt10);
                Unit unit11 = Unit.INSTANCE;
                Unit unit12 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild14 = dataType13.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild14, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild14;
        }
        if (record instanceof MenstruationPeriodRecord) {
            DataProto.DataPoint dataPointBuild15 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("MenstruationPeriod")).build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild15, "intervalProto().setDataT…truationPeriod\")).build()");
            return dataPointBuild15;
        }
        if (record instanceof OvulationTestRecord) {
            DataProto.DataPoint.Builder dataType14 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("OvulationTest"));
            DataProto.Value valueEnumValFromInt11 = ValueExtKt.enumValFromInt(((OvulationTestRecord) record).getResult(), OvulationTestRecord.RESULT_INT_TO_STRING_MAP);
            if (valueEnumValFromInt11 != null) {
                dataType14.putValues("result", valueEnumValFromInt11);
                Unit unit13 = Unit.INSTANCE;
                Unit unit14 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild16 = dataType14.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild16, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild16;
        }
        if (record instanceof OxygenSaturationRecord) {
            DataProto.DataPoint.Builder dataType15 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("OxygenSaturation"));
            dataType15.putValues("percentage", ValueExtKt.doubleVal(((OxygenSaturationRecord) record).getPercentage().getValue()));
            DataProto.DataPoint dataPointBuild17 = dataType15.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild17, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild17;
        }
        if (record instanceof PowerRecord) {
            return toProto((SeriesRecord) record, "PowerSeries", new Function1<PowerRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto.18
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(PowerRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue seriesValueBuild = DataProto.SeriesValue.newBuilder().putValues("power", ValueExtKt.doubleVal(sample.getPower().getWatts())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(seriesValueBuild, "newBuilder()\n           …                 .build()");
                    return seriesValueBuild;
                }
            });
        }
        if (record instanceof RespiratoryRateRecord) {
            DataProto.DataPoint.Builder dataType16 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("RespiratoryRate"));
            dataType16.putValues("rate", ValueExtKt.doubleVal(((RespiratoryRateRecord) record).getRate()));
            DataProto.DataPoint dataPointBuild18 = dataType16.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild18, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild18;
        }
        if (record instanceof RestingHeartRateRecord) {
            DataProto.DataPoint.Builder dataType17 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("RestingHeartRate"));
            dataType17.putValues("bpm", ValueExtKt.longVal(((RestingHeartRateRecord) record).getBeatsPerMinute()));
            DataProto.DataPoint dataPointBuild19 = dataType17.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild19, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild19;
        }
        if (record instanceof SexualActivityRecord) {
            DataProto.DataPoint.Builder dataType18 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("SexualActivity"));
            DataProto.Value valueEnumValFromInt12 = ValueExtKt.enumValFromInt(((SexualActivityRecord) record).getProtectionUsed(), SexualActivityRecord.PROTECTION_USED_INT_TO_STRING_MAP);
            if (valueEnumValFromInt12 != null) {
                dataType18.putValues("protectionUsed", valueEnumValFromInt12);
                Unit unit15 = Unit.INSTANCE;
                Unit unit16 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild20 = dataType18.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild20, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild20;
        }
        if (record instanceof SpeedRecord) {
            return toProto((SeriesRecord) record, "SpeedSeries", new Function1<SpeedRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto.22
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(SpeedRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue seriesValueBuild = DataProto.SeriesValue.newBuilder().putValues("speed", ValueExtKt.doubleVal(sample.getSpeed().getMetersPerSecond())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(seriesValueBuild, "newBuilder()\n           …                 .build()");
                    return seriesValueBuild;
                }
            });
        }
        if (record instanceof StepsCadenceRecord) {
            return toProto((SeriesRecord) record, "StepsCadenceSeries", new Function1<StepsCadenceRecord.Sample, DataProto.SeriesValue>() { // from class: androidx.health.connect.client.impl.converters.records.RecordToProtoConvertersKt.toProto.23
                @Override // kotlin.jvm.functions.Function1
                public final DataProto.SeriesValue invoke(StepsCadenceRecord.Sample sample) {
                    Intrinsics.checkNotNullParameter(sample, "sample");
                    DataProto.SeriesValue seriesValueBuild = DataProto.SeriesValue.newBuilder().putValues("rate", ValueExtKt.doubleVal(sample.getRate())).setInstantTimeMillis(sample.getTime().toEpochMilli()).build();
                    Intrinsics.checkNotNullExpressionValue(seriesValueBuild, "newBuilder()\n           …                 .build()");
                    return seriesValueBuild;
                }
            });
        }
        if (record instanceof Vo2MaxRecord) {
            DataProto.DataPoint.Builder dataType19 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Vo2Max"));
            Vo2MaxRecord vo2MaxRecord = (Vo2MaxRecord) record;
            dataType19.putValues("vo2", ValueExtKt.doubleVal(vo2MaxRecord.getVo2MillilitersPerMinuteKilogram()));
            DataProto.Value valueEnumValFromInt13 = ValueExtKt.enumValFromInt(vo2MaxRecord.getMeasurementMethod(), Vo2MaxRecord.MEASUREMENT_METHOD_INT_TO_STRING_MAP);
            if (valueEnumValFromInt13 != null) {
                dataType19.putValues("measurementMethod", valueEnumValFromInt13);
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild21 = dataType19.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild21, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild21;
        }
        if (record instanceof WeightRecord) {
            DataProto.DataPoint.Builder dataType20 = RecordToProtoUtilsKt.instantaneousProto((InstantaneousRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Weight"));
            dataType20.putValues("weight", ValueExtKt.doubleVal(((WeightRecord) record).getWeight().getKilograms()));
            DataProto.DataPoint dataPointBuild22 = dataType20.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild22, "instantaneousProto()\n   …\n                .build()");
            return dataPointBuild22;
        }
        if (record instanceof ActiveCaloriesBurnedRecord) {
            DataProto.DataPoint.Builder dataType21 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("ActiveCaloriesBurned"));
            dataType21.putValues("energy", ValueExtKt.doubleVal(((ActiveCaloriesBurnedRecord) record).getEnergy().getKilocalories()));
            DataProto.DataPoint dataPointBuild23 = dataType21.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild23, "intervalProto()\n        …\n                .build()");
            return dataPointBuild23;
        }
        if (record instanceof ExerciseSessionRecord) {
            DataProto.DataPoint.Builder dataType22 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("ActivitySession"));
            ExerciseSessionRecord exerciseSessionRecord = (ExerciseSessionRecord) record;
            DataProto.DataPoint.Builder builderPutValues = dataType22.putValues("hasRoute", ValueExtKt.boolVal(!(exerciseSessionRecord.getExerciseRouteResult() instanceof ExerciseRouteResult.NoData)));
            DataProto.Value valueEnumValFromInt14 = ValueExtKt.enumValFromInt(exerciseSessionRecord.getExerciseType(), ExerciseSessionRecord.EXERCISE_TYPE_INT_TO_STRING_MAP);
            if (valueEnumValFromInt14 == null) {
                valueEnumValFromInt14 = ValueExtKt.enumVal(NotificationCompat.CATEGORY_WORKOUT);
            }
            builderPutValues.putValues("activityType", valueEnumValFromInt14);
            String title = exerciseSessionRecord.getTitle();
            if (title != null) {
                builderPutValues.putValues("title", ValueExtKt.stringVal(title));
            }
            String notes = exerciseSessionRecord.getNotes();
            if (notes != null) {
                builderPutValues.putValues("notes", ValueExtKt.stringVal(notes));
            }
            if (!exerciseSessionRecord.getSegments().isEmpty()) {
                DataProto.DataPoint.SubTypeDataList.Builder builderNewBuilder = DataProto.DataPoint.SubTypeDataList.newBuilder();
                List<ExerciseSegment> segments = exerciseSessionRecord.getSegments();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(segments, 10));
                Iterator<T> it = segments.iterator();
                while (it.hasNext()) {
                    arrayList.add(RecordToProtoUtilsKt.toProto((ExerciseSegment) it.next()));
                }
                builderPutValues.putSubTypeDataLists("segments", builderNewBuilder.addAllValues(arrayList).build());
            }
            if (!exerciseSessionRecord.getLaps().isEmpty()) {
                DataProto.DataPoint.SubTypeDataList.Builder builderNewBuilder2 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                List<ExerciseLap> laps = exerciseSessionRecord.getLaps();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(laps, 10));
                Iterator<T> it2 = laps.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(RecordToProtoUtilsKt.toProto((ExerciseLap) it2.next()));
                }
                builderPutValues.putSubTypeDataLists("laps", builderNewBuilder2.addAllValues(arrayList2).build());
            }
            if (exerciseSessionRecord.getExerciseRouteResult() instanceof ExerciseRouteResult.Data) {
                DataProto.DataPoint.SubTypeDataList.Builder builderNewBuilder3 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                List<ExerciseRoute.Location> route = ((ExerciseRouteResult.Data) exerciseSessionRecord.getExerciseRouteResult()).getExerciseRoute().getRoute();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(route, 10));
                Iterator<T> it3 = route.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(RecordToProtoUtilsKt.toProto((ExerciseRoute.Location) it3.next()));
                }
                builderPutValues.putSubTypeDataLists("route", builderNewBuilder3.addAllValues(arrayList3).build());
            }
            DataProto.DataPoint dataPointBuild24 = builderPutValues.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild24, "intervalProto()\n        …\n                .build()");
            return dataPointBuild24;
        }
        if (record instanceof DistanceRecord) {
            DataProto.DataPoint.Builder dataType23 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Distance"));
            dataType23.putValues("distance", ValueExtKt.doubleVal(((DistanceRecord) record).getDistance().getMeters()));
            DataProto.DataPoint dataPointBuild25 = dataType23.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild25, "intervalProto()\n        …\n                .build()");
            return dataPointBuild25;
        }
        if (record instanceof ElevationGainedRecord) {
            DataProto.DataPoint.Builder dataType24 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("ElevationGained"));
            dataType24.putValues("elevation", ValueExtKt.doubleVal(((ElevationGainedRecord) record).getElevation().getMeters()));
            DataProto.DataPoint dataPointBuild26 = dataType24.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild26, "intervalProto()\n        …\n                .build()");
            return dataPointBuild26;
        }
        if (record instanceof FloorsClimbedRecord) {
            DataProto.DataPoint.Builder dataType25 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("FloorsClimbed"));
            dataType25.putValues("floors", ValueExtKt.doubleVal(((FloorsClimbedRecord) record).getFloors()));
            DataProto.DataPoint dataPointBuild27 = dataType25.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild27, "intervalProto()\n        …\n                .build()");
            return dataPointBuild27;
        }
        if (record instanceof HydrationRecord) {
            DataProto.DataPoint.Builder dataType26 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Hydration"));
            dataType26.putValues("volume", ValueExtKt.doubleVal(((HydrationRecord) record).getVolume().getLiters()));
            DataProto.DataPoint dataPointBuild28 = dataType26.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild28, "intervalProto()\n        …\n                .build()");
            return dataPointBuild28;
        }
        if (record instanceof NutritionRecord) {
            DataProto.DataPoint.Builder dataType27 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Nutrition"));
            NutritionRecord nutritionRecord = (NutritionRecord) record;
            if (nutritionRecord.getBiotin() != null) {
                dataType27.putValues("biotin", ValueExtKt.doubleVal(nutritionRecord.getBiotin().getGrams()));
            }
            if (nutritionRecord.getCaffeine() != null) {
                dataType27.putValues("caffeine", ValueExtKt.doubleVal(nutritionRecord.getCaffeine().getGrams()));
            }
            if (nutritionRecord.getCalcium() != null) {
                dataType27.putValues("calcium", ValueExtKt.doubleVal(nutritionRecord.getCalcium().getGrams()));
            }
            if (nutritionRecord.getEnergy() != null) {
                dataType27.putValues("calories", ValueExtKt.doubleVal(nutritionRecord.getEnergy().getKilocalories()));
            }
            if (nutritionRecord.getEnergyFromFat() != null) {
                dataType27.putValues("caloriesFromFat", ValueExtKt.doubleVal(nutritionRecord.getEnergyFromFat().getKilocalories()));
            }
            if (nutritionRecord.getChloride() != null) {
                dataType27.putValues("chloride", ValueExtKt.doubleVal(nutritionRecord.getChloride().getGrams()));
            }
            if (nutritionRecord.getCholesterol() != null) {
                dataType27.putValues("cholesterol", ValueExtKt.doubleVal(nutritionRecord.getCholesterol().getGrams()));
            }
            if (nutritionRecord.getChromium() != null) {
                dataType27.putValues("chromium", ValueExtKt.doubleVal(nutritionRecord.getChromium().getGrams()));
            }
            if (nutritionRecord.getCopper() != null) {
                dataType27.putValues("copper", ValueExtKt.doubleVal(nutritionRecord.getCopper().getGrams()));
            }
            if (nutritionRecord.getDietaryFiber() != null) {
                dataType27.putValues("dietaryFiber", ValueExtKt.doubleVal(nutritionRecord.getDietaryFiber().getGrams()));
            }
            if (nutritionRecord.getFolate() != null) {
                dataType27.putValues("folate", ValueExtKt.doubleVal(nutritionRecord.getFolate().getGrams()));
            }
            if (nutritionRecord.getFolicAcid() != null) {
                dataType27.putValues("folicAcid", ValueExtKt.doubleVal(nutritionRecord.getFolicAcid().getGrams()));
            }
            if (nutritionRecord.getIodine() != null) {
                dataType27.putValues("iodine", ValueExtKt.doubleVal(nutritionRecord.getIodine().getGrams()));
            }
            if (nutritionRecord.getIron() != null) {
                dataType27.putValues("iron", ValueExtKt.doubleVal(nutritionRecord.getIron().getGrams()));
            }
            if (nutritionRecord.getMagnesium() != null) {
                dataType27.putValues("magnesium", ValueExtKt.doubleVal(nutritionRecord.getMagnesium().getGrams()));
            }
            if (nutritionRecord.getManganese() != null) {
                dataType27.putValues("manganese", ValueExtKt.doubleVal(nutritionRecord.getManganese().getGrams()));
            }
            if (nutritionRecord.getMolybdenum() != null) {
                dataType27.putValues("molybdenum", ValueExtKt.doubleVal(nutritionRecord.getMolybdenum().getGrams()));
            }
            if (nutritionRecord.getMonounsaturatedFat() != null) {
                dataType27.putValues("monounsaturatedFat", ValueExtKt.doubleVal(nutritionRecord.getMonounsaturatedFat().getGrams()));
            }
            if (nutritionRecord.getNiacin() != null) {
                dataType27.putValues("niacin", ValueExtKt.doubleVal(nutritionRecord.getNiacin().getGrams()));
            }
            if (nutritionRecord.getPantothenicAcid() != null) {
                dataType27.putValues("pantothenicAcid", ValueExtKt.doubleVal(nutritionRecord.getPantothenicAcid().getGrams()));
            }
            if (nutritionRecord.getPhosphorus() != null) {
                dataType27.putValues("phosphorus", ValueExtKt.doubleVal(nutritionRecord.getPhosphorus().getGrams()));
            }
            if (nutritionRecord.getPolyunsaturatedFat() != null) {
                dataType27.putValues("polyunsaturatedFat", ValueExtKt.doubleVal(nutritionRecord.getPolyunsaturatedFat().getGrams()));
            }
            if (nutritionRecord.getPotassium() != null) {
                dataType27.putValues("potassium", ValueExtKt.doubleVal(nutritionRecord.getPotassium().getGrams()));
            }
            if (nutritionRecord.getProtein() != null) {
                dataType27.putValues("protein", ValueExtKt.doubleVal(nutritionRecord.getProtein().getGrams()));
            }
            if (nutritionRecord.getRiboflavin() != null) {
                dataType27.putValues("riboflavin", ValueExtKt.doubleVal(nutritionRecord.getRiboflavin().getGrams()));
            }
            if (nutritionRecord.getSaturatedFat() != null) {
                dataType27.putValues("saturatedFat", ValueExtKt.doubleVal(nutritionRecord.getSaturatedFat().getGrams()));
            }
            if (nutritionRecord.getSelenium() != null) {
                dataType27.putValues("selenium", ValueExtKt.doubleVal(nutritionRecord.getSelenium().getGrams()));
            }
            if (nutritionRecord.getSodium() != null) {
                dataType27.putValues("sodium", ValueExtKt.doubleVal(nutritionRecord.getSodium().getGrams()));
            }
            if (nutritionRecord.getSugar() != null) {
                dataType27.putValues("sugar", ValueExtKt.doubleVal(nutritionRecord.getSugar().getGrams()));
            }
            if (nutritionRecord.getThiamin() != null) {
                dataType27.putValues("thiamin", ValueExtKt.doubleVal(nutritionRecord.getThiamin().getGrams()));
            }
            if (nutritionRecord.getTotalCarbohydrate() != null) {
                dataType27.putValues("totalCarbohydrate", ValueExtKt.doubleVal(nutritionRecord.getTotalCarbohydrate().getGrams()));
            }
            if (nutritionRecord.getTotalFat() != null) {
                dataType27.putValues("totalFat", ValueExtKt.doubleVal(nutritionRecord.getTotalFat().getGrams()));
            }
            if (nutritionRecord.getTransFat() != null) {
                dataType27.putValues("transFat", ValueExtKt.doubleVal(nutritionRecord.getTransFat().getGrams()));
            }
            if (nutritionRecord.getUnsaturatedFat() != null) {
                dataType27.putValues("unsaturatedFat", ValueExtKt.doubleVal(nutritionRecord.getUnsaturatedFat().getGrams()));
            }
            if (nutritionRecord.getVitaminA() != null) {
                dataType27.putValues("vitaminA", ValueExtKt.doubleVal(nutritionRecord.getVitaminA().getGrams()));
            }
            if (nutritionRecord.getVitaminB12() != null) {
                dataType27.putValues("vitaminB12", ValueExtKt.doubleVal(nutritionRecord.getVitaminB12().getGrams()));
            }
            if (nutritionRecord.getVitaminB6() != null) {
                dataType27.putValues("vitaminB6", ValueExtKt.doubleVal(nutritionRecord.getVitaminB6().getGrams()));
            }
            if (nutritionRecord.getVitaminC() != null) {
                dataType27.putValues("vitaminC", ValueExtKt.doubleVal(nutritionRecord.getVitaminC().getGrams()));
            }
            if (nutritionRecord.getVitaminD() != null) {
                dataType27.putValues("vitaminD", ValueExtKt.doubleVal(nutritionRecord.getVitaminD().getGrams()));
            }
            if (nutritionRecord.getVitaminE() != null) {
                dataType27.putValues("vitaminE", ValueExtKt.doubleVal(nutritionRecord.getVitaminE().getGrams()));
            }
            if (nutritionRecord.getVitaminK() != null) {
                dataType27.putValues("vitaminK", ValueExtKt.doubleVal(nutritionRecord.getVitaminK().getGrams()));
            }
            if (nutritionRecord.getZinc() != null) {
                dataType27.putValues("zinc", ValueExtKt.doubleVal(nutritionRecord.getZinc().getGrams()));
            }
            DataProto.Value valueEnumValFromInt15 = ValueExtKt.enumValFromInt(nutritionRecord.getMealType(), MealType.MEAL_TYPE_INT_TO_STRING_MAP);
            if (valueEnumValFromInt15 != null) {
                dataType27.putValues("mealType", valueEnumValFromInt15);
            }
            String name = nutritionRecord.getName();
            if (name != null) {
                dataType27.putValues("name", ValueExtKt.stringVal(name));
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild29 = dataType27.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild29, "intervalProto()\n        …\n                .build()");
            return dataPointBuild29;
        }
        if (record instanceof SleepSessionRecord) {
            DataProto.DataPoint.Builder dataType28 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("SleepSession"));
            SleepSessionRecord sleepSessionRecord = (SleepSessionRecord) record;
            if (!sleepSessionRecord.getStages().isEmpty()) {
                DataProto.DataPoint.SubTypeDataList.Builder builderNewBuilder4 = DataProto.DataPoint.SubTypeDataList.newBuilder();
                List<SleepSessionRecord.Stage> stages = sleepSessionRecord.getStages();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(stages, 10));
                Iterator<T> it4 = stages.iterator();
                while (it4.hasNext()) {
                    arrayList4.add(RecordToProtoUtilsKt.toProto((SleepSessionRecord.Stage) it4.next()));
                }
                dataType28.putSubTypeDataLists("stages", builderNewBuilder4.addAllValues(arrayList4).build());
            }
            String title2 = sleepSessionRecord.getTitle();
            if (title2 != null) {
                dataType28.putValues("title", ValueExtKt.stringVal(title2));
            }
            String notes2 = sleepSessionRecord.getNotes();
            if (notes2 != null) {
                dataType28.putValues("notes", ValueExtKt.stringVal(notes2));
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
            DataProto.DataPoint dataPointBuild30 = dataType28.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild30, "intervalProto()\n        …\n                .build()");
            return dataPointBuild30;
        }
        if (record instanceof StepsRecord) {
            DataProto.DataPoint.Builder dataType29 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("Steps"));
            dataType29.putValues("count", ValueExtKt.longVal(((StepsRecord) record).getCount()));
            DataProto.DataPoint dataPointBuild31 = dataType29.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild31, "intervalProto()\n        …\n                .build()");
            return dataPointBuild31;
        }
        if (record instanceof TotalCaloriesBurnedRecord) {
            DataProto.DataPoint.Builder dataType30 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("TotalCaloriesBurned"));
            dataType30.putValues("energy", ValueExtKt.doubleVal(((TotalCaloriesBurnedRecord) record).getEnergy().getKilocalories()));
            DataProto.DataPoint dataPointBuild32 = dataType30.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild32, "intervalProto()\n        …\n                .build()");
            return dataPointBuild32;
        }
        if (record instanceof WheelchairPushesRecord) {
            DataProto.DataPoint.Builder dataType31 = RecordToProtoUtilsKt.intervalProto((IntervalRecord) record).setDataType(RecordToProtoUtilsKt.protoDataType("WheelchairPushes"));
            dataType31.putValues("count", ValueExtKt.longVal(((WheelchairPushesRecord) record).getCount()));
            DataProto.DataPoint dataPointBuild33 = dataType31.build();
            Intrinsics.checkNotNullExpressionValue(dataPointBuild33, "intervalProto()\n        …\n                .build()");
            return dataPointBuild33;
        }
        throw new RuntimeException("Unsupported yet!");
    }

    private static final <T> DataProto.DataPoint toProto(SeriesRecord<? extends T> seriesRecord, String str, Function1<? super T, DataProto.SeriesValue> function1) {
        DataProto.DataPoint.Builder dataType = RecordToProtoUtilsKt.intervalProto(seriesRecord).setDataType(RecordToProtoUtilsKt.protoDataType(str));
        Iterator<? extends T> it = seriesRecord.getSamples().iterator();
        while (it.hasNext()) {
            dataType.addSeriesValues(function1.invoke(it.next()));
        }
        DataProto.DataPoint dataPointBuild = dataType.build();
        Intrinsics.checkNotNullExpressionValue(dataPointBuild, "intervalProto()\n        …       }\n        .build()");
        return dataPointBuild;
    }
}
