package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutTimerStopEntryImpl implements WorkoutTimerStopEntry {
    public static final Parcelable.Creator<WorkoutTimerStopEntryImpl> CREATOR = new Parcelable.Creator<WorkoutTimerStopEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutTimerStopEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutTimerStopEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutTimerStopEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutTimerStopEntryImpl[] newArray(int i) {
            return new WorkoutTimerStopEntryImpl[i];
        }
    };
    private double offset;
    private double stoppedTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public Date getTime() {
        return null;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public Long getTimeInMillis() {
        return null;
    }

    public WorkoutTimerStopEntryImpl(Double d, Double d2) {
        this.offset = d.doubleValue();
        this.stoppedTime = d2.doubleValue();
    }

    @Override // com.ua.sdk.workout.WorkoutTimerStopEntry
    public double getStoppedTime() {
        return this.stoppedTime;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutTimerStopEntry workoutTimerStopEntry) {
        return Double.compare(this.offset, workoutTimerStopEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Double.valueOf(this.stoppedTime));
    }

    private WorkoutTimerStopEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.stoppedTime = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutTimerStopEntryImpl workoutTimerStopEntryImpl = (WorkoutTimerStopEntryImpl) obj;
        return Double.compare(workoutTimerStopEntryImpl.offset, this.offset) == 0 && Double.compare(workoutTimerStopEntryImpl.stoppedTime, this.stoppedTime) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.stoppedTime);
        return (i * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }
}
