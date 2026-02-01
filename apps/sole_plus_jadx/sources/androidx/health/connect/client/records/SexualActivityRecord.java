package androidx.health.connect.client.records;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
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

/* compiled from: SexualActivityRecord.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/records/SexualActivityRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "time", "Ljava/time/Instant;", "zoneOffset", "Ljava/time/ZoneOffset;", "protectionUsed", "", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "(Ljava/time/Instant;Ljava/time/ZoneOffset;ILandroidx/health/connect/client/records/metadata/Metadata;)V", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "getProtectionUsed$annotations", "()V", "getProtectionUsed", "()I", "getTime", "()Ljava/time/Instant;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", SsManifestParser.ProtectionParser.TAG, "Protections", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SexualActivityRecord implements InstantaneousRecord {
    public static final Map<Integer, String> PROTECTION_USED_INT_TO_STRING_MAP;
    public static final int PROTECTION_USED_PROTECTED = 1;
    public static final Map<String, Integer> PROTECTION_USED_STRING_TO_INT_MAP;
    public static final int PROTECTION_USED_UNKNOWN = 0;
    public static final int PROTECTION_USED_UNPROTECTED = 2;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int protectionUsed;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    /* compiled from: SexualActivityRecord.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/health/connect/client/records/SexualActivityRecord$Protections;", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Protections {
    }

    public static /* synthetic */ void getProtectionUsed$annotations() {
    }

    public SexualActivityRecord(Instant time, ZoneOffset zoneOffset, int i, androidx.health.connect.client.records.metadata.Metadata metadata) {
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.time = time;
        this.zoneOffset = zoneOffset;
        this.protectionUsed = i;
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

    public final int getProtectionUsed() {
        return this.protectionUsed;
    }

    public /* synthetic */ SexualActivityRecord(Instant instant, ZoneOffset zoneOffset, int i, androidx.health.connect.client.records.metadata.Metadata metadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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
        if (!(other instanceof SexualActivityRecord)) {
            return false;
        }
        SexualActivityRecord sexualActivityRecord = (SexualActivityRecord) other;
        return this.protectionUsed == sexualActivityRecord.protectionUsed && Intrinsics.areEqual(getTime(), sexualActivityRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), sexualActivityRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), sexualActivityRecord.getMetadata());
    }

    public int hashCode() {
        int iHashCode = ((this.protectionUsed * 31) + getTime().hashCode()) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31) + getMetadata().hashCode();
    }

    public String toString() {
        return "SexualActivityRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", protectionUsed=" + this.protectionUsed + ", metadata=" + getMetadata() + ')';
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to(Protection.PROTECTED, 1), TuplesKt.to(Protection.UNPROTECTED, 2));
        PROTECTION_USED_STRING_TO_INT_MAP = mapMapOf;
        PROTECTION_USED_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }

    /* compiled from: SexualActivityRecord.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/health/connect/client/records/SexualActivityRecord$Protection;", "", "()V", "PROTECTED", "", "UNPROTECTED", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Protection {
        public static final Protection INSTANCE = new Protection();
        public static final String PROTECTED = "protected";
        public static final String UNPROTECTED = "unprotected";

        private Protection() {
        }
    }
}
