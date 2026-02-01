package androidx.health.connect.client.impl.platform.response;

import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.AggregateRecordsGroupedByPeriodResponse;
import android.health.connect.AggregateRecordsResponse;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.DataOrigin;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Mass;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.impl.platform.aggregate.AggregationMappingsKt;
import androidx.health.connect.client.impl.platform.records.MetadataConvertersKt;
import androidx.health.connect.client.impl.platform.request.RequestConvertersKt;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Mass;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseConverters.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a^\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u001a\u0010\u0006\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072$\b\u0002\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\nj\u0002`\u000b0\u00030\u0007H\u0001\u001a.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\rH\u0001\u001a.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\r2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\rH\u0001\u001a$\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00050\u00152\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u001a$\u0010\u0013\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u00172\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u001a4\u0010\u0013\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\u00050\u00172\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019\u001a$\u0010\u0013\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¨\u0006\u001c"}, d2 = {"buildAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "metrics", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "", "aggregationValueGetter", "Lkotlin/Function1;", "Landroid/health/connect/datatypes/AggregationType;", "platformDataOriginsGetter", "Landroid/health/connect/datatypes/DataOrigin;", "Landroidx/health/connect/client/impl/platform/records/PlatformDataOrigin;", "getDoubleMetricValues", "", "", "", "metricValueMap", "getLongMetricValues", "", "toSdkResponse", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroid/health/connect/AggregateRecordsGroupedByDurationResponse;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "Landroid/health/connect/AggregateRecordsGroupedByPeriodResponse;", "bucketStartTime", "Ljava/time/LocalDateTime;", "bucketEndTime", "Landroid/health/connect/AggregateRecordsResponse;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResponseConvertersKt {

    /* compiled from: ResponseConverters.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07991 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Object> {
        C07991(Object obj) {
            super(1, obj, AggregateRecordsResponse.class, "get", "get(Landroid/health/connect/datatypes/AggregationType;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(AggregationType<Object> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((AggregateRecordsResponse) this.receiver).get(p0);
        }
    }

    /* compiled from: ResponseConverters.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Set<DataOrigin>> {
        AnonymousClass2(Object obj) {
            super(1, obj, AggregateRecordsResponse.class, "getDataOrigins", "getDataOrigins(Landroid/health/connect/datatypes/AggregationType;)Ljava/util/Set;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Set<DataOrigin> invoke(AggregationType<Object> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((AggregateRecordsResponse) this.receiver).getDataOrigins(p0);
        }
    }

    public static final AggregationResult toSdkResponse(AggregateRecordsResponse<Object> aggregateRecordsResponse, Set<? extends AggregateMetric<? extends Object>> metrics) {
        Intrinsics.checkNotNullParameter(aggregateRecordsResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return buildAggregationResult(metrics, new C07991(aggregateRecordsResponse), new AnonymousClass2(aggregateRecordsResponse));
    }

    /* compiled from: ResponseConverters.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Object> {
        AnonymousClass3(Object obj) {
            super(1, obj, AggregateRecordsGroupedByDurationResponse.class, "get", "get(Landroid/health/connect/datatypes/AggregationType;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(AggregationType<Object> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((AggregateRecordsGroupedByDurationResponse) this.receiver).get(p0);
        }
    }

    public static final AggregationResultGroupedByDuration toSdkResponse(AggregateRecordsGroupedByDurationResponse<Object> aggregateRecordsGroupedByDurationResponse, Set<? extends AggregateMetric<? extends Object>> metrics) {
        Intrinsics.checkNotNullParameter(aggregateRecordsGroupedByDurationResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        AggregationResult aggregationResultBuildAggregationResult$default = buildAggregationResult$default(metrics, new AnonymousClass3(aggregateRecordsGroupedByDurationResponse), null, 4, null);
        Instant startTime = aggregateRecordsGroupedByDurationResponse.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        Instant endTime = aggregateRecordsGroupedByDurationResponse.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        ZoneOffset zoneOffset = aggregateRecordsGroupedByDurationResponse.getZoneOffset(RequestConvertersKt.toAggregationType((AggregateMetric) CollectionsKt.first(metrics)));
        if (zoneOffset == null) {
            zoneOffset = ZoneOffset.systemDefault().getRules().getOffset(aggregateRecordsGroupedByDurationResponse.getStartTime());
        }
        Intrinsics.checkNotNullExpressionValue(zoneOffset, "getZoneOffset(metrics.fi…ules.getOffset(startTime)");
        return new AggregationResultGroupedByDuration(aggregationResultBuildAggregationResult$default, startTime, endTime, zoneOffset);
    }

    /* compiled from: ResponseConverters.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Object> {
        AnonymousClass4(Object obj) {
            super(1, obj, AggregateRecordsGroupedByPeriodResponse.class, "get", "get(Landroid/health/connect/datatypes/AggregationType;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(AggregationType<Object> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((AggregateRecordsGroupedByPeriodResponse) this.receiver).get(p0);
        }
    }

    public static final AggregationResultGroupedByPeriod toSdkResponse(AggregateRecordsGroupedByPeriodResponse<Object> aggregateRecordsGroupedByPeriodResponse, Set<? extends AggregateMetric<? extends Object>> metrics) {
        Intrinsics.checkNotNullParameter(aggregateRecordsGroupedByPeriodResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        AggregationResult aggregationResultBuildAggregationResult$default = buildAggregationResult$default(metrics, new AnonymousClass4(aggregateRecordsGroupedByPeriodResponse), null, 4, null);
        LocalDateTime startTime = aggregateRecordsGroupedByPeriodResponse.getStartTime();
        Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
        LocalDateTime endTime = aggregateRecordsGroupedByPeriodResponse.getEndTime();
        Intrinsics.checkNotNullExpressionValue(endTime, "endTime");
        return new AggregationResultGroupedByPeriod(aggregationResultBuildAggregationResult$default, startTime, endTime);
    }

    /* compiled from: ResponseConverters.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Object> {
        AnonymousClass5(Object obj) {
            super(1, obj, AggregateRecordsGroupedByPeriodResponse.class, "get", "get(Landroid/health/connect/datatypes/AggregationType;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(AggregationType<Object> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((AggregateRecordsGroupedByPeriodResponse) this.receiver).get(p0);
        }
    }

    public static final AggregationResultGroupedByPeriod toSdkResponse(AggregateRecordsGroupedByPeriodResponse<Object> aggregateRecordsGroupedByPeriodResponse, Set<? extends AggregateMetric<? extends Object>> metrics, LocalDateTime bucketStartTime, LocalDateTime bucketEndTime) {
        Intrinsics.checkNotNullParameter(aggregateRecordsGroupedByPeriodResponse, "<this>");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(bucketStartTime, "bucketStartTime");
        Intrinsics.checkNotNullParameter(bucketEndTime, "bucketEndTime");
        return new AggregationResultGroupedByPeriod(buildAggregationResult$default(metrics, new AnonymousClass5(aggregateRecordsGroupedByPeriodResponse), null, 4, null), bucketStartTime, bucketEndTime);
    }

    public static /* synthetic */ AggregationResult buildAggregationResult$default(Set set, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function12 = new Function1<AggregationType<Object>, Set<? extends DataOrigin>>() { // from class: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt.buildAggregationResult.1
                @Override // kotlin.jvm.functions.Function1
                public final Set<DataOrigin> invoke(AggregationType<Object> aggregationType) {
                    Intrinsics.checkNotNullParameter(aggregationType, "<anonymous parameter 0>");
                    return SetsKt.emptySet();
                }
            };
        }
        return buildAggregationResult(set, function1, function12);
    }

    public static final AggregationResult buildAggregationResult(Set<? extends AggregateMetric<? extends Object>> metrics, Function1<? super AggregationType<Object>, ? extends Object> aggregationValueGetter, Function1<? super AggregationType<Object>, ? extends Set<DataOrigin>> platformDataOriginsGetter) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(aggregationValueGetter, "aggregationValueGetter");
        Intrinsics.checkNotNullParameter(platformDataOriginsGetter, "platformDataOriginsGetter");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Set<? extends AggregateMetric<? extends Object>> set = metrics;
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            AggregateMetric aggregateMetric = (AggregateMetric) it.next();
            Object objInvoke = aggregationValueGetter.invoke(RequestConvertersKt.toAggregationType(aggregateMetric));
            if (objInvoke != null) {
                mapCreateMapBuilder.put(aggregateMetric, objInvoke);
            }
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        Map<String, Long> longMetricValues = getLongMetricValues(mapBuild);
        Map<String, Double> doubleMetricValues = getDoubleMetricValues(mapBuild);
        HashSet hashSet = new HashSet();
        Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            Set<DataOrigin> setInvoke = platformDataOriginsGetter.invoke(RequestConvertersKt.toAggregationType((AggregateMetric) it2.next()));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setInvoke, 10));
            Iterator<T> it3 = setInvoke.iterator();
            while (it3.hasNext()) {
                arrayList.add(MetadataConvertersKt.toSdkDataOrigin((DataOrigin) it3.next()));
            }
            CollectionsKt.addAll(hashSet, arrayList);
        }
        return new AggregationResult(longMetricValues, doubleMetricValues, hashSet);
    }

    public static final Map<String, Long> getLongMetricValues(Map<AggregateMetric<Object>, ? extends Object> metricValueMap) {
        Intrinsics.checkNotNullParameter(metricValueMap, "metricValueMap");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (Map.Entry<AggregateMetric<Object>, ? extends Object> entry : metricValueMap.entrySet()) {
            AggregateMetric<Object> key = entry.getKey();
            Object value = entry.getValue();
            if (AggregationMappingsKt.getDURATION_AGGREGATION_METRIC_TYPE_MAP().containsKey(key) || AggregationMappingsKt.getLONG_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
                mapCreateMapBuilder.put(metricKey, (Long) value);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static final Map<String, Double> getDoubleMetricValues(Map<AggregateMetric<Object>, ? extends Object> metricValueMap) {
        Intrinsics.checkNotNullParameter(metricValueMap, "metricValueMap");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (Map.Entry<AggregateMetric<Object>, ? extends Object> entry : metricValueMap.entrySet()) {
            AggregateMetric<Object> key = entry.getKey();
            Object value = entry.getValue();
            if (AggregationMappingsKt.getDOUBLE_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
                mapCreateMapBuilder.put(metricKey, (Double) value);
            } else if (AggregationMappingsKt.getENERGY_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey2 = key.getMetricKey();
                Energy.Companion companion = Energy.INSTANCE;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Energy");
                mapCreateMapBuilder.put(metricKey2, Double.valueOf(companion.calories(((android.health.connect.datatypes.units.Energy) value).getInCalories()).getKilocalories()));
            } else if (AggregationMappingsKt.getGRAMS_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey3 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Mass{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformMass }");
                mapCreateMapBuilder.put(metricKey3, Double.valueOf(((Mass) value).getInGrams()));
            } else if (AggregationMappingsKt.getLENGTH_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey4 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Length{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformLength }");
                mapCreateMapBuilder.put(metricKey4, Double.valueOf(((Length) value).getInMeters()));
            } else if (AggregationMappingsKt.getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey5 = key.getMetricKey();
                Mass.Companion companion2 = androidx.health.connect.client.units.Mass.INSTANCE;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Mass{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformMass }");
                mapCreateMapBuilder.put(metricKey5, Double.valueOf(companion2.grams(((android.health.connect.datatypes.units.Mass) value).getInGrams()).getKilograms()));
            } else if (AggregationMappingsKt.getPRESSURE_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey6 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Pressure{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformPressure }");
                mapCreateMapBuilder.put(metricKey6, Double.valueOf(((Pressure) value).getInMillimetersOfMercury()));
            } else if (AggregationMappingsKt.getPOWER_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey7 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Power{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformPower }");
                mapCreateMapBuilder.put(metricKey7, Double.valueOf(((Power) value).getInWatts()));
            } else if (AggregationMappingsKt.getVELOCITY_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey8 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Velocity{ androidx.health.connect.client.impl.platform.records.PlatformRecordAliasesKt.PlatformVelocity }");
                mapCreateMapBuilder.put(metricKey8, Double.valueOf(((Velocity) value).getInMetersPerSecond()));
            } else if (AggregationMappingsKt.getVOLUME_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey9 = key.getMetricKey();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.health.connect.datatypes.units.Volume");
                mapCreateMapBuilder.put(metricKey9, Double.valueOf(((Volume) value).getInLiters()));
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
