package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class WorkoutTimeSeriesImpl implements TimeSeriesData {
    public static final Parcelable.Creator<WorkoutTimeSeriesImpl> CREATOR = new Parcelable.Creator<WorkoutTimeSeriesImpl>() { // from class: com.ua.sdk.workout.WorkoutTimeSeriesImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutTimeSeriesImpl createFromParcel(Parcel parcel) {
            return new WorkoutTimeSeriesImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutTimeSeriesImpl[] newArray(int i) {
            return new WorkoutTimeSeriesImpl[i];
        }
    };
    TimeSeriesImpl<WorkoutCadenceEntry> workoutCadenceEntryTimeSeries;
    TimeSeriesImpl<WorkoutDistanceEntry> workoutDistanceTimeSeries;
    TimeSeriesImpl<WorkoutHeartRateEntry> workoutHeartRateEntryTimeSeries;
    TimeSeriesImpl<WorkoutPositionEntry> workoutPositionEntryTimeSeries;
    TimeSeriesImpl<WorkoutPowerEntry> workoutPowerEntryTimeSeries;
    TimeSeriesImpl<WorkoutSpeedEntry> workoutSpeedEntryTimeSeries;
    TimeSeriesImpl<WorkoutStepsEntry> workoutStepsEntryTimeSeries;
    TimeSeriesImpl<WorkoutTimerStopEntry> workoutStopTimeEntryTimeSeries;
    TimeSeriesImpl<WorkoutTorqueEntry> workoutTorqueEntryTimeSeries;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WorkoutTimeSeriesImpl() {
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutHeartRateEntry> getHeartRateTimeSeries() {
        return this.workoutHeartRateEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutSpeedEntry> getSpeedTimeSeries() {
        return this.workoutSpeedEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutCadenceEntry> getCadenceTimeSeries() {
        return this.workoutCadenceEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutPowerEntry> getPowerTimeSeries() {
        return this.workoutPowerEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutTorqueEntry> getTorqueTimeSeries() {
        return this.workoutTorqueEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutDistanceEntry> getDistanceTimeSeries() {
        return this.workoutDistanceTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutStepsEntry> getStepsTimeSeries() {
        return this.workoutStepsEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutPositionEntry> getPositionTimeSeries() {
        return this.workoutPositionEntryTimeSeries;
    }

    @Override // com.ua.sdk.workout.TimeSeriesData
    public TimeSeries<WorkoutTimerStopEntry> getTimerStopTimeSeries() {
        return this.workoutStopTimeEntryTimeSeries;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.workoutHeartRateEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutSpeedEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutCadenceEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutPowerEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutTorqueEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutDistanceTimeSeries, i);
        parcel.writeParcelable(this.workoutStepsEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutPositionEntryTimeSeries, i);
        parcel.writeParcelable(this.workoutStopTimeEntryTimeSeries, i);
    }

    private WorkoutTimeSeriesImpl(Parcel parcel) {
        this.workoutHeartRateEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutSpeedEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutCadenceEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutPowerEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutTorqueEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutDistanceTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutStepsEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutPositionEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
        this.workoutStopTimeEntryTimeSeries = (TimeSeriesImpl) parcel.readParcelable(TimeSeriesImpl.class.getClassLoader());
    }
}
