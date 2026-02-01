package com.ua.sdk.recorder.save;

import com.ua.sdk.UaLog;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataFrame;
import com.ua.sdk.datapoint.DataFrameImpl;
import com.ua.sdk.datapoint.DataPoint;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.privacy.Privacy;
import com.ua.sdk.recorder.RecorderContext;
import com.ua.sdk.workout.Workout;
import com.ua.sdk.workout.WorkoutBuilder;
import com.ua.sdk.workout.WorkoutBuilderImpl;
import com.ua.sdk.workout.WorkoutNameGenerator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class RecordWorkoutV7Converter {
    private RecorderContext context;
    private List<DataFrame> data;
    private Double distance;
    private Date startDate;
    private WorkoutBuilder workoutBuilder = new WorkoutBuilderImpl();

    public RecordWorkoutV7Converter(List<DataFrame> list, RecorderContext recorderContext) {
        this.context = recorderContext;
        this.data = list;
    }

    public Workout buildWorkout(String str) {
        constructWorkout();
        this.workoutBuilder.setName(str);
        return this.workoutBuilder.build();
    }

    public Workout buildWorkout(WorkoutNameGenerator workoutNameGenerator) {
        constructWorkout();
        if (this.startDate == null) {
            UaLog.error("Unable to build workout without startDate.");
            return null;
        }
        this.workoutBuilder.setName(workoutNameGenerator.generateName(this.context.getUser(), this.context.getActivityType(), this.context.getApplicationContext(), this.startDate, this.distance));
        return this.workoutBuilder.build();
    }

    private void constructWorkout() {
        Iterator<DataFrame> it = this.data.iterator();
        while (it.hasNext()) {
            extractTimeSeries((DataFrameImpl) it.next());
        }
        this.workoutBuilder.setActivityType(this.context.getActivityType().getRef());
        this.workoutBuilder.setPrivacy(Privacy.Level.PUBLIC);
        this.workoutBuilder.setTimeZone(TimeZone.getDefault());
        this.workoutBuilder.setCreateTime(this.startDate);
        this.workoutBuilder.setStartTime(this.startDate);
    }

    private void extractTimeSeries(DataFrameImpl dataFrameImpl) {
        Set<DataTypeRef> dataTypesChanged = dataFrameImpl.getDataTypesChanged();
        if (dataFrameImpl.isSegmentStarted()) {
            double dDoubleValue = dataFrameImpl.getActiveTime().doubleValue();
            if (this.startDate == null) {
                setStartDate(dataFrameImpl.getFirstSegmentStartTime().doubleValue());
            }
            if (!Double.isNaN(dDoubleValue) && dataTypesChanged != null) {
                Iterator<DataTypeRef> it = dataTypesChanged.iterator();
                while (it.hasNext()) {
                    String id = it.next().getId();
                    if (id.equals(BaseDataTypes.TYPE_HEART_RATE.getId()) && dataFrameImpl.getHeartRateDataPoint() != null) {
                        this.workoutBuilder.addHeartRateEvent(dDoubleValue, dataFrameImpl.getHeartRateDataPoint().getHeartRate().intValue());
                    } else if (id.equals(BaseDataTypes.TYPE_SPEED.getId()) && dataFrameImpl.getSpeedDataPoint() != null) {
                        this.workoutBuilder.addSpeedEvent(dDoubleValue, dataFrameImpl.getSpeedDataPoint().getSpeed().doubleValue());
                    } else if (id.equals(BaseDataTypes.TYPE_RUN_CADENCE.getId()) && dataFrameImpl.getRunCadenceDataPoint() != null) {
                        this.workoutBuilder.addCadenceEvent(dDoubleValue, dataFrameImpl.getRunCadenceDataPoint().getRunCadence().intValue());
                    } else if (id.equals(BaseDataTypes.TYPE_CYCLING_POWER.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_CYCLING_POWER.getRef()) != null) {
                        this.workoutBuilder.addPowerEvent(dDoubleValue, dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_CYCLING_POWER.getRef()).getValueDouble(BaseDataTypes.FIELD_CYCLING_POWER).doubleValue());
                    } else if (id.equals(BaseDataTypes.TYPE_ACCUMULATED_TORQUE.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_ACCUMULATED_TORQUE.getRef()) != null) {
                        this.workoutBuilder.addTorqueEvent(dDoubleValue, dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_ACCUMULATED_TORQUE.getRef()).getValueDouble(BaseDataTypes.FIELD_ACCUMULATED_TORQUE).doubleValue());
                    } else if (id.equals(BaseDataTypes.TYPE_DISTANCE.getId()) && dataFrameImpl.getDistanceDataPoint() != null) {
                        this.workoutBuilder.addDistanceEvent(dDoubleValue, dataFrameImpl.getDistanceDataPoint().getDistance().doubleValue());
                        this.distance = dataFrameImpl.getDistanceDataPoint().getDistance();
                    } else if (id.equals(BaseDataTypes.TYPE_STEPS.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_STEPS.getRef()) != null) {
                        this.workoutBuilder.addStepsEvent(dDoubleValue, dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_STEPS.getRef()).getValueLong(BaseDataTypes.FIELD_STEPS).intValue());
                    } else if (id.equals(BaseDataTypes.TYPE_LOCATION.getId()) && dataFrameImpl.getLocationDataPoint() != null) {
                        this.workoutBuilder.addPositionEvent(dDoubleValue, null, dataFrameImpl.getLocationDataPoint().getLatitude(), dataFrameImpl.getLocationDataPoint().getLongitude());
                    } else if (id.equals(BaseDataTypes.TYPE_WILLPOWER.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_WILLPOWER.getRef()) != null) {
                        this.workoutBuilder.setWillPower(dataFrameImpl.getWillPowerDataPoint().getWillPower());
                    } else if (id.equals(BaseDataTypes.TYPE_ENERGY_EXPENDED.getId()) && dataFrameImpl.getEnergyExpendedDataPoint() != null) {
                        this.workoutBuilder.setMetabolicEnergyTotal(dataFrameImpl.getEnergyExpendedDataPoint().getEnergyExpended());
                    } else if (id.equals(BaseDataTypes.TYPE_HEART_RATE_SUMMARY.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_HEART_RATE_SUMMARY.getRef()) != null) {
                        DataPoint dataPoint = dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_HEART_RATE_SUMMARY.getRef());
                        this.workoutBuilder.setHeartRateAggregates(Integer.valueOf(dataPoint.getValueLong(BaseDataTypes.FIELD_HEART_RATE_MAX).intValue()), Integer.valueOf(dataPoint.getValueLong(BaseDataTypes.FIELD_HEART_RATE_MIN).intValue()), Integer.valueOf(dataPoint.getValueLong(BaseDataTypes.FIELD_HEART_RATE_AVG).intValue()));
                    } else if (id.equals(BaseDataTypes.TYPE_SPEED_SUMMARY.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_SPEED_SUMMARY.getRef()) != null) {
                        DataPoint dataPoint2 = dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_SPEED_SUMMARY.getRef());
                        this.workoutBuilder.setSpeedAggregates(dataPoint2.getValueDouble(BaseDataTypes.FIELD_SPEED_MAX), dataPoint2.getValueDouble(BaseDataTypes.FIELD_SPEED_MIN), dataPoint2.getValueDouble(BaseDataTypes.FIELD_SPEED_AVG));
                    } else if (id.equals(BaseDataTypes.TYPE_RUN_CADENCE_SUMMARY.getId()) && dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_RUN_CADENCE_SUMMARY.getRef()) != null) {
                        DataPoint dataPoint3 = dataFrameImpl.getDataPoint(BaseDataTypes.TYPE_RUN_CADENCE_SUMMARY.getRef());
                        this.workoutBuilder.setHeartRateAggregates(Integer.valueOf(dataPoint3.getValueLong(BaseDataTypes.FIELD_RUN_CADENCE_MAX).intValue()), Integer.valueOf(dataPoint3.getValueLong(BaseDataTypes.FIELD_RUN_CADENCE_MIN).intValue()), Integer.valueOf(dataPoint3.getValueLong(BaseDataTypes.FIELD_RUN_CADENCE_AVG).intValue()));
                    }
                }
            }
        }
        this.workoutBuilder.setTotalTime(dataFrameImpl.getActiveTime(), dataFrameImpl.getElapsedTime());
    }

    private void setStartDate(double d) {
        this.startDate = new Date(((long) d) * 1000);
    }
}
