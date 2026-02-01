package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.SleepSessionRecord;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.samsung.android.sdk.healthdata.HealthConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SleepSessionRecord.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0003%&'B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u0006("}, d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "startTime", "Ljava/time/Instant;", "startZoneOffset", "Ljava/time/ZoneOffset;", SDKConstants.PARAM_END_TIME, "endZoneOffset", "title", "", "notes", "stages", "", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/time/Instant;Ljava/time/ZoneOffset;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Landroidx/health/connect/client/records/metadata/Metadata;)V", "getEndTime", "()Ljava/time/Instant;", "getEndZoneOffset", "()Ljava/time/ZoneOffset;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getNotes", "()Ljava/lang/String;", "getStages", "()Ljava/util/List;", "getStartTime", "getStartZoneOffset", "getTitle", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "Stage", "StageTypes", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SleepSessionRecord implements IntervalRecord {
    public static final AggregateMetric<Duration> SLEEP_DURATION_TOTAL = AggregateMetric.INSTANCE.durationMetric$connect_client_release("SleepSession");
    public static final int STAGE_TYPE_AWAKE = 1;
    public static final int STAGE_TYPE_AWAKE_IN_BED = 7;
    public static final int STAGE_TYPE_DEEP = 5;
    public static final Map<Integer, String> STAGE_TYPE_INT_TO_STRING_MAP;
    public static final int STAGE_TYPE_LIGHT = 4;
    public static final int STAGE_TYPE_OUT_OF_BED = 3;
    public static final int STAGE_TYPE_REM = 6;
    public static final int STAGE_TYPE_SLEEPING = 2;
    public static final Map<String, Integer> STAGE_TYPE_STRING_TO_INT_MAP;
    public static final int STAGE_TYPE_UNKNOWN = 0;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final List<Stage> stages;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;

    /* compiled from: SleepSessionRecord.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord$StageTypes;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface StageTypes {
    }

    public SleepSessionRecord(Instant startTime, ZoneOffset zoneOffset, Instant endTime, ZoneOffset zoneOffset2, String str, String str2, List<Stage> stages, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        Intrinsics.checkNotNullParameter(stages, "stages");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.startTime = startTime;
        this.startZoneOffset = zoneOffset;
        this.endTime = endTime;
        this.endZoneOffset = zoneOffset2;
        this.title = str;
        this.notes = str2;
        this.stages = stages;
        this.metadata = metadata;
        if (!getStartTime().isBefore(getEndTime())) {
            throw new IllegalArgumentException("startTime must be before endTime.".toString());
        }
        if (stages.isEmpty()) {
            return;
        }
        final SleepSessionRecord$sortedStages$1 sleepSessionRecord$sortedStages$1 = new Function2<Stage, Stage, Integer>() { // from class: androidx.health.connect.client.records.SleepSessionRecord$sortedStages$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SleepSessionRecord.Stage stage, SleepSessionRecord.Stage stage2) {
                return Integer.valueOf(stage.getStartTime().compareTo(stage2.getStartTime()));
            }
        };
        List listSortedWith = CollectionsKt.sortedWith(stages, new Comparator() { // from class: androidx.health.connect.client.records.SleepSessionRecord$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SleepSessionRecord._init_$lambda$1(sleepSessionRecord$sortedStages$1, obj, obj2);
            }
        });
        int lastIndex = CollectionsKt.getLastIndex(listSortedWith);
        int i = 0;
        while (i < lastIndex) {
            Instant endTime2 = ((Stage) listSortedWith.get(i)).getEndTime();
            i++;
            if (endTime2.isAfter(((Stage) listSortedWith.get(i)).getStartTime())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        if (((Stage) CollectionsKt.first(listSortedWith)).getStartTime().isBefore(getStartTime())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (((Stage) CollectionsKt.last(listSortedWith)).getEndTime().isAfter(getEndTime())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getNotes() {
        return this.notes;
    }

    public /* synthetic */ SleepSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, String str, String str2, List list, androidx.health.connect.client.records.metadata.Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    public final List<Stage> getStages() {
        return this.stages;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$1(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SleepSessionRecord)) {
            return false;
        }
        SleepSessionRecord sleepSessionRecord = (SleepSessionRecord) other;
        return Intrinsics.areEqual(this.title, sleepSessionRecord.title) && Intrinsics.areEqual(this.notes, sleepSessionRecord.notes) && Intrinsics.areEqual(this.stages, sleepSessionRecord.stages) && Intrinsics.areEqual(getStartTime(), sleepSessionRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), sleepSessionRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), sleepSessionRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), sleepSessionRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), sleepSessionRecord.getMetadata());
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.notes;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.stages.hashCode()) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode3 = (((iHashCode2 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31) + getEndTime().hashCode()) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return ((iHashCode3 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "SleepSessionRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", title=" + this.title + ", notes=" + this.notes + ", stages=" + this.stages + ", metadata=" + getMetadata() + ')';
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("awake", 1), TuplesKt.to("sleeping", 2), TuplesKt.to("out_of_bed", 3), TuplesKt.to("light", 4), TuplesKt.to("deep", 5), TuplesKt.to("rem", 6), TuplesKt.to("awake_in_bed", 7), TuplesKt.to("unknown", 0));
        STAGE_TYPE_STRING_TO_INT_MAP = mapMapOf;
        Set<Map.Entry<String, Integer>> setEntrySet = mapMapOf.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        STAGE_TYPE_INT_TO_STRING_MAP = linkedHashMap;
    }

    /* compiled from: SleepSessionRecord.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00020\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "", "startTime", "Ljava/time/Instant;", SDKConstants.PARAM_END_TIME, HealthConstants.SleepStage.STAGE, "", "(Ljava/time/Instant;Ljava/time/Instant;I)V", "getEndTime", "()Ljava/time/Instant;", "getStage$annotations", "()V", "getStage", "()I", "getStartTime", "equals", "", "other", "hashCode", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Stage {
        private final Instant endTime;
        private final int stage;
        private final Instant startTime;

        public static /* synthetic */ void getStage$annotations() {
        }

        public Stage(Instant startTime, Instant endTime, int i) {
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(endTime, "endTime");
            this.startTime = startTime;
            this.endTime = endTime;
            this.stage = i;
            if (!startTime.isBefore(endTime)) {
                throw new IllegalArgumentException("startTime must be before endTime.".toString());
            }
        }

        public final Instant getStartTime() {
            return this.startTime;
        }

        public final Instant getEndTime() {
            return this.endTime;
        }

        public final int getStage() {
            return this.stage;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stage)) {
                return false;
            }
            Stage stage = (Stage) other;
            return this.stage == stage.stage && Intrinsics.areEqual(this.startTime, stage.startTime) && Intrinsics.areEqual(this.endTime, stage.endTime);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.stage) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode();
        }

        public String toString() {
            return "Stage(startTime=" + this.startTime + ", endTime=" + this.endTime + ", stage=" + this.stage + ')';
        }
    }
}
