package com.ua.sdk.actigraphy;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityList;
import com.ua.sdk.LocalDate;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ActigraphyTransferObject extends ApiTransferObject {
    public static final String KEY_ACTIGRAPHY = "actigraphies";

    @SerializedName("_embedded")
    Map<String, ArrayList<Actigraphies>> actigraphies;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    Integer totalCount;

    static class Actigraphies extends ApiTransferObject {

        @SerializedName("aggregates")
        ActigraphyAggregatesIn actigraphyAggregates;

        @SerializedName("date")
        LocalDate date;

        @SerializedName("end_datetime_utc")
        Date endDate;

        @SerializedName("metrics")
        MetricsIn metricsIn;

        @SerializedName("start_datetime_utc")
        Date startDate;

        @SerializedName("start_datetime_timezone")
        String startTimeZone;

        @SerializedName("workouts")
        ArrayList<WorkoutSummariesIn> workoutSummaryIn;

        Actigraphies() {
        }
    }

    static class ActigraphyAggregatesIn {

        @SerializedName("active_time")
        AggregateValueIn activeTimeAggregate;

        @SerializedName("bodymass")
        AggregateValueIn bodymassAggregate;

        @SerializedName("distance")
        AggregateValueIn distanceAggregate;

        @SerializedName("energy_burned")
        AggregateValueIn energyBurnedAggregate;

        @SerializedName("sleep")
        AggregateValueIn sleepAggregate;

        @SerializedName(BaseDataTypes.ID_STEPS)
        AggregateValueIn stepsAggregate;

        ActigraphyAggregatesIn() {
        }
    }

    static class AggregateValueIn {

        @SerializedName("average")
        Double average;

        @SerializedName("count")
        Double count;

        @SerializedName("details")
        AggregateDetailsIn details;

        @SerializedName("latest")
        Double latest;

        @SerializedName("max")
        Double max;

        @SerializedName("min")
        Double min;

        @SerializedName("sum")
        Double sum;

        AggregateValueIn() {
        }
    }

    static class AggregateDetailsIn {

        @SerializedName("awake")
        AggregateValueIn awake;

        @SerializedName("deep_sleep")
        AggregateValueIn deepSleep;

        @SerializedName("light_sleep")
        AggregateValueIn lightSleep;

        @SerializedName("time_to_sleep")
        AggregateValueIn timeToSleep;

        @SerializedName("times_awakened")
        AggregateValueIn timesAwakened;

        AggregateDetailsIn() {
        }
    }

    static class MetricsIn {

        @SerializedName("bodymass")
        ArrayList<MetricDetails> bodymassMetrics;

        @SerializedName("distance")
        ArrayList<MetricDetails> distanceMetrics;

        @SerializedName("energy_burned")
        ArrayList<MetricDetails> energyBurnedMetrics;

        @SerializedName("sleep")
        ArrayList<MetricDetails> sleepMetrics;

        @SerializedName(BaseDataTypes.ID_STEPS)
        ArrayList<MetricDetails> stepsMetrics;

        MetricsIn() {
        }
    }

    static class Metrics {

        @SerializedName("end_datetime_utc")
        Date endTime;

        @SerializedName("start_datetime_utc")
        Date startTime;

        @SerializedName("start_datetime_timezone")
        String startTimeZone;

        @SerializedName("time_series")
        TimeSeriesIn timeSeries;

        Metrics() {
        }
    }

    static class MetricDetails extends Metrics {

        @SerializedName("aggregates")
        AggregateValueIn aggregate;

        MetricDetails() {
        }
    }

    static class TimeSeriesIn {

        @SerializedName("epoch_values")
        ArrayList<ArrayList<Double>> epochValues;

        @SerializedName("interval")
        Integer interval;

        TimeSeriesIn() {
        }
    }

    static class WorkoutSummariesIn {

        @SerializedName("activity_type_id")
        Integer activityTypeId;

        @SerializedName("aggregates")
        WorkoutAggregateDetails details;

        @SerializedName("end_datetime_utc")
        Date endDate;

        @SerializedName("name")
        String name;

        @SerializedName("start_datetime_utc")
        Date startDate;

        WorkoutSummariesIn() {
        }
    }

    static class WorkoutAggregateDetails {

        @SerializedName("details")
        ActigraphyAggregatesIn actigraphyAggregatesIn;

        WorkoutAggregateDetails() {
        }
    }

    public static EntityList<Actigraphy> toList(ActigraphyTransferObject actigraphyTransferObject) throws UaException {
        ActigraphyList actigraphyList = new ActigraphyList();
        actigraphyList.setLinkMap(actigraphyTransferObject.getLinkMap());
        actigraphyList.setTotalCount(actigraphyTransferObject.totalCount.intValue());
        Iterator<Actigraphies> it = actigraphyTransferObject.getActigraphyList().iterator();
        while (it.hasNext()) {
            Actigraphies next = it.next();
            ActigraphyImpl actigraphyImpl = new ActigraphyImpl();
            ActigraphyAggregatesImpl actigraphyAggregatesImpl = new ActigraphyAggregatesImpl();
            actigraphyAggregatesImpl.setDistance(getAggregateValues(next.actigraphyAggregates.distanceAggregate));
            actigraphyAggregatesImpl.setBodyMass(getAggregateValues(next.actigraphyAggregates.bodymassAggregate));
            actigraphyAggregatesImpl.setActiveTime(getAggregateValues(next.actigraphyAggregates.activeTimeAggregate));
            actigraphyAggregatesImpl.setEnergyBurned(getAggregateValues(next.actigraphyAggregates.energyBurnedAggregate));
            actigraphyAggregatesImpl.setSleep(getAggregateValues(next.actigraphyAggregates.sleepAggregate));
            actigraphyAggregatesImpl.setSteps(getAggregateValues(next.actigraphyAggregates.stepsAggregate));
            ActigraphyMetricsImpl actigraphyMetricsImpl = new ActigraphyMetricsImpl();
            actigraphyMetricsImpl.setDistance(getMetricDetailValues(next.metricsIn.distanceMetrics));
            actigraphyMetricsImpl.setEnergyBurned(getMetricDetailValues(next.metricsIn.energyBurnedMetrics));
            actigraphyMetricsImpl.setSteps(getMetricDetailValues(next.metricsIn.stepsMetrics));
            actigraphyMetricsImpl.setSleep(getMetricDetailValues(next.metricsIn.sleepMetrics));
            actigraphyMetricsImpl.setBodyMass(getMetricDetailValues(next.metricsIn.bodymassMetrics));
            actigraphyImpl.setAggregates(actigraphyAggregatesImpl);
            actigraphyImpl.setMetrics(actigraphyMetricsImpl);
            actigraphyImpl.setWorkoutSummaries(getWorkoutSummaries(next.workoutSummaryIn));
            actigraphyImpl.setDate(next.date);
            actigraphyImpl.setTimeZone(getTimeZone(next.startTimeZone));
            actigraphyImpl.setStartDateTime(next.startDate);
            actigraphyImpl.setEndDateTime(next.endDate);
            actigraphyImpl.setLinkMap(next.getLinkMap());
            actigraphyList.add(actigraphyImpl);
        }
        return actigraphyList;
    }

    private static AggregateValueImpl getAggregateValues(AggregateValueIn aggregateValueIn) {
        AggregateValueImpl aggregateValueImpl = new AggregateValueImpl();
        aggregateValueImpl.setSum(aggregateValueIn.sum);
        aggregateValueImpl.setMin(aggregateValueIn.min);
        aggregateValueImpl.setMax(aggregateValueIn.max);
        aggregateValueImpl.setLatest(aggregateValueIn.latest);
        aggregateValueImpl.setCount(aggregateValueIn.count);
        aggregateValueImpl.setAverage(aggregateValueIn.average);
        if (aggregateValueIn.details != null && aggregateValueIn.details.awake != null) {
            SleepAggregateDetailsImpl sleepAggregateDetailsImpl = new SleepAggregateDetailsImpl();
            sleepAggregateDetailsImpl.setAwake(aggregateValueIn.details.awake.sum);
            sleepAggregateDetailsImpl.setLightSleep(aggregateValueIn.details.lightSleep.sum);
            sleepAggregateDetailsImpl.setTimeToSleep(aggregateValueIn.details.timeToSleep.sum);
            sleepAggregateDetailsImpl.setTimesAwaken(Integer.valueOf(aggregateValueIn.details.timesAwakened.sum.intValue()));
            sleepAggregateDetailsImpl.setDeepSleep(aggregateValueIn.details.deepSleep.sum);
            aggregateValueImpl.setAggregateDetails(sleepAggregateDetailsImpl);
        }
        return aggregateValueImpl;
    }

    private static MetricImpl[] getMetricDetailValues(ArrayList<MetricDetails> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        MetricImpl[] metricImplArr = new MetricImpl[arrayList.size()];
        Iterator<MetricDetails> it = arrayList.iterator();
        while (it.hasNext()) {
            MetricDetails next = it.next();
            MetricImpl metricImpl = new MetricImpl();
            metricImpl.setStartDateTime(next.startTime);
            metricImpl.setEndDateTime(next.endTime);
            metricImpl.setTimeZone(getTimeZone(next.startTimeZone));
            metricImpl.setAggregateValue(getAggregateValues(next.aggregate));
            if (next.timeSeries.epochValues != null) {
                int size = next.timeSeries.epochValues.size();
                long[] jArr = new long[size];
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    jArr[i] = (long) (Math.round(next.timeSeries.epochValues.get(i).get(0).doubleValue()) * 1000.0d);
                    dArr[i] = next.timeSeries.epochValues.get(i).get(1).doubleValue();
                }
                metricImpl.setEpochTimes(jArr);
                metricImpl.setValues(dArr);
            } else {
                metricImpl.setEpochTimes(new long[]{0});
                metricImpl.setValues(new double[]{0.0d});
            }
            metricImplArr[arrayList.indexOf(next)] = metricImpl;
        }
        return metricImplArr;
    }

    private static WorkoutSummaryImpl[] getWorkoutSummaries(ArrayList<WorkoutSummariesIn> arrayList) {
        if (arrayList == null || arrayList.size() < 1) {
            return null;
        }
        WorkoutSummaryImpl[] workoutSummaryImplArr = new WorkoutSummaryImpl[arrayList.size()];
        Iterator<WorkoutSummariesIn> it = arrayList.iterator();
        while (it.hasNext()) {
            WorkoutSummariesIn next = it.next();
            WorkoutSummaryImpl workoutSummaryImpl = new WorkoutSummaryImpl();
            workoutSummaryImpl.setActivityTypeId(next.activityTypeId.intValue());
            workoutSummaryImpl.setName(next.name);
            workoutSummaryImpl.setStartDateTime(next.startDate);
            workoutSummaryImpl.setEndDateTime(next.endDate);
            ActigraphyAggregatesImpl actigraphyAggregatesImpl = new ActigraphyAggregatesImpl();
            actigraphyAggregatesImpl.setDistance(getAggregateValues(next.details.actigraphyAggregatesIn.distanceAggregate));
            actigraphyAggregatesImpl.setEnergyBurned(getAggregateValues(next.details.actigraphyAggregatesIn.energyBurnedAggregate));
            actigraphyAggregatesImpl.setSteps(getAggregateValues(next.details.actigraphyAggregatesIn.stepsAggregate));
            workoutSummaryImpl.setWorkoutAggregates(actigraphyAggregatesImpl);
            workoutSummaryImplArr[arrayList.indexOf(next)] = workoutSummaryImpl;
        }
        return workoutSummaryImplArr;
    }

    private ArrayList<Actigraphies> getActigraphyList() {
        Map<String, ArrayList<Actigraphies>> map = this.actigraphies;
        if (map == null) {
            return null;
        }
        return map.get(KEY_ACTIGRAPHY);
    }

    private static TimeZone getTimeZone(String str) {
        if (str == null) {
            return null;
        }
        return TimeZone.getTimeZone(str);
    }
}
