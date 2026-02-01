package androidx.health.connect.client.records.metadata;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.time.Instant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Metadata.kt */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0003H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\r\u001a\u00020\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Landroidx/health/connect/client/records/metadata/Metadata;", "", "id", "", "dataOrigin", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "lastModifiedTime", "Ljava/time/Instant;", "clientRecordId", "clientRecordVersion", "", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroidx/health/connect/client/records/metadata/Device;", "recordingMethod", "", "(Ljava/lang/String;Landroidx/health/connect/client/records/metadata/DataOrigin;Ljava/time/Instant;Ljava/lang/String;JLandroidx/health/connect/client/records/metadata/Device;I)V", "getClientRecordId", "()Ljava/lang/String;", "getClientRecordVersion", "()J", "getDataOrigin", "()Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDevice", "()Landroidx/health/connect/client/records/metadata/Device;", "getId", "getLastModifiedTime", "()Ljava/time/Instant;", "getRecordingMethod$annotations", "()V", "getRecordingMethod", "()I", "equals", "", "other", "hashCode", "toString", "Companion", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Metadata {
    public static final Metadata EMPTY = new Metadata(null, null, null, null, 0, null, 0, 127, null);
    public static final String EMPTY_ID = "";
    public static final int RECORDING_METHOD_ACTIVELY_RECORDED = 1;
    public static final int RECORDING_METHOD_AUTOMATICALLY_RECORDED = 2;
    public static final int RECORDING_METHOD_MANUAL_ENTRY = 3;
    public static final int RECORDING_METHOD_UNKNOWN = 0;
    private final String clientRecordId;
    private final long clientRecordVersion;
    private final DataOrigin dataOrigin;
    private final Device device;
    private final String id;
    private final Instant lastModifiedTime;
    private final int recordingMethod;

    public Metadata() {
        this(null, null, null, null, 0L, null, 0, 127, null);
    }

    public static /* synthetic */ void getRecordingMethod$annotations() {
    }

    public Metadata(String id2, DataOrigin dataOrigin, Instant lastModifiedTime, String str, long j, Device device, int i) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(dataOrigin, "dataOrigin");
        Intrinsics.checkNotNullParameter(lastModifiedTime, "lastModifiedTime");
        this.id = id2;
        this.dataOrigin = dataOrigin;
        this.lastModifiedTime = lastModifiedTime;
        this.clientRecordId = str;
        this.clientRecordVersion = j;
        this.device = device;
        this.recordingMethod = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Metadata(String str, DataOrigin dataOrigin, Instant instant, String str2, long j, Device device, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Instant EPOCH;
        String str3 = (i2 & 1) != 0 ? "" : str;
        DataOrigin dataOrigin2 = (i2 & 2) != 0 ? new DataOrigin("") : dataOrigin;
        if ((i2 & 4) != 0) {
            EPOCH = Instant.EPOCH;
            Intrinsics.checkNotNullExpressionValue(EPOCH, "EPOCH");
        } else {
            EPOCH = instant;
        }
        this(str3, dataOrigin2, EPOCH, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? 0L : j, (i2 & 32) == 0 ? device : null, (i2 & 64) != 0 ? 0 : i);
    }

    public final String getId() {
        return this.id;
    }

    public final DataOrigin getDataOrigin() {
        return this.dataOrigin;
    }

    public final Instant getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getClientRecordId() {
        return this.clientRecordId;
    }

    public final long getClientRecordVersion() {
        return this.clientRecordVersion;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final int getRecordingMethod() {
        return this.recordingMethod;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Metadata)) {
            return false;
        }
        Metadata metadata = (Metadata) other;
        return Intrinsics.areEqual(this.id, metadata.id) && Intrinsics.areEqual(this.dataOrigin, metadata.dataOrigin) && Intrinsics.areEqual(this.lastModifiedTime, metadata.lastModifiedTime) && Intrinsics.areEqual(this.clientRecordId, metadata.clientRecordId) && this.clientRecordVersion == metadata.clientRecordVersion && Intrinsics.areEqual(this.device, metadata.device) && this.recordingMethod == metadata.recordingMethod;
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.dataOrigin.hashCode()) * 31) + this.lastModifiedTime.hashCode()) * 31;
        String str = this.clientRecordId;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Long.hashCode(this.clientRecordVersion)) * 31;
        Device device = this.device;
        return ((iHashCode2 + (device != null ? device.hashCode() : 0)) * 31) + Integer.hashCode(this.recordingMethod);
    }

    public String toString() {
        return "Metadata(id='" + this.id + "', dataOrigin=" + this.dataOrigin + ", lastModifiedTime=" + this.lastModifiedTime + ", clientRecordId=" + this.clientRecordId + ", clientRecordVersion=" + this.clientRecordVersion + ", device=" + this.device + ", recordingMethod=" + this.recordingMethod + ')';
    }
}
