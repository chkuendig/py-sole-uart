package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.records.metadata.DataOrigin;
import com.android.SdkConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SeriesRecordAggregationExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/RecordInfo;", "", "dataOrigin", "Landroidx/health/connect/client/records/metadata/DataOrigin;", SdkConstants.FD_SAMPLES, "", "Landroidx/health/connect/client/impl/platform/aggregate/SampleInfo;", "(Landroidx/health/connect/client/records/metadata/DataOrigin;Ljava/util/List;)V", "getDataOrigin", "()Landroidx/health/connect/client/records/metadata/DataOrigin;", "getSamples", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "connect-client_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RecordInfo {
    private final DataOrigin dataOrigin;
    private final List<SampleInfo> samples;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecordInfo copy$default(RecordInfo recordInfo, DataOrigin dataOrigin, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            dataOrigin = recordInfo.dataOrigin;
        }
        if ((i & 2) != 0) {
            list = recordInfo.samples;
        }
        return recordInfo.copy(dataOrigin, list);
    }

    /* renamed from: component1, reason: from getter */
    public final DataOrigin getDataOrigin() {
        return this.dataOrigin;
    }

    public final List<SampleInfo> component2() {
        return this.samples;
    }

    public final RecordInfo copy(DataOrigin dataOrigin, List<SampleInfo> samples) {
        Intrinsics.checkNotNullParameter(dataOrigin, "dataOrigin");
        Intrinsics.checkNotNullParameter(samples, "samples");
        return new RecordInfo(dataOrigin, samples);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecordInfo)) {
            return false;
        }
        RecordInfo recordInfo = (RecordInfo) other;
        return Intrinsics.areEqual(this.dataOrigin, recordInfo.dataOrigin) && Intrinsics.areEqual(this.samples, recordInfo.samples);
    }

    public int hashCode() {
        return (this.dataOrigin.hashCode() * 31) + this.samples.hashCode();
    }

    public String toString() {
        return "RecordInfo(dataOrigin=" + this.dataOrigin + ", samples=" + this.samples + ')';
    }

    public RecordInfo(DataOrigin dataOrigin, List<SampleInfo> samples) {
        Intrinsics.checkNotNullParameter(dataOrigin, "dataOrigin");
        Intrinsics.checkNotNullParameter(samples, "samples");
        this.dataOrigin = dataOrigin;
        this.samples = samples;
    }

    public final DataOrigin getDataOrigin() {
        return this.dataOrigin;
    }

    public final List<SampleInfo> getSamples() {
        return this.samples;
    }
}
