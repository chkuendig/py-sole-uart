package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutCadenceEntryImpl implements WorkoutCadenceEntry {
    public static final Parcelable.Creator<WorkoutCadenceEntryImpl> CREATOR = new Parcelable.Creator<WorkoutCadenceEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutCadenceEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutCadenceEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutCadenceEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutCadenceEntryImpl[] newArray(int i) {
            return new WorkoutCadenceEntryImpl[i];
        }
    };
    private int cadence;
    private double offset;

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

    public WorkoutCadenceEntryImpl(Double d, Integer num) {
        this.offset = d.doubleValue();
        this.cadence = num.intValue();
    }

    @Override // com.ua.sdk.workout.WorkoutCadenceEntry
    public int getInstantaneousCadence() {
        return this.cadence;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutCadenceEntry workoutCadenceEntry) {
        return Double.compare(this.offset, workoutCadenceEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Integer.valueOf(this.cadence));
    }

    private WorkoutCadenceEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.cadence = ((Integer) parcel.readValue(Integer.class.getClassLoader())).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutCadenceEntryImpl workoutCadenceEntryImpl = (WorkoutCadenceEntryImpl) obj;
        return this.cadence == workoutCadenceEntryImpl.cadence && Double.compare(workoutCadenceEntryImpl.offset, this.offset) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        return (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + this.cadence;
    }
}
