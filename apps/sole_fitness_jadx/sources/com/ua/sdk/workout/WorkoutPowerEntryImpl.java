package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutPowerEntryImpl implements WorkoutPowerEntry {
    public static final Parcelable.Creator<WorkoutPowerEntryImpl> CREATOR = new Parcelable.Creator<WorkoutPowerEntryImpl>() { // from class: com.ua.sdk.workout.WorkoutPowerEntryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutPowerEntryImpl createFromParcel(Parcel parcel) {
            return new WorkoutPowerEntryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutPowerEntryImpl[] newArray(int i) {
            return new WorkoutPowerEntryImpl[i];
        }
    };
    private double offset;
    private double power;

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

    public WorkoutPowerEntryImpl(Double d, Double d2) {
        this.offset = d.doubleValue();
        this.power = d2.doubleValue();
    }

    @Override // com.ua.sdk.workout.WorkoutPowerEntry
    public double getInstantaneousPower() {
        return this.power;
    }

    @Override // com.ua.sdk.workout.BaseTimeSeriesEntry
    public double getOffset() {
        return this.offset;
    }

    @Override // java.lang.Comparable
    public int compareTo(WorkoutPowerEntry workoutPowerEntry) {
        return Double.compare(this.offset, workoutPowerEntry.getOffset());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(Double.valueOf(this.offset));
        parcel.writeValue(Double.valueOf(this.power));
    }

    private WorkoutPowerEntryImpl(Parcel parcel) {
        this.offset = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
        this.power = ((Double) parcel.readValue(Double.class.getClassLoader())).doubleValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkoutPowerEntryImpl workoutPowerEntryImpl = (WorkoutPowerEntryImpl) obj;
        return Double.compare(workoutPowerEntryImpl.offset, this.offset) == 0 && Double.compare(workoutPowerEntryImpl.power, this.power) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.offset);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.power);
        return (i * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }
}
