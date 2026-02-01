package androidx.health.connect.client.records;

import androidx.health.connect.client.units.BloodGlucose;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BloodGlucoseRecord.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0005&'()*BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", FirebaseAnalytics.Param.LEVEL, "Landroidx/health/connect/client/units/BloodGlucose;", "specimenSource", "", "mealType", "relationToMeal", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Landroidx/health/connect/client/units/BloodGlucose;IIILandroidx/health/connect/client/records/metadata/Metadata;)V", "getLevel", "()Landroidx/health/connect/client/units/BloodGlucose;", "getMealType$annotations", "()V", "getMealType", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getRelationToMeal$annotations", "getRelationToMeal", "getSpecimenSource$annotations", "getSpecimenSource", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "RelationToMeal", "RelationToMeals", "SpecimenSource", "SpecimenSources", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BloodGlucoseRecord implements InstantaneousRecord {
    private static final BloodGlucose MAX_BLOOD_GLUCOSE_LEVEL = BloodGlucose.INSTANCE.millimolesPerLiter(50.0d);
    public static final int RELATION_TO_MEAL_AFTER_MEAL = 4;
    public static final int RELATION_TO_MEAL_BEFORE_MEAL = 3;
    public static final int RELATION_TO_MEAL_FASTING = 2;
    public static final int RELATION_TO_MEAL_GENERAL = 1;
    public static final Map<Integer, String> RELATION_TO_MEAL_INT_TO_STRING_MAP;
    public static final Map<String, Integer> RELATION_TO_MEAL_STRING_TO_INT_MAP;
    public static final int RELATION_TO_MEAL_UNKNOWN = 0;
    public static final int SPECIMEN_SOURCE_CAPILLARY_BLOOD = 2;
    public static final int SPECIMEN_SOURCE_INTERSTITIAL_FLUID = 1;
    public static final Map<Integer, String> SPECIMEN_SOURCE_INT_TO_STRING_MAP;
    public static final int SPECIMEN_SOURCE_PLASMA = 3;
    public static final int SPECIMEN_SOURCE_SERUM = 4;
    public static final Map<String, Integer> SPECIMEN_SOURCE_STRING_TO_INT_MAP;
    public static final int SPECIMEN_SOURCE_TEARS = 5;
    public static final int SPECIMEN_SOURCE_UNKNOWN = 0;
    public static final int SPECIMEN_SOURCE_WHOLE_BLOOD = 6;
    private final BloodGlucose level;
    private final int mealType;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int relationToMeal;
    private final int specimenSource;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$RelationToMeals;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RelationToMeals {
    }

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$SpecimenSources;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SpecimenSources {
    }

    public static /* synthetic */ void getMealType$annotations() {
    }

    public static /* synthetic */ void getRelationToMeal$annotations() {
    }

    public static /* synthetic */ void getSpecimenSource$annotations() {
    }

    public BloodGlucoseRecord(Instant time, ZoneOffset zoneOffset, BloodGlucose level, int i, int i2, int i3, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.level = level;
        this.specimenSource = i;
        this.mealType = i2;
        this.relationToMeal = i3;
        this.metadata = metadata;
        UtilsKt.requireNotLess(level, level.zero$connect_client_release(), FirebaseAnalytics.Param.LEVEL);
        UtilsKt.requireNotMore(level, MAX_BLOOD_GLUCOSE_LEVEL, FirebaseAnalytics.Param.LEVEL);
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final BloodGlucose getLevel() {
        return this.level;
    }

    public final int getSpecimenSource() {
        return this.specimenSource;
    }

    public final int getMealType() {
        return this.mealType;
    }

    public final int getRelationToMeal() {
        return this.relationToMeal;
    }

    public /* synthetic */ BloodGlucoseRecord(Instant instant, ZoneOffset zoneOffset, BloodGlucose bloodGlucose, int i, int i2, int i3, androidx.health.connect.client.records.metadata.Metadata metadata, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, bloodGlucose, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$SpecimenSource;", "", "()V", "CAPILLARY_BLOOD", "", "INTERSTITIAL_FLUID", "PLASMA", "SERUM", "TEARS", "WHOLE_BLOOD", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SpecimenSource {
        public static final String CAPILLARY_BLOOD = "capillary_blood";
        public static final SpecimenSource INSTANCE = new SpecimenSource();
        public static final String INTERSTITIAL_FLUID = "interstitial_fluid";
        public static final String PLASMA = "plasma";
        public static final String SERUM = "serum";
        public static final String TEARS = "tears";
        public static final String WHOLE_BLOOD = "whole_blood";

        private SpecimenSource() {
        }
    }

    /* compiled from: BloodGlucoseRecord.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/health/connect/client/records/BloodGlucoseRecord$RelationToMeal;", "", "()V", "AFTER_MEAL", "", "BEFORE_MEAL", "FASTING", "GENERAL", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RelationToMeal {
        public static final String AFTER_MEAL = "after_meal";
        public static final String BEFORE_MEAL = "before_meal";
        public static final String FASTING = "fasting";
        public static final String GENERAL = "general";
        public static final RelationToMeal INSTANCE = new RelationToMeal();

        private RelationToMeal() {
        }
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to(RelationToMeal.GENERAL, 1), TuplesKt.to(RelationToMeal.AFTER_MEAL, 4), TuplesKt.to(RelationToMeal.FASTING, 2), TuplesKt.to(RelationToMeal.BEFORE_MEAL, 3));
        RELATION_TO_MEAL_STRING_TO_INT_MAP = mapMapOf;
        RELATION_TO_MEAL_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
        Map<String, Integer> mapMapOf2 = MapsKt.mapOf(TuplesKt.to(SpecimenSource.INTERSTITIAL_FLUID, 1), TuplesKt.to(SpecimenSource.CAPILLARY_BLOOD, 2), TuplesKt.to(SpecimenSource.PLASMA, 3), TuplesKt.to(SpecimenSource.TEARS, 5), TuplesKt.to(SpecimenSource.WHOLE_BLOOD, 6), TuplesKt.to(SpecimenSource.SERUM, 4));
        SPECIMEN_SOURCE_STRING_TO_INT_MAP = mapMapOf2;
        SPECIMEN_SOURCE_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.health.connect.client.records.BloodGlucoseRecord");
        BloodGlucoseRecord bloodGlucoseRecord = (BloodGlucoseRecord) other;
        return Intrinsics.areEqual(getTime(), bloodGlucoseRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), bloodGlucoseRecord.getZoneOffset()) && Intrinsics.areEqual(this.level, bloodGlucoseRecord.level) && this.specimenSource == bloodGlucoseRecord.specimenSource && this.mealType == bloodGlucoseRecord.mealType && this.relationToMeal == bloodGlucoseRecord.relationToMeal && Intrinsics.areEqual(getMetadata(), bloodGlucoseRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = getTime().hashCode() * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((((((((((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + this.level.hashCode()) * 31) + this.specimenSource) * 31) + this.mealType) * 31) + this.relationToMeal) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "BloodGlucoseRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", level=" + this.level + ", specimenSource=" + this.specimenSource + ", mealType=" + this.mealType + ", relationToMeal=" + this.relationToMeal + ", metadata=" + getMetadata() + ')';
    }
}
