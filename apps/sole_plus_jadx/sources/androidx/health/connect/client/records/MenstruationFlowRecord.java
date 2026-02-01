package androidx.health.connect.client.records;

import androidx.health.connect.client.records.CervicalMucusRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MenstruationFlowRecord.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0017\u0010\u0006\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Landroidx/health/connect/client/records/MenstruationFlowRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "flow", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;ILandroidx/health/connect/client/records/metadata/Metadata;)V", "getFlow$annotations", "()V", "getFlow", "()I", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "Flows", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MenstruationFlowRecord implements InstantaneousRecord {
    public static final int FLOW_HEAVY = 3;
    public static final int FLOW_LIGHT = 1;
    public static final int FLOW_MEDIUM = 2;
    public static final Map<Integer, String> FLOW_TYPE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> FLOW_TYPE_STRING_TO_INT_MAP;
    public static final int FLOW_UNKNOWN = 0;
    private final int flow;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    /* compiled from: MenstruationFlowRecord.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/records/MenstruationFlowRecord$Flows;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Flows {
    }

    public static /* synthetic */ void getFlow$annotations() {
    }

    public MenstruationFlowRecord(Instant time, ZoneOffset zoneOffset, int i, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.flow = i;
        this.metadata = metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final int getFlow() {
        return this.flow;
    }

    public /* synthetic */ MenstruationFlowRecord(Instant instant, ZoneOffset zoneOffset, int i, androidx.health.connect.client.records.metadata.Metadata metadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? androidx.health.connect.client.records.metadata.Metadata.EMPTY : metadata);
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenstruationFlowRecord)) {
            return false;
        }
        MenstruationFlowRecord menstruationFlowRecord = (MenstruationFlowRecord) other;
        return this.flow == menstruationFlowRecord.flow && Intrinsics.areEqual(getTime(), menstruationFlowRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), menstruationFlowRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), menstruationFlowRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((this.flow * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "MenstruationFlowRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", flow=" + this.flow + ", metadata=" + getMetadata() + ')';
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("light", 1), TuplesKt.to("medium", 2), TuplesKt.to(CervicalMucusRecord.Sensation.HEAVY, 3));
        FLOW_TYPE_STRING_TO_INT_MAP = mapMapOf;
        Set<Map.Entry<String, Integer>> setEntrySet = mapMapOf.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        FLOW_TYPE_INT_TO_STRING_MAP = linkedHashMap;
    }
}
