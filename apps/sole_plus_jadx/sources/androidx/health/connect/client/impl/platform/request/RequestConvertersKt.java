package androidx.health.connect.client.impl.platform.request;

import android.health.connect.AggregateRecordsRequest;
import android.health.connect.LocalTimeRangeFilter;
import android.health.connect.ReadRecordsRequestUsingFilters;
import android.health.connect.TimeInstantRangeFilter;
import android.health.connect.TimeRangeFilter;
import android.health.connect.changelog.ChangeLogTokenRequest;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.Record;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.aggregate.AggregationMappingsKt;
import androidx.health.connect.client.impl.platform.records.MetadataConvertersKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.AggregateGroupByPeriodRequest;
import androidx.health.connect.client.request.AggregateRequest;
import androidx.health.connect.client.request.ChangesTokenRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: RequestConverters.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\u0014\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005*\u00020\u0007H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\r\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u000e\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u000f\u001a\n\u0010\u000b\u001a\u00020\u0010*\u00020\u0011\u001a\u001a\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012*\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\n¨\u0006\u0018"}, d2 = {"toAggregationType", "Landroid/health/connect/datatypes/AggregationType;", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "toLocalDateTime", "Ljava/time/LocalDateTime;", "kotlin.jvm.PlatformType", "Ljava/time/Instant;", "toPlatformLocalTimeRangeFilter", "Landroid/health/connect/LocalTimeRangeFilter;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "toPlatformRequest", "Landroid/health/connect/AggregateRecordsRequest;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/connect/client/request/AggregateGroupByPeriodRequest;", "Landroidx/health/connect/client/request/AggregateRequest;", "Landroid/health/connect/changelog/ChangeLogTokenRequest;", "Landroidx/health/connect/client/request/ChangesTokenRequest;", "Landroid/health/connect/ReadRecordsRequestUsingFilters;", "Landroid/health/connect/datatypes/Record;", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "Landroidx/health/connect/client/records/Record;", "toPlatformTimeRangeFilter", "Landroid/health/connect/TimeRangeFilter;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestConvertersKt {
    public static final ReadRecordsRequestUsingFilters<? extends Record> toPlatformRequest(ReadRecordsRequest<? extends androidx.health.connect.client.records.Record> readRecordsRequest) {
        Intrinsics.checkNotNullParameter(readRecordsRequest, "<this>");
        ReadRecordsRequestUsingFilters.Builder pageSize = new ReadRecordsRequestUsingFilters.Builder(RecordConvertersKt.toPlatformRecordClass(readRecordsRequest.getRecordType())).setTimeRangeFilter(toPlatformTimeRangeFilter(readRecordsRequest.getTimeRangeFilter())).setPageSize(readRecordsRequest.getPageSize());
        Iterator<T> it = readRecordsRequest.getDataOriginFilter().iterator();
        while (it.hasNext()) {
            pageSize.addDataOrigins(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        String pageToken = readRecordsRequest.getPageToken();
        if (pageToken != null) {
            pageSize.setPageToken(Long.parseLong(pageToken));
        }
        if (readRecordsRequest.getPageToken() == null) {
            pageSize.setAscending(readRecordsRequest.getAscendingOrder());
        }
        ReadRecordsRequestUsingFilters<? extends Record> readRecordsRequestUsingFiltersBuild = pageSize.build();
        Intrinsics.checkNotNullExpressionValue(readRecordsRequestUsingFiltersBuild, "Builder(recordType.toPla…       }\n        .build()");
        return readRecordsRequestUsingFiltersBuild;
    }

    public static final TimeRangeFilter toPlatformTimeRangeFilter(androidx.health.connect.client.time.TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "<this>");
        if (timeRangeFilter.getStartTime() != null || timeRangeFilter.getEndTime() != null) {
            TimeInstantRangeFilter timeInstantRangeFilterBuild = new TimeInstantRangeFilter.Builder().setStartTime(timeRangeFilter.getStartTime()).setEndTime(timeRangeFilter.getEndTime()).build();
            Intrinsics.checkNotNullExpressionValue(timeInstantRangeFilterBuild, "{\n        TimeInstantRan…me(endTime).build()\n    }");
            return timeInstantRangeFilterBuild;
        }
        if (timeRangeFilter.getLocalStartTime() != null || timeRangeFilter.getLocalEndTime() != null) {
            LocalTimeRangeFilter localTimeRangeFilterBuild = new LocalTimeRangeFilter.Builder().setStartTime(timeRangeFilter.getLocalStartTime()).setEndTime(timeRangeFilter.getLocalEndTime()).build();
            Intrinsics.checkNotNullExpressionValue(localTimeRangeFilterBuild, "{\n        LocalTimeRange…calEndTime).build()\n    }");
            return localTimeRangeFilterBuild;
        }
        TimeInstantRangeFilter timeInstantRangeFilterBuild2 = new TimeInstantRangeFilter.Builder().setStartTime(Instant.EPOCH).build();
        Intrinsics.checkNotNullExpressionValue(timeInstantRangeFilterBuild2, "{\n        // Platform do…tant.EPOCH).build()\n    }");
        return timeInstantRangeFilterBuild2;
    }

    public static final LocalTimeRangeFilter toPlatformLocalTimeRangeFilter(androidx.health.connect.client.time.TimeRangeFilter timeRangeFilter) {
        Intrinsics.checkNotNullParameter(timeRangeFilter, "<this>");
        if (timeRangeFilter.getLocalStartTime() != null || timeRangeFilter.getLocalEndTime() != null) {
            LocalTimeRangeFilter localTimeRangeFilterBuild = new LocalTimeRangeFilter.Builder().setStartTime(timeRangeFilter.getLocalStartTime()).setEndTime(timeRangeFilter.getLocalEndTime()).build();
            Intrinsics.checkNotNullExpressionValue(localTimeRangeFilterBuild, "Builder()\n              …\n                .build()");
            return localTimeRangeFilterBuild;
        }
        if (timeRangeFilter.getStartTime() != null || timeRangeFilter.getEndTime() != null) {
            LocalTimeRangeFilter.Builder builder = new LocalTimeRangeFilter.Builder();
            Instant startTime = timeRangeFilter.getStartTime();
            LocalTimeRangeFilter.Builder startTime2 = builder.setStartTime(startTime != null ? toLocalDateTime(startTime) : null);
            Instant endTime = timeRangeFilter.getEndTime();
            LocalTimeRangeFilter localTimeRangeFilterBuild2 = startTime2.setEndTime(endTime != null ? toLocalDateTime(endTime) : null).build();
            Intrinsics.checkNotNullExpressionValue(localTimeRangeFilterBuild2, "Builder()\n              …\n                .build()");
            return localTimeRangeFilterBuild2;
        }
        LocalTimeRangeFilter.Builder builder2 = new LocalTimeRangeFilter.Builder();
        Instant EPOCH = Instant.EPOCH;
        Intrinsics.checkNotNullExpressionValue(EPOCH, "EPOCH");
        LocalTimeRangeFilter localTimeRangeFilterBuild3 = builder2.setStartTime(toLocalDateTime(EPOCH)).build();
        Intrinsics.checkNotNullExpressionValue(localTimeRangeFilterBuild3, "Builder().setStartTime(I…oLocalDateTime()).build()");
        return localTimeRangeFilterBuild3;
    }

    private static final LocalDateTime toLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }

    public static final ChangeLogTokenRequest toPlatformRequest(ChangesTokenRequest changesTokenRequest) {
        Intrinsics.checkNotNullParameter(changesTokenRequest, "<this>");
        ChangeLogTokenRequest.Builder builder = new ChangeLogTokenRequest.Builder();
        Iterator<T> it = changesTokenRequest.getDataOriginFilters().iterator();
        while (it.hasNext()) {
            builder.addDataOriginFilter(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        Iterator<T> it2 = changesTokenRequest.getRecordTypes().iterator();
        while (it2.hasNext()) {
            builder.addRecordType(RecordConvertersKt.toPlatformRecordClass((KClass) it2.next()));
        }
        ChangeLogTokenRequest changeLogTokenRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(changeLogTokenRequestBuild, "Builder()\n        .apply…       }\n        .build()");
        return changeLogTokenRequestBuild;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateRequest aggregateRequest) {
        Intrinsics.checkNotNullParameter(aggregateRequest, "<this>");
        AggregateRecordsRequest.Builder builder = new AggregateRecordsRequest.Builder(toPlatformTimeRangeFilter(aggregateRequest.getTimeRangeFilter()));
        Iterator<T> it = aggregateRequest.getDataOriginFilter$connect_client_release().iterator();
        while (it.hasNext()) {
            builder.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        Iterator<T> it2 = AggregationExtensionsKt.getPlatformMetrics(aggregateRequest).iterator();
        while (it2.hasNext()) {
            builder.addAggregationType(toAggregationType((AggregateMetric) it2.next()));
        }
        AggregateRecordsRequest<Object> aggregateRecordsRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(aggregateRecordsRequestBuild, "Builder<Any>(timeRangeFi…       }\n        .build()");
        return aggregateRecordsRequestBuild;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateGroupByDurationRequest aggregateGroupByDurationRequest) {
        Intrinsics.checkNotNullParameter(aggregateGroupByDurationRequest, "<this>");
        AggregateRecordsRequest.Builder builder = new AggregateRecordsRequest.Builder(toPlatformTimeRangeFilter(aggregateGroupByDurationRequest.getTimeRangeFilter()));
        Iterator<T> it = aggregateGroupByDurationRequest.getDataOriginFilter$connect_client_release().iterator();
        while (it.hasNext()) {
            builder.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        Iterator<T> it2 = aggregateGroupByDurationRequest.getMetrics$connect_client_release().iterator();
        while (it2.hasNext()) {
            builder.addAggregationType(toAggregationType((AggregateMetric) it2.next()));
        }
        AggregateRecordsRequest<Object> aggregateRecordsRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(aggregateRecordsRequestBuild, "Builder<Any>(timeRangeFi…       }\n        .build()");
        return aggregateRecordsRequestBuild;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateGroupByPeriodRequest aggregateGroupByPeriodRequest) {
        Intrinsics.checkNotNullParameter(aggregateGroupByPeriodRequest, "<this>");
        AggregateRecordsRequest.Builder builder = new AggregateRecordsRequest.Builder(toPlatformLocalTimeRangeFilter(aggregateGroupByPeriodRequest.getTimeRangeFilter()));
        Iterator<T> it = aggregateGroupByPeriodRequest.getDataOriginFilter$connect_client_release().iterator();
        while (it.hasNext()) {
            builder.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        Iterator<T> it2 = aggregateGroupByPeriodRequest.getMetrics$connect_client_release().iterator();
        while (it2.hasNext()) {
            builder.addAggregationType(toAggregationType((AggregateMetric) it2.next()));
        }
        AggregateRecordsRequest<Object> aggregateRecordsRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(aggregateRecordsRequestBuild, "Builder<Any>(timeRangeFi…       }\n        .build()");
        return aggregateRecordsRequestBuild;
    }

    public static final AggregationType<Object> toAggregationType(AggregateMetric<? extends Object> aggregateMetric) {
        Intrinsics.checkNotNullParameter(aggregateMetric, "<this>");
        AggregationType<Double> aggregationType = AggregationMappingsKt.getDOUBLE_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric);
        if (aggregationType == null && (aggregationType = (AggregationType) AggregationMappingsKt.getDURATION_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getENERGY_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getGRAMS_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getLENGTH_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getLONG_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getPOWER_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getPRESSURE_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getVELOCITY_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null && (aggregationType = (AggregationType) AggregationMappingsKt.getVOLUME_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric)) == null) {
            throw new IllegalArgumentException("Unsupported aggregation type " + aggregateMetric.getMetricKey());
        }
        return aggregationType;
    }
}
