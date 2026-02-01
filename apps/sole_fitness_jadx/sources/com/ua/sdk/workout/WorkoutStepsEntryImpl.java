package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutStepsEntryImpl implements WorkoutStepsEntry {
    public static final Parcelable.Creator<WorkoutStepsEntryImpl> CREATOR = new Parcelable.Creator<WorkoutStepsEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutStepsEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutStepsEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutStepsEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutStepsEntryImpl[] newArray(int i) {
            return new WorkoutStepsEntryImpl[i];
        }
    };
    double offset;
    int steps;

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

    public WorkoutStepsEntryImpl(Double d, Integer num) {
        this.offset = d.doubleValue();
        this.steps = num.intValue();
    }

    @Override // com.ua.sdk.workout.WorkoutStepsEntry
    public int getInstantaneousSteps() {
        return this.steps;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutStepsEntry workoutStepsEntry) {
        return Double.compare(this.offset, workoutStepsEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Integer.valueOf(this.steps));
    }

    private WorkoutStepsEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.steps = ((Integer) parcel.readValue(Integer.class.getClassLoader())).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutStepsEntryImpl workoutStepsEntryImpl = (WorkoutStepsEntryImpl) obj;
        return Double.compare(workoutStepsEntryImpl.offset, this.offset) == 0 && this.steps == workoutStepsEntryImpl.steps;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        return (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + this.steps;
    }
}
