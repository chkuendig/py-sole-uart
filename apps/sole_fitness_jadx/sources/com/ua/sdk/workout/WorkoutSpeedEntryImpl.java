package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutSpeedEntryImpl implements WorkoutSpeedEntry {
    public static final Parcelable.Creator<WorkoutSpeedEntryImpl> CREATOR = new Parcelable.Creator<WorkoutSpeedEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutSpeedEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutSpeedEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutSpeedEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutSpeedEntryImpl[] newArray(int i) {
            return new WorkoutSpeedEntryImpl[i];
        }
    };
    private double offset;
    private double speed;

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

    public WorkoutSpeedEntryImpl(Double d, Double d2) {
        this.offset = d.doubleValue();
        this.speed = d2.doubleValue();
    }

    @Override // com.ua.sdk.workout.WorkoutSpeedEntry
    public double getInstantaneousSpeed() {
        return this.speed;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutSpeedEntry workoutSpeedEntry) {
        return Double.compare(this.offset, workoutSpeedEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Double.valueOf(this.speed));
    }

    private WorkoutSpeedEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.speed = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutSpeedEntryImpl workoutSpeedEntryImpl = (WorkoutSpeedEntryImpl) obj;
        return Double.compare(workoutSpeedEntryImpl.offset, this.offset) == 0 && Double.compare(workoutSpeedEntryImpl.speed, this.speed) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.speed);
        return (i * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }
}
