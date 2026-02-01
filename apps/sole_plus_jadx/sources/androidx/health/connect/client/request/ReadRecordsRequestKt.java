package androidx.health.connect.client.request;

import androidx.exifinterface.media.ExifInterface;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: ReadRecordsRequest.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aS\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086\b¨\u0006\u000f"}, d2 = {"ReadRecordsRequest", "Landroidx/health/connect/client/request/ReadRecordsRequest;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "dataOriginFilter", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "ascendingOrder", "", "pageSize", "", "pageToken", "", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReadRecordsRequestKt {
    public static /* synthetic */ ReadRecordsRequest ReadRecordsRequest$default(TimeRangeFilter timeRangeFilter, Set set, boolean z, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            set = SetsKt.emptySet();
        }
        Set dataOriginFilter = set;
        if ((i2 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            i = 1000;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        Intrinsics.checkNotNullParameter(dataOriginFilter, "dataOriginFilter");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(Record.class), timeRangeFilter, dataOriginFilter, z2, i3, str);
    }

    public static final /* synthetic */ <T extends Record> ReadRecordsRequest<T> ReadRecordsRequest(TimeRangeFilter timeRangeFilter, Set<DataOrigin> dataOriginFilter, boolean z, int i, String str) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "timeRangeFilter");
        Intrinsics.checkNotNullParameter(dataOriginFilter, "dataOriginFilter");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return new ReadRecordsRequest<>(Reflection.getOrCreateKotlinClass(Record.class), timeRangeFilter, dataOriginFilter, z, i, str);
    }
}
