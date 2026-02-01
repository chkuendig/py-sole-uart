package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.ActiveCaloriesBurnedRecord;
import android.health.connect.datatypes.BasalBodyTemperatureRecord;
import android.health.connect.datatypes.BasalMetabolicRateRecord;
import android.health.connect.datatypes.BloodGlucoseRecord;
import android.health.connect.datatypes.BloodPressureRecord;
import android.health.connect.datatypes.BodyFatRecord;
import android.health.connect.datatypes.BodyTemperatureRecord;
import android.health.connect.datatypes.BodyWaterMassRecord;
import android.health.connect.datatypes.BoneMassRecord;
import android.health.connect.datatypes.CervicalMucusRecord;
import android.health.connect.datatypes.CyclingPedalingCadenceRecord;
import android.health.connect.datatypes.DistanceRecord;
import android.health.connect.datatypes.ElevationGainedRecord;
import android.health.connect.datatypes.ExerciseLap;
import android.health.connect.datatypes.ExerciseRoute;
import android.health.connect.datatypes.ExerciseSegment;
import android.health.connect.datatypes.ExerciseSessionRecord;
import android.health.connect.datatypes.FloorsClimbedRecord;
import android.health.connect.datatypes.HeartRateRecord;
import android.health.connect.datatypes.HeartRateVariabilityRmssdRecord;
import android.health.connect.datatypes.HeightRecord;
import android.health.connect.datatypes.HydrationRecord;
import android.health.connect.datatypes.IntermenstrualBleedingRecord;
import android.health.connect.datatypes.LeanBodyMassRecord;
import android.health.connect.datatypes.MenstruationFlowRecord;
import android.health.connect.datatypes.MenstruationPeriodRecord;
import android.health.connect.datatypes.NutritionRecord;
import android.health.connect.datatypes.OvulationTestRecord;
import android.health.connect.datatypes.OxygenSaturationRecord;
import android.health.connect.datatypes.PowerRecord;
import android.health.connect.datatypes.Record;
import android.health.connect.datatypes.RespiratoryRateRecord;
import android.health.connect.datatypes.RestingHeartRateRecord;
import android.health.connect.datatypes.SexualActivityRecord;
import android.health.connect.datatypes.SleepSessionRecord;
import android.health.connect.datatypes.SpeedRecord;
import android.health.connect.datatypes.StepsCadenceRecord;
import android.health.connect.datatypes.StepsRecord;
import android.health.connect.datatypes.TotalCaloriesBurnedRecord;
import android.health.connect.datatypes.Vo2MaxRecord;
import android.health.connect.datatypes.WeightRecord;
import android.health.connect.datatypes.WheelchairPushesRecord;
import android.health.connect.datatypes.units.BloodGlucose;
import android.health.connect.datatypes.units.Energy;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Mass;
import android.health.connect.datatypes.units.Percentage;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Temperature;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
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
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
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
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: RecordConverters.kt */
@Metadata(d1 = {"\u0000\u008a\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0002\u001a\u0010\u0010!\u001a\u00060\"j\u0002`#*\u00020$H\u0002\u001a\f\u0010%\u001a\u00020&*\u00020'H\u0002\u001a\f\u0010(\u001a\u00020)*\u00020*H\u0002\u001a\f\u0010+\u001a\u00020,*\u00020-H\u0002\u001a\u0010\u0010.\u001a\u00060/j\u0002`0*\u000201H\u0002\u001a\f\u00102\u001a\u000203*\u000204H\u0002\u001a\f\u00105\u001a\u000206*\u000207H\u0002\u001a\f\u00108\u001a\u000209*\u00020:H\u0002\u001a\f\u0010;\u001a\u00020<*\u00020=H\u0002\u001a\u0010\u0010>\u001a\u00060?j\u0002`@*\u00020AH\u0002\u001a\f\u0010B\u001a\u00020C*\u00020DH\u0002\u001a\f\u0010E\u001a\u00020F*\u00020GH\u0002\u001a\f\u0010H\u001a\u00020I*\u00020JH\u0002\u001a\f\u0010K\u001a\u00020L*\u00020MH\u0002\u001a\f\u0010N\u001a\u00020O*\u00020PH\u0002\u001a\f\u0010Q\u001a\u00020R*\u00020SH\u0002\u001a\f\u0010T\u001a\u00020U*\u00020VH\u0002\u001a\f\u0010W\u001a\u00020X*\u00020YH\u0002\u001a\f\u0010Z\u001a\u00020[*\u00020\\H\u0002\u001a\f\u0010]\u001a\u00020^*\u00020_H\u0002\u001a\f\u0010`\u001a\u00020a*\u00020bH\u0002\u001a\u0010\u0010c\u001a\u00060dj\u0002`e*\u00020fH\u0002\u001a\u000e\u0010g\u001a\u00060hj\u0002`i*\u00020j\u001a\u001e\u0010k\u001a\u000e\u0012\n\b\u0001\u0012\u00060hj\u0002`i0l*\n\u0012\u0006\b\u0001\u0012\u00020j0m\u001a\f\u0010n\u001a\u00020o*\u00020pH\u0002\u001a\f\u0010q\u001a\u00020r*\u00020sH\u0002\u001a\f\u0010t\u001a\u00020u*\u00020vH\u0002\u001a\f\u0010w\u001a\u00020x*\u00020yH\u0002\u001a\u0010\u0010z\u001a\u00060{j\u0002`|*\u00020}H\u0002\u001a\r\u0010~\u001a\u00020\u007f*\u00030\u0080\u0001H\u0002\u001a\u0014\u0010\u0081\u0001\u001a\b0\u0082\u0001j\u0003`\u0083\u0001*\u00030\u0084\u0001H\u0002\u001a\u000f\u0010\u0085\u0001\u001a\u00030\u0086\u0001*\u00030\u0087\u0001H\u0002\u001a\u0014\u0010\u0088\u0001\u001a\b0\u0089\u0001j\u0003`\u008a\u0001*\u00030\u008b\u0001H\u0002\u001a\u000f\u0010\u008c\u0001\u001a\u00030\u008d\u0001*\u00030\u008e\u0001H\u0002\u001a\u000f\u0010\u008f\u0001\u001a\u00030\u0090\u0001*\u00030\u0091\u0001H\u0002\u001a\u000f\u0010\u0092\u0001\u001a\u00030\u0093\u0001*\u00030\u0094\u0001H\u0002\u001a\u000f\u0010\u0095\u0001\u001a\u00030\u0096\u0001*\u00030\u0097\u0001H\u0002\u001a\u000f\u0010\u0098\u0001\u001a\u00030\u0099\u0001*\u00030\u009a\u0001H\u0002\u001a\u0012\u0010\u009b\u0001\u001a\u00020\u0002*\u00070\u0001j\u0003`\u009c\u0001H\u0002\u001a\u0012\u0010\u009d\u0001\u001a\u00020\u0005*\u00070\u0004j\u0003`\u009e\u0001H\u0002\u001a\u0012\u0010\u009f\u0001\u001a\u00020\b*\u00070\u0007j\u0003` \u0001H\u0002\u001a\u0012\u0010¡\u0001\u001a\u00020\u000b*\u00070\nj\u0003`¢\u0001H\u0002\u001a\u0012\u0010£\u0001\u001a\u00020\u000e*\u00070\rj\u0003`¤\u0001H\u0002\u001a\u0012\u0010¥\u0001\u001a\u00020\u0011*\u00070\u0010j\u0003`¦\u0001H\u0002\u001a\u0012\u0010§\u0001\u001a\u00020\u0014*\u00070\u0013j\u0003`¨\u0001H\u0002\u001a\u0012\u0010©\u0001\u001a\u00020\u0017*\u00070\u0016j\u0003`ª\u0001H\u0002\u001a\u0012\u0010«\u0001\u001a\u00020\u001a*\u00070\u0019j\u0003`¬\u0001H\u0002\u001a\u0012\u0010\u00ad\u0001\u001a\u00020\u001d*\u00070\u001cj\u0003`®\u0001H\u0002\u001a\u0012\u0010¯\u0001\u001a\u00020 *\u00070\u001fj\u0003`°\u0001H\u0002\u001a\u0011\u0010±\u0001\u001a\u00020$*\u00060\"j\u0002`#H\u0002\u001a\u0012\u0010²\u0001\u001a\u00020'*\u00070&j\u0003`³\u0001H\u0002\u001a\u0012\u0010´\u0001\u001a\u00020**\u00070)j\u0003`µ\u0001H\u0002\u001a\u0012\u0010¶\u0001\u001a\u00020-*\u00070,j\u0003`·\u0001H\u0000\u001a\u0011\u0010¸\u0001\u001a\u000201*\u00060/j\u0002`0H\u0000\u001a\u0012\u0010¹\u0001\u001a\u000204*\u000703j\u0003`º\u0001H\u0000\u001a\u0012\u0010»\u0001\u001a\u000207*\u000706j\u0003`¼\u0001H\u0002\u001a\u0012\u0010½\u0001\u001a\u00020:*\u000709j\u0003`¾\u0001H\u0002\u001a\u0012\u0010¿\u0001\u001a\u00020=*\u00070<j\u0003`À\u0001H\u0002\u001a\u0011\u0010Á\u0001\u001a\u00020A*\u00060?j\u0002`@H\u0002\u001a\u0012\u0010Â\u0001\u001a\u00020D*\u00070Cj\u0003`Ã\u0001H\u0002\u001a\u0012\u0010Ä\u0001\u001a\u00020G*\u00070Fj\u0003`Å\u0001H\u0002\u001a\u0012\u0010Æ\u0001\u001a\u00020J*\u00070Ij\u0003`Ç\u0001H\u0002\u001a\u0012\u0010È\u0001\u001a\u00020M*\u00070Lj\u0003`É\u0001H\u0002\u001a\u0012\u0010Ê\u0001\u001a\u00020P*\u00070Oj\u0003`Ë\u0001H\u0002\u001a\u0012\u0010Ì\u0001\u001a\u00020S*\u00070Rj\u0003`Í\u0001H\u0002\u001a\u0012\u0010Î\u0001\u001a\u00020V*\u00070Uj\u0003`Ï\u0001H\u0002\u001a\u0012\u0010Ð\u0001\u001a\u00020Y*\u00070Xj\u0003`Ñ\u0001H\u0002\u001a\u0012\u0010Ò\u0001\u001a\u00020\\*\u00070[j\u0003`Ó\u0001H\u0002\u001a\u0012\u0010Ô\u0001\u001a\u00020_*\u00070^j\u0003`Õ\u0001H\u0002\u001a\u0012\u0010Ö\u0001\u001a\u00020b*\u00070aj\u0003`×\u0001H\u0002\u001a\u0011\u0010Ø\u0001\u001a\u00020f*\u00060dj\u0002`eH\u0002\u001a\u000f\u0010Ù\u0001\u001a\u00020j*\u00060hj\u0002`i\u001a\u0012\u0010Ú\u0001\u001a\u00020p*\u00070oj\u0003`Û\u0001H\u0002\u001a\u0012\u0010Ü\u0001\u001a\u00020s*\u00070rj\u0003`Ý\u0001H\u0002\u001a\u0012\u0010Þ\u0001\u001a\u00020v*\u00070uj\u0003`ß\u0001H\u0002\u001a\u0012\u0010à\u0001\u001a\u00020y*\u00070xj\u0003`á\u0001H\u0002\u001a\u0011\u0010â\u0001\u001a\u00020}*\u00060{j\u0002`|H\u0002\u001a\u0013\u0010ã\u0001\u001a\u00030\u0080\u0001*\u00070\u007fj\u0003`ä\u0001H\u0002\u001a\u0014\u0010å\u0001\u001a\u00030\u0084\u0001*\b0\u0082\u0001j\u0003`\u0083\u0001H\u0002\u001a\u0014\u0010æ\u0001\u001a\u00030\u0087\u0001*\b0\u0086\u0001j\u0003`ç\u0001H\u0002\u001a\u0014\u0010è\u0001\u001a\u00030\u008b\u0001*\b0\u0089\u0001j\u0003`\u008a\u0001H\u0002\u001a\u0014\u0010é\u0001\u001a\u00030\u008e\u0001*\b0\u008d\u0001j\u0003`ê\u0001H\u0002\u001a\u0014\u0010ë\u0001\u001a\u00030\u0091\u0001*\b0\u0090\u0001j\u0003`ì\u0001H\u0002\u001a\u0014\u0010í\u0001\u001a\u00030\u0094\u0001*\b0\u0093\u0001j\u0003`î\u0001H\u0002\u001a\u0014\u0010ï\u0001\u001a\u00030\u0097\u0001*\b0\u0096\u0001j\u0003`ð\u0001H\u0002\u001a\u0014\u0010ñ\u0001\u001a\u00030\u009a\u0001*\b0\u0099\u0001j\u0003`ò\u0001H\u0002¨\u0006ó\u0001"}, d2 = {"toPlatformActiveCaloriesBurnedRecord", "Landroid/health/connect/datatypes/ActiveCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/ActiveCaloriesBurnedRecord;", "toPlatformBasalBodyTemperatureRecord", "Landroid/health/connect/datatypes/BasalBodyTemperatureRecord;", "Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;", "toPlatformBasalMetabolicRateRecord", "Landroid/health/connect/datatypes/BasalMetabolicRateRecord;", "Landroidx/health/connect/client/records/BasalMetabolicRateRecord;", "toPlatformBloodGlucoseRecord", "Landroid/health/connect/datatypes/BloodGlucoseRecord;", "Landroidx/health/connect/client/records/BloodGlucoseRecord;", "toPlatformBloodPressureRecord", "Landroid/health/connect/datatypes/BloodPressureRecord;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "toPlatformBodyFatRecord", "Landroid/health/connect/datatypes/BodyFatRecord;", "Landroidx/health/connect/client/records/BodyFatRecord;", "toPlatformBodyTemperatureRecord", "Landroid/health/connect/datatypes/BodyTemperatureRecord;", "Landroidx/health/connect/client/records/BodyTemperatureRecord;", "toPlatformBodyWaterMassRecord", "Landroid/health/connect/datatypes/BodyWaterMassRecord;", "Landroidx/health/connect/client/records/BodyWaterMassRecord;", "toPlatformBoneMassRecord", "Landroid/health/connect/datatypes/BoneMassRecord;", "Landroidx/health/connect/client/records/BoneMassRecord;", "toPlatformCervicalMucusRecord", "Landroid/health/connect/datatypes/CervicalMucusRecord;", "Landroidx/health/connect/client/records/CervicalMucusRecord;", "toPlatformCyclingPedalingCadenceRecord", "Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord;", "Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord;", "toPlatformCyclingPedalingCadenceSample", "Landroid/health/connect/datatypes/CyclingPedalingCadenceRecord$CyclingPedalingCadenceRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformCyclingPedalingCadenceSample;", "Landroidx/health/connect/client/records/CyclingPedalingCadenceRecord$Sample;", "toPlatformDistanceRecord", "Landroid/health/connect/datatypes/DistanceRecord;", "Landroidx/health/connect/client/records/DistanceRecord;", "toPlatformElevationGainedRecord", "Landroid/health/connect/datatypes/ElevationGainedRecord;", "Landroidx/health/connect/client/records/ElevationGainedRecord;", "toPlatformExerciseLap", "Landroid/health/connect/datatypes/ExerciseLap;", "Landroidx/health/connect/client/records/ExerciseLap;", "toPlatformExerciseRoute", "Landroid/health/connect/datatypes/ExerciseRoute;", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseRoute;", "Landroidx/health/connect/client/records/ExerciseRoute;", "toPlatformExerciseSegment", "Landroid/health/connect/datatypes/ExerciseSegment;", "Landroidx/health/connect/client/records/ExerciseSegment;", "toPlatformExerciseSessionRecord", "Landroid/health/connect/datatypes/ExerciseSessionRecord;", "Landroidx/health/connect/client/records/ExerciseSessionRecord;", "toPlatformFloorsClimbedRecord", "Landroid/health/connect/datatypes/FloorsClimbedRecord;", "Landroidx/health/connect/client/records/FloorsClimbedRecord;", "toPlatformHeartRateRecord", "Landroid/health/connect/datatypes/HeartRateRecord;", "Landroidx/health/connect/client/records/HeartRateRecord;", "toPlatformHeartRateSample", "Landroid/health/connect/datatypes/HeartRateRecord$HeartRateSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateSample;", "Landroidx/health/connect/client/records/HeartRateRecord$Sample;", "toPlatformHeartRateVariabilityRmssdRecord", "Landroid/health/connect/datatypes/HeartRateVariabilityRmssdRecord;", "Landroidx/health/connect/client/records/HeartRateVariabilityRmssdRecord;", "toPlatformHeightRecord", "Landroid/health/connect/datatypes/HeightRecord;", "Landroidx/health/connect/client/records/HeightRecord;", "toPlatformHydrationRecord", "Landroid/health/connect/datatypes/HydrationRecord;", "Landroidx/health/connect/client/records/HydrationRecord;", "toPlatformIntermenstrualBleedingRecord", "Landroid/health/connect/datatypes/IntermenstrualBleedingRecord;", "Landroidx/health/connect/client/records/IntermenstrualBleedingRecord;", "toPlatformLeanBodyMassRecord", "Landroid/health/connect/datatypes/LeanBodyMassRecord;", "Landroidx/health/connect/client/records/LeanBodyMassRecord;", "toPlatformMenstruationFlowRecord", "Landroid/health/connect/datatypes/MenstruationFlowRecord;", "Landroidx/health/connect/client/records/MenstruationFlowRecord;", "toPlatformMenstruationPeriodRecord", "Landroid/health/connect/datatypes/MenstruationPeriodRecord;", "Landroidx/health/connect/client/records/MenstruationPeriodRecord;", "toPlatformNutritionRecord", "Landroid/health/connect/datatypes/NutritionRecord;", "Landroidx/health/connect/client/records/NutritionRecord;", "toPlatformOvulationTestRecord", "Landroid/health/connect/datatypes/OvulationTestRecord;", "Landroidx/health/connect/client/records/OvulationTestRecord;", "toPlatformOxygenSaturationRecord", "Landroid/health/connect/datatypes/OxygenSaturationRecord;", "Landroidx/health/connect/client/records/OxygenSaturationRecord;", "toPlatformPowerRecord", "Landroid/health/connect/datatypes/PowerRecord;", "Landroidx/health/connect/client/records/PowerRecord;", "toPlatformPowerRecordSample", "Landroid/health/connect/datatypes/PowerRecord$PowerRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformPowerRecordSample;", "Landroidx/health/connect/client/records/PowerRecord$Sample;", "toPlatformRecord", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/impl/platform/records/PlatformRecord;", "Landroidx/health/connect/client/records/Record;", "toPlatformRecordClass", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "toPlatformRespiratoryRateRecord", "Landroid/health/connect/datatypes/RespiratoryRateRecord;", "Landroidx/health/connect/client/records/RespiratoryRateRecord;", "toPlatformRestingHeartRateRecord", "Landroid/health/connect/datatypes/RestingHeartRateRecord;", "Landroidx/health/connect/client/records/RestingHeartRateRecord;", "toPlatformSexualActivityRecord", "Landroid/health/connect/datatypes/SexualActivityRecord;", "Landroidx/health/connect/client/records/SexualActivityRecord;", "toPlatformSleepSessionRecord", "Landroid/health/connect/datatypes/SleepSessionRecord;", "Landroidx/health/connect/client/records/SleepSessionRecord;", "toPlatformSleepSessionStage", "Landroid/health/connect/datatypes/SleepSessionRecord$Stage;", "Landroidx/health/connect/client/impl/platform/records/PlatformSleepSessionStage;", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "toPlatformSpeedRecord", "Landroid/health/connect/datatypes/SpeedRecord;", "Landroidx/health/connect/client/records/SpeedRecord;", "toPlatformSpeedRecordSample", "Landroid/health/connect/datatypes/SpeedRecord$SpeedRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformSpeedSample;", "Landroidx/health/connect/client/records/SpeedRecord$Sample;", "toPlatformStepsCadenceRecord", "Landroid/health/connect/datatypes/StepsCadenceRecord;", "Landroidx/health/connect/client/records/StepsCadenceRecord;", "toPlatformStepsCadenceSample", "Landroid/health/connect/datatypes/StepsCadenceRecord$StepsCadenceRecordSample;", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsCadenceSample;", "Landroidx/health/connect/client/records/StepsCadenceRecord$Sample;", "toPlatformStepsRecord", "Landroid/health/connect/datatypes/StepsRecord;", "Landroidx/health/connect/client/records/StepsRecord;", "toPlatformTotalCaloriesBurnedRecord", "Landroid/health/connect/datatypes/TotalCaloriesBurnedRecord;", "Landroidx/health/connect/client/records/TotalCaloriesBurnedRecord;", "toPlatformVo2MaxRecord", "Landroid/health/connect/datatypes/Vo2MaxRecord;", "Landroidx/health/connect/client/records/Vo2MaxRecord;", "toPlatformWeightRecord", "Landroid/health/connect/datatypes/WeightRecord;", "Landroidx/health/connect/client/records/WeightRecord;", "toPlatformWheelchairPushesRecord", "Landroid/health/connect/datatypes/WheelchairPushesRecord;", "Landroidx/health/connect/client/records/WheelchairPushesRecord;", "toSdkActiveCaloriesBurnedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformActiveCaloriesBurnedRecord;", "toSdkBasalBodyTemperatureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBasalBodyTemperatureRecord;", "toSdkBasalMetabolicRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBasalMetabolicRateRecord;", "toSdkBloodGlucoseRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodGlucoseRecord;", "toSdkBloodPressureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodPressureRecord;", "toSdkBodyFatRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyFatRecord;", "toSdkBodyTemperatureRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyTemperatureRecord;", "toSdkBodyWaterMassRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBodyWaterMassRecord;", "toSdkBoneMassRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformBoneMassRecord;", "toSdkCervicalMucusRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformCervicalMucusRecord;", "toSdkCyclingPedalingCadenceRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformCyclingPedalingCadenceRecord;", "toSdkCyclingPedalingCadenceSample", "toSdkDistanceRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformDistanceRecord;", "toSdkElevationGainedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformElevationGainedRecord;", "toSdkExerciseLap", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseLap;", "toSdkExerciseRoute", "toSdkExerciseSegment", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseSegment;", "toSdkExerciseSessionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformExerciseSessionRecord;", "toSdkFloorsClimbedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformFloorsClimbedRecord;", "toSdkHeartRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateRecord;", "toSdkHeartRateSample", "toSdkHeartRateVariabilityRmssdRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHeartRateVariabilityRmssdRecord;", "toSdkHeightRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHeightRecord;", "toSdkHydrationRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformHydrationRecord;", "toSdkIntermenstrualBleedingRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformIntermenstrualBleedingRecord;", "toSdkLeanBodyMassRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformLeanBodyMassRecord;", "toSdkMenstruationFlowRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformMenstruationFlowRecord;", "toSdkMenstruationPeriodRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformMenstruationPeriodRecord;", "toSdkNutritionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformNutritionRecord;", "toSdkOvulationTestRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformOvulationTestRecord;", "toSdkOxygenSaturationRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformOxygenSaturationRecord;", "toSdkPowerRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformPowerRecord;", "toSdkPowerRecordSample", "toSdkRecord", "toSdkRespiratoryRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformRespiratoryRateRecord;", "toSdkRestingHeartRateRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformRestingHeartRateRecord;", "toSdkSexualActivityRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSexualActivityRecord;", "toSdkSleepSessionRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSleepSessionRecord;", "toSdkSleepSessionStage", "toSdkSpeedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformSpeedRecord;", "toSdkSpeedSample", "toSdkStepsCadenceRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsCadenceRecord;", "toSdkStepsCadenceSample", "toSdkStepsRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformStepsRecord;", "toSdkTotalCaloriesBurnedRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformTotalCaloriesBurnedRecord;", "toSdkVo2MaxRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformVo2MaxRecord;", "toSdkWeightRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformWeightRecord;", "toWheelchairPushesRecord", "Landroidx/health/connect/client/impl/platform/records/PlatformWheelchairPushesRecord;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecordConvertersKt {
    public static final Class<? extends Record> toPlatformRecordClass(KClass<? extends androidx.health.connect.client.records.Record> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<? extends Record> cls = RecordMappingsKt.getSDK_TO_PLATFORM_RECORD_CLASS().get(kClass);
        if (cls != null) {
            return cls;
        }
        throw new IllegalArgumentException("Unsupported record type " + kClass);
    }

    public static final Record toPlatformRecord(androidx.health.connect.client.records.Record record) {
        Intrinsics.checkNotNullParameter(record, "<this>");
        if (record instanceof ActiveCaloriesBurnedRecord) {
            return toPlatformActiveCaloriesBurnedRecord((ActiveCaloriesBurnedRecord) record);
        }
        if (record instanceof BasalBodyTemperatureRecord) {
            return toPlatformBasalBodyTemperatureRecord((BasalBodyTemperatureRecord) record);
        }
        if (record instanceof BasalMetabolicRateRecord) {
            return toPlatformBasalMetabolicRateRecord((BasalMetabolicRateRecord) record);
        }
        if (record instanceof BloodGlucoseRecord) {
            return toPlatformBloodGlucoseRecord((BloodGlucoseRecord) record);
        }
        if (record instanceof BloodPressureRecord) {
            return toPlatformBloodPressureRecord((BloodPressureRecord) record);
        }
        if (record instanceof BodyFatRecord) {
            return toPlatformBodyFatRecord((BodyFatRecord) record);
        }
        if (record instanceof BodyTemperatureRecord) {
            return toPlatformBodyTemperatureRecord((BodyTemperatureRecord) record);
        }
        if (record instanceof BodyWaterMassRecord) {
            return toPlatformBodyWaterMassRecord((BodyWaterMassRecord) record);
        }
        if (record instanceof BoneMassRecord) {
            return toPlatformBoneMassRecord((BoneMassRecord) record);
        }
        if (record instanceof CervicalMucusRecord) {
            return toPlatformCervicalMucusRecord((CervicalMucusRecord) record);
        }
        if (record instanceof CyclingPedalingCadenceRecord) {
            return toPlatformCyclingPedalingCadenceRecord((CyclingPedalingCadenceRecord) record);
        }
        if (record instanceof DistanceRecord) {
            return toPlatformDistanceRecord((DistanceRecord) record);
        }
        if (record instanceof ElevationGainedRecord) {
            return toPlatformElevationGainedRecord((ElevationGainedRecord) record);
        }
        if (record instanceof ExerciseSessionRecord) {
            return toPlatformExerciseSessionRecord((ExerciseSessionRecord) record);
        }
        if (record instanceof FloorsClimbedRecord) {
            return toPlatformFloorsClimbedRecord((FloorsClimbedRecord) record);
        }
        if (record instanceof HeartRateRecord) {
            return toPlatformHeartRateRecord((HeartRateRecord) record);
        }
        if (record instanceof HeartRateVariabilityRmssdRecord) {
            return toPlatformHeartRateVariabilityRmssdRecord((HeartRateVariabilityRmssdRecord) record);
        }
        if (record instanceof HeightRecord) {
            return toPlatformHeightRecord((HeightRecord) record);
        }
        if (record instanceof HydrationRecord) {
            return toPlatformHydrationRecord((HydrationRecord) record);
        }
        if (record instanceof IntermenstrualBleedingRecord) {
            return toPlatformIntermenstrualBleedingRecord((IntermenstrualBleedingRecord) record);
        }
        if (record instanceof LeanBodyMassRecord) {
            return toPlatformLeanBodyMassRecord((LeanBodyMassRecord) record);
        }
        if (record instanceof MenstruationFlowRecord) {
            return toPlatformMenstruationFlowRecord((MenstruationFlowRecord) record);
        }
        if (record instanceof MenstruationPeriodRecord) {
            return toPlatformMenstruationPeriodRecord((MenstruationPeriodRecord) record);
        }
        if (record instanceof NutritionRecord) {
            return toPlatformNutritionRecord((NutritionRecord) record);
        }
        if (record instanceof OvulationTestRecord) {
            return toPlatformOvulationTestRecord((OvulationTestRecord) record);
        }
        if (record instanceof OxygenSaturationRecord) {
            return toPlatformOxygenSaturationRecord((OxygenSaturationRecord) record);
        }
        if (record instanceof PowerRecord) {
            return toPlatformPowerRecord((PowerRecord) record);
        }
        if (record instanceof RespiratoryRateRecord) {
            return toPlatformRespiratoryRateRecord((RespiratoryRateRecord) record);
        }
        if (record instanceof RestingHeartRateRecord) {
            return toPlatformRestingHeartRateRecord((RestingHeartRateRecord) record);
        }
        if (record instanceof SexualActivityRecord) {
            return toPlatformSexualActivityRecord((SexualActivityRecord) record);
        }
        if (record instanceof SleepSessionRecord) {
            return toPlatformSleepSessionRecord((SleepSessionRecord) record);
        }
        if (record instanceof SpeedRecord) {
            return toPlatformSpeedRecord((SpeedRecord) record);
        }
        if (record instanceof StepsCadenceRecord) {
            return toPlatformStepsCadenceRecord((StepsCadenceRecord) record);
        }
        if (record instanceof StepsRecord) {
            return toPlatformStepsRecord((StepsRecord) record);
        }
        if (record instanceof TotalCaloriesBurnedRecord) {
            return toPlatformTotalCaloriesBurnedRecord((TotalCaloriesBurnedRecord) record);
        }
        if (record instanceof Vo2MaxRecord) {
            return toPlatformVo2MaxRecord((Vo2MaxRecord) record);
        }
        if (record instanceof WeightRecord) {
            return toPlatformWeightRecord((WeightRecord) record);
        }
        if (record instanceof WheelchairPushesRecord) {
            return toPlatformWheelchairPushesRecord((WheelchairPushesRecord) record);
        }
        throw new IllegalArgumentException("Unsupported record " + record);
    }

    public static final androidx.health.connect.client.records.Record toSdkRecord(Record record) {
        Intrinsics.checkNotNullParameter(record, "<this>");
        if (record instanceof android.health.connect.datatypes.ActiveCaloriesBurnedRecord) {
            return toSdkActiveCaloriesBurnedRecord((android.health.connect.datatypes.ActiveCaloriesBurnedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BasalBodyTemperatureRecord) {
            return toSdkBasalBodyTemperatureRecord((android.health.connect.datatypes.BasalBodyTemperatureRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BasalMetabolicRateRecord) {
            return toSdkBasalMetabolicRateRecord((android.health.connect.datatypes.BasalMetabolicRateRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BloodGlucoseRecord) {
            return toSdkBloodGlucoseRecord((android.health.connect.datatypes.BloodGlucoseRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BloodPressureRecord) {
            return toSdkBloodPressureRecord((android.health.connect.datatypes.BloodPressureRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BodyFatRecord) {
            return toSdkBodyFatRecord((android.health.connect.datatypes.BodyFatRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BodyTemperatureRecord) {
            return toSdkBodyTemperatureRecord((android.health.connect.datatypes.BodyTemperatureRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BodyWaterMassRecord) {
            return toSdkBodyWaterMassRecord((android.health.connect.datatypes.BodyWaterMassRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.BoneMassRecord) {
            return toSdkBoneMassRecord((android.health.connect.datatypes.BoneMassRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.CervicalMucusRecord) {
            return toSdkCervicalMucusRecord((android.health.connect.datatypes.CervicalMucusRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.CyclingPedalingCadenceRecord) {
            return toSdkCyclingPedalingCadenceRecord((android.health.connect.datatypes.CyclingPedalingCadenceRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.DistanceRecord) {
            return toSdkDistanceRecord((android.health.connect.datatypes.DistanceRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.ElevationGainedRecord) {
            return toSdkElevationGainedRecord((android.health.connect.datatypes.ElevationGainedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.ExerciseSessionRecord) {
            return toSdkExerciseSessionRecord((android.health.connect.datatypes.ExerciseSessionRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.FloorsClimbedRecord) {
            return toSdkFloorsClimbedRecord((android.health.connect.datatypes.FloorsClimbedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.HeartRateRecord) {
            return toSdkHeartRateRecord((android.health.connect.datatypes.HeartRateRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.HeartRateVariabilityRmssdRecord) {
            return toSdkHeartRateVariabilityRmssdRecord((android.health.connect.datatypes.HeartRateVariabilityRmssdRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.HeightRecord) {
            return toSdkHeightRecord((android.health.connect.datatypes.HeightRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.HydrationRecord) {
            return toSdkHydrationRecord((android.health.connect.datatypes.HydrationRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.IntermenstrualBleedingRecord) {
            return toSdkIntermenstrualBleedingRecord((android.health.connect.datatypes.IntermenstrualBleedingRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.LeanBodyMassRecord) {
            return toSdkLeanBodyMassRecord((android.health.connect.datatypes.LeanBodyMassRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.MenstruationFlowRecord) {
            return toSdkMenstruationFlowRecord((android.health.connect.datatypes.MenstruationFlowRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.MenstruationPeriodRecord) {
            return toSdkMenstruationPeriodRecord((android.health.connect.datatypes.MenstruationPeriodRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.NutritionRecord) {
            return toSdkNutritionRecord((android.health.connect.datatypes.NutritionRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.OvulationTestRecord) {
            return toSdkOvulationTestRecord((android.health.connect.datatypes.OvulationTestRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.OxygenSaturationRecord) {
            return toSdkOxygenSaturationRecord((android.health.connect.datatypes.OxygenSaturationRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.PowerRecord) {
            return toSdkPowerRecord((android.health.connect.datatypes.PowerRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.RespiratoryRateRecord) {
            return toSdkRespiratoryRateRecord((android.health.connect.datatypes.RespiratoryRateRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.RestingHeartRateRecord) {
            return toSdkRestingHeartRateRecord((android.health.connect.datatypes.RestingHeartRateRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SexualActivityRecord) {
            return toSdkSexualActivityRecord((android.health.connect.datatypes.SexualActivityRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SleepSessionRecord) {
            return toSdkSleepSessionRecord((android.health.connect.datatypes.SleepSessionRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.SpeedRecord) {
            return toSdkSpeedRecord((android.health.connect.datatypes.SpeedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.StepsCadenceRecord) {
            return toSdkStepsCadenceRecord((android.health.connect.datatypes.StepsCadenceRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.StepsRecord) {
            return toSdkStepsRecord((android.health.connect.datatypes.StepsRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.TotalCaloriesBurnedRecord) {
            return toSdkTotalCaloriesBurnedRecord((android.health.connect.datatypes.TotalCaloriesBurnedRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.Vo2MaxRecord) {
            return toSdkVo2MaxRecord((android.health.connect.datatypes.Vo2MaxRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.WeightRecord) {
            return toSdkWeightRecord((android.health.connect.datatypes.WeightRecord) record);
        }
        if (record instanceof android.health.connect.datatypes.WheelchairPushesRecord) {
            return toWheelchairPushesRecord((android.health.connect.datatypes.WheelchairPushesRecord) record);
        }
        throw new IllegalArgumentException("Unsupported record " + record);
    }

    private static final ActiveCaloriesBurnedRecord toSdkActiveCaloriesBurnedRecord(android.health.connect.datatypes.ActiveCaloriesBurnedRecord activeCaloriesBurnedRecord) {
        Instant startTime = activeCaloriesBurnedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = activeCaloriesBurnedRecord.getStartZoneOffset();
        Instant endTime = activeCaloriesBurnedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = activeCaloriesBurnedRecord.getEndZoneOffset();
        Energy energy = activeCaloriesBurnedRecord.getEnergy();
        Intrinsics.checkNotNullExpressionValue(energy, "energy");
        androidx.health.connect.client.units.Energy sdkEnergy = UnitConvertersKt.toSdkEnergy(energy);
        android.health.connect.datatypes.Metadata metadata = activeCaloriesBurnedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new ActiveCaloriesBurnedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkEnergy, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BasalBodyTemperatureRecord toSdkBasalBodyTemperatureRecord(android.health.connect.datatypes.BasalBodyTemperatureRecord basalBodyTemperatureRecord) {
        Instant time = basalBodyTemperatureRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = basalBodyTemperatureRecord.getZoneOffset();
        Temperature temperature = basalBodyTemperatureRecord.getTemperature();
        Intrinsics.checkNotNullExpressionValue(temperature, "temperature");
        androidx.health.connect.client.units.Temperature sdkTemperature = UnitConvertersKt.toSdkTemperature(temperature);
        int measurementLocation = basalBodyTemperatureRecord.getMeasurementLocation();
        android.health.connect.datatypes.Metadata metadata = basalBodyTemperatureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BasalBodyTemperatureRecord(time, zoneOffset, sdkTemperature, measurementLocation, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BasalMetabolicRateRecord toSdkBasalMetabolicRateRecord(android.health.connect.datatypes.BasalMetabolicRateRecord basalMetabolicRateRecord) {
        Instant time = basalMetabolicRateRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = basalMetabolicRateRecord.getZoneOffset();
        Power basalMetabolicRate = basalMetabolicRateRecord.getBasalMetabolicRate();
        Intrinsics.checkNotNullExpressionValue(basalMetabolicRate, "basalMetabolicRate");
        androidx.health.connect.client.units.Power sdkPower = UnitConvertersKt.toSdkPower(basalMetabolicRate);
        android.health.connect.datatypes.Metadata metadata = basalMetabolicRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BasalMetabolicRateRecord(time, zoneOffset, sdkPower, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BloodGlucoseRecord toSdkBloodGlucoseRecord(android.health.connect.datatypes.BloodGlucoseRecord bloodGlucoseRecord) {
        Instant time = bloodGlucoseRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = bloodGlucoseRecord.getZoneOffset();
        BloodGlucose level = bloodGlucoseRecord.getLevel();
        Intrinsics.checkNotNullExpressionValue(level, "level");
        androidx.health.connect.client.units.BloodGlucose sdkBloodGlucose = UnitConvertersKt.toSdkBloodGlucose(level);
        int sdkBloodGlucoseSpecimenSource = IntDefMappingsKt.toSdkBloodGlucoseSpecimenSource(bloodGlucoseRecord.getSpecimenSource());
        int sdkMealType = IntDefMappingsKt.toSdkMealType(bloodGlucoseRecord.getMealType());
        int sdkRelationToMeal = IntDefMappingsKt.toSdkRelationToMeal(bloodGlucoseRecord.getRelationToMeal());
        android.health.connect.datatypes.Metadata metadata = bloodGlucoseRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BloodGlucoseRecord(time, zoneOffset, sdkBloodGlucose, sdkBloodGlucoseSpecimenSource, sdkMealType, sdkRelationToMeal, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BloodPressureRecord toSdkBloodPressureRecord(android.health.connect.datatypes.BloodPressureRecord bloodPressureRecord) {
        Instant time = bloodPressureRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = bloodPressureRecord.getZoneOffset();
        Pressure systolic = bloodPressureRecord.getSystolic();
        Intrinsics.checkNotNullExpressionValue(systolic, "systolic");
        androidx.health.connect.client.units.Pressure sdkPressure = UnitConvertersKt.toSdkPressure(systolic);
        Pressure diastolic = bloodPressureRecord.getDiastolic();
        Intrinsics.checkNotNullExpressionValue(diastolic, "diastolic");
        androidx.health.connect.client.units.Pressure sdkPressure2 = UnitConvertersKt.toSdkPressure(diastolic);
        int sdkBloodPressureBodyPosition = IntDefMappingsKt.toSdkBloodPressureBodyPosition(bloodPressureRecord.getBodyPosition());
        int sdkBloodPressureMeasurementLocation = IntDefMappingsKt.toSdkBloodPressureMeasurementLocation(bloodPressureRecord.getMeasurementLocation());
        android.health.connect.datatypes.Metadata metadata = bloodPressureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BloodPressureRecord(time, zoneOffset, sdkPressure, sdkPressure2, sdkBloodPressureBodyPosition, sdkBloodPressureMeasurementLocation, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BodyFatRecord toSdkBodyFatRecord(android.health.connect.datatypes.BodyFatRecord bodyFatRecord) {
        Instant time = bodyFatRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = bodyFatRecord.getZoneOffset();
        Percentage percentage = bodyFatRecord.getPercentage();
        Intrinsics.checkNotNullExpressionValue(percentage, "percentage");
        androidx.health.connect.client.units.Percentage sdkPercentage = UnitConvertersKt.toSdkPercentage(percentage);
        android.health.connect.datatypes.Metadata metadata = bodyFatRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BodyFatRecord(time, zoneOffset, sdkPercentage, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BodyTemperatureRecord toSdkBodyTemperatureRecord(android.health.connect.datatypes.BodyTemperatureRecord bodyTemperatureRecord) {
        Instant time = bodyTemperatureRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = bodyTemperatureRecord.getZoneOffset();
        Temperature temperature = bodyTemperatureRecord.getTemperature();
        Intrinsics.checkNotNullExpressionValue(temperature, "temperature");
        androidx.health.connect.client.units.Temperature sdkTemperature = UnitConvertersKt.toSdkTemperature(temperature);
        int sdkBodyTemperatureMeasurementLocation = IntDefMappingsKt.toSdkBodyTemperatureMeasurementLocation(bodyTemperatureRecord.getMeasurementLocation());
        android.health.connect.datatypes.Metadata metadata = bodyTemperatureRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BodyTemperatureRecord(time, zoneOffset, sdkTemperature, sdkBodyTemperatureMeasurementLocation, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BodyWaterMassRecord toSdkBodyWaterMassRecord(android.health.connect.datatypes.BodyWaterMassRecord bodyWaterMassRecord) {
        Instant time = bodyWaterMassRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = bodyWaterMassRecord.getZoneOffset();
        Mass bodyWaterMass = bodyWaterMassRecord.getBodyWaterMass();
        Intrinsics.checkNotNullExpressionValue(bodyWaterMass, "bodyWaterMass");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(bodyWaterMass);
        android.health.connect.datatypes.Metadata metadata = bodyWaterMassRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BodyWaterMassRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final BoneMassRecord toSdkBoneMassRecord(android.health.connect.datatypes.BoneMassRecord boneMassRecord) {
        Instant time = boneMassRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = boneMassRecord.getZoneOffset();
        Mass mass = boneMassRecord.getMass();
        Intrinsics.checkNotNullExpressionValue(mass, "mass");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(mass);
        android.health.connect.datatypes.Metadata metadata = boneMassRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new BoneMassRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final CervicalMucusRecord toSdkCervicalMucusRecord(android.health.connect.datatypes.CervicalMucusRecord cervicalMucusRecord) {
        Instant time = cervicalMucusRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = cervicalMucusRecord.getZoneOffset();
        int sdkCervicalMucusAppearance = IntDefMappingsKt.toSdkCervicalMucusAppearance(cervicalMucusRecord.getAppearance());
        int sdkCervicalMucusSensation = IntDefMappingsKt.toSdkCervicalMucusSensation(cervicalMucusRecord.getSensation());
        android.health.connect.datatypes.Metadata metadata = cervicalMucusRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new CervicalMucusRecord(time, zoneOffset, sdkCervicalMucusAppearance, sdkCervicalMucusSensation, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final CyclingPedalingCadenceRecord toSdkCyclingPedalingCadenceRecord(android.health.connect.datatypes.CyclingPedalingCadenceRecord cyclingPedalingCadenceRecord) {
        Instant startTime = cyclingPedalingCadenceRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = cyclingPedalingCadenceRecord.getStartZoneOffset();
        Instant endTime = cyclingPedalingCadenceRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = cyclingPedalingCadenceRecord.getEndZoneOffset();
        List<CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample> samples = cyclingPedalingCadenceRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        List<CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkCyclingPedalingCadenceSample(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkCyclingPedalingCadenceRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CyclingPedalingCadenceRecord.Sample) t).getTime(), ((CyclingPedalingCadenceRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = cyclingPedalingCadenceRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.CyclingPedalingCadenceRecord(startTime, startZoneOffset, endTime, endZoneOffset, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final DistanceRecord toSdkDistanceRecord(android.health.connect.datatypes.DistanceRecord distanceRecord) {
        Instant startTime = distanceRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = distanceRecord.getStartZoneOffset();
        Instant endTime = distanceRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = distanceRecord.getEndZoneOffset();
        Length distance = distanceRecord.getDistance();
        Intrinsics.checkNotNullExpressionValue(distance, "distance");
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(distance);
        android.health.connect.datatypes.Metadata metadata = distanceRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new DistanceRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final ElevationGainedRecord toSdkElevationGainedRecord(android.health.connect.datatypes.ElevationGainedRecord elevationGainedRecord) {
        Instant startTime = elevationGainedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = elevationGainedRecord.getStartZoneOffset();
        Instant endTime = elevationGainedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = elevationGainedRecord.getEndZoneOffset();
        Length elevation = elevationGainedRecord.getElevation();
        Intrinsics.checkNotNullExpressionValue(elevation, "elevation");
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(elevation);
        android.health.connect.datatypes.Metadata metadata = elevationGainedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new ElevationGainedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final ExerciseSessionRecord toSdkExerciseSessionRecord(android.health.connect.datatypes.ExerciseSessionRecord exerciseSessionRecord) {
        ExerciseRouteResult.NoData consentRequired;
        Instant startTime = exerciseSessionRecord.getStartTime();
        ZoneOffset startZoneOffset = exerciseSessionRecord.getStartZoneOffset();
        Instant endTime = exerciseSessionRecord.getEndTime();
        ZoneOffset endZoneOffset = exerciseSessionRecord.getEndZoneOffset();
        int sdkExerciseSessionType = IntDefMappingsKt.toSdkExerciseSessionType(exerciseSessionRecord.getExerciseType());
        CharSequence title = exerciseSessionRecord.getTitle();
        String string = title != null ? title.toString() : null;
        CharSequence notes = exerciseSessionRecord.getNotes();
        String string2 = notes != null ? notes.toString() : null;
        List<ExerciseLap> laps = exerciseSessionRecord.getLaps();
        Intrinsics.checkNotNullExpressionValue(laps, "laps");
        List<ExerciseLap> list = laps;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ExerciseLap it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkExerciseLap(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkExerciseSessionRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((androidx.health.connect.client.records.ExerciseLap) t).getStartTime(), ((androidx.health.connect.client.records.ExerciseLap) t2).getStartTime());
            }
        });
        List<ExerciseSegment> segments = exerciseSessionRecord.getSegments();
        Intrinsics.checkNotNullExpressionValue(segments, "segments");
        List<ExerciseSegment> list2 = segments;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ExerciseSegment it2 : list2) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            arrayList2.add(toSdkExerciseSegment(it2));
        }
        List listSortedWith2 = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkExerciseSessionRecord$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((androidx.health.connect.client.records.ExerciseSegment) t).getStartTime(), ((androidx.health.connect.client.records.ExerciseSegment) t2).getStartTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = exerciseSessionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        ExerciseRoute route = exerciseSessionRecord.getRoute();
        if (route != null) {
            consentRequired = new ExerciseRouteResult.Data(toSdkExerciseRoute(route));
        } else {
            consentRequired = exerciseSessionRecord.hasRoute() ? new ExerciseRouteResult.ConsentRequired() : new ExerciseRouteResult.NoData();
        }
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new ExerciseSessionRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkExerciseSessionType, string, string2, sdkMetadata, (List<androidx.health.connect.client.records.ExerciseSegment>) listSortedWith2, (List<androidx.health.connect.client.records.ExerciseLap>) listSortedWith, consentRequired);
    }

    private static final FloorsClimbedRecord toSdkFloorsClimbedRecord(android.health.connect.datatypes.FloorsClimbedRecord floorsClimbedRecord) {
        Instant startTime = floorsClimbedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = floorsClimbedRecord.getStartZoneOffset();
        Instant endTime = floorsClimbedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = floorsClimbedRecord.getEndZoneOffset();
        double floors = floorsClimbedRecord.getFloors();
        android.health.connect.datatypes.Metadata metadata = floorsClimbedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new FloorsClimbedRecord(startTime, startZoneOffset, endTime, endZoneOffset, floors, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeartRateRecord toSdkHeartRateRecord(android.health.connect.datatypes.HeartRateRecord heartRateRecord) {
        Instant startTime = heartRateRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = heartRateRecord.getStartZoneOffset();
        Instant endTime = heartRateRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = heartRateRecord.getEndZoneOffset();
        List<HeartRateRecord.HeartRateSample> samples = heartRateRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        List<HeartRateRecord.HeartRateSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (HeartRateRecord.HeartRateSample it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkHeartRateSample(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkHeartRateRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((HeartRateRecord.Sample) t).getTime(), ((HeartRateRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = heartRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.HeartRateRecord(startTime, startZoneOffset, endTime, endZoneOffset, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeartRateVariabilityRmssdRecord toSdkHeartRateVariabilityRmssdRecord(android.health.connect.datatypes.HeartRateVariabilityRmssdRecord heartRateVariabilityRmssdRecord) {
        Instant time = heartRateVariabilityRmssdRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = heartRateVariabilityRmssdRecord.getZoneOffset();
        double heartRateVariabilityMillis = heartRateVariabilityRmssdRecord.getHeartRateVariabilityMillis();
        android.health.connect.datatypes.Metadata metadata = heartRateVariabilityRmssdRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new HeartRateVariabilityRmssdRecord(time, zoneOffset, heartRateVariabilityMillis, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HeightRecord toSdkHeightRecord(android.health.connect.datatypes.HeightRecord heightRecord) {
        Instant time = heightRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = heightRecord.getZoneOffset();
        Length height = heightRecord.getHeight();
        Intrinsics.checkNotNullExpressionValue(height, "height");
        androidx.health.connect.client.units.Length sdkLength = UnitConvertersKt.toSdkLength(height);
        android.health.connect.datatypes.Metadata metadata = heightRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new HeightRecord(time, zoneOffset, sdkLength, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final HydrationRecord toSdkHydrationRecord(android.health.connect.datatypes.HydrationRecord hydrationRecord) {
        Instant startTime = hydrationRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = hydrationRecord.getStartZoneOffset();
        Instant endTime = hydrationRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = hydrationRecord.getEndZoneOffset();
        Volume volume = hydrationRecord.getVolume();
        Intrinsics.checkNotNullExpressionValue(volume, "volume");
        androidx.health.connect.client.units.Volume sdkVolume = UnitConvertersKt.toSdkVolume(volume);
        android.health.connect.datatypes.Metadata metadata = hydrationRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new HydrationRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkVolume, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final IntermenstrualBleedingRecord toSdkIntermenstrualBleedingRecord(android.health.connect.datatypes.IntermenstrualBleedingRecord intermenstrualBleedingRecord) {
        Instant time = intermenstrualBleedingRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = intermenstrualBleedingRecord.getZoneOffset();
        android.health.connect.datatypes.Metadata metadata = intermenstrualBleedingRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new IntermenstrualBleedingRecord(time, zoneOffset, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final LeanBodyMassRecord toSdkLeanBodyMassRecord(android.health.connect.datatypes.LeanBodyMassRecord leanBodyMassRecord) {
        Instant time = leanBodyMassRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = leanBodyMassRecord.getZoneOffset();
        Mass mass = leanBodyMassRecord.getMass();
        Intrinsics.checkNotNullExpressionValue(mass, "mass");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(mass);
        android.health.connect.datatypes.Metadata metadata = leanBodyMassRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new LeanBodyMassRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final MenstruationFlowRecord toSdkMenstruationFlowRecord(android.health.connect.datatypes.MenstruationFlowRecord menstruationFlowRecord) {
        Instant time = menstruationFlowRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = menstruationFlowRecord.getZoneOffset();
        int sdkMenstruationFlow = IntDefMappingsKt.toSdkMenstruationFlow(menstruationFlowRecord.getFlow());
        android.health.connect.datatypes.Metadata metadata = menstruationFlowRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new MenstruationFlowRecord(time, zoneOffset, sdkMenstruationFlow, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final MenstruationPeriodRecord toSdkMenstruationPeriodRecord(android.health.connect.datatypes.MenstruationPeriodRecord menstruationPeriodRecord) {
        Instant startTime = menstruationPeriodRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = menstruationPeriodRecord.getStartZoneOffset();
        Instant endTime = menstruationPeriodRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = menstruationPeriodRecord.getEndZoneOffset();
        android.health.connect.datatypes.Metadata metadata = menstruationPeriodRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new MenstruationPeriodRecord(startTime, startZoneOffset, endTime, endZoneOffset, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final NutritionRecord toSdkNutritionRecord(android.health.connect.datatypes.NutritionRecord nutritionRecord) {
        Instant startTime = nutritionRecord.getStartTime();
        ZoneOffset startZoneOffset = nutritionRecord.getStartZoneOffset();
        Instant endTime = nutritionRecord.getEndTime();
        ZoneOffset endZoneOffset = nutritionRecord.getEndZoneOffset();
        String mealName = nutritionRecord.getMealName();
        int sdkMealType = IntDefMappingsKt.toSdkMealType(nutritionRecord.getMealType());
        android.health.connect.datatypes.Metadata metadata = nutritionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        Mass biotin = nutritionRecord.getBiotin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass = biotin != null ? UnitConvertersKt.toNonDefaultSdkMass(biotin) : null;
        Mass caffeine = nutritionRecord.getCaffeine();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass2 = caffeine != null ? UnitConvertersKt.toNonDefaultSdkMass(caffeine) : null;
        Mass calcium = nutritionRecord.getCalcium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass3 = calcium != null ? UnitConvertersKt.toNonDefaultSdkMass(calcium) : null;
        Energy energy = nutritionRecord.getEnergy();
        androidx.health.connect.client.units.Energy nonDefaultSdkEnergy = energy != null ? UnitConvertersKt.toNonDefaultSdkEnergy(energy) : null;
        Energy energyFromFat = nutritionRecord.getEnergyFromFat();
        androidx.health.connect.client.units.Energy nonDefaultSdkEnergy2 = energyFromFat != null ? UnitConvertersKt.toNonDefaultSdkEnergy(energyFromFat) : null;
        Mass chloride = nutritionRecord.getChloride();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass4 = chloride != null ? UnitConvertersKt.toNonDefaultSdkMass(chloride) : null;
        Mass cholesterol = nutritionRecord.getCholesterol();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass5 = cholesterol != null ? UnitConvertersKt.toNonDefaultSdkMass(cholesterol) : null;
        Mass chromium = nutritionRecord.getChromium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass6 = chromium != null ? UnitConvertersKt.toNonDefaultSdkMass(chromium) : null;
        Mass copper = nutritionRecord.getCopper();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass7 = copper != null ? UnitConvertersKt.toNonDefaultSdkMass(copper) : null;
        Mass dietaryFiber = nutritionRecord.getDietaryFiber();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass8 = dietaryFiber != null ? UnitConvertersKt.toNonDefaultSdkMass(dietaryFiber) : null;
        Mass folate = nutritionRecord.getFolate();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass9 = folate != null ? UnitConvertersKt.toNonDefaultSdkMass(folate) : null;
        Mass folicAcid = nutritionRecord.getFolicAcid();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass10 = folicAcid != null ? UnitConvertersKt.toNonDefaultSdkMass(folicAcid) : null;
        Mass iodine = nutritionRecord.getIodine();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass11 = iodine != null ? UnitConvertersKt.toNonDefaultSdkMass(iodine) : null;
        Mass iron = nutritionRecord.getIron();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass12 = iron != null ? UnitConvertersKt.toNonDefaultSdkMass(iron) : null;
        Mass magnesium = nutritionRecord.getMagnesium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass13 = magnesium != null ? UnitConvertersKt.toNonDefaultSdkMass(magnesium) : null;
        Mass manganese = nutritionRecord.getManganese();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass14 = manganese != null ? UnitConvertersKt.toNonDefaultSdkMass(manganese) : null;
        Mass molybdenum = nutritionRecord.getMolybdenum();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass15 = molybdenum != null ? UnitConvertersKt.toNonDefaultSdkMass(molybdenum) : null;
        Mass monounsaturatedFat = nutritionRecord.getMonounsaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass16 = monounsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(monounsaturatedFat) : null;
        Mass niacin = nutritionRecord.getNiacin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass17 = niacin != null ? UnitConvertersKt.toNonDefaultSdkMass(niacin) : null;
        Mass pantothenicAcid = nutritionRecord.getPantothenicAcid();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass18 = pantothenicAcid != null ? UnitConvertersKt.toNonDefaultSdkMass(pantothenicAcid) : null;
        Mass phosphorus = nutritionRecord.getPhosphorus();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass19 = phosphorus != null ? UnitConvertersKt.toNonDefaultSdkMass(phosphorus) : null;
        Mass polyunsaturatedFat = nutritionRecord.getPolyunsaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass20 = polyunsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(polyunsaturatedFat) : null;
        Mass potassium = nutritionRecord.getPotassium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass21 = potassium != null ? UnitConvertersKt.toNonDefaultSdkMass(potassium) : null;
        Mass protein = nutritionRecord.getProtein();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass22 = protein != null ? UnitConvertersKt.toNonDefaultSdkMass(protein) : null;
        Mass riboflavin = nutritionRecord.getRiboflavin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass23 = riboflavin != null ? UnitConvertersKt.toNonDefaultSdkMass(riboflavin) : null;
        Mass saturatedFat = nutritionRecord.getSaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass24 = saturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(saturatedFat) : null;
        Mass selenium = nutritionRecord.getSelenium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass25 = selenium != null ? UnitConvertersKt.toNonDefaultSdkMass(selenium) : null;
        Mass sodium = nutritionRecord.getSodium();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass26 = sodium != null ? UnitConvertersKt.toNonDefaultSdkMass(sodium) : null;
        Mass sugar = nutritionRecord.getSugar();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass27 = sugar != null ? UnitConvertersKt.toNonDefaultSdkMass(sugar) : null;
        Mass thiamin = nutritionRecord.getThiamin();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass28 = thiamin != null ? UnitConvertersKt.toNonDefaultSdkMass(thiamin) : null;
        Mass totalCarbohydrate = nutritionRecord.getTotalCarbohydrate();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass29 = totalCarbohydrate != null ? UnitConvertersKt.toNonDefaultSdkMass(totalCarbohydrate) : null;
        Mass totalFat = nutritionRecord.getTotalFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass30 = totalFat != null ? UnitConvertersKt.toNonDefaultSdkMass(totalFat) : null;
        Mass transFat = nutritionRecord.getTransFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass31 = transFat != null ? UnitConvertersKt.toNonDefaultSdkMass(transFat) : null;
        Mass unsaturatedFat = nutritionRecord.getUnsaturatedFat();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass32 = unsaturatedFat != null ? UnitConvertersKt.toNonDefaultSdkMass(unsaturatedFat) : null;
        Mass vitaminA = nutritionRecord.getVitaminA();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass33 = vitaminA != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminA) : null;
        Mass vitaminB12 = nutritionRecord.getVitaminB12();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass34 = vitaminB12 != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminB12) : null;
        Mass vitaminB6 = nutritionRecord.getVitaminB6();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass35 = vitaminB6 != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminB6) : null;
        Mass vitaminC = nutritionRecord.getVitaminC();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass36 = vitaminC != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminC) : null;
        Mass vitaminD = nutritionRecord.getVitaminD();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass37 = vitaminD != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminD) : null;
        Mass vitaminE = nutritionRecord.getVitaminE();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass38 = vitaminE != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminE) : null;
        Mass vitaminK = nutritionRecord.getVitaminK();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass39 = vitaminK != null ? UnitConvertersKt.toNonDefaultSdkMass(vitaminK) : null;
        Mass zinc = nutritionRecord.getZinc();
        androidx.health.connect.client.units.Mass nonDefaultSdkMass40 = zinc != null ? UnitConvertersKt.toNonDefaultSdkMass(zinc) : null;
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new NutritionRecord(startTime, startZoneOffset, endTime, endZoneOffset, nonDefaultSdkMass, nonDefaultSdkMass2, nonDefaultSdkMass3, nonDefaultSdkEnergy, nonDefaultSdkEnergy2, nonDefaultSdkMass4, nonDefaultSdkMass5, nonDefaultSdkMass6, nonDefaultSdkMass7, nonDefaultSdkMass8, nonDefaultSdkMass9, nonDefaultSdkMass10, nonDefaultSdkMass11, nonDefaultSdkMass12, nonDefaultSdkMass13, nonDefaultSdkMass14, nonDefaultSdkMass15, nonDefaultSdkMass16, nonDefaultSdkMass17, nonDefaultSdkMass18, nonDefaultSdkMass19, nonDefaultSdkMass20, nonDefaultSdkMass21, nonDefaultSdkMass22, nonDefaultSdkMass23, nonDefaultSdkMass24, nonDefaultSdkMass25, nonDefaultSdkMass26, nonDefaultSdkMass27, nonDefaultSdkMass28, nonDefaultSdkMass29, nonDefaultSdkMass30, nonDefaultSdkMass31, nonDefaultSdkMass32, nonDefaultSdkMass33, nonDefaultSdkMass34, nonDefaultSdkMass35, nonDefaultSdkMass36, nonDefaultSdkMass37, nonDefaultSdkMass38, nonDefaultSdkMass39, nonDefaultSdkMass40, mealName, sdkMealType, sdkMetadata);
    }

    private static final OvulationTestRecord toSdkOvulationTestRecord(android.health.connect.datatypes.OvulationTestRecord ovulationTestRecord) {
        Instant time = ovulationTestRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = ovulationTestRecord.getZoneOffset();
        int sdkOvulationTestResult = IntDefMappingsKt.toSdkOvulationTestResult(ovulationTestRecord.getResult());
        android.health.connect.datatypes.Metadata metadata = ovulationTestRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new OvulationTestRecord(time, zoneOffset, sdkOvulationTestResult, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final OxygenSaturationRecord toSdkOxygenSaturationRecord(android.health.connect.datatypes.OxygenSaturationRecord oxygenSaturationRecord) {
        Instant time = oxygenSaturationRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = oxygenSaturationRecord.getZoneOffset();
        Percentage percentage = oxygenSaturationRecord.getPercentage();
        Intrinsics.checkNotNullExpressionValue(percentage, "percentage");
        androidx.health.connect.client.units.Percentage sdkPercentage = UnitConvertersKt.toSdkPercentage(percentage);
        android.health.connect.datatypes.Metadata metadata = oxygenSaturationRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new OxygenSaturationRecord(time, zoneOffset, sdkPercentage, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final PowerRecord toSdkPowerRecord(android.health.connect.datatypes.PowerRecord powerRecord) {
        Instant startTime = powerRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = powerRecord.getStartZoneOffset();
        Instant endTime = powerRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = powerRecord.getEndZoneOffset();
        List<PowerRecord.PowerRecordSample> samples = powerRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        List<PowerRecord.PowerRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PowerRecord.PowerRecordSample it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkPowerRecordSample(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkPowerRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((PowerRecord.Sample) t).getTime(), ((PowerRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = powerRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.PowerRecord(startTime, startZoneOffset, endTime, endZoneOffset, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final RespiratoryRateRecord toSdkRespiratoryRateRecord(android.health.connect.datatypes.RespiratoryRateRecord respiratoryRateRecord) {
        Instant time = respiratoryRateRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = respiratoryRateRecord.getZoneOffset();
        double rate = respiratoryRateRecord.getRate();
        android.health.connect.datatypes.Metadata metadata = respiratoryRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new RespiratoryRateRecord(time, zoneOffset, rate, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final RestingHeartRateRecord toSdkRestingHeartRateRecord(android.health.connect.datatypes.RestingHeartRateRecord restingHeartRateRecord) {
        Instant time = restingHeartRateRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = restingHeartRateRecord.getZoneOffset();
        long beatsPerMinute = restingHeartRateRecord.getBeatsPerMinute();
        android.health.connect.datatypes.Metadata metadata = restingHeartRateRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new RestingHeartRateRecord(time, zoneOffset, beatsPerMinute, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final SexualActivityRecord toSdkSexualActivityRecord(android.health.connect.datatypes.SexualActivityRecord sexualActivityRecord) {
        Instant time = sexualActivityRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = sexualActivityRecord.getZoneOffset();
        int sdkProtectionUsed = IntDefMappingsKt.toSdkProtectionUsed(sexualActivityRecord.getProtectionUsed());
        android.health.connect.datatypes.Metadata metadata = sexualActivityRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new SexualActivityRecord(time, zoneOffset, sdkProtectionUsed, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final SleepSessionRecord toSdkSleepSessionRecord(android.health.connect.datatypes.SleepSessionRecord sleepSessionRecord) {
        Instant startTime = sleepSessionRecord.getStartTime();
        ZoneOffset startZoneOffset = sleepSessionRecord.getStartZoneOffset();
        Instant endTime = sleepSessionRecord.getEndTime();
        ZoneOffset endZoneOffset = sleepSessionRecord.getEndZoneOffset();
        android.health.connect.datatypes.Metadata metadata = sleepSessionRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        androidx.health.connect.client.records.metadata.Metadata sdkMetadata = MetadataConvertersKt.toSdkMetadata(metadata);
        CharSequence title = sleepSessionRecord.getTitle();
        String string = title != null ? title.toString() : null;
        CharSequence notes = sleepSessionRecord.getNotes();
        String string2 = notes != null ? notes.toString() : null;
        List<SleepSessionRecord.Stage> stages = sleepSessionRecord.getStages();
        Intrinsics.checkNotNullExpressionValue(stages, "stages");
        List<SleepSessionRecord.Stage> list = stages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SleepSessionRecord.Stage it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkSleepSessionStage(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkSleepSessionRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SleepSessionRecord.Stage) t).getStartTime(), ((SleepSessionRecord.Stage) t2).getStartTime());
            }
        });
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new androidx.health.connect.client.records.SleepSessionRecord(startTime, startZoneOffset, endTime, endZoneOffset, string, string2, listSortedWith, sdkMetadata);
    }

    private static final SpeedRecord toSdkSpeedRecord(android.health.connect.datatypes.SpeedRecord speedRecord) {
        Instant startTime = speedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = speedRecord.getStartZoneOffset();
        Instant endTime = speedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = speedRecord.getEndZoneOffset();
        List<SpeedRecord.SpeedRecordSample> samples = speedRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        List<SpeedRecord.SpeedRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SpeedRecord.SpeedRecordSample it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkSpeedSample(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkSpeedRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((SpeedRecord.Sample) t).getTime(), ((SpeedRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = speedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.SpeedRecord(startTime, startZoneOffset, endTime, endZoneOffset, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final StepsCadenceRecord toSdkStepsCadenceRecord(android.health.connect.datatypes.StepsCadenceRecord stepsCadenceRecord) {
        Instant startTime = stepsCadenceRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = stepsCadenceRecord.getStartZoneOffset();
        Instant endTime = stepsCadenceRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = stepsCadenceRecord.getEndZoneOffset();
        List<StepsCadenceRecord.StepsCadenceRecordSample> samples = stepsCadenceRecord.getSamples();
        Intrinsics.checkNotNullExpressionValue(samples, "samples");
        List<StepsCadenceRecord.StepsCadenceRecordSample> list = samples;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (StepsCadenceRecord.StepsCadenceRecordSample it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(toSdkStepsCadenceSample(it));
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.health.connect.client.impl.platform.records.RecordConvertersKt$toSdkStepsCadenceRecord$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((StepsCadenceRecord.Sample) t).getTime(), ((StepsCadenceRecord.Sample) t2).getTime());
            }
        });
        android.health.connect.datatypes.Metadata metadata = stepsCadenceRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new androidx.health.connect.client.records.StepsCadenceRecord(startTime, startZoneOffset, endTime, endZoneOffset, listSortedWith, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final StepsRecord toSdkStepsRecord(android.health.connect.datatypes.StepsRecord stepsRecord) {
        Instant startTime = stepsRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = stepsRecord.getStartZoneOffset();
        Instant endTime = stepsRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = stepsRecord.getEndZoneOffset();
        long count = stepsRecord.getCount();
        android.health.connect.datatypes.Metadata metadata = stepsRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new StepsRecord(startTime, startZoneOffset, endTime, endZoneOffset, count, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final TotalCaloriesBurnedRecord toSdkTotalCaloriesBurnedRecord(android.health.connect.datatypes.TotalCaloriesBurnedRecord totalCaloriesBurnedRecord) {
        Instant startTime = totalCaloriesBurnedRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = totalCaloriesBurnedRecord.getStartZoneOffset();
        Instant endTime = totalCaloriesBurnedRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = totalCaloriesBurnedRecord.getEndZoneOffset();
        Energy energy = totalCaloriesBurnedRecord.getEnergy();
        Intrinsics.checkNotNullExpressionValue(energy, "energy");
        androidx.health.connect.client.units.Energy sdkEnergy = UnitConvertersKt.toSdkEnergy(energy);
        android.health.connect.datatypes.Metadata metadata = totalCaloriesBurnedRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new TotalCaloriesBurnedRecord(startTime, startZoneOffset, endTime, endZoneOffset, sdkEnergy, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final Vo2MaxRecord toSdkVo2MaxRecord(android.health.connect.datatypes.Vo2MaxRecord vo2MaxRecord) {
        Instant time = vo2MaxRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = vo2MaxRecord.getZoneOffset();
        double vo2MillilitersPerMinuteKilogram = vo2MaxRecord.getVo2MillilitersPerMinuteKilogram();
        int sdkVo2MaxMeasurementMethod = IntDefMappingsKt.toSdkVo2MaxMeasurementMethod(vo2MaxRecord.getMeasurementMethod());
        android.health.connect.datatypes.Metadata metadata = vo2MaxRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new Vo2MaxRecord(time, zoneOffset, vo2MillilitersPerMinuteKilogram, sdkVo2MaxMeasurementMethod, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final WeightRecord toSdkWeightRecord(android.health.connect.datatypes.WeightRecord weightRecord) {
        Instant time = weightRecord.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        ZoneOffset zoneOffset = weightRecord.getZoneOffset();
        Mass weight = weightRecord.getWeight();
        Intrinsics.checkNotNullExpressionValue(weight, "weight");
        androidx.health.connect.client.units.Mass sdkMass = UnitConvertersKt.toSdkMass(weight);
        android.health.connect.datatypes.Metadata metadata = weightRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new WeightRecord(time, zoneOffset, sdkMass, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final WheelchairPushesRecord toWheelchairPushesRecord(android.health.connect.datatypes.WheelchairPushesRecord wheelchairPushesRecord) {
        Instant startTime = wheelchairPushesRecord.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        ZoneOffset startZoneOffset = wheelchairPushesRecord.getStartZoneOffset();
        Instant endTime = wheelchairPushesRecord.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset endZoneOffset = wheelchairPushesRecord.getEndZoneOffset();
        long count = wheelchairPushesRecord.getCount();
        android.health.connect.datatypes.Metadata metadata = wheelchairPushesRecord.getMetadata();
        Intrinsics.checkNotNullExpressionValue(metadata, "metadata");
        return new WheelchairPushesRecord(startTime, startZoneOffset, endTime, endZoneOffset, count, MetadataConvertersKt.toSdkMetadata(metadata));
    }

    private static final android.health.connect.datatypes.ActiveCaloriesBurnedRecord toPlatformActiveCaloriesBurnedRecord(ActiveCaloriesBurnedRecord activeCaloriesBurnedRecord) {
        ActiveCaloriesBurnedRecord.Builder builder = new ActiveCaloriesBurnedRecord.Builder(MetadataConvertersKt.toPlatformMetadata(activeCaloriesBurnedRecord.getMetadata()), activeCaloriesBurnedRecord.getStartTime(), activeCaloriesBurnedRecord.getEndTime(), UnitConvertersKt.toPlatformEnergy(activeCaloriesBurnedRecord.getEnergy()));
        ZoneOffset startZoneOffset = activeCaloriesBurnedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = activeCaloriesBurnedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.ActiveCaloriesBurnedRecord activeCaloriesBurnedRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(activeCaloriesBurnedRecordBuild, "PlatformActiveCaloriesBu…       }\n        .build()");
        return activeCaloriesBurnedRecordBuild;
    }

    private static final android.health.connect.datatypes.BasalBodyTemperatureRecord toPlatformBasalBodyTemperatureRecord(BasalBodyTemperatureRecord basalBodyTemperatureRecord) {
        BasalBodyTemperatureRecord.Builder builder = new BasalBodyTemperatureRecord.Builder(MetadataConvertersKt.toPlatformMetadata(basalBodyTemperatureRecord.getMetadata()), basalBodyTemperatureRecord.getTime(), IntDefMappingsKt.toPlatformBodyTemperatureMeasurementLocation(basalBodyTemperatureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformTemperature(basalBodyTemperatureRecord.getTemperature()));
        ZoneOffset zoneOffset = basalBodyTemperatureRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BasalBodyTemperatureRecord basalBodyTemperatureRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(basalBodyTemperatureRecordBuild, "PlatformBasalBodyTempera…(it) } }\n        .build()");
        return basalBodyTemperatureRecordBuild;
    }

    private static final android.health.connect.datatypes.BasalMetabolicRateRecord toPlatformBasalMetabolicRateRecord(BasalMetabolicRateRecord basalMetabolicRateRecord) {
        BasalMetabolicRateRecord.Builder builder = new BasalMetabolicRateRecord.Builder(MetadataConvertersKt.toPlatformMetadata(basalMetabolicRateRecord.getMetadata()), basalMetabolicRateRecord.getTime(), UnitConvertersKt.toPlatformPower(basalMetabolicRateRecord.getBasalMetabolicRate()));
        ZoneOffset zoneOffset = basalMetabolicRateRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BasalMetabolicRateRecord basalMetabolicRateRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(basalMetabolicRateRecordBuild, "PlatformBasalMetabolicRa…(it) } }\n        .build()");
        return basalMetabolicRateRecordBuild;
    }

    private static final android.health.connect.datatypes.BloodGlucoseRecord toPlatformBloodGlucoseRecord(BloodGlucoseRecord bloodGlucoseRecord) {
        BloodGlucoseRecord.Builder builder = new BloodGlucoseRecord.Builder(MetadataConvertersKt.toPlatformMetadata(bloodGlucoseRecord.getMetadata()), bloodGlucoseRecord.getTime(), IntDefMappingsKt.toPlatformBloodGlucoseSpecimenSource(bloodGlucoseRecord.getSpecimenSource()), UnitConvertersKt.toPlatformBloodGlucose(bloodGlucoseRecord.getLevel()), IntDefMappingsKt.toPlatformBloodGlucoseRelationToMeal(bloodGlucoseRecord.getRelationToMeal()), IntDefMappingsKt.toPlatformMealType(bloodGlucoseRecord.getMealType()));
        ZoneOffset zoneOffset = bloodGlucoseRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BloodGlucoseRecord bloodGlucoseRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(bloodGlucoseRecordBuild, "PlatformBloodGlucoseReco…(it) } }\n        .build()");
        return bloodGlucoseRecordBuild;
    }

    private static final android.health.connect.datatypes.BloodPressureRecord toPlatformBloodPressureRecord(BloodPressureRecord bloodPressureRecord) {
        BloodPressureRecord.Builder builder = new BloodPressureRecord.Builder(MetadataConvertersKt.toPlatformMetadata(bloodPressureRecord.getMetadata()), bloodPressureRecord.getTime(), IntDefMappingsKt.toPlatformBloodPressureMeasurementLocation(bloodPressureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformPressure(bloodPressureRecord.getSystolic()), UnitConvertersKt.toPlatformPressure(bloodPressureRecord.getDiastolic()), IntDefMappingsKt.toPlatformBloodPressureBodyPosition(bloodPressureRecord.getBodyPosition()));
        ZoneOffset zoneOffset = bloodPressureRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BloodPressureRecord bloodPressureRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(bloodPressureRecordBuild, "PlatformBloodPressureRec…(it) } }\n        .build()");
        return bloodPressureRecordBuild;
    }

    private static final android.health.connect.datatypes.BodyFatRecord toPlatformBodyFatRecord(BodyFatRecord bodyFatRecord) {
        BodyFatRecord.Builder builder = new BodyFatRecord.Builder(MetadataConvertersKt.toPlatformMetadata(bodyFatRecord.getMetadata()), bodyFatRecord.getTime(), UnitConvertersKt.toPlatformPercentage(bodyFatRecord.getPercentage()));
        ZoneOffset zoneOffset = bodyFatRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BodyFatRecord bodyFatRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(bodyFatRecordBuild, "PlatformBodyFatRecordBui…(it) } }\n        .build()");
        return bodyFatRecordBuild;
    }

    private static final android.health.connect.datatypes.BodyTemperatureRecord toPlatformBodyTemperatureRecord(BodyTemperatureRecord bodyTemperatureRecord) {
        BodyTemperatureRecord.Builder builder = new BodyTemperatureRecord.Builder(MetadataConvertersKt.toPlatformMetadata(bodyTemperatureRecord.getMetadata()), bodyTemperatureRecord.getTime(), IntDefMappingsKt.toPlatformBodyTemperatureMeasurementLocation(bodyTemperatureRecord.getMeasurementLocation()), UnitConvertersKt.toPlatformTemperature(bodyTemperatureRecord.getTemperature()));
        ZoneOffset zoneOffset = bodyTemperatureRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BodyTemperatureRecord bodyTemperatureRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(bodyTemperatureRecordBuild, "PlatformBodyTemperatureR…(it) } }\n        .build()");
        return bodyTemperatureRecordBuild;
    }

    private static final android.health.connect.datatypes.BodyWaterMassRecord toPlatformBodyWaterMassRecord(BodyWaterMassRecord bodyWaterMassRecord) {
        BodyWaterMassRecord.Builder builder = new BodyWaterMassRecord.Builder(MetadataConvertersKt.toPlatformMetadata(bodyWaterMassRecord.getMetadata()), bodyWaterMassRecord.getTime(), UnitConvertersKt.toPlatformMass(bodyWaterMassRecord.getMass()));
        ZoneOffset zoneOffset = bodyWaterMassRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BodyWaterMassRecord bodyWaterMassRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(bodyWaterMassRecordBuild, "PlatformBodyWaterMassRec…(it) } }\n        .build()");
        return bodyWaterMassRecordBuild;
    }

    private static final android.health.connect.datatypes.BoneMassRecord toPlatformBoneMassRecord(BoneMassRecord boneMassRecord) {
        BoneMassRecord.Builder builder = new BoneMassRecord.Builder(MetadataConvertersKt.toPlatformMetadata(boneMassRecord.getMetadata()), boneMassRecord.getTime(), UnitConvertersKt.toPlatformMass(boneMassRecord.getMass()));
        ZoneOffset zoneOffset = boneMassRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.BoneMassRecord boneMassRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(boneMassRecordBuild, "PlatformBoneMassRecordBu…(it) } }\n        .build()");
        return boneMassRecordBuild;
    }

    private static final android.health.connect.datatypes.CervicalMucusRecord toPlatformCervicalMucusRecord(CervicalMucusRecord cervicalMucusRecord) {
        CervicalMucusRecord.Builder builder = new CervicalMucusRecord.Builder(MetadataConvertersKt.toPlatformMetadata(cervicalMucusRecord.getMetadata()), cervicalMucusRecord.getTime(), IntDefMappingsKt.toPlatformCervicalMucusSensation(cervicalMucusRecord.getSensation()), IntDefMappingsKt.toPlatformCervicalMucusAppearance(cervicalMucusRecord.getAppearance()));
        ZoneOffset zoneOffset = cervicalMucusRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.CervicalMucusRecord cervicalMucusRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(cervicalMucusRecordBuild, "PlatformCervicalMucusRec…(it) } }\n        .build()");
        return cervicalMucusRecordBuild;
    }

    private static final android.health.connect.datatypes.CyclingPedalingCadenceRecord toPlatformCyclingPedalingCadenceRecord(androidx.health.connect.client.records.CyclingPedalingCadenceRecord cyclingPedalingCadenceRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(cyclingPedalingCadenceRecord.getMetadata());
        Instant startTime = cyclingPedalingCadenceRecord.getStartTime();
        Instant endTime = cyclingPedalingCadenceRecord.getEndTime();
        List<CyclingPedalingCadenceRecord.Sample> samples = cyclingPedalingCadenceRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformCyclingPedalingCadenceSample((CyclingPedalingCadenceRecord.Sample) it.next()));
        }
        CyclingPedalingCadenceRecord.Builder builder = new CyclingPedalingCadenceRecord.Builder(platformMetadata, startTime, endTime, arrayList);
        ZoneOffset startZoneOffset = cyclingPedalingCadenceRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = cyclingPedalingCadenceRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.CyclingPedalingCadenceRecord cyclingPedalingCadenceRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(cyclingPedalingCadenceRecordBuild, "PlatformCyclingPedalingC…       }\n        .build()");
        return cyclingPedalingCadenceRecordBuild;
    }

    private static final CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample toPlatformCyclingPedalingCadenceSample(CyclingPedalingCadenceRecord.Sample sample) {
        return new CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample(sample.getRevolutionsPerMinute(), sample.getTime());
    }

    private static final android.health.connect.datatypes.DistanceRecord toPlatformDistanceRecord(DistanceRecord distanceRecord) {
        DistanceRecord.Builder builder = new DistanceRecord.Builder(MetadataConvertersKt.toPlatformMetadata(distanceRecord.getMetadata()), distanceRecord.getStartTime(), distanceRecord.getEndTime(), UnitConvertersKt.toPlatformLength(distanceRecord.getDistance()));
        ZoneOffset startZoneOffset = distanceRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = distanceRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.DistanceRecord distanceRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(distanceRecordBuild, "PlatformDistanceRecordBu…       }\n        .build()");
        return distanceRecordBuild;
    }

    private static final android.health.connect.datatypes.ElevationGainedRecord toPlatformElevationGainedRecord(ElevationGainedRecord elevationGainedRecord) {
        ElevationGainedRecord.Builder builder = new ElevationGainedRecord.Builder(MetadataConvertersKt.toPlatformMetadata(elevationGainedRecord.getMetadata()), elevationGainedRecord.getStartTime(), elevationGainedRecord.getEndTime(), UnitConvertersKt.toPlatformLength(elevationGainedRecord.getElevation()));
        ZoneOffset startZoneOffset = elevationGainedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = elevationGainedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.ElevationGainedRecord elevationGainedRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(elevationGainedRecordBuild, "PlatformElevationGainedR…       }\n        .build()");
        return elevationGainedRecordBuild;
    }

    private static final android.health.connect.datatypes.ExerciseSessionRecord toPlatformExerciseSessionRecord(ExerciseSessionRecord exerciseSessionRecord) {
        ExerciseSessionRecord.Builder builder = new ExerciseSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(exerciseSessionRecord.getMetadata()), exerciseSessionRecord.getStartTime(), exerciseSessionRecord.getEndTime(), IntDefMappingsKt.toPlatformExerciseSessionType(exerciseSessionRecord.getExerciseType()));
        ZoneOffset startZoneOffset = exerciseSessionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = exerciseSessionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        String notes = exerciseSessionRecord.getNotes();
        if (notes != null) {
            builder.setNotes(notes);
        }
        String title = exerciseSessionRecord.getTitle();
        if (title != null) {
            builder.setTitle(title);
        }
        List<androidx.health.connect.client.records.ExerciseLap> laps = exerciseSessionRecord.getLaps();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(laps, 10));
        Iterator<T> it = laps.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformExerciseLap((androidx.health.connect.client.records.ExerciseLap) it.next()));
        }
        builder.setLaps(arrayList);
        List<androidx.health.connect.client.records.ExerciseSegment> segments = exerciseSessionRecord.getSegments();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(segments, 10));
        Iterator<T> it2 = segments.iterator();
        while (it2.hasNext()) {
            arrayList2.add(toPlatformExerciseSegment((androidx.health.connect.client.records.ExerciseSegment) it2.next()));
        }
        builder.setSegments(arrayList2);
        if (exerciseSessionRecord.getExerciseRouteResult() instanceof ExerciseRouteResult.Data) {
            builder.setRoute(toPlatformExerciseRoute(((ExerciseRouteResult.Data) exerciseSessionRecord.getExerciseRouteResult()).getExerciseRoute()));
        }
        android.health.connect.datatypes.ExerciseSessionRecord exerciseSessionRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(exerciseSessionRecordBuild, "PlatformExerciseSessionR…       }\n        .build()");
        return exerciseSessionRecordBuild;
    }

    private static final ExerciseLap toPlatformExerciseLap(androidx.health.connect.client.records.ExerciseLap exerciseLap) {
        ExerciseLap.Builder builder = new ExerciseLap.Builder(exerciseLap.getStartTime(), exerciseLap.getEndTime());
        androidx.health.connect.client.units.Length length = exerciseLap.getLength();
        if (length != null) {
            builder.setLength(UnitConvertersKt.toPlatformLength(length));
        }
        ExerciseLap exerciseLapBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(exerciseLapBuild, "PlatformExerciseLapBuild…h()) } }\n        .build()");
        return exerciseLapBuild;
    }

    private static final ExerciseRoute toPlatformExerciseRoute(androidx.health.connect.client.records.ExerciseRoute exerciseRoute) {
        List<ExerciseRoute.Location> route = exerciseRoute.getRoute();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(route, 10));
        for (ExerciseRoute.Location location : route) {
            ExerciseRoute.Location.Builder builder = new ExerciseRoute.Location.Builder(location.getTime(), location.getLatitude(), location.getLongitude());
            androidx.health.connect.client.units.Length horizontalAccuracy = location.getHorizontalAccuracy();
            if (horizontalAccuracy != null) {
                builder.setHorizontalAccuracy(UnitConvertersKt.toPlatformLength(horizontalAccuracy));
            }
            androidx.health.connect.client.units.Length verticalAccuracy = location.getVerticalAccuracy();
            if (verticalAccuracy != null) {
                builder.setVerticalAccuracy(UnitConvertersKt.toPlatformLength(verticalAccuracy));
            }
            androidx.health.connect.client.units.Length altitude = location.getAltitude();
            if (altitude != null) {
                builder.setAltitude(UnitConvertersKt.toPlatformLength(altitude));
            }
            arrayList.add(builder.build());
        }
        return new android.health.connect.datatypes.ExerciseRoute(arrayList);
    }

    private static final ExerciseSegment toPlatformExerciseSegment(androidx.health.connect.client.records.ExerciseSegment exerciseSegment) {
        ExerciseSegment exerciseSegmentBuild = new ExerciseSegment.Builder(exerciseSegment.getStartTime(), exerciseSegment.getEndTime(), IntDefMappingsKt.toPlatformExerciseSegmentType(exerciseSegment.getSegmentType())).setRepetitionsCount(exerciseSegment.getRepetitions()).build();
        Intrinsics.checkNotNullExpressionValue(exerciseSegmentBuild, "PlatformExerciseSegmentB…titions)\n        .build()");
        return exerciseSegmentBuild;
    }

    private static final android.health.connect.datatypes.FloorsClimbedRecord toPlatformFloorsClimbedRecord(FloorsClimbedRecord floorsClimbedRecord) {
        FloorsClimbedRecord.Builder builder = new FloorsClimbedRecord.Builder(MetadataConvertersKt.toPlatformMetadata(floorsClimbedRecord.getMetadata()), floorsClimbedRecord.getStartTime(), floorsClimbedRecord.getEndTime(), floorsClimbedRecord.getFloors());
        ZoneOffset startZoneOffset = floorsClimbedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = floorsClimbedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.FloorsClimbedRecord floorsClimbedRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(floorsClimbedRecordBuild, "PlatformFloorsClimbedRec…       }\n        .build()");
        return floorsClimbedRecordBuild;
    }

    private static final android.health.connect.datatypes.HeartRateRecord toPlatformHeartRateRecord(androidx.health.connect.client.records.HeartRateRecord heartRateRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(heartRateRecord.getMetadata());
        Instant startTime = heartRateRecord.getStartTime();
        Instant endTime = heartRateRecord.getEndTime();
        List<HeartRateRecord.Sample> samples = heartRateRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformHeartRateSample((HeartRateRecord.Sample) it.next()));
        }
        HeartRateRecord.Builder builder = new HeartRateRecord.Builder(platformMetadata, startTime, endTime, arrayList);
        ZoneOffset startZoneOffset = heartRateRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = heartRateRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.HeartRateRecord heartRateRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(heartRateRecordBuild, "PlatformHeartRateRecordB…       }\n        .build()");
        return heartRateRecordBuild;
    }

    private static final HeartRateRecord.HeartRateSample toPlatformHeartRateSample(HeartRateRecord.Sample sample) {
        return new HeartRateRecord.HeartRateSample(sample.getBeatsPerMinute(), sample.getTime());
    }

    private static final android.health.connect.datatypes.HeartRateVariabilityRmssdRecord toPlatformHeartRateVariabilityRmssdRecord(HeartRateVariabilityRmssdRecord heartRateVariabilityRmssdRecord) {
        HeartRateVariabilityRmssdRecord.Builder builder = new HeartRateVariabilityRmssdRecord.Builder(MetadataConvertersKt.toPlatformMetadata(heartRateVariabilityRmssdRecord.getMetadata()), heartRateVariabilityRmssdRecord.getTime(), heartRateVariabilityRmssdRecord.getHeartRateVariabilityMillis());
        ZoneOffset zoneOffset = heartRateVariabilityRmssdRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.HeartRateVariabilityRmssdRecord heartRateVariabilityRmssdRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(heartRateVariabilityRmssdRecordBuild, "PlatformHeartRateVariabi…(it) } }\n        .build()");
        return heartRateVariabilityRmssdRecordBuild;
    }

    private static final android.health.connect.datatypes.HeightRecord toPlatformHeightRecord(HeightRecord heightRecord) {
        HeightRecord.Builder builder = new HeightRecord.Builder(MetadataConvertersKt.toPlatformMetadata(heightRecord.getMetadata()), heightRecord.getTime(), UnitConvertersKt.toPlatformLength(heightRecord.getHeight()));
        ZoneOffset zoneOffset = heightRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.HeightRecord heightRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(heightRecordBuild, "PlatformHeightRecordBuil…(it) } }\n        .build()");
        return heightRecordBuild;
    }

    private static final android.health.connect.datatypes.HydrationRecord toPlatformHydrationRecord(HydrationRecord hydrationRecord) {
        HydrationRecord.Builder builder = new HydrationRecord.Builder(MetadataConvertersKt.toPlatformMetadata(hydrationRecord.getMetadata()), hydrationRecord.getStartTime(), hydrationRecord.getEndTime(), UnitConvertersKt.toPlatformVolume(hydrationRecord.getVolume()));
        ZoneOffset startZoneOffset = hydrationRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = hydrationRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.HydrationRecord hydrationRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(hydrationRecordBuild, "PlatformHydrationRecordB…       }\n        .build()");
        return hydrationRecordBuild;
    }

    private static final android.health.connect.datatypes.IntermenstrualBleedingRecord toPlatformIntermenstrualBleedingRecord(IntermenstrualBleedingRecord intermenstrualBleedingRecord) {
        IntermenstrualBleedingRecord.Builder builder = new IntermenstrualBleedingRecord.Builder(MetadataConvertersKt.toPlatformMetadata(intermenstrualBleedingRecord.getMetadata()), intermenstrualBleedingRecord.getTime());
        ZoneOffset zoneOffset = intermenstrualBleedingRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.IntermenstrualBleedingRecord intermenstrualBleedingRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(intermenstrualBleedingRecordBuild, "PlatformIntermenstrualBl…(it) } }\n        .build()");
        return intermenstrualBleedingRecordBuild;
    }

    private static final android.health.connect.datatypes.LeanBodyMassRecord toPlatformLeanBodyMassRecord(LeanBodyMassRecord leanBodyMassRecord) {
        LeanBodyMassRecord.Builder builder = new LeanBodyMassRecord.Builder(MetadataConvertersKt.toPlatformMetadata(leanBodyMassRecord.getMetadata()), leanBodyMassRecord.getTime(), UnitConvertersKt.toPlatformMass(leanBodyMassRecord.getMass()));
        ZoneOffset zoneOffset = leanBodyMassRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.LeanBodyMassRecord leanBodyMassRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(leanBodyMassRecordBuild, "PlatformLeanBodyMassReco…(it) } }\n        .build()");
        return leanBodyMassRecordBuild;
    }

    private static final android.health.connect.datatypes.MenstruationFlowRecord toPlatformMenstruationFlowRecord(MenstruationFlowRecord menstruationFlowRecord) {
        MenstruationFlowRecord.Builder builder = new MenstruationFlowRecord.Builder(MetadataConvertersKt.toPlatformMetadata(menstruationFlowRecord.getMetadata()), menstruationFlowRecord.getTime(), IntDefMappingsKt.toPlatformMenstruationFlow(menstruationFlowRecord.getFlow()));
        ZoneOffset zoneOffset = menstruationFlowRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.MenstruationFlowRecord menstruationFlowRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(menstruationFlowRecordBuild, "PlatformMenstruationFlow…(it) } }\n        .build()");
        return menstruationFlowRecordBuild;
    }

    private static final android.health.connect.datatypes.MenstruationPeriodRecord toPlatformMenstruationPeriodRecord(MenstruationPeriodRecord menstruationPeriodRecord) {
        MenstruationPeriodRecord.Builder builder = new MenstruationPeriodRecord.Builder(MetadataConvertersKt.toPlatformMetadata(menstruationPeriodRecord.getMetadata()), menstruationPeriodRecord.getStartTime(), menstruationPeriodRecord.getEndTime());
        ZoneOffset startZoneOffset = menstruationPeriodRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = menstruationPeriodRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.MenstruationPeriodRecord menstruationPeriodRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(menstruationPeriodRecordBuild, "PlatformMenstruationPeri…       }\n        .build()");
        return menstruationPeriodRecordBuild;
    }

    private static final android.health.connect.datatypes.NutritionRecord toPlatformNutritionRecord(NutritionRecord nutritionRecord) {
        NutritionRecord.Builder mealType = new NutritionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(nutritionRecord.getMetadata()), nutritionRecord.getStartTime(), nutritionRecord.getEndTime()).setMealType(IntDefMappingsKt.toPlatformMealType(nutritionRecord.getMealType()));
        ZoneOffset startZoneOffset = nutritionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            mealType.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = nutritionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            mealType.setEndZoneOffset(endZoneOffset);
        }
        androidx.health.connect.client.units.Mass biotin = nutritionRecord.getBiotin();
        if (biotin != null) {
            mealType.setBiotin(UnitConvertersKt.toPlatformMass(biotin));
        }
        androidx.health.connect.client.units.Mass caffeine = nutritionRecord.getCaffeine();
        if (caffeine != null) {
            mealType.setCaffeine(UnitConvertersKt.toPlatformMass(caffeine));
        }
        androidx.health.connect.client.units.Mass calcium = nutritionRecord.getCalcium();
        if (calcium != null) {
            mealType.setCalcium(UnitConvertersKt.toPlatformMass(calcium));
        }
        androidx.health.connect.client.units.Mass chloride = nutritionRecord.getChloride();
        if (chloride != null) {
            mealType.setChloride(UnitConvertersKt.toPlatformMass(chloride));
        }
        androidx.health.connect.client.units.Mass cholesterol = nutritionRecord.getCholesterol();
        if (cholesterol != null) {
            mealType.setCholesterol(UnitConvertersKt.toPlatformMass(cholesterol));
        }
        androidx.health.connect.client.units.Mass chromium = nutritionRecord.getChromium();
        if (chromium != null) {
            mealType.setChromium(UnitConvertersKt.toPlatformMass(chromium));
        }
        androidx.health.connect.client.units.Mass copper = nutritionRecord.getCopper();
        if (copper != null) {
            mealType.setCopper(UnitConvertersKt.toPlatformMass(copper));
        }
        androidx.health.connect.client.units.Mass dietaryFiber = nutritionRecord.getDietaryFiber();
        if (dietaryFiber != null) {
            mealType.setDietaryFiber(UnitConvertersKt.toPlatformMass(dietaryFiber));
        }
        androidx.health.connect.client.units.Energy energy = nutritionRecord.getEnergy();
        if (energy != null) {
            mealType.setEnergy(UnitConvertersKt.toPlatformEnergy(energy));
        }
        androidx.health.connect.client.units.Energy energyFromFat = nutritionRecord.getEnergyFromFat();
        if (energyFromFat != null) {
            mealType.setEnergyFromFat(UnitConvertersKt.toPlatformEnergy(energyFromFat));
        }
        androidx.health.connect.client.units.Mass folate = nutritionRecord.getFolate();
        if (folate != null) {
            mealType.setFolate(UnitConvertersKt.toPlatformMass(folate));
        }
        androidx.health.connect.client.units.Mass folicAcid = nutritionRecord.getFolicAcid();
        if (folicAcid != null) {
            mealType.setFolicAcid(UnitConvertersKt.toPlatformMass(folicAcid));
        }
        androidx.health.connect.client.units.Mass iodine = nutritionRecord.getIodine();
        if (iodine != null) {
            mealType.setIodine(UnitConvertersKt.toPlatformMass(iodine));
        }
        androidx.health.connect.client.units.Mass iron = nutritionRecord.getIron();
        if (iron != null) {
            mealType.setIron(UnitConvertersKt.toPlatformMass(iron));
        }
        androidx.health.connect.client.units.Mass magnesium = nutritionRecord.getMagnesium();
        if (magnesium != null) {
            mealType.setMagnesium(UnitConvertersKt.toPlatformMass(magnesium));
        }
        androidx.health.connect.client.units.Mass manganese = nutritionRecord.getManganese();
        if (manganese != null) {
            mealType.setManganese(UnitConvertersKt.toPlatformMass(manganese));
        }
        androidx.health.connect.client.units.Mass molybdenum = nutritionRecord.getMolybdenum();
        if (molybdenum != null) {
            mealType.setMolybdenum(UnitConvertersKt.toPlatformMass(molybdenum));
        }
        androidx.health.connect.client.units.Mass monounsaturatedFat = nutritionRecord.getMonounsaturatedFat();
        if (monounsaturatedFat != null) {
            mealType.setMonounsaturatedFat(UnitConvertersKt.toPlatformMass(monounsaturatedFat));
        }
        String name = nutritionRecord.getName();
        if (name != null) {
            mealType.setMealName(name);
        }
        androidx.health.connect.client.units.Mass niacin = nutritionRecord.getNiacin();
        if (niacin != null) {
            mealType.setNiacin(UnitConvertersKt.toPlatformMass(niacin));
        }
        androidx.health.connect.client.units.Mass pantothenicAcid = nutritionRecord.getPantothenicAcid();
        if (pantothenicAcid != null) {
            mealType.setPantothenicAcid(UnitConvertersKt.toPlatformMass(pantothenicAcid));
        }
        androidx.health.connect.client.units.Mass phosphorus = nutritionRecord.getPhosphorus();
        if (phosphorus != null) {
            mealType.setPhosphorus(UnitConvertersKt.toPlatformMass(phosphorus));
        }
        androidx.health.connect.client.units.Mass polyunsaturatedFat = nutritionRecord.getPolyunsaturatedFat();
        if (polyunsaturatedFat != null) {
            mealType.setPolyunsaturatedFat(UnitConvertersKt.toPlatformMass(polyunsaturatedFat));
        }
        androidx.health.connect.client.units.Mass potassium = nutritionRecord.getPotassium();
        if (potassium != null) {
            mealType.setPotassium(UnitConvertersKt.toPlatformMass(potassium));
        }
        androidx.health.connect.client.units.Mass protein = nutritionRecord.getProtein();
        if (protein != null) {
            mealType.setProtein(UnitConvertersKt.toPlatformMass(protein));
        }
        androidx.health.connect.client.units.Mass riboflavin = nutritionRecord.getRiboflavin();
        if (riboflavin != null) {
            mealType.setRiboflavin(UnitConvertersKt.toPlatformMass(riboflavin));
        }
        androidx.health.connect.client.units.Mass saturatedFat = nutritionRecord.getSaturatedFat();
        if (saturatedFat != null) {
            mealType.setSaturatedFat(UnitConvertersKt.toPlatformMass(saturatedFat));
        }
        androidx.health.connect.client.units.Mass selenium = nutritionRecord.getSelenium();
        if (selenium != null) {
            mealType.setSelenium(UnitConvertersKt.toPlatformMass(selenium));
        }
        androidx.health.connect.client.units.Mass sodium = nutritionRecord.getSodium();
        if (sodium != null) {
            mealType.setSodium(UnitConvertersKt.toPlatformMass(sodium));
        }
        androidx.health.connect.client.units.Mass sugar = nutritionRecord.getSugar();
        if (sugar != null) {
            mealType.setSugar(UnitConvertersKt.toPlatformMass(sugar));
        }
        androidx.health.connect.client.units.Mass thiamin = nutritionRecord.getThiamin();
        if (thiamin != null) {
            mealType.setThiamin(UnitConvertersKt.toPlatformMass(thiamin));
        }
        androidx.health.connect.client.units.Mass totalCarbohydrate = nutritionRecord.getTotalCarbohydrate();
        if (totalCarbohydrate != null) {
            mealType.setTotalCarbohydrate(UnitConvertersKt.toPlatformMass(totalCarbohydrate));
        }
        androidx.health.connect.client.units.Mass totalFat = nutritionRecord.getTotalFat();
        if (totalFat != null) {
            mealType.setTotalFat(UnitConvertersKt.toPlatformMass(totalFat));
        }
        androidx.health.connect.client.units.Mass transFat = nutritionRecord.getTransFat();
        if (transFat != null) {
            mealType.setTransFat(UnitConvertersKt.toPlatformMass(transFat));
        }
        androidx.health.connect.client.units.Mass unsaturatedFat = nutritionRecord.getUnsaturatedFat();
        if (unsaturatedFat != null) {
            mealType.setUnsaturatedFat(UnitConvertersKt.toPlatformMass(unsaturatedFat));
        }
        androidx.health.connect.client.units.Mass vitaminA = nutritionRecord.getVitaminA();
        if (vitaminA != null) {
            mealType.setVitaminA(UnitConvertersKt.toPlatformMass(vitaminA));
        }
        androidx.health.connect.client.units.Mass vitaminB6 = nutritionRecord.getVitaminB6();
        if (vitaminB6 != null) {
            mealType.setVitaminB6(UnitConvertersKt.toPlatformMass(vitaminB6));
        }
        androidx.health.connect.client.units.Mass vitaminB12 = nutritionRecord.getVitaminB12();
        if (vitaminB12 != null) {
            mealType.setVitaminB12(UnitConvertersKt.toPlatformMass(vitaminB12));
        }
        androidx.health.connect.client.units.Mass vitaminC = nutritionRecord.getVitaminC();
        if (vitaminC != null) {
            mealType.setVitaminC(UnitConvertersKt.toPlatformMass(vitaminC));
        }
        androidx.health.connect.client.units.Mass vitaminD = nutritionRecord.getVitaminD();
        if (vitaminD != null) {
            mealType.setVitaminD(UnitConvertersKt.toPlatformMass(vitaminD));
        }
        androidx.health.connect.client.units.Mass vitaminE = nutritionRecord.getVitaminE();
        if (vitaminE != null) {
            mealType.setVitaminE(UnitConvertersKt.toPlatformMass(vitaminE));
        }
        androidx.health.connect.client.units.Mass vitaminK = nutritionRecord.getVitaminK();
        if (vitaminK != null) {
            mealType.setVitaminK(UnitConvertersKt.toPlatformMass(vitaminK));
        }
        androidx.health.connect.client.units.Mass zinc = nutritionRecord.getZinc();
        if (zinc != null) {
            mealType.setZinc(UnitConvertersKt.toPlatformMass(zinc));
        }
        android.health.connect.datatypes.NutritionRecord nutritionRecordBuild = mealType.build();
        Intrinsics.checkNotNullExpressionValue(nutritionRecordBuild, "PlatformNutritionRecordB…       }\n        .build()");
        return nutritionRecordBuild;
    }

    private static final android.health.connect.datatypes.OvulationTestRecord toPlatformOvulationTestRecord(OvulationTestRecord ovulationTestRecord) {
        OvulationTestRecord.Builder builder = new OvulationTestRecord.Builder(MetadataConvertersKt.toPlatformMetadata(ovulationTestRecord.getMetadata()), ovulationTestRecord.getTime(), IntDefMappingsKt.toPlatformOvulationTestResult(ovulationTestRecord.getResult()));
        ZoneOffset zoneOffset = ovulationTestRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.OvulationTestRecord ovulationTestRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(ovulationTestRecordBuild, "PlatformOvulationTestRec…(it) } }\n        .build()");
        return ovulationTestRecordBuild;
    }

    private static final android.health.connect.datatypes.OxygenSaturationRecord toPlatformOxygenSaturationRecord(OxygenSaturationRecord oxygenSaturationRecord) {
        OxygenSaturationRecord.Builder builder = new OxygenSaturationRecord.Builder(MetadataConvertersKt.toPlatformMetadata(oxygenSaturationRecord.getMetadata()), oxygenSaturationRecord.getTime(), UnitConvertersKt.toPlatformPercentage(oxygenSaturationRecord.getPercentage()));
        ZoneOffset zoneOffset = oxygenSaturationRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.OxygenSaturationRecord oxygenSaturationRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(oxygenSaturationRecordBuild, "PlatformOxygenSaturation…(it) } }\n        .build()");
        return oxygenSaturationRecordBuild;
    }

    private static final android.health.connect.datatypes.PowerRecord toPlatformPowerRecord(androidx.health.connect.client.records.PowerRecord powerRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(powerRecord.getMetadata());
        Instant startTime = powerRecord.getStartTime();
        Instant endTime = powerRecord.getEndTime();
        List<PowerRecord.Sample> samples = powerRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformPowerRecordSample((PowerRecord.Sample) it.next()));
        }
        PowerRecord.Builder builder = new PowerRecord.Builder(platformMetadata, startTime, endTime, arrayList);
        ZoneOffset startZoneOffset = powerRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = powerRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.PowerRecord powerRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(powerRecordBuild, "PlatformPowerRecordBuild…       }\n        .build()");
        return powerRecordBuild;
    }

    private static final PowerRecord.PowerRecordSample toPlatformPowerRecordSample(PowerRecord.Sample sample) {
        return new PowerRecord.PowerRecordSample(UnitConvertersKt.toPlatformPower(sample.getPower()), sample.getTime());
    }

    private static final android.health.connect.datatypes.RespiratoryRateRecord toPlatformRespiratoryRateRecord(RespiratoryRateRecord respiratoryRateRecord) {
        RespiratoryRateRecord.Builder builder = new RespiratoryRateRecord.Builder(MetadataConvertersKt.toPlatformMetadata(respiratoryRateRecord.getMetadata()), respiratoryRateRecord.getTime(), respiratoryRateRecord.getRate());
        ZoneOffset zoneOffset = respiratoryRateRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.RespiratoryRateRecord respiratoryRateRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(respiratoryRateRecordBuild, "PlatformRespiratoryRateR…(it) } }\n        .build()");
        return respiratoryRateRecordBuild;
    }

    private static final android.health.connect.datatypes.RestingHeartRateRecord toPlatformRestingHeartRateRecord(RestingHeartRateRecord restingHeartRateRecord) {
        RestingHeartRateRecord.Builder builder = new RestingHeartRateRecord.Builder(MetadataConvertersKt.toPlatformMetadata(restingHeartRateRecord.getMetadata()), restingHeartRateRecord.getTime(), restingHeartRateRecord.getBeatsPerMinute());
        ZoneOffset zoneOffset = restingHeartRateRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.RestingHeartRateRecord restingHeartRateRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(restingHeartRateRecordBuild, "PlatformRestingHeartRate…(it) } }\n        .build()");
        return restingHeartRateRecordBuild;
    }

    private static final android.health.connect.datatypes.SexualActivityRecord toPlatformSexualActivityRecord(SexualActivityRecord sexualActivityRecord) {
        SexualActivityRecord.Builder builder = new SexualActivityRecord.Builder(MetadataConvertersKt.toPlatformMetadata(sexualActivityRecord.getMetadata()), sexualActivityRecord.getTime(), IntDefMappingsKt.toPlatformSexualActivityProtectionUsed(sexualActivityRecord.getProtectionUsed()));
        ZoneOffset zoneOffset = sexualActivityRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.SexualActivityRecord sexualActivityRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(sexualActivityRecordBuild, "PlatformSexualActivityRe…(it) } }\n        .build()");
        return sexualActivityRecordBuild;
    }

    private static final android.health.connect.datatypes.SleepSessionRecord toPlatformSleepSessionRecord(androidx.health.connect.client.records.SleepSessionRecord sleepSessionRecord) {
        SleepSessionRecord.Builder builder = new SleepSessionRecord.Builder(MetadataConvertersKt.toPlatformMetadata(sleepSessionRecord.getMetadata()), sleepSessionRecord.getStartTime(), sleepSessionRecord.getEndTime());
        ZoneOffset startZoneOffset = sleepSessionRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = sleepSessionRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        String notes = sleepSessionRecord.getNotes();
        if (notes != null) {
            builder.setNotes(notes);
        }
        String title = sleepSessionRecord.getTitle();
        if (title != null) {
            builder.setTitle(title);
        }
        List<SleepSessionRecord.Stage> stages = sleepSessionRecord.getStages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stages, 10));
        Iterator<T> it = stages.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformSleepSessionStage((SleepSessionRecord.Stage) it.next()));
        }
        builder.setStages(arrayList);
        android.health.connect.datatypes.SleepSessionRecord sleepSessionRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(sleepSessionRecordBuild, "PlatformSleepSessionReco…       }\n        .build()");
        return sleepSessionRecordBuild;
    }

    private static final SleepSessionRecord.Stage toPlatformSleepSessionStage(SleepSessionRecord.Stage stage) {
        return new SleepSessionRecord.Stage(stage.getStartTime(), stage.getEndTime(), IntDefMappingsKt.toPlatformSleepStageType(stage.getStage()));
    }

    private static final android.health.connect.datatypes.SpeedRecord toPlatformSpeedRecord(androidx.health.connect.client.records.SpeedRecord speedRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(speedRecord.getMetadata());
        Instant startTime = speedRecord.getStartTime();
        Instant endTime = speedRecord.getEndTime();
        List<SpeedRecord.Sample> samples = speedRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformSpeedRecordSample((SpeedRecord.Sample) it.next()));
        }
        SpeedRecord.Builder builder = new SpeedRecord.Builder(platformMetadata, startTime, endTime, arrayList);
        ZoneOffset startZoneOffset = speedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = speedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.SpeedRecord speedRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(speedRecordBuild, "PlatformSpeedRecordBuild…       }\n        .build()");
        return speedRecordBuild;
    }

    private static final SpeedRecord.SpeedRecordSample toPlatformSpeedRecordSample(SpeedRecord.Sample sample) {
        return new SpeedRecord.SpeedRecordSample(UnitConvertersKt.toPlatformVelocity(sample.getSpeed()), sample.getTime());
    }

    private static final android.health.connect.datatypes.StepsRecord toPlatformStepsRecord(StepsRecord stepsRecord) {
        StepsRecord.Builder builder = new StepsRecord.Builder(MetadataConvertersKt.toPlatformMetadata(stepsRecord.getMetadata()), stepsRecord.getStartTime(), stepsRecord.getEndTime(), stepsRecord.getCount());
        ZoneOffset startZoneOffset = stepsRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = stepsRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.StepsRecord stepsRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(stepsRecordBuild, "PlatformStepsRecordBuild…       }\n        .build()");
        return stepsRecordBuild;
    }

    private static final android.health.connect.datatypes.StepsCadenceRecord toPlatformStepsCadenceRecord(androidx.health.connect.client.records.StepsCadenceRecord stepsCadenceRecord) {
        android.health.connect.datatypes.Metadata platformMetadata = MetadataConvertersKt.toPlatformMetadata(stepsCadenceRecord.getMetadata());
        Instant startTime = stepsCadenceRecord.getStartTime();
        Instant endTime = stepsCadenceRecord.getEndTime();
        List<StepsCadenceRecord.Sample> samples = stepsCadenceRecord.getSamples();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(samples, 10));
        Iterator<T> it = samples.iterator();
        while (it.hasNext()) {
            arrayList.add(toPlatformStepsCadenceSample((StepsCadenceRecord.Sample) it.next()));
        }
        StepsCadenceRecord.Builder builder = new StepsCadenceRecord.Builder(platformMetadata, startTime, endTime, arrayList);
        ZoneOffset startZoneOffset = stepsCadenceRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = stepsCadenceRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.StepsCadenceRecord stepsCadenceRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(stepsCadenceRecordBuild, "PlatformStepsCadenceReco…       }\n        .build()");
        return stepsCadenceRecordBuild;
    }

    private static final StepsCadenceRecord.StepsCadenceRecordSample toPlatformStepsCadenceSample(StepsCadenceRecord.Sample sample) {
        return new StepsCadenceRecord.StepsCadenceRecordSample(sample.getRate(), sample.getTime());
    }

    private static final android.health.connect.datatypes.TotalCaloriesBurnedRecord toPlatformTotalCaloriesBurnedRecord(TotalCaloriesBurnedRecord totalCaloriesBurnedRecord) {
        TotalCaloriesBurnedRecord.Builder builder = new TotalCaloriesBurnedRecord.Builder(MetadataConvertersKt.toPlatformMetadata(totalCaloriesBurnedRecord.getMetadata()), totalCaloriesBurnedRecord.getStartTime(), totalCaloriesBurnedRecord.getEndTime(), UnitConvertersKt.toPlatformEnergy(totalCaloriesBurnedRecord.getEnergy()));
        ZoneOffset startZoneOffset = totalCaloriesBurnedRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = totalCaloriesBurnedRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.TotalCaloriesBurnedRecord totalCaloriesBurnedRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(totalCaloriesBurnedRecordBuild, "PlatformTotalCaloriesBur…       }\n        .build()");
        return totalCaloriesBurnedRecordBuild;
    }

    private static final android.health.connect.datatypes.Vo2MaxRecord toPlatformVo2MaxRecord(Vo2MaxRecord vo2MaxRecord) {
        Vo2MaxRecord.Builder builder = new Vo2MaxRecord.Builder(MetadataConvertersKt.toPlatformMetadata(vo2MaxRecord.getMetadata()), vo2MaxRecord.getTime(), IntDefMappingsKt.toPlatformVo2MaxMeasurementMethod(vo2MaxRecord.getMeasurementMethod()), vo2MaxRecord.getVo2MillilitersPerMinuteKilogram());
        ZoneOffset zoneOffset = vo2MaxRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.Vo2MaxRecord vo2MaxRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(vo2MaxRecordBuild, "PlatformVo2MaxRecordBuil…(it) } }\n        .build()");
        return vo2MaxRecordBuild;
    }

    private static final android.health.connect.datatypes.WeightRecord toPlatformWeightRecord(WeightRecord weightRecord) {
        WeightRecord.Builder builder = new WeightRecord.Builder(MetadataConvertersKt.toPlatformMetadata(weightRecord.getMetadata()), weightRecord.getTime(), UnitConvertersKt.toPlatformMass(weightRecord.getWeight()));
        ZoneOffset zoneOffset = weightRecord.getZoneOffset();
        if (zoneOffset != null) {
            builder.setZoneOffset(zoneOffset);
        }
        android.health.connect.datatypes.WeightRecord weightRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(weightRecordBuild, "PlatformWeightRecordBuil…(it) } }\n        .build()");
        return weightRecordBuild;
    }

    private static final android.health.connect.datatypes.WheelchairPushesRecord toPlatformWheelchairPushesRecord(WheelchairPushesRecord wheelchairPushesRecord) {
        WheelchairPushesRecord.Builder builder = new WheelchairPushesRecord.Builder(MetadataConvertersKt.toPlatformMetadata(wheelchairPushesRecord.getMetadata()), wheelchairPushesRecord.getStartTime(), wheelchairPushesRecord.getEndTime(), wheelchairPushesRecord.getCount());
        ZoneOffset startZoneOffset = wheelchairPushesRecord.getStartZoneOffset();
        if (startZoneOffset != null) {
            builder.setStartZoneOffset(startZoneOffset);
        }
        ZoneOffset endZoneOffset = wheelchairPushesRecord.getEndZoneOffset();
        if (endZoneOffset != null) {
            builder.setEndZoneOffset(endZoneOffset);
        }
        android.health.connect.datatypes.WheelchairPushesRecord wheelchairPushesRecordBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(wheelchairPushesRecordBuild, "PlatformWheelchairPushes…       }\n        .build()");
        return wheelchairPushesRecordBuild;
    }

    private static final CyclingPedalingCadenceRecord.Sample toSdkCyclingPedalingCadenceSample(CyclingPedalingCadenceRecord.CyclingPedalingCadenceRecordSample cyclingPedalingCadenceRecordSample) {
        Instant time = cyclingPedalingCadenceRecordSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new CyclingPedalingCadenceRecord.Sample(time, cyclingPedalingCadenceRecordSample.getRevolutionsPerMinute());
    }

    private static final HeartRateRecord.Sample toSdkHeartRateSample(HeartRateRecord.HeartRateSample heartRateSample) {
        Instant time = heartRateSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new HeartRateRecord.Sample(time, heartRateSample.getBeatsPerMinute());
    }

    private static final PowerRecord.Sample toSdkPowerRecordSample(PowerRecord.PowerRecordSample powerRecordSample) {
        Instant time = powerRecordSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        Power power = powerRecordSample.getPower();
        Intrinsics.checkNotNullExpressionValue(power, "power");
        return new PowerRecord.Sample(time, UnitConvertersKt.toSdkPower(power));
    }

    private static final SpeedRecord.Sample toSdkSpeedSample(SpeedRecord.SpeedRecordSample speedRecordSample) {
        Instant time = speedRecordSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        Velocity speed = speedRecordSample.getSpeed();
        Intrinsics.checkNotNullExpressionValue(speed, "speed");
        return new SpeedRecord.Sample(time, UnitConvertersKt.toSdkVelocity(speed));
    }

    private static final StepsCadenceRecord.Sample toSdkStepsCadenceSample(StepsCadenceRecord.StepsCadenceRecordSample stepsCadenceRecordSample) {
        Instant time = stepsCadenceRecordSample.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "time");
        return new StepsCadenceRecord.Sample(time, stepsCadenceRecordSample.getRate());
    }

    private static final SleepSessionRecord.Stage toSdkSleepSessionStage(SleepSessionRecord.Stage stage) {
        Instant startTime = stage.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = stage.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new SleepSessionRecord.Stage(startTime, endTime, IntDefMappingsKt.toSdkSleepStageType(stage.getType()));
    }

    public static final androidx.health.connect.client.records.ExerciseRoute toSdkExerciseRoute(android.health.connect.datatypes.ExerciseRoute exerciseRoute) {
        androidx.health.connect.client.units.Length sdkLength;
        androidx.health.connect.client.units.Length sdkLength2;
        androidx.health.connect.client.units.Length sdkLength3;
        Intrinsics.checkNotNullParameter(exerciseRoute, "<this>");
        List<ExerciseRoute.Location> routeLocations = exerciseRoute.getRouteLocations();
        Intrinsics.checkNotNullExpressionValue(routeLocations, "routeLocations");
        List<ExerciseRoute.Location> list = routeLocations;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ExerciseRoute.Location location : list) {
            Instant time = location.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "value.time");
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            Length horizontalAccuracy = location.getHorizontalAccuracy();
            if (horizontalAccuracy != null) {
                Intrinsics.checkNotNullExpressionValue(horizontalAccuracy, "horizontalAccuracy");
                sdkLength = UnitConvertersKt.toSdkLength(horizontalAccuracy);
            } else {
                sdkLength = null;
            }
            Length verticalAccuracy = location.getVerticalAccuracy();
            if (verticalAccuracy != null) {
                Intrinsics.checkNotNullExpressionValue(verticalAccuracy, "verticalAccuracy");
                sdkLength2 = UnitConvertersKt.toSdkLength(verticalAccuracy);
            } else {
                sdkLength2 = null;
            }
            Length altitude = location.getAltitude();
            if (altitude != null) {
                Intrinsics.checkNotNullExpressionValue(altitude, "altitude");
                sdkLength3 = UnitConvertersKt.toSdkLength(altitude);
            } else {
                sdkLength3 = null;
            }
            arrayList.add(new ExerciseRoute.Location(time, latitude, longitude, sdkLength, sdkLength2, sdkLength3));
        }
        return new androidx.health.connect.client.records.ExerciseRoute(arrayList);
    }

    public static final androidx.health.connect.client.records.ExerciseLap toSdkExerciseLap(ExerciseLap exerciseLap) {
        Intrinsics.checkNotNullParameter(exerciseLap, "<this>");
        Instant startTime = exerciseLap.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = exerciseLap.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        Length length = exerciseLap.getLength();
        return new androidx.health.connect.client.records.ExerciseLap(startTime, endTime, length != null ? UnitConvertersKt.toSdkLength(length) : null);
    }

    public static final androidx.health.connect.client.records.ExerciseSegment toSdkExerciseSegment(ExerciseSegment exerciseSegment) {
        Intrinsics.checkNotNullParameter(exerciseSegment, "<this>");
        Instant startTime = exerciseSegment.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = exerciseSegment.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new androidx.health.connect.client.records.ExerciseSegment(startTime, endTime, IntDefMappingsKt.toSdkExerciseSegmentType(exerciseSegment.getSegmentType()), exerciseSegment.getRepetitionsCount());
    }
}
