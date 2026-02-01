package androidx.health.connect.client.impl.converters.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.platform.client.proto.DataProto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoToAggregateDataRow.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¨\u0006\u0007"}, d2 = {"retrieveAggregateDataRow", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/platform/client/proto/DataProto$AggregateDataRow;", "toAggregateDataRowGroupByDuration", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "toAggregateDataRowGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProtoToAggregateDataRowKt {
    public static final AggregationResultGroupedByDuration toAggregateDataRowGroupByDuration(DataProto.AggregateDataRow aggregateDataRow) {
        Intrinsics.checkNotNullParameter(aggregateDataRow, "<this>");
        if (!aggregateDataRow.hasStartTimeEpochMs()) {
            throw new IllegalArgumentException("start time must be set".toString());
        }
        if (!aggregateDataRow.hasEndTimeEpochMs()) {
            throw new IllegalArgumentException("end time must be set".toString());
        }
        AggregationResult aggregationResultRetrieveAggregateDataRow = retrieveAggregateDataRow(aggregateDataRow);
        Instant instantOfEpochMilli = Instant.ofEpochMilli(aggregateDataRow.getStartTimeEpochMs());
        Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli, "ofEpochMilli(startTimeEpochMs)");
        Instant instantOfEpochMilli2 = Instant.ofEpochMilli(aggregateDataRow.getEndTimeEpochMs());
        Intrinsics.checkNotNullExpressionValue(instantOfEpochMilli2, "ofEpochMilli(endTimeEpochMs)");
        ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(aggregateDataRow.getZoneOffsetSeconds());
        Intrinsics.checkNotNullExpressionValue(zoneOffsetOfTotalSeconds, "ofTotalSeconds(zoneOffsetSeconds)");
        return new AggregationResultGroupedByDuration(aggregationResultRetrieveAggregateDataRow, instantOfEpochMilli, instantOfEpochMilli2, zoneOffsetOfTotalSeconds);
    }

    public static final AggregationResultGroupedByPeriod toAggregateDataRowGroupByPeriod(DataProto.AggregateDataRow aggregateDataRow) {
        Intrinsics.checkNotNullParameter(aggregateDataRow, "<this>");
        if (!aggregateDataRow.hasStartLocalDateTime()) {
            throw new IllegalArgumentException("start time must be set".toString());
        }
        if (!aggregateDataRow.hasEndLocalDateTime()) {
            throw new IllegalArgumentException("end time must be set".toString());
        }
        AggregationResult aggregationResultRetrieveAggregateDataRow = retrieveAggregateDataRow(aggregateDataRow);
        LocalDateTime localDateTime = LocalDateTime.parse(aggregateDataRow.getStartLocalDateTime());
        Intrinsics.checkNotNullExpressionValue(localDateTime, "parse(startLocalDateTime)");
        LocalDateTime localDateTime2 = LocalDateTime.parse(aggregateDataRow.getEndLocalDateTime());
        Intrinsics.checkNotNullExpressionValue(localDateTime2, "parse(endLocalDateTime)");
        return new AggregationResultGroupedByPeriod(aggregationResultRetrieveAggregateDataRow, localDateTime, localDateTime2);
    }

    public static final AggregationResult retrieveAggregateDataRow(DataProto.AggregateDataRow aggregateDataRow) {
        Intrinsics.checkNotNullParameter(aggregateDataRow, "<this>");
        Map<String, Long> longValuesMap = aggregateDataRow.getLongValuesMap();
        Intrinsics.checkNotNullExpressionValue(longValuesMap, "longValuesMap");
        Map<String, Double> doubleValuesMap = aggregateDataRow.getDoubleValuesMap();
        Intrinsics.checkNotNullExpressionValue(doubleValuesMap, "doubleValuesMap");
        List<DataProto.DataOrigin> dataOriginsList = aggregateDataRow.getDataOriginsList();
        Intrinsics.checkNotNullExpressionValue(dataOriginsList, "dataOriginsList");
        HashSet hashSet = new HashSet();
        Iterator<T> it = dataOriginsList.iterator();
        while (it.hasNext()) {
            String applicationId = ((DataProto.DataOrigin) it.next()).getApplicationId();
            Intrinsics.checkNotNullExpressionValue(applicationId, "it.applicationId");
            hashSet.add(new DataOrigin(applicationId));
        }
        return new AggregationResult(longValuesMap, doubleValuesMap, hashSet);
    }
}
