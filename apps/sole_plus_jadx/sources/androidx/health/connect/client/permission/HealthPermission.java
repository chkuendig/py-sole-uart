package androidx.health.connect.client.permission;

import androidx.health.connect.client.records.ActiveCaloriesBurnedRecord;
import androidx.health.connect.client.records.BasalBodyTemperatureRecord;
import androidx.health.connect.client.records.BasalMetabolicRateRecord;
import androidx.health.connect.client.records.BloodGlucoseRecord;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.BodyFatRecord;
import androidx.health.connect.client.records.BodyTemperatureRecord;
import androidx.health.connect.client.records.BodyWaterMassRecord;
import androidx.health.connect.client.records.BoneMassRecord;
import androidx.health.connect.client.records.CervicalMucusRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ElevationGainedRecord;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.FloorsClimbedRecord;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.HeartRateVariabilityRmssdRecord;
import androidx.health.connect.client.records.HeightRecord;
import androidx.health.connect.client.records.HydrationRecord;
import androidx.health.connect.client.records.IntermenstrualBleedingRecord;
import androidx.health.connect.client.records.LeanBodyMassRecord;
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
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.records.WeightRecord;
import androidx.health.connect.client.records.WheelchairPushesRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: HealthPermission.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/health/connect/client/permission/HealthPermission;", "", "recordType", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "accessType", "", "(Lkotlin/reflect/KClass;I)V", "getAccessType$connect_client_release$annotations", "()V", "getAccessType$connect_client_release", "()I", "getRecordType$connect_client_release", "()Lkotlin/reflect/KClass;", "equals", "", "other", "hashCode", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HealthPermission {
    public static final List<String> ALL_PERMISSIONS;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PERMISSION_PREFIX = "android.permission.health.";
    public static final String PERMISSION_READ_HEALTH_DATA_IN_BACKGROUND = "android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND";
    public static final String PERMISSION_WRITE_EXERCISE_ROUTE = "android.permission.health.WRITE_EXERCISE_ROUTE";
    public static final String READ_ACTIVE_CALORIES_BURNED = "android.permission.health.READ_ACTIVE_CALORIES_BURNED";
    public static final String READ_BASAL_BODY_TEMPERATURE = "android.permission.health.READ_BASAL_BODY_TEMPERATURE";
    public static final String READ_BASAL_METABOLIC_RATE = "android.permission.health.READ_BASAL_METABOLIC_RATE";
    public static final String READ_BLOOD_GLUCOSE = "android.permission.health.READ_BLOOD_GLUCOSE";
    public static final String READ_BLOOD_PRESSURE = "android.permission.health.READ_BLOOD_PRESSURE";
    public static final String READ_BODY_FAT = "android.permission.health.READ_BODY_FAT";
    public static final String READ_BODY_TEMPERATURE = "android.permission.health.READ_BODY_TEMPERATURE";
    public static final String READ_BODY_WATER_MASS = "android.permission.health.READ_BODY_WATER_MASS";
    public static final String READ_BONE_MASS = "android.permission.health.READ_BONE_MASS";
    public static final String READ_CERVICAL_MUCUS = "android.permission.health.READ_CERVICAL_MUCUS";
    public static final String READ_DISTANCE = "android.permission.health.READ_DISTANCE";
    public static final String READ_ELEVATION_GAINED = "android.permission.health.READ_ELEVATION_GAINED";
    public static final String READ_EXERCISE = "android.permission.health.READ_EXERCISE";
    public static final String READ_FLOORS_CLIMBED = "android.permission.health.READ_FLOORS_CLIMBED";
    public static final String READ_HEART_RATE = "android.permission.health.READ_HEART_RATE";
    public static final String READ_HEART_RATE_VARIABILITY = "android.permission.health.READ_HEART_RATE_VARIABILITY";
    public static final String READ_HEIGHT = "android.permission.health.READ_HEIGHT";
    public static final String READ_HYDRATION = "android.permission.health.READ_HYDRATION";
    public static final String READ_INTERMENSTRUAL_BLEEDING = "android.permission.health.READ_INTERMENSTRUAL_BLEEDING";
    public static final String READ_LEAN_BODY_MASS = "android.permission.health.READ_LEAN_BODY_MASS";
    public static final String READ_MENSTRUATION = "android.permission.health.READ_MENSTRUATION";
    public static final String READ_NUTRITION = "android.permission.health.READ_NUTRITION";
    public static final String READ_OVULATION_TEST = "android.permission.health.READ_OVULATION_TEST";
    public static final String READ_OXYGEN_SATURATION = "android.permission.health.READ_OXYGEN_SATURATION";
    public static final String READ_PERMISSION_PREFIX = "android.permission.health.READ_";
    public static final String READ_POWER = "android.permission.health.READ_POWER";
    public static final String READ_RESPIRATORY_RATE = "android.permission.health.READ_RESPIRATORY_RATE";
    public static final String READ_RESTING_HEART_RATE = "android.permission.health.READ_RESTING_HEART_RATE";
    public static final String READ_SEXUAL_ACTIVITY = "android.permission.health.READ_SEXUAL_ACTIVITY";
    public static final String READ_SKIN_TEMPERATURE = "android.permission.health.READ_SKIN_TEMPERATURE";
    public static final String READ_SLEEP = "android.permission.health.READ_SLEEP";
    public static final String READ_SPEED = "android.permission.health.READ_SPEED";
    public static final String READ_STEPS = "android.permission.health.READ_STEPS";
    public static final String READ_TOTAL_CALORIES_BURNED = "android.permission.health.READ_TOTAL_CALORIES_BURNED";
    public static final String READ_VO2_MAX = "android.permission.health.READ_VO2_MAX";
    public static final String READ_WEIGHT = "android.permission.health.READ_WEIGHT";
    public static final String READ_WHEELCHAIR_PUSHES = "android.permission.health.READ_WHEELCHAIR_PUSHES";
    private static final Map<KClass<? extends Record>, String> RECORD_TYPE_TO_PERMISSION;
    public static final String WRITE_ACTIVE_CALORIES_BURNED = "android.permission.health.WRITE_ACTIVE_CALORIES_BURNED";
    public static final String WRITE_BASAL_BODY_TEMPERATURE = "android.permission.health.WRITE_BASAL_BODY_TEMPERATURE";
    public static final String WRITE_BASAL_METABOLIC_RATE = "android.permission.health.WRITE_BASAL_METABOLIC_RATE";
    public static final String WRITE_BLOOD_GLUCOSE = "android.permission.health.WRITE_BLOOD_GLUCOSE";
    public static final String WRITE_BLOOD_PRESSURE = "android.permission.health.WRITE_BLOOD_PRESSURE";
    public static final String WRITE_BODY_FAT = "android.permission.health.WRITE_BODY_FAT";
    public static final String WRITE_BODY_TEMPERATURE = "android.permission.health.WRITE_BODY_TEMPERATURE";
    public static final String WRITE_BODY_WATER_MASS = "android.permission.health.WRITE_BODY_WATER_MASS";
    public static final String WRITE_BONE_MASS = "android.permission.health.WRITE_BONE_MASS";
    public static final String WRITE_CERVICAL_MUCUS = "android.permission.health.WRITE_CERVICAL_MUCUS";
    public static final String WRITE_DISTANCE = "android.permission.health.WRITE_DISTANCE";
    public static final String WRITE_ELEVATION_GAINED = "android.permission.health.WRITE_ELEVATION_GAINED";
    public static final String WRITE_EXERCISE = "android.permission.health.WRITE_EXERCISE";
    public static final String WRITE_FLOORS_CLIMBED = "android.permission.health.WRITE_FLOORS_CLIMBED";
    public static final String WRITE_HEART_RATE = "android.permission.health.WRITE_HEART_RATE";
    public static final String WRITE_HEART_RATE_VARIABILITY = "android.permission.health.WRITE_HEART_RATE_VARIABILITY";
    public static final String WRITE_HEIGHT = "android.permission.health.WRITE_HEIGHT";
    public static final String WRITE_HYDRATION = "android.permission.health.WRITE_HYDRATION";
    public static final String WRITE_INTERMENSTRUAL_BLEEDING = "android.permission.health.WRITE_INTERMENSTRUAL_BLEEDING";
    public static final String WRITE_LEAN_BODY_MASS = "android.permission.health.WRITE_LEAN_BODY_MASS";
    public static final String WRITE_MENSTRUATION = "android.permission.health.WRITE_MENSTRUATION";
    public static final String WRITE_NUTRITION = "android.permission.health.WRITE_NUTRITION";
    public static final String WRITE_OVULATION_TEST = "android.permission.health.WRITE_OVULATION_TEST";
    public static final String WRITE_OXYGEN_SATURATION = "android.permission.health.WRITE_OXYGEN_SATURATION";
    public static final String WRITE_PERMISSION_PREFIX = "android.permission.health.WRITE_";
    public static final String WRITE_POWER = "android.permission.health.WRITE_POWER";
    public static final String WRITE_RESPIRATORY_RATE = "android.permission.health.WRITE_RESPIRATORY_RATE";
    public static final String WRITE_RESTING_HEART_RATE = "android.permission.health.WRITE_RESTING_HEART_RATE";
    public static final String WRITE_SEXUAL_ACTIVITY = "android.permission.health.WRITE_SEXUAL_ACTIVITY";
    public static final String WRITE_SKIN_TEMPERATURE = "android.permission.health.WRITE_SKIN_TEMPERATURE";
    public static final String WRITE_SLEEP = "android.permission.health.WRITE_SLEEP";
    public static final String WRITE_SPEED = "android.permission.health.WRITE_SPEED";
    public static final String WRITE_STEPS = "android.permission.health.WRITE_STEPS";
    public static final String WRITE_TOTAL_CALORIES_BURNED = "android.permission.health.WRITE_TOTAL_CALORIES_BURNED";
    public static final String WRITE_VO2_MAX = "android.permission.health.WRITE_VO2_MAX";
    public static final String WRITE_WEIGHT = "android.permission.health.WRITE_WEIGHT";
    public static final String WRITE_WHEELCHAIR_PUSHES = "android.permission.health.WRITE_WHEELCHAIR_PUSHES";
    private final int accessType;
    private final KClass<? extends Record> recordType;

    @JvmStatic
    public static final HealthPermission createReadPermissionLegacy(KClass<? extends Record> kClass) {
        return INSTANCE.createReadPermissionLegacy(kClass);
    }

    @JvmStatic
    public static final HealthPermission createWritePermissionLegacy(KClass<? extends Record> kClass) {
        return INSTANCE.createWritePermissionLegacy(kClass);
    }

    public static /* synthetic */ void getAccessType$connect_client_release$annotations() {
    }

    @JvmStatic
    public static final String getReadPermission(KClass<? extends Record> kClass) {
        return INSTANCE.getReadPermission(kClass);
    }

    @JvmStatic
    public static final String getWritePermission(KClass<? extends Record> kClass) {
        return INSTANCE.getWritePermission(kClass);
    }

    public HealthPermission(KClass<? extends Record> recordType, int i) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        this.recordType = recordType;
        this.accessType = i;
    }

    public final KClass<? extends Record> getRecordType$connect_client_release() {
        return this.recordType;
    }

    /* renamed from: getAccessType$connect_client_release, reason: from getter */
    public final int getAccessType() {
        return this.accessType;
    }

    /* compiled from: HealthPermission.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010Y\u001a\u00020Z2\u000e\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020100H\u0007J\u0018\u0010\\\u001a\u00020Z2\u000e\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020100H\u0007J\u0018\u0010]\u001a\u00020\u00052\u000e\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020100H\u0007J\u0018\u0010^\u001a\u00020\u00052\u000e\u0010[\u001a\n\u0012\u0006\b\u0001\u0012\u00020100H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00058\u0000X\u0081T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020\u00058\u0000X\u0081T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R(\u0010.\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020100\u0012\u0004\u0012\u00020\u00050/X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\u00058\u0000X\u0081T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u00020\u00058\u0000X\u0081T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Landroidx/health/connect/client/permission/HealthPermission$Companion;", "", "()V", "ALL_PERMISSIONS", "", "", "PERMISSION_PREFIX", "PERMISSION_READ_HEALTH_DATA_IN_BACKGROUND", "PERMISSION_WRITE_EXERCISE_ROUTE", "READ_ACTIVE_CALORIES_BURNED", "READ_BASAL_BODY_TEMPERATURE", "READ_BASAL_METABOLIC_RATE", "READ_BLOOD_GLUCOSE", "READ_BLOOD_PRESSURE", "READ_BODY_FAT", "READ_BODY_TEMPERATURE", "READ_BODY_WATER_MASS", "READ_BONE_MASS", "READ_CERVICAL_MUCUS", "READ_DISTANCE", "READ_ELEVATION_GAINED", "READ_EXERCISE", "READ_FLOORS_CLIMBED", "READ_HEART_RATE", "READ_HEART_RATE_VARIABILITY", "READ_HEIGHT", "READ_HYDRATION", "READ_INTERMENSTRUAL_BLEEDING", "READ_LEAN_BODY_MASS", "READ_MENSTRUATION", "READ_NUTRITION", "READ_OVULATION_TEST", "READ_OXYGEN_SATURATION", "READ_PERMISSION_PREFIX", "READ_POWER", "READ_RESPIRATORY_RATE", "READ_RESTING_HEART_RATE", "READ_SEXUAL_ACTIVITY", "READ_SKIN_TEMPERATURE", "READ_SLEEP", "READ_SPEED", "READ_STEPS", "READ_TOTAL_CALORIES_BURNED", "READ_VO2_MAX", "READ_WEIGHT", "READ_WHEELCHAIR_PUSHES", "RECORD_TYPE_TO_PERMISSION", "", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "getRECORD_TYPE_TO_PERMISSION$connect_client_release", "()Ljava/util/Map;", "WRITE_ACTIVE_CALORIES_BURNED", "WRITE_BASAL_BODY_TEMPERATURE", "WRITE_BASAL_METABOLIC_RATE", "WRITE_BLOOD_GLUCOSE", "WRITE_BLOOD_PRESSURE", "WRITE_BODY_FAT", "WRITE_BODY_TEMPERATURE", "WRITE_BODY_WATER_MASS", "WRITE_BONE_MASS", "WRITE_CERVICAL_MUCUS", "WRITE_DISTANCE", "WRITE_ELEVATION_GAINED", "WRITE_EXERCISE", "WRITE_FLOORS_CLIMBED", "WRITE_HEART_RATE", "WRITE_HEART_RATE_VARIABILITY", "WRITE_HEIGHT", "WRITE_HYDRATION", "WRITE_INTERMENSTRUAL_BLEEDING", "WRITE_LEAN_BODY_MASS", "WRITE_MENSTRUATION", "WRITE_NUTRITION", "WRITE_OVULATION_TEST", "WRITE_OXYGEN_SATURATION", "WRITE_PERMISSION_PREFIX", "WRITE_POWER", "WRITE_RESPIRATORY_RATE", "WRITE_RESTING_HEART_RATE", "WRITE_SEXUAL_ACTIVITY", "WRITE_SKIN_TEMPERATURE", "WRITE_SLEEP", "WRITE_SPEED", "WRITE_STEPS", "WRITE_TOTAL_CALORIES_BURNED", "WRITE_VO2_MAX", "WRITE_WEIGHT", "WRITE_WHEELCHAIR_PUSHES", "createReadPermissionLegacy", "Landroidx/health/connect/client/permission/HealthPermission;", "recordType", "createWritePermissionLegacy", "getReadPermission", "getWritePermission", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HealthPermission createReadPermissionLegacy(KClass<? extends Record> recordType) {
            Intrinsics.checkNotNullParameter(recordType, "recordType");
            return new HealthPermission(recordType, 1);
        }

        @JvmStatic
        public final String getReadPermission(KClass<? extends Record> recordType) {
            Intrinsics.checkNotNullParameter(recordType, "recordType");
            if (getRECORD_TYPE_TO_PERMISSION$connect_client_release().get(recordType) == null) {
                throw new IllegalArgumentException("Given recordType is not valid : " + recordType + ".simpleName");
            }
            return HealthPermission.READ_PERMISSION_PREFIX + getRECORD_TYPE_TO_PERMISSION$connect_client_release().get(recordType);
        }

        @JvmStatic
        public final HealthPermission createWritePermissionLegacy(KClass<? extends Record> recordType) {
            Intrinsics.checkNotNullParameter(recordType, "recordType");
            return new HealthPermission(recordType, 2);
        }

        @JvmStatic
        public final String getWritePermission(KClass<? extends Record> recordType) {
            Intrinsics.checkNotNullParameter(recordType, "recordType");
            if (getRECORD_TYPE_TO_PERMISSION$connect_client_release().get(recordType) == null) {
                throw new IllegalArgumentException("Given recordType is not valid : " + recordType + ".simpleName");
            }
            return HealthPermission.WRITE_PERMISSION_PREFIX + getRECORD_TYPE_TO_PERMISSION$connect_client_release().getOrDefault(recordType, "");
        }

        public final Map<KClass<? extends Record>, String> getRECORD_TYPE_TO_PERMISSION$connect_client_release() {
            return HealthPermission.RECORD_TYPE_TO_PERMISSION;
        }
    }

    static {
        Map<KClass<? extends Record>, String> mapMapOf = MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(ActiveCaloriesBurnedRecord.class), StringsKt.substringAfter$default(READ_ACTIVE_CALORIES_BURNED, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BasalBodyTemperatureRecord.class), StringsKt.substringAfter$default(READ_BASAL_BODY_TEMPERATURE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BasalMetabolicRateRecord.class), StringsKt.substringAfter$default(READ_BASAL_METABOLIC_RATE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BloodGlucoseRecord.class), StringsKt.substringAfter$default(READ_BLOOD_GLUCOSE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), StringsKt.substringAfter$default(READ_BLOOD_PRESSURE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BodyFatRecord.class), StringsKt.substringAfter$default(READ_BODY_FAT, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BodyTemperatureRecord.class), StringsKt.substringAfter$default(READ_BODY_TEMPERATURE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BodyWaterMassRecord.class), StringsKt.substringAfter$default(READ_BODY_WATER_MASS, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(BoneMassRecord.class), StringsKt.substringAfter$default(READ_BONE_MASS, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(CervicalMucusRecord.class), StringsKt.substringAfter$default(READ_CERVICAL_MUCUS, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), StringsKt.substringAfter$default(READ_EXERCISE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(DistanceRecord.class), StringsKt.substringAfter$default(READ_DISTANCE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(ElevationGainedRecord.class), StringsKt.substringAfter$default(READ_ELEVATION_GAINED, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(ExerciseSessionRecord.class), StringsKt.substringAfter$default(READ_EXERCISE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(FloorsClimbedRecord.class), StringsKt.substringAfter$default(READ_FLOORS_CLIMBED, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HeartRateRecord.class), StringsKt.substringAfter$default(READ_HEART_RATE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HeartRateVariabilityRmssdRecord.class), StringsKt.substringAfter$default(READ_HEART_RATE_VARIABILITY, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HeightRecord.class), StringsKt.substringAfter$default(READ_HEIGHT, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(HydrationRecord.class), StringsKt.substringAfter$default(READ_HYDRATION, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(IntermenstrualBleedingRecord.class), StringsKt.substringAfter$default(READ_INTERMENSTRUAL_BLEEDING, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(LeanBodyMassRecord.class), StringsKt.substringAfter$default(READ_LEAN_BODY_MASS, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(MenstruationFlowRecord.class), StringsKt.substringAfter$default(READ_MENSTRUATION, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(MenstruationPeriodRecord.class), StringsKt.substringAfter$default(READ_MENSTRUATION, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(NutritionRecord.class), StringsKt.substringAfter$default(READ_NUTRITION, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(OvulationTestRecord.class), StringsKt.substringAfter$default(READ_OVULATION_TEST, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(OxygenSaturationRecord.class), StringsKt.substringAfter$default(READ_OXYGEN_SATURATION, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(PowerRecord.class), StringsKt.substringAfter$default(READ_POWER, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(RespiratoryRateRecord.class), StringsKt.substringAfter$default(READ_RESPIRATORY_RATE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(RestingHeartRateRecord.class), StringsKt.substringAfter$default(READ_RESTING_HEART_RATE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(SexualActivityRecord.class), StringsKt.substringAfter$default(READ_SEXUAL_ACTIVITY, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(SleepSessionRecord.class), StringsKt.substringAfter$default(READ_SLEEP, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(SpeedRecord.class), StringsKt.substringAfter$default(READ_SPEED, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(SkinTemperatureRecord.class), StringsKt.substringAfter$default(READ_SKIN_TEMPERATURE, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), StringsKt.substringAfter$default(READ_STEPS, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(StepsRecord.class), StringsKt.substringAfter$default(READ_STEPS, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(TotalCaloriesBurnedRecord.class), StringsKt.substringAfter$default(READ_TOTAL_CALORIES_BURNED, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Vo2MaxRecord.class), StringsKt.substringAfter$default(READ_VO2_MAX, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(WeightRecord.class), StringsKt.substringAfter$default(READ_WEIGHT, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)), TuplesKt.to(Reflection.getOrCreateKotlinClass(WheelchairPushesRecord.class), StringsKt.substringAfter$default(READ_WHEELCHAIR_PUSHES, READ_PERMISSION_PREFIX, (String) null, 2, (Object) null)));
        RECORD_TYPE_TO_PERMISSION = mapMapOf;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<KClass<? extends Record>, String> entry : mapMapOf.entrySet()) {
            CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new String[]{WRITE_PERMISSION_PREFIX + entry.getValue(), READ_PERMISSION_PREFIX + entry.getValue()}));
        }
        listCreateListBuilder.addAll(arrayList);
        listCreateListBuilder.add(PERMISSION_WRITE_EXERCISE_ROUTE);
        listCreateListBuilder.add(PERMISSION_READ_HEALTH_DATA_IN_BACKGROUND);
        ALL_PERMISSIONS = CollectionsKt.build(listCreateListBuilder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthPermission)) {
            return false;
        }
        HealthPermission healthPermission = (HealthPermission) other;
        return Intrinsics.areEqual(this.recordType, healthPermission.recordType) && this.accessType == healthPermission.accessType;
    }

    public int hashCode() {
        return (this.recordType.hashCode() * 31) + this.accessType;
    }
}
