package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutDistanceEntryImpl implements WorkoutDistanceEntry {
    public static final Parcelable.Creator<WorkoutDistanceEntryImpl> CREATOR = new Parcelable.Creator<WorkoutDistanceEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutDistanceEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutDistanceEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutDistanceEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutDistanceEntryImpl[] newArray(int i) {
            return new WorkoutDistanceEntryImpl[i];
        }
    };
    double distance;
    double offset;

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

    public WorkoutDistanceEntryImpl(Double d, Double d2) {
        this.offset = d.doubleValue();
        this.distance = d2.doubleValue();
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // com.ua.sdk.workout.WorkoutDistanceEntry
    public double getDistance() {
        return this.distance;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutDistanceEntry workoutDistanceEntry) {
        return Double.compare(this.offset, workoutDistanceEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Double.valueOf(this.distance));
    }

    private WorkoutDistanceEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.distance = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutDistanceEntryImpl workoutDistanceEntryImpl = (WorkoutDistanceEntryImpl) obj;
        return Double.compare(workoutDistanceEntryImpl.distance, this.distance) == 0 && Double.compare(workoutDistanceEntryImpl.offset, this.offset) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.distance);
        return (i * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }
}
